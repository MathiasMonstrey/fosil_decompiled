package com.fossil;

import com.portfolio.platform.data.source.UserRepository;
import dagger.internal.MembersInjectors;

public final class dpg implements emi<dpf> {
    static final /* synthetic */ boolean $assertionsDisabled = (!dpg.class.desiredAssertionStatus());
    private final emg<dpf> dcP;
    private final eru<UserRepository> userRepositoryProvider;

    public /* synthetic */ Object get() {
        return atF();
    }

    public dpg(emg<dpf> com_fossil_emg_com_fossil_dpf, eru<UserRepository> com_fossil_eru_com_portfolio_platform_data_source_UserRepository) {
        if ($assertionsDisabled || com_fossil_emg_com_fossil_dpf != null) {
            this.dcP = com_fossil_emg_com_fossil_dpf;
            if ($assertionsDisabled || com_fossil_eru_com_portfolio_platform_data_source_UserRepository != null) {
                this.userRepositoryProvider = com_fossil_eru_com_portfolio_platform_data_source_UserRepository;
                return;
            }
            throw new AssertionError();
        }
        throw new AssertionError();
    }

    public dpf atF() {
        return (dpf) MembersInjectors.a(this.dcP, new dpf((UserRepository) this.userRepositoryProvider.get()));
    }

    public static emi<dpf> m9324a(emg<dpf> com_fossil_emg_com_fossil_dpf, eru<UserRepository> com_fossil_eru_com_portfolio_platform_data_source_UserRepository) {
        return new dpg(com_fossil_emg_com_fossil_dpf, com_fossil_eru_com_portfolio_platform_data_source_UserRepository);
    }
}
