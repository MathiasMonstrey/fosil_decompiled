package com.fossil;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class auk<T> implements Iterator<T> {
    protected final auh<T> bgR;
    protected int bgS = -1;

    public auk(auh<T> com_fossil_auh_T) {
        this.bgR = (auh) awa.bO(com_fossil_auh_T);
    }

    public boolean hasNext() {
        return this.bgS < this.bgR.getCount() + -1;
    }

    public T next() {
        if (hasNext()) {
            auh com_fossil_auh = this.bgR;
            int i = this.bgS + 1;
            this.bgS = i;
            return com_fossil_auh.get(i);
        }
        throw new NoSuchElementException("Cannot advance the iterator beyond " + this.bgS);
    }

    public void remove() {
        throw new UnsupportedOperationException("Cannot remove elements from a DataBufferIterator");
    }
}
