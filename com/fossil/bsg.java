package com.fossil;

final class bsg extends bnr {
    private /* synthetic */ bsf bDt;

    bsg(bsf com_fossil_bsf, bpk com_fossil_bpk) {
        this.bDt = com_fossil_bsf;
        super(com_fossil_bpk);
    }

    public final void run() {
        this.bDt.Pf().Ri().log("Sending upload intent from DelayedRunnable");
        this.bDt.Sh();
    }
}
