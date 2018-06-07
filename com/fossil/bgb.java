package com.fossil;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;

public final class bgb extends BroadcastReceiver {
    private final bgc buk;
    private Context mContext;

    public bgb(bgc com_fossil_bgc) {
        this.buk = com_fossil_bgc;
    }

    public final void onReceive(Context context, Intent intent) {
        Uri data = intent.getData();
        Object obj = null;
        if (data != null) {
            obj = data.getSchemeSpecificPart();
        }
        if ("com.google.android.gms".equals(obj)) {
            this.buk.Ng();
            unregister();
        }
    }

    public final void setContext(Context context) {
        this.mContext = context;
    }

    public final synchronized void unregister() {
        if (this.mContext != null) {
            this.mContext.unregisterReceiver(this);
        }
        this.mContext = null;
    }
}
