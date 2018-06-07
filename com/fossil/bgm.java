package com.fossil;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

final class bgm extends Handler {
    private /* synthetic */ bgl buA;

    public bgm(bgl com_fossil_bgl, Looper looper) {
        this.buA = com_fossil_bgl;
        super(looper);
    }

    public final void handleMessage(Message message) {
        boolean z = true;
        if (message.what != 1) {
            z = false;
        }
        awa.aY(z);
        this.buA.m5139b((bgo) message.obj);
    }
}
