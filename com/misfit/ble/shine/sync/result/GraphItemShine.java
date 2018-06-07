package com.misfit.ble.shine.sync.result;

import android.annotation.SuppressLint;

public class GraphItemShine {
    public float averagePoint;
    public long endTime;
    public long startTime;

    @SuppressLint({"DefaultLocale"})
    public String toString() {
        return String.format("{startTime = %d, endTime = %d, averagePoint = %.3f}", new Object[]{Long.valueOf(this.startTime), Long.valueOf(this.endTime), Float.valueOf(this.averagePoint)});
    }
}
