package com.portfolio.platform.data.source;

import com.misfit.frameworks.network.responses.MFLoginResponse;
import com.portfolio.platform.PortfolioApp;
import com.portfolio.platform.data.model.MFUser;
import com.portfolio.platform.enums.AuthType;

class UserRepository$12 implements UserDataSource$OnSignUpEmailComplete {
    final /* synthetic */ UserRepository this$0;
    final /* synthetic */ UserDataSource$OnSignUpEmailComplete val$callback;

    UserRepository$12(UserRepository userRepository, UserDataSource$OnSignUpEmailComplete userDataSource$OnSignUpEmailComplete) {
        this.this$0 = userRepository;
        this.val$callback = userDataSource$OnSignUpEmailComplete;
    }

    public void onSignUpEmailComplete(MFLoginResponse mFLoginResponse, boolean z) {
        if (z && mFLoginResponse != null) {
            MFUser mFUser = new MFUser();
            mFUser.setAuthType(AuthType.EMAIL.getValue());
            mFUser.setCreatedAt(mFLoginResponse.getProfile().getCreatedAt());
            mFUser.setUserAccessToken(mFLoginResponse.getProfile().getAccessToken());
            mFUser.setUserId(mFLoginResponse.getProfile().getUid());
            mFUser.setObjectId(mFLoginResponse.getProfile().getObjectId());
            UserRepository.access$000(this.this$0).addOrUpdateUser(mFUser, null);
            PortfolioApp.ZQ().aam().YV().setUserAccessToken(mFLoginResponse.getProfile().getAccessToken());
        }
        if (this.val$callback != null) {
            this.val$callback.onSignUpEmailComplete(mFLoginResponse, z);
        }
    }
}
