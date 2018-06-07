package com.fossil.wearables.fsl.sleep;

import com.fossil.wearables.fsl.shared.BaseModel;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import org.joda.time.DateTime;

@DatabaseTable(tableName = "sleep_session")
public class MFSleepSession extends BaseModel {
    public static final String COLUMN_BOOKMARK_TIME = "bookmarkTime";
    public static final String COLUMN_CREATE_AT = "createdAt";
    public static final String COLUMN_DATE = "date";
    public static final String COLUMN_DAY = "day";
    public static final String COLUMN_DEVICE_SERIAL_NUMBER = "deviceSerialNumber";
    public static final String COLUMN_EDITED_END_TIME = "editedEndTime";
    public static final String COLUMN_EDITED_SLEEP_MINUTES = "editedSleepMinutes";
    public static final String COLUMN_EDITED_START_TIME = "editedStartTime";
    public static final String COLUMN_EDITED_STATE_DIST_IN_MINUTE = "editedSleepStateDistInMinute";
    public static final String COLUMN_NORMALIZED_SLEEP_QUALITY = "normalizedSleepQuality";
    public static final String COLUMN_OBJECT_ID = "objectId";
    public static final String COLUMN_OWNER = "owner";
    public static final String COLUMN_PIN_TYPE = "pinType";
    public static final String COLUMN_REAL_END_TIME = "realEndTime";
    public static final String COLUMN_REAL_SLEEP_MINUTES = "realSleepMinutes";
    public static final String COLUMN_REAL_START_TIME = "realStartTime";
    public static final String COLUMN_REAL_STATE_DIST_IN_MINUTE = "realSleepStateDistInMinute";
    public static final String COLUMN_SLEEP_STATES = "sleepStates";
    public static final String COLUMN_SOURCE = "source";
    public static final String COLUMN_SYNC_TIME = "syncTime";
    public static final String COLUMN_TIMEZONE_OFFSET = "timezoneOffset";
    public static final String COLUMN_UDPATE_AT = "updatedAt";
    public static final String TABLE_NAME = "sleep_session";
    @DatabaseField(columnName = "bookmarkTime")
    private int bookmarkTime;
    @DatabaseField(columnName = "createdAt")
    private DateTime createdAt;
    @DatabaseField(columnName = "date")
    private long date;
    @DatabaseField(columnName = "day")
    private String day;
    @DatabaseField(columnName = "deviceSerialNumber")
    private String deviceSerialNumber;
    @DatabaseField(columnName = "editedEndTime")
    private int editedEndTime;
    @DatabaseField(columnName = "editedSleepMinutes")
    private int editedSleepMinutes;
    @DatabaseField(columnName = "editedSleepStateDistInMinute")
    private String editedSleepStateDistInMinute;
    @DatabaseField(columnName = "editedStartTime")
    private int editedStartTime;
    @DatabaseField(columnName = "normalizedSleepQuality")
    private double normalizedSleepQuality;
    @DatabaseField(columnName = "objectId")
    private String objectId;
    @DatabaseField(columnName = "owner")
    private String owner;
    @DatabaseField(columnName = "pinType")
    private int pinType;
    @DatabaseField(columnName = "realEndTime")
    private int realEndTime;
    @DatabaseField(columnName = "realSleepMinutes")
    private int realSleepMinutes;
    @DatabaseField(columnName = "realSleepStateDistInMinute")
    private String realSleepStateDistInMinute;
    @DatabaseField(columnName = "realStartTime")
    private int realStartTime;
    @DatabaseField(columnName = "sleepStates")
    private String sleepStates;
    @DatabaseField(columnName = "source")
    private int source;
    @DatabaseField(columnName = "syncTime")
    private int syncTime;
    @DatabaseField(columnName = "timezoneOffset")
    private int timezoneOffset;
    @DatabaseField(columnName = "updatedAt")
    private DateTime updatedAt;

    public MFSleepSession(long j, int i, String str, int i2, int i3, double d, int i4, int i5, int i6, int i7, String str2, String str3, DateTime dateTime) {
        this.date = j;
        this.timezoneOffset = i;
        this.deviceSerialNumber = str;
        this.syncTime = i2;
        this.bookmarkTime = i3;
        this.normalizedSleepQuality = d;
        this.source = i4;
        this.realStartTime = i5;
        this.realEndTime = i6;
        this.realSleepMinutes = i7;
        this.realSleepStateDistInMinute = str2;
        this.sleepStates = str3;
        this.updatedAt = dateTime;
        this.editedStartTime = i5;
        this.editedEndTime = i6;
        this.editedSleepMinutes = i7;
        this.editedSleepStateDistInMinute = str2;
        this.pinType = 0;
    }

