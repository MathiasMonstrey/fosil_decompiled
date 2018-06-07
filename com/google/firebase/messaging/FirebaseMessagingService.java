package com.google.firebase.messaging;

import android.app.PendingIntent;
import android.app.PendingIntent.CanceledException;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import com.facebook.appevents.AppEventsConstants;
import com.fossil.cei;
import com.fossil.cew;
import com.fossil.cez;
import com.fossil.cfd;
import java.util.Iterator;

public class FirebaseMessagingService extends cei {
    public static boolean m14559C(Bundle bundle) {
        return bundle == null ? false : AppEventsConstants.EVENT_PARAM_VALUE_YES.equals(bundle.getString("google.c.a.e"));
    }

    public static void m14560n(Bundle bundle) {
        Iterator it = bundle.keySet().iterator();
        while (it.hasNext()) {
            String str = (String) it.next();
            if (str != null && str.startsWith("google.c.")) {
                it.remove();
            }
        }
    }

    public void Mq() {
    }

    public void mo5414a(cez com_fossil_cez) {
    }

    public void mo5415a(String str, Exception exception) {
    }

    public void dy(String str) {
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void handleIntent(android.content.Intent r6) {
        /*
        r5 = this;
        r3 = 1;
        r1 = 0;
        r2 = -1;
        r0 = r6.getAction();
        if (r0 != 0) goto L_0x000b;
    L_0x0009:
        r0 = "";
    L_0x000b:
        r4 = r0.hashCode();
        switch(r4) {
            case 75300319: goto L_0x003a;
            case 366519424: goto L_0x0030;
            default: goto L_0x0012;
        };
    L_0x0012:
        r0 = r2;
    L_0x0013:
        switch(r0) {
            case 0: goto L_0x0044;
            case 1: goto L_0x010b;
            default: goto L_0x0016;
        };
    L_0x0016:
        r1 = "FirebaseMessaging";
        r2 = "Unknown intent action: ";
        r0 = r6.getAction();
        r0 = java.lang.String.valueOf(r0);
        r3 = r0.length();
        if (r3 == 0) goto L_0x011a;
    L_0x0028:
        r0 = r2.concat(r0);
    L_0x002c:
        android.util.Log.d(r1, r0);
    L_0x002f:
        return;
    L_0x0030:
        r4 = "com.google.android.c2dm.intent.RECEIVE";
        r0 = r0.equals(r4);
        if (r0 == 0) goto L_0x0012;
    L_0x0038:
        r0 = r1;
        goto L_0x0013;
    L_0x003a:
        r4 = "com.google.firebase.messaging.NOTIFICATION_DISMISS";
        r0 = r0.equals(r4);
        if (r0 == 0) goto L_0x0012;
    L_0x0042:
        r0 = r3;
        goto L_0x0013;
    L_0x0044:
        r0 = "message_type";
        r0 = r6.getStringExtra(r0);
        if (r0 != 0) goto L_0x004e;
    L_0x004c:
        r0 = "gcm";
    L_0x004e:
        r4 = r0.hashCode();
        switch(r4) {
            case -2062414158: goto L_0x0078;
            case 102161: goto L_0x006f;
            case 814694033: goto L_0x008c;
            case 814800675: goto L_0x0082;
            default: goto L_0x0055;
        };
    L_0x0055:
        r1 = r2;
    L_0x0056:
        switch(r1) {
            case 0: goto L_0x0096;
            case 1: goto L_0x00d6;
            case 2: goto L_0x00db;
            case 3: goto L_0x00e6;
            default: goto L_0x0059;
        };
    L_0x0059:
        r1 = "FirebaseMessaging";
        r2 = "Received message with unknown type: ";
        r0 = java.lang.String.valueOf(r0);
        r3 = r0.length();
        if (r3 == 0) goto L_0x0104;
    L_0x0067:
        r0 = r2.concat(r0);
    L_0x006b:
        android.util.Log.w(r1, r0);
        goto L_0x002f;
    L_0x006f:
        r3 = "gcm";
        r3 = r0.equals(r3);
        if (r3 == 0) goto L_0x0055;
    L_0x0077:
        goto L_0x0056;
    L_0x0078:
        r1 = "deleted_messages";
        r1 = r0.equals(r1);
        if (r1 == 0) goto L_0x0055;
    L_0x0080:
        r1 = r3;
        goto L_0x0056;
    L_0x0082:
        r1 = "send_event";
        r1 = r0.equals(r1);
        if (r1 == 0) goto L_0x0055;
    L_0x008a:
        r1 = 2;
        goto L_0x0056;
    L_0x008c:
        r1 = "send_error";
        r1 = r0.equals(r1);
        if (r1 == 0) goto L_0x0055;
    L_0x0094:
        r1 = 3;
        goto L_0x0056;
    L_0x0096:
        r0 = r6.getExtras();
        r0 = m14559C(r0);
        if (r0 == 0) goto L_0x00a3;
    L_0x00a0:
        com.fossil.cfd.f(r5, r6);
    L_0x00a3:
        r0 = r6.getExtras();
        if (r0 != 0) goto L_0x00ae;
    L_0x00a9:
        r0 = new android.os.Bundle;
        r0.<init>();
    L_0x00ae:
        r1 = "android.support.content.wakelockid";
        r0.remove(r1);
        r1 = com.fossil.cfa.D(r0);
        if (r1 == 0) goto L_0x00cc;
    L_0x00b9:
        r1 = com.fossil.cfa.bi(r5);
        r1 = r1.s(r0);
        if (r1 != 0) goto L_0x002f;
    L_0x00c3:
        r1 = m14559C(r0);
        if (r1 == 0) goto L_0x00cc;
    L_0x00c9:
        com.fossil.cfd.i(r5, r6);
    L_0x00cc:
        r1 = new com.fossil.cez;
        r1.<init>(r0);
        r5.mo5414a(r1);
        goto L_0x002f;
    L_0x00d6:
        r5.Mq();
        goto L_0x002f;
    L_0x00db:
        r0 = "google.message_id";
        r0 = r6.getStringExtra(r0);
        r5.dy(r0);
        goto L_0x002f;
    L_0x00e6:
        r0 = "google.message_id";
        r0 = r6.getStringExtra(r0);
        if (r0 != 0) goto L_0x00f4;
    L_0x00ee:
        r0 = "message_id";
        r0 = r6.getStringExtra(r0);
    L_0x00f4:
        r1 = new com.google.firebase.messaging.SendException;
        r2 = "error";
        r2 = r6.getStringExtra(r2);
        r1.<init>(r2);
        r5.mo5415a(r0, r1);
        goto L_0x002f;
    L_0x0104:
        r0 = new java.lang.String;
        r0.<init>(r2);
        goto L_0x006b;
    L_0x010b:
        r0 = r6.getExtras();
        r0 = m14559C(r0);
        if (r0 == 0) goto L_0x002f;
    L_0x0115:
        com.fossil.cfd.h(r5, r6);
        goto L_0x002f;
    L_0x011a:
        r0 = new java.lang.String;
        r0.<init>(r2);
        goto L_0x002c;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.messaging.FirebaseMessagingService.handleIntent(android.content.Intent):void");
    }

    public final boolean m14563l(Intent intent) {
        if (!"com.google.firebase.messaging.NOTIFICATION_OPEN".equals(intent.getAction())) {
            return false;
        }
        PendingIntent pendingIntent = (PendingIntent) intent.getParcelableExtra("pending_intent");
        if (pendingIntent != null) {
            try {
                pendingIntent.send();
            } catch (CanceledException e) {
                Log.e("FirebaseMessaging", "Notification pending intent canceled");
            }
        }
        if (m14559C(intent.getExtras())) {
            cfd.g(this, intent);
        }
        return true;
    }

    protected final Intent m14564m(Intent intent) {
        return cew.Wk().Wl();
    }
}
