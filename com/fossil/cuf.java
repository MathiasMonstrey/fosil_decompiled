package com.fossil;

public final class cuf implements emi<fj> {
    static final /* synthetic */ boolean $assertionsDisabled = (!cuf.class.desiredAssertionStatus());
    private final cub cGd;

    public /* synthetic */ Object get() {
        return ahg();
    }

    public cuf(cub com_fossil_cub) {
        if ($assertionsDisabled || com_fossil_cub != null) {
            this.cGd = com_fossil_cub;
            return;
        }
        throw new AssertionError();
    }

    public fj ahg() {
        return (fj) emj.m10873f(this.cGd.ahb(), "Cannot return null from a non-@Nullable @Provides method");
    }

    public static emi<fj> m7584b(cub com_fossil_cub) {
        return new cuf(com_fossil_cub);
    }
}
