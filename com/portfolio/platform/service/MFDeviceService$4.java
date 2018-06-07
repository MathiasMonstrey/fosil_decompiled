package com.portfolio.platform.service;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.fossil.clx.p;
import com.fossil.cnk;
import com.misfit.frameworks.common.constants.Constants;
import com.misfit.frameworks.common.log.MFLogger;
import com.portfolio.platform.PortfolioApp;

class MFDeviceService$4 extends BroadcastReceiver {
    final /* synthetic */ MFDeviceService cDk;

    MFDeviceService$4(MFDeviceService mFDeviceService) {
        this.cDk = mFDeviceService;
    }

    public void onReceive(Context context, Intent intent) {
        MFLogger.d(MFDeviceService.access$500(), "Micro app event receive");
        if (intent != null) {
            cnk.abV();
            PortfolioApp.cL(new p(intent.getStringExtra(Constants.SERIAL_NUMBER), intent.getIntExtra(Constants.MICRO_APP_ID, -1), intent.getIntExtra(Constants.VARIANT_ID, -1), intent.getIntExtra("gesture", -1)));
        }
    }
}
