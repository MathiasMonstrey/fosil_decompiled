package com.fossil;

import android.text.TextUtils;
import com.fossil.ckb.C2126d;
import com.fossil.ckb.C2133c;
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
import com.fossil.dnv.C2999a;
import com.fossil.dnv.C3000b;
import com.fossil.dpt.C3072a;
import com.fossil.dpt.C3073b;
import com.fossil.dpt.C3074c;
import com.fossil.dpv.C3076a;
import com.fossil.dpv.C3077b;
import com.fossil.wearables.fossil.R;
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
import java.util.Date;
import java.util.List;

public class dnz implements C2999a {
    private static final String TAG = dnz.class.getSimpleName();
    cnr cEF;
    private cyq cIu;
    private cmj cJv;
    private final dlo cZv;
    private final dlv cZw;
    AlarmsRepository cxw;
    LandingPageRepository daE;
    private dpt daL;
    private dpr daM;
    private dji daN;
    private final dmt dae;
    private final dmm daf;
    private C3000b dbt;
    private dpv dbu;
    private String dbv;
    private String dbw;
    DeviceRepository mDeviceRepository;
    private ckc mUseCaseHandler;
    UserRepository mUserRepository;

    class C30031 implements C2126d<C2133c, C3077b> {
        final /* synthetic */ dnz dbx;

        C30031(dnz com_fossil_dnz) {
            this.dbx = com_fossil_dnz;
        }

        public /* synthetic */ void onError(Object obj) {
            m9196a((C3077b) obj);
        }

        public /* synthetic */ void onSuccess(Object obj) {
            m9195a((C2133c) obj);
        }

        public void m9195a(C2133c c2133c) {
            MFLogger.m12670d(dnz.TAG, "Inside .loginEmail success ");
            this.dbx.asy();
            this.dbx.cJv.ap("Auth", "Email");
            this.dbx.cJv.m7086l("login_success", "Auth", "Email");
        }

        public void m9196a(C3077b c3077b) {
            MFLogger.m12670d(dnz.TAG, "Inside .loginEmail failed with error=" + c3077b.getErrorCode());
            this.dbx.dbt.afM();
            this.dbx.lm(c3077b.getErrorCode());
        }
    }

    class C30062 implements C2126d<C3074c, C3073b> {
        final /* synthetic */ dnz dbx;

        class C30041 implements LoadAlarmsCallback {
            final /* synthetic */ C30062 dby;

            C30041(C30062 c30062) {
                this.dby = c30062;
            }

            public void onAlarmsLoaded(List<Alarm> list) {
            }

            public void onDataNotAvailable() {
            }
        }

        class C30052 implements GetAllDeviceCallback {
            final /* synthetic */ C30062 dby;

            C30052(C30062 c30062) {
                this.dby = c30062;
            }

            public void onSuccess(List<DeviceModel> list) {
                MFLogger.m12670d(dnz.TAG, "Get all device success devicesList=" + list);
                MFUser currentUser = this.dby.dbx.mUserRepository.getCurrentUser();
                String activeDeviceId = currentUser != null ? currentUser.getActiveDeviceId() : "";
                String firstName = currentUser != null ? currentUser.getFirstName() : "";
                for (DeviceModel deviceModel : list) {
                    PortfolioApp.ZQ().setPairedSerial(deviceModel.getDeviceId(), deviceModel.getMacAddress());
                    if (deviceModel.getDeviceId().equalsIgnoreCase(activeDeviceId)) {
                        PortfolioApp.ZQ().an(activeDeviceId, deviceModel.getMacAddress());
                    }
                }
                if (TextUtils.isEmpty(activeDeviceId) || !DeviceHelper.gf(activeDeviceId)) {
                    this.dby.dbx.dbt.afM();
                    this.dby.dbx.dbt.iS(firstName);
                    return;
                }
                this.dby.dbx.aF(activeDeviceId, firstName);
            }

