package com.fossil;

import dagger.internal.MembersInjectors;

public final class djx implements emi<djw> {
    static final /* synthetic */ boolean $assertionsDisabled = (!djx.class.desiredAssertionStatus());
    private final emg<djw> cXL;

    public /* synthetic */ Object get() {
        return aqC();
    }

    public djx(emg<djw> com_fossil_emg_com_fossil_djw) {
        if ($assertionsDisabled || com_fossil_emg_com_fossil_djw != null) {
            this.cXL = com_fossil_emg_com_fossil_djw;
            return;
        }
        throw new AssertionError();
    }

    public djw aqC() {
        return (djw) MembersInjectors.a(this.cXL, new djw());
    }

    public static emi<djw> m8855a(emg<djw> com_fossil_emg_com_fossil_djw) {
        return new djx(com_fossil_emg_com_fossil_djw);
    }
}