    public MFSleepSession(long j, int i, String str, int i2, double d, int i3, int i4, int i5, int i6, String str2, String str3, DateTime dateTime, boolean z) {
        this.date = j;
        this.timezoneOffset = i;
        this.deviceSerialNumber = str;
        this.bookmarkTime = i2;
        this.normalizedSleepQuality = d;
        this.source = i3;
        this.editedStartTime = i4;
        this.editedEndTime = i5;
        this.editedSleepMinutes = i6;
        this.editedSleepStateDistInMinute = str2;
        this.sleepStates = str3;
        if (!z) {
            this.realStartTime = i4;
            this.realEndTime = i5;
            this.realSleepMinutes = i6;
            this.realSleepStateDistInMinute = str2;
        }
        this.updatedAt = dateTime;
        this.pinType = 0;
    }

    public MFSleepSession(long j, int i, String str, String str2, String str3, int i2, int i3, double d, int i4, int i5, int i6, int i7, String str4, int i8, int i9, int i10, String str5, String str6, DateTime dateTime, DateTime dateTime2) {
        this.date = j;
        this.timezoneOffset = i;
        this.owner = str;
        this.objectId = str2;
        this.deviceSerialNumber = str3;
        this.syncTime = i2;
        this.bookmarkTime = i3;
        this.normalizedSleepQuality = d;
        this.source = i4;
        this.realStartTime = i5;
        this.realEndTime = i6;
        this.realSleepMinutes = i7;
        this.realSleepStateDistInMinute = str4;
        this.editedStartTime = i8;
        this.editedEndTime = i9;
        this.editedSleepMinutes = i10;
        this.editedSleepStateDistInMinute = str5;
        this.sleepStates = str6;
        this.createdAt = dateTime;
        this.updatedAt = dateTime2;
        this.pinType = 0;
    }

    public MFSleepSession(long j, int i, String str, String str2, int i2, int i3, double d, int i4, int i5, int i6, int i7, String str3, String str4, DateTime dateTime) {
        this.date = j;
        this.timezoneOffset = i;
        this.day = str;
        this.deviceSerialNumber = str2;
        this.syncTime = i2;
        this.bookmarkTime = i3;
        this.normalizedSleepQuality = d;
        this.source = i4;
        this.realStartTime = i5;
        this.realEndTime = i6;
        this.realSleepMinutes = i7;
        this.realSleepStateDistInMinute = str3;
        this.sleepStates = str4;
        this.updatedAt = dateTime;
        this.editedStartTime = i5;
        this.editedEndTime = i6;
        this.editedSleepMinutes = i7;
        this.editedSleepStateDistInMinute = str3;
        this.pinType = 0;
    }

    public MFSleepSession(long j, int i, String str, String str2, int i2, double d, int i3, int i4, int i5, int i6, String str3, String str4, DateTime dateTime, boolean z) {
        this.date = j;
        this.timezoneOffset = i;
        this.day = str;
        this.deviceSerialNumber = str2;
        this.bookmarkTime = i2;
        this.normalizedSleepQuality = d;
        this.source = i3;
        this.editedStartTime = i4;
        this.editedEndTime = i5;
        this.editedSleepMinutes = i6;
        this.editedSleepStateDistInMinute = str3;
        this.sleepStates = str4;
        if (!z) {
            this.realStartTime = i4;
            this.realEndTime = i5;
            this.realSleepMinutes = i6;
            this.realSleepStateDistInMinute = str3;
        }
        this.updatedAt = dateTime;
        this.pinType = 0;
    }

    public MFSleepSession(long j, int i, String str, String str2, String str3, String str4, int i2, int i3, double d, int i4, int i5, int i6, int i7, String str5, int i8, int i9, int i10, String str6, String str7, DateTime dateTime, DateTime dateTime2) {
        this.date = j;
        this.timezoneOffset = i;
        this.day = str2;
        this.owner = str;
        this.objectId = str3;
        this.deviceSerialNumber = str4;
        this.syncTime = i2;
        this.bookmarkTime = i3;
        this.normalizedSleepQuality = d;
        this.source = i4;
        this.realStartTime = i5;
        this.realEndTime = i6;
        this.realSleepMinutes = i7;
        this.realSleepStateDistInMinute = str5;
        this.editedStartTime = i8;
        this.editedEndTime = i9;
        this.editedSleepMinutes = i10;
        this.editedSleepStateDistInMinute = str6;
        this.sleepStates = str7;
        this.createdAt = dateTime;
        this.updatedAt = dateTime2;
        this.pinType = 0;
    }

