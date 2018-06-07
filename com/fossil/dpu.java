package com.fossil;

import com.portfolio.platform.data.source.UserRepository;
import dagger.internal.MembersInjectors;

public final class dpu implements emi<dpt> {
    static final /* synthetic */ boolean $assertionsDisabled = (!dpu.class.desiredAssertionStatus());
    private final emg<dpt> ddl;
    private final eru<UserRepository> userRepositoryProvider;

    public /* synthetic */ Object get() {
        return atP();
    }

    public dpu(emg<dpt> com_fossil_emg_com_fossil_dpt, eru<UserRepository> com_fossil_eru_com_portfolio_platform_data_source_UserRepository) {
        if ($assertionsDisabled || com_fossil_emg_com_fossil_dpt != null) {
            this.ddl = com_fossil_emg_com_fossil_dpt;
            if ($assertionsDisabled || com_fossil_eru_com_portfolio_platform_data_source_UserRepository != null) {
                this.userRepositoryProvider = com_fossil_eru_com_portfolio_platform_data_source_UserRepository;
                return;
            }
            throw new AssertionError();
        }
        throw new AssertionError();
    }

    public dpt atP() {
        return (dpt) MembersInjectors.a(this.ddl, new dpt((UserRepository) this.userRepositoryProvider.get()));
    }

    public static emi<dpt> m9349a(emg<dpt> com_fossil_emg_com_fossil_dpt, eru<UserRepository> com_fossil_eru_com_portfolio_platform_data_source_UserRepository) {
        return new dpu(com_fossil_emg_com_fossil_dpt, com_fossil_eru_com_portfolio_platform_data_source_UserRepository);
    }
}
