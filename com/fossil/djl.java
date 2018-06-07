package com.fossil;

import dagger.internal.MembersInjectors;

public final class djl implements emi<djk> {
    static final /* synthetic */ boolean $assertionsDisabled = (!djl.class.desiredAssertionStatus());
    private final emg<djk> cXt;

    public /* synthetic */ Object get() {
        return aqs();
    }

    public djl(emg<djk> com_fossil_emg_com_fossil_djk) {
        if ($assertionsDisabled || com_fossil_emg_com_fossil_djk != null) {
            this.cXt = com_fossil_emg_com_fossil_djk;
            return;
        }
        throw new AssertionError();
    }

    public djk aqs() {
        return (djk) MembersInjectors.a(this.cXt, new djk());
    }

    public static emi<djk> m8838a(emg<djk> com_fossil_emg_com_fossil_djk) {
        return new djl(com_fossil_emg_com_fossil_djk);
    }
}
