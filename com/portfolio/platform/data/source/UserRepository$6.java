package com.portfolio.platform.data.source;

import com.misfit.frameworks.common.log.MFLogger;
import com.misfit.frameworks.network.responses.MFResponse;
import com.portfolio.platform.data.model.MFUser;

class UserRepository$6 implements UserDataSource$OnLoadUserInfoComplete {
    final /* synthetic */ UserRepository this$0;

    UserRepository$6(UserRepository userRepository) {
        this.this$0 = userRepository;
    }

    public void onComplete(MFResponse mFResponse, MFUser mFUser) {
        MFLogger.d(UserRepository.access$100(this.this$0), "Inside .refreshUser complete currentUser=" + mFUser);
        if (mFUser != null) {
            UserRepository.access$000(this.this$0).addOrUpdateUser(mFUser, null);
        }
    }
}
