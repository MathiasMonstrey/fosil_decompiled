package com.fossil;

import android.util.Base64;

public class eaw {
    static byte[] Ii() {
        return Base64.decode("MDNhOTc2NTExZTJjYmUzYTdmMjY4MDhmYjdhZjNjMDU=", 0);
    }

    static byte[] m10424a(byte[] bArr, byte[] bArr2) {
        int i = 0;
        int[] iArr = new int[256];
        int[] iArr2 = new int[256];
        int length = bArr2.length;
        if (length <= 0 || length > 256) {
            throw new IllegalArgumentException("key must be between 1 and 256 bytes");
        }
        int i2;
        for (i2 = 0; i2 < 256; i2++) {
            iArr[i2] = i2;
            iArr2[i2] = bArr2[i2 % length];
        }
        i2 = 0;
        for (length = 0; length < 256; length++) {
            i2 = ((i2 + iArr[length]) + iArr2[length]) & 255;
            int i3 = iArr[length];
            iArr[length] = iArr[i2];
            iArr[i2] = i3;
        }
        byte[] bArr3 = new byte[bArr.length];
        i2 = 0;
        length = 0;
        while (i < bArr.length) {
            i2 = (i2 + 1) & 255;
            length = (length + iArr[i2]) & 255;
            i3 = iArr[i2];
            iArr[i2] = iArr[length];
            iArr[length] = i3;
            bArr3[i] = (byte) (iArr[(iArr[i2] + iArr[length]) & 255] ^ bArr[i]);
            i++;
        }
        return bArr3;
    }

    public static byte[] at(byte[] bArr) {
        return m10424a(bArr, Ii());
    }

    public static byte[] m10425b(byte[] bArr) {
        return m10426b(bArr, Ii());
    }

    static byte[] m10426b(byte[] bArr, byte[] bArr2) {
        return m10424a(bArr, bArr2);
    }
}