    public long getDate() {
        return this.date;
    }

    public void setDate(long j) {
        this.date = j;
    }

    public int getTimezoneOffset() {
        return this.timezoneOffset;
    }

    public void setTimezoneOffset(int i) {
        this.timezoneOffset = i;
    }

    public String getDay() {
        return this.day;
    }

    public void setDay(String str) {
        this.day = str;
    }

    public String getOwner() {
        return this.owner;
    }

    public void setOwner(String str) {
        this.owner = str;
    }

    public String getObjectId() {
        return this.objectId;
    }

    public void setObjectId(String str) {
        this.objectId = str;
    }

    public String getDeviceSerialNumber() {
        return this.deviceSerialNumber;
    }

    public void setDeviceSerialNumber(String str) {
        this.deviceSerialNumber = str;
    }

    public int getSyncTime() {
        return this.syncTime;
    }

    public void setSyncTime(int i) {
        this.syncTime = i;
    }

    public int getBookmarkTime() {
        return this.bookmarkTime;
    }

    public void setBookmarkTime(int i) {
        this.bookmarkTime = i;
    }

    public double getNormalizedSleepQuality() {
        return this.normalizedSleepQuality;
    }

    public void setNormalizedSleepQuality(double d) {
        this.normalizedSleepQuality = d;
    }

    public int getSource() {
        return this.source;
    }

    public void setSource(int i) {
        this.source = i;
    }

    public int getRealStartTime() {
        return this.realStartTime;
    }

    public void setRealStartTime(int i) {
        this.realStartTime = i;
    }

    public int getRealEndTime() {
        return this.realEndTime;
    }

    public void setRealEndTime(int i) {
        this.realEndTime = i;
    }

    public int getRealSleepMinutes() {
        return this.realSleepMinutes;
    }

    public void setRealSleepMinutes(int i) {
        this.realSleepMinutes = i;
    }

    public String getRealSleepStateDistInMinute() {
        return this.realSleepStateDistInMinute;
    }

    public void setRealSleepStateDistInMinute(String str) {
        this.realSleepStateDistInMinute = str;
    }

    public int getEditedStartTime() {
        return this.editedStartTime;
    }

    public void setEditedStartTime(int i) {
        this.editedStartTime = i;
    }

    public int getEditedEndTime() {
        return this.editedEndTime;
    }

    public void setEditedEndTime(int i) {
        this.editedEndTime = i;
    }

    public int getEditedSleepMinutes() {
        return this.editedSleepMinutes;
    }

    public void setEditedSleepMinutes(int i) {
        this.editedSleepMinutes = i;
    }

    public String getEditedSleepStateDistInMinute() {
        return this.editedSleepStateDistInMinute;
    }

    public void setEditedSleepStateDistInMinute(String str) {
        this.editedSleepStateDistInMinute = str;
    }

    public String getSleepStates() {
        return this.sleepStates;
    }

    public void setSleepStates(String str) {
        this.sleepStates = str;
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

    public int getPinType() {
        return this.pinType;
    }

    public void setPinType(int i) {
        this.pinType = i;
    }

    public String toString() {
        return "MFSleepSession{date=" + this.date + ", timezoneOffset=" + this.timezoneOffset + ", day='" + this.day + '\'' + ", owner='" + this.owner + '\'' + ", objectId='" + this.objectId + '\'' + ", deviceSerialNumber='" + this.deviceSerialNumber + '\'' + ", syncTime=" + this.syncTime + ", bookmarkTime=" + this.bookmarkTime + ", normalizedSleepQuality=" + this.normalizedSleepQuality + ", source=" + this.source + ", realStartTime=" + this.realStartTime + ", realEndTime=" + this.realEndTime + ", realSleepMinutes=" + this.realSleepMinutes + ", realSleepStateDistInMinute='" + this.realSleepStateDistInMinute + '\'' + ", editedStartTime=" + this.editedStartTime + ", editedEndTime=" + this.editedEndTime + ", editedSleepMinutes=" + this.editedSleepMinutes + ", editedSleepStateDistInMinute='" + this.editedSleepStateDistInMinute + '\'' + ", sleepStates='" + this.sleepStates + '\'' + ", createdAt=" + this.createdAt + ", updatedAt=" + this.updatedAt + ", pinType=" + this.pinType + '}';
    }
}
