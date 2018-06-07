package com.misfit.ble.shine.sync.result;

import android.annotation.SuppressLint;

public class ActivitySession {
    private ActivitySessionShine f1603q;

    public ActivitySession() {
        this.f1603q = new ActivitySessionShine();
    }

    public ActivitySession(ActivitySessionShine activitySessionShine) {
        this.f1603q = activitySessionShine;
    }

    public long getBookmarkTimestamp() {
        return this.f1603q.bookmarkTimestamp;
    }

    public long getStartTime() {
        return this.f1603q.startTime;
    }

    public long getDuration() {
        return this.f1603q.duration;
    }

    public long getPoint() {
        return this.f1603q.point;
    }

    public float getDistance() {
        return this.f1603q.distanceInMeter;
    }

    public float getCalorie() {
        return this.f1603q.calorie;
    }

    public long getStep() {
        return this.f1603q.step;
    }

    public int getSType() {
        return this.f1603q.sType;
    }

    public int getType() {
        return this.f1603q.type;
    }

    public long getRawPoint() {
        return this.f1603q.rawPoint;
    }

    public long getStrokes() {
        return this.f1603q.strokes;
    }

    public long getLaps() {
        return this.f1603q.laps;
    }

    @SuppressLint({"DefaultLocale"})
    public String toString() {
        return this.f1603q.toString();
    }
}
