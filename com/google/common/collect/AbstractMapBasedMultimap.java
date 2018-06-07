package com.google.common.collect;

import com.fossil.cco;
import com.fossil.cct;
import com.fossil.ccw;
import com.fossil.ccx;
import com.google.common.collect.AbstractMapBasedMultimap$i.a;
import com.google.common.collect.Maps.C4279a;
import com.google.common.collect.Maps.C4282d;
import com.google.common.collect.Maps.C4285b;
import java.io.Serializable;
import java.util.AbstractCollection;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.NavigableMap;
import java.util.NavigableSet;
import java.util.RandomAccess;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;

abstract class AbstractMapBasedMultimap<K, V> extends cct<K, V> implements Serializable {
    private static final long serialVersionUID = 2447537837011683357L;
    private transient int bLO;
    private transient Map<K, Collection<V>> map;

    abstract class C4275b<T> implements Iterator<T> {
        final /* synthetic */ AbstractMapBasedMultimap bLP;
        Collection<V> bLT = null;
        final Iterator<Entry<K, Collection<V>>> bLU;
        Iterator<V> bLV = Iterators.UT();
        K key = null;

        abstract T mo4468t(K k, V v);

        C4275b(AbstractMapBasedMultimap abstractMapBasedMultimap) {
            this.bLP = abstractMapBasedMultimap;
            this.bLU = abstractMapBasedMultimap.map.entrySet().iterator();
        }

        public boolean hasNext() {
            return this.bLU.hasNext() || this.bLV.hasNext();
        }

        public T next() {
            if (!this.bLV.hasNext()) {
                Entry entry = (Entry) this.bLU.next();
                this.key = entry.getKey();
                this.bLT = (Collection) entry.getValue();
                this.bLV = this.bLT.iterator();
            }
            return mo4468t(this.key, this.bLV.next());
        }

        public void remove() {
            this.bLV.remove();
            if (this.bLT.isEmpty()) {
                this.bLU.remove();
            }
            this.bLP.bLO = this.bLP.bLO - 1;
        }
    }

    class C42761 extends C4275b<V> {
        final /* synthetic */ AbstractMapBasedMultimap bLP;

        C42761(AbstractMapBasedMultimap abstractMapBasedMultimap) {
            this.bLP = abstractMapBasedMultimap;
            super(abstractMapBasedMultimap);
        }

        V mo4468t(K k, V v) {
            return v;
        }
    }

    class C42772 extends C4275b<Entry<K, V>> {
        final /* synthetic */ AbstractMapBasedMultimap bLP;

        C42772(AbstractMapBasedMultimap abstractMapBasedMultimap) {
            this.bLP = abstractMapBasedMultimap;
            super(abstractMapBasedMultimap);
        }

        /* synthetic */ Object mo4468t(Object obj, Object obj2) {
            return m14297u(obj, obj2);
        }

        Entry<K, V> m14297u(K k, V v) {
            return Maps.m14452B(k, v);
        }
    }

    class C4283a extends C4282d<K, Collection<V>> {
        final /* synthetic */ AbstractMapBasedMultimap bLP;
        final transient Map<K, Collection<V>> bLQ;

        class C4280a extends C4279a<K, Collection<V>> {
            final /* synthetic */ C4283a bLR;

            C4280a(C4283a c4283a) {
                this.bLR = c4283a;
            }

            Map<K, Collection<V>> Ug() {
                return this.bLR;
            }

            public Iterator<Entry<K, Collection<V>>> iterator() {
                return new C4281b(this.bLR);
            }

            public boolean contains(Object obj) {
                return ccx.a(this.bLR.bLQ.entrySet(), obj);
            }

            public boolean remove(Object obj) {
                if (!contains(obj)) {
                    return false;
                }
                this.bLR.bLP.ch(((Entry) obj).getKey());
                return true;
            }
        }

        class C4281b implements Iterator<Entry<K, Collection<V>>> {
            final /* synthetic */ C4283a bLR;
            final Iterator<Entry<K, Collection<V>>> bLS = this.bLR.bLQ.entrySet().iterator();
            Collection<V> bLT;

            C4281b(C4283a c4283a) {
                this.bLR = c4283a;
            }

            public /* synthetic */ Object next() {
                return jv();
            }

            public boolean hasNext() {
                return this.bLS.hasNext();
            }

            public Entry<K, Collection<V>> jv() {
                Entry entry = (Entry) this.bLS.next();
                this.bLT = (Collection) entry.getValue();
                return this.bLR.m14298b(entry);
            }

