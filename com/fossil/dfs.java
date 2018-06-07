package com.fossil;

import com.fossil.dfp.C2727b;

public final class dfs implements emi<C2727b> {
    static final /* synthetic */ boolean $assertionsDisabled = (!dfs.class.desiredAssertionStatus());
    private final dfr cTh;

    public /* synthetic */ Object get() {
        return anP();
    }

    public dfs(dfr com_fossil_dfr) {
        if ($assertionsDisabled || com_fossil_dfr != null) {
            this.cTh = com_fossil_dfr;
            return;
        }
        throw new AssertionError();
    }

    public C2727b anP() {
        return (C2727b) emj.m10873f(this.cTh.anO(), "Cannot return null from a non-@Nullable @Provides method");
    }

    public static emi<C2727b> m8484b(dfr com_fossil_dfr) {
        return new dfs(com_fossil_dfr);
    }
}
