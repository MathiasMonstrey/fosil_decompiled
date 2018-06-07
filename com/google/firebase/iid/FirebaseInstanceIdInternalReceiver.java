package com.google.firebase.iid;

import android.content.Context;
import android.content.Intent;
import android.os.Parcelable;
import android.util.Log;
import com.fossil.axt;
import com.fossil.ceo;
import com.fossil.cew;
import com.fossil.ha;

public final class FirebaseInstanceIdInternalReceiver extends ha {
    private static ceo bPB;
    private static ceo bPC;
    private static boolean boX = false;

    static boolean be(Context context) {
        return axt.LK() && context.getApplicationInfo().targetSdkVersion > 25;
    }

    static synchronized ceo m14551s(Context context, String str) {
        ceo com_fossil_ceo;
        synchronized (FirebaseInstanceIdInternalReceiver.class) {
            if ("com.google.firebase.MESSAGING_EVENT".equals(str)) {
                if (bPC == null) {
                    bPC = new ceo(context, str);
                }
                com_fossil_ceo = bPC;
            } else {
                if (bPB == null) {
                    bPB = new ceo(context, str);
                }
                com_fossil_ceo = bPB;
            }
        }
        return com_fossil_ceo;
    }

    public final void onReceive(Context context, Intent intent) {
        if (intent != null) {
            Parcelable parcelableExtra = intent.getParcelableExtra("wrapped_intent");
            if (parcelableExtra instanceof Intent) {
                Intent intent2 = (Intent) parcelableExtra;
                if (be(context)) {
                    m14551s(context, intent.getAction()).a(intent2, goAsync());
                    return;
                } else {
                    cew.Wk().a(context, intent.getAction(), intent2);
                    return;
                }
            }
            Log.e("FirebaseInstanceId", "Missing or invalid wrapped intent");
        }
    }
}
