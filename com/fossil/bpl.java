package com.fossil;

final class bpl implements Runnable {
    private /* synthetic */ bpk bBT;

    bpl(bpk com_fossil_bpk) {
        this.bBT = com_fossil_bpk;
    }

    public final void run() {
        this.bBT.start();
    }
}
