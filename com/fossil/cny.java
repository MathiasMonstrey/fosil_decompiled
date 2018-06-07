package com.fossil;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.fossil.drj.C2244a;
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
import com.portfolio.platform.response.auth.MFGetWechatAccessTokenResponse;
import com.portfolio.platform.response.user.MFGetWechatUserInfoResponse;
import java.util.concurrent.ExecutionException;

public class cny implements dyu {
    private static final String TAG = cny.class.getSimpleName();
    private static cny cAO = new cny();
    private boolean cAP;
    cnr mSharedPreferencesManager;
    UserRepository mUserRepository;
    private String openId;

    public cny() {
        PortfolioApp.ZQ().aam().mo1834a(this);
    }

    public void aw(String str, String str2) {
        drj.auQ().setAppId(str);
        drj.auQ().jv(str2);
    }

    public static cny adz() {
        return cAO;
    }

    public void onNewIntent(Intent intent) {
        drj.auQ().m9485a(intent, (dyu) this);
    }

    public void m7300b(final Activity activity, final coc com_fossil_coc) {
        drj.auQ().initialize(activity);
        drj.auQ().m9485a(activity.getIntent(), (dyu) this);
        this.cAP = false;
        final Handler handler = new Handler(Looper.getMainLooper());
        handler.postDelayed(new Runnable(this) {
            final /* synthetic */ cny cAQ;

            public void run() {
                if (!this.cAQ.cAP) {
                    com_fossil_coc.onLoginFailed(MFNetworkReturnCode.INTERNAL_SERVER_ERROR, null);
                }
            }
        }, 120000);
        drj.auQ().m9484a((Context) activity, new C2244a(this) {
            final /* synthetic */ cny cAQ;

            class C22431 implements MFServerResultCallback {
                final /* synthetic */ C22452 cAR;

                C22431(C22452 c22452) {
                    this.cAR = c22452;
                }

                public void onSuccess(MFResponse mFResponse) {
                    MFGetWechatAccessTokenResponse mFGetWechatAccessTokenResponse = (MFGetWechatAccessTokenResponse) mFResponse;
                    String accessToken = mFGetWechatAccessTokenResponse.getAccessToken();
                    this.cAR.cAQ.openId = mFGetWechatAccessTokenResponse.getOpenId();
                    MFLogger.m12670d(cny.TAG, "Wechat step 2: Get access token from wechat success: " + accessToken);
                    this.cAR.cAQ.m7291a(activity, accessToken, com_fossil_coc);
                }

                public void onFail(int i, MFResponse mFResponse) {
                    com_fossil_coc.onLoginFailed(MFNetworkReturnCode.INTERNAL_SERVER_ERROR, null);
                }
            }

            public void gY(String str) {
                this.cAQ.cAP = true;
                handler.removeCallbacksAndMessages(null);
                MFLogger.m12670d(cny.TAG, "Wechat onAuthSuccess: " + str);
                MFLogger.m12670d(cny.TAG, "Wechat step 1: Login using wechat success");
                MFNetwork.getInstance(activity.getApplicationContext()).execute(new cqf(activity.getApplicationContext(), str, drj.auQ().auR(), drj.auQ().getAppId()), new C22431(this));
            }

            public void adA() {
                this.cAQ.cAP = true;
                handler.removeCallbacksAndMessages(null);
                MFLogger.m12670d(cny.TAG, "Wechat onAuthCancel");
                com_fossil_coc.onLoginFailed(2, null);
            }

            public void adB() {
                this.cAQ.cAP = true;
                handler.removeCallbacksAndMessages(null);
                MFLogger.m12670d(cny.TAG, "Wechat onAuthFailed");
                com_fossil_coc.onLoginFailed(MFNetworkReturnCode.INTERNAL_SERVER_ERROR, null);
            }

            public void adC() {
                this.cAQ.cAP = true;
                handler.removeCallbacksAndMessages(null);
                MFLogger.m12670d(cny.TAG, "Wechat onAuthAppNotInstalled");
                com_fossil_coc.onLoginFailed(MFNetworkReturnCode.INTERNAL_SERVER_ERROR, null);
            }
        });
    }

