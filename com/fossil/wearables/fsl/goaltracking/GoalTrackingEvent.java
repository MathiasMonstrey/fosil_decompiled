package com.fossil.wearables.fsl.goaltracking;

import com.j256.ormlite.field.DatabaseField;

public class GoalTrackingEvent {
    public static final String COLUMN_AUTO_DETECTED = "autoDetected";
    public static final String COLUMN_COUNTER = "counter";
    public static final String COLUMN_DATE = "date";
    public static final String COLUMN_GOAL_ID = "goalId";
    public static final String COLUMN_PIN_TYPE = "pinType";
    public static final String COLUMN_TRACKED_AT = "trackedAt";
    public static final String COLUMN_URI = "uri";
    @DatabaseField(columnName = "autoDetected")
    protected boolean autoDetected;
    @DatabaseField(columnName = "counter")
    protected int counter;
    @DatabaseField(columnName = "date")
    protected int date;
    @DatabaseField(columnName = "goalId", foreign = true, foreignAutoRefresh = true)
    protected GoalTracking goalTracking;
    @DatabaseField(columnName = "pinType")
    private int pinType = 0;
    @DatabaseField(columnName = "trackedAt")
    protected long trackedAt;
    @DatabaseField(columnName = "uri", id = true)
    protected String uri = GoalTrackingURI.generateEventURI(this).toASCIIString();

    public GoalTrackingEvent(int i, long j, GoalTracking goalTracking) {
        this.date = i;
        this.trackedAt = j;
        this.goalTracking = goalTracking;
    }

    public GoalTracking getGoalTracking() {
        return this.goalTracking;
    }

    public void setGoalTracking(GoalTracking goalTracking) {
        this.goalTracking = goalTracking;
    }

    public String getUri() {
        return this.uri;
    }

    public void setUri(String str) {
        this.uri = str;
    }

    public int getDate() {
        return this.date;
    }

    public void setDate(int i) {
        this.date = i;
    }

    public long getTrackedAt() {
        return this.trackedAt;
    }

    public void setTrackedAt(long j) {
        this.trackedAt = j;
    }

    public void setCounter(int i) {
        this.counter = i;
    }

    public int getCounter() {
        return this.counter;
    }

    public void setAutoDetected(boolean z) {
        this.autoDetected = z;
    }

    public boolean isAutoDetected() {
        return this.autoDetected;
    }

    public int getPinType() {
        return this.pinType;
    }

    public void setPinType(int i) {
        this.pinType = i;
    }
}
