package com.portfolio.platform.data.source;

import com.fossil.emi;
import com.fossil.emj;

public final class ExploreRepositoryModule_ProvideExploreRemoteDataSourceFactory implements emi<ExploreDataSource> {
    static final /* synthetic */ boolean $assertionsDisabled = (!ExploreRepositoryModule_ProvideExploreRemoteDataSourceFactory.class.desiredAssertionStatus());
    private final ExploreRepositoryModule module;

    public ExploreRepositoryModule_ProvideExploreRemoteDataSourceFactory(ExploreRepositoryModule exploreRepositoryModule) {
        if ($assertionsDisabled || exploreRepositoryModule != null) {
            this.module = exploreRepositoryModule;
            return;
        }
        throw new AssertionError();
    }

    public ExploreDataSource get() {
        return (ExploreDataSource) emj.f(this.module.provideExploreRemoteDataSource(), "Cannot return null from a non-@Nullable @Provides method");
    }

    public static emi<ExploreDataSource> create(ExploreRepositoryModule exploreRepositoryModule) {
        return new ExploreRepositoryModule_ProvideExploreRemoteDataSourceFactory(exploreRepositoryModule);
    }

    public static ExploreDataSource proxyProvideExploreRemoteDataSource(ExploreRepositoryModule exploreRepositoryModule) {
        return exploreRepositoryModule.provideExploreRemoteDataSource();
    }
}
