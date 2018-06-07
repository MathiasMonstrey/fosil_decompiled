package com.google.common.collect;

import com.fossil.cco;
import com.fossil.ccs;
import com.fossil.ccw;
import com.fossil.cda;
import com.google.common.base.Equivalence;
import com.google.common.primitives.Ints;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.util.AbstractCollection;
import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.concurrent.locks.ReentrantLock;

class MapMakerInternalMap<K, V, E extends C4313g<K, V, E>, S extends Segment<K, V, E, S>> extends AbstractMap<K, V> implements Serializable, ConcurrentMap<K, V> {
    static final long CLEANUP_EXECUTOR_DELAY_SECS = 60;
    static final int CONTAINS_VALUE_RETRIES = 3;
    static final int DRAIN_MAX = 16;
    static final int DRAIN_THRESHOLD = 63;
    static final int MAXIMUM_CAPACITY = 1073741824;
    static final int MAX_SEGMENTS = 65536;
    static final C4309v<Object, Object, C4316c> UNSET_WEAK_VALUE_REFERENCE = new C43101();
    private static final long serialVersionUID = 5;
    final int concurrencyLevel;
    final transient C4321h<K, V, E, S> entryHelper;
    transient Set<Entry<K, V>> entrySet;
    final Equivalence<Object> keyEquivalence;
    transient Set<K> keySet;
    final transient int segmentMask;
    final transient int segmentShift;
    final transient Segment<K, V, E, S>[] segments;
    transient Collection<V> values;

    interface C4309v<K, V, E extends C4313g<K, V, E>> {
        E Vd();

        C4309v<K, V, E> mo4515a(ReferenceQueue<V> referenceQueue, E e);

        void clear();

        V get();
    }

    static class C43101 implements C4309v<Object, Object, C4316c> {
        C43101() {
        }

        public /* synthetic */ C4313g Vd() {
            return Vc();
        }

        public C4316c Vc() {
            return null;
        }

        public void clear() {
        }

        public Object get() {
            return null;
        }

        public C4309v<Object, Object, C4316c> m14383a(ReferenceQueue<Object> referenceQueue, C4316c c4316c) {
            return this;
        }
    }

    static abstract class AbstractSerializationProxy<K, V> extends cda<K, V> implements Serializable {
        private static final long serialVersionUID = 3;
        final int concurrencyLevel;
        transient ConcurrentMap<K, V> delegate;
        final Equivalence<Object> keyEquivalence;
        final Strength keyStrength;
        final Equivalence<Object> valueEquivalence;
        final Strength valueStrength;

        AbstractSerializationProxy(Strength strength, Strength strength2, Equivalence<Object> equivalence, Equivalence<Object> equivalence2, int i, ConcurrentMap<K, V> concurrentMap) {
            this.keyStrength = strength;
            this.valueStrength = strength2;
            this.keyEquivalence = equivalence;
            this.valueEquivalence = equivalence2;
            this.concurrencyLevel = i;
            this.delegate = concurrentMap;
        }

        protected ConcurrentMap<K, V> delegate() {
            return this.delegate;
        }

        void writeMapTo(ObjectOutputStream objectOutputStream) throws IOException {
            objectOutputStream.writeInt(this.delegate.size());
            for (Entry entry : this.delegate.entrySet()) {
                objectOutputStream.writeObject(entry.getKey());
                objectOutputStream.writeObject(entry.getValue());
            }
            objectOutputStream.writeObject(null);
        }

        MapMaker readMapMaker(ObjectInputStream objectInputStream) throws IOException {
            return new MapMaker().iz(objectInputStream.readInt()).m14380a(this.keyStrength).m14381b(this.valueStrength).m14379a(this.keyEquivalence).iA(this.concurrencyLevel);
        }

        void readEntries(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
            while (true) {
                Object readObject = objectInputStream.readObject();
                if (readObject != null) {
                    this.delegate.put(readObject, objectInputStream.readObject());
                } else {
                    return;
                }
            }
        }
    }

    static abstract class Segment<K, V, E extends C4313g<K, V, E>, S extends Segment<K, V, E, S>> extends ReentrantLock {
        volatile int count;
        final MapMakerInternalMap<K, V, E, S> map;
        final int maxSegmentSize;
        int modCount;
        final AtomicInteger readCount = new AtomicInteger();
        volatile AtomicReferenceArray<E> table;
        int threshold;

        abstract E castForTesting(C4313g<K, V, ?> c4313g);

        abstract S self();

        Segment(MapMakerInternalMap<K, V, E, S> mapMakerInternalMap, int i, int i2) {
            this.map = mapMakerInternalMap;
            this.maxSegmentSize = i2;
            initTable(newEntryArray(i));
        }

        void maybeDrainReferenceQueues() {
        }

        void maybeClearReferenceQueues() {
        }

        void setValue(E e, V v) {
            this.map.entryHelper.mo4535a(self(), (C4313g) e, (Object) v);
        }

        E copyEntry(E e, E e2) {
            return this.map.entryHelper.mo4533a(self(), (C4313g) e, (C4313g) e2);
        }

        AtomicReferenceArray<E> newEntryArray(int i) {
            return new AtomicReferenceArray(i);
        }

        void initTable(AtomicReferenceArray<E> atomicReferenceArray) {
            this.threshold = (atomicReferenceArray.length() * 3) / 4;
            if (this.threshold == this.maxSegmentSize) {
                this.threshold++;
            }
            this.table = atomicReferenceArray;
        }

        ReferenceQueue<K> getKeyReferenceQueueForTesting() {
            throw new AssertionError();
        }

        ReferenceQueue<V> getValueReferenceQueueForTesting() {
            throw new AssertionError();
        }

        C4309v<K, V, E> getWeakValueReferenceForTesting(C4313g<K, V, ?> c4313g) {
            throw new AssertionError();
        }

        C4309v<K, V, E> newWeakValueReferenceForTesting(C4313g<K, V, ?> c4313g, V v) {
            throw new AssertionError();
        }

        void setWeakValueReferenceForTesting(C4313g<K, V, ?> c4313g, C4309v<K, V, ? extends C4313g<K, V, ?>> c4309v) {
            throw new AssertionError();
        }

        void setTableEntryForTesting(int i, C4313g<K, V, ?> c4313g) {
            this.table.set(i, castForTesting(c4313g));
        }

        E copyForTesting(C4313g<K, V, ?> c4313g, C4313g<K, V, ?> c4313g2) {
            return this.map.entryHelper.mo4533a(self(), castForTesting(c4313g), castForTesting(c4313g2));
        }

        void setValueForTesting(C4313g<K, V, ?> c4313g, V v) {
            this.map.entryHelper.mo4535a(self(), castForTesting(c4313g), (Object) v);
        }

        E newEntryForTesting(K k, int i, C4313g<K, V, ?> c4313g) {
            return this.map.entryHelper.mo4534a(self(), k, i, castForTesting(c4313g));
        }

        boolean removeTableEntryForTesting(C4313g<K, V, ?> c4313g) {
            return removeEntryForTesting(castForTesting(c4313g));
        }

        E removeFromChainForTesting(C4313g<K, V, ?> c4313g, C4313g<K, V, ?> c4313g2) {
            return removeFromChain(castForTesting(c4313g), castForTesting(c4313g2));
        }

        V getLiveValueForTesting(C4313g<K, V, ?> c4313g) {
            return getLiveValue(castForTesting(c4313g));
        }

        void tryDrainReferenceQueues() {
            if (tryLock()) {
                try {
                    maybeDrainReferenceQueues();
                } finally {
                    unlock();
                }
            }
        }

        void drainKeyReferenceQueue(ReferenceQueue<K> referenceQueue) {
            int i = 0;
            while (true) {
                Reference poll = referenceQueue.poll();
                if (poll != null) {
                    this.map.reclaimKey((C4313g) poll);
                    int i2 = i + 1;
                    if (i2 != 16) {
                        i = i2;
                    } else {
                        return;
                    }
                }
                return;
            }
        }

        void drainValueReferenceQueue(ReferenceQueue<V> referenceQueue) {
            int i = 0;
            while (true) {
                Reference poll = referenceQueue.poll();
                if (poll != null) {
                    this.map.reclaimValue((C4309v) poll);
                    int i2 = i + 1;
                    if (i2 != 16) {
                        i = i2;
                    } else {
                        return;
                    }
                }
                return;
            }
        }

