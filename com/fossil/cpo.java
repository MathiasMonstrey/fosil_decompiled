package com.fossil;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.telephony.TelephonyManager;
import java.util.Date;

public abstract class cpo extends BroadcastReceiver {
    private static boolean cBA;
    private static String cBB;
    private static int cBy = 0;
    private static Date cBz;

    public abstract void m7441a(Context context, String str, Date date);

    public abstract void m7442a(Context context, String str, Date date, Date date2);

    public abstract void m7443b(Context context, String str, Date date);

    public abstract void m7444b(Context context, String str, Date date, Date date2);

    public abstract void m7446c(Context context, String str, Date date);

    public void onReceive(Context context, Intent intent) {
        int i = 0;
        if ("android.intent.action.NEW_OUTGOING_CALL".equalsIgnoreCase(intent.getAction())) {
            cBB = intent.getStringExtra("android.intent.extra.PHONE_NUMBER");
            return;
        }
        String stringExtra = intent.getStringExtra("state");
        String stringExtra2 = intent.getStringExtra("incoming_number");
        if (stringExtra != null) {
            if (!stringExtra.equals(TelephonyManager.EXTRA_STATE_IDLE)) {
                if (stringExtra.equals(TelephonyManager.EXTRA_STATE_OFFHOOK)) {
                    i = 2;
                } else if (stringExtra.equals(TelephonyManager.EXTRA_STATE_RINGING)) {
                    i = 1;
                }
            }
            m7445c(context, i, stringExtra2);
        }
    }

    public void m7445c(Context context, int i, String str) {
        if (cBy != i) {
            switch (i) {
                case 0:
                    if (cBy != 1) {
                        if (!cBA) {
                            m7444b(context, cBB, cBz, new Date());
                            break;
                        } else {
                            m7442a(context, cBB, cBz, new Date());
                            break;
                        }
                    }
                    m7446c(context, cBB, cBz);
                    break;
                case 1:
                    cBA = true;
                    cBz = new Date();
                    cBB = str;
                    m7441a(context, str, cBz);
                    break;
                case 2:
                    if (cBy != 1) {
                        cBA = false;
                        cBz = new Date();
                        m7443b(context, cBB, cBz);
                        break;
                    }
                    break;
            }
            cBy = i;
        }
    }
}
