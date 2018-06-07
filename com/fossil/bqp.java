package com.fossil;

import java.util.concurrent.atomic.AtomicReference;

final class bqp implements Runnable {
    private /* synthetic */ String bBU;
    private /* synthetic */ String bCa;
    private /* synthetic */ String bCb;
    private /* synthetic */ bqk bCm;
    private /* synthetic */ AtomicReference bCo;
    private /* synthetic */ boolean bCp;

    bqp(bqk com_fossil_bqk, AtomicReference atomicReference, String str, String str2, String str3, boolean z) {
        this.bCm = com_fossil_bqk;
        this.bCo = atomicReference;
        this.bBU = str;
        this.bCa = str2;
        this.bCb = str3;
        this.bCp = z;
    }

    public final void run() {
        this.bCm.zzboe.OV().m5562a(this.bCo, this.bBU, this.bCa, this.bCb, this.bCp);
    }
}
