package com.portfolio.platform.data.model;

import com.fossil.cga;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "device")
public class DeviceModel {
    public static final String COLUMN_BATTERY_LEVEL = "deviceBattery";
    public static final String COLUMN_CREATED_AT = "createdAt";
    public static final String COLUMN_DEVICE_ID = "deviceId";
    public static final String COLUMN_DEVICE_MODEL = "sku";
    public static final String COLUMN_FIRMWARE_VERSION = "firmwareRevision";
    public static final String COLUMN_MAC_ADDRESS = "macAddress";
    public static final String COLUMN_MAJOR = "major";
    public static final String COLUMN_MINOR = "minor";
    public static final String COLUMN_VIBRATION_STRENGTH = "vibrationStrength";
    @DatabaseField(columnName = "deviceBattery")
    protected int batteryLevel;
    @cga("createdAt")
    @DatabaseField(columnName = "createdAt")
    protected String createdAt;
    @cga("deviceId")
    @DatabaseField(columnName = "deviceId", id = true)
    protected String deviceId;
    @cga("deviceType")
    private String deviceType;
    @cga("firmwareRevision")
    @DatabaseField(columnName = "firmwareRevision")
    protected String firmwareRevision;
    @cga("hardwareRevision")
    private String hardwareRevision;
    @cga("hostMaker")
    private String hostMaker;
    @cga("hostModel")
    private String hostModel;
    @cga("hostOS")
    private String hostOS;
    @cga("hostOSVersion")
    private String hostOSVersion;
    @cga("hostSystemLanguage")
    private String hostSystemLanguage;
    @cga("hostSystemLocale")
    private String hostSystemLocale;
    @cga("href")
    private String href;
    @cga("lastConnection")
    private String lastConnection;
    @cga("lastDisconnection")
    private String lastDisconnection;
    @cga("lastFirmwareUpdate")
    private String lastFirmwareUpdate;
    @cga("lastRecoveryModeEnd")
    private String lastRecoveryModeEnd;
    @cga("lastRecoveryModeStart")
    private String lastRecoveryModeStart;
    @cga("mac_address")
    @DatabaseField(columnName = "macAddress")
    protected String macAddress;
    @cga("majorNumber")
    @DatabaseField(columnName = "major")
    protected int major;
    @cga("manufacturer")
    private String manufacturer;
    @cga("minorNumber")
    @DatabaseField(columnName = "minor")
    protected int minor;
    @cga("owner")
    private String owner;
    @cga("productDisplayName")
    private String productDisplayName;
    @cga("sku")
    @DatabaseField(columnName = "sku")
    protected String sku;
    @cga("softwareRevision")
    private String softwareRevision;
    @cga("updatedAt")
    @DatabaseField(columnName = "updateAt")
    protected String updateAt;
    @DatabaseField(columnName = "vibrationStrength")
    protected int vibrationStrength = 25;

    public DeviceModel(String str, String str2, String str3, String str4, int i) {
        this.deviceId = str;
        this.macAddress = str2;
        this.sku = str3;
        this.firmwareRevision = str4;
        this.batteryLevel = i;
    }

    public String getDeviceId() {
        return this.deviceId;
    }

    public void setDeviceId(String str) {
        this.deviceId = str;
    }

    public String getSku() {
        return this.sku;
    }

    public void setSku(String str) {
        this.sku = str;
    }

    public String getFirmwareRevision() {
        return this.firmwareRevision;
    }

    public void setFirmwareRevision(String str) {
        this.firmwareRevision = str;
    }

    public String getHref() {
        return this.href;
    }

    public void setHref(String str) {
        this.href = str;
    }

    public String getUpdateAt() {
        return this.updateAt;
    }

    public String getCreatedAt() {
        return this.createdAt;
    }

    public void setUpdateAt(String str) {
        this.updateAt = str;
    }

    public void setCreatedAt(String str) {
        this.createdAt = str;
    }

    public String getOwner() {
        return this.owner;
    }

    public void setOwner(String str) {
        this.owner = str;
    }

    public String getDeviceType() {
        return this.deviceType;
    }

    public void setDeviceType(String str) {
        this.deviceType = str;
    }

    public String getProductDisplayName() {
        return this.productDisplayName;
    }

    public void setProductDisplayName(String str) {
        this.productDisplayName = str;
    }

    public String getManufacturer() {
        return this.manufacturer;
    }

    public void setManufacturer(String str) {
        this.manufacturer = str;
    }

    public String getSoftwareRevision() {
        return this.softwareRevision;
    }

    public void setSoftwareRevision(String str) {
        this.softwareRevision = str;
    }

    public String getHardwareRevision() {
        return this.hardwareRevision;
    }

    public void setHardwareRevision(String str) {
        this.hardwareRevision = str;
    }

    public String getLastConnection() {
        return this.lastConnection;
    }

    public void setLastConnection(String str) {
        this.lastConnection = str;
    }

    public String getLastDisconnection() {
        return this.lastDisconnection;
    }

    public void setLastDisconnection(String str) {
        this.lastDisconnection = str;
    }

    public String getLastRecoveryModeStart() {
        return this.lastRecoveryModeStart;
    }

    public void setLastRecoveryModeStart(String str) {
        this.lastRecoveryModeStart = str;
    }

    public String getLastRecoveryModeEnd() {
        return this.lastRecoveryModeEnd;
    }

    public void setLastRecoveryModeEnd(String str) {
        this.lastRecoveryModeEnd = str;
    }

    public String getLastFirmwareUpdate() {
        return this.lastFirmwareUpdate;
    }

    public void setLastFirmwareUpdate(String str) {
        this.lastFirmwareUpdate = str;
    }

    public String getHostMaker() {
        return this.hostMaker;
    }

    public void setHostMaker(String str) {
        this.hostMaker = str;
    }

    public String getHostModel() {
        return this.hostModel;
    }

    public void setHostModel(String str) {
        this.hostModel = str;
    }

    public String getHostOS() {
        return this.hostOS;
    }

    public void setHostOS(String str) {
        this.hostOS = str;
    }

    public String getHostOSVersion() {
        return this.hostOSVersion;
    }

    public void setHostOSVersion(String str) {
        this.hostOSVersion = str;
    }

    public String getHostSystemLocale() {
        return this.hostSystemLocale;
    }

    public void setHostSystemLocale(String str) {
        this.hostSystemLocale = str;
    }

    public String getHostSystemLanguage() {
        return this.hostSystemLanguage;
    }

    public void setHostSystemLanguage(String str) {
        this.hostSystemLanguage = str;
    }

    public int getBatteryLevel() {
        return this.batteryLevel;
    }

    public void setBatteryLevel(int i) {
        this.batteryLevel = i;
    }

    public void setMacAddress(String str) {
        this.macAddress = str;
    }

    public String getMacAddress() {
        return this.macAddress;
    }

    public int getMajor() {
        return this.major;
    }

    public void setMajor(int i) {
        this.major = i;
    }

    public int getMinor() {
        return this.minor;
    }

    public void setMinor(int i) {
        this.minor = i;
    }

    public int getVibrationStrength() {
        return this.vibrationStrength;
    }

    public void setVibrationStrength(int i) {
        this.vibrationStrength = i;
    }
}
