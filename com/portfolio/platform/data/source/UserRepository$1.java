package com.portfolio.platform.data.source;

import com.misfit.frameworks.network.responses.MFResponse;
import com.portfolio.platform.data.model.MFUser;

class UserRepository$1 implements UserDataSource$OnUpdateUserComplete {
    final /* synthetic */ UserRepository this$0;
    final /* synthetic */ UserDataSource$OnUpdateUserComplete val$callback;

    UserRepository$1(UserRepository userRepository, UserDataSource$OnUpdateUserComplete userDataSource$OnUpdateUserComplete) {
        this.this$0 = userRepository;
        this.val$callback = userDataSource$OnUpdateUserComplete;
    }

    public void onComplete(final MFResponse mFResponse, boolean z, MFUser mFUser) {
        if (mFUser == null) {
            this.val$callback.onComplete(mFResponse, false, null);
        } else {
            UserRepository.access$000(this.this$0).addOrUpdateUser(mFUser, new UserDataSource$OnUpdateUserComplete() {
                public void onComplete(MFResponse mFResponse, boolean z, MFUser mFUser) {
                    UserRepository$1.this.val$callback.onComplete(mFResponse, z, mFUser);
                }
            });
        }
    }
}
