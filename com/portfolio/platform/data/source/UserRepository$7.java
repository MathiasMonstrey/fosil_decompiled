package com.portfolio.platform.data.source;

import com.misfit.frameworks.network.responses.MFLoginResponse;
import com.portfolio.platform.PortfolioApp;
import com.portfolio.platform.data.model.MFUser;
import com.portfolio.platform.enums.AuthType;

class UserRepository$7 implements UserDataSource$OnLoginEmailComplete {
    final /* synthetic */ UserRepository this$0;
    final /* synthetic */ UserDataSource$OnLoginEmailComplete val$callback;

    UserRepository$7(UserRepository userRepository, UserDataSource$OnLoginEmailComplete userDataSource$OnLoginEmailComplete) {
        this.this$0 = userRepository;
        this.val$callback = userDataSource$OnLoginEmailComplete;
    }

    public void onLoginComplete(MFLoginResponse mFLoginResponse, boolean z, int i) {
        if (z && mFLoginResponse != null) {
            MFUser mFUser = new MFUser();
            mFUser.setAuthType(AuthType.EMAIL.getValue());
            mFUser.setUserAccessToken(mFLoginResponse.getProfile().getAccessToken());
            mFUser.setUserId(mFLoginResponse.getProfile().getUid());
            mFUser.setObjectId(mFLoginResponse.getProfile().getObjectId());
            UserRepository.access$000(this.this$0).addOrUpdateUser(mFUser, null);
            PortfolioApp.ZQ().aam().YV().setUserAccessToken(mFLoginResponse.getProfile().getAccessToken());
            if (this.val$callback != null) {
                this.val$callback.onLoginComplete(null, true, 0);
            }
        } else if (this.val$callback != null) {
            this.val$callback.onLoginComplete(null, false, i);
        }
    }
}
