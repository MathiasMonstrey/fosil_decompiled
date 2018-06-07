package com.fossil;

import com.facebook.internal.NativeProtocol;
import com.fasterxml.jackson.core.JsonFactory.Feature;
import com.fasterxml.jackson.core.util.InternCache;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicReference;

public final class agg {
    protected final agg aOR;
    protected final AtomicReference<C1631a> aOS;
    private final int aOT;
    protected boolean aOU;
    protected final boolean aOV;
    protected int[] aOW;
    protected int aOX;
    protected int aOY;
    protected int aOZ;
    protected int aPa;
    protected int aPb;
    protected String[] aPc;
    protected int aPd;
    protected int aPe;
    private transient boolean aPf;
    private boolean aPg;

    static final class C1631a {
        public final int aPh;
        public final int[] aPi;
        public final String[] aPj;
        public final int aPk;
        public final int aPl;
        public final int count;
        public final int size;

        public C1631a(int i, int i2, int i3, int[] iArr, String[] strArr, int i4, int i5) {
            this.size = i;
            this.count = i2;
            this.aPh = i3;
            this.aPi = iArr;
            this.aPj = strArr;
            this.aPk = i4;
            this.aPl = i5;
        }

        public C1631a(agg com_fossil_agg) {
            this.size = com_fossil_agg.aOX;
            this.count = com_fossil_agg.aPb;
            this.aPh = com_fossil_agg.aPa;
            this.aPi = com_fossil_agg.aOW;
            this.aPj = com_fossil_agg.aPc;
            this.aPk = com_fossil_agg.aPd;
            this.aPl = com_fossil_agg.aPe;
        }

        public static C1631a gq(int i) {
            int i2 = i << 3;
            return new C1631a(i, 0, agg.gp(i), new int[i2], new String[(i << 1)], i2 - i, i2);
        }
    }

    private agg(int i, boolean z, int i2, boolean z2) {
        int i3 = 16;
        this.aOR = null;
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
        this.aOS = new AtomicReference(C1631a.gq(i));
    }

    private agg(agg com_fossil_agg, boolean z, int i, boolean z2, C1631a c1631a) {
        this.aOR = com_fossil_agg;
        this.aOT = i;
        this.aOU = z;
        this.aOV = z2;
        this.aOS = null;
        this.aPb = c1631a.count;
        this.aOX = c1631a.size;
        this.aOY = this.aOX << 2;
        this.aOZ = this.aOY + (this.aOY >> 1);
        this.aPa = c1631a.aPh;
        this.aOW = c1631a.aPi;
        this.aPc = c1631a.aPj;
        this.aPd = c1631a.aPk;
        this.aPe = c1631a.aPl;
        this.aPf = false;
        this.aPg = true;
    }

    public static agg CB() {
        long currentTimeMillis = System.currentTimeMillis();
        return gj((((int) (currentTimeMillis >>> 32)) + ((int) currentTimeMillis)) | 1);
    }

    protected static agg gj(int i) {
        return new agg(64, true, i, true);
    }

    public agg gk(int i) {
        return new agg(this, Feature.INTERN_FIELD_NAMES.enabledIn(i), this.aOT, Feature.FAIL_ON_SYMBOL_HASH_OVERFLOW.enabledIn(i), (C1631a) this.aOS.get());
    }

    public void release() {
        if (this.aOR != null && CC()) {
            this.aOR.m3299a(new C1631a(this));
            this.aPg = true;
        }
    }

    private void m3299a(C1631a c1631a) {
        int i = c1631a.count;
        C1631a c1631a2 = (C1631a) this.aOS.get();
        if (i != c1631a2.count) {
            if (i > 6000) {
                c1631a = C1631a.gq(64);
            }
            this.aOS.compareAndSet(c1631a2, c1631a);
        }
    }

    public boolean CC() {
        return !this.aPg;
    }

    public int CD() {
        int i = this.aOY;
        int i2 = 0;
        for (int i3 = 3; i3 < i; i3 += 4) {
            if (this.aOW[i3] != 0) {
                i2++;
            }
        }
        return i2;
    }

    public int CE() {
        int i = this.aOY + 3;
        int i2 = this.aOZ;
        int i3 = i;
        i = 0;
        for (int i4 = i3; i4 < i2; i4 += 4) {
            if (this.aOW[i4] != 0) {
                i++;
            }
        }
        return i;
    }

    public int CF() {
        int i = this.aOZ + 3;
        int i2 = this.aOX + i;
        int i3 = i;
        i = 0;
        for (int i4 = i3; i4 < i2; i4 += 4) {
            if (this.aOW[i4] != 0) {
                i++;
            }
        }
        return i;
    }

