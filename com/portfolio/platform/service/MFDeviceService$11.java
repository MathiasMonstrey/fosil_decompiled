package com.portfolio.platform.service;

import java.util.Calendar;

class MFDeviceService$11 implements Runnable {
    final /* synthetic */ MFDeviceService cDk;

    MFDeviceService$11(MFDeviceService mFDeviceService) {
        this.cDk = mFDeviceService;
    }

    public void run() {
        int i = Calendar.getInstance().get(11);
        if (i < 8 || i <= 20) {
            MFDeviceService.e(this.cDk).postDelayed(MFDeviceService.d(this.cDk), 1800000);
        } else {
            MFDeviceService.e(this.cDk).postDelayed(MFDeviceService.d(this.cDk), 1800000);
        }
    }
}
