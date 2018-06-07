package com.google.common.collect;

import java.io.Serializable;
import java.util.Comparator;

class ImmutableSortedSet$SerializedForm<E> implements Serializable {
    private static final long serialVersionUID = 0;
    final Comparator<? super E> comparator;
    final Object[] elements;

    public ImmutableSortedSet$SerializedForm(Comparator<? super E> comparator, Object[] objArr) {
        this.comparator = comparator;
        this.elements = objArr;
    }

    Object readResolve() {
        return new ImmutableSortedSet$a(this.comparator).m14356k(this.elements).UQ();
    }
}
