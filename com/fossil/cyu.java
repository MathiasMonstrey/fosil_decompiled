package com.fossil;

import android.text.TextUtils;
import com.fossil.ckb.C2131a;
import com.fossil.ckb.C2132b;
import com.fossil.ckb.C2133c;
import com.fossil.drf.C2299b;
import com.misfit.frameworks.buttonservice.model.microapp.MicroAppInstruction.MicroAppID;
import com.misfit.frameworks.buttonservice.model.microapp.mapping.BLEMapping;
import com.misfit.frameworks.buttonservice.model.microapp.mapping.MicroAppMapping;
import com.misfit.frameworks.common.constants.MFNetworkReturnCode;
import com.misfit.frameworks.common.log.MFLogger;
import com.misfit.frameworks.network.responses.MFResponse;
import com.portfolio.platform.PortfolioApp;
import com.portfolio.platform.data.model.DeviceModel;
import com.portfolio.platform.data.model.MFUser;
import com.portfolio.platform.data.model.microapp.ActivePreset;
import com.portfolio.platform.data.model.microapp.MicroAppSetting;
import com.portfolio.platform.data.model.microapp.RecommendedPreset;
import com.portfolio.platform.data.model.microapp.SecondTimezone;
import com.portfolio.platform.data.source.DataVersioningRepository;
import com.portfolio.platform.data.source.DeviceRepository;
import com.portfolio.platform.data.source.MicroAppSettingDataSource.MicroAppSettingCallback;
import com.portfolio.platform.data.source.MicroAppSettingRepository;
import com.portfolio.platform.data.source.PresetDataSource.GetActivePresetCallback;
import com.portfolio.platform.data.source.PresetDataSource.GetRecommendedPresetCallback;
import com.portfolio.platform.data.source.PresetRepository;
import com.portfolio.platform.data.source.UAppSystemVersionRepository;
import com.portfolio.platform.data.source.UserDataSource.OnUpdateUserComplete;
import com.portfolio.platform.data.source.UserRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;

public class cyu extends ckb<C2544a, C2546c, C2545b> {
    private static final String TAG = cyu.class.getSimpleName();
    private ActivePreset cEs;
    private MicroAppSetting cLv;
    private DataVersioningRepository czr;
    private ciw mAppExecutors;
    private DeviceRepository mDeviceRepository;
    private MicroAppSettingRepository mMicroAppSettingRepository;
    private PresetRepository mPresetRepository;
    private UAppSystemVersionRepository mUAppSystemVersionRepository;
    private UserRepository mUserRepository;

    public static final class C2544a implements C2132b {
        private final String cDD;
        private final String cLE;

        public C2544a(String str, String str2) {
            this.cDD = str;
            this.cLE = str2;
        }

        public String ajZ() {
            return this.cLE;
        }
    }

    public static class C2545b implements C2131a {
        private int errorCode;

        C2545b(int i) {
            this.errorCode = i;
        }

        public int getErrorCode() {
            return this.errorCode;
        }
    }

    public static final class C2546c implements C2133c {
    }

    protected /* synthetic */ void mo2022b(C2132b c2132b) {
        m7940a((C2544a) c2132b);
    }

    cyu(UserRepository userRepository, DeviceRepository deviceRepository, PresetRepository presetRepository, MicroAppSettingRepository microAppSettingRepository, UAppSystemVersionRepository uAppSystemVersionRepository, DataVersioningRepository dataVersioningRepository, ciw com_fossil_ciw) {
        this.mAppExecutors = com_fossil_ciw;
        this.mUserRepository = userRepository;
        this.mDeviceRepository = deviceRepository;
        this.mPresetRepository = presetRepository;
        this.czr = dataVersioningRepository;
        this.mMicroAppSettingRepository = (MicroAppSettingRepository) cco.m5996s(microAppSettingRepository, "microAppSettingRepository cannot be null!");
        this.mUAppSystemVersionRepository = (UAppSystemVersionRepository) cco.m5996s(uAppSystemVersionRepository, "uAppSystemVersionRepository cannot be null!");
    }

    protected void m7940a(final C2544a c2544a) {
        MFUser currentUser = this.mUserRepository.getCurrentUser();
        if (currentUser == null || TextUtils.isEmpty(c2544a.ajZ())) {
            abr().onError(new C2545b(MFNetworkReturnCode.INTERNAL_SERVER_ERROR));
            return;
        }
        currentUser.setActiveDeviceId(c2544a.ajZ());
        final DeviceModel deviceBySerial = this.mDeviceRepository.getDeviceBySerial(c2544a.ajZ(), null);
        this.mUserRepository.addOrUpdateUser(currentUser, new OnUpdateUserComplete(this) {
            final /* synthetic */ cyu cLy;

            public void onComplete(final MFResponse mFResponse, final boolean z, final MFUser mFUser) {
                cjw.ZP().m6836l(new Runnable(this) {
                    final /* synthetic */ C25371 cLB;

                    public void run() {
                        if (!z || mFUser == null) {
                            this.cLB.cLy.abr().onError(new C2545b(mFResponse.getHttpReturnCode()));
                            return;
                        }
                        this.cLB.cLy.czr.clearDeviceDataVersioning();
                        this.cLB.cLy.mPresetRepository.setIsActivePresetCacheDirty(true);
                        this.cLB.cLy.mPresetRepository.notifyActivePresetObserver();
                        this.cLB.cLy.mPresetRepository.setCacheIsDirty(true);
                        this.cLB.cLy.mPresetRepository.notifySavedPresetObserver();
                        this.cLB.cLy.ic(c2544a.ajZ());
                        this.cLB.cLy.mDeviceRepository.updateDevice(deviceBySerial, null);
                        this.cLB.cLy.abr().onSuccess(new C2546c());
                    }
                });
            }
        });
    }

