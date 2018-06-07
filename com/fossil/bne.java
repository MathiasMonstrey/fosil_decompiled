package com.fossil;

final class bne implements Runnable {
    private /* synthetic */ String bwP;
    private /* synthetic */ long bwQ;
    private /* synthetic */ bnc bwR;

    bne(bnc com_fossil_bnc, String str, long j) {
        this.bwR = com_fossil_bnc;
        this.bwP = str;
        this.bwQ = j;
    }

    public final void run() {
        this.bwR.m5316e(this.bwP, this.bwQ);
    }
}
