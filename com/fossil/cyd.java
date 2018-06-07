package com.fossil;

import dagger.internal.MembersInjectors;

public final class cyd implements emi<cyc> {
    static final /* synthetic */ boolean $assertionsDisabled = (!cyd.class.desiredAssertionStatus());
    private final emg<cyc> cKJ;

    public /* synthetic */ Object get() {
        return ajJ();
    }

    public cyd(emg<cyc> com_fossil_emg_com_fossil_cyc) {
        if ($assertionsDisabled || com_fossil_emg_com_fossil_cyc != null) {
            this.cKJ = com_fossil_emg_com_fossil_cyc;
            return;
        }
        throw new AssertionError();
    }

    public cyc ajJ() {
        return (cyc) MembersInjectors.a(this.cKJ, new cyc());
    }

    public static emi<cyc> m7891a(emg<cyc> com_fossil_emg_com_fossil_cyc) {
        return new cyd(com_fossil_emg_com_fossil_cyc);
    }
}
