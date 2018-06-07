package com.fossil;

import android.text.TextUtils;
import com.fossil.ckb.C2126d;
import com.fossil.ckb.C2133c;
import com.fossil.dlv.C2946a;
import com.fossil.dmt.C2974a;
import com.fossil.dok.C3012a;
import com.fossil.dok.C3013b;
import com.fossil.dqh.C3101a;
import com.fossil.dqh.C3102b;
import com.fossil.wearables.fossil.R;
import com.misfit.frameworks.common.constants.MFNetworkReturnCode;
import com.misfit.frameworks.common.log.MFLogger;
import com.misfit.frameworks.network.responses.MFResponse;
import com.portfolio.platform.PortfolioApp;
import com.portfolio.platform.data.model.MFUser;
import com.portfolio.platform.data.source.DeviceRepository;
import com.portfolio.platform.data.source.UserDataSource.OnUpdateUserComplete;
import com.portfolio.platform.data.source.UserRepository;
import com.portfolio.platform.enums.AuthType;
import com.portfolio.platform.enums.Gender;
import com.portfolio.platform.util.URLHelper;
import com.portfolio.platform.util.URLHelper.StaticPage;
import java.util.Calendar;
import java.util.Date;
import org.joda.time.LocalDate;
import org.joda.time.Years;

public class doo implements C3012a {
    private static final String TAG = doo.class.getSimpleName();
    private cmj cJv;
    private final dlv cZw;
    private final dmt dae;
    private String dbv;
    private String dbw;
    private C3013b dcf;
    private dqh dcg;
    private String dch;
    private String dci;
    private String dcj;
    private String dck;
    private boolean dcl;
    private boolean dcm;
    private Calendar dcn;
    private AuthType dco = AuthType.EMAIL;
    DeviceRepository mDeviceRepository;
    private cnr mSharedPreferencesManager;
    private ckc mUseCaseHandler;
    UserRepository mUserRepository;

    class C30201 implements C2126d<C2133c, C3102b> {
        final /* synthetic */ doo dcp;

        C30201(doo com_fossil_doo) {
            this.dcp = com_fossil_doo;
        }

        public /* synthetic */ void onError(Object obj) {
            m9242a((C3102b) obj);
        }

        public /* synthetic */ void onSuccess(Object obj) {
            m9241a((C2133c) obj);
        }

        public void m9241a(C2133c c2133c) {
            MFUser currentUser = this.dcp.mUserRepository.getCurrentUser();
            if (currentUser != null) {
                this.dcp.m9250h(currentUser);
                return;
            }
            this.dcp.dcf.afM();
            this.dcp.dcf.jV(MFNetworkReturnCode.INTERNAL_SERVER_ERROR);
        }

        public void m9242a(C3102b c3102b) {
            MFLogger.m12670d(doo.TAG, "Inside .signUpEmail failed with error=" + c3102b.getErrorCode());
            this.dcp.dcf.afM();
            switch (c3102b.getErrorCode()) {
                case MFNetworkReturnCode.ITEM_NAME_IN_USED /*409*/:
                    this.dcp.dcf.asY();
                    return;
                default:
                    this.dcp.dcf.jV(c3102b.getErrorCode());
                    return;
            }
        }
    }

    class C30212 implements OnUpdateUserComplete {
        final /* synthetic */ doo dcp;

        C30212(doo com_fossil_doo) {
            this.dcp = com_fossil_doo;
        }

        public void onComplete(MFResponse mFResponse, boolean z, MFUser mFUser) {
            this.dcp.dcf.afM();
            this.dcp.mUserRepository.onboardingComplete();
            if (!z || mFUser == null) {
                this.dcp.dcf.jV(mFResponse.getHttpReturnCode());
            } else {
                this.dcp.dcf.asZ();
                String acQ = this.dcp.mSharedPreferencesManager.acQ();
                if (TextUtils.isEmpty(acQ)) {
                    acQ = "Email";
                }
                this.dcp.cJv.ap("Auth", acQ);
                this.dcp.cJv.m7086l("signup_success", "Auth", acQ);
                this.dcp.mSharedPreferencesManager.gK("");
                Date date = new Date();
                this.dcp.mUseCaseHandler.m6886a(this.dcp.cZw, new C2946a(date, true), null);
                this.dcp.mUseCaseHandler.m6886a(this.dcp.dae, new C2974a(date, true), null);
            }
            this.dcp.mDeviceRepository.fetchSupportedSkus();
        }
    }

