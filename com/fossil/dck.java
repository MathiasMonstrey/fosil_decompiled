package com.fossil;

public final class dck implements emi<Integer> {
    static final /* synthetic */ boolean $assertionsDisabled = (!dck.class.desiredAssertionStatus());
    private final dcj cPu;

    public /* synthetic */ Object get() {
        return ama();
    }

    public dck(dcj com_fossil_dcj) {
        if ($assertionsDisabled || com_fossil_dcj != null) {
            this.cPu = com_fossil_dcj;
            return;
        }
        throw new AssertionError();
    }

    public Integer ama() {
        return (Integer) emj.m10873f(Integer.valueOf(this.cPu.alY()), "Cannot return null from a non-@Nullable @Provides method");
    }

    public static emi<Integer> m8260b(dcj com_fossil_dcj) {
        return new dck(com_fossil_dcj);
    }
}
