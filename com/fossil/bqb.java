package com.fossil;

import java.util.concurrent.Callable;

final class bqb implements Callable<byte[]> {
    private /* synthetic */ String bBU;
    private /* synthetic */ bpp bBY;
    private /* synthetic */ bnz bCc;

    bqb(bpp com_fossil_bpp, bnz com_fossil_bnz, String str) {
        this.bBY = com_fossil_bpp;
        this.bCc = com_fossil_bnz;
        this.bBU = str;
    }

    public final /* synthetic */ Object call() throws Exception {
        this.bBY.zzboe.RQ();
        return this.bBY.zzboe.m5486a(this.bCc, this.bBU);
    }
}
