package com.fossil.wearables.fsl.fitness;

import com.j256.ormlite.field.DatabaseField;
import java.io.Serializable;
import java.net.URI;

public class SampleDay implements Serializable {
    public static final String COLUMN_CALORIES = "calories";
    public static final String COLUMN_CREATED_AT = "createdAt";
    public static final String COLUMN_DAY = "day";
    public static final String COLUMN_DISTANCE = "distance";
    public static final String COLUMN_DST_OFFSET = "dstOffset";
    public static final String COLUMN_ID = "id";
    public static final String COLUMN_MONTH = "month";
    public static final String COLUMN_PIN_TYPE = "pinType";
    public static final String COLUMN_STEPS = "steps";
    public static final String COLUMN_TIMEZONE_NAME = "timezoneName";
    public static final String COLUMN_UPDATED_AT = "updatedAt";
    public static final String COLUMN_YEAR = "year";
    public static final String TABLE_NAME = "sampleday";
    @DatabaseField(columnName = "calories")
    protected double calories;
    @DatabaseField(columnName = "createdAt")
    protected long createdAt;
    @DatabaseField(columnName = "day")
    protected int day;
    @DatabaseField(columnName = "distance")
    protected double distance;
    @DatabaseField(columnName = "dstOffset")
    protected int dstOffset;
    protected DailyGoal goal;
    @DatabaseField(columnName = "id", id = true)
    protected String id;
    @DatabaseField(columnName = "month")
    protected int month;
    @DatabaseField(columnName = "pinType")
    private int pinType;
    @DatabaseField(columnName = "steps")
    protected double steps;
    @DatabaseField(columnName = "timezoneName")
    protected String timezoneName;
    @DatabaseField(columnName = "updatedAt")
    protected long updatedAt;
    private URI uri;
    @DatabaseField(columnName = "year")
    protected int year;

    protected SampleDay() {
    }

    public SampleDay(int i, int i2, int i3, String str, int i4, double d, double d2, double d3) {
        this.year = i;
        this.month = i2;
        this.day = i3;
        this.timezoneName = str;
        this.dstOffset = i4;
        this.steps = d;
        this.calories = d2;
        this.distance = d3;
        this.uri = FitnessURI.generateURI(this);
        this.id = this.uri.toASCIIString();
        this.pinType = 0;
    }

    public URI getUri() {
        if (this.uri == null && this.id != null) {
            this.uri = URI.create(this.id);
        }
        return this.uri;
    }

    public int getYear() {
        return this.year;
    }

    public int getMonth() {
        return this.month;
    }

    public int getDay() {
        return this.day;
    }

    public String getTimezoneName() {
        return this.timezoneName;
    }

    public int getDstOffset() {
        return this.dstOffset;
    }

    public double getSteps() {
        return this.steps;
    }

    public double getCalories() {
        return this.calories;
    }

    public double getDistance() {
        return this.distance;
    }

    public void setSteps(double d) {
        this.steps = d;
    }

    public void setCalories(double d) {
        this.calories = d;
    }

    public void setDistance(double d) {
        this.distance = d;
    }

    public DailyGoal getGoal() {
        return this.goal;
    }

    public void setGoal(DailyGoal dailyGoal) {
        this.goal = dailyGoal;
    }

    public int getStepGoal() {
        if (this.goal != null) {
            return this.goal.getSteps();
        }
        return 0;
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

    public String toString() {
        return "[SampleDay: date=" + this.year + "/" + this.month + "/" + this.day + ", timezone=" + this.timezoneName + ", steps=" + this.steps + ", calories=" + this.calories + ", distance=" + this.distance + ", goal=" + this.goal + ", createdAt=" + this.createdAt + ", updatedAt=" + this.updatedAt + ", pinType=" + this.pinType + "]";
    }

    public int getPinType() {
        return this.pinType;
    }

    public void setPinType(int i) {
        this.pinType = i;
    }
}
