package com.fossil;

import com.fossil.dfg.C2719b;
import dagger.internal.MembersInjectors;

public final class dfl implements emi<dfk> {
    static final /* synthetic */ boolean $assertionsDisabled = (!dfl.class.desiredAssertionStatus());
    private final eru<C2719b> cGA;
    private final eru<dpp> cTa;
    private final eru<dpl> cil;
    private final eru<dpn> cjB;
    private final emg<dfk> cjz;
    private final eru<ckc> useCaseHandlerProvider;

    public /* synthetic */ Object get() {
        return anM();
    }

    public dfl(emg<dfk> com_fossil_emg_com_fossil_dfk, eru<C2719b> com_fossil_eru_com_fossil_dfg_b, eru<ckc> com_fossil_eru_com_fossil_ckc, eru<dpn> com_fossil_eru_com_fossil_dpn, eru<dpp> com_fossil_eru_com_fossil_dpp, eru<dpl> com_fossil_eru_com_fossil_dpl) {
        if ($assertionsDisabled || com_fossil_emg_com_fossil_dfk != null) {
            this.cjz = com_fossil_emg_com_fossil_dfk;
            if ($assertionsDisabled || com_fossil_eru_com_fossil_dfg_b != null) {
                this.cGA = com_fossil_eru_com_fossil_dfg_b;
                if ($assertionsDisabled || com_fossil_eru_com_fossil_ckc != null) {
                    this.useCaseHandlerProvider = com_fossil_eru_com_fossil_ckc;
                    if ($assertionsDisabled || com_fossil_eru_com_fossil_dpn != null) {
                        this.cjB = com_fossil_eru_com_fossil_dpn;
                        if ($assertionsDisabled || com_fossil_eru_com_fossil_dpp != null) {
                            this.cTa = com_fossil_eru_com_fossil_dpp;
                            if ($assertionsDisabled || com_fossil_eru_com_fossil_dpl != null) {
                                this.cil = com_fossil_eru_com_fossil_dpl;
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

    public dfk anM() {
        return (dfk) MembersInjectors.a(this.cjz, new dfk((C2719b) this.cGA.get(), (ckc) this.useCaseHandlerProvider.get(), (dpn) this.cjB.get(), (dpp) this.cTa.get(), (dpl) this.cil.get()));
    }

    public static emi<dfk> m8478a(emg<dfk> com_fossil_emg_com_fossil_dfk, eru<C2719b> com_fossil_eru_com_fossil_dfg_b, eru<ckc> com_fossil_eru_com_fossil_ckc, eru<dpn> com_fossil_eru_com_fossil_dpn, eru<dpp> com_fossil_eru_com_fossil_dpp, eru<dpl> com_fossil_eru_com_fossil_dpl) {
        return new dfl(com_fossil_emg_com_fossil_dfk, com_fossil_eru_com_fossil_dfg_b, com_fossil_eru_com_fossil_ckc, com_fossil_eru_com_fossil_dpn, com_fossil_eru_com_fossil_dpp, com_fossil_eru_com_fossil_dpl);
    }
}
