package com.fossil;

import com.fossil.dmv.C2975b;
import com.portfolio.platform.data.source.loader.SleepSummaryLoader;
import dagger.internal.MembersInjectors;

public final class dmy implements emi<dmx> {
    static final /* synthetic */ boolean $assertionsDisabled = (!dmy.class.desiredAssertionStatus());
    private final eru<C2975b> cGA;
    private final eru<fj> cIC;
    private final emg<dmx> cmk;
    private final eru<SleepSummaryLoader> cmm;

    public /* synthetic */ Object get() {
        return asm();
    }

    public dmy(emg<dmx> com_fossil_emg_com_fossil_dmx, eru<C2975b> com_fossil_eru_com_fossil_dmv_b, eru<fj> com_fossil_eru_com_fossil_fj, eru<SleepSummaryLoader> com_fossil_eru_com_portfolio_platform_data_source_loader_SleepSummaryLoader) {
        if ($assertionsDisabled || com_fossil_emg_com_fossil_dmx != null) {
            this.cmk = com_fossil_emg_com_fossil_dmx;
            if ($assertionsDisabled || com_fossil_eru_com_fossil_dmv_b != null) {
                this.cGA = com_fossil_eru_com_fossil_dmv_b;
                if ($assertionsDisabled || com_fossil_eru_com_fossil_fj != null) {
                    this.cIC = com_fossil_eru_com_fossil_fj;
                    if ($assertionsDisabled || com_fossil_eru_com_portfolio_platform_data_source_loader_SleepSummaryLoader != null) {
                        this.cmm = com_fossil_eru_com_portfolio_platform_data_source_loader_SleepSummaryLoader;
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

    public dmx asm() {
        return (dmx) MembersInjectors.a(this.cmk, new dmx((C2975b) this.cGA.get(), (fj) this.cIC.get(), (SleepSummaryLoader) this.cmm.get()));
    }

    public static emi<dmx> create(emg<dmx> com_fossil_emg_com_fossil_dmx, eru<C2975b> com_fossil_eru_com_fossil_dmv_b, eru<fj> com_fossil_eru_com_fossil_fj, eru<SleepSummaryLoader> com_fossil_eru_com_portfolio_platform_data_source_loader_SleepSummaryLoader) {
        return new dmy(com_fossil_emg_com_fossil_dmx, com_fossil_eru_com_fossil_dmv_b, com_fossil_eru_com_fossil_fj, com_fossil_eru_com_portfolio_platform_data_source_loader_SleepSummaryLoader);
    }
}
