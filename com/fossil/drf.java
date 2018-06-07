package com.fossil;

import com.misfit.frameworks.buttonservice.model.microapp.MicroAppInstruction.MicroAppID;
import com.misfit.frameworks.buttonservice.model.microapp.mapping.MicroAppMapping;
import com.misfit.frameworks.buttonservice.model.microapp.mapping.customization.BLECustomization;
import com.misfit.frameworks.buttonservice.model.microapp.mapping.customization.BLEGoalTrackingCustomization;
import com.misfit.frameworks.buttonservice.model.microapp.mapping.customization.BLENonCustomization;
import com.misfit.frameworks.common.enums.Gesture;
import com.misfit.frameworks.common.log.MFLogger;
import com.portfolio.platform.data.model.microapp.ButtonMapping;
import com.portfolio.platform.data.model.microapp.CommuteTimeSettings;
import com.portfolio.platform.data.model.microapp.CommuteTimeSettings.TIME_FORMAT;
import com.portfolio.platform.data.model.microapp.DeclarationFile;
import com.portfolio.platform.data.model.microapp.MicroAppSetting;
import com.portfolio.platform.data.model.microapp.MicroAppVariant;
import com.portfolio.platform.data.model.microapp.PusherConfiguration.Pusher;
import com.portfolio.platform.data.model.microapp.goaltracking.GoalTrackingSettings;
import com.portfolio.platform.data.source.MicroAppSettingDataSource.GetVariantCallback;
import com.portfolio.platform.data.source.MicroAppSettingDataSource.MicroAppSettingCallback;
import com.portfolio.platform.data.source.MicroAppSettingRepository;
import com.portfolio.platform.data.source.UAppSystemVersionRepository;
import com.portfolio.platform.model.UAppSystemVersionModel;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

public class drf {
    private static String TAG = drf.class.getName();

    public interface C2299b {
        void onError(int i);

        void onSuccess(List<MicroAppMapping> list);
    }

    interface C3113a {
        void mo2665a(MicroAppVariant microAppVariant, MicroAppSetting microAppSetting);

        void onFailed(int i);
    }

