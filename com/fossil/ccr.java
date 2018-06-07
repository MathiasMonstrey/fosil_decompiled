package com.fossil;

import java.util.NoSuchElementException;

public abstract class ccr<E> extends cdu<E> {
    private int position;
    private final int size;

    public abstract E get(int i);

    protected ccr(int i, int i2) {
        cco.bP(i2, i);
        this.size = i;
        this.position = i2;
    }

    public final boolean hasNext() {
        return this.position < this.size;
    }

    public final E next() {
        if (hasNext()) {
            int i = this.position;
            this.position = i + 1;
            return get(i);
        }
        throw new NoSuchElementException();
    }

    public final int nextIndex() {
        return this.position;
    }

    public final boolean hasPrevious() {
        return this.position > 0;
    }

    public final E previous() {
        if (hasPrevious()) {
            int i = this.position - 1;
            this.position = i;
            return get(i);
        }
        throw new NoSuchElementException();
    }

    public final int previousIndex() {
        return this.position - 1;
    }
}