    private void m7291a(final Context context, String str, final coc com_fossil_coc) {
        this.mSharedPreferencesManager.gI(str);
        MFNetwork.getInstance(context.getApplicationContext()).execute(new cql(context.getApplicationContext()), new MFServerResultCallback(this) {
            final /* synthetic */ cny cAQ;

            public void onSuccess(MFResponse mFResponse) {
                MFLoginResponse mFLoginResponse = (MFLoginResponse) mFResponse;
                if (mFLoginResponse != null) {
                    Profile profile = mFLoginResponse.getProfile();
                    MFUser mFUser = new MFUser();
                    mFUser.setUserAccessToken(profile.getAccessToken());
                    mFUser.setUserId(profile.getUid());
                    mFUser.setObjectId(profile.getObjectId());
                    mFUser.setAuthType(AuthType.WECHAT.getValue());
                    PortfolioApp.ZQ().aam().YV().setUserAccessToken(mFLoginResponse.getProfile().getAccessToken());
                    this.cAQ.mUserRepository.addOrUpdateUser(mFUser, null);
                }
                MFLogger.m12670d(cny.TAG, "Wechat step 3: Login server with wechat token success");
                this.cAQ.m7289a(context, com_fossil_coc);
            }

            public void onFail(int i, MFResponse mFResponse) {
                MFLogger.m12671e(cny.TAG, "Wechat Log in fail " + i);
                com_fossil_coc.onLoginFailed(i, null);
            }
        });
    }

    private void m7289a(final Context context, final coc com_fossil_coc) {
        MFNetwork.getInstance(context).execute(new cqe(context), new MFServerResultCallback(this) {
            final /* synthetic */ cny cAQ;

            public void onSuccess(MFResponse mFResponse) {
                MFGetCurrentUserResponse mFGetCurrentUserResponse = (MFGetCurrentUserResponse) mFResponse;
                MFLogger.m12670d(cny.TAG, "Step 3: Fetch user data from server success, isRegistrationComplete: " + mFGetCurrentUserResponse.isRegistrationComplete());
                if (mFGetCurrentUserResponse.isRegistrationComplete()) {
                    com_fossil_coc.onLoginSuccess(0);
                } else {
                    this.cAQ.m7290a(context, com_fossil_coc, this.cAQ.mSharedPreferencesManager.acO(), this.cAQ.openId, PortfolioApp.ZQ().getLocale().replace("-", "_"));
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

    private void m7290a(Context context, final coc com_fossil_coc, String str, String str2, String str3) {
        MFNetwork.getInstance(context).execute(new csr(context, str, str2, str3), new MFServerResultCallback(this) {
            final /* synthetic */ cny cAQ;

            public void onSuccess(MFResponse mFResponse) {
                final MFGetWechatUserInfoResponse mFGetWechatUserInfoResponse = (MFGetWechatUserInfoResponse) mFResponse;
                final MFUser currentUser = this.cAQ.mUserRepository.getCurrentUser();
                if (mFGetWechatUserInfoResponse != null && currentUser != null) {
                    new Thread(new Runnable(this) {
                        final /* synthetic */ C22495 cAU;

                        public void run() {
                            Exception e;
                            try {
                                currentUser.setProfilePicture(dqq.m9401t((Bitmap) tx.G(PortfolioApp.ZQ()).ah(mFGetWechatUserInfoResponse.getProfilePicture()).tA().a(DiskCacheStrategy.NONE).ay(true).bc(640, 640).get()));
                                return;
                            } catch (InterruptedException e2) {
                                e = e2;
                            } catch (ExecutionException e3) {
                                e = e3;
                            }
                            e.printStackTrace();
                        }
                    }).start();
                    currentUser.setGender(mFGetWechatUserInfoResponse.getSexString());
                    this.cAQ.mUserRepository.addOrUpdateUser(currentUser, null);
                    com_fossil_coc.onLoginSuccess(1);
                }
            }

            public void onFail(int i, MFResponse mFResponse) {
                com_fossil_coc.onLoginFailed(MFNetworkReturnCode.INTERNAL_SERVER_ERROR, null);
            }
        });
    }

    public void mo1901a(dyg com_fossil_dyg) {
        drj.auQ().mo1901a(com_fossil_dyg);
    }

    public void mo1902a(dyh com_fossil_dyh) {
        drj.auQ().mo1902a(com_fossil_dyh);
    }
}
