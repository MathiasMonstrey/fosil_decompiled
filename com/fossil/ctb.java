package com.fossil;

import com.fossil.ckb.C2131a;
import com.fossil.ckb.C2132b;
import com.fossil.ckb.C2133c;
import com.misfit.frameworks.common.log.MFLogger;
import com.portfolio.platform.data.model.microapp.MicroAppVariant;
import com.portfolio.platform.data.source.MicroAppSettingDataSource.GetVariantListCallback;
import com.portfolio.platform.data.source.MicroAppSettingRepository;
import com.portfolio.platform.data.source.UAppSystemVersionRepository;
import com.portfolio.platform.model.UAppSystemVersionModel;
import java.util.List;

public class ctb extends ckb<C2286a, C2287b, C2131a> {
    private static final String TAG = ctb.class.getSimpleName();
    private MicroAppSettingRepository mMicroAppSettingRepository;
    private UAppSystemVersionRepository mUAppSystemVersionRepository;

    public static final class C2286a implements C2132b {
        private final String mDeviceId;

        public C2286a(String str) {
            this.mDeviceId = (String) cco.m5996s(str, "deviceId cannot be null!");
        }

        public String getDeviceId() {
            return this.mDeviceId;
        }
    }

    public static final class C2287b implements C2131a, C2133c {
        private boolean cnT = false;

        public C2287b(boolean z) {
            this.cnT = z;
        }
    }

    protected /* synthetic */ void mo2022b(C2132b c2132b) {
        m7495a((C2286a) c2132b);
    }

    ctb(MicroAppSettingRepository microAppSettingRepository, UAppSystemVersionRepository uAppSystemVersionRepository) {
        this.mMicroAppSettingRepository = (MicroAppSettingRepository) cco.m5996s(microAppSettingRepository, "microAppSettingRepository cannot be null!");
        this.mUAppSystemVersionRepository = (UAppSystemVersionRepository) cco.m5996s(uAppSystemVersionRepository, "uAppSystemVersionRepository cannot be null!");
    }

    protected void m7495a(final C2286a c2286a) {
        UAppSystemVersionModel uAppSystemVersionModel = this.mUAppSystemVersionRepository.getUAppSystemVersionModel(c2286a.getDeviceId());
        if (uAppSystemVersionModel != null && uAppSystemVersionModel.getPinType() != 0) {
            MFLogger.m12670d(TAG, "executeUseCase serial=" + c2286a.getDeviceId() + " uAppSystemVersionModel=" + uAppSystemVersionModel.toString());
            this.mMicroAppSettingRepository.fetchAllMicroAppVariants(c2286a.getDeviceId(), uAppSystemVersionModel.getMajorVersion(), uAppSystemVersionModel.getMinorVersion(), new GetVariantListCallback(this) {
                final /* synthetic */ ctb cEl;

                public void onSuccess(List<MicroAppVariant> list) {
                    MFLogger.m12670d(ctb.TAG, "executeUseCase onSuccess serial=" + c2286a.getDeviceId());
                    this.cEl.abr().onSuccess(new C2287b(true));
                }

                public void onFail(int i) {
                    MFLogger.m12670d(ctb.TAG, "executeUseCase onFail serial=" + c2286a.getDeviceId());
                    this.cEl.abr().onError(new C2287b(false));
                }
            });
        } else if (uAppSystemVersionModel == null) {
            MFLogger.m12670d(TAG, "executeUseCase serial=" + c2286a.getDeviceId() + " uAppSystemVersionModel is null. Do not download variants.");
            abr().onError(new C2287b(false));
        } else {
            MFLogger.m12670d(TAG, "executeUseCase serial=" + c2286a.getDeviceId() + " uAppSystemVersionModel=" + uAppSystemVersionModel.toString());
            abr().onSuccess(new C2287b(true));
        }
    }
}
