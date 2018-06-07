package com.portfolio.platform.service;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

class MFDeviceService$8 extends BroadcastReceiver {
    final /* synthetic */ MFDeviceService cDk;

    MFDeviceService$8(MFDeviceService mFDeviceService) {
        this.cDk = mFDeviceService;
    }

    public void onReceive(Context context, Intent intent) {
        if (intent != null) {
            this.cDk.hB(intent.getStringExtra("message"));
        }
    }
}
