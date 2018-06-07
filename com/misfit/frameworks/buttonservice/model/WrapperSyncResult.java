package com.misfit.frameworks.buttonservice.model;

import com.fossil.cfj;
import com.misfit.ble.parser.MetricAlgorithm;
import com.misfit.ble.parser.SyncSession;
import com.misfit.ble.shine.sync.UserProfile;
import com.misfit.ble.shine.sync.result.MinuteData;
import com.misfit.ble.shine.sync.result.SessionTimestamp;
import com.misfit.ble.shine.sync.result.SleepData;
import com.misfit.ble.shine.sync.result.SleepSession;
import com.misfit.ble.shine.sync.result.TapEventSummary;
import java.util.ArrayList;
import java.util.List;
import org.parceler.Parcel;
import org.parceler.ParcelConstructor;

@Parcel
public class WrapperSyncResult {
    public float calories;
    public float distance;
    public List<String> fileIds;
    public List<WrapperMinuteData> minuteDataList;
    public long realTimeStep;
    public List<WrapperSleep> sleepSessions;
    public List<WrapperTapEventSummary> tapEventSummaryList;
    public int vibeStrengthLevel;

    @ParcelConstructor
    public WrapperSyncResult(List<WrapperSleep> list, List<WrapperMinuteData> list2, List<WrapperTapEventSummary> list3, List<String> list4, float f, float f2, long j, int i) {
        this.sleepSessions = list;
        this.minuteDataList = list2;
        this.tapEventSummaryList = list3;
        this.calories = f;
        this.distance = f2;
        this.fileIds = list4;
        this.realTimeStep = j;
        this.vibeStrengthLevel = i;
    }

    public List<WrapperSleep> getSleep() {
        return this.sleepSessions;
    }

    public List<WrapperMinuteData> getMinuteDataList() {
        return this.minuteDataList;
    }

    public List<WrapperTapEventSummary> getTapEventSummaryList() {
        return this.tapEventSummaryList;
    }

    public List<String> getFileIds() {
        return this.fileIds;
    }

    public float getCalories() {
        return this.calories;
    }

    public float getDistance() {
        return this.distance;
    }

    public long getRealTimeStep() {
        return this.realTimeStep;
    }

    public int getVibeStrengthLevel() {
        return this.vibeStrengthLevel;
    }

    public static WrapperSyncResult cloneFrom(SyncSession syncSession, UserProfile userProfile, List<String> list, long j, int i) {
        List arrayList = new ArrayList();
        List arrayList2 = new ArrayList();
        List arrayList3 = new ArrayList();
        float f = 0.0f;
        float f2 = 0.0f;
        if (syncSession != null) {
            SleepData sleepData = syncSession.getSleepData(null, null, null, new SessionTimestamp(), null);
            if (!(sleepData == null || sleepData.sleepSessions == null)) {
                for (SleepSession cloneFrom : sleepData.sleepSessions) {
                    arrayList.add(WrapperSleep.cloneFrom(cloneFrom));
                }
            }
            if (syncSession.getMinuteData() != null) {
                for (MinuteData cloneFrom2 : syncSession.getMinuteData()) {
                    arrayList2.add(WrapperMinuteData.cloneFrom(cloneFrom2));
                }
            }
            UserProfile userProfile2 = new UserProfile(userProfile.age, userProfile.height, userProfile.weight, userProfile.gender);
            f = MetricAlgorithm.calculateCalories(userProfile2, syncSession.getMinuteData());
            f2 = MetricAlgorithm.calculateDistance(userProfile2, syncSession.getMinuteData());
            for (TapEventSummary cloneFrom3 : syncSession.getTapEventSummaries()) {
                arrayList3.add(WrapperTapEventSummary.cloneFrom(cloneFrom3));
            }
        }
        return new WrapperSyncResult(arrayList, arrayList2, arrayList3, list, f, f2, j, i);
    }

    public String toJson() {
        return new cfj().m6204b(this, new 1(this).getType());
    }

    public static WrapperSyncResult fromJson(String str) {
        return (WrapperSyncResult) new cfj().m6197a(str, new 2().getType());
    }
}
