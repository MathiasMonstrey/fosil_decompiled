package com.fossil;

import android.content.Intent;
import android.os.Bundle;
import com.fossil.ckb.C2126d;
import com.fossil.ckb.C2131a;
import com.fossil.dhh.C2784a;
import com.fossil.dhh.C2785b;
import com.fossil.dhs.C2796a;
import com.fossil.dii.C2797a;
import com.fossil.dip.C2798a;
import com.fossil.diz.C2799a;
import com.fossil.djp.C2849a;
import com.fossil.djp.C2850b;
import com.fossil.dka.C2868a;
import com.fossil.dka.C2869b;
import com.fossil.dka.C2870c;
import com.fossil.dkc.C2872a;
import com.fossil.dkc.C2873b;
import com.fossil.dkg.C2883a;
import com.fossil.dkg.C2884b;
import com.fossil.dkg.C2885c;
import com.fossil.dko.C2905a;
import com.fossil.dko.C2906b;
import com.fossil.fj.C2426a;
import com.misfit.frameworks.buttonservice.communite.CommunicateMode;
import com.misfit.frameworks.buttonservice.log.FailureCode;
import com.misfit.frameworks.buttonservice.model.microapp.MicroAppInstruction.MicroAppID;
import com.misfit.frameworks.common.log.MFLogger;
import com.portfolio.platform.PortfolioApp;
import com.portfolio.platform.data.model.microapp.ActivePreset;
import com.portfolio.platform.data.model.microapp.ButtonMapping;
import com.portfolio.platform.data.model.microapp.CommuteTimeSettings;
import com.portfolio.platform.data.model.microapp.CommuteTimeSettings.TIME_FORMAT;
import com.portfolio.platform.data.model.microapp.MicroApp;
import com.portfolio.platform.data.model.microapp.MicroAppSetting;
import com.portfolio.platform.data.model.microapp.PusherConfiguration.Pusher;
import com.portfolio.platform.data.model.microapp.SecondTimezone;
import com.portfolio.platform.data.source.loader.ActivePresetLoader;
import com.portfolio.platform.data.source.loader.MicroAppSettingsLoader;
import com.portfolio.platform.enums.PermissionCodes;
import java.util.Collections;

public class dhk implements C2784a, C2796a, C2797a, C2798a, C2799a {
    private static final String TAG = dhk.class.getSimpleName();
    private dkc cCM;
    private MicroAppSetting cCl;
    private fj cFC;
    private ActivePresetLoader cOD;
    private dkg cUG;
    private C2426a<ActivePreset> cUJ;
    private boolean cVA;
    private ActivePreset cVB;
    private dir cVg;
    private djb cVh;
    private C2785b cVr;
    private Pusher cVs;
    private djp cVt;
    private dko cVu;
    private dka cVv;
    private boolean cVw;
    private MicroAppSettingsLoader cVx;
    private dik cVy;
    private dhu cVz;
    private MicroApp coG;
    private ckc mUseCaseHandler;

    class C27871 implements C2426a<ActivePreset> {
        final /* synthetic */ dhk cVC;

        C27871(dhk com_fossil_dhk) {
            this.cVC = com_fossil_dhk;
        }

        public gx<ActivePreset> mo2137b(int i, Bundle bundle) {
            MFLogger.m12670d(dhk.TAG, "Inside .onCreateLoader");
            return this.cVC.cOD;
        }

        public void m8678a(gx<ActivePreset> gxVar, ActivePreset activePreset) {
            MFLogger.m12670d(dhk.TAG, "Inside .onLoadFinished loaderId=" + gxVar.getId());
            this.cVC.cVB = activePreset;
            this.cVC.cVr.cU(this.cVC.apd());
        }

        public void mo2129a(gx<ActivePreset> gxVar) {
            MFLogger.m12670d(dhk.TAG, "Inside .onLoaderReset loaderId=" + gxVar.getId());
        }
    }

