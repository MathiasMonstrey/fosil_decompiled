package com.misfit.frameworks.buttonservice.model;

import com.misfit.ble.shine.sync.result.ActivitySession;
import com.misfit.ble.shine.sync.result.GapSession;
import org.parceler.Parcel;
import org.parceler.ParcelConstructor;

@Parcel
public class WrapperActivitySync {
    protected long mBipedalCount;
    protected float mCalories;
    protected float mDistance;
    protected long mEndTimestamp;
    protected long mPoints;
    protected long mStartTimestamp;
    protected int mVariance;

    @ParcelConstructor
    public WrapperActivitySync(long j, long j2, long j3, long j4, int i, float f, float f2) {
        this.mStartTimestamp = j;
        this.mEndTimestamp = j2;
        this.mBipedalCount = j3;
        this.mPoints = j4;
        this.mVariance = i;
        this.mCalories = f;
        this.mDistance = f2;
    }

    public int getmVariance() {
        return this.mVariance;
    }

    public void setmVariance(int i) {
        this.mVariance = i;
    }

    public long getmStartTimestamp() {
        return this.mStartTimestamp;
    }

    public void setmStartTimestamp(long j) {
        this.mStartTimestamp = j;
    }

    public long getmEndTimestamp() {
        return this.mEndTimestamp;
    }

    public void setmEndTimestamp(long j) {
        this.mEndTimestamp = j;
    }

    public long getmPoints() {
        return this.mPoints;
    }

    public void setmPoints(long j) {
        this.mPoints = j;
    }

    public long getmBipedalCount() {
        return this.mBipedalCount;
    }

    public void setmBipedalCount(long j) {
        this.mBipedalCount = j;
    }

    public float getCalories() {
        return this.mCalories;
    }

    public void setCalories(float f) {
        this.mCalories = f;
    }

    public float getDistance() {
        return this.mDistance;
    }

    public void setDistance(float f) {
        this.mDistance = f;
    }

    public boolean equals(Object obj) {
        if (obj instanceof WrapperActivitySync) {
            WrapperActivitySync wrapperActivitySync = (WrapperActivitySync) obj;
            if (this.mStartTimestamp == wrapperActivitySync.mStartTimestamp && this.mEndTimestamp == wrapperActivitySync.mEndTimestamp && this.mPoints == wrapperActivitySync.mPoints && this.mBipedalCount == wrapperActivitySync.mBipedalCount && this.mVariance == wrapperActivitySync.mVariance) {
                return true;
            }
        }
        return false;
    }

    public static WrapperActivitySync cloneFrom(GapSession gapSession) {
        if (gapSession == null) {
            return null;
        }
        return new WrapperActivitySync(gapSession.getStartTime(), gapSession.getStartTime() + gapSession.getDuration(), gapSession.getStep(), gapSession.getPoint(), gapSession.getSType(), gapSession.getCalorie(), gapSession.getDistance());
    }

    public static WrapperActivitySync cloneFrom(ActivitySession activitySession) {
        if (activitySession == null) {
            return null;
        }
        return new WrapperActivitySync(activitySession.getStartTime(), activitySession.getStartTime() + activitySession.getDuration(), activitySession.getStep(), activitySession.getPoint(), activitySession.getSType(), activitySession.getCalorie(), activitySession.getDistance());
    }

    public int hashCode() {
        return (int) ((((this.mStartTimestamp + this.mEndTimestamp) + this.mPoints) + this.mBipedalCount) + ((long) this.mVariance));
    }

    public String toString() {
        return "[WrapperActivitySync: startTime=" + this.mStartTimestamp + ", endTime=" + this.mEndTimestamp + ", points=" + this.mPoints + ", steps=" + this.mBipedalCount + ", distance=" + this.mDistance + ", calories=" + this.mCalories + "]";
    }
}
