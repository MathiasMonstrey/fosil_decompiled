package com.google.common.base;

import com.fossil.cco;
import com.fossil.ccp;
import java.io.Serializable;

public final class Predicates {

    static class IsEqualToPredicate<T> implements ccp<T>, Serializable {
        private static final long serialVersionUID = 0;
        private final T target;

        private IsEqualToPredicate(T t) {
            this.target = t;
        }

        public boolean apply(T t) {
            return this.target.equals(t);
        }

        public int hashCode() {
            return this.target.hashCode();
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof IsEqualToPredicate)) {
                return false;
            }
            return this.target.equals(((IsEqualToPredicate) obj).target);
        }

        public String toString() {
            return "Predicates.equalTo(" + this.target + ")";
        }
    }

    static class NotPredicate<T> implements ccp<T>, Serializable {
        private static final long serialVersionUID = 0;
        final ccp<T> predicate;

        NotPredicate(ccp<T> com_fossil_ccp_T) {
            this.predicate = (ccp) cco.ce(com_fossil_ccp_T);
        }

        public boolean apply(T t) {
            return !this.predicate.apply(t);
        }

        public int hashCode() {
            return this.predicate.hashCode() ^ -1;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof NotPredicate)) {
                return false;
            }
            return this.predicate.equals(((NotPredicate) obj).predicate);
        }

        public String toString() {
            return "Predicates.not(" + this.predicate + ")";
        }
    }

    enum ObjectPredicate implements ccp<Object> {
        ALWAYS_TRUE {
            public boolean apply(Object obj) {
                return true;
            }

            public String toString() {
                return "Predicates.alwaysTrue()";
            }
        },
        ALWAYS_FALSE {
            public boolean apply(Object obj) {
                return false;
            }

            public String toString() {
                return "Predicates.alwaysFalse()";
            }
        },
        IS_NULL {
            public boolean apply(Object obj) {
                return obj == null;
            }

            public String toString() {
                return "Predicates.isNull()";
            }
        },
        NOT_NULL {
            public boolean apply(Object obj) {
                return obj != null;
            }

            public String toString() {
                return "Predicates.notNull()";
            }
        };

        <T> ccp<T> withNarrowedType() {
            return this;
        }
    }

    public static <T> ccp<T> Ue() {
        return ObjectPredicate.IS_NULL.withNarrowedType();
    }

    public static <T> ccp<T> m14291a(ccp<T> com_fossil_ccp_T) {
        return new NotPredicate(com_fossil_ccp_T);
    }

    public static <T> ccp<T> cf(T t) {
        return t == null ? Ue() : new IsEqualToPredicate(t);
    }
}
