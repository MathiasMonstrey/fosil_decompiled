package com.fossil;

import java.nio.charset.Charset;
import java.util.Arrays;

public final class bcn {
    private static Charset ISO_8859_1 = Charset.forName("ISO-8859-1");
    protected static final Charset UTF_8 = Charset.forName("UTF-8");
    public static final Object bqx = new Object();

    public static int m4866a(byte[][] bArr) {
        int i = 0;
        int length = bArr == null ? 0 : bArr.length;
        for (int i2 = 0; i2 < length; i2++) {
            byte[] bArr2 = bArr[i2];
            if (bArr2 != null) {
                i = (i * 31) + Arrays.hashCode(bArr2);
            }
        }
        return i;
    }

    public static void m4867a(bcj com_fossil_bcj, bcj com_fossil_bcj2) {
        if (com_fossil_bcj.bqp != null) {
            com_fossil_bcj2.bqp = (bcl) com_fossil_bcj.bqp.clone();
        }
    }

    public static boolean m4868a(byte[][] bArr, byte[][] bArr2) {
        boolean length = bArr == null ? false : bArr.length;
        int length2 = bArr2 == null ? 0 : bArr2.length;
        int i = 0;
        boolean z = false;
        while (true) {
            if (z >= length || bArr[z] != null) {
                int i2 = i;
                while (i2 < length2 && bArr2[i2] == null) {
                    i2++;
                }
                boolean z2 = z >= length;
                boolean z3 = i2 >= length2;
                if (z2 && z3) {
                    return true;
                }
                if (z2 != z3 || !Arrays.equals(bArr[z], bArr2[i2])) {
                    return false;
                }
                i = i2 + 1;
                z++;
            } else {
                z++;
            }
        }
    }

    public static boolean equals(int[] iArr, int[] iArr2) {
        return (iArr == null || iArr.length == 0) ? iArr2 == null || iArr2.length == 0 : Arrays.equals(iArr, iArr2);
    }

    public static boolean equals(long[] jArr, long[] jArr2) {
        return (jArr == null || jArr.length == 0) ? jArr2 == null || jArr2.length == 0 : Arrays.equals(jArr, jArr2);
    }

    public static boolean equals(Object[] objArr, Object[] objArr2) {
        boolean length = objArr == null ? false : objArr.length;
        int length2 = objArr2 == null ? 0 : objArr2.length;
        int i = 0;
        boolean z = false;
        while (true) {
            if (z >= length || objArr[z] != null) {
                int i2 = i;
                while (i2 < length2 && objArr2[i2] == null) {
                    i2++;
                }
                boolean z2 = z >= length;
                boolean z3 = i2 >= length2;
                if (z2 && z3) {
                    return true;
                }
                if (z2 != z3 || !objArr[z].equals(objArr2[i2])) {
                    return false;
                }
                i = i2 + 1;
                z++;
            } else {
                z++;
            }
        }
    }

    public static int hashCode(int[] iArr) {
        return (iArr == null || iArr.length == 0) ? 0 : Arrays.hashCode(iArr);
    }

    public static int hashCode(long[] jArr) {
        return (jArr == null || jArr.length == 0) ? 0 : Arrays.hashCode(jArr);
    }

    public static int hashCode(Object[] objArr) {
        int i = 0;
        int length = objArr == null ? 0 : objArr.length;
        for (int i2 = 0; i2 < length; i2++) {
            Object obj = objArr[i2];
            if (obj != null) {
                i = (i * 31) + obj.hashCode();
            }
        }
        return i;
    }
}