        <T> void clearReferenceQueue(ReferenceQueue<T> referenceQueue) {
            do {
            } while (referenceQueue.poll() != null);
        }

        E getFirst(int i) {
            AtomicReferenceArray atomicReferenceArray = this.table;
            return (C4313g) atomicReferenceArray.get((atomicReferenceArray.length() - 1) & i);
        }

        E getEntry(Object obj, int i) {
            if (this.count != 0) {
                for (E first = getFirst(i); first != null; first = first.Vf()) {
                    if (first.Ve() == i) {
                        Object key = first.getKey();
                        if (key == null) {
                            tryDrainReferenceQueues();
                        } else if (this.map.keyEquivalence.equivalent(obj, key)) {
                            return first;
                        }
                    }
                }
            }
            return null;
        }

        E getLiveEntry(Object obj, int i) {
            return getEntry(obj, i);
        }

        V get(Object obj, int i) {
            try {
                C4313g liveEntry = getLiveEntry(obj, i);
                if (liveEntry == null) {
                    return null;
                }
                V value = liveEntry.getValue();
                if (value == null) {
                    tryDrainReferenceQueues();
                }
                postReadCleanup();
                return value;
            } finally {
                postReadCleanup();
            }
        }

        boolean containsKey(Object obj, int i) {
            boolean z = false;
            try {
                if (this.count != 0) {
                    C4313g liveEntry = getLiveEntry(obj, i);
                    if (!(liveEntry == null || liveEntry.getValue() == null)) {
                        z = true;
                    }
                    postReadCleanup();
                } else {
                    postReadCleanup();
                }
                return z;
            } catch (Throwable th) {
                postReadCleanup();
            }
        }

        boolean containsValue(Object obj) {
            try {
                if (this.count != 0) {
                    AtomicReferenceArray atomicReferenceArray = this.table;
                    int length = atomicReferenceArray.length();
                    for (int i = 0; i < length; i++) {
                        for (C4313g c4313g = (C4313g) atomicReferenceArray.get(i); c4313g != null; c4313g = c4313g.Vf()) {
                            Object liveValue = getLiveValue(c4313g);
                            if (liveValue != null && this.map.valueEquivalence().equivalent(obj, liveValue)) {
                                return true;
                            }
                        }
                    }
                }
                postReadCleanup();
                return false;
            } finally {
                postReadCleanup();
            }
        }

        V put(K k, int i, V v, boolean z) {
            V v2 = null;
            lock();
            try {
                int i2;
                preWriteCleanup();
                int i3 = this.count + 1;
                if (i3 > this.threshold) {
                    expand();
                    i2 = this.count + 1;
                } else {
                    i2 = i3;
                }
                AtomicReferenceArray atomicReferenceArray = this.table;
                int length = i & (atomicReferenceArray.length() - 1);
                C4313g c4313g = (C4313g) atomicReferenceArray.get(length);
                for (C4313g c4313g2 = c4313g; c4313g2 != null; c4313g2 = c4313g2.Vf()) {
                    Object key = c4313g2.getKey();
                    if (c4313g2.Ve() == i && key != null && this.map.keyEquivalence.equivalent(k, key)) {
                        V value = c4313g2.getValue();
                        if (value == null) {
                            this.modCount++;
                            setValue(c4313g2, v);
                            this.count = this.count;
                            return v2;
                        } else if (z) {
                            unlock();
                            return value;
                        } else {
                            v2 = this.modCount + 1;
                            this.modCount = v2;
                            setValue(c4313g2, v);
                            unlock();
                            return value;
                        }
                    }
                }
                this.modCount++;
                c4313g = this.map.entryHelper.mo4534a(self(), k, i, c4313g);
                setValue(c4313g, v);
                atomicReferenceArray.set(length, c4313g);
                this.count = i2;
                unlock();
                return null;
            } finally {
                unlock();
            }
        }

        void expand() {
            AtomicReferenceArray atomicReferenceArray = this.table;
            int length = atomicReferenceArray.length();
            if (length < MapMakerInternalMap.MAXIMUM_CAPACITY) {
                int i = this.count;
                AtomicReferenceArray newEntryArray = newEntryArray(length << 1);
                this.threshold = (newEntryArray.length() * 3) / 4;
                int length2 = newEntryArray.length() - 1;
                int i2 = 0;
                while (i2 < length) {
                    int i3;
                    C4313g c4313g = (C4313g) atomicReferenceArray.get(i2);
                    if (c4313g != null) {
                        C4313g Vf = c4313g.Vf();
                        int Ve = c4313g.Ve() & length2;
                        if (Vf == null) {
                            newEntryArray.set(Ve, c4313g);
                            i3 = i;
                        } else {
                            C4313g c4313g2;
                            C4313g c4313g3 = c4313g;
                            while (Vf != null) {
                                i3 = Vf.Ve() & length2;
                                if (i3 != Ve) {
                                    c4313g2 = Vf;
                                } else {
                                    i3 = Ve;
                                    c4313g2 = c4313g3;
                                }
                                Vf = Vf.Vf();
                                c4313g3 = c4313g2;
                                Ve = i3;
                            }
                            newEntryArray.set(Ve, c4313g3);
                            c4313g2 = c4313g;
                            i3 = i;
                            while (c4313g2 != c4313g3) {
                                int i4;
                                int Ve2 = c4313g2.Ve() & length2;
                                c4313g = copyEntry(c4313g2, (C4313g) newEntryArray.get(Ve2));
                                if (c4313g != null) {
                                    newEntryArray.set(Ve2, c4313g);
                                    i4 = i3;
                                } else {
                                    i4 = i3 - 1;
                                }
                                c4313g2 = c4313g2.Vf();
                                i3 = i4;
                            }
                        }
                    } else {
                        i3 = i;
                    }
                    i2++;
                    i = i3;
                }
                this.table = newEntryArray;
                this.count = i;
            }
        }

        boolean replace(K k, int i, V v, V v2) {
            lock();
            try {
                preWriteCleanup();
                AtomicReferenceArray atomicReferenceArray = this.table;
                int length = i & (atomicReferenceArray.length() - 1);
                C4313g c4313g = (C4313g) atomicReferenceArray.get(length);
                for (C4313g c4313g2 = c4313g; c4313g2 != null; c4313g2 = c4313g2.Vf()) {
                    Object key = c4313g2.getKey();
                    if (c4313g2.Ve() == i && key != null && this.map.keyEquivalence.equivalent(k, key)) {
                        key = c4313g2.getValue();
                        if (key == null) {
                            if (isCollected(c4313g2)) {
                                int i2 = this.count - 1;
                                this.modCount++;
                                c4313g = removeFromChain(c4313g, c4313g2);
                                int i3 = this.count - 1;
                                atomicReferenceArray.set(length, c4313g);
                                this.count = i3;
                            }
                            unlock();
                            return false;
                        } else if (this.map.valueEquivalence().equivalent(v, key)) {
                            this.modCount++;
                            setValue(c4313g2, v2);
                            unlock();
                            return true;
                        } else {
                            unlock();
                            return false;
                        }
                    }
                }
                unlock();
                return false;
            } catch (Throwable th) {
                unlock();
            }
        }

        V replace(K k, int i, V v) {
            lock();
            try {
                preWriteCleanup();
                AtomicReferenceArray atomicReferenceArray = this.table;
                int length = i & (atomicReferenceArray.length() - 1);
                C4313g c4313g = (C4313g) atomicReferenceArray.get(length);
                for (C4313g c4313g2 = c4313g; c4313g2 != null; c4313g2 = c4313g2.Vf()) {
                    Object key = c4313g2.getKey();
                    if (c4313g2.Ve() == i && key != null && this.map.keyEquivalence.equivalent(k, key)) {
                        V value = c4313g2.getValue();
                        if (value == null) {
                            if (isCollected(c4313g2)) {
                                int i2 = this.count - 1;
                                this.modCount++;
                                i2 = this.count - 1;
                                atomicReferenceArray.set(length, removeFromChain(c4313g, c4313g2));
                                this.count = i2;
                            }
                            unlock();
                            return null;
                        }
                        this.modCount++;
                        setValue(c4313g2, v);
                        unlock();
                        return value;
                    }
                }
                unlock();
                return null;
            } catch (Throwable th) {
                unlock();
            }
        }

