package com.portfolio.platform.service;

import com.misfit.frameworks.buttonservice.communite.CommunicateMode;
import com.misfit.frameworks.buttonservice.db.DataFile;
import com.misfit.frameworks.buttonservice.db.DataFileProvider;
import com.misfit.frameworks.buttonservice.model.WrapperSyncResult;
import com.misfit.frameworks.common.log.MFLogger;
import com.portfolio.platform.PortfolioApp;

class MFDeviceService$15 implements Runnable {
    final /* synthetic */ MFDeviceService cDk;
    final /* synthetic */ String cDm;
    final /* synthetic */ PortfolioApp cDn;
    final /* synthetic */ String val$serial;

    MFDeviceService$15(MFDeviceService mFDeviceService, String str, String str2, PortfolioApp portfolioApp) {
        this.cDk = mFDeviceService;
        this.cDm = str;
        this.val$serial = str2;
        this.cDn = portfolioApp;
    }

    public void run() {
        DataFile dataFile = DataFileProvider.getInstance(this.cDk).getDataFile(this.cDm, this.val$serial);
        if (dataFile != null) {
            this.cDn.a(CommunicateMode.SYNC, this.val$serial, "Save sync result to DB");
            WrapperSyncResult fromJson = WrapperSyncResult.fromJson(dataFile.getDataFile());
            MFDeviceService.a(this.cDk, fromJson, this.val$serial);
            this.cDn.bM(false);
            try {
                this.cDk.cmQ.A(this.val$serial, fromJson.getVibeStrengthLevel());
                return;
            } catch (Exception e) {
                MFLogger.e(MFDeviceService.access$500(), "Error Inside " + MFDeviceService.access$500() + ".processBleResult - ex=" + e.toString());
                return;
            }
        }
        MFLogger.e(MFDeviceService.access$500(), "Inside " + MFDeviceService.access$500() + ".processBleResult - dataFile is NULL");
        this.cDn.a(CommunicateMode.SYNC, this.val$serial, "Save sync result to failed. dataFile is NULL");
        this.cDn.bM(true);
    }
}
