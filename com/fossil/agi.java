package com.fossil;

import com.facebook.internal.NativeProtocol;
import com.fasterxml.jackson.core.JsonFactory.Feature;
import com.fasterxml.jackson.core.util.InternCache;
import java.util.Arrays;
import java.util.BitSet;

public final class agi {
    static final agi aPt = new agi();
    protected int _size;
    private final int aOt;
    protected int aPA;
    protected int aPB;
    protected boolean aPC;
    protected BitSet aPD;
    protected agi aPu;
    protected final int aPv;
    protected boolean aPw;
    protected String[] aPx;
    protected C1634a[] aPy;
    protected int aPz;

    static final class C1634a {
        public final String aJU;
        public final C1634a aPE;
        public final int length;

        public C1634a(String str, C1634a c1634a) {
            this.aJU = str;
            this.aPE = c1634a;
            this.length = c1634a == null ? 1 : c1634a.length + 1;
        }

        public String m3310p(char[] cArr, int i, int i2) {
            if (this.aJU.length() != i2) {
                return null;
            }
            int i3 = 0;
            while (this.aJU.charAt(i3) == cArr[i + i3]) {
                i3++;
                if (i3 >= i2) {
                    return this.aJU;
                }
            }
            return null;
        }
    }

    public static agi CN() {
        long currentTimeMillis = System.currentTimeMillis();
        return gt((((int) (currentTimeMillis >>> 32)) + ((int) currentTimeMillis)) | 1);
    }

    protected static agi gt(int i) {
        return aPt.gx(i);
    }

    private agi() {
        this.aPw = true;
        this.aPv = -1;
        this.aPC = true;
        this.aOt = 0;
        this.aPB = 0;
        gu(64);
    }

    private void gu(int i) {
        this.aPx = new String[i];
        this.aPy = new C1634a[(i >> 1)];
        this.aPA = i - 1;
        this._size = 0;
        this.aPB = 0;
        this.aPz = gv(i);
    }

    private static int gv(int i) {
        return i - (i >> 2);
    }

    private agi(agi com_fossil_agi, int i, String[] strArr, C1634a[] c1634aArr, int i2, int i3, int i4) {
        this.aPu = com_fossil_agi;
        this.aPv = i;
        this.aPw = Feature.CANONICALIZE_FIELD_NAMES.enabledIn(i);
        this.aPx = strArr;
        this.aPy = c1634aArr;
        this._size = i2;
        this.aOt = i3;
        int length = strArr.length;
        this.aPz = gv(length);
        this.aPA = length - 1;
        this.aPB = i4;
        this.aPC = false;
    }

    public agi gw(int i) {
        String[] strArr;
        C1634a[] c1634aArr;
        int i2;
        int i3;
        int i4;
        synchronized (this) {
            strArr = this.aPx;
            c1634aArr = this.aPy;
            i2 = this._size;
            i3 = this.aOt;
            i4 = this.aPB;
        }
        return new agi(this, i, strArr, c1634aArr, i2, i3, i4);
    }

    private agi gx(int i) {
        return new agi(null, -1, this.aPx, this.aPy, this._size, i, this.aPB);
    }

    private void m3314a(agi com_fossil_agi) {
        if (com_fossil_agi.size() > 12000) {
            synchronized (this) {
                gu(256);
                this.aPC = false;
            }
        } else if (com_fossil_agi.size() > size()) {
            synchronized (this) {
                this.aPx = com_fossil_agi.aPx;
                this.aPy = com_fossil_agi.aPy;
                this._size = com_fossil_agi._size;
                this.aPz = com_fossil_agi.aPz;
                this.aPA = com_fossil_agi.aPA;
                this.aPB = com_fossil_agi.aPB;
                this.aPC = false;
            }
        }
    }

    public void release() {
        if (CC() && this.aPu != null && this.aPw) {
            this.aPu.m3314a(this);
            this.aPC = false;
        }
    }

    public int size() {
        return this._size;
    }

    public boolean CC() {
        return this.aPC;
    }

    public int CO() {
        return this.aOt;
    }

    public String m3315b(char[] cArr, int i, int i2, int i3) {
        if (i2 < 1) {
            return "";
        }
        if (!this.aPw) {
            return new String(cArr, i, i2);
        }
        int gy = gy(i3);
        String str = this.aPx[gy];
        if (str != null) {
            if (str.length() == i2) {
                int i4 = 0;
                while (str.charAt(i4) == cArr[i + i4]) {
                    i4++;
                    if (i4 == i2) {
                        return str;
                    }
                }
            }
            C1634a c1634a = this.aPy[gy >> 1];
            if (c1634a != null) {
                String p = c1634a.m3310p(cArr, i, i2);
                if (p != null) {
                    return p;
                }
                p = m3312a(cArr, i, i2, c1634a.aPE);
                if (p != null) {
                    return p;
                }
            }
        }
        return m3311a(cArr, i, i2, i3, gy);
    }

