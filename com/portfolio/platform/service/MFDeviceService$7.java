package com.portfolio.platform.service;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.fossil.gy;

class MFDeviceService$7 extends BroadcastReceiver {
    final /* synthetic */ MFDeviceService cDk;

    MFDeviceService$7(MFDeviceService mFDeviceService) {
        this.cDk = mFDeviceService;
    }

    public void onReceive(Context context, Intent intent) {
        intent.setAction("SCAN_DEVICE_FOUND");
        gy.p(context).b(intent);
    }
}
