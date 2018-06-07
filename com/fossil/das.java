package com.fossil;

import dagger.internal.MembersInjectors;

public final class das implements emi<dar> {
    static final /* synthetic */ boolean $assertionsDisabled = (!das.class.desiredAssertionStatus());
    private final eru<gy> cIB;
    private final emg<dar> cNE;

    public /* synthetic */ Object get() {
        return akY();
    }

    public das(emg<dar> com_fossil_emg_com_fossil_dar, eru<gy> com_fossil_eru_com_fossil_gy) {
        if ($assertionsDisabled || com_fossil_emg_com_fossil_dar != null) {
            this.cNE = com_fossil_emg_com_fossil_dar;
            if ($assertionsDisabled || com_fossil_eru_com_fossil_gy != null) {
                this.cIB = com_fossil_eru_com_fossil_gy;
                return;
            }
            throw new AssertionError();
        }
        throw new AssertionError();
    }

    public dar akY() {
        return (dar) MembersInjectors.a(this.cNE, new dar((gy) this.cIB.get()));
    }

    public static emi<dar> m8104a(emg<dar> com_fossil_emg_com_fossil_dar, eru<gy> com_fossil_eru_com_fossil_gy) {
        return new das(com_fossil_emg_com_fossil_dar, com_fossil_eru_com_fossil_gy);
    }
}