    class C27882 implements C2426a<MicroAppSetting> {
        final /* synthetic */ dhk cVC;

        C27882(dhk com_fossil_dhk) {
            this.cVC = com_fossil_dhk;
        }

        public gx<MicroAppSetting> mo2137b(int i, Bundle bundle) {
            MFLogger.m12670d(dhk.TAG, "Inside .onCreateLoader id=" + i);
            MFLogger.m12670d(dhk.TAG, "Inside .onCreateLoader microAppId=" + this.cVC.coG.getAppId());
            this.cVC.cVx.setMicroAppId(this.cVC.coG.getAppId());
            return this.cVC.cVx;
        }

        public void m8682a(gx<MicroAppSetting> gxVar, MicroAppSetting microAppSetting) {
            MFLogger.m12670d(dhk.TAG, "Inside .onLoadFinished loaderId=" + gxVar.getId());
            if (microAppSetting == null) {
                MFLogger.m12670d(dhk.TAG, "Inside .onLoadFinished UAPP_UNKNOWN");
                this.cVC.aps();
                return;
            }
            MFLogger.m12670d(dhk.TAG, "Inside .onLoadFinished microAppSetting=" + microAppSetting.getSetting());
            this.cVC.cCl = microAppSetting;
            if (microAppSetting.getSetting() != null) {
                this.cVC.m8719f(this.cVC.cCl);
            }
            this.cVC.cX(this.cVC.apo());
            MicroAppID microAppId = MicroAppID.getMicroAppId(this.cVC.coG.getAppId());
            MFLogger.m12670d(dhk.TAG, "Inside .onLoadFinished appID=" + microAppId.getValue());
            switch (C27958.f1462xb89372e[microAppId.ordinal()]) {
                case 1:
                    this.cVC.mo2481e(microAppSetting);
                    break;
                case 2:
                    this.cVC.iJ(microAppSetting.getSetting());
                    break;
                case 3:
                    this.cVC.iH(microAppSetting.getSetting());
                    break;
                case 4:
                    this.cVC.iI(microAppSetting.getSetting());
                    break;
                default:
                    return;
            }
            this.cVC.cVr.aoW();
        }

        public void mo2129a(gx<MicroAppSetting> gxVar) {
            MFLogger.m12670d(dhk.TAG, "Inside .onLoaderReset loaderId=" + gxVar.getId());
        }
    }

    class C27904 implements C2126d<C2870c, C2868a> {
        final /* synthetic */ dhk cVC;

        C27904(dhk com_fossil_dhk) {
            this.cVC = com_fossil_dhk;
        }

        public /* synthetic */ void onError(Object obj) {
            m8687a((C2868a) obj);
        }

        public /* synthetic */ void onSuccess(Object obj) {
            m8688a((C2870c) obj);
        }

        public void m8688a(C2870c c2870c) {
            MFLogger.m12670d(dhk.TAG, "saveCommuteTimeSettings onSuccess settingJson=" + c2870c.aqu().getSetting());
            this.cVC.cVr.afU();
            if (this.cVC.cVr.aoV() && !this.cVC.apd() && this.cVC.cVr.isActive()) {
                this.cVC.cVr.cU(false);
            }
        }

        public void m8687a(C2868a c2868a) {
            MFLogger.m12670d(dhk.TAG, "saveCommuteTimeSettings onError");
            this.cVC.cVr.afU();
            if (c2868a != null) {
                MFLogger.m12670d(dhk.TAG, "saveCommuteTimeSettings onError errorCode=" + c2868a.getErrorCode());
                switch (c2868a.getErrorCode()) {
                    case 2:
                        int ajg = c2868a.ajg();
                        if (ajg == FailureCode.BLUETOOTH_IS_DISABLED || ajg == FailureCode.LOCATION_SERVICE_DISABLED || ajg == FailureCode.LOCATION_ACCESS_DENIED) {
                            this.cVC.cVr.m7524a((PermissionCodes[]) c2868a.aqG().toArray(new PermissionCodes[0]));
                            if (this.cVC.cVr.isActive()) {
                                this.cVC.cVr.cS(false);
                                return;
                            }
                            return;
                        }
                        this.cVC.cVr.aou();
                        return;
                    case 3:
                        gy.m11536p(PortfolioApp.ZQ()).m11538b(new Intent("BROADCAST_DEVICE_BUSY_OTAING"));
                        return;
                    case 4:
                        this.cVC.cVr.m7524a((PermissionCodes[]) c2868a.aqG().toArray(new PermissionCodes[0]));
                        return;
                    default:
                        this.cVC.cVr.lb(c2868a.getErrorCode());
                        return;
                }
            }
        }
    }

