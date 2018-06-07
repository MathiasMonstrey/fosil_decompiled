package com.fossil;

import com.portfolio.platform.data.source.UserRepository;
import dagger.internal.MembersInjectors;

public final class dqi implements emi<dqh> {
    static final /* synthetic */ boolean $assertionsDisabled = (!dqi.class.desiredAssertionStatus());
    private final emg<dqh> ddC;
    private final eru<UserRepository> userRepositoryProvider;

    public /* synthetic */ Object get() {
        return atY();
    }

    public dqi(emg<dqh> com_fossil_emg_com_fossil_dqh, eru<UserRepository> com_fossil_eru_com_portfolio_platform_data_source_UserRepository) {
        if ($assertionsDisabled || com_fossil_emg_com_fossil_dqh != null) {
            this.ddC = com_fossil_emg_com_fossil_dqh;
            if ($assertionsDisabled || com_fossil_eru_com_portfolio_platform_data_source_UserRepository != null) {
                this.userRepositoryProvider = com_fossil_eru_com_portfolio_platform_data_source_UserRepository;
                return;
            }
            throw new AssertionError();
        }
        throw new AssertionError();
    }

    public dqh atY() {
        return (dqh) MembersInjectors.a(this.ddC, new dqh((UserRepository) this.userRepositoryProvider.get()));
    }

    public static emi<dqh> m9371a(emg<dqh> com_fossil_emg_com_fossil_dqh, eru<UserRepository> com_fossil_eru_com_portfolio_platform_data_source_UserRepository) {
        return new dqi(com_fossil_emg_com_fossil_dqh, com_fossil_eru_com_portfolio_platform_data_source_UserRepository);
    }
}
