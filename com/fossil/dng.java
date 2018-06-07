package com.fossil;

import android.text.TextUtils;
import com.fossil.ckb.C2126d;
import com.fossil.cyq.C2529a;
import com.fossil.cyq.C2530b;
import com.fossil.cyq.C2531c;
import com.fossil.dji.C2837a;
import com.fossil.dji.C2838b;
import com.fossil.dji.C2839c;
import com.fossil.dlo.C2938a;
import com.fossil.dlv.C2946a;
import com.fossil.dmm.C2966a;
import com.fossil.dmt.C2974a;
import com.fossil.dnf.C2985a;
import com.fossil.dnf.C2986b;
import com.fossil.dpt.C3072a;
import com.fossil.dpt.C3073b;
import com.fossil.dpt.C3074c;
import com.fossil.dpx.C3080a;
import com.fossil.dpx.C3081b;
import com.fossil.dpx.C3082c;
import com.fossil.dpz.C3084a;
import com.fossil.dpz.C3085b;
import com.fossil.dpz.C3086c;
import com.fossil.dqb.C3089a;
import com.fossil.dqb.C3090b;
import com.fossil.dqb.C3091c;
import com.fossil.dqd.C3093a;
import com.fossil.dqd.C3094b;
import com.fossil.dqd.C3095c;
import com.misfit.frameworks.buttonservice.model.Alarm;
import com.misfit.frameworks.common.constants.MFNetworkReturnCode;
import com.misfit.frameworks.common.log.MFLogger;
import com.portfolio.platform.PortfolioApp;
import com.portfolio.platform.data.model.DeviceModel;
import com.portfolio.platform.data.model.MFUser;
import com.portfolio.platform.data.source.AlarmsDataSource.LoadAlarmsCallback;
import com.portfolio.platform.data.source.AlarmsRepository;
import com.portfolio.platform.data.source.DeviceDataSource.GetAllDeviceCallback;
import com.portfolio.platform.data.source.DeviceRepository;
import com.portfolio.platform.data.source.LandingPageRepository;
import com.portfolio.platform.data.source.UserRepository;
import com.portfolio.platform.helper.DeviceHelper;
import java.lang.ref.WeakReference;
import java.util.Date;
import java.util.List;

public class dng implements C2985a {
    private static final String TAG = dng.class.getSimpleName();
    private cmj cEE;
    cnr cEF;
    private cyq cIu;
    private final dlo cZv;
    private final dlv cZw;
    AlarmsRepository cxw;
    LandingPageRepository daE;
    private C2986b daF;
    private ctj daG;
    private dpx daH;
    private dpz daI;
    private dqd daJ;
    private dqb daK;
    private dpt daL;
    private dpr daM;
    private dji daN;
    private final dmt dae;
    private final dmm daf;
    DeviceRepository mDeviceRepository;
    private ckc mUseCaseHandler;
    UserRepository mUserRepository;

    class C29871 implements C2126d<C3082c, C3081b> {
        final /* synthetic */ dng daO;

        C29871(dng com_fossil_dng) {
            this.daO = com_fossil_dng;
        }

        public /* synthetic */ void onError(Object obj) {
            m9149a((C3081b) obj);
        }

        public /* synthetic */ void onSuccess(Object obj) {
            m9150a((C3082c) obj);
        }

        public void m9150a(C3082c c3082c) {
            MFLogger.m12670d(dng.TAG, "Inside .loginFacebook success with result=" + c3082c.atS());
            switch (c3082c.atS()) {
                case 0:
                    this.daO.aG("Auth", "Facebook");
                    this.daO.m9175n("login_success", "Auth", "Facebook");
                    this.daO.asy();
                    return;
                case 1:
                    cnq.acd().reset();
                    this.daO.cEF.gK("Facebook");
                    this.daO.daF.asv();
                    return;
                default:
                    return;
            }
        }

        public void m9149a(C3081b c3081b) {
            MFLogger.m12670d(dng.TAG, "Inside .loginFacebook failed with error=" + c3081b.getErrorCode());
            this.daO.daF.afM();
            this.daO.lm(c3081b.getErrorCode());
        }
    }

    class C29882 implements C2126d<C3086c, C3085b> {
        final /* synthetic */ dng daO;

