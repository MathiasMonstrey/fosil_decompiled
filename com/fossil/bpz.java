package com.fossil;

final class bpz implements Runnable {
    private /* synthetic */ bnh bBX;
    private /* synthetic */ bpp bBY;
    private /* synthetic */ bnz bCc;

    bpz(bpp com_fossil_bpp, bnz com_fossil_bnz, bnh com_fossil_bnh) {
        this.bBY = com_fossil_bpp;
        this.bCc = com_fossil_bnz;
        this.bBX = com_fossil_bnh;
    }

    public final void run() {
        this.bBY.zzboe.RQ();
        this.bBY.zzboe.m5488b(this.bCc, this.bBX);
    }
}