    public int CG() {
        return (this.aPd - CK()) >> 2;
    }

    public int CH() {
        int i = this.aOX << 3;
        int i2 = 0;
        for (int i3 = 3; i3 < i; i3 += 4) {
            if (this.aOW[i3] != 0) {
                i2++;
            }
        }
        return i2;
    }

    public String toString() {
        int CD = CD();
        int CE = CE();
        int CF = CF();
        int CG = CG();
        int CH = CH();
        return String.format("[%s: size=%d, hashSize=%d, %d/%d/%d/%d pri/sec/ter/spill (=%s), total:%d]", new Object[]{getClass().getName(), Integer.valueOf(this.aPb), Integer.valueOf(this.aOX), Integer.valueOf(CD), Integer.valueOf(CE), Integer.valueOf(CF), Integer.valueOf(CG), Integer.valueOf(CH), Integer.valueOf(((CD + CE) + CF) + CG), Integer.valueOf(CH)});
    }

    public String gl(int i) {
        int gm = gm(go(i));
        int[] iArr = this.aOW;
        int i2 = iArr[gm + 3];
        if (i2 == 1) {
            if (iArr[gm] == i) {
                return this.aPc[gm >> 2];
            }
        } else if (i2 == 0) {
            return null;
        }
        i2 = this.aOY + ((gm >> 3) << 2);
        int i3 = iArr[i2 + 3];
        if (i3 == 1) {
            if (iArr[i2] == i) {
                return this.aPc[i2 >> 2];
            }
        } else if (i3 == 0) {
            return null;
        }
        return bD(gm, i);
    }

    public String by(int i, int i2) {
        int gm = gm(bE(i, i2));
        int[] iArr = this.aOW;
        int i3 = iArr[gm + 3];
        if (i3 == 2) {
            if (i == iArr[gm] && i2 == iArr[gm + 1]) {
                return this.aPc[gm >> 2];
            }
        } else if (i3 == 0) {
            return null;
        }
        i3 = this.aOY + ((gm >> 3) << 2);
        int i4 = iArr[i3 + 3];
        if (i4 == 2) {
            if (i == iArr[i3] && i2 == iArr[i3 + 1]) {
                return this.aPc[i3 >> 2];
            }
        } else if (i4 == 0) {
            return null;
        }
        return m3304y(gm, i, i2);
    }

    public String m3308x(int i, int i2, int i3) {
        int gm = gm(m3309z(i, i2, i3));
        int[] iArr = this.aOW;
        int i4 = iArr[gm + 3];
        if (i4 == 3) {
            if (i == iArr[gm] && iArr[gm + 1] == i2 && iArr[gm + 2] == i3) {
                return this.aPc[gm >> 2];
            }
        } else if (i4 == 0) {
            return null;
        }
        i4 = this.aOY + ((gm >> 3) << 2);
        int i5 = iArr[i4 + 3];
        if (i5 == 3) {
            if (i == iArr[i4] && iArr[i4 + 1] == i2 && iArr[i4 + 2] == i3) {
                return this.aPc[i4 >> 2];
            }
        } else if (i5 == 0) {
            return null;
        }
        return m3303s(gm, i, i2, i3);
    }

    public String m3306c(int[] iArr, int i) {
        if (i >= 4) {
            int e = m3307e(iArr, i);
            int gm = gm(e);
            int[] iArr2 = this.aOW;
            int i2 = iArr2[gm + 3];
            if (e == iArr2[gm] && i2 == i && m3301e(iArr, i, iArr2[gm + 1])) {
                return this.aPc[gm >> 2];
            }
            if (i2 == 0) {
                return null;
            }
            int i3 = this.aOY + ((gm >> 3) << 2);
            int i4 = iArr2[i3 + 3];
            if (e == iArr2[i3] && i4 == i && m3301e(iArr, i, iArr2[i3 + 1])) {
                return this.aPc[i3 >> 2];
            }
            if (i2 != 0) {
                return m3298a(gm, e, iArr, i);
            }
            return null;
        } else if (i == 3) {
            return m3308x(iArr[0], iArr[1], iArr[2]);
        } else {
            if (i == 2) {
                return by(iArr[0], iArr[1]);
            }
            return gl(iArr[0]);
        }
    }

    private final int gm(int i) {
        return ((this.aOX - 1) & i) << 2;
    }

