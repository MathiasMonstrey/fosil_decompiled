package com.fossil;

import com.portfolio.platform.data.source.UserRepository;
import dagger.internal.MembersInjectors;

public final class dpm implements emi<dpl> {
    static final /* synthetic */ boolean $assertionsDisabled = (!dpm.class.desiredAssertionStatus());
    private final emg<dpl> dcW;
    private final eru<UserRepository> userRepositoryProvider;

    public /* synthetic */ Object get() {
        return atI();
    }

    public dpm(emg<dpl> com_fossil_emg_com_fossil_dpl, eru<UserRepository> com_fossil_eru_com_portfolio_platform_data_source_UserRepository) {
        if ($assertionsDisabled || com_fossil_emg_com_fossil_dpl != null) {
            this.dcW = com_fossil_emg_com_fossil_dpl;
            if ($assertionsDisabled || com_fossil_eru_com_portfolio_platform_data_source_UserRepository != null) {
                this.userRepositoryProvider = com_fossil_eru_com_portfolio_platform_data_source_UserRepository;
                return;
            }
            throw new AssertionError();
        }
        throw new AssertionError();
    }

    public dpl atI() {
        return (dpl) MembersInjectors.a(this.dcW, new dpl((UserRepository) this.userRepositoryProvider.get()));
    }

    public static emi<dpl> m9335a(emg<dpl> com_fossil_emg_com_fossil_dpl, eru<UserRepository> com_fossil_eru_com_portfolio_platform_data_source_UserRepository) {
        return new dpm(com_fossil_emg_com_fossil_dpl, com_fossil_eru_com_portfolio_platform_data_source_UserRepository);
    }
}
