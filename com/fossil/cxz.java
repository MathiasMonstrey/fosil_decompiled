package com.fossil;

import com.fossil.cxu.C2485b;
import com.portfolio.platform.PortfolioApp;
import dagger.internal.MembersInjectors;

public final class cxz implements emi<cxy> {
    static final /* synthetic */ boolean $assertionsDisabled = (!cxz.class.desiredAssertionStatus());
    private final eru<C2485b> cGA;
    private final eru<gy> cIB;
    private final eru<PortfolioApp> cKG;
    private final eru<cng> cKH;
    private final emg<cxy> chF;

    public /* synthetic */ Object get() {
        return ajI();
    }

    public cxz(emg<cxy> com_fossil_emg_com_fossil_cxy, eru<PortfolioApp> com_fossil_eru_com_portfolio_platform_PortfolioApp, eru<C2485b> com_fossil_eru_com_fossil_cxu_b, eru<gy> com_fossil_eru_com_fossil_gy, eru<cng> com_fossil_eru_com_fossil_cng) {
        if ($assertionsDisabled || com_fossil_emg_com_fossil_cxy != null) {
            this.chF = com_fossil_emg_com_fossil_cxy;
            if ($assertionsDisabled || com_fossil_eru_com_portfolio_platform_PortfolioApp != null) {
                this.cKG = com_fossil_eru_com_portfolio_platform_PortfolioApp;
                if ($assertionsDisabled || com_fossil_eru_com_fossil_cxu_b != null) {
                    this.cGA = com_fossil_eru_com_fossil_cxu_b;
                    if ($assertionsDisabled || com_fossil_eru_com_fossil_gy != null) {
                        this.cIB = com_fossil_eru_com_fossil_gy;
                        if ($assertionsDisabled || com_fossil_eru_com_fossil_cng != null) {
                            this.cKH = com_fossil_eru_com_fossil_cng;
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

    public cxy ajI() {
        return (cxy) MembersInjectors.a(this.chF, new cxy((PortfolioApp) this.cKG.get(), (C2485b) this.cGA.get(), (gy) this.cIB.get(), (cng) this.cKH.get()));
    }

    public static emi<cxy> create(emg<cxy> com_fossil_emg_com_fossil_cxy, eru<PortfolioApp> com_fossil_eru_com_portfolio_platform_PortfolioApp, eru<C2485b> com_fossil_eru_com_fossil_cxu_b, eru<gy> com_fossil_eru_com_fossil_gy, eru<cng> com_fossil_eru_com_fossil_cng) {
        return new cxz(com_fossil_emg_com_fossil_cxy, com_fossil_eru_com_portfolio_platform_PortfolioApp, com_fossil_eru_com_fossil_cxu_b, com_fossil_eru_com_fossil_gy, com_fossil_eru_com_fossil_cng);
    }
}