        V remove(Object obj, int i) {
            lock();
            try {
                preWriteCleanup();
                int i2 = this.count - 1;
                AtomicReferenceArray atomicReferenceArray = this.table;
                int length = i & (atomicReferenceArray.length() - 1);
                C4313g c4313g = (C4313g) atomicReferenceArray.get(length);
                for (C4313g c4313g2 = c4313g; c4313g2 != null; c4313g2 = c4313g2.Vf()) {
                    V key = c4313g2.getKey();
                    if (c4313g2.Ve() == i && key != null) {
                        key = this.map.keyEquivalence.equivalent(obj, key);
                        if (key != null) {
                            key = c4313g2.getValue();
                            if (key == null) {
                                if (!isCollected(c4313g2)) {
                                    unlock();
                                    return null;
                                }
                            }
                            this.modCount++;
                            int i3 = this.count - 1;
                            atomicReferenceArray.set(length, removeFromChain(c4313g, c4313g2));
                            this.count = i3;
                            return key;
                        }
                    }
                }
                unlock();
                return null;
            } finally {
                unlock();
            }
        }

        boolean remove(Object obj, int i, Object obj2) {
            boolean z = false;
            lock();
            try {
                preWriteCleanup();
                int i2 = this.count - 1;
                AtomicReferenceArray atomicReferenceArray = this.table;
                int length = i & (atomicReferenceArray.length() - 1);
                C4313g c4313g = (C4313g) atomicReferenceArray.get(length);
                for (C4313g c4313g2 = c4313g; c4313g2 != null; c4313g2 = c4313g2.Vf()) {
                    Object key = c4313g2.getKey();
                    if (c4313g2.Ve() == i && key != null && this.map.keyEquivalence.equivalent(obj, key)) {
                        if (this.map.valueEquivalence().equivalent(obj2, c4313g2.getValue())) {
                            z = true;
                        } else if (!isCollected(c4313g2)) {
                            unlock();
                            return false;
                        }
                        this.modCount++;
                        c4313g = removeFromChain(c4313g, c4313g2);
                        int i3 = this.count - 1;
                        atomicReferenceArray.set(length, c4313g);
                        this.count = i3;
                        return z;
                    }
                }
                unlock();
                return false;
            } finally {
                unlock();
            }
        }

        void clear() {
            if (this.count != 0) {
                lock();
                try {
                    AtomicReferenceArray atomicReferenceArray = this.table;
                    for (int i = 0; i < atomicReferenceArray.length(); i++) {
                        atomicReferenceArray.set(i, null);
                    }
                    maybeClearReferenceQueues();
                    this.readCount.set(0);
                    this.modCount++;
                    this.count = 0;
                } finally {
                    unlock();
                }
            }
        }

        E removeFromChain(E e, E e2) {
            int i = this.count;
            E Vf = e2.Vf();
            while (e != e2) {
                int i2;
                E copyEntry = copyEntry(e, Vf);
                if (copyEntry != null) {
                    i2 = i;
                } else {
                    E e3 = Vf;
                    i2 = i - 1;
                    copyEntry = e3;
                }
                e = e.Vf();
                i = i2;
                Vf = copyEntry;
            }
            this.count = i;
            return Vf;
        }

        boolean reclaimKey(E e, int i) {
            lock();
            try {
                int i2 = this.count - 1;
                AtomicReferenceArray atomicReferenceArray = this.table;
                int length = i & (atomicReferenceArray.length() - 1);
                E e2 = (C4313g) atomicReferenceArray.get(length);
                for (E e3 = e2; e3 != null; e3 = e3.Vf()) {
                    if (e3 == e) {
                        this.modCount++;
                        C4313g removeFromChain = removeFromChain(e2, e3);
                        int i3 = this.count - 1;
                        atomicReferenceArray.set(length, removeFromChain);
                        this.count = i3;
                        return true;
                    }
                }
                unlock();
                return false;
            } finally {
                unlock();
            }
        }

        boolean reclaimValue(K k, int i, C4309v<K, V, E> c4309v) {
            lock();
            try {
                int i2 = this.count - 1;
                AtomicReferenceArray atomicReferenceArray = this.table;
                int length = i & (atomicReferenceArray.length() - 1);
                C4313g c4313g = (C4313g) atomicReferenceArray.get(length);
                C4313g c4313g2 = c4313g;
                while (c4313g2 != null) {
                    Object key = c4313g2.getKey();
                    if (c4313g2.Ve() != i || key == null || !this.map.keyEquivalence.equivalent(k, key)) {
                        c4313g2 = c4313g2.Vf();
                    } else if (((C4330u) c4313g2).Vn() == c4309v) {
                        this.modCount++;
                        int i3 = this.count - 1;
                        atomicReferenceArray.set(length, removeFromChain(c4313g, c4313g2));
                        this.count = i3;
                        return true;
                    } else {
                        unlock();
                        return false;
                    }
                }
                unlock();
                return false;
            } finally {
                unlock();
            }
        }

        boolean clearValueForTesting(K k, int i, C4309v<K, V, ? extends C4313g<K, V, ?>> c4309v) {
            lock();
            try {
                AtomicReferenceArray atomicReferenceArray = this.table;
                int length = i & (atomicReferenceArray.length() - 1);
                C4313g c4313g = (C4313g) atomicReferenceArray.get(length);
                C4313g c4313g2 = c4313g;
                while (c4313g2 != null) {
                    Object key = c4313g2.getKey();
                    if (c4313g2.Ve() != i || key == null || !this.map.keyEquivalence.equivalent(k, key)) {
                        c4313g2 = c4313g2.Vf();
                    } else if (((C4330u) c4313g2).Vn() == c4309v) {
                        atomicReferenceArray.set(length, removeFromChain(c4313g, c4313g2));
                        return true;
                    } else {
                        unlock();
                        return false;
                    }
                }
                unlock();
                return false;
            } finally {
                unlock();
            }
        }

        boolean removeEntryForTesting(E e) {
            int Ve = e.Ve();
            int i = this.count - 1;
            AtomicReferenceArray atomicReferenceArray = this.table;
            int length = Ve & (atomicReferenceArray.length() - 1);
            E e2 = (C4313g) atomicReferenceArray.get(length);
            for (E e3 = e2; e3 != null; e3 = e3.Vf()) {
                if (e3 == e) {
                    this.modCount++;
                    C4313g removeFromChain = removeFromChain(e2, e3);
                    i = this.count - 1;
                    atomicReferenceArray.set(length, removeFromChain);
                    this.count = i;
                    return true;
                }
            }
            return false;
        }

        static <K, V, E extends C4313g<K, V, E>> boolean isCollected(E e) {
            return e.getValue() == null;
        }

        V getLiveValue(E e) {
            if (e.getKey() == null) {
                tryDrainReferenceQueues();
                return null;
            }
            V value = e.getValue();
            if (value != null) {
                return value;
            }
            tryDrainReferenceQueues();
            return null;
        }

        void postReadCleanup() {
            if ((this.readCount.incrementAndGet() & 63) == 0) {
                runCleanup();
            }
        }

        void preWriteCleanup() {
            runLockedCleanup();
        }

        void runCleanup() {
            runLockedCleanup();
        }

        void runLockedCleanup() {
            if (tryLock()) {
                try {
                    maybeDrainReferenceQueues();
                    this.readCount.set(0);
                } finally {
                    unlock();
                }
            }
        }
    }

    static final class SerializationProxy<K, V> extends AbstractSerializationProxy<K, V> {
        private static final long serialVersionUID = 3;

        SerializationProxy(Strength strength, Strength strength2, Equivalence<Object> equivalence, Equivalence<Object> equivalence2, int i, ConcurrentMap<K, V> concurrentMap) {
            super(strength, strength2, equivalence, equivalence2, i, concurrentMap);
        }

        private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
            objectOutputStream.defaultWriteObject();
            writeMapTo(objectOutputStream);
        }

