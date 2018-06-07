package com.fossil;

import com.google.common.collect.Iterators;
import java.util.Collection;
import java.util.Iterator;

public abstract class ccz<E> extends cdc implements Collection<E> {
    protected abstract Collection<E> delegate();

    protected ccz() {
    }

    public Iterator<E> iterator() {
        return delegate().iterator();
    }

    public int size() {
        return delegate().size();
    }

    public boolean removeAll(Collection<?> collection) {
        return delegate().removeAll(collection);
    }

    public boolean isEmpty() {
        return delegate().isEmpty();
    }

    public boolean contains(Object obj) {
        return delegate().contains(obj);
    }

    public boolean add(E e) {
        return delegate().add(e);
    }

    public boolean remove(Object obj) {
        return delegate().remove(obj);
    }

    public boolean containsAll(Collection<?> collection) {
        return delegate().containsAll(collection);
    }

    public boolean addAll(Collection<? extends E> collection) {
        return delegate().addAll(collection);
    }

    public boolean retainAll(Collection<?> collection) {
        return delegate().retainAll(collection);
    }

    public void clear() {
        delegate().clear();
    }

    public Object[] toArray() {
        return delegate().toArray();
    }

    public <T> T[] toArray(T[] tArr) {
        return delegate().toArray(tArr);
    }

    protected boolean standardContains(Object obj) {
        return Iterators.a(iterator(), obj);
    }

    protected boolean standardContainsAll(Collection<?> collection) {
        return ccx.m6002a((Collection) this, (Collection) collection);
    }

    protected boolean standardAddAll(Collection<? extends E> collection) {
        return Iterators.a(this, collection.iterator());
    }

    protected boolean standardRemove(Object obj) {
        Iterator it = iterator();
        while (it.hasNext()) {
            if (ccn.equal(it.next(), obj)) {
                it.remove();
                return true;
            }
        }
        return false;
    }

    protected boolean standardRemoveAll(Collection<?> collection) {
        return Iterators.a(iterator(), collection);
    }

    protected boolean standardRetainAll(Collection<?> collection) {
        return Iterators.b(iterator(), collection);
    }

    protected void standardClear() {
        Iterators.k(iterator());
    }

    protected boolean standardIsEmpty() {
        return !iterator().hasNext();
    }

    protected String standardToString() {
        return ccx.m6004f(this);
    }

    protected Object[] standardToArray() {
        return toArray(new Object[size()]);
    }

    protected <T> T[] standardToArray(T[] tArr) {
        return cdk.m6015a(this, tArr);
    }
}
