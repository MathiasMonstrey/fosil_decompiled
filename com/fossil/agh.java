package com.fossil;

import java.util.concurrent.atomic.AtomicReference;

@Deprecated
public final class agh {
    protected final AtomicReference<C1633b> aOS;
    private final int aOT;
    protected boolean aOU;
    protected final boolean aOV;
    protected final agh aPm = null;

    static final class C1632a {
    }

    static final class C1633b {
        public final int[] aPi;
        public final int aPn;
        public final agj[] aPo;
        public final C1632a[] aPp;
        public final int aPq;
        public final int aPr;
        public final int aPs;
        public final int count;

        public C1633b(int i, int i2, int[] iArr, agj[] com_fossil_agjArr, C1632a[] c1632aArr, int i3, int i4, int i5) {
            this.count = i;
            this.aPn = i2;
            this.aPi = iArr;
            this.aPo = com_fossil_agjArr;
            this.aPp = c1632aArr;
            this.aPq = i3;
            this.aPr = i4;
            this.aPs = i5;
        }
    }

    private agh(int i, boolean z, int i2, boolean z2) {
        int i3 = 16;
        this.aOT = i2;
        this.aOU = z;
        this.aOV = z2;
        if (i < 16) {
            i = 16;
        } else if (((i - 1) & i) != 0) {
            while (i3 < i) {
                i3 += i3;
            }
            i = i3;
        }
        this.aOS = new AtomicReference(gr(i));
    }

    private C1633b gr(int i) {
        return new C1633b(0, i - 1, new int[i], new agj[i], null, 0, 0, 0);
    }

    public static agh CM() {
        long currentTimeMillis = System.currentTimeMillis();
        return gs((((int) (currentTimeMillis >>> 32)) + ((int) currentTimeMillis)) | 1);
    }

    protected static agh gs(int i) {
        return new agh(64, true, i, true);
    }
}
