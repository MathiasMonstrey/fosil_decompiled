package com.portfolio.platform.data;

import android.text.TextUtils;

public enum NotificationSource {
    OS,
    CALL,
    TEXT,
    MAIL;

    public static final NotificationSource find(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return valueOf(str);
    }
}
