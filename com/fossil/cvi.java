package com.fossil;

import com.fossil.cvg.C2383b;
import dagger.internal.MembersInjectors;

public final class cvi implements emi<cvh> {
    static final /* synthetic */ boolean $assertionsDisabled = (!cvi.class.desiredAssertionStatus());
    private final eru<C2383b> cGA;
    private final eru<ckc> cHh;
    private final eru<dpd> ciC;
    private final emg<cvh> cmo;

    public /* synthetic */ Object get() {
        return aic();
    }

    public cvi(emg<cvh> com_fossil_emg_com_fossil_cvh, eru<C2383b> com_fossil_eru_com_fossil_cvg_b, eru<ckc> com_fossil_eru_com_fossil_ckc, eru<dpd> com_fossil_eru_com_fossil_dpd) {
        if ($assertionsDisabled || com_fossil_emg_com_fossil_cvh != null) {
            this.cmo = com_fossil_emg_com_fossil_cvh;
            if ($assertionsDisabled || com_fossil_eru_com_fossil_cvg_b != null) {
                this.cGA = com_fossil_eru_com_fossil_cvg_b;
                if ($assertionsDisabled || com_fossil_eru_com_fossil_ckc != null) {
                    this.cHh = com_fossil_eru_com_fossil_ckc;
                    if ($assertionsDisabled || com_fossil_eru_com_fossil_dpd != null) {
                        this.ciC = com_fossil_eru_com_fossil_dpd;
                        return;
                    }
                    throw new AssertionError();
                }
                throw new AssertionError();
            }
            throw new AssertionError();
        }
        throw new AssertionError();
    }

    public cvh aic() {
        return (cvh) MembersInjectors.a(this.cmo, new cvh((C2383b) this.cGA.get(), (ckc) this.cHh.get(), (dpd) this.ciC.get()));
    }

    public static emi<cvh> create(emg<cvh> com_fossil_emg_com_fossil_cvh, eru<C2383b> com_fossil_eru_com_fossil_cvg_b, eru<ckc> com_fossil_eru_com_fossil_ckc, eru<dpd> com_fossil_eru_com_fossil_dpd) {
        return new cvi(com_fossil_emg_com_fossil_cvh, com_fossil_eru_com_fossil_cvg_b, com_fossil_eru_com_fossil_ckc, com_fossil_eru_com_fossil_dpd);
    }
}
