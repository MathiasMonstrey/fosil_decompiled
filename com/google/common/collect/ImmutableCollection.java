package com.google.common.collect;

import com.fossil.cco;
import com.fossil.cdk;
import com.fossil.cdt;
import com.google.common.collect.ImmutableList.SerializedForm;
import java.io.Serializable;
import java.util.AbstractCollection;
import java.util.Collection;
import java.util.Iterator;

public abstract class ImmutableCollection<E> extends AbstractCollection<E> implements Serializable {
    private static final Object[] bMr = new Object[0];

    public abstract boolean contains(Object obj);

    abstract boolean isPartialView();

    public abstract cdt<E> iterator();

    ImmutableCollection() {
    }

    public final Object[] toArray() {
        int size = size();
        if (size == 0) {
            return bMr;
        }
        Object[] objArr = new Object[size];
        copyIntoArray(objArr, 0);
        return objArr;
    }

    public final <T> T[] toArray(T[] tArr) {
        cco.ce(tArr);
        int size = size();
        if (tArr.length < size) {
            tArr = cdk.m6017d(tArr, size);
        } else if (tArr.length > size) {
            tArr[size] = null;
        }
        copyIntoArray(tArr, 0);
        return tArr;
    }

    @Deprecated
    public final boolean add(E e) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public final boolean remove(Object obj) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public final boolean addAll(Collection<? extends E> collection) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public final boolean removeAll(Collection<?> collection) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public final boolean retainAll(Collection<?> collection) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public final void clear() {
        throw new UnsupportedOperationException();
    }

    public ImmutableList<E> asList() {
        return isEmpty() ? ImmutableList.of() : ImmutableList.asImmutableList(toArray());
    }

    int copyIntoArray(Object[] objArr, int i) {
        Iterator it = iterator();
        while (it.hasNext()) {
            int i2 = i + 1;
            objArr[i] = it.next();
            i = i2;
        }
        return i;
    }

    Object writeReplace() {
        return new SerializedForm(toArray());
    }
}
