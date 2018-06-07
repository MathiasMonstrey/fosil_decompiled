package com.fossil;

import android.content.Context;
import com.fossil.dfp.C2727b;
import dagger.internal.MembersInjectors;

public final class dfu implements emi<dft> {
    static final /* synthetic */ boolean $assertionsDisabled = (!dfu.class.desiredAssertionStatus());
    private final eru<C2727b> cGA;
    private final eru<dpl> cil;
    private final eru<dpf> cim;
    private final emg<dft> ckU;
    private final eru<Context> contextProvider;
    private final eru<ckc> useCaseHandlerProvider;

    public /* synthetic */ Object get() {
        return anQ();
    }

    public dfu(emg<dft> com_fossil_emg_com_fossil_dft, eru<C2727b> com_fossil_eru_com_fossil_dfp_b, eru<ckc> com_fossil_eru_com_fossil_ckc, eru<dpf> com_fossil_eru_com_fossil_dpf, eru<dpl> com_fossil_eru_com_fossil_dpl, eru<Context> com_fossil_eru_android_content_Context) {
        if ($assertionsDisabled || com_fossil_emg_com_fossil_dft != null) {
            this.ckU = com_fossil_emg_com_fossil_dft;
            if ($assertionsDisabled || com_fossil_eru_com_fossil_dfp_b != null) {
                this.cGA = com_fossil_eru_com_fossil_dfp_b;
                if ($assertionsDisabled || com_fossil_eru_com_fossil_ckc != null) {
                    this.useCaseHandlerProvider = com_fossil_eru_com_fossil_ckc;
                    if ($assertionsDisabled || com_fossil_eru_com_fossil_dpf != null) {
                        this.cim = com_fossil_eru_com_fossil_dpf;
                        if ($assertionsDisabled || com_fossil_eru_com_fossil_dpl != null) {
                            this.cil = com_fossil_eru_com_fossil_dpl;
                            if ($assertionsDisabled || com_fossil_eru_android_content_Context != null) {
                                this.contextProvider = com_fossil_eru_android_content_Context;
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
        throw new AssertionError();
    }

    public dft anQ() {
        return (dft) MembersInjectors.a(this.ckU, new dft((C2727b) this.cGA.get(), (ckc) this.useCaseHandlerProvider.get(), (dpf) this.cim.get(), (dpl) this.cil.get(), (Context) this.contextProvider.get()));
    }

    public static emi<dft> m8492a(emg<dft> com_fossil_emg_com_fossil_dft, eru<C2727b> com_fossil_eru_com_fossil_dfp_b, eru<ckc> com_fossil_eru_com_fossil_ckc, eru<dpf> com_fossil_eru_com_fossil_dpf, eru<dpl> com_fossil_eru_com_fossil_dpl, eru<Context> com_fossil_eru_android_content_Context) {
        return new dfu(com_fossil_emg_com_fossil_dft, com_fossil_eru_com_fossil_dfp_b, com_fossil_eru_com_fossil_ckc, com_fossil_eru_com_fossil_dpf, com_fossil_eru_com_fossil_dpl, com_fossil_eru_android_content_Context);
    }
}