    class C27915 implements C2126d<C2885c, C2883a> {
        final /* synthetic */ dhk cVC;

        C27915(dhk com_fossil_dhk) {
            this.cVC = com_fossil_dhk;
        }

        public /* synthetic */ void onError(Object obj) {
            m8689a((C2883a) obj);
        }

        public /* synthetic */ void onSuccess(Object obj) {
            m8690a((C2885c) obj);
        }

        public void m8690a(C2885c c2885c) {
            MFLogger.m12670d(dhk.TAG, "setMicroAppToDevice onSuccess");
            this.cVC.cVr.cS(true);
            this.cVC.cR(false);
            this.cVC.cVr.afU();
            this.cVC.cVr.cU(true);
            this.cVC.cVr.aoq();
        }

        public void m8689a(C2883a c2883a) {
            MFLogger.m12670d(dhk.TAG, "setMicroAppToDevice onError");
            this.cVC.cVr.cS(false);
            this.cVC.cR(false);
            this.cVC.cVr.afU();
            switch (c2883a.getErrorCode()) {
                case 2:
                    int ajg = c2883a.ajg();
                    if (ajg == FailureCode.BLUETOOTH_IS_DISABLED || ajg == FailureCode.LOCATION_SERVICE_DISABLED || ajg == FailureCode.LOCATION_ACCESS_DENIED) {
                        this.cVC.cVr.m7524a((PermissionCodes[]) c2883a.aqG().toArray(new PermissionCodes[0]));
                        if (this.cVC.cVr.isActive()) {
                            this.cVC.cVr.cS(false);
                            return;
                        }
                        return;
                    }
                    this.cVC.cVr.aou();
                    return;
                case 3:
                    gy.m11536p(PortfolioApp.ZQ()).m11538b(new Intent("BROADCAST_DEVICE_BUSY_OTAING"));
                    return;
                case 4:
                    this.cVC.cVr.m7524a((PermissionCodes[]) c2883a.aqG().toArray(new PermissionCodes[0]));
                    return;
                default:
                    this.cVC.cVr.lb(c2883a.getErrorCode());
                    return;
            }
        }
    }

    class C27926 implements C2126d<C2850b, C2131a> {
        final /* synthetic */ dhk cVC;

        C27926(dhk com_fossil_dhk) {
            this.cVC = com_fossil_dhk;
        }

        public /* synthetic */ void onError(Object obj) {
            m8691a((C2131a) obj);
        }

        public /* synthetic */ void onSuccess(Object obj) {
            m8692a((C2850b) obj);
        }

        public void m8692a(C2850b c2850b) {
            MFLogger.m12670d(dhk.TAG, "getAndShowSettings onSuccess");
            this.cVC.cCl = c2850b.aqv();
            if (c2850b.aqv().getSetting() != null) {
                this.cVC.m8719f(this.cVC.cCl);
            }
            this.cVC.cX(this.cVC.apo());
        }

        public void m8691a(C2131a c2131a) {
            MFLogger.m12670d(dhk.TAG, "getAndShowSettings onError");
            this.cVC.cCl = new MicroAppSetting(this.cVC.coG.getAppId(), "");
            this.cVC.m8719f(this.cVC.cCl);
            this.cVC.cX(this.cVC.apo());
        }
    }

