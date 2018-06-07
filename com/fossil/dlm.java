package com.fossil;

import com.fossil.dlj.C2925b;
import com.portfolio.platform.PortfolioApp;
import com.portfolio.platform.data.source.UserRepository;
import com.portfolio.platform.data.source.loader.ActivitiesDayLoader;
import dagger.internal.MembersInjectors;

public final class dlm implements emi<dll> {
    static final /* synthetic */ boolean $assertionsDisabled = (!dlm.class.desiredAssertionStatus());
    private final eru<C2925b> cGA;
    private final eru<PortfolioApp> cIA;
    private final eru<gy> cIB;
    private final eru<fj> cIC;
    private final eru<ActivitiesDayLoader> cOm;
    private final eru<dpf> cim;
    private final eru<dlo> cjf;
    private final eru<dlv> cjg;
    private final emg<dll> clJ;
    private final eru<cnr> sharedPreferencesManagerProvider;
    private final eru<ckc> useCaseHandlerProvider;
    private final eru<UserRepository> userRepositoryProvider;

    public /* synthetic */ Object get() {
        return arS();
    }

    public dlm(emg<dll> com_fossil_emg_com_fossil_dll, eru<C2925b> com_fossil_eru_com_fossil_dlj_b, eru<cnr> com_fossil_eru_com_fossil_cnr, eru<gy> com_fossil_eru_com_fossil_gy, eru<fj> com_fossil_eru_com_fossil_fj, eru<ActivitiesDayLoader> com_fossil_eru_com_portfolio_platform_data_source_loader_ActivitiesDayLoader, eru<ckc> com_fossil_eru_com_fossil_ckc, eru<dpf> com_fossil_eru_com_fossil_dpf, eru<dlo> com_fossil_eru_com_fossil_dlo, eru<dlv> com_fossil_eru_com_fossil_dlv, eru<PortfolioApp> com_fossil_eru_com_portfolio_platform_PortfolioApp, eru<UserRepository> com_fossil_eru_com_portfolio_platform_data_source_UserRepository) {
        if ($assertionsDisabled || com_fossil_emg_com_fossil_dll != null) {
            this.clJ = com_fossil_emg_com_fossil_dll;
            if ($assertionsDisabled || com_fossil_eru_com_fossil_dlj_b != null) {
                this.cGA = com_fossil_eru_com_fossil_dlj_b;
                if ($assertionsDisabled || com_fossil_eru_com_fossil_cnr != null) {
                    this.sharedPreferencesManagerProvider = com_fossil_eru_com_fossil_cnr;
                    if ($assertionsDisabled || com_fossil_eru_com_fossil_gy != null) {
                        this.cIB = com_fossil_eru_com_fossil_gy;
                        if ($assertionsDisabled || com_fossil_eru_com_fossil_fj != null) {
                            this.cIC = com_fossil_eru_com_fossil_fj;
                            if ($assertionsDisabled || com_fossil_eru_com_portfolio_platform_data_source_loader_ActivitiesDayLoader != null) {
                                this.cOm = com_fossil_eru_com_portfolio_platform_data_source_loader_ActivitiesDayLoader;
                                if ($assertionsDisabled || com_fossil_eru_com_fossil_ckc != null) {
                                    this.useCaseHandlerProvider = com_fossil_eru_com_fossil_ckc;
                                    if ($assertionsDisabled || com_fossil_eru_com_fossil_dpf != null) {
                                        this.cim = com_fossil_eru_com_fossil_dpf;
                                        if ($assertionsDisabled || com_fossil_eru_com_fossil_dlo != null) {
                                            this.cjf = com_fossil_eru_com_fossil_dlo;
                                            if ($assertionsDisabled || com_fossil_eru_com_fossil_dlv != null) {
                                                this.cjg = com_fossil_eru_com_fossil_dlv;
                                                if ($assertionsDisabled || com_fossil_eru_com_portfolio_platform_PortfolioApp != null) {
                                                    this.cIA = com_fossil_eru_com_portfolio_platform_PortfolioApp;
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

    public dll arS() {
        return (dll) MembersInjectors.a(this.clJ, new dll((C2925b) this.cGA.get(), (cnr) this.sharedPreferencesManagerProvider.get(), (gy) this.cIB.get(), (fj) this.cIC.get(), (ActivitiesDayLoader) this.cOm.get(), (ckc) this.useCaseHandlerProvider.get(), (dpf) this.cim.get(), (dlo) this.cjf.get(), (dlv) this.cjg.get(), (PortfolioApp) this.cIA.get(), (UserRepository) this.userRepositoryProvider.get()));
    }

    public static emi<dll> m9013a(emg<dll> com_fossil_emg_com_fossil_dll, eru<C2925b> com_fossil_eru_com_fossil_dlj_b, eru<cnr> com_fossil_eru_com_fossil_cnr, eru<gy> com_fossil_eru_com_fossil_gy, eru<fj> com_fossil_eru_com_fossil_fj, eru<ActivitiesDayLoader> com_fossil_eru_com_portfolio_platform_data_source_loader_ActivitiesDayLoader, eru<ckc> com_fossil_eru_com_fossil_ckc, eru<dpf> com_fossil_eru_com_fossil_dpf, eru<dlo> com_fossil_eru_com_fossil_dlo, eru<dlv> com_fossil_eru_com_fossil_dlv, eru<PortfolioApp> com_fossil_eru_com_portfolio_platform_PortfolioApp, eru<UserRepository> com_fossil_eru_com_portfolio_platform_data_source_UserRepository) {
        return new dlm(com_fossil_emg_com_fossil_dll, com_fossil_eru_com_fossil_dlj_b, com_fossil_eru_com_fossil_cnr, com_fossil_eru_com_fossil_gy, com_fossil_eru_com_fossil_fj, com_fossil_eru_com_portfolio_platform_data_source_loader_ActivitiesDayLoader, com_fossil_eru_com_fossil_ckc, com_fossil_eru_com_fossil_dpf, com_fossil_eru_com_fossil_dlo, com_fossil_eru_com_fossil_dlv, com_fossil_eru_com_portfolio_platform_PortfolioApp, com_fossil_eru_com_portfolio_platform_data_source_UserRepository);
    }
}
