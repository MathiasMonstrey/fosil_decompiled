package com.fossil;

import dagger.internal.MembersInjectors;

public final class dps implements emi<dpr> {
    static final /* synthetic */ boolean $assertionsDisabled = (!dps.class.desiredAssertionStatus());
    private final emg<dpr> ddj;

    public /* synthetic */ Object get() {
        return atO();
    }

    public dps(emg<dpr> com_fossil_emg_com_fossil_dpr) {
        if ($assertionsDisabled || com_fossil_emg_com_fossil_dpr != null) {
            this.ddj = com_fossil_emg_com_fossil_dpr;
            return;
        }
        throw new AssertionError();
    }

    public dpr atO() {
        return (dpr) MembersInjectors.a(this.ddj, new dpr());
    }

    public static emi<dpr> m9346a(emg<dpr> com_fossil_emg_com_fossil_dpr) {
        return new dps(com_fossil_emg_com_fossil_dpr);
    }
}
