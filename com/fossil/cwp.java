package com.fossil;

import android.content.Context;
import com.fossil.cwj.C2442b;
import dagger.internal.MembersInjectors;

public final class cwp implements emi<cwl> {
    static final /* synthetic */ boolean $assertionsDisabled = (!cwp.class.desiredAssertionStatus());
    private final eru<cmi> cFX;
    private final eru<C2442b> cGA;
    private final eru<Context> cJD;
    private final eru<cmj> cJE;
    private final eru<String> cJF;
    private final emg<cwl> cgI;
    private final eru<cwt> cgL;
    private final eru<cxh> cgM;
    private final eru<cwr> cgN;
    private final eru<cnr> sharedPreferencesManagerProvider;
    private final eru<ckc> useCaseHandlerProvider;

    public /* synthetic */ Object get() {
        return ajc();
    }

    public cwp(emg<cwl> com_fossil_emg_com_fossil_cwl, eru<Context> com_fossil_eru_android_content_Context, eru<cmj> com_fossil_eru_com_fossil_cmj, eru<C2442b> com_fossil_eru_com_fossil_cwj_b, eru<cmi> com_fossil_eru_com_fossil_cmi, eru<cnr> com_fossil_eru_com_fossil_cnr, eru<String> com_fossil_eru_java_lang_String, eru<ckc> com_fossil_eru_com_fossil_ckc, eru<cwt> com_fossil_eru_com_fossil_cwt, eru<cxh> com_fossil_eru_com_fossil_cxh, eru<cwr> com_fossil_eru_com_fossil_cwr) {
        if ($assertionsDisabled || com_fossil_emg_com_fossil_cwl != null) {
            this.cgI = com_fossil_emg_com_fossil_cwl;
            if ($assertionsDisabled || com_fossil_eru_android_content_Context != null) {
                this.cJD = com_fossil_eru_android_content_Context;
                if ($assertionsDisabled || com_fossil_eru_com_fossil_cmj != null) {
                    this.cJE = com_fossil_eru_com_fossil_cmj;
                    if ($assertionsDisabled || com_fossil_eru_com_fossil_cwj_b != null) {
                        this.cGA = com_fossil_eru_com_fossil_cwj_b;
                        if ($assertionsDisabled || com_fossil_eru_com_fossil_cmi != null) {
                            this.cFX = com_fossil_eru_com_fossil_cmi;
                            if ($assertionsDisabled || com_fossil_eru_com_fossil_cnr != null) {
                                this.sharedPreferencesManagerProvider = com_fossil_eru_com_fossil_cnr;
                                if ($assertionsDisabled || com_fossil_eru_java_lang_String != null) {
                                    this.cJF = com_fossil_eru_java_lang_String;
                                    if ($assertionsDisabled || com_fossil_eru_com_fossil_ckc != null) {
                                        this.useCaseHandlerProvider = com_fossil_eru_com_fossil_ckc;
                                        if ($assertionsDisabled || com_fossil_eru_com_fossil_cwt != null) {
                                            this.cgL = com_fossil_eru_com_fossil_cwt;
                                            if ($assertionsDisabled || com_fossil_eru_com_fossil_cxh != null) {
                                                this.cgM = com_fossil_eru_com_fossil_cxh;
                                                if ($assertionsDisabled || com_fossil_eru_com_fossil_cwr != null) {
                                                    this.cgN = com_fossil_eru_com_fossil_cwr;
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
                throw new AssertionError();
            }
            throw new AssertionError();
        }
        throw new AssertionError();
    }

    public cwl ajc() {
        return (cwl) MembersInjectors.a(this.cgI, new cwl((Context) this.cJD.get(), (cmj) this.cJE.get(), (C2442b) this.cGA.get(), (cmi) this.cFX.get(), (cnr) this.sharedPreferencesManagerProvider.get(), (String) this.cJF.get(), (ckc) this.useCaseHandlerProvider.get(), (cwt) this.cgL.get(), (cxh) this.cgM.get(), (cwr) this.cgN.get()));
    }

    public static emi<cwl> m7801a(emg<cwl> com_fossil_emg_com_fossil_cwl, eru<Context> com_fossil_eru_android_content_Context, eru<cmj> com_fossil_eru_com_fossil_cmj, eru<C2442b> com_fossil_eru_com_fossil_cwj_b, eru<cmi> com_fossil_eru_com_fossil_cmi, eru<cnr> com_fossil_eru_com_fossil_cnr, eru<String> com_fossil_eru_java_lang_String, eru<ckc> com_fossil_eru_com_fossil_ckc, eru<cwt> com_fossil_eru_com_fossil_cwt, eru<cxh> com_fossil_eru_com_fossil_cxh, eru<cwr> com_fossil_eru_com_fossil_cwr) {
        return new cwp(com_fossil_emg_com_fossil_cwl, com_fossil_eru_android_content_Context, com_fossil_eru_com_fossil_cmj, com_fossil_eru_com_fossil_cwj_b, com_fossil_eru_com_fossil_cmi, com_fossil_eru_com_fossil_cnr, com_fossil_eru_java_lang_String, com_fossil_eru_com_fossil_ckc, com_fossil_eru_com_fossil_cwt, com_fossil_eru_com_fossil_cxh, com_fossil_eru_com_fossil_cwr);
    }
}
