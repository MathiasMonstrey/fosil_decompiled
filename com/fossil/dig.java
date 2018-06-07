package com.fossil;

public final class dig implements emi<String> {
    static final /* synthetic */ boolean $assertionsDisabled = (!dig.class.desiredAssertionStatus());
    private final die cWi;

    public /* synthetic */ Object get() {
        return ajb();
    }

    public dig(die com_fossil_die) {
        if ($assertionsDisabled || com_fossil_die != null) {
            this.cWi = com_fossil_die;
            return;
        }
        throw new AssertionError();
    }

    public String ajb() {
        return (String) emj.m10873f(this.cWi.apL(), "Cannot return null from a non-@Nullable @Provides method");
    }

    public static emi<String> m8753b(die com_fossil_die) {
        return new dig(com_fossil_die);
    }
}
