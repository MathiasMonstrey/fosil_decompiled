package com.fossil;

import com.portfolio.platform.data.source.SleepSessionsRepository;
import com.portfolio.platform.data.source.UserRepository;
import dagger.internal.MembersInjectors;

public final class dmn implements emi<dmm> {
    static final /* synthetic */ boolean $assertionsDisabled = (!dmn.class.desiredAssertionStatus());
    private final eru<SleepSessionsRepository> cXq;
    private final emg<dmm> dai;
    private final eru<UserRepository> userRepositoryProvider;

    public /* synthetic */ Object get() {
        return ash();
    }

    public dmn(emg<dmm> com_fossil_emg_com_fossil_dmm, eru<SleepSessionsRepository> com_fossil_eru_com_portfolio_platform_data_source_SleepSessionsRepository, eru<UserRepository> com_fossil_eru_com_portfolio_platform_data_source_UserRepository) {
        if ($assertionsDisabled || com_fossil_emg_com_fossil_dmm != null) {
            this.dai = com_fossil_emg_com_fossil_dmm;
            if ($assertionsDisabled || com_fossil_eru_com_portfolio_platform_data_source_SleepSessionsRepository != null) {
                this.cXq = com_fossil_eru_com_portfolio_platform_data_source_SleepSessionsRepository;
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

    public dmm ash() {
        return (dmm) MembersInjectors.a(this.dai, new dmm((SleepSessionsRepository) this.cXq.get(), (UserRepository) this.userRepositoryProvider.get()));
    }

    public static emi<dmm> create(emg<dmm> com_fossil_emg_com_fossil_dmm, eru<SleepSessionsRepository> com_fossil_eru_com_portfolio_platform_data_source_SleepSessionsRepository, eru<UserRepository> com_fossil_eru_com_portfolio_platform_data_source_UserRepository) {
        return new dmn(com_fossil_emg_com_fossil_dmm, com_fossil_eru_com_portfolio_platform_data_source_SleepSessionsRepository, com_fossil_eru_com_portfolio_platform_data_source_UserRepository);
    }
}
