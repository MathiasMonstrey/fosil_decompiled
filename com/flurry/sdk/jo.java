package com.flurry.sdk;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.fossil.aot;
import com.fossil.apc;
import com.fossil.apj;
import com.fossil.apl;

public final class jo extends BroadcastReceiver {
    private static jo bal;
    private boolean aWE = false;
    public boolean aXI;
    boolean aXk;

    public enum C1535a {
        ;

        static {
            f1314a = 1;
            f1315b = 2;
            f1316c = 3;
            f1317d = 4;
            bam = new int[]{f1314a, f1315b, f1316c, f1317d};
        }
    }

    private jo() {
        boolean z = false;
        Context context = apc.IO().baD;
        if (context.checkCallingOrSelfPermission("android.permission.ACCESS_NETWORK_STATE") == 0) {
            z = true;
        }
        this.aWE = z;
        this.aXI = m2777V(context);
        if (this.aWE) {
            HH();
        }
    }

    private boolean m2777V(Context context) {
        if (!this.aWE || context == null) {
            return true;
        }
        NetworkInfo activeNetworkInfo = IC().getActiveNetworkInfo();
        if (activeNetworkInfo == null || !activeNetworkInfo.isConnected()) {
            return false;
        }
        return true;
    }

    private synchronized void HH() {
        if (!this.aXk) {
            Context context = apc.IO().baD;
            this.aXI = m2777V(context);
            context.registerReceiver(this, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
            this.aXk = true;
        }
    }

    private static ConnectivityManager IC() {
        return (ConnectivityManager) apc.IO().baD.getSystemService("connectivity");
    }

    public static synchronized jo ID() {
        jo joVar;
        synchronized (jo.class) {
            if (bal == null) {
                bal = new jo();
            }
            joVar = bal;
        }
        return joVar;
    }

    public final void onReceive(Context context, Intent intent) {
        boolean V = m2777V(context);
        if (this.aXI != V) {
            this.aXI = V;
            apj com_fossil_aot = new aot();
            com_fossil_aot.aXk = V;
            com_fossil_aot.f1433b = Iz();
            apl.IW().m4167a(com_fossil_aot);
        }
    }

    public final int Iz() {
        if (!this.aWE) {
            return C1535a.f1314a;
        }
        NetworkInfo activeNetworkInfo = IC().getActiveNetworkInfo();
        if (activeNetworkInfo == null || !activeNetworkInfo.isConnected()) {
            return C1535a.f1314a;
        }
        switch (activeNetworkInfo.getType()) {
            case 0:
            case 2:
            case 3:
            case 4:
            case 5:
                return C1535a.f1317d;
            case 1:
                return C1535a.f1316c;
            case 8:
                return C1535a.f1314a;
            default:
                if (activeNetworkInfo.isConnected()) {
                    return C1535a.f1315b;
                }
                return C1535a.f1314a;
        }
    }
}
