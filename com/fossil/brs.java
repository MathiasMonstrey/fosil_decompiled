package com.fossil;

final class brs implements Runnable {
    private /* synthetic */ brp bDe;
    private /* synthetic */ bod bDg;

    brs(brp com_fossil_brp, bod com_fossil_bod) {
        this.bDe = com_fossil_brp;
        this.bDg = com_fossil_bod;
    }

    public final void run() {
        synchronized (this.bDe) {
            this.bDe.bDb = false;
            if (!this.bDe.bCU.isConnected()) {
                this.bDe.bCU.Pf().Rh().log("Connected to remote service");
                this.bDe.bCU.m5557a(this.bDg);
            }
        }
    }
}
