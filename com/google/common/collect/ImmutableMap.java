package com.google.common.collect;

import com.fossil.ccw;
import com.fossil.cdt;
import java.io.Serializable;
import java.util.AbstractMap.SimpleImmutableEntry;
import java.util.Collection;
import java.util.Map;
import java.util.Map.Entry;
import java.util.SortedMap;

public abstract class ImmutableMap<K, V> implements Serializable, Map<K, V> {
    static final Entry<?, ?>[] EMPTY_ENTRY_ARRAY = new Entry[0];
    private transient ImmutableSet<Entry<K, V>> bMw;
    private transient ImmutableSet<K> bMx;
    private transient ImmutableCollection<V> bMy;
    private transient ImmutableSetMultimap<K, V> bMz;

    abstract ImmutableSet<Entry<K, V>> createEntrySet();

    abstract ImmutableSet<K> createKeySet();

    abstract ImmutableCollection<V> createValues();

    public abstract V get(Object obj);

    abstract boolean isPartialView();

    public static <K, V> ImmutableMap<K, V> of() {
        return RegularImmutableMap.EMPTY;
    }

    public static <K, V> ImmutableMap<K, V> of(K k, V v) {
        ccw.m6000w(k, v);
        return RegularImmutableMap.create(1, new Object[]{k, v});
    }

    public static <K, V> ImmutableMap<K, V> of(K k, V v, K k2, V v2) {
        ccw.m6000w(k, v);
        ccw.m6000w(k2, v2);
        return RegularImmutableMap.create(2, new Object[]{k, v, k2, v2});
    }

    public static <K, V> ImmutableMap<K, V> of(K k, V v, K k2, V v2, K k3, V v3) {
        ccw.m6000w(k, v);
        ccw.m6000w(k2, v2);
        ccw.m6000w(k3, v3);
        return RegularImmutableMap.create(3, new Object[]{k, v, k2, v2, k3, v3});
    }

    public static <K, V> ImmutableMap<K, V> of(K k, V v, K k2, V v2, K k3, V v3, K k4, V v4) {
        ccw.m6000w(k, v);
        ccw.m6000w(k2, v2);
        ccw.m6000w(k3, v3);
        ccw.m6000w(k4, v4);
        return RegularImmutableMap.create(4, new Object[]{k, v, k2, v2, k3, v3, k4, v4});
    }

    public static <K, V> ImmutableMap<K, V> of(K k, V v, K k2, V v2, K k3, V v3, K k4, V v4, K k5, V v5) {
        ccw.m6000w(k, v);
        ccw.m6000w(k2, v2);
        ccw.m6000w(k3, v3);
        ccw.m6000w(k4, v4);
        ccw.m6000w(k5, v5);
        return RegularImmutableMap.create(5, new Object[]{k, v, k2, v2, k3, v3, k4, v4, k5, v5});
    }

    static <K, V> Entry<K, V> entryOf(K k, V v) {
        ccw.m6000w(k, v);
        return new SimpleImmutableEntry(k, v);
    }

    public static <K, V> a<K, V> builder() {
        return new a();
    }

    static void checkNoConflict(boolean z, String str, Entry<?, ?> entry, Entry<?, ?> entry2) {
        if (!z) {
            throw new IllegalArgumentException("Multiple entries with same " + str + ": " + entry + " and " + entry2);
        }
    }

    public static <K, V> ImmutableMap<K, V> copyOf(Map<? extends K, ? extends V> map) {
        if ((map instanceof ImmutableMap) && !(map instanceof SortedMap)) {
            ImmutableMap<K, V> immutableMap = (ImmutableMap) map;
            if (!immutableMap.isPartialView()) {
                return immutableMap;
            }
        }
        return copyOf(map.entrySet());
    }

    public static <K, V> ImmutableMap<K, V> copyOf(Iterable<? extends Entry<? extends K, ? extends V>> iterable) {
        a aVar = new a(iterable instanceof Collection ? ((Collection) iterable).size() : 4);
        aVar.i(iterable);
        return aVar.UJ();
    }

    ImmutableMap() {
    }

    @Deprecated
    public final V put(K k, V v) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public final V remove(Object obj) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public final void putAll(Map<? extends K, ? extends V> map) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public final void clear() {
        throw new UnsupportedOperationException();
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public boolean containsKey(Object obj) {
        return get(obj) != null;
    }

    public boolean containsValue(Object obj) {
        return values().contains(obj);
    }

    public ImmutableSet<Entry<K, V>> entrySet() {
        ImmutableSet<Entry<K, V>> immutableSet = this.bMw;
        if (immutableSet != null) {
            return immutableSet;
        }
        immutableSet = createEntrySet();
        this.bMw = immutableSet;
        return immutableSet;
    }

    public ImmutableSet<K> keySet() {
        ImmutableSet<K> immutableSet = this.bMx;
        if (immutableSet != null) {
            return immutableSet;
        }
        immutableSet = createKeySet();
        this.bMx = immutableSet;
        return immutableSet;
    }

    cdt<K> keyIterator() {
        return new 1(this, entrySet().iterator());
    }

    public ImmutableCollection<V> values() {
        ImmutableCollection<V> immutableCollection = this.bMy;
        if (immutableCollection != null) {
            return immutableCollection;
        }
        immutableCollection = createValues();
        this.bMy = immutableCollection;
        return immutableCollection;
    }

    public ImmutableSetMultimap<K, V> asMultimap() {
        if (isEmpty()) {
            return ImmutableSetMultimap.of();
        }
        ImmutableSetMultimap<K, V> immutableSetMultimap = this.bMz;
        if (immutableSetMultimap != null) {
            return immutableSetMultimap;
        }
        immutableSetMultimap = new ImmutableSetMultimap(new MapViewOfValuesAsSingletonSets(this, null), size(), null);
        this.bMz = immutableSetMultimap;
        return immutableSetMultimap;
    }

    public boolean equals(Object obj) {
        return Maps.f(this, obj);
    }

    public int hashCode() {
        return Sets.h(entrySet());
    }

    boolean isHashCodeFast() {
        return false;
    }

    public String toString() {
        return Maps.t(this);
    }

    Object writeReplace() {
        return new SerializedForm(this);
    }
}
