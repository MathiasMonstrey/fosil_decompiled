package com.fossil;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

public class bbz extends cei {
    static void m4824a(Context context, bce com_fossil_bce) {
        com_fossil_bce.ME();
        Intent intent = new Intent("com.google.android.gms.iid.InstanceID");
        intent.putExtra("CMD", "RST");
        intent.setClassName(context, "com.google.android.gms.gcm.GcmReceiver");
        context.sendBroadcast(intent);
    }

    public void MD() {
    }

    public void handleIntent(Intent intent) {
        if ("com.google.android.gms.iid.InstanceID".equals(intent.getAction())) {
            Bundle bundle = null;
            String stringExtra = intent.getStringExtra("subtype");
            if (stringExtra != null) {
                bundle = new Bundle();
                bundle.putString("subtype", stringExtra);
            }
            bby a = bby.m4823a(this, bundle);
            String stringExtra2 = intent.getStringExtra("CMD");
            if (Log.isLoggable("InstanceID", 3)) {
                Log.d("InstanceID", new StringBuilder((String.valueOf(stringExtra).length() + 34) + String.valueOf(stringExtra2).length()).append("Service command. subtype:").append(stringExtra).append(" command:").append(stringExtra2).toString());
            }
            if ("gcm.googleapis.com/refresh".equals(intent.getStringExtra("from"))) {
                bby.MC().dE(stringExtra);
                MD();
            } else if ("RST".equals(stringExtra2)) {
                a.MB();
                MD();
            } else if ("RST_FULL".equals(stringExtra2)) {
                if (!bby.MC().isEmpty()) {
                    bby.MC().ME();
                    MD();
                }
            } else if ("SYNC".equals(stringExtra2)) {
                bby.MC().dE(stringExtra);
                MD();
            } else {
                "PING".equals(stringExtra2);
            }
        }
    }
}