    private String m3312a(char[] cArr, int i, int i2, C1634a c1634a) {
        while (c1634a != null) {
            String p = c1634a.m3310p(cArr, i, i2);
            if (p != null) {
                return p;
            }
            c1634a = c1634a.aPE;
        }
        return null;
    }

    private String m3311a(char[] cArr, int i, int i2, int i3, int i4) {
        if (!this.aPC) {
            CP();
            this.aPC = true;
        } else if (this._size >= this.aPz) {
            rehash();
            i4 = gy(m3316o(cArr, i, i2));
        }
        String str = new String(cArr, i, i2);
        if (Feature.INTERN_FIELD_NAMES.enabledIn(this.aPv)) {
            str = InternCache.instance.intern(str);
        }
        this._size++;
        if (this.aPx[i4] == null) {
            this.aPx[i4] = str;
        } else {
            int i5 = i4 >> 1;
            C1634a c1634a = new C1634a(str, this.aPy[i5]);
            int i6 = c1634a.length;
            if (i6 > 100) {
                m3313a(i5, c1634a);
            } else {
                this.aPy[i5] = c1634a;
                this.aPB = Math.max(i6, this.aPB);
            }
        }
        return str;
    }

    private void m3313a(int i, C1634a c1634a) {
        if (this.aPD == null) {
            this.aPD = new BitSet();
            this.aPD.set(i);
        } else if (this.aPD.get(i)) {
            if (Feature.FAIL_ON_SYMBOL_HASH_OVERFLOW.enabledIn(this.aPv)) {
                gz(100);
            }
            this.aPw = false;
        } else {
            this.aPD.set(i);
        }
        this.aPx[i + i] = c1634a.aJU;
        this.aPy[i] = null;
        this._size -= c1634a.length;
        this.aPB = -1;
    }

    public int gy(int i) {
        int i2 = (i >>> 15) + i;
        i2 ^= i2 << 7;
        return (i2 + (i2 >>> 3)) & this.aPA;
    }

    public int m3316o(char[] cArr, int i, int i2) {
        int i3 = this.aOt;
        int i4 = i + i2;
        while (i < i4) {
            i3 = (i3 * 33) + cArr[i];
            i++;
        }
        return i3 == 0 ? 1 : i3;
    }

    public int bA(String str) {
        int length = str.length();
        int i = this.aOt;
        int i2 = 0;
        while (i2 < length) {
            int charAt = str.charAt(i2) + (i * 33);
            i2++;
            i = charAt;
        }
        return i == 0 ? 1 : i;
    }

    private void CP() {
        String[] strArr = this.aPx;
        this.aPx = (String[]) Arrays.copyOf(strArr, strArr.length);
        C1634a[] c1634aArr = this.aPy;
        this.aPy = (C1634a[]) Arrays.copyOf(c1634aArr, c1634aArr.length);
    }

    private void rehash() {
        int length = this.aPx.length;
        int i = length + length;
        if (i > NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST) {
            this._size = 0;
            this.aPw = false;
            this.aPx = new String[64];
            this.aPy = new C1634a[32];
            this.aPA = 63;
            this.aPC = true;
            return;
        }
        int i2;
        String[] strArr = this.aPx;
        C1634a[] c1634aArr = this.aPy;
        this.aPx = new String[i];
        this.aPy = new C1634a[(i >> 1)];
        this.aPA = i - 1;
        this.aPz = gv(i);
        i = 0;
        int i3 = 0;
        for (i2 = 0; i2 < length; i2++) {
            String str = strArr[i2];
            if (str != null) {
                i3++;
                int gy = gy(bA(str));
                if (this.aPx[gy] == null) {
                    this.aPx[gy] = str;
                } else {
                    gy >>= 1;
                    C1634a c1634a = new C1634a(str, this.aPy[gy]);
                    this.aPy[gy] = c1634a;
                    i = Math.max(i, c1634a.length);
                }
            }
        }
        length >>= 1;
        i2 = 0;
        int i4 = i3;
        i3 = i;
        while (i2 < length) {
            i = i3;
            for (C1634a c1634a2 = c1634aArr[i2]; c1634a2 != null; c1634a2 = c1634a2.aPE) {
                i4++;
                String str2 = c1634a2.aJU;
                int gy2 = gy(bA(str2));
                if (this.aPx[gy2] == null) {
                    this.aPx[gy2] = str2;
                } else {
                    gy2 >>= 1;
                    C1634a c1634a3 = new C1634a(str2, this.aPy[gy2]);
                    this.aPy[gy2] = c1634a3;
                    i = Math.max(i, c1634a3.length);
                }
            }
            i2++;
            i3 = i;
        }
        this.aPB = i3;
        this.aPD = null;
        if (i4 != this._size) {
            throw new Error("Internal error on SymbolTable.rehash(): had " + this._size + " entries; now have " + i4 + ".");
        }
    }

    protected void gz(int i) {
        throw new IllegalStateException("Longest collision chain in symbol table (of size " + this._size + ") now exceeds maximum, " + i + " -- suspect a DoS attack based on hash collisions");
    }
}
