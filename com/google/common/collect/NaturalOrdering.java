package com.google.common.collect;

import com.fossil.cco;
import java.io.Serializable;

final class NaturalOrdering extends Ordering<Comparable> implements Serializable {
    static final NaturalOrdering INSTANCE = new NaturalOrdering();
    private static final long serialVersionUID = 0;
    private transient Ordering<Comparable> bNP;
    private transient Ordering<Comparable> bNQ;

    public int compare(Comparable comparable, Comparable comparable2) {
        cco.ce(comparable);
        cco.ce(comparable2);
        return comparable.compareTo(comparable2);
    }

    public <S extends Comparable> Ordering<S> nullsFirst() {
        Ordering<S> ordering = this.bNP;
        if (ordering != null) {
            return ordering;
        }
        ordering = super.nullsFirst();
        this.bNP = ordering;
        return ordering;
    }

    public <S extends Comparable> Ordering<S> nullsLast() {
        Ordering<S> ordering = this.bNQ;
        if (ordering != null) {
            return ordering;
        }
        ordering = super.nullsLast();
        this.bNQ = ordering;
        return ordering;
    }

    public <S extends Comparable> Ordering<S> reverse() {
        return ReverseNaturalOrdering.INSTANCE;
    }

    private Object readResolve() {
        return INSTANCE;
    }

    public String toString() {
        return "Ordering.natural()";
    }

    private NaturalOrdering() {
    }
}
