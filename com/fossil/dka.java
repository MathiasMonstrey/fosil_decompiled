package com.fossil;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.fossil.ckb.C2131a;
import com.fossil.ckb.C2132b;
import com.fossil.ckb.C2133c;
import com.misfit.frameworks.buttonservice.ButtonService;
import com.misfit.frameworks.buttonservice.communite.CommunicateMode;
import com.misfit.frameworks.buttonservice.enums.ServiceActionResult;
import com.misfit.frameworks.buttonservice.model.microapp.MicroAppInstruction.MicroAppID;
import com.misfit.frameworks.buttonservice.model.microapp.mapping.MicroAppMapping;
import com.misfit.frameworks.buttonservice.model.microapp.mapping.customization.BLECustomization;
import com.misfit.frameworks.buttonservice.model.microapp.mapping.customization.BLEGoalTrackingCustomization;
import com.misfit.frameworks.buttonservice.model.microapp.mapping.customization.BLENonCustomization;
import com.misfit.frameworks.common.enums.Gesture;
import com.misfit.frameworks.common.log.MFLogger;
import com.portfolio.platform.PortfolioApp;
import com.portfolio.platform.data.model.microapp.ActivePreset;
import com.portfolio.platform.data.model.microapp.ButtonMapping;
import com.portfolio.platform.data.model.microapp.CommuteTimeSettings;
import com.portfolio.platform.data.model.microapp.DeclarationFile;
import com.portfolio.platform.data.model.microapp.MicroAppSetting;
import com.portfolio.platform.data.model.microapp.MicroAppVariant;
import com.portfolio.platform.data.model.microapp.PusherConfiguration.Pusher;
import com.portfolio.platform.data.model.microapp.goaltracking.GoalTrackingSettings;
import com.portfolio.platform.data.source.MicroAppSettingDataSource.GetVariantCallback;
import com.portfolio.platform.data.source.MicroAppSettingDataSource.MicroAppSettingCallback;
import com.portfolio.platform.data.source.MicroAppSettingRepository;
import com.portfolio.platform.data.source.PresetDataSource.GetActivePresetCallback;
import com.portfolio.platform.data.source.PresetRepository;
import com.portfolio.platform.data.source.UAppSystemVersionRepository;
import com.portfolio.platform.enums.PermissionCodes;
import com.portfolio.platform.model.UAppSystemVersionModel;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

public class dka extends ckb<C2869b, C2870c, C2868a> {
    private static final String TAG = dka.class.getSimpleName();
    private BroadcastReceiver broadcastReceiver = new C28601(this);
    private MicroAppSetting cCl;
    private gy cEa;
    private boolean cLc = false;
    private MicroAppSettingRepository cXO;
    private CommuteTimeSettings cXP;
    private PresetRepository mPresetRepository;
    private UAppSystemVersionRepository mUAppSystemVersionRepository;

    class C28601 extends BroadcastReceiver {
        final /* synthetic */ dka cXQ;

        C28601(dka com_fossil_dka) {
            this.cXQ = com_fossil_dka;
        }

        public void onReceive(Context context, Intent intent) {
            MFLogger.m12670d(dka.TAG, "onReceive mIsExecuted=" + this.cXQ.cLc);
            if (CommunicateMode.values()[intent.getIntExtra(ButtonService.SERVICE_BLE_PHASE, CommunicateMode.IDLE.ordinal())] == CommunicateMode.SET_LINK_MAPPING && this.cXQ.cLc) {
                this.cXQ.cLc = false;
                if (intent.getIntExtra(ButtonService.SERVICE_ACTION_RESULT, -1) == ServiceActionResult.SUCCEEDED.ordinal()) {
                    MFLogger.m12670d(dka.TAG, "onReceive success");
                    this.cXQ.apc();
                    return;
                }
                MFLogger.m12670d(dka.TAG, "onReceive failed");
                int intExtra = intent.getIntExtra(ButtonService.LAST_DEVICE_ERROR_STATE, -1);
                ArrayList integerArrayListExtra = intent.getIntegerArrayListExtra(ButtonService.LIST_ERROR_STATE);
                if (integerArrayListExtra == null) {
                    integerArrayListExtra = new ArrayList(intExtra);
                }
                this.cXQ.abr().onError(new C2868a(2, intExtra, PermissionCodes.convertBLEPermissionErrorCode(integerArrayListExtra)));
            }
        }
    }

