package com.google.common.base;

import com.fossil.cck;
import com.fossil.cco;
import com.fossil.ccq;
import java.util.Collections;
import java.util.Set;

final class Present<T> extends Optional<T> {
    private static final long serialVersionUID = 0;
    private final T reference;

    Present(T t) {
        this.reference = t;
    }

    public boolean isPresent() {
        return true;
    }

    public T get() {
        return this.reference;
    }

    public T or(T t) {
        cco.s(t, "use Optional.orNull() instead of Optional.or(null)");
        return this.reference;
    }

    public Optional<T> or(Optional<? extends T> optional) {
        cco.ce(optional);
        return this;
    }

    public T or(ccq<? extends T> com_fossil_ccq__extends_T) {
        cco.ce(com_fossil_ccq__extends_T);
        return this.reference;
    }

    public T orNull() {
        return this.reference;
    }

    public Set<T> asSet() {
        return Collections.singleton(this.reference);
    }

    public <V> Optional<V> transform(cck<? super T, V> com_fossil_cck__super_T__V) {
        return new Present(cco.s(com_fossil_cck__super_T__V.apply(this.reference), "the Function passed to Optional.transform() must not return null."));
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof Present)) {
            return false;
        }
        return this.reference.equals(((Present) obj).reference);
    }

    public int hashCode() {
        return 1502476572 + this.reference.hashCode();
    }

    public String toString() {
        return "Optional.of(" + this.reference + ")";
    }
}
