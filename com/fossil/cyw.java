package com.fossil;

import android.text.TextUtils;
import com.fossil.ckb.C2132b;
import com.fossil.drf.C2299b;
import com.misfit.frameworks.buttonservice.model.UserProfile;
import com.misfit.frameworks.buttonservice.model.microapp.MicroAppInstruction.MicroAppID;
import com.misfit.frameworks.buttonservice.model.microapp.mapping.BLEMapping;
import com.misfit.frameworks.buttonservice.model.microapp.mapping.MicroAppMapping;
import com.misfit.frameworks.common.constants.MFNetworkReturnCode;
import com.misfit.frameworks.common.log.MFLogger;
import com.portfolio.platform.PortfolioApp;
import com.portfolio.platform.data.model.microapp.ActivePreset;
import com.portfolio.platform.data.model.microapp.MicroAppSetting;
import com.portfolio.platform.data.model.microapp.RecommendedPreset;
import com.portfolio.platform.data.model.microapp.SecondTimezone;
import com.portfolio.platform.data.source.MicroAppSettingDataSource.MicroAppSettingCallback;
import com.portfolio.platform.data.source.MicroAppSettingRepository;
import com.portfolio.platform.data.source.PresetDataSource.GetActivePresetCallback;
import com.portfolio.platform.data.source.PresetDataSource.GetRecommendedPresetCallback;
import com.portfolio.platform.data.source.PresetRepository;
import com.portfolio.platform.data.source.UAppSystemVersionRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;

public class cyw extends ckb<C2552a, Object, Object> {
    private static final String TAG = cyw.class.getSimpleName();
    private ActivePreset cEs;
    private MicroAppSetting cLv;
    private cnr czn;
    private MicroAppSettingRepository mMicroAppSettingRepository;
    private PresetRepository mPresetRepository;
    private UAppSystemVersionRepository mUAppSystemVersionRepository;

    public static final class C2552a implements C2132b {
        private boolean isNewDevice;
        private final String mSerial;
        private final int syncMode;

        public C2552a(String str, int i, boolean z) {
            this.mSerial = str;
            this.isNewDevice = z;
            this.syncMode = i;
        }

        public int getSyncMode() {
            return this.syncMode;
        }

        public String getSerial() {
            return this.mSerial;
        }
    }

    public /* synthetic */ void mo2022b(C2132b c2132b) {
        m7951a((C2552a) c2132b);
    }

    cyw(MicroAppSettingRepository microAppSettingRepository, UAppSystemVersionRepository uAppSystemVersionRepository, cnr com_fossil_cnr, PresetRepository presetRepository) {
        this.mMicroAppSettingRepository = (MicroAppSettingRepository) cco.m5996s(microAppSettingRepository, "microAppSettingRepository cannot be null!");
        this.mUAppSystemVersionRepository = (UAppSystemVersionRepository) cco.m5996s(uAppSystemVersionRepository, "uAppSystemVersionRepository cannot be null!");
        this.czn = (cnr) cco.m5996s(com_fossil_cnr, "preferencesManager cannot be null!");
        this.mPresetRepository = (PresetRepository) cco.m5996s(presetRepository, "presetRepository cannot be null!");
    }