    private String bD(int i, int i2) {
        int i3 = this.aOZ + ((i >> (this.aPa + 2)) << this.aPa);
        int[] iArr = this.aOW;
        int i4 = (1 << this.aPa) + i3;
        while (i3 < i4) {
            int i5 = iArr[i3 + 3];
            if (i2 == iArr[i3] && 1 == i5) {
                return this.aPc[i3 >> 2];
            }
            if (i5 == 0) {
                return null;
            }
            i3 += 4;
        }
        i3 = CK();
        while (i3 < this.aPd) {
            if (i2 == iArr[i3] && 1 == iArr[i3 + 3]) {
                return this.aPc[i3 >> 2];
            }
            i3 += 4;
        }
        return null;
    }

    private String m3304y(int i, int i2, int i3) {
        int i4 = this.aOZ + ((i >> (this.aPa + 2)) << this.aPa);
        int[] iArr = this.aOW;
        int i5 = (1 << this.aPa) + i4;
        while (i4 < i5) {
            int i6 = iArr[i4 + 3];
            if (i2 == iArr[i4] && i3 == iArr[i4 + 1] && 2 == i6) {
                return this.aPc[i4 >> 2];
            }
            if (i6 == 0) {
                return null;
            }
            i4 += 4;
        }
        i4 = CK();
        while (i4 < this.aPd) {
            if (i2 == iArr[i4] && i3 == iArr[i4 + 1] && 2 == iArr[i4 + 3]) {
                return this.aPc[i4 >> 2];
            }
            i4 += 4;
        }
        return null;
    }

    private String m3303s(int i, int i2, int i3, int i4) {
        int i5 = this.aOZ + ((i >> (this.aPa + 2)) << this.aPa);
        int[] iArr = this.aOW;
        int i6 = (1 << this.aPa) + i5;
        while (i5 < i6) {
            int i7 = iArr[i5 + 3];
            if (i2 == iArr[i5] && i3 == iArr[i5 + 1] && i4 == iArr[i5 + 2] && 3 == i7) {
                return this.aPc[i5 >> 2];
            }
            if (i7 == 0) {
                return null;
            }
            i5 += 4;
        }
        i5 = CK();
        while (i5 < this.aPd) {
            if (i2 == iArr[i5] && i3 == iArr[i5 + 1] && i4 == iArr[i5 + 2] && 3 == iArr[i5 + 3]) {
                return this.aPc[i5 >> 2];
            }
            i5 += 4;
        }
        return null;
    }

