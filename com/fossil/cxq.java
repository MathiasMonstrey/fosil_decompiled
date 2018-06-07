package com.fossil;

import com.fossil.cxl.C2479b;
import dagger.internal.MembersInjectors;

public final class cxq implements emi<cxp> {
    static final /* synthetic */ boolean $assertionsDisabled = (!cxq.class.desiredAssertionStatus());
    private final eru<C2479b> cGA;
    private final emg<cxp> chA;

    public /* synthetic */ Object get() {
        return ajy();
    }

    public cxq(emg<cxp> com_fossil_emg_com_fossil_cxp, eru<C2479b> com_fossil_eru_com_fossil_cxl_b) {
        if ($assertionsDisabled || com_fossil_emg_com_fossil_cxp != null) {
            this.chA = com_fossil_emg_com_fossil_cxp;
            if ($assertionsDisabled || com_fossil_eru_com_fossil_cxl_b != null) {
                this.cGA = com_fossil_eru_com_fossil_cxl_b;
                return;
            }
            throw new AssertionError();
        }
        throw new AssertionError();
    }

    public cxp ajy() {
        return (cxp) MembersInjectors.a(this.chA, new cxp((C2479b) this.cGA.get()));
    }

    public static emi<cxp> m7860a(emg<cxp> com_fossil_emg_com_fossil_cxp, eru<C2479b> com_fossil_eru_com_fossil_cxl_b) {
        return new cxq(com_fossil_emg_com_fossil_cxp, com_fossil_eru_com_fossil_cxl_b);
    }
}
