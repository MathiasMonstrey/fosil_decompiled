package com.misfit.ble.shine.sync.result;

import java.util.List;

public class SleepData {
    public List<SessionTimestamp> idleSessionTimestamps;
    public List<SleepSession> sleepSessions;

    public SleepData(List<SleepSession> list, List<SessionTimestamp> list2) {
        this.sleepSessions = list;
        this.idleSessionTimestamps = list2;
    }
}
