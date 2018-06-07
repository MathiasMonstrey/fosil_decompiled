package com.fossil;

import com.fossil.dfy.C2738b;
import dagger.internal.MembersInjectors;

public final class dgd implements emi<dgc> {
    static final /* synthetic */ boolean $assertionsDisabled = (!dgd.class.desiredAssertionStatus());
    private final eru<C2738b> cGA;
    private final emg<dgc> ckY;
    private final eru<ckc> useCaseHandlerProvider;

    public /* synthetic */ Object get() {
        return anU();
    }

    public dgd(emg<dgc> com_fossil_emg_com_fossil_dgc, eru<C2738b> com_fossil_eru_com_fossil_dfy_b, eru<ckc> com_fossil_eru_com_fossil_ckc) {
        if ($assertionsDisabled || com_fossil_emg_com_fossil_dgc != null) {
            this.ckY = com_fossil_emg_com_fossil_dgc;
            if ($assertionsDisabled || com_fossil_eru_com_fossil_dfy_b != null) {
                this.cGA = com_fossil_eru_com_fossil_dfy_b;
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

    public dgc anU() {
        return (dgc) MembersInjectors.a(this.ckY, new dgc((C2738b) this.cGA.get(), (ckc) this.useCaseHandlerProvider.get()));
    }

    public static emi<dgc> create(emg<dgc> com_fossil_emg_com_fossil_dgc, eru<C2738b> com_fossil_eru_com_fossil_dfy_b, eru<ckc> com_fossil_eru_com_fossil_ckc) {
        return new dgd(com_fossil_emg_com_fossil_dgc, com_fossil_eru_com_fossil_dfy_b, com_fossil_eru_com_fossil_ckc);
    }
}
