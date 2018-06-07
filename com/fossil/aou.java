package com.fossil;

import android.telephony.TelephonyManager;

public class aou {
    private static final String aWB = aou.class.getSimpleName();
    private static aou ban;

    private aou() {
    }

    public static synchronized aou IE() {
        aou com_fossil_aou;
        synchronized (aou.class) {
            if (ban == null) {
                ban = new aou();
            }
            com_fossil_aou = ban;
        }
        return com_fossil_aou;
    }

    public static String HI() {
        TelephonyManager telephonyManager = (TelephonyManager) apc.IO().baD.getSystemService("phone");
        if (telephonyManager == null) {
            return null;
        }
        return telephonyManager.getNetworkOperatorName();
    }

    public static String Ih() {
        TelephonyManager telephonyManager = (TelephonyManager) apc.IO().baD.getSystemService("phone");
        if (telephonyManager == null) {
            return null;
        }
        return telephonyManager.getNetworkOperator();
    }
}
