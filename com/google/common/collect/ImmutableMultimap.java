package com.google.common.collect;

import com.fossil.cct;
import com.fossil.cdi;
import com.fossil.cdt;
import java.io.Serializable;
import java.util.Collection;
import java.util.Map;
import java.util.Map.Entry;

public abstract class ImmutableMultimap<K, V> extends cct<K, V> implements Serializable {
    private static final long serialVersionUID = 0;
    final transient ImmutableMap<K, ? extends ImmutableCollection<V>> map;
    final transient int size;

    public abstract ImmutableCollection<V> get(K k);

    public abstract ImmutableMultimap<V, K> inverse();

    public /* bridge */ /* synthetic */ boolean containsEntry(Object obj, Object obj2) {
        return super.containsEntry(obj, obj2);
    }

    public /* bridge */ /* synthetic */ boolean equals(Object obj) {
        return super.equals(obj);
    }

    public /* bridge */ /* synthetic */ int hashCode() {
        return super.hashCode();
    }

    public /* bridge */ /* synthetic */ boolean isEmpty() {
        return super.isEmpty();
    }

    public /* bridge */ /* synthetic */ String toString() {
        return super.toString();
    }

    public static <K, V> ImmutableMultimap<K, V> of() {
        return ImmutableListMultimap.of();
    }

    public static <K, V> ImmutableMultimap<K, V> of(K k, V v) {
        return ImmutableListMultimap.of(k, v);
    }

    public static <K, V> ImmutableMultimap<K, V> of(K k, V v, K k2, V v2) {
        return ImmutableListMultimap.of(k, v, k2, v2);
    }

    public static <K, V> ImmutableMultimap<K, V> of(K k, V v, K k2, V v2, K k3, V v3) {
        return ImmutableListMultimap.of(k, v, k2, v2, k3, v3);
    }

    public static <K, V> ImmutableMultimap<K, V> of(K k, V v, K k2, V v2, K k3, V v3, K k4, V v4) {
        return ImmutableListMultimap.of(k, v, k2, v2, k3, v3, k4, v4);
    }

    public static <K, V> ImmutableMultimap<K, V> of(K k, V v, K k2, V v2, K k3, V v3, K k4, V v4, K k5, V v5) {
        return ImmutableListMultimap.of(k, v, k2, v2, k3, v3, k4, v4, k5, v5);
    }

    public static <K, V> a<K, V> builder() {
        return new a();
    }

    public static <K, V> ImmutableMultimap<K, V> copyOf(cdi<? extends K, ? extends V> com_fossil_cdi__extends_K___extends_V) {
        if (com_fossil_cdi__extends_K___extends_V instanceof ImmutableMultimap) {
            ImmutableMultimap<K, V> immutableMultimap = (ImmutableMultimap) com_fossil_cdi__extends_K___extends_V;
            if (!immutableMultimap.isPartialView()) {
                return immutableMultimap;
            }
        }
        return ImmutableListMultimap.copyOf((cdi) com_fossil_cdi__extends_K___extends_V);
    }

    public static <K, V> ImmutableMultimap<K, V> copyOf(Iterable<? extends Entry<? extends K, ? extends V>> iterable) {
        return ImmutableListMultimap.copyOf((Iterable) iterable);
    }

    ImmutableMultimap(ImmutableMap<K, ? extends ImmutableCollection<V>> immutableMap, int i) {
        this.map = immutableMap;
        this.size = i;
    }

    @Deprecated
    public ImmutableCollection<V> removeAll(Object obj) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public ImmutableCollection<V> replaceValues(K k, Iterable<? extends V> iterable) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public void clear() {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public boolean put(K k, V v) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public boolean putAll(K k, Iterable<? extends V> iterable) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public boolean putAll(cdi<? extends K, ? extends V> com_fossil_cdi__extends_K___extends_V) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public boolean remove(Object obj, Object obj2) {
        throw new UnsupportedOperationException();
    }

    boolean isPartialView() {
        return this.map.isPartialView();
    }

    public boolean containsKey(Object obj) {
        return this.map.containsKey(obj);
    }

    public boolean containsValue(Object obj) {
        return obj != null && super.containsValue(obj);
    }

    public int size() {
        return this.size;
    }

    public ImmutableSet<K> keySet() {
        return this.map.keySet();
    }

    public ImmutableMap<K, Collection<V>> asMap() {
        return this.map;
    }

    Map<K, Collection<V>> createAsMap() {
        throw new AssertionError("should never be called");
    }

    public ImmutableCollection<Entry<K, V>> entries() {
        return (ImmutableCollection) super.entries();
    }

    ImmutableCollection<Entry<K, V>> createEntries() {
        return new EntryCollection(this);
    }

    cdt<Entry<K, V>> entryIterator() {
        return new 1(this);
    }

    public ImmutableMultiset<K> keys() {
        return (ImmutableMultiset) super.keys();
    }

    ImmutableMultiset<K> createKeys() {
        return new Keys(this);
    }

    public ImmutableCollection<V> values() {
        return (ImmutableCollection) super.values();
    }

    ImmutableCollection<V> createValues() {
        return new Values(this);
    }

    cdt<V> valueIterator() {
        return new 2(this);
    }
}
