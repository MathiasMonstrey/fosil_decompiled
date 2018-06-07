package com.fossil;

final class bru implements Runnable {
    private /* synthetic */ brp bDe;

    bru(brp com_fossil_brp) {
        this.bDe = com_fossil_brp;
    }

    public final void run() {
        this.bDe.bCU.bCO = null;
        this.bDe.bCU.Sa();
    }
}
