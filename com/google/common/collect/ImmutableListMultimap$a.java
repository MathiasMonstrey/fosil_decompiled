package com.google.common.collect;

import java.util.Map.Entry;

public final class ImmutableListMultimap$a<K, V> extends ImmutableMultimap$a<K, V> {
    public /* synthetic */ ImmutableMultimap UI() {
        return UH();
    }

    public /* synthetic */ ImmutableMultimap$a mo4499d(Entry entry) {
        return m14316c(entry);
    }

    public /* synthetic */ ImmutableMultimap$a mo4500h(Iterable iterable) {
        return m14318g(iterable);
    }

    public /* synthetic */ ImmutableMultimap$a mo4501y(Object obj, Object obj2) {
        return m14320x(obj, obj2);
    }

    public ImmutableListMultimap$a<K, V> m14320x(K k, V v) {
        super.mo4501y(k, v);
        return this;
    }

    public ImmutableListMultimap$a<K, V> m14316c(Entry<? extends K, ? extends V> entry) {
        super.mo4499d(entry);
        return this;
    }

    public ImmutableListMultimap$a<K, V> m14318g(Iterable<? extends Entry<? extends K, ? extends V>> iterable) {
        super.mo4500h(iterable);
        return this;
    }

    public ImmutableListMultimap<K, V> UH() {
        return (ImmutableListMultimap) super.UI();
    }
}
