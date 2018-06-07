package com.fossil;

import com.tencent.wxop.stat.StatReportStrategy;

/* synthetic */ class dzt {
    static final /* synthetic */ int[] f1486a = new int[StatReportStrategy.values().length];

    static {
        try {
            f1486a[StatReportStrategy.INSTANT.ordinal()] = 1;
        } catch (NoSuchFieldError e) {
        }
        try {
            f1486a[StatReportStrategy.PERIOD.ordinal()] = 2;
        } catch (NoSuchFieldError e2) {
        }
        try {
            f1486a[StatReportStrategy.APP_LAUNCH.ordinal()] = 3;
        } catch (NoSuchFieldError e3) {
        }
        try {
            f1486a[StatReportStrategy.DEVELOPER.ordinal()] = 4;
        } catch (NoSuchFieldError e4) {
        }
        try {
            f1486a[StatReportStrategy.BATCH.ordinal()] = 5;
        } catch (NoSuchFieldError e5) {
        }
        try {
            f1486a[StatReportStrategy.ONLY_WIFI.ordinal()] = 6;
        } catch (NoSuchFieldError e6) {
        }
        try {
            f1486a[StatReportStrategy.ONLY_WIFI_NO_CACHE.ordinal()] = 7;
        } catch (NoSuchFieldError e7) {
        }
    }
}
