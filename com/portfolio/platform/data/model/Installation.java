package com.portfolio.platform.data.model;

import com.fossil.cga;

public class Installation {
    @cga("appBuildNumber")
    private int appBuildNumber;
    @cga("appMarketingVersion")
    private String appMarketingVersion;
    @cga("appName")
    private String appName;
    @cga("appPermissions")
    private String[] appPermissions;
    @cga("appVersion")
    private String appVersion;
    @cga("badge")
    private int badge;
    @cga("channels")
    private String[] channels;
    @cga("deviceToken")
    private String deviceToken;
    @cga("deviceType")
    private String deviceType;
    @cga("gcmSenderId")
    private String gcmId;
    @cga("installationId")
    private String installationId;
    @cga("localeIdentifier")
    private String localeIdentifier;
    @cga("model")
    private String model;
    @cga("osVersion")
    private String osVersion;
    @cga("pushType")
    private String pushType;
    @cga("timeZone")
    private String timeZone;
    private transient MFUser user;

    public MFUser getUser() {
        return this.user;
    }

    public void setUser(MFUser mFUser) {
        this.user = mFUser;
    }

    public String getModel() {
        return this.model;
    }

    public void setModel(String str) {
        this.model = str;
    }

    public String getAppMarketingVersion() {
        return this.appMarketingVersion;
    }

    public void setAppMarketingVersion(String str) {
        this.appMarketingVersion = str;
    }

    public int getAppBuildNumber() {
        return this.appBuildNumber;
    }

    public void setAppBuildNumber(int i) {
        this.appBuildNumber = i;
    }

    public String getOsVersion() {
        return this.osVersion;
    }

    public void setOsVersion(String str) {
        this.osVersion = str;
    }

    public String getGcmId() {
        return this.gcmId;
    }

    public void setGcmId(String str) {
        this.gcmId = str;
    }

    public String getLocaleIdentifier() {
        return this.localeIdentifier;
    }

    public void setLocaleIdentifier(String str) {
        this.localeIdentifier = str;
    }

    public String getAppName() {
        return this.appName;
    }

    public void setAppName(String str) {
        this.appName = str;
    }

    public int getBadge() {
        return this.badge;
    }

    public void setBadge(int i) {
        this.badge = i;
    }

    public String[] getChannels() {
        return this.channels;
    }

    public void setChannels(String[] strArr) {
        this.channels = strArr;
    }

    public String getDeviceType() {
        return this.deviceType;
    }

    public void setDeviceType(String str) {
        this.deviceType = str;
    }

    public String getInstallationId() {
        return this.installationId;
    }

    public void setInstallationId(String str) {
        this.installationId = str;
    }

    public String getAppVersion() {
        return this.appVersion;
    }

    public void setAppVersion(String str) {
        this.appVersion = str;
    }

    public String getPushType() {
        return this.pushType;
    }

    public void setPushType(String str) {
        this.pushType = str;
    }

    public String getTimeZone() {
        return this.timeZone;
    }

    public void setTimeZone(String str) {
        this.timeZone = str;
    }

    public String getDeviceToken() {
        return this.deviceToken;
    }

    public void setDeviceToken(String str) {
        this.deviceToken = str;
    }

    public String[] getAppPermissions() {
        return this.appPermissions;
    }

    public void setAppPermissions(String[] strArr) {
        this.appPermissions = strArr;
    }
}
