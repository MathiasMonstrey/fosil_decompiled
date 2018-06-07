package com.fossil;

import com.google.common.base.Optional;
import com.google.common.collect.ImmutableSet;
import java.util.Iterator;

public abstract class ccy<E> implements Iterable<E> {
    private final Optional<Iterable<E>> bMp;

    protected ccy() {
        this.bMp = Optional.absent();
    }

    ccy(Iterable<E> iterable) {
        cco.ce(iterable);
        if (this == iterable) {
            iterable = null;
        }
        this.bMp = Optional.fromNullable(iterable);
    }

    private Iterable<E> UD() {
        return (Iterable) this.bMp.or(this);
    }

    public static <E> ccy<E> m6005d(final Iterable<E> iterable) {
        return iterable instanceof ccy ? (ccy) iterable : new ccy<E>(iterable) {
            public Iterator<E> iterator() {
                return iterable.iterator();
            }
        };
    }

    public String toString() {
        return cdg.m6012n(UD());
    }

    public final ccy<E> m6006b(ccp<? super E> com_fossil_ccp__super_E) {
        return m6005d(cdg.m6009a(UD(), (ccp) com_fossil_ccp__super_E));
    }

    public final ImmutableSet<E> UE() {
        return ImmutableSet.copyOf(UD());
    }
}
