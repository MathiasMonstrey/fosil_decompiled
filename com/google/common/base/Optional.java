package com.google.common.base;

import com.fossil.cck;
import com.fossil.cco;
import com.fossil.ccq;
import java.io.Serializable;
import java.util.Iterator;
import java.util.Set;

public abstract class Optional<T> implements Serializable {
    private static final long serialVersionUID = 0;

    public abstract Set<T> asSet();

    public abstract boolean equals(Object obj);

    public abstract T get();

    public abstract int hashCode();

    public abstract boolean isPresent();

    public abstract Optional<T> or(Optional<? extends T> optional);

    public abstract T or(ccq<? extends T> com_fossil_ccq__extends_T);

    public abstract T or(T t);

    public abstract T orNull();

    public abstract String toString();

    public abstract <V> Optional<V> transform(cck<? super T, V> com_fossil_cck__super_T__V);

    public static <T> Optional<T> absent() {
        return Absent.withType();
    }

    public static <T> Optional<T> of(T t) {
        return new Present(cco.ce(t));
    }

    public static <T> Optional<T> fromNullable(T t) {
        return t == null ? absent() : new Present(t);
    }

    Optional() {
    }

    public static <T> Iterable<T> presentInstances(final Iterable<? extends Optional<? extends T>> iterable) {
        cco.ce(iterable);
        return new Iterable<T>() {

            class C42671 extends AbstractIterator<T> {
                private final Iterator<? extends Optional<? extends T>> bLI = ((Iterator) cco.ce(iterable.iterator()));
                final /* synthetic */ C42681 bLJ;

                C42671(C42681 c42681) {
                    this.bLJ = c42681;
                }

                protected T Ua() {
                    while (this.bLI.hasNext()) {
                        Optional optional = (Optional) this.bLI.next();
                        if (optional.isPresent()) {
                            return optional.get();
                        }
                    }
                    return Ub();
                }
            }

            public Iterator<T> iterator() {
                return new C42671(this);
            }
        };
    }
}
