package com.fossil;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import com.facebook.appevents.AppEventsConstants;
import java.util.Iterator;

public class bbl extends cei {
    static void m4801n(Bundle bundle) {
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

    public void m4802O(String str, String str2) {
    }

    public void dy(String str) {
    }

    public void m4803f(String str, Bundle bundle) {
    }

    public void handleIntent(Intent intent) {
        String stringExtra;
        if ("com.google.android.c2dm.intent.RECEIVE".equals(intent.getAction())) {
            stringExtra = intent.getStringExtra("message_type");
            if (stringExtra == null) {
                stringExtra = "gcm";
            }
            Object obj = -1;
            switch (stringExtra.hashCode()) {
                case -2062414158:
                    if (stringExtra.equals("deleted_messages")) {
                        int i = 1;
                        break;
                    }
                    break;
                case 102161:
                    if (stringExtra.equals("gcm")) {
                        obj = null;
                        break;
                    }
                    break;
                case 814694033:
                    if (stringExtra.equals("send_error")) {
                        obj = 3;
                        break;
                    }
                    break;
                case 814800675:
                    if (stringExtra.equals("send_event")) {
                        obj = 2;
                        break;
                    }
                    break;
            }
            switch (obj) {
                case null:
                    Bundle extras = intent.getExtras();
                    extras.remove("message_type");
                    extras.remove("android.support.content.wakelockid");
                    Object obj2 = (AppEventsConstants.EVENT_PARAM_VALUE_YES.equals(bbr.m4817c(extras, "gcm.n.e")) || bbr.m4817c(extras, "gcm.n.icon") != null) ? 1 : null;
                    if (obj2 != null) {
                        if (bbr.aI(this)) {
                            bbr.m4819r(extras);
                        } else {
                            bbr.aH(this).m4821s(extras);
                            return;
                        }
                    }
                    stringExtra = extras.getString("from");
                    extras.remove("from");
                    m4801n(extras);
                    m4803f(stringExtra, extras);
                    return;
                case 1:
                    Mq();
                    return;
                case 2:
                    dy(intent.getStringExtra("google.message_id"));
                    return;
                case 3:
                    stringExtra = intent.getStringExtra("google.message_id");
                    if (stringExtra == null) {
                        stringExtra = intent.getStringExtra("message_id");
                    }
                    m4802O(stringExtra, intent.getStringExtra("error"));
                    return;
                default:
                    String str = "GcmListenerService";
                    String str2 = "Received message with unknown type: ";
                    stringExtra = String.valueOf(stringExtra);
                    Log.w(str, stringExtra.length() != 0 ? str2.concat(stringExtra) : new String(str2));
                    return;
            }
        }
        str = "GcmListenerService";
        str2 = "Unknown intent action: ";
        stringExtra = String.valueOf(intent.getAction());
        Log.w(str, stringExtra.length() != 0 ? str2.concat(stringExtra) : new String(str2));
    }
}
