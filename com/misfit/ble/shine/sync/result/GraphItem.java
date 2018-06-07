package com.misfit.ble.shine.sync.result;

import android.annotation.SuppressLint;

public class GraphItem {
    private GraphItemShine f1606t;

    public GraphItem() {
        this.f1606t = new GraphItemShine();
    }

    public GraphItem(GraphItemShine graphItemShine) {
        this.f1606t = graphItemShine;
    }

    public long getStartTime() {
        return this.f1606t.startTime;
    }

    public long getEndTime() {
        return this.f1606t.endTime;
    }

    public float getAveragePoint() {
        return this.f1606t.averagePoint;
    }

    @SuppressLint({"DefaultLocale"})
    public String toString() {
        return this.f1606t.toString();
    }
}
