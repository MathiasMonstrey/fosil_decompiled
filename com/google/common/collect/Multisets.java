package com.google.common.collect;

import com.fossil.ccn;
import com.fossil.cco;
import com.fossil.ccw;
import com.fossil.cdj;
import com.fossil.cdj.a;
import com.fossil.cds;
import com.google.common.collect.Sets.C4278a;
import com.google.common.primitives.Ints;
import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;

public final class Multisets {

    public static abstract class C4354a<E> implements a<E> {
        protected C4354a() {
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            if (getCount() == aVar.getCount() && ccn.equal(getElement(), aVar.getElement())) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            Object element = getElement();
            return (element == null ? 0 : element.hashCode()) ^ getCount();
        }

        public String toString() {
            String valueOf = String.valueOf(getElement());
            int count = getCount();
            return count == 1 ? valueOf : valueOf + " x " + count;
        }
    }

    public static abstract class C4357c<E> extends C4278a<a<E>> {
        public abstract cdj<E> UA();

        protected C4357c() {
        }

        public boolean contains(Object obj) {
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            if (aVar.getCount() > 0 && UA().count(aVar.getElement()) == aVar.getCount()) {
                return true;
            }
            return false;
        }

        public boolean remove(Object obj) {
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            Object element = aVar.getElement();
            int count = aVar.getCount();
            if (count != 0) {
                return UA().setCount(element, count, 0);
            }
            return false;
        }

        public void clear() {
            UA().clear();
        }
    }

    static class ImmutableEntry<E> extends C4354a<E> implements Serializable {
        private static final long serialVersionUID = 0;
        private final int count;
        private final E element;

        ImmutableEntry(E e, int i) {
            this.element = e;
            this.count = i;
            ccw.n(i, "count");
        }

        public final E getElement() {
            return this.element;
        }

        public final int getCount() {
            return this.count;
        }

        public ImmutableEntry<E> nextInBucket() {
            return null;
        }
    }

    public static abstract class C4361b<E> extends C4278a<E> {
        protected abstract cdj<E> UA();

        protected C4361b() {
        }

        public void clear() {
            UA().clear();
        }

        public boolean contains(Object obj) {
            return UA().contains(obj);
        }

        public boolean containsAll(Collection<?> collection) {
            return UA().containsAll(collection);
        }

        public boolean isEmpty() {
            return UA().isEmpty();
        }

        public Iterator<E> iterator() {
            return new cds<a<E>, E>(this, UA().entrySet().iterator()) {
                final /* synthetic */ C4361b bNI;

                /* synthetic */ Object cu(Object obj) {
                    return m14468a((a) obj);
                }

                E m14468a(a<E> aVar) {
                    return aVar.getElement();
                }
            };
        }

        public boolean remove(Object obj) {
            return UA().remove(obj, Integer.MAX_VALUE) > 0;
        }

        public int size() {
            return UA().entrySet().size();
        }
    }

    static final class C4362d<E> implements Iterator<E> {
        private final cdj<E> bNJ;
        private final Iterator<a<E>> bNK;
        private a<E> bNL;
        private int bNM;
        private int bNN;
        private boolean bNO;

        C4362d(cdj<E> com_fossil_cdj_E, Iterator<a<E>> it) {
            this.bNJ = com_fossil_cdj_E;
            this.bNK = it;
        }

        public boolean hasNext() {
            return this.bNM > 0 || this.bNK.hasNext();
        }

        public E next() {
            if (hasNext()) {
                if (this.bNM == 0) {
                    this.bNL = (a) this.bNK.next();
                    int count = this.bNL.getCount();
                    this.bNM = count;
                    this.bNN = count;
                }
                this.bNM--;
                this.bNO = true;
                return this.bNL.getElement();
            }
            throw new NoSuchElementException();
        }

        public void remove() {
            ccw.bB(this.bNO);
            if (this.bNN == 1) {
                this.bNK.remove();
            } else {
                this.bNJ.remove(this.bNL.getElement());
            }
            this.bNN--;
            this.bNO = false;
        }
    }

    public static <E> a<E> m14479w(E e, int i) {
        return new ImmutableEntry(e, i);
    }

    static int m14477r(Iterable<?> iterable) {
        if (iterable instanceof cdj) {
            return ((cdj) iterable).elementSet().size();
        }
        return 11;
    }

    public static boolean m14471a(cdj<?> com_fossil_cdj_, Object obj) {
        if (obj == com_fossil_cdj_) {
            return true;
        }
        if (!(obj instanceof cdj)) {
            return false;
        }
        cdj com_fossil_cdj = (cdj) obj;
        if (com_fossil_cdj_.size() != com_fossil_cdj.size() || com_fossil_cdj_.entrySet().size() != com_fossil_cdj.entrySet().size()) {
            return false;
        }
        for (a aVar : com_fossil_cdj.entrySet()) {
            if (com_fossil_cdj_.count(aVar.getElement()) != aVar.getCount()) {
                return false;
            }
        }
        return true;
    }

    public static <E> boolean m14473a(cdj<E> com_fossil_cdj_E, Collection<? extends E> collection) {
        if (collection.isEmpty()) {
            return false;
        }
        if (collection instanceof cdj) {
            for (a aVar : m14478s(collection).entrySet()) {
                com_fossil_cdj_E.add(aVar.getElement(), aVar.getCount());
            }
        } else {
            Iterators.m14361a((Collection) com_fossil_cdj_E, collection.iterator());
        }
        return true;
    }

    public static boolean m14475b(cdj<?> com_fossil_cdj_, Collection<?> collection) {
        if (collection instanceof cdj) {
            collection = ((cdj) collection).elementSet();
        }
        return com_fossil_cdj_.elementSet().removeAll(collection);
    }

    public static boolean m14476c(cdj<?> com_fossil_cdj_, Collection<?> collection) {
        cco.ce(collection);
        if (collection instanceof cdj) {
            collection = ((cdj) collection).elementSet();
        }
        return com_fossil_cdj_.elementSet().retainAll(collection);
    }

    public static <E> int m14469a(cdj<E> com_fossil_cdj_E, E e, int i) {
        ccw.n(i, "count");
        int count = com_fossil_cdj_E.count(e);
        int i2 = i - count;
        if (i2 > 0) {
            com_fossil_cdj_E.add(e, i2);
        } else if (i2 < 0) {
            com_fossil_cdj_E.remove(e, -i2);
        }
        return count;
    }

    public static <E> boolean m14472a(cdj<E> com_fossil_cdj_E, E e, int i, int i2) {
        ccw.n(i, "oldCount");
        ccw.n(i2, "newCount");
        if (com_fossil_cdj_E.count(e) != i) {
            return false;
        }
        com_fossil_cdj_E.setCount(e, i2);
        return true;
    }

    public static <E> Iterator<E> m14470a(cdj<E> com_fossil_cdj_E) {
        return new C4362d(com_fossil_cdj_E, com_fossil_cdj_E.entrySet().iterator());
    }

    public static int m14474b(cdj<?> com_fossil_cdj_) {
        long j = 0;
        for (a count : com_fossil_cdj_.entrySet()) {
            j = ((long) count.getCount()) + j;
        }
        return Ints.aw(j);
    }

    static <T> cdj<T> m14478s(Iterable<T> iterable) {
        return (cdj) iterable;
    }
}
