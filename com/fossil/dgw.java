package com.fossil;

import com.fossil.dgq.C2742b;
import dagger.internal.MembersInjectors;

public final class dgw implements emi<dgv> {
    static final /* synthetic */ boolean $assertionsDisabled = (!dgw.class.desiredAssertionStatus());
    private final eru<C2742b> cGA;
    private final eru<dpl> cil;
    private final eru<dpf> cim;
    private final emg<dgv> clg;
    private final eru<ckc> useCaseHandlerProvider;

    public /* synthetic */ Object get() {
        return aoe();
    }

    public dgw(emg<dgv> com_fossil_emg_com_fossil_dgv, eru<C2742b> com_fossil_eru_com_fossil_dgq_b, eru<ckc> com_fossil_eru_com_fossil_ckc, eru<dpl> com_fossil_eru_com_fossil_dpl, eru<dpf> com_fossil_eru_com_fossil_dpf) {
        if ($assertionsDisabled || com_fossil_emg_com_fossil_dgv != null) {
            this.clg = com_fossil_emg_com_fossil_dgv;
            if ($assertionsDisabled || com_fossil_eru_com_fossil_dgq_b != null) {
                this.cGA = com_fossil_eru_com_fossil_dgq_b;
                if ($assertionsDisabled || com_fossil_eru_com_fossil_ckc != null) {
                    this.useCaseHandlerProvider = com_fossil_eru_com_fossil_ckc;
                    if ($assertionsDisabled || com_fossil_eru_com_fossil_dpl != null) {
                        this.cil = com_fossil_eru_com_fossil_dpl;
                        if ($assertionsDisabled || com_fossil_eru_com_fossil_dpf != null) {
                            this.cim = com_fossil_eru_com_fossil_dpf;
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

    public dgv aoe() {
        return (dgv) MembersInjectors.a(this.clg, new dgv((C2742b) this.cGA.get(), (ckc) this.useCaseHandlerProvider.get(), (dpl) this.cil.get(), (dpf) this.cim.get()));
    }

    public static emi<dgv> create(emg<dgv> com_fossil_emg_com_fossil_dgv, eru<C2742b> com_fossil_eru_com_fossil_dgq_b, eru<ckc> com_fossil_eru_com_fossil_ckc, eru<dpl> com_fossil_eru_com_fossil_dpl, eru<dpf> com_fossil_eru_com_fossil_dpf) {
        return new dgw(com_fossil_emg_com_fossil_dgv, com_fossil_eru_com_fossil_dgq_b, com_fossil_eru_com_fossil_ckc, com_fossil_eru_com_fossil_dpl, com_fossil_eru_com_fossil_dpf);
    }
}
