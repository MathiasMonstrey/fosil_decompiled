package com.fossil;

import com.fossil.dmh.C2958b;
import com.portfolio.platform.PortfolioApp;
import com.portfolio.platform.data.source.UserRepository;
import com.portfolio.platform.data.source.loader.SleepSessionsDayLoader;
import dagger.internal.MembersInjectors;

public final class dmk implements emi<dmj> {
    static final /* synthetic */ boolean $assertionsDisabled = (!dmk.class.desiredAssertionStatus());
    private final eru<C2958b> cGA;
    private final eru<PortfolioApp> cIA;
    private final eru<gy> cIB;
    private final eru<fj> cIC;
    private final eru<dmm> cjh;
    private final eru<dmt> cji;
    private final emg<dmj> clX;
    private final eru<SleepSessionsDayLoader> dah;
    private final eru<cnr> sharedPreferencesManagerProvider;
    private final eru<ckc> useCaseHandlerProvider;
    private final eru<UserRepository> userRepositoryProvider;

    public /* synthetic */ Object get() {
        return asg();
    }

    public dmk(emg<dmj> com_fossil_emg_com_fossil_dmj, eru<PortfolioApp> com_fossil_eru_com_portfolio_platform_PortfolioApp, eru<C2958b> com_fossil_eru_com_fossil_dmh_b, eru<cnr> com_fossil_eru_com_fossil_cnr, eru<gy> com_fossil_eru_com_fossil_gy, eru<fj> com_fossil_eru_com_fossil_fj, eru<SleepSessionsDayLoader> com_fossil_eru_com_portfolio_platform_data_source_loader_SleepSessionsDayLoader, eru<ckc> com_fossil_eru_com_fossil_ckc, eru<dmm> com_fossil_eru_com_fossil_dmm, eru<dmt> com_fossil_eru_com_fossil_dmt, eru<UserRepository> com_fossil_eru_com_portfolio_platform_data_source_UserRepository) {
        if ($assertionsDisabled || com_fossil_emg_com_fossil_dmj != null) {
            this.clX = com_fossil_emg_com_fossil_dmj;
            if ($assertionsDisabled || com_fossil_eru_com_portfolio_platform_PortfolioApp != null) {
                this.cIA = com_fossil_eru_com_portfolio_platform_PortfolioApp;
                if ($assertionsDisabled || com_fossil_eru_com_fossil_dmh_b != null) {
                    this.cGA = com_fossil_eru_com_fossil_dmh_b;
                    if ($assertionsDisabled || com_fossil_eru_com_fossil_cnr != null) {
                        this.sharedPreferencesManagerProvider = com_fossil_eru_com_fossil_cnr;
                        if ($assertionsDisabled || com_fossil_eru_com_fossil_gy != null) {
                            this.cIB = com_fossil_eru_com_fossil_gy;
                            if ($assertionsDisabled || com_fossil_eru_com_fossil_fj != null) {
                                this.cIC = com_fossil_eru_com_fossil_fj;
                                if ($assertionsDisabled || com_fossil_eru_com_portfolio_platform_data_source_loader_SleepSessionsDayLoader != null) {
                                    this.dah = com_fossil_eru_com_portfolio_platform_data_source_loader_SleepSessionsDayLoader;
                                    if ($assertionsDisabled || com_fossil_eru_com_fossil_ckc != null) {
                                        this.useCaseHandlerProvider = com_fossil_eru_com_fossil_ckc;
                                        if ($assertionsDisabled || com_fossil_eru_com_fossil_dmm != null) {
                                            this.cjh = com_fossil_eru_com_fossil_dmm;
                                            if ($assertionsDisabled || com_fossil_eru_com_fossil_dmt != null) {
                                                this.cji = com_fossil_eru_com_fossil_dmt;
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

    public dmj asg() {
        return (dmj) MembersInjectors.a(this.clX, new dmj((PortfolioApp) this.cIA.get(), (C2958b) this.cGA.get(), (cnr) this.sharedPreferencesManagerProvider.get(), (gy) this.cIB.get(), (fj) this.cIC.get(), (SleepSessionsDayLoader) this.dah.get(), (ckc) this.useCaseHandlerProvider.get(), (dmm) this.cjh.get(), (dmt) this.cji.get(), (UserRepository) this.userRepositoryProvider.get()));
    }

    public static emi<dmj> m9092a(emg<dmj> com_fossil_emg_com_fossil_dmj, eru<PortfolioApp> com_fossil_eru_com_portfolio_platform_PortfolioApp, eru<C2958b> com_fossil_eru_com_fossil_dmh_b, eru<cnr> com_fossil_eru_com_fossil_cnr, eru<gy> com_fossil_eru_com_fossil_gy, eru<fj> com_fossil_eru_com_fossil_fj, eru<SleepSessionsDayLoader> com_fossil_eru_com_portfolio_platform_data_source_loader_SleepSessionsDayLoader, eru<ckc> com_fossil_eru_com_fossil_ckc, eru<dmm> com_fossil_eru_com_fossil_dmm, eru<dmt> com_fossil_eru_com_fossil_dmt, eru<UserRepository> com_fossil_eru_com_portfolio_platform_data_source_UserRepository) {
        return new dmk(com_fossil_emg_com_fossil_dmj, com_fossil_eru_com_portfolio_platform_PortfolioApp, com_fossil_eru_com_fossil_dmh_b, com_fossil_eru_com_fossil_cnr, com_fossil_eru_com_fossil_gy, com_fossil_eru_com_fossil_fj, com_fossil_eru_com_portfolio_platform_data_source_loader_SleepSessionsDayLoader, com_fossil_eru_com_fossil_ckc, com_fossil_eru_com_fossil_dmm, com_fossil_eru_com_fossil_dmt, com_fossil_eru_com_portfolio_platform_data_source_UserRepository);
    }
}
