package com.misfit.ble.setting.sam;

public class CountdownSettings {
    private long be;
    private long bf;
    private short bg;
    private short mTimezoneOffset;

    public CountdownSettings(long j, long j2, short s) {
        this.be = j;
        this.bf = j2;
        this.mTimezoneOffset = s;
    }

    public CountdownSettings(long j, long j2, short s, short s2) {
        this.be = j;
        this.bf = j2;
        this.mTimezoneOffset = s;
        this.bg = s2;
    }

    public long getStartTimeInUTCSeconds() {
        return this.be;
    }

    public long getEndTimeInUTCSeconds() {
        return this.bf;
    }

    public short getTimezoneOffset() {
        return this.mTimezoneOffset;
    }

    public short getProgress() {
        return this.bg;
    }

    public String toString() {
        return "startTime: " + this.be + ", endTime: " + this.bf + ", timezoneOffset: " + this.mTimezoneOffset + ", progress: " + this.bg;
    }
}
