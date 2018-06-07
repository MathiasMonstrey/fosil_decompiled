package com.fossil;

import com.fossil.ckb.C2131a;
import com.fossil.ckb.C2132b;
import com.fossil.ckb.C2133c;
import com.misfit.frameworks.common.log.MFLogger;
import com.portfolio.platform.data.model.microapp.RecommendedPreset;
import com.portfolio.platform.data.source.PresetDataSource.GetRecommendedPresetListCallback;
import com.portfolio.platform.data.source.PresetRepository;
import java.util.List;

public class dju extends ckb<C2854a, C2855b, C2131a> {
    private static final String TAG = dju.class.getSimpleName();
    private PresetRepository czg;

    public static final class C2854a implements C2132b {
        private final String mDeviceId;

        public C2854a(String str) {
            this.mDeviceId = (String) cco.m5996s(str, "deviceId cannot be null!");
        }

        public String getDeviceId() {
            return this.mDeviceId;
        }
    }

    public static final class C2855b implements C2133c {
        private final List<RecommendedPreset> cXI;

        public C2855b(List<RecommendedPreset> list) {
            this.cXI = list;
        }

        public List<RecommendedPreset> aqz() {
            return this.cXI;
        }
    }

    protected /* synthetic */ void mo2022b(C2132b c2132b) {
        m8851a((C2854a) c2132b);
    }

    dju(PresetRepository presetRepository) {
        this.czg = (PresetRepository) cco.m5996s(presetRepository, "mappingSetRepository cannot be null!");
    }

    protected void m8851a(final C2854a c2854a) {
        MFLogger.m12670d(TAG, "executeUseCase serial=" + c2854a.getDeviceId());
        this.czg.getRecommendedPresets(c2854a.getDeviceId(), new GetRecommendedPresetListCallback(this) {
            final /* synthetic */ dju cXH;

            public void onSuccess(List<RecommendedPreset> list) {
                MFLogger.m12670d(dju.TAG, "getRecommendedPresetList onSuccess" + c2854a.getDeviceId());
                this.cXH.abr().onSuccess(new C2855b(list));
            }

            public void onFail() {
                MFLogger.m12670d(dju.TAG, "getRecommendedPresetList onFail" + c2854a.getDeviceId());
                this.cXH.abr().onError(null);
            }
        });
    }
}
