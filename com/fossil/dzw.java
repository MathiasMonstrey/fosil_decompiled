package com.fossil;

import android.content.Context;

final class dzw implements Runnable {
    final /* synthetic */ Context baD;
    final /* synthetic */ dzh dCm;

    dzw(Context context, dzh com_fossil_dzh) {
        this.baD = context;
        this.dCm = com_fossil_dzh;
    }

    public final void run() {
        try {
            dzg.m10354a(this.baD, false, this.dCm);
        } catch (Throwable th) {
            dzg.dBR.m10419g(th);
        }
    }
}
