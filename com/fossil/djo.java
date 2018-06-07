package com.fossil;

import com.fossil.ckb.C2131a;
import com.fossil.ckb.C2132b;
import com.fossil.ckb.C2133c;
import com.misfit.frameworks.common.log.MFLogger;
import com.portfolio.platform.data.model.microapp.MicroAppSetting;
import com.portfolio.platform.data.source.MicroAppSettingDataSource.MicroAppSettingCallback;
import com.portfolio.platform.data.source.MicroAppSettingRepository;

public class djo extends ckb<C2846a, C2847b, C2131a> {
    private static final String TAG = djo.class.getSimpleName();
    private MicroAppSettingRepository mMicroAppSettingRepository;

    public static final class C2846a implements C2132b {
        private final String mMicroAppId;

        public C2846a(String str) {
            this.mMicroAppId = (String) cco.m5996s(str, "microAppId cannot be null!");
        }

        public String getMicroAppId() {
            return this.mMicroAppId;
        }
    }

    public static final class C2847b implements C2133c {
        private final MicroAppSetting cCl;

        public C2847b(MicroAppSetting microAppSetting) {
            this.cCl = microAppSetting;
        }

        public MicroAppSetting aqu() {
            return this.cCl;
        }
    }

    protected /* synthetic */ void mo2022b(C2132b c2132b) {
        m8842a((C2846a) c2132b);
    }

    djo(MicroAppSettingRepository microAppSettingRepository) {
        this.mMicroAppSettingRepository = (MicroAppSettingRepository) cco.m5996s(microAppSettingRepository, "microAppSettingRepository cannot be null!");
    }

    protected void m8842a(final C2846a c2846a) {
        MFLogger.m12670d(TAG, "executeUseCase microAppId=" + c2846a.getMicroAppId());
        this.mMicroAppSettingRepository.getMicroAppSetting(c2846a.getMicroAppId(), new MicroAppSettingCallback(this) {
            final /* synthetic */ djo cXy;

            public void onSuccess(MicroAppSetting microAppSetting) {
                MFLogger.m12670d(djo.TAG, "executeUseCase onSuccess microAppId=" + c2846a.getMicroAppId());
                this.cXy.abr().onSuccess(new C2847b(microAppSetting));
            }

            public void onFail() {
                MFLogger.m12670d(djo.TAG, "executeUseCase onFail microAppId=" + c2846a.getMicroAppId());
                this.cXy.abr().onError(null);
            }
        });
    }
}
