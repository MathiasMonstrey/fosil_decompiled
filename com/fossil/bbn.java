package com.fossil;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.os.Build.VERSION;
import android.util.Base64;
import android.util.Log;
import com.misfit.frameworks.common.constants.MFNetworkReturnCode;

public class bbn extends ha {
    private static String boW = "gcm.googleapis.com/refresh";
    private static boolean boX = false;
    private ceo boY;
    private ceo boZ;

    private final void m4808b(Context context, Intent intent) {
        if (isOrderedBroadcast()) {
            setResultCode(MFNetworkReturnCode.INTERNAL_SERVER_ERROR);
        }
        ResolveInfo resolveService = context.getPackageManager().resolveService(intent, 0);
        if (resolveService == null || resolveService.serviceInfo == null) {
            Log.e("GcmReceiver", "Failed to resolve target intent service, skipping classname enforcement");
        } else {
            ServiceInfo serviceInfo = resolveService.serviceInfo;
            String valueOf;
            String valueOf2;
            if (!context.getPackageName().equals(serviceInfo.packageName) || serviceInfo.name == null) {
                valueOf = String.valueOf(serviceInfo.packageName);
                valueOf2 = String.valueOf(serviceInfo.name);
                Log.e("GcmReceiver", new StringBuilder((String.valueOf(valueOf).length() + 94) + String.valueOf(valueOf2).length()).append("Error resolving target intent service, skipping classname enforcement. Resolved service was: ").append(valueOf).append("/").append(valueOf2).toString());
            } else {
                String valueOf3;
                valueOf2 = serviceInfo.name;
                if (valueOf2.startsWith(".")) {
                    valueOf3 = String.valueOf(context.getPackageName());
                    valueOf2 = String.valueOf(valueOf2);
                    valueOf2 = valueOf2.length() != 0 ? valueOf3.concat(valueOf2) : new String(valueOf3);
                }
                if (Log.isLoggable("GcmReceiver", 3)) {
                    valueOf = "GcmReceiver";
                    String str = "Restricting intent to a specific service: ";
                    valueOf3 = String.valueOf(valueOf2);
                    Log.d(valueOf, valueOf3.length() != 0 ? str.concat(valueOf3) : new String(str));
                }
                intent.setClassName(context.getPackageName(), valueOf2);
            }
        }
        try {
            ComponentName a;
            if (context.checkCallingOrSelfPermission("android.permission.WAKE_LOCK") == 0) {
                a = ha.m4806a(context, intent);
            } else {
                a = context.startService(intent);
                Log.d("GcmReceiver", "Missing wake lock permission, service start may be delayed");
            }
            if (a == null) {
                Log.e("GcmReceiver", "Error while delivering the message: ServiceIntent not found.");
                if (isOrderedBroadcast()) {
                    setResultCode(404);
                }
            } else if (isOrderedBroadcast()) {
                setResultCode(-1);
            }
        } catch (Throwable e) {
            Log.e("GcmReceiver", "Error while delivering the message to the serviceIntent", e);
            if (isOrderedBroadcast()) {
                setResultCode(401);
            }
        }
    }

    private final synchronized ceo m4809s(Context context, String str) {
        ceo com_fossil_ceo;
        if ("com.google.android.c2dm.intent.RECEIVE".equals(str)) {
            if (this.boZ == null) {
                this.boZ = new ceo(context, str);
            }
            com_fossil_ceo = this.boZ;
        } else {
            if (this.boY == null) {
                this.boY = new ceo(context, str);
            }
            com_fossil_ceo = this.boY;
        }
        return com_fossil_ceo;
    }

    public void onReceive(Context context, Intent intent) {
        if (Log.isLoggable("GcmReceiver", 3)) {
            Log.d("GcmReceiver", "received new intent");
        }
        intent.setComponent(null);
        intent.setPackage(context.getPackageName());
        if (VERSION.SDK_INT <= 18) {
            intent.removeCategory(context.getPackageName());
        }
        String stringExtra = intent.getStringExtra("from");
        if ("google.com/iid".equals(stringExtra) || boW.equals(stringExtra)) {
            intent.setAction("com.google.android.gms.iid.InstanceID");
        }
        stringExtra = intent.getStringExtra("gcm.rawData64");
        if (stringExtra != null) {
            intent.putExtra("rawData", Base64.decode(stringExtra, 0));
            intent.removeExtra("gcm.rawData64");
        }
        if (axt.LK()) {
            if (isOrderedBroadcast()) {
                setResultCode(-1);
            }
            m4809s(context, intent.getAction()).m6101a(intent, goAsync());
            return;
        }
        if ("com.google.android.c2dm.intent.RECEIVE".equals(intent.getAction())) {
            m4808b(context, intent);
        } else {
            m4808b(context, intent);
        }
        if (isOrderedBroadcast() && getResultCode() == 0) {
            setResultCode(-1);
        }
    }
}
