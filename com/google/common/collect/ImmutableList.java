package com.google.common.collect;

import com.fossil.cco;
import com.fossil.cdg;
import com.fossil.cdk;
import com.fossil.cdt;
import com.fossil.cdu;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.RandomAccess;

public abstract class ImmutableList<E> extends ImmutableCollection<E> implements List<E>, RandomAccess {
    public static <E> ImmutableList<E> of() {
        return RegularImmutableList.EMPTY;
    }

    public static <E> ImmutableList<E> of(E e) {
        return m12659f(e);
    }

    public static <E> ImmutableList<E> of(E e, E e2) {
        return m12659f(e, e2);
    }

    public static <E> ImmutableList<E> of(E e, E e2, E e3) {
        return m12659f(e, e2, e3);
    }

    public static <E> ImmutableList<E> of(E e, E e2, E e3, E e4) {
        return m12659f(e, e2, e3, e4);
    }

    public static <E> ImmutableList<E> of(E e, E e2, E e3, E e4, E e5) {
        return m12659f(e, e2, e3, e4, e5);
    }

    public static <E> ImmutableList<E> of(E e, E e2, E e3, E e4, E e5, E e6) {
        return m12659f(e, e2, e3, e4, e5, e6);
    }

    public static <E> ImmutableList<E> of(E e, E e2, E e3, E e4, E e5, E e6, E e7) {
        return m12659f(e, e2, e3, e4, e5, e6, e7);
    }

    public static <E> ImmutableList<E> of(E e, E e2, E e3, E e4, E e5, E e6, E e7, E e8) {
        return m12659f(e, e2, e3, e4, e5, e6, e7, e8);
    }

    public static <E> ImmutableList<E> of(E e, E e2, E e3, E e4, E e5, E e6, E e7, E e8, E e9) {
        return m12659f(e, e2, e3, e4, e5, e6, e7, e8, e9);
    }

    public static <E> ImmutableList<E> of(E e, E e2, E e3, E e4, E e5, E e6, E e7, E e8, E e9, E e10) {
        return m12659f(e, e2, e3, e4, e5, e6, e7, e8, e9, e10);
    }

    public static <E> ImmutableList<E> of(E e, E e2, E e3, E e4, E e5, E e6, E e7, E e8, E e9, E e10, E e11) {
        return m12659f(e, e2, e3, e4, e5, e6, e7, e8, e9, e10, e11);
    }

    @SafeVarargs
    public static <E> ImmutableList<E> of(E e, E e2, E e3, E e4, E e5, E e6, E e7, E e8, E e9, E e10, E e11, E e12, E... eArr) {
        Object obj = new Object[(eArr.length + 12)];
        obj[0] = e;
        obj[1] = e2;
        obj[2] = e3;
        obj[3] = e4;
        obj[4] = e5;
        obj[5] = e6;
        obj[6] = e7;
        obj[7] = e8;
        obj[8] = e9;
        obj[9] = e10;
        obj[10] = e11;
        obj[11] = e12;
        System.arraycopy(eArr, 0, obj, 12, eArr.length);
        return m12659f(obj);
    }

    public static <E> ImmutableList<E> copyOf(Iterable<? extends E> iterable) {
        cco.ce(iterable);
        if (iterable instanceof Collection) {
            return copyOf((Collection) iterable);
        }
        return copyOf(iterable.iterator());
    }

    public static <E> ImmutableList<E> copyOf(Collection<? extends E> collection) {
        if (!(collection instanceof ImmutableCollection)) {
            return m12659f(collection.toArray());
        }
        ImmutableList<E> asList = ((ImmutableCollection) collection).asList();
        if (asList.isPartialView()) {
            return asImmutableList(asList.toArray());
        }
        return asList;
    }

    public static <E> ImmutableList<E> copyOf(Iterator<? extends E> it) {
        if (!it.hasNext()) {
            return of();
        }
        Object next = it.next();
        if (it.hasNext()) {
            return new a().cp(next).d(it).UF();
        }
        return of(next);
    }

    public static <E> ImmutableList<E> copyOf(E[] eArr) {
        if (eArr.length == 0) {
            return of();
        }
        return m12659f((Object[]) eArr.clone());
    }

    public static <E extends Comparable<? super E>> ImmutableList<E> sortedCopyOf(Iterable<? extends E> iterable) {
        Comparable[] comparableArr = (Comparable[]) cdg.m6011a((Iterable) iterable, new Comparable[0]);
        cdk.m6019l((Object[]) comparableArr);
        Arrays.sort(comparableArr);
        return asImmutableList(comparableArr);
    }

    public static <E> ImmutableList<E> sortedCopyOf(Comparator<? super E> comparator, Iterable<? extends E> iterable) {
        cco.ce(comparator);
        Object[] o = cdg.m6013o(iterable);
        cdk.m6019l(o);
        Arrays.sort(o, comparator);
        return asImmutableList(o);
    }

    private static <E> ImmutableList<E> m12659f(Object... objArr) {
        return asImmutableList(cdk.m6019l(objArr));
    }

    static <E> ImmutableList<E> asImmutableList(Object[] objArr) {
        return asImmutableList(objArr, objArr.length);
    }

    static <E> ImmutableList<E> asImmutableList(Object[] objArr, int i) {
        if (i == 0) {
            return of();
        }
        return new RegularImmutableList(objArr, i);
    }

    ImmutableList() {
    }

    public cdt<E> iterator() {
        return listIterator();
    }

    public cdu<E> listIterator() {
        return listIterator(0);
    }

    public cdu<E> listIterator(int i) {
        return new 1(this, size(), i);
    }

    public int indexOf(Object obj) {
        return obj == null ? -1 : Lists.b(this, obj);
    }

    public int lastIndexOf(Object obj) {
        return obj == null ? -1 : Lists.d(this, obj);
    }

    public boolean contains(Object obj) {
        return indexOf(obj) >= 0;
    }

    public ImmutableList<E> subList(int i, int i2) {
        cco.m5982C(i, i2, size());
        int i3 = i2 - i;
        if (i3 == size()) {
            return this;
        }
        if (i3 == 0) {
            return of();
        }
        return subListUnchecked(i, i2);
    }

    ImmutableList<E> subListUnchecked(int i, int i2) {
        return new SubList(this, i, i2 - i);
    }

    @Deprecated
    public final boolean addAll(int i, Collection<? extends E> collection) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public final E set(int i, E e) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public final void add(int i, E e) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public final E remove(int i) {
        throw new UnsupportedOperationException();
    }

    public final ImmutableList<E> asList() {
        return this;
    }

    int copyIntoArray(Object[] objArr, int i) {
        int size = size();
        for (int i2 = 0; i2 < size; i2++) {
            objArr[i + i2] = get(i2);
        }
        return i + size;
    }

    public ImmutableList<E> reverse() {
        return size() <= 1 ? this : new ReverseImmutableList(this);
    }

    public boolean equals(Object obj) {
        return Lists.a(this, obj);
    }

    public int hashCode() {
        int i = 1;
        for (int i2 = 0; i2 < size(); i2++) {
            i = (((i * 31) + get(i2).hashCode()) ^ -1) ^ -1;
        }
        return i;
    }

    private void readObject(ObjectInputStream objectInputStream) throws InvalidObjectException {
        throw new InvalidObjectException("Use SerializedForm");
    }

    Object writeReplace() {
        return new SerializedForm(toArray());
    }

    public static <E> a<E> builder() {
        return new a();
    }
}
