package com.google.common.base;

import com.fossil.cco;
import java.io.Serializable;
import java.util.Iterator;

final class PairwiseEquivalence<T> extends Equivalence<Iterable<T>> implements Serializable {
    private static final long serialVersionUID = 1;
    final Equivalence<? super T> elementEquivalence;

    PairwiseEquivalence(Equivalence<? super T> equivalence) {
        this.elementEquivalence = (Equivalence) cco.ce(equivalence);
    }

    protected boolean doEquivalent(Iterable<T> iterable, Iterable<T> iterable2) {
        Iterator it = iterable.iterator();
        Iterator it2 = iterable2.iterator();
        while (it.hasNext() && it2.hasNext()) {
            if (!this.elementEquivalence.equivalent(it.next(), it2.next())) {
                return false;
            }
        }
        if (it.hasNext() || it2.hasNext()) {
            return false;
        }
        return true;
    }

    protected int doHash(Iterable<T> iterable) {
        int i = 78721;
        for (T hash : iterable) {
            i = (i * 24943) + this.elementEquivalence.hash(hash);
        }
        return i;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof PairwiseEquivalence)) {
            return false;
        }
        return this.elementEquivalence.equals(((PairwiseEquivalence) obj).elementEquivalence);
    }

    public int hashCode() {
        return this.elementEquivalence.hashCode() ^ 1185147655;
    }

    public String toString() {
        return this.elementEquivalence + ".pairwise()";
    }
}
