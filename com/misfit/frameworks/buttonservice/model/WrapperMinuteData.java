package com.misfit.frameworks.buttonservice.model;

import com.misfit.ble.shine.sync.result.MinuteData;
import org.parceler.Parcel;
import org.parceler.ParcelConstructor;

@Parcel
public class WrapperMinuteData {
    public long id;
    public long points;
    public long startTime;
    public long steps;

    @ParcelConstructor
    public WrapperMinuteData(long j, long j2, long j3, long j4) {
        this.id = j;
        this.startTime = j2;
        this.steps = j3;
        this.points = j4;
    }

    public static WrapperMinuteData cloneFrom(MinuteData minuteData) {
        if (minuteData == null) {
            return null;
        }
        return new WrapperMinuteData(minuteData.getMinuteId(), minuteData.getStartTime(), minuteData.getStep(), minuteData.getPoint());
    }

    public static MinuteData toMinuteData(WrapperMinuteData wrapperMinuteData) {
        return new MinuteData(wrapperMinuteData.id, wrapperMinuteData.startTime, wrapperMinuteData.steps, wrapperMinuteData.points);
    }

    public String toString() {
        return "[WrapperMinuteData: start=" + this.startTime + ", steps=" + this.steps + ", point=" + this.points + "]";
    }
}
