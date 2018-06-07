package com.misfit.ble.shine.sync.result;

import android.annotation.SuppressLint;
import java.util.ArrayList;
import java.util.List;

public class SleepSessionShine {
    public long deepSleepMinute;
    public long duration;
    public long sleepMinute;
    public float sleepQuality;
    public String sleepStateChanges;
    public long startTime;
    public int timezoneOffsetInSecond;

    public List<SleepStateChangeShine> parseJsonSleepStateChange() {
        if (this.sleepStateChanges == null) {
            return null;
        }
        this.sleepStateChanges = this.sleepStateChanges.replace("{", "");
        this.sleepStateChanges = this.sleepStateChanges.replace("}", "");
        if (this.sleepStateChanges.equals("")) {
            return null;
        }
        String[] split = this.sleepStateChanges.split(":");
        List<SleepStateChangeShine> arrayList = new ArrayList();
        for (int i = 0; i < split.length; i++) {
            split[i] = split[i].replace("[", "");
            split[i] = split[i].replace("]", "");
            String[] split2 = split[i].split(",");
            if (!(split2[0].equals("") || split2[1].equals(""))) {
                arrayList.add(new SleepStateChangeShine(Integer.parseInt(split2[0]), Long.parseLong(split2[1])));
            }
        }
        return arrayList;
    }

    @SuppressLint({"DefaultLocale"})
    public String toString() {
        return String.format("{startTime = %d, duration = %d, sleepMinute = %d, deepSleepMinute = %d, sleepQuality = %.3f", new Object[]{Long.valueOf(this.startTime), Long.valueOf(this.duration), Long.valueOf(this.sleepMinute), Long.valueOf(this.deepSleepMinute), Float.valueOf(this.sleepQuality)});
    }
}
