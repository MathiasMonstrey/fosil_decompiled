package com.portfolio.platform.data.source;

import com.fossil.emi;
import com.fossil.emj;

public final class IntegrationModule_ProvideLocalDataSourceFactory implements emi<IntegrationDataSource> {
    static final /* synthetic */ boolean $assertionsDisabled = (!IntegrationModule_ProvideLocalDataSourceFactory.class.desiredAssertionStatus());
    private final IntegrationModule module;

    public IntegrationModule_ProvideLocalDataSourceFactory(IntegrationModule integrationModule) {
        if ($assertionsDisabled || integrationModule != null) {
            this.module = integrationModule;
            return;
        }
        throw new AssertionError();
    }

    public IntegrationDataSource get() {
        return (IntegrationDataSource) emj.f(this.module.provideLocalDataSource(), "Cannot return null from a non-@Nullable @Provides method");
    }

    public static emi<IntegrationDataSource> create(IntegrationModule integrationModule) {
        return new IntegrationModule_ProvideLocalDataSourceFactory(integrationModule);
    }

    public static IntegrationDataSource proxyProvideLocalDataSource(IntegrationModule integrationModule) {
        return integrationModule.provideLocalDataSource();
    }
}