            public void remove() {
                this.bLS.remove();
                this.bLR.bLP.bLO = this.bLR.bLP.bLO - this.bLT.size();
                this.bLT.clear();
            }
        }

        public /* synthetic */ Object remove(Object obj) {
            return ci(obj);
        }

        C4283a(AbstractMapBasedMultimap abstractMapBasedMultimap, Map<K, Collection<V>> map) {
            this.bLP = abstractMapBasedMultimap;
            this.bLQ = map;
        }

        protected Set<Entry<K, Collection<V>>> Uf() {
            return new C4280a(this);
        }

        public boolean containsKey(Object obj) {
            return Maps.m14455b(this.bLQ, obj);
        }

        public Collection<V> get(Object obj) {
            Collection collection = (Collection) Maps.m14453a(this.bLQ, obj);
            if (collection == null) {
                return null;
            }
            return this.bLP.wrapCollection(obj, collection);
        }

        public Set<K> keySet() {
            return this.bLP.keySet();
        }

        public int size() {
            return this.bLQ.size();
        }

        public Collection<V> ci(Object obj) {
            Collection collection = (Collection) this.bLQ.remove(obj);
            if (collection == null) {
                return null;
            }
            Collection<V> createCollection = this.bLP.createCollection();
            createCollection.addAll(collection);
            this.bLP.bLO = this.bLP.bLO - collection.size();
            collection.clear();
            return createCollection;
        }

        public boolean equals(Object obj) {
            return this == obj || this.bLQ.equals(obj);
        }

        public int hashCode() {
            return this.bLQ.hashCode();
        }

        public String toString() {
            return this.bLQ.toString();
        }

        public void clear() {
            if (this.bLQ == this.bLP.map) {
                this.bLP.clear();
            } else {
                Iterators.m14370k(new C4281b(this));
            }
        }

        Entry<K, Collection<V>> m14298b(Entry<K, Collection<V>> entry) {
            Object key = entry.getKey();
            return Maps.m14452B(key, this.bLP.wrapCollection(key, (Collection) entry.getValue()));
        }
    }

    class C4286c extends C4285b<K, Collection<V>> {
        final /* synthetic */ AbstractMapBasedMultimap bLP;

        C4286c(AbstractMapBasedMultimap abstractMapBasedMultimap, Map<K, Collection<V>> map) {
            this.bLP = abstractMapBasedMultimap;
            super(map);
        }

        public Iterator<K> iterator() {
            final Iterator it = Ug().entrySet().iterator();
            return new Iterator<K>(this) {
                Entry<K, Collection<V>> bLW;
                final /* synthetic */ C4286c bLY;

                public boolean hasNext() {
                    return it.hasNext();
                }

                public K next() {
                    this.bLW = (Entry) it.next();
                    return this.bLW.getKey();
                }

                public void remove() {
                    ccw.bB(this.bLW != null);
                    Collection collection = (Collection) this.bLW.getValue();
                    it.remove();
                    this.bLY.bLP.bLO = this.bLY.bLP.bLO - collection.size();
                    collection.clear();
                }
            };
        }

        public boolean remove(Object obj) {
            int i;
            Collection collection = (Collection) Ug().remove(obj);
            if (collection != null) {
                int size = collection.size();
                collection.clear();
                this.bLP.bLO = this.bLP.bLO - size;
                i = size;
            } else {
                i = 0;
            }
            return i > 0;
        }

        public void clear() {
            Iterators.m14370k(iterator());
        }

        public boolean containsAll(Collection<?> collection) {
            return Ug().keySet().containsAll(collection);
        }

        public boolean equals(Object obj) {
            return this == obj || Ug().keySet().equals(obj);
        }

        public int hashCode() {
            return Ug().keySet().hashCode();
        }
    }

    class C4287g extends C4283a implements SortedMap<K, Collection<V>> {
        final /* synthetic */ AbstractMapBasedMultimap bLP;
        SortedSet<K> bLZ;

        /* synthetic */ Set createKeySet() {
            return Uj();
        }

        public /* synthetic */ Set keySet() {
            return Uk();
        }

        C4287g(AbstractMapBasedMultimap abstractMapBasedMultimap, SortedMap<K, Collection<V>> sortedMap) {
            this.bLP = abstractMapBasedMultimap;
            super(abstractMapBasedMultimap, sortedMap);
        }

        SortedMap<K, Collection<V>> Ul() {
            return (SortedMap) this.bLQ;
        }

        public Comparator<? super K> comparator() {
            return Ul().comparator();
        }

        public K firstKey() {
            return Ul().firstKey();
        }

