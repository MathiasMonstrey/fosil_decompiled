package com.fossil.wearables.fsl.goaltracking;

import com.j256.ormlite.field.DatabaseField;

public class GoalTracking {
    public static final String COLUMN_CREATED_AT = "createdAt";
    public static final String COLUMN_FREQUENCY = "frequency";
    public static final String COLUMN_ID = "id";
    public static final String COLUMN_NAME = "name";
    public static final String COLUMN_PERIOD_TYPE = "periodType";
    public static final String COLUMN_PERIOD_VALUE = "periodValue";
    public static final String COLUMN_PIN_TYPE = "pinType";
    public static final String COLUMN_SERVER_ID = "serverId";
    public static final String COLUMN_STATUS = "status";
    public static final String COLUMN_TARGET = "target";
    public static final String COLUMN_UPDATED_AT = "updatedAt";
    public static final String COLUMN_URI = "uri";
    @DatabaseField(columnName = "createdAt")
    protected long createdAt;
    @DatabaseField(columnName = "frequency")
    protected int frequency;
    @DatabaseField(columnName = "id", generatedId = true)
    protected long id;
    @DatabaseField(columnName = "name")
    protected String name;
    @DatabaseField(columnName = "periodType")
    protected int periodType;
    @DatabaseField(columnName = "periodValue")
    protected int periodValue;
    @DatabaseField(columnName = "pinType")
    protected int pinType;
    @DatabaseField(columnName = "serverId")
    protected String serverId;
    @DatabaseField(columnName = "status")
    protected int status;
    @DatabaseField(columnName = "target")
    protected int target;
    @DatabaseField(columnName = "updatedAt")
    protected long updatedAt;
    @DatabaseField(columnName = "uri")
    protected String uri;

    public GoalTracking() {
        this.pinType = 0;
    }

    public GoalTracking(String str, Frequency frequency, int i, PeriodType periodType, int i2, GoalStatus goalStatus) {
        this.name = str.trim();
        this.frequency = frequency.getValue();
        this.target = i;
        this.periodType = periodType.getValue();
        this.periodValue = i2;
        this.status = goalStatus.getValue();
        this.uri = GoalTrackingURI.generateURI(this).toASCIIString();
        this.pinType = 0;
    }

    public GoalTracking(GoalTracking goalTracking) {
        this.name = goalTracking.name;
        this.frequency = goalTracking.frequency;
        this.target = goalTracking.target;
        this.periodType = goalTracking.periodType;
        this.periodValue = goalTracking.periodValue;
        this.status = goalTracking.status;
        this.serverId = goalTracking.serverId;
        this.createdAt = goalTracking.createdAt;
        this.updatedAt = goalTracking.updatedAt;
        this.uri = goalTracking.uri;
        this.id = goalTracking.id;
        this.pinType = goalTracking.getPinType();
    }

    public long getId() {
        return this.id;
    }

    public void setId(long j) {
        this.id = j;
    }

    public String getUri() {
        return this.uri;
    }

    public void setUri(String str) {
        this.uri = str;
    }

    public String getServerId() {
        return this.serverId;
    }

    public void setServerId(String str) {
        this.serverId = str;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String str) {
        this.name = str;
    }

    public Frequency getFrequency() {
        return Frequency.fromInt(this.frequency);
    }

    public void setFrequency(Frequency frequency) {
        this.frequency = frequency.getValue();
    }

    public int getTarget() {
        return this.target;
    }

    public void setTarget(int i) {
        this.target = i;
    }

    public long getCreatedAt() {
        return this.createdAt;
    }

    public void setCreatedAt(long j) {
        this.createdAt = j;
    }

    public long getUpdatedAt() {
        return this.updatedAt;
    }

    public void setUpdatedAt(long j) {
        this.updatedAt = j;
    }

    public PeriodType getPeriodType() {
        return PeriodType.fromInt(this.periodType);
    }

    public void setPeriodType(PeriodType periodType) {
        this.periodType = periodType.getValue();
    }

    public int getPeriodValue() {
        return this.periodValue;
    }

    public void setPeriodValue(int i) {
        this.periodValue = i;
    }

    public GoalStatus getStatus() {
        return GoalStatus.fromInt(this.status);
    }

    public void setStatus(GoalStatus goalStatus) {
        this.status = goalStatus.getValue();
    }

    public int getPinType() {
        return this.pinType;
    }

    public void setPinType(int i) {
        this.pinType = i;
    }
}
