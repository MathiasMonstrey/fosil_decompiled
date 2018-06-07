package com.fossil;

import com.fossil.dkr.C2908b;
import com.portfolio.platform.PortfolioApp;
import dagger.internal.MembersInjectors;
import java.util.Date;

public final class dlh implements emi<dlg> {
    static final /* synthetic */ boolean $assertionsDisabled = (!dlh.class.desiredAssertionStatus());
    private final eru<C2908b> cGA;
    private final eru<PortfolioApp> cIA;
    private final eru<gy> cIB;
    private final eru<Date> cZq;
    private final emg<dlg> cka;
    private final eru<cnr> sharedPreferencesManagerProvider;

    public /* synthetic */ Object get() {
        return arN();
    }

    public dlh(emg<dlg> com_fossil_emg_com_fossil_dlg, eru<PortfolioApp> com_fossil_eru_com_portfolio_platform_PortfolioApp, eru<C2908b> com_fossil_eru_com_fossil_dkr_b, eru<Date> com_fossil_eru_java_util_Date, eru<cnr> com_fossil_eru_com_fossil_cnr, eru<gy> com_fossil_eru_com_fossil_gy) {
        if ($assertionsDisabled || com_fossil_emg_com_fossil_dlg != null) {
            this.cka = com_fossil_emg_com_fossil_dlg;
            if ($assertionsDisabled || com_fossil_eru_com_portfolio_platform_PortfolioApp != null) {
                this.cIA = com_fossil_eru_com_portfolio_platform_PortfolioApp;
                if ($assertionsDisabled || com_fossil_eru_com_fossil_dkr_b != null) {
                    this.cGA = com_fossil_eru_com_fossil_dkr_b;
                    if ($assertionsDisabled || com_fossil_eru_java_util_Date != null) {
                        this.cZq = com_fossil_eru_java_util_Date;
                        if ($assertionsDisabled || com_fossil_eru_com_fossil_cnr != null) {
                            this.sharedPreferencesManagerProvider = com_fossil_eru_com_fossil_cnr;
                            if ($assertionsDisabled || com_fossil_eru_com_fossil_gy != null) {
                                this.cIB = com_fossil_eru_com_fossil_gy;
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

    public dlg arN() {
        return (dlg) MembersInjectors.a(this.cka, new dlg((PortfolioApp) this.cIA.get(), (C2908b) this.cGA.get(), (Date) this.cZq.get(), (cnr) this.sharedPreferencesManagerProvider.get(), (gy) this.cIB.get()));
    }

    public static emi<dlg> m8974a(emg<dlg> com_fossil_emg_com_fossil_dlg, eru<PortfolioApp> com_fossil_eru_com_portfolio_platform_PortfolioApp, eru<C2908b> com_fossil_eru_com_fossil_dkr_b, eru<Date> com_fossil_eru_java_util_Date, eru<cnr> com_fossil_eru_com_fossil_cnr, eru<gy> com_fossil_eru_com_fossil_gy) {
        return new dlh(com_fossil_emg_com_fossil_dlg, com_fossil_eru_com_portfolio_platform_PortfolioApp, com_fossil_eru_com_fossil_dkr_b, com_fossil_eru_java_util_Date, com_fossil_eru_com_fossil_cnr, com_fossil_eru_com_fossil_gy);
    }
}
