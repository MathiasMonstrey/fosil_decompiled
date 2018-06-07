package com.portfolio.platform.data.model.microapp;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.fossil.cfy;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "secondTimezone")
public class SecondTimezone implements Parcelable, Comparable<SecondTimezone> {
    public static final String COLUMN_IS_ACTIVE = "isActiveAlarm";
    public static final String COLUMN_TIMEZONE_CITY_NAME = "timezone_city_name";
    public static final String COLUMN_TIMEZONE_ID = "timezone_id";
    public static final String COLUMN_TIMEZONE_OFFSET = "timezone_offset";
    public static final String COLUMN_TIMEZONE_TYPE = "timezone_type";
    public static final String COLUMN_URI = "uri";
    public static final Creator<SecondTimezone> CREATOR = new 1();
    @DatabaseField(columnName = "isActiveAlarm")
    private boolean isActive;
    @cfy
    @DatabaseField(columnName = "timezone_city_name")
    private String timezoneCityName;
    @cfy
    @DatabaseField(columnName = "timezone_id")
    private String timezoneId;
    @cfy
    @DatabaseField(columnName = "timezone_offset")
    private long timezoneOffset;
    @cfy
    @DatabaseField(columnName = "timezone_type")
    private String timezoneType;
    @cfy
    @DatabaseField(columnName = "uri", id = true)
    private String uri;

    public SecondTimezone(String str, String str2, long j, String str3) {
        this.timezoneId = str;
        this.timezoneCityName = str2;
        this.timezoneOffset = j;
        this.timezoneType = str3;
        this.uri = "uri:fsl:timezone:" + str2 + ":" + str;
    }

    public String getTimezoneCityName() {
        return this.timezoneCityName;
    }

    public void setTimezoneCityName(String str) {
        this.timezoneCityName = str;
    }

    public long getTimezoneOffset() {
        return this.timezoneOffset;
    }

    public void setTimezoneOffset(long j) {
        this.timezoneOffset = j;
    }

    public String getTimezoneType() {
        return this.timezoneType;
    }

    public void setTimezoneType(String str) {
        this.timezoneType = str;
    }

    public String getTimezoneId() {
        return this.timezoneId;
    }

    public void setTimezoneId(String str) {
        this.timezoneId = str;
    }

    public String getUri() {
        return this.uri;
    }

    public void setUri(String str) {
        this.uri = str;
    }

    public void generateUri() {
        this.uri = "uri:fsl:timezone:" + this.timezoneCityName + ":" + this.timezoneId;
    }

    public SecondTimezone clone() {
        SecondTimezone secondTimezone = new SecondTimezone();
        secondTimezone.setTimezoneCityName(this.timezoneCityName);
        secondTimezone.setTimezoneOffset(this.timezoneOffset);
        secondTimezone.setTimezoneType(this.timezoneType);
        secondTimezone.setTimezoneId(this.timezoneId);
        secondTimezone.generateUri();
        return secondTimezone;
    }

    public int compareTo(SecondTimezone secondTimezone) {
        return this.timezoneCityName.compareTo(secondTimezone.getTimezoneCityName());
    }

    protected SecondTimezone(Parcel parcel) {
        this.timezoneCityName = parcel.readString();
        this.timezoneOffset = parcel.readLong();
        this.timezoneType = parcel.readString();
        this.timezoneId = parcel.readString();
        this.uri = parcel.readString();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.timezoneCityName);
        parcel.writeLong(this.timezoneOffset);
        parcel.writeString(this.timezoneType);
        parcel.writeString(this.timezoneId);
        parcel.writeString(this.uri);
    }
}
