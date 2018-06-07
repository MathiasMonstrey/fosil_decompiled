package com.google.gson.internal;

import com.j256.ormlite.stmt.query.SimpleComparison;
import java.io.ObjectStreamException;
import java.io.Serializable;
import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.Comparator;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map.Entry;
import java.util.NoSuchElementException;
import java.util.Set;

public final class LinkedTreeMap<K, V> extends AbstractMap<K, V> implements Serializable {
    static final /* synthetic */ boolean $assertionsDisabled = (!LinkedTreeMap.class.desiredAssertionStatus());
    private static final Comparator<Comparable> bRI = new C06821();
    Comparator<? super K> comparator;
    private C4397a entrySet;
    final C4400d<K, V> header;
    private C4399b keySet;
    int modCount;
    C4400d<K, V> root;
    int size;

    static class C06821 implements Comparator<Comparable> {
        C06821() {
        }

        public int compare(Comparable comparable, Comparable comparable2) {
            return comparable.compareTo(comparable2);
        }
    }

    abstract class C4395c<T> implements Iterator<T> {
        final /* synthetic */ LinkedTreeMap bRJ;
        C4400d<K, V> bRM = this.bRJ.header.bRM;
        C4400d<K, V> bRN = null;
        int bRO = this.bRJ.modCount;

        C4395c(LinkedTreeMap linkedTreeMap) {
            this.bRJ = linkedTreeMap;
        }

        public final boolean hasNext() {
            return this.bRM != this.bRJ.header;
        }

        final C4400d<K, V> WP() {
            C4400d<K, V> c4400d = this.bRM;
            if (c4400d == this.bRJ.header) {
                throw new NoSuchElementException();
            } else if (this.bRJ.modCount != this.bRO) {
                throw new ConcurrentModificationException();
            } else {
                this.bRM = c4400d.bRM;
                this.bRN = c4400d;
                return c4400d;
            }
        }

        public final void remove() {
            if (this.bRN == null) {
                throw new IllegalStateException();
            }
            this.bRJ.removeInternal(this.bRN, true);
            this.bRN = null;
            this.bRO = this.bRJ.modCount;
        }
    }

    class C4397a extends AbstractSet<Entry<K, V>> {
        final /* synthetic */ LinkedTreeMap bRJ;

        class C43961 extends C4395c<Entry<K, V>> {
            final /* synthetic */ C4397a bRK;

            C43961(C4397a c4397a) {
                this.bRK = c4397a;
                super(c4397a.bRJ);
            }

            public /* synthetic */ Object next() {
                return jv();
            }

            public Entry<K, V> jv() {
                return WP();
            }
        }

        C4397a(LinkedTreeMap linkedTreeMap) {
            this.bRJ = linkedTreeMap;
        }

        public int size() {
            return this.bRJ.size;
        }

        public Iterator<Entry<K, V>> iterator() {
            return new C43961(this);
        }

        public boolean contains(Object obj) {
            return (obj instanceof Entry) && this.bRJ.findByEntry((Entry) obj) != null;
        }

        public boolean remove(Object obj) {
            if (!(obj instanceof Entry)) {
                return false;
            }
            C4400d findByEntry = this.bRJ.findByEntry((Entry) obj);
            if (findByEntry == null) {
                return false;
            }
            this.bRJ.removeInternal(findByEntry, true);
            return true;
        }

        public void clear() {
            this.bRJ.clear();
        }
    }

    final class C4399b extends AbstractSet<K> {
        final /* synthetic */ LinkedTreeMap bRJ;

        class C43981 extends C4395c<K> {
            final /* synthetic */ C4399b bRL;

            C43981(C4399b c4399b) {
                this.bRL = c4399b;
                super(c4399b.bRJ);
            }

            public K next() {
                return WP().key;
            }
        }

        C4399b(LinkedTreeMap linkedTreeMap) {
            this.bRJ = linkedTreeMap;
        }

        public int size() {
            return this.bRJ.size;
        }

        public Iterator<K> iterator() {
            return new C43981(this);
        }

        public boolean contains(Object obj) {
            return this.bRJ.containsKey(obj);
        }

        public boolean remove(Object obj) {
            return this.bRJ.removeInternalByKey(obj) != null;
        }

        public void clear() {
            this.bRJ.clear();
        }
    }

