package com.fossil;

final class bnf implements Runnable {
    private /* synthetic */ long bwQ;
    private /* synthetic */ bnc bwR;

    bnf(bnc com_fossil_bnc, long j) {
        this.bwR = com_fossil_bnc;
        this.bwQ = j;
    }

    public final void run() {
        this.bwR.m5309T(this.bwQ);
    }
}
