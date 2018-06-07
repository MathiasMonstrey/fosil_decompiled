package com.google.common.collect;

import com.fossil.cco;
import com.fossil.cdt;

final class SingletonImmutableSet<E> extends ImmutableSet<E> {
    private transient int bOc;
    final transient E element;

    SingletonImmutableSet(E e) {
        this.element = cco.ce(e);
    }

    SingletonImmutableSet(E e, int i) {
        this.element = e;
        this.bOc = i;
    }

    public int size() {
        return 1;
    }

    public boolean contains(Object obj) {
        return this.element.equals(obj);
    }

    public cdt<E> iterator() {
        return Iterators.ct(this.element);
    }

    ImmutableList<E> createAsList() {
        return ImmutableList.of(this.element);
    }

    boolean isPartialView() {
        return false;
    }

    int copyIntoArray(Object[] objArr, int i) {
        objArr[i] = this.element;
        return i + 1;
    }

    public final int hashCode() {
        int i = this.bOc;
        if (i != 0) {
            return i;
        }
        i = this.element.hashCode();
        this.bOc = i;
        return i;
    }

    boolean isHashCodeFast() {
        return this.bOc != 0;
    }

    public String toString() {
        return '[' + this.element.toString() + ']';
    }
}
