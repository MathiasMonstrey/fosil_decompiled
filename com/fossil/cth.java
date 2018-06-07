package com.fossil;

import android.text.TextUtils;
import com.fossil.ckb.C2132b;
import com.fossil.drf.C2299b;
import com.misfit.frameworks.buttonservice.model.microapp.mapping.BLEMapping;
import com.misfit.frameworks.buttonservice.model.microapp.mapping.MicroAppMapping;
import com.misfit.frameworks.common.constants.MFNetworkReturnCode;
import com.misfit.frameworks.common.log.MFLogger;
import com.portfolio.platform.PortfolioApp;
import com.portfolio.platform.data.model.microapp.ActivePreset;
import com.portfolio.platform.data.model.microapp.RecommendedPreset;
import com.portfolio.platform.data.source.MicroAppSettingRepository;
import com.portfolio.platform.data.source.PresetDataSource.GetActivePresetCallback;
import com.portfolio.platform.data.source.PresetDataSource.GetRecommendedPresetCallback;
import com.portfolio.platform.data.source.PresetRepository;
import com.portfolio.platform.data.source.UAppSystemVersionRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;

public class cth extends ckb<C2301a, Object, Object> {
    private static final String TAG = cth.class.getSimpleName();
    private ActivePreset cEs;
    private MicroAppSettingRepository mMicroAppSettingRepository;
    private PresetRepository mPresetRepository;
    private UAppSystemVersionRepository mUAppSystemVersionRepository;

    public static final class C2301a implements C2132b {
        private final String mSerial;

        public C2301a(String str) {
            this.mSerial = str;
        }

        public String getSerial() {
            return this.mSerial;
        }
    }

    protected /* synthetic */ void mo2022b(C2132b c2132b) {
        m7507a((C2301a) c2132b);
    }

    public cth(MicroAppSettingRepository microAppSettingRepository, UAppSystemVersionRepository uAppSystemVersionRepository, PresetRepository presetRepository) {
        this.mPresetRepository = presetRepository;
        this.mMicroAppSettingRepository = (MicroAppSettingRepository) cco.m5996s(microAppSettingRepository, "microAppSettingRepository cannot be null!");
        this.mUAppSystemVersionRepository = (UAppSystemVersionRepository) cco.m5996s(uAppSystemVersionRepository, "uAppSystemVersionRepository cannot be null!");
    }

    protected synchronized void m7507a(C2301a c2301a) {
        try {
            String aaa = PortfolioApp.ZQ().aaa();
            if (TextUtils.isEmpty(aaa)) {
                MFLogger.m12671e(TAG, "Error inside " + TAG + ".setMicroAppMappingInBackground - serial is null");
            } else {
                MFLogger.m12670d(TAG, "Inside " + TAG + ".setMicroAppMappingInBackground - serial=" + aaa);
                hC(aaa);
                if (this.cEs != null) {
                    try {
                        List b = m7506b(this.cEs);
                        MFLogger.m12670d(TAG, "Inside " + TAG + ".setMicroAppMappingInBackground - set auto mapping to buttonservice.");
                        PortfolioApp.ZQ().setAutoMapping(((C2301a) abq()).getSerial(), b);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        } catch (Exception e2) {
            MFLogger.m12671e(TAG, "Error inside " + TAG + ".setMicroAppMappingInBackground - e=" + e2);
        }
    }

    private void hC(final String str) {
        MFLogger.m12670d(TAG, "Inside .initPresetSetting serial=" + str);
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        this.mPresetRepository.getActivePreset(str, new GetActivePresetCallback(this) {
            final /* synthetic */ cth cEt;

            public void onSuccess(ActivePreset activePreset) {
                MFLogger.m12670d(cth.TAG, "executeUseCase deviceSerial=" + str + " onSuccess");
                this.cEt.cEs = activePreset;
                countDownLatch.countDown();
            }

            public void onFail() {
                MFLogger.m12670d(cth.TAG, "executeUseCase deviceSerial=" + str + " onFail");
                this.cEt.hD(str);
                countDownLatch.countDown();
            }
        });
        try {
            MFLogger.m12670d(TAG, "Await on thread=" + Thread.currentThread().getName());
            countDownLatch.await();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void hD(String str) {
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        MFLogger.m12670d(TAG, "Inside .activateDefaultPreset serial=" + str);
        this.mPresetRepository.getDefaultPreset(str, new GetRecommendedPresetCallback(this) {
            final /* synthetic */ cth cEt;

            class C22971 implements GetActivePresetCallback {
                final /* synthetic */ C22982 cEu;

                C22971(C22982 c22982) {
                    this.cEu = c22982;
                }

                public void onSuccess(ActivePreset activePreset) {
                    MFLogger.m12670d(cth.TAG, "activateDefaultPreset onSuccess activePreset=" + activePreset.getButtons());
                    this.cEu.cEt.cEs = activePreset;
                    countDownLatch.countDown();
                }

                public void onFail() {
                    MFLogger.m12670d(cth.TAG, "activateDefaultPreset onFail");
                    countDownLatch.countDown();
                }
            }

            public void onSuccess(RecommendedPreset recommendedPreset) {
                MFLogger.m12670d(cth.TAG, "getActivePreset getDefaultPreset onSuccess");
                this.cEt.mPresetRepository.activateDefaultPreset(recommendedPreset, new C22971(this));
            }

            public void onFail() {
                MFLogger.m12670d(cth.TAG, "getActivePreset onFail");
                countDownLatch.countDown();
            }
        }, false);
        try {
            MFLogger.m12670d(TAG, "Await on thread=" + Thread.currentThread().getName());
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private List<BLEMapping> m7506b(ActivePreset activePreset) {
        MFLogger.m12670d(TAG, "createListMicroAppMapping activePreset=" + activePreset);
        final List<BLEMapping> arrayList = new ArrayList();
        if (activePreset.getButtonMappingList().isEmpty()) {
            return arrayList;
        }
        MFLogger.m12670d(TAG, "createListMicroAppMapping initMicroAppMapping activePreset=" + activePreset);
        drf.m9470a(((C2301a) abq()).getSerial(), activePreset.getButtonMappingList(), this.mMicroAppSettingRepository, this.mUAppSystemVersionRepository, new C2299b(this) {
            final /* synthetic */ cth cEt;

            public void onSuccess(List<MicroAppMapping> list) {
                MFLogger.m12670d(cth.TAG, "createListMicroAppMapping initMicroAppMapping onSuccess");
                arrayList.addAll(list);
            }

            public void onError(int i) {
                MFLogger.m12670d(cth.TAG, "createListMicroAppMapping initMicroAppMapping onError errorCode=" + i);
                if (i == 601 || i == 504 || i == 503 || i == MFNetworkReturnCode.INTERNAL_SERVER_ERROR || i == 404) {
                    this.cEt.mMicroAppSettingRepository.notifyStatusChanged("DECLARATION_FILES_DOWNLOADING", ((C2301a) this.cEt.abq()).getSerial());
                }
            }
        });
        MFLogger.m12670d(TAG, "go ahead");
        return arrayList;
    }
}
