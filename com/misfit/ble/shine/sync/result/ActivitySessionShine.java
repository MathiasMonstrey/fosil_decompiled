package com.misfit.ble.shine.sync.result;

import android.annotation.SuppressLint;
import java.util.ArrayList;
import java.util.List;

public class ActivitySessionShine {
    public long bookmarkTimestamp;
    public float calorie;
    public float distanceInMeter;
    public long duration;
    public String jsonActSession;
    public long laps;
    public long point;
    public long rawPoint;
    public int sType;
    public long startTime;
    public long step;
    public long strokes;
    public int type;

    public ActivitySessionShine(long j, long j2, long j3, long j4, float f, float f2, long j5, int i, int i2, long j6, long j7, long j8) {
        this.bookmarkTimestamp = j;
        this.startTime = j2;
        this.duration = j3;
        this.point = j4;
        this.distanceInMeter = f;
        this.calorie = f2;
        this.step = j5;
        this.sType = i;
        this.type = i2;
        this.rawPoint = j6;
        this.strokes = j7;
        this.laps = j8;
    }

    public List<ActivitySessionShine> parseJsonToActivitySessions() {
        if (this.jsonActSession == null) {
            return null;
        }
        this.jsonActSession = this.jsonActSession.replace("{", "");
        this.jsonActSession = this.jsonActSession.replace("}", "");
        if (this.jsonActSession.equals("")) {
            return null;
        }
        String[] split = this.jsonActSession.split(":");
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < split.length; i++) {
            split[i] = split[i].replace("[", "");
            split[i] = split[i].replace("]", "");
            String[] split2 = split[i].split(",");
            if (!(split2[0].equals("") || split2[1].equals("") || split2[2].equals("") || split2[3].equals("") || split2[5].equals("") || split2[4].equals("") || split2[6].equals("") || split2[7].equals(""))) {
                arrayList.add(new ActivitySessionShine(Long.parseLong(split2[0]), Long.parseLong(split2[1]), Long.parseLong(split2[2]), Long.parseLong(split2[3]), Float.parseFloat(split2[4]), Float.parseFloat(split2[5]), Long.parseLong(split2[6]), Integer.parseInt(split2[7]), Integer.parseInt(split2[8]), Long.parseLong(split2[9]), Long.parseLong(split2[10]), Long.parseLong(split2[11])));
            }
        }
        return arrayList;
    }

    @SuppressLint({"DefaultLocale"})
    public String toString() {
        return String.format("{bookmarkTimestamp = %d, startTime = %d, duration = %d, point = %d, distanceInMeter = %.3f, calorie = %.3f, step = %d, sType = %d, type = %d, rawPoint = %d, strokes = %d, laps = %d}", new Object[]{Long.valueOf(this.bookmarkTimestamp), Long.valueOf(this.startTime), Long.valueOf(this.duration), Long.valueOf(this.point), Float.valueOf(this.distanceInMeter), Float.valueOf(this.calorie), Long.valueOf(this.step), Integer.valueOf(this.sType), Integer.valueOf(this.type), Long.valueOf(this.rawPoint), Long.valueOf(this.strokes), Long.valueOf(this.laps)});
    }
}
