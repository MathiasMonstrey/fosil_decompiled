package com.fossil;

import com.fossil.dok.C3013b;
import dagger.internal.MembersInjectors;

public final class dop implements emi<doo> {
    static final /* synthetic */ boolean $assertionsDisabled = (!dop.class.desiredAssertionStatus());
    private final eru<cmj> cJE;
    private final eru<dlv> cjg;
    private final eru<dmt> cji;
    private final emg<doo> clE;
    private final eru<dqh> clF;
    private final eru<C3013b> dcq;
    private final eru<cnr> sharedPreferencesManagerProvider;
    private final eru<ckc> useCaseHandlerProvider;

    public /* synthetic */ Object get() {
        return atn();
    }

    public dop(emg<doo> com_fossil_emg_com_fossil_doo, eru<C3013b> com_fossil_eru_com_fossil_dok_b, eru<dqh> com_fossil_eru_com_fossil_dqh, eru<ckc> com_fossil_eru_com_fossil_ckc, eru<dlv> com_fossil_eru_com_fossil_dlv, eru<dmt> com_fossil_eru_com_fossil_dmt, eru<cnr> com_fossil_eru_com_fossil_cnr, eru<cmj> com_fossil_eru_com_fossil_cmj) {
        if ($assertionsDisabled || com_fossil_emg_com_fossil_doo != null) {
            this.clE = com_fossil_emg_com_fossil_doo;
            if ($assertionsDisabled || com_fossil_eru_com_fossil_dok_b != null) {
                this.dcq = com_fossil_eru_com_fossil_dok_b;
                if ($assertionsDisabled || com_fossil_eru_com_fossil_dqh != null) {
                    this.clF = com_fossil_eru_com_fossil_dqh;
                    if ($assertionsDisabled || com_fossil_eru_com_fossil_ckc != null) {
                        this.useCaseHandlerProvider = com_fossil_eru_com_fossil_ckc;
                        if ($assertionsDisabled || com_fossil_eru_com_fossil_dlv != null) {
                            this.cjg = com_fossil_eru_com_fossil_dlv;
                            if ($assertionsDisabled || com_fossil_eru_com_fossil_dmt != null) {
                                this.cji = com_fossil_eru_com_fossil_dmt;
                                if ($assertionsDisabled || com_fossil_eru_com_fossil_cnr != null) {
                                    this.sharedPreferencesManagerProvider = com_fossil_eru_com_fossil_cnr;
                                    if ($assertionsDisabled || com_fossil_eru_com_fossil_cmj != null) {
                                        this.cJE = com_fossil_eru_com_fossil_cmj;
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

    public doo atn() {
        return (doo) MembersInjectors.a(this.clE, new doo((C3013b) this.dcq.get(), (dqh) this.clF.get(), (ckc) this.useCaseHandlerProvider.get(), (dlv) this.cjg.get(), (dmt) this.cji.get(), (cnr) this.sharedPreferencesManagerProvider.get(), (cmj) this.cJE.get()));
    }

    public static emi<doo> m9253a(emg<doo> com_fossil_emg_com_fossil_doo, eru<C3013b> com_fossil_eru_com_fossil_dok_b, eru<dqh> com_fossil_eru_com_fossil_dqh, eru<ckc> com_fossil_eru_com_fossil_ckc, eru<dlv> com_fossil_eru_com_fossil_dlv, eru<dmt> com_fossil_eru_com_fossil_dmt, eru<cnr> com_fossil_eru_com_fossil_cnr, eru<cmj> com_fossil_eru_com_fossil_cmj) {
        return new dop(com_fossil_emg_com_fossil_doo, com_fossil_eru_com_fossil_dok_b, com_fossil_eru_com_fossil_dqh, com_fossil_eru_com_fossil_ckc, com_fossil_eru_com_fossil_dlv, com_fossil_eru_com_fossil_dmt, com_fossil_eru_com_fossil_cnr, com_fossil_eru_com_fossil_cmj);
    }
}
