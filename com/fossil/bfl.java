package com.fossil;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;

final class bfl extends Handler {
    private /* synthetic */ bfg btu;

    bfl(bfg com_fossil_bfg, Looper looper) {
        this.btu = com_fossil_bfg;
        super(looper);
    }

    public final void handleMessage(Message message) {
        switch (message.what) {
            case 1:
                this.btu.NJ();
                return;
            case 2:
                this.btu.resume();
                return;
            default:
                Log.w("GoogleApiClientImpl", "Unknown message id: " + message.what);
                return;
        }
    }
}
