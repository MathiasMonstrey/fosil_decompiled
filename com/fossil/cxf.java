package com.fossil;

import android.content.Context;
import com.fossil.cwx.C2456b;
import com.misfit.frameworks.buttonservice.model.Alarm;
import dagger.internal.MembersInjectors;
import java.util.List;

public final class cxf implements emi<cwz> {
    static final /* synthetic */ boolean $assertionsDisabled = (!cxf.class.desiredAssertionStatus());
    private final eru<C2456b> cGA;
    private final eru<Context> cJD;
    private final eru<cmj> cJE;
    private final eru<String> cJF;
    private final eru<List<Alarm>> cKc;
    private final eru<Alarm> cKd;
    private final eru<cxh> cgM;
    private final emg<cwz> cgS;
    private final eru<ckc> useCaseHandlerProvider;

    public /* synthetic */ Object get() {
        return ajt();
    }

    public cxf(emg<cwz> com_fossil_emg_com_fossil_cwz, eru<Context> com_fossil_eru_android_content_Context, eru<cmj> com_fossil_eru_com_fossil_cmj, eru<C2456b> com_fossil_eru_com_fossil_cwx_b, eru<String> com_fossil_eru_java_lang_String, eru<List<Alarm>> com_fossil_eru_java_util_List_com_misfit_frameworks_buttonservice_model_Alarm, eru<Alarm> com_fossil_eru_com_misfit_frameworks_buttonservice_model_Alarm, eru<ckc> com_fossil_eru_com_fossil_ckc, eru<cxh> com_fossil_eru_com_fossil_cxh) {
        if ($assertionsDisabled || com_fossil_emg_com_fossil_cwz != null) {
            this.cgS = com_fossil_emg_com_fossil_cwz;
            if ($assertionsDisabled || com_fossil_eru_android_content_Context != null) {
                this.cJD = com_fossil_eru_android_content_Context;
                if ($assertionsDisabled || com_fossil_eru_com_fossil_cmj != null) {
                    this.cJE = com_fossil_eru_com_fossil_cmj;
                    if ($assertionsDisabled || com_fossil_eru_com_fossil_cwx_b != null) {
                        this.cGA = com_fossil_eru_com_fossil_cwx_b;
                        if ($assertionsDisabled || com_fossil_eru_java_lang_String != null) {
                            this.cJF = com_fossil_eru_java_lang_String;
                            if ($assertionsDisabled || com_fossil_eru_java_util_List_com_misfit_frameworks_buttonservice_model_Alarm != null) {
                                this.cKc = com_fossil_eru_java_util_List_com_misfit_frameworks_buttonservice_model_Alarm;
                                if ($assertionsDisabled || com_fossil_eru_com_misfit_frameworks_buttonservice_model_Alarm != null) {
                                    this.cKd = com_fossil_eru_com_misfit_frameworks_buttonservice_model_Alarm;
                                    if ($assertionsDisabled || com_fossil_eru_com_fossil_ckc != null) {
                                        this.useCaseHandlerProvider = com_fossil_eru_com_fossil_ckc;
                                        if ($assertionsDisabled || com_fossil_eru_com_fossil_cxh != null) {
                                            this.cgM = com_fossil_eru_com_fossil_cxh;
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

    public cwz ajt() {
        return (cwz) MembersInjectors.a(this.cgS, new cwz((Context) this.cJD.get(), (cmj) this.cJE.get(), (C2456b) this.cGA.get(), (String) this.cJF.get(), (List) this.cKc.get(), (Alarm) this.cKd.get(), (ckc) this.useCaseHandlerProvider.get(), (cxh) this.cgM.get()));
    }

    public static emi<cwz> m7843a(emg<cwz> com_fossil_emg_com_fossil_cwz, eru<Context> com_fossil_eru_android_content_Context, eru<cmj> com_fossil_eru_com_fossil_cmj, eru<C2456b> com_fossil_eru_com_fossil_cwx_b, eru<String> com_fossil_eru_java_lang_String, eru<List<Alarm>> com_fossil_eru_java_util_List_com_misfit_frameworks_buttonservice_model_Alarm, eru<Alarm> com_fossil_eru_com_misfit_frameworks_buttonservice_model_Alarm, eru<ckc> com_fossil_eru_com_fossil_ckc, eru<cxh> com_fossil_eru_com_fossil_cxh) {
        return new cxf(com_fossil_emg_com_fossil_cwz, com_fossil_eru_android_content_Context, com_fossil_eru_com_fossil_cmj, com_fossil_eru_com_fossil_cwx_b, com_fossil_eru_java_lang_String, com_fossil_eru_java_util_List_com_misfit_frameworks_buttonservice_model_Alarm, com_fossil_eru_com_misfit_frameworks_buttonservice_model_Alarm, com_fossil_eru_com_fossil_ckc, com_fossil_eru_com_fossil_cxh);
    }
}
