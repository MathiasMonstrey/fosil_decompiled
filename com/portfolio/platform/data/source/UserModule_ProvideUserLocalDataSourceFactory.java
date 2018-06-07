package com.portfolio.platform.data.source;

import com.fossil.emi;
import com.fossil.emj;

public final class UserModule_ProvideUserLocalDataSourceFactory implements emi<UserDataSource> {
    static final /* synthetic */ boolean $assertionsDisabled = (!UserModule_ProvideUserLocalDataSourceFactory.class.desiredAssertionStatus());
    private final UserModule module;

    public UserModule_ProvideUserLocalDataSourceFactory(UserModule userModule) {
        if ($assertionsDisabled || userModule != null) {
            this.module = userModule;
            return;
        }
        throw new AssertionError();
    }

    public UserDataSource get() {
        return (UserDataSource) emj.f(this.module.provideUserLocalDataSource(), "Cannot return null from a non-@Nullable @Provides method");
    }

    public static emi<UserDataSource> create(UserModule userModule) {
        return new UserModule_ProvideUserLocalDataSourceFactory(userModule);
    }

    public static UserDataSource proxyProvideUserLocalDataSource(UserModule userModule) {
        return userModule.provideUserLocalDataSource();
    }
}
