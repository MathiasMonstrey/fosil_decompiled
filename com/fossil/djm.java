package com.fossil;

import com.fossil.ckb.C2131a;
import com.fossil.ckb.C2132b;
import com.fossil.ckb.C2133c;
import com.misfit.frameworks.common.log.MFLogger;
import com.portfolio.platform.data.model.microapp.MicroApp;
import com.portfolio.platform.data.source.MicroAppSettingDataSource.GetMicroAppGalleryCallback;
import com.portfolio.platform.data.source.MicroAppSettingRepository;
import java.util.List;

public class djm extends ckb<C2843a, C2844b, C2131a> {
    private static final String TAG = djm.class.getSimpleName();
    private MicroAppSettingRepository mMicroAppSettingRepository;

    class C28421 implements GetMicroAppGalleryCallback {
        final /* synthetic */ djm cXu;

        C28421(djm com_fossil_djm) {
            this.cXu = com_fossil_djm;
        }

        public void onSuccess(List<MicroApp> list) {
            MFLogger.m12670d(djm.TAG, "executeUseCase onSuccess");
            this.cXu.abr().onSuccess(new C2844b(list));
        }

        public void onFail() {
            MFLogger.m12670d(djm.TAG, "executeUseCase onFail");
            this.cXu.abr().onError(null);
        }
    }

    public static final class C2843a implements C2132b {
        private final String mDeviceId;

        public C2843a(String str) {
            this.mDeviceId = (String) cco.m5996s(str, "deviceId cannot be null!");
        }

        public String getDeviceId() {
            return this.mDeviceId;
        }
    }

    public static final class C2844b implements C2133c {
        private final List<MicroApp> cXv;

        public C2844b(List<MicroApp> list) {
            this.cXv = list;
        }

        public List<MicroApp> getMicroAppList() {
            return this.cXv;
        }
    }

    protected /* synthetic */ void mo2022b(C2132b c2132b) {
        m8839a((C2843a) c2132b);
    }

    djm(MicroAppSettingRepository microAppSettingRepository) {
        this.mMicroAppSettingRepository = (MicroAppSettingRepository) cco.m5996s(microAppSettingRepository, "microAppSettingRepository cannot be null!");
    }

    protected void m8839a(C2843a c2843a) {
        MFLogger.m12670d(TAG, "executeUseCase");
        this.mMicroAppSettingRepository.getMicroAppGallery(c2843a.getDeviceId(), new C28421(this));
    }
}
