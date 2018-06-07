package com.portfolio.platform.service;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.fossil.clx.z;
import com.fossil.cnk;
import com.misfit.frameworks.common.constants.Constants;
import com.misfit.frameworks.common.log.MFLogger;
import com.portfolio.platform.PortfolioApp;

class MFDeviceService$3 extends BroadcastReceiver {
    final /* synthetic */ MFDeviceService cDk;

    MFDeviceService$3(MFDeviceService mFDeviceService) {
        this.cDk = mFDeviceService;
    }

    public void onReceive(Context context, Intent intent) {
        MFLogger.d(MFDeviceService.access$500(), "Streaming event receive");
        if (intent != null) {
            cnk.abV();
            PortfolioApp.cL(new z(intent.getStringExtra(Constants.SERIAL_NUMBER), intent.getIntExtra("gesture", -1)));
        }
    }
}
