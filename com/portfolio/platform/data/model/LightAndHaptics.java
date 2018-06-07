package com.portfolio.platform.data.model;

import com.portfolio.platform.data.NotificationType;

public class LightAndHaptics implements Comparable<LightAndHaptics> {
    private int hour;
    private NotificationPriority mPriority;
    private String packageName;
    private String senderName;
    private long timestamp = System.currentTimeMillis();
    private NotificationType type;

    public LightAndHaptics(String str, NotificationType notificationType, String str2, int i, NotificationPriority notificationPriority) {
        this.packageName = str;
        this.type = notificationType;
        this.senderName = str2;
        this.hour = i;
        this.mPriority = notificationPriority;
    }

    public String getPackageName() {
        return this.packageName;
    }

    public NotificationType getType() {
        return this.type;
    }

    public String getSenderName() {
        return this.senderName;
    }

    public long getTimestamp() {
        return this.timestamp;
    }

    public void setTimestamp(long j) {
        this.timestamp = j;
    }

    public void setNotificationType(NotificationType notificationType) {
        this.type = notificationType;
    }

    public NotificationType getNotificationType() {
        return this.type;
    }

    public int getHour() {
        return this.hour;
    }

    public void setHour(int i) {
        this.hour = i;
    }

    public int compareTo(LightAndHaptics lightAndHaptics) {
        return this.mPriority.compareTo(lightAndHaptics.mPriority);
    }

    public NotificationPriority getPriority() {
        return this.mPriority;
    }
}