    static final class C4400d<K, V> implements Entry<K, V> {
        C4400d<K, V> bRM;
        C4400d<K, V> bRP;
        C4400d<K, V> bRQ;
        C4400d<K, V> bRR;
        C4400d<K, V> bRS;
        int height;
        final K key;
        V value;

        C4400d() {
            this.key = null;
            this.bRS = this;
            this.bRM = this;
        }

        C4400d(C4400d<K, V> c4400d, K k, C4400d<K, V> c4400d2, C4400d<K, V> c4400d3) {
            this.bRP = c4400d;
            this.key = k;
            this.height = 1;
            this.bRM = c4400d2;
            this.bRS = c4400d3;
            c4400d3.bRM = this;
            c4400d2.bRS = this;
        }

        public K getKey() {
            return this.key;
        }

        public V getValue() {
            return this.value;
        }

        public V setValue(V v) {
            V v2 = this.value;
            this.value = v;
            return v2;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof Entry)) {
                return false;
            }
            Entry entry = (Entry) obj;
            if (this.key == null) {
                if (entry.getKey() != null) {
                    return false;
                }
            } else if (!this.key.equals(entry.getKey())) {
                return false;
            }
            if (this.value == null) {
                if (entry.getValue() != null) {
                    return false;
                }
            } else if (!this.value.equals(entry.getValue())) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            int i = 0;
            int hashCode = this.key == null ? 0 : this.key.hashCode();
            if (this.value != null) {
                i = this.value.hashCode();
            }
            return hashCode ^ i;
        }

        public String toString() {
            return this.key + SimpleComparison.EQUAL_TO_OPERATION + this.value;
        }

        public C4400d<K, V> WQ() {
            C4400d<K, V> c4400d;
            for (C4400d<K, V> c4400d2 = this.bRQ; c4400d2 != null; c4400d2 = c4400d2.bRQ) {
                c4400d = c4400d2;
            }
            return c4400d;
        }

        public C4400d<K, V> WR() {
            C4400d<K, V> c4400d;
            for (C4400d<K, V> c4400d2 = this.bRR; c4400d2 != null; c4400d2 = c4400d2.bRR) {
                c4400d = c4400d2;
            }
            return c4400d;
        }
    }

    public LinkedTreeMap() {
        this(bRI);
    }

    public LinkedTreeMap(Comparator<? super K> comparator) {
        this.size = 0;
        this.modCount = 0;
        this.header = new C4400d();
        if (comparator == null) {
            comparator = bRI;
        }
        this.comparator = comparator;
    }

    public int size() {
        return this.size;
    }

    public V get(Object obj) {
        C4400d findByObject = findByObject(obj);
        return findByObject != null ? findByObject.value : null;
    }

    public boolean containsKey(Object obj) {
        return findByObject(obj) != null;
    }

    public V put(K k, V v) {
        if (k == null) {
            throw new NullPointerException("key == null");
        }
        C4400d find = find(k, true);
        V v2 = find.value;
        find.value = v;
        return v2;
    }

    public void clear() {
        this.root = null;
        this.size = 0;
        this.modCount++;
        C4400d c4400d = this.header;
        c4400d.bRS = c4400d;
        c4400d.bRM = c4400d;
    }

    public V remove(Object obj) {
        C4400d removeInternalByKey = removeInternalByKey(obj);
        return removeInternalByKey != null ? removeInternalByKey.value : null;
    }

    C4400d<K, V> find(K k, boolean z) {
        int i;
        Comparator comparator = this.comparator;
        C4400d<K, V> c4400d = this.root;
        if (c4400d != null) {
            int compareTo;
            Comparable comparable = comparator == bRI ? (Comparable) k : null;
            while (true) {
                if (comparable != null) {
                    compareTo = comparable.compareTo(c4400d.key);
                } else {
                    compareTo = comparator.compare(k, c4400d.key);
                }
                if (compareTo == 0) {
                    return c4400d;
                }
                C4400d<K, V> c4400d2 = compareTo < 0 ? c4400d.bRQ : c4400d.bRR;
                if (c4400d2 == null) {
                    break;
                }
                c4400d = c4400d2;
            }
            int i2 = compareTo;
            C4400d c4400d3 = c4400d;
            i = i2;
        } else {
            C4400d<K, V> c4400d4 = c4400d;
            i = 0;
        }
        if (!z) {
            return null;
        }
        C4400d<K, V> c4400d5;
        C4400d c4400d6 = this.header;
        if (c4400d3 != null) {
            c4400d5 = new C4400d(c4400d3, k, c4400d6, c4400d6.bRS);
            if (i < 0) {
                c4400d3.bRQ = c4400d5;
            } else {
                c4400d3.bRR = c4400d5;
            }
            m14589a(c4400d3, true);
        } else if (comparator != bRI || (k instanceof Comparable)) {
            c4400d5 = new C4400d(c4400d3, k, c4400d6, c4400d6.bRS);
            this.root = c4400d5;
        } else {
            throw new ClassCastException(k.getClass().getName() + " is not Comparable");
        }
        this.size++;
        this.modCount++;
        return c4400d5;
    }

    C4400d<K, V> findByObject(Object obj) {
        C4400d<K, V> c4400d = null;
        if (obj != null) {
            try {
                c4400d = find(obj, false);
            } catch (ClassCastException e) {
            }
        }
        return c4400d;
    }

    C4400d<K, V> findByEntry(Entry<?, ?> entry) {
        C4400d<K, V> findByObject = findByObject(entry.getKey());
        Object obj = (findByObject == null || !equal(findByObject.value, entry.getValue())) ? null : 1;
        return obj != null ? findByObject : null;
    }

    private boolean equal(Object obj, Object obj2) {
        return obj == obj2 || (obj != null && obj.equals(obj2));
    }

    void removeInternal(C4400d<K, V> c4400d, boolean z) {
        int i = 0;
        if (z) {
            c4400d.bRS.bRM = c4400d.bRM;
            c4400d.bRM.bRS = c4400d.bRS;
        }
        C4400d c4400d2 = c4400d.bRQ;
        C4400d c4400d3 = c4400d.bRR;
        C4400d c4400d4 = c4400d.bRP;
        if (c4400d2 == null || c4400d3 == null) {
            if (c4400d2 != null) {
                m14588a((C4400d) c4400d, c4400d2);
                c4400d.bRQ = null;
            } else if (c4400d3 != null) {
                m14588a((C4400d) c4400d, c4400d3);
                c4400d.bRR = null;
            } else {
                m14588a((C4400d) c4400d, null);
            }
            m14589a(c4400d4, false);
            this.size--;
            this.modCount++;
            return;
        }
        int i2;
        c4400d2 = c4400d2.height > c4400d3.height ? c4400d2.WR() : c4400d3.WQ();
        removeInternal(c4400d2, false);
        c4400d4 = c4400d.bRQ;
        if (c4400d4 != null) {
            i2 = c4400d4.height;
            c4400d2.bRQ = c4400d4;
            c4400d4.bRP = c4400d2;
            c4400d.bRQ = null;
        } else {
            i2 = 0;
        }
        c4400d4 = c4400d.bRR;
        if (c4400d4 != null) {
            i = c4400d4.height;
            c4400d2.bRR = c4400d4;
            c4400d4.bRP = c4400d2;
            c4400d.bRR = null;
        }
        c4400d2.height = Math.max(i2, i) + 1;
        m14588a((C4400d) c4400d, c4400d2);
    }

    C4400d<K, V> removeInternalByKey(Object obj) {
        C4400d<K, V> findByObject = findByObject(obj);
        if (findByObject != null) {
            removeInternal(findByObject, true);
        }
        return findByObject;
    }

    private void m14588a(C4400d<K, V> c4400d, C4400d<K, V> c4400d2) {
        C4400d c4400d3 = c4400d.bRP;
        c4400d.bRP = null;
        if (c4400d2 != null) {
            c4400d2.bRP = c4400d3;
        }
        if (c4400d3 == null) {
            this.root = c4400d2;
        } else if (c4400d3.bRQ == c4400d) {
            c4400d3.bRQ = c4400d2;
        } else if ($assertionsDisabled || c4400d3.bRR == c4400d) {
            c4400d3.bRR = c4400d2;
        } else {
            throw new AssertionError();
        }
    }

    private void m14589a(C4400d<K, V> c4400d, boolean z) {
        while (c4400d != null) {
            int i;
            C4400d c4400d2 = c4400d.bRQ;
            C4400d c4400d3 = c4400d.bRR;
            int i2 = c4400d2 != null ? c4400d2.height : 0;
            if (c4400d3 != null) {
                i = c4400d3.height;
            } else {
                i = 0;
            }
            int i3 = i2 - i;
            C4400d c4400d4;
            if (i3 == -2) {
                c4400d2 = c4400d3.bRQ;
                c4400d4 = c4400d3.bRR;
                if (c4400d4 != null) {
                    i2 = c4400d4.height;
                } else {
                    i2 = 0;
                }
                if (c4400d2 != null) {
                    i = c4400d2.height;
                } else {
                    i = 0;
                }
                i -= i2;
                if (i == -1 || (i == 0 && !z)) {
                    m14587a(c4400d);
                } else if ($assertionsDisabled || i == 1) {
                    m14590b(c4400d3);
                    m14587a(c4400d);
                } else {
                    throw new AssertionError();
                }
                if (z) {
                    return;
                }
            } else if (i3 == 2) {
                c4400d3 = c4400d2.bRQ;
                c4400d4 = c4400d2.bRR;
                i2 = c4400d4 != null ? c4400d4.height : 0;
                if (c4400d3 != null) {
                    i = c4400d3.height;
                } else {
                    i = 0;
                }
                i -= i2;
                if (i == 1 || (i == 0 && !z)) {
                    m14590b(c4400d);
                } else if ($assertionsDisabled || i == -1) {
                    m14587a(c4400d2);
                    m14590b(c4400d);
                } else {
                    throw new AssertionError();
                }
                if (z) {
                    return;
                }
            } else if (i3 == 0) {
                c4400d.height = i2 + 1;
                if (z) {
                    return;
                }
            } else if ($assertionsDisabled || i3 == -1 || i3 == 1) {
                c4400d.height = Math.max(i2, i) + 1;
                if (!z) {
                    return;
                }
            } else {
                throw new AssertionError();
            }
            c4400d = c4400d.bRP;
        }
    }

    private void m14587a(C4400d<K, V> c4400d) {
        int i;
        int i2 = 0;
        C4400d c4400d2 = c4400d.bRQ;
        C4400d c4400d3 = c4400d.bRR;
        C4400d c4400d4 = c4400d3.bRQ;
        C4400d c4400d5 = c4400d3.bRR;
        c4400d.bRR = c4400d4;
        if (c4400d4 != null) {
            c4400d4.bRP = c4400d;
        }
        m14588a((C4400d) c4400d, c4400d3);
        c4400d3.bRQ = c4400d;
        c4400d.bRP = c4400d3;
        if (c4400d2 != null) {
            i = c4400d2.height;
        } else {
            i = 0;
        }
        c4400d.height = Math.max(i, c4400d4 != null ? c4400d4.height : 0) + 1;
        int i3 = c4400d.height;
        if (c4400d5 != null) {
            i2 = c4400d5.height;
        }
        c4400d3.height = Math.max(i3, i2) + 1;
    }

    private void m14590b(C4400d<K, V> c4400d) {
        int i;
        int i2 = 0;
        C4400d c4400d2 = c4400d.bRQ;
        C4400d c4400d3 = c4400d.bRR;
        C4400d c4400d4 = c4400d2.bRQ;
        C4400d c4400d5 = c4400d2.bRR;
        c4400d.bRQ = c4400d5;
        if (c4400d5 != null) {
            c4400d5.bRP = c4400d;
        }
        m14588a((C4400d) c4400d, c4400d2);
        c4400d2.bRR = c4400d;
        c4400d.bRP = c4400d2;
        if (c4400d3 != null) {
            i = c4400d3.height;
        } else {
            i = 0;
        }
        c4400d.height = Math.max(i, c4400d5 != null ? c4400d5.height : 0) + 1;
        int i3 = c4400d.height;
        if (c4400d4 != null) {
            i2 = c4400d4.height;
        }
        c4400d2.height = Math.max(i3, i2) + 1;
    }

    public Set<Entry<K, V>> entrySet() {
        Set set = this.entrySet;
        if (set != null) {
            return set;
        }
        Set<Entry<K, V>> c4397a = new C4397a(this);
        this.entrySet = c4397a;
        return c4397a;
    }

    public Set<K> keySet() {
        Set set = this.keySet;
        if (set != null) {
            return set;
        }
        Set<K> c4399b = new C4399b(this);
        this.keySet = c4399b;
        return c4399b;
    }

    private Object writeReplace() throws ObjectStreamException {
        return new LinkedHashMap(this);
    }
}
