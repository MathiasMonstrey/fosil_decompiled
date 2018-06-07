package com.fossil;

import com.fossil.ats.C1879a.C1882c;
import java.util.Arrays;
import java.util.Locale;

public final class bve implements C1882c {
    public final String bGT;
    public final String bGU;
    public final int bGV;
    public final Locale bGW;
    public final String bwJ;

    public static class C1963a {
        private int bGV = 0;

        public bve SL() {
            return new bve();
        }
    }

    private bve(C1963a c1963a) {
        this.bGT = null;
        this.bGU = null;
        this.bGV = 0;
        this.bwJ = null;
        this.bGW = null;
    }

    public final boolean equals(Object obj) {
        return (obj instanceof bve) && avx.equal(null, null) && avx.equal(null, null) && avx.equal(Integer.valueOf(0), Integer.valueOf(0)) && avx.equal(null, null) && avx.equal(null, null);
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{null, null, Integer.valueOf(0), null, null});
    }
}
