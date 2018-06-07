package com.fossil;

import com.fossil.ckb.C2131a;
import com.fossil.ckb.C2132b;
import com.fossil.ckb.C2133c;
import com.misfit.frameworks.common.log.MFLogger;
import com.portfolio.platform.data.model.microapp.ActivePreset;
import com.portfolio.platform.data.model.microapp.SavedPreset;
import com.portfolio.platform.data.source.PresetDataSource.AddOrUpdateSavedPresetCallback;
import com.portfolio.platform.data.source.PresetRepository;

public class dke extends ckb<C2875a, C2876b, C2131a> {
    private static final String TAG = dke.class.getSimpleName();
    private PresetRepository cXe;

    class C28741 implements AddOrUpdateSavedPresetCallback {
        final /* synthetic */ dke cXZ;

        C28741(dke com_fossil_dke) {
            this.cXZ = com_fossil_dke;
        }

        public void onSuccess(SavedPreset savedPreset) {
            MFLogger.m12670d(dke.TAG, "executeUseCase onSuccess");
            this.cXZ.abr().onSuccess(new C2876b(savedPreset));
        }

        public void onFail() {
            MFLogger.m12670d(dke.TAG, "executeUseCase onFail");
            this.cXZ.abr().onError(null);
        }
    }

    public static final class C2875a implements C2132b {
        private final ActivePreset cEs;
        private final String cTU;

        public C2875a(ActivePreset activePreset, String str) {
            this.cEs = (ActivePreset) cco.m5996s(activePreset, "activePreset cannot be null!");
            this.cTU = (String) cco.m5996s(str, "mPresetName cannot be null!");
        }
    }

    public static final class C2876b implements C2133c {
        private final SavedPreset cYa;

        public C2876b(SavedPreset savedPreset) {
            this.cYa = savedPreset;
        }
    }

    protected /* synthetic */ void mo2022b(C2132b c2132b) {
        m8882a((C2875a) c2132b);
    }

    dke(PresetRepository presetRepository) {
        this.cXe = (PresetRepository) cco.m5996s(presetRepository, "mappingSetRepository cannot be null!");
    }

    protected void m8882a(C2875a c2875a) {
        MFLogger.m12670d(TAG, "executeUseCase presetName=" + c2875a.cTU);
        SavedPreset savedPreset = new SavedPreset();
        savedPreset.setButtons(c2875a.cEs.getButtons());
        savedPreset.setCreateAt(System.currentTimeMillis());
        savedPreset.setUpdateAt(System.currentTimeMillis());
        savedPreset.setName(c2875a.cTU);
        this.cXe.setCacheIsDirty(true);
        this.cXe.addOrUpdateSavedPreset(savedPreset, new C28741(this));
    }
}
