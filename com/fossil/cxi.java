package com.fossil;

import com.portfolio.platform.PortfolioApp;
import com.portfolio.platform.data.source.AlarmsRepository;
import dagger.internal.MembersInjectors;

public final class cxi implements emi<cxh> {
    static final /* synthetic */ boolean $assertionsDisabled = (!cxi.class.desiredAssertionStatus());
    private final eru<PortfolioApp> cIA;
    private final eru<gy> cIB;
    private final emg<cxh> cKf;
    private final eru<AlarmsRepository> ceE;

    public /* synthetic */ Object get() {
        return aju();
    }

    public cxi(emg<cxh> com_fossil_emg_com_fossil_cxh, eru<PortfolioApp> com_fossil_eru_com_portfolio_platform_PortfolioApp, eru<gy> com_fossil_eru_com_fossil_gy, eru<AlarmsRepository> com_fossil_eru_com_portfolio_platform_data_source_AlarmsRepository) {
        if ($assertionsDisabled || com_fossil_emg_com_fossil_cxh != null) {
            this.cKf = com_fossil_emg_com_fossil_cxh;
            if ($assertionsDisabled || com_fossil_eru_com_portfolio_platform_PortfolioApp != null) {
                this.cIA = com_fossil_eru_com_portfolio_platform_PortfolioApp;
                if ($assertionsDisabled || com_fossil_eru_com_fossil_gy != null) {
                    this.cIB = com_fossil_eru_com_fossil_gy;
                    if ($assertionsDisabled || com_fossil_eru_com_portfolio_platform_data_source_AlarmsRepository != null) {
                        this.ceE = com_fossil_eru_com_portfolio_platform_data_source_AlarmsRepository;
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

    public cxh aju() {
        return (cxh) MembersInjectors.a(this.cKf, new cxh((PortfolioApp) this.cIA.get(), (gy) this.cIB.get(), (AlarmsRepository) this.ceE.get()));
    }

    public static emi<cxh> create(emg<cxh> com_fossil_emg_com_fossil_cxh, eru<PortfolioApp> com_fossil_eru_com_portfolio_platform_PortfolioApp, eru<gy> com_fossil_eru_com_fossil_gy, eru<AlarmsRepository> com_fossil_eru_com_portfolio_platform_data_source_AlarmsRepository) {
        return new cxi(com_fossil_emg_com_fossil_cxh, com_fossil_eru_com_portfolio_platform_PortfolioApp, com_fossil_eru_com_fossil_gy, com_fossil_eru_com_portfolio_platform_data_source_AlarmsRepository);
    }
}
