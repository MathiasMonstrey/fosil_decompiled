package com.fossil;

import android.content.Context;

final class ebw implements Runnable {
    final /* synthetic */ String aWB;
    final /* synthetic */ Context bcp;
    final /* synthetic */ dzh dCl;

    ebw(String str, Context context, dzh com_fossil_dzh) {
        this.aWB = str;
        this.bcp = context;
        this.dCl = com_fossil_dzh;
    }

    public final void run() {
        try {
            synchronized (dzg.dBP) {
                if (dzg.dBP.size() >= dze.aBP()) {
                    dzg.dBR.error("The number of page events exceeds the maximum value " + Integer.toString(dze.aBP()));
                    return;
                }
                dzg.aYt = this.aWB;
                if (dzg.dBP.containsKey(dzg.aYt)) {
                    dzg.dBR.da("Duplicate PageID : " + dzg.aYt + ", onResume() repeated?");
                    return;
                }
                dzg.dBP.put(dzg.aYt, Long.valueOf(System.currentTimeMillis()));
                dzg.m10354a(this.bcp, true, this.dCl);
            }
        } catch (Throwable th) {
            dzg.dBR.m10419g(th);
            dzg.m10360a(this.bcp, th);
        }
    }
}
