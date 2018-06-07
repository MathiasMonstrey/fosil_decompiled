package com.google.common.collect;

import java.io.Serializable;
import java.util.List;

final class AllEqualOrdering extends Ordering<Object> implements Serializable {
    static final AllEqualOrdering INSTANCE = new AllEqualOrdering();
    private static final long serialVersionUID = 0;

    AllEqualOrdering() {
    }

    public int compare(Object obj, Object obj2) {
        return 0;
    }

    public <E> List<E> sortedCopy(Iterable<E> iterable) {
        return Lists.m14378q(iterable);
    }

    public <E> ImmutableList<E> immutableSortedCopy(Iterable<E> iterable) {
        return ImmutableList.copyOf(iterable);
    }

    public <S> Ordering<S> reverse() {
        return this;
    }

    private Object readResolve() {
        return INSTANCE;
    }

    public String toString() {
        return "Ordering.allEqual()";
    }
}
