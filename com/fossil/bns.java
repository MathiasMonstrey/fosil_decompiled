package com.fossil;

import android.os.Looper;

final class bns implements Runnable {
    private /* synthetic */ bnr bye;

    bns(bnr com_fossil_bnr) {
        this.bye = com_fossil_bnr;
    }

    public final void run() {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            this.bye.zzboe.Pe().m5469h(this);
            return;
        }
        boolean QU = this.bye.QU();
        this.bye.byc = 0;
        if (QU && this.bye.byd) {
            this.bye.run();
        }
    }
}
