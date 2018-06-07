package com.google.common.collect;

import com.fossil.cdo;
import java.util.Collection;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

abstract class AbstractSetMultimap<K, V> extends AbstractMapBasedMultimap<K, V> implements cdo<K, V> {
    private static final long serialVersionUID = 7431625294878419160L;

    abstract Set<V> createCollection();

    protected AbstractSetMultimap(Map<K, Collection<V>> map) {
        super(map);
    }

    Set<V> createUnmodifiableEmptyCollection() {
        return ImmutableSet.of();
    }

    public Set<V> get(K k) {
        return (Set) super.get(k);
    }

    public Set<Entry<K, V>> entries() {
        return (Set) super.entries();
    }

    public Set<V> removeAll(Object obj) {
        return (Set) super.removeAll(obj);
    }

    public Set<V> replaceValues(K k, Iterable<? extends V> iterable) {
        return (Set) super.replaceValues(k, iterable);
    }

    public Map<K, Collection<V>> asMap() {
        return super.asMap();
    }

    public boolean put(K k, V v) {
        return super.put(k, v);
    }

    public boolean equals(Object obj) {
        return super.equals(obj);
    }
}
