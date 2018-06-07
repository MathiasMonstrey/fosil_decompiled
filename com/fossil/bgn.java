package com.fossil;

public final class bgn<L> {
    private final L biy;
    private final String buB;

    bgn(L l, String str) {
        this.biy = l;
        this.buB = str;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof bgn)) {
            return false;
        }
        bgn com_fossil_bgn = (bgn) obj;
        return this.biy == com_fossil_bgn.biy && this.buB.equals(com_fossil_bgn.buB);
    }

    public final int hashCode() {
        return (System.identityHashCode(this.biy) * 31) + this.buB.hashCode();
    }
}
