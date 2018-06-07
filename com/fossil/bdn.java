package com.fossil;

import com.fossil.ats.C1879a;

public final class bdn<O extends C1879a> {
    private final ats<O> bfV;
    private final O bfW;
    private final boolean brh = true;
    private final int bri;

    private bdn(ats<O> com_fossil_ats_O) {
        this.bfV = com_fossil_ats_O;
        this.bfW = null;
        this.bri = System.identityHashCode(this);
    }

    public static <O extends C1879a> bdn<O> m4899e(ats<O> com_fossil_ats_O) {
        return new bdn(com_fossil_ats_O);
    }

    public final String MY() {
        return this.bfV.getName();
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof bdn)) {
            return false;
        }
        bdn com_fossil_bdn = (bdn) obj;
        return !this.brh && !com_fossil_bdn.brh && avx.equal(this.bfV, com_fossil_bdn.bfV) && avx.equal(this.bfW, com_fossil_bdn.bfW);
    }

    public final int hashCode() {
        return this.bri;
    }
}
