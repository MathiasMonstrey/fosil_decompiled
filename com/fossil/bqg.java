package com.fossil;

import com.google.android.gms.measurement.AppMeasurement.g;

final class bqg implements Runnable {
    private /* synthetic */ String bBU;
    private /* synthetic */ bpp bBY;
    private /* synthetic */ String bCe;
    private /* synthetic */ String bCf;
    private /* synthetic */ long bCg;

    bqg(bpp com_fossil_bpp, String str, String str2, String str3, long j) {
        this.bBY = com_fossil_bpp;
        this.bCe = str;
        this.bBU = str2;
        this.bCf = str3;
        this.bCg = j;
    }

    public final void run() {
        if (this.bCe == null) {
            this.bBY.zzboe.OW().m5547a(this.bBU, null);
            return;
        }
        g gVar = new g();
        gVar.bJL = this.bCf;
        gVar.bJM = this.bCe;
        gVar.bJN = this.bCg;
        this.bBY.zzboe.OW().m5547a(this.bBU, gVar);
    }
}
