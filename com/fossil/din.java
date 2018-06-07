package com.fossil;

public final class din implements emi<fj> {
    static final /* synthetic */ boolean $assertionsDisabled = (!din.class.desiredAssertionStatus());
    private final dil cWw;

    public /* synthetic */ Object get() {
        return ahg();
    }

    public din(dil com_fossil_dil) {
        if ($assertionsDisabled || com_fossil_dil != null) {
            this.cWw = com_fossil_dil;
            return;
        }
        throw new AssertionError();
    }

    public fj ahg() {
        return (fj) emj.m10873f(this.cWw.ahb(), "Cannot return null from a non-@Nullable @Provides method");
    }

    public static emi<fj> m8770a(dil com_fossil_dil) {
        return new din(com_fossil_dil);
    }
}
