package com.fossil;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

class eaj extends BroadcastReceiver {
    final /* synthetic */ dzi dCE;

    eaj(dzi com_fossil_dzi) {
        this.dCE = com_fossil_dzi;
    }

    public void onReceive(Context context, Intent intent) {
        if (this.dCE.dBV != null) {
            this.dCE.dBV.m10423a(new eao(this));
        }
    }
}
