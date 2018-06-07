package com.google.common.collect;

import com.fossil.ccw;
import com.fossil.cdi;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map.Entry;

public class ImmutableMultimap$a<K, V> {
    Comparator<? super V> bMB;
    cdi<K, V> bMJ;
    Comparator<? super K> bMK;

    public ImmutableMultimap$a() {
        this(MultimapBuilder.Vv().Vx().Vw());
    }

    ImmutableMultimap$a(cdi<K, V> com_fossil_cdi_K__V) {
        this.bMJ = com_fossil_cdi_K__V;
    }

    public ImmutableMultimap$a<K, V> mo4501y(K k, V v) {
        ccw.w(k, v);
        this.bMJ.put(k, v);
        return this;
    }

    public ImmutableMultimap$a<K, V> mo4499d(Entry<? extends K, ? extends V> entry) {
        return mo4501y(entry.getKey(), entry.getValue());
    }

    public ImmutableMultimap$a<K, V> mo4500h(Iterable<? extends Entry<? extends K, ? extends V>> iterable) {
        for (Entry d : iterable) {
            mo4499d(d);
        }
        return this;
    }

    public ImmutableMultimap<K, V> UI() {
        if (this.bMB != null) {
            for (Collection collection : this.bMJ.asMap().values()) {
                Collections.sort((List) collection, this.bMB);
            }
        }
        if (this.bMK != null) {
            cdi Vw = MultimapBuilder.Vv().Vx().Vw();
            for (Entry entry : Ordering.from(this.bMK).onKeys().immutableSortedCopy(this.bMJ.asMap().entrySet())) {
                Vw.putAll(entry.getKey(), (Iterable) entry.getValue());
            }
            this.bMJ = Vw;
        }
        return ImmutableMultimap.copyOf(this.bMJ);
    }
}
