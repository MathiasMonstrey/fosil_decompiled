package com.portfolio.platform.data.model;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "SKU")
public class SKUModel {
    public static final String COLUMN_CREATED_AT = "createdAt";
    public static final String COLUMN_DEVICE_NAME = "deviceName";
    public static final String COLUMN_DEVICE_TYPE = "deviceType";
    public static final String COLUMN_GENDER = "gender";
    public static final String COLUMN_GROUP_NAME = "groupName";
    public static final String COLUMN_SERIAL_NUMBER_PREFIX = "serialNumberPrefix";
    public static final String COLUMN_SKU = "sku";
    public static final String COLUMN_UPDATED_AT = "updatedAt";
    public static final String TABLE_NAME = "SKU";
    @DatabaseField(columnName = "createdAt")
    protected String createdAt;
    @DatabaseField(columnName = "deviceName")
    protected String deviceName;
    @DatabaseField(columnName = "deviceType")
    protected String deviceType;
    @DatabaseField(columnName = "gender")
    protected String gender;
    @DatabaseField(columnName = "groupName")
    protected String groupName;
    @DatabaseField(columnName = "serialNumberPrefix")
    protected String serialNumberPrefix;
    @DatabaseField(columnName = "sku", id = true)
    protected String sku;
    @DatabaseField(columnName = "updatedAt")
    protected String updatedAt;

    public SKUModel(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8) {
        this.sku = str;
        this.serialNumberPrefix = str2;
        this.deviceName = str3;
        this.groupName = str4;
        this.gender = str5;
        this.createdAt = str6;
        this.updatedAt = str7;
        this.deviceType = str8;
    }

    public String getSku() {
        return this.sku;
    }

    public void setSku(String str) {
        this.sku = str;
    }

    public String getSerialNumberPrefix() {
        return this.serialNumberPrefix;
    }

    public void setSerialNumberPrefix(String str) {
        this.serialNumberPrefix = str;
    }

    public String getDeviceName() {
        return this.deviceName;
    }

    public void setDeviceName(String str) {
        this.deviceName = str;
    }

    public String getGroupName() {
        return this.groupName;
    }

    public void setGroupName(String str) {
        this.groupName = str;
    }

    public String getGender() {
        return this.gender;
    }

    public void setGender(String str) {
        this.gender = str;
    }

    public String getCreatedAt() {
        return this.createdAt;
    }

    public void setCreatedAt(String str) {
        this.createdAt = str;
    }

    public String getUpdatedAt() {
        return this.updatedAt;
    }

    public void setUpdatedAt(String str) {
        this.updatedAt = str;
    }

    public String getDeviceType() {
        return this.deviceType;
    }

    public void setDeviceType(String str) {
        this.deviceType = str;
    }
}
