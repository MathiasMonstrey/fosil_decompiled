package com.fossil;

import java.util.Iterator;

public abstract class cdt<E> implements Iterator<E> {
    protected cdt() {
    }

    @Deprecated
    public final void remove() {
        throw new UnsupportedOperationException();
    }
}
