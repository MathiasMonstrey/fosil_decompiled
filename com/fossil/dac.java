package com.fossil;

import dagger.internal.MembersInjectors;

public final class dac implements emi<dab> {
    static final /* synthetic */ boolean $assertionsDisabled = (!dac.class.desiredAssertionStatus());
    private final emg<dab> cNj;

    public /* synthetic */ Object get() {
        return akN();
    }

    public dac(emg<dab> com_fossil_emg_com_fossil_dab) {
        if ($assertionsDisabled || com_fossil_emg_com_fossil_dab != null) {
            this.cNj = com_fossil_emg_com_fossil_dab;
            return;
        }
        throw new AssertionError();
    }

    public dab akN() {
        return (dab) MembersInjectors.a(this.cNj, new dab());
    }

    public static emi<dab> m8067a(emg<dab> com_fossil_emg_com_fossil_dab) {
        return new dac(com_fossil_emg_com_fossil_dab);
    }
}
