package com.fossil;

import android.content.Context;
import android.os.Handler;
import android.text.TextUtils;
import com.facebook.appevents.AppEventsConstants;
import com.fossil.ctd.C2288a;
import com.fossil.wearables.fossil.R;
import com.fossil.wearables.fsl.appfilter.AppFilter;
import com.fossil.wearables.fsl.contact.Contact;
import com.fossil.wearables.fsl.contact.ContactGroup;
import com.fossil.wearables.fsl.contact.PhoneNumber;
import com.misfit.frameworks.buttonservice.enums.MFDeviceFamily;
import com.misfit.frameworks.buttonservice.model.Mapping;
import com.misfit.frameworks.buttonservice.model.microapp.MicroAppInstruction.MicroAppID;
import com.misfit.frameworks.common.log.MFLogger;
import com.portfolio.platform.PortfolioApp;
import com.portfolio.platform.data.AppType;
import com.portfolio.platform.data.model.DeviceModel;
import com.portfolio.platform.data.model.MFUser;
import com.portfolio.platform.data.model.Ringtone;
import com.portfolio.platform.data.model.microapp.ActivePreset;
import com.portfolio.platform.data.model.microapp.MappingSet;
import com.portfolio.platform.data.model.microapp.MappingSet.MappingSetType;
import com.portfolio.platform.data.model.microapp.MicroAppSetting;
import com.portfolio.platform.data.model.microapp.RecommendedPreset;
import com.portfolio.platform.data.model.microapp.SavedPreset;
import com.portfolio.platform.data.model.microapp.SecondTimezone;
import com.portfolio.platform.data.source.DataVersioningRepository;
import com.portfolio.platform.data.source.LandingPageRepository;
import com.portfolio.platform.data.source.MicroAppSettingDataSource.MicroAppSettingCallback;
import com.portfolio.platform.data.source.MicroAppSettingRepository;
import com.portfolio.platform.data.source.NotificationsRepository;
import com.portfolio.platform.data.source.PresetDataSource.AddOrUpdateActivePresetCallback;
import com.portfolio.platform.data.source.PresetDataSource.AddOrUpdateSavedPresetCallback;
import com.portfolio.platform.data.source.PresetDataSource.GetActivePresetCallback;
import com.portfolio.platform.data.source.PresetDataSource.GetRecommendedPresetCallback;
import com.portfolio.platform.data.source.PresetRepository;
import com.portfolio.platform.data.source.UserRepository;
import com.portfolio.platform.helper.DeviceHelper;
import java.util.ArrayList;
import java.util.List;

public class cnn {
    private static final String TAG = cnn.class.getSimpleName();
    private static cnn czm;
    cnr czn;
    ckc czo;
    NotificationsRepository czp;
    ctd czq;
    DataVersioningRepository czr;
    private Handler mHandler;
    LandingPageRepository mLandingPageRepository;
    MicroAppSettingRepository mMicroAppSettingRepository;
    PresetRepository mPresetRepository;
    UserRepository mUserRepository;

