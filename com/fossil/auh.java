package com.fossil;

import java.util.Iterator;

public interface auh<T> extends atx, Iterable<T> {
    @Deprecated
    void close();

    T get(int i);

    int getCount();

    Iterator<T> iterator();
}