        C29882(dng com_fossil_dng) {
            this.daO = com_fossil_dng;
        }

        public /* synthetic */ void onError(Object obj) {
            m9151a((C3085b) obj);
        }

        public /* synthetic */ void onSuccess(Object obj) {
            m9152a((C3086c) obj);
        }

        public void m9152a(C3086c c3086c) {
            MFLogger.m12670d(dng.TAG, "Inside .loginGoogle success with result=" + c3086c.atS());
            switch (c3086c.atS()) {
                case 0:
                    this.daO.aG("Auth", "Google");
                    this.daO.m9175n("login_success", "Auth", "Google");
                    this.daO.asy();
                    return;
                case 1:
                    cnq.acd().reset();
                    this.daO.cEF.gK("Google");
                    this.daO.daF.asv();
                    return;
                default:
                    return;
            }
        }

        public void m9151a(C3085b c3085b) {
            MFLogger.m12670d(dng.TAG, "Inside .loginGoogle failed with error=" + c3085b.getErrorCode());
            this.daO.daF.afM();
            this.daO.lm(c3085b.getErrorCode());
        }
    }

    class C29893 implements C2126d<C3095c, C3094b> {
        final /* synthetic */ dng daO;

        C29893(dng com_fossil_dng) {
            this.daO = com_fossil_dng;
        }

        public /* synthetic */ void onError(Object obj) {
            m9153a((C3094b) obj);
        }

        public /* synthetic */ void onSuccess(Object obj) {
            m9154a((C3095c) obj);
        }

        public void m9154a(C3095c c3095c) {
            MFLogger.m12670d(dng.TAG, "Inside .loginWeibo success with result=" + c3095c.atS());
            switch (c3095c.atS()) {
                case 0:
                    this.daO.aG("Auth", "Weibo");
                    this.daO.m9175n("login_success", "Auth", "Weibo");
                    this.daO.asy();
                    return;
                case 1:
                    this.daO.cEF.gK("Weibo");
                    cnq.acd().reset();
                    this.daO.daF.db(false);
                    return;
                default:
                    return;
            }
        }

        public void m9153a(C3094b c3094b) {
            MFLogger.m12670d(dng.TAG, "Inside .loginWeibo failed with error=" + c3094b.getErrorCode());
            this.daO.daF.afM();
            this.daO.lm(c3094b.getErrorCode());
        }
    }

    class C29904 implements C2126d<C3091c, C3090b> {
        final /* synthetic */ dng daO;

        C29904(dng com_fossil_dng) {
            this.daO = com_fossil_dng;
        }

        public /* synthetic */ void onError(Object obj) {
            m9155a((C3090b) obj);
        }

        public /* synthetic */ void onSuccess(Object obj) {
            m9156a((C3091c) obj);
        }

        public void m9156a(C3091c c3091c) {
            MFLogger.m12670d(dng.TAG, "Inside .loginWechat success with result=" + c3091c.atS());
            switch (c3091c.atS()) {
                case 0:
                    this.daO.aG("Auth", "Wechat");
                    this.daO.m9175n("login_success", "Auth", "Wechat");
                    this.daO.asy();
                    return;
                case 1:
                    cnq.acd().reset();
                    this.daO.cEF.gK("Wechat");
                    this.daO.daF.db(false);
                    return;
                default:
                    return;
            }
        }

        public void m9155a(C3090b c3090b) {
            MFLogger.m12670d(dng.TAG, "Inside .loginWechat failed with error=" + c3090b.getErrorCode());
            this.daO.daF.afM();
            this.daO.lm(c3090b.getErrorCode());
        }
    }

    class C29926 implements C2126d<C2531c, C2530b> {
        final /* synthetic */ dng daO;

        C29926(dng com_fossil_dng) {
            this.daO = com_fossil_dng;
        }

        public /* synthetic */ void onError(Object obj) {
            m9159a((C2530b) obj);
        }

        public /* synthetic */ void onSuccess(Object obj) {
            m9160a((C2531c) obj);
        }

        public void m9160a(C2531c c2531c) {
        }

        public void m9159a(C2530b c2530b) {
        }
    }

    class C29957 implements C2126d<C3074c, C3073b> {
        final /* synthetic */ dng daO;

