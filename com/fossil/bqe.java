package com.fossil;

import java.util.List;
import java.util.concurrent.Callable;

final class bqe implements Callable<List<bsj>> {
    private /* synthetic */ bnh bBX;
    private /* synthetic */ bpp bBY;

    bqe(bpp com_fossil_bpp, bnh com_fossil_bnh) {
        this.bBY = com_fossil_bpp;
        this.bBX = com_fossil_bnh;
    }

    public final /* synthetic */ Object call() throws Exception {
        this.bBY.zzboe.RQ();
        return this.bBY.zzboe.OZ().dY(this.bBX.packageName);
    }
}
