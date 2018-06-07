package com.google.common.collect;

import com.fossil.cco;
import com.fossil.cdj;
import com.fossil.cdq;
import com.fossil.cdt;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Set;

final class RegularImmutableSortedSet<E> extends ImmutableSortedSet<E> {
    static final RegularImmutableSortedSet<Comparable> NATURAL_EMPTY_SET = new RegularImmutableSortedSet(ImmutableList.of(), Ordering.natural());
    final transient ImmutableList<E> elements;

    RegularImmutableSortedSet(ImmutableList<E> immutableList, Comparator<? super E> comparator) {
        super(comparator);
        this.elements = immutableList;
    }

    public cdt<E> iterator() {
        return this.elements.iterator();
    }

    public cdt<E> descendingIterator() {
        return this.elements.reverse().iterator();
    }

    public int size() {
        return this.elements.size();
    }

    public boolean contains(Object obj) {
        if (obj == null) {
            return false;
        }
        try {
            return cx(obj) >= 0;
        } catch (ClassCastException e) {
            return false;
        }
    }

    public boolean containsAll(Collection<?> collection) {
        if (collection instanceof cdj) {
            collection = ((cdj) collection).elementSet();
        }
        if (!cdq.a(comparator(), collection) || collection.size() <= 1) {
            return super.containsAll(collection);
        }
        Iterator it = iterator();
        Iterator it2 = collection.iterator();
        if (!it.hasNext()) {
            return false;
        }
        Object next = it2.next();
        Object next2 = it.next();
        while (true) {
            try {
                int unsafeCompare = unsafeCompare(next2, next);
                if (unsafeCompare < 0) {
                    if (!it.hasNext()) {
                        return false;
                    }
                    next2 = it.next();
                } else if (unsafeCompare == 0) {
                    if (!it2.hasNext()) {
                        return true;
                    }
                    next = it2.next();
                } else if (unsafeCompare > 0) {
                    return false;
                }
            } catch (NullPointerException e) {
                return false;
            } catch (ClassCastException e2) {
                return false;
            }
        }
    }

    private int cx(Object obj) throws ClassCastException {
        return Collections.binarySearch(this.elements, obj, unsafeComparator());
    }

    boolean isPartialView() {
        return this.elements.isPartialView();
    }

    int copyIntoArray(Object[] objArr, int i) {
        return this.elements.copyIntoArray(objArr, i);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Set)) {
            return false;
        }
        Set set = (Set) obj;
        if (size() != set.size()) {
            return false;
        }
        if (isEmpty()) {
            return true;
        }
        if (!cdq.a(this.comparator, set)) {
            return containsAll(set);
        }
        Iterator it = set.iterator();
        try {
            Iterator it2 = iterator();
            while (it2.hasNext()) {
                Object next = it2.next();
                Object next2 = it.next();
                if (next2 != null) {
                    if (unsafeCompare(next, next2) != 0) {
                    }
                }
                return false;
            }
            return true;
        } catch (ClassCastException e) {
            return false;
        } catch (NoSuchElementException e2) {
            return false;
        }
    }

    public E first() {
        if (!isEmpty()) {
            return this.elements.get(0);
        }
        throw new NoSuchElementException();
    }

    public E last() {
        if (!isEmpty()) {
            return this.elements.get(size() - 1);
        }
        throw new NoSuchElementException();
    }

    public E lower(E e) {
        int headIndex = headIndex(e, false) - 1;
        return headIndex == -1 ? null : this.elements.get(headIndex);
    }

    public E floor(E e) {
        int headIndex = headIndex(e, true) - 1;
        return headIndex == -1 ? null : this.elements.get(headIndex);
    }

    public E ceiling(E e) {
        int tailIndex = tailIndex(e, true);
        return tailIndex == size() ? null : this.elements.get(tailIndex);
    }

    public E higher(E e) {
        int tailIndex = tailIndex(e, false);
        return tailIndex == size() ? null : this.elements.get(tailIndex);
    }

    ImmutableSortedSet<E> headSetImpl(E e, boolean z) {
        return getSubSet(0, headIndex(e, z));
    }

    int headIndex(E e, boolean z) {
        int binarySearch = Collections.binarySearch(this.elements, cco.ce(e), comparator());
        if (binarySearch < 0) {
            return binarySearch ^ -1;
        }
        if (z) {
            return binarySearch + 1;
        }
        return binarySearch;
    }

    ImmutableSortedSet<E> subSetImpl(E e, boolean z, E e2, boolean z2) {
        return tailSetImpl(e, z).headSetImpl(e2, z2);
    }

    ImmutableSortedSet<E> tailSetImpl(E e, boolean z) {
        return getSubSet(tailIndex(e, z), size());
    }

    int tailIndex(E e, boolean z) {
        int binarySearch = Collections.binarySearch(this.elements, cco.ce(e), comparator());
        if (binarySearch < 0) {
            return binarySearch ^ -1;
        }
        if (z) {
            return binarySearch;
        }
        return binarySearch + 1;
    }

    Comparator<Object> unsafeComparator() {
        return this.comparator;
    }

    RegularImmutableSortedSet<E> getSubSet(int i, int i2) {
        if (i == 0 && i2 == size()) {
            return this;
        }
        if (i < i2) {
            return new RegularImmutableSortedSet(this.elements.subList(i, i2), this.comparator);
        }
        return emptySet(this.comparator);
    }

    int indexOf(Object obj) {
        if (obj == null) {
            return -1;
        }
        try {
            int binarySearch = Collections.binarySearch(this.elements, obj, unsafeComparator());
            if (binarySearch < 0) {
                binarySearch = -1;
            }
            return binarySearch;
        } catch (ClassCastException e) {
            return -1;
        }
    }

    public ImmutableList<E> asList() {
        return this.elements;
    }

    ImmutableSortedSet<E> createDescendingSet() {
        Comparator reverseOrder = Collections.reverseOrder(this.comparator);
        if (isEmpty()) {
            return emptySet(reverseOrder);
        }
        return new RegularImmutableSortedSet(this.elements.reverse(), reverseOrder);
    }
}
