package com.fossil;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

public final class bpc {
    private final bpe bAB;

    public bpc(bpe com_fossil_bpe) {
        awa.bO(com_fossil_bpe);
        this.bAB = com_fossil_bpe;
    }

    public static boolean m5452f(Context context, boolean z) {
        awa.bO(context);
        return bsk.m5592e(context, "com.google.android.gms.measurement.AppMeasurementReceiver", false);
    }

    public final void onReceive(Context context, Intent intent) {
        bpk aR = bpk.aR(context);
        bol Pf = aR.Pf();
        if (intent == null) {
            Pf.Re().log("Receiver called with null intent");
            return;
        }
        bnm.Qh();
        String action = intent.getAction();
        Pf.Ri().m5439d("Local receiver got", action);
        if ("com.google.android.gms.measurement.UPLOAD".equals(action)) {
            brv.m5573g(context, false);
            Intent className = new Intent().setClassName(context, "com.google.android.gms.measurement.AppMeasurementService");
            className.setAction("com.google.android.gms.measurement.UPLOAD");
            this.bAB.m5453b(context, className);
        } else if ("com.android.vending.INSTALL_REFERRER".equals(action)) {
            action = intent.getStringExtra("referrer");
            if (action == null) {
                Pf.Ri().log("Install referrer extras are null");
                return;
            }
            Pf.Rg().m5439d("Install referrer extras are", action);
            if (!action.contains("?")) {
                String str = "?";
                action = String.valueOf(action);
                action = action.length() != 0 ? str.concat(action) : new String(str);
            }
            Bundle j = aR.Pb().m5609j(Uri.parse(action));
            if (j == null) {
                Pf.Ri().log("No campaign defined in install referrer broadcast");
                return;
            }
            long longExtra = 1000 * intent.getLongExtra("referrer_timestamp_seconds", 0);
            if (longExtra == 0) {
                Pf.Re().log("Install referrer is missing timestamp");
            }
            aR.Pe().m5469h(new bpd(this, aR, longExtra, j, context, Pf));
        }
    }
}
