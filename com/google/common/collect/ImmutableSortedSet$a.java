package com.google.common.collect;

import com.fossil.cco;
import java.util.Comparator;
import java.util.Iterator;

public final class ImmutableSortedSet$a<E> extends ImmutableSet$a<E> {
    private final Comparator<? super E> comparator;

    public /* synthetic */ ImmutableSet UN() {
        return UQ();
    }

    public /* synthetic */ ImmutableCollection$b mo4496c(Iterator it) {
        return m14353g(it);
    }

    public /* synthetic */ ImmutableCollection$a cn(Object obj) {
        return cs(obj);
    }

    public /* synthetic */ ImmutableCollection$b co(Object obj) {
        return cs(obj);
    }

    public /* synthetic */ ImmutableSet$a cr(Object obj) {
        return cs(obj);
    }

    public /* synthetic */ ImmutableCollection$b mo4494e(Iterable iterable) {
        return m14357m(iterable);
    }

    public /* synthetic */ ImmutableCollection$b mo4495e(Object[] objArr) {
        return m14356k(objArr);
    }

    public /* synthetic */ ImmutableSet$a mo4510f(Iterator it) {
        return m14353g(it);
    }

    public /* synthetic */ ImmutableSet$a mo4511j(Object[] objArr) {
        return m14356k(objArr);
    }

    public /* synthetic */ ImmutableSet$a mo4512k(Iterable iterable) {
        return m14357m(iterable);
    }

    public ImmutableSortedSet$a(Comparator<? super E> comparator) {
        this.comparator = (Comparator) cco.ce(comparator);
    }

    public ImmutableSortedSet$a<E> cs(E e) {
        super.cr(e);
        return this;
    }

    public ImmutableSortedSet$a<E> m14356k(E... eArr) {
        super.mo4511j(eArr);
        return this;
    }

    public ImmutableSortedSet$a<E> m14357m(Iterable<? extends E> iterable) {
        super.mo4512k(iterable);
        return this;
    }

    public ImmutableSortedSet$a<E> m14353g(Iterator<? extends E> it) {
        super.mo4510f(it);
        return this;
    }

    public ImmutableSortedSet<E> UQ() {
        ImmutableSortedSet<E> construct = ImmutableSortedSet.construct(this.comparator, this.size, this.bMs);
        this.size = construct.size();
        this.bMt = true;
        return construct;
    }
}
