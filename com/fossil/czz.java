package com.fossil;

import com.fossil.czt.C2584b;
import dagger.internal.MembersInjectors;

public final class czz implements emi<czv> {
    static final /* synthetic */ boolean $assertionsDisabled = (!czz.class.desiredAssertionStatus());
    private final eru<C2584b> cGA;
    private final eru<gy> cIB;
    private final eru<String> cJF;
    private final emg<czv> chV;
    private final eru<dad> chX;
    private final eru<daf> chY;
    private final eru<dab> chZ;
    private final eru<ckc> useCaseHandlerProvider;

    public /* synthetic */ Object get() {
        return akM();
    }

    public czz(emg<czv> com_fossil_emg_com_fossil_czv, eru<gy> com_fossil_eru_com_fossil_gy, eru<String> com_fossil_eru_java_lang_String, eru<C2584b> com_fossil_eru_com_fossil_czt_b, eru<ckc> com_fossil_eru_com_fossil_ckc, eru<dad> com_fossil_eru_com_fossil_dad, eru<daf> com_fossil_eru_com_fossil_daf, eru<dab> com_fossil_eru_com_fossil_dab) {
        if ($assertionsDisabled || com_fossil_emg_com_fossil_czv != null) {
            this.chV = com_fossil_emg_com_fossil_czv;
            if ($assertionsDisabled || com_fossil_eru_com_fossil_gy != null) {
                this.cIB = com_fossil_eru_com_fossil_gy;
                if ($assertionsDisabled || com_fossil_eru_java_lang_String != null) {
                    this.cJF = com_fossil_eru_java_lang_String;
                    if ($assertionsDisabled || com_fossil_eru_com_fossil_czt_b != null) {
                        this.cGA = com_fossil_eru_com_fossil_czt_b;
                        if ($assertionsDisabled || com_fossil_eru_com_fossil_ckc != null) {
                            this.useCaseHandlerProvider = com_fossil_eru_com_fossil_ckc;
                            if ($assertionsDisabled || com_fossil_eru_com_fossil_dad != null) {
                                this.chX = com_fossil_eru_com_fossil_dad;
                                if ($assertionsDisabled || com_fossil_eru_com_fossil_daf != null) {
                                    this.chY = com_fossil_eru_com_fossil_daf;
                                    if ($assertionsDisabled || com_fossil_eru_com_fossil_dab != null) {
                                        this.chZ = com_fossil_eru_com_fossil_dab;
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
            throw new AssertionError();
        }
        throw new AssertionError();
    }

    public czv akM() {
        return (czv) MembersInjectors.a(this.chV, new czv((gy) this.cIB.get(), (String) this.cJF.get(), (C2584b) this.cGA.get(), (ckc) this.useCaseHandlerProvider.get(), (dad) this.chX.get(), (daf) this.chY.get(), (dab) this.chZ.get()));
    }

    public static emi<czv> m8063a(emg<czv> com_fossil_emg_com_fossil_czv, eru<gy> com_fossil_eru_com_fossil_gy, eru<String> com_fossil_eru_java_lang_String, eru<C2584b> com_fossil_eru_com_fossil_czt_b, eru<ckc> com_fossil_eru_com_fossil_ckc, eru<dad> com_fossil_eru_com_fossil_dad, eru<daf> com_fossil_eru_com_fossil_daf, eru<dab> com_fossil_eru_com_fossil_dab) {
        return new czz(com_fossil_emg_com_fossil_czv, com_fossil_eru_com_fossil_gy, com_fossil_eru_java_lang_String, com_fossil_eru_com_fossil_czt_b, com_fossil_eru_com_fossil_ckc, com_fossil_eru_com_fossil_dad, com_fossil_eru_com_fossil_daf, com_fossil_eru_com_fossil_dab);
    }
}
