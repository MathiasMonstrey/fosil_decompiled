package com.portfolio.platform.data.source.local;

import com.fossil.cnq;
import com.fossil.ctj;
import com.fossil.jt;
import com.misfit.frameworks.common.constants.MFNetworkReturnCode;
import com.misfit.frameworks.network.responses.MFResponse;
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
import java.lang.ref.WeakReference;

public class UserLocalDataSource implements UserDataSource {
    public void addOrUpdateUser(MFUser mFUser, UserDataSource$OnUpdateUserComplete userDataSource$OnUpdateUserComplete) {
        cnq.acd().ace().a(mFUser);
        if (userDataSource$OnUpdateUserComplete != null) {
            MFResponse mFResponse = new MFResponse();
            mFResponse.setHttpReturnCode(MFNetworkReturnCode.RESPONSE_OK);
            userDataSource$OnUpdateUserComplete.onComplete(mFResponse, true, getCurrentUser());
        }
    }

    public void deleteUser(MFUser mFUser, UserDataSource$OnDeleteUserComplete userDataSource$OnDeleteUserComplete) {
        cnq.acd().ace().b(mFUser);
    }

    public void logoutUser(UserDataSource$OnLogoutUserComplete userDataSource$OnLogoutUserComplete) {
        cnq.acd().ace().b(getCurrentUser());
    }

    public MFUser getCurrentUser() {
        return cnq.acd().ace().getCurrentUser();
    }

    public void loadUserInfo(UserDataSource$OnLoadUserInfoComplete userDataSource$OnLoadUserInfoComplete) {
    }

    public jt<Integer, Integer> fetchUserStatistic(UserDataSource$OnLoadStatisticComplete userDataSource$OnLoadStatisticComplete) {
        MFUser currentUser = getCurrentUser();
        if (currentUser == null) {
            return new jt(Integer.valueOf(0), Integer.valueOf(0));
        }
        return new jt(Integer.valueOf(currentUser.getAverageStep()), Integer.valueOf(currentUser.getAverageSleep()));
    }

    public void refreshUser() {
    }

    public void loginEmail(String str, String str2, UserDataSource$OnLoginEmailComplete userDataSource$OnLoginEmailComplete) {
    }

    public void loginFacebook(WeakReference<ctj> weakReference, UserDataSource$OnLoginSocialComplete userDataSource$OnLoginSocialComplete) {
    }

    public void loginGoogle(WeakReference<ctj> weakReference, UserDataSource$OnLoginSocialComplete userDataSource$OnLoginSocialComplete) {
    }

    public void loginWeibo(WeakReference<ctj> weakReference, UserDataSource$OnLoginSocialComplete userDataSource$OnLoginSocialComplete) {
    }

    public void loginWechat(WeakReference<ctj> weakReference, UserDataSource$OnLoginSocialComplete userDataSource$OnLoginSocialComplete) {
    }

    public void signUpEmail(String str, String str2, UserDataSource$OnSignUpEmailComplete userDataSource$OnSignUpEmailComplete) {
    }

    public void resetPassword() {
    }

    public void changePassword(String str) {
    }

    public void onboardingComplete() {
    }

    public void clearAllUser() {
        cnq.acd().ace().clearAllUser();
    }
}
