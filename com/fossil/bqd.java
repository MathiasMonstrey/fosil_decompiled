package com.fossil;

final class bqd implements Runnable {
    private /* synthetic */ bnh bBX;
    private /* synthetic */ bpp bBY;
    private /* synthetic */ bsh bCd;

    bqd(bpp com_fossil_bpp, bsh com_fossil_bsh, bnh com_fossil_bnh) {
        this.bBY = com_fossil_bpp;
        this.bCd = com_fossil_bsh;
        this.bBX = com_fossil_bnh;
    }

    public final void run() {
        this.bBY.zzboe.RQ();
        this.bBY.zzboe.m5491b(this.bCd, this.bBX);
    }
}
