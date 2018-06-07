package com.fossil;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.text.TextUtils;
import com.fasterxml.jackson.core.util.MinimalPrettyPrinter;
import com.fossil.ckb.C2126d;
import com.fossil.ckb.C2131a;
import com.fossil.ckb.C2133c;
import com.fossil.dha.C2763a;
import com.fossil.dha.C2764b;
import com.fossil.dhh.C2784a;
import com.fossil.dje.C2822a;
import com.fossil.djm.C2843a;
import com.fossil.djm.C2844b;
import com.fossil.dju.C2854a;
import com.fossil.dju.C2855b;
import com.fossil.djy.C2858a;
import com.fossil.djy.C2859b;
import com.fossil.dke.C2875a;
import com.fossil.dke.C2876b;
import com.fossil.dkg.C2883a;
import com.fossil.dkg.C2884b;
import com.fossil.dkg.C2885c;
import com.fossil.dki.C2891a;
import com.fossil.dki.C2892b;
import com.fossil.dki.C2893c;
import com.fossil.dkm.C2901a;
import com.fossil.dkm.C2902b;
import com.fossil.dkm.C2903c;
import com.fossil.fj.C2426a;
import com.google.gson.JsonSyntaxException;
import com.misfit.frameworks.buttonservice.communite.CommunicateMode;
import com.misfit.frameworks.buttonservice.log.FailureCode;
import com.misfit.frameworks.buttonservice.model.microapp.MicroAppInstruction.MicroAppID;
import com.misfit.frameworks.common.constants.Constants;
import com.misfit.frameworks.common.log.MFLogger;
import com.portfolio.platform.PortfolioApp;
import com.portfolio.platform.data.model.microapp.ActivePreset;
import com.portfolio.platform.data.model.microapp.ButtonMapping;
import com.portfolio.platform.data.model.microapp.CommuteTimeSettings;
import com.portfolio.platform.data.model.microapp.MicroApp;
import com.portfolio.platform.data.model.microapp.MicroAppSetting;
import com.portfolio.platform.data.model.microapp.PusherConfiguration.Pusher;
import com.portfolio.platform.data.model.microapp.RecommendedPreset;
import com.portfolio.platform.data.model.microapp.SavedPreset;
import com.portfolio.platform.data.model.microapp.SavedPreset.MappingSetType;
import com.portfolio.platform.data.source.loader.ActivePresetLoader;
import com.portfolio.platform.data.source.loader.MicroAppSettingListLoader;
import com.portfolio.platform.data.source.loader.SavedPresetListLoader;
import com.portfolio.platform.enums.PermissionCodes;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class dhd implements C2763a, C2784a, C2426a<List<SavedPreset>> {
    static final /* synthetic */ boolean $assertionsDisabled = (!dhd.class.desiredAssertionStatus());
    private static final String TAG = dhd.class.getSimpleName();
    private final gy cEa;
    private ActivePreset cEs;
    private fj cFC;
    private final BroadcastReceiver cFN = new C27751(this);
    private int cFa;
    private ActivePresetLoader cOD;
    private djy cUA;
    private dke cUB;
    private dki cUC;
    private djm cUD;
    private dje cUE;
    private dju cUF;
    private dkg cUG;
    private dkm cUH;
    private SavedPresetListLoader cUI;
    private C2426a<ActivePreset> cUJ;
    private boolean cUK;
    private MicroAppSettingListLoader cUL;
    private boolean cUM = true;
    private boolean cUN;
    private dhk cUo;
    private C2764b cUw;
    private List<SavedPreset> cUx;
    private List<RecommendedPreset> cUy;
    private List<MicroAppSetting> cUz;
    private List<MicroApp> mMicroAppList;
    cnr mSharedPreferencesManager;
    private ckc mUseCaseHandler;

    class C27751 extends BroadcastReceiver {
        final /* synthetic */ dhd cUO;

        C27751(dhd com_fossil_dhd) {
            this.cUO = com_fossil_dhd;
        }

        public void onReceive(Context context, Intent intent) {
            String stringExtra = intent.getStringExtra("SERIAL");
            if (!TextUtils.isEmpty(stringExtra) && stringExtra.equalsIgnoreCase(PortfolioApp.ZQ().aaa())) {
                MFLogger.m12670d(dhd.TAG, "Inside .syncReceiver syncResult=" + intent.getIntExtra("sync_result", 3) + ",  serial=" + stringExtra);
                this.cUO.cUw.cD(false);
            }
        }
    }

    class C27762 implements C2126d<C2133c, C2131a> {
        final /* synthetic */ dhd cUO;

        C27762(dhd com_fossil_dhd) {
            this.cUO = com_fossil_dhd;
        }

        public /* synthetic */ void onError(Object obj) {
            m8609a((C2131a) obj);
        }

        public /* synthetic */ void onSuccess(Object obj) {
            m8610a((C2133c) obj);
        }

        public void m8610a(C2133c c2133c) {
            MFLogger.m12670d(dhd.TAG, "deletedPreset mappingSetType= onSuccess");
        }

        public void m8609a(C2131a c2131a) {
            MFLogger.m12670d(dhd.TAG, "deletedPreset mappingSetType= onError");
        }
    }

    class C27784 implements C2126d<C2903c, C2901a> {
        final /* synthetic */ dhd cUO;

        C27784(dhd com_fossil_dhd) {
            this.cUO = com_fossil_dhd;
        }

        public /* synthetic */ void onError(Object obj) {
            m8613a((C2901a) obj);
        }

        public /* synthetic */ void onSuccess(Object obj) {
            m8614a((C2903c) obj);
        }

        public void m8614a(C2903c c2903c) {
            this.cUO.cUw.afU();
            MFLogger.m12670d(dhd.TAG, "Inside .swapButton onSuccess buttons" + c2903c.aqN().getButtons());
            this.cUO.cUw.aoq();
            this.cUO.cUK = true;
        }

        public void m8613a(C2901a c2901a) {
            this.cUO.cUw.afU();
            MFLogger.m12670d(dhd.TAG, "Inside .swapButton onError");
            this.cUO.cUw.clearAnimation();
            switch (c2901a.getErrorCode()) {
                case 2:
                    int ajg = c2901a.ajg();
                    if (ajg == FailureCode.BLUETOOTH_IS_DISABLED || ajg == FailureCode.LOCATION_SERVICE_DISABLED || ajg == FailureCode.LOCATION_ACCESS_DENIED) {
                        this.cUO.cUw.m7524a((PermissionCodes[]) PermissionCodes.convertBLEPermissionErrorCode(c2901a.ajf()).toArray(new PermissionCodes[0]));
                        return;
                    }
                    this.cUO.cUw.aou();
                    return;
                case 3:
                    gy.m11536p(PortfolioApp.ZQ()).m11538b(new Intent("BROADCAST_DEVICE_BUSY_OTAING"));
                    return;
                default:
                    this.cUO.cUw.kZ(c2901a.getErrorCode());
                    return;
            }
        }
    }

    static /* synthetic */ class C27795 {
        static final /* synthetic */ int[] f1460xb89372e = new int[MicroAppID.values().length];
        static final /* synthetic */ int[] f1461x96782840 = new int[Pusher.values().length];

        static {
            try {
                f1460xb89372e[MicroAppID.UAPP_COMMUTE_TIME.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f1460xb89372e[MicroAppID.UAPP_RING_PHONE.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f1460xb89372e[MicroAppID.UAPP_TIME2_ID.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                f1461x96782840[Pusher.TOP_PUSHER.ordinal()] = 1;
            } catch (NoSuchFieldError e4) {
            }
            try {
                f1461x96782840[Pusher.MID_PUSHER.ordinal()] = 2;
            } catch (NoSuchFieldError e5) {
            }
            try {
                f1461x96782840[Pusher.BOTTOM_PUSHER.ordinal()] = 3;
            } catch (NoSuchFieldError e6) {
            }
        }
    }

    class C27806 implements C2426a<ActivePreset> {
        final /* synthetic */ dhd cUO;

        C27806(dhd com_fossil_dhd) {
            this.cUO = com_fossil_dhd;
        }

        public gx<ActivePreset> mo2137b(int i, Bundle bundle) {
            MFLogger.m12670d(dhd.TAG, "Inside .onCreateLoader");
            return this.cUO.cOD;
        }

        public void m8616a(gx<ActivePreset> gxVar, ActivePreset activePreset) {
            MFLogger.m12670d(dhd.TAG, "Inside .onLoadFinished loaderId=" + gxVar.getId());
            this.cUO.m8645e(activePreset);
            if (this.cUO.cUK) {
                this.cUO.cUw.clearAnimation();
                this.cUO.cUK = false;
            }
        }

        public void mo2129a(gx<ActivePreset> gxVar) {
            MFLogger.m12670d(dhd.TAG, "Inside .onLoaderReset loaderId=" + gxVar.getId());
        }
    }

    class C27817 implements C2426a<List<MicroAppSetting>> {
        final /* synthetic */ dhd cUO;

        C27817(dhd com_fossil_dhd) {
            this.cUO = com_fossil_dhd;
        }

        public gx<List<MicroAppSetting>> mo2137b(int i, Bundle bundle) {
            MFLogger.m12670d(dhd.TAG, "Inside .onCreateLoader");
            return this.cUO.cUL;
        }

        public void m8621a(gx<List<MicroAppSetting>> gxVar, List<MicroAppSetting> list) {
            MFLogger.m12670d(dhd.TAG, "Inside .onLoadFinished loaderId=" + gxVar.getId());
            if (this.cUO.cUz == null) {
                this.cUO.cUz = new ArrayList();
            }
            this.cUO.cUz.clear();
            this.cUO.cUz.addAll(list);
            if (this.cUO.cFa == 0) {
                MFLogger.m12670d(dhd.TAG, "reloadSettings getMicroAppGallery");
                this.cUO.cP(true);
            }
        }

        public void mo2129a(gx<List<MicroAppSetting>> gxVar) {
            MFLogger.m12670d(dhd.TAG, "Inside .onLoaderReset loaderId=" + gxVar.getId());
        }
    }

    class C27828 implements C2126d<C2844b, C2131a> {
        final /* synthetic */ dhd cUO;

        C27828(dhd com_fossil_dhd) {
            this.cUO = com_fossil_dhd;
        }

        public /* synthetic */ void onError(Object obj) {
            m8623a((C2131a) obj);
        }

        public /* synthetic */ void onSuccess(Object obj) {
            m8624a((C2844b) obj);
        }

        public void m8624a(C2844b c2844b) {
            MFLogger.m12670d(dhd.TAG, "getMicroAppGallery onSuccess");
            this.cUO.mMicroAppList = c2844b.getMicroAppList();
            this.cUO.m8645e(this.cUO.cEs);
            if (this.cUO.cUz == null) {
                this.cUO.cUz = new ArrayList();
            }
            this.cUO.cUw.mo2404d(this.cUO.mMicroAppList, this.cUO.cUz);
        }

        public void m8623a(C2131a c2131a) {
            MFLogger.m12670d(dhd.TAG, "getMicroAppGallery onError");
            this.cUO.mMicroAppList = new ArrayList();
        }
    }

    class C27839 implements C2126d<C2855b, C2131a> {
        final /* synthetic */ dhd cUO;

        C27839(dhd com_fossil_dhd) {
            this.cUO = com_fossil_dhd;
        }

        public /* synthetic */ void onError(Object obj) {
            m8625a((C2131a) obj);
        }

        public /* synthetic */ void onSuccess(Object obj) {
            m8626a((C2855b) obj);
        }

        public void m8626a(C2855b c2855b) {
            MFLogger.m12670d(dhd.TAG, "getPresets getRecommendedPresets onSuccess");
            this.cUO.cUy = c2855b.aqz();
            if (this.cUO.cUx == null) {
                this.cUO.aoL();
            } else {
                this.cUO.cUw.mo2390a(this.cUO.mMicroAppList, this.cUO.cUy, this.cUO.cUx);
            }
        }

        public void m8625a(C2131a c2131a) {
            MFLogger.m12670d(dhd.TAG, "getPresets getRecommendedPresets onError");
            this.cUO.cUy = new ArrayList();
            if (this.cUO.cUx == null) {
                this.cUO.aoL();
            } else {
                this.cUO.cUw.mo2390a(this.cUO.mMicroAppList, this.cUO.cUy, this.cUO.cUx);
            }
        }
    }

    dhd(C2764b c2764b, gy gyVar, djy com_fossil_djy, dke com_fossil_dke, dki com_fossil_dki, djm com_fossil_djm, dje com_fossil_dje, dkg com_fossil_dkg, dkm com_fossil_dkm, dju com_fossil_dju, fj fjVar, SavedPresetListLoader savedPresetListLoader, ActivePresetLoader activePresetLoader, MicroAppSettingListLoader microAppSettingListLoader, ckc com_fossil_ckc) {
        this.cUw = (C2764b) emj.ce(c2764b);
        this.cEa = (gy) emj.m10873f(gyVar, "localBroadcastManager cannot be null!");
        this.cUA = (djy) emj.m10873f(com_fossil_djy, "getRecommendedPresets can not be null!");
        this.cUB = (dke) emj.m10873f(com_fossil_dke, "savePreset can not be null!");
        this.cUC = (dki) emj.m10873f(com_fossil_dki, "showActivePreset can not be null!");
        this.cUD = (djm) emj.m10873f(com_fossil_djm, "getMicroAppGallery can not be null!");
        this.cUE = (dje) emj.m10873f(com_fossil_dje, "deletePreset can not be null!");
        this.cUF = (dju) emj.m10873f(com_fossil_dju, "getRecommendedPresets can not be null!");
        this.cUG = (dkg) emj.m10873f(com_fossil_dkg, "setCommuteApp can not be null");
        this.cUH = (dkm) emj.m10873f(com_fossil_dkm, "swapMicroAppButton can not be null");
        this.cUI = savedPresetListLoader;
        this.cOD = activePresetLoader;
        this.cUL = microAppSettingListLoader;
        this.cFC = (fj) emj.ce(fjVar);
        this.mUseCaseHandler = (ckc) emj.ce(com_fossil_ckc);
    }

    private void aoG() {
        MFLogger.m12670d(TAG, "registerBroadcastReceivers()");
        this.cUC.ajd();
        this.cUG.ajd();
        this.cUH.ajd();
        this.cEa.m11537a(this.cFN, new IntentFilter("BROADCAST_SYNC_COMPLETE"));
    }

    private void aoH() {
        MFLogger.m12670d(TAG, "unRegisterBroadcastReceivers()");
        try {
            this.cUC.aje();
            this.cUG.aje();
            this.cUH.aje();
            this.cEa.unregisterReceiver(this.cFN);
        } catch (Exception e) {
            MFLogger.m12671e(TAG, "unRegisterBroadcastReceivers() ex = " + e);
        }
    }

    public void aoj() {
        MFLogger.m12670d(TAG, "startDevice");
        aoG();
        this.cFC.mo3100a(12, null, this);
        this.cUN = true;
        if (this.cUJ == null) {
            this.cUJ = new C27806(this);
        }
        MFLogger.m12670d(TAG, "Inside .startDevice with currentTab=" + this.cFa);
        this.cFC.mo3100a(25, null, this.cUJ);
        this.cFC.mo3100a(28, null, new C27817(this));
        if (this.cFa == 1) {
            aoi();
        }
        PortfolioApp.ZQ().m12685I(Collections.singletonList(CommunicateMode.SET_LINK_MAPPING));
        this.cUw.cD(TextUtils.isEmpty(PortfolioApp.ZQ().aaa()));
    }

    public void cP(boolean z) {
        MFLogger.m12670d(TAG, "getMicroAppGallery isMicroAppDirty=" + z);
        if (this.mMicroAppList == null || this.mMicroAppList.isEmpty() || z) {
            this.mUseCaseHandler.m6886a(this.cUD, new C2843a(PortfolioApp.ZQ().aaa()), new C27828(this));
            return;
        }
        if (this.cUz == null) {
            this.cUz = new ArrayList();
        }
        this.cUw.mo2404d(this.mMicroAppList, this.cUz);
    }

    public void cQ(boolean z) {
        MFLogger.m12670d(TAG, "handleOnSetOnWatchButtonChanged isActivated=" + z);
        this.cUo.cQ(z);
    }

    public void aoq() {
        MFLogger.m12670d(TAG, "showSavedLayout");
        this.cUw.aoq();
    }

    public void aoI() {
        this.cUo.aoI();
    }

    public void mo2435e(Pusher pusher) {
        this.cUo.mo2435e(pusher);
    }

    public void aoJ() {
        this.cUo.aoJ();
    }

    public boolean aoK() {
        return this.cUo.aoK();
    }

    private void m8633a(String str, Pusher pusher, boolean z) {
        MicroApp microApp;
        MFLogger.m12670d(TAG, "updateButton microAppId=" + str);
        for (int i = 0; i < this.mMicroAppList.size(); i++) {
            if (((MicroApp) this.mMicroAppList.get(i)).getAppId().equals(str)) {
                microApp = (MicroApp) this.mMicroAppList.get(i);
                break;
            }
        }
        microApp = null;
        if (microApp != null) {
            switch (C27795.f1461x96782840[pusher.ordinal()]) {
                case 1:
                    MFLogger.m12670d(TAG, "showActivePreset TOP_PUSHER microAppId=" + microApp.getAppId());
                    this.cUw.mo2387a(microApp, z);
                    return;
                case 2:
                    MFLogger.m12670d(TAG, "showActivePreset MID_PUSHER microAppId=" + microApp.getAppId());
                    this.cUw.mo2400b(microApp, z);
                    return;
                case 3:
                    MFLogger.m12670d(TAG, "showActivePreset BOTTOM_PUSHER microAppId=" + microApp.getAppId());
                    this.cUw.mo2401c(microApp, z);
                    return;
                default:
                    return;
            }
        }
    }

    private void m8645e(ActivePreset activePreset) {
        if (activePreset != null) {
            MFLogger.m12670d(TAG, "showActivePreset mappingSetId=" + activePreset.getSerialNumber() + " buttonList=" + activePreset.getButtons());
            this.cEs = activePreset;
            if (this.mMicroAppList == null || this.mMicroAppList.isEmpty()) {
                MFLogger.m12670d(TAG, "showActivePreset getMicroAppGallery");
                cP(false);
            } else {
                for (ButtonMapping buttonMapping : activePreset.getButtonMappingList()) {
                    m8633a(buttonMapping.getMicroAppId(), Pusher.getPusherFromValue(buttonMapping.getButton()), false);
                }
                if (this.cUN && !this.mSharedPreferencesManager.add() && this.cUM) {
                    this.cUN = false;
                    this.cUw.aot();
                }
            }
            this.cUw.aos();
        }
    }

    public void stop() {
        aoH();
    }

    public void aol() {
        if (this.mMicroAppList != null) {
            this.mMicroAppList.clear();
        }
        if (this.cUy != null) {
            this.cUy.clear();
        }
    }

    public void ahu() {
        this.cUw.cK(this);
    }

    public void aoh() {
        this.cUM = true;
    }

    public void mo2429b(Pusher pusher) {
        if (pusher != null) {
            MFLogger.m12670d(TAG, "showMicroAppDetails pusher=" + pusher.getValue());
            if (this.cEs != null) {
                for (ButtonMapping buttonMapping : this.cEs.getButtonMappingList()) {
                    if (buttonMapping.getButton().equals(pusher.getValue())) {
                        stop();
                        this.cUw.mo2386a(fT(buttonMapping.getMicroAppId()), pusher);
                        return;
                    }
                }
            }
        }
    }

    private MicroApp fT(String str) {
        if (this.mMicroAppList == null || this.mMicroAppList.isEmpty()) {
            return new MicroApp();
        }
        for (MicroApp microApp : this.mMicroAppList) {
            if (microApp.getAppId().equals(str)) {
                return microApp;
            }
        }
        return new MicroApp();
    }

    public void aoi() {
        MFLogger.m12670d(TAG, "getPresets");
        MFLogger.m12670d(TAG, "getPresets getRecommendedPresets");
        this.mUseCaseHandler.m6886a(this.cUF, new C2854a(PortfolioApp.ZQ().aaa()), new C27839(this));
    }

    public void iz(final String str) {
        MFLogger.m12670d(TAG, "savePresets presetName=" + str);
        if ($assertionsDisabled || this.cEs != null) {
            this.mUseCaseHandler.m6886a(this.cUB, new C2875a(this.cEs, str), new C2126d<C2876b, C2131a>(this) {
                final /* synthetic */ dhd cUO;

                public /* synthetic */ void onError(Object obj) {
                    m8601a((C2131a) obj);
                }

                public /* synthetic */ void onSuccess(Object obj) {
                    m8602a((C2876b) obj);
                }

                public void m8602a(C2876b c2876b) {
                    MFLogger.m12670d(dhd.TAG, "savePresets presetName=" + str + " onSuccess");
                    cmj.bs(PortfolioApp.ZQ()).logEvent("preset_save_success");
                }

                public void m8601a(C2131a c2131a) {
                    MFLogger.m12670d(dhd.TAG, "savePresets presetName=" + str + " onError");
                }
            });
            return;
        }
        throw new AssertionError();
    }

    private void aoL() {
        MFLogger.m12670d(TAG, "getSavedMappingSetList");
        this.mUseCaseHandler.m6886a(this.cUA, new C2858a(PortfolioApp.ZQ().aaa()), new C2126d<C2859b, C2131a>(this) {
            final /* synthetic */ dhd cUO;

            {
                this.cUO = r1;
            }

            public /* synthetic */ void onError(Object obj) {
                m8603a((C2131a) obj);
            }

            public /* synthetic */ void onSuccess(Object obj) {
                m8604a((C2859b) obj);
            }

            public void m8604a(C2859b c2859b) {
                MFLogger.m12670d(dhd.TAG, "getSavedMappingSetList onSuccess");
                this.cUO.cUx = c2859b.aqD();
                this.cUO.cUw.mo2390a(this.cUO.mMicroAppList, this.cUO.cUy, this.cUO.cUx);
            }

            public void m8603a(C2131a c2131a) {
                MFLogger.m12670d(dhd.TAG, "getSavedMappingSetList onError");
                this.cUO.cUw.mo2390a(this.cUO.mMicroAppList, this.cUO.cUy, this.cUO.cUx);
            }
        });
    }

    private void m8643d(final String str, Pusher pusher) {
        MFLogger.m12670d(TAG, "setMicroAppToDevice microAppId=" + str + " pusher=" + pusher.getValue());
        this.cUw.afT();
        this.mUseCaseHandler.m6886a(this.cUG, new C2884b(PortfolioApp.ZQ().aaa(), str, pusher), new C2126d<C2885c, C2883a>(this) {
            final /* synthetic */ dhd cUO;

            public /* synthetic */ void onError(Object obj) {
                m8605a((C2883a) obj);
            }

            public /* synthetic */ void onSuccess(Object obj) {
                m8606a((C2885c) obj);
            }

            public void m8606a(C2885c c2885c) {
                MFLogger.m12670d(dhd.TAG, "setMicroAppToDevice onSuccess");
                this.cUO.cUw.afU();
                this.cUO.cUw.aoq();
                if (str.equals(MicroAppID.UAPP_TOGGLE_MODE.getValue())) {
                    this.cUO.cUw.aor();
                }
            }

            public void m8605a(C2883a c2883a) {
                MFLogger.m12670d(dhd.TAG, "setMicroAppToDevice onError");
                this.cUO.cUw.afU();
                this.cUO.m8645e(this.cUO.cEs);
                switch (c2883a.getErrorCode()) {
                    case 2:
                        int ajg = c2883a.ajg();
                        if (ajg == FailureCode.BLUETOOTH_IS_DISABLED || ajg == FailureCode.LOCATION_SERVICE_DISABLED || ajg == FailureCode.LOCATION_ACCESS_DENIED) {
                            this.cUO.cUw.m7524a((PermissionCodes[]) c2883a.aqG().toArray(new PermissionCodes[0]));
                            return;
                        }
                        this.cUO.cUw.aou();
                        return;
                    case 3:
                        gy.m11536p(PortfolioApp.ZQ()).m11538b(new Intent("BROADCAST_DEVICE_BUSY_OTAING"));
                        return;
                    case 4:
                        this.cUO.cUw.m7524a((PermissionCodes[]) c2883a.aqG().toArray(new PermissionCodes[0]));
                        return;
                    default:
                        this.cUO.cUw.kZ(c2883a.getErrorCode());
                        return;
                }
            }
        });
    }

    public void mo2431b(final String str, MappingSetType mappingSetType) {
        this.cUw.afT();
        MFLogger.m12670d(TAG, "setActivePreset mappingSetId=" + str);
        this.mUseCaseHandler.m6886a(this.cUC, new C2892b(PortfolioApp.ZQ().aaa(), str, mappingSetType), new C2126d<C2893c, C2891a>(this) {
            final /* synthetic */ dhd cUO;

            public /* synthetic */ void onError(Object obj) {
                m8607a((C2891a) obj);
            }

            public /* synthetic */ void onSuccess(Object obj) {
                m8608a((C2893c) obj);
            }

            public void m8608a(C2893c c2893c) {
                MFLogger.m12670d(dhd.TAG, "setActivePreset mappingSetId=" + str);
                this.cUO.cEs = c2893c.aqN();
                this.cUO.cUw.afU();
            }

            public void m8607a(C2891a c2891a) {
                MFLogger.m12670d(dhd.TAG, "setActivePreset mappingSetId=" + str + " onError errorCode=" + c2891a.getErrorCode());
                this.cUO.m8645e(this.cUO.cEs);
                this.cUO.cUw.afU();
                switch (c2891a.getErrorCode()) {
                    case 2:
                        int ajg = c2891a.ajg();
                        if (ajg == FailureCode.BLUETOOTH_IS_DISABLED || ajg == FailureCode.LOCATION_SERVICE_DISABLED || ajg == FailureCode.LOCATION_ACCESS_DENIED) {
                            this.cUO.cUw.m7524a((PermissionCodes[]) c2891a.aqG().toArray(new PermissionCodes[0]));
                            return;
                        }
                        this.cUO.cUw.aou();
                        return;
                    case 3:
                        gy.m11536p(PortfolioApp.ZQ()).m11538b(new Intent("BROADCAST_DEVICE_BUSY_OTAING"));
                        return;
                    case 4:
                        this.cUO.cUw.m7524a((PermissionCodes[]) c2891a.aqG().toArray(new PermissionCodes[0]));
                        return;
                    default:
                        this.cUO.cUw.kZ(c2891a.getErrorCode());
                        return;
                }
            }
        });
    }

    public boolean mo2409a(String str, Pusher pusher) {
        MFLogger.m12670d(TAG, "processDropMicroApp microAppId=" + str + " pusher=" + pusher);
        if (!iB(str)) {
            if (iA(str)) {
                m8633a(str, pusher, true);
                m8643d(str, pusher);
            } else {
                MicroApp fT = fT(str);
                m8662c(fT);
                cR(true);
                this.cUw.mo2386a(fT, pusher);
            }
        }
        return false;
    }

    private boolean iA(String str) {
        boolean z = true;
        MFLogger.m12670d(TAG, "isSettingDataAvailable microAppId=" + str);
        if (this.cUz == null) {
            return false;
        }
        MicroAppID microAppId = MicroAppID.getMicroAppId(str);
        switch (C27795.f1460xb89372e[microAppId.ordinal()]) {
            case 1:
            case 2:
            case 3:
                MicroAppSetting microAppSetting = null;
                for (MicroAppSetting microAppSetting2 : this.cUz) {
                    MicroAppSetting microAppSetting22;
                    if (!microAppSetting22.getMicroAppId().equals(str)) {
                        microAppSetting22 = microAppSetting;
                    }
                    microAppSetting = microAppSetting22;
                }
                if (microAppSetting != null) {
                    if (microAppId != MicroAppID.UAPP_COMMUTE_TIME) {
                        if (TextUtils.isEmpty(microAppSetting.getSetting())) {
                            z = false;
                            break;
                        }
                    }
                    boolean z2;
                    CommuteTimeSettings c = m8638c(microAppSetting);
                    if (c == null || TextUtils.isEmpty(c.getDestination())) {
                        z2 = false;
                    } else {
                        z2 = true;
                    }
                    z = z2;
                    break;
                }
                z = false;
                break;
                break;
        }
        MFLogger.m12670d(TAG, "isSettingDataAvailable " + z);
        return z;
    }

    private CommuteTimeSettings m8638c(MicroAppSetting microAppSetting) {
        if (microAppSetting == null || MicroAppID.getMicroAppId(microAppSetting.getMicroAppId()) != MicroAppID.UAPP_COMMUTE_TIME) {
            return null;
        }
        String setting = microAppSetting.getSetting();
        if (setting == null || setting.isEmpty()) {
            return null;
        }
        try {
            return (CommuteTimeSettings) new cfj().m6205c(setting, CommuteTimeSettings.class);
        } catch (JsonSyntaxException e) {
            return null;
        }
    }

    public boolean iB(String str) {
        if (this.cEs != null) {
            for (ButtonMapping microAppId : this.cEs.getButtonMappingList()) {
                if (microAppId.getMicroAppId().equals(str)) {
                    return true;
                }
            }
        }
        return false;
    }

    public void mo2407a(dhk com_fossil_dhk) {
        this.cUo = com_fossil_dhk;
    }

    public void mo2430b(MappingSetType mappingSetType, String str) {
        MFLogger.m12670d(TAG, "deletedPreset mappingSetType=" + mappingSetType + "mappingSetId=" + str);
        if (mappingSetType == MappingSetType.USER_SAVED) {
            this.mUseCaseHandler.m6886a(this.cUE, new C2822a(str), new C27762(this));
        }
    }

    public void aE(String str, final String str2) {
        MFLogger.m12670d(TAG, "navigateDeepLinking subView=" + str + " id=" + str2);
        if (!TextUtils.isEmpty(str)) {
            boolean z = true;
            switch (str.hashCode()) {
                case -1335224239:
                    if (str.equals(Constants.DETAIL)) {
                        z = false;
                        break;
                    }
                    break;
            }
            switch (z) {
                case false:
                    this.cUM = false;
                    if (this.mMicroAppList == null || this.mMicroAppList.isEmpty()) {
                        this.mUseCaseHandler.m6886a(this.cUD, new C2843a(PortfolioApp.ZQ().aaa()), new C2126d<C2844b, C2131a>(this) {
                            final /* synthetic */ dhd cUO;

                            public /* synthetic */ void onError(Object obj) {
                                m8611a((C2131a) obj);
                            }

                            public /* synthetic */ void onSuccess(Object obj) {
                                m8612a((C2844b) obj);
                            }

                            public void m8612a(C2844b c2844b) {
                                this.cUO.mMicroAppList = c2844b.getMicroAppList();
                                if (this.cUO.cUw.isActive()) {
                                    this.cUO.cUw.mo2386a(this.cUO.fT(str2), Pusher.BOTTOM_PUSHER);
                                }
                            }

                            public void m8611a(C2131a c2131a) {
                            }
                        });
                        return;
                    } else {
                        this.cUw.mo2386a(fT(str2), Pusher.BOTTOM_PUSHER);
                        return;
                    }
                default:
                    return;
            }
        }
    }

    public void ai(List<Pusher> list) {
        MFLogger.m12670d(TAG, "Inside .swapButton pusherList=" + ((Pusher) list.get(0)).getValue() + MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR + ((Pusher) list.get(1)).getValue() + MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR + ((Pusher) list.get(2)).getValue());
        if (al(list)) {
            this.cUw.afT();
            this.mUseCaseHandler.m6886a(this.cUH, new C2902b(PortfolioApp.ZQ().aaa(), list), new C27784(this));
            return;
        }
        this.cUw.clearAnimation();
    }

    private boolean al(List<Pusher> list) {
        if (list.size() != 3) {
            return false;
        }
        if (list.get(0) == Pusher.TOP_PUSHER && list.get(1) == Pusher.MID_PUSHER && list.get(2) == Pusher.BOTTOM_PUSHER) {
            MFLogger.m12670d(TAG, "isPositionChanged false");
            return false;
        }
        MFLogger.m12670d(TAG, "isPositionChanged true");
        return true;
    }

    public gx<List<SavedPreset>> mo2137b(int i, Bundle bundle) {
        MFLogger.m12670d(TAG, "Inside .onCreateLoader id=" + i);
        return this.cUI;
    }

    public void m8656a(gx<List<SavedPreset>> gxVar, List<SavedPreset> list) {
        MFLogger.m12670d(TAG, "Inside .onLoadFinished");
        if (this.cUx != null) {
            this.cUx.clear();
        } else {
            this.cUx = new ArrayList();
        }
        if (!(list == null || list.isEmpty())) {
            MFLogger.m12670d(TAG, "Inside .onLoadFinished presetListSize=" + list.size());
            this.cUx.addAll(list);
        }
        MFLogger.m12670d(TAG, "Inside .onLoadFinished currentTab=" + this.cFa);
        if (this.cFa == 1) {
            this.cUw.mo2390a(this.mMicroAppList, this.cUy, this.cUx);
        }
    }

    public void mo2129a(gx<List<SavedPreset>> gxVar) {
        MFLogger.m12670d(TAG, "Inside .onLoaderReset loaderId=" + gxVar.getId());
    }

    public void setCurrentTab(int i) {
        this.cFa = i;
    }

    public void m8662c(MicroApp microApp) {
        this.cUo.m8716c(microApp);
    }

    public void cR(boolean z) {
        this.cUo.cR(z);
    }

    public void aok() {
        MFLogger.m12670d(TAG, "setIsShowTooltips");
        this.mSharedPreferencesManager.ca(true);
    }

    public void mo2408a(dik com_fossil_dik, dhu com_fossil_dhu, dir com_fossil_dir, djb com_fossil_djb) {
        MFLogger.m12670d(TAG, "setupPresenter");
        this.cUo.mo2408a(com_fossil_dik, com_fossil_dhu, com_fossil_dir, com_fossil_djb);
    }

    public void aoM() {
        this.cUo.aoM();
    }

    public void aoN() {
        this.cUo.aoN();
    }

    public void aom() {
        this.cUw.aom();
    }

    public void aon() {
        this.cUw.aon();
    }

    public void aoO() {
        this.cUo.aoO();
    }

    public void aoP() {
        this.cUo.aoP();
    }

    public dhk aoQ() {
        return this.cUo;
    }

    public void aoo() {
        this.cUw.aoo();
    }

    public void aop() {
        this.cUw.aop();
    }

    public void sync() {
        MFLogger.m12670d(TAG, "sync");
        PortfolioApp.ZQ().m12698e(false, 12);
    }
}
