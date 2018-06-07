package com.portfolio.platform.data.source;

import com.fossil.ctj;
import com.fossil.jt;
import com.portfolio.platform.data.model.MFUser;
import java.lang.ref.WeakReference;

public interface UserDataSource {
    void addOrUpdateUser(MFUser mFUser, OnUpdateUserComplete onUpdateUserComplete);

    void changePassword(String str);

    void clearAllUser();

    void deleteUser(MFUser mFUser, OnDeleteUserComplete onDeleteUserComplete);

    jt<Integer, Integer> fetchUserStatistic(OnLoadStatisticComplete onLoadStatisticComplete);

    MFUser getCurrentUser();

    void loadUserInfo(OnLoadUserInfoComplete onLoadUserInfoComplete);

    void loginEmail(String str, String str2, OnLoginEmailComplete onLoginEmailComplete);

    void loginFacebook(WeakReference<ctj> weakReference, OnLoginSocialComplete onLoginSocialComplete);

    void loginGoogle(WeakReference<ctj> weakReference, OnLoginSocialComplete onLoginSocialComplete);

    void loginWechat(WeakReference<ctj> weakReference, OnLoginSocialComplete onLoginSocialComplete);

    void loginWeibo(WeakReference<ctj> weakReference, OnLoginSocialComplete onLoginSocialComplete);

    void logoutUser(OnLogoutUserComplete onLogoutUserComplete);

    void onboardingComplete();

    void refreshUser();

    void resetPassword();

    void signUpEmail(String str, String str2, OnSignUpEmailComplete onSignUpEmailComplete);
}
