package com.portfolio.platform.data.source;

class UserRepository$2 implements UserDataSource$OnDeleteUserComplete {
    final /* synthetic */ UserRepository this$0;
    final /* synthetic */ UserDataSource$OnDeleteUserComplete val$callback;

    UserRepository$2(UserRepository userRepository, UserDataSource$OnDeleteUserComplete userDataSource$OnDeleteUserComplete) {
        this.this$0 = userRepository;
        this.val$callback = userDataSource$OnDeleteUserComplete;
    }

    public void onSuccess() {
        this.val$callback.onSuccess();
    }

    public void onFailed(int i) {
        this.val$callback.onFailed(i);
    }
}
