package com.misfit.ble.shine.sync.result;

import android.annotation.SuppressLint;

public class SleepStateChange {
    private SleepStateChangeShine f1611y;

    public SleepStateChange() {
        this.f1611y = new SleepStateChangeShine();
    }

    public SleepStateChange(int i, long j) {
        this.f1611y = new SleepStateChangeShine(i, j);
    }

    public SleepStateChange(SleepStateChangeShine sleepStateChangeShine) {
        this.f1611y = sleepStateChangeShine;
    }

    public int getState() {
        return this.f1611y.state;
    }

    public long getIndex() {
        return this.f1611y.index;
    }

    @SuppressLint({"DefaultLocale"})
    public String toString() {
        return this.f1611y.toString();
    }
}
