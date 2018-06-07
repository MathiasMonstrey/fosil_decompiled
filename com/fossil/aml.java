package com.fossil;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class aml<T> implements Iterator<T> {
    private static final aml<?> aVJ = new aml();

    public static <T> Iterator<T> Hk() {
        return aVJ;
    }

    public boolean hasNext() {
        return false;
    }

    public T next() {
        throw new NoSuchElementException();
    }

    public void remove() {
        throw new UnsupportedOperationException();
    }
}
