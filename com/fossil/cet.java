package com.fossil;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

final class cet extends BroadcastReceiver {
    private /* synthetic */ cer bQl;

    cet(cer com_fossil_cer) {
        this.bQl = com_fossil_cer;
    }

    public final void onReceive(Context context, Intent intent) {
        if (Log.isLoggable("InstanceID/Rpc", 3)) {
            String valueOf = String.valueOf(intent.getExtras());
            Log.d("InstanceID/Rpc", new StringBuilder(String.valueOf(valueOf).length() + 44).append("Received GSF callback via dynamic receiver: ").append(valueOf).toString());
        }
        this.bQl.m6115p(intent);
    }
}
