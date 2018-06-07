package com.fossil;

final class bpr implements Runnable {
    private /* synthetic */ bnh bBX;
    private /* synthetic */ bpp bBY;
    private /* synthetic */ bnk bBZ;

    bpr(bpp com_fossil_bpp, bnk com_fossil_bnk, bnh com_fossil_bnh) {
        this.bBY = com_fossil_bpp;
        this.bBZ = com_fossil_bnk;
        this.bBX = com_fossil_bnh;
    }

    public final void run() {
        this.bBY.zzboe.RQ();
        this.bBY.zzboe.m5493c(this.bBZ, this.bBX);
    }
}
