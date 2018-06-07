package com.portfolio.platform.data.source;

import com.misfit.frameworks.network.responses.MFResponse;
import com.portfolio.platform.data.model.MFUser;

class UserRepository$4 implements UserDataSource$OnLoadUserInfoComplete {
    final /* synthetic */ UserRepository this$0;
    final /* synthetic */ UserDataSource$OnLoadUserInfoComplete val$callback;

    UserRepository$4(UserRepository userRepository, UserDataSource$OnLoadUserInfoComplete userDataSource$OnLoadUserInfoComplete) {
        this.this$0 = userRepository;
        this.val$callback = userDataSource$OnLoadUserInfoComplete;
    }

    public void onComplete(MFResponse mFResponse, MFUser mFUser) {
        if (mFUser != null) {
            UserRepository.access$000(this.this$0).addOrUpdateUser(mFUser, null);
            if (this.val$callback != null) {
                this.val$callback.onComplete(mFResponse, mFUser);
            }
        } else if (this.val$callback != null) {
            this.val$callback.onComplete(mFResponse, null);
        }
    }
}
