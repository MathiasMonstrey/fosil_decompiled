package com.portfolio.platform.data.source;

class UserRepository$3 implements UserDataSource$OnLogoutUserComplete {
    final /* synthetic */ UserRepository this$0;
    final /* synthetic */ UserDataSource$OnLogoutUserComplete val$callback;

    UserRepository$3(UserRepository userRepository, UserDataSource$OnLogoutUserComplete userDataSource$OnLogoutUserComplete) {
        this.this$0 = userRepository;
        this.val$callback = userDataSource$OnLogoutUserComplete;
    }

    public void onSuccess() {
        if (this.val$callback != null) {
            this.val$callback.onSuccess();
        }
    }

    public void onFailed(int i) {
        if (this.val$callback != null) {
            this.val$callback.onFailed(i);
        }
    }
}
