package com.portfolio.platform.data.source;

import com.fossil.bbm;
import com.fossil.ciw;
import com.fossil.emg;
import com.fossil.emi;
import com.fossil.eru;
import dagger.internal.MembersInjectors;

public final class SummariesRepository_Factory implements emi<SummariesRepository> {
    static final /* synthetic */ boolean $assertionsDisabled = (!SummariesRepository_Factory.class.desiredAssertionStatus());
    private final eru<ciw> appExecutorsProvider;
    private final eru<bbm> gcmNetworkManagerProvider;
    private final eru<SummariesDataSource> summariesLocalDataSourceProvider;
    private final eru<SummariesDataSource> summariesRemoteDataSourceProvider;
    private final emg<SummariesRepository> summariesRepositoryMembersInjector;

    public SummariesRepository_Factory(emg<SummariesRepository> com_fossil_emg_com_portfolio_platform_data_source_SummariesRepository, eru<SummariesDataSource> com_fossil_eru_com_portfolio_platform_data_source_SummariesDataSource, eru<SummariesDataSource> com_fossil_eru_com_portfolio_platform_data_source_SummariesDataSource2, eru<bbm> com_fossil_eru_com_fossil_bbm, eru<ciw> com_fossil_eru_com_fossil_ciw) {
        if ($assertionsDisabled || com_fossil_emg_com_portfolio_platform_data_source_SummariesRepository != null) {
            this.summariesRepositoryMembersInjector = com_fossil_emg_com_portfolio_platform_data_source_SummariesRepository;
            if ($assertionsDisabled || com_fossil_eru_com_portfolio_platform_data_source_SummariesDataSource != null) {
                this.summariesRemoteDataSourceProvider = com_fossil_eru_com_portfolio_platform_data_source_SummariesDataSource;
                if ($assertionsDisabled || com_fossil_eru_com_portfolio_platform_data_source_SummariesDataSource2 != null) {
                    this.summariesLocalDataSourceProvider = com_fossil_eru_com_portfolio_platform_data_source_SummariesDataSource2;
                    if ($assertionsDisabled || com_fossil_eru_com_fossil_bbm != null) {
                        this.gcmNetworkManagerProvider = com_fossil_eru_com_fossil_bbm;
                        if ($assertionsDisabled || com_fossil_eru_com_fossil_ciw != null) {
                            this.appExecutorsProvider = com_fossil_eru_com_fossil_ciw;
                            return;
                        }
                        throw new AssertionError();
                    }
                    throw new AssertionError();
                }
                throw new AssertionError();
            }
            throw new AssertionError();
        }
        throw new AssertionError();
    }

    public SummariesRepository get() {
        return (SummariesRepository) MembersInjectors.m16264a(this.summariesRepositoryMembersInjector, new SummariesRepository((SummariesDataSource) this.summariesRemoteDataSourceProvider.get(), (SummariesDataSource) this.summariesLocalDataSourceProvider.get(), (bbm) this.gcmNetworkManagerProvider.get(), (ciw) this.appExecutorsProvider.get()));
    }

    public static emi<SummariesRepository> create(emg<SummariesRepository> com_fossil_emg_com_portfolio_platform_data_source_SummariesRepository, eru<SummariesDataSource> com_fossil_eru_com_portfolio_platform_data_source_SummariesDataSource, eru<SummariesDataSource> com_fossil_eru_com_portfolio_platform_data_source_SummariesDataSource2, eru<bbm> com_fossil_eru_com_fossil_bbm, eru<ciw> com_fossil_eru_com_fossil_ciw) {
        return new SummariesRepository_Factory(com_fossil_emg_com_portfolio_platform_data_source_SummariesRepository, com_fossil_eru_com_portfolio_platform_data_source_SummariesDataSource, com_fossil_eru_com_portfolio_platform_data_source_SummariesDataSource2, com_fossil_eru_com_fossil_bbm, com_fossil_eru_com_fossil_ciw);
    }
}
