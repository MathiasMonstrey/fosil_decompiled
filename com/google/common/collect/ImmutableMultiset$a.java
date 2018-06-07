package com.google.common.collect;

import com.fossil.cco;
import com.fossil.ccv;
import com.fossil.cdj;
import com.fossil.cdj.a;
import com.fossil.cdl;
import java.util.Iterator;

public class ImmutableMultiset$a<E> extends ImmutableCollection$b<E> {
    ccv<E> bMQ;
    boolean bMR;
    boolean bMS;

    public /* synthetic */ ImmutableCollection$b mo4496c(Iterator it) {
        return m14333e(it);
    }

    public /* synthetic */ ImmutableCollection$b co(Object obj) {
        return cq(obj);
    }

    public /* synthetic */ ImmutableCollection$b mo4494e(Iterable iterable) {
        return m14335j(iterable);
    }

    public /* synthetic */ ImmutableCollection$b mo4495e(Object[] objArr) {
        return m14334i(objArr);
    }

    public ImmutableMultiset$a() {
        this(4);
    }

    ImmutableMultiset$a(int i) {
        this.bMR = false;
        this.bMS = false;
        this.bMQ = cdl.iH(i);
    }

    public ImmutableMultiset$a<E> cq(E e) {
        return m14336v(e, 1);
    }

    public ImmutableMultiset$a<E> m14336v(E e, int i) {
        if (i != 0) {
            if (this.bMR) {
                this.bMQ = new cdl(this.bMQ);
                this.bMS = false;
            }
            this.bMR = false;
            cco.ce(e);
            this.bMQ.u(e, this.bMQ.get(e) + i);
        }
        return this;
    }

    public ImmutableMultiset$a<E> m14334i(E... eArr) {
        super.mo4495e((Object[]) eArr);
        return this;
    }

    public ImmutableMultiset$a<E> m14335j(Iterable<? extends E> iterable) {
        if (iterable instanceof cdj) {
            for (a aVar : Multisets.m14478s(iterable).entrySet()) {
                m14336v(aVar.getElement(), aVar.getCount());
            }
        } else {
            super.mo4494e((Iterable) iterable);
        }
        return this;
    }

    public ImmutableMultiset$a<E> m14333e(Iterator<? extends E> it) {
        super.mo4496c(it);
        return this;
    }

    public ImmutableMultiset<E> UM() {
        if (this.bMQ.isEmpty()) {
            return ImmutableMultiset.of();
        }
        if (this.bMS) {
            this.bMQ = new cdl(this.bMQ);
            this.bMS = false;
        }
        this.bMR = true;
        return new RegularImmutableMultiset((cdl) this.bMQ);
    }
}
