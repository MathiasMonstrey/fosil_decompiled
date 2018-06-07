package com.portfolio.platform.data.source.remote;

import android.app.Activity;
import android.text.TextUtils;
import com.fossil.atn;
import com.fossil.cjy;
import com.fossil.cnu;
import com.fossil.cnw;
import com.fossil.cny;
import com.fossil.coa;
import com.fossil.coc;
import com.fossil.cqd;
import com.fossil.cqe;
import com.fossil.cqg;
import com.fossil.cqi;
import com.fossil.cqn;
import com.fossil.cqo;
import com.fossil.cqp;
import com.fossil.cro;
import com.fossil.csm;
import com.fossil.ctj;
import com.fossil.jt;
import com.misfit.frameworks.common.constants.MFNetworkReturnCode;
import com.misfit.frameworks.common.log.MFLogger;
import com.misfit.frameworks.network.manager.MFNetwork;
import com.misfit.frameworks.network.manager.MFNetwork.MFServerResultCallback;
import com.misfit.frameworks.network.responses.MFLoginResponse;
import com.misfit.frameworks.network.responses.MFResponse;
import com.portfolio.platform.PortfolioApp;
import com.portfolio.platform.data.model.MFUser;
import com.portfolio.platform.data.source.UserDataSource;
import com.portfolio.platform.data.source.UserDataSource$OnDeleteUserComplete;
import com.portfolio.platform.data.source.UserDataSource$OnLoadStatisticComplete;
import com.portfolio.platform.data.source.UserDataSource$OnLoadUserInfoComplete;
import com.portfolio.platform.data.source.UserDataSource$OnLoginEmailComplete;
import com.portfolio.platform.data.source.UserDataSource$OnLoginSocialComplete;
import com.portfolio.platform.data.source.UserDataSource$OnLogoutUserComplete;
import com.portfolio.platform.data.source.UserDataSource$OnSignUpEmailComplete;
import com.portfolio.platform.data.source.UserDataSource$OnUpdateUserComplete;
import com.portfolio.platform.helper.DeviceHelper;
import com.portfolio.platform.response.auth.MFGetCurrentUserResponse;
import com.portfolio.platform.response.fitness.MFActivityStatisticRespond;
import com.portfolio.platform.response.sleep.MFSleepStatisticRespond;
import java.lang.ref.WeakReference;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

public class UserRemoteDataSource implements UserDataSource {
    private static final String TAG = UserRemoteDataSource.class.getSimpleName();

    static final class ServerResultCallback implements MFServerResultCallback {
        private UserDataSource$OnLoginEmailComplete mLoginEmailCallback;
        private int mLoginType;
        private UserDataSource$OnDeleteUserComplete mOnDeleteUserCallback;
        private UserDataSource$OnLoadStatisticComplete mOnLoadStatisticCompleteCallback;
        private UserDataSource$OnLoadUserInfoComplete mOnLoadUserInfoCallback;
        private UserDataSource$OnLogoutUserComplete mOnLogoutUserCompleteCallback;
        private UserDataSource$OnSignUpEmailComplete mOnSignUpEmailCallback;
        private UserDataSource$OnUpdateUserComplete mOnUpdateUserCallback;

        ServerResultCallback(int i, UserDataSource$OnLogoutUserComplete userDataSource$OnLogoutUserComplete) {
            this(i);
            this.mOnLogoutUserCompleteCallback = userDataSource$OnLogoutUserComplete;
        }

        ServerResultCallback(int i) {
            this.mLoginType = i;
        }

        ServerResultCallback(int i, UserDataSource$OnLoginEmailComplete userDataSource$OnLoginEmailComplete) {
            this(i);
            this.mLoginEmailCallback = userDataSource$OnLoginEmailComplete;
        }

        ServerResultCallback(int i, UserDataSource$OnLoadUserInfoComplete userDataSource$OnLoadUserInfoComplete) {
            this(i);
            this.mOnLoadUserInfoCallback = userDataSource$OnLoadUserInfoComplete;
        }

        ServerResultCallback(int i, UserDataSource$OnUpdateUserComplete userDataSource$OnUpdateUserComplete) {
            this(i);
            this.mOnUpdateUserCallback = userDataSource$OnUpdateUserComplete;
        }

        ServerResultCallback(int i, UserDataSource$OnDeleteUserComplete userDataSource$OnDeleteUserComplete) {
            this(i);
            this.mOnDeleteUserCallback = userDataSource$OnDeleteUserComplete;
        }

