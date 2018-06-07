package com.fossil;

import java.util.Comparator;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.SortedSet;

public abstract class cde<E> extends cdd<E> implements SortedSet<E> {
    protected abstract SortedSet<E> delegate();

    protected cde() {
    }

    public Comparator<? super E> comparator() {
        return delegate().comparator();
    }

    public E first() {
        return delegate().first();
    }

    public SortedSet<E> headSet(E e) {
        return delegate().headSet(e);
    }

    public E last() {
        return delegate().last();
    }

    public SortedSet<E> subSet(E e, E e2) {
        return delegate().subSet(e, e2);
    }

    public SortedSet<E> tailSet(E e) {
        return delegate().tailSet(e);
    }

    private int unsafeCompare(Object obj, Object obj2) {
        Comparator comparator = comparator();
        if (comparator == null) {
            return ((Comparable) obj).compareTo(obj2);
        }
        return comparator.compare(obj, obj2);
    }

    protected boolean standardContains(Object obj) {
        try {
            if (unsafeCompare(tailSet(obj).first(), obj) == 0) {
                return true;
            }
            return false;
        } catch (ClassCastException e) {
            return false;
        } catch (NoSuchElementException e2) {
            return false;
        } catch (NullPointerException e3) {
            return false;
        }
    }

    protected boolean standardRemove(Object obj) {
        try {
            Iterator it = tailSet(obj).iterator();
            if (!it.hasNext() || unsafeCompare(it.next(), obj) != 0) {
                return false;
            }
            it.remove();
            return true;
        } catch (ClassCastException e) {
            return false;
        } catch (NullPointerException e2) {
            return false;
        }
    }

    protected SortedSet<E> standardSubSet(E e, E e2) {
        return tailSet(e).headSet(e2);
    }
}
