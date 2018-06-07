package com.fossil;

import dagger.internal.MembersInjectors;

public final class dae implements emi<dad> {
    static final /* synthetic */ boolean $assertionsDisabled = (!dae.class.desiredAssertionStatus());
    private final emg<dad> cNl;

    public /* synthetic */ Object get() {
        return akP();
    }

    public dae(emg<dad> com_fossil_emg_com_fossil_dad) {
        if ($assertionsDisabled || com_fossil_emg_com_fossil_dad != null) {
            this.cNl = com_fossil_emg_com_fossil_dad;
            return;
        }
        throw new AssertionError();
    }

    public dad akP() {
        return (dad) MembersInjectors.a(this.cNl, new dad());
    }

    public static emi<dad> m8070a(emg<dad> com_fossil_emg_com_fossil_dad) {
        return new dae(com_fossil_emg_com_fossil_dad);
    }
}
