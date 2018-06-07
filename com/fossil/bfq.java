package com.fossil;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;

final class bfq extends Handler {
    private /* synthetic */ bfo btJ;

    bfq(bfo com_fossil_bfo, Looper looper) {
        this.btJ = com_fossil_bfo;
        super(looper);
    }

    public final void handleMessage(Message message) {
        switch (message.what) {
            case 1:
                ((bfp) message.obj).m5005c(this.btJ);
                return;
            case 2:
                throw ((RuntimeException) message.obj);
            default:
                Log.w("GACStateManager", "Unknown message id: " + message.what);
                return;
        }
    }
}
