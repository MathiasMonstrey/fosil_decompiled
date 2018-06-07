package com.fossil;

import com.fossil.cun.C2344b;

public final class cuq implements emi<C2344b> {
    static final /* synthetic */ boolean $assertionsDisabled = (!cuq.class.desiredAssertionStatus());
    private final cup cGx;

    public /* synthetic */ Object get() {
        return aht();
    }

    public cuq(cup com_fossil_cup) {
        if ($assertionsDisabled || com_fossil_cup != null) {
            this.cGx = com_fossil_cup;
            return;
        }
        throw new AssertionError();
    }

    public C2344b aht() {
        return (C2344b) emj.m10873f(this.cGx.ahs(), "Cannot return null from a non-@Nullable @Provides method");
    }

    public static emi<C2344b> m7605b(cup com_fossil_cup) {
        return new cuq(com_fossil_cup);
    }
}
