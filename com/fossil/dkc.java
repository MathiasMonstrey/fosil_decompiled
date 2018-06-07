package com.fossil;

import com.fossil.ckb.C2131a;
import com.fossil.ckb.C2132b;
import com.fossil.ckb.C2133c;
import com.misfit.frameworks.common.log.MFLogger;
import com.portfolio.platform.data.model.microapp.MicroAppSetting;
import com.portfolio.platform.data.source.MicroAppSettingDataSource.MicroAppSettingCallback;
import com.portfolio.platform.data.source.MicroAppSettingRepository;

public class dkc extends ckb<C2872a, C2873b, C2131a> {
    private static final String TAG = dkc.class.getSimpleName();
    private MicroAppSettingRepository cXO;

    class C28711 implements MicroAppSettingCallback {
        final /* synthetic */ dkc cXX;

        C28711(dkc com_fossil_dkc) {
            this.cXX = com_fossil_dkc;
        }

        public void onSuccess(MicroAppSetting microAppSetting) {
            MFLogger.m12670d(dkc.TAG, "executeUseCase onSuccess");
            this.cXX.abr().onSuccess(new C2873b(microAppSetting));
        }

        public void onFail() {
            MFLogger.m12670d(dkc.TAG, "executeUseCase onFail");
            this.cXX.abr().onError(null);
        }
    }

    public static final class C2872a implements C2132b {
        private final MicroAppSetting cCl;

        public C2872a(MicroAppSetting microAppSetting) {
            this.cCl = (MicroAppSetting) cco.m5996s(microAppSetting, "microAppSetting cannot be null!");
        }
    }

    public static final class C2873b implements C2133c {
        private final MicroAppSetting cCl;

        public C2873b(MicroAppSetting microAppSetting) {
            this.cCl = microAppSetting;
        }

        public MicroAppSetting aqu() {
            return this.cCl;
        }
    }

    protected /* synthetic */ void mo2022b(C2132b c2132b) {
        m8877a((C2872a) c2132b);
    }

    dkc(MicroAppSettingRepository microAppSettingRepository) {
        this.cXO = (MicroAppSettingRepository) cco.m5996s(microAppSettingRepository, "microAppSettingRepository cannot be null!");
    }

    protected void m8877a(C2872a c2872a) {
        MFLogger.m12670d(TAG, "executeUseCase setting=" + c2872a.cCl.getSetting() + " appId=" + c2872a.cCl.getMicroAppId());
        this.cXO.addOrUpdateMicroAppSetting(c2872a.cCl, new C28711(this));
    }
}
