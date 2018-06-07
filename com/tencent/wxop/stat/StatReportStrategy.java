package com.tencent.wxop.stat;

public enum StatReportStrategy {
    INSTANT(1),
    ONLY_WIFI(2),
    BATCH(3),
    APP_LAUNCH(4),
    DEVELOPER(5),
    PERIOD(6),
    ONLY_WIFI_NO_CACHE(7);
    
    int f1643a;

    private StatReportStrategy(int i) {
        this.f1643a = i;
    }

    public static StatReportStrategy getStatReportStrategy(int i) {
        for (StatReportStrategy statReportStrategy : values()) {
            if (i == statReportStrategy.m16102a()) {
                return statReportStrategy;
            }
        }
        return null;
    }

    public final int m16102a() {
        return this.f1643a;
    }
}
