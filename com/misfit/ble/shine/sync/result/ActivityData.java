package com.misfit.ble.shine.sync.result;

import java.util.List;

public class ActivityData {
    public List<ActivitySession> activitySessions;
    public List<GapSession> gapSessions;

    public ActivityData(List<ActivitySession> list, List<GapSession> list2) {
        this.activitySessions = list;
        this.gapSessions = list2;
    }
}
