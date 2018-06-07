package com.fossil;

import com.fossil.dov.C3025b;

public final class dbk implements emi<C3025b> {
    static final /* synthetic */ boolean $assertionsDisabled = (!dbk.class.desiredAssertionStatus());
    private final dbj cOg;

    public /* synthetic */ Object get() {
        return all();
    }

    public dbk(dbj com_fossil_dbj) {
        if ($assertionsDisabled || com_fossil_dbj != null) {
            this.cOg = com_fossil_dbj;
            return;
        }
        throw new AssertionError();
    }

    public C3025b all() {
        return (C3025b) emj.m10873f(this.cOg.alk(), "Cannot return null from a non-@Nullable @Provides method");
    }

    public static emi<C3025b> m8132b(dbj com_fossil_dbj) {
        return new dbk(com_fossil_dbj);
    }
}
