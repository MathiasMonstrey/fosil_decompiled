package com.fossil;

final class bqr implements Runnable {
    private /* synthetic */ bqk bCm;
    private /* synthetic */ long bCq;

    bqr(bqk com_fossil_bqk, long j) {
        this.bCm = com_fossil_bqk;
        this.bCq = j;
    }

    public final void run() {
        this.bCm.Pg().bAl.set(this.bCq);
        this.bCm.Pf().Rh().m5439d("Session timeout duration set", Long.valueOf(this.bCq));
    }
}
