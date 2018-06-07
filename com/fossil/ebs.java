package com.fossil;

import android.content.Context;

final class ebs implements Runnable {
    final /* synthetic */ Context baD;
    final /* synthetic */ dzh dCm;

    ebs(Context context, dzh com_fossil_dzh) {
        this.baD = context;
        this.dCm = com_fossil_dzh;
    }

    public final void run() {
        if (this.baD == null) {
            dzg.dBR.error("The Context of StatService.onPause() can not be null!");
        } else {
            dzg.m10363b(this.baD, ebb.dG(this.baD), this.dCm);
        }
    }
}
