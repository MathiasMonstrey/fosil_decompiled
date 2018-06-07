package com.misfit.ble.shine.sync.result;

import android.annotation.SuppressLint;

public class GapSession {
    private GapSessionShine f1605s;

    public GapSession() {
        this.f1605s = new GapSessionShine();
    }

    public GapSession(GapSessionShine gapSessionShine) {
        this.f1605s = gapSessionShine;
    }

    public long getBookmarkTimestamp() {
        return this.f1605s.bookmarkTimestamp;
    }

    public long getStartTime() {
        return this.f1605s.startTime;
    }

    public long getDuration() {
        return this.f1605s.duration;
    }

    public long getPoint() {
        return this.f1605s.point;
    }

    public float getDistance() {
        return this.f1605s.distanceInMeter;
    }

    public float getCalorie() {
        return this.f1605s.calorie;
    }

    public long getStep() {
        return this.f1605s.step;
    }

    public int getSType() {
        return this.f1605s.sType;
    }

    @SuppressLint({"DefaultLocale"})
    public String toString() {
        return this.f1605s.toString();
    }
}
