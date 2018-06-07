package com.misfit.ble.algorithm;

import com.misfit.ble.shine.sync.result.ActivitySessionShine;
import com.misfit.ble.shine.sync.result.AutoSleepStateChangeShine;
import com.misfit.ble.shine.sync.result.GapSessionShine;
import com.misfit.ble.shine.sync.result.GraphItemShine;
import com.misfit.ble.shine.sync.result.PerMinuteActivityShine;
import com.misfit.ble.shine.sync.result.SessionTimestampShine;
import com.misfit.ble.shine.sync.result.SleepSessionShine;
import com.misfit.ble.shine.sync.result.TapEventSummaryShine;
import com.misfit.ble.shine.sync.result.UserProfileShine;

public class TrackerAlgorithm {
    public native long clearSyncSession(long j);

    public native void getActivityAndGapSessions(long j, ActivitySessionShine activitySessionShine, GapSessionShine gapSessionShine);

    public native String getErrorMessage(long j);

    public native GraphItemShine[] getGraphItems(long j);

    public native PerMinuteActivityShine[] getPerMinuteActivities(long j);

    public native SleepSessionShine[] getSleepSessions(long j, AutoSleepStateChangeShine[] autoSleepStateChangeShineArr, SessionTimestampShine[] sessionTimestampShineArr, SessionTimestampShine[] sessionTimestampShineArr2, SessionTimestampShine sessionTimestampShine, float[] fArr);

    public native TapEventSummaryShine[] getTapEventSummary(long j);

    public native long initSyncSession(String[] strArr, UserProfileShine userProfileShine, int i, int i2, long j);

    static {
        System.loadLibrary("LibMisfitAlgorithm");
    }
}
