package com.fossil;

import android.content.Context;

final class ebt implements Runnable {
    final /* synthetic */ Context baD;
    final /* synthetic */ Throwable dDp;

    ebt(Context context, Throwable th) {
        this.baD = context;
        this.dDp = th;
    }

    public final void run() {
        try {
            if (dze.aBH()) {
                new dzz(new dzl(this.baD, dzg.m10354a(this.baD, false, null), 99, this.dDp, dzn.dCg)).HJ();
            }
        } catch (Throwable th) {
            dzg.dBR.da("reportSdkSelfException error: " + th);
        }
    }
}