    class C28612 implements MicroAppSettingCallback {
        final /* synthetic */ dka cXQ;

        C28612(dka com_fossil_dka) {
            this.cXQ = com_fossil_dka;
        }

        public void onSuccess(MicroAppSetting microAppSetting) {
            CommuteTimeSettings commuteTimeSettings;
            this.cXQ.cCl = microAppSetting;
            try {
                commuteTimeSettings = (CommuteTimeSettings) new cfj().m6205c(microAppSetting.getSetting(), CommuteTimeSettings.class);
            } catch (Exception e) {
                MFLogger.m12670d(dka.TAG, "get oldCommuteSettings ex=" + e.getMessage());
                commuteTimeSettings = null;
            }
            if (commuteTimeSettings == null) {
                commuteTimeSettings = new CommuteTimeSettings();
            }
            if (commuteTimeSettings.getTimeFormat() != this.cXQ.cXP.getTimeFormat()) {
                this.cXQ.aqF();
            } else {
                this.cXQ.apc();
            }
        }

        public void onFail() {
            this.cXQ.cCl = new MicroAppSetting(MicroAppID.UAPP_COMMUTE_TIME.getValue(), "");
            this.cXQ.apc();
        }
    }

    class C28655 implements MicroAppSettingCallback {
        final /* synthetic */ dka cXQ;

        C28655(dka com_fossil_dka) {
            this.cXQ = com_fossil_dka;
        }

        public void onSuccess(MicroAppSetting microAppSetting) {
        }

        public void onFail() {
        }
    }

    class C28666 implements MicroAppSettingCallback {
        final /* synthetic */ dka cXQ;

        C28666(dka com_fossil_dka) {
            this.cXQ = com_fossil_dka;
        }

        public void onSuccess(MicroAppSetting microAppSetting) {
            MFLogger.m12670d(dka.TAG, "addOrUpdateMicroAppSetting onSuccess");
            this.cXQ.abr().onSuccess(new C2870c(microAppSetting));
        }

        public void onFail() {
            MFLogger.m12670d(dka.TAG, "addOrUpdateMicroAppSetting onFail");
            this.cXQ.abr().onError(null);
        }
    }

