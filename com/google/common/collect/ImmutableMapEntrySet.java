package com.google.common.collect;

import java.io.Serializable;
import java.util.Map.Entry;

abstract class ImmutableMapEntrySet<K, V> extends ImmutableSet<Entry<K, V>> {

    static class EntrySetSerializedForm<K, V> implements Serializable {
        private static final long serialVersionUID = 0;
        final ImmutableMap<K, V> map;

        EntrySetSerializedForm(ImmutableMap<K, V> immutableMap) {
            this.map = immutableMap;
        }

        Object readResolve() {
            return this.map.entrySet();
        }
    }

    abstract ImmutableMap<K, V> map();

    ImmutableMapEntrySet() {
    }

    public int size() {
        return map().size();
    }

    public boolean contains(Object obj) {
        if (!(obj instanceof Entry)) {
            return false;
        }
        Entry entry = (Entry) obj;
        Object obj2 = map().get(entry.getKey());
        if (obj2 == null || !obj2.equals(entry.getValue())) {
            return false;
        }
        return true;
    }

    boolean isPartialView() {
        return map().isPartialView();
    }

    boolean isHashCodeFast() {
        return map().isHashCodeFast();
    }

    public int hashCode() {
        return map().hashCode();
    }

    Object writeReplace() {
        return new EntrySetSerializedForm(map());
    }
}
