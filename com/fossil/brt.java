package com.fossil;

import android.content.ComponentName;
import android.content.Context;

final class brt implements Runnable {
    private /* synthetic */ brp bDe;

    brt(brp com_fossil_brp) {
        this.bDe = com_fossil_brp;
    }

    public final void run() {
        brc com_fossil_brc = this.bDe.bCU;
        Context context = this.bDe.bCU.getContext();
        bnm.Qh();
        com_fossil_brc.onServiceDisconnected(new ComponentName(context, "com.google.android.gms.measurement.AppMeasurementService"));
    }
}
