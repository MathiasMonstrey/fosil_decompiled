package com.fossil;

import dagger.internal.MembersInjectors;

public final class dcw implements emi<dcv> {
    static final /* synthetic */ boolean $assertionsDisabled = (!dcw.class.desiredAssertionStatus());
    private final emg<dcv> cQD;

    public /* synthetic */ Object get() {
        return amv();
    }

    public dcw(emg<dcv> com_fossil_emg_com_fossil_dcv) {
        if ($assertionsDisabled || com_fossil_emg_com_fossil_dcv != null) {
            this.cQD = com_fossil_emg_com_fossil_dcv;
            return;
        }
        throw new AssertionError();
    }

    public dcv amv() {
        return (dcv) MembersInjectors.a(this.cQD, new dcv());
    }

    public static emi<dcv> m8347a(emg<dcv> com_fossil_emg_com_fossil_dcv) {
        return new dcw(com_fossil_emg_com_fossil_dcv);
    }
}
