package com.fossil;

import com.fossil.ckb.C2131a;
import com.fossil.ckb.C2132b;
import com.fossil.ckb.C2133c;
import com.misfit.frameworks.common.log.MFLogger;
import com.portfolio.platform.data.model.microapp.SavedPreset;
import com.portfolio.platform.data.source.PresetDataSource.GetSavedPresetListCallback;
import com.portfolio.platform.data.source.PresetRepository;
import java.util.List;

public class djy extends ckb<C2858a, C2859b, C2131a> {
    private static final String TAG = djy.class.getSimpleName();
    private PresetRepository czg;

    class C28571 implements GetSavedPresetListCallback {
        final /* synthetic */ djy cXM;

        C28571(djy com_fossil_djy) {
            this.cXM = com_fossil_djy;
        }

        public void onSuccess(List<SavedPreset> list) {
            this.cXM.abr().onSuccess(new C2859b(list));
        }

        public void onFail() {
            this.cXM.abr().onError(null);
        }
    }

    public static final class C2858a implements C2132b {
        private final String mDeviceId;

        public C2858a(String str) {
            this.mDeviceId = (String) cco.m5996s(str, "deviceId cannot be null!");
        }

        public String getDeviceId() {
            return this.mDeviceId;
        }
    }

    public static final class C2859b implements C2133c {
        private final List<SavedPreset> mSavedPresetList;

        public C2859b(List<SavedPreset> list) {
            this.mSavedPresetList = list;
        }

        public List<SavedPreset> aqD() {
            return this.mSavedPresetList;
        }
    }

    protected /* synthetic */ void mo2022b(C2132b c2132b) {
        m8856a((C2858a) c2132b);
    }

    djy(PresetRepository presetRepository) {
        this.czg = (PresetRepository) cco.m5996s(presetRepository, "mappingSetRepository cannot be null!");
    }

    protected void m8856a(C2858a c2858a) {
        MFLogger.m12670d(TAG, "executeUseCase serial=" + c2858a.getDeviceId());
        this.czg.getAllSavedPresets(new C28571(this));
    }
}
