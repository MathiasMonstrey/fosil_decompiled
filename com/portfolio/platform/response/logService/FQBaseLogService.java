package com.portfolio.platform.response.logService;

import android.os.Build;
import com.fossil.cnq;
import com.portfolio.platform.data.model.MFUser;
import java.io.Serializable;
import java.util.UUID;

public class FQBaseLogService implements Serializable {
    protected String appVersion;
    protected String debugLog = "";
    protected String deviceModel;
    protected int endTime;
    protected int[] errorCodes;
    protected String firmware;
    protected String id = UUID.randomUUID().toString();
    protected int isSuccess = -1;
    protected String os;
    protected String osVersion;
    protected String sdkVersion;
    protected String serialNumber;
    protected int startTime;
    protected String uid;

    public FQBaseLogService(String str, int i, int i2, String str2, int i3, String str3, int[] iArr, String str4, String str5, String str6) {
        MFUser currentUser = cnq.acd().ace().getCurrentUser();
        if (currentUser != null) {
            this.uid = currentUser.getUserId();
        }
        this.os = "android";
        this.osVersion = str4;
        this.deviceModel = Build.MODEL;
        this.sdkVersion = str5;
        this.appVersion = str6;
        this.serialNumber = str;
        this.startTime = i;
        this.endTime = i2;
        this.firmware = str2;
        this.isSuccess = i3;
        this.debugLog = str3;
        this.errorCodes = iArr;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String str) {
        this.id = str;
    }

    public String getUid() {
        return this.uid;
    }

    public void setUid(String str) {
        this.uid = str;
    }

    public String getSerialNumber() {
        return this.serialNumber;
    }

    public void setSerialNumber(String str) {
        this.serialNumber = str;
    }

    public String getOs() {
        return this.os;
    }

    public void setOs(String str) {
        this.os = str;
    }

    public String getOsVersion() {
        return this.osVersion;
    }

    public void setOsVersion(String str) {
        this.osVersion = str;
    }

    public String getDeviceModel() {
        return this.deviceModel;
    }

    public void setDeviceModel(String str) {
        this.deviceModel = str;
    }

    public String getSdkVersion() {
        return this.sdkVersion;
    }

    public void setSdkVersion(String str) {
        this.sdkVersion = str;
    }

    public String getAppVersion() {
        return this.appVersion;
    }

    public void setAppVersion(String str) {
        this.appVersion = str;
    }

    public int getStartTime() {
        return this.startTime;
    }

    public void setStartTime(int i) {
        this.startTime = i;
    }

    public int getEndTime() {
        return this.endTime;
    }

    public void setEndTime(int i) {
        this.endTime = i;
    }

    public String getFirmware() {
        return this.firmware;
    }

    public void setFirmware(String str) {
        this.firmware = str;
    }

    public int getIsSuccess() {
        return this.isSuccess;
    }

    public void setIsSuccess(int i) {
        this.isSuccess = i;
    }

    public String getDebugLog() {
        return this.debugLog;
    }

    public void setDebugLog(String str) {
        this.debugLog = str;
    }
}
