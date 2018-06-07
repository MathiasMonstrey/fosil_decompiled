package com.fossil;

import android.support.v8.renderscript.Allocation;
import java.util.Arrays;

public final class dwk {
    private final int[] bMm = new int[10];
    private int dyS;
    private int dyT;
    private int dyU;

    void clear() {
        this.dyU = 0;
        this.dyT = 0;
        this.dyS = 0;
        Arrays.fill(this.bMm, 0);
    }

    dwk m10148J(int i, int i2, int i3) {
        if (i < this.bMm.length) {
            int i4 = 1 << i;
            this.dyS |= i4;
            if ((i2 & 1) != 0) {
                this.dyT |= i4;
            } else {
                this.dyT &= i4 ^ -1;
            }
            if ((i2 & 2) != 0) {
                this.dyU = i4 | this.dyU;
            } else {
                this.dyU = (i4 ^ -1) & this.dyU;
            }
            this.bMm[i] = i3;
        }
        return this;
    }

    boolean isSet(int i) {
        if (((1 << i) & this.dyS) != 0) {
            return true;
        }
        return false;
    }

    int get(int i) {
        return this.bMm[i];
    }

    int mP(int i) {
        int i2 = 0;
        if (mT(i)) {
            i2 = 2;
        }
        if (mS(i)) {
            return i2 | 1;
        }
        return i2;
    }

    int size() {
        return Integer.bitCount(this.dyS);
    }

    int aAB() {
        return (2 & this.dyS) != 0 ? this.bMm[1] : -1;
    }

    int mQ(int i) {
        return (32 & this.dyS) != 0 ? this.bMm[5] : i;
    }

    int mR(int i) {
        return (Allocation.USAGE_SHARED & this.dyS) != 0 ? this.bMm[7] : i;
    }

    boolean mS(int i) {
        if (((1 << i) & this.dyT) != 0) {
            return true;
        }
        return false;
    }

    boolean mT(int i) {
        if (((1 << i) & this.dyU) != 0) {
            return true;
        }
        return false;
    }

    void m10149d(dwk com_fossil_dwk) {
        for (int i = 0; i < 10; i++) {
            if (com_fossil_dwk.isSet(i)) {
                m10148J(i, com_fossil_dwk.mP(i), com_fossil_dwk.get(i));
            }
        }
    }
}
