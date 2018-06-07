package com.fossil;

import android.content.Intent;
import android.os.Bundle;
import com.fossil.atv.C1897a;
import com.fossil.atv.C1898b;
import com.fossil.atv.C1899c;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions.a;
import com.google.android.gms.common.api.Status;
import com.misfit.frameworks.common.constants.MFNetworkReturnCode;
import com.misfit.frameworks.common.log.MFLogger;
import com.misfit.frameworks.common.model.Profile;
import com.misfit.frameworks.network.manager.MFNetwork;
import com.misfit.frameworks.network.manager.MFNetwork.MFServerResultCallback;
import com.misfit.frameworks.network.responses.MFLoginResponse;
import com.misfit.frameworks.network.responses.MFResponse;
import com.portfolio.platform.PortfolioApp;
import com.portfolio.platform.data.model.MFUser;
import com.portfolio.platform.data.source.UserRepository;
import com.portfolio.platform.enums.AuthType;
import com.portfolio.platform.response.auth.MFGetCurrentUserResponse;
import java.lang.ref.WeakReference;

public class cnw implements C1898b, C1899c {
    private static final String TAG = cnw.class.getCanonicalName();
    private static cnw cAG;
    private static WeakReference<ctj> cAH;
    private static atv cAI;
    private static GoogleSignInOptions cAJ;
    private static coc cAK;
    UserRepository cAL;
    cnr mSharedPreferencesManager;

    static class C22391 implements aua<Status> {
        C22391() {
        }

        public /* synthetic */ void mo1184a(atz com_fossil_atz) {
            m7275p((Status) com_fossil_atz);
        }

        public void m7275p(Status status) {
            MFLogger.m12670d(cnw.TAG, "Log out google account with status " + status.getStatusMessage());
            cnw.cAI = null;
        }
    }

    class C22413 implements MFServerResultCallback {
        final /* synthetic */ cnw cAN;

        C22413(cnw com_fossil_cnw) {
            this.cAN = com_fossil_cnw;
        }

        public void onSuccess(MFResponse mFResponse) {
            MFGetCurrentUserResponse mFGetCurrentUserResponse = (MFGetCurrentUserResponse) mFResponse;
            MFLogger.m12670d(cnw.TAG, "Step 3: Fetch user data from server success, isRegistrationComplete: " + mFGetCurrentUserResponse.isRegistrationComplete());
            int i = mFGetCurrentUserResponse.isRegistrationComplete() ? 0 : 1;
            if (cnw.cAK != null) {
                cnw.cAK.onLoginSuccess(i);
            }
        }

        public void onFail(int i, MFResponse mFResponse) {
            switch (i) {
                case 401:
                case 404:
                    if (cnw.cAK != null) {
                        cnw.cAK.onLoginSuccess(1);
                        return;
                    }
                    return;
                default:
                    if (cnw.cAK != null) {
                        cnw.cAK.onLoginFailed(i, null);
                        return;
                    }
                    return;
            }
        }
    }

    public cnw() {
        PortfolioApp.ZQ().aam().mo1833a(this);
    }

    public static cnw m7276a(WeakReference<ctj> weakReference) {
        cAH = weakReference;
        if (cAG == null) {
            cAG = new cnw();
        }
        if (cAI == null) {
            cAJ = new a(GoogleSignInOptions.beR).cT(cjy.cnN.aaS()).cU(cjy.cnN.aaS()).JW().JY();
            cAI = new C1897a(PortfolioApp.ZQ().getApplicationContext()).m4466a(arz.beh, cAJ).m4471c(bzp.bfF).KI();
        }
        return cAG;
    }

    public void m7282a(coc com_fossil_coc) {
        cAK = com_fossil_coc;
        if (cAI == null || cAI.isConnected()) {
            adx();
            return;
        }
        cAI.hq(2);
        cAI.mo1307a((C1899c) this);
        cAI.mo1306a((C1898b) this);
    }

    public static void logOut() {
        if (cAI != null && cAI.isConnected()) {
            arz.bem.mo1155b(cAI).mo1169a(new C22391());
        }
    }

    public void mo1273a(atn com_fossil_atn) {
        MFLogger.m12671e(TAG, ".onConnectionFailed google client " + com_fossil_atn.getErrorMessage());
        if (cAK != null) {
            cAK.onLoginFailed(MFNetworkReturnCode.INTERNAL_SERVER_ERROR, com_fossil_atn);
        }
    }

