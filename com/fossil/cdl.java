package com.fossil;

import java.util.Arrays;

public class cdl<K> extends ccv<K> {
    private transient int[] bNR;
    transient long[] bNS;
    private transient float bNT;
    private transient int threshold;

    public static <K> cdl<K> VA() {
        return new cdl();
    }

    public static <K> cdl<K> iH(int i) {
        return new cdl(i);
    }

    cdl() {
        m6023h(3, 1.0f);
    }

    public cdl(ccv<K> com_fossil_ccv_K) {
        m6023h(com_fossil_ccv_K.size(), 1.0f);
        int UB = com_fossil_ccv_K.UB();
        while (UB != -1) {
            mo1640u(com_fossil_ccv_K.is(UB), com_fossil_ccv_K.getValue(UB));
            UB = com_fossil_ccv_K.it(UB);
        }
    }

    cdl(int i) {
        this(i, 1.0f);
    }

    cdl(int i, float f) {
        m6023h(i, f);
    }

    void m6023h(int i, float f) {
        boolean z = false;
        cco.m5991d(i >= 0, "Initial capacity must be non-negative");
        if (f > 0.0f) {
            z = true;
        }
        cco.m5991d(z, "Illegal load factor");
        int b = cdf.m6007b(i, (double) f);
        this.bNR = iI(b);
        this.bNT = f;
        this.keys = new Object[i];
        this.bMm = new int[i];
        this.bNS = iJ(i);
        this.threshold = Math.max(1, (int) (((float) b) * f));
    }

    private static int[] iI(int i) {
        int[] iArr = new int[i];
        Arrays.fill(iArr, -1);
        return iArr;
    }

    private static long[] iJ(int i) {
        long[] jArr = new long[i];
        Arrays.fill(jArr, -1);
        return jArr;
    }

    private int VB() {
        return this.bNR.length - 1;
    }

    private static int au(long j) {
        return (int) (j >>> 32);
    }

    private static int av(long j) {
        return (int) j;
    }

    private static long m6021b(long j, int i) {
        return (-4294967296L & j) | (4294967295L & ((long) i));
    }

    public int mo1640u(K k, int i) {
        ccw.m5999o(i, "count");
        long[] jArr = this.bNS;
        Object[] objArr = this.keys;
        int[] iArr = this.bMm;
        int cm = cdf.cm(k);
        int VB = cm & VB();
        int i2 = this.size;
        int i3 = this.bNR[VB];
        if (i3 == -1) {
            this.bNR[VB] = i2;
        } else {
            long j;
            while (true) {
                j = jArr[i3];
                if (au(j) == cm && ccn.equal(k, objArr[i3])) {
                    VB = iArr[i3];
                    iArr[i3] = i;
                    return VB;
                }
                VB = av(j);
                if (VB == -1) {
                    break;
                }
                i3 = VB;
            }
            jArr[i3] = m6021b(j, i2);
        }
        if (i2 == Integer.MAX_VALUE) {
            throw new IllegalStateException("Cannot contain more than Integer.MAX_VALUE elements!");
        }
        i3 = i2 + 1;
        iK(i3);
        m6022a(i2, k, i, cm);
        this.size = i3;
        if (i2 >= this.threshold) {
            iM(this.bNR.length * 2);
        }
        this.modCount++;
        return 0;
    }

    void m6022a(int i, K k, int i2, int i3) {
        this.bNS[i] = (((long) i3) << 32) | 4294967295L;
        this.keys[i] = k;
        this.bMm[i] = i2;
    }

    private void iK(int i) {
        int length = this.bNS.length;
        if (i > length) {
            int max = Math.max(1, length >>> 1) + length;
            if (max < 0) {
                max = Integer.MAX_VALUE;
            }
            if (max != length) {
                iL(max);
            }
        }
    }

    void iL(int i) {
        this.keys = Arrays.copyOf(this.keys, i);
        this.bMm = Arrays.copyOf(this.bMm, i);
        long[] jArr = this.bNS;
        int length = jArr.length;
        jArr = Arrays.copyOf(jArr, i);
        if (i > length) {
            Arrays.fill(jArr, length, i, -1);
        }
        this.bNS = jArr;
    }

    private void iM(int i) {
        if (this.bNR.length >= 1073741824) {
            this.threshold = Integer.MAX_VALUE;
            return;
        }
        int i2 = ((int) (((float) i) * this.bNT)) + 1;
        int[] iI = iI(i);
        long[] jArr = this.bNS;
        int length = iI.length - 1;
        for (int i3 = 0; i3 < this.size; i3++) {
            int au = au(jArr[i3]);
            int i4 = au & length;
            int i5 = iI[i4];
            iI[i4] = i3;
            jArr[i3] = (((long) i5) & 4294967295L) | (((long) au) << 32);
        }
        this.threshold = i2;
        this.bNR = iI;
    }

    int indexOf(Object obj) {
        int cm = cdf.cm(obj);
        int i = this.bNR[VB() & cm];
        while (i != -1) {
            long j = this.bNS[i];
            if (au(j) == cm && ccn.equal(obj, this.keys[i])) {
                return i;
            }
            i = av(j);
        }
        return -1;
    }

    public int get(Object obj) {
        int indexOf = indexOf(obj);
        return indexOf == -1 ? 0 : this.bMm[indexOf];
    }
}
