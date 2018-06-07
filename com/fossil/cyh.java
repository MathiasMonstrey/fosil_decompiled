package com.fossil;

import com.portfolio.platform.data.source.UserRepository;
import dagger.internal.MembersInjectors;

public final class cyh implements emi<cyg> {
    static final /* synthetic */ boolean $assertionsDisabled = (!cyh.class.desiredAssertionStatus());
    private final emg<cyg> cKS;
    private final eru<UserRepository> cnc;

    public /* synthetic */ Object get() {
        return ajO();
    }

    public cyh(emg<cyg> com_fossil_emg_com_fossil_cyg, eru<UserRepository> com_fossil_eru_com_portfolio_platform_data_source_UserRepository) {
        if ($assertionsDisabled || com_fossil_emg_com_fossil_cyg != null) {
            this.cKS = com_fossil_emg_com_fossil_cyg;
            if ($assertionsDisabled || com_fossil_eru_com_portfolio_platform_data_source_UserRepository != null) {
                this.cnc = com_fossil_eru_com_portfolio_platform_data_source_UserRepository;
                return;
            }
            throw new AssertionError();
        }
        throw new AssertionError();
    }

    public cyg ajO() {
        return (cyg) MembersInjectors.a(this.cKS, new cyg((UserRepository) this.cnc.get()));
    }

    public static emi<cyg> m7898a(emg<cyg> com_fossil_emg_com_fossil_cyg, eru<UserRepository> com_fossil_eru_com_portfolio_platform_data_source_UserRepository) {
        return new cyh(com_fossil_emg_com_fossil_cyg, com_fossil_eru_com_portfolio_platform_data_source_UserRepository);
    }
}
