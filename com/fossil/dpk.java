package com.fossil;

import com.portfolio.platform.data.source.ActivitiesRepository;
import com.portfolio.platform.data.source.SummariesRepository;
import dagger.internal.MembersInjectors;

public final class dpk implements emi<dpj> {
    static final /* synthetic */ boolean $assertionsDisabled = (!dpk.class.desiredAssertionStatus());
    private final eru<ActivitiesRepository> cfd;
    private final emg<dpj> dcU;
    private final eru<SummariesRepository> summariesRepositoryProvider;

    public /* synthetic */ Object get() {
        return atH();
    }

    public dpk(emg<dpj> com_fossil_emg_com_fossil_dpj, eru<SummariesRepository> com_fossil_eru_com_portfolio_platform_data_source_SummariesRepository, eru<ActivitiesRepository> com_fossil_eru_com_portfolio_platform_data_source_ActivitiesRepository) {
        if ($assertionsDisabled || com_fossil_emg_com_fossil_dpj != null) {
            this.dcU = com_fossil_emg_com_fossil_dpj;
            if ($assertionsDisabled || com_fossil_eru_com_portfolio_platform_data_source_SummariesRepository != null) {
                this.summariesRepositoryProvider = com_fossil_eru_com_portfolio_platform_data_source_SummariesRepository;
                if ($assertionsDisabled || com_fossil_eru_com_portfolio_platform_data_source_ActivitiesRepository != null) {
                    this.cfd = com_fossil_eru_com_portfolio_platform_data_source_ActivitiesRepository;
                    return;
                }
                throw new AssertionError();
            }
            throw new AssertionError();
        }
        throw new AssertionError();
    }

    public dpj atH() {
        return (dpj) MembersInjectors.a(this.dcU, new dpj((SummariesRepository) this.summariesRepositoryProvider.get(), (ActivitiesRepository) this.cfd.get()));
    }

    public static emi<dpj> create(emg<dpj> com_fossil_emg_com_fossil_dpj, eru<SummariesRepository> com_fossil_eru_com_portfolio_platform_data_source_SummariesRepository, eru<ActivitiesRepository> com_fossil_eru_com_portfolio_platform_data_source_ActivitiesRepository) {
        return new dpk(com_fossil_emg_com_fossil_dpj, com_fossil_eru_com_portfolio_platform_data_source_SummariesRepository, com_fossil_eru_com_portfolio_platform_data_source_ActivitiesRepository);
    }
}
