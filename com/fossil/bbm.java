package com.fossil;

import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.gcm.Task;
import java.util.List;

public class bbm {
    private static bbm boV;
    private final PendingIntent bfJ = PendingIntent.getBroadcast(this.mContext, 0, new Intent().setPackage("com.google.example.invalidpackage"), 0);
    private Context mContext;

    private bbm(Context context) {
        this.mContext = context;
    }

    private final Intent Mr() {
        String aK = bcd.aK(this.mContext);
        int i = -1;
        if (aK != null) {
            i = bbp.aG(this.mContext);
        }
        if (aK == null || i < bbp.bpj) {
            Log.e("GcmNetworkManager", "Google Play Services is not available, dropping GcmNetworkManager request. code=" + i);
            return null;
        }
        Intent intent = new Intent("com.google.android.gms.gcm.ACTION_SCHEDULE");
        intent.setPackage(aK);
        intent.putExtra("app", this.bfJ);
        intent.putExtra("source", 4);
        intent.putExtra("source_version", 11020000);
        return intent;
    }

    public static bbm aF(Context context) {
        bbm com_fossil_bbm;
        synchronized (bbm.class) {
            if (boV == null) {
                boV = new bbm(context.getApplicationContext());
            }
            com_fossil_bbm = boV;
        }
        return com_fossil_bbm;
    }

    private final void dA(String str) {
        boolean z = true;
        awa.m4640p(str, "GcmTaskService must not be null.");
        Intent intent = new Intent("com.google.android.gms.gcm.ACTION_TASK_READY");
        intent.setPackage(this.mContext.getPackageName());
        List<ResolveInfo> queryIntentServices = this.mContext.getPackageManager().queryIntentServices(intent, 0);
        boolean z2 = (queryIntentServices == null || queryIntentServices.size() == 0) ? false : true;
        awa.m4637b(z2, "There is no GcmTaskService component registered within this package. Have you extended GcmTaskService correctly?");
        for (ResolveInfo resolveInfo : queryIntentServices) {
            if (resolveInfo.serviceInfo.name.equals(str)) {
                break;
            }
        }
        z = false;
        awa.m4637b(z, new StringBuilder(String.valueOf(str).length() + 119).append("The GcmTaskService class you provided ").append(str).append(" does not seem to support receiving com.google.android.gms.gcm.ACTION_TASK_READY.").toString());
    }

    public static void dz(String str) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("Must provide a valid tag.");
        } else if (100 < str.length()) {
            throw new IllegalArgumentException("Tag is larger than max permissible tag length (100)");
        }
    }

    public void m4804a(Task task) {
        dA(task.getServiceName());
        Intent Mr = Mr();
        if (Mr != null) {
            Bundle extras = Mr.getExtras();
            extras.putString("scheduler_action", "SCHEDULE_TASK");
            task.mo3497o(extras);
            Mr.putExtras(extras);
            this.mContext.sendBroadcast(Mr);
        }
    }

    public void m4805a(String str, Class<? extends bbo> cls) {
        Parcelable componentName = new ComponentName(this.mContext, cls);
        dz(str);
        dA(componentName.getClassName());
        Intent Mr = Mr();
        if (Mr != null) {
            Mr.putExtra("scheduler_action", "CANCEL_TASK");
            Mr.putExtra("tag", str);
            Mr.putExtra("component", componentName);
            this.mContext.sendBroadcast(Mr);
        }
    }
}
