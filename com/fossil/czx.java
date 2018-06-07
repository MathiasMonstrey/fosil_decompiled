package com.fossil;

public final class czx implements emi<String> {
    static final /* synthetic */ boolean $assertionsDisabled = (!czx.class.desiredAssertionStatus());
    private final czw cNg;

    public /* synthetic */ Object get() {
        return ajb();
    }

    public czx(czw com_fossil_czw) {
        if ($assertionsDisabled || com_fossil_czw != null) {
            this.cNg = com_fossil_czw;
            return;
        }
        throw new AssertionError();
    }

    public String ajb() {
        return (String) emj.m10873f(this.cNg.aiZ(), "Cannot return null from a non-@Nullable @Provides method");
    }

    public static emi<String> m8061b(czw com_fossil_czw) {
        return new czx(com_fossil_czw);
    }
}
