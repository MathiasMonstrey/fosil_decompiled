package com.tencent.wxop.stat.p000a;

public enum C5068f {
    PAGE_VIEW(1),
    SESSION_ENV(2),
    ERROR(3),
    CUSTOM(1000),
    ADDITION(1001),
    MONITOR_STAT(1002),
    MTA_GAME_USER(1003),
    NETWORK_MONITOR(1004),
    NETWORK_DETECTOR(1005);
    
    private int f1653j;

    private C5068f(int i) {
        this.f1653j = i;
    }

    public final int m16103a() {
        return this.f1653j;
    }
}