        public K lastKey() {
            return Ul().lastKey();
        }

        public SortedMap<K, Collection<V>> headMap(K k) {
            return new C4287g(this.bLP, Ul().headMap(k));
        }

        public SortedMap<K, Collection<V>> subMap(K k, K k2) {
            return new C4287g(this.bLP, Ul().subMap(k, k2));
        }

        public SortedMap<K, Collection<V>> tailMap(K k) {
            return new C4287g(this.bLP, Ul().tailMap(k));
        }

        public SortedSet<K> Uk() {
            SortedSet<K> sortedSet = this.bLZ;
            if (sortedSet != null) {
                return sortedSet;
            }
            sortedSet = Uj();
            this.bLZ = sortedSet;
            return sortedSet;
        }

        SortedSet<K> Uj() {
            return new C4289h(this.bLP, Ul());
        }
    }

    class C4288d extends C4287g implements NavigableMap<K, Collection<V>> {
        final /* synthetic */ AbstractMapBasedMultimap bLP;

        /* synthetic */ SortedSet Uj() {
            return Ui();
        }

        public /* synthetic */ SortedSet Uk() {
            return keySet();
        }

        /* synthetic */ SortedMap Ul() {
            return Uh();
        }

        /* synthetic */ Set createKeySet() {
            return Ui();
        }

        public /* synthetic */ SortedMap headMap(Object obj) {
            return cj(obj);
        }

        public /* synthetic */ SortedMap subMap(Object obj, Object obj2) {
            return m14300v(obj, obj2);
        }

        public /* synthetic */ SortedMap tailMap(Object obj) {
            return ck(obj);
        }

        C4288d(AbstractMapBasedMultimap abstractMapBasedMultimap, NavigableMap<K, Collection<V>> navigableMap) {
            this.bLP = abstractMapBasedMultimap;
            super(abstractMapBasedMultimap, navigableMap);
        }

        NavigableMap<K, Collection<V>> Uh() {
            return (NavigableMap) super.Ul();
        }

        public Entry<K, Collection<V>> lowerEntry(K k) {
            Entry lowerEntry = Uh().lowerEntry(k);
            return lowerEntry == null ? null : m14298b(lowerEntry);
        }

        public K lowerKey(K k) {
            return Uh().lowerKey(k);
        }

        public Entry<K, Collection<V>> floorEntry(K k) {
            Entry floorEntry = Uh().floorEntry(k);
            return floorEntry == null ? null : m14298b(floorEntry);
        }

        public K floorKey(K k) {
            return Uh().floorKey(k);
        }

        public Entry<K, Collection<V>> ceilingEntry(K k) {
            Entry ceilingEntry = Uh().ceilingEntry(k);
            return ceilingEntry == null ? null : m14298b(ceilingEntry);
        }

        public K ceilingKey(K k) {
            return Uh().ceilingKey(k);
        }

        public Entry<K, Collection<V>> higherEntry(K k) {
            Entry higherEntry = Uh().higherEntry(k);
            return higherEntry == null ? null : m14298b(higherEntry);
        }

        public K higherKey(K k) {
            return Uh().higherKey(k);
        }

        public Entry<K, Collection<V>> firstEntry() {
            Entry firstEntry = Uh().firstEntry();
            return firstEntry == null ? null : m14298b(firstEntry);
        }

        public Entry<K, Collection<V>> lastEntry() {
            Entry lastEntry = Uh().lastEntry();
            return lastEntry == null ? null : m14298b(lastEntry);
        }

        public Entry<K, Collection<V>> pollFirstEntry() {
            return m14299b(entrySet().iterator());
        }

        public Entry<K, Collection<V>> pollLastEntry() {
            return m14299b(descendingMap().entrySet().iterator());
        }

        Entry<K, Collection<V>> m14299b(Iterator<Entry<K, Collection<V>>> it) {
            if (!it.hasNext()) {
                return null;
            }
            Entry entry = (Entry) it.next();
            Collection createCollection = this.bLP.createCollection();
            createCollection.addAll((Collection) entry.getValue());
            it.remove();
            return Maps.m14452B(entry.getKey(), AbstractMapBasedMultimap.unmodifiableCollectionSubclass(createCollection));
        }

        public NavigableMap<K, Collection<V>> descendingMap() {
            return new C4288d(this.bLP, Uh().descendingMap());
        }

        public NavigableSet<K> keySet() {
            return (NavigableSet) super.Uk();
        }

        NavigableSet<K> Ui() {
            return new C4290e(this.bLP, Uh());
        }

        public NavigableSet<K> navigableKeySet() {
            return keySet();
        }

