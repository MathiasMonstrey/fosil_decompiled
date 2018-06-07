package com.misfit.ble.parser;

import com.misfit.ble.algorithm.TrackerAlgorithm;
import com.misfit.ble.shine.sync.UserProfile;
import com.misfit.ble.shine.sync.result.ActivityData;
import com.misfit.ble.shine.sync.result.ActivitySession;
import com.misfit.ble.shine.sync.result.ActivitySessionShine;
import com.misfit.ble.shine.sync.result.AutoSleepStateChange;
import com.misfit.ble.shine.sync.result.AutoSleepStateChangeShine;
import com.misfit.ble.shine.sync.result.GapSession;
import com.misfit.ble.shine.sync.result.GapSessionShine;
import com.misfit.ble.shine.sync.result.GraphItem;
import com.misfit.ble.shine.sync.result.GraphItemShine;
import com.misfit.ble.shine.sync.result.MinuteData;
import com.misfit.ble.shine.sync.result.PerMinuteActivityShine;
import com.misfit.ble.shine.sync.result.SessionTimestamp;
import com.misfit.ble.shine.sync.result.SessionTimestampShine;
import com.misfit.ble.shine.sync.result.SleepData;
import com.misfit.ble.shine.sync.result.SleepSession;
import com.misfit.ble.shine.sync.result.SleepSessionShine;
import com.misfit.ble.shine.sync.result.TapEventSummary;
import com.misfit.ble.shine.sync.result.TapEventSummaryShine;
import com.misfit.ble.shine.sync.result.UserProfileShine;
import com.misfit.ble.sync.obfuscated.C4647c;
import java.util.ArrayList;
import java.util.List;

public class SyncSession {
    private final Object f1592h = new Object();
    private TrackerAlgorithm f1593i = new TrackerAlgorithm();
    private long f1594j;
    private List<MinuteData> f1595k;
    private ActivityData f1596l;
    private SleepData f1597m;
    private List<GraphItem> f1598n;
    private List<TapEventSummary> f1599o;

    SyncSession(List<byte[]> list, UserProfile userProfile, int i, int i2, long j) {
        int size = list.size();
        String[] strArr = new String[size];
        for (int i3 = 0; i3 < size; i3++) {
            strArr[i3] = C4647c.m15470a((byte[]) list.get(i3));
        }
        UserProfileShine userProfileShine = null;
        if (userProfile != null) {
            userProfileShine = userProfile.convertToJNIProperty();
        }
        this.f1594j = this.f1593i.initSyncSession(strArr, userProfileShine, i, i2, j);
    }

    public long clearSession() {
        long clearSyncSession;
        synchronized (this.f1592h) {
            this.f1595k = null;
            this.f1596l = null;
            this.f1597m = null;
            this.f1598n = null;
            this.f1599o = null;
            clearSyncSession = this.f1593i.clearSyncSession(this.f1594j);
        }
        return clearSyncSession;
    }

    public List<MinuteData> getMinuteData() {
        synchronized (this.f1592h) {
            if (this.f1595k == null) {
                this.f1595k = new ArrayList();
                PerMinuteActivityShine[] perMinuteActivities = this.f1593i.getPerMinuteActivities(this.f1594j);
                if (!(perMinuteActivities == null || perMinuteActivities.length == 0)) {
                    for (PerMinuteActivityShine minuteData : perMinuteActivities) {
                        this.f1595k.add(new MinuteData(minuteData));
                    }
                }
            }
        }
        return this.f1595k;
    }

    public ActivityData getActivityData() {
        ActivityData activityData;
        synchronized (this.f1592h) {
            if (this.f1596l == null) {
                ActivitySessionShine activitySessionShine = new ActivitySessionShine();
                GapSessionShine gapSessionShine = new GapSessionShine();
                this.f1593i.getActivityAndGapSessions(this.f1594j, activitySessionShine, gapSessionShine);
                List<ActivitySessionShine> parseJsonToActivitySessions = activitySessionShine.parseJsonToActivitySessions();
                List<GapSessionShine> parseJsonGapSessions = gapSessionShine.parseJsonGapSessions();
                List arrayList = new ArrayList();
                List arrayList2 = new ArrayList();
                if (parseJsonToActivitySessions != null) {
                    for (ActivitySessionShine activitySessionShine2 : parseJsonToActivitySessions) {
                        arrayList.add(new ActivitySession(activitySessionShine2));
                    }
                }
                if (parseJsonGapSessions != null) {
                    for (GapSessionShine gapSession : parseJsonGapSessions) {
                        arrayList2.add(new GapSession(gapSession));
                    }
                }
                this.f1596l = new ActivityData(arrayList, arrayList2);
            }
            activityData = this.f1596l;
        }
        return activityData;
    }

