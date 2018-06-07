package com.google.common.collect;

import com.fossil.cdt;
import java.util.Collection;
import java.util.Map.Entry;
import java.util.Set;

abstract class ImmutableMap$IteratorBasedImmutableMap<K, V> extends ImmutableMap<K, V> {
    abstract cdt<Entry<K, V>> entryIterator();

    ImmutableMap$IteratorBasedImmutableMap() {
    }

    public /* bridge */ /* synthetic */ Set entrySet() {
        return super.entrySet();
    }

    public /* bridge */ /* synthetic */ Set keySet() {
        return super.keySet();
    }

    public /* bridge */ /* synthetic */ Collection values() {
        return super.values();
    }

    ImmutableSet<K> createKeySet() {
        return new ImmutableMapKeySet(this);
    }

    ImmutableSet<Entry<K, V>> createEntrySet() {
        return new ImmutableMapEntrySet<K, V>() {
            ImmutableMap<K, V> map() {
                return ImmutableMap$IteratorBasedImmutableMap.this;
            }

            public cdt<Entry<K, V>> iterator() {
                return ImmutableMap$IteratorBasedImmutableMap.this.entryIterator();
            }
        };
    }

    ImmutableCollection<V> createValues() {
        return new ImmutableMapValues(this);
    }
}
