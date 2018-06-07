package com.google.common.collect;

import java.util.Iterator;

public abstract class ImmutableCollection$b<E> {
    public abstract ImmutableCollection$b<E> co(E e);

    static int bQ(int i, int i2) {
        if (i2 < 0) {
            throw new AssertionError("cannot store more than MAX_VALUE elements");
        }
        int i3 = ((i >> 1) + i) + 1;
        if (i3 < i2) {
            i3 = Integer.highestOneBit(i2 - 1) << 1;
        }
        if (i3 < 0) {
            return Integer.MAX_VALUE;
        }
        return i3;
    }

    ImmutableCollection$b() {
    }

    public ImmutableCollection$b<E> mo4495e(E... eArr) {
        for (Object co : eArr) {
            co(co);
        }
        return this;
    }

    public ImmutableCollection$b<E> mo4494e(Iterable<? extends E> iterable) {
        for (Object co : iterable) {
            co(co);
        }
        return this;
    }

    public ImmutableCollection$b<E> mo4496c(Iterator<? extends E> it) {
        while (it.hasNext()) {
            co(it.next());
        }
        return this;
    }
}
