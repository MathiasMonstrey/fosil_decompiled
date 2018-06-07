package com.fossil;

public final class cvw implements emi<fj> {
    static final /* synthetic */ boolean $assertionsDisabled = (!cvw.class.desiredAssertionStatus());
    private final cvu cIn;

    public /* synthetic */ Object get() {
        return ahg();
    }

    public cvw(cvu com_fossil_cvu) {
        if ($assertionsDisabled || com_fossil_cvu != null) {
            this.cIn = com_fossil_cvu;
            return;
        }
        throw new AssertionError();
    }

    public fj ahg() {
        return (fj) emj.m10873f(this.cIn.ahb(), "Cannot return null from a non-@Nullable @Provides method");
    }

    public static emi<fj> m7708b(cvu com_fossil_cvu) {
        return new cvw(com_fossil_cvu);
    }
}
