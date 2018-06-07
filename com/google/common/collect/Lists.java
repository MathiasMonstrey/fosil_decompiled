package com.google.common.collect;

import com.fossil.ccn;
import com.fossil.cco;
import com.fossil.ccx;
import com.fossil.cdv;
import java.io.Serializable;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;

public final class Lists {

    static class OnePlusArrayList<E> extends AbstractList<E> implements Serializable, RandomAccess {
        private static final long serialVersionUID = 0;
        final E first;
        final E[] rest;

        OnePlusArrayList(E e, E[] eArr) {
            this.first = e;
            this.rest = (Object[]) cco.ce(eArr);
        }

        public int size() {
            return cdv.bT(this.rest.length, 1);
        }

        public E get(int i) {
            cco.bO(i, size());
            return i == 0 ? this.first : this.rest[i - 1];
        }
    }

    public static <E> ArrayList<E> UU() {
        return new ArrayList();
    }

    public static <E> ArrayList<E> m14378q(Iterable<? extends E> iterable) {
        cco.ce(iterable);
        if (iterable instanceof Collection) {
            return new ArrayList(ccx.c(iterable));
        }
        return m14377l(iterable.iterator());
    }

    public static <E> ArrayList<E> m14377l(Iterator<? extends E> it) {
        Collection UU = UU();
        Iterators.m14361a(UU, (Iterator) it);
        return UU;
    }

    public static <E> List<E> m14371a(E e, E[] eArr) {
        return new OnePlusArrayList(e, eArr);
    }

    static boolean m14372a(List<?> list, Object obj) {
        if (obj == cco.ce(list)) {
            return true;
        }
        if (!(obj instanceof List)) {
            return false;
        }
        List list2 = (List) obj;
        int size = list.size();
        if (size != list2.size()) {
            return false;
        }
        if (!(list instanceof RandomAccess) || !(list2 instanceof RandomAccess)) {
            return Iterators.m14364a(list.iterator(), list2.iterator());
        }
        for (int i = 0; i < size; i++) {
            if (!ccn.equal(list.get(i), list2.get(i))) {
                return false;
            }
        }
        return true;
    }

    static int m14373b(List<?> list, Object obj) {
        if (list instanceof RandomAccess) {
            return m14374c(list, obj);
        }
        ListIterator listIterator = list.listIterator();
        while (listIterator.hasNext()) {
            if (ccn.equal(obj, listIterator.next())) {
                return listIterator.previousIndex();
            }
        }
        return -1;
    }

    private static int m14374c(List<?> list, Object obj) {
        int i = 0;
        int size = list.size();
        if (obj == null) {
            while (i < size) {
                if (list.get(i) == null) {
                    return i;
                }
                i++;
            }
        } else {
            while (i < size) {
                if (obj.equals(list.get(i))) {
                    return i;
                }
                i++;
            }
        }
        return -1;
    }

    static int m14375d(List<?> list, Object obj) {
        if (list instanceof RandomAccess) {
            return m14376e(list, obj);
        }
        ListIterator listIterator = list.listIterator(list.size());
        while (listIterator.hasPrevious()) {
            if (ccn.equal(obj, listIterator.previous())) {
                return listIterator.nextIndex();
            }
        }
        return -1;
    }

    private static int m14376e(List<?> list, Object obj) {
        int size;
        if (obj == null) {
            for (size = list.size() - 1; size >= 0; size--) {
                if (list.get(size) == null) {
                    return size;
                }
            }
        } else {
            for (size = list.size() - 1; size >= 0; size--) {
                if (obj.equals(list.get(size))) {
                    return size;
                }
            }
        }
        return -1;
    }
}
