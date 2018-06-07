package com.google.common.collect;

import com.fossil.cdt;
import java.io.Serializable;
import java.util.Map.Entry;

final class ImmutableMapKeySet<K, V> extends ImmutableSet$Indexed<K> {
    private final ImmutableMap<K, V> map;

    static class KeySetSerializedForm<K> implements Serializable {
        private static final long serialVersionUID = 0;
        final ImmutableMap<K, ?> map;

        KeySetSerializedForm(ImmutableMap<K, ?> immutableMap) {
            this.map = immutableMap;
        }

        Object readResolve() {
            return this.map.keySet();
        }
    }

    ImmutableMapKeySet(ImmutableMap<K, V> immutableMap) {
        this.map = immutableMap;
    }

    public int size() {
        return this.map.size();
    }

    public cdt<K> iterator() {
        return this.map.keyIterator();
    }

    public boolean contains(Object obj) {
        return this.map.containsKey(obj);
    }

    K get(int i) {
        return ((Entry) this.map.entrySet().asList().get(i)).getKey();
    }

    boolean isPartialView() {
        return true;
    }

    Object writeReplace() {
        return new KeySetSerializedForm(this.map);
    }
}
