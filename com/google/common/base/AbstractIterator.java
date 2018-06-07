package com.google.common.base;

import com.fossil.cco;
import java.util.Iterator;
import java.util.NoSuchElementException;

abstract class AbstractIterator<T> implements Iterator<T> {
    private State bLx = State.NOT_READY;
    private T bLy;

    enum State {
        READY,
        NOT_READY,
        DONE,
        FAILED
    }

    protected abstract T Ua();

    protected AbstractIterator() {
    }

    protected final T Ub() {
        this.bLx = State.DONE;
        return null;
    }

    public final boolean hasNext() {
        cco.bA(this.bLx != State.FAILED);
        switch (this.bLx) {
            case READY:
                return true;
            case DONE:
                return false;
            default:
                return Uc();
        }
    }

    private boolean Uc() {
        this.bLx = State.FAILED;
        this.bLy = Ua();
        if (this.bLx == State.DONE) {
            return false;
        }
        this.bLx = State.READY;
        return true;
    }

    public final T next() {
        if (hasNext()) {
            this.bLx = State.NOT_READY;
            T t = this.bLy;
            this.bLy = null;
            return t;
        }
        throw new NoSuchElementException();
    }

    public final void remove() {
        throw new UnsupportedOperationException();
    }
}
