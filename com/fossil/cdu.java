package com.fossil;

import java.util.ListIterator;

public abstract class cdu<E> extends cdt<E> implements ListIterator<E> {
    protected cdu() {
    }

    @Deprecated
    public final void add(E e) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public final void set(E e) {
        throw new UnsupportedOperationException();
    }
}
