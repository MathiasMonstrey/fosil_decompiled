package com.google.common.collect;

import com.fossil.cdj;
import com.fossil.cdj.C2007a;
import com.fossil.cdt;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;

public abstract class ImmutableMultiset<E> extends ImmutableMultisetGwtSerializationDependencies<E> implements cdj<E> {
    private transient ImmutableList<E> bMP;
    private transient ImmutableSet<C2007a<E>> bMw;

    public abstract ImmutableSet<E> elementSet();

    abstract C2007a<E> getEntry(int i);

    public static <E> ImmutableMultiset<E> of() {
        return RegularImmutableMultiset.EMPTY;
    }

    public static <E> ImmutableMultiset<E> of(E e) {
        return m12660h(e);
    }

    public static <E> ImmutableMultiset<E> of(E e, E e2) {
        return m12660h(e, e2);
    }

    public static <E> ImmutableMultiset<E> of(E e, E e2, E e3) {
        return m12660h(e, e2, e3);
    }

    public static <E> ImmutableMultiset<E> of(E e, E e2, E e3, E e4) {
        return m12660h(e, e2, e3, e4);
    }

    public static <E> ImmutableMultiset<E> of(E e, E e2, E e3, E e4, E e5) {
        return m12660h(e, e2, e3, e4, e5);
    }

    public static <E> ImmutableMultiset<E> of(E e, E e2, E e3, E e4, E e5, E e6, E... eArr) {
        return new a().cq(e).cq(e2).cq(e3).cq(e4).cq(e5).cq(e6).i(eArr).UM();
    }

    public static <E> ImmutableMultiset<E> copyOf(E[] eArr) {
        return m12660h(eArr);
    }

    public static <E> ImmutableMultiset<E> copyOf(Iterable<? extends E> iterable) {
        if (iterable instanceof ImmutableMultiset) {
            ImmutableMultiset<E> immutableMultiset = (ImmutableMultiset) iterable;
            if (!immutableMultiset.isPartialView()) {
                return immutableMultiset;
            }
        }
        a aVar = new a(Multisets.r(iterable));
        aVar.j(iterable);
        return aVar.UM();
    }

    private static <E> ImmutableMultiset<E> m12660h(E... eArr) {
        return new a().i(eArr).UM();
    }

    static <E> ImmutableMultiset<E> copyFromEntries(Collection<? extends C2007a<? extends E>> collection) {
        a aVar = new a(collection.size());
        for (C2007a c2007a : collection) {
            aVar.v(c2007a.getElement(), c2007a.getCount());
        }
        return aVar.UM();
    }

    public static <E> ImmutableMultiset<E> copyOf(Iterator<? extends E> it) {
        return new a().e(it).UM();
    }

    ImmutableMultiset() {
    }

    public cdt<E> iterator() {
        return new 1(this, entrySet().iterator());
    }

    public ImmutableList<E> asList() {
        ImmutableList<E> immutableList = this.bMP;
        if (immutableList != null) {
            return immutableList;
        }
        immutableList = super.asList();
        this.bMP = immutableList;
        return immutableList;
    }

    public boolean contains(Object obj) {
        return count(obj) > 0;
    }

    @Deprecated
    public final int add(E e, int i) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public final int remove(Object obj, int i) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public final int setCount(E e, int i) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public final boolean setCount(E e, int i, int i2) {
        throw new UnsupportedOperationException();
    }

    int copyIntoArray(Object[] objArr, int i) {
        Iterator it = entrySet().iterator();
        while (it.hasNext()) {
            C2007a c2007a = (C2007a) it.next();
            Arrays.fill(objArr, i, c2007a.getCount() + i, c2007a.getElement());
            i += c2007a.getCount();
        }
        return i;
    }

    public boolean equals(Object obj) {
        return Multisets.a(this, obj);
    }

    public int hashCode() {
        return Sets.h(entrySet());
    }

    public String toString() {
        return entrySet().toString();
    }

    public ImmutableSet<C2007a<E>> entrySet() {
        ImmutableSet<C2007a<E>> immutableSet = this.bMw;
        if (immutableSet != null) {
            return immutableSet;
        }
        immutableSet = createEntrySet();
        this.bMw = immutableSet;
        return immutableSet;
    }

    private final ImmutableSet<C2007a<E>> createEntrySet() {
        return isEmpty() ? ImmutableSet.of() : new EntrySet(this, null);
    }

    Object writeReplace() {
        return new SerializedForm(this);
    }

    public static <E> a<E> builder() {
        return new a();
    }
}
