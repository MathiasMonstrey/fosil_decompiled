package com.fossil;

import android.support.v8.renderscript.Allocation;
import com.facebook.internal.NativeProtocol;
import java.lang.ref.SoftReference;

public final class afp {
    private static final char[] aMW = afn.Bv();
    private static final byte[] aMX = afn.Bw();
    protected static final ThreadLocal<SoftReference<afp>> aNo = new ThreadLocal();
    protected agr aNp;
    protected agn aNq;
    protected final char[] aNr = new char[6];

    public afp() {
        this.aNr[0] = '\\';
        this.aNr[2] = '0';
        this.aNr[3] = '0';
    }

    public static afp BH() {
        SoftReference softReference = (SoftReference) aNo.get();
        afp com_fossil_afp = softReference == null ? null : (afp) softReference.get();
        if (com_fossil_afp != null) {
            return com_fossil_afp;
        }
        com_fossil_afp = new afp();
        aNo.set(new SoftReference(com_fossil_afp));
        return com_fossil_afp;
    }

    public char[] bj(String str) {
        agr com_fossil_agr = this.aNp;
        if (com_fossil_agr == null) {
            com_fossil_agr = new agr(null);
            this.aNp = com_fossil_agr;
        }
        Object Df = com_fossil_agr.Df();
        int[] Bu = afn.Bu();
        char length = Bu.length;
        int length2 = str.length();
        int i = 0;
        int i2 = 0;
        loop0:
        while (i2 < length2) {
            int i3;
            while (true) {
                char charAt = str.charAt(i2);
                if (charAt < length && Bu[charAt] != 0) {
                    break;
                }
                if (i >= Df.length) {
                    Df = com_fossil_agr.Dh();
                    i3 = 0;
                } else {
                    i3 = i;
                }
                i = i3 + 1;
                Df[i3] = charAt;
                i2++;
                if (i2 >= length2) {
                    break loop0;
                }
            }
            i3 = i2 + 1;
            char charAt2 = str.charAt(i2);
            int i4 = Bu[charAt2];
            if (i4 < 0) {
                i2 = m3155a(charAt2, this.aNr);
            } else {
                i2 = m3156b(i4, this.aNr);
            }
            if (i + i2 > Df.length) {
                i4 = Df.length - i;
                if (i4 > 0) {
                    System.arraycopy(this.aNr, 0, Df, i, i4);
                }
                Df = com_fossil_agr.Dh();
                i = i2 - i4;
                System.arraycopy(this.aNr, i4, Df, 0, i);
            } else {
                System.arraycopy(this.aNr, 0, Df, i, i2);
                i += i2;
            }
            i2 = i3;
        }
        com_fossil_agr.gL(i);
        return com_fossil_agr.Db();
    }

    public byte[] bk(String str) {
        agn com_fossil_agn = this.aNq;
        if (com_fossil_agn == null) {
            com_fossil_agn = new agn(null);
            this.aNq = com_fossil_agn;
        }
        int length = str.length();
        byte[] CQ = com_fossil_agn.CQ();
        int i = 0;
        int i2 = 0;
        loop0:
        while (i2 < length) {
            char charAt;
            int i3;
            int[] Bu = afn.Bu();
            while (true) {
                charAt = str.charAt(i2);
                if (charAt <= '' && Bu[charAt] == 0) {
                    if (i >= CQ.length) {
                        CQ = com_fossil_agn.CR();
                        i3 = 0;
                    } else {
                        i3 = i;
                    }
                    i = i3 + 1;
                    CQ[i3] = (byte) charAt;
                    i2++;
                    if (i2 >= length) {
                        break loop0;
                    }
                }
            }
            if (i >= CQ.length) {
                CQ = com_fossil_agn.CR();
                i = 0;
            }
            i3 = i2 + 1;
            charAt = str.charAt(i2);
            if (charAt <= '') {
                i = m3154a(charAt, Bu[charAt], com_fossil_agn, i);
                CQ = com_fossil_agn.CS();
                i2 = i3;
            } else {
                byte[] bArr;
                int i4;
                int i5;
                if (charAt <= '߿') {
                    i2 = i + 1;
                    CQ[i] = (byte) ((charAt >> 6) | 192);
                    bArr = CQ;
                    i4 = (charAt & 63) | Allocation.USAGE_SHARED;
                } else if (charAt < '?' || charAt > '?') {
                    i2 = i + 1;
                    CQ[i] = (byte) ((charAt >> 12) | 224);
                    if (i2 >= CQ.length) {
                        CQ = com_fossil_agn.CR();
                        i = 0;
                    } else {
                        i = i2;
                    }
                    i2 = i + 1;
                    CQ[i] = (byte) (((charAt >> 6) & 63) | Allocation.USAGE_SHARED);
                    bArr = CQ;
                    i4 = (charAt & 63) | Allocation.USAGE_SHARED;
                } else {
                    if (charAt > '?') {
                        fA(charAt);
                    }
                    if (i3 >= length) {
                        fA(charAt);
                    }
                    i5 = i3 + 1;
                    i3 = bq(charAt, str.charAt(i3));
                    if (i3 > 1114111) {
                        fA(i3);
                    }
                    i2 = i + 1;
                    CQ[i] = (byte) ((i3 >> 18) | 240);
                    if (i2 >= CQ.length) {
                        CQ = com_fossil_agn.CR();
                        i = 0;
                    } else {
                        i = i2;
                    }
                    i2 = i + 1;
                    CQ[i] = (byte) (((i3 >> 12) & 63) | Allocation.USAGE_SHARED);
                    if (i2 >= CQ.length) {
                        CQ = com_fossil_agn.CR();
                        i = 0;
                    } else {
                        i = i2;
                    }
                    i2 = i + 1;
                    CQ[i] = (byte) (((i3 >> 6) & 63) | Allocation.USAGE_SHARED);
                    i3 = i5;
                    byte[] bArr2 = CQ;
                    i4 = (i3 & 63) | Allocation.USAGE_SHARED;
                    bArr = bArr2;
                }
                if (i2 >= bArr.length) {
                    bArr = com_fossil_agn.CR();
                    i2 = 0;
                }
                i5 = i2 + 1;
                bArr[i2] = (byte) i4;
                CQ = bArr;
                i2 = i3;
                i = i5;
            }
        }
        return this.aNq.gI(i);
    }

