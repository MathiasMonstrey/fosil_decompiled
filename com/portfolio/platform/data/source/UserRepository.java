package com.portfolio.platform.data.source;

import com.fossil.ctj;
import com.fossil.jt;
import com.misfit.frameworks.common.log.MFLogger;
import com.portfolio.platform.data.model.MFUser;
import com.portfolio.platform.data.source.UserDataSource.OnDeleteUserComplete;
import com.portfolio.platform.data.source.UserDataSource.OnLoadStatisticComplete;
import com.portfolio.platform.data.source.UserDataSource.OnLoadUserInfoComplete;
import com.portfolio.platform.data.source.UserDataSource.OnLoginEmailComplete;
import com.portfolio.platform.data.source.UserDataSource.OnLoginSocialComplete;
import com.portfolio.platform.data.source.UserDataSource.OnLogoutUserComplete;
import com.portfolio.platform.data.source.UserDataSource.OnSignUpEmailComplete;
import com.portfolio.platform.data.source.UserDataSource.OnUpdateUserComplete;
import com.portfolio.platform.data.source.scope.Local;
import com.portfolio.platform.data.source.scope.Remote;
import java.lang.ref.WeakReference;

public class UserRepository implements UserDataSource {
    private final String TAG = UserRepository.class.getSimpleName();
    private final UserDataSource mUserLocalDataSource;
    private final UserDataSource mUserRemoteDataSource;

    public UserRepository(@Remote UserDataSource userDataSource, @Local UserDataSource userDataSource2) {
        this.mUserRemoteDataSource = userDataSource;
        this.mUserLocalDataSource = userDataSource2;
    }

    public void addOrUpdateUser(MFUser mFUser, OnUpdateUserComplete onUpdateUserComplete) {
        if (onUpdateUserComplete != null) {
            MFLogger.m12670d(this.TAG, "Inside .addOrUpdateUser updateUserInfo on server");
            this.mUserRemoteDataSource.addOrUpdateUser(mFUser, new 1(this, onUpdateUserComplete));
            return;
        }
        this.mUserLocalDataSource.addOrUpdateUser(mFUser, null);
    }

    public void deleteUser(MFUser mFUser, OnDeleteUserComplete onDeleteUserComplete) {
        if (onDeleteUserComplete != null) {
            this.mUserRemoteDataSource.deleteUser(mFUser, new 2(this, onDeleteUserComplete));
        } else {
            this.mUserLocalDataSource.deleteUser(mFUser, null);
        }
    }

    public void logoutUser(OnLogoutUserComplete onLogoutUserComplete) {
        this.mUserRemoteDataSource.logoutUser(new 3(this, onLogoutUserComplete));
    }

    public MFUser getCurrentUser() {
        return this.mUserLocalDataSource.getCurrentUser();
    }

    public void loadUserInfo(OnLoadUserInfoComplete onLoadUserInfoComplete) {
        this.mUserRemoteDataSource.loadUserInfo(new 4(this, onLoadUserInfoComplete));
    }

    public jt<Integer, Integer> fetchUserStatistic(OnLoadStatisticComplete onLoadStatisticComplete) {
        this.mUserRemoteDataSource.fetchUserStatistic(new 5(this, onLoadStatisticComplete));
        return this.mUserLocalDataSource.fetchUserStatistic(onLoadStatisticComplete);
    }

    public void refreshUser() {
        MFLogger.m12670d(this.TAG, "Inside .refreshUser");
        this.mUserRemoteDataSource.loadUserInfo(new 6(this));
    }

    public void loginEmail(String str, String str2, OnLoginEmailComplete onLoginEmailComplete) {
        this.mUserRemoteDataSource.loginEmail(str, str2, new 7(this, onLoginEmailComplete));
    }

    public void loginFacebook(WeakReference<ctj> weakReference, OnLoginSocialComplete onLoginSocialComplete) {
        this.mUserRemoteDataSource.loginFacebook(weakReference, new 8(this, onLoginSocialComplete));
    }

    public void loginGoogle(WeakReference<ctj> weakReference, OnLoginSocialComplete onLoginSocialComplete) {
        this.mUserRemoteDataSource.loginGoogle(weakReference, new 9(this, onLoginSocialComplete));
    }

    public void loginWeibo(WeakReference<ctj> weakReference, OnLoginSocialComplete onLoginSocialComplete) {
        this.mUserRemoteDataSource.loginWeibo(weakReference, new 10(this, onLoginSocialComplete));
    }

    public void loginWechat(WeakReference<ctj> weakReference, OnLoginSocialComplete onLoginSocialComplete) {
        this.mUserRemoteDataSource.loginWechat(weakReference, new 11(this, onLoginSocialComplete));
    }

    public void signUpEmail(String str, String str2, OnSignUpEmailComplete onSignUpEmailComplete) {
        this.mUserRemoteDataSource.signUpEmail(str, str2, new 12(this, onSignUpEmailComplete));
    }

    public void resetPassword() {
    }

    public void changePassword(String str) {
    }

    public void onboardingComplete() {
        this.mUserRemoteDataSource.onboardingComplete();
    }

    public void clearAllUser() {
        this.mUserLocalDataSource.clearAllUser();
    }
}