    private String m3298a(int i, int i2, int[] iArr, int i3) {
        int i4 = this.aOZ + ((i >> (this.aPa + 2)) << this.aPa);
        int[] iArr2 = this.aOW;
        int i5 = (1 << this.aPa) + i4;
        while (i4 < i5) {
            int i6 = iArr2[i4 + 3];
            if (i2 == iArr2[i4] && i3 == i6) {
                return this.aPc[i4 >> 2];
            }
            if (i6 == 0) {
                return null;
            }
            i4 += 4;
        }
        i4 = CK();
        while (i4 < this.aPd) {
            if (i2 == iArr2[i4] && i3 == iArr2[i4 + 3] && m3301e(iArr, i3, iArr2[i4 + 1])) {
                return this.aPc[i4 >> 2];
            }
            i4 += 4;
        }
        return null;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean m3301e(int[] r8, int r9, int r10) {
        /*
        r7 = this;
        r1 = 1;
        r2 = 0;
        r4 = r7.aOW;
        switch(r9) {
            case 4: goto L_0x006a;
            case 5: goto L_0x0068;
            case 6: goto L_0x0066;
            case 7: goto L_0x0064;
            case 8: goto L_0x000c;
            default: goto L_0x0007;
        };
    L_0x0007:
        r2 = r7.m3302f(r8, r9, r10);
    L_0x000b:
        return r2;
    L_0x000c:
        r3 = r8[r2];
        r0 = r10 + 1;
        r5 = r4[r10];
        if (r3 != r5) goto L_0x000b;
    L_0x0014:
        r10 = r0;
        r0 = r1;
    L_0x0016:
        r3 = r0 + 1;
        r5 = r8[r0];
        r0 = r10 + 1;
        r6 = r4[r10];
        if (r5 != r6) goto L_0x000b;
    L_0x0020:
        r10 = r0;
        r0 = r3;
    L_0x0022:
        r3 = r0 + 1;
        r5 = r8[r0];
        r0 = r10 + 1;
        r6 = r4[r10];
        if (r5 != r6) goto L_0x000b;
    L_0x002c:
        r10 = r0;
        r0 = r3;
    L_0x002e:
        r3 = r0 + 1;
        r5 = r8[r0];
        r0 = r10 + 1;
        r6 = r4[r10];
        if (r5 != r6) goto L_0x000b;
    L_0x0038:
        r10 = r0;
        r0 = r3;
    L_0x003a:
        r3 = r0 + 1;
        r0 = r8[r0];
        r5 = r10 + 1;
        r6 = r4[r10];
        if (r0 != r6) goto L_0x000b;
    L_0x0044:
        r0 = r3 + 1;
        r3 = r8[r3];
        r6 = r5 + 1;
        r5 = r4[r5];
        if (r3 != r5) goto L_0x000b;
    L_0x004e:
        r3 = r0 + 1;
        r0 = r8[r0];
        r5 = r6 + 1;
        r6 = r4[r6];
        if (r0 != r6) goto L_0x000b;
    L_0x0058:
        r0 = r3 + 1;
        r0 = r8[r3];
        r3 = r5 + 1;
        r3 = r4[r5];
        if (r0 != r3) goto L_0x000b;
    L_0x0062:
        r2 = r1;
        goto L_0x000b;
    L_0x0064:
        r0 = r2;
        goto L_0x0016;
    L_0x0066:
        r0 = r2;
        goto L_0x0022;
    L_0x0068:
        r0 = r2;
        goto L_0x002e;
    L_0x006a:
        r0 = r2;
        goto L_0x003a;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fossil.agg.e(int[], int, int):boolean");
    }

    private boolean m3302f(int[] iArr, int i, int i2) {
        int i3 = 0;
        while (true) {
            int i4 = i3 + 1;
            int i5 = iArr[i3];
            i3 = i2 + 1;
            if (i5 != this.aOW[i2]) {
                return false;
            }
            if (i4 >= i) {
                return true;
            }
            i2 = i3;
            i3 = i4;
        }
    }

    public String m3305a(String str, int[] iArr, int i) {
        int gn;
        CJ();
        if (this.aOU) {
            str = InternCache.instance.intern(str);
        }
        switch (i) {
            case 1:
                gn = gn(go(iArr[0]));
                this.aOW[gn] = iArr[0];
                this.aOW[gn + 3] = 1;
                break;
            case 2:
                gn = gn(bE(iArr[0], iArr[1]));
                this.aOW[gn] = iArr[0];
                this.aOW[gn + 1] = iArr[1];
                this.aOW[gn + 3] = 2;
                break;
            case 3:
                gn = gn(m3309z(iArr[0], iArr[1], iArr[2]));
                this.aOW[gn] = iArr[0];
                this.aOW[gn + 1] = iArr[1];
                this.aOW[gn + 2] = iArr[2];
                this.aOW[gn + 3] = 3;
                break;
            default:
                int e = m3307e(iArr, i);
                gn = gn(e);
                this.aOW[gn] = e;
                this.aOW[gn + 1] = m3300d(iArr, i);
                this.aOW[gn + 3] = i;
                break;
        }
        this.aPc[gn >> 2] = str;
        this.aPb++;
        CI();
        return str;
    }

    private void CI() {
        if (this.aPb <= (this.aOX >> 1)) {
            return;
        }
        if (((this.aPd - CK()) >> 2) > ((this.aPb + 1) >> 7) || ((double) this.aPb) > ((double) this.aOX) * 0.8d) {
            this.aPf = true;
        }
    }

    private void CJ() {
        if (this.aPg) {
            this.aOW = Arrays.copyOf(this.aOW, this.aOW.length);
            this.aPc = (String[]) Arrays.copyOf(this.aPc, this.aPc.length);
            this.aPg = false;
        }
        if (this.aPf) {
            rehash();
        }
    }

    private int gn(int i) {
        int gm = gm(i);
        int[] iArr = this.aOW;
        if (iArr[gm + 3] == 0) {
            return gm;
        }
        int i2 = this.aOY + ((gm >> 3) << 2);
        if (iArr[i2 + 3] == 0) {
            return i2;
        }
        gm = ((gm >> (this.aPa + 2)) << this.aPa) + this.aOZ;
        i2 = (1 << this.aPa) + gm;
        while (gm < i2) {
            if (iArr[gm + 3] == 0) {
                return gm;
            }
            gm += 4;
        }
        gm = this.aPd;
        this.aPd += 4;
        if (this.aPd < (this.aOX << 3)) {
            return gm;
        }
        if (this.aOV) {
            CL();
        }
        this.aPf = true;
        return gm;
    }

    private int m3300d(int[] iArr, int i) {
        int i2 = this.aPe;
        if (i2 + i > this.aOW.length) {
            int length = (i2 + i) - this.aOW.length;
            int min = Math.min(4096, this.aOX);
            this.aOW = Arrays.copyOf(this.aOW, Math.max(length, min) + this.aOW.length);
        }
        System.arraycopy(iArr, 0, this.aOW, i2, i);
        this.aPe += i;
        return i2;
    }

    public int go(int i) {
        int i2 = this.aOT ^ i;
        i2 += i2 >>> 16;
        i2 ^= i2 << 3;
        return i2 + (i2 >>> 12);
    }

    public int bE(int i, int i2) {
        int i3 = (i >>> 15) + i;
        i3 = ((i3 ^ (i3 >>> 9)) + (i2 * 33)) ^ this.aOT;
        i3 += i3 >>> 16;
        i3 ^= i3 >>> 4;
        return i3 + (i3 << 3);
    }

    public int m3309z(int i, int i2, int i3) {
        int i4 = this.aOT ^ i;
        i4 = (((i4 + (i4 >>> 9)) * 31) + i2) * 33;
        i4 = (i4 + (i4 >>> 15)) ^ i3;
        i4 += i4 >>> 4;
        i4 += i4 >>> 15;
        return i4 ^ (i4 << 9);
    }

    public int m3307e(int[] iArr, int i) {
        if (i < 4) {
            throw new IllegalArgumentException();
        }
        int i2 = iArr[0] ^ this.aOT;
        i2 = (i2 + (i2 >>> 9)) + iArr[1];
        i2 = ((i2 + (i2 >>> 15)) * 33) ^ iArr[2];
        int i3 = (i2 >>> 4) + i2;
        for (i2 = 3; i2 < i; i2++) {
            int i4 = iArr[i2];
            i3 += i4 ^ (i4 >> 21);
        }
        i2 = 65599 * i3;
        i2 += i2 >>> 19;
        return i2 ^ (i2 << 5);
    }

    private void rehash() {
        this.aPf = false;
        this.aPg = false;
        Object obj = this.aOW;
        String[] strArr = this.aPc;
        int i = this.aOX;
        int i2 = this.aPb;
        int i3 = i + i;
        int i4 = this.aPd;
        if (i3 > NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST) {
            aH(true);
            return;
        }
        this.aOW = new int[((i << 3) + obj.length)];
        this.aOX = i3;
        this.aOY = i3 << 2;
        this.aOZ = this.aOY + (this.aOY >> 1);
        this.aPa = gp(i3);
        this.aPc = new String[(strArr.length << 1)];
        aH(false);
        int[] iArr = new int[16];
        i3 = 0;
        for (int i5 = 0; i5 < i4; i5 += 4) {
            int i6 = obj[i5 + 3];
            if (i6 != 0) {
                i3++;
                String str = strArr[i5 >> 2];
                switch (i6) {
                    case 1:
                        iArr[0] = obj[i5];
                        m3305a(str, iArr, 1);
                        break;
                    case 2:
                        iArr[0] = obj[i5];
                        iArr[1] = obj[i5 + 1];
                        m3305a(str, iArr, 2);
                        break;
                    case 3:
                        iArr[0] = obj[i5];
                        iArr[1] = obj[i5 + 1];
                        iArr[2] = obj[i5 + 2];
                        m3305a(str, iArr, 3);
                        break;
                    default:
                        if (i6 > iArr.length) {
                            iArr = new int[i6];
                        }
                        System.arraycopy(obj, obj[i5 + 1], iArr, 0, i6);
                        m3305a(str, iArr, i6);
                        break;
                }
            }
        }
        if (i3 != i2) {
            throw new IllegalStateException("Failed rehash(): old count=" + i2 + ", copyCount=" + i3);
        }
    }

    private void aH(boolean z) {
        this.aPb = 0;
        this.aPd = CK();
        this.aPe = this.aOX << 3;
        if (z) {
            Arrays.fill(this.aOW, 0);
            Arrays.fill(this.aPc, null);
        }
    }

    private final int CK() {
        int i = this.aOX;
        return (i << 3) - i;
    }

    protected void CL() {
        if (this.aOX > 1024) {
            throw new IllegalStateException("Spill-over slots in symbol table with " + this.aPb + " entries, hash area of " + this.aOX + " slots is now full (all " + (this.aOX >> 3) + " slots -- suspect a DoS attack based on hash collisions." + " You can disable the check via `JsonFactory.Feature.FAIL_ON_SYMBOL_HASH_OVERFLOW`");
        }
    }

    static int gp(int i) {
        int i2 = i >> 2;
        if (i2 < 64) {
            return 4;
        }
        if (i2 <= 256) {
            return 5;
        }
        if (i2 <= 1024) {
            return 6;
        }
        return 7;
    }
}
