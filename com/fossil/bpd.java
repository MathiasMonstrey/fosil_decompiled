package com.fossil;

import android.content.Context;
import android.os.Bundle;
import com.google.android.gms.measurement.AppMeasurement;

final class bpd implements Runnable {
    private /* synthetic */ bpk bAC;
    private /* synthetic */ long bAD;
    private /* synthetic */ Bundle bAE;
    private /* synthetic */ bol bAF;
    private /* synthetic */ Context bjN;

    bpd(bpc com_fossil_bpc, bpk com_fossil_bpk, long j, Bundle bundle, Context context, bol com_fossil_bol) {
        this.bAC = com_fossil_bpk;
        this.bAD = j;
        this.bAE = bundle;
        this.bjN = context;
        this.bAF = com_fossil_bol;
    }

    public final void run() {
        bsj T = this.bAC.OZ().m5351T(this.bAC.OT().Pj(), "_fot");
        long longValue = (T == null || !(T.mValue instanceof Long)) ? 0 : ((Long) T.mValue).longValue();
        long j = this.bAD;
        longValue = (longValue <= 0 || (j < longValue && j > 0)) ? j : longValue - 1;
        if (longValue > 0) {
            this.bAE.putLong("click_timestamp", longValue);
        }
        AppMeasurement.getInstance(this.bjN).logEventInternal("auto", "_cmp", this.bAE);
        this.bAF.Ri().log("Install campaign recorded");
    }
}