    static /* synthetic */ class C31195 {
        static final /* synthetic */ int[] f1464xb89372e = new int[MicroAppID.values().length];

        static {
            try {
                f1464xb89372e[MicroAppID.UAPP_GOAL_TRACKING_ID.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f1464xb89372e[MicroAppID.UAPP_COMMUTE_TIME.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
        }
    }

    public static void m9470a(String str, List<ButtonMapping> list, MicroAppSettingRepository microAppSettingRepository, UAppSystemVersionRepository uAppSystemVersionRepository, C2299b c2299b) {
        List<ButtonMapping> list2 = (List) cco.ce(list);
        String str2 = (String) cco.ce(str);
        MicroAppSettingRepository microAppSettingRepository2 = (MicroAppSettingRepository) cco.ce(microAppSettingRepository);
        UAppSystemVersionRepository uAppSystemVersionRepository2 = (UAppSystemVersionRepository) cco.ce(uAppSystemVersionRepository);
        C2299b c2299b2 = (C2299b) cco.ce(c2299b);
        MFLogger.m12670d(TAG, "Inside .initMicroAppMapping serial = " + str2 + ", buttonMappings = " + list2);
        final List arrayList = new ArrayList();
        final CountDownLatch countDownLatch = new CountDownLatch(list2.size());
        final AtomicInteger atomicInteger = new AtomicInteger(-1);
        UAppSystemVersionModel uAppSystemVersionModel = uAppSystemVersionRepository2.getUAppSystemVersionModel(str2);
        if (uAppSystemVersionModel == null || uAppSystemVersionModel.getMajorVersion() == 255 || uAppSystemVersionModel.getMinorVersion() == 255) {
            atomicInteger.set(2);
        } else {
            for (final ButtonMapping buttonMapping : list2) {
                if (buttonMapping != null) {
                    m9469a(str2, buttonMapping.getMicroAppId(), microAppSettingRepository2, uAppSystemVersionModel, new C3113a() {
                        public void mo2665a(MicroAppVariant microAppVariant, MicroAppSetting microAppSetting) {
                            MFLogger.m12670d(drf.TAG, "Inside .getVariant onSuccess of buttonMapping=" + buttonMapping);
                            MicroAppMapping b;
                            switch (C31195.f1464xb89372e[MicroAppID.getMicroAppId(buttonMapping.getMicroAppId()).ordinal()]) {
                                case 1:
                                    b = drf.m9466a(buttonMapping, microAppVariant, microAppSetting);
                                    if (b != null) {
                                        arrayList.add(b);
                                        break;
                                    }
                                    break;
                                default:
                                    b = drf.m9466a(buttonMapping, microAppVariant, null);
                                    if (b != null) {
                                        arrayList.add(b);
                                        break;
                                    }
                                    break;
                            }
                            countDownLatch.countDown();
                        }

                        public void onFailed(int i) {
                            MFLogger.m12670d(drf.TAG, "Inside .getVariant onFailed of buttonMapping=" + buttonMapping);
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
            c2299b2.onSuccess(arrayList);
            return;
        }
        MFLogger.m12670d(TAG, "Inside .initMicroAppMapping onFailed");
        c2299b2.onError(atomicInteger.get());
    }

    private static MicroAppMapping m9466a(ButtonMapping buttonMapping, MicroAppVariant microAppVariant, MicroAppSetting microAppSetting) {
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
        switch (C31195.f1464xb89372e[microAppId.ordinal()]) {
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

    private static void m9469a(String str, String str2, MicroAppSettingRepository microAppSettingRepository, UAppSystemVersionModel uAppSystemVersionModel, C3113a c3113a) {
        MFLogger.m12670d(TAG, "getVariant");
        MFLogger.m12670d(TAG, "getVariant, serial = " + str + ", microAppId = " + str2);
        String str3 = (String) cco.ce(str);
        MicroAppSettingRepository microAppSettingRepository2 = (MicroAppSettingRepository) cco.ce(microAppSettingRepository);
        UAppSystemVersionModel uAppSystemVersionModel2 = (UAppSystemVersionModel) cco.ce(uAppSystemVersionModel);
        final C3113a c3113a2 = (C3113a) cco.ce(c3113a);
        switch (C31195.f1464xb89372e[MicroAppID.getMicroAppId(str2).ordinal()]) {
            case 1:
            case 2:
                m9468a(str3, str2, uAppSystemVersionModel2.getMajorVersion(), uAppSystemVersionModel2.getMinorVersion(), microAppSettingRepository2, c3113a2);
                return;
            default:
                int majorVersion = uAppSystemVersionModel2.getMajorVersion();
                int minorVersion = uAppSystemVersionModel2.getMinorVersion();
                GetVariantCallback c31152 = new GetVariantCallback() {
                    public void onSuccess(MicroAppVariant microAppVariant) {
                        MFLogger.m12670d(drf.TAG, "getVariant getMicroAppVariant onSuccess");
                        c3113a2.mo2665a(microAppVariant, null);
                    }

                    public void onFail(int i) {
                        MFLogger.m12670d(drf.TAG, "getVariant getMicroAppVariant onFail");
                        c3113a2.onFailed(i);
                    }
                };
                microAppSettingRepository2.getMicroAppVariant(str3, str2, "", majorVersion, minorVersion, c31152);
                return;
        }
    }

    private static void m9468a(String str, String str2, int i, int i2, MicroAppSettingRepository microAppSettingRepository, C3113a c3113a) {
        final C3113a c3113a2 = (C3113a) cco.ce(c3113a);
        final MicroAppSettingRepository microAppSettingRepository2 = (MicroAppSettingRepository) cco.ce(microAppSettingRepository);
        MFLogger.m12670d(TAG, "getVariantBaseOnSetting serial " + str + " microAppId=" + str2 + "major=" + i + "minor=" + i2);
        final String str3 = str2;
        final int i3 = i;
        final int i4 = i2;
        final String str4 = str;
        final C3113a c3113a3 = c3113a;
        microAppSettingRepository2.getMicroAppSetting(str2, new MicroAppSettingCallback() {

            class C31161 implements MicroAppSettingCallback {
                final /* synthetic */ C31173 dfj;

                C31161(C31173 c31173) {
                    this.dfj = c31173;
                }

                public void onSuccess(MicroAppSetting microAppSetting) {
                }

                public void onFail() {
                }
            }

            public void onSuccess(MicroAppSetting microAppSetting) {
                MFLogger.m12670d(drf.TAG, "getVariantBaseOnSetting onSuccess microAppId=" + str3 + "major=" + i3 + "minor=" + i4);
                String str = "";
                if (str3.equals(MicroAppID.UAPP_COMMUTE_TIME.getValue())) {
                    CommuteTimeSettings commuteTimeSettings = (CommuteTimeSettings) new cfj().m6205c(microAppSetting.getSetting(), CommuteTimeSettings.class);
                    if (commuteTimeSettings != null) {
                        TIME_FORMAT timeFormat = commuteTimeSettings.getTimeFormat();
                        if (timeFormat == null) {
                            timeFormat = TIME_FORMAT.ETA;
                        }
                        str = timeFormat.getValue();
                    }
                }
                MFLogger.m12670d(drf.TAG, "getVariantBaseOnSetting variant=" + str);
                drf.m9467a(microAppSettingRepository2, str4, str3, str, i3, i4, c3113a3, microAppSetting);
            }

            public void onFail() {
                MFLogger.m12670d(drf.TAG, "getVariantBaseOnSetting onFail microAppId=" + str3 + "major=" + i3 + "minor=" + i4);
                if (str3.equals(MicroAppID.UAPP_GOAL_TRACKING_ID.getValue())) {
                    MicroAppSetting microAppSetting = new MicroAppSetting(str3, new GoalTrackingSettings().toJson());
                    MFLogger.m12670d(drf.TAG, "Inside .getMicroAppSetting, there is no default goal tracking setting, generate one: " + microAppSetting.getSetting());
                    microAppSettingRepository2.addOrUpdateMicroAppSetting(microAppSetting, new C31161(this));
                    drf.m9467a(microAppSettingRepository2, str4, str3, "", i3, i4, c3113a3, microAppSetting);
                    return;
                }
                c3113a2.onFailed(601);
            }
        });
    }

    private static void m9467a(MicroAppSettingRepository microAppSettingRepository, String str, String str2, String str3, int i, int i2, final C3113a c3113a, final MicroAppSetting microAppSetting) {
        microAppSettingRepository.getMicroAppVariant(str, str2, str3, i, i2, new GetVariantCallback() {
            public void onSuccess(MicroAppVariant microAppVariant) {
                MFLogger.m12670d(drf.TAG, "getMicroAppVariant onSuccess");
                c3113a.mo2665a(microAppVariant, microAppSetting);
            }

            public void onFail(int i) {
                MFLogger.m12670d(drf.TAG, "getMicroAppVariant onFailed");
                c3113a.onFailed(i);
            }
        });
    }

    private static Gesture iP(String str) {
        if (str.equals(Pusher.TOP_PUSHER.getValue())) {
            return Gesture.SAM_BT1_SINGLE_PRESS;
        }
        if (str.equals(Pusher.MID_PUSHER.getValue())) {
            return Gesture.SAM_BT2_SINGLE_PRESS;
        }
        return Gesture.SAM_BT3_SINGLE_PRESS;
    }
}
