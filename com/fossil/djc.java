package com.fossil;

import com.fossil.diz.C2816b;
import dagger.internal.MembersInjectors;

public final class djc implements emi<djb> {
    static final /* synthetic */ boolean $assertionsDisabled = (!djc.class.desiredAssertionStatus());
    private final eru<C2816b> cGA;
    private final emg<djb> cks;
    private final eru<djs> cku;
    private final eru<dkk> ckv;
    private final eru<ckc> useCaseHandlerProvider;

    public /* synthetic */ Object get() {
        return aqh();
    }

    public djc(emg<djb> com_fossil_emg_com_fossil_djb, eru<C2816b> com_fossil_eru_com_fossil_diz_b, eru<djs> com_fossil_eru_com_fossil_djs, eru<dkk> com_fossil_eru_com_fossil_dkk, eru<ckc> com_fossil_eru_com_fossil_ckc) {
        if ($assertionsDisabled || com_fossil_emg_com_fossil_djb != null) {
            this.cks = com_fossil_emg_com_fossil_djb;
            if ($assertionsDisabled || com_fossil_eru_com_fossil_diz_b != null) {
                this.cGA = com_fossil_eru_com_fossil_diz_b;
                if ($assertionsDisabled || com_fossil_eru_com_fossil_djs != null) {
                    this.cku = com_fossil_eru_com_fossil_djs;
                    if ($assertionsDisabled || com_fossil_eru_com_fossil_dkk != null) {
                        this.ckv = com_fossil_eru_com_fossil_dkk;
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

    public djb aqh() {
        return (djb) MembersInjectors.a(this.cks, new djb((C2816b) this.cGA.get(), (djs) this.cku.get(), (dkk) this.ckv.get(), (ckc) this.useCaseHandlerProvider.get()));
    }

    public static emi<djb> create(emg<djb> com_fossil_emg_com_fossil_djb, eru<C2816b> com_fossil_eru_com_fossil_diz_b, eru<djs> com_fossil_eru_com_fossil_djs, eru<dkk> com_fossil_eru_com_fossil_dkk, eru<ckc> com_fossil_eru_com_fossil_ckc) {
        return new djc(com_fossil_emg_com_fossil_djb, com_fossil_eru_com_fossil_diz_b, com_fossil_eru_com_fossil_djs, com_fossil_eru_com_fossil_dkk, com_fossil_eru_com_fossil_ckc);
    }
}
