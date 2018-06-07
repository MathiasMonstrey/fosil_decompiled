package com.google.common.collect;

import com.fossil.cdj.a;
import com.fossil.cdt;
import java.util.Iterator;

class ImmutableMultiset$1 extends cdt<E> {
    int aAB;
    final /* synthetic */ Iterator bLX;
    E element;
    final /* synthetic */ ImmutableMultiset this$0;

    ImmutableMultiset$1(ImmutableMultiset immutableMultiset, Iterator it) {
        this.this$0 = immutableMultiset;
        this.bLX = it;
    }

    public boolean hasNext() {
        return this.aAB > 0 || this.bLX.hasNext();
    }

    public E next() {
        if (this.aAB <= 0) {
            a aVar = (a) this.bLX.next();
            this.element = aVar.getElement();
            this.aAB = aVar.getCount();
        }
        this.aAB--;
        return this.element;
    }
}
