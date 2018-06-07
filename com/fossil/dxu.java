package com.fossil;

import android.content.Context;

public abstract class dxu {
    protected Context baD = null;

    protected dxu(Context context) {
        this.baD = context;
    }

    protected abstract String HI();

    protected abstract boolean Ja();

    public final void m10267a(dxr com_fossil_dxr) {
        if (com_fossil_dxr != null) {
            String com_fossil_dxr2 = com_fossil_dxr.toString();
            if (Ja()) {
                cg(dxw.cr(com_fossil_dxr2));
            }
        }
    }

    public final dxr aBz() {
        String lb = Ja() ? dxw.lb(HI()) : null;
        return lb != null ? dxr.kZ(lb) : null;
    }

    protected abstract void cg(String str);
}
