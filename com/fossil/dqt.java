package com.fossil;

import android.content.ContentResolver;
import com.portfolio.platform.PortfolioApp;
import dagger.internal.MembersInjectors;

public final class dqt implements emi<dqs> {
    static final /* synthetic */ boolean $assertionsDisabled = (!dqt.class.desiredAssertionStatus());
    private final eru<ddh> cfs;
    private final eru<ddj> cft;
    private final emg<dqs> deV;
    private final eru<PortfolioApp> deW;
    private final eru<ContentResolver> deX;
    private final eru<cnr> sharedPreferencesManagerProvider;
    private final eru<ckc> useCaseHandlerProvider;

    public /* synthetic */ Object get() {
        return auk();
    }

    public dqt(emg<dqs> com_fossil_emg_com_fossil_dqs, eru<PortfolioApp> com_fossil_eru_com_portfolio_platform_PortfolioApp, eru<ckc> com_fossil_eru_com_fossil_ckc, eru<ddh> com_fossil_eru_com_fossil_ddh, eru<cnr> com_fossil_eru_com_fossil_cnr, eru<ddj> com_fossil_eru_com_fossil_ddj, eru<ContentResolver> com_fossil_eru_android_content_ContentResolver) {
        if ($assertionsDisabled || com_fossil_emg_com_fossil_dqs != null) {
            this.deV = com_fossil_emg_com_fossil_dqs;
            if ($assertionsDisabled || com_fossil_eru_com_portfolio_platform_PortfolioApp != null) {
                this.deW = com_fossil_eru_com_portfolio_platform_PortfolioApp;
                if ($assertionsDisabled || com_fossil_eru_com_fossil_ckc != null) {
                    this.useCaseHandlerProvider = com_fossil_eru_com_fossil_ckc;
                    if ($assertionsDisabled || com_fossil_eru_com_fossil_ddh != null) {
                        this.cfs = com_fossil_eru_com_fossil_ddh;
                        if ($assertionsDisabled || com_fossil_eru_com_fossil_cnr != null) {
                            this.sharedPreferencesManagerProvider = com_fossil_eru_com_fossil_cnr;
                            if ($assertionsDisabled || com_fossil_eru_com_fossil_ddj != null) {
                                this.cft = com_fossil_eru_com_fossil_ddj;
                                if ($assertionsDisabled || com_fossil_eru_android_content_ContentResolver != null) {
                                    this.deX = com_fossil_eru_android_content_ContentResolver;
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

    public dqs auk() {
        return (dqs) MembersInjectors.a(this.deV, new dqs((PortfolioApp) this.deW.get(), (ckc) this.useCaseHandlerProvider.get(), (ddh) this.cfs.get(), (cnr) this.sharedPreferencesManagerProvider.get(), (ddj) this.cft.get(), (ContentResolver) this.deX.get()));
    }

    public static emi<dqs> m9407a(emg<dqs> com_fossil_emg_com_fossil_dqs, eru<PortfolioApp> com_fossil_eru_com_portfolio_platform_PortfolioApp, eru<ckc> com_fossil_eru_com_fossil_ckc, eru<ddh> com_fossil_eru_com_fossil_ddh, eru<cnr> com_fossil_eru_com_fossil_cnr, eru<ddj> com_fossil_eru_com_fossil_ddj, eru<ContentResolver> com_fossil_eru_android_content_ContentResolver) {
        return new dqt(com_fossil_emg_com_fossil_dqs, com_fossil_eru_com_portfolio_platform_PortfolioApp, com_fossil_eru_com_fossil_ckc, com_fossil_eru_com_fossil_ddh, com_fossil_eru_com_fossil_cnr, com_fossil_eru_com_fossil_ddj, com_fossil_eru_android_content_ContentResolver);
    }
}
