package com.misfit.ble.shine.sync.result;

public class AutoSleepStateChange {
    private AutoSleepStateChangeShine f1604r;

    public AutoSleepStateChange() {
        this.f1604r = new AutoSleepStateChangeShine();
    }

    public AutoSleepStateChange(long j, int i) {
        this.f1604r = new AutoSleepStateChangeShine(j, i);
    }

    public AutoSleepStateChange(AutoSleepStateChangeShine autoSleepStateChangeShine) {
        this.f1604r = autoSleepStateChangeShine;
    }

    public long getTimestamp() {
        return this.f1604r.timestamp;
    }

    public int getState() {
        return this.f1604r.state;
    }

    public AutoSleepStateChangeShine convertToJNIProperty() {
        return this.f1604r;
    }
}
