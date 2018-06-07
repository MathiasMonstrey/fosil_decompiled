package com.portfolio.platform.data.source;

import com.fossil.emi;
import com.fossil.emj;

public final class LandingPageModule_ProvideLocalDataSourceFactory implements emi<LandingPageDataSource> {
    static final /* synthetic */ boolean $assertionsDisabled = (!LandingPageModule_ProvideLocalDataSourceFactory.class.desiredAssertionStatus());
    private final LandingPageModule module;

    public LandingPageModule_ProvideLocalDataSourceFactory(LandingPageModule landingPageModule) {
        if ($assertionsDisabled || landingPageModule != null) {
            this.module = landingPageModule;
            return;
        }
        throw new AssertionError();
    }

    public LandingPageDataSource get() {
        return (LandingPageDataSource) emj.f(this.module.provideLocalDataSource(), "Cannot return null from a non-@Nullable @Provides method");
    }

    public static emi<LandingPageDataSource> create(LandingPageModule landingPageModule) {
        return new LandingPageModule_ProvideLocalDataSourceFactory(landingPageModule);
    }

    public static LandingPageDataSource proxyProvideLocalDataSource(LandingPageModule landingPageModule) {
        return landingPageModule.provideLocalDataSource();
    }
}
