package com.portfolio.platform.service;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.misfit.frameworks.buttonservice.IButtonConnectivity$Stub;
import com.portfolio.platform.PortfolioApp;

class MFDeviceService$1 implements ServiceConnection {
    final /* synthetic */ MFDeviceService cDk;

    MFDeviceService$1(MFDeviceService mFDeviceService) {
        this.cDk = mFDeviceService;
    }

    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        MFDeviceService.a(this.cDk, true);
        PortfolioApp.a(IButtonConnectivity$Stub.asInterface(iBinder));
        MFDeviceService.b(this.cDk);
    }

    public void onServiceDisconnected(ComponentName componentName) {
        MFDeviceService.a(this.cDk, false);
    }
}
