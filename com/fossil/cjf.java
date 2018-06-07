package com.fossil;

import android.content.Context;

public final class cjf implements emi<bbm> {
    static final /* synthetic */ boolean $assertionsDisabled = (!cjf.class.desiredAssertionStatus());
    private final ciz ceD;
    private final eru<Context> contextProvider;

    public /* synthetic */ Object get() {
        return Zp();
    }

    public cjf(ciz com_fossil_ciz, eru<Context> com_fossil_eru_android_content_Context) {
        if ($assertionsDisabled || com_fossil_ciz != null) {
            this.ceD = com_fossil_ciz;
            if ($assertionsDisabled || com_fossil_eru_android_content_Context != null) {
                this.contextProvider = com_fossil_eru_android_content_Context;
                return;
            }
            throw new AssertionError();
        }
        throw new AssertionError();
    }

    public bbm Zp() {
        return (bbm) emj.m10873f(this.ceD.bn((Context) this.contextProvider.get()), "Cannot return null from a non-@Nullable @Provides method");
    }

    public static emi<bbm> m6620a(ciz com_fossil_ciz, eru<Context> com_fossil_eru_android_content_Context) {
        return new cjf(com_fossil_ciz, com_fossil_eru_android_content_Context);
    }
}
