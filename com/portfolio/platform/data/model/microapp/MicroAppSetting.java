package com.portfolio.platform.data.model.microapp;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "microAppSetting")
public class MicroAppSetting {
    public static final String COLUMN_CREATED_AT = "createdAt";
    public static final String COLUMN_FIRST_USED = "firstUsed";
    public static final String COLUMN_PIN_TYPE = "pinType";
    public static final String COLUMN_UPDATED_AT = "updatedAt";
    public static final String LIKE = "isLiked";
    public static final String MICRO_APP_ID = "appId";
    public static final String SETTING = "setting";
    public static final String TABLE_NAME = "microAppSetting";
    @DatabaseField(columnName = "createdAt")
    private long createdAt;
    @DatabaseField(columnName = "firstUsed")
    private long firstUsed;
    @DatabaseField(columnName = "isLiked")
    private boolean like;
    @DatabaseField(columnName = "appId", id = true)
    private String microAppId;
    @DatabaseField(columnName = "pinType")
    private int pinType;
    @DatabaseField(columnName = "setting")
    private String setting;
    @DatabaseField(columnName = "updatedAt")
    private long updatedAt;

    public MicroAppSetting() {
        this.microAppId = "";
        this.setting = "";
        this.like = false;
        this.pinType = 0;
        this.createdAt = System.currentTimeMillis();
        this.updatedAt = System.currentTimeMillis();
    }

    public MicroAppSetting(String str, String str2) {
        this.microAppId = str;
        this.setting = str2;
        this.like = false;
        this.pinType = 0;
        this.createdAt = System.currentTimeMillis();
        this.updatedAt = System.currentTimeMillis();
    }

    public MicroAppSetting(String str) {
        this.microAppId = str;
        this.setting = "";
        this.like = false;
        this.pinType = 0;
        this.createdAt = System.currentTimeMillis();
        this.updatedAt = System.currentTimeMillis();
    }

    public String getMicroAppId() {
        return this.microAppId;
    }

    public void setMicroAppId(String str) {
        this.microAppId = str;
    }

    public String getSetting() {
        return this.setting;
    }

    public void setSetting(String str) {
        this.setting = str;
    }

    public long getUpdatedAt() {
        return this.updatedAt;
    }

    public void setUpdatedAt(long j) {
        this.updatedAt = j;
    }

    public long getCreatedAt() {
        return this.createdAt;
    }

    public void setCreatedAt(long j) {
        this.createdAt = j;
    }

    public boolean isLike() {
        return this.like;
    }

    public void setLike(boolean z) {
        this.like = z;
    }

    public long getFirstUsed() {
        return this.firstUsed;
    }

    public void setFirstUsed(long j) {
        this.firstUsed = j;
    }

    public int getPinType() {
        return this.pinType;
    }

    public void setPinType(int i) {
        this.pinType = i;
    }
}
