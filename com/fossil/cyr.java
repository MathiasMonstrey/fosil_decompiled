package com.fossil;

import dagger.internal.MembersInjectors;

public final class cyr implements emi<cyq> {
    static final /* synthetic */ boolean $assertionsDisabled = (!cyr.class.desiredAssertionStatus());
    private final eru<gy> cLo;
    private final emg<cyq> cLq;

    public /* synthetic */ Object get() {
        return ajW();
    }

    public cyr(emg<cyq> com_fossil_emg_com_fossil_cyq, eru<gy> com_fossil_eru_com_fossil_gy) {
        if ($assertionsDisabled || com_fossil_emg_com_fossil_cyq != null) {
            this.cLq = com_fossil_emg_com_fossil_cyq;
            if ($assertionsDisabled || com_fossil_eru_com_fossil_gy != null) {
                this.cLo = com_fossil_eru_com_fossil_gy;
                return;
            }
            throw new AssertionError();
        }
        throw new AssertionError();
    }

    public cyq ajW() {
        return (cyq) MembersInjectors.a(this.cLq, new cyq((gy) this.cLo.get()));
    }

    public static emi<cyq> m7926a(emg<cyq> com_fossil_emg_com_fossil_cyq, eru<gy> com_fossil_eru_com_fossil_gy) {
        return new cyr(com_fossil_emg_com_fossil_cyq, com_fossil_eru_com_fossil_gy);
    }
}
