package com.fossil;

final class bnd implements Runnable {
    private /* synthetic */ String bwP;
    private /* synthetic */ long bwQ;
    private /* synthetic */ bnc bwR;

    bnd(bnc com_fossil_bnc, String str, long j) {
        this.bwR = com_fossil_bnc;
        this.bwP = str;
        this.bwQ = j;
    }

    public final void run() {
        this.bwR.m5315d(this.bwP, this.bwQ);
    }
}
