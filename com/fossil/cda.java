package com.fossil;

import java.util.concurrent.ConcurrentMap;

public abstract class cda<K, V> extends cdb<K, V> implements ConcurrentMap<K, V> {
    protected abstract ConcurrentMap<K, V> delegate();

    protected cda() {
    }

    public V putIfAbsent(K k, V v) {
        return delegate().putIfAbsent(k, v);
    }

    public boolean remove(Object obj, Object obj2) {
        return delegate().remove(obj, obj2);
    }

    public V replace(K k, V v) {
        return delegate().replace(k, v);
    }

    public boolean replace(K k, V v, V v2) {
        return delegate().replace(k, v, v2);
    }
}
