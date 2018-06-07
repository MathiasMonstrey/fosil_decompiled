package com.fossil;

import android.app.PendingIntent;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;

final class awq extends Handler {
    private /* synthetic */ awm bix;

    public awq(awm com_fossil_awm, Looper looper) {
        this.bix = com_fossil_awm;
        super(looper);
    }

    private static void m4650a(Message message) {
        ((awr) message.obj).unregister();
    }

    private static boolean m4651b(Message message) {
        return message.what == 2 || message.what == 1 || message.what == 7;
    }

    public final void handleMessage(Message message) {
        PendingIntent pendingIntent = null;
        if (this.bix.biu.get() != message.arg1) {
            if (m4651b(message)) {
                m4650a(message);
            }
        } else if ((message.what == 1 || message.what == 7 || message.what == 4 || message.what == 5) && !this.bix.isConnecting()) {
            m4650a(message);
        } else if (message.what == 4) {
            this.bix.bis = new atn(message.arg2);
            if (!this.bix.Lp() || this.bix.bit) {
                r0 = this.bix.bis != null ? this.bix.bis : new atn(8);
                this.bix.bij.mo1210d(r0);
                this.bix.m4382a(r0);
                return;
            }
            this.bix.m4368a(3, null);
        } else if (message.what == 5) {
            r0 = this.bix.bis != null ? this.bix.bis : new atn(8);
            this.bix.bij.mo1210d(r0);
            this.bix.m4382a(r0);
        } else if (message.what == 3) {
            if (message.obj instanceof PendingIntent) {
                pendingIntent = (PendingIntent) message.obj;
            }
            atn com_fossil_atn = new atn(message.arg2, pendingIntent);
            this.bix.bij.mo1210d(com_fossil_atn);
            this.bix.m4382a(com_fossil_atn);
        } else if (message.what == 6) {
            this.bix.m4368a(5, null);
            if (this.bix.bio != null) {
                this.bix.bio.hr(message.arg2);
            }
            this.bix.hr(message.arg2);
            this.bix.m4371a(5, 1, null);
        } else if (message.what == 2 && !this.bix.isConnected()) {
            m4650a(message);
        } else if (m4651b(message)) {
            ((awr) message.obj).Lr();
        } else {
            Log.wtf("GmsClient", "Don't know how to handle message: " + message.what, new Exception());
        }
    }
}
