package com.fossil;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
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
import com.sina.weibo.sdk.auth.sso.SsoHandler;
import com.sina.weibo.sdk.exception.WeiboException;

public class coa {
    private static final String TAG = coa.class.getSimpleName();
    private static coa cAV = new coa();
    private String aHF;
    private boolean cAP;
    private String cAW;
    private String cAX;
    private SsoHandler cAY;
    cnr mSharedPreferencesManager;
    UserRepository mUserRepository;

    public coa() {
        PortfolioApp.ZQ().aam().mo1835a(this);
    }

    public void m7333m(String str, String str2, String str3) {
        this.aHF = str;
        this.cAW = str2;
        this.cAX = str3;
    }

    public void m7331a(int i, int i2, Intent intent) {
        if (this.cAY != null) {
            this.cAY.a(i, i2, intent);
        }
    }

    public static coa adD() {
        return cAV;
    }

    public void m7332c(final Activity activity, final coc com_fossil_coc) {
        try {
            this.cAP = false;
            final Handler handler = new Handler(Looper.getMainLooper());
            handler.postDelayed(new Runnable(this) {
                final /* synthetic */ coa cAZ;

                public void run() {
                    if (!this.cAZ.cAP) {
                        com_fossil_coc.onLoginFailed(MFNetworkReturnCode.INTERNAL_SERVER_ERROR, null);
                    }
                }
            }, 60000);
            this.cAY = new SsoHandler(activity, new dsn(activity, this.aHF, this.cAW, this.cAX));
            this.cAY.a(new dsp(this) {
                final /* synthetic */ coa cAZ;

                public void mo1909G(Bundle bundle) {
                    this.cAZ.cAP = true;
                    handler.removeCallbacksAndMessages(null);
                    String token = dso.m9625K(bundle).getToken();
                    MFLogger.m12670d(coa.TAG, "Weibo step 1: Get access token from weibo success: " + token);
                    this.cAZ.m7326a(activity, token, com_fossil_coc);
                }

                public void mo1910a(WeiboException weiboException) {
                    this.cAZ.cAP = true;
                    handler.removeCallbacksAndMessages(null);
                    MFLogger.m12670d(coa.TAG, "Weibo login failed - ex=" + weiboException.toString());
                    com_fossil_coc.onLoginFailed(MFNetworkReturnCode.INTERNAL_SERVER_ERROR, null);
                }

                public void onCancel() {
                    this.cAZ.cAP = true;
                    handler.removeCallbacksAndMessages(null);
                    com_fossil_coc.onLoginFailed(2, null);
                }
            });
        } catch (Exception e) {
            MFLogger.m12670d(TAG, "Weibo login failed - ex=" + e.toString());
            com_fossil_coc.onLoginFailed(MFNetworkReturnCode.INTERNAL_SERVER_ERROR, null);
        }
    }

    private void m7326a(final Context context, String str, final coc com_fossil_coc) {
        this.mSharedPreferencesManager.gJ(str);
        MFNetwork.getInstance(context.getApplicationContext()).execute(new cqm(context.getApplicationContext()), new MFServerResultCallback(this) {
            final /* synthetic */ coa cAZ;

            public void onSuccess(MFResponse mFResponse) {
                MFLoginResponse mFLoginResponse = (MFLoginResponse) mFResponse;
                if (mFLoginResponse != null) {
                    Profile profile = mFLoginResponse.getProfile();
                    MFUser mFUser = new MFUser();
                    mFUser.setUserAccessToken(profile.getAccessToken());
                    mFUser.setUserId(profile.getUid());
                    mFUser.setObjectId(profile.getObjectId());
                    mFUser.setAuthType(AuthType.WEIBO.getValue());
                    PortfolioApp.ZQ().aam().YV().setUserAccessToken(mFLoginResponse.getProfile().getAccessToken());
                    this.cAZ.mUserRepository.addOrUpdateUser(mFUser, null);
                }
                MFLogger.m12670d(coa.TAG, "Weibo step 2: Login server with weibo token success");
                this.cAZ.m7325a(context, com_fossil_coc);
            }

            public void onFail(int i, MFResponse mFResponse) {
                MFLogger.m12671e(coa.TAG, "Weibo Log in fail " + i);
                com_fossil_coc.onLoginFailed(i, null);
            }
        });
    }

    private void m7325a(Context context, final coc com_fossil_coc) {
        MFNetwork.getInstance(context).execute(new cqe(context), new MFServerResultCallback(this) {
            final /* synthetic */ coa cAZ;

            public void onSuccess(MFResponse mFResponse) {
                MFGetCurrentUserResponse mFGetCurrentUserResponse = (MFGetCurrentUserResponse) mFResponse;
                MFLogger.m12670d(coa.TAG, "Step 3: Fetch user data from server success, isRegistrationComplete: " + mFGetCurrentUserResponse.isRegistrationComplete());
                int i = mFGetCurrentUserResponse.isRegistrationComplete() ? 0 : 1;
                if (com_fossil_coc != null) {
                    com_fossil_coc.onLoginSuccess(i);
                }
            }

            public void onFail(int i, MFResponse mFResponse) {
                switch (i) {
                    case 401:
                    case 404:
                        if (com_fossil_coc != null) {
                            com_fossil_coc.onLoginSuccess(1);
                            return;
                        }
                        return;
                    default:
                        if (com_fossil_coc != null) {
                            com_fossil_coc.onLoginFailed(i, null);
                            return;
                        }
                        return;
                }
            }
        });
    }
}
