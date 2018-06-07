package com.portfolio.platform.data.source.loader;

import com.fossil.emg;
import com.fossil.eru;
import com.portfolio.platform.data.source.ExploreRepository;

public final class ExploreLoader_MembersInjector implements emg<ExploreLoader> {
    static final /* synthetic */ boolean $assertionsDisabled = (!ExploreLoader_MembersInjector.class.desiredAssertionStatus());
    private final eru<ExploreRepository> mRepositoryProvider;

    public ExploreLoader_MembersInjector(eru<ExploreRepository> com_fossil_eru_com_portfolio_platform_data_source_ExploreRepository) {
        if ($assertionsDisabled || com_fossil_eru_com_portfolio_platform_data_source_ExploreRepository != null) {
            this.mRepositoryProvider = com_fossil_eru_com_portfolio_platform_data_source_ExploreRepository;
            return;
        }
        throw new AssertionError();
    }

    public static emg<ExploreLoader> create(eru<ExploreRepository> com_fossil_eru_com_portfolio_platform_data_source_ExploreRepository) {
        return new ExploreLoader_MembersInjector(com_fossil_eru_com_portfolio_platform_data_source_ExploreRepository);
    }

    public void injectMembers(ExploreLoader exploreLoader) {
        if (exploreLoader == null) {
            throw new NullPointerException("Cannot inject members into a null reference");
        }
        exploreLoader.mRepository = (ExploreRepository) this.mRepositoryProvider.get();
    }
}
