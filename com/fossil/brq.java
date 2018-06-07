package com.fossil;

final class brq implements Runnable {
    private /* synthetic */ bod bDd;
    private /* synthetic */ brp bDe;

    brq(brp com_fossil_brp, bod com_fossil_bod) {
        this.bDe = com_fossil_brp;
        this.bDd = com_fossil_bod;
    }

    public final void run() {
        synchronized (this.bDe) {
            this.bDe.bDb = false;
            if (!this.bDe.bCU.isConnected()) {
                this.bDe.bCU.Pf().Ri().log("Connected to service");
                this.bDe.bCU.m5557a(this.bDd);
            }
        }
    }
}
