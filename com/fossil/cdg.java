package com.fossil;

import com.google.common.collect.Iterators;
import com.google.common.collect.Lists;
import java.util.Collection;
import java.util.Iterator;

public final class cdg {
    public static String m6012n(Iterable<?> iterable) {
        return Iterators.i(iterable.iterator());
    }

    public static <T> T[] m6011a(Iterable<? extends T> iterable, T[] tArr) {
        return m6014p(iterable).toArray(tArr);
    }

    public static Object[] m6013o(Iterable<?> iterable) {
        return m6014p(iterable).toArray();
    }

    private static <E> Collection<E> m6014p(Iterable<E> iterable) {
        if (iterable instanceof Collection) {
            return (Collection) iterable;
        }
        return Lists.l(iterable.iterator());
    }

    public static <T> Iterable<T> m6009a(final Iterable<T> iterable, final ccp<? super T> com_fossil_ccp__super_T) {
        cco.ce(iterable);
        cco.ce(com_fossil_ccp__super_T);
        return new ccy<T>() {
            public Iterator<T> iterator() {
                return Iterators.a(iterable.iterator(), com_fossil_ccp__super_T);
            }
        };
    }

    public static <F, T> Iterable<T> m6008a(final Iterable<F> iterable, final cck<? super F, ? extends T> com_fossil_cck__super_F___extends_T) {
        cco.ce(iterable);
        cco.ce(com_fossil_cck__super_F___extends_T);
        return new ccy<T>() {
            public Iterator<T> iterator() {
                return Iterators.a(iterable.iterator(), com_fossil_cck__super_F___extends_T);
            }
        };
    }

    public static <T> T m6010a(Iterable<? extends T> iterable, T t) {
        return Iterators.b(iterable.iterator(), t);
    }
}
