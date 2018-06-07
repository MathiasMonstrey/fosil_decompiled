package com.misfit.frameworks.buttonservice.model;

import com.misfit.ble.shine.sync.result.SleepSession;
import com.misfit.ble.shine.sync.result.SleepStateChange;
import java.util.ArrayList;
import java.util.List;
import org.parceler.Parcel;
import org.parceler.ParcelConstructor;

@Parcel
public class WrapperSleep {
    public long deepSleepMinute;
    public long duration;
    public long sleepMinute;
    public float sleepQuality;
    List<WrapperSleepStateChange> sleepStateChanges;
    public long startTime;

    @ParcelConstructor
    public WrapperSleep(long j, long j2, long j3, long j4, float f, List<WrapperSleepStateChange> list) {
        this.startTime = j;
        this.duration = j2;
        this.sleepMinute = j3;
        this.deepSleepMinute = j4;
        this.sleepQuality = f;
        this.sleepStateChanges = list;
    }

    public static WrapperSleep cloneFrom(SleepSession sleepSession) {
        if (sleepSession == null) {
            return null;
        }
        List arrayList = new ArrayList();
        for (SleepStateChange sleepStateChange : sleepSession.getSleepStateChanges()) {
            arrayList.add(new WrapperSleepStateChange(sleepStateChange.getState(), sleepStateChange.getIndex()));
        }
        return new WrapperSleep(sleepSession.getStartTime(), sleepSession.getDuration(), sleepSession.getSleepMinute(), sleepSession.getDeepSleepMinute(), sleepSession.getSleepQuality(), arrayList);
    }

    public List<WrapperSleepStateChange> getSleepStateChanges() {
        return this.sleepStateChanges;
    }
}
