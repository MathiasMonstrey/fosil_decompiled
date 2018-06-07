package com.fossil;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.ResolveInfo;
import android.os.Process;
import android.util.Log;
import java.util.HashMap;
import java.util.Map;

public final class bcd {
    private static String bpV = null;
    private static boolean bpW = false;
    private static int bpX = 0;
    private static int bpY = 0;
    private static int bpZ = 0;
    private static BroadcastReceiver bqa = null;
    private Context bqb;
    private Map<String, Object> bqc = new HashMap();

    public bcd(Context context) {
        this.bqb = context;
    }

    private static boolean m4830a(PackageManager packageManager) {
        for (ResolveInfo resolveInfo : packageManager.queryBroadcastReceivers(new Intent("com.google.iid.TOKEN_REQUEST"), 0)) {
            if (m4832a(packageManager, resolveInfo.activityInfo.packageName, "com.google.iid.TOKEN_REQUEST")) {
                bpW = true;
                return true;
            }
        }
        return false;
    }

    private static boolean m4831a(PackageManager packageManager, String str) {
        try {
            ApplicationInfo applicationInfo = packageManager.getApplicationInfo(str, 0);
            bpV = applicationInfo.packageName;
            bpY = applicationInfo.uid;
            return true;
        } catch (NameNotFoundException e) {
            return false;
        }
    }

    private static boolean m4832a(PackageManager packageManager, String str, String str2) {
        if (packageManager.checkPermission("com.google.android.c2dm.permission.SEND", str) == 0) {
            return m4831a(packageManager, str);
        }
        Log.w("InstanceID/Rpc", new StringBuilder((String.valueOf(str).length() + 56) + String.valueOf(str2).length()).append("Possible malicious package ").append(str).append(" declares ").append(str2).append(" without permission").toString());
        return false;
    }

    public static String aK(Context context) {
        if (bpV != null) {
            return bpV;
        }
        bpX = Process.myUid();
        PackageManager packageManager = context.getPackageManager();
        if (!axt.LK()) {
            boolean z;
            for (ResolveInfo resolveInfo : packageManager.queryIntentServices(new Intent("com.google.android.c2dm.intent.REGISTER"), 0)) {
                if (m4832a(packageManager, resolveInfo.serviceInfo.packageName, "com.google.android.c2dm.intent.REGISTER")) {
                    bpW = false;
                    z = true;
                    break;
                }
            }
            z = false;
            if (z) {
                return bpV;
            }
        }
        if (m4830a(packageManager)) {
            return bpV;
        }
        Log.w("InstanceID/Rpc", "Failed to resolve IID implementation package, falling back");
        if (m4831a(packageManager, "com.google.android.gms")) {
            bpW = axt.LK();
            return bpV;
        } else if (axt.LJ() || !m4831a(packageManager, "com.google.android.gsf")) {
            Log.w("InstanceID/Rpc", "Google Play services is missing, unable to get tokens");
            return null;
        } else {
            bpW = false;
            return bpV;
        }
    }
}