            public void onFailed(int i) {
                MFLogger.m12670d(dnz.TAG, "Get all device failed errorCode=" + i);
                this.dby.dbx.dbt.afM();
                this.dby.dbx.lm(i);
            }
        }

        C30062(dnz com_fossil_dnz) {
            this.dbx = com_fossil_dnz;
        }

        public /* synthetic */ void onError(Object obj) {
            m9197a((C3073b) obj);
        }

        public /* synthetic */ void onSuccess(Object obj) {
            m9198a((C3074c) obj);
        }

        public void m9198a(C3074c c3074c) {
            MFLogger.m12670d(dnz.TAG, "Inside .onLoginSuccess Download user info success, startOnboardingFlow download fitness, sleep, device data of user.");
            cnq.acd().reset();
            MFUser user = c3074c.getUser();
            if (user == null) {
                MFLogger.m12670d(dnz.TAG, "Inside .onLoginSuccess Download user info failed");
                this.dbx.dbt.afM();
                this.dbx.dbt.jV(MFNetworkReturnCode.INTERNAL_SERVER_ERROR);
                return;
            }
            Date date = new Date();
            this.dbx.mUseCaseHandler.m6886a(this.dbx.cZw, new C2946a(date, true), null);
            this.dbx.mUseCaseHandler.m6886a(this.dbx.cZv, new C2938a(date, true), null);
            this.dbx.mUseCaseHandler.m6886a(this.dbx.daf, new C2966a(date, true), null);
            this.dbx.mUseCaseHandler.m6886a(this.dbx.dae, new C2974a(date, true), null);
            this.dbx.daE.refreshLandingPage();
            Object activeDeviceId = user.getActiveDeviceId();
            if (!(TextUtils.isEmpty(activeDeviceId) || DeviceHelper.gf(activeDeviceId))) {
                this.dbx.cEF.ce(true);
            }
            this.dbx.cxw.clearCache();
            this.dbx.cxw.getAlarms(new C30041(this));
            this.dbx.mDeviceRepository.fetchSupportedSkus();
            this.dbx.mDeviceRepository.getAllDevice(new C30052(this));
        }

        public void m9197a(C3073b c3073b) {
            MFLogger.m12670d(dnz.TAG, "Inside .onLoginSuccess Download user info failed");
            this.dbx.dbt.afM();
            this.dbx.lm(c3073b.getErrorCode());
        }
    }

    class C30073 implements C2126d<C2531c, C2530b> {
        final /* synthetic */ dnz dbx;

        C30073(dnz com_fossil_dnz) {
            this.dbx = com_fossil_dnz;
        }

        public /* synthetic */ void onError(Object obj) {
            m9199a((C2530b) obj);
        }

        public /* synthetic */ void onSuccess(Object obj) {
            m9200a((C2531c) obj);
        }

        public void m9200a(C2531c c2531c) {
        }

        public void m9199a(C2530b c2530b) {
        }
    }

    dnz(C3000b c3000b, ckc com_fossil_ckc, dpv com_fossil_dpv, dpt com_fossil_dpt, dji com_fossil_dji, cyq com_fossil_cyq, dpr com_fossil_dpr, cmj com_fossil_cmj, dlo com_fossil_dlo, dlv com_fossil_dlv, dmm com_fossil_dmm, dmt com_fossil_dmt) {
        this.dbt = (C3000b) cco.m5996s(c3000b, "loginView cannot be null!");
        this.dbu = (dpv) cco.m5996s(com_fossil_dpv, "loginEmailUseCase cannot be null");
        this.daL = (dpt) cco.m5996s(com_fossil_dpt, "downloadUserInfoUseCase cannot be null");
        this.daM = (dpr) cco.m5996s(com_fossil_dpr, "downloadUserInfoUseCase cannot be null");
        this.dbt.cK(this);
        this.cIu = com_fossil_cyq;
        this.daN = com_fossil_dji;
        this.mUseCaseHandler = (ckc) cco.m5996s(com_fossil_ckc, "useCaseHandler cannot be nulL!");
        this.cZv = com_fossil_dlo;
        this.cZw = com_fossil_dlv;
        this.daf = com_fossil_dmm;
        this.dae = com_fossil_dmt;
        this.cJv = com_fossil_cmj;
    }

