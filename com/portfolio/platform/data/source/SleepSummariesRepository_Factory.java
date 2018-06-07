package com.portfolio.platform.data.source;

import com.fossil.bbm;
import com.fossil.ciw;
import com.fossil.emg;
import com.fossil.emi;
import com.fossil.eru;
import dagger.internal.MembersInjectors;

public final class SleepSummariesRepository_Factory implements emi<SleepSummariesRepository> {
    static final /* synthetic */ boolean $assertionsDisabled = (!SleepSummariesRepository_Factory.class.desiredAssertionStatus());
    private final eru<ciw> appExecutorsProvider;
    private final eru<bbm> gcmNetworkManagerProvider;
    private final eru<SleepSummariesDataSource> sleepSummariesLocalDataSourceProvider;
    private final eru<SleepSummariesDataSource> sleepSummariesRemoteDataSourceProvider;
    private final emg<SleepSummariesRepository> sleepSummariesRepositoryMembersInjector;

    public SleepSummariesRepository_Factory(emg<SleepSummariesRepository> com_fossil_emg_com_portfolio_platform_data_source_SleepSummariesRepository, eru<SleepSummariesDataSource> com_fossil_eru_com_portfolio_platform_data_source_SleepSummariesDataSource, eru<SleepSummariesDataSource> com_fossil_eru_com_portfolio_platform_data_source_SleepSummariesDataSource2, eru<bbm> com_fossil_eru_com_fossil_bbm, eru<ciw> com_fossil_eru_com_fossil_ciw) {
        if ($assertionsDisabled || com_fossil_emg_com_portfolio_platform_data_source_SleepSummariesRepository != null) {
            this.sleepSummariesRepositoryMembersInjector = com_fossil_emg_com_portfolio_platform_data_source_SleepSummariesRepository;
            if ($assertionsDisabled || com_fossil_eru_com_portfolio_platform_data_source_SleepSummariesDataSource != null) {
                this.sleepSummariesRemoteDataSourceProvider = com_fossil_eru_com_portfolio_platform_data_source_SleepSummariesDataSource;
                if ($assertionsDisabled || com_fossil_eru_com_portfolio_platform_data_source_SleepSummariesDataSource2 != null) {
                    this.sleepSummariesLocalDataSourceProvider = com_fossil_eru_com_portfolio_platform_data_source_SleepSummariesDataSource2;
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

    public SleepSummariesRepository get() {
        return (SleepSummariesRepository) MembersInjectors.m16264a(this.sleepSummariesRepositoryMembersInjector, new SleepSummariesRepository((SleepSummariesDataSource) this.sleepSummariesRemoteDataSourceProvider.get(), (SleepSummariesDataSource) this.sleepSummariesLocalDataSourceProvider.get(), (bbm) this.gcmNetworkManagerProvider.get(), (ciw) this.appExecutorsProvider.get()));
    }

    public static emi<SleepSummariesRepository> create(emg<SleepSummariesRepository> com_fossil_emg_com_portfolio_platform_data_source_SleepSummariesRepository, eru<SleepSummariesDataSource> com_fossil_eru_com_portfolio_platform_data_source_SleepSummariesDataSource, eru<SleepSummariesDataSource> com_fossil_eru_com_portfolio_platform_data_source_SleepSummariesDataSource2, eru<bbm> com_fossil_eru_com_fossil_bbm, eru<ciw> com_fossil_eru_com_fossil_ciw) {
        return new SleepSummariesRepository_Factory(com_fossil_emg_com_portfolio_platform_data_source_SleepSummariesRepository, com_fossil_eru_com_portfolio_platform_data_source_SleepSummariesDataSource, com_fossil_eru_com_portfolio_platform_data_source_SleepSummariesDataSource2, com_fossil_eru_com_fossil_bbm, com_fossil_eru_com_fossil_ciw);
    }
}