    class C27947 implements C2126d<C2873b, C2131a> {
        final /* synthetic */ dhk cVC;

        class C27931 implements C2126d<C2906b, C2131a> {
            final /* synthetic */ C27947 cVE;

            C27931(C27947 c27947) {
                this.cVE = c27947;
            }

            public /* synthetic */ void onError(Object obj) {
                m8693a((C2131a) obj);
            }

            public /* synthetic */ void onSuccess(Object obj) {
                m8694a((C2906b) obj);
            }

            public void m8694a(C2906b c2906b) {
                MFLogger.m12670d(dhk.TAG, "UpdateLikeInDB onSuccess like=" + c2906b.aqS().getLike());
                this.cVE.cVC.coG = c2906b.aqS();
                this.cVE.cVC.cVr.la(this.cVE.cVC.coG.getLike());
                this.cVE.cVC.cVr.cV(true);
            }

            public void m8693a(C2131a c2131a) {
                MFLogger.m12670d(dhk.TAG, "UpdateLikeInDB onError");
                this.cVE.cVC.cVr.cV(true);
            }
        }

        C27947(dhk com_fossil_dhk) {
            this.cVC = com_fossil_dhk;
        }

        public /* synthetic */ void onError(Object obj) {
            m8695a((C2131a) obj);
        }

        public /* synthetic */ void onSuccess(Object obj) {
            m8696a((C2873b) obj);
        }

        public void m8696a(C2873b c2873b) {
            MFLogger.m12670d(dhk.TAG, "saveSettings onSuccess isLike=" + c2873b.aqu().isLike());
            this.cVC.mUseCaseHandler.m6886a(this.cVC.cVu, new C2905a(this.cVC.coG), new C27931(this));
        }

        public void m8695a(C2131a c2131a) {
            MFLogger.m12670d(dhk.TAG, "saveSettings onError");
            this.cVC.cVr.cV(true);
            int like = this.cVC.coG.getLike();
            if (this.cVC.cCl.isLike()) {
                this.cVC.coG.setLike(like - 1);
            } else {
                this.cVC.coG.setLike(like + 1);
            }
        }
    }

