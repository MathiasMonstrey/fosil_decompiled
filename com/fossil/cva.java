package com.fossil;

import com.fossil.cuv.C2358b;
import dagger.internal.MembersInjectors;

public final class cva implements emi<cuz> {
    static final /* synthetic */ boolean $assertionsDisabled = (!cva.class.desiredAssertionStatus());
    private final eru<C2358b> cGA;
    private final emg<cuz> che;

    public /* synthetic */ Object get() {
        return ahF();
    }

    public cva(emg<cuz> com_fossil_emg_com_fossil_cuz, eru<C2358b> com_fossil_eru_com_fossil_cuv_b) {
        if ($assertionsDisabled || com_fossil_emg_com_fossil_cuz != null) {
            this.che = com_fossil_emg_com_fossil_cuz;
            if ($assertionsDisabled || com_fossil_eru_com_fossil_cuv_b != null) {
                this.cGA = com_fossil_eru_com_fossil_cuv_b;
                return;
            }
            throw new AssertionError();
        }
        throw new AssertionError();
    }

    public cuz ahF() {
        return (cuz) MembersInjectors.a(this.che, new cuz((C2358b) this.cGA.get()));
    }

    public static emi<cuz> m7617a(emg<cuz> com_fossil_emg_com_fossil_cuz, eru<C2358b> com_fossil_eru_com_fossil_cuv_b) {
        return new cva(com_fossil_emg_com_fossil_cuz, com_fossil_eru_com_fossil_cuv_b);
    }
}
