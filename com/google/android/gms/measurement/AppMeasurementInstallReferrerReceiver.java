package com.google.android.gms.measurement;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.fossil.bpc;
import com.fossil.bpe;

public final class AppMeasurementInstallReferrerReceiver extends BroadcastReceiver implements bpe {
    private bpc bJO;

    public final void m14281b(Context context, Intent intent) {
    }

    public final void onReceive(Context context, Intent intent) {
        if (this.bJO == null) {
            this.bJO = new bpc(this);
        }
        this.bJO.onReceive(context, intent);
    }
}
