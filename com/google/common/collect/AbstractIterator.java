package com.google.common.collect;

import com.fossil.cco;
import com.fossil.cdt;
import java.util.NoSuchElementException;

public abstract class AbstractIterator<T> extends cdt<T> {
    private State bLL = State.NOT_READY;
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
        this.bLL = State.DONE;
        return null;
    }

    public final boolean hasNext() {
        cco.bA(this.bLL != State.FAILED);
        switch (this.bLL) {
            case DONE:
                return false;
            case READY:
                return true;
            default:
                return Uc();
        }
    }

    private boolean Uc() {
        this.bLL = State.FAILED;
        this.bLy = Ua();
        if (this.bLL == State.DONE) {
            return false;
        }
        this.bLL = State.READY;
        return true;
    }

    public final T next() {
        if (hasNext()) {
            this.bLL = State.NOT_READY;
            T t = this.bLy;
            this.bLy = null;
            return t;
        }
        throw new NoSuchElementException();
    }
}
