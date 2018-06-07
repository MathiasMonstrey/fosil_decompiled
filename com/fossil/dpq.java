package com.fossil;

import com.portfolio.platform.data.source.UserRepository;
import dagger.internal.MembersInjectors;

public final class dpq implements emi<dpp> {
    static final /* synthetic */ boolean $assertionsDisabled = (!dpq.class.desiredAssertionStatus());
    private final eru<UserRepository> cnc;
    private final emg<dpp> ddd;

    public /* synthetic */ Object get() {
        return atL();
    }

    public dpq(emg<dpp> com_fossil_emg_com_fossil_dpp, eru<UserRepository> com_fossil_eru_com_portfolio_platform_data_source_UserRepository) {
        if ($assertionsDisabled || com_fossil_emg_com_fossil_dpp != null) {
            this.ddd = com_fossil_emg_com_fossil_dpp;
            if ($assertionsDisabled || com_fossil_eru_com_portfolio_platform_data_source_UserRepository != null) {
                this.cnc = com_fossil_eru_com_portfolio_platform_data_source_UserRepository;
                return;
            }
            throw new AssertionError();
        }
        throw new AssertionError();
    }

    public dpp atL() {
        return (dpp) MembersInjectors.a(this.ddd, new dpp((UserRepository) this.cnc.get()));
    }

    public static emi<dpp> m9341a(emg<dpp> com_fossil_emg_com_fossil_dpp, eru<UserRepository> com_fossil_eru_com_portfolio_platform_data_source_UserRepository) {
        return new dpq(com_fossil_emg_com_fossil_dpp, com_fossil_eru_com_portfolio_platform_data_source_UserRepository);
    }
}
