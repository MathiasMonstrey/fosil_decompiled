package com.fossil;

public class eax {
    static final /* synthetic */ boolean aXk = (!eax.class.desiredAssertionStatus());

    private eax() {
    }

    public static byte[] m10427b(byte[] bArr, int i, int i2, int i3) {
        eaz com_fossil_eaz = new eaz(i3, new byte[((i2 * 3) / 4)]);
        if (!com_fossil_eaz.m10431b(bArr, i, i2, true)) {
            throw new IllegalArgumentException("bad base-64");
        } else if (com_fossil_eaz.b == com_fossil_eaz.aYe.length) {
            return com_fossil_eaz.aYe;
        } else {
            Object obj = new byte[com_fossil_eaz.b];
            System.arraycopy(com_fossil_eaz.aYe, 0, obj, 0, com_fossil_eaz.b);
            return obj;
        }
    }

    public static byte[] m10428c(byte[] bArr, int i) {
        return m10427b(bArr, 0, bArr.length, i);
    }

    public static byte[] m10429c(byte[] bArr, int i, int i2, int i3) {
        eba com_fossil_eba = new eba(i3, null);
        int i4 = (i2 / 3) * 4;
        if (!com_fossil_eba.aWE) {
            switch (i2 % 3) {
                case 0:
                    break;
                case 1:
                    i4 += 2;
                    break;
                case 2:
                    i4 += 3;
                    break;
                default:
                    break;
            }
        } else if (i2 % 3 > 0) {
            i4 += 4;
        }
        if (com_fossil_eba.f1504e && i2 > 0) {
            i4 += (com_fossil_eba.aWO ? 2 : 1) * (((i2 - 1) / 57) + 1);
        }
        com_fossil_eba.aYe = new byte[i4];
        com_fossil_eba.m10433b(bArr, i, i2, true);
        if (aXk || com_fossil_eba.b == i4) {
            return com_fossil_eba.aYe;
        }
        throw new AssertionError();
    }

    public static byte[] m10430d(byte[] bArr, int i) {
        return m10429c(bArr, 0, bArr.length, i);
    }
}
