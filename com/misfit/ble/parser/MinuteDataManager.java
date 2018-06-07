package com.misfit.ble.parser;

import android.content.Context;
import com.misfit.ble.shine.sync.result.MinuteData;
import com.misfit.ble.shine.sync.result.TimeRange;
import com.misfit.ble.sync.obfuscated.C4646b;
import java.util.ArrayList;
import java.util.List;

public class MinuteDataManager {
    public static final long DEFAULT_ACTIVE_DURATION = 259200;
    public static final long DEFAULT_TIME_TO_LIVE = 2592000;
    private static MinuteDataManager f1588d;
    private C4646b f1589e;
    private long f1590f = DEFAULT_TIME_TO_LIVE;
    private long f1591g = DEFAULT_ACTIVE_DURATION;

    static {
        System.loadLibrary("LibMisfitAlgorithm");
    }

    public void setTimeToLive(long j) {
        this.f1590f = j;
    }

    public void setActiveDuration(long j) {
        this.f1591g = j;
    }

    private MinuteDataManager(Context context) {
        this.f1589e = C4646b.m15466a(context);
    }

    public static MinuteDataManager getInstance(Context context) {
        if (f1588d == null) {
            f1588d = new MinuteDataManager(context);
        }
        return f1588d;
    }

    public void dispose() {
        if (this.f1589e != null) {
            this.f1589e.dispose();
        }
        f1588d = null;
    }

    public TimeRange mergeMinuteData(List<MinuteData> list, long j) {
        long j2 = 0;
        long j3 = j - this.f1591g;
        if (list.size() == 0 || j < 0 || j3 < 0) {
            return new TimeRange(0, 0);
        }
        this.f1589e.m15467a(j - this.f1590f);
        List a = m15234a(this.f1589e.m15469a(j3, j), list, j3);
        this.f1589e.m15468a(a);
        if (a.size() > 0) {
            j3 = ((MinuteData) a.get(0)).getStartTime();
            j2 = ((MinuteData) a.get(a.size() - 1)).getStartTime() + 60;
        } else {
            j3 = 0;
        }
        return new TimeRange(j3, j2);
    }

    public List<MinuteData> getMinuteDataInRange(TimeRange timeRange) {
        return this.f1589e.m15469a(timeRange.startTime, timeRange.endTime);
    }

    public int clearAllMinuteData() {
        return this.f1589e.clearAllMinuteData();
    }

    private List<MinuteData> m15234a(List<MinuteData> list, List<MinuteData> list2, long j) {
        for (MinuteData minuteData : list) {
            MinuteData minuteData2;
            if (minuteData2.getStartTime() < j) {
                list.remove(minuteData2);
            }
        }
        for (MinuteData minuteData22 : list2) {
            if (minuteData22.getStartTime() < j) {
                list2.remove(minuteData22);
            }
        }
        if (list2.isEmpty()) {
            return new ArrayList();
        }
        if (list.isEmpty()) {
            return list2;
        }
        List<MinuteData> arrayList = new ArrayList();
        long min = Math.min(((MinuteData) list.get(0)).getMinuteId(), ((MinuteData) list2.get(0)).getMinuteId());
        long max = Math.max(((MinuteData) list.get(list.size() - 1)).getMinuteId(), ((MinuteData) list2.get(list2.size() - 1)).getMinuteId());
        long j2 = min;
        int i = 0;
        int i2 = 0;
        while (j2 <= max) {
            int i3 = i;
            while (i3 < list.size() - 1 && ((MinuteData) list.get(i3)).getMinuteId() < j2) {
                i3++;
            }
            while (i2 < list2.size() - 1 && ((MinuteData) list2.get(i2)).getMinuteId() < j2) {
                i2++;
            }
            MinuteData minuteData3 = ((MinuteData) list.get(i3)).getMinuteId() == j2 ? (MinuteData) list.get(i3) : null;
            minuteData22 = ((MinuteData) list2.get(i2)).getMinuteId() == j2 ? (MinuteData) list2.get(i2) : null;
            if (minuteData3 == null || minuteData22 == null) {
                if (minuteData22 != null) {
                    arrayList.add(minuteData22);
                }
            } else if (minuteData3.getStep() < minuteData22.getStep()) {
                arrayList.add(minuteData22);
            }
            j2++;
            i = i3;
        }
        return arrayList;
    }

    protected void finalize() throws Throwable {
        dispose();
        super.finalize();
    }
}
