package com.fossil;

public final class dan implements emi<String> {
    static final /* synthetic */ boolean $assertionsDisabled = (!dan.class.desiredAssertionStatus());
    private final dam cNC;

    public /* synthetic */ Object get() {
        return ajb();
    }

    public dan(dam com_fossil_dam) {
        if ($assertionsDisabled || com_fossil_dam != null) {
            this.cNC = com_fossil_dam;
            return;
        }
        throw new AssertionError();
    }

    public String ajb() {
        return (String) emj.m10873f(this.cNC.aiZ(), "Cannot return null from a non-@Nullable @Provides method");
    }

    public static emi<String> m8095b(dam com_fossil_dam) {
        return new dan(com_fossil_dam);
    }
}
