package com.fossil;

import com.fossil.ckb.C2131a;
import com.fossil.ckb.C2132b;
import com.fossil.ckb.C2133c;
import com.misfit.frameworks.common.log.MFLogger;
import com.portfolio.platform.data.source.NotificationsRepository;

public class ddb extends ckb<C2132b, C2133c, C2131a> {
    public static final String TAG = ddb.class.getSimpleName();
    private NotificationsRepository mRepository;

    public ddb(NotificationsRepository notificationsRepository) {
        this.mRepository = (NotificationsRepository) cco.ce(notificationsRepository);
    }

    protected void mo2022b(C2132b c2132b) {
        MFLogger.m12670d(TAG, "executeUseCase");
        this.mRepository.removeRedundantContact();
        abr().onSuccess(null);
    }
}
