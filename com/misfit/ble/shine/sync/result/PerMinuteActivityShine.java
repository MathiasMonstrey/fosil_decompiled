package com.misfit.ble.shine.sync.result;

public class PerMinuteActivityShine {
    public long point;
    public long startTime;
    public long step;

    public PerMinuteActivityShine(long j, long j2) {
        this.startTime = j;
        this.step = j2;
    }

    public PerMinuteActivityShine(long j, long j2, long j3) {
        this.startTime = j;
        this.step = j2;
        this.point = j3;
    }

    public String toString() {
        return String.format("Start time: %d with %d steps", new Object[]{Long.valueOf(this.startTime), Long.valueOf(this.step)});
    }
}
