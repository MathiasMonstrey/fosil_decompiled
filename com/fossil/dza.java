package com.fossil;

import android.util.Log;
import com.fossil.dyy.C3310a;

class dza implements Runnable {
    final /* synthetic */ C3310a dBs;

    dza(C3310a c3310a) {
        this.dBs = c3310a;
    }

    public void run() {
        if (dyy.dBl != null && !this.dBs.dBp) {
            Log.v("MicroMsg.SDK.WXApiImplV10.ActivityLifecycleCb", "WXStat trigger onForeground");
            dzf.m10350a(this.dBs.context, "onForeground_WX", null);
            this.dBs.dBp = true;
        }
    }
}