    static /* synthetic */ class C27958 {
        static final /* synthetic */ int[] f1462xb89372e = new int[MicroAppID.values().length];

        static {
            try {
                f1462xb89372e[MicroAppID.UAPP_GOAL_TRACKING_ID.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f1462xb89372e[MicroAppID.UAPP_COMMUTE_TIME.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f1462xb89372e[MicroAppID.UAPP_TIME2_ID.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                f1462xb89372e[MicroAppID.UAPP_RING_PHONE.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
        }
    }

    public dhk(C2785b c2785b, MicroApp microApp, djp com_fossil_djp, dko com_fossil_dko, fj fjVar, ActivePresetLoader activePresetLoader, dkg com_fossil_dkg, dkc com_fossil_dkc, dka com_fossil_dka, MicroAppSettingsLoader microAppSettingsLoader, ckc com_fossil_ckc) {
        this.cVr = (C2785b) emj.ce(c2785b);
        this.coG = (MicroApp) emj.ce(microApp);
        this.cUG = (dkg) emj.m10873f(com_fossil_dkg, "setCommuteApp can not be null");
        this.cCM = (dkc) emj.m10873f(com_fossil_dkc, "saveMicroAppSetting can not be null");
        this.cVt = (djp) emj.ce(com_fossil_djp);
        this.cVu = (dko) emj.ce(com_fossil_dko);
        this.cVv = (dka) emj.ce(com_fossil_dka);
        this.mUseCaseHandler = (ckc) emj.m10873f(com_fossil_ckc, "useCaseHandler can not be null");
        this.cVx = (MicroAppSettingsLoader) emj.m10873f(microAppSettingsLoader, "microAppSettingsLoader can not be null");
        this.cFC = (fj) emj.ce(fjVar);
        this.cOD = (ActivePresetLoader) emj.ce(activePresetLoader);
    }

    public void aoM() {
        this.cUG.ajd();
        this.cVv.ajd();
        MFLogger.m12670d(TAG, "startMicroAppDetails");
        this.cVr.mo2453d(this.coG);
        this.cVr.iC(this.coG.getDescription());
        this.cVr.cV(false);
        PortfolioApp.ZQ().m12685I(Collections.singletonList(CommunicateMode.SET_LINK_MAPPING));
        if (this.cUJ == null) {
            this.cUJ = new C27871(this);
        }
        this.cFC.mo3100a(26, null, this.cUJ);
        this.cFC.mo3100a(27, null, new C27882(this));
    }

    public void aoN() {
        MFLogger.m12670d(TAG, "onSetToWatchClick");
        cR(true);
        cmj.bs(PortfolioApp.ZQ()).m7086l("microapp_set_to_watch", "App", this.coG.getAppId());
        if (apo()) {
            MFLogger.m12670d(TAG, "onSetToWatchClick isSettingDataAvailable true");
            if (this.cVs != null) {
                ape();
                return;
            } else {
                this.cVr.aoT();
                return;
            }
        }
        MFLogger.m12670d(TAG, "onSetToWatchClick isSettingDataAvailable false");
        if (!this.cVA) {
            this.cVr.aoU();
            this.cVA = true;
        }
    }

    public void apc() {
        MFLogger.m12670d(TAG, "saveSettings");
        switch (C27958.f1462xb89372e[MicroAppID.getMicroAppId(this.coG.getAppId()).ordinal()]) {
            case 2:
                MFLogger.m12670d(TAG, "saveSettings UAPP_COMMUTE_TIME");
                m8704a(this.cVz.apC());
                return;
            case 3:
                MFLogger.m12670d(TAG, "saveSettings UAPP_TIME2_ID");
                iG(this.cVh.apW());
                return;
            case 4:
                MFLogger.m12670d(TAG, "saveSettings UAPP_RING_PHONE");
                iG(this.cVg.apW());
                return;
            default:
                ape();
                return;
        }
    }

    private void iG(final String str) {
        MFLogger.m12670d(TAG, "saveSettings settingJson=" + str);
        this.cCl.setSetting(str);
        this.mUseCaseHandler.m6886a(this.cCM, new C2872a(this.cCl), new C2126d<C2873b, C2131a>(this) {
            final /* synthetic */ dhk cVC;

            public /* synthetic */ void onError(Object obj) {
                m8685a((C2131a) obj);
            }

            public /* synthetic */ void onSuccess(Object obj) {
                m8686a((C2873b) obj);
            }

            public void m8686a(C2873b c2873b) {
                MFLogger.m12670d(dhk.TAG, "saveSettings onSuccess settingJson=" + str);
                if (this.cVC.cVr.aoV() && !this.cVC.apd()) {
                    this.cVC.cVr.cU(false);
                }
            }

            public void m8685a(C2131a c2131a) {
                MFLogger.m12670d(dhk.TAG, "saveSettings onError settingJson=" + str);
            }
        });
    }

    private void m8704a(CommuteTimeSettings commuteTimeSettings) {
        MFLogger.m12670d(TAG, "saveCommuteTimeSettings destination=" + commuteTimeSettings.getDestination() + " timeFormat=" + commuteTimeSettings.getTimeFormat().getValue());
        this.cVr.afT();
        this.mUseCaseHandler.m6886a(this.cVv, new C2869b(commuteTimeSettings), new C27904(this));
    }

    private boolean apd() {
        if (this.cVB != null) {
            for (ButtonMapping microAppId : this.cVB.getButtonMappingList()) {
                if (microAppId.getMicroAppId().equals(this.coG.getAppId())) {
                    return true;
                }
            }
        }
        return false;
    }

    public void aoI() {
        this.cUG.aje();
        this.cVv.aje();
        if (this.cFC.aN(26) != null) {
            this.cFC.destroyLoader(26);
        }
        if (this.cFC.aN(27) != null) {
            this.cFC.destroyLoader(27);
        }
    }

    public void ahu() {
        MFLogger.m12670d(TAG, "setupListeners");
    }

    public void m8716c(MicroApp microApp) {
        MFLogger.m12670d(TAG, "setMicroApp action=" + microApp.getAppId());
        if (!this.cVw) {
            this.coG = microApp;
            if (this.cFC.aN(27) != null) {
                this.cFC.destroyLoader(27);
            }
        }
    }

    public void ape() {
        MFLogger.m12670d(TAG, "setMicroAppToDevice()");
        if (this.cVs != null) {
            MFLogger.m12670d(TAG, "setMicroAppToDevice pusher=" + this.cVs.getValue());
            this.cVr.afT();
            this.mUseCaseHandler.m6886a(this.cUG, new C2884b(PortfolioApp.ZQ().aaa(), this.coG.getAppId(), this.cVs), new C27915(this));
        }
    }

    public void apf() {
        this.cVy.apf();
    }

    public void apg() {
        this.cVy.apg();
    }

    public void aph() {
        this.cVy.aph();
    }

    public void api() {
        this.cVy.api();
    }

    public void apj() {
        this.cVy.apj();
    }

    public void apk() {
        this.cVz.apk();
    }

    public void apl() {
        this.cVz.apl();
    }

    public void setDestination(String str) {
        this.cVz.setDestination(str);
    }

    public void apm() {
        this.cVh.apm();
    }

    public void apn() {
        this.cVh.apn();
    }

    public boolean apo() {
        MFLogger.m12670d(TAG, "isSettingDataAvailable mMicroAppId=" + this.coG.getAppId());
        switch (C27958.f1462xb89372e[MicroAppID.getMicroAppId(this.coG.getAppId()).ordinal()]) {
            case 1:
                return this.cVy.apo();
            case 2:
                return this.cVz.apo();
            case 3:
                return this.cVh.apo();
            case 4:
                return this.cVg.apo();
            default:
                return true;
        }
    }

    public void iH(String str) {
        this.cVh.iH(str);
    }

    public void app() {
        this.cVh.app();
    }

    public void mo2479b(SecondTimezone secondTimezone) {
        this.cVh.mo2479b(secondTimezone);
    }

    public void apq() {
        this.cVg.apq();
    }

    public void ld(int i) {
        this.cVg.ld(i);
    }

    public void le(int i) {
        this.cVg.le(i);
    }

    public void apr() {
        this.cVg.apr();
    }

    public void iI(String str) {
        this.cVg.iI(str);
    }

    public void mo2481e(MicroAppSetting microAppSetting) {
        this.cVy.mo2481e(microAppSetting);
    }

    public void iJ(String str) {
        this.cVz.iJ(str);
    }

    public void cW(boolean z) {
        this.cVz.cW(z);
    }

    public void mo2463a(TIME_FORMAT time_format) {
        this.cVz.mo2463a(time_format);
    }

    public boolean lM() {
        return this.cVr.lM();
    }

    public void onSaveInstanceState(Bundle bundle) {
        this.cVz.onSaveInstanceState(bundle);
    }

    public void onActivityCreated(Bundle bundle) {
        this.cVz.onActivityCreated(bundle);
    }

    public void cR(boolean z) {
        MFLogger.m12670d(TAG, "setIsSetToWatch isSelectedButton=" + z);
        this.cVw = z;
    }

    public boolean aoK() {
        return this.cVw;
    }

    public void mo2408a(dik com_fossil_dik, dhu com_fossil_dhu, dir com_fossil_dir, djb com_fossil_djb) {
        MFLogger.m12670d(TAG, "setupPresenter");
        this.cVz = com_fossil_dhu;
        this.cVg = com_fossil_dir;
        this.cVh = com_fossil_djb;
        this.cVy = com_fossil_dik;
    }

    public void mo2435e(Pusher pusher) {
        MFLogger.m12670d(TAG, "setPusher");
        this.cVs = pusher;
    }

    public void aps() {
        MFLogger.m12670d(TAG, "getAndShowSettings");
        this.mUseCaseHandler.m6886a(this.cVt, new C2849a(this.coG.getAppId()), new C27926(this));
    }

    private void cX(boolean z) {
        MFLogger.m12670d(TAG, "initMicroAppDetails isSettingsAvailable=" + z);
        if (z) {
            if (this.cVw) {
                this.cVr.cU(false);
                if (this.cVs != null) {
                    ape();
                } else if (!this.cVr.aoX()) {
                    cR(false);
                }
            }
            this.cVr.cV(true);
            return;
        }
        if (this.cVw) {
            this.cVr.cU(true);
            switch (C27958.f1462xb89372e[MicroAppID.getMicroAppId(this.coG.getAppId()).ordinal()]) {
                case 2:
                case 3:
                case 4:
                    if (!this.cVA) {
                        this.cVr.aoU();
                        this.cVA = true;
                        break;
                    }
                    break;
                default:
                    if (this.cVs != null) {
                        ape();
                        break;
                    }
                    break;
            }
        }
        this.cVr.cV(true);
    }

    public void cQ(boolean z) {
        switch (C27958.f1462xb89372e[MicroAppID.getMicroAppId(this.coG.getAppId()).ordinal()]) {
            case 1:
                this.cVy.cZ(z);
                this.cVy.apg();
                return;
            default:
                return;
        }
    }

    public void m8719f(MicroAppSetting microAppSetting) {
        if (microAppSetting != null) {
            MFLogger.m12670d(TAG, "showMicroAppSettingsFragment settings=" + microAppSetting.getSetting() + " isViewAlive=" + this.cVr.isAlive());
            this.cVr.la(this.coG.getLike());
            this.cVr.cT(microAppSetting.isLike());
            if (this.cVr.isActive() && this.cVr.isAlive()) {
                switch (C27958.f1462xb89372e[MicroAppID.getMicroAppId(this.coG.getAppId()).ordinal()]) {
                    case 1:
                        this.cVr.mo2454d(microAppSetting);
                        return;
                    case 2:
                        this.cVr.iD(microAppSetting.getSetting());
                        return;
                    case 3:
                        this.cVr.iF(microAppSetting.getSetting());
                        return;
                    case 4:
                        this.cVr.iE(microAppSetting.getSetting());
                        return;
                    default:
                        this.cVr.aoS();
                        return;
                }
            }
        }
    }

    public void aoO() {
        MFLogger.m12670d(TAG, "updateLike");
        this.cCl.setLike(!this.cCl.isLike());
        this.cVr.cV(false);
        cmj.bs(PortfolioApp.ZQ()).m7086l("microapp_like", "App", this.coG.getAppId());
        int like = this.coG.getLike();
        if (this.cCl.isLike()) {
            this.coG.setLike(like + 1);
        } else {
            this.coG.setLike(like - 1);
        }
        this.mUseCaseHandler.m6886a(this.cCM, new C2872a(this.cCl), new C27947(this));
    }

    public void apt() {
        this.cVg.apt();
    }

    public void apu() {
        this.cVg.apr();
        this.cVh.apn();
        this.cVz.apl();
    }

    public void apv() {
        this.cVy.apv();
    }

    public void aom() {
    }

    public void aoP() {
        if (this.cVs != null) {
            this.cVs = null;
        }
        if (this.cVw) {
            cR(false);
        }
        if (this.cVr.isAlive()) {
            this.cVr.aoP();
        }
    }

    public dhk aoQ() {
        return null;
    }

    public void aoo() {
    }

    public void aop() {
    }

    public void aon() {
    }

    public void aoq() {
    }

    public void aoJ() {
        this.cVA = false;
    }
}
