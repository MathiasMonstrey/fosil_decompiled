package com.fossil;

public final class cxe implements emi<String> {
    static final /* synthetic */ boolean $assertionsDisabled = (!cxe.class.desiredAssertionStatus());
    private final cxa cKb;

    public /* synthetic */ Object get() {
        return ajb();
    }

    public cxe(cxa com_fossil_cxa) {
        if ($assertionsDisabled || com_fossil_cxa != null) {
            this.cKb = com_fossil_cxa;
            return;
        }
        throw new AssertionError();
    }

    public String ajb() {
        return (String) emj.m10873f(this.cKb.aiZ(), "Cannot return null from a non-@Nullable @Provides method");
    }

    public static emi<String> m7842b(cxa com_fossil_cxa) {
        return new cxe(com_fossil_cxa);
    }
}
