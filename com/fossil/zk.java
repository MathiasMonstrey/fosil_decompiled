package com.fossil;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.fossil.zi.C4128a;

class zk implements zi {
    private final C4128a aFA;
    private boolean aFB;
    private boolean aFC;
    private final BroadcastReceiver aFD = new C42401(this);
    private final Context context;

    class C42401 extends BroadcastReceiver {
        final /* synthetic */ zk aFE;

        C42401(zk zkVar) {
            this.aFE = zkVar;
        }

        public void onReceive(Context context, Intent intent) {
            boolean a = this.aFE.aFB;
            this.aFE.aFB = this.aFE.m14152H(context);
            if (a != this.aFE.aFB) {
                this.aFE.aFA.aB(this.aFE.aFB);
            }
        }
    }

    public zk(Context context, C4128a c4128a) {
        this.context = context.getApplicationContext();
        this.aFA = c4128a;
    }

    private void wi() {
        if (!this.aFC) {
            this.aFB = m14152H(this.context);
            this.context.registerReceiver(this.aFD, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
            this.aFC = true;
        }
    }

    private void unregister() {
        if (this.aFC) {
            this.context.unregisterReceiver(this.aFD);
            this.aFC = false;
        }
    }

    private boolean m14152H(Context context) {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }

    public void onStart() {
        wi();
    }

    public void onStop() {
        unregister();
    }

    public void onDestroy() {
    }
}
