package com.portfolio.platform.service;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.location.Location;
import android.text.TextUtils;
import com.fossil.civ;
import com.fossil.civ.a;
import com.fossil.clx.s;
import com.fossil.gy;
import com.misfit.frameworks.buttonservice.enums.ConnectionStateChange;
import com.misfit.frameworks.buttonservice.model.MisfitDeviceProfile;
import com.misfit.frameworks.common.constants.Constants;
import com.misfit.frameworks.common.log.MFLogger;
import com.portfolio.platform.PortfolioApp;
import com.portfolio.platform.helper.DeviceHelper;

class MFDeviceService$2 extends BroadcastReceiver {
    final /* synthetic */ MFDeviceService cDk;

    MFDeviceService$2(MFDeviceService mFDeviceService) {
        this.cDk = mFDeviceService;
    }

    public void onReceive(Context context, Intent intent) {
        final Object stringExtra = intent.getStringExtra(Constants.SERIAL_NUMBER);
        int intExtra = intent.getIntExtra(Constants.CONNECTION_STATE, -1);
        MFLogger.d(MFDeviceService.access$500(), "---Inside .connectionStateChangeReceiver " + stringExtra + " status " + intExtra);
        if (intExtra == ConnectionStateChange.GATT_ON.ordinal()) {
            MisfitDeviceProfile gb = DeviceHelper.abH().gb(stringExtra);
            MFLogger.d(MFDeviceService.access$500(), "---Inside .connectionStateChangeReceiver " + stringExtra + " deviceProfile=" + gb);
            MFDeviceService.a(this.cDk, gb, stringExtra);
            if (!TextUtils.isEmpty(stringExtra) && stringExtra.equals(PortfolioApp.ZQ().aaa())) {
                MFDeviceService.c(this.cDk);
            }
        } else if (intExtra == ConnectionStateChange.GATT_OFF.ordinal() && !TextUtils.isEmpty(stringExtra) && stringExtra.equals(PortfolioApp.ZQ().aaa())) {
            MFDeviceService.h(this.cDk);
        }
        PortfolioApp.cL(new s(stringExtra, intExtra));
        MFDeviceService.c(this.cDk, stringExtra);
        if (this.cDk.cmQ.ade()) {
            MFLogger.d(MFDeviceService.access$500(), "Collect location data only user enable locate feature");
            civ.bm(this.cDk).a(new a(this) {
                final /* synthetic */ MFDeviceService$2 cDl;

                public void m15671a(Location location, int i) {
                    this.cDl.cDk.a(stringExtra, location, i);
                    if (location != null) {
                        civ.bm(PortfolioApp.ZQ()).b(this);
                    }
                }
            });
        }
        gy.p(PortfolioApp.ZQ()).b(intent);
    }
}