        ServerResultCallback(int i, UserDataSource$OnSignUpEmailComplete userDataSource$OnSignUpEmailComplete) {
            this(i);
            this.mOnSignUpEmailCallback = userDataSource$OnSignUpEmailComplete;
        }

        ServerResultCallback(int i, UserDataSource$OnLoadStatisticComplete userDataSource$OnLoadStatisticComplete) {
            this(i);
            this.mOnLoadStatisticCompleteCallback = userDataSource$OnLoadStatisticComplete;
        }

        public void onSuccess(MFResponse mFResponse) {
            MFGetCurrentUserResponse mFGetCurrentUserResponse;
            switch (this.mLoginType) {
                case 8:
                    if (this.mLoginEmailCallback != null) {
                        this.mLoginEmailCallback.onLoginComplete((MFLoginResponse) mFResponse, true, 0);
                        return;
                    }
                    return;
                case 9:
                    mFGetCurrentUserResponse = (MFGetCurrentUserResponse) mFResponse;
                    if (this.mOnLoadUserInfoCallback != null) {
                        this.mOnLoadUserInfoCallback.onComplete(mFGetCurrentUserResponse, mFGetCurrentUserResponse.getCurrentUser());
                        return;
                    }
                    return;
                case 10:
                    mFGetCurrentUserResponse = (MFGetCurrentUserResponse) mFResponse;
                    if (this.mOnUpdateUserCallback != null) {
                        this.mOnUpdateUserCallback.onComplete(mFGetCurrentUserResponse, true, mFGetCurrentUserResponse.getCurrentUser());
                        return;
                    }
                    return;
                case 11:
                    if (this.mOnDeleteUserCallback != null) {
                        this.mOnDeleteUserCallback.onSuccess();
                        return;
                    }
                    return;
                case 12:
                    if (this.mOnSignUpEmailCallback != null) {
                        this.mOnSignUpEmailCallback.onSignUpEmailComplete((MFLoginResponse) mFResponse, true);
                        return;
                    }
                    return;
                case 15:
                    if (this.mOnLogoutUserCompleteCallback != null) {
                        this.mOnLogoutUserCompleteCallback.onSuccess();
                        return;
                    }
                    return;
                case 16:
                    if (this.mOnLoadStatisticCompleteCallback != null) {
                        this.mOnLoadStatisticCompleteCallback.onSuccess((int) ((MFActivityStatisticRespond) mFResponse).getAvgSteps(), 0);
                        return;
                    }
                    return;
                case 17:
                    if (this.mOnLoadStatisticCompleteCallback != null) {
                        this.mOnLoadStatisticCompleteCallback.onSuccess(0, (int) ((MFSleepStatisticRespond) mFResponse).getAvgSleepMinutes());
                        return;
                    }
                    return;
                default:
                    return;
            }
        }

