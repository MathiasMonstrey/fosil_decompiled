package com.misfit.ble.shine.sync.result;

import android.annotation.SuppressLint;
import java.util.ArrayList;
import java.util.List;

public class SleepSession {
    private SleepSessionShine f1610x;

    public SleepSession() {
        this.f1610x = new SleepSessionShine();
    }

    public SleepSession(SleepSessionShine sleepSessionShine) {
        this.f1610x = sleepSessionShine;
    }

    public long getStartTime() {
        return this.f1610x.startTime;
    }

    public long getDuration() {
        return this.f1610x.duration;
    }

    public long getSleepMinute() {
        return this.f1610x.sleepMinute;
    }

    public long getDeepSleepMinute() {
        return this.f1610x.deepSleepMinute;
    }

    public float getSleepQuality() {
        return this.f1610x.sleepQuality;
    }

    public int getTimezoneOffsetInSecond() {
        return this.f1610x.timezoneOffsetInSecond;
    }

    public List<SleepStateChange> getSleepStateChanges() {
        List<SleepStateChangeShine> parseJsonSleepStateChange = this.f1610x.parseJsonSleepStateChange();
        if (parseJsonSleepStateChange == null) {
            return null;
        }
        List<SleepStateChange> arrayList = new ArrayList();
        for (SleepStateChangeShine sleepStateChange : parseJsonSleepStateChange) {
            arrayList.add(new SleepStateChange(sleepStateChange));
        }
        return arrayList;
    }

    @SuppressLint({"DefaultLocale"})
    public String toString() {
        return this.f1610x.toString();
    }
}
