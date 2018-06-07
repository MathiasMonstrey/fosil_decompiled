package com.fossil;

import com.fossil.dau.C2614b;
import com.portfolio.platform.PortfolioApp;
import dagger.internal.MembersInjectors;

public final class dbd implements emi<dbc> {
    static final /* synthetic */ boolean $assertionsDisabled = (!dbd.class.desiredAssertionStatus());
    private final eru<gy> cIB;
    private final eru<fj> cIC;
    private final eru<PortfolioApp> cKG;
    private final eru<C2614b> cNV;
    private final emg<dbc> cjG;

    public /* synthetic */ Object get() {
        return alh();
    }

    public dbd(emg<dbc> com_fossil_emg_com_fossil_dbc, eru<PortfolioApp> com_fossil_eru_com_portfolio_platform_PortfolioApp, eru<C2614b> com_fossil_eru_com_fossil_dau_b, eru<gy> com_fossil_eru_com_fossil_gy, eru<fj> com_fossil_eru_com_fossil_fj) {
        if ($assertionsDisabled || com_fossil_emg_com_fossil_dbc != null) {
            this.cjG = com_fossil_emg_com_fossil_dbc;
            if ($assertionsDisabled || com_fossil_eru_com_portfolio_platform_PortfolioApp != null) {
                this.cKG = com_fossil_eru_com_portfolio_platform_PortfolioApp;
                if ($assertionsDisabled || com_fossil_eru_com_fossil_dau_b != null) {
                    this.cNV = com_fossil_eru_com_fossil_dau_b;
                    if ($assertionsDisabled || com_fossil_eru_com_fossil_gy != null) {
                        this.cIB = com_fossil_eru_com_fossil_gy;
                        if ($assertionsDisabled || com_fossil_eru_com_fossil_fj != null) {
                            this.cIC = com_fossil_eru_com_fossil_fj;
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

    public dbc alh() {
        return (dbc) MembersInjectors.a(this.cjG, new dbc((PortfolioApp) this.cKG.get(), (C2614b) this.cNV.get(), (gy) this.cIB.get(), (fj) this.cIC.get()));
    }

    public static emi<dbc> create(emg<dbc> com_fossil_emg_com_fossil_dbc, eru<PortfolioApp> com_fossil_eru_com_portfolio_platform_PortfolioApp, eru<C2614b> com_fossil_eru_com_fossil_dau_b, eru<gy> com_fossil_eru_com_fossil_gy, eru<fj> com_fossil_eru_com_fossil_fj) {
        return new dbd(com_fossil_emg_com_fossil_dbc, com_fossil_eru_com_portfolio_platform_PortfolioApp, com_fossil_eru_com_fossil_dau_b, com_fossil_eru_com_fossil_gy, com_fossil_eru_com_fossil_fj);
    }
}