        public NavigableSet<K> descendingKeySet() {
            return descendingMap().navigableKeySet();
        }

        public NavigableMap<K, Collection<V>> m14300v(K k, K k2) {
            return subMap(k, true, k2, false);
        }

        public NavigableMap<K, Collection<V>> subMap(K k, boolean z, K k2, boolean z2) {
            return new C4288d(this.bLP, Uh().subMap(k, z, k2, z2));
        }

        public NavigableMap<K, Collection<V>> cj(K k) {
            return headMap(k, false);
        }

        public NavigableMap<K, Collection<V>> headMap(K k, boolean z) {
            return new C4288d(this.bLP, Uh().headMap(k, z));
        }

        public NavigableMap<K, Collection<V>> ck(K k) {
            return tailMap(k, true);
        }

        public NavigableMap<K, Collection<V>> tailMap(K k, boolean z) {
            return new C4288d(this.bLP, Uh().tailMap(k, z));
        }
    }

    class C4289h extends C4286c implements SortedSet<K> {
        final /* synthetic */ AbstractMapBasedMultimap bLP;

        C4289h(AbstractMapBasedMultimap abstractMapBasedMultimap, SortedMap<K, Collection<V>> sortedMap) {
            this.bLP = abstractMapBasedMultimap;
            super(abstractMapBasedMultimap, sortedMap);
        }

        SortedMap<K, Collection<V>> Ul() {
            return (SortedMap) super.Ug();
        }

        public Comparator<? super K> comparator() {
            return Ul().comparator();
        }

        public K first() {
            return Ul().firstKey();
        }

        public SortedSet<K> headSet(K k) {
            return new C4289h(this.bLP, Ul().headMap(k));
        }

        public K last() {
            return Ul().lastKey();
        }

        public SortedSet<K> subSet(K k, K k2) {
            return new C4289h(this.bLP, Ul().subMap(k, k2));
        }

        public SortedSet<K> tailSet(K k) {
            return new C4289h(this.bLP, Ul().tailMap(k));
        }
    }

    class C4290e extends C4289h implements NavigableSet<K> {
        final /* synthetic */ AbstractMapBasedMultimap bLP;

        /* synthetic */ SortedMap Ul() {
            return Uh();
        }

        C4290e(AbstractMapBasedMultimap abstractMapBasedMultimap, NavigableMap<K, Collection<V>> navigableMap) {
            this.bLP = abstractMapBasedMultimap;
            super(abstractMapBasedMultimap, navigableMap);
        }

        NavigableMap<K, Collection<V>> Uh() {
            return (NavigableMap) super.Ul();
        }

        public K lower(K k) {
            return Uh().lowerKey(k);
        }

        public K floor(K k) {
            return Uh().floorKey(k);
        }

        public K ceiling(K k) {
            return Uh().ceilingKey(k);
        }

        public K higher(K k) {
            return Uh().higherKey(k);
        }

        public K pollFirst() {
            return Iterators.m14369j(iterator());
        }

        public K pollLast() {
            return Iterators.m14369j(descendingIterator());
        }

        public NavigableSet<K> descendingSet() {
            return new C4290e(this.bLP, Uh().descendingMap());
        }

        public Iterator<K> descendingIterator() {
            return descendingSet().iterator();
        }

        public NavigableSet<K> headSet(K k) {
            return headSet(k, false);
        }

        public NavigableSet<K> headSet(K k, boolean z) {
            return new C4290e(this.bLP, Uh().headMap(k, z));
        }

        public NavigableSet<K> subSet(K k, K k2) {
            return subSet(k, true, k2, false);
        }

        public NavigableSet<K> subSet(K k, boolean z, K k2, boolean z2) {
            return new C4290e(this.bLP, Uh().subMap(k, z, k2, z2));
        }

        public NavigableSet<K> tailSet(K k) {
            return tailSet(k, true);
        }

        public NavigableSet<K> tailSet(K k, boolean z) {
            return new C4290e(this.bLP, Uh().tailMap(k, z));
        }
    }

    class C4291i extends AbstractCollection<V> {
        final /* synthetic */ AbstractMapBasedMultimap bLP;
        Collection<V> bMa;
        final C4291i bMb;
        final Collection<V> bMc;
        final K key;

        class C4294a implements Iterator<V> {
            final Iterator<V> bLS;
            final Collection<V> bMd = this.bMe.bMa;
            final /* synthetic */ C4291i bMe;

            C4294a(C4291i c4291i) {
                this.bMe = c4291i;
                this.bLS = AbstractMapBasedMultimap.m14293e(c4291i.bMa);
            }