    public doo(C3013b c3013b, dqh com_fossil_dqh, ckc com_fossil_ckc, dlv com_fossil_dlv, dmt com_fossil_dmt, cnr com_fossil_cnr, cmj com_fossil_cmj) {
        this.dcf = (C3013b) cco.m5996s(c3013b, "profileSetupView cannot be null!");
        this.dcf.cK(this);
        this.dcg = com_fossil_dqh;
        this.mUseCaseHandler = (ckc) cco.m5996s(com_fossil_ckc, "useCaseHandler cannot be nulL!");
        this.cZw = (dlv) cco.m5996s(com_fossil_dlv, "fetchSummaries cannot be nulL!");
        this.dae = (dmt) cco.m5996s(com_fossil_dmt, "fetchSleepSummaries cannot be nulL!");
        this.mSharedPreferencesManager = (cnr) cco.m5996s(com_fossil_cnr, "sharedPreferencesManager cannot be nulL!");
        this.cJv = com_fossil_cmj;
    }

    public void start() {
        MFUser currentUser = this.mUserRepository.getCurrentUser();
        if (currentUser != null) {
            this.dcf.mo2625g(currentUser);
            this.dcf.ata();
            this.dcf.atb();
            this.dco = currentUser.getAuthType();
            if (TextUtils.isEmpty(currentUser.getEmail())) {
                this.dcf.atc();
            }
        }
        if (TextUtils.isEmpty(this.dcj)) {
            mo2630b(Gender.FEMALE);
            this.dcf.mo2613a(Gender.FEMALE);
        }
    }

    public void stop() {
    }

    public void jb(String str) {
        this.dch = str;
        atf();
    }

    public void jc(String str) {
        this.dci = str;
        atf();
    }

    public void iW(String str) {
        if (TextUtils.isEmpty(str)) {
            this.dbv = str;
        } else {
            this.dbv = str.trim();
        }
        atf();
    }

    public void jd(String str) {
        this.dbw = str;
        atf();
    }

    public void mo2627a(String str, Calendar calendar) {
        this.dck = str;
        this.dcn = calendar;
        atf();
    }

    public void dg(boolean z) {
        this.dcl = z;
        atf();
    }

    public void dh(boolean z) {
        this.dcm = z;
    }

    public void mo2630b(Gender gender) {
        this.dcj = gender.toString();
        atf();
    }

    public void asW() {
        if (atj()) {
            this.dcf.dd(true);
            if (ati()) {
                this.dcf.di(true);
                if (atl()) {
                    this.dcf.dj(true);
                    this.dcf.afL();
                    if (this.dco == AuthType.EMAIL) {
                        this.mUseCaseHandler.m6886a(this.dcg, new C3101a(this.dbv, this.dbw), new C30201(this));
                        return;
                    } else {
                        m9250h(getCurrentUser());
                        return;
                    }
                }
                this.dcf.dj(false);
                return;
            }
            this.dcf.di(false);
            return;
        }
        this.dcf.dd(false);
    }

    private void atf() {
        if (!atg()) {
            this.dcf.dk(false);
        } else if (!ath()) {
            this.dcf.dk(false);
        } else if (!atm()) {
            this.dcf.dk(false);
        } else if (atk()) {
            this.dcf.dk(true);
        } else {
            this.dcf.dk(false);
        }
    }

    public String asX() {
        CharSequence a = URLHelper.a(StaticPage.TERMS, null);
        CharSequence a2 = URLHelper.a(StaticPage.PRIVACY, null);
        return PortfolioApp.ZQ().getText(R.string.Onboarding_Account_Signup_Email_Text_By_creating_an_account_you).toString().replace("term_of_use_url", a).replace("privacy_policy", a2);
    }

    public MFUser getCurrentUser() {
        return this.mUserRepository.getCurrentUser();
    }

    private void m9250h(MFUser mFUser) {
        mFUser.setFirstName(this.dch);
        mFUser.setLastName(this.dci);
        mFUser.setBirthday(this.dck);
        mFUser.setDiagnosticEnabled(this.dcm);
        mFUser.setGender(this.dcj);
        mFUser.setEmail(this.dbv);
        mFUser.setOnboardingComplete(true);
        this.mUserRepository.addOrUpdateUser(mFUser, new C30212(this));
    }

    private boolean atg() {
        return !TextUtils.isEmpty(this.dch);
    }

    private boolean ath() {
        return !TextUtils.isEmpty(this.dci);
    }

    private boolean ati() {
        return (this.dco == AuthType.EMAIL && getCurrentUser() == null && (TextUtils.isEmpty(this.dbw) || !dra.m9454w(this.dbw))) ? false : true;
    }

    private boolean atj() {
        return !TextUtils.isEmpty(this.dbv) && dra.m9453v(this.dbv);
    }

    private boolean atk() {
        return !TextUtils.isEmpty(this.dcj);
    }

    private boolean atl() {
        if (this.dcn == null || Years.yearsBetween(LocalDate.fromCalendarFields(this.dcn), LocalDate.now()).getYears() < 14) {
            return false;
        }
        return true;
    }

    private boolean atm() {
        return this.dcl;
    }
}
