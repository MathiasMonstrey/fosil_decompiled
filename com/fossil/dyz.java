package com.fossil;

import android.util.Log;
import com.fossil.dyy.C3310a;

class dyz implements Runnable {
    final /* synthetic */ C3310a dBs;

    dyz(C3310a c3310a) {
        this.dBs = c3310a;
    }

    public void run() {
        if (dyy.dBl != null && this.dBs.dBp) {
            Log.v("MicroMsg.SDK.WXApiImplV10.ActivityLifecycleCb", "WXStat trigger onBackground");
            dzf.m10350a(this.dBs.context, "onBackground_WX", null);
            this.dBs.dBp = false;
        }
    }
}
