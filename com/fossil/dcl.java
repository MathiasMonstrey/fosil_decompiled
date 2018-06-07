package com.fossil;

public final class dcl implements emi<Boolean> {
    static final /* synthetic */ boolean $assertionsDisabled = (!dcl.class.desiredAssertionStatus());
    private final dcj cPu;

    public /* synthetic */ Object get() {
        return amb();
    }

    public dcl(dcj com_fossil_dcj) {
        if ($assertionsDisabled || com_fossil_dcj != null) {
            this.cPu = com_fossil_dcj;
            return;
        }
        throw new AssertionError();
    }

    public Boolean amb() {
        return (Boolean) emj.m10873f(Boolean.valueOf(this.cPu.alZ()), "Cannot return null from a non-@Nullable @Provides method");
    }

    public static emi<Boolean> m8261b(dcj com_fossil_dcj) {
        return new dcl(com_fossil_dcj);
    }
}
