package com.fossil.wearables.fsl.location;

import com.j256.ormlite.field.DatabaseField;
import java.io.Serializable;

public class DeviceLocation implements Serializable {
    public static final String COLUMN_DEVICE_SERIAL = "deviceSerial";
    public static final String COLUMN_LATITUDE = "latitude";
    public static final String COLUMN_LONGITUDE = "longitude";
    public static final String COLUMN_TIMESTAMP = "timestamp";
    @DatabaseField(columnName = "deviceSerial", id = true)
    private String deviceSerial;
    @DatabaseField(columnName = "latitude")
    private double latitude;
    @DatabaseField(columnName = "longitude")
    private double longitude;
    @DatabaseField(columnName = "timestamp")
    private long timeStamp;

    public DeviceLocation(String str, double d, double d2, long j) {
        this.deviceSerial = str;
        this.latitude = d;
        this.longitude = d2;
        this.timeStamp = j;
    }

    public String getDeviceSerial() {
        return this.deviceSerial;
    }

    public void setDeviceSerial(String str) {
        this.deviceSerial = str;
    }

    public double getLatitude() {
        return this.latitude;
    }

    public void setLatitude(double d) {
        this.latitude = d;
    }

    public double getLongitude() {
        return this.longitude;
    }

    public void setLongitude(double d) {
        this.longitude = d;
    }

    public long getTimeStamp() {
        return this.timeStamp;
    }

    public void setTimeStamp(long j) {
        this.timeStamp = j;
    }

    public String toString() {
        return "[DeviceLocation: serial=" + this.deviceSerial + ", lat=" + this.latitude + ", lon=" + this.longitude + ", timestamp=" + this.timeStamp + "]";
    }
}
