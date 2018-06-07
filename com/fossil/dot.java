package com.fossil;

public final class dot implements emi<ctj> {
    static final /* synthetic */ boolean $assertionsDisabled = (!dot.class.desiredAssertionStatus());
    private final dos dcy;

    public /* synthetic */ Object get() {
        return asU();
    }

    public dot(dos com_fossil_dos) {
        if ($assertionsDisabled || com_fossil_dos != null) {
            this.dcy = com_fossil_dos;
            return;
        }
        throw new AssertionError();
    }

    public ctj asU() {
        return (ctj) emj.m10873f(this.dcy.asS(), "Cannot return null from a non-@Nullable @Provides method");
    }

    public static emi<ctj> m9258b(dos com_fossil_dos) {
        return new dot(com_fossil_dos);
    }
}
