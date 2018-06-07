package com.fossil;

import com.fossil.ckb.C2131a;
import com.fossil.ckb.C2132b;
import com.fossil.ckb.C2133c;
import com.misfit.frameworks.common.log.MFLogger;
import com.portfolio.platform.data.model.microapp.MicroApp;
import com.portfolio.platform.data.source.MicroAppSettingDataSource.GetMicroAppCallback;
import com.portfolio.platform.data.source.MicroAppSettingRepository;

public class dko extends ckb<C2905a, C2906b, C2131a> {
    private static final String TAG = dko.class.getSimpleName();
    private MicroAppSettingRepository mMicroAppSettingRepository;

    public static final class C2905a implements C2132b {
        private final MicroApp coG;

        public C2905a(MicroApp microApp) {
            this.coG = (MicroApp) cco.m5996s(microApp, "microApp cannot be null!");
        }
    }

    public static final class C2906b implements C2133c {
        private final MicroApp coG;

        public C2906b(MicroApp microApp) {
            this.coG = microApp;
        }

        public MicroApp aqS() {
            return this.coG;
        }
    }

    protected /* synthetic */ void mo2022b(C2132b c2132b) {
        m8937a((C2905a) c2132b);
    }

    dko(MicroAppSettingRepository microAppSettingRepository) {
        this.mMicroAppSettingRepository = (MicroAppSettingRepository) cco.m5996s(microAppSettingRepository, "microAppSettingRepository cannot be null!");
    }

    protected void m8937a(final C2905a c2905a) {
        MFLogger.m12670d(TAG, "executeUseCase microApp=" + c2905a.coG.getAppId());
        this.mMicroAppSettingRepository.updateMicroApp(c2905a.coG, new GetMicroAppCallback(this) {
            final /* synthetic */ dko cYs;

            public void onSuccess(MicroApp microApp) {
                MFLogger.m12670d(dko.TAG, "executeUseCase onSuccess microApp=" + c2905a.coG.getAppId());
                this.cYs.abr().onSuccess(new C2906b(microApp));
            }

            public void onFail() {
                MFLogger.m12670d(dko.TAG, "executeUseCase onFail microApp=" + c2905a.coG.getAppId());
                this.cYs.abr().onError(null);
            }
        });
    }
}
