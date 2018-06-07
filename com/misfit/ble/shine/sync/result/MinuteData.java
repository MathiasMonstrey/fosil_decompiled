package com.misfit.ble.shine.sync.result;

public class MinuteData {
    private long f1607u;
    private PerMinuteActivityShine f1608v;

    public MinuteData() {
        this.f1608v = new PerMinuteActivityShine();
    }

    public MinuteData(long j, long j2) {
        this.f1607u = j / 60;
        this.f1608v = new PerMinuteActivityShine(j, j2);
    }

    public MinuteData(long j, long j2, long j3) {
        this.f1607u = j / 60;
        this.f1608v = new PerMinuteActivityShine(j, j2, j3);
    }

    public MinuteData(long j, long j2, long j3, long j4) {
        this.f1607u = j;
        this.f1608v = new PerMinuteActivityShine(j2, j3, j4);
    }

    public MinuteData(PerMinuteActivityShine perMinuteActivityShine) {
        this.f1607u = perMinuteActivityShine.startTime / 60;
        this.f1608v = perMinuteActivityShine;
    }

    public long getMinuteId() {
        return this.f1607u;
    }

    public long getStartTime() {
        return this.f1608v.startTime;
    }

    public long getStep() {
        return this.f1608v.step;
    }

    public long getPoint() {
        return this.f1608v.point;
    }
}