    public byte[] bl(String str) {
        int i;
        agn com_fossil_agn = this.aNq;
        if (com_fossil_agn == null) {
            com_fossil_agn = new agn(null);
            this.aNq = com_fossil_agn;
        }
        int length = str.length();
        byte[] CQ = com_fossil_agn.CQ();
        int length2 = CQ.length;
        int i2 = 0;
        int i3 = 0;
        loop0:
        while (i3 < length) {
            int i4;
            int i5 = i3 + 1;
            i3 = str.charAt(i3);
            int i6 = length2;
            byte[] bArr = CQ;
            int i7 = i2;
            i2 = i6;
            while (i3 <= 127) {
                if (i7 >= i2) {
                    bArr = com_fossil_agn.CR();
                    i2 = bArr.length;
                    i7 = 0;
                }
                i4 = i7 + 1;
                bArr[i7] = (byte) i3;
                if (i5 >= length) {
                    i = i4;
                    break loop0;
                }
                i7 = i5 + 1;
                i3 = str.charAt(i5);
                i5 = i7;
                i7 = i4;
            }
            if (i7 >= i2) {
                bArr = com_fossil_agn.CR();
                i2 = bArr.length;
                i4 = 0;
            } else {
                i4 = i7;
            }
            if (i3 < 2048) {
                i7 = i4 + 1;
                bArr[i4] = (byte) ((i3 >> 6) | 192);
                i4 = i3;
                i3 = i5;
            } else if (i3 < 55296 || i3 > 57343) {
                i7 = i4 + 1;
                bArr[i4] = (byte) ((i3 >> 12) | 224);
                if (i7 >= i2) {
                    bArr = com_fossil_agn.CR();
                    i2 = bArr.length;
                    i7 = 0;
                }
                i4 = i7 + 1;
                bArr[i7] = (byte) (((i3 >> 6) & 63) | Allocation.USAGE_SHARED);
                i7 = i4;
                i4 = i3;
                i3 = i5;
            } else {
                if (i3 > 56319) {
                    fA(i3);
                }
                if (i5 >= length) {
                    fA(i3);
                }
                int i8 = i5 + 1;
                i3 = bq(i3, str.charAt(i5));
                if (i3 > 1114111) {
                    fA(i3);
                }
                i7 = i4 + 1;
                bArr[i4] = (byte) ((i3 >> 18) | 240);
                if (i7 >= i2) {
                    bArr = com_fossil_agn.CR();
                    i2 = bArr.length;
                    i7 = 0;
                }
                i4 = i7 + 1;
                bArr[i7] = (byte) (((i3 >> 12) & 63) | Allocation.USAGE_SHARED);
                if (i4 >= i2) {
                    bArr = com_fossil_agn.CR();
                    i2 = bArr.length;
                    i7 = 0;
                } else {
                    i7 = i4;
                }
                i4 = i7 + 1;
                bArr[i7] = (byte) (((i3 >> 6) & 63) | Allocation.USAGE_SHARED);
                i7 = i4;
                i4 = i3;
                i3 = i8;
            }
            if (i7 >= i2) {
                bArr = com_fossil_agn.CR();
                i2 = bArr.length;
                i7 = 0;
            }
            i5 = i7 + 1;
            bArr[i7] = (byte) ((i4 & 63) | Allocation.USAGE_SHARED);
            CQ = bArr;
            length2 = i2;
            i2 = i5;
        }
        i = i2;
        return this.aNq.gI(i);
    }

    private int m3155a(int i, char[] cArr) {
        cArr[1] = 'u';
        cArr[4] = aMW[i >> 4];
        cArr[5] = aMW[i & 15];
        return 6;
    }

    private int m3156b(int i, char[] cArr) {
        cArr[1] = (char) i;
        return 2;
    }

    private int m3154a(int i, int i2, agn com_fossil_agn, int i3) {
        com_fossil_agn.gJ(i3);
        com_fossil_agn.append(92);
        if (i2 < 0) {
            com_fossil_agn.append(117);
            if (i > 255) {
                int i4 = i >> 8;
                com_fossil_agn.append(aMX[i4 >> 4]);
                com_fossil_agn.append(aMX[i4 & 15]);
                i &= 255;
            } else {
                com_fossil_agn.append(48);
                com_fossil_agn.append(48);
            }
            com_fossil_agn.append(aMX[i >> 4]);
            com_fossil_agn.append(aMX[i & 15]);
        } else {
            com_fossil_agn.append((byte) i2);
        }
        return com_fossil_agn.CT();
    }

    private static int bq(int i, int i2) {
        if (i2 >= 56320 && i2 <= 57343) {
            return (NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST + ((i - 55296) << 10)) + (i2 - 56320);
        }
        throw new IllegalArgumentException("Broken surrogate pair: first char 0x" + Integer.toHexString(i) + ", second 0x" + Integer.toHexString(i2) + "; illegal combination");
    }

    private static void fA(int i) {
        throw new IllegalArgumentException(afv.fE(i));
    }
}