        class C29931 implements LoadAlarmsCallback {
            final /* synthetic */ C29957 daQ;

            C29931(C29957 c29957) {
                this.daQ = c29957;
            }

            public void onAlarmsLoaded(List<Alarm> list) {
            }

            public void onDataNotAvailable() {
            }
        }

        class C29942 implements GetAllDeviceCallback {
            final /* synthetic */ C29957 daQ;

            C29942(C29957 c29957) {
                this.daQ = c29957;
            }

            public void onSuccess(List<DeviceModel> list) {
                MFLogger.m12670d(dng.TAG, "Get all device success devicesList=" + list);
                MFUser currentUser = this.daQ.daO.mUserRepository.getCurrentUser();
                String activeDeviceId = currentUser != null ? currentUser.getActiveDeviceId() : "";
                String firstName = currentUser != null ? currentUser.getFirstName() : "";
                for (DeviceModel deviceModel : list) {
                    PortfolioApp.ZQ().setPairedSerial(deviceModel.getDeviceId(), deviceModel.getMacAddress());
                    if (deviceModel.getDeviceId().equalsIgnoreCase(activeDeviceId)) {
                        PortfolioApp.ZQ().an(activeDeviceId, deviceModel.getMacAddress());
                    }
                }
                if (TextUtils.isEmpty(activeDeviceId) || !DeviceHelper.gf(activeDeviceId)) {
                    this.daQ.daO.daF.afM();
                    this.daQ.daO.daF.iS(firstName);
                    return;
                }
                this.daQ.daO.aF(activeDeviceId, firstName);
            }

            public void onFailed(int i) {
                MFLogger.m12670d(dng.TAG, "Get all device failed errorCode=" + i);
                this.daQ.daO.daF.afM();
                this.daQ.daO.lm(i);
            }
        }

        C29957(dng com_fossil_dng) {
            this.daO = com_fossil_dng;
        }

        public /* synthetic */ void onError(Object obj) {
            m9161a((C3073b) obj);
        }

        public /* synthetic */ void onSuccess(Object obj) {
            m9162a((C3074c) obj);
        }

        public void m9162a(C3074c c3074c) {
            MFLogger.m12670d(dng.TAG, "Inside .onLoginSuccess Download user info success, startOnboardingFlow download fitness, sleep, device data of user.");
            cnq.acd().reset();
            MFUser user = c3074c.getUser();
            if (user == null) {
                MFLogger.m12670d(dng.TAG, "Inside .onLoginSuccess Download user info failed");
                this.daO.daF.afM();
                this.daO.daF.jV(MFNetworkReturnCode.INTERNAL_SERVER_ERROR);
                return;
            }
            Date date = new Date();
            this.daO.mUseCaseHandler.m6886a(this.daO.cZw, new C2946a(date, true), null);
            this.daO.mUseCaseHandler.m6886a(this.daO.cZv, new C2938a(date, true), null);
            this.daO.mUseCaseHandler.m6886a(this.daO.daf, new C2966a(date, true), null);
            this.daO.mUseCaseHandler.m6886a(this.daO.dae, new C2974a(date, true), null);
            this.daO.daE.refreshLandingPage();
            Object activeDeviceId = user.getActiveDeviceId();
            if (!(TextUtils.isEmpty(activeDeviceId) || DeviceHelper.gf(activeDeviceId))) {
                this.daO.cEF.ce(true);
            }
            this.daO.cxw.clearCache();
            this.daO.cxw.getAlarms(new C29931(this));
            this.daO.mDeviceRepository.fetchSupportedSkus();
            this.daO.mDeviceRepository.getAllDevice(new C29942(this));
        }

        public void m9161a(C3073b c3073b) {
            MFLogger.m12670d(dng.TAG, "Inside .onLoginSuccess Download user info failed");
            this.daO.daF.afM();
            this.daO.lm(c3073b.getErrorCode());
        }
    }

