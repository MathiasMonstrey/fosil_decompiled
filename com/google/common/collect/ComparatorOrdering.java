package com.google.common.collect;

import com.fossil.cco;
import java.io.Serializable;
import java.util.Comparator;

final class ComparatorOrdering<T> extends Ordering<T> implements Serializable {
    private static final long serialVersionUID = 0;
    final Comparator<T> comparator;

    ComparatorOrdering(Comparator<T> comparator) {
        this.comparator = (Comparator) cco.ce(comparator);
    }

    public int compare(T t, T t2) {
        return this.comparator.compare(t, t2);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ComparatorOrdering)) {
            return false;
        }
        return this.comparator.equals(((ComparatorOrdering) obj).comparator);
    }

    public int hashCode() {
        return this.comparator.hashCode();
    }

    public String toString() {
        return this.comparator.toString();
    }
}