    private void ic(String str) {
        id(str);
        if (this.cEs != null) {
            try {
                List a = m7935a(str, this.cEs);
                MFLogger.m12670d(TAG, "Inside " + TAG + ".startDeviceSync - set auto mapping to buttonservice.");
                PortfolioApp.ZQ().setAutoMapping(((C2544a) abq()).ajZ(), a);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if (this.cLv != null) {
            try {
                SecondTimezone secondTimezone = (SecondTimezone) new cfj().m6205c(this.cLv.getSetting(), SecondTimezone.class);
                if (!(secondTimezone == null || secondTimezone.getTimezoneId() == null)) {
                    PortfolioApp.ZQ().m12692a(secondTimezone);
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        PortfolioApp.ZQ().fO(str);
    }

    private void id(final String str) {
        MFLogger.m12670d(TAG, "Inside .initPresetSetting serial=" + str);
        final CountDownLatch countDownLatch = new CountDownLatch(2);
        this.mPresetRepository.getActivePreset(str, new GetActivePresetCallback(this) {
            final /* synthetic */ cyu cLy;

            public void onSuccess(ActivePreset activePreset) {
                MFLogger.m12670d(cyu.TAG, "executeUseCase deviceSerial=" + str + " onSuccess");
                this.cLy.cEs = activePreset;
                countDownLatch.countDown();
            }

            public void onFail() {
                MFLogger.m12670d(cyu.TAG, "executeUseCase deviceSerial=" + str + " onFail");
                this.cLy.hD(str);
                countDownLatch.countDown();
            }
        });
        this.mMicroAppSettingRepository.getMicroAppSetting(MicroAppID.UAPP_TIME2_ID.getValue(), new MicroAppSettingCallback(this) {
            final /* synthetic */ cyu cLy;

            public void onSuccess(MicroAppSetting microAppSetting) {
                MFLogger.m12670d(cyu.TAG, "executeUseCase onSuccess microAppId=2nd Timezone");
                this.cLy.cLv = microAppSetting;
                countDownLatch.countDown();
            }

            public void onFail() {
                MFLogger.m12670d(cyu.TAG, "executeUseCase onFail microAppId=2nd Timezone");
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

    private void hD(final String str) {
        this.mAppExecutors.YQ().execute(new Runnable(this) {
            final /* synthetic */ cyu cLy;

            public void run() {
                final CountDownLatch countDownLatch = new CountDownLatch(1);
                MFLogger.m12670d(cyu.TAG, "Inside .activateDefaultPreset serial=" + str);
                this.cLy.mPresetRepository.getDefaultPreset(str, new GetRecommendedPresetCallback(this) {
                    final /* synthetic */ C25424 cLC;

                    class C25401 implements GetActivePresetCallback {
                        final /* synthetic */ C25411 cLD;

                        C25401(C25411 c25411) {
                            this.cLD = c25411;
                        }

                        public void onSuccess(ActivePreset activePreset) {
                            MFLogger.m12670d(cyu.TAG, "activateDefaultPreset onSuccess activePreset=" + activePreset.getButtons());
                            this.cLD.cLC.cLy.cEs = activePreset;
                            countDownLatch.countDown();
                        }

                        public void onFail() {
                            MFLogger.m12670d(cyu.TAG, "activateDefaultPreset onFail");
                            countDownLatch.countDown();
                        }
                    }

                    public void onSuccess(RecommendedPreset recommendedPreset) {
                        MFLogger.m12670d(cyu.TAG, "getActivePreset getDefaultPreset onSuccess");
                        this.cLC.cLy.mPresetRepository.activateDefaultPreset(recommendedPreset, new C25401(this));
                    }

                    public void onFail() {
                        MFLogger.m12670d(cyu.TAG, "getActivePreset onFail");
                        countDownLatch.countDown();
                    }
                }, false);
                try {
                    MFLogger.m12670d(cyu.TAG, "Await on thread=" + Thread.currentThread().getName());
                    countDownLatch.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    private List<BLEMapping> m7935a(String str, ActivePreset activePreset) {
        final List arrayList = new ArrayList();
        if (!activePreset.getButtonMappingList().isEmpty()) {
            drf.m9470a(str, activePreset.getButtonMappingList(), this.mMicroAppSettingRepository, this.mUAppSystemVersionRepository, new C2299b(this) {
                final /* synthetic */ cyu cLy;

                public void onSuccess(List<MicroAppMapping> list) {
                    arrayList.addAll(list);
                }

                public void onError(int i) {
                }
            });
            MFLogger.m12670d(TAG, "go ahead");
        }
        return arrayList;
    }
}
