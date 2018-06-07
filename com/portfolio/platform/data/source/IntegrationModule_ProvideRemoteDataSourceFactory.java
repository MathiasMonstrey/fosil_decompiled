package com.portfolio.platform.data.source;

import com.fossil.emi;
import com.fossil.emj;

public final class IntegrationModule_ProvideRemoteDataSourceFactory implements emi<IntegrationDataSource> {
    static final /* synthetic */ boolean $assertionsDisabled = (!IntegrationModule_ProvideRemoteDataSourceFactory.class.desiredAssertionStatus());
    private final IntegrationModule module;

    public IntegrationModule_ProvideRemoteDataSourceFactory(IntegrationModule integrationModule) {
        if ($assertionsDisabled || integrationModule != null) {
            this.module = integrationModule;
            return;
        }
        throw new AssertionError();
    }

    public IntegrationDataSource get() {
        return (IntegrationDataSource) emj.f(this.module.provideRemoteDataSource(), "Cannot return null from a non-@Nullable @Provides method");
    }

    public static emi<IntegrationDataSource> create(IntegrationModule integrationModule) {
        return new IntegrationModule_ProvideRemoteDataSourceFactory(integrationModule);
    }

    public static IntegrationDataSource proxyProvideRemoteDataSource(IntegrationModule integrationModule) {
        return integrationModule.provideRemoteDataSource();
    }
}
