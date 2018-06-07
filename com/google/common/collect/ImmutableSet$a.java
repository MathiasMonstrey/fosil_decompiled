package com.google.common.collect;

import java.util.Iterator;

public class ImmutableSet$a<E> extends ImmutableCollection$a<E> {
    public /* synthetic */ ImmutableCollection$b mo4496c(Iterator it) {
        return mo4510f(it);
    }

    public /* synthetic */ ImmutableCollection$a cn(Object obj) {
        return cr(obj);
    }

    public /* synthetic */ ImmutableCollection$b co(Object obj) {
        return cr(obj);
    }

    public /* synthetic */ ImmutableCollection$b mo4494e(Iterable iterable) {
        return mo4512k(iterable);
    }

    public /* synthetic */ ImmutableCollection$b mo4495e(Object[] objArr) {
        return mo4511j(objArr);
    }

    public ImmutableSet$a() {
        this(4);
    }

    ImmutableSet$a(int i) {
        super(i);
    }

    public ImmutableSet$a<E> cr(E e) {
        super.cn(e);
        return this;
    }

    public ImmutableSet$a<E> mo4511j(E... eArr) {
        super.mo4495e((Object[]) eArr);
        return this;
    }

    public ImmutableSet$a<E> mo4512k(Iterable<? extends E> iterable) {
        super.mo4494e((Iterable) iterable);
        return this;
    }

    public ImmutableSet$a<E> mo4510f(Iterator<? extends E> it) {
        super.mo4496c(it);
        return this;
    }

    public ImmutableSet<E> UN() {
        ImmutableSet<E> access$000 = ImmutableSet.access$000(this.size, this.bMs);
        this.size = access$000.size();
        this.bMt = true;
        return access$000;
    }
}
