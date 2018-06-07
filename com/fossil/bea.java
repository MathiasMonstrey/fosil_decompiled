package com.fossil;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import android.util.Pair;
import com.google.android.gms.common.api.Status;

public final class bea<R extends atz> extends Handler {
    public bea() {
        this(Looper.getMainLooper());
    }

    public bea(Looper looper) {
        super(looper);
    }

    public final void m4919a(aua<? super R> com_fossil_aua__super_R, R r) {
        sendMessage(obtainMessage(1, new Pair(com_fossil_aua__super_R, r)));
    }

    public final void handleMessage(Message message) {
        switch (message.what) {
            case 1:
                Pair pair = (Pair) message.obj;
                aua com_fossil_aua = (aua) pair.first;
                atz com_fossil_atz = (atz) pair.second;
                try {
                    com_fossil_aua.mo1184a(com_fossil_atz);
                    return;
                } catch (RuntimeException e) {
                    bdy.m4400f(com_fossil_atz);
                    throw e;
                }
            case 2:
                ((bdy) message.obj).m4407j(Status.bgz);
                return;
            default:
                Log.wtf("BasePendingResult", "Don't know how to handle message: " + message.what, new Exception());
                return;
        }
    }
}
