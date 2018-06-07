package com.fossil;

import com.portfolio.platform.data.source.UserRepository;
import dagger.internal.MembersInjectors;

public final class dqa implements emi<dpz> {
    static final /* synthetic */ boolean $assertionsDisabled = (!dqa.class.desiredAssertionStatus());
    private final emg<dpz> ddu;
    private final eru<UserRepository> userRepositoryProvider;

    public /* synthetic */ Object get() {
        return atU();
    }

    public dqa(emg<dpz> com_fossil_emg_com_fossil_dpz, eru<UserRepository> com_fossil_eru_com_portfolio_platform_data_source_UserRepository) {
        if ($assertionsDisabled || com_fossil_emg_com_fossil_dpz != null) {
            this.ddu = com_fossil_emg_com_fossil_dpz;
            if ($assertionsDisabled || com_fossil_eru_com_portfolio_platform_data_source_UserRepository != null) {
                this.userRepositoryProvider = com_fossil_eru_com_portfolio_platform_data_source_UserRepository;
                return;
            }
            throw new AssertionError();
        }
        throw new AssertionError();
    }

    public dpz atU() {
        return (dpz) MembersInjectors.a(this.ddu, new dpz((UserRepository) this.userRepositoryProvider.get()));
    }

    public static emi<dpz> m9359a(emg<dpz> com_fossil_emg_com_fossil_dpz, eru<UserRepository> com_fossil_eru_com_portfolio_platform_data_source_UserRepository) {
        return new dqa(com_fossil_emg_com_fossil_dpz, com_fossil_eru_com_portfolio_platform_data_source_UserRepository);
    }
}
