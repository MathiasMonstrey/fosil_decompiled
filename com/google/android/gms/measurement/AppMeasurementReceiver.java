package com.google.android.gms.measurement;

import android.content.Context;
import android.content.Intent;
import com.fossil.bpc;
import com.fossil.bpe;
import com.fossil.ha;

public final class AppMeasurementReceiver extends ha implements bpe {
    private bpc bJO;

    public final void m14283b(Context context, Intent intent) {
        a(context, intent);
    }

    public final void onReceive(Context context, Intent intent) {
        if (this.bJO == null) {
            this.bJO = new bpc(this);
        }
        this.bJO.onReceive(context, intent);
    }
}
