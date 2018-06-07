package com.fossil;

import com.portfolio.platform.data.source.UserRepository;
import dagger.internal.MembersInjectors;

public final class dpw implements emi<dpv> {
    static final /* synthetic */ boolean $assertionsDisabled = (!dpw.class.desiredAssertionStatus());
    private final emg<dpv> ddn;
    private final eru<UserRepository> userRepositoryProvider;

    public /* synthetic */ Object get() {
        return atQ();
    }

    public dpw(emg<dpv> com_fossil_emg_com_fossil_dpv, eru<UserRepository> com_fossil_eru_com_portfolio_platform_data_source_UserRepository) {
        if ($assertionsDisabled || com_fossil_emg_com_fossil_dpv != null) {
            this.ddn = com_fossil_emg_com_fossil_dpv;
            if ($assertionsDisabled || com_fossil_eru_com_portfolio_platform_data_source_UserRepository != null) {
                this.userRepositoryProvider = com_fossil_eru_com_portfolio_platform_data_source_UserRepository;
                return;
            }
            throw new AssertionError();
        }
        throw new AssertionError();
    }

    public dpv atQ() {
        return (dpv) MembersInjectors.a(this.ddn, new dpv((UserRepository) this.userRepositoryProvider.get()));
    }

    public static emi<dpv> m9352a(emg<dpv> com_fossil_emg_com_fossil_dpv, eru<UserRepository> com_fossil_eru_com_portfolio_platform_data_source_UserRepository) {
        return new dpw(com_fossil_emg_com_fossil_dpv, com_fossil_eru_com_portfolio_platform_data_source_UserRepository);
    }
}
