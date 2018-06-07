package com.fossil;

import com.fossil.cun.C2344b;
import dagger.internal.MembersInjectors;

public final class cus implements emi<cur> {
    static final /* synthetic */ boolean $assertionsDisabled = (!cus.class.desiredAssertionStatus());
    private final eru<C2344b> cGA;
    private final emg<cur> cgZ;

    public /* synthetic */ Object get() {
        return ahv();
    }

    public cus(emg<cur> com_fossil_emg_com_fossil_cur, eru<C2344b> com_fossil_eru_com_fossil_cun_b) {
        if ($assertionsDisabled || com_fossil_emg_com_fossil_cur != null) {
            this.cgZ = com_fossil_emg_com_fossil_cur;
            if ($assertionsDisabled || com_fossil_eru_com_fossil_cun_b != null) {
                this.cGA = com_fossil_eru_com_fossil_cun_b;
                return;
            }
            throw new AssertionError();
        }
        throw new AssertionError();
    }

    public cur ahv() {
        return (cur) MembersInjectors.a(this.cgZ, new cur((C2344b) this.cGA.get()));
    }

    public static emi<cur> m7609a(emg<cur> com_fossil_emg_com_fossil_cur, eru<C2344b> com_fossil_eru_com_fossil_cun_b) {
        return new cus(com_fossil_emg_com_fossil_cur, com_fossil_eru_com_fossil_cun_b);
    }
}
