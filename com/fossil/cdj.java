package com.fossil;

import java.util.Collection;
import java.util.Set;

public interface cdj<E> extends Collection<E> {

    public interface C2007a<E> {
        int getCount();

        E getElement();
    }

    int add(E e, int i);

    boolean contains(Object obj);

    boolean containsAll(Collection<?> collection);

    int count(Object obj);

    Set<E> elementSet();

    Set<C2007a<E>> entrySet();

    int remove(Object obj, int i);

    boolean remove(Object obj);

    int setCount(E e, int i);

    boolean setCount(E e, int i, int i2);

    int size();
}
