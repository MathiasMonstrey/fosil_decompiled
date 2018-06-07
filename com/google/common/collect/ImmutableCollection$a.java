package com.google.common.collect;

import com.fossil.cco;
import com.fossil.ccw;
import com.fossil.cdk;
import java.util.Arrays;
import java.util.Collection;

abstract class ImmutableCollection$a<E> extends ImmutableCollection$b<E> {
    Object[] bMs;
    boolean bMt;
    int size = 0;

    public /* synthetic */ ImmutableCollection$b co(Object obj) {
        return cn(obj);
    }

    ImmutableCollection$a(int i) {
        ccw.n(i, "initialCapacity");
        this.bMs = new Object[i];
    }

    private void iw(int i) {
        if (this.bMs.length < i) {
            this.bMs = Arrays.copyOf(this.bMs, ImmutableCollection$b.bQ(this.bMs.length, i));
            this.bMt = false;
        } else if (this.bMt) {
            this.bMs = (Object[]) this.bMs.clone();
            this.bMt = false;
        }
    }

    public ImmutableCollection$a<E> cn(E e) {
        cco.ce(e);
        iw(this.size + 1);
        Object[] objArr = this.bMs;
        int i = this.size;
        this.size = i + 1;
        objArr[i] = e;
        return this;
    }

    public ImmutableCollection$b<E> mo4495e(E... eArr) {
        cdk.l(eArr);
        iw(this.size + eArr.length);
        System.arraycopy(eArr, 0, this.bMs, this.size, eArr.length);
        this.size += eArr.length;
        return this;
    }

    public ImmutableCollection$b<E> mo4494e(Iterable<? extends E> iterable) {
        if (iterable instanceof Collection) {
            Collection collection = (Collection) iterable;
            iw(collection.size() + this.size);
        }
        super.mo4494e((Iterable) iterable);
        return this;
    }
}