            C4294a(C4291i c4291i, Iterator<V> it) {
                this.bMe = c4291i;
                this.bLS = it;
            }

            void Ur() {
                this.bMe.Um();
                if (this.bMe.bMa != this.bMd) {
                    throw new ConcurrentModificationException();
                }
            }

            public boolean hasNext() {
                Ur();
                return this.bLS.hasNext();
            }

            public V next() {
                Ur();
                return this.bLS.next();
            }

            public void remove() {
                this.bLS.remove();
                this.bMe.bLP.bLO = this.bMe.bLP.bLO - 1;
                this.bMe.Un();
            }

            Iterator<V> Us() {
                Ur();
                return this.bLS;
            }
        }

        C4291i(AbstractMapBasedMultimap abstractMapBasedMultimap, K k, Collection<V> collection, C4291i c4291i) {
            this.bLP = abstractMapBasedMultimap;
            this.key = k;
            this.bMa = collection;
            this.bMb = c4291i;
            this.bMc = c4291i == null ? null : c4291i.Up();
        }

        void Um() {
            if (this.bMb != null) {
                this.bMb.Um();
                if (this.bMb.Up() != this.bMc) {
                    throw new ConcurrentModificationException();
                }
            } else if (this.bMa.isEmpty()) {
                Collection collection = (Collection) this.bLP.map.get(this.key);
                if (collection != null) {
                    this.bMa = collection;
                }
            }
        }

        void Un() {
            if (this.bMb != null) {
                this.bMb.Un();
            } else if (this.bMa.isEmpty()) {
                this.bLP.map.remove(this.key);
            }
        }

        K getKey() {
            return this.key;
        }

        void Uo() {
            if (this.bMb != null) {
                this.bMb.Uo();
            } else {
                this.bLP.map.put(this.key, this.bMa);
            }
        }

        public int size() {
            Um();
            return this.bMa.size();
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            Um();
            return this.bMa.equals(obj);
        }

        public int hashCode() {
            Um();
            return this.bMa.hashCode();
        }

        public String toString() {
            Um();
            return this.bMa.toString();
        }

        Collection<V> Up() {
            return this.bMa;
        }

        public Iterator<V> iterator() {
            Um();
            return new C4294a(this);
        }

        public boolean add(V v) {
            Um();
            boolean isEmpty = this.bMa.isEmpty();
            boolean add = this.bMa.add(v);
            if (add) {
                this.bLP.bLO = this.bLP.bLO + 1;
                if (isEmpty) {
                    Uo();
                }
            }
            return add;
        }

        C4291i Uq() {
            return this.bMb;
        }

        public boolean addAll(Collection<? extends V> collection) {
            if (collection.isEmpty()) {
                return false;
            }
            int size = size();
            boolean addAll = this.bMa.addAll(collection);
            if (!addAll) {
                return addAll;
            }
            this.bLP.bLO = (this.bMa.size() - size) + this.bLP.bLO;
            if (size != 0) {
                return addAll;
            }
            Uo();
            return addAll;
        }

        public boolean contains(Object obj) {
            Um();
            return this.bMa.contains(obj);
        }

        public boolean containsAll(Collection<?> collection) {
            Um();
            return this.bMa.containsAll(collection);
        }

        public void clear() {
            int size = size();
            if (size != 0) {
                this.bMa.clear();
                this.bLP.bLO = this.bLP.bLO - size;
                Un();
            }
        }

        public boolean remove(Object obj) {
            Um();
            boolean remove = this.bMa.remove(obj);
            if (remove) {
                this.bLP.bLO = this.bLP.bLO - 1;
                Un();
            }
            return remove;
        }

        public boolean removeAll(Collection<?> collection) {
            if (collection.isEmpty()) {
                return false;
            }
            int size = size();
            boolean removeAll = this.bMa.removeAll(collection);
            if (!removeAll) {
                return removeAll;
            }
            this.bLP.bLO = (this.bMa.size() - size) + this.bLP.bLO;
            Un();
            return removeAll;
        }

        public boolean retainAll(Collection<?> collection) {
            cco.ce(collection);
            int size = size();
            boolean retainAll = this.bMa.retainAll(collection);
            if (retainAll) {
                this.bLP.bLO = (this.bMa.size() - size) + this.bLP.bLO;
                Un();
            }
            return retainAll;
        }
    }

    class C4292j extends C4291i implements List<V> {
        final /* synthetic */ AbstractMapBasedMultimap bLP;

        class C4295a extends a implements ListIterator<V> {
            final /* synthetic */ C4292j bMf;

