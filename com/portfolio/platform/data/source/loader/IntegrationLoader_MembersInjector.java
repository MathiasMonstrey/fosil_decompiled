package com.portfolio.platform.data.source.loader;

import com.fossil.emg;
import com.fossil.eru;
import com.portfolio.platform.data.source.IntegrationRepository;

public final class IntegrationLoader_MembersInjector implements emg<IntegrationLoader> {
    static final /* synthetic */ boolean $assertionsDisabled = (!IntegrationLoader_MembersInjector.class.desiredAssertionStatus());
    private final eru<IntegrationRepository> mRepositoryProvider;

    public IntegrationLoader_MembersInjector(eru<IntegrationRepository> com_fossil_eru_com_portfolio_platform_data_source_IntegrationRepository) {
        if ($assertionsDisabled || com_fossil_eru_com_portfolio_platform_data_source_IntegrationRepository != null) {
            this.mRepositoryProvider = com_fossil_eru_com_portfolio_platform_data_source_IntegrationRepository;
            return;
        }
        throw new AssertionError();
    }

    public static emg<IntegrationLoader> create(eru<IntegrationRepository> com_fossil_eru_com_portfolio_platform_data_source_IntegrationRepository) {
        return new IntegrationLoader_MembersInjector(com_fossil_eru_com_portfolio_platform_data_source_IntegrationRepository);
    }

    public void injectMembers(IntegrationLoader integrationLoader) {
        if (integrationLoader == null) {
            throw new NullPointerException("Cannot inject members into a null reference");
        }
        integrationLoader.mRepository = (IntegrationRepository) this.mRepositoryProvider.get();
    }
}