    public SleepData getSleepData(List<AutoSleepStateChange> list, List<SessionTimestamp> list2, List<SessionTimestamp> list3, SessionTimestamp sessionTimestamp, List<Float> list4) {
        synchronized (this.f1592h) {
            if (this.f1597m == null) {
                int size;
                int i;
                List arrayList;
                List list5;
                AutoSleepStateChangeShine[] autoSleepStateChangeShineArr = null;
                if (list != null) {
                    size = list.size();
                    autoSleepStateChangeShineArr = new AutoSleepStateChangeShine[size];
                    for (i = 0; i < size; i++) {
                        autoSleepStateChangeShineArr[i] = ((AutoSleepStateChange) list.get(i)).convertToJNIProperty();
                    }
                }
                SessionTimestampShine[] sessionTimestampShineArr = null;
                if (list2 != null) {
                    size = list2.size();
                    sessionTimestampShineArr = new SessionTimestampShine[size];
                    for (i = 0; i < size; i++) {
                        sessionTimestampShineArr[i] = ((SessionTimestamp) list2.get(i)).convertToJNIProperty();
                    }
                }
                SessionTimestampShine[] sessionTimestampShineArr2 = null;
                if (list3 != null) {
                    size = list3.size();
                    sessionTimestampShineArr2 = new SessionTimestampShine[size];
                    for (i = 0; i < size; i++) {
                        sessionTimestampShineArr2[i] = ((SessionTimestamp) list3.get(i)).convertToJNIProperty();
                    }
                }
                SessionTimestampShine sessionTimestampShine = null;
                if (sessionTimestamp != null) {
                    sessionTimestampShine = sessionTimestamp.convertToJNIProperty();
                }
                float[] fArr = null;
                if (list4 != null) {
                    size = list4.size();
                    fArr = new float[size];
                    for (i = 0; i < size; i++) {
                        fArr[i] = ((Float) list4.get(i)).floatValue();
                    }
                }
                SleepSessionShine[] sleepSessions = this.f1593i.getSleepSessions(this.f1594j, autoSleepStateChangeShineArr, sessionTimestampShineArr, sessionTimestampShineArr2, sessionTimestampShine, fArr);
                if (sleepSessions != null) {
                    arrayList = new ArrayList();
                    for (SleepSessionShine sleepSession : sleepSessions) {
                        arrayList.add(new SleepSession(sleepSession));
                    }
                    list5 = arrayList;
                } else {
                    list5 = null;
                }
                arrayList = null;
                if (sessionTimestampShine != null) {
                    List<SessionTimestampShine> parseJsonSessionTimestampShine = sessionTimestampShine.parseJsonSessionTimestampShine();
                    if (parseJsonSessionTimestampShine != null) {
                        List arrayList2 = new ArrayList();
                        for (SessionTimestampShine sessionTimestamp2 : parseJsonSessionTimestampShine) {
                            arrayList2.add(new SessionTimestamp(sessionTimestamp2));
                        }
                        arrayList = arrayList2;
                    }
                }
                this.f1597m = new SleepData(list5, arrayList);
            }
        }
        return this.f1597m;
    }

    public List<GraphItem> getGraphItems() {
        synchronized (this.f1592h) {
            if (this.f1598n == null) {
                GraphItemShine[] graphItems = this.f1593i.getGraphItems(this.f1594j);
                if (graphItems == null || graphItems.length == 0) {
                    this.f1598n = new ArrayList();
                } else {
                    List arrayList = new ArrayList();
                    for (GraphItemShine graphItem : graphItems) {
                        arrayList.add(new GraphItem(graphItem));
                    }
                    this.f1598n = arrayList;
                }
            }
        }
        return this.f1598n;
    }

    public List<TapEventSummary> getTapEventSummaries() {
        synchronized (this.f1592h) {
            if (this.f1599o == null) {
                TapEventSummaryShine[] tapEventSummary = this.f1593i.getTapEventSummary(this.f1594j);
                if (tapEventSummary == null || tapEventSummary.length == 0) {
                    this.f1599o = new ArrayList();
                } else {
                    List arrayList = new ArrayList();
                    for (TapEventSummaryShine tapEventSummary2 : tapEventSummary) {
                        arrayList.add(new TapEventSummary(tapEventSummary2));
                    }
                    this.f1599o = arrayList;
                }
            }
        }
        return this.f1599o;
    }

    long m15235a() {
        return this.f1594j;
    }

    TrackerAlgorithm m15236b() {
        return this.f1593i;
    }

    protected void finalize() throws Throwable {
        clearSession();
        super.finalize();
    }
}
