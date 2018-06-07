package com.fossil;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class ame<T> implements Iterable<T>, Iterator<T> {
    private int _index = 0;
    private final T[] aVD;

    public ame(T[] tArr) {
        this.aVD = tArr;
    }

    public boolean hasNext() {
        return this._index < this.aVD.length;
    }

    public T next() {
        if (this._index >= this.aVD.length) {
            throw new NoSuchElementException();
        }
        Object[] objArr = this.aVD;
        int i = this._index;
        this._index = i + 1;
        return objArr[i];
    }

    public void remove() {
        throw new UnsupportedOperationException();
    }

    public Iterator<T> iterator() {
        return this;
    }
}
