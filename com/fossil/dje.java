package com.fossil;

import com.fossil.ckb.C2131a;
import com.fossil.ckb.C2132b;
import com.fossil.ckb.C2133c;
import com.misfit.frameworks.common.log.MFLogger;
import com.portfolio.platform.data.model.microapp.SavedPreset;
import com.portfolio.platform.data.source.PresetDataSource.DeleteMappingSetCallback;
import com.portfolio.platform.data.source.PresetDataSource.GetSavedPresetCallback;
import com.portfolio.platform.data.source.PresetRepository;

public class dje extends ckb<C2822a, C2133c, C2131a> {
    private static final String TAG = dje.class.getSimpleName();
    private PresetRepository czg;

    public static final class C2822a implements C2132b {
        private final String coS;

        public C2822a(String str) {
            this.coS = str;
        }
    }

    protected /* synthetic */ void mo2022b(C2132b c2132b) {
        m8816a((C2822a) c2132b);
    }

    dje(PresetRepository presetRepository) {
        this.czg = (PresetRepository) cco.m5996s(presetRepository, "mappingSetRepository cannot be null!");
    }

    protected void m8816a(final C2822a c2822a) {
        MFLogger.m12670d(TAG, "executeUseCase mappingSetId=" + c2822a.coS);
        this.czg.getSavedPreset(c2822a.coS, new GetSavedPresetCallback(this) {
            final /* synthetic */ dje cXc;

            public void onSuccess(SavedPreset savedPreset) {
                MFLogger.m12670d(dje.TAG, "executeUseCase getSavedPreset onSuccess mappingSetId=" + c2822a.coS);
                this.cXc.m8815c(savedPreset);
            }

            public void onFail() {
                MFLogger.m12670d(dje.TAG, "executeUseCase getSavedPreset onFail mappingSetId=" + c2822a.coS);
                this.cXc.abr().onError(null);
            }
        });
    }

    private void m8815c(final SavedPreset savedPreset) {
        this.czg.deleteSavedPreset(savedPreset, new DeleteMappingSetCallback(this) {
            final /* synthetic */ dje cXc;

            public void onSuccess() {
                MFLogger.m12670d(dje.TAG, "executeUseCase deleteSavedPreset onSuccess mappingSetId=" + savedPreset.getId());
                this.cXc.abr().onSuccess(null);
            }

            public void onFail() {
                MFLogger.m12670d(dje.TAG, "executeUseCase deleteSavedPreset onFail mappingSetId=" + savedPreset.getId());
                this.cXc.abr().onError(null);
            }
        });
    }
}
