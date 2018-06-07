package com.portfolio.platform.data.model;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "firmware")
public class Firmware {
    public static final String COLUMN_CHECKSUM = "checksum";
    public static final String COLUMN_DEVICE_MODEL = "deviceModel";
    public static final String COLUMN_DOWNLOAD_URL = "downloadUrl";
    public static final String COLUMN_IS_LATEST = "isLatest";
    public static final String COLUMN_OBJECT_ID = "objectId";
    public static final String COLUMN_SERVER_HREF = "serverHref";
    public static final String COLUMN_VERSION_NUMBER = "versionNumber";
    @DatabaseField(columnName = "checksum")
    private String checksum;
    @DatabaseField(columnName = "deviceModel", id = true)
    private String deviceModel;
    @DatabaseField(columnName = "downloadUrl")
    private String downloadUrl;
    private boolean embedded;
    @DatabaseField(columnName = "isLatest")
    private boolean isLatest;
    @DatabaseField(columnName = "objectId")
    private String objectId;
    private int resourceId;
    @DatabaseField(columnName = "serverHref")
    private String serverHref;
    @DatabaseField(columnName = "versionNumber")
    private String versionNumber;

    public Firmware(String str, String str2, String str3, String str4, boolean z, String str5, String str6) {
        this.objectId = str;
        this.deviceModel = str2;
        this.versionNumber = str3;
        this.downloadUrl = str4;
        this.isLatest = z;
        this.serverHref = str5;
        this.checksum = str6;
    }

    public Firmware(String str, String str2, boolean z, int i) {
        this(str, z, i);
        this.deviceModel = str2;
    }

    public Firmware(String str, boolean z, int i) {
        this.versionNumber = str;
        this.embedded = z;
        this.resourceId = i;
    }

    public boolean isEmbedded() {
        return this.embedded;
    }

    public int getResourceId() {
        return this.resourceId;
    }

    public String getObjectId() {
        return this.objectId;
    }

    public void setObjectId(String str) {
        this.objectId = str;
    }

    public String getDeviceModel() {
        return this.deviceModel;
    }

    public void setDeviceModel(String str) {
        this.deviceModel = str;
    }

    public String getVersionNumber() {
        return this.versionNumber;
    }

    public void setVersionNumber(String str) {
        this.versionNumber = str;
    }

    public String getDownloadUrl() {
        return this.downloadUrl;
    }

    public void setDownloadUrl(String str) {
        this.downloadUrl = str;
    }

    public boolean isLatest() {
        return this.isLatest;
    }

    public void setIsLatest(boolean z) {
        this.isLatest = z;
    }

    public String getServerHref() {
        return this.serverHref;
    }

    public void setServerHref(String str) {
        this.serverHref = str;
    }

    public String getChecksum() {
        return this.checksum;
    }

    public void setChecksum(String str) {
        this.checksum = str;
    }

    public String toString() {
        return "[Firmware: deviceModel=" + this.deviceModel + ", version=" + this.versionNumber + ", embedded=" + this.embedded + ", resId=" + this.resourceId + "]";
    }
}
