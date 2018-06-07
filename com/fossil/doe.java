package com.fossil;

public final class doe implements emi<ctj> {
    static final /* synthetic */ boolean $assertionsDisabled = (!doe.class.desiredAssertionStatus());
    private final dod dbK;

    public /* synthetic */ Object get() {
        return asU();
    }

    public doe(dod com_fossil_dod) {
        if ($assertionsDisabled || com_fossil_dod != null) {
            this.dbK = com_fossil_dod;
            return;
        }
        throw new AssertionError();
    }

    public ctj asU() {
        return (ctj) emj.m10873f(this.dbK.asS(), "Cannot return null from a non-@Nullable @Provides method");
    }

    public static emi<ctj> m9219b(dod com_fossil_dod) {
        return new doe(com_fossil_dod);
    }
}
