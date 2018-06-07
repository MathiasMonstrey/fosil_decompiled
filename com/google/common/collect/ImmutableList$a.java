package com.google.common.collect;

import java.util.Iterator;

public final class ImmutableList$a<E> extends ImmutableCollection$a<E> {
    public /* synthetic */ ImmutableCollection$b mo4496c(Iterator it) {
        return m14308d(it);
    }

    public /* synthetic */ ImmutableCollection$a cn(Object obj) {
        return cp(obj);
    }

    public /* synthetic */ ImmutableCollection$b co(Object obj) {
        return cp(obj);
    }

    public /* synthetic */ ImmutableCollection$b mo4494e(Iterable iterable) {
        return m14311f(iterable);
    }

    public /* synthetic */ ImmutableCollection$b mo4495e(Object[] objArr) {
        return m14312g(objArr);
    }

    public ImmutableList$a() {
        this(4);
    }

    ImmutableList$a(int i) {
        super(i);
    }

    public ImmutableList$a<E> cp(E e) {
        super.cn(e);
        return this;
    }

    public ImmutableList$a<E> m14311f(Iterable<? extends E> iterable) {
        super.mo4494e((Iterable) iterable);
        return this;
    }

    public ImmutableList$a<E> m14312g(E... eArr) {
        super.mo4495e((Object[]) eArr);
        return this;
    }

    public ImmutableList$a<E> m14308d(Iterator<? extends E> it) {
        super.mo4496c(it);
        return this;
    }

    public ImmutableList<E> UF() {
        this.bMt = true;
        return ImmutableList.asImmutableList(this.bMs, this.size);
    }
}
