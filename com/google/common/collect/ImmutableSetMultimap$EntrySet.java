package com.google.common.collect;

import com.fossil.cdt;
import java.util.Map.Entry;

final class ImmutableSetMultimap$EntrySet<K, V> extends ImmutableSet<Entry<K, V>> {
    private final transient ImmutableSetMultimap<K, V> bMW;

    ImmutableSetMultimap$EntrySet(ImmutableSetMultimap<K, V> immutableSetMultimap) {
        this.bMW = immutableSetMultimap;
    }

    public boolean contains(Object obj) {
        if (!(obj instanceof Entry)) {
            return false;
        }
        Entry entry = (Entry) obj;
        return this.bMW.containsEntry(entry.getKey(), entry.getValue());
    }

    public int size() {
        return this.bMW.size();
    }

    public cdt<Entry<K, V>> iterator() {
        return this.bMW.entryIterator();
    }

    boolean isPartialView() {
        return false;
    }
}
