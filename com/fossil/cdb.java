package com.fossil;

import com.google.common.collect.Iterators;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public abstract class cdb<K, V> extends cdc implements Map<K, V> {
    protected abstract Map<K, V> delegate();

    protected cdb() {
    }

    public int size() {
        return delegate().size();
    }

    public boolean isEmpty() {
        return delegate().isEmpty();
    }

    public V remove(Object obj) {
        return delegate().remove(obj);
    }

    public void clear() {
        delegate().clear();
    }

    public boolean containsKey(Object obj) {
        return delegate().containsKey(obj);
    }

    public boolean containsValue(Object obj) {
        return delegate().containsValue(obj);
    }

    public V get(Object obj) {
        return delegate().get(obj);
    }

    public V put(K k, V v) {
        return delegate().put(k, v);
    }

    public void putAll(Map<? extends K, ? extends V> map) {
        delegate().putAll(map);
    }

    public Set<K> keySet() {
        return delegate().keySet();
    }

    public Collection<V> values() {
        return delegate().values();
    }

    public Set<Entry<K, V>> entrySet() {
        return delegate().entrySet();
    }

    public boolean equals(Object obj) {
        return obj == this || delegate().equals(obj);
    }

    public int hashCode() {
        return delegate().hashCode();
    }

    protected void standardPutAll(Map<? extends K, ? extends V> map) {
        Maps.b(this, map);
    }

    protected V standardRemove(Object obj) {
        Iterator it = entrySet().iterator();
        while (it.hasNext()) {
            Entry entry = (Entry) it.next();
            if (ccn.equal(entry.getKey(), obj)) {
                V value = entry.getValue();
                it.remove();
                return value;
            }
        }
        return null;
    }

    protected void standardClear() {
        Iterators.k(entrySet().iterator());
    }

    protected boolean standardContainsKey(Object obj) {
        return Maps.d(this, obj);
    }

    protected boolean standardContainsValue(Object obj) {
        return Maps.e(this, obj);
    }

    protected boolean standardIsEmpty() {
        return !entrySet().iterator().hasNext();
    }

    protected boolean standardEquals(Object obj) {
        return Maps.f(this, obj);
    }

    protected int standardHashCode() {
        return Sets.h(entrySet());
    }

    protected String standardToString() {
        return Maps.t(this);
    }
}
