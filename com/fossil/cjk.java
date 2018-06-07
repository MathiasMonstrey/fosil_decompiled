package com.fossil;

import com.misfit.frameworks.network.manager.MFNetwork;

public final class cjk implements emi<MFNetwork> {
    static final /* synthetic */ boolean $assertionsDisabled = (!cjk.class.desiredAssertionStatus());
    private final ciz ceD;

    public /* synthetic */ Object get() {
        return Zu();
    }

    public cjk(ciz com_fossil_ciz) {
        if ($assertionsDisabled || com_fossil_ciz != null) {
            this.ceD = com_fossil_ciz;
            return;
        }
        throw new AssertionError();
    }

    public MFNetwork Zu() {
        return (MFNetwork) emj.m10873f(this.ceD.Zf(), "Cannot return null from a non-@Nullable @Provides method");
    }

    public static emi<MFNetwork> m6625a(ciz com_fossil_ciz) {
        return new cjk(com_fossil_ciz);
    }
}
