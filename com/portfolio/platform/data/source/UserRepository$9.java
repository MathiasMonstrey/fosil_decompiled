package com.portfolio.platform.data.source;

import com.fossil.atn;

class UserRepository$9 implements UserDataSource$OnLoginSocialComplete {
    final /* synthetic */ UserRepository this$0;
    final /* synthetic */ UserDataSource$OnLoginSocialComplete val$onLoginSocialComplete;

    UserRepository$9(UserRepository userRepository, UserDataSource$OnLoginSocialComplete userDataSource$OnLoginSocialComplete) {
        this.this$0 = userRepository;
        this.val$onLoginSocialComplete = userDataSource$OnLoginSocialComplete;
    }

    public void onLoginSuccess(int i) {
        if (this.val$onLoginSocialComplete != null) {
            this.val$onLoginSocialComplete.onLoginSuccess(i);
        }
    }

    public void onLoginFailed(int i, atn com_fossil_atn) {
        if (this.val$onLoginSocialComplete != null) {
            this.val$onLoginSocialComplete.onLoginFailed(i, com_fossil_atn);
        }
    }
}
