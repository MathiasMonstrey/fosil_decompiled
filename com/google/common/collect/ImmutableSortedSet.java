package com.google.common.collect;

import com.fossil.cco;
import com.fossil.cdg;
import com.fossil.cdk;
import com.fossil.cdp;
import com.fossil.cdq;
import com.fossil.cdt;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.NavigableSet;
import java.util.SortedSet;

public abstract class ImmutableSortedSet<E> extends ImmutableSortedSetFauxverideShim<E> implements cdp<E>, NavigableSet<E> {
    final transient Comparator<? super E> comparator;
    transient ImmutableSortedSet<E> descendingSet;

    abstract ImmutableSortedSet<E> createDescendingSet();

    public abstract cdt<E> descendingIterator();

    abstract ImmutableSortedSet<E> headSetImpl(E e, boolean z);

    abstract int indexOf(Object obj);

    public abstract cdt<E> iterator();

    abstract ImmutableSortedSet<E> subSetImpl(E e, boolean z, E e2, boolean z2);

    abstract ImmutableSortedSet<E> tailSetImpl(E e, boolean z);

    static <E> RegularImmutableSortedSet<E> emptySet(Comparator<? super E> comparator) {
        if (Ordering.natural().equals(comparator)) {
            return RegularImmutableSortedSet.NATURAL_EMPTY_SET;
        }
        return new RegularImmutableSortedSet(ImmutableList.of(), comparator);
    }

    public static <E> ImmutableSortedSet<E> of() {
        return RegularImmutableSortedSet.NATURAL_EMPTY_SET;
    }

    public static <E extends Comparable<? super E>> ImmutableSortedSet<E> of(E e) {
        return new RegularImmutableSortedSet(ImmutableList.of(e), Ordering.natural());
    }

    public static <E extends Comparable<? super E>> ImmutableSortedSet<E> of(E e, E e2) {
        return construct(Ordering.natural(), 2, e, e2);
    }

    public static <E extends Comparable<? super E>> ImmutableSortedSet<E> of(E e, E e2, E e3) {
        return construct(Ordering.natural(), 3, e, e2, e3);
    }

    public static <E extends Comparable<? super E>> ImmutableSortedSet<E> of(E e, E e2, E e3, E e4) {
        return construct(Ordering.natural(), 4, e, e2, e3, e4);
    }

    public static <E extends Comparable<? super E>> ImmutableSortedSet<E> of(E e, E e2, E e3, E e4, E e5) {
        return construct(Ordering.natural(), 5, e, e2, e3, e4, e5);
    }

    public static <E extends Comparable<? super E>> ImmutableSortedSet<E> of(E e, E e2, E e3, E e4, E e5, E e6, E... eArr) {
        Object obj = new Comparable[(eArr.length + 6)];
        obj[0] = e;
        obj[1] = e2;
        obj[2] = e3;
        obj[3] = e4;
        obj[4] = e5;
        obj[5] = e6;
        System.arraycopy(eArr, 0, obj, 6, eArr.length);
        return construct(Ordering.natural(), obj.length, (Comparable[]) obj);
    }

    public static <E extends Comparable<? super E>> ImmutableSortedSet<E> copyOf(E[] eArr) {
        return construct(Ordering.natural(), eArr.length, (Object[]) eArr.clone());
    }

    public static <E> ImmutableSortedSet<E> copyOf(Iterable<? extends E> iterable) {
        return copyOf(Ordering.natural(), (Iterable) iterable);
    }

    public static <E> ImmutableSortedSet<E> copyOf(Collection<? extends E> collection) {
        return copyOf(Ordering.natural(), (Collection) collection);
    }

    public static <E> ImmutableSortedSet<E> copyOf(Iterator<? extends E> it) {
        return copyOf(Ordering.natural(), (Iterator) it);
    }

    public static <E> ImmutableSortedSet<E> copyOf(Comparator<? super E> comparator, Iterator<? extends E> it) {
        return new a(comparator).g(it).UQ();
    }

    public static <E> ImmutableSortedSet<E> copyOf(Comparator<? super E> comparator, Iterable<? extends E> iterable) {
        cco.ce(comparator);
        if (cdq.m6030a(comparator, iterable) && (iterable instanceof ImmutableSortedSet)) {
            ImmutableSortedSet<E> immutableSortedSet = (ImmutableSortedSet) iterable;
            if (!immutableSortedSet.isPartialView()) {
                return immutableSortedSet;
            }
        }
        Object[] o = cdg.m6013o(iterable);
        return construct(comparator, o.length, o);
    }

