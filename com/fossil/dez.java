package com.fossil;

import com.fossil.deu.C2714b;
import dagger.internal.MembersInjectors;

public final class dez implements emi<dey> {
    static final /* synthetic */ boolean $assertionsDisabled = (!dez.class.desiredAssertionStatus());
    private final eru<C2714b> cGA;
    private final emg<dey> ckQ;
    private final eru<ckc> useCaseHandlerProvider;

    public /* synthetic */ Object get() {
        return anD();
    }

    public dez(emg<dey> com_fossil_emg_com_fossil_dey, eru<C2714b> com_fossil_eru_com_fossil_deu_b, eru<ckc> com_fossil_eru_com_fossil_ckc) {
        if ($assertionsDisabled || com_fossil_emg_com_fossil_dey != null) {
            this.ckQ = com_fossil_emg_com_fossil_dey;
            if ($assertionsDisabled || com_fossil_eru_com_fossil_deu_b != null) {
                this.cGA = com_fossil_eru_com_fossil_deu_b;
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

    public dey anD() {
        return (dey) MembersInjectors.a(this.ckQ, new dey((C2714b) this.cGA.get(), (ckc) this.useCaseHandlerProvider.get()));
    }

    public static emi<dey> create(emg<dey> com_fossil_emg_com_fossil_dey, eru<C2714b> com_fossil_eru_com_fossil_deu_b, eru<ckc> com_fossil_eru_com_fossil_ckc) {
        return new dez(com_fossil_emg_com_fossil_dey, com_fossil_eru_com_fossil_deu_b, com_fossil_eru_com_fossil_ckc);
    }
}
