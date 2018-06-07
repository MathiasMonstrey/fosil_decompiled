package com.misfit.ble.shine.sync.result;

public class TapEventSummary {
    private TapEventSummaryShine f1612z;

    public TapEventSummary() {
        this.f1612z = new TapEventSummaryShine();
    }

    public TapEventSummary(TapEventSummaryShine tapEventSummaryShine) {
        this.f1612z = tapEventSummaryShine;
    }

    public long getStartTime() {
        return this.f1612z.startTime;
    }

    public long getDoubleTapCount() {
        return this.f1612z.doubleTapCount;
    }

    public long getTripleTapCount() {
        return this.f1612z.tripleTapCount;
    }

    public long[] getGoalID() {
        this.f1612z.parseJsonStringGoalTrackingToArray();
        return this.f1612z.arrGoalTrackingID;
    }

    public String toString() {
        return this.f1612z.toString();
    }
}
