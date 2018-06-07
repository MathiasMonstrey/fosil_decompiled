package com.fossil;

import com.fossil.ckb.C2131a;
import com.fossil.ckb.C2132b;
import com.fossil.ckb.C2133c;
import com.misfit.frameworks.common.log.MFLogger;
import com.portfolio.platform.data.model.microapp.MicroAppSetting;
import com.portfolio.platform.data.source.MicroAppSettingDataSource.MicroAppSettingCallback;
import com.portfolio.platform.data.source.MicroAppSettingRepository;

public class djp extends ckb<C2849a, C2850b, C2131a> {
    private static final String TAG = djp.class.getSimpleName();
    private MicroAppSettingRepository mMicroAppSettingRepository;

    public static final class C2849a implements C2132b {
        private final String mMicroAppId;

        public C2849a(String str) {
            this.mMicroAppId = (String) cco.m5996s(str, "microAppId cannot be null!");
        }

        public String getMicroAppId() {
            return this.mMicroAppId;
        }
    }

    public static final class C2850b implements C2133c {
        private final MicroAppSetting cCl;

        public C2850b(MicroAppSetting microAppSetting) {
            this.cCl = microAppSetting;
        }

        public MicroAppSetting aqv() {
            return this.cCl;
        }
    }

    protected /* synthetic */ void mo2022b(C2132b c2132b) {
        m8844a((C2849a) c2132b);
    }

    djp(MicroAppSettingRepository microAppSettingRepository) {
        this.mMicroAppSettingRepository = (MicroAppSettingRepository) cco.m5996s(microAppSettingRepository, "microAppSettingRepository cannot be null!");
    }

    protected void m8844a(final C2849a c2849a) {
        MFLogger.m12670d(TAG, "executeUseCase microAppId=" + c2849a.getMicroAppId());
        this.mMicroAppSettingRepository.getMicroAppSettingInDB(c2849a.getMicroAppId(), new MicroAppSettingCallback(this) {
            final /* synthetic */ djp cXA;

            public void onSuccess(MicroAppSetting microAppSetting) {
                MFLogger.m12670d(djp.TAG, "executeUseCase onSuccess microAppId=" + c2849a.getMicroAppId());
                this.cXA.abr().onSuccess(new C2850b(microAppSetting));
            }

            public void onFail() {
                MFLogger.m12670d(djp.TAG, "executeUseCase onFail microAppId=" + c2849a.getMicroAppId());
                this.cXA.abr().onError(null);
            }
        });
    }
}
