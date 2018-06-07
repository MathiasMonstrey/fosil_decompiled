package com.fossil;

import android.support.v8.renderscript.Allocation;
import java.util.Arrays;

public final class afn {
    private static final char[] aMW = "0123456789ABCDEF".toCharArray();
    private static final byte[] aMX;
    static final int[] aMY;
    static final int[] aMZ;
    static final int[] aNa;
    static final int[] aNb;
    static final int[] aNc;
    static final int[] aNd;
    static final int[] aNe;
    static final int[] aNf = new int[Allocation.USAGE_SHARED];

    static {
        int i;
        int length = aMW.length;
        aMX = new byte[length];
        for (i = 0; i < length; i++) {
            aMX[i] = (byte) aMW[i];
        }
        int[] iArr = new int[256];
        for (i = 0; i < 32; i++) {
            iArr[i] = -1;
        }
        iArr[34] = 1;
        iArr[92] = 1;
        aMY = iArr;
        Object obj = new int[aMY.length];
        System.arraycopy(aMY, 0, obj, 0, obj.length);
        for (length = Allocation.USAGE_SHARED; length < 256; length++) {
            i = (length & 224) == 192 ? 2 : (length & 240) == 224 ? 3 : (length & 248) == 240 ? 4 : -1;
            obj[length] = i;
        }
        aMZ = obj;
        iArr = new int[256];
        Arrays.fill(iArr, -1);
        for (i = 33; i < 256; i++) {
            if (Character.isJavaIdentifierPart((char) i)) {
                iArr[i] = 0;
            }
        }
        iArr[64] = 0;
        iArr[35] = 0;
        iArr[42] = 0;
        iArr[45] = 0;
        iArr[43] = 0;
        aNa = iArr;
        Object obj2 = new int[256];
        System.arraycopy(aNa, 0, obj2, 0, obj2.length);
        Arrays.fill(obj2, Allocation.USAGE_SHARED, Allocation.USAGE_SHARED, 0);
        aNb = obj2;
        obj2 = new int[256];
        System.arraycopy(aMZ, Allocation.USAGE_SHARED, obj2, Allocation.USAGE_SHARED, Allocation.USAGE_SHARED);
        Arrays.fill(obj2, 0, 32, -1);
        obj2[9] = null;
        obj2[10] = 10;
        obj2[13] = 13;
        obj2[42] = 42;
        aNc = obj2;
        obj2 = new int[256];
        System.arraycopy(aMZ, Allocation.USAGE_SHARED, obj2, Allocation.USAGE_SHARED, Allocation.USAGE_SHARED);
        Arrays.fill(obj2, 0, 32, -1);
        obj2[32] = 1;
        obj2[9] = 1;
        obj2[10] = 10;
        obj2[13] = 13;
        obj2[47] = 47;
        obj2[35] = 35;
        aNd = obj2;
        iArr = new int[Allocation.USAGE_SHARED];
        for (i = 0; i < 32; i++) {
            iArr[i] = -1;
        }
        iArr[34] = 34;
        iArr[92] = 92;
        iArr[8] = 98;
        iArr[9] = 116;
        iArr[12] = 102;
        iArr[10] = 110;
        iArr[13] = 114;
        aNe = iArr;
        Arrays.fill(aNf, -1);
        for (i = 0; i < 10; i++) {
            aNf[i + 48] = i;
        }
        for (i = 0; i < 6; i++) {
            aNf[i + 97] = i + 10;
            aNf[i + 65] = i + 10;
        }
    }

    public static int[] Bp() {
        return aMY;
    }

    public static int[] Bq() {
        return aMZ;
    }

    public static int[] Br() {
        return aNa;
    }

    public static int[] Bs() {
        return aNb;
    }

    public static int[] Bt() {
        return aNc;
    }

    public static int[] Bu() {
        return aNe;
    }

    public static int fx(int i) {
        return i > 127 ? -1 : aNf[i];
    }

    public static void m3144a(StringBuilder stringBuilder, String str) {
        int[] iArr = aNe;
        char length = iArr.length;
        int length2 = str.length();
        for (int i = 0; i < length2; i++) {
            char charAt = str.charAt(i);
            if (charAt >= length || iArr[charAt] == 0) {
                stringBuilder.append(charAt);
            } else {
                stringBuilder.append('\\');
                int i2 = iArr[charAt];
                if (i2 < 0) {
                    stringBuilder.append('u');
                    stringBuilder.append('0');
                    stringBuilder.append('0');
                    stringBuilder.append(aMW[charAt >> 4]);
                    stringBuilder.append(aMW[charAt & 15]);
                } else {
                    stringBuilder.append((char) i2);
                }
            }
        }
    }

    public static char[] Bv() {
        return (char[]) aMW.clone();
    }

    public static byte[] Bw() {
        return (byte[]) aMX.clone();
    }
}
