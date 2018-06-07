package com.misfit.ble.shine.sync.result;

import android.annotation.SuppressLint;

public class SleepStateChangeShine {
    public long index;
    public int state;

    public SleepStateChangeShine(int i, long j) {
        this.state = i;
        this.index = j;
    }

    @SuppressLint({"DefaultLocale"})
    public String toString() {
        return String.format("{state = %d, index = %d}", new Object[]{Integer.valueOf(this.state), Long.valueOf(this.index)});
    }
}
