package com.google.common.collect;

import com.fossil.cck;
import com.fossil.cco;
import com.fossil.ccw;
import com.fossil.cdg;
import com.fossil.cdr;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;

public abstract class Ordering<T> implements Comparator<T> {
    static final int LEFT_IS_GREATER = 1;
    static final int RIGHT_IS_GREATER = -1;

    public abstract int compare(T t, T t2);

    public static <C extends Comparable> Ordering<C> natural() {
        return NaturalOrdering.INSTANCE;
    }

    public static <T> Ordering<T> from(Comparator<T> comparator) {
        return comparator instanceof Ordering ? (Ordering) comparator : new ComparatorOrdering(comparator);
    }

    @Deprecated
    public static <T> Ordering<T> from(Ordering<T> ordering) {
        return (Ordering) cco.ce(ordering);
    }

    public static <T> Ordering<T> explicit(List<T> list) {
        return new ExplicitOrdering(list);
    }

    public static <T> Ordering<T> explicit(T t, T... tArr) {
        return explicit(Lists.a(t, tArr));
    }

    public static Ordering<Object> allEqual() {
        return AllEqualOrdering.INSTANCE;
    }

    public static Ordering<Object> usingToString() {
        return UsingToStringOrdering.INSTANCE;
    }

    public static Ordering<Object> arbitrary() {
        return b.bNV;
    }

    protected Ordering() {
    }

    public <S extends T> Ordering<S> reverse() {
        return new ReverseOrdering(this);
    }

    public <S extends T> Ordering<S> nullsFirst() {
        return new NullsFirstOrdering(this);
    }

    public <S extends T> Ordering<S> nullsLast() {
        return new NullsLastOrdering(this);
    }

    public <F> Ordering<F> onResultOf(cck<F, ? extends T> com_fossil_cck_F___extends_T) {
        return new ByFunctionOrdering(com_fossil_cck_F___extends_T, this);
    }

    <T2 extends T> Ordering<Entry<T2, ?>> onKeys() {
        return onResultOf(Maps.Vs());
    }

    public <U extends T> Ordering<U> compound(Comparator<? super U> comparator) {
        return new CompoundOrdering(this, (Comparator) cco.ce(comparator));
    }

    public static <T> Ordering<T> compound(Iterable<? extends Comparator<? super T>> iterable) {
        return new CompoundOrdering(iterable);
    }

    public <S extends T> Ordering<Iterable<S>> lexicographical() {
        return new LexicographicalOrdering(this);
    }

    public <E extends T> E min(Iterator<E> it) {
        E next = it.next();
        while (it.hasNext()) {
            next = min(next, it.next());
        }
        return next;
    }

    public <E extends T> E min(Iterable<E> iterable) {
        return min(iterable.iterator());
    }

    public <E extends T> E min(E e, E e2) {
        return compare(e, e2) <= 0 ? e : e2;
    }

    public <E extends T> E min(E e, E e2, E e3, E... eArr) {
        E min = min(min(e, e2), e3);
        for (Object min2 : eArr) {
            min = min(min, min2);
        }
        return min;
    }

    public <E extends T> E max(Iterator<E> it) {
        E next = it.next();
        while (it.hasNext()) {
            next = max(next, it.next());
        }
        return next;
    }

    public <E extends T> E max(Iterable<E> iterable) {
        return max(iterable.iterator());
    }

    public <E extends T> E max(E e, E e2) {
        return compare(e, e2) >= 0 ? e : e2;
    }

    public <E extends T> E max(E e, E e2, E e3, E... eArr) {
        E max = max(max(e, e2), e3);
        for (Object max2 : eArr) {
            max = max(max, max2);
        }
        return max;
    }

    public <E extends T> List<E> leastOf(Iterable<E> iterable, int i) {
        if (iterable instanceof Collection) {
            Collection collection = (Collection) iterable;
            if (((long) collection.size()) <= 2 * ((long) i)) {
                Object[] toArray = collection.toArray();
                Arrays.sort(toArray, this);
                if (toArray.length > i) {
                    toArray = Arrays.copyOf(toArray, i);
                }
                return Collections.unmodifiableList(Arrays.asList(toArray));
            }
        }
        return leastOf(iterable.iterator(), i);
    }

    public <E extends T> List<E> leastOf(Iterator<E> it, int i) {
        cco.ce(it);
        ccw.m5998n(i, "k");
        if (i == 0 || !it.hasNext()) {
            return ImmutableList.of();
        }
        if (i >= 1073741823) {
            List l = Lists.l(it);
            Collections.sort(l, this);
            if (l.size() > i) {
                l.subList(i, l.size()).clear();
            }
            l.trimToSize();
            return Collections.unmodifiableList(l);
        }
        cdr a = cdr.m6032a(i, this);
        a.m6033o(it);
        return a.VD();
    }

    public <E extends T> List<E> greatestOf(Iterable<E> iterable, int i) {
        return reverse().leastOf((Iterable) iterable, i);
    }

    public <E extends T> List<E> greatestOf(Iterator<E> it, int i) {
        return reverse().leastOf((Iterator) it, i);
    }

    public <E extends T> List<E> sortedCopy(Iterable<E> iterable) {
        Object[] o = cdg.m6013o(iterable);
        Arrays.sort(o, this);
        return Lists.q(Arrays.asList(o));
    }

    public <E extends T> ImmutableList<E> immutableSortedCopy(Iterable<E> iterable) {
        return ImmutableList.sortedCopyOf(this, iterable);
    }

    public boolean isOrdered(Iterable<? extends T> iterable) {
        Iterator it = iterable.iterator();
        if (it.hasNext()) {
            Object next = it.next();
            while (it.hasNext()) {
                Object next2 = it.next();
                if (compare(next, next2) > 0) {
                    return false;
                }
                next = next2;
            }
        }
        return true;
    }

    public boolean isStrictlyOrdered(Iterable<? extends T> iterable) {
        Iterator it = iterable.iterator();
        if (it.hasNext()) {
            Object next = it.next();
            while (it.hasNext()) {
                Object next2 = it.next();
                if (compare(next, next2) >= 0) {
                    return false;
                }
                next = next2;
            }
        }
        return true;
    }

    @Deprecated
    public int binarySearch(List<? extends T> list, T t) {
        return Collections.binarySearch(list, t, this);
    }
}