            C4295a(C4292j c4292j) {
                this.bMf = c4292j;
                super(c4292j);
            }

            public C4295a(C4292j c4292j, int i) {
                this.bMf = c4292j;
                super(c4292j, c4292j.Ut().listIterator(i));
            }

            private ListIterator<V> Uu() {
                return (ListIterator) Us();
            }

            public boolean hasPrevious() {
                return Uu().hasPrevious();
            }

            public V previous() {
                return Uu().previous();
            }

            public int nextIndex() {
                return Uu().nextIndex();
            }

            public int previousIndex() {
                return Uu().previousIndex();
            }

            public void set(V v) {
                Uu().set(v);
            }

            public void add(V v) {
                boolean isEmpty = this.bMf.isEmpty();
                Uu().add(v);
                this.bMf.bLP.bLO = this.bMf.bLP.bLO + 1;
                if (isEmpty) {
                    this.bMf.Uo();
                }
            }
        }

        C4292j(AbstractMapBasedMultimap abstractMapBasedMultimap, K k, List<V> list, C4291i c4291i) {
            this.bLP = abstractMapBasedMultimap;
            super(abstractMapBasedMultimap, k, list, c4291i);
        }

        List<V> Ut() {
            return (List) Up();
        }

        public boolean addAll(int i, Collection<? extends V> collection) {
            if (collection.isEmpty()) {
                return false;
            }
            int size = size();
            boolean addAll = Ut().addAll(i, collection);
            if (!addAll) {
                return addAll;
            }
            this.bLP.bLO = (Up().size() - size) + this.bLP.bLO;
            if (size != 0) {
                return addAll;
            }
            Uo();
            return addAll;
        }

        public V get(int i) {
            Um();
            return Ut().get(i);
        }

        public V set(int i, V v) {
            Um();
            return Ut().set(i, v);
        }

        public void add(int i, V v) {
            Um();
            boolean isEmpty = Up().isEmpty();
            Ut().add(i, v);
            this.bLP.bLO = this.bLP.bLO + 1;
            if (isEmpty) {
                Uo();
            }
        }

        public V remove(int i) {
            Um();
            V remove = Ut().remove(i);
            this.bLP.bLO = this.bLP.bLO - 1;
            Un();
            return remove;
        }

        public int indexOf(Object obj) {
            Um();
            return Ut().indexOf(obj);
        }

        public int lastIndexOf(Object obj) {
            Um();
            return Ut().lastIndexOf(obj);
        }

        public ListIterator<V> listIterator() {
            Um();
            return new C4295a(this);
        }

        public ListIterator<V> listIterator(int i) {
            Um();
            return new C4295a(this, i);
        }

        public List<V> subList(int i, int i2) {
            C4291i Uq;
            Um();
            AbstractMapBasedMultimap abstractMapBasedMultimap = this.bLP;
            Object key = getKey();
            List subList = Ut().subList(i, i2);
            if (Uq() != null) {
                Uq = Uq();
            }
            return abstractMapBasedMultimap.m14292a(key, subList, Uq);
        }
    }

    class C4293f extends C4292j implements RandomAccess {
        final /* synthetic */ AbstractMapBasedMultimap bLP;

        C4293f(AbstractMapBasedMultimap abstractMapBasedMultimap, K k, List<V> list, C4291i c4291i) {
            this.bLP = abstractMapBasedMultimap;
            super(abstractMapBasedMultimap, k, list, c4291i);
        }
    }

    class C4296m extends C4291i implements SortedSet<V> {
        final /* synthetic */ AbstractMapBasedMultimap bLP;

        C4296m(AbstractMapBasedMultimap abstractMapBasedMultimap, K k, SortedSet<V> sortedSet, C4291i c4291i) {
            this.bLP = abstractMapBasedMultimap;
            super(abstractMapBasedMultimap, k, sortedSet, c4291i);
        }

        SortedSet<V> Uw() {
            return (SortedSet) Up();
        }

        public Comparator<? super V> comparator() {
            return Uw().comparator();
        }

        public V first() {
            Um();
            return Uw().first();
        }

        public V last() {
            Um();
            return Uw().last();
        }

        public SortedSet<V> headSet(V v) {
            C4291i Uq;
            Um();
            AbstractMapBasedMultimap abstractMapBasedMultimap = this.bLP;
            Object key = getKey();
            SortedSet headSet = Uw().headSet(v);
            if (Uq() != null) {
                Uq = Uq();
            }
            return new C4296m(abstractMapBasedMultimap, key, headSet, Uq);
        }