    public static <E> ImmutableSortedSet<E> copyOf(Comparator<? super E> comparator, Collection<? extends E> collection) {
        return copyOf((Comparator) comparator, (Iterable) collection);
    }

    public static <E> ImmutableSortedSet<E> copyOfSorted(SortedSet<E> sortedSet) {
        Comparator a = cdq.m6029a(sortedSet);
        ImmutableList copyOf = ImmutableList.copyOf((Collection) sortedSet);
        if (copyOf.isEmpty()) {
            return emptySet(a);
        }
        return new RegularImmutableSortedSet(copyOf, a);
    }

    static <E> ImmutableSortedSet<E> construct(Comparator<? super E> comparator, int i, E... eArr) {
        if (i == 0) {
            return emptySet(comparator);
        }
        cdk.m6018e(eArr, i);
        Arrays.sort(eArr, 0, i, comparator);
        int i2 = 1;
        int i3 = 1;
        while (i2 < i) {
            int i4;
            Object obj = eArr[i2];
            if (comparator.compare(obj, eArr[i3 - 1]) != 0) {
                i4 = i3 + 1;
                eArr[i3] = obj;
            } else {
                i4 = i3;
            }
            i2++;
            i3 = i4;
        }
        Arrays.fill(eArr, i3, i, null);
        if (i3 < eArr.length / 2) {
            eArr = Arrays.copyOf(eArr, i3);
        }
        return new RegularImmutableSortedSet(ImmutableList.asImmutableList(eArr, i3), comparator);
    }

    public static <E> a<E> orderedBy(Comparator<E> comparator) {
        return new a(comparator);
    }

    public static <E extends Comparable<?>> a<E> reverseOrder() {
        return new a(Collections.reverseOrder());
    }

    public static <E extends Comparable<?>> a<E> naturalOrder() {
        return new a(Ordering.natural());
    }

    int unsafeCompare(Object obj, Object obj2) {
        return unsafeCompare(this.comparator, obj, obj2);
    }

    static int unsafeCompare(Comparator<?> comparator, Object obj, Object obj2) {
        return comparator.compare(obj, obj2);
    }

    ImmutableSortedSet(Comparator<? super E> comparator) {
        this.comparator = comparator;
    }

    public Comparator<? super E> comparator() {
        return this.comparator;
    }

    public ImmutableSortedSet<E> headSet(E e) {
        return headSet((Object) e, false);
    }

    public ImmutableSortedSet<E> headSet(E e, boolean z) {
        return headSetImpl(cco.ce(e), z);
    }

    public ImmutableSortedSet<E> subSet(E e, E e2) {
        return subSet((Object) e, true, (Object) e2, false);
    }

    public ImmutableSortedSet<E> subSet(E e, boolean z, E e2, boolean z2) {
        cco.ce(e);
        cco.ce(e2);
        cco.bz(this.comparator.compare(e, e2) <= 0);
        return subSetImpl(e, z, e2, z2);
    }

    public ImmutableSortedSet<E> tailSet(E e) {
        return tailSet((Object) e, true);
    }

    public ImmutableSortedSet<E> tailSet(E e, boolean z) {
        return tailSetImpl(cco.ce(e), z);
    }

    public E lower(E e) {
        return Iterators.b(headSet((Object) e, false).descendingIterator(), null);
    }

    public E floor(E e) {
        return Iterators.b(headSet((Object) e, true).descendingIterator(), null);
    }

    public E ceiling(E e) {
        return cdg.m6010a(tailSet((Object) e, true), null);
    }

    public E higher(E e) {
        return cdg.m6010a(tailSet((Object) e, false), null);
    }

    public E first() {
        return iterator().next();
    }

    public E last() {
        return descendingIterator().next();
    }

    @Deprecated
    public final E pollFirst() {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public final E pollLast() {
        throw new UnsupportedOperationException();
    }

    public ImmutableSortedSet<E> descendingSet() {
        ImmutableSortedSet<E> immutableSortedSet = this.descendingSet;
        if (immutableSortedSet != null) {
            return immutableSortedSet;
        }
        immutableSortedSet = createDescendingSet();
        this.descendingSet = immutableSortedSet;
        immutableSortedSet.descendingSet = this;
        return immutableSortedSet;
    }

    private void readObject(ObjectInputStream objectInputStream) throws InvalidObjectException {
        throw new InvalidObjectException("Use SerializedForm");
    }

    Object writeReplace() {
        return new SerializedForm(this.comparator, toArray());
    }
}
