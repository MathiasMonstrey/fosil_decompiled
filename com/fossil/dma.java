package com.fossil;

import com.fossil.dlx.C2947b;
import com.portfolio.platform.data.source.loader.ActivitiesDayLoader;
import dagger.internal.MembersInjectors;

public final class dma implements emi<dlz> {
    static final /* synthetic */ boolean $assertionsDisabled = (!dma.class.desiredAssertionStatus());
    private final eru<C2947b> cGA;
    private final eru<fj> cIC;
    private final eru<ActivitiesDayLoader> cOm;
    private final emg<dlz> clU;

    public /* synthetic */ Object get() {
        return asb();
    }

    public dma(emg<dlz> com_fossil_emg_com_fossil_dlz, eru<C2947b> com_fossil_eru_com_fossil_dlx_b, eru<fj> com_fossil_eru_com_fossil_fj, eru<ActivitiesDayLoader> com_fossil_eru_com_portfolio_platform_data_source_loader_ActivitiesDayLoader) {
        if ($assertionsDisabled || com_fossil_emg_com_fossil_dlz != null) {
            this.clU = com_fossil_emg_com_fossil_dlz;
            if ($assertionsDisabled || com_fossil_eru_com_fossil_dlx_b != null) {
                this.cGA = com_fossil_eru_com_fossil_dlx_b;
                if ($assertionsDisabled || com_fossil_eru_com_fossil_fj != null) {
                    this.cIC = com_fossil_eru_com_fossil_fj;
                    if ($assertionsDisabled || com_fossil_eru_com_portfolio_platform_data_source_loader_ActivitiesDayLoader != null) {
                        this.cOm = com_fossil_eru_com_portfolio_platform_data_source_loader_ActivitiesDayLoader;
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

    public dlz asb() {
        return (dlz) MembersInjectors.a(this.clU, new dlz((C2947b) this.cGA.get(), (fj) this.cIC.get(), (ActivitiesDayLoader) this.cOm.get()));
    }

    public static emi<dlz> create(emg<dlz> com_fossil_emg_com_fossil_dlz, eru<C2947b> com_fossil_eru_com_fossil_dlx_b, eru<fj> com_fossil_eru_com_fossil_fj, eru<ActivitiesDayLoader> com_fossil_eru_com_portfolio_platform_data_source_loader_ActivitiesDayLoader) {
        return new dma(com_fossil_emg_com_fossil_dlz, com_fossil_eru_com_fossil_dlx_b, com_fossil_eru_com_fossil_fj, com_fossil_eru_com_portfolio_platform_data_source_loader_ActivitiesDayLoader);
    }
}
