package com.fossil;

import com.fossil.dip.C2810b;
import dagger.internal.MembersInjectors;

public final class diu implements emi<dir> {
    static final /* synthetic */ boolean $assertionsDisabled = (!diu.class.desiredAssertionStatus());
    private final eru<C2810b> cGA;
    private final eru<cns> cWH;
    private final emg<dir> cko;
    private final eru<djw> ckq;
    private final eru<ckc> useCaseHandlerProvider;

    public /* synthetic */ Object get() {
        return apZ();
    }

    public diu(emg<dir> com_fossil_emg_com_fossil_dir, eru<C2810b> com_fossil_eru_com_fossil_dip_b, eru<djw> com_fossil_eru_com_fossil_djw, eru<cns> com_fossil_eru_com_fossil_cns, eru<ckc> com_fossil_eru_com_fossil_ckc) {
        if ($assertionsDisabled || com_fossil_emg_com_fossil_dir != null) {
            this.cko = com_fossil_emg_com_fossil_dir;
            if ($assertionsDisabled || com_fossil_eru_com_fossil_dip_b != null) {
                this.cGA = com_fossil_eru_com_fossil_dip_b;
                if ($assertionsDisabled || com_fossil_eru_com_fossil_djw != null) {
                    this.ckq = com_fossil_eru_com_fossil_djw;
                    if ($assertionsDisabled || com_fossil_eru_com_fossil_cns != null) {
                        this.cWH = com_fossil_eru_com_fossil_cns;
                        if ($assertionsDisabled || com_fossil_eru_com_fossil_ckc != null) {
                            this.useCaseHandlerProvider = com_fossil_eru_com_fossil_ckc;
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
        throw new AssertionError();
    }

    public dir apZ() {
        return (dir) MembersInjectors.a(this.cko, new dir((C2810b) this.cGA.get(), (djw) this.ckq.get(), (cns) this.cWH.get(), (ckc) this.useCaseHandlerProvider.get()));
    }

    public static emi<dir> create(emg<dir> com_fossil_emg_com_fossil_dir, eru<C2810b> com_fossil_eru_com_fossil_dip_b, eru<djw> com_fossil_eru_com_fossil_djw, eru<cns> com_fossil_eru_com_fossil_cns, eru<ckc> com_fossil_eru_com_fossil_ckc) {
        return new diu(com_fossil_emg_com_fossil_dir, com_fossil_eru_com_fossil_dip_b, com_fossil_eru_com_fossil_djw, com_fossil_eru_com_fossil_cns, com_fossil_eru_com_fossil_ckc);
    }
}
