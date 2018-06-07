package com.fossil;

final class bqq implements Runnable {
    private /* synthetic */ bqk bCm;
    private /* synthetic */ long bCq;

    bqq(bqk com_fossil_bqk, long j) {
        this.bCm = com_fossil_bqk;
        this.bCq = j;
    }

    public final void run() {
        this.bCm.Pg().bAk.set(this.bCq);
        this.bCm.Pf().Rh().m5439d("Minimum session duration set", Long.valueOf(this.bCq));
    }
}