    public synchronized void m7951a(C2552a c2552a) {
        MFLogger.m12670d(TAG, "executeUseCase on thread=" + Thread.currentThread().getName());
        int syncMode = c2552a.getSyncMode();
        String aaa = PortfolioApp.ZQ().aaa();
        UserProfile aad = PortfolioApp.ZQ().aad();
        if (aad == null) {
            MFLogger.m12671e(TAG, "Error inside " + TAG + ".startDeviceSync - user is null");
        } else if (TextUtils.isEmpty(aaa)) {
            MFLogger.m12671e(TAG, "Error inside " + TAG + ".startDeviceSync - serial is null");
        } else {
            MFLogger.m12670d(TAG, "Inside " + TAG + ".startDeviceSync - serial=" + aaa + ", weightInKg=" + aad.weight + ", heightInMeter=" + aad.height + ", goal=" + aad.goalSteps + ", isNewDevice=" + c2552a.isNewDevice + ", SyncMode=" + syncMode);
            if (!this.czn.gF(aaa) || syncMode == 13) {
                syncMode = 13;
            }
            if (syncMode == 13 || !PortfolioApp.ZQ().isSyncing(aaa)) {
                if (syncMode == 13) {
                    List b;
                    MFLogger.m12670d(TAG, "Inside " + TAG + ".startDeviceSync - Start full-sync");
                    id(aaa);
                    if (this.cEs != null) {
                        try {
                            b = m7950b(this.cEs);
                            MFLogger.m12670d(TAG, "Inside " + TAG + ".startDeviceSync - set auto mapping to buttonservice with activePreset=" + this.cEs);
                            PortfolioApp.ZQ().setAutoMapping(c2552a.getSerial(), b);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                    try {
                        if (this.cLv != null) {
                            try {
                                SecondTimezone secondTimezone = (SecondTimezone) new cfj().m6205c(this.cLv.getSetting(), SecondTimezone.class);
                                if (!(secondTimezone == null || TextUtils.isEmpty(secondTimezone.getTimezoneId()))) {
                                    PortfolioApp.ZQ().m12692a(secondTimezone);
                                }
                            } catch (Exception e2) {
                                e2.printStackTrace();
                            }
                        }
                        b = cnq.acd().acu().adG();
                        if (b == null) {
                            b = new ArrayList();
                        }
                        PortfolioApp.ZQ().m12684H(b);
                        syncMode = 13;
                    } catch (Exception e22) {
                        MFLogger.m12671e(TAG, "Error inside " + TAG + ".startDeviceSync - e=" + e22);
                    }
                }
                aad.isNewDevice = c2552a.isNewDevice;
                aad.syncMode = syncMode;
                MFLogger.m12670d(TAG, ".startDeviceSync - syncMode=" + syncMode);
                PortfolioApp.ZR().deviceStartSync(aaa, aad);
                if (syncMode == 13) {
                    this.czn.m7241a(aaa, System.currentTimeMillis(), false);
                }
            } else {
                MFLogger.m12671e(TAG, "Device is syncing, returning...");
            }
        }
    }

    private void id(final String str) {
        MFLogger.m12670d(TAG, "Inside .initPresetSetting serial=" + str);
        final CountDownLatch countDownLatch = new CountDownLatch(2);
        this.mPresetRepository.getActivePreset(str, new GetActivePresetCallback(this) {
            final /* synthetic */ cyw cLG;

            public void onSuccess(ActivePreset activePreset) {
                MFLogger.m12670d(cyw.TAG, "executeUseCase deviceSerial=" + str + " onSuccess");
                this.cLG.cEs = activePreset;
                countDownLatch.countDown();
            }

            public void onFail() {
                MFLogger.m12670d(cyw.TAG, "executeUseCase deviceSerial=" + str + " onFail");
                this.cLG.m7948a(str, countDownLatch);
            }
        });
        this.mMicroAppSettingRepository.getMicroAppSetting(MicroAppID.UAPP_TIME2_ID.getValue(), new MicroAppSettingCallback(this) {
            final /* synthetic */ cyw cLG;

            public void onSuccess(MicroAppSetting microAppSetting) {
                MFLogger.m12670d(cyw.TAG, "executeUseCase onSuccess microAppId=2nd Timezone");
                this.cLG.cLv = microAppSetting;
                countDownLatch.countDown();
            }

            public void onFail() {
                MFLogger.m12670d(cyw.TAG, "executeUseCase onFail microAppId=2nd Timezone");
                countDownLatch.countDown();
            }
        });
        try {
            MFLogger.m12670d(TAG, "Await on thread=" + Thread.currentThread().getName());
            countDownLatch.await();
        } catch (Exception e) {
            e.printStackTrace();
        }
        MFLogger.m12670d(TAG, "Await done=" + Thread.currentThread().getName());
    }

    private void m7948a(String str, final CountDownLatch countDownLatch) {
        MFLogger.m12670d(TAG, "Inside .activateDefaultPreset serial=" + str);
        this.mPresetRepository.getDefaultPreset(str, new GetRecommendedPresetCallback(this) {
            final /* synthetic */ cyw cLG;

            class C25491 implements GetActivePresetCallback {
                final /* synthetic */ C25503 cLH;

                C25491(C25503 c25503) {
                    this.cLH = c25503;
                }

                public void onSuccess(ActivePreset activePreset) {
                    MFLogger.m12670d(cyw.TAG, "activateDefaultPreset onSuccess activePreset=" + activePreset.getButtons());
                    this.cLH.cLG.cEs = activePreset;
                    countDownLatch.countDown();
                }

                public void onFail() {
                    MFLogger.m12670d(cyw.TAG, "activateDefaultPreset onFail");
                    countDownLatch.countDown();
                }
            }

            public void onSuccess(RecommendedPreset recommendedPreset) {
                MFLogger.m12670d(cyw.TAG, "getActivePreset getDefaultPreset onSuccess");
                this.cLG.mPresetRepository.activateDefaultPreset(recommendedPreset, new C25491(this));
            }

            public void onFail() {
                MFLogger.m12670d(cyw.TAG, "getActivePreset onFail");
                countDownLatch.countDown();
            }
        }, false);
    }

    private List<BLEMapping> m7950b(ActivePreset activePreset) {
        MFLogger.m12670d(TAG, "createListMicroAppMapping activePreset=" + activePreset);
        final List arrayList = new ArrayList();
        if (!activePreset.getButtonMappingList().isEmpty()) {
            MFLogger.m12670d(TAG, "createListMicroAppMapping initMicroAppMapping activePreset=" + activePreset);
            drf.m9470a(PortfolioApp.ZQ().aaa(), activePreset.getButtonMappingList(), this.mMicroAppSettingRepository, this.mUAppSystemVersionRepository, new C2299b(this) {
                final /* synthetic */ cyw cLG;

                public void onSuccess(List<MicroAppMapping> list) {
                    MFLogger.m12670d(cyw.TAG, "createListMicroAppMapping initMicroAppMapping onSuccess");
                    arrayList.addAll(list);
                }

                public void onError(int i) {
                    MFLogger.m12670d(cyw.TAG, "createListMicroAppMapping initMicroAppMapping onError errorCode=" + i);
                    if (i == 601 || i == 504 || i == 503 || i == MFNetworkReturnCode.INTERNAL_SERVER_ERROR || i == 404) {
                        this.cLG.mMicroAppSettingRepository.notifyStatusChanged("DECLARATION_FILES_DOWNLOADING", PortfolioApp.ZQ().aaa());
                    }
                }
            });
            MFLogger.m12670d(TAG, "go ahead");
        }
        return arrayList;
    }
}
