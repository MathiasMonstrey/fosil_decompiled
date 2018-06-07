package com.fossil;

import android.util.Base64;

public final class axk {
    public static String ac(byte[] bArr) {
        return bArr == null ? null : Base64.encodeToString(bArr, 10);
    }

    public static String encode(byte[] bArr) {
        return bArr == null ? null : Base64.encodeToString(bArr, 0);
    }
}
