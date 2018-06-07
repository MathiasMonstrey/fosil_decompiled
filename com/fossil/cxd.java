package com.fossil;

import com.misfit.frameworks.buttonservice.model.Alarm;
import java.util.List;

public final class cxd implements emi<List<Alarm>> {
    static final /* synthetic */ boolean $assertionsDisabled = (!cxd.class.desiredAssertionStatus());
    private final cxa cKb;

    public cxd(cxa com_fossil_cxa) {
        if ($assertionsDisabled || com_fossil_cxa != null) {
            this.cKb = com_fossil_cxa;
            return;
        }
        throw new AssertionError();
    }

    public List<Alarm> get() {
        return (List) emj.m10873f(this.cKb.ajp(), "Cannot return null from a non-@Nullable @Provides method");
    }

    public static emi<List<Alarm>> m7841b(cxa com_fossil_cxa) {
        return new cxd(com_fossil_cxa);
    }
}
