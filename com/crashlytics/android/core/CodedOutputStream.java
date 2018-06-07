package com.crashlytics.android.core;

import android.support.v8.renderscript.Allocation;
import com.fossil.acp;
import com.fossil.ado;
import java.io.Flushable;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public final class CodedOutputStream implements Flushable {
    private final byte[] buffer;
    private final int limit;
    private final OutputStream output;
    private int position = 0;

    static class OutOfSpaceException extends IOException {
        private static final long serialVersionUID = -6947486886997889499L;

        OutOfSpaceException() {
            super("CodedOutputStream was writing to a flat byte array and ran out of space.");
        }
    }

    private CodedOutputStream(OutputStream outputStream, byte[] bArr) {
        this.output = outputStream;
        this.buffer = bArr;
        this.limit = bArr.length;
    }

    public static CodedOutputStream m2632d(OutputStream outputStream) {
        return m2629a(outputStream, 4096);
    }

    public static CodedOutputStream m2629a(OutputStream outputStream, int i) {
        return new CodedOutputStream(outputStream, new byte[i]);
    }

    public void m2646e(int i, float f) throws IOException {
        bn(i, 5);
        m2638Q(f);
    }

    public void m2647f(int i, long j) throws IOException {
        bn(i, 0);
        m2636F(j);
    }

    public void m2649o(int i, boolean z) throws IOException {
        bn(i, 0);
        aC(z);
    }

    public void m2648f(int i, String str) throws IOException {
        bn(i, 2);
        as(str);
    }

    public void m2640a(int i, acp com_fossil_acp) throws IOException {
        bn(i, 2);
        m2641a(com_fossil_acp);
    }

    public void bh(int i, int i2) throws IOException {
        bn(i, 0);
        eU(i2);
    }

    public void bi(int i, int i2) throws IOException {
        bn(i, 0);
        eV(i2);
    }

    public void bj(int i, int i2) throws IOException {
        bn(i, 0);
        eW(i2);
    }

    public void m2638Q(float f) throws IOException {
        ff(Float.floatToRawIntBits(f));
    }

    public void m2636F(long j) throws IOException {
        m2637H(j);
    }

    public void eT(int i) throws IOException {
        if (i >= 0) {
            fd(i);
        } else {
            m2637H((long) i);
        }
    }

    public void aC(boolean z) throws IOException {
        fb(z ? 1 : 0);
    }

    public void as(String str) throws IOException {
        byte[] bytes = str.getBytes("UTF-8");
        fd(bytes.length);
        m2639Q(bytes);
    }

    public void m2641a(acp com_fossil_acp) throws IOException {
        fd(com_fossil_acp.size());
        m2643c(com_fossil_acp);
    }

    public void eU(int i) throws IOException {
        fd(i);
    }

    public void eV(int i) throws IOException {
        eT(i);
    }

    public void eW(int i) throws IOException {
        fd(fg(i));
    }

    public static int m2633f(int i, float f) {
        return fc(i) + m2628R(f);
    }

    public static int m2634g(int i, long j) {
        return fc(i) + m2626G(j);
    }

    public static int m2635p(int i, boolean z) {
        return fc(i) + aD(z);
    }

    public static int m2630b(int i, acp com_fossil_acp) {
        return fc(i) + m2631b(com_fossil_acp);
    }

    public static int bk(int i, int i2) {
        return fc(i) + eY(i2);
    }

    public static int bl(int i, int i2) {
        return fc(i) + eZ(i2);
    }

    public static int bm(int i, int i2) {
        return fc(i) + fa(i2);
    }

    public static int m2628R(float f) {
        return 4;
    }

    public static int m2626G(long j) {
        return m2627I(j);
    }

    public static int eX(int i) {
        if (i >= 0) {
            return fe(i);
        }
        return 10;
    }

    public static int aD(boolean z) {
        return 1;
    }

    public static int m2631b(acp com_fossil_acp) {
        return fe(com_fossil_acp.size()) + com_fossil_acp.size();
    }

    public static int eY(int i) {
        return fe(i);
    }

    public static int eZ(int i) {
        return eX(i);
    }

    public static int fa(int i) {
        return fe(fg(i));
    }

    private void xC() throws IOException {
        if (this.output == null) {
            throw new OutOfSpaceException();
        }
        this.output.write(this.buffer, 0, this.position);
        this.position = 0;
    }

    public void flush() throws IOException {
        if (this.output != null) {
            xC();
        }
    }

    public void m2645e(byte b) throws IOException {
        if (this.position == this.limit) {
            xC();
        }
        byte[] bArr = this.buffer;
        int i = this.position;
        this.position = i + 1;
        bArr[i] = b;
    }

    public void fb(int i) throws IOException {
        m2645e((byte) i);
    }

    public void m2643c(acp com_fossil_acp) throws IOException {
        m2642a(com_fossil_acp, 0, com_fossil_acp.size());
    }

    public void m2639Q(byte[] bArr) throws IOException {
        m2644c(bArr, 0, bArr.length);
    }

    public void m2644c(byte[] bArr, int i, int i2) throws IOException {
        if (this.limit - this.position >= i2) {
            System.arraycopy(bArr, i, this.buffer, this.position, i2);
            this.position += i2;
            return;
        }
        int i3 = this.limit - this.position;
        System.arraycopy(bArr, i, this.buffer, this.position, i3);
        int i4 = i + i3;
        i3 = i2 - i3;
        this.position = this.limit;
        xC();
        if (i3 <= this.limit) {
            System.arraycopy(bArr, i4, this.buffer, 0, i3);
            this.position = i3;
            return;
        }
        this.output.write(bArr, i4, i3);
    }

    public void m2642a(acp com_fossil_acp, int i, int i2) throws IOException {
        if (this.limit - this.position >= i2) {
            com_fossil_acp.m2947a(this.buffer, i, this.position, i2);
            this.position += i2;
            return;
        }
        int i3 = this.limit - this.position;
        com_fossil_acp.m2947a(this.buffer, i, this.position, i3);
        int i4 = i + i3;
        i3 = i2 - i3;
        this.position = this.limit;
        xC();
        if (i3 <= this.limit) {
            com_fossil_acp.m2947a(this.buffer, i4, 0, i3);
            this.position = i3;
            return;
        }
        InputStream xA = com_fossil_acp.xA();
        if (((long) i4) != xA.skip((long) i4)) {
            throw new IllegalStateException("Skip failed.");
        }
        while (i3 > 0) {
            i4 = Math.min(i3, this.limit);
            int read = xA.read(this.buffer, 0, i4);
            if (read != i4) {
                throw new IllegalStateException("Read failed.");
            }
            this.output.write(this.buffer, 0, read);
            i3 -= read;
        }
    }

    public void bn(int i, int i2) throws IOException {
        fd(ado.bo(i, i2));
    }

    public static int fc(int i) {
        return fe(ado.bo(i, 0));
    }

    public void fd(int i) throws IOException {
        while ((i & -128) != 0) {
            fb((i & 127) | Allocation.USAGE_SHARED);
            i >>>= 7;
        }
        fb(i);
    }

    public static int fe(int i) {
        if ((i & -128) == 0) {
            return 1;
        }
        if ((i & -16384) == 0) {
            return 2;
        }
        if ((-2097152 & i) == 0) {
            return 3;
        }
        if ((-268435456 & i) == 0) {
            return 4;
        }
        return 5;
    }

    public void m2637H(long j) throws IOException {
        while ((-128 & j) != 0) {
            fb((((int) j) & 127) | Allocation.USAGE_SHARED);
            j >>>= 7;
        }
        fb((int) j);
    }

    public static int m2627I(long j) {
        if ((-128 & j) == 0) {
            return 1;
        }
        if ((-16384 & j) == 0) {
            return 2;
        }
        if ((-2097152 & j) == 0) {
            return 3;
        }
        if ((-268435456 & j) == 0) {
            return 4;
        }
        if ((-34359738368L & j) == 0) {
            return 5;
        }
        if ((-4398046511104L & j) == 0) {
            return 6;
        }
        if ((-562949953421312L & j) == 0) {
            return 7;
        }
        if ((-72057594037927936L & j) == 0) {
            return 8;
        }
        if ((Long.MIN_VALUE & j) == 0) {
            return 9;
        }
        return 10;
    }

    public void ff(int i) throws IOException {
        fb(i & 255);
        fb((i >> 8) & 255);
        fb((i >> 16) & 255);
        fb((i >> 24) & 255);
    }

    public static int fg(int i) {
        return (i << 1) ^ (i >> 31);
    }
}
