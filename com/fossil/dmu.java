package com.fossil;

import com.portfolio.platform.data.source.SleepSummariesRepository;
import com.portfolio.platform.data.source.UserRepository;
import dagger.internal.MembersInjectors;

public final class dmu implements emi<dmt> {
    static final /* synthetic */ boolean $assertionsDisabled = (!dmu.class.desiredAssertionStatus());
    private final emg<dmt> daq;
    private final eru<SleepSummariesRepository> sleepSummariesRepositoryProvider;
    private final eru<UserRepository> userRepositoryProvider;

    public /* synthetic */ Object get() {
        return ask();
    }

    public dmu(emg<dmt> com_fossil_emg_com_fossil_dmt, eru<SleepSummariesRepository> com_fossil_eru_com_portfolio_platform_data_source_SleepSummariesRepository, eru<UserRepository> com_fossil_eru_com_portfolio_platform_data_source_UserRepository) {
        if ($assertionsDisabled || com_fossil_emg_com_fossil_dmt != null) {
            this.daq = com_fossil_emg_com_fossil_dmt;
            if ($assertionsDisabled || com_fossil_eru_com_portfolio_platform_data_source_SleepSummariesRepository != null) {
                this.sleepSummariesRepositoryProvider = com_fossil_eru_com_portfolio_platform_data_source_SleepSummariesRepository;
                if ($assertionsDisabled || com_fossil_eru_com_portfolio_platform_data_source_UserRepository != null) {
                    this.userRepositoryProvider = com_fossil_eru_com_portfolio_platform_data_source_UserRepository;
                    return;
                }
                throw new AssertionError();
            }
            throw new AssertionError();
        }
        throw new AssertionError();
    }

    public dmt ask() {
        return (dmt) MembersInjectors.a(this.daq, new dmt((SleepSummariesRepository) this.sleepSummariesRepositoryProvider.get(), (UserRepository) this.userRepositoryProvider.get()));
    }

    public static emi<dmt> create(emg<dmt> com_fossil_emg_com_fossil_dmt, eru<SleepSummariesRepository> com_fossil_eru_com_portfolio_platform_data_source_SleepSummariesRepository, eru<UserRepository> com_fossil_eru_com_portfolio_platform_data_source_UserRepository) {
        return new dmu(com_fossil_emg_com_fossil_dmt, com_fossil_eru_com_portfolio_platform_data_source_SleepSummariesRepository, com_fossil_eru_com_portfolio_platform_data_source_UserRepository);
    }
}