        public void onFail(int i, MFResponse mFResponse) {
            switch (this.mLoginType) {
                case 8:
                    if (this.mLoginEmailCallback == null) {
                        return;
                    }
                    if (mFResponse instanceof MFLoginResponse) {
                        MFLoginResponse mFLoginResponse = (MFLoginResponse) mFResponse;
                        this.mLoginEmailCallback.onLoginComplete(mFLoginResponse, false, mFLoginResponse.getHttpReturnCode());
                        return;
                    }
                    this.mLoginEmailCallback.onLoginComplete(null, false, MFNetworkReturnCode.INTERNAL_SERVER_ERROR);
                    return;
                case 9:
                    if (this.mOnLoadUserInfoCallback != null) {
                        this.mOnLoadUserInfoCallback.onComplete(mFResponse, null);
                        return;
                    }
                    return;
                case 10:
                    if (this.mOnUpdateUserCallback == null) {
                        return;
                    }
                    if (mFResponse instanceof MFGetCurrentUserResponse) {
                        MFGetCurrentUserResponse mFGetCurrentUserResponse = (MFGetCurrentUserResponse) mFResponse;
                        this.mOnUpdateUserCallback.onComplete(mFGetCurrentUserResponse, false, mFGetCurrentUserResponse.getCurrentUser());
                        return;
                    }
                    if (!PortfolioApp.ZQ().aak()) {
                        mFResponse.setHttpReturnCode(601);
                    }
                    this.mOnUpdateUserCallback.onComplete(mFResponse, false, null);
                    return;
                case 11:
                    if (this.mOnDeleteUserCallback != null) {
                        this.mOnDeleteUserCallback.onFailed(i);
                        return;
                    }
                    return;
                case 12:
                    if (this.mOnSignUpEmailCallback == null) {
                        return;
                    }
                    if (mFResponse instanceof MFLoginResponse) {
                        this.mOnSignUpEmailCallback.onSignUpEmailComplete((MFLoginResponse) mFResponse, false);
                        return;
                    }
                    this.mOnSignUpEmailCallback.onSignUpEmailComplete(null, false);
                    return;
                case 15:
                    if (this.mOnLogoutUserCompleteCallback != null) {
                        this.mOnLogoutUserCompleteCallback.onFailed(i);
                        return;
                    }
                    return;
                case 16:
                    if (this.mOnLoadStatisticCompleteCallback != null) {
                        this.mOnLoadStatisticCompleteCallback.onFailed(i);
                        return;
                    }
                    return;
                case 17:
                    if (this.mOnLoadStatisticCompleteCallback != null) {
                        this.mOnLoadStatisticCompleteCallback.onFailed(i);
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    public void addOrUpdateUser(MFUser mFUser, UserDataSource$OnUpdateUserComplete userDataSource$OnUpdateUserComplete) {
        MFNetwork.getInstance(PortfolioApp.ZQ()).execute(new cqo(PortfolioApp.ZQ(), mFUser), new ServerResultCallback(10, userDataSource$OnUpdateUserComplete));
    }

    public void deleteUser(MFUser mFUser, UserDataSource$OnDeleteUserComplete userDataSource$OnDeleteUserComplete) {
        MFNetwork.getInstance(PortfolioApp.ZQ()).execute(new cqd(PortfolioApp.ZQ()), new ServerResultCallback(11, userDataSource$OnDeleteUserComplete));
    }

    public void logoutUser(UserDataSource$OnLogoutUserComplete userDataSource$OnLogoutUserComplete) {
        MFNetwork.getInstance(PortfolioApp.ZQ()).execute(new cqg(PortfolioApp.ZQ()), new ServerResultCallback(15, userDataSource$OnLogoutUserComplete));
    }

    public void loadUserInfo(UserDataSource$OnLoadUserInfoComplete userDataSource$OnLoadUserInfoComplete) {
        MFNetwork.getInstance(PortfolioApp.ZQ()).execute(new cqe(PortfolioApp.ZQ()), new ServerResultCallback(9, userDataSource$OnLoadUserInfoComplete));
    }

    public jt<Integer, Integer> fetchUserStatistic(UserDataSource$OnLoadStatisticComplete userDataSource$OnLoadStatisticComplete) {
        final CountDownLatch countDownLatch = new CountDownLatch(2);
        final AtomicInteger atomicInteger = new AtomicInteger();
        final AtomicInteger atomicInteger2 = new AtomicInteger();
        fetchActivityStatistic(new UserDataSource$OnLoadStatisticComplete() {
            public void onSuccess(int i, int i2) {
                atomicInteger.addAndGet(i);
                countDownLatch.countDown();
            }

            public void onFailed(int i) {
                countDownLatch.countDown();
            }
        });
        fetchSleepStatistic(new UserDataSource$OnLoadStatisticComplete() {
            public void onSuccess(int i, int i2) {
                atomicInteger2.addAndGet(i2);
                countDownLatch.countDown();
            }

            public void onFailed(int i) {
                countDownLatch.countDown();
            }
        });
        try {
            MFLogger.d(TAG, "Await on thread=" + Thread.currentThread().getName());
            countDownLatch.await();
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (userDataSource$OnLoadStatisticComplete != null) {
            userDataSource$OnLoadStatisticComplete.onSuccess(atomicInteger.get(), atomicInteger2.get());
        }
        return null;
    }

    public void refreshUser() {
    }

    private void fetchActivityStatistic(UserDataSource$OnLoadStatisticComplete userDataSource$OnLoadStatisticComplete) {
        MFNetwork.getInstance(PortfolioApp.ZQ()).execute(new cro(PortfolioApp.ZQ()), new ServerResultCallback(16, userDataSource$OnLoadStatisticComplete));
    }

    private void fetchSleepStatistic(UserDataSource$OnLoadStatisticComplete userDataSource$OnLoadStatisticComplete) {
        MFNetwork.getInstance(PortfolioApp.ZQ()).execute(new csm(PortfolioApp.ZQ()), new ServerResultCallback(17, userDataSource$OnLoadStatisticComplete));
    }

    public MFUser getCurrentUser() {
        return null;
    }

    public void loginEmail(String str, String str2, UserDataSource$OnLoginEmailComplete userDataSource$OnLoginEmailComplete) {
        MFNetwork.getInstance(PortfolioApp.ZQ()).execute(new cqi(PortfolioApp.ZQ(), str, str2), new ServerResultCallback(8, userDataSource$OnLoginEmailComplete));
    }

    public void loginFacebook(WeakReference<ctj> weakReference, final UserDataSource$OnLoginSocialComplete userDataSource$OnLoginSocialComplete) {
        cnu.adu().a((Activity) weakReference.get(), new coc() {
            public void onLoginSuccess(int i) {
                if (userDataSource$OnLoginSocialComplete != null) {
                    userDataSource$OnLoginSocialComplete.onLoginSuccess(i);
                }
            }

            public void onLoginFailed(int i, atn com_fossil_atn) {
                if (userDataSource$OnLoginSocialComplete != null) {
                    userDataSource$OnLoginSocialComplete.onLoginFailed(i, com_fossil_atn);
                }
            }
        });
    }

    public void loginGoogle(WeakReference<ctj> weakReference, final UserDataSource$OnLoginSocialComplete userDataSource$OnLoginSocialComplete) {
        cnw.a(weakReference).a(new coc() {
            public void onLoginSuccess(int i) {
                if (userDataSource$OnLoginSocialComplete != null) {
                    userDataSource$OnLoginSocialComplete.onLoginSuccess(i);
                }
            }

            public void onLoginFailed(int i, atn com_fossil_atn) {
                if (userDataSource$OnLoginSocialComplete != null) {
                    userDataSource$OnLoginSocialComplete.onLoginFailed(i, com_fossil_atn);
                }
            }
        });
    }

    public void loginWeibo(WeakReference<ctj> weakReference, final UserDataSource$OnLoginSocialComplete userDataSource$OnLoginSocialComplete) {
        coa.adD().c((Activity) weakReference.get(), new coc() {
            public void onLoginSuccess(int i) {
                if (userDataSource$OnLoginSocialComplete != null) {
                    userDataSource$OnLoginSocialComplete.onLoginSuccess(i);
                }
            }

            public void onLoginFailed(int i, atn com_fossil_atn) {
                if (userDataSource$OnLoginSocialComplete != null) {
                    userDataSource$OnLoginSocialComplete.onLoginFailed(i, com_fossil_atn);
                }
            }
        });
    }

    public void loginWechat(WeakReference<ctj> weakReference, final UserDataSource$OnLoginSocialComplete userDataSource$OnLoginSocialComplete) {
        cny.adz().aw(cjy.cnN.aaV(), cjy.cnN.aaW());
        cny.adz().b((Activity) weakReference.get(), new coc() {
            public void onLoginSuccess(int i) {
                if (userDataSource$OnLoginSocialComplete != null) {
                    userDataSource$OnLoginSocialComplete.onLoginSuccess(i);
                }
            }

            public void onLoginFailed(int i, atn com_fossil_atn) {
                if (userDataSource$OnLoginSocialComplete != null) {
                    userDataSource$OnLoginSocialComplete.onLoginFailed(i, com_fossil_atn);
                }
            }
        });
    }

    public void signUpEmail(String str, String str2, UserDataSource$OnSignUpEmailComplete userDataSource$OnSignUpEmailComplete) {
        MFNetwork.getInstance(PortfolioApp.ZQ()).execute(new cqn(PortfolioApp.ZQ(), str, str2), new ServerResultCallback(12, userDataSource$OnSignUpEmailComplete));
    }

    public void resetPassword() {
    }

    public void changePassword(String str) {
    }

    public void onboardingComplete() {
        String str = "";
        if (!TextUtils.isEmpty(PortfolioApp.ZQ().aaa())) {
            str = DeviceHelper.gg(PortfolioApp.ZQ().aaa());
        }
        MFNetwork.getInstance(PortfolioApp.ZQ()).execute(new cqp(PortfolioApp.ZQ(), PortfolioApp.ZQ().getLocale(), str), new ServerResultCallback(19));
    }

    public void clearAllUser() {
    }
}
