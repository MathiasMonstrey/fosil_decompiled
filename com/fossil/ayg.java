package com.fossil;

import android.util.Log;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;

abstract class ayg extends avl {
    private int bjo;

    protected ayg(byte[] bArr) {
        boolean z = false;
        if (bArr.length != 25) {
            int length = bArr.length;
            String valueOf = String.valueOf(axp.m4685a(bArr, 0, bArr.length, false));
            Log.wtf("GoogleCertificates", new StringBuilder(String.valueOf(valueOf).length() + 51).append("Cert hash data has incorrect length (").append(length).append("):\n").append(valueOf).toString(), new Exception());
            bArr = Arrays.copyOfRange(bArr, 0, 25);
            if (bArr.length == 25) {
                z = true;
            }
            awa.m4637b(z, "cert hash data has incorrect length. length=" + bArr.length);
        }
        this.bjo = Arrays.hashCode(bArr);
    }

    protected static byte[] dk(String str) {
        try {
            return str.getBytes("ISO-8859-1");
        } catch (UnsupportedEncodingException e) {
            throw new AssertionError(e);
        }
    }

    public final ayq KY() {
        return azc.bQ(getBytes());
    }

    public final int KZ() {
        return hashCode();
    }

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof avk)) {
            return false;
        }
        try {
            avk com_fossil_avk = (avk) obj;
            if (com_fossil_avk.KZ() != hashCode()) {
                return false;
            }
            ayq KY = com_fossil_avk.KY();
            if (KY == null) {
                return false;
            }
            return Arrays.equals(getBytes(), (byte[]) azc.m4739a(KY));
        } catch (Throwable e) {
            Log.e("GoogleCertificates", "Failed to get Google certificates from remote", e);
            return false;
        }
    }

    abstract byte[] getBytes();

    public int hashCode() {
        return this.bjo;
    }
}