    static /* synthetic */ class C28677 {
        static final /* synthetic */ int[] f1463xb89372e = new int[MicroAppID.values().length];

        static {
            try {
                f1463xb89372e[MicroAppID.UAPP_GOAL_TRACKING_ID.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
        }
    }

    public static final class C2868a implements C2131a {
        private final int cJJ;
        private final List<PermissionCodes> cXV;
        private final int mErrorCode;

        public C2868a(int i, int i2, List<PermissionCodes> list) {
            this.mErrorCode = i;
            this.cJJ = i2;
            this.cXV = list;
        }

        public C2868a(int i) {
            this(i, -1, new ArrayList());
        }

        public C2868a(int i, List<PermissionCodes> list) {
            this(i, -1, list);
        }

        public int getErrorCode() {
            return this.mErrorCode;
        }

        public List<PermissionCodes> aqG() {
            return this.cXV;
        }

        public int ajg() {
            return this.cJJ;
        }
    }

    public static final class C2869b implements C2132b {
        private final CommuteTimeSettings cDY;

        public C2869b(CommuteTimeSettings commuteTimeSettings) {
            this.cDY = (CommuteTimeSettings) cco.m5996s(commuteTimeSettings, "commuteTimeSettings cannot be null!");
        }
    }

    public static final class C2870c implements C2133c {
        private final MicroAppSetting cCl;

        public C2870c(MicroAppSetting microAppSetting) {
            this.cCl = microAppSetting;
        }

        public MicroAppSetting aqu() {
            return this.cCl;
        }
    }

    protected /* synthetic */ void mo2022b(C2132b c2132b) {
        m8874a((C2869b) c2132b);
    }

    dka(MicroAppSettingRepository microAppSettingRepository, PresetRepository presetRepository, UAppSystemVersionRepository uAppSystemVersionRepository, gy gyVar) {
        this.cXO = (MicroAppSettingRepository) cco.m5996s(microAppSettingRepository, "microAppSettingRepository cannot be null!");
        this.mPresetRepository = (PresetRepository) cco.m5996s(presetRepository, "presetRepository cannot be null!");
        this.mUAppSystemVersionRepository = (UAppSystemVersionRepository) cco.m5996s(uAppSystemVersionRepository, "uAppSystemVersionRepository cannot be null!");
        this.cEa = (gy) cco.m5996s(gyVar, "mLocalBroadcastManager cannot be null!");
    }

    protected void m8874a(C2869b c2869b) {
        this.cLc = true;
        MFLogger.m12670d(TAG, "executeUseCase destination=" + c2869b.cDY.getDestination() + " timeFormat=" + c2869b.cDY.getTimeFormat().getValue());
        this.cXP = c2869b.cDY;
        this.cXO.getMicroAppSetting(MicroAppID.UAPP_COMMUTE_TIME.getValue(), new C28612(this));
    }

    private void aqF() {
        final String aaa = PortfolioApp.ZQ().aaa();
        this.mPresetRepository.getActivePreset(aaa, new GetActivePresetCallback(this) {
            final /* synthetic */ dka cXQ;

            public void onSuccess(ActivePreset activePreset) {
                MFLogger.m12670d(dka.TAG, "executeUseCase getActivePreset onSuccess");
                List<ButtonMapping> buttonMappingList = activePreset.getButtonMappingList();
                for (ButtonMapping buttonMapping : buttonMappingList) {
                    if (buttonMapping.getMicroAppId().equals(MicroAppID.UAPP_COMMUTE_TIME.getValue())) {
                        break;
                    }
                }
                ButtonMapping buttonMapping2 = null;
                if (buttonMapping2 != null) {
                    this.cXQ.m8872h(aaa, buttonMappingList);
                } else {
                    this.cXQ.apc();
                }
            }

            public void onFail() {
                MFLogger.m12670d(dka.TAG, "executeUseCase getActivePreset onFail");
                this.cXQ.abr().onError(null);
            }
        });
    }

    private void m8872h(String str, List<ButtonMapping> list) {
        int fS = PortfolioApp.ZQ().fS(PortfolioApp.ZQ().aaa());
        MFLogger.m12670d(TAG, "Inside .convertToMicroAppMappings currentDeviceSession=" + fS);
        if (fS == CommunicateMode.OTA.getValue()) {
            abr().onError(new C2868a(3));
            this.cLc = false;
            return;
        }
        List arrayList = new ArrayList();
        if (!dre.dff.auD()) {
            arrayList.add(PermissionCodes.BLUETOOTH_OFF);
        }
        if (!dre.dff.cx(PortfolioApp.ZQ())) {
            arrayList.add(PermissionCodes.LOCATION_PERMISSION_FEATURE_OFF);
        }
        if (!dre.dff.auC()) {
            arrayList.add(PermissionCodes.LOCATION_SERVICE_FEATURE_OFF);
        }
        if (arrayList.isEmpty()) {
            final List arrayList2 = new ArrayList();
            final CountDownLatch countDownLatch = new CountDownLatch(list.size());
            final AtomicInteger atomicInteger = new AtomicInteger(-1);
            UAppSystemVersionModel uAppSystemVersionModel = this.mUAppSystemVersionRepository.getUAppSystemVersionModel(str);
            if (uAppSystemVersionModel == null || uAppSystemVersionModel.getMajorVersion() == 255 || uAppSystemVersionModel.getMinorVersion() == 255) {
                atomicInteger.set(2);
            } else {
                for (final ButtonMapping buttonMapping : list) {
                    if (buttonMapping != null) {
                        m8864a(str, buttonMapping.getMicroAppId(), this.cXO, uAppSystemVersionModel, new GetVariantCallback(this) {
                            final /* synthetic */ dka cXQ;

                            public void onSuccess(final MicroAppVariant microAppVariant) {
                                MFLogger.m12670d(dka.TAG, "Inside .getVariant onSuccess of buttonMapping=" + buttonMapping);
                                switch (C28677.f1463xb89372e[MicroAppID.getMicroAppId(buttonMapping.getMicroAppId()).ordinal()]) {
                                    case 1:
                                        this.cXQ.cXO.getMicroAppSetting(buttonMapping.getMicroAppId(), new MicroAppSettingCallback(this) {
                                            final /* synthetic */ C28644 cXU;

                                            public void onSuccess(MicroAppSetting microAppSetting) {
                                                MFLogger.m12670d(dka.TAG, "Inside .getVariant onSuccess getMicroAppSetting");
                                                MicroAppMapping a = this.cXU.cXQ.m8861a(buttonMapping, microAppVariant, microAppSetting);
                                                if (a != null) {
                                                    arrayList2.add(a);
                                                }
                                                countDownLatch.countDown();
                                            }

                                            public void onFail() {
                                                MFLogger.m12670d(dka.TAG, "Inside .getVariant onFail getMicroAppSetting");
                                                MicroAppSetting microAppSetting = new MicroAppSetting(MicroAppID.UAPP_GOAL_TRACKING_ID.getValue(), new GoalTrackingSettings().toJson());
                                                this.cXU.cXQ.m8873j(microAppSetting);
                                                MicroAppMapping a = this.cXU.cXQ.m8861a(buttonMapping, microAppVariant, microAppSetting);
                                                if (a != null) {
                                                    arrayList2.add(a);
                                                }
                                                countDownLatch.countDown();
                                            }
                                        });
                                        return;
                                    default:
                                        MicroAppMapping a = this.cXQ.m8861a(buttonMapping, microAppVariant, null);
                                        if (a != null) {
                                            arrayList2.add(a);
                                        }
                                        countDownLatch.countDown();
                                        return;
                                }
                            }

                            public void onFail(int i) {
                                MFLogger.m12670d(dka.TAG, "Inside .getVariant onFailed of buttonMapping=" + buttonMapping);
                                atomicInteger.set(i);
                                countDownLatch.countDown();
                            }
                        });
                    } else {
                        atomicInteger.set(2);
                        countDownLatch.countDown();
                    }
                }
                try {
                    MFLogger.m12670d(TAG, "Await on thread=" + Thread.currentThread().getName());
                    countDownLatch.await();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            if (atomicInteger.get() == -1) {
                MFLogger.m12670d(TAG, "Inside .initMicroAppMapping onSuccess");
                PortfolioApp.ZQ().m12697e(str, arrayList2);
                return;
            }
            MFLogger.m12670d(TAG, "Inside .initMicroAppMapping onFailed");
            abr().onError(new C2868a(atomicInteger.get()));
            return;
        }
        abr().onError(new C2868a(4, arrayList));
        this.cLc = false;
    }

    private void m8873j(MicroAppSetting microAppSetting) {
        MFLogger.m12670d(TAG, "Inside .getMicroAppSetting, there is no default goal tracking setting, generate one: " + microAppSetting.getSetting());
        this.cXO.addOrUpdateMicroAppSetting(microAppSetting, new C28655(this));
    }

    private MicroAppMapping m8861a(ButtonMapping buttonMapping, MicroAppVariant microAppVariant, MicroAppSetting microAppSetting) {
        MFLogger.m12670d(TAG, "createMicroAppMapping");
        Gesture iP = iP(buttonMapping.getButton());
        MicroAppID microAppId = MicroAppID.getMicroAppId(buttonMapping.getMicroAppId());
        if (microAppVariant.getDeclarationFiles().isEmpty()) {
            return null;
        }
        String[] strArr = new String[microAppVariant.getDeclarationFiles().size()];
        List declarationFiles = microAppVariant.getDeclarationFiles();
        for (int i = 0; i < declarationFiles.size(); i++) {
            strArr[i] = ((DeclarationFile) microAppVariant.getDeclarationFiles().get(i)).getContent();
        }
        BLECustomization bLENonCustomization = new BLENonCustomization();
        switch (C28677.f1463xb89372e[microAppId.ordinal()]) {
            case 1:
                if (microAppSetting == null) {
                    MFLogger.m12670d(TAG, "createMicroAppMapping, setting micro app goal tracking is empty??? Set goalId 255 to device.");
                    bLENonCustomization = new BLEGoalTrackingCustomization(255);
                    break;
                }
                GoalTrackingSettings goalTrackingSettings = (GoalTrackingSettings) new cfj().m6205c(microAppSetting.getSetting(), GoalTrackingSettings.class);
                if (goalTrackingSettings == null) {
                    MFLogger.m12670d(TAG, "createMicroAppMapping, goal tracking data is empty??? Set goalId 255 to device.");
                    bLENonCustomization = new BLEGoalTrackingCustomization(255);
                    break;
                }
                bLENonCustomization = new BLEGoalTrackingCustomization(cmv.aE((long) goalTrackingSettings.getGoalId()));
                break;
        }
        return new MicroAppMapping(iP, microAppId.getValue(), strArr, bLENonCustomization);
    }

    private void m8864a(String str, String str2, MicroAppSettingRepository microAppSettingRepository, UAppSystemVersionModel uAppSystemVersionModel, GetVariantCallback getVariantCallback) {
        MFLogger.m12670d(TAG, "getVariant");
        MFLogger.m12670d(TAG, "getVariant, serial = " + str + ", microAppId = " + str2);
        String str3 = (String) cco.ce(str);
        MicroAppSettingRepository microAppSettingRepository2 = (MicroAppSettingRepository) cco.ce(microAppSettingRepository);
        UAppSystemVersionModel uAppSystemVersionModel2 = (UAppSystemVersionModel) cco.ce(uAppSystemVersionModel);
        String str4 = "";
        if (str2.equals(MicroAppID.UAPP_COMMUTE_TIME.getValue())) {
            str4 = this.cXP.getTimeFormat().getValue();
        }
        microAppSettingRepository2.getMicroAppVariant(str3, str2, str4, uAppSystemVersionModel2.getMajorVersion(), uAppSystemVersionModel2.getMinorVersion(), getVariantCallback);
    }

    private Gesture iP(String str) {
        if (str.equals(Pusher.TOP_PUSHER.getValue())) {
            return Gesture.SAM_BT1_SINGLE_PRESS;
        }
        if (str.equals(Pusher.MID_PUSHER.getValue())) {
            return Gesture.SAM_BT2_SINGLE_PRESS;
        }
        return Gesture.SAM_BT3_SINGLE_PRESS;
    }

    private void apc() {
        String toJson = new cfj().toJson(this.cXP);
        MFLogger.m12670d(TAG, "saveCommuteSettings - jsonString=" + toJson);
        this.cCl.setSetting(toJson);
        this.cXO.addOrUpdateMicroAppSetting(this.cCl, new C28666(this));
    }

    public void ajd() {
        MFLogger.m12670d(TAG, "registerBroadcastReceiver");
        this.cEa.m11537a(this.broadcastReceiver, new IntentFilter(PortfolioApp.ZQ().getPackageName().concat(ButtonService.ACTION_SERVICE_BLE_RESPONSE)));
    }

    public void aje() {
        MFLogger.m12670d(TAG, "unregisterBroadcastReceiver");
        this.cEa.unregisterReceiver(this.broadcastReceiver);
    }
}
