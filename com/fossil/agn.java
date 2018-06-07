package com.fossil;

import com.misfit.frameworks.common.constants.MFNetworkReturnCode;
import java.io.OutputStream;
import java.util.Iterator;
import java.util.LinkedList;

public final class agn extends OutputStream {
    public static final byte[] aPJ = new byte[0];
    private final agm aNi;
    private final LinkedList<byte[]> aPK;
    private int aPL;
    private byte[] aPM;
    private int aPN;

    public agn() {
        this(null);
    }

    public agn(agm com_fossil_agm) {
        this(com_fossil_agm, MFNetworkReturnCode.INTERNAL_SERVER_ERROR);
    }

    public agn(int i) {
        this(null, i);
    }

    public agn(agm com_fossil_agm, int i) {
        this.aPK = new LinkedList();
        this.aNi = com_fossil_agm;
        this.aPM = com_fossil_agm == null ? new byte[i] : com_fossil_agm.gA(2);
    }

    public void reset() {
        this.aPL = 0;
        this.aPN = 0;
        if (!this.aPK.isEmpty()) {
            this.aPK.clear();
        }
    }

    public void release() {
        reset();
        if (this.aNi != null && this.aPM != null) {
            this.aNi.m3317b(2, this.aPM);
            this.aPM = null;
        }
    }

    public void append(int i) {
        if (this.aPN >= this.aPM.length) {
            CU();
        }
        byte[] bArr = this.aPM;
        int i2 = this.aPN;
        this.aPN = i2 + 1;
        bArr[i2] = (byte) i;
    }

    public void gG(int i) {
        if (this.aPN + 1 < this.aPM.length) {
            byte[] bArr = this.aPM;
            int i2 = this.aPN;
            this.aPN = i2 + 1;
            bArr[i2] = (byte) (i >> 8);
            bArr = this.aPM;
            i2 = this.aPN;
            this.aPN = i2 + 1;
            bArr[i2] = (byte) i;
            return;
        }
        append(i >> 8);
        append(i);
    }

    public void gH(int i) {
        if (this.aPN + 2 < this.aPM.length) {
            byte[] bArr = this.aPM;
            int i2 = this.aPN;
            this.aPN = i2 + 1;
            bArr[i2] = (byte) (i >> 16);
            bArr = this.aPM;
            i2 = this.aPN;
            this.aPN = i2 + 1;
            bArr[i2] = (byte) (i >> 8);
            bArr = this.aPM;
            i2 = this.aPN;
            this.aPN = i2 + 1;
            bArr[i2] = (byte) i;
            return;
        }
        append(i >> 16);
        append(i >> 8);
        append(i);
    }

    public byte[] toByteArray() {
        int i = this.aPL + this.aPN;
        if (i == 0) {
            return aPJ;
        }
        Object obj = new byte[i];
        Iterator it = this.aPK.iterator();
        int i2 = 0;
        while (it.hasNext()) {
            byte[] bArr = (byte[]) it.next();
            int length = bArr.length;
            System.arraycopy(bArr, 0, obj, i2, length);
            i2 += length;
        }
        System.arraycopy(this.aPM, 0, obj, i2, this.aPN);
        int i3 = this.aPN + i2;
        if (i3 != i) {
            throw new RuntimeException("Internal error: total len assumed to be " + i + ", copied " + i3 + " bytes");
        }
        if (!this.aPK.isEmpty()) {
            reset();
        }
        return obj;
    }

    public byte[] CQ() {
        reset();
        return this.aPM;
    }

    public byte[] CR() {
        CU();
        return this.aPM;
    }

    public byte[] gI(int i) {
        this.aPN = i;
        return toByteArray();
    }

    public byte[] CS() {
        return this.aPM;
    }

    public void gJ(int i) {
        this.aPN = i;
    }

    public int CT() {
        return this.aPN;
    }

    public void write(byte[] bArr) {
        write(bArr, 0, bArr.length);
    }

    public void write(byte[] bArr, int i, int i2) {
        while (true) {
            int min = Math.min(this.aPM.length - this.aPN, i2);
            if (min > 0) {
                System.arraycopy(bArr, i, this.aPM, this.aPN, min);
                i += min;
                this.aPN += min;
                i2 -= min;
            }
            if (i2 > 0) {
                CU();
            } else {
                return;
            }
        }
    }

    public void write(int i) {
        append(i);
    }

    public void close() {
    }

    public void flush() {
    }

    private void CU() {
        int i = 262144;
        this.aPL += this.aPM.length;
        int max = Math.max(this.aPL >> 1, 1000);
        if (max <= 262144) {
            i = max;
        }
        this.aPK.add(this.aPM);
        this.aPM = new byte[i];
        this.aPN = 0;
    }
}
