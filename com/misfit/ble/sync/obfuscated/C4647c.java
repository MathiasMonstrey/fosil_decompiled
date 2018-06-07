package com.misfit.ble.sync.obfuscated;

public class C4647c {
    protected static final char[] f1615C = "0123456789ABCDEF".toCharArray();

    public static String m15470a(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        char[] cArr = new char[(bArr.length * 2)];
        for (int i = 0; i < bArr.length; i++) {
            int i2 = bArr[i] & 255;
            cArr[i * 2] = f1615C[i2 >>> 4];
            cArr[(i * 2) + 1] = f1615C[i2 & 15];
        }
        return new String(cArr);
    }
}
