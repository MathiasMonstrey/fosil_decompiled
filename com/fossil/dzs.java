package com.fossil;

import android.content.Context;

final class dzs implements Runnable {
    final /* synthetic */ Context baD;

    dzs(Context context) {
        this.baD = context;
    }

    public final void run() {
        try {
            new Thread(new dzy(this.baD, null, null), "NetworkMonitorTask").start();
        } catch (Throwable th) {
            dzg.dBR.m10419g(th);
            dzg.m10360a(this.baD, th);
        }
    }
}
