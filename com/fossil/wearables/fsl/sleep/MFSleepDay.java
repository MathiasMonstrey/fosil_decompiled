package com.fossil.wearables.fsl.sleep;

import com.fossil.wearables.fsl.shared.BaseModel;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import org.joda.time.DateTime;

@DatabaseTable(tableName = "sleep_date")
public class MFSleepDay extends BaseModel {
    public static final String COLUMN_CREATED_AT = "createdAt";
    public static final String COLUMN_DATE = "date";
    public static final String COLUMN_GOAL_MINUTES = "goalMinutes";
    public static final String COLUMN_OBJECT_ID = "objectId";
    public static final String COLUMN_OWNER = "owner";
    public static final String COLUMN_PIN_TYPE = "pinType";
    public static final String COLUMN_SLEEP_MINUTES = "sleepMinutes";
    public static final String COLUMN_SLEEP_STATE_DIST_IN_MINUTE = "sleepStateDistInMinute";
    public static final String COLUMN_TIMEZONE_OFFSET = "timezoneOffset";
    public static final String COLUMN_UPDATE_AT = "updatedAt";
    public static final String TABLE_NAME = "sleep_date";
    @DatabaseField(columnName = "createdAt")
    private DateTime createdAt;
    @DatabaseField(columnName = "date")
    private String date;
    @DatabaseField(columnName = "goalMinutes")
    private int goalMinutes;
    @DatabaseField(columnName = "objectId")
    private String objectId;
    @DatabaseField(columnName = "owner")
    private String owner;
    @DatabaseField(columnName = "pinType")
    private int pinType;
    @DatabaseField(columnName = "sleepMinutes")
    private int sleepMinutes;
    @DatabaseField(columnName = "sleepStateDistInMinute")
    private String sleepStateDistInMinute;
    @DatabaseField(columnName = "timezoneOffset")
    private int timezoneOffset;
    @DatabaseField(columnName = "updatedAt")
    private DateTime updatedAt;

    public MFSleepDay(String str, int i, int i2, int i3, String str2, DateTime dateTime) {
        this.date = str;
        this.timezoneOffset = i;
        this.goalMinutes = i2;
        this.sleepMinutes = i3;
        this.sleepStateDistInMinute = str2;
        this.updatedAt = dateTime;
        this.pinType = 0;
    }

    public MFSleepDay(String str, int i, int i2, int i3, String str2, DateTime dateTime, DateTime dateTime2, String str3, String str4) {
        this.date = str;
        this.timezoneOffset = i;
        this.goalMinutes = i2;
        this.sleepMinutes = i3;
        this.sleepStateDistInMinute = str2;
        this.createdAt = dateTime;
        this.updatedAt = dateTime2;
        this.objectId = str3;
        this.owner = str4;
        this.pinType = 0;
    }

    public String getDate() {
        return this.date;
    }

    public void setDate(String str) {
        this.date = str;
    }

    public int getTimezoneOffset() {
        return this.timezoneOffset;
    }

    public void setTimezoneOffset(int i) {
        this.timezoneOffset = i;
    }

    public int getGoalMinutes() {
        return this.goalMinutes;
    }

    public void setGoalMinutes(int i) {
        this.goalMinutes = i;
    }

    public int getSleepMinutes() {
        return this.sleepMinutes;
    }

    public void setSleepMinutes(int i) {
        this.sleepMinutes = i;
    }

    public String getSleepStateDistInMinute() {
        return this.sleepStateDistInMinute;
    }

    public void setSleepStateDistInMinute(String str) {
        this.sleepStateDistInMinute = str;
    }

    public DateTime getCreatedAt() {
        return this.createdAt;
    }

    public void setCreatedAt(DateTime dateTime) {
        this.createdAt = dateTime;
    }

    public DateTime getUpdatedAt() {
        return this.updatedAt;
    }

    public void setUpdatedAt(DateTime dateTime) {
        this.updatedAt = dateTime;
    }

    public String getObjectId() {
        return this.objectId;
    }

    public void setObjectId(String str) {
        this.objectId = str;
    }

    public String getOwner() {
        return this.owner;
    }

    public void setOwner(String str) {
        this.owner = str;
    }

    public int getPinType() {
        return this.pinType;
    }

    public void setPinType(int i) {
        this.pinType = i;
    }

    public String toString() {
        return "MFSleepDay{date='" + this.date + '\'' + ", timezoneOffset=" + this.timezoneOffset + ", goalMinutes=" + this.goalMinutes + ", sleepMinutes=" + this.sleepMinutes + ", sleepStateDistInMinute='" + this.sleepStateDistInMinute + '\'' + ", createdAt=" + this.createdAt + ", updatedAt=" + this.updatedAt + ", objectId='" + this.objectId + '\'' + ", owner='" + this.owner + '\'' + ", pinType=" + this.pinType + '\'' + '}';
    }
}
