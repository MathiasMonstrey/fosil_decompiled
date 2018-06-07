package com.fossil;

import java.util.AbstractSet;
import java.util.Collection;
import java.util.Iterator;

@Deprecated
public final class axi<E> extends AbstractSet<E> {
    private final jl<E, E> biY = new jl();

    public final boolean add(E e) {
        if (this.biY.containsKey(e)) {
            return false;
        }
        this.biY.put(e, e);
        return true;
    }

    public final boolean addAll(Collection<? extends E> collection) {
        if (!(collection instanceof axi)) {
            return super.addAll(collection);
        }
        axi com_fossil_axi = (axi) collection;
        int size = size();
        this.biY.m11888b(com_fossil_axi.biY);
        return size() > size;
    }

    public final void clear() {
        this.biY.clear();
    }

    public final boolean contains(Object obj) {
        return this.biY.containsKey(obj);
    }

    public final Iterator<E> iterator() {
        return this.biY.keySet().iterator();
    }

    public final boolean remove(Object obj) {
        if (!this.biY.containsKey(obj)) {
            return false;
        }
        this.biY.remove(obj);
        return true;
    }

    public final int size() {
        return this.biY.size();
    }
}
