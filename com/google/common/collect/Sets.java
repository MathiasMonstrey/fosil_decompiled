package com.google.common.collect;

import com.fossil.cco;
import com.fossil.cde;
import com.fossil.cdj;
import java.io.Serializable;
import java.util.AbstractSet;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.NavigableSet;
import java.util.Set;
import java.util.SortedSet;

public final class Sets {

    static abstract class C4278a<E> extends AbstractSet<E> {
        C4278a() {
        }

        public boolean removeAll(Collection<?> collection) {
            return Sets.m14480a((Set) this, (Collection) collection);
        }

        public boolean retainAll(Collection<?> collection) {
            return super.retainAll((Collection) cco.ce(collection));
        }
    }

    static final class UnmodifiableNavigableSet<E> extends cde<E> implements Serializable, NavigableSet<E> {
        private static final long serialVersionUID = 0;
        private transient UnmodifiableNavigableSet<E> bOb;
        private final NavigableSet<E> delegate;
        private final SortedSet<E> unmodifiableDelegate;

        UnmodifiableNavigableSet(NavigableSet<E> navigableSet) {
            this.delegate = (NavigableSet) cco.ce(navigableSet);
            this.unmodifiableDelegate = Collections.unmodifiableSortedSet(navigableSet);
        }

        protected SortedSet<E> delegate() {
            return this.unmodifiableDelegate;
        }

        public E lower(E e) {
            return this.delegate.lower(e);
        }

        public E floor(E e) {
            return this.delegate.floor(e);
        }

        public E ceiling(E e) {
            return this.delegate.ceiling(e);
        }

        public E higher(E e) {
            return this.delegate.higher(e);
        }

        public E pollFirst() {
            throw new UnsupportedOperationException();
        }

        public E pollLast() {
            throw new UnsupportedOperationException();
        }

        public NavigableSet<E> descendingSet() {
            NavigableSet<E> navigableSet = this.bOb;
            if (navigableSet != null) {
                return navigableSet;
            }
            NavigableSet unmodifiableNavigableSet = new UnmodifiableNavigableSet(this.delegate.descendingSet());
            this.bOb = unmodifiableNavigableSet;
            unmodifiableNavigableSet.bOb = this;
            return unmodifiableNavigableSet;
        }

        public Iterator<E> descendingIterator() {
            return Iterators.m14367h(this.delegate.descendingIterator());
        }

        public NavigableSet<E> subSet(E e, boolean z, E e2, boolean z2) {
            return Sets.m14482b(this.delegate.subSet(e, z, e2, z2));
        }

        public NavigableSet<E> headSet(E e, boolean z) {
            return Sets.m14482b(this.delegate.headSet(e, z));
        }

        public NavigableSet<E> tailSet(E e, boolean z) {
            return Sets.m14482b(this.delegate.tailSet(e, z));
        }
    }

    public static <E> HashSet<E> VC() {
        return new HashSet();
    }

    public static <E> HashSet<E> iN(int i) {
        return new HashSet(Maps.iC(i));
    }

    public static <E> LinkedHashSet<E> iO(int i) {
        return new LinkedHashSet(Maps.iC(i));
    }

    public static int m14484h(Set<?> set) {
        int i = 0;
        for (Object next : set) {
            int hashCode;
            if (next != null) {
                hashCode = next.hashCode();
            } else {
                hashCode = 0;
            }
            i = ((i + hashCode) ^ -1) ^ -1;
        }
        return i;
    }

    public static boolean m14483b(Set<?> set, Object obj) {
        boolean z = true;
        if (set == obj) {
            return true;
        }
        if (!(obj instanceof Set)) {
            return false;
        }
        Set set2 = (Set) obj;
        try {
            if (!(set.size() == set2.size() && set.containsAll(set2))) {
                z = false;
            }
            return z;
        } catch (NullPointerException e) {
            return false;
        } catch (ClassCastException e2) {
            return false;
        }
    }

    public static <E> NavigableSet<E> m14482b(NavigableSet<E> navigableSet) {
        return ((navigableSet instanceof ImmutableSortedSet) || (navigableSet instanceof UnmodifiableNavigableSet)) ? navigableSet : new UnmodifiableNavigableSet(navigableSet);
    }

    static boolean m14481a(Set<?> set, Iterator<?> it) {
        boolean z = false;
        while (it.hasNext()) {
            z |= set.remove(it.next());
        }
        return z;
    }

    public static boolean m14480a(Set<?> set, Collection<?> collection) {
        cco.ce(collection);
        if (collection instanceof cdj) {
            Collection elementSet = ((cdj) collection).elementSet();
        }
        if (!(elementSet instanceof Set) || elementSet.size() <= set.size()) {
            return m14481a((Set) set, elementSet.iterator());
        }
        return Iterators.m14363a(set.iterator(), elementSet);
    }
}
