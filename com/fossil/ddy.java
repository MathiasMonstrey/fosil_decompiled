package com.fossil;

import com.fossil.ddu.C2691b;
import dagger.internal.MembersInjectors;

public final class ddy implements emi<ddx> {
    static final /* synthetic */ boolean $assertionsDisabled = (!ddy.class.desiredAssertionStatus());
    private final eru<C2691b> cGA;
    private final emg<ddx> chv;
    private final eru<ckc> useCaseHandlerProvider;

    public /* synthetic */ Object get() {
        return ana();
    }

    public ddy(emg<ddx> com_fossil_emg_com_fossil_ddx, eru<C2691b> com_fossil_eru_com_fossil_ddu_b, eru<ckc> com_fossil_eru_com_fossil_ckc) {
        if ($assertionsDisabled || com_fossil_emg_com_fossil_ddx != null) {
            this.chv = com_fossil_emg_com_fossil_ddx;
            if ($assertionsDisabled || com_fossil_eru_com_fossil_ddu_b != null) {
                this.cGA = com_fossil_eru_com_fossil_ddu_b;
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

    public ddx ana() {
        return (ddx) MembersInjectors.a(this.chv, new ddx((C2691b) this.cGA.get(), (ckc) this.useCaseHandlerProvider.get()));
    }

    public static emi<ddx> create(emg<ddx> com_fossil_emg_com_fossil_ddx, eru<C2691b> com_fossil_eru_com_fossil_ddu_b, eru<ckc> com_fossil_eru_com_fossil_ckc) {
        return new ddy(com_fossil_emg_com_fossil_ddx, com_fossil_eru_com_fossil_ddu_b, com_fossil_eru_com_fossil_ckc);
    }
}
