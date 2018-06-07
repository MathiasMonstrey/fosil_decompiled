package com.fossil;

import com.fossil.cdj.C2007a;
import com.google.common.collect.Iterators;
import com.google.common.collect.Multisets;
import com.google.common.collect.Multisets.b;
import com.google.common.collect.Multisets.c;
import java.util.AbstractCollection;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

public abstract class ccu<E> extends AbstractCollection<E> implements cdj<E> {
    private transient Set<E> bMk;
    private transient Set<C2007a<E>> entrySet;

    class C2001a extends b<E> {
        final /* synthetic */ ccu bMl;

        C2001a(ccu com_fossil_ccu) {
            this.bMl = com_fossil_ccu;
        }

        cdj<E> UA() {
            return this.bMl;
        }
    }

    class C2002b extends c<E> {
        final /* synthetic */ ccu bMl;

        C2002b(ccu com_fossil_ccu) {
            this.bMl = com_fossil_ccu;
        }

        cdj<E> UA() {
            return this.bMl;
        }

        public Iterator<C2007a<E>> iterator() {
            return this.bMl.entryIterator();
        }

        public int size() {
            return this.bMl.Uz();
        }
    }

    public abstract int Uz();

    public abstract Iterator<C2007a<E>> entryIterator();

    protected ccu() {
    }

    public int size() {
        return Multisets.b(this);
    }

    public boolean isEmpty() {
        return entrySet().isEmpty();
    }

    public boolean contains(Object obj) {
        return count(obj) > 0;
    }

    public Iterator<E> iterator() {
        return Multisets.a(this);
    }

    public int count(Object obj) {
        for (C2007a c2007a : entrySet()) {
            if (ccn.equal(c2007a.getElement(), obj)) {
                return c2007a.getCount();
            }
        }
        return 0;
    }

    public boolean add(E e) {
        add(e, 1);
        return true;
    }

    public int add(E e, int i) {
        throw new UnsupportedOperationException();
    }

    public boolean remove(Object obj) {
        return remove(obj, 1) > 0;
    }

    public int remove(Object obj, int i) {
        throw new UnsupportedOperationException();
    }

    public int setCount(E e, int i) {
        return Multisets.a(this, e, i);
    }

    public boolean setCount(E e, int i, int i2) {
        return Multisets.a(this, e, i, i2);
    }

    public boolean addAll(Collection<? extends E> collection) {
        return Multisets.a(this, collection);
    }

    public boolean removeAll(Collection<?> collection) {
        return Multisets.b(this, collection);
    }

    public boolean retainAll(Collection<?> collection) {
        return Multisets.c(this, collection);
    }

    public void clear() {
        Iterators.k(entryIterator());
    }

    public Set<E> elementSet() {
        Set<E> set = this.bMk;
        if (set != null) {
            return set;
        }
        set = Uy();
        this.bMk = set;
        return set;
    }

    Set<E> Uy() {
        return new C2001a(this);
    }

    public Set<C2007a<E>> entrySet() {
        Set<C2007a<E>> set = this.entrySet;
        if (set != null) {
            return set;
        }
        set = Uf();
        this.entrySet = set;
        return set;
    }

    public Set<C2007a<E>> Uf() {
        return new C2002b(this);
    }

    public boolean equals(Object obj) {
        return Multisets.a(this, obj);
    }

    public int hashCode() {
        return entrySet().hashCode();
    }

    public String toString() {
        return entrySet().toString();
    }
}
