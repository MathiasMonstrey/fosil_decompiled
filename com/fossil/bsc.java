package com.fossil;

final class bsc implements Runnable {
    private /* synthetic */ brz bDp;
    private /* synthetic */ long bwQ;

    bsc(brz com_fossil_brz, long j) {
        this.bDp = com_fossil_brz;
        this.bwQ = j;
    }

    public final void run() {
        this.bDp.ao(this.bwQ);
    }
}
