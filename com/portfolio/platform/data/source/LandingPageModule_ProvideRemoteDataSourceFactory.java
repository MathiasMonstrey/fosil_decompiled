package com.portfolio.platform.data.source;

import com.fossil.emi;
import com.fossil.emj;

public final class LandingPageModule_ProvideRemoteDataSourceFactory implements emi<LandingPageDataSource> {
    static final /* synthetic */ boolean $assertionsDisabled = (!LandingPageModule_ProvideRemoteDataSourceFactory.class.desiredAssertionStatus());
    private final LandingPageModule module;

    public LandingPageModule_ProvideRemoteDataSourceFactory(LandingPageModule landingPageModule) {
        if ($assertionsDisabled || landingPageModule != null) {
            this.module = landingPageModule;
            return;
        }
        throw new AssertionError();
    }

    public LandingPageDataSource get() {
        return (LandingPageDataSource) emj.f(this.module.provideRemoteDataSource(), "Cannot return null from a non-@Nullable @Provides method");
    }

    public static emi<LandingPageDataSource> create(LandingPageModule landingPageModule) {
        return new LandingPageModule_ProvideRemoteDataSourceFactory(landingPageModule);
    }

    public static LandingPageDataSource proxyProvideRemoteDataSource(LandingPageModule landingPageModule) {
        return landingPageModule.provideRemoteDataSource();
    }
}
