package com.portfolio.platform.data.source;

import com.fossil.emi;
import com.fossil.emj;

public final class ExploreRepositoryModule_ProvideExploreLocalDataSourceFactory implements emi<ExploreDataSource> {
    static final /* synthetic */ boolean $assertionsDisabled = (!ExploreRepositoryModule_ProvideExploreLocalDataSourceFactory.class.desiredAssertionStatus());
    private final ExploreRepositoryModule module;

    public ExploreRepositoryModule_ProvideExploreLocalDataSourceFactory(ExploreRepositoryModule exploreRepositoryModule) {
        if ($assertionsDisabled || exploreRepositoryModule != null) {
            this.module = exploreRepositoryModule;
            return;
        }
        throw new AssertionError();
    }

    public ExploreDataSource get() {
        return (ExploreDataSource) emj.f(this.module.provideExploreLocalDataSource(), "Cannot return null from a non-@Nullable @Provides method");
    }

    public static emi<ExploreDataSource> create(ExploreRepositoryModule exploreRepositoryModule) {
        return new ExploreRepositoryModule_ProvideExploreLocalDataSourceFactory(exploreRepositoryModule);
    }

    public static ExploreDataSource proxyProvideExploreLocalDataSource(ExploreRepositoryModule exploreRepositoryModule) {
        return exploreRepositoryModule.provideExploreLocalDataSource();
    }
}