    public void start() {
        this.daM.ajd();
    }

    public void stop() {
        this.daM.aje();
    }

    public void aH(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            this.dbt.iY(arp.m4318u(PortfolioApp.ZQ(), R.string.Onboarding_Login_Error_Empty_Text_Please_enter_an_email_address));
        } else if (iZ(str) && ja(str2)) {
            this.dbt.asJ();
            this.dbt.afL();
            this.mUseCaseHandler.m6886a(this.dbu, new C3076a(str, str2), new C30031(this));
        } else {
            this.dbt.iY(arp.m4318u(PortfolioApp.ZQ(), R.string.Onboarding_Login_Error_Account_Text_Your_email_or_password_is));
        }
    }

    private boolean iZ(String str) {
        return dra.m9453v(str);
    }

    private boolean ja(String str) {
        return !TextUtils.isEmpty(str) && dra.m9454w(str);
    }

    private void asy() {
        MFLogger.m12670d(TAG, "Inside .onLoginSuccess startOnboardingFlow download user info");
        this.mUseCaseHandler.m6886a(this.daL, new C3072a(), new C30062(this));
    }

    private void iT(String str) {
        this.mUseCaseHandler.m6886a(this.cIu, new C2529a(str), new C30073(this));
    }

    private void aF(final String str, final String str2) {
        this.cEF.m7241a(str, 0, false);
        this.cEF.m7251r(str, true);
        this.mUseCaseHandler.m6886a(this.daN, new C2837a(str), new C2126d<C2839c, C2838b>(this) {
            final /* synthetic */ dnz dbx;

            public /* synthetic */ void onError(Object obj) {
                m9201a((C2838b) obj);
            }

            public /* synthetic */ void onSuccess(Object obj) {
                m9202a((C2839c) obj);
            }

            public void m9202a(C2839c c2839c) {
                this.dbx.iT(str);
                this.dbx.dbt.iS(str2);
            }

            public void m9201a(C2838b c2838b) {
                this.dbx.iT(str);
                this.dbx.dbt.iS(str2);
            }
        });
    }

    public void iW(String str) {
        this.dbv = str;
        if (dra.m9453v(this.dbv)) {
            if (TextUtils.isEmpty(this.dbw) || !dra.m9454w(this.dbw)) {
                this.dbt.asI();
            } else {
                this.dbt.asH();
            }
            this.dbt.de(true);
            return;
        }
        this.dbt.de(false);
    }

    public void iX(String str) {
        this.dbw = str;
        if (dra.m9454w(this.dbw)) {
            if (TextUtils.isEmpty(this.dbv) || !dra.m9453v(this.dbv)) {
                this.dbt.asI();
            } else {
                this.dbt.asH();
            }
            this.dbt.df(true);
            return;
        }
        this.dbt.df(false);
    }

    public void asG() {
        MFUser currentUser = this.mUserRepository.getCurrentUser();
        if (currentUser == null) {
            this.dbt.asK();
        } else if (!currentUser.isOnboardingComplete() && !currentUser.isRegistrationComplete()) {
            this.dbt.asL();
        } else if (TextUtils.isEmpty(PortfolioApp.ZQ().aaa()) && TextUtils.isEmpty(currentUser.getActiveDeviceId())) {
            this.dbt.asM();
        } else {
            this.dbt.asK();
        }
    }

    private void lm(int i) {
        switch (i) {
            case 401:
            case 404:
                this.dbt.iY(arp.m4318u(PortfolioApp.ZQ(), R.string.Onboarding_Login_Error_Account_Text_Your_email_or_password_is));
                return;
            default:
                this.dbt.jV(i);
                return;
        }
    }
}
