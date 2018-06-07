package com.fossil;

import java.util.List;
import java.util.concurrent.Callable;

final class bpv implements Callable<List<bsj>> {
    private /* synthetic */ bnh bBX;
    private /* synthetic */ bpp bBY;
    private /* synthetic */ String bCa;
    private /* synthetic */ String bCb;

    bpv(bpp com_fossil_bpp, bnh com_fossil_bnh, String str, String str2) {
        this.bBY = com_fossil_bpp;
        this.bBX = com_fossil_bnh;
        this.bCa = str;
        this.bCb = str2;
    }

    public final /* synthetic */ Object call() throws Exception {
        this.bBY.zzboe.RQ();
        return this.bBY.zzboe.OZ().m5367d(this.bBX.packageName, this.bCa, this.bCb);
    }
}
