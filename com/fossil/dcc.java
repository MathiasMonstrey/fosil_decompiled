package com.fossil;

import com.fossil.dbx.C2639b;
import com.portfolio.platform.data.source.loader.NotificationsLoader;
import dagger.internal.MembersInjectors;

public final class dcc implements emi<dcb> {
    static final /* synthetic */ boolean $assertionsDisabled = (!dcc.class.desiredAssertionStatus());
    private final eru<C2639b> cGA;
    private final eru<gy> cIB;
    private final eru<fj> cIC;
    private final eru<NotificationsLoader> ciN;
    private final emg<dcb> cjW;
    private final eru<ddb> cjY;
    private final eru<cnr> sharedPreferencesManagerProvider;
    private final eru<ckc> useCaseHandlerProvider;

    public /* synthetic */ Object get() {
        return aly();
    }

    public dcc(emg<dcb> com_fossil_emg_com_fossil_dcb, eru<C2639b> com_fossil_eru_com_fossil_dbx_b, eru<gy> com_fossil_eru_com_fossil_gy, eru<fj> com_fossil_eru_com_fossil_fj, eru<cnr> com_fossil_eru_com_fossil_cnr, eru<NotificationsLoader> com_fossil_eru_com_portfolio_platform_data_source_loader_NotificationsLoader, eru<ddb> com_fossil_eru_com_fossil_ddb, eru<ckc> com_fossil_eru_com_fossil_ckc) {
        if ($assertionsDisabled || com_fossil_emg_com_fossil_dcb != null) {
            this.cjW = com_fossil_emg_com_fossil_dcb;
            if ($assertionsDisabled || com_fossil_eru_com_fossil_dbx_b != null) {
                this.cGA = com_fossil_eru_com_fossil_dbx_b;
                if ($assertionsDisabled || com_fossil_eru_com_fossil_gy != null) {
                    this.cIB = com_fossil_eru_com_fossil_gy;
                    if ($assertionsDisabled || com_fossil_eru_com_fossil_fj != null) {
                        this.cIC = com_fossil_eru_com_fossil_fj;
                        if ($assertionsDisabled || com_fossil_eru_com_fossil_cnr != null) {
                            this.sharedPreferencesManagerProvider = com_fossil_eru_com_fossil_cnr;
                            if ($assertionsDisabled || com_fossil_eru_com_portfolio_platform_data_source_loader_NotificationsLoader != null) {
                                this.ciN = com_fossil_eru_com_portfolio_platform_data_source_loader_NotificationsLoader;
                                if ($assertionsDisabled || com_fossil_eru_com_fossil_ddb != null) {
                                    this.cjY = com_fossil_eru_com_fossil_ddb;
                                    if ($assertionsDisabled || com_fossil_eru_com_fossil_ckc != null) {
                                        this.useCaseHandlerProvider = com_fossil_eru_com_fossil_ckc;
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
        throw new AssertionError();
    }

    public dcb aly() {
        return (dcb) MembersInjectors.a(this.cjW, new dcb((C2639b) this.cGA.get(), (gy) this.cIB.get(), (fj) this.cIC.get(), (cnr) this.sharedPreferencesManagerProvider.get(), (NotificationsLoader) this.ciN.get(), (ddb) this.cjY.get(), (ckc) this.useCaseHandlerProvider.get()));
    }

    public static emi<dcb> m8205a(emg<dcb> com_fossil_emg_com_fossil_dcb, eru<C2639b> com_fossil_eru_com_fossil_dbx_b, eru<gy> com_fossil_eru_com_fossil_gy, eru<fj> com_fossil_eru_com_fossil_fj, eru<cnr> com_fossil_eru_com_fossil_cnr, eru<NotificationsLoader> com_fossil_eru_com_portfolio_platform_data_source_loader_NotificationsLoader, eru<ddb> com_fossil_eru_com_fossil_ddb, eru<ckc> com_fossil_eru_com_fossil_ckc) {
        return new dcc(com_fossil_emg_com_fossil_dcb, com_fossil_eru_com_fossil_dbx_b, com_fossil_eru_com_fossil_gy, com_fossil_eru_com_fossil_fj, com_fossil_eru_com_fossil_cnr, com_fossil_eru_com_portfolio_platform_data_source_loader_NotificationsLoader, com_fossil_eru_com_fossil_ddb, com_fossil_eru_com_fossil_ckc);
    }
}
