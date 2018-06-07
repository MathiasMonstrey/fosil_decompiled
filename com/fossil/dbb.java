package com.fossil;

public final class dbb implements emi<fj> {
    static final /* synthetic */ boolean $assertionsDisabled = (!dbb.class.desiredAssertionStatus());
    private final dax cNR;

    public /* synthetic */ Object get() {
        return ahg();
    }

    public dbb(dax com_fossil_dax) {
        if ($assertionsDisabled || com_fossil_dax != null) {
            this.cNR = com_fossil_dax;
            return;
        }
        throw new AssertionError();
    }

    public fj ahg() {
        return (fj) emj.m10873f(this.cNR.ahb(), "Cannot return null from a non-@Nullable @Provides method");
    }

    public static emi<fj> m8114b(dax com_fossil_dax) {
        return new dbb(com_fossil_dax);
    }
}
