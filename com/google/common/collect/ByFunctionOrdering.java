package com.google.common.collect;

import com.fossil.cck;
import com.fossil.ccn;
import com.fossil.cco;
import java.io.Serializable;

final class ByFunctionOrdering<F, T> extends Ordering<F> implements Serializable {
    private static final long serialVersionUID = 0;
    final cck<F, ? extends T> function;
    final Ordering<T> ordering;

    ByFunctionOrdering(cck<F, ? extends T> com_fossil_cck_F___extends_T, Ordering<T> ordering) {
        this.function = (cck) cco.ce(com_fossil_cck_F___extends_T);
        this.ordering = (Ordering) cco.ce(ordering);
    }

    public int compare(F f, F f2) {
        return this.ordering.compare(this.function.apply(f), this.function.apply(f2));
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ByFunctionOrdering)) {
            return false;
        }
        ByFunctionOrdering byFunctionOrdering = (ByFunctionOrdering) obj;
        if (this.function.equals(byFunctionOrdering.function) && this.ordering.equals(byFunctionOrdering.ordering)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return ccn.hashCode(new Object[]{this.function, this.ordering});
    }

    public String toString() {
        return this.ordering + ".onResultOf(" + this.function + ")";
    }
}
