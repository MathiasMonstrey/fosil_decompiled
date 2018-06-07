package com.fossil;

import dagger.internal.MembersInjectors;

public final class cyn implements emi<cym> {
    static final /* synthetic */ boolean $assertionsDisabled = (!cyn.class.desiredAssertionStatus());
    private final eru<gy> cIB;
    private final emg<cym> cLf;

    public /* synthetic */ Object get() {
        return ajS();
    }

    public cyn(emg<cym> com_fossil_emg_com_fossil_cym, eru<gy> com_fossil_eru_com_fossil_gy) {
        if ($assertionsDisabled || com_fossil_emg_com_fossil_cym != null) {
            this.cLf = com_fossil_emg_com_fossil_cym;
            if ($assertionsDisabled || com_fossil_eru_com_fossil_gy != null) {
                this.cIB = com_fossil_eru_com_fossil_gy;
                return;
            }
            throw new AssertionError();
        }
        throw new AssertionError();
    }

    public cym ajS() {
        return (cym) MembersInjectors.a(this.cLf, new cym((gy) this.cIB.get()));
    }

    public static emi<cym> m7913a(emg<cym> com_fossil_emg_com_fossil_cym, eru<gy> com_fossil_eru_com_fossil_gy) {
        return new cyn(com_fossil_emg_com_fossil_cym, com_fossil_eru_com_fossil_gy);
    }
}
