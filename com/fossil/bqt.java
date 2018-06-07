package com.fossil;

final class bqt implements Runnable {
    private /* synthetic */ String bCa;
    private /* synthetic */ bqk bCm;
    private /* synthetic */ String bCr;
    private /* synthetic */ long bCs;
    private /* synthetic */ Object bCx;

    bqt(bqk com_fossil_bqk, String str, String str2, Object obj, long j) {
        this.bCm = com_fossil_bqk;
        this.bCa = str;
        this.bCr = str2;
        this.bCx = obj;
        this.bCs = j;
    }

    public final void run() {
        this.bCm.m5531a(this.bCa, this.bCr, this.bCx, this.bCs);
    }
}
