package com.fossil;

import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.util.Log;
import com.google.firebase.iid.FirebaseInstanceIdInternalReceiver;
import com.misfit.frameworks.common.constants.MFNetworkReturnCode;
import com.misfit.frameworks.common.enums.Action.ActivityTracker;
import java.util.LinkedList;
import java.util.Queue;

public final class cew {
    private static cew bQo;
    private final jv<String, String> bQp = new jv();
    private Boolean bQq = null;
    public final Queue<Intent> bQr = new LinkedList();
    private Queue<Intent> bQs = new LinkedList();

    private cew() {
    }

    public static synchronized cew Wk() {
        cew com_fossil_cew;
        synchronized (cew.class) {
            if (bQo == null) {
                bQo = new cew();
            }
            com_fossil_cew = bQo;
        }
        return com_fossil_cew;
    }

    public static PendingIntent m6118a(Context context, int i, Intent intent, int i2) {
        return m6119a(context, 0, "com.google.firebase.INSTANCE_ID_EVENT", intent, 134217728);
    }

    private static PendingIntent m6119a(Context context, int i, String str, Intent intent, int i2) {
        Intent intent2 = new Intent(context, FirebaseInstanceIdInternalReceiver.class);
        intent2.setAction(str);
        intent2.putExtra("wrapped_intent", intent);
        return PendingIntent.getBroadcast(context, i, intent2, i2);
    }

    public static PendingIntent m6120b(Context context, int i, Intent intent, int i2) {
        return m6119a(context, i, "com.google.firebase.MESSAGING_EVENT", intent, 1073741824);
    }

    private final int m6121e(Context context, Intent intent) {
        String str;
        ComponentName a;
        synchronized (this.bQp) {
            str = (String) this.bQp.get(intent.getAction());
        }
        if (str == null) {
            ResolveInfo resolveService = context.getPackageManager().resolveService(intent, 0);
            if (resolveService == null || resolveService.serviceInfo == null) {
                Log.e("FirebaseInstanceId", "Failed to resolve target intent service, skipping classname enforcement");
                if (this.bQq == null) {
                    this.bQq = Boolean.valueOf(context.checkCallingOrSelfPermission("android.permission.WAKE_LOCK") == 0);
                }
                if (this.bQq.booleanValue()) {
                    a = ha.m4806a(context, intent);
                } else {
                    a = context.startService(intent);
                    Log.d("FirebaseInstanceId", "Missing wake lock permission, service start may be delayed");
                }
                if (a == null) {
                    return -1;
                }
                Log.e("FirebaseInstanceId", "Error while delivering the message: ServiceIntent not found.");
                return 404;
            }
            ServiceInfo serviceInfo = resolveService.serviceInfo;
            if (!context.getPackageName().equals(serviceInfo.packageName) || serviceInfo.name == null) {
                String valueOf = String.valueOf(serviceInfo.packageName);
                str = String.valueOf(serviceInfo.name);
                Log.e("FirebaseInstanceId", new StringBuilder((String.valueOf(valueOf).length() + 94) + String.valueOf(str).length()).append("Error resolving target intent service, skipping classname enforcement. Resolved service was: ").append(valueOf).append("/").append(str).toString());
                if (this.bQq == null) {
                    if (context.checkCallingOrSelfPermission("android.permission.WAKE_LOCK") == 0) {
                    }
                    this.bQq = Boolean.valueOf(context.checkCallingOrSelfPermission("android.permission.WAKE_LOCK") == 0);
                }
                if (this.bQq.booleanValue()) {
                    a = context.startService(intent);
                    Log.d("FirebaseInstanceId", "Missing wake lock permission, service start may be delayed");
                } else {
                    a = ha.m4806a(context, intent);
                }
                if (a == null) {
                    return -1;
                }
                Log.e("FirebaseInstanceId", "Error while delivering the message: ServiceIntent not found.");
                return 404;
            }
            str = serviceInfo.name;
            if (str.startsWith(".")) {
                String valueOf2 = String.valueOf(context.getPackageName());
                str = String.valueOf(str);
                str = str.length() != 0 ? valueOf2.concat(str) : new String(valueOf2);
            }
            synchronized (this.bQp) {
                this.bQp.put(intent.getAction(), str);
            }
        }
        if (Log.isLoggable("FirebaseInstanceId", 3)) {
            valueOf = "FirebaseInstanceId";
            String str2 = "Restricting intent to a specific service: ";
            valueOf2 = String.valueOf(str);
            Log.d(valueOf, valueOf2.length() != 0 ? str2.concat(valueOf2) : new String(str2));
        }
        intent.setClassName(context.getPackageName(), str);
        try {
            if (this.bQq == null) {
                if (context.checkCallingOrSelfPermission("android.permission.WAKE_LOCK") == 0) {
                }
                this.bQq = Boolean.valueOf(context.checkCallingOrSelfPermission("android.permission.WAKE_LOCK") == 0);
            }
            if (this.bQq.booleanValue()) {
                a = ha.m4806a(context, intent);
            } else {
                a = context.startService(intent);
                Log.d("FirebaseInstanceId", "Missing wake lock permission, service start may be delayed");
            }
            if (a == null) {
                return -1;
            }
            Log.e("FirebaseInstanceId", "Error while delivering the message: ServiceIntent not found.");
            return 404;
        } catch (Throwable e) {
            Log.e("FirebaseInstanceId", "Error while delivering the message to the serviceIntent", e);
            return 401;
        } catch (IllegalStateException e2) {
            str = String.valueOf(e2);
            Log.e("FirebaseInstanceId", new StringBuilder(String.valueOf(str).length() + 45).append("Failed to start service while in background: ").append(str).toString());
            return ActivityTracker.TAG_ACTIVITY;
        }
    }

    public final Intent Wl() {
        return (Intent) this.bQs.poll();
    }

    public final int m6122a(Context context, String str, Intent intent) {
        Object obj = -1;
        switch (str.hashCode()) {
            case -842411455:
                if (str.equals("com.google.firebase.INSTANCE_ID_EVENT")) {
                    obj = null;
                    break;
                }
                break;
            case 41532704:
                if (str.equals("com.google.firebase.MESSAGING_EVENT")) {
                    obj = 1;
                    break;
                }
                break;
        }
        switch (obj) {
            case null:
                this.bQr.offer(intent);
                break;
            case 1:
                this.bQs.offer(intent);
                break;
            default:
                String str2 = "FirebaseInstanceId";
                String str3 = "Unknown service action: ";
                String valueOf = String.valueOf(str);
                Log.w(str2, valueOf.length() != 0 ? str3.concat(valueOf) : new String(str3));
                return MFNetworkReturnCode.INTERNAL_SERVER_ERROR;
        }
        Intent intent2 = new Intent(str);
        intent2.setPackage(context.getPackageName());
        return m6121e(context, intent2);
    }

    public final void m6123d(Context context, Intent intent) {
        m6122a(context, "com.google.firebase.INSTANCE_ID_EVENT", intent);
    }
}
