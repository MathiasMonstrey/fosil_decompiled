package com.misfit.frameworks.buttonservice.model;

import com.fossil.cfj;
import com.misfit.frameworks.common.log.MFLogger;

public class AppInfo {
    private static final String TAG = "AppInfo";
    private String appVersion;
    private String osVersion;

    public AppInfo(String str, String str2) {
        this.appVersion = str;
        this.osVersion = str2;
    }

    public static String getAppInfoJson(AppInfo appInfo) {
        if (appInfo == null) {
            return "";
        }
        try {
            return new cfj().toJson(appInfo);
        } catch (Exception e) {
            MFLogger.m12671e(TAG, "getAppInfoJson - ex=" + e.toString());
            return "";
        }
    }

    public static AppInfo convertJsonToObject(String str) {
        MFLogger.m12670d(TAG, "convertJsonToObject - appInfoJson=" + str);
        try {
            return (AppInfo) new cfj().m6205c(str, AppInfo.class);
        } catch (Exception e) {
            MFLogger.m12671e(TAG, "convertJsonToObject - ex=" + e.toString());
            return null;
        }
    }

    public String getAppVersion() {
        return this.appVersion;
    }

    public String getOsVersion() {
        return this.osVersion;
    }

    public String toString() {
        return "AppInfo{appVersion='" + this.appVersion + '\'' + ", osVersion='" + this.osVersion + '\'' + '}';
    }
}
