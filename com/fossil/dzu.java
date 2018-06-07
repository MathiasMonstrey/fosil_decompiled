package com.fossil;

import android.content.Context;

final class dzu implements Runnable {
    final /* synthetic */ String aWR;
    final /* synthetic */ Context baD;
    final /* synthetic */ dzh dCl;

    dzu(Context context, String str, dzh com_fossil_dzh) {
        this.baD = context;
        this.aWR = str;
        this.dCl = com_fossil_dzh;
    }

    public final void run() {
        try {
            Long l;
            dzg.dw(this.baD);
            synchronized (dzg.dBP) {
                l = (Long) dzg.dBP.remove(this.aWR);
            }
            if (l != null) {
                Long valueOf = Long.valueOf((System.currentTimeMillis() - l.longValue()) / 1000);
                if (valueOf.longValue() <= 0) {
                    valueOf = Long.valueOf(1);
                }
                String aCb = dzg.dBO;
                if (aCb != null && aCb.equals(this.aWR)) {
                    aCb = "-";
                }
                dzm com_fossil_dzp = new dzp(this.baD, aCb, this.aWR, dzg.m10354a(this.baD, false, this.dCl), valueOf, this.dCl);
                if (!this.aWR.equals(dzg.aYt)) {
                    dzg.dBR.warn("Invalid invocation since previous onResume on diff page.");
                }
                new dzz(com_fossil_dzp).HJ();
                dzg.dBO = this.aWR;
                return;
            }
            dzg.dBR.da("Starttime for PageID:" + this.aWR + " not found, lost onResume()?");
        } catch (Throwable th) {
            dzg.dBR.m10419g(th);
            dzg.m10360a(this.baD, th);
        }
    }
}
