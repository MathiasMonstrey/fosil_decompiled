package com.misfit.frameworks.buttonservice.log;

import android.content.Context;

public class MFSyncLog extends MFLog {
    private long activityPoint = -1;
    private int activityTaggingState = -1;
    private String alarm = "";
    private int battery = -1;
    private long goal = -1;
    private int phoneTimestamp = 0;
    private long postSyncActivityPoint = -1;
    private long postSyncGoal = -1;
    private int postSyncTimezone = -1;
    private long realTimeStep = 0;
    private int retries = -1;
    private int rssi = -1;
    private int syncMode = -1;
    private int timezone = -1;
    private long todaySumMinuteDataStep = 0;
    private int watchTimestamp = 0;

    public MFSyncLog(Context context) {
        super(context);
    }

    public void setActivityPoint(long j) {
        this.activityPoint = j;
    }

    public long getActivityPoint() {
        return this.activityPoint;
    }

    public void setPostSyncActivityPoint(long j) {
        this.postSyncActivityPoint = j;
    }

    public long getPostSyncActivityPoint() {
        return this.postSyncActivityPoint;
    }

    public void setTimezone(int i) {
        this.timezone = i;
    }

    public int getTimezone() {
        return this.timezone;
    }

    public void setPostSyncTimezone(int i) {
        this.postSyncTimezone = i;
    }

    public int getPostSyncTimezone() {
        return this.postSyncTimezone;
    }

    public void setGoal(long j) {
        this.goal = j;
    }

    public long getGoal() {
        return this.goal;
    }

    public void setPostSyncGoal(long j) {
        this.postSyncGoal = j;
    }

    public long getPostSyncGoal() {
        return this.postSyncGoal;
    }

    public void setBattery(int i) {
        this.battery = i;
    }

    public int getBattery() {
        return this.battery;
    }

    public void setRetries(int i) {
        this.retries = i;
    }

    public int getRetries() {
        return this.retries;
    }

    public int getSyncMode() {
        return this.syncMode;
    }

    public void setSyncMode(int i) {
        this.syncMode = i;
    }

    public int getActivityTaggingState() {
        return this.activityTaggingState;
    }

    public void setActivityTaggingState(int i) {
        this.activityTaggingState = i;
    }

    public String getAlarm() {
        return this.alarm;
    }

    public void setAlarm(String str) {
        this.alarm = str;
    }

    public int getRssi() {
        return this.rssi;
    }

    public void setRssi(int i) {
        this.rssi = i;
    }

    public int getWatchTimestamp() {
        return this.watchTimestamp;
    }

    public void setWatchTimestamp(int i) {
        this.watchTimestamp = i;
    }

    public int getPhoneTimestamp() {
        return this.phoneTimestamp;
    }

    public void setPhoneTimestamp(int i) {
        this.phoneTimestamp = i;
    }

    public long getRealTimeStep() {
        return this.realTimeStep;
    }

    public void setRealTimeStep(long j) {
        this.realTimeStep = j;
    }

    public long getTodaySumMinuteDataStep() {
        return this.todaySumMinuteDataStep;
    }

    public void setTodaySumMinuteDataStep(long j) {
        this.todaySumMinuteDataStep = j;
    }

    public int getLogType() {
        return 1;
    }
}
