package com.fossil;

public final class dhn implements emi<fj> {
    static final /* synthetic */ boolean $assertionsDisabled = (!dhn.class.desiredAssertionStatus());
    private final dhl cVF;

    public /* synthetic */ Object get() {
        return ahg();
    }

    public dhn(dhl com_fossil_dhl) {
        if ($assertionsDisabled || com_fossil_dhl != null) {
            this.cVF = com_fossil_dhl;
            return;
        }
        throw new AssertionError();
    }

    public fj ahg() {
        return (fj) emj.m10873f(this.cVF.ahb(), "Cannot return null from a non-@Nullable @Provides method");
    }

    public static emi<fj> m8721b(dhl com_fossil_dhl) {
        return new dhn(com_fossil_dhl);
    }
}
