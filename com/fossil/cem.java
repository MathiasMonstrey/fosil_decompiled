package com.fossil;

import android.os.Binder;
import android.os.Process;
import android.util.Log;

public final class cem extends Binder {
    private final cei bPQ;

    cem(cei com_fossil_cei) {
        this.bPQ = com_fossil_cei;
    }

    public final void m6100a(cek com_fossil_cek) {
        if (Binder.getCallingUid() != Process.myUid()) {
            throw new SecurityException("Binding only allowed within app");
        }
        if (Log.isLoggable("EnhancedIntentService", 3)) {
            Log.d("EnhancedIntentService", "service received new intent via bind strategy");
        }
        if (this.bPQ.m4799l(com_fossil_cek.intent)) {
            com_fossil_cek.finish();
            return;
        }
        if (Log.isLoggable("EnhancedIntentService", 3)) {
            Log.d("EnhancedIntentService", "intent being queued for bg execution");
        }
        this.bPQ.bAL.execute(new cen(this, com_fossil_cek));
    }
}
