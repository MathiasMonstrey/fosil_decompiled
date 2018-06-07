package com.fossil;

import android.os.AsyncTask;
import android.util.Log;
import com.fossil.cmw.C2213a;
import com.fossil.cmx.C2215a;
import com.fossil.dec.C2693a;
import com.fossil.dec.C2694b;
import com.fossil.ecp.C2701c;
import com.fossil.ecp.C2703b;
import com.google.android.gms.common.api.Status;
import com.jawbone.upplatformsdk.api.response.OauthAccessTokenResponse;
import com.misfit.frameworks.common.log.MFLogger;
import com.misfit.frameworks.network.responses.MFResponse;
import com.portfolio.platform.data.model.MFUser;
import com.portfolio.platform.data.source.UserDataSource.OnUpdateUserComplete;
import com.portfolio.platform.data.source.UserRepository;
import com.portfolio.platform.enums.Integration;
import com.ua.sdk.UaException;
import java.util.List;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class deg implements C2213a, C2215a, C2693a {
    private static final String TAG = deg.class.getSimpleName();
    private ecp cDE;
    private MFUser cRA;
    private cmx cRB;
    private cmw cRC;
    private boolean cRD = true;
    private final C2694b cRy;
    private ckc mUseCaseHandler;
    private UserRepository mUserRepository;

    class C27001 implements OnUpdateUserComplete {
        final /* synthetic */ deg cRE;

        C27001(deg com_fossil_deg) {
            this.cRE = com_fossil_deg;
        }

        public void onComplete(MFResponse mFResponse, boolean z, MFUser mFUser) {
        }
    }

    class C27022 implements C2701c {
        final /* synthetic */ deg cRE;

        C27022(deg com_fossil_deg) {
            this.cRE = com_fossil_deg;
        }

        public void mo2338a(UaException uaException) {
            MFLogger.m12670d(deg.TAG, "setUpUnderAmourRecord - Logged out. Error: " + uaException);
            this.cRE.iv(Integration.UnderArmour.getName());
            this.cRE.cRy.cJ(false);
        }
    }

    class C27043 implements C2703b {
        final /* synthetic */ deg cRE;

        C27043(deg com_fossil_deg) {
            this.cRE = com_fossil_deg;
        }

        public void mo2339a(ekn com_fossil_ekn, UaException uaException) {
            if (uaException == null) {
                MFLogger.m12670d(deg.TAG, "updateUnderAmourRecord - Login completed!");
                this.cRE.anm();
                this.cRE.iu(Integration.UnderArmour.getName());
                this.cRE.cRy.cJ(true);
            }
            this.cRE.cRy.afU();
        }
    }

    class C27054 extends AsyncTask<Void, Void, Void> {
        final /* synthetic */ deg cRE;

        C27054(deg com_fossil_deg) {
            this.cRE = com_fossil_deg;
        }

        protected /* synthetic */ Object doInBackground(Object[] objArr) {
            return m8413c((Void[]) objArr);
        }

        protected Void m8413c(Void... voidArr) {
            try {
                this.cRE.cDE.aCz().mo2903c(ekc.aEc().lW("fossil_q").lV("fossil_q").aEd());
            } catch (UaException e) {
                MFLogger.m12670d(deg.TAG, "setupUaProvider - There was a UA Exception when setting the data source");
                e.printStackTrace();
            }
            return null;
        }
    }

    deg(C2694b c2694b, ckc com_fossil_ckc, UserRepository userRepository, ecp com_fossil_ecp, cmx com_fossil_cmx, cmw com_fossil_cmw) {
        this.cRy = (C2694b) cco.m5996s(c2694b, "view cannot be null!");
        this.mUseCaseHandler = (ckc) cco.m5996s(com_fossil_ckc, "useCaseHandler cannot be null!");
        this.mUserRepository = (UserRepository) cco.m5996s(userRepository, "userRepository cannot be null!");
        this.cDE = (ecp) cco.m5996s(com_fossil_ecp, "ua cannot be null!");
        this.cRB = (cmx) cco.m5996s(com_fossil_cmx, "jawboneHelper cannot be null!");
        this.cRC = (cmw) cco.m5996s(com_fossil_cmw, "googleFitHelper cannot be null!");
    }

    public void ahu() {
        this.cRy.cK(this);
    }

    public void start() {
        Log.d(TAG, "presenter starts");
        this.cRy.cJ(this.cDE.abM());
        this.cRy.cK(this.cRB.abM());
        this.cRy.cL(this.cRC.isConnected());
        this.cRB.m7166a((C2215a) this);
        this.cRC.m7161a((C2213a) this);
        this.cRA = this.mUserRepository.getCurrentUser();
    }

    public void stop() {
        Log.d(TAG, "presenter stop");
        this.mUserRepository.addOrUpdateUser(this.cRA, new C27001(this));
        this.cRB.m7166a(null);
        this.cRC.m7161a(null);
    }

    public void anb() {
        if (this.cDE.abM()) {
            MFLogger.m12670d(TAG, "setUpUnderAmourRecord - Logging out of UA");
            this.cDE.m10480a(new C27022(this));
            return;
        }
        this.cRy.mo2331a(this.cDE);
    }

    public void anc() {
        if (this.cRB.abM()) {
            this.cRB.logout();
            iv(Integration.Jawbone.getName());
            this.cRy.cK(false);
            return;
        }
        this.cRy.ang();
    }

    public void ane() {
        this.cRD = false;
        if (this.cRC.isConnected()) {
            this.cRC.logout();
        } else {
            this.cRC.connect();
        }
    }

    public void is(String str) {
        this.cRy.afT();
        this.cDE.m10479a(str, new C27043(this));
    }

    private void anm() {
        new C27054(this).execute(new Void[0]);
    }

    public void it(String str) {
        this.cRy.afT();
        this.cRB.gm(str);
    }

    public void anf() {
        this.cRC.connect();
    }

    public void ann() {
        this.cRC.disconnect();
        iv(Integration.GoogleFit.getName());
        this.cRy.cL(false);
    }

    public void mo2349b(OauthAccessTokenResponse oauthAccessTokenResponse, Response response) {
        if (oauthAccessTokenResponse.access_token != null) {
            this.cRB.m7167a(oauthAccessTokenResponse);
            MFLogger.m12670d(TAG, "onJBConnectionSuccess - AccessToken: " + oauthAccessTokenResponse.access_token);
            iu(Integration.Jawbone.getName());
            this.cRy.cK(true);
        } else {
            MFLogger.m12670d(TAG, "onJBConnectionSuccess - AccessToken not returned by Oauth call, exiting...");
            this.cRB.logout();
        }
        this.cRy.afU();
    }

    public void mo2342a(RetrofitError retrofitError) {
        MFLogger.m12670d(TAG, "onJBConnectionFailed - Failed to get accessToken: " + retrofitError.getMessage());
        this.cRB.logout();
        this.cRy.afU();
    }

    public void abL() {
        MFLogger.m12670d(TAG, "onGFConnectionSuccess");
        iu(Integration.GoogleFit.getName());
        this.cRy.cL(true);
    }

    public void mo2352m(atn com_fossil_atn) {
        if (!this.cRD) {
            MFLogger.m12670d(TAG, "onGFConnectionFailed - Cause: " + com_fossil_atn.toString());
            if (com_fossil_atn.Ks()) {
                this.cRy.mo2337n(com_fossil_atn);
            } else {
                this.cRy.kW(com_fossil_atn.getErrorCode());
            }
        }
    }

    public void mo2348b(atw<Status> com_fossil_atw_com_google_android_gms_common_api_Status) {
        com_fossil_atw_com_google_android_gms_common_api_Status.mo1169a(new aty<Status>(this, ((ctm) this.cRy).getActivity(), 3) {
            final /* synthetic */ deg cRE;

            public /* synthetic */ void mo2340b(atz com_fossil_atz) {
                m8416q((Status) com_fossil_atz);
            }

            public void m8416q(Status status) {
                if (status.Kb()) {
                    this.cRE.ann();
                } else {
                    this.cRE.cRy.kW(status.getStatusCode());
                }
            }

            public void mo2341f(Status status) {
                this.cRE.cRy.kW(status.getStatusCode());
            }
        });
    }

    private void iu(String str) {
        List integrations = this.cRA.getIntegrations();
        if (!integrations.contains(str)) {
            integrations.add(str);
        }
        this.cRA.setIntegrations(integrations);
    }

    private void iv(String str) {
        List integrations = this.cRA.getIntegrations();
        integrations.remove(str);
        this.cRA.setIntegrations(integrations);
    }
}
