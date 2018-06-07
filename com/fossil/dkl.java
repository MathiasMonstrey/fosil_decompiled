package com.fossil;

import dagger.internal.MembersInjectors;

public final class dkl implements emi<dkk> {
    static final /* synthetic */ boolean $assertionsDisabled = (!dkl.class.desiredAssertionStatus());
    private final eru<gy> cIB;
    private final emg<dkk> cYl;

    public /* synthetic */ Object get() {
        return aqQ();
    }

    public dkl(emg<dkk> com_fossil_emg_com_fossil_dkk, eru<gy> com_fossil_eru_com_fossil_gy) {
        if ($assertionsDisabled || com_fossil_emg_com_fossil_dkk != null) {
            this.cYl = com_fossil_emg_com_fossil_dkk;
            if ($assertionsDisabled || com_fossil_eru_com_fossil_gy != null) {
                this.cIB = com_fossil_eru_com_fossil_gy;
                return;
            }
            throw new AssertionError();
        }
        throw new AssertionError();
    }

    public dkk aqQ() {
        return (dkk) MembersInjectors.a(this.cYl, new dkk((gy) this.cIB.get()));
    }

    public static emi<dkk> m8924a(emg<dkk> com_fossil_emg_com_fossil_dkk, eru<gy> com_fossil_eru_com_fossil_gy) {
        return new dkl(com_fossil_emg_com_fossil_dkk, com_fossil_eru_com_fossil_gy);
    }
}
