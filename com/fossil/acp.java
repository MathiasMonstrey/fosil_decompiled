package com.fossil;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

public final class acp {
    public static final acp aIv = new acp(new byte[0]);
    private volatile int aIw = 0;
    private final byte[] bytes;

    private acp(byte[] bArr) {
        this.bytes = bArr;
    }

    public int size() {
        return this.bytes.length;
    }

    public static acp m2946b(byte[] bArr, int i, int i2) {
        Object obj = new byte[i2];
        System.arraycopy(bArr, i, obj, 0, i2);
        return new acp(obj);
    }

    public static acp ar(String str) {
        try {
            return new acp(str.getBytes("UTF-8"));
        } catch (Throwable e) {
            throw new RuntimeException("UTF-8 not supported.", e);
        }
    }

    public void m2947a(byte[] bArr, int i, int i2, int i3) {
        System.arraycopy(this.bytes, i, bArr, i2, i3);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof acp)) {
            return false;
        }
        acp com_fossil_acp = (acp) obj;
        int length = this.bytes.length;
        if (length != com_fossil_acp.bytes.length) {
            return false;
        }
        byte[] bArr = this.bytes;
        byte[] bArr2 = com_fossil_acp.bytes;
        for (int i = 0; i < length; i++) {
            if (bArr[i] != bArr2[i]) {
                return false;
            }
        }
        return true;
    }

    public int hashCode() {
        int i = this.aIw;
        if (i == 0) {
            byte[] bArr = this.bytes;
            int length = this.bytes.length;
            int i2 = 0;
            i = length;
            while (i2 < length) {
                int i3 = bArr[i2] + (i * 31);
                i2++;
                i = i3;
            }
            if (i == 0) {
                i = 1;
            }
            this.aIw = i;
        }
        return i;
    }

    public InputStream xA() {
        return new ByteArrayInputStream(this.bytes);
    }
}
