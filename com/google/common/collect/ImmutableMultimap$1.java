package com.google.common.collect;

import java.util.Map.Entry;

class ImmutableMultimap$1 extends ImmutableMultimap$c<Entry<K, V>> {
    final /* synthetic */ ImmutableMultimap this$0;

    ImmutableMultimap$1(ImmutableMultimap immutableMultimap) {
        this.this$0 = immutableMultimap;
        super(immutableMultimap);
    }

    /* synthetic */ Object mo4507t(Object obj, Object obj2) {
        return m14328u(obj, obj2);
    }

    Entry<K, V> m14328u(K k, V v) {
        return Maps.m14452B(k, v);
    }
}
