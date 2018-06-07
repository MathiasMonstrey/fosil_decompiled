package com.fossil;

import com.portfolio.platform.PortfolioApp;
import com.portfolio.platform.service.microapp.CommuteTimeService;

public final class csz implements emg<CommuteTimeService> {
    static final /* synthetic */ boolean $assertionsDisabled = (!csz.class.desiredAssertionStatus());
    private final eru<gy> cEg;
    private final eru<djk> cEh;
    private final eru<PortfolioApp> cEi;
    private final eru<ckc> cne;

    public /* synthetic */ void injectMembers(Object obj) {
        m7494h((CommuteTimeService) obj);
    }

    public csz(eru<ckc> com_fossil_eru_com_fossil_ckc, eru<gy> com_fossil_eru_com_fossil_gy, eru<djk> com_fossil_eru_com_fossil_djk, eru<PortfolioApp> com_fossil_eru_com_portfolio_platform_PortfolioApp) {
        if ($assertionsDisabled || com_fossil_eru_com_fossil_ckc != null) {
            this.cne = com_fossil_eru_com_fossil_ckc;
            if ($assertionsDisabled || com_fossil_eru_com_fossil_gy != null) {
                this.cEg = com_fossil_eru_com_fossil_gy;
                if ($assertionsDisabled || com_fossil_eru_com_fossil_djk != null) {
                    this.cEh = com_fossil_eru_com_fossil_djk;
                    if ($assertionsDisabled || com_fossil_eru_com_portfolio_platform_PortfolioApp != null) {
                        this.cEi = com_fossil_eru_com_portfolio_platform_PortfolioApp;
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

    public static emg<CommuteTimeService> m7493a(eru<ckc> com_fossil_eru_com_fossil_ckc, eru<gy> com_fossil_eru_com_fossil_gy, eru<djk> com_fossil_eru_com_fossil_djk, eru<PortfolioApp> com_fossil_eru_com_portfolio_platform_PortfolioApp) {
        return new csz(com_fossil_eru_com_fossil_ckc, com_fossil_eru_com_fossil_gy, com_fossil_eru_com_fossil_djk, com_fossil_eru_com_portfolio_platform_PortfolioApp);
    }

    public void m7494h(CommuteTimeService commuteTimeService) {
        if (commuteTimeService == null) {
            throw new NullPointerException("Cannot inject members into a null reference");
        }
        commuteTimeService.mUseCaseHandler = (ckc) this.cne.get();
        commuteTimeService.cEa = (gy) this.cEg.get();
        commuteTimeService.cEb = (djk) this.cEh.get();
        commuteTimeService.cEc = (PortfolioApp) this.cEi.get();
    }
}
