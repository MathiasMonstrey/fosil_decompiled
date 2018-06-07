package com.misfit.frameworks.buttonservice.model;

import com.misfit.ble.shine.sync.result.TapEventSummary;
import org.parceler.Parcel;
import org.parceler.ParcelConstructor;

@Parcel
public class WrapperTapEventSummary {
    public long doubleTapCount;
    public long[] goalTrackingIds;
    public long startTime;
    public long tripleTapCount;

    @ParcelConstructor
    public WrapperTapEventSummary(long j, long j2, long j3, long[] jArr) {
        this.startTime = j;
        this.doubleTapCount = j2;
        this.tripleTapCount = j3;
        this.goalTrackingIds = jArr;
    }

    public static WrapperTapEventSummary cloneFrom(TapEventSummary tapEventSummary) {
        return new WrapperTapEventSummary(tapEventSummary.getStartTime(), tapEventSummary.getDoubleTapCount(), tapEventSummary.getTripleTapCount(), tapEventSummary.getGoalID());
    }
}
