package com.fossil;

import com.google.common.collect.Sets;
import java.util.Collection;
import java.util.Set;

public abstract class cdd<E> extends ccz<E> implements Set<E> {
    protected abstract Set<E> delegate();

    protected cdd() {
    }

    public boolean equals(Object obj) {
        return obj == this || delegate().equals(obj);
    }

    public int hashCode() {
        return delegate().hashCode();
    }

    protected boolean standardRemoveAll(Collection<?> collection) {
        return Sets.a(this, (Collection) cco.ce(collection));
    }

    protected boolean standardEquals(Object obj) {
        return Sets.b(this, obj);
    }

    protected int standardHashCode() {
        return Sets.h(this);
    }
}
