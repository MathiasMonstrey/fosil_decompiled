package com.portfolio.platform.data.source;

import com.fossil.bbm;
import com.fossil.ciw;
import com.fossil.emg;
import com.fossil.emi;
import com.fossil.eru;
import dagger.internal.MembersInjectors;

public final class ActivitiesRepository_Factory implements emi<ActivitiesRepository> {
    static final /* synthetic */ boolean $assertionsDisabled = (!ActivitiesRepository_Factory.class.desiredAssertionStatus());
    private final emg<ActivitiesRepository> activitiesRepositoryMembersInjector;
    private final eru<ciw> appExecutorsProvider;
    private final eru<ActivitiesDataSource> fitnessLocalDataSourceProvider;
    private final eru<ActivitiesDataSource> fitnessRemoteDataSourceProvider;
    private final eru<bbm> gcmNetworkManagerProvider;

    public ActivitiesRepository_Factory(emg<ActivitiesRepository> com_fossil_emg_com_portfolio_platform_data_source_ActivitiesRepository, eru<ActivitiesDataSource> com_fossil_eru_com_portfolio_platform_data_source_ActivitiesDataSource, eru<ActivitiesDataSource> com_fossil_eru_com_portfolio_platform_data_source_ActivitiesDataSource2, eru<bbm> com_fossil_eru_com_fossil_bbm, eru<ciw> com_fossil_eru_com_fossil_ciw) {
        if ($assertionsDisabled || com_fossil_emg_com_portfolio_platform_data_source_ActivitiesRepository != null) {
            this.activitiesRepositoryMembersInjector = com_fossil_emg_com_portfolio_platform_data_source_ActivitiesRepository;
            if ($assertionsDisabled || com_fossil_eru_com_portfolio_platform_data_source_ActivitiesDataSource != null) {
                this.fitnessRemoteDataSourceProvider = com_fossil_eru_com_portfolio_platform_data_source_ActivitiesDataSource;
                if ($assertionsDisabled || com_fossil_eru_com_portfolio_platform_data_source_ActivitiesDataSource2 != null) {
                    this.fitnessLocalDataSourceProvider = com_fossil_eru_com_portfolio_platform_data_source_ActivitiesDataSource2;
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

    public ActivitiesRepository get() {
        return (ActivitiesRepository) MembersInjectors.m16264a(this.activitiesRepositoryMembersInjector, new ActivitiesRepository((ActivitiesDataSource) this.fitnessRemoteDataSourceProvider.get(), (ActivitiesDataSource) this.fitnessLocalDataSourceProvider.get(), (bbm) this.gcmNetworkManagerProvider.get(), (ciw) this.appExecutorsProvider.get()));
    }

    public static emi<ActivitiesRepository> create(emg<ActivitiesRepository> com_fossil_emg_com_portfolio_platform_data_source_ActivitiesRepository, eru<ActivitiesDataSource> com_fossil_eru_com_portfolio_platform_data_source_ActivitiesDataSource, eru<ActivitiesDataSource> com_fossil_eru_com_portfolio_platform_data_source_ActivitiesDataSource2, eru<bbm> com_fossil_eru_com_fossil_bbm, eru<ciw> com_fossil_eru_com_fossil_ciw) {
        return new ActivitiesRepository_Factory(com_fossil_emg_com_portfolio_platform_data_source_ActivitiesRepository, com_fossil_eru_com_portfolio_platform_data_source_ActivitiesDataSource, com_fossil_eru_com_portfolio_platform_data_source_ActivitiesDataSource2, com_fossil_eru_com_fossil_bbm, com_fossil_eru_com_fossil_ciw);
    }
}
