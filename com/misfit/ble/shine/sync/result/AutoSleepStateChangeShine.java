package com.misfit.ble.shine.sync.result;

public class AutoSleepStateChangeShine {
    public int state;
    public long timestamp;

    public AutoSleepStateChangeShine(long j, int i) {
        this.timestamp = j;
        this.state = i;
    }
}
