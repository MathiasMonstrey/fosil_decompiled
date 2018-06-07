package com.fossil;

import android.content.Context;

public final class cjg implements emi<cmw> {
    static final /* synthetic */ boolean $assertionsDisabled = (!cjg.class.desiredAssertionStatus());
    private final eru<ciw> appExecutorsProvider;
    private final ciz ceD;
    private final eru<Context> contextProvider;

    public /* synthetic */ Object get() {
        return Zq();
    }

    public cjg(ciz com_fossil_ciz, eru<Context> com_fossil_eru_android_content_Context, eru<ciw> com_fossil_eru_com_fossil_ciw) {
        if ($assertionsDisabled || com_fossil_ciz != null) {
            this.ceD = com_fossil_ciz;
            if ($assertionsDisabled || com_fossil_eru_android_content_Context != null) {
                this.contextProvider = com_fossil_eru_android_content_Context;
                if ($assertionsDisabled || com_fossil_eru_com_fossil_ciw != null) {
                    this.appExecutorsProvider = com_fossil_eru_com_fossil_ciw;
                    return;
                }
                throw new AssertionError();
            }
            throw new AssertionError();
        }
        throw new AssertionError();
    }

    public cmw Zq() {
        return (cmw) emj.m10873f(this.ceD.m6608a((Context) this.contextProvider.get(), (ciw) this.appExecutorsProvider.get()), "Cannot return null from a non-@Nullable @Provides method");
    }

    public static emi<cmw> m6621a(ciz com_fossil_ciz, eru<Context> com_fossil_eru_android_content_Context, eru<ciw> com_fossil_eru_com_fossil_ciw) {
        return new cjg(com_fossil_ciz, com_fossil_eru_android_content_Context, com_fossil_eru_com_fossil_ciw);
    }
}
