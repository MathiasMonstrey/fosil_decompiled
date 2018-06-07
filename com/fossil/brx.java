package com.fossil;

import android.os.Build.VERSION;

final class brx implements Runnable {
    private /* synthetic */ brw bDl;

    brx(brw com_fossil_brw) {
        this.bDl = com_fossil_brw;
    }

    public final void run() {
        if (this.bDl.bDi == null) {
            bnm.Qh();
            if (VERSION.SDK_INT >= 24) {
                this.bDl.bAF.Ri().log("AppMeasurementJobService processed last upload request.");
                this.bDl.bDk.bDh.m5574a(this.bDl.bDj, false);
            }
        } else if (this.bDl.bDk.bDh.ii(this.bDl.bDi.intValue())) {
            bnm.Qh();
            this.bDl.bAF.Ri().m5439d("Local AppMeasurementService processed last upload request. StartId", this.bDl.bDi);
        }
    }
}
