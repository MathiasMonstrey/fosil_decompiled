package com.portfolio.platform.data.model;

import com.portfolio.platform.data.NotificationSource;

public class NotificationInfo {
    private final String appName;
    private final String body;
    private String packageName;
    private final String senderInfo;
    private final NotificationSource source;

    public NotificationInfo(NotificationSource notificationSource, String str, String str2, String str3) {
        this(notificationSource, str, str2, str3, "");
    }

    public NotificationInfo(NotificationSource notificationSource, String str, String str2, String str3, String str4) {
        this.source = notificationSource;
        this.senderInfo = str;
        this.body = str2;
        this.packageName = str3;
        this.appName = str4;
    }

    public String getSenderInfo() {
        return this.senderInfo;
    }

    public String getBody() {
        return this.body;
    }

    public NotificationSource getSource() {
        return this.source;
    }

    public String getPackageName() {
        return this.packageName;
    }

    public void setPackageName(String str) {
        this.packageName = str;
    }

    public String getAppName() {
        return this.appName;
    }
}
