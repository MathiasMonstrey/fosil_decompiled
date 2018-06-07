package com.google.common.base;

import com.fossil.cck;
import com.fossil.ccn;
import com.fossil.cco;
import java.io.Serializable;

final class FunctionalEquivalence<F, T> extends Equivalence<F> implements Serializable {
    private static final long serialVersionUID = 0;
    private final cck<F, ? extends T> function;
    private final Equivalence<T> resultEquivalence;

    FunctionalEquivalence(cck<F, ? extends T> com_fossil_cck_F___extends_T, Equivalence<T> equivalence) {
        this.function = (cck) cco.ce(com_fossil_cck_F___extends_T);
        this.resultEquivalence = (Equivalence) cco.ce(equivalence);
    }

    protected boolean doEquivalent(F f, F f2) {
        return this.resultEquivalence.equivalent(this.function.apply(f), this.function.apply(f2));
    }

    protected int doHash(F f) {
        return this.resultEquivalence.hash(this.function.apply(f));
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof FunctionalEquivalence)) {
            return false;
        }
        FunctionalEquivalence functionalEquivalence = (FunctionalEquivalence) obj;
        if (this.function.equals(functionalEquivalence.function) && this.resultEquivalence.equals(functionalEquivalence.resultEquivalence)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return ccn.hashCode(new Object[]{this.function, this.resultEquivalence});
    }

    public String toString() {
        return this.resultEquivalence + ".onResultOf(" + this.function + ")";
    }
}