    public dng(C2986b c2986b, ckc com_fossil_ckc, ctj com_fossil_ctj, dpx com_fossil_dpx, dpz com_fossil_dpz, dqd com_fossil_dqd, dqb com_fossil_dqb, dpt com_fossil_dpt, cyq com_fossil_cyq, dji com_fossil_dji, dpr com_fossil_dpr, dlo com_fossil_dlo, dlv com_fossil_dlv, dmm com_fossil_dmm, dmt com_fossil_dmt) {
        this.daF = (C2986b) cco.m5996s(c2986b, "profileSetupView cannot be null!");
        this.daF.cK(this);
        this.mUseCaseHandler = (ckc) cco.m5996s(com_fossil_ckc, "useCaseHandler cannot be nulL!");
        this.daH = com_fossil_dpx;
        this.daI = com_fossil_dpz;
        this.daJ = com_fossil_dqd;
        this.daK = com_fossil_dqb;
        this.daL = com_fossil_dpt;
        this.cIu = com_fossil_cyq;
        this.daN = com_fossil_dji;
        this.daM = com_fossil_dpr;
        this.cZv = com_fossil_dlo;
        this.cZw = com_fossil_dlv;
        this.daf = com_fossil_dmm;
        this.dae = com_fossil_dmt;
        this.daG = com_fossil_ctj;
    }

    public void start() {
        this.daM.ajd();
        this.cEE = cmj.bs(PortfolioApp.ZQ());
    }

    public void stop() {
        this.daM.aje();
    }

    public void asq() {
        this.daF.afL();
        this.mUseCaseHandler.m6886a(this.daH, new C3080a(new WeakReference(this.daG)), new C29871(this));
    }

    public void asr() {
        this.daF.afL();
        this.mUseCaseHandler.m6886a(this.daI, new C3084a(new WeakReference(this.daG)), new C29882(this));
    }

    public void ass() {
        this.daF.afL();
        coa.adD().m7333m(cjy.cnN.aaX(), cjy.cnN.aaY(), cjy.cnN.aaZ());
        this.mUseCaseHandler.m6886a(this.daJ, new C3093a(new WeakReference(this.daG)), new C29893(this));
    }

    public void ast() {
        String str = "com.tencent.mm";
        if (cmk.m7091y(this.daG, str)) {
            this.daF.afL();
            this.mUseCaseHandler.m6886a(this.daK, new C3089a(new WeakReference(this.daG)), new C29904(this));
            return;
        }
        cmk.m7090x(this.daG, str);
    }

    public void asu() {
        MFUser currentUser = this.mUserRepository.getCurrentUser();
        if (currentUser == null) {
            this.daF.asx();
        } else if (TextUtils.isEmpty(PortfolioApp.ZQ().aaa()) && TextUtils.isEmpty(currentUser.getActiveDeviceId())) {
            this.daF.asw();
        } else {
            this.daF.asx();
        }
    }

    private void aF(final String str, final String str2) {
        MFLogger.m12670d(TAG, "Inside .downloadDeviceShortcutSetting serial=" + str);
        this.cEF.m7241a(str, 0, false);
        this.cEF.m7251r(str, true);
        this.mUseCaseHandler.m6886a(this.daN, new C2837a(str), new C2126d<C2839c, C2838b>(this) {
            final /* synthetic */ dng daO;

            public /* synthetic */ void onError(Object obj) {
                m9157a((C2838b) obj);
            }

            public /* synthetic */ void onSuccess(Object obj) {
                m9158a((C2839c) obj);
            }

            public void m9158a(C2839c c2839c) {
                this.daO.iT(str);
                this.daO.daF.afM();
                this.daO.daF.iS(str2);
            }

            public void m9157a(C2838b c2838b) {
                this.daO.iT(str);
                this.daO.daF.afM();
                this.daO.daF.iS(str2);
            }
        });
    }

    private void iT(String str) {
        MFLogger.m12670d(TAG, "Inside .reconnectActiveDevice serial=" + str);
        this.mUseCaseHandler.m6886a(this.cIu, new C2529a(str), new C29926(this));
    }

    private void asy() {
        MFLogger.m12670d(TAG, "Inside .onLoginSuccess startOnboardingFlow download user info");
        this.mUseCaseHandler.m6886a(this.daL, new C3072a(), new C29957(this));
    }

    private void m9175n(String str, String str2, String str3) {
        this.cEE.m7086l(str, str2, str3);
    }

    private void aG(String str, String str2) {
        this.cEE.ap(str, str2);
    }

    private void lm(int i) {
        switch (i) {
            case 2:
                return;
            default:
                this.daF.jV(i);
                return;
        }
    }
}
