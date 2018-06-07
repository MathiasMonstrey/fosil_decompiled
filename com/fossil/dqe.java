package com.fossil;

import com.portfolio.platform.data.source.UserRepository;
import dagger.internal.MembersInjectors;

public final class dqe implements emi<dqd> {
    static final /* synthetic */ boolean $assertionsDisabled = (!dqe.class.desiredAssertionStatus());
    private final emg<dqd> ddy;
    private final eru<UserRepository> userRepositoryProvider;

    public /* synthetic */ Object get() {
        return atW();
    }

    public dqe(emg<dqd> com_fossil_emg_com_fossil_dqd, eru<UserRepository> com_fossil_eru_com_portfolio_platform_data_source_UserRepository) {
        if ($assertionsDisabled || com_fossil_emg_com_fossil_dqd != null) {
            this.ddy = com_fossil_emg_com_fossil_dqd;
            if ($assertionsDisabled || com_fossil_eru_com_portfolio_platform_data_source_UserRepository != null) {
                this.userRepositoryProvider = com_fossil_eru_com_portfolio_platform_data_source_UserRepository;
                return;
            }
            throw new AssertionError();
        }
        throw new AssertionError();
    }

    public dqd atW() {
        return (dqd) MembersInjectors.a(this.ddy, new dqd((UserRepository) this.userRepositoryProvider.get()));
    }

    public static emi<dqd> m9365a(emg<dqd> com_fossil_emg_com_fossil_dqd, eru<UserRepository> com_fossil_eru_com_portfolio_platform_data_source_UserRepository) {
        return new dqe(com_fossil_emg_com_fossil_dqd, com_fossil_eru_com_portfolio_platform_data_source_UserRepository);
    }
}
