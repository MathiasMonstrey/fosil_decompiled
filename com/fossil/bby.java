package com.fossil;

import android.content.Context;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Bundle;
import android.util.Log;
import java.security.KeyPair;
import java.util.HashMap;
import java.util.Map;

public class bby {
    private static Map<String, bby> bpM = new HashMap();
    private static bce bpN;
    private static bcd bpO;
    private static String bpS;
    private KeyPair bpP;
    private String bpQ = "";
    private long bpR;
    private Context mContext;

    private bby(Context context, String str, Bundle bundle) {
        this.mContext = context.getApplicationContext();
        this.bpQ = str;
    }

    public static bce MC() {
        return bpN;
    }

    public static synchronized bby m4823a(Context context, Bundle bundle) {
        bby com_fossil_bby;
        synchronized (bby.class) {
            String string = bundle == null ? "" : bundle.getString("subtype");
            String str = string == null ? "" : string;
            Context applicationContext = context.getApplicationContext();
            if (bpN == null) {
                bpN = new bce(applicationContext);
                bpO = new bcd(applicationContext);
            }
            bpS = Integer.toString(aJ(applicationContext));
            com_fossil_bby = (bby) bpM.get(str);
            if (com_fossil_bby == null) {
                com_fossil_bby = new bby(applicationContext, str, bundle);
                bpM.put(str, com_fossil_bby);
            }
        }
        return com_fossil_bby;
    }

    static int aJ(Context context) {
        int i = 0;
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode;
        } catch (NameNotFoundException e) {
            String valueOf = String.valueOf(e);
            Log.w("InstanceID", new StringBuilder(String.valueOf(valueOf).length() + 38).append("Never happens: can't find own package ").append(valueOf).toString());
            return i;
        }
    }

    public final void MB() {
        this.bpR = 0;
        bpN.dD(String.valueOf(this.bpQ).concat("|"));
        this.bpP = null;
    }
}
