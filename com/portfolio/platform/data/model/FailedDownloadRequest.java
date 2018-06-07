package com.portfolio.platform.data.model;

import java.io.Serializable;

public class FailedDownloadRequest implements Serializable {
    public static int GOAL_EVENT = 6;
    public static int GOAL_SUMMARY = 5;
    public static int GOAL_TRACKING = 4;
    public static int NO_LIMIT = -1;
    public static int NO_OFFSET = -1;
    public static int SAMPLE_DAY = 0;
    public static int SAMPLE_RAW = 1;
    public static int SLEEP_DAY = 2;
    public static int SLEEP_SESSION = 3;
    private String extra;
    private String from;
    private int limit;
    private int offset;
    private int requestCode;
    private String to;

    public FailedDownloadRequest(int i, String str, String str2, int i2, int i3) {
        this.requestCode = i;
        this.from = str;
        this.to = str2;
        this.offset = i2;
        this.limit = i3;
    }

    public FailedDownloadRequest(int i, String str, String str2, int i2, int i3, String str3) {
        this(i, str, str2, i2, i3);
        this.extra = str3;
    }

    public int getRequestCode() {
        return this.requestCode;
    }

    public void setRequestCode(int i) {
        this.requestCode = i;
    }

    public String getFrom() {
        return this.from;
    }

    public void setFrom(String str) {
        this.from = str;
    }

    public String getTo() {
        return this.to;
    }

    public void setTo(String str) {
        this.to = str;
    }

    public int getOffset() {
        return this.offset;
    }

    public void setOffset(int i) {
        this.offset = i;
    }

    public int getLimit() {
        return this.limit;
    }

    public void setLimit(int i) {
        this.limit = i;
    }

    public String getExtra() {
        return this.extra;
    }

    public void setExtra(String str) {
        this.extra = str;
    }
}
