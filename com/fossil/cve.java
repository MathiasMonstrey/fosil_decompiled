package com.fossil;

import android.text.TextUtils;
import com.fossil.cvc.C2364a;
import com.fossil.cvc.C2365b;
import com.misfit.frameworks.common.log.MFLogger;
import com.misfit.frameworks.network.manager.MFNetwork;
import com.misfit.frameworks.network.manager.MFNetwork.MFServerResultCallback;
import com.misfit.frameworks.network.responses.MFResponse;
import com.misfit.frameworks.network.utils.NetworkUtils;
import com.portfolio.platform.PortfolioApp;
import com.portfolio.platform.data.model.buddychallenge.BCChallenge;
import com.portfolio.platform.data.model.buddychallenge.BCInvitation;
import com.portfolio.platform.data.model.buddychallenge.BCOpponent;
import com.portfolio.platform.response.buddychallenge.MFGetChallengeResponse;
import com.portfolio.platform.response.buddychallenge.MFUpdateInvitationResponse;

public class cve extends cvf implements C2364a {
    private static final String TAG = cve.class.getSimpleName();
    private C2365b cGY;

    class C23792 implements MFServerResultCallback {
        final /* synthetic */ cve cGZ;

        C23792(cve com_fossil_cve) {
            this.cGZ = com_fossil_cve;
        }

        public void onSuccess(MFResponse mFResponse) {
            MFLogger.m12670d(cve.TAG, " onSuccess");
            BCInvitation invitation = ((MFUpdateInvitationResponse) mFResponse).getInvitation();
            cnq.acd().acw().mo1930b(invitation);
            if (this.cGZ.cGY.isActive()) {
                this.cGZ.cGY.mo2093u(2, invitation.getChallengeId());
            }
        }

        public void onFail(int i, MFResponse mFResponse) {
            MFLogger.m12670d(cve.TAG, " onFailed");
            if (NetworkUtils.isNetworkAvailable(PortfolioApp.ZQ())) {
                MFUpdateInvitationResponse mFUpdateInvitationResponse = (MFUpdateInvitationResponse) mFResponse;
                if (mFUpdateInvitationResponse.getInternalErrorCode() == 400101) {
                    MFLogger.m12670d(cve.TAG, " Invalid invitation");
                } else if (mFUpdateInvitationResponse.getInternalErrorCode() == 400102) {
                    MFLogger.m12670d(cve.TAG, " Expired invitation");
                } else if (mFUpdateInvitationResponse.getInternalErrorCode() == 404001) {
                    MFLogger.m12670d(cve.TAG, " Invitation not found");
                }
                this.cGZ.cGY.mo2093u(3, "");
                return;
            }
            this.cGZ.cGY.jV(601);
        }
    }

    class C23803 implements MFServerResultCallback {
        final /* synthetic */ cve cGZ;

        C23803(cve com_fossil_cve) {
            this.cGZ = com_fossil_cve;
        }

        public void onSuccess(MFResponse mFResponse) {
            MFLogger.m12670d(cve.TAG, "MFGetChallengeRequest onSuccess");
            BCChallenge challenge = ((MFGetChallengeResponse) mFResponse).getChallenge();
            challenge.setPinType(0);
            cnq.acd().acw().mo1921a(challenge);
            if (this.cGZ.cGY.isActive()) {
                this.cGZ.cGY.mo2085d(challenge);
            }
        }

        public void onFail(int i, MFResponse mFResponse) {
            MFLogger.m12670d(cve.TAG, "MFGetChallengeRequest onFailed");
        }
    }

    cve(C2365b c2365b) {
        this.cGY = (C2365b) emj.ce(c2365b);
    }

    public void start() {
        this.cGY.fo();
    }

    public void stop() {
    }

    public void mo2096c(final BCChallenge bCChallenge) {
        if (NetworkUtils.isNetworkAvailable(PortfolioApp.ZQ())) {
            MFNetwork.getInstance(PortfolioApp.ZQ()).execute(new cqz(PortfolioApp.ZQ(), bCChallenge.getChallengeId()), new MFServerResultCallback(this) {
                final /* synthetic */ cve cGZ;

                public void onSuccess(MFResponse mFResponse) {
                    MFLogger.m12670d(cve.TAG, " onSuccess");
                    if (this.cGZ.cGY.isActive()) {
                        this.cGZ.cGY.mo2093u(1, bCChallenge.getChallengeId());
                    }
                }

                public void onFail(int i, MFResponse mFResponse) {
                    MFLogger.m12670d(cve.TAG, " onFailed");
                    if (this.cGZ.cGY.isActive()) {
                        this.cGZ.cGY.jV(i);
                    }
                }
            });
            return;
        }
        this.cGY.jV(601);
    }

    public void mo2094a(BCInvitation bCInvitation, boolean z) {
        int i;
        if (z) {
            i = 1;
        } else {
            i = 2;
        }
        MFNetwork.getInstance(PortfolioApp.ZQ()).execute(new cre(PortfolioApp.ZQ(), bCInvitation.getInvitationId(), i), new C23792(this));
    }

    public void hO(String str) {
        MFLogger.m12670d(TAG, "getChallenge - challengeId=" + str);
        if (!TextUtils.isEmpty(str) && NetworkUtils.isNetworkAvailable(PortfolioApp.ZQ())) {
            MFNetwork.getInstance(PortfolioApp.ZQ()).execute(new cqu(PortfolioApp.ZQ(), str), new C23803(this));
        }
    }

    public void mo2095a(BCOpponent bCOpponent, String str) {
        if (this.cGY.isActive()) {
            this.cGY.mo2084a(bCOpponent, str);
        }
    }
}
