package com.fossil;

import java.util.List;
import java.util.concurrent.Callable;

final class bpy implements Callable<List<bnk>> {
    private /* synthetic */ String bBU;
    private /* synthetic */ bpp bBY;
    private /* synthetic */ String bCa;
    private /* synthetic */ String bCb;

    bpy(bpp com_fossil_bpp, String str, String str2, String str3) {
        this.bBY = com_fossil_bpp;
        this.bBU = str;
        this.bCa = str2;
        this.bCb = str3;
    }

    public final /* synthetic */ Object call() throws Exception {
        this.bBY.zzboe.RQ();
        return this.bBY.zzboe.OZ().m5368e(this.bBU, this.bCa, this.bCb);
    }
}
