package com.fossil;

import com.fossil.cwa.C2428b;
import com.portfolio.platform.PortfolioApp;
import com.portfolio.platform.data.source.DeviceRepository;
import dagger.internal.MembersInjectors;

public final class cwd implements emi<cwc> {
    static final /* synthetic */ boolean $assertionsDisabled = (!cwd.class.desiredAssertionStatus());
    private final eru<C2428b> cGA;
    private final eru<PortfolioApp> cIA;
    private final emg<cwc> cmt;
    private final eru<cys> cmv;
    private final eru<DeviceRepository> deviceRepositoryProvider;
    private final eru<cnr> sharedPreferencesManagerProvider;
    private final eru<ckc> useCaseHandlerProvider;

    public /* synthetic */ Object get() {
        return aiO();
    }

    public cwd(emg<cwc> com_fossil_emg_com_fossil_cwc, eru<C2428b> com_fossil_eru_com_fossil_cwa_b, eru<ckc> com_fossil_eru_com_fossil_ckc, eru<cys> com_fossil_eru_com_fossil_cys, eru<DeviceRepository> com_fossil_eru_com_portfolio_platform_data_source_DeviceRepository, eru<PortfolioApp> com_fossil_eru_com_portfolio_platform_PortfolioApp, eru<cnr> com_fossil_eru_com_fossil_cnr) {
        if ($assertionsDisabled || com_fossil_emg_com_fossil_cwc != null) {
            this.cmt = com_fossil_emg_com_fossil_cwc;
            if ($assertionsDisabled || com_fossil_eru_com_fossil_cwa_b != null) {
                this.cGA = com_fossil_eru_com_fossil_cwa_b;
                if ($assertionsDisabled || com_fossil_eru_com_fossil_ckc != null) {
                    this.useCaseHandlerProvider = com_fossil_eru_com_fossil_ckc;
                    if ($assertionsDisabled || com_fossil_eru_com_fossil_cys != null) {
                        this.cmv = com_fossil_eru_com_fossil_cys;
                        if ($assertionsDisabled || com_fossil_eru_com_portfolio_platform_data_source_DeviceRepository != null) {
                            this.deviceRepositoryProvider = com_fossil_eru_com_portfolio_platform_data_source_DeviceRepository;
                            if ($assertionsDisabled || com_fossil_eru_com_portfolio_platform_PortfolioApp != null) {
                                this.cIA = com_fossil_eru_com_portfolio_platform_PortfolioApp;
                                if ($assertionsDisabled || com_fossil_eru_com_fossil_cnr != null) {
                                    this.sharedPreferencesManagerProvider = com_fossil_eru_com_fossil_cnr;
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

    public cwc aiO() {
        return (cwc) MembersInjectors.a(this.cmt, new cwc((C2428b) this.cGA.get(), (ckc) this.useCaseHandlerProvider.get(), (cys) this.cmv.get(), (DeviceRepository) this.deviceRepositoryProvider.get(), (PortfolioApp) this.cIA.get(), (cnr) this.sharedPreferencesManagerProvider.get()));
    }

    public static emi<cwc> m7744a(emg<cwc> com_fossil_emg_com_fossil_cwc, eru<C2428b> com_fossil_eru_com_fossil_cwa_b, eru<ckc> com_fossil_eru_com_fossil_ckc, eru<cys> com_fossil_eru_com_fossil_cys, eru<DeviceRepository> com_fossil_eru_com_portfolio_platform_data_source_DeviceRepository, eru<PortfolioApp> com_fossil_eru_com_portfolio_platform_PortfolioApp, eru<cnr> com_fossil_eru_com_fossil_cnr) {
        return new cwd(com_fossil_emg_com_fossil_cwc, com_fossil_eru_com_fossil_cwa_b, com_fossil_eru_com_fossil_ckc, com_fossil_eru_com_fossil_cys, com_fossil_eru_com_portfolio_platform_data_source_DeviceRepository, com_fossil_eru_com_portfolio_platform_PortfolioApp, com_fossil_eru_com_fossil_cnr);
    }
}
