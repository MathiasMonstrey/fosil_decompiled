package com.fossil;

import com.misfit.frameworks.common.constants.MFNetworkReturnCode;

public class agm {
    private static final int[] aPF = new int[]{MFNetworkReturnCode.REQUEST_NOT_FOUND, MFNetworkReturnCode.REQUEST_NOT_FOUND, 2000, 2000};
    private static final int[] aPG = new int[]{4000, 4000, MFNetworkReturnCode.RESPONSE_OK, MFNetworkReturnCode.RESPONSE_OK};
    protected final byte[][] aPH;
    protected final char[][] aPI;

    public agm() {
        this(4, 4);
    }

    protected agm(int i, int i2) {
        this.aPH = new byte[i][];
        this.aPI = new char[i2][];
    }

    public final byte[] gA(int i) {
        return bF(i, 0);
    }

    public byte[] bF(int i, int i2) {
        int gC = gC(i);
        if (i2 < gC) {
            i2 = gC;
        }
        byte[] bArr = this.aPH[i];
        if (bArr == null || bArr.length < i2) {
            return gE(i2);
        }
        this.aPH[i] = null;
        return bArr;
    }

    public final void m3317b(int i, byte[] bArr) {
        this.aPH[i] = bArr;
    }

    public final char[] gB(int i) {
        return bG(i, 0);
    }

    public char[] bG(int i, int i2) {
        int gD = gD(i);
        if (i2 < gD) {
            i2 = gD;
        }
        char[] cArr = this.aPI[i];
        if (cArr == null || cArr.length < i2) {
            return gF(i2);
        }
        this.aPI[i] = null;
        return cArr;
    }

    public void m3318c(int i, char[] cArr) {
        this.aPI[i] = cArr;
    }

    protected int gC(int i) {
        return aPF[i];
    }

    protected int gD(int i) {
        return aPG[i];
    }

    protected byte[] gE(int i) {
        return new byte[i];
    }

    protected char[] gF(int i) {
        return new char[i];
    }
}
