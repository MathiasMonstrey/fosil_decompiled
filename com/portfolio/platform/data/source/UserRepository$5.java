package com.portfolio.platform.data.source;

import com.portfolio.platform.data.model.MFUser;

class UserRepository$5 implements UserDataSource$OnLoadStatisticComplete {
    final /* synthetic */ UserRepository this$0;
    final /* synthetic */ UserDataSource$OnLoadStatisticComplete val$callback;

    UserRepository$5(UserRepository userRepository, UserDataSource$OnLoadStatisticComplete userDataSource$OnLoadStatisticComplete) {
        this.this$0 = userRepository;
        this.val$callback = userDataSource$OnLoadStatisticComplete;
    }

    public void onSuccess(int i, int i2) {
        if (this.val$callback != null) {
            MFUser currentUser = this.this$0.getCurrentUser();
            if (currentUser != null) {
                currentUser.setAverageStep(i);
                currentUser.setAverageSleep(i2);
                this.this$0.addOrUpdateUser(currentUser, null);
            }
            this.val$callback.onSuccess(i, i2);
        }
    }

    public void onFailed(int i) {
        if (this.val$callback != null) {
            this.val$callback.onFailed(i);
        }
    }
}
