package com.fossil;

import android.os.Bundle;

final class bqs implements Runnable {
    private /* synthetic */ String bBU;
    private /* synthetic */ String bCa;
    private /* synthetic */ bqk bCm;
    private /* synthetic */ String bCr;
    private /* synthetic */ long bCs;
    private /* synthetic */ Bundle bCt;
    private /* synthetic */ boolean bCu;
    private /* synthetic */ boolean bCv;
    private /* synthetic */ boolean bCw;

    bqs(bqk com_fossil_bqk, String str, String str2, long j, Bundle bundle, boolean z, boolean z2, boolean z3, String str3) {
        this.bCm = com_fossil_bqk;
        this.bCa = str;
        this.bCr = str2;
        this.bCs = j;
        this.bCt = bundle;
        this.bCu = z;
        this.bCv = z2;
        this.bCw = z3;
        this.bBU = str3;
    }

    public final void run() {
        this.bCm.m5536b(this.bCa, this.bCr, this.bCs, this.bCt, this.bCu, this.bCv, this.bCw, this.bBU);
    }
}
