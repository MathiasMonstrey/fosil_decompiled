package com.fossil;

public final class cwo implements emi<String> {
    static final /* synthetic */ boolean $assertionsDisabled = (!cwo.class.desiredAssertionStatus());
    private final cwm cJC;

    public /* synthetic */ Object get() {
        return ajb();
    }

    public cwo(cwm com_fossil_cwm) {
        if ($assertionsDisabled || com_fossil_cwm != null) {
            this.cJC = com_fossil_cwm;
            return;
        }
        throw new AssertionError();
    }

    public String ajb() {
        return (String) emj.m10873f(this.cJC.aiZ(), "Cannot return null from a non-@Nullable @Provides method");
    }

    public static emi<String> m7800b(cwm com_fossil_cwm) {
        return new cwo(com_fossil_cwm);
    }
}
