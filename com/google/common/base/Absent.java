package com.google.common.base;

import com.fossil.cck;
import com.fossil.cco;
import com.fossil.ccq;
import java.util.Collections;
import java.util.Set;

final class Absent<T> extends Optional<T> {
    static final Absent<Object> INSTANCE = new Absent();
    private static final long serialVersionUID = 0;

    static <T> Optional<T> withType() {
        return INSTANCE;
    }

    private Absent() {
    }

    public boolean isPresent() {
        return false;
    }

    public T get() {
        throw new IllegalStateException("Optional.get() cannot be called on an absent value");
    }

    public T or(T t) {
        return cco.s(t, "use Optional.orNull() instead of Optional.or(null)");
    }

    public Optional<T> or(Optional<? extends T> optional) {
        return (Optional) cco.ce(optional);
    }

    public T or(ccq<? extends T> com_fossil_ccq__extends_T) {
        return cco.s(com_fossil_ccq__extends_T.get(), "use Optional.orNull() instead of a Supplier that returns null");
    }

    public T orNull() {
        return null;
    }

    public Set<T> asSet() {
        return Collections.emptySet();
    }

    public <V> Optional<V> transform(cck<? super T, V> com_fossil_cck__super_T__V) {
        cco.ce(com_fossil_cck__super_T__V);
        return Optional.absent();
    }

    public boolean equals(Object obj) {
        return obj == this;
    }

    public int hashCode() {
        return 2040732332;
    }

    public String toString() {
        return "Optional.absent()";
    }

    private Object readResolve() {
        return INSTANCE;
    }
}
