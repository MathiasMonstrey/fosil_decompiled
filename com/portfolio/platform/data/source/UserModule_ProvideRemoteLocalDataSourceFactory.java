package com.portfolio.platform.data.source;

import com.fossil.emi;
import com.fossil.emj;

public final class UserModule_ProvideRemoteLocalDataSourceFactory implements emi<UserDataSource> {
    static final /* synthetic */ boolean $assertionsDisabled = (!UserModule_ProvideRemoteLocalDataSourceFactory.class.desiredAssertionStatus());
    private final UserModule module;

    public UserModule_ProvideRemoteLocalDataSourceFactory(UserModule userModule) {
        if ($assertionsDisabled || userModule != null) {
            this.module = userModule;
            return;
        }
        throw new AssertionError();
    }

    public UserDataSource get() {
        return (UserDataSource) emj.f(this.module.provideRemoteLocalDataSource(), "Cannot return null from a non-@Nullable @Provides method");
    }

    public static emi<UserDataSource> create(UserModule userModule) {
        return new UserModule_ProvideRemoteLocalDataSourceFactory(userModule);
    }

    public static UserDataSource proxyProvideRemoteLocalDataSource(UserModule userModule) {
        return userModule.provideRemoteLocalDataSource();
    }
}
