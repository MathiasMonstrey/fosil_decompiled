package com.fossil;

import com.google.android.gms.common.data.DataHolder;
import java.util.Arrays;

public class aul {
    protected final DataHolder bgD;
    protected int bgT;
    private int bgU;

    public aul(DataHolder dataHolder, int i) {
        this.bgD = (DataHolder) awa.bO(dataHolder);
        hu(i);
    }

    public final boolean da(String str) {
        return this.bgD.da(str);
    }

    protected final boolean db(String str) {
        return this.bgD.o(str, this.bgT, this.bgU);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof aul)) {
            return false;
        }
        aul com_fossil_aul = (aul) obj;
        return avx.equal(Integer.valueOf(com_fossil_aul.bgT), Integer.valueOf(this.bgT)) && avx.equal(Integer.valueOf(com_fossil_aul.bgU), Integer.valueOf(this.bgU)) && com_fossil_aul.bgD == this.bgD;
    }

    protected final boolean getBoolean(String str) {
        return this.bgD.l(str, this.bgT, this.bgU);
    }

    protected final byte[] getByteArray(String str) {
        return this.bgD.n(str, this.bgT, this.bgU);
    }

    protected final float getFloat(String str) {
        return this.bgD.m(str, this.bgT, this.bgU);
    }

    protected final int getInteger(String str) {
        return this.bgD.j(str, this.bgT, this.bgU);
    }

    protected final String getString(String str) {
        return this.bgD.k(str, this.bgT, this.bgU);
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(this.bgT), Integer.valueOf(this.bgU), this.bgD});
    }

    protected final void hu(int i) {
        boolean z = i >= 0 && i < this.bgD.bgJ;
        awa.aX(z);
        this.bgT = i;
        this.bgU = this.bgD.hs(this.bgT);
    }
}
