package com.fossil;

import com.portfolio.platform.data.source.UserRepository;
import dagger.internal.MembersInjectors;

public final class dqc implements emi<dqb> {
    static final /* synthetic */ boolean $assertionsDisabled = (!dqc.class.desiredAssertionStatus());
    private final emg<dqb> ddw;
    private final eru<UserRepository> userRepositoryProvider;

    public /* synthetic */ Object get() {
        return atV();
    }

    public dqc(emg<dqb> com_fossil_emg_com_fossil_dqb, eru<UserRepository> com_fossil_eru_com_portfolio_platform_data_source_UserRepository) {
        if ($assertionsDisabled || com_fossil_emg_com_fossil_dqb != null) {
            this.ddw = com_fossil_emg_com_fossil_dqb;
            if ($assertionsDisabled || com_fossil_eru_com_portfolio_platform_data_source_UserRepository != null) {
                this.userRepositoryProvider = com_fossil_eru_com_portfolio_platform_data_source_UserRepository;
                return;
            }
            throw new AssertionError();
        }
        throw new AssertionError();
    }

    public dqb atV() {
        return (dqb) MembersInjectors.a(this.ddw, new dqb((UserRepository) this.userRepositoryProvider.get()));
    }

    public static emi<dqb> m9362a(emg<dqb> com_fossil_emg_com_fossil_dqb, eru<UserRepository> com_fossil_eru_com_portfolio_platform_data_source_UserRepository) {
        return new dqc(com_fossil_emg_com_fossil_dqb, com_fossil_eru_com_portfolio_platform_data_source_UserRepository);
    }
}
