package com.fossil;

import java.util.Iterator;

public abstract class cds<F, T> implements Iterator<T> {
    final Iterator<? extends F> bOf;

    public abstract T cu(F f);

    protected cds(Iterator<? extends F> it) {
        this.bOf = (Iterator) cco.ce(it);
    }

    public final boolean hasNext() {
        return this.bOf.hasNext();
    }

    public final T next() {
        return cu(this.bOf.next());
    }

    public final void remove() {
        this.bOf.remove();
    }
}
