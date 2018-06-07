package com.fossil;

import java.util.Iterator;

public class esn implements Iterable<Integer> {
    public static final C3535a dSS = new C3535a();
    private final int dSP;
    private final int dSQ;
    private final int dSR;

    public static final class C3535a {
        private C3535a() {
        }

        public final esn m11130N(int i, int i2, int i3) {
            return new esn(i, i2, i3);
        }
    }

    public /* synthetic */ Iterator iterator() {
        return aHa();
    }

    public esn(int i, int i2, int i3) {
        if (i3 == 0) {
            throw new IllegalArgumentException("Step must be non-zero");
        }
        this.dSP = i;
        this.dSQ = esj.m11124M(i, i2, i3);
        this.dSR = i3;
    }

    public final int aGX() {
        return this.dSP;
    }

    public final int aGY() {
        return this.dSQ;
    }

    public final int aGZ() {
        return this.dSR;
    }

    public esc aHa() {
        return new eso(this.dSP, this.dSQ, this.dSR);
    }

    public boolean isEmpty() {
        return this.dSR > 0 ? this.dSP > this.dSQ : this.dSP < this.dSQ;
    }

    public boolean equals(Object obj) {
        return (obj instanceof esn) && ((isEmpty() && ((esn) obj).isEmpty()) || (this.dSP == ((esn) obj).dSP && this.dSQ == ((esn) obj).dSQ && this.dSR == ((esn) obj).dSR));
    }

    public int hashCode() {
        return isEmpty() ? -1 : (((this.dSP * 31) + this.dSQ) * 31) + this.dSR;
    }

    public String toString() {
        return this.dSR > 0 ? "" + this.dSP + ".." + this.dSQ + " step " + this.dSR : "" + this.dSP + " downTo " + this.dSQ + " step " + (-this.dSR);
    }
}
