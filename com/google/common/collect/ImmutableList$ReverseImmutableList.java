package com.google.common.collect;

import com.fossil.cco;
import java.util.Iterator;
import java.util.ListIterator;

class ImmutableList$ReverseImmutableList<E> extends ImmutableList<E> {
    private final transient ImmutableList<E> bMu;

    public /* bridge */ /* synthetic */ Iterator iterator() {
        return super.iterator();
    }

    public /* bridge */ /* synthetic */ ListIterator listIterator() {
        return super.listIterator();
    }

    public /* bridge */ /* synthetic */ ListIterator listIterator(int i) {
        return super.listIterator(i);
    }

    ImmutableList$ReverseImmutableList(ImmutableList<E> immutableList) {
        this.bMu = immutableList;
    }

    private int ix(int i) {
        return (size() - 1) - i;
    }

    private int iy(int i) {
        return size() - i;
    }

    public ImmutableList<E> reverse() {
        return this.bMu;
    }

    public boolean contains(Object obj) {
        return this.bMu.contains(obj);
    }

    public int indexOf(Object obj) {
        int lastIndexOf = this.bMu.lastIndexOf(obj);
        return lastIndexOf >= 0 ? ix(lastIndexOf) : -1;
    }

    public int lastIndexOf(Object obj) {
        int indexOf = this.bMu.indexOf(obj);
        return indexOf >= 0 ? ix(indexOf) : -1;
    }

    public ImmutableList<E> subList(int i, int i2) {
        cco.C(i, i2, size());
        return this.bMu.subList(iy(i2), iy(i)).reverse();
    }

    public E get(int i) {
        cco.bO(i, size());
        return this.bMu.get(ix(i));
    }

    public int size() {
        return this.bMu.size();
    }

    boolean isPartialView() {
        return this.bMu.isPartialView();
    }
}