        public SortedSet<V> subSet(V v, V v2) {
            C4291i Uq;
            Um();
            AbstractMapBasedMultimap abstractMapBasedMultimap = this.bLP;
            Object key = getKey();
            SortedSet subSet = Uw().subSet(v, v2);
            if (Uq() != null) {
                Uq = Uq();
            }
            return new C4296m(abstractMapBasedMultimap, key, subSet, Uq);
        }

        public SortedSet<V> tailSet(V v) {
            C4291i Uq;
            Um();
            AbstractMapBasedMultimap abstractMapBasedMultimap = this.bLP;
            Object key = getKey();
            SortedSet tailSet = Uw().tailSet(v);
            if (Uq() != null) {
                Uq = Uq();
            }
            return new C4296m(abstractMapBasedMultimap, key, tailSet, Uq);
        }
    }

    class C4297k extends C4296m implements NavigableSet<V> {
        final /* synthetic */ AbstractMapBasedMultimap bLP;

        /* synthetic */ SortedSet Uw() {
            return Uv();
        }

        C4297k(AbstractMapBasedMultimap abstractMapBasedMultimap, K k, NavigableSet<V> navigableSet, C4291i c4291i) {
            this.bLP = abstractMapBasedMultimap;
            super(abstractMapBasedMultimap, k, navigableSet, c4291i);
        }

        NavigableSet<V> Uv() {
            return (NavigableSet) super.Uw();
        }

        public V lower(V v) {
            return Uv().lower(v);
        }

        public V floor(V v) {
            return Uv().floor(v);
        }

        public V ceiling(V v) {
            return Uv().ceiling(v);
        }

        public V higher(V v) {
            return Uv().higher(v);
        }

        public V pollFirst() {
            return Iterators.m14369j(iterator());
        }

        public V pollLast() {
            return Iterators.m14369j(descendingIterator());
        }

        private NavigableSet<V> m14301a(NavigableSet<V> navigableSet) {
            C4291i Uq;
            AbstractMapBasedMultimap abstractMapBasedMultimap = this.bLP;
            Object obj = this.key;
            if (Uq() != null) {
                Uq = Uq();
            }
            return new C4297k(abstractMapBasedMultimap, obj, navigableSet, Uq);
        }

        public NavigableSet<V> descendingSet() {
            return m14301a(Uv().descendingSet());
        }

        public Iterator<V> descendingIterator() {
            return new C4294a(this, Uv().descendingIterator());
        }

        public NavigableSet<V> subSet(V v, boolean z, V v2, boolean z2) {
            return m14301a(Uv().subSet(v, z, v2, z2));
        }

        public NavigableSet<V> headSet(V v, boolean z) {
            return m14301a(Uv().headSet(v, z));
        }

        public NavigableSet<V> tailSet(V v, boolean z) {
            return m14301a(Uv().tailSet(v, z));
        }
    }

    class C4298l extends C4291i implements Set<V> {
        final /* synthetic */ AbstractMapBasedMultimap bLP;

        C4298l(AbstractMapBasedMultimap abstractMapBasedMultimap, K k, Set<V> set) {
            this.bLP = abstractMapBasedMultimap;
            super(abstractMapBasedMultimap, k, set, null);
        }

        public boolean removeAll(Collection<?> collection) {
            if (collection.isEmpty()) {
                return false;
            }
            int size = size();
            boolean a = Sets.m14480a((Set) this.bMa, (Collection) collection);
            if (!a) {
                return a;
            }
            this.bLP.bLO = (this.bMa.size() - size) + this.bLP.bLO;
            Un();
            return a;
        }
    }

    abstract Collection<V> createCollection();

    protected AbstractMapBasedMultimap(Map<K, Collection<V>> map) {
        cco.bz(map.isEmpty());
        this.map = map;
    }

    final void setMap(Map<K, Collection<V>> map) {
        this.map = map;
        this.bLO = 0;
        for (Collection collection : map.values()) {
            boolean z;
            if (collection.isEmpty()) {
                z = false;
            } else {
                z = true;
            }
            cco.bz(z);
            this.bLO = collection.size() + this.bLO;
        }
    }

    Collection<V> createUnmodifiableEmptyCollection() {
        return unmodifiableCollectionSubclass(createCollection());
    }

    Collection<V> createCollection(K k) {
        return createCollection();
    }

    Map<K, Collection<V>> backingMap() {
        return this.map;
    }

    public int size() {
        return this.bLO;
    }

    public boolean containsKey(Object obj) {
        return this.map.containsKey(obj);
    }

