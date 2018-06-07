package com.fossil;

import com.google.common.collect.Iterators;
import com.google.common.collect.Maps;
import com.google.common.collect.Maps.b;
import com.google.common.collect.Multimaps;
import com.google.common.collect.Multimaps.a;
import com.google.common.collect.Sets;
import java.util.AbstractCollection;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public abstract class cct<K, V> implements cdi<K, V> {
    private transient Collection<Entry<K, V>> bMg;
    private transient cdj<K> bMh;
    private transient Map<K, Collection<V>> bMi;
    private transient Set<K> keySet;
    private transient Collection<V> values;

    class C1998a extends a<K, V> {
        final /* synthetic */ cct bMj;

        private C1998a(cct com_fossil_cct) {
            this.bMj = com_fossil_cct;
        }

        cdi<K, V> Ux() {
            return this.bMj;
        }

        public Iterator<Entry<K, V>> iterator() {
            return this.bMj.entryIterator();
        }
    }

    class C1999b extends C1998a implements Set<Entry<K, V>> {
        final /* synthetic */ cct bMj;

        private C1999b(cct com_fossil_cct) {
            this.bMj = com_fossil_cct;
            super();
        }

        public int hashCode() {
            return Sets.h(this);
        }

        public boolean equals(Object obj) {
            return Sets.b(this, obj);
        }
    }

    class C2000c extends AbstractCollection<V> {
        final /* synthetic */ cct bMj;

        C2000c(cct com_fossil_cct) {
            this.bMj = com_fossil_cct;
        }

        public Iterator<V> iterator() {
            return this.bMj.valueIterator();
        }

        public int size() {
            return this.bMj.size();
        }

        public boolean contains(Object obj) {
            return this.bMj.containsValue(obj);
        }

        public void clear() {
            this.bMj.clear();
        }
    }

    public abstract Map<K, Collection<V>> createAsMap();

    public abstract Iterator<Entry<K, V>> entryIterator();

    protected cct() {
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public boolean containsValue(Object obj) {
        for (Collection contains : asMap().values()) {
            if (contains.contains(obj)) {
                return true;
            }
        }
        return false;
    }

    public boolean containsEntry(Object obj, Object obj2) {
        Collection collection = (Collection) asMap().get(obj);
        return collection != null && collection.contains(obj2);
    }

    public boolean remove(Object obj, Object obj2) {
        Collection collection = (Collection) asMap().get(obj);
        return collection != null && collection.remove(obj2);
    }

    public boolean put(K k, V v) {
        return get(k).add(v);
    }

    public boolean putAll(K k, Iterable<? extends V> iterable) {
        cco.ce(iterable);
        if (iterable instanceof Collection) {
            Collection collection = (Collection) iterable;
            if (collection.isEmpty() || !get(k).addAll(collection)) {
                return false;
            }
            return true;
        }
        Iterator it = iterable.iterator();
        if (it.hasNext() && Iterators.a(get(k), it)) {
            return true;
        }
        return false;
    }

    public boolean putAll(cdi<? extends K, ? extends V> com_fossil_cdi__extends_K___extends_V) {
        boolean z = false;
        for (Entry entry : com_fossil_cdi__extends_K___extends_V.entries()) {
            z = put(entry.getKey(), entry.getValue()) | z;
        }
        return z;
    }

    public Collection<V> replaceValues(K k, Iterable<? extends V> iterable) {
        cco.ce(iterable);
        Collection<V> removeAll = removeAll(k);
        putAll(k, iterable);
        return removeAll;
    }

    public Collection<Entry<K, V>> entries() {
        Collection<Entry<K, V>> collection = this.bMg;
        if (collection != null) {
            return collection;
        }
        collection = createEntries();
        this.bMg = collection;
        return collection;
    }

    protected Collection<Entry<K, V>> createEntries() {
        if (this instanceof cdo) {
            return new C1999b();
        }
        return new C1998a();
    }

    public Set<K> keySet() {
        Set<K> set = this.keySet;
        if (set != null) {
            return set;
        }
        set = createKeySet();
        this.keySet = set;
        return set;
    }

    public Set<K> createKeySet() {
        return new b(asMap());
    }

    public cdj<K> keys() {
        cdj<K> com_fossil_cdj_K = this.bMh;
        if (com_fossil_cdj_K != null) {
            return com_fossil_cdj_K;
        }
        com_fossil_cdj_K = createKeys();
        this.bMh = com_fossil_cdj_K;
        return com_fossil_cdj_K;
    }

    protected cdj<K> createKeys() {
        return new Multimaps.b(this);
    }

    public Collection<V> values() {
        Collection<V> collection = this.values;
        if (collection != null) {
            return collection;
        }
        collection = createValues();
        this.values = collection;
        return collection;
    }

    protected Collection<V> createValues() {
        return new C2000c(this);
    }

    public Iterator<V> valueIterator() {
        return Maps.n(entries().iterator());
    }

    public Map<K, Collection<V>> asMap() {
        Map<K, Collection<V>> map = this.bMi;
        if (map != null) {
            return map;
        }
        map = createAsMap();
        this.bMi = map;
        return map;
    }

    public boolean equals(Object obj) {
        return Multimaps.a(this, obj);
    }

    public int hashCode() {
        return asMap().hashCode();
    }

    public String toString() {
        return asMap().toString();
    }
}
