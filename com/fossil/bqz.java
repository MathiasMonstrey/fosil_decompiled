package com.fossil;

import android.os.Bundle;
import com.google.android.gms.measurement.AppMeasurement.g;

final class bqz implements Runnable {
    private /* synthetic */ boolean bCH;
    private /* synthetic */ g bCI;
    private /* synthetic */ brb bCJ;
    private /* synthetic */ bqy bCK;

    bqz(bqy com_fossil_bqy, boolean z, g gVar, brb com_fossil_brb) {
        this.bCK = com_fossil_bqy;
        this.bCH = z;
        this.bCI = gVar;
        this.bCJ = com_fossil_brb;
    }

    public final void run() {
        if (this.bCH && this.bCK.bCy != null) {
            this.bCK.m5545a(this.bCK.bCy);
        }
        Object obj = (this.bCI != null && this.bCI.bJN == this.bCJ.bJN && bsk.ae(this.bCI.bJM, this.bCJ.bJM) && bsk.ae(this.bCI.bJL, this.bCJ.bJL)) ? null : 1;
        if (obj != null) {
            Bundle bundle = new Bundle();
            bqy.m5546a(this.bCJ, bundle);
            if (this.bCI != null) {
                if (this.bCI.bJL != null) {
                    bundle.putString("_pn", this.bCI.bJL);
                }
                bundle.putString("_pc", this.bCI.bJM);
                bundle.putLong("_pi", this.bCI.bJN);
            }
            this.bCK.OS().m5539a("auto", "_vs", bundle);
        }
        this.bCK.bCy = this.bCJ;
        this.bCK.OV().m5559a(this.bCJ);
    }
}
