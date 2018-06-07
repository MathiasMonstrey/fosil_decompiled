package com.fossil;

final class bsd implements Runnable {
    private /* synthetic */ brz bDp;
    private /* synthetic */ long bwQ;

    bsd(brz com_fossil_brz, long j) {
        this.bDp = com_fossil_brz;
        this.bwQ = j;
    }

    public final void run() {
        this.bDp.ap(this.bwQ);
    }
}
