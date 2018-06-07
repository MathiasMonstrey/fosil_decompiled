package com.google.common.collect;

import com.fossil.ccr;

class ImmutableList$1 extends ccr<E> {
    final /* synthetic */ ImmutableList this$0;

    ImmutableList$1(ImmutableList immutableList, int i, int i2) {
        this.this$0 = immutableList;
        super(i, i2);
    }

    protected E get(int i) {
        return this.this$0.get(i);
    }
}
