package com.fossil;

import com.fossil.dmo.C2967b;
import com.portfolio.platform.data.source.UserRepository;
import com.portfolio.platform.data.source.loader.SleepSummariesLoader;
import dagger.internal.MembersInjectors;

public final class dmr implements emi<dmq> {
    static final /* synthetic */ boolean $assertionsDisabled = (!dmr.class.desiredAssertionStatus());
    private final eru<C2967b> cGA;
    private final eru<fj> cIC;
    private final eru<dpf> cim;
    private final eru<dmt> cji;
    private final emg<dmq> cmb;
    private final eru<SleepSummariesLoader> cme;
    private final eru<ckc> useCaseHandlerProvider;
    private final eru<UserRepository> userRepositoryProvider;

    public /* synthetic */ Object get() {
        return asj();
    }

    public dmr(emg<dmq> com_fossil_emg_com_fossil_dmq, eru<C2967b> com_fossil_eru_com_fossil_dmo_b, eru<fj> com_fossil_eru_com_fossil_fj, eru<SleepSummariesLoader> com_fossil_eru_com_portfolio_platform_data_source_loader_SleepSummariesLoader, eru<UserRepository> com_fossil_eru_com_portfolio_platform_data_source_UserRepository, eru<ckc> com_fossil_eru_com_fossil_ckc, eru<dpf> com_fossil_eru_com_fossil_dpf, eru<dmt> com_fossil_eru_com_fossil_dmt) {
        if ($assertionsDisabled || com_fossil_emg_com_fossil_dmq != null) {
            this.cmb = com_fossil_emg_com_fossil_dmq;
            if ($assertionsDisabled || com_fossil_eru_com_fossil_dmo_b != null) {
                this.cGA = com_fossil_eru_com_fossil_dmo_b;
                if ($assertionsDisabled || com_fossil_eru_com_fossil_fj != null) {
                    this.cIC = com_fossil_eru_com_fossil_fj;
                    if ($assertionsDisabled || com_fossil_eru_com_portfolio_platform_data_source_loader_SleepSummariesLoader != null) {
                        this.cme = com_fossil_eru_com_portfolio_platform_data_source_loader_SleepSummariesLoader;
                        if ($assertionsDisabled || com_fossil_eru_com_portfolio_platform_data_source_UserRepository != null) {
                            this.userRepositoryProvider = com_fossil_eru_com_portfolio_platform_data_source_UserRepository;
                            if ($assertionsDisabled || com_fossil_eru_com_fossil_ckc != null) {
                                this.useCaseHandlerProvider = com_fossil_eru_com_fossil_ckc;
                                if ($assertionsDisabled || com_fossil_eru_com_fossil_dpf != null) {
                                    this.cim = com_fossil_eru_com_fossil_dpf;
                                    if ($assertionsDisabled || com_fossil_eru_com_fossil_dmt != null) {
                                        this.cji = com_fossil_eru_com_fossil_dmt;
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
                throw new AssertionError();
            }
            throw new AssertionError();
        }
        throw new AssertionError();
    }

    public dmq asj() {
        return (dmq) MembersInjectors.a(this.cmb, new dmq((C2967b) this.cGA.get(), (fj) this.cIC.get(), (SleepSummariesLoader) this.cme.get(), (UserRepository) this.userRepositoryProvider.get(), (ckc) this.useCaseHandlerProvider.get(), (dpf) this.cim.get(), (dmt) this.cji.get()));
    }

    public static emi<dmq> m9115a(emg<dmq> com_fossil_emg_com_fossil_dmq, eru<C2967b> com_fossil_eru_com_fossil_dmo_b, eru<fj> com_fossil_eru_com_fossil_fj, eru<SleepSummariesLoader> com_fossil_eru_com_portfolio_platform_data_source_loader_SleepSummariesLoader, eru<UserRepository> com_fossil_eru_com_portfolio_platform_data_source_UserRepository, eru<ckc> com_fossil_eru_com_fossil_ckc, eru<dpf> com_fossil_eru_com_fossil_dpf, eru<dmt> com_fossil_eru_com_fossil_dmt) {
        return new dmr(com_fossil_emg_com_fossil_dmq, com_fossil_eru_com_fossil_dmo_b, com_fossil_eru_com_fossil_fj, com_fossil_eru_com_portfolio_platform_data_source_loader_SleepSummariesLoader, com_fossil_eru_com_portfolio_platform_data_source_UserRepository, com_fossil_eru_com_fossil_ckc, com_fossil_eru_com_fossil_dpf, com_fossil_eru_com_fossil_dmt);
    }
}
