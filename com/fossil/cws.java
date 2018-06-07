package com.fossil;

import com.portfolio.platform.data.source.AlarmsRepository;
import dagger.internal.MembersInjectors;

public final class cws implements emi<cwr> {
    static final /* synthetic */ boolean $assertionsDisabled = (!cws.class.desiredAssertionStatus());
    private final eru<gy> cIB;
    private final emg<cwr> cJL;
    private final eru<AlarmsRepository> ceE;

    public /* synthetic */ Object get() {
        return ajh();
    }

    public cws(emg<cwr> com_fossil_emg_com_fossil_cwr, eru<gy> com_fossil_eru_com_fossil_gy, eru<AlarmsRepository> com_fossil_eru_com_portfolio_platform_data_source_AlarmsRepository) {
        if ($assertionsDisabled || com_fossil_emg_com_fossil_cwr != null) {
            this.cJL = com_fossil_emg_com_fossil_cwr;
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

    public cwr ajh() {
        return (cwr) MembersInjectors.a(this.cJL, new cwr((gy) this.cIB.get(), (AlarmsRepository) this.ceE.get()));
    }

    public static emi<cwr> create(emg<cwr> com_fossil_emg_com_fossil_cwr, eru<gy> com_fossil_eru_com_fossil_gy, eru<AlarmsRepository> com_fossil_eru_com_portfolio_platform_data_source_AlarmsRepository) {
        return new cws(com_fossil_emg_com_fossil_cwr, com_fossil_eru_com_fossil_gy, com_fossil_eru_com_portfolio_platform_data_source_AlarmsRepository);
    }
}