    static /* synthetic */ class C22303 {
        static final /* synthetic */ int[] f1456xb89372e = new int[MicroAppID.values().length];

        static {
            try {
                f1456xb89372e[MicroAppID.UAPP_RING_PHONE.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
        }
    }

    cnn() {
        PortfolioApp.ZQ().aam().mo1831a(this);
    }

    public static synchronized cnn abZ() {
        cnn com_fossil_cnn;
        synchronized (cnn.class) {
            if (czm == null) {
                czm = new cnn();
            }
            com_fossil_cnn = czm;
        }
        return com_fossil_cnn;
    }

    public void aca() {
        this.mHandler = new Handler();
        String adf = this.czn.adf();
        final String aaf = PortfolioApp.ZQ().aaf();
        Context ZQ = PortfolioApp.ZQ();
        MFLogger.m12670d(TAG, "Inside .startUpgrade start migration flow for appVersion=" + aaf + ", from version=" + adf);
        try {
            if (TextUtils.isEmpty(adf) || !adf.equalsIgnoreCase(aaf)) {
                if (TextUtils.isEmpty(adf) || cmv.ar(adf, "2.0.0") == -1) {
                    if (this.mUserRepository.getCurrentUser() == null && !TextUtils.isEmpty(dqz.aum().cp(ZQ))) {
                        MFLogger.m12670d(TAG, "Inside .onReceive start migration user...");
                        this.czn.setUserAccessToken(dqz.aum().cp(ZQ));
                        MFUser mFUser = new MFUser();
                        mFUser.setUserAccessToken(dqz.aum().cp(ZQ));
                        mFUser.setUserId(dqz.aum().co(ZQ));
                        mFUser.setObjectId(dqz.aum().cn(ZQ));
                        mFUser.setRegisterDate(dqz.aum().cd(ZQ));
                        mFUser.setHref(dqz.aum().bT(ZQ));
                        mFUser.setFirstName(dqz.aum().cl(ZQ));
                        mFUser.setLastName(dqz.aum().cm(ZQ));
                        mFUser.setCreatedAt(dqz.aum().bU(ZQ));
                        mFUser.setUpdatedAt(dqz.aum().bV(ZQ));
                        mFUser.setEmail(dqz.aum().bY(ZQ));
                        mFUser.setAuthType(dqz.aum().cf(ZQ));
                        try {
                            if (TextUtils.isEmpty(dqz.aum().ca(ZQ))) {
                                mFUser.setWeightInGrams(0);
                            } else {
                                mFUser.setWeightInGrams(Integer.valueOf(dqz.aum().ca(ZQ)).intValue());
                            }
                            if (TextUtils.isEmpty(dqz.aum().bZ(ZQ))) {
                                mFUser.setHeightInCentimeters(0);
                            } else {
                                mFUser.setHeightInCentimeters(Integer.valueOf(dqz.aum().bZ(ZQ)).intValue());
                            }
                            if (TextUtils.isEmpty(dqz.aum().cc(ZQ))) {
                                mFUser.setRegistrationComplete(true);
                            } else {
                                mFUser.setRegistrationComplete(Boolean.valueOf(dqz.aum().cc(ZQ)).booleanValue());
                            }
                        } catch (Exception e) {
                            abm.m2872a(0, TAG, "Exception when parse weight, height... e=" + e + ", keep going to migrate other data");
                        }
                        mFUser.setDistanceUnit(dqz.aum().cj(ZQ));
                        mFUser.setHeightUnit(dqz.aum().ch(ZQ));
                        mFUser.setWeightUnit(dqz.aum().ci(ZQ));
                        mFUser.setBirthday(dqz.aum().ck(ZQ));
                        mFUser.setGender(dqz.aum().cg(ZQ).toString());
                        mFUser.setProfilePicture(dqz.aum().cb(ZQ));
                        mFUser.setOnboardingComplete(dqz.aum().cq(ZQ));
                        mFUser.setIntegrations(dqz.aum().ce(ZQ));
                        mFUser.setEmailProgress(dqz.aum().bX(ZQ));
                        mFUser.setEmailOptIn(dqz.aum().bW(ZQ));
                        mFUser.setDiagnosticEnabled(dqz.aum().cr(ZQ));
                        mFUser.setActiveDeviceId(this.czn.adg());
                        this.mUserRepository.addOrUpdateUser(mFUser, null);
                        acb();
                    }
                    if (!TextUtils.isEmpty(this.czn.adg())) {
                        MFLogger.m12670d(TAG, "Inside .onReceive migration activeSerial=" + this.czn.adg());
                        this.czn.gx(this.czn.adg());
                    }
                    MFLogger.m12670d(TAG, "Migration device with userID=" + dqz.aum().co(ZQ));
                    if (!TextUtils.isEmpty(dqz.aum().co(ZQ))) {
                        cnq.acd().gw(dqz.aum().co(ZQ)).hd(this.czn.adg());
                    }
                    this.mHandler.postDelayed(new Runnable(this) {
                        final /* synthetic */ cnn czt;

                        class C22241 implements AddOrUpdateSavedPresetCallback {
                            final /* synthetic */ C22281 czu;

                            C22241(C22281 c22281) {
                                this.czu = c22281;
                            }

                            public void onSuccess(SavedPreset savedPreset) {
                                MFLogger.m12670d(cnn.TAG, "addOrUpdateSavedPreset onSuccess savedPresetId=" + savedPreset.getId() + "buttons=" + savedPreset.getButtons());
                            }

                            public void onFail() {
                                MFLogger.m12670d(cnn.TAG, "addOrUpdateSavedPreset onFail");
                            }
                        }

                        class C22252 implements AddOrUpdateActivePresetCallback {
                            final /* synthetic */ C22281 czu;

                            C22252(C22281 c22281) {
                                this.czu = c22281;
                            }

                            public void onSuccess(ActivePreset activePreset) {
                            }

                            public void onFail() {
                            }
                        }

                        class C22273 implements GetRecommendedPresetCallback {
                            final /* synthetic */ C22281 czu;

                            class C22261 implements GetActivePresetCallback {
                                final /* synthetic */ C22273 czv;

                                C22261(C22273 c22273) {
                                    this.czv = c22273;
                                }

                                public void onSuccess(ActivePreset activePreset) {
                                    MFLogger.m12670d(cnn.TAG, "activateDefaultPreset onSuccess");
                                }

                                public void onFail() {
                                    MFLogger.m12670d(cnn.TAG, "activateDefaultPreset onFail");
                                }
                            }

                            C22273(C22281 c22281) {
                                this.czu = c22281;
                            }

                            public void onSuccess(RecommendedPreset recommendedPreset) {
                                MFLogger.m12670d(cnn.TAG, "getDefaultPreset onSuccess");
                                this.czu.czt.mPresetRepository.activateDefaultPreset(recommendedPreset, new C22261(this));
                            }

                            public void onFail() {
                                MFLogger.m12670d(cnn.TAG, "getDefaultPreset onFail");
                            }
                        }

                        public void run() {
                            MFLogger.m12670d(cnn.TAG, "-------------------7 keep going");
                            cnq.acd().ack().getAllContactGroups();
                            cnq.acd().acm().getAllAppFilters();
                            this.czt.czn.cb(this.czt.czn.adh());
                            this.czt.czn.gO(cnq.acd().acA().getSharedPreferenceString(PortfolioApp.ZQ(), "u56n_45nt", ""));
                            this.czt.czn.gP(cnq.acd().acA().getSharedPreferenceString(PortfolioApp.ZQ(), "eh4j_fg34", ""));
                            this.czt.mLandingPageRepository.refreshLandingPage();
                            cok acp = cnq.acd().acp();
                            List<MappingSet> a = acp.mo1943a(MappingSetType.USER_SAVED);
                            if (!(a == null || a.isEmpty())) {
                                MFLogger.m12670d(cnn.TAG, "getMappingSetByType size=" + a.size());
                                for (MappingSet convertToSavedPreset : a) {
                                    SavedPreset convertToSavedPreset2 = convertToSavedPreset.convertToSavedPreset();
                                    if (convertToSavedPreset2 != null) {
                                        this.czt.mPresetRepository.addOrUpdateSavedPreset(convertToSavedPreset2, new C22241(this));
                                    }
                                }
                            }
                            List<DeviceModel> adS = acp.adS();
                            MFLogger.m12670d(cnn.TAG, "deviceList size=" + (a != null ? Integer.valueOf(a.size()) : AppEventsConstants.EVENT_PARAM_VALUE_NO) + " of device provider path=" + acp.getDbPath());
                            this.czt.czn.m7251r(this.czt.czn.adg(), true);
                            for (DeviceModel deviceModel : adS) {
                                this.czt.czn.m7251r(deviceModel.getDeviceId(), true);
                                MappingSet a2 = acp.mo1941a(MFDeviceFamily.getDeviceFamily(deviceModel.getDeviceId()));
                                MFLogger.m12670d(cnn.TAG, "Check active preset of device=" + deviceModel.getDeviceId() + ", activePreset=" + a2);
                                if (a2 != null) {
                                    List<Mapping> mappingList = a2.getMappingList();
                                    MFLogger.m12670d(cnn.TAG, "Mapping list=" + mappingList);
                                    ActivePreset convertToActivePreset = a2.convertToActivePreset(deviceModel.getDeviceId());
                                    MFLogger.m12670d(cnn.TAG, "Convert active mapping set to active preset, activePreset=" + convertToActivePreset);
                                    if (convertToActivePreset != null) {
                                        this.czt.mPresetRepository.addOrUpdateActivePreset(convertToActivePreset, new C22252(this));
                                    } else {
                                        MFLogger.m12670d(cnn.TAG, "mapping set contains alarm");
                                        this.czt.mPresetRepository.getDefaultPreset(deviceModel.getDeviceId(), new C22273(this), true);
                                    }
                                    for (Mapping mapping : mappingList) {
                                        MicroAppID lz = drb.lz(mapping.getAction());
                                        if (lz != null) {
                                            switch (C22303.f1456xb89372e[lz.ordinal()]) {
                                                case 1:
                                                    String extraInfo = mapping.getExtraInfo();
                                                    if (!extraInfo.contains("{")) {
                                                        Ringtone ringtone = new Ringtone(extraInfo);
                                                        MicroAppSetting microAppSetting = new MicroAppSetting(MicroAppID.UAPP_RING_PHONE.getValue());
                                                        microAppSetting.setSetting(new cfj().m6204b(ringtone, Ringtone.class));
                                                        this.czt.m7223a(microAppSetting);
                                                        break;
                                                    }
                                                    break;
                                                default:
                                                    break;
                                            }
                                        }
                                    }
                                }
                                SecondTimezone aeM = cnq.acd().acx().aeM();
                                if (aeM != null) {
                                    MicroAppSetting microAppSetting2 = new MicroAppSetting(MicroAppID.UAPP_TIME2_ID.getValue());
                                    microAppSetting2.setSetting(new cfk().Wt().Wu().m6204b(aeM, SecondTimezone.class));
                                    this.czt.m7223a(microAppSetting2);
                                }
                            }
                            List<AppFilter> allAppFilters = cnq.acd().acm().getAllAppFilters();
                            List<AppFilter> arrayList = new ArrayList();
                            if (!(allAppFilters == null || allAppFilters.isEmpty())) {
                                for (AppFilter appFilter : allAppFilters) {
                                    if (AppType.ALL_CALLS.name().equalsIgnoreCase(appFilter.getType()) || AppType.ALL_SMS.name().equalsIgnoreCase(appFilter.getType())) {
                                        MFLogger.m12670d(cnn.TAG, "Add app filter=" + appFilter.getName());
                                        arrayList.add(appFilter);
                                        this.czt.czp.removeAppFilter(appFilter);
                                    }
                                }
                            }
                            if (!arrayList.isEmpty()) {
                                for (AppFilter appFilter2 : arrayList) {
                                    ContactGroup contactGroup = new ContactGroup();
                                    contactGroup.setDeviceFamily(MFDeviceFamily.DEVICE_FAMILY_SAM.getValue());
                                    contactGroup.setHour(appFilter2.getHour());
                                    this.czt.czp.saveContactGroup(contactGroup);
                                    MFLogger.m12670d(cnn.TAG, "Save contact group=" + contactGroup);
                                    Contact contact = new Contact();
                                    PhoneNumber phoneNumber = new PhoneNumber();
                                    if (PortfolioApp.ZQ().getString(AppType.ALL_CALLS.getAppResId()).equalsIgnoreCase(appFilter2.getName())) {
                                        contact.setContactId(-100);
                                        contact.setFirstName(PortfolioApp.ZQ().getResources().getString(R.string.all_call));
                                        contact.setUseCall(true);
                                        phoneNumber.setNumber("-1234");
                                    }
                                    if (PortfolioApp.ZQ().getString(AppType.ALL_SMS.getAppResId()).equalsIgnoreCase(appFilter2.getName())) {
                                        contact.setContactId(-200);
                                        contact.setFirstName(PortfolioApp.ZQ().getResources().getString(R.string.all_text));
                                        contact.setUseSms(true);
                                        phoneNumber.setNumber("-5678");
                                    }
                                    MFLogger.m12670d(cnn.TAG, "Save contact=" + contact);
                                    MFLogger.m12670d(cnn.TAG, "Save phone number=" + phoneNumber);
                                    contact.setContactGroup(contactGroup);
                                    this.czt.czp.saveContact(contact);
                                    phoneNumber.setContact(contact);
                                    this.czt.czp.savePhoneNumber(phoneNumber);
                                }
                            }
                            cnn.m7224b(this.czt.czn);
                            MFLogger.m12670d(cnn.TAG, "Migration complete for app version=" + aaf);
                            this.czt.czn.gR(aaf);
                            this.czt.czn.m7242a(true, aaf);
                        }
                    }, 2000);
                    this.czn.jH(this.czn.acX());
                    this.czn.gL(this.czn.acV());
                }
                if (TextUtils.isEmpty(adf) || cmv.ar(adf, "2.0.2") == -1) {
                    MFLogger.m12670d(TAG, "Inside .MigrationManager, start migration flow for 2.0.2");
                    cnq.acd().ack().getAllContactGroups();
                }
                if (TextUtils.isEmpty(adf) || cmv.ar(adf, "2.1.0") == -1) {
                    MFLogger.m12670d(TAG, "Inside .MigrationManager, start migration flow for 2.1.0");
                    this.czr.removeDataVersion("firmwares");
                }
                if (TextUtils.isEmpty(adf) || cmv.ar(adf, "2.1.1") == -1) {
                    MFLogger.m12670d(TAG, "Inside .MigrationManager, start migration flow for 2.1.1");
                    this.czr.removeDataVersion("micro-apps");
                }
                this.czn.gR(aaf);
                this.czn.m7242a(true, aaf);
                return;
            }
            this.czn.gR(aaf);
            this.czn.m7242a(true, aaf);
        } catch (Exception e2) {
            MFLogger.m12671e(TAG, "Exception when start upgrade from version=" + adf + ", to version=" + aaf + ", exception=" + e2);
            abm.m2872a(0, TAG, "Exception when migration e=" + e2);
        }
    }

    public static void m7224b(cnr com_fossil_cnr) {
        List<DeviceModel> adS = cnq.acd().acp().adS();
        String aaa = PortfolioApp.ZQ().aaa();
        MFLogger.m12670d(TAG, "migrationDeviceData - allDevices=" + adS + ", activeSerial=" + aaa);
        try {
            boolean z = (TextUtils.isEmpty(aaa) || DeviceHelper.gf(aaa)) ? false : true;
            if (z) {
                com_fossil_cnr.gx("");
                com_fossil_cnr.ce(true);
            }
            if (adS != null && !adS.isEmpty()) {
                for (DeviceModel deviceModel : adS) {
                    if (!(deviceModel == null || TextUtils.isEmpty(deviceModel.getDeviceId()))) {
                        String deviceId = deviceModel.getDeviceId();
                        MFLogger.m12670d(TAG, "migrationDeviceData - step1: deviceId=" + deviceId + ", deviceAddress=" + deviceModel.getMacAddress());
                        if (!DeviceHelper.gf(deviceModel.getDeviceId())) {
                            cnq.acd().acp().he(deviceId);
                        }
                    }
                }
                if (z) {
                    PortfolioApp.ZR().removeActiveSerial(aaa);
                }
                for (DeviceModel deviceModel2 : adS) {
                    if (!(deviceModel2 == null || TextUtils.isEmpty(deviceModel2.getDeviceId()))) {
                        MFLogger.m12670d(TAG, "migrationDeviceData - step2: - deviceId=" + deviceModel2.getDeviceId() + ", deviceAddress=" + deviceModel2.getMacAddress());
                        if (DeviceHelper.gf(deviceModel2.getDeviceId())) {
                            PortfolioApp.ZR().setPairedSerial(deviceModel2.getDeviceId(), deviceModel2.getMacAddress());
                            if (deviceModel2.getDeviceId().equalsIgnoreCase(aaa)) {
                                PortfolioApp.ZQ().an(deviceModel2.getDeviceId(), deviceModel2.getMacAddress());
                            }
                        } else {
                            PortfolioApp.ZR().removePairedSerial(deviceModel2.getDeviceId());
                        }
                    }
                }
                com_fossil_cnr.cf(false);
            }
        } catch (Exception e) {
            MFLogger.m12671e(TAG, "migrationDeviceData - Exception when upgrade to 1.14.0 version e=" + e);
            e.printStackTrace();
            com_fossil_cnr.cf(true);
        }
    }

    private void m7223a(final MicroAppSetting microAppSetting) {
        this.mMicroAppSettingRepository.addOrUpdateMicroAppSetting(microAppSetting, new MicroAppSettingCallback(this) {
            final /* synthetic */ cnn czt;

            public void onSuccess(MicroAppSetting microAppSetting) {
                MFLogger.m12670d(cnn.TAG, "addOrUpdateMicroAppSetting onSuccess settings=" + microAppSetting.getSetting());
            }

            public void onFail() {
                MFLogger.m12670d(cnn.TAG, "addOrUpdateMicroAppSetting onFail settings=" + microAppSetting.getSetting());
            }
        });
    }

    private void acb() {
        this.czo.m6886a(this.czq, new C2288a(), null);
    }
}
