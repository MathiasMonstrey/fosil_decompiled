package com.portfolio.platform.service;

import com.misfit.frameworks.common.log.MFLogger;
import com.portfolio.platform.data.source.UAppSystemVersionRepository.UAppSystemVersionRepositoryObserver;
import com.portfolio.platform.model.UAppSystemVersionModel;

class MFDeviceService$12 implements UAppSystemVersionRepositoryObserver {
    final /* synthetic */ MFDeviceService cDk;

    MFDeviceService$12(MFDeviceService mFDeviceService) {
        this.cDk = mFDeviceService;
    }

    public void onUAppSystemVersionChanged(UAppSystemVersionModel uAppSystemVersionModel) {
        MFLogger.d(MFDeviceService.access$500(), "Inside .onUAppSystemVersionChanged, new UAppSystemVersionModel=" + uAppSystemVersionModel.toString());
        if (uAppSystemVersionModel.getPinType() != 0) {
            MFDeviceService.a(this.cDk, uAppSystemVersionModel.getDeviceId());
        }
    }
}
