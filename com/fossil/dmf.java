package com.fossil;

import com.fossil.dmc.C2954b;
import com.portfolio.platform.data.source.UserRepository;
import com.portfolio.platform.data.source.loader.ActivitiesWeekLoader;
import dagger.internal.MembersInjectors;

public final class dmf implements emi<dme> {
    static final /* synthetic */ boolean $assertionsDisabled = (!dmf.class.desiredAssertionStatus());
    private final eru<C2954b> cGA;
    private final eru<fj> cIC;
    private final emg<dme> clQ;
    private final eru<ActivitiesWeekLoader> clS;
    private final eru<UserRepository> userRepositoryProvider;

    public /* synthetic */ Object get() {
        return ase();
    }

    public dmf(emg<dme> com_fossil_emg_com_fossil_dme, eru<C2954b> com_fossil_eru_com_fossil_dmc_b, eru<fj> com_fossil_eru_com_fossil_fj, eru<ActivitiesWeekLoader> com_fossil_eru_com_portfolio_platform_data_source_loader_ActivitiesWeekLoader, eru<UserRepository> com_fossil_eru_com_portfolio_platform_data_source_UserRepository) {
        if ($assertionsDisabled || com_fossil_emg_com_fossil_dme != null) {
            this.clQ = com_fossil_emg_com_fossil_dme;
            if ($assertionsDisabled || com_fossil_eru_com_fossil_dmc_b != null) {
                this.cGA = com_fossil_eru_com_fossil_dmc_b;
                if ($assertionsDisabled || com_fossil_eru_com_fossil_fj != null) {
                    this.cIC = com_fossil_eru_com_fossil_fj;
                    if ($assertionsDisabled || com_fossil_eru_com_portfolio_platform_data_source_loader_ActivitiesWeekLoader != null) {
                        this.clS = com_fossil_eru_com_portfolio_platform_data_source_loader_ActivitiesWeekLoader;
                        if ($assertionsDisabled || com_fossil_eru_com_portfolio_platform_data_source_UserRepository != null) {
                            this.userRepositoryProvider = com_fossil_eru_com_portfolio_platform_data_source_UserRepository;
                            return;
                        }
                        throw new AssertionError();
                    }
                    throw new AssertionError();
                }
                throw new AssertionError();
            }
            throw new AssertionError();
        }
        throw new AssertionError();
    }

    public dme ase() {
        return (dme) MembersInjectors.a(this.clQ, new dme((C2954b) this.cGA.get(), (fj) this.cIC.get(), (ActivitiesWeekLoader) this.clS.get(), (UserRepository) this.userRepositoryProvider.get()));
    }

    public static emi<dme> create(emg<dme> com_fossil_emg_com_fossil_dme, eru<C2954b> com_fossil_eru_com_fossil_dmc_b, eru<fj> com_fossil_eru_com_fossil_fj, eru<ActivitiesWeekLoader> com_fossil_eru_com_portfolio_platform_data_source_loader_ActivitiesWeekLoader, eru<UserRepository> com_fossil_eru_com_portfolio_platform_data_source_UserRepository) {
        return new dmf(com_fossil_emg_com_fossil_dme, com_fossil_eru_com_fossil_dmc_b, com_fossil_eru_com_fossil_fj, com_fossil_eru_com_portfolio_platform_data_source_loader_ActivitiesWeekLoader, com_fossil_eru_com_portfolio_platform_data_source_UserRepository);
    }
}
