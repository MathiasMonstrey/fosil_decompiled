package com.fossil;

import android.support.v8.renderscript.Allocation;

public abstract class eqc<T> {
    static final int BUFFER_SIZE = Math.max(1, Integer.getInteger("rx2.buffer-size", Allocation.USAGE_SHARED).intValue());

    public static int aGF() {
        return BUFFER_SIZE;
    }
}
