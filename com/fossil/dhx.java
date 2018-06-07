package com.fossil;

import com.fossil.dhs.C2800b;
import dagger.internal.MembersInjectors;

public final class dhx implements emi<dhu> {
    static final /* synthetic */ boolean $assertionsDisabled = (!dhx.class.desiredAssertionStatus());
    private final eru<C2800b> cGA;
    private final emg<dhu> ckl;

    public /* synthetic */ Object get() {
        return apF();
    }

    public dhx(emg<dhu> com_fossil_emg_com_fossil_dhu, eru<C2800b> com_fossil_eru_com_fossil_dhs_b) {
        if ($assertionsDisabled || com_fossil_emg_com_fossil_dhu != null) {
            this.ckl = com_fossil_emg_com_fossil_dhu;
            if ($assertionsDisabled || com_fossil_eru_com_fossil_dhs_b != null) {
                this.cGA = com_fossil_eru_com_fossil_dhs_b;
                return;
            }
            throw new AssertionError();
        }
        throw new AssertionError();
    }

    public dhu apF() {
        return (dhu) MembersInjectors.a(this.ckl, new dhu((C2800b) this.cGA.get()));
    }

    public static emi<dhu> m8731a(emg<dhu> com_fossil_emg_com_fossil_dhu, eru<C2800b> com_fossil_eru_com_fossil_dhs_b) {
        return new dhx(com_fossil_emg_com_fossil_dhu, com_fossil_eru_com_fossil_dhs_b);
    }
}
