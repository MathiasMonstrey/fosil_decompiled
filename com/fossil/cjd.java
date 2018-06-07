package com.fossil;

import com.portfolio.platform.PortfolioApp;

public final class cjd implements emi<PortfolioApp> {
    static final /* synthetic */ boolean $assertionsDisabled = (!cjd.class.desiredAssertionStatus());
    private final ciz ceD;

    public /* synthetic */ Object get() {
        return Zn();
    }

    public cjd(ciz com_fossil_ciz) {
        if ($assertionsDisabled || com_fossil_ciz != null) {
            this.ceD = com_fossil_ciz;
            return;
        }
        throw new AssertionError();
    }

    public PortfolioApp Zn() {
        return (PortfolioApp) emj.m10873f(this.ceD.YX(), "Cannot return null from a non-@Nullable @Provides method");
    }

    public static emi<PortfolioApp> m6618a(ciz com_fossil_ciz) {
        return new cjd(com_fossil_ciz);
    }
}
