package com.fossil;

import com.fossil.dlq.C2939b;
import com.portfolio.platform.data.source.UserRepository;
import com.portfolio.platform.data.source.loader.SummariesLoader;
import dagger.internal.MembersInjectors;

public final class dlt implements emi<dls> {
    static final /* synthetic */ boolean $assertionsDisabled = (!dlt.class.desiredAssertionStatus());
    private final eru<C2939b> cGA;
    private final eru<fj> cIC;
    private final eru<dpf> cim;
    private final eru<dlv> cjg;
    private final emg<dls> clM;
    private final eru<SummariesLoader> clO;
    private final eru<ckc> useCaseHandlerProvider;
    private final eru<UserRepository> userRepositoryProvider;

    public /* synthetic */ Object get() {
        return arY();
    }

    public dlt(emg<dls> com_fossil_emg_com_fossil_dls, eru<C2939b> com_fossil_eru_com_fossil_dlq_b, eru<fj> com_fossil_eru_com_fossil_fj, eru<SummariesLoader> com_fossil_eru_com_portfolio_platform_data_source_loader_SummariesLoader, eru<UserRepository> com_fossil_eru_com_portfolio_platform_data_source_UserRepository, eru<ckc> com_fossil_eru_com_fossil_ckc, eru<dpf> com_fossil_eru_com_fossil_dpf, eru<dlv> com_fossil_eru_com_fossil_dlv) {
        if ($assertionsDisabled || com_fossil_emg_com_fossil_dls != null) {
            this.clM = com_fossil_emg_com_fossil_dls;
            if ($assertionsDisabled || com_fossil_eru_com_fossil_dlq_b != null) {
                this.cGA = com_fossil_eru_com_fossil_dlq_b;
                if ($assertionsDisabled || com_fossil_eru_com_fossil_fj != null) {
                    this.cIC = com_fossil_eru_com_fossil_fj;
                    if ($assertionsDisabled || com_fossil_eru_com_portfolio_platform_data_source_loader_SummariesLoader != null) {
                        this.clO = com_fossil_eru_com_portfolio_platform_data_source_loader_SummariesLoader;
                        if ($assertionsDisabled || com_fossil_eru_com_portfolio_platform_data_source_UserRepository != null) {
                            this.userRepositoryProvider = com_fossil_eru_com_portfolio_platform_data_source_UserRepository;
                            if ($assertionsDisabled || com_fossil_eru_com_fossil_ckc != null) {
                                this.useCaseHandlerProvider = com_fossil_eru_com_fossil_ckc;
                                if ($assertionsDisabled || com_fossil_eru_com_fossil_dpf != null) {
                                    this.cim = com_fossil_eru_com_fossil_dpf;
                                    if ($assertionsDisabled || com_fossil_eru_com_fossil_dlv != null) {
                                        this.cjg = com_fossil_eru_com_fossil_dlv;
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

    public dls arY() {
        return (dls) MembersInjectors.a(this.clM, new dls((C2939b) this.cGA.get(), (fj) this.cIC.get(), (SummariesLoader) this.clO.get(), (UserRepository) this.userRepositoryProvider.get(), (ckc) this.useCaseHandlerProvider.get(), (dpf) this.cim.get(), (dlv) this.cjg.get()));
    }

    public static emi<dls> m9036a(emg<dls> com_fossil_emg_com_fossil_dls, eru<C2939b> com_fossil_eru_com_fossil_dlq_b, eru<fj> com_fossil_eru_com_fossil_fj, eru<SummariesLoader> com_fossil_eru_com_portfolio_platform_data_source_loader_SummariesLoader, eru<UserRepository> com_fossil_eru_com_portfolio_platform_data_source_UserRepository, eru<ckc> com_fossil_eru_com_fossil_ckc, eru<dpf> com_fossil_eru_com_fossil_dpf, eru<dlv> com_fossil_eru_com_fossil_dlv) {
        return new dlt(com_fossil_emg_com_fossil_dls, com_fossil_eru_com_fossil_dlq_b, com_fossil_eru_com_fossil_fj, com_fossil_eru_com_portfolio_platform_data_source_loader_SummariesLoader, com_fossil_eru_com_portfolio_platform_data_source_UserRepository, com_fossil_eru_com_fossil_ckc, com_fossil_eru_com_fossil_dpf, com_fossil_eru_com_fossil_dlv);
    }
}
