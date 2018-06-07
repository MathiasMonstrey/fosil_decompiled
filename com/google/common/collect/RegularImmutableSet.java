package com.google.common.collect;

import com.fossil.cdf;
import com.fossil.cdt;

final class RegularImmutableSet<E> extends ImmutableSet<E> {
    static final RegularImmutableSet<Object> EMPTY = new RegularImmutableSet(new Object[0], 0, null, 0, 0);
    final transient Object[] elements;
    private final transient int hashCode;
    private final transient int mask;
    private final transient int size;
    final transient Object[] table;

    RegularImmutableSet(Object[] objArr, int i, Object[] objArr2, int i2, int i3) {
        this.elements = objArr;
        this.table = objArr2;
        this.mask = i2;
        this.hashCode = i;
        this.size = i3;
    }

    public boolean contains(Object obj) {
        Object[] objArr = this.table;
        if (obj == null || objArr == null) {
            return false;
        }
        int cm = cdf.cm(obj);
        while (true) {
            cm &= this.mask;
            Object obj2 = objArr[cm];
            if (obj2 == null) {
                return false;
            }
            if (obj2.equals(obj)) {
                return true;
            }
            cm++;
        }
    }

    public int size() {
        return this.size;
    }

    public cdt<E> iterator() {
        return Iterators.m14359a(this.elements, 0, this.size, 0);
    }

    int copyIntoArray(Object[] objArr, int i) {
        System.arraycopy(this.elements, 0, objArr, i, this.size);
        return this.size + i;
    }

    ImmutableList<E> createAsList() {
        return ImmutableList.asImmutableList(this.elements, this.size);
    }

    boolean isPartialView() {
        return false;
    }

    public int hashCode() {
        return this.hashCode;
    }

    boolean isHashCodeFast() {
        return true;
    }
}