        private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
            objectInputStream.defaultReadObject();
            this.delegate = readMapMaker(objectInputStream).Vb();
            readEntries(objectInputStream);
        }

        private Object readResolve() {
            return this.delegate;
        }
    }

    enum Strength {
        STRONG {
            Equivalence<Object> defaultEquivalence() {
                return Equivalence.equals();
            }
        },
        WEAK {
            Equivalence<Object> defaultEquivalence() {
                return Equivalence.identity();
            }
        };

        abstract Equivalence<Object> defaultEquivalence();
    }

    static final class StrongKeyDummyValueSegment<K> extends Segment<K, Dummy, C4326l<K>, StrongKeyDummyValueSegment<K>> {
        StrongKeyDummyValueSegment(MapMakerInternalMap<K, Dummy, C4326l<K>, StrongKeyDummyValueSegment<K>> mapMakerInternalMap, int i, int i2) {
            super(mapMakerInternalMap, i, i2);
        }

        StrongKeyDummyValueSegment<K> self() {
            return this;
        }

        public C4326l<K> castForTesting(C4313g<K, Dummy, ?> c4313g) {
            return (C4326l) c4313g;
        }
    }

    static final class StrongKeyStrongValueSegment<K, V> extends Segment<K, V, C4328m<K, V>, StrongKeyStrongValueSegment<K, V>> {
        StrongKeyStrongValueSegment(MapMakerInternalMap<K, V, C4328m<K, V>, StrongKeyStrongValueSegment<K, V>> mapMakerInternalMap, int i, int i2) {
            super(mapMakerInternalMap, i, i2);
        }

        StrongKeyStrongValueSegment<K, V> self() {
            return this;
        }

        public C4328m<K, V> castForTesting(C4313g<K, V, ?> c4313g) {
            return (C4328m) c4313g;
        }
    }

    static final class StrongKeyWeakValueSegment<K, V> extends Segment<K, V, C4331n<K, V>, StrongKeyWeakValueSegment<K, V>> {
        private final ReferenceQueue<V> queueForValues = new ReferenceQueue();

        StrongKeyWeakValueSegment(MapMakerInternalMap<K, V, C4331n<K, V>, StrongKeyWeakValueSegment<K, V>> mapMakerInternalMap, int i, int i2) {
            super(mapMakerInternalMap, i, i2);
        }

        StrongKeyWeakValueSegment<K, V> self() {
            return this;
        }

        ReferenceQueue<V> getValueReferenceQueueForTesting() {
            return this.queueForValues;
        }

        public C4331n<K, V> castForTesting(C4313g<K, V, ?> c4313g) {
            return (C4331n) c4313g;
        }

        public C4309v<K, V, C4331n<K, V>> getWeakValueReferenceForTesting(C4313g<K, V, ?> c4313g) {
            return castForTesting((C4313g) c4313g).Vn();
        }

        public C4309v<K, V, C4331n<K, V>> newWeakValueReferenceForTesting(C4313g<K, V, ?> c4313g, V v) {
            return new C4340w(this.queueForValues, v, castForTesting((C4313g) c4313g));
        }

        public void setWeakValueReferenceForTesting(C4313g<K, V, ?> c4313g, C4309v<K, V, ? extends C4313g<K, V, ?>> c4309v) {
            C4331n castForTesting = castForTesting((C4313g) c4313g);
            C4309v a = castForTesting.bNv;
            castForTesting.bNv = c4309v;
            a.clear();
        }

        void maybeDrainReferenceQueues() {
            drainValueReferenceQueue(this.queueForValues);
        }

        void maybeClearReferenceQueues() {
            clearReferenceQueue(this.queueForValues);
        }
    }

    static final class WeakKeyDummyValueSegment<K> extends Segment<K, Dummy, C4335r<K>, WeakKeyDummyValueSegment<K>> {
        private final ReferenceQueue<K> queueForKeys = new ReferenceQueue();

        WeakKeyDummyValueSegment(MapMakerInternalMap<K, Dummy, C4335r<K>, WeakKeyDummyValueSegment<K>> mapMakerInternalMap, int i, int i2) {
            super(mapMakerInternalMap, i, i2);
        }

        WeakKeyDummyValueSegment<K> self() {
            return this;
        }

        ReferenceQueue<K> getKeyReferenceQueueForTesting() {
            return this.queueForKeys;
        }

        public C4335r<K> castForTesting(C4313g<K, Dummy, ?> c4313g) {
            return (C4335r) c4313g;
        }

        void maybeDrainReferenceQueues() {
            drainKeyReferenceQueue(this.queueForKeys);
        }

        void maybeClearReferenceQueues() {
            clearReferenceQueue(this.queueForKeys);
        }
    }

    static final class WeakKeyStrongValueSegment<K, V> extends Segment<K, V, C4337s<K, V>, WeakKeyStrongValueSegment<K, V>> {
        private final ReferenceQueue<K> queueForKeys = new ReferenceQueue();

        WeakKeyStrongValueSegment(MapMakerInternalMap<K, V, C4337s<K, V>, WeakKeyStrongValueSegment<K, V>> mapMakerInternalMap, int i, int i2) {
            super(mapMakerInternalMap, i, i2);
        }

        WeakKeyStrongValueSegment<K, V> self() {
            return this;
        }

        ReferenceQueue<K> getKeyReferenceQueueForTesting() {
            return this.queueForKeys;
        }

        public C4337s<K, V> castForTesting(C4313g<K, V, ?> c4313g) {
            return (C4337s) c4313g;
        }

        void maybeDrainReferenceQueues() {
            drainKeyReferenceQueue(this.queueForKeys);
        }

        void maybeClearReferenceQueues() {
            clearReferenceQueue(this.queueForKeys);
        }
    }

    static final class WeakKeyWeakValueSegment<K, V> extends Segment<K, V, C4339t<K, V>, WeakKeyWeakValueSegment<K, V>> {
        private final ReferenceQueue<K> queueForKeys = new ReferenceQueue();
        private final ReferenceQueue<V> queueForValues = new ReferenceQueue();

        WeakKeyWeakValueSegment(MapMakerInternalMap<K, V, C4339t<K, V>, WeakKeyWeakValueSegment<K, V>> mapMakerInternalMap, int i, int i2) {
            super(mapMakerInternalMap, i, i2);
        }

        WeakKeyWeakValueSegment<K, V> self() {
            return this;
        }

        ReferenceQueue<K> getKeyReferenceQueueForTesting() {
            return this.queueForKeys;
        }

        ReferenceQueue<V> getValueReferenceQueueForTesting() {
            return this.queueForValues;
        }

        public C4339t<K, V> castForTesting(C4313g<K, V, ?> c4313g) {
            return (C4339t) c4313g;
        }

        public C4309v<K, V, C4339t<K, V>> getWeakValueReferenceForTesting(C4313g<K, V, ?> c4313g) {
            return castForTesting((C4313g) c4313g).Vn();
        }

        public C4309v<K, V, C4339t<K, V>> newWeakValueReferenceForTesting(C4313g<K, V, ?> c4313g, V v) {
            return new C4340w(this.queueForValues, v, castForTesting((C4313g) c4313g));
        }

        public void setWeakValueReferenceForTesting(C4313g<K, V, ?> c4313g, C4309v<K, V, ? extends C4313g<K, V, ?>> c4309v) {
            C4339t castForTesting = castForTesting((C4313g) c4313g);
            C4309v a = castForTesting.bNv;
            castForTesting.bNv = c4309v;
            a.clear();
        }

        void maybeDrainReferenceQueues() {
            drainKeyReferenceQueue(this.queueForKeys);
            drainValueReferenceQueue(this.queueForValues);
        }

        void maybeClearReferenceQueues() {
            clearReferenceQueue(this.queueForKeys);
        }
    }

    interface C4313g<K, V, E extends C4313g<K, V, E>> {
        int Ve();

        E Vf();

        K getKey();

        V getValue();
    }

    static abstract class C4314a<K, V, E extends C4313g<K, V, E>> implements C4313g<K, V, E> {
        final int aIw;
        final E bNj;
        final K key;

        C4314a(K k, int i, E e) {
            this.key = k;
            this.aIw = i;
            this.bNj = e;
        }

        public K getKey() {
            return this.key;
        }

        public int Ve() {
            return this.aIw;
        }

        public E Vf() {
            return this.bNj;
        }
    }

    static abstract class C4315b<K, V, E extends C4313g<K, V, E>> extends WeakReference<K> implements C4313g<K, V, E> {
        final int aIw;
        final E bNj;

        C4315b(ReferenceQueue<K> referenceQueue, K k, int i, E e) {
            super(k, referenceQueue);
            this.aIw = i;
            this.bNj = e;
        }

        public K getKey() {
            return get();
        }

        public int Ve() {
            return this.aIw;
        }

        public E Vf() {
            return this.bNj;
        }
    }

    static final class C4316c implements C4313g<Object, Object, C4316c> {
        public /* synthetic */ C4313g Vf() {
            return Vg();
        }

        private C4316c() {
            throw new AssertionError();
        }

        public C4316c Vg() {
            throw new AssertionError();
        }

        public int Ve() {
            throw new AssertionError();
        }

        public Object getKey() {
            throw new AssertionError();
        }

        public Object getValue() {
            throw new AssertionError();
        }
    }

    abstract class C4317f<T> implements Iterator<T> {
        final /* synthetic */ MapMakerInternalMap bNk;
        int bNl;
        int bNm = -1;
        Segment<K, V, E, S> bNn;
        AtomicReferenceArray<E> bNo;
        E bNp;
        C4341x bNq;
        C4341x bNr;

        C4317f(MapMakerInternalMap mapMakerInternalMap) {
            this.bNk = mapMakerInternalMap;
            this.bNl = mapMakerInternalMap.segments.length - 1;
            advance();
        }

        final void advance() {
            this.bNq = null;
            if (!Vh() && !Vi()) {
                while (this.bNl >= 0) {
                    Segment[] segmentArr = this.bNk.segments;
                    int i = this.bNl;
                    this.bNl = i - 1;
                    this.bNn = segmentArr[i];
                    if (this.bNn.count != 0) {
                        this.bNo = this.bNn.table;
                        this.bNm = this.bNo.length() - 1;
                        if (Vi()) {
                            return;
                        }
                    }
                }
            }
        }

        boolean Vh() {
            if (this.bNp != null) {
                this.bNp = this.bNp.Vf();
                while (this.bNp != null) {
                    if (m14385a(this.bNp)) {
                        return true;
                    }
                    this.bNp = this.bNp.Vf();
                }
            }
            return false;
        }

        boolean Vi() {
            while (this.bNm >= 0) {
                AtomicReferenceArray atomicReferenceArray = this.bNo;
                int i = this.bNm;
                this.bNm = i - 1;
                C4313g c4313g = (C4313g) atomicReferenceArray.get(i);
                this.bNp = c4313g;
                if (c4313g != null && (m14385a(this.bNp) || Vh())) {
                    return true;
                }
            }
            return false;
        }

        boolean m14385a(E e) {
            try {
                Object key = e.getKey();
                Object liveValue = this.bNk.getLiveValue(e);
                if (liveValue != null) {
                    this.bNq = new C4341x(this.bNk, key, liveValue);
                    return true;
                }
                this.bNn.postReadCleanup();
                return false;
            } finally {
                this.bNn.postReadCleanup();
            }
        }

        public boolean hasNext() {
            return this.bNq != null;
        }

        C4341x Vj() {
            if (this.bNq == null) {
                throw new NoSuchElementException();
            }
            this.bNr = this.bNq;
            advance();
            return this.bNr;
        }

        public void remove() {
            ccw.bB(this.bNr != null);
            this.bNk.remove(this.bNr.getKey());
            this.bNr = null;
        }
    }

    final class C4318d extends C4317f<Entry<K, V>> {
        final /* synthetic */ MapMakerInternalMap bNk;

        C4318d(MapMakerInternalMap mapMakerInternalMap) {
            this.bNk = mapMakerInternalMap;
            super(mapMakerInternalMap);
        }

        public /* synthetic */ Object next() {
            return jv();
        }

        public Entry<K, V> jv() {
            return Vj();
        }
    }

    static abstract class C4319k<E> extends AbstractSet<E> {
        private C4319k() {
        }

        public Object[] toArray() {
            return MapMakerInternalMap.m14451g(this).toArray();
        }

        public <E> E[] toArray(E[] eArr) {
            return MapMakerInternalMap.m14451g(this).toArray(eArr);
        }
    }

    final class C4320e extends C4319k<Entry<K, V>> {
        final /* synthetic */ MapMakerInternalMap bNk;

        C4320e(MapMakerInternalMap mapMakerInternalMap) {
            this.bNk = mapMakerInternalMap;
            super();
        }

        public Iterator<Entry<K, V>> iterator() {
            return new C4318d(this.bNk);
        }

        public boolean contains(Object obj) {
            if (!(obj instanceof Entry)) {
                return false;
            }
            Entry entry = (Entry) obj;
            Object key = entry.getKey();
            if (key == null) {
                return false;
            }
            key = this.bNk.get(key);
            if (key == null || !this.bNk.valueEquivalence().equivalent(entry.getValue(), key)) {
                return false;
            }
            return true;
        }

        public boolean remove(Object obj) {
            if (!(obj instanceof Entry)) {
                return false;
            }
            Entry entry = (Entry) obj;
            Object key = entry.getKey();
            if (key == null || !this.bNk.remove(key, entry.getValue())) {
                return false;
            }
            return true;
        }

        public int size() {
            return this.bNk.size();
        }

        public boolean isEmpty() {
            return this.bNk.isEmpty();
        }

        public void clear() {
            this.bNk.clear();
        }
    }

    interface C4321h<K, V, E extends C4313g<K, V, E>, S extends Segment<K, V, E, S>> {
        S mo4532a(MapMakerInternalMap<K, V, E, S> mapMakerInternalMap, int i, int i2);

        E mo4533a(S s, E e, E e2);

        E mo4534a(S s, K k, int i, E e);

        void mo4535a(S s, E e, V v);

        Strength keyStrength();

        Strength valueStrength();
    }

    final class C4322i extends C4317f<K> {
        final /* synthetic */ MapMakerInternalMap bNk;

        C4322i(MapMakerInternalMap mapMakerInternalMap) {
            this.bNk = mapMakerInternalMap;
            super(mapMakerInternalMap);
        }

        public K next() {
            return Vj().getKey();
        }
    }

    final class C4323j extends C4319k<K> {
        final /* synthetic */ MapMakerInternalMap bNk;

        C4323j(MapMakerInternalMap mapMakerInternalMap) {
            this.bNk = mapMakerInternalMap;
            super();
        }

        public Iterator<K> iterator() {
            return new C4322i(this.bNk);
        }

        public int size() {
            return this.bNk.size();
        }

        public boolean isEmpty() {
            return this.bNk.isEmpty();
        }

        public boolean contains(Object obj) {
            return this.bNk.containsKey(obj);
        }

        public boolean remove(Object obj) {
            return this.bNk.remove(obj) != null;
        }

        public void clear() {
            this.bNk.clear();
        }
    }

    interface C4325o extends C4313g {
    }

    static final class C4326l<K> extends C4314a<K, Dummy, C4326l<K>> implements C4325o<K, Dummy, C4326l<K>> {

        static final class C4324a<K> implements C4321h<K, Dummy, C4326l<K>, StrongKeyDummyValueSegment<K>> {
            private static final C4324a<?> bNt = new C4324a();

            C4324a() {
            }

            public /* synthetic */ Segment mo4532a(MapMakerInternalMap mapMakerInternalMap, int i, int i2) {
                return m14397b(mapMakerInternalMap, i, i2);
            }

            static <K> C4324a<K> Vl() {
                return bNt;
            }

            public Strength keyStrength() {
                return Strength.STRONG;
            }

            public Strength valueStrength() {
                return Strength.STRONG;
            }

            public StrongKeyDummyValueSegment<K> m14397b(MapMakerInternalMap<K, Dummy, C4326l<K>, StrongKeyDummyValueSegment<K>> mapMakerInternalMap, int i, int i2) {
                return new StrongKeyDummyValueSegment(mapMakerInternalMap, i, i2);
            }

            public C4326l<K> m14393a(StrongKeyDummyValueSegment<K> strongKeyDummyValueSegment, C4326l<K> c4326l, C4326l<K> c4326l2) {
                return c4326l.m14398a(c4326l2);
            }

            public void m14396a(StrongKeyDummyValueSegment<K> strongKeyDummyValueSegment, C4326l<K> c4326l, Dummy dummy) {
            }

            public C4326l<K> m14394a(StrongKeyDummyValueSegment<K> strongKeyDummyValueSegment, K k, int i, C4326l<K> c4326l) {
                return new C4326l(k, i, c4326l);
            }
        }

        public /* synthetic */ Object getValue() {
            return Vk();
        }

        C4326l(K k, int i, C4326l<K> c4326l) {
            super(k, i, c4326l);
        }

        public Dummy Vk() {
            return Dummy.VALUE;
        }

        C4326l<K> m14398a(C4326l<K> c4326l) {
            return new C4326l(this.key, this.aIw, c4326l);
        }
    }

    static final class C4328m<K, V> extends C4314a<K, V, C4328m<K, V>> implements C4325o<K, V, C4328m<K, V>> {
        private volatile V value = null;

        static final class C4327a<K, V> implements C4321h<K, V, C4328m<K, V>, StrongKeyStrongValueSegment<K, V>> {
            private static final C4327a<?, ?> bNu = new C4327a();

            C4327a() {
            }

            public /* synthetic */ Segment mo4532a(MapMakerInternalMap mapMakerInternalMap, int i, int i2) {
                return m14406c(mapMakerInternalMap, i, i2);
            }

            static <K, V> C4327a<K, V> Vm() {
                return bNu;
            }

            public Strength keyStrength() {
                return Strength.STRONG;
            }

            public Strength valueStrength() {
                return Strength.STRONG;
            }

            public StrongKeyStrongValueSegment<K, V> m14406c(MapMakerInternalMap<K, V, C4328m<K, V>, StrongKeyStrongValueSegment<K, V>> mapMakerInternalMap, int i, int i2) {
                return new StrongKeyStrongValueSegment(mapMakerInternalMap, i, i2);
            }

            public C4328m<K, V> m14402a(StrongKeyStrongValueSegment<K, V> strongKeyStrongValueSegment, C4328m<K, V> c4328m, C4328m<K, V> c4328m2) {
                return c4328m.m14407a(c4328m2);
            }

            public void m14405a(StrongKeyStrongValueSegment<K, V> strongKeyStrongValueSegment, C4328m<K, V> c4328m, V v) {
                c4328m.setValue(v);
            }

            public C4328m<K, V> m14403a(StrongKeyStrongValueSegment<K, V> strongKeyStrongValueSegment, K k, int i, C4328m<K, V> c4328m) {
                return new C4328m(k, i, c4328m);
            }
        }

        C4328m(K k, int i, C4328m<K, V> c4328m) {
            super(k, i, c4328m);
        }

        public V getValue() {
            return this.value;
        }

        void setValue(V v) {
            this.value = v;
        }

        C4328m<K, V> m14407a(C4328m<K, V> c4328m) {
            C4328m<K, V> c4328m2 = new C4328m(this.key, this.aIw, c4328m);
            c4328m2.value = this.value;
            return c4328m2;
        }
    }

    interface C4330u<K, V, E extends C4313g<K, V, E>> extends C4313g<K, V, E> {
        C4309v<K, V, E> Vn();
    }

    static final class C4331n<K, V> extends C4314a<K, V, C4331n<K, V>> implements C4330u<K, V, C4331n<K, V>> {
        private volatile C4309v<K, V, C4331n<K, V>> bNv = MapMakerInternalMap.unsetWeakValueReference();

        static final class C4329a<K, V> implements C4321h<K, V, C4331n<K, V>, StrongKeyWeakValueSegment<K, V>> {
            private static final C4329a<?, ?> bNw = new C4329a();

            C4329a() {
            }

            public /* synthetic */ Segment mo4532a(MapMakerInternalMap mapMakerInternalMap, int i, int i2) {
                return m14415d(mapMakerInternalMap, i, i2);
            }

            static <K, V> C4329a<K, V> Vo() {
                return bNw;
            }

            public Strength keyStrength() {
                return Strength.STRONG;
            }

            public Strength valueStrength() {
                return Strength.WEAK;
            }

            public StrongKeyWeakValueSegment<K, V> m14415d(MapMakerInternalMap<K, V, C4331n<K, V>, StrongKeyWeakValueSegment<K, V>> mapMakerInternalMap, int i, int i2) {
                return new StrongKeyWeakValueSegment(mapMakerInternalMap, i, i2);
            }

            public C4331n<K, V> m14411a(StrongKeyWeakValueSegment<K, V> strongKeyWeakValueSegment, C4331n<K, V> c4331n, C4331n<K, V> c4331n2) {
                if (Segment.isCollected(c4331n)) {
                    return null;
                }
                return c4331n.m14418a(strongKeyWeakValueSegment.queueForValues, (C4331n) c4331n2);
            }

            public void m14414a(StrongKeyWeakValueSegment<K, V> strongKeyWeakValueSegment, C4331n<K, V> c4331n, V v) {
                c4331n.m14419a((Object) v, strongKeyWeakValueSegment.queueForValues);
            }

            public C4331n<K, V> m14412a(StrongKeyWeakValueSegment<K, V> strongKeyWeakValueSegment, K k, int i, C4331n<K, V> c4331n) {
                return new C4331n(k, i, c4331n);
            }
        }

        C4331n(K k, int i, C4331n<K, V> c4331n) {
            super(k, i, c4331n);
        }

        public V getValue() {
            return this.bNv.get();
        }

        void m14419a(V v, ReferenceQueue<V> referenceQueue) {
            C4309v c4309v = this.bNv;
            this.bNv = new C4340w(referenceQueue, v, this);
            c4309v.clear();
        }

        C4331n<K, V> m14418a(ReferenceQueue<V> referenceQueue, C4331n<K, V> c4331n) {
            C4331n<K, V> c4331n2 = new C4331n(this.key, this.aIw, c4331n);
            c4331n2.bNv = this.bNv.mo4515a(referenceQueue, c4331n2);
            return c4331n2;
        }

        public C4309v<K, V, C4331n<K, V>> Vn() {
            return this.bNv;
        }
    }

    final class C4332p extends C4317f<V> {
        final /* synthetic */ MapMakerInternalMap bNk;

        C4332p(MapMakerInternalMap mapMakerInternalMap) {
            this.bNk = mapMakerInternalMap;
            super(mapMakerInternalMap);
        }

        public V next() {
            return Vj().getValue();
        }
    }

    final class C4333q extends AbstractCollection<V> {
        final /* synthetic */ MapMakerInternalMap bNk;

        C4333q(MapMakerInternalMap mapMakerInternalMap) {
            this.bNk = mapMakerInternalMap;
        }

        public Iterator<V> iterator() {
            return new C4332p(this.bNk);
        }

        public int size() {
            return this.bNk.size();
        }

        public boolean isEmpty() {
            return this.bNk.isEmpty();
        }

        public boolean contains(Object obj) {
            return this.bNk.containsValue(obj);
        }

        public void clear() {
            this.bNk.clear();
        }

        public Object[] toArray() {
            return MapMakerInternalMap.m14451g(this).toArray();
        }

        public <E> E[] toArray(E[] eArr) {
            return MapMakerInternalMap.m14451g(this).toArray(eArr);
        }
    }

    static final class C4335r<K> extends C4315b<K, Dummy, C4335r<K>> implements C4325o<K, Dummy, C4335r<K>> {

        static final class C4334a<K> implements C4321h<K, Dummy, C4335r<K>, WeakKeyDummyValueSegment<K>> {
            private static final C4334a<?> bNx = new C4334a();

            C4334a() {
            }

            public /* synthetic */ Segment mo4532a(MapMakerInternalMap mapMakerInternalMap, int i, int i2) {
                return m14427e(mapMakerInternalMap, i, i2);
            }

            static <K> C4334a<K> Vp() {
                return bNx;
            }

            public Strength keyStrength() {
                return Strength.WEAK;
            }

            public Strength valueStrength() {
                return Strength.STRONG;
            }

            public WeakKeyDummyValueSegment<K> m14427e(MapMakerInternalMap<K, Dummy, C4335r<K>, WeakKeyDummyValueSegment<K>> mapMakerInternalMap, int i, int i2) {
                return new WeakKeyDummyValueSegment(mapMakerInternalMap, i, i2);
            }

            public C4335r<K> m14423a(WeakKeyDummyValueSegment<K> weakKeyDummyValueSegment, C4335r<K> c4335r, C4335r<K> c4335r2) {
                if (c4335r.getKey() == null) {
                    return null;
                }
                return c4335r.m14428a(weakKeyDummyValueSegment.queueForKeys, c4335r2);
            }

            public void m14426a(WeakKeyDummyValueSegment<K> weakKeyDummyValueSegment, C4335r<K> c4335r, Dummy dummy) {
            }

            public C4335r<K> m14424a(WeakKeyDummyValueSegment<K> weakKeyDummyValueSegment, K k, int i, C4335r<K> c4335r) {
                return new C4335r(weakKeyDummyValueSegment.queueForKeys, k, i, c4335r);
            }
        }

        public /* synthetic */ Object getValue() {
            return Vk();
        }

        C4335r(ReferenceQueue<K> referenceQueue, K k, int i, C4335r<K> c4335r) {
            super(referenceQueue, k, i, c4335r);
        }

        public Dummy Vk() {
            return Dummy.VALUE;
        }

        C4335r<K> m14428a(ReferenceQueue<K> referenceQueue, C4335r<K> c4335r) {
            return new C4335r(referenceQueue, getKey(), this.aIw, c4335r);
        }
    }

    static final class C4337s<K, V> extends C4315b<K, V, C4337s<K, V>> implements C4325o<K, V, C4337s<K, V>> {
        private volatile V value = null;

        static final class C4336a<K, V> implements C4321h<K, V, C4337s<K, V>, WeakKeyStrongValueSegment<K, V>> {
            private static final C4336a<?, ?> bNy = new C4336a();

            C4336a() {
            }

            public /* synthetic */ Segment mo4532a(MapMakerInternalMap mapMakerInternalMap, int i, int i2) {
                return m14436f(mapMakerInternalMap, i, i2);
            }

            static <K, V> C4336a<K, V> Vq() {
                return bNy;
            }

            public Strength keyStrength() {
                return Strength.WEAK;
            }

            public Strength valueStrength() {
                return Strength.STRONG;
            }

            public WeakKeyStrongValueSegment<K, V> m14436f(MapMakerInternalMap<K, V, C4337s<K, V>, WeakKeyStrongValueSegment<K, V>> mapMakerInternalMap, int i, int i2) {
                return new WeakKeyStrongValueSegment(mapMakerInternalMap, i, i2);
            }

            public C4337s<K, V> m14432a(WeakKeyStrongValueSegment<K, V> weakKeyStrongValueSegment, C4337s<K, V> c4337s, C4337s<K, V> c4337s2) {
                if (c4337s.getKey() == null) {
                    return null;
                }
                return c4337s.m14437a(weakKeyStrongValueSegment.queueForKeys, c4337s2);
            }

            public void m14435a(WeakKeyStrongValueSegment<K, V> weakKeyStrongValueSegment, C4337s<K, V> c4337s, V v) {
                c4337s.setValue(v);
            }

            public C4337s<K, V> m14433a(WeakKeyStrongValueSegment<K, V> weakKeyStrongValueSegment, K k, int i, C4337s<K, V> c4337s) {
                return new C4337s(weakKeyStrongValueSegment.queueForKeys, k, i, c4337s);
            }
        }

        C4337s(ReferenceQueue<K> referenceQueue, K k, int i, C4337s<K, V> c4337s) {
            super(referenceQueue, k, i, c4337s);
        }

        public V getValue() {
            return this.value;
        }

        void setValue(V v) {
            this.value = v;
        }

        C4337s<K, V> m14437a(ReferenceQueue<K> referenceQueue, C4337s<K, V> c4337s) {
            C4337s<K, V> c4337s2 = new C4337s(referenceQueue, getKey(), this.aIw, c4337s);
            c4337s2.setValue(this.value);
            return c4337s2;
        }
    }

    static final class C4339t<K, V> extends C4315b<K, V, C4339t<K, V>> implements C4330u<K, V, C4339t<K, V>> {
        private volatile C4309v<K, V, C4339t<K, V>> bNv = MapMakerInternalMap.unsetWeakValueReference();

        static final class C4338a<K, V> implements C4321h<K, V, C4339t<K, V>, WeakKeyWeakValueSegment<K, V>> {
            private static final C4338a<?, ?> bNz = new C4338a();

            C4338a() {
            }

            public /* synthetic */ Segment mo4532a(MapMakerInternalMap mapMakerInternalMap, int i, int i2) {
                return m14445g(mapMakerInternalMap, i, i2);
            }

            static <K, V> C4338a<K, V> Vr() {
                return bNz;
            }

            public Strength keyStrength() {
                return Strength.WEAK;
            }

            public Strength valueStrength() {
                return Strength.WEAK;
            }

            public WeakKeyWeakValueSegment<K, V> m14445g(MapMakerInternalMap<K, V, C4339t<K, V>, WeakKeyWeakValueSegment<K, V>> mapMakerInternalMap, int i, int i2) {
                return new WeakKeyWeakValueSegment(mapMakerInternalMap, i, i2);
            }

            public C4339t<K, V> m14441a(WeakKeyWeakValueSegment<K, V> weakKeyWeakValueSegment, C4339t<K, V> c4339t, C4339t<K, V> c4339t2) {
                if (c4339t.getKey() == null || Segment.isCollected(c4339t)) {
                    return null;
                }
                return c4339t.m14448a(weakKeyWeakValueSegment.queueForKeys, weakKeyWeakValueSegment.queueForValues, c4339t2);
            }

            public void m14444a(WeakKeyWeakValueSegment<K, V> weakKeyWeakValueSegment, C4339t<K, V> c4339t, V v) {
                c4339t.m14449a((Object) v, weakKeyWeakValueSegment.queueForValues);
            }

            public C4339t<K, V> m14442a(WeakKeyWeakValueSegment<K, V> weakKeyWeakValueSegment, K k, int i, C4339t<K, V> c4339t) {
                return new C4339t(weakKeyWeakValueSegment.queueForKeys, k, i, c4339t);
            }
        }

        C4339t(ReferenceQueue<K> referenceQueue, K k, int i, C4339t<K, V> c4339t) {
            super(referenceQueue, k, i, c4339t);
        }

        public V getValue() {
            return this.bNv.get();
        }

        C4339t<K, V> m14448a(ReferenceQueue<K> referenceQueue, ReferenceQueue<V> referenceQueue2, C4339t<K, V> c4339t) {
            C4339t<K, V> c4339t2 = new C4339t(referenceQueue, getKey(), this.aIw, c4339t);
            c4339t2.bNv = this.bNv.mo4515a(referenceQueue2, c4339t2);
            return c4339t2;
        }

        void m14449a(V v, ReferenceQueue<V> referenceQueue) {
            C4309v c4309v = this.bNv;
            this.bNv = new C4340w(referenceQueue, v, this);
            c4309v.clear();
        }

        public C4309v<K, V, C4339t<K, V>> Vn() {
            return this.bNv;
        }
    }

    static final class C4340w<K, V, E extends C4313g<K, V, E>> extends WeakReference<V> implements C4309v<K, V, E> {
        final E bNA;

        C4340w(ReferenceQueue<V> referenceQueue, V v, E e) {
            super(v, referenceQueue);
            this.bNA = e;
        }

        public E Vd() {
            return this.bNA;
        }

        public C4309v<K, V, E> mo4515a(ReferenceQueue<V> referenceQueue, E e) {
            return new C4340w(referenceQueue, get(), e);
        }
    }

    final class C4341x extends ccs<K, V> {
        final /* synthetic */ MapMakerInternalMap bNk;
        final K key;
        V value;

        C4341x(MapMakerInternalMap mapMakerInternalMap, K k, V v) {
            this.bNk = mapMakerInternalMap;
            this.key = k;
            this.value = v;
        }

        public K getKey() {
            return this.key;
        }

        public V getValue() {
            return this.value;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof Entry)) {
                return false;
            }
            Entry entry = (Entry) obj;
            if (this.key.equals(entry.getKey()) && this.value.equals(entry.getValue())) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return this.key.hashCode() ^ this.value.hashCode();
        }

        public V setValue(V v) {
            V put = this.bNk.put(this.key, v);
            this.value = v;
            return put;
        }
    }

    private MapMakerInternalMap(MapMaker mapMaker, C4321h<K, V, E, S> c4321h) {
        int i = 1;
        int i2 = 0;
        this.concurrencyLevel = Math.min(mapMaker.UX(), 65536);
        this.keyEquivalence = mapMaker.UV();
        this.entryHelper = c4321h;
        int min = Math.min(mapMaker.UW(), MAXIMUM_CAPACITY);
        int i3 = 1;
        int i4 = 0;
        while (i3 < this.concurrencyLevel) {
            i4++;
            i3 <<= 1;
        }
        this.segmentShift = 32 - i4;
        this.segmentMask = i3 - 1;
        this.segments = newSegmentArray(i3);
        i4 = min / i3;
        if (i3 * i4 < min) {
            i3 = i4 + 1;
        } else {
            i3 = i4;
        }
        while (i < i3) {
            i <<= 1;
        }
        while (i2 < this.segments.length) {
            this.segments[i2] = createSegment(i, -1);
            i2++;
        }
    }

    static <K, V> MapMakerInternalMap<K, V, ? extends C4313g<K, V, ?>, ?> create(MapMaker mapMaker) {
        if (mapMaker.UZ() == Strength.STRONG && mapMaker.Va() == Strength.STRONG) {
            return new MapMakerInternalMap(mapMaker, C4327a.Vm());
        }
        if (mapMaker.UZ() == Strength.STRONG && mapMaker.Va() == Strength.WEAK) {
            return new MapMakerInternalMap(mapMaker, C4329a.Vo());
        }
        if (mapMaker.UZ() == Strength.WEAK && mapMaker.Va() == Strength.STRONG) {
            return new MapMakerInternalMap(mapMaker, C4336a.Vq());
        }
        if (mapMaker.UZ() == Strength.WEAK && mapMaker.Va() == Strength.WEAK) {
            return new MapMakerInternalMap(mapMaker, C4338a.Vr());
        }
        throw new AssertionError();
    }

    static <K> MapMakerInternalMap<K, Dummy, ? extends C4313g<K, Dummy, ?>, ?> createWithDummyValues(MapMaker mapMaker) {
        if (mapMaker.UZ() == Strength.STRONG && mapMaker.Va() == Strength.STRONG) {
            return new MapMakerInternalMap(mapMaker, C4324a.Vl());
        }
        if (mapMaker.UZ() == Strength.WEAK && mapMaker.Va() == Strength.STRONG) {
            return new MapMakerInternalMap(mapMaker, C4334a.Vp());
        }
        if (mapMaker.Va() == Strength.WEAK) {
            throw new IllegalArgumentException("Map cannot have both weak and dummy values");
        }
        throw new AssertionError();
    }

    static <K, V, E extends C4313g<K, V, E>> C4309v<K, V, E> unsetWeakValueReference() {
        return UNSET_WEAK_VALUE_REFERENCE;
    }

    static int rehash(int i) {
        int i2 = ((i << 15) ^ -12931) + i;
        i2 ^= i2 >>> 10;
        i2 += i2 << 3;
        i2 ^= i2 >>> 6;
        i2 += (i2 << 2) + (i2 << 14);
        return i2 ^ (i2 >>> 16);
    }

    E copyEntry(E e, E e2) {
        return segmentFor(e.Ve()).copyEntry(e, e2);
    }

    int hash(Object obj) {
        return rehash(this.keyEquivalence.hash(obj));
    }

    void reclaimValue(C4309v<K, V, E> c4309v) {
        C4313g Vd = c4309v.Vd();
        int Ve = Vd.Ve();
        segmentFor(Ve).reclaimValue(Vd.getKey(), Ve, c4309v);
    }

    void reclaimKey(E e) {
        int Ve = e.Ve();
        segmentFor(Ve).reclaimKey(e, Ve);
    }

    boolean isLiveForTesting(C4313g<K, V, ?> c4313g) {
        return segmentFor(c4313g.Ve()).getLiveValueForTesting(c4313g) != null;
    }

    Segment<K, V, E, S> segmentFor(int i) {
        return this.segments[(i >>> this.segmentShift) & this.segmentMask];
    }

    Segment<K, V, E, S> createSegment(int i, int i2) {
        return this.entryHelper.mo4532a(this, i, i2);
    }

    V getLiveValue(E e) {
        if (e.getKey() == null) {
            return null;
        }
        V value = e.getValue();
        if (value != null) {
            return value;
        }
        return null;
    }

    final Segment<K, V, E, S>[] newSegmentArray(int i) {
        return new Segment[i];
    }

    Strength keyStrength() {
        return this.entryHelper.keyStrength();
    }

    Strength valueStrength() {
        return this.entryHelper.valueStrength();
    }

    Equivalence<Object> valueEquivalence() {
        return this.entryHelper.valueStrength().defaultEquivalence();
    }

    public boolean isEmpty() {
        int i;
        Segment[] segmentArr = this.segments;
        long j = 0;
        for (i = 0; i < segmentArr.length; i++) {
            if (segmentArr[i].count != 0) {
                return false;
            }
            j += (long) segmentArr[i].modCount;
        }
        if (j != 0) {
            for (i = 0; i < segmentArr.length; i++) {
                if (segmentArr[i].count != 0) {
                    return false;
                }
                j -= (long) segmentArr[i].modCount;
            }
            if (j != 0) {
                return false;
            }
        }
        return true;
    }

    public int size() {
        long j = 0;
        for (Segment segment : this.segments) {
            j += (long) segment.count;
        }
        return Ints.aw(j);
    }

    public V get(Object obj) {
        if (obj == null) {
            return null;
        }
        int hash = hash(obj);
        return segmentFor(hash).get(obj, hash);
    }

    E getEntry(Object obj) {
        if (obj == null) {
            return null;
        }
        int hash = hash(obj);
        return segmentFor(hash).getEntry(obj, hash);
    }

    public boolean containsKey(Object obj) {
        if (obj == null) {
            return false;
        }
        int hash = hash(obj);
        return segmentFor(hash).containsKey(obj, hash);
    }

    public boolean containsValue(Object obj) {
        if (obj == null) {
            return false;
        }
        Segment[] segmentArr = this.segments;
        int i = 0;
        long j = -1;
        while (i < 3) {
            long j2 = 0;
            for (Segment segment : segmentArr) {
                int i2 = segment.count;
                AtomicReferenceArray atomicReferenceArray = segment.table;
                for (int i3 = 0; i3 < atomicReferenceArray.length(); i3++) {
                    for (C4313g c4313g = (C4313g) atomicReferenceArray.get(i3); c4313g != null; c4313g = c4313g.Vf()) {
                        Object liveValue = segment.getLiveValue(c4313g);
                        if (liveValue != null && valueEquivalence().equivalent(obj, liveValue)) {
                            return true;
                        }
                    }
                }
                j2 += (long) segment.modCount;
            }
            if (j2 == j) {
                break;
            }
            i++;
            j = j2;
        }
        return false;
    }

    public V put(K k, V v) {
        cco.ce(k);
        cco.ce(v);
        int hash = hash(k);
        return segmentFor(hash).put(k, hash, v, false);
    }

    public V putIfAbsent(K k, V v) {
        cco.ce(k);
        cco.ce(v);
        int hash = hash(k);
        return segmentFor(hash).put(k, hash, v, true);
    }

    public void putAll(Map<? extends K, ? extends V> map) {
        for (Entry entry : map.entrySet()) {
            put(entry.getKey(), entry.getValue());
        }
    }

    public V remove(Object obj) {
        if (obj == null) {
            return null;
        }
        int hash = hash(obj);
        return segmentFor(hash).remove(obj, hash);
    }

    public boolean remove(Object obj, Object obj2) {
        if (obj == null || obj2 == null) {
            return false;
        }
        int hash = hash(obj);
        return segmentFor(hash).remove(obj, hash, obj2);
    }

    public boolean replace(K k, V v, V v2) {
        cco.ce(k);
        cco.ce(v2);
        if (v == null) {
            return false;
        }
        int hash = hash(k);
        return segmentFor(hash).replace(k, hash, v, v2);
    }

    public V replace(K k, V v) {
        cco.ce(k);
        cco.ce(v);
        int hash = hash(k);
        return segmentFor(hash).replace(k, hash, v);
    }

    public void clear() {
        for (Segment clear : this.segments) {
            clear.clear();
        }
    }

    public Set<K> keySet() {
        Set<K> set = this.keySet;
        if (set != null) {
            return set;
        }
        set = new C4323j(this);
        this.keySet = set;
        return set;
    }

    public Collection<V> values() {
        Collection<V> collection = this.values;
        if (collection != null) {
            return collection;
        }
        collection = new C4333q(this);
        this.values = collection;
        return collection;
    }

    public Set<Entry<K, V>> entrySet() {
        Set<Entry<K, V>> set = this.entrySet;
        if (set != null) {
            return set;
        }
        set = new C4320e(this);
        this.entrySet = set;
        return set;
    }

    private static <E> ArrayList<E> m14451g(Collection<E> collection) {
        Collection arrayList = new ArrayList(collection.size());
        Iterators.m14361a(arrayList, collection.iterator());
        return arrayList;
    }

    Object writeReplace() {
        return new SerializationProxy(this.entryHelper.keyStrength(), this.entryHelper.valueStrength(), this.keyEquivalence, this.entryHelper.valueStrength().defaultEquivalence(), this.concurrencyLevel, this);
    }
}
