package com.fossil;

import com.misfit.frameworks.buttonservice.model.Alarm;

public final class cxc implements emi<Alarm> {
    static final /* synthetic */ boolean $assertionsDisabled = (!cxc.class.desiredAssertionStatus());
    private final cxa cKb;

    public /* synthetic */ Object get() {
        return ajs();
    }

    public cxc(cxa com_fossil_cxa) {
        if ($assertionsDisabled || com_fossil_cxa != null) {
            this.cKb = com_fossil_cxa;
            return;
        }
        throw new AssertionError();
    }

    public Alarm ajs() {
        return this.cKb.ajq();
    }

    public static emi<Alarm> m7840b(cxa com_fossil_cxa) {
        return new cxc(com_fossil_cxa);
    }
}
