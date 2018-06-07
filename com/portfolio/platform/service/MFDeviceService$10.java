package com.portfolio.platform.service;

import com.portfolio.platform.PortfolioApp;
import com.portfolio.platform.enums.FossilBrand;

class MFDeviceService$10 implements Runnable {
    final /* synthetic */ MFDeviceService cDk;

    MFDeviceService$10(MFDeviceService mFDeviceService) {
        this.cDk = mFDeviceService;
    }

    public void run() {
        if ("release".equalsIgnoreCase("debug") && PortfolioApp.ZQ().aag() == FossilBrand.PORTFOLIO) {
            PortfolioApp.ZQ().aal();
            MFDeviceService.c(this.cDk);
        }
    }
}
