package com.misfit.frameworks.buttonservice.log;

import android.content.Context;
import com.misfit.frameworks.buttonservice.ButtonService;
import com.misfit.frameworks.buttonservice.model.AppInfo;
import com.misfit.frameworks.common.log.MFLogger;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Set;

public class MFLog implements Serializable {
    private static final String LOG_PATTERN = "[%d] --\t%s%s\n";
    private static final String TAG_DEBUG = "[DEBUG] ";
    private static final String TAG_EMPTY = "";
    private static final String TAG_ERROR = "[ERROR] ";
    private static final String TAG_INFO = "[INFO] ";
    private String appVersion;
    private Set<String> candidates = new HashSet();
    protected transient Context context;
    private String detailLog = "";
    private long endTime;
    private List<Integer> errorCodes;
    private String firmwareVersion;
    private boolean isHidden;
    private String osVersion;
    private String phoneModel;
    private int resultCode;
    private String sdkVersion;
    private String serial;
    protected long startTime = System.currentTimeMillis();
    private String uuid;

    protected MFLog(Context context) {
        this.context = context;
        this.isHidden = false;
        this.sdkVersion = ButtonService.getSDKVersion();
        AppInfo appInfo = ButtonService.getAppInfo();
        if (appInfo != null) {
            MFLogger.d("MFLog", "MFLog - appInfo=" + appInfo.toString());
            this.osVersion = appInfo.getOsVersion();
            this.appVersion = appInfo.getAppVersion();
        }
    }

    public void setStartTime(long j) {
        this.startTime = j;
    }

    public long getStartTime() {
        return this.startTime;
    }

    public int getStartTimeEpoch() {
        return (int) (this.startTime / 1000);
    }

    public int getEndTimeEpoch() {
        return (int) (this.endTime / 1000);
    }

    public void setResultCode(int i) {
        this.resultCode = i;
    }

    public int getResultCode() {
        return this.resultCode;
    }

    public void setLogId(String str) {
        this.uuid = str;
    }

    public String getLogId() {
        return this.uuid;
    }

    public void setPhoneModel(String str) {
        this.phoneModel = str;
    }

    public String getPhoneModel() {
        return this.phoneModel;
    }

    public void setOsVersion(String str) {
        this.osVersion = str;
    }

    public String getOsVersion() {
        return this.osVersion;
    }

    public void setEndTime(long j) {
        this.endTime = j;
    }

    public long getEndTime() {
        return this.endTime;
    }

    public void addCandidate(String str) {
        if (!this.candidates.contains(str)) {
            this.candidates.add(str);
            appendLog("", "Found device: " + str);
        }
    }

    public int getButtonCount() {
        return this.candidates.size();
    }

    public void setAppVersion(String str) {
        this.appVersion = str;
    }

    public String getAppVersion() {
        return this.appVersion;
    }

    private void appendLog(String str, String str2) {
        long timeInMillis = Calendar.getInstance().getTimeInMillis();
        this.detailLog += String.format(Locale.US, LOG_PATTERN, new Object[]{Long.valueOf((timeInMillis - this.startTime) / 1000), str, str2});
    }

    public void log(String str) {
        appendLog("", str);
    }

    public void error(String str) {
        appendLog(TAG_ERROR, str);
    }

    public void debug(String str) {
        appendLog(TAG_DEBUG, str);
    }

    public void info(String str) {
        appendLog(TAG_INFO, str);
    }

    public String getDetailLog() {
        return this.detailLog;
    }

    public void setDetailLog(String str) {
        this.detailLog = str;
    }

    public String getSerial() {
        return this.serial;
    }

    public void setSerial(String str) {
        this.serial = str;
    }

    public void setFirmwareVersion(String str) {
        this.firmwareVersion = str;
    }

    public String getFirmwareVersion() {
        return this.firmwareVersion;
    }

    public List<Integer> getErrorCodes() {
        return this.errorCodes == null ? new ArrayList() : this.errorCodes;
    }

    public void setErrorCodes(List<Integer> list) {
        this.errorCodes = list;
    }

    public void addErrorCode(int i) {
        if (this.errorCodes == null) {
            this.errorCodes = new ArrayList();
        }
        this.errorCodes.add(Integer.valueOf(i));
    }

    public int getLogType() {
        return 0;
    }

    public boolean isHidden() {
        return this.isHidden;
    }

    public void setHidden(boolean z) {
        this.isHidden = z;
    }

    public String getSdkVersion() {
        return this.sdkVersion;
    }
}
