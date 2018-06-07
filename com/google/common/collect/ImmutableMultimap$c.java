package com.google.common.collect;

import com.fossil.cdt;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map.Entry;

abstract class ImmutableMultimap$c<T> extends cdt<T> {
    Iterator<V> bLV;
    final Iterator<Entry<K, Collection<V>>> bMO;
    K key;
    final /* synthetic */ ImmutableMultimap this$0;

    abstract T mo4507t(K k, V v);

    private ImmutableMultimap$c(ImmutableMultimap immutableMultimap) {
        this.this$0 = immutableMultimap;
        this.bMO = this.this$0.asMap().entrySet().iterator();
        this.key = null;
        this.bLV = Iterators.UR();
    }

    public boolean hasNext() {
        return this.bMO.hasNext() || this.bLV.hasNext();
    }

    public T next() {
        if (!this.bLV.hasNext()) {
            Entry entry = (Entry) this.bMO.next();
            this.key = entry.getKey();
            this.bLV = ((Collection) entry.getValue()).iterator();
        }
        return mo4507t(this.key, this.bLV.next());
    }
}
