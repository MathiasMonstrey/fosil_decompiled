package com.fossil;

import java.util.Date;

public final class cuc implements emi<Date> {
    static final /* synthetic */ boolean $assertionsDisabled = (!cuc.class.desiredAssertionStatus());
    private final cub cGd;

    public /* synthetic */ Object get() {
        return ahd();
    }

    public cuc(cub com_fossil_cub) {
        if ($assertionsDisabled || com_fossil_cub != null) {
            this.cGd = com_fossil_cub;
            return;
        }
        throw new AssertionError();
    }

    public Date ahd() {
        return (Date) emj.m10873f(this.cGd.ahc(), "Cannot return null from a non-@Nullable @Provides method");
    }

    public static emi<Date> m7581b(cub com_fossil_cub) {
        return new cuc(com_fossil_cub);
    }
}
