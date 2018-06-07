package com.fossil;

final class bql implements Runnable {
    private /* synthetic */ boolean OL;
    private /* synthetic */ bqk bCm;

    bql(bqk com_fossil_bqk, boolean z) {
        this.bCm = com_fossil_bqk;
        this.OL = z;
    }

    public final void run() {
        this.bCm.bg(this.OL);
    }
}
