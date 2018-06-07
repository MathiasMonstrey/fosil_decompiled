package com.google.common.collect;

import com.fossil.cco;
import com.fossil.cdi;
import java.util.Map.Entry;

public final class ImmutableSetMultimap$a<K, V> extends ImmutableMultimap$a<K, V> {
    public /* synthetic */ ImmutableMultimap UI() {
        return UP();
    }

    public /* synthetic */ ImmutableMultimap$a mo4499d(Entry entry) {
        return m14345f(entry);
    }

    public /* synthetic */ ImmutableMultimap$a mo4500h(Iterable iterable) {
        return m14347l(iterable);
    }

    public /* synthetic */ ImmutableMultimap$a mo4501y(Object obj, Object obj2) {
        return m14343A(obj, obj2);
    }

    public ImmutableSetMultimap$a() {
        super(MultimapBuilder.Vv().Vy().Vz());
    }

    public ImmutableSetMultimap$a<K, V> m14343A(K k, V v) {
        this.bMJ.put(cco.ce(k), cco.ce(v));
        return this;
    }

    public ImmutableSetMultimap$a<K, V> m14345f(Entry<? extends K, ? extends V> entry) {
        this.bMJ.put(cco.ce(entry.getKey()), cco.ce(entry.getValue()));
        return this;
    }

    public ImmutableSetMultimap$a<K, V> m14347l(Iterable<? extends Entry<? extends K, ? extends V>> iterable) {
        super.mo4500h(iterable);
        return this;
    }

    public ImmutableSetMultimap<K, V> UP() {
        if (this.bMK != null) {
            cdi Vz = MultimapBuilder.Vv().Vy().Vz();
            for (Entry entry : Ordering.from(this.bMK).onKeys().immutableSortedCopy(this.bMJ.asMap().entrySet())) {
                Vz.putAll(entry.getKey(), (Iterable) entry.getValue());
            }
            this.bMJ = Vz;
        }
        return ImmutableSetMultimap.access$000(this.bMJ, this.bMB);
    }
}
