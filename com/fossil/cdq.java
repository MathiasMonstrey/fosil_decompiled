package com.fossil;

import com.google.common.collect.Ordering;
import java.util.Comparator;
import java.util.SortedSet;

public final class cdq {
    public static boolean m6030a(Comparator<?> comparator, Iterable<?> iterable) {
        Object a;
        cco.ce(comparator);
        cco.ce(iterable);
        if (iterable instanceof SortedSet) {
            a = m6029a((SortedSet) iterable);
        } else if (!(iterable instanceof cdp)) {
            return false;
        } else {
            a = ((cdp) iterable).comparator();
        }
        return comparator.equals(a);
    }

    public static <E> Comparator<? super E> m6029a(SortedSet<E> sortedSet) {
        Comparator<? super E> comparator = sortedSet.comparator();
        if (comparator == null) {
            return Ordering.natural();
        }
        return comparator;
    }
}
