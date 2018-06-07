package com.flurry.sdk;

public enum jq {
    DeviceId(0, true),
    AndroidAdvertisingId(13, true),
    AndroidInstallationId(14, false);
    
    public final int f1321d;
    public final boolean f1322e;

    private jq(int i, boolean z) {
        this.f1321d = i;
        this.f1322e = z;
    }
}
