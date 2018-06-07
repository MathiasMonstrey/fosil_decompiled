package com.fossil;

import com.fossil.dib.C2804b;

public final class dif implements emi<C2804b> {
    static final /* synthetic */ boolean $assertionsDisabled = (!dif.class.desiredAssertionStatus());
    private final die cWi;

    public /* synthetic */ Object get() {
        return apM();
    }

    public dif(die com_fossil_die) {
        if ($assertionsDisabled || com_fossil_die != null) {
            this.cWi = com_fossil_die;
            return;
        }
        throw new AssertionError();
    }

    public C2804b apM() {
        return (C2804b) emj.m10873f(this.cWi.apK(), "Cannot return null from a non-@Nullable @Provides method");
    }

    public static emi<C2804b> m8752b(die com_fossil_die) {
        return new dif(com_fossil_die);
    }
}
