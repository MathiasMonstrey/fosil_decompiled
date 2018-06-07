package com.fossil;

import android.content.Context;

final class ebv implements Runnable {
    final /* synthetic */ Context baD;
    final /* synthetic */ dzh dCm;
    final /* synthetic */ dzk dDq;

    ebv(Context context, dzh com_fossil_dzh, dzk com_fossil_dzk) {
        this.baD = context;
        this.dCm = com_fossil_dzh;
        this.dDq = com_fossil_dzk;
    }

    public final void run() {
        try {
            dzm com_fossil_dzj = new dzj(this.baD, dzg.m10354a(this.baD, false, this.dCm), this.dDq.aWB, this.dCm);
            com_fossil_dzj.aCk().dCb = this.dDq.dCb;
            new dzz(com_fossil_dzj).HJ();
        } catch (Throwable th) {
            dzg.dBR.m10419g(th);
            dzg.m10360a(this.baD, th);
        }
    }
}
