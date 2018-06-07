package com.fossil;

import com.fossil.ckb.C2131a;
import com.fossil.ckb.C2132b;
import com.fossil.ckb.C2133c;
import com.misfit.frameworks.common.log.MFLogger;
import com.portfolio.platform.data.model.microapp.ActivePreset;
import com.portfolio.platform.data.model.microapp.RecommendedPreset;
import com.portfolio.platform.data.source.PresetDataSource.GetActivePresetCallback;
import com.portfolio.platform.data.source.PresetDataSource.GetRecommendedPresetCallback;
import com.portfolio.platform.data.source.PresetRepository;

public class djg extends ckb<C2827a, C2828b, C2131a> {
    private static final String TAG = djg.class.getSimpleName();
    private PresetRepository cXe;
    private ciw mAppExecutors;

    public static final class C2827a implements C2132b {
        private final String mDeviceId;

        public C2827a(String str) {
            this.mDeviceId = (String) cco.m5996s(str, "deviceId cannot be null!");
        }

        public String getDeviceId() {
            return this.mDeviceId;
        }
    }

    public static final class C2828b implements C2133c {
        private final ActivePreset cXk;

        public C2828b(ActivePreset activePreset) {
            this.cXk = activePreset;
        }

        public ActivePreset aqj() {
            return this.cXk;
        }
    }

    protected /* synthetic */ void mo2022b(C2132b c2132b) {
        m8821a((C2827a) c2132b);
    }

    djg(PresetRepository presetRepository, ciw com_fossil_ciw) {
        this.mAppExecutors = (ciw) cco.m5996s(com_fossil_ciw, "executor cannot be null!");
        this.cXe = (PresetRepository) cco.m5996s(presetRepository, "mappingSetRepository cannot be null!");
    }

    protected void m8821a(final C2827a c2827a) {
        MFLogger.m12670d(TAG, "executeUseCase deviceSerial=" + c2827a.getDeviceId());
        this.cXe.getActivePreset(c2827a.getDeviceId(), new GetActivePresetCallback(this) {
            final /* synthetic */ djg cXg;

            public void onSuccess(ActivePreset activePreset) {
                MFLogger.m12670d(djg.TAG, "executeUseCase deviceSerial=" + c2827a.getDeviceId() + " onSuccess");
                this.cXg.abr().onSuccess(new C2828b(activePreset));
            }

            public void onFail() {
                MFLogger.m12670d(djg.TAG, "executeUseCase deviceSerial=" + c2827a.getDeviceId() + " onFail");
                this.cXg.hD(c2827a.getDeviceId());
            }
        });
    }

    private void hD(final String str) {
        MFLogger.m12670d(TAG, "activateDefaultPreset deviceId=" + str);
        this.mAppExecutors.YQ().execute(new Runnable(this) {
            final /* synthetic */ djg cXg;

            class C28251 implements GetRecommendedPresetCallback {
                final /* synthetic */ C28262 cXi;

                class C28241 implements GetActivePresetCallback {
                    final /* synthetic */ C28251 cXj;

                    C28241(C28251 c28251) {
                        this.cXj = c28251;
                    }

                    public void onSuccess(ActivePreset activePreset) {
                        MFLogger.m12670d(djg.TAG, "activateDefaultPreset onSuccess activePreset=" + activePreset.getButtons());
                        this.cXj.cXi.cXg.abr().onSuccess(new C2828b(activePreset));
                    }

                    public void onFail() {
                        MFLogger.m12670d(djg.TAG, "activateDefaultPreset onFail");
                        this.cXj.cXi.cXg.abr().onError(null);
                    }
                }

                C28251(C28262 c28262) {
                    this.cXi = c28262;
                }

                public void onSuccess(RecommendedPreset recommendedPreset) {
                    MFLogger.m12670d(djg.TAG, "getActivePreset getDefaultPreset onSuccess");
                    this.cXi.cXg.cXe.activateDefaultPreset(recommendedPreset, new C28241(this));
                }

                public void onFail() {
                    MFLogger.m12670d(djg.TAG, "getActivePreset onFail");
                    this.cXi.cXg.abr().onError(null);
                }
            }

            public void run() {
                this.cXg.cXe.getDefaultPreset(str, new C28251(this), false);
            }
        });
    }
}