    public boolean onActivityResult(int i, int i2, Intent intent) {
        MFLogger.m12670d(TAG, "Inside .onActivityResult requestCode=" + i + ", resultCode=" + i2);
        if (i == 922) {
            if (intent != null) {
                ase h = arz.bem.mo1157h(intent);
                m7277a(h);
                MFLogger.m12670d(TAG, "Inside .onActivityResult googleSignInResult=" + h.Ka());
            } else {
                m7277a(null);
            }
        }
        return true;
    }

    private void m7277a(ase com_fossil_ase) {
        int i = MFNetworkReturnCode.INTERNAL_SERVER_ERROR;
        if (com_fossil_ase == null) {
            adw();
            if (cAK != null) {
                cAK.onLoginFailed(MFNetworkReturnCode.INTERNAL_SERVER_ERROR, null);
            }
        } else if (com_fossil_ase.Kb()) {
            final MFUser mFUser = new MFUser();
            GoogleSignInAccount JZ = com_fossil_ase.JZ();
            MFLogger.m12670d(TAG, "Step 1: Login using google success");
            this.mSharedPreferencesManager.gH(JZ.JL());
            mFUser.setAuthType(AuthType.GOOGLE.getValue());
            mFUser.setEmail(JZ.getEmail());
            MFLogger.m12670d(TAG, "Google user email is " + JZ.getEmail());
            if (cAI != null && cAI.isConnected() && cAI.mo1309b(bzp.bfF)) {
                MFLogger.m12670d(TAG, "Start get user first and last name");
                caa h = bzp.bJS.mo1469h(cAI);
                if (h != null) {
                    mFUser.setFirstName(h.Sv().JM());
                    MFLogger.m12670d(TAG, "Google user first name is " + h.Sv().JM());
                    mFUser.setLastName(h.Sv().JN());
                    MFLogger.m12670d(TAG, "Google user last name is " + h.Sv().JN());
                } else {
                    MFLogger.m12671e(TAG, "Person is null, can't get last and first name");
                }
            } else {
                MFLogger.m12671e(TAG, "Error when get persion, Plus API is not connected");
            }
            MFNetwork.getInstance(PortfolioApp.ZQ()).execute(new cqk(PortfolioApp.ZQ()), new MFServerResultCallback(this) {
                final /* synthetic */ cnw cAN;

                public void onSuccess(MFResponse mFResponse) {
                    MFLoginResponse mFLoginResponse = (MFLoginResponse) mFResponse;
                    Profile profile = mFLoginResponse.getProfile();
                    if (mFLoginResponse != null) {
                        mFUser.setCreatedAt(profile.getCreatedAt());
                        mFUser.setUserAccessToken(profile.getAccessToken());
                        mFUser.setUserId(profile.getUid());
                        mFUser.setObjectId(profile.getObjectId());
                        PortfolioApp.ZQ().aam().YV().setUserAccessToken(mFLoginResponse.getProfile().getAccessToken());
                        this.cAN.cAL.addOrUpdateUser(mFUser, null);
                    }
                    MFLogger.m12670d(cnw.TAG, "Step 2: Login server using google token success");
                    this.cAN.adv();
                }

                public void onFail(int i, MFResponse mFResponse) {
                    MFLogger.m12671e(cnw.TAG, "Log in google error " + i);
                    this.cAN.adw();
                    if (cnw.cAK != null) {
                        cnw.cAK.onLoginFailed(i, null);
                    }
                }
            });
        } else {
            adw();
            if (com_fossil_ase.Ka().getStatusCode() == 12501) {
                i = 2;
            }
            if (cAK != null) {
                cAK.onLoginFailed(i, null);
            }
        }
    }

    private void adv() {
        MFNetwork.getInstance(PortfolioApp.ZQ()).execute(new cqe(PortfolioApp.ZQ()), new C22413(this));
    }

    private void adw() {
        if (cAI != null && cAI.isConnected()) {
            cAI.disconnect();
        }
    }

    public void mo1284l(Bundle bundle) {
        if (cAI != null && cAH != null && cAH.get() != null) {
            ((ctj) cAH.get()).startActivityForResult(arz.bem.mo1154a(cAI), 922);
        } else if (cAK != null) {
            cAK.onLoginFailed(MFNetworkReturnCode.INTERNAL_SERVER_ERROR, null);
        }
    }

    private void adx() {
        logOut();
        if (cAI != null && cAH != null && cAH.get() != null) {
            ((ctj) cAH.get()).startActivityForResult(arz.bem.mo1154a(cAI), 922);
        } else if (cAK != null) {
            cAK.onLoginFailed(MFNetworkReturnCode.INTERNAL_SERVER_ERROR, null);
        }
    }

    public void hr(int i) {
        MFLogger.m12671e(TAG, "Connection was supedned");
    }
}
