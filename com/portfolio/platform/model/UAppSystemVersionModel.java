package com.portfolio.platform.model;

import com.fossil.cfj;
import com.fossil.cga;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "uappsystemversion")
public class UAppSystemVersionModel {
    public static final String COLUMN_DEVICE_ID = "deviceId";
    public static final String COLUMN_MAJOR_VERSION = "majorVersion";
    public static final String COLUMN_MINOR_VERSION = "minorVersion";
    public static final String COLUMN_PIN_TYPE = "pinType";
    public static final String TABLE_NAME = "uappsystemversion";
    public static final int UNSUPPORTED_MAJOR_MINOR_NUMBER = 255;
    @cga("deviceId")
    @DatabaseField(columnName = "deviceId", id = true)
    private String deviceId;
    @DatabaseField(columnName = "majorVersion")
    private int majorVersion;
    @DatabaseField(columnName = "minorVersion")
    private int minorVersion;
    @DatabaseField(columnName = "pinType")
    private int pinType;

    public UAppSystemVersionModel(String str, int i, int i2) {
        this.deviceId = str;
        this.majorVersion = i;
        this.minorVersion = i2;
        this.pinType = 0;
    }

    public UAppSystemVersionModel(String str, int i, int i2, int i3) {
        this(str, i, i2);
        this.pinType = i3;
    }

    public String getDeviceId() {
        return this.deviceId;
    }

    public void setDeviceId(String str) {
        this.deviceId = str;
    }

    public int getMajorVersion() {
        return this.majorVersion;
    }

    public void setMajorVersion(int i) {
        this.majorVersion = i;
    }

    public int getMinorVersion() {
        return this.minorVersion;
    }

    public void setMinorVersion(int i) {
        this.minorVersion = i;
    }

    public int getPinType() {
        return this.pinType;
    }

    public void setPinType(int i) {
        this.pinType = i;
    }

    public String toString() {
        return new cfj().toJson(this);
    }

    public String getHash() {
        return this.deviceId + ":" + this.majorVersion + ":" + this.minorVersion + ":" + this.pinType;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof UAppSystemVersionModel)) {
            return false;
        }
        return getHash().equals(((UAppSystemVersionModel) obj).getHash());
    }
}
