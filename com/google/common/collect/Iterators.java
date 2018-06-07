package com.google.common.collect;

import com.fossil.cck;
import com.fossil.ccn;
import com.fossil.cco;
import com.fossil.ccp;
import com.fossil.ccr;
import com.fossil.ccw;
import com.fossil.cds;
import com.fossil.cdt;
import com.fossil.cdu;
import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;

public final class Iterators {

    enum EmptyModifiableIterator implements Iterator<Object> {
        INSTANCE;

        public boolean hasNext() {
            return false;
        }

        public Object next() {
            throw new NoSuchElementException();
        }

        public void remove() {
            ccw.bB(false);
        }
    }

    static final class C4308a<T> extends ccr<T> {
        static final cdu<Object> bNe = new C4308a(new Object[0], 0, 0, 0);
        private final T[] array;
        private final int offset;

        C4308a(T[] tArr, int i, int i2, int i3) {
            super(i2, i3);
            this.array = tArr;
            this.offset = i;
        }

        protected T get(int i) {
            return this.array[this.offset + i];
        }
    }

    static <T> cdt<T> UR() {
        return US();
    }

    static <T> cdu<T> US() {
        return C4308a.bNe;
    }

    static <T> Iterator<T> UT() {
        return EmptyModifiableIterator.INSTANCE;
    }

    public static <T> cdt<T> m14367h(final Iterator<? extends T> it) {
        cco.ce(it);
        if (it instanceof cdt) {
            return (cdt) it;
        }
        return new cdt<T>() {
            public boolean hasNext() {
                return it.hasNext();
            }

            public T next() {
                return it.next();
            }
        };
    }

    public static boolean m14362a(Iterator<?> it, Object obj) {
        if (obj == null) {
            while (it.hasNext()) {
                if (it.next() == null) {
                    return true;
                }
            }
        }
        while (it.hasNext()) {
            if (obj.equals(it.next())) {
                return true;
            }
        }
        return false;
    }

    public static boolean m14363a(Iterator<?> it, Collection<?> collection) {
        cco.ce(collection);
        boolean z = false;
        while (it.hasNext()) {
            if (collection.contains(it.next())) {
                it.remove();
                z = true;
            }
        }
        return z;
    }

    public static boolean m14366b(Iterator<?> it, Collection<?> collection) {
        cco.ce(collection);
        boolean z = false;
        while (it.hasNext()) {
            if (!collection.contains(it.next())) {
                it.remove();
                z = true;
            }
        }
        return z;
    }

    public static boolean m14364a(Iterator<?> it, Iterator<?> it2) {
        while (it.hasNext()) {
            if (!it2.hasNext()) {
                return false;
            }
            if (!ccn.equal(it.next(), it2.next())) {
                return false;
            }
        }
        if (it2.hasNext()) {
            return false;
        }
        return true;
    }

    public static String m14368i(Iterator<?> it) {
        StringBuilder append = new StringBuilder().append('[');
        Object obj = 1;
        while (it.hasNext()) {
            if (obj == null) {
                append.append(", ");
            }
            obj = null;
            append.append(it.next());
        }
        return append.append(']').toString();
    }

    public static <T> boolean m14361a(Collection<T> collection, Iterator<? extends T> it) {
        cco.ce(collection);
        cco.ce(it);
        boolean z = false;
        while (it.hasNext()) {
            z |= collection.add(it.next());
        }
        return z;
    }

    public static <T> cdt<T> m14358a(final Iterator<T> it, final ccp<? super T> com_fossil_ccp__super_T) {
        cco.ce(it);
        cco.ce(com_fossil_ccp__super_T);
        return new AbstractIterator<T>() {
            protected T Ua() {
                while (it.hasNext()) {
                    T next = it.next();
                    if (com_fossil_ccp__super_T.apply(next)) {
                        return next;
                    }
                }
                return Ub();
            }
        };
    }

    public static <F, T> Iterator<T> m14360a(Iterator<F> it, final cck<? super F, ? extends T> com_fossil_cck__super_F___extends_T) {
        cco.ce(com_fossil_cck__super_F___extends_T);
        return new cds<F, T>(it) {
            T cu(F f) {
                return com_fossil_cck__super_F___extends_T.apply(f);
            }
        };
    }

    public static <T> T m14365b(Iterator<? extends T> it, T t) {
        return it.hasNext() ? it.next() : t;
    }

    static <T> T m14369j(Iterator<T> it) {
        if (!it.hasNext()) {
            return null;
        }
        T next = it.next();
        it.remove();
        return next;
    }

    public static void m14370k(Iterator<?> it) {
        cco.ce(it);
        while (it.hasNext()) {
            it.next();
            it.remove();
        }
    }

    static <T> cdu<T> m14359a(T[] tArr, int i, int i2, int i3) {
        cco.bz(i2 >= 0);
        cco.C(i, i + i2, tArr.length);
        cco.bP(i3, i2);
        if (i2 == 0) {
            return US();
        }
        return new C4308a(tArr, i, i2, i3);
    }

    public static <T> cdt<T> ct(final T t) {
        return new cdt<T>() {
            boolean done;

            public boolean hasNext() {
                return !this.done;
            }

            public T next() {
                if (this.done) {
                    throw new NoSuchElementException();
                }
                this.done = true;
                return t;
            }
        };
    }
}
