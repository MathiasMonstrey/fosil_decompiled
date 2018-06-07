package com.google.common.collect;

import com.fossil.cco;
import com.fossil.cdu;

class RegularImmutableList<E> extends ImmutableList<E> {
    static final ImmutableList<Object> EMPTY = new RegularImmutableList(new Object[0], 0);
    final transient Object[] array;
    private final transient int size;

    RegularImmutableList(Object[] objArr, int i) {
        this.array = objArr;
        this.size = i;
    }

    public int size() {
        return this.size;
    }

    boolean isPartialView() {
        return false;
    }

    int copyIntoArray(Object[] objArr, int i) {
        System.arraycopy(this.array, 0, objArr, i, this.size);
        return this.size + i;
    }

    public E get(int i) {
        cco.bO(i, this.size);
        return this.array[i];
    }

    public cdu<E> listIterator(int i) {
        return Iterators.m14359a(this.array, 0, this.size, i);
    }
}
