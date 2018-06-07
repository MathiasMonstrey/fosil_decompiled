package com.fossil;

import com.google.android.gms.measurement.AppMeasurement.ConditionalUserProperty;

final class bqm implements Runnable {
    private /* synthetic */ bqk bCm;
    private /* synthetic */ ConditionalUserProperty bCn;

    bqm(bqk com_fossil_bqk, ConditionalUserProperty conditionalUserProperty) {
        this.bCm = com_fossil_bqk;
        this.bCn = conditionalUserProperty;
    }

    public final void run() {
        this.bCm.m5535b(this.bCn);
    }
}
