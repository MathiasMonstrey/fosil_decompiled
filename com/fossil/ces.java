package com.fossil;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

final class ces extends Handler {
    private /* synthetic */ cer bQl;

    ces(cer com_fossil_cer, Looper looper) {
        this.bQl = com_fossil_cer;
        super(looper);
    }

    public final void handleMessage(Message message) {
        this.bQl.m6114c(message);
    }
}