    public boolean put(K k, V v) {
        Collection collection = (Collection) this.map.get(k);
        if (collection == null) {
            collection = createCollection(k);
            if (collection.add(v)) {
                this.bLO++;
                this.map.put(k, collection);
                return true;
            }
            throw new AssertionError("New Collection violated the Collection spec");
        } else if (!collection.add(v)) {
            return false;
        } else {
            this.bLO++;
            return true;
        }
    }

    private Collection<V> cg(K k) {
        Collection<V> collection = (Collection) this.map.get(k);
        if (collection != null) {
            return collection;
        }
        collection = createCollection(k);
        this.map.put(k, collection);
        return collection;
    }

    public Collection<V> replaceValues(K k, Iterable<? extends V> iterable) {
        Iterator it = iterable.iterator();
        if (!it.hasNext()) {
            return removeAll(k);
        }
        Collection cg = cg(k);
        Collection createCollection = createCollection();
        createCollection.addAll(cg);
        this.bLO -= cg.size();
        cg.clear();
        while (it.hasNext()) {
            if (cg.add(it.next())) {
                this.bLO++;
            }
        }
        return unmodifiableCollectionSubclass(createCollection);
    }

    public Collection<V> removeAll(Object obj) {
        Collection collection = (Collection) this.map.remove(obj);
        if (collection == null) {
            return createUnmodifiableEmptyCollection();
        }
        Collection createCollection = createCollection();
        createCollection.addAll(collection);
        this.bLO -= collection.size();
        collection.clear();
        return unmodifiableCollectionSubclass(createCollection);
    }

    static <E> Collection<E> unmodifiableCollectionSubclass(Collection<E> collection) {
        if (collection instanceof NavigableSet) {
            return Sets.m14482b((NavigableSet) collection);
        }
        if (collection instanceof SortedSet) {
            return Collections.unmodifiableSortedSet((SortedSet) collection);
        }
        if (collection instanceof Set) {
            return Collections.unmodifiableSet((Set) collection);
        }
        if (collection instanceof List) {
            return Collections.unmodifiableList((List) collection);
        }
        return Collections.unmodifiableCollection(collection);
    }

    public void clear() {
        for (Collection clear : this.map.values()) {
            clear.clear();
        }
        this.map.clear();
        this.bLO = 0;
    }

    public Collection<V> get(K k) {
        Collection collection = (Collection) this.map.get(k);
        if (collection == null) {
            collection = createCollection(k);
        }
        return wrapCollection(k, collection);
    }

    Collection<V> wrapCollection(K k, Collection<V> collection) {
        if (collection instanceof NavigableSet) {
            return new C4297k(this, k, (NavigableSet) collection, null);
        }
        if (collection instanceof SortedSet) {
            return new C4296m(this, k, (SortedSet) collection, null);
        }
        if (collection instanceof Set) {
            return new C4298l(this, k, (Set) collection);
        }
        if (collection instanceof List) {
            return m14292a(k, (List) collection, null);
        }
        return new C4291i(this, k, collection, null);
    }

    private List<V> m14292a(K k, List<V> list, C4291i c4291i) {
        return list instanceof RandomAccess ? new C4293f(this, k, list, c4291i) : new C4292j(this, k, list, c4291i);
    }

    private static <E> Iterator<E> m14293e(Collection<E> collection) {
        if (collection instanceof List) {
            return ((List) collection).listIterator();
        }
        return collection.iterator();
    }

    Set<K> createKeySet() {
        if (this.map instanceof NavigableMap) {
            return new C4290e(this, (NavigableMap) this.map);
        }
        if (this.map instanceof SortedMap) {
            return new C4289h(this, (SortedMap) this.map);
        }
        return new C4286c(this, this.map);
    }

    private void ch(Object obj) {
        Collection collection = (Collection) Maps.m14456c(this.map, obj);
        if (collection != null) {
            int size = collection.size();
            collection.clear();
            this.bLO -= size;
        }
    }

    public Collection<V> values() {
        return super.values();
    }

    Iterator<V> valueIterator() {
        return new C42761(this);
    }

    public Collection<Entry<K, V>> entries() {
        return super.entries();
    }

    Iterator<Entry<K, V>> entryIterator() {
        return new C42772(this);
    }

    Map<K, Collection<V>> createAsMap() {
        if (this.map instanceof NavigableMap) {
            return new C4288d(this, (NavigableMap) this.map);
        }
        if (this.map instanceof SortedMap) {
            return new C4287g(this, (SortedMap) this.map);
        }
        return new C4283a(this, this.map);
    }
}
