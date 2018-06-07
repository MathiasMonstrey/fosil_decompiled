package com.fossil;

import com.fossil.del.C2708b;
import dagger.internal.MembersInjectors;

public final class deq implements emi<dep> {
    static final /* synthetic */ boolean $assertionsDisabled = (!deq.class.desiredAssertionStatus());
    private final eru<C2708b> cGA;
    private final emg<dep> cij;
    private final eru<dpl> cil;
    private final eru<dpf> cim;
    private final eru<ckc> useCaseHandlerProvider;

    public /* synthetic */ Object get() {
        return anz();
    }

    public deq(emg<dep> com_fossil_emg_com_fossil_dep, eru<C2708b> com_fossil_eru_com_fossil_del_b, eru<dpl> com_fossil_eru_com_fossil_dpl, eru<dpf> com_fossil_eru_com_fossil_dpf, eru<ckc> com_fossil_eru_com_fossil_ckc) {
        if ($assertionsDisabled || com_fossil_emg_com_fossil_dep != null) {
            this.cij = com_fossil_emg_com_fossil_dep;
            if ($assertionsDisabled || com_fossil_eru_com_fossil_del_b != null) {
                this.cGA = com_fossil_eru_com_fossil_del_b;
                if ($assertionsDisabled || com_fossil_eru_com_fossil_dpl != null) {
                    this.cil = com_fossil_eru_com_fossil_dpl;
                    if ($assertionsDisabled || com_fossil_eru_com_fossil_dpf != null) {
                        this.cim = com_fossil_eru_com_fossil_dpf;
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

    public dep anz() {
        return (dep) MembersInjectors.a(this.cij, new dep((C2708b) this.cGA.get(), (dpl) this.cil.get(), (dpf) this.cim.get(), (ckc) this.useCaseHandlerProvider.get()));
    }

    public static emi<dep> create(emg<dep> com_fossil_emg_com_fossil_dep, eru<C2708b> com_fossil_eru_com_fossil_del_b, eru<dpl> com_fossil_eru_com_fossil_dpl, eru<dpf> com_fossil_eru_com_fossil_dpf, eru<ckc> com_fossil_eru_com_fossil_ckc) {
        return new deq(com_fossil_emg_com_fossil_dep, com_fossil_eru_com_fossil_del_b, com_fossil_eru_com_fossil_dpl, com_fossil_eru_com_fossil_dpf, com_fossil_eru_com_fossil_ckc);
    }
}
