package com.fossil;

import android.support.v8.renderscript.Allocation;
import com.facebook.internal.NativeProtocol;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import okio.ByteString;

public final class eth implements eti, etj, Cloneable {
    private static final byte[] dTg = new byte[]{(byte) 48, (byte) 49, (byte) 50, (byte) 51, (byte) 52, (byte) 53, (byte) 54, (byte) 55, (byte) 56, (byte) 57, (byte) 97, (byte) 98, (byte) 99, (byte) 100, (byte) 101, (byte) 102};
    long Fs;
    ets dTh;

    class C35401 extends OutputStream {
        final /* synthetic */ eth dTi;

        C35401(eth com_fossil_eth) {
            this.dTi = com_fossil_eth;
        }

        public void write(int i) {
            this.dTi.pr((byte) i);
        }

        public void write(byte[] bArr, int i, int i2) {
            this.dTi.m11163m(bArr, i, i2);
        }

        public void flush() {
        }

        public void close() {
        }

        public String toString() {
            return this + ".outputStream()";
        }
    }

    class C35412 extends InputStream {
        final /* synthetic */ eth dTi;

        C35412(eth com_fossil_eth) {
            this.dTi = com_fossil_eth;
        }

        public int read() {
            if (this.dTi.Fs > 0) {
                return this.dTi.readByte() & 255;
            }
            return -1;
        }

        public int read(byte[] bArr, int i, int i2) {
            return this.dTi.read(bArr, i, i2);
        }

        public int available() {
            return (int) Math.min(this.dTi.Fs, 2147483647L);
        }

        public void close() {
        }

        public String toString() {
            return this.dTi + ".inputStream()";
        }
    }

    public /* synthetic */ eti aHs() throws IOException {
        return aHg();
    }

    public /* synthetic */ eti ay(byte[] bArr) throws IOException {
        return ax(bArr);
    }

    public /* synthetic */ eti bj(long j) throws IOException {
        return bi(j);
    }

    public /* synthetic */ Object clone() throws CloneNotSupportedException {
        return aHr();
    }

    public /* synthetic */ eti mo3046f(ByteString byteString) throws IOException {
        return m11160e(byteString);
    }

    public /* synthetic */ eti mI(String str) throws IOException {
        return mH(str);
    }

    public /* synthetic */ eti mo3049n(byte[] bArr, int i, int i2) throws IOException {
        return m11163m(bArr, i, i2);
    }

    public /* synthetic */ eti pv(int i) throws IOException {
        return pt(i);
    }

    public /* synthetic */ eti pw(int i) throws IOException {
        return ps(i);
    }

    public /* synthetic */ eti px(int i) throws IOException {
        return pr(i);
    }

    public long size() {
        return this.Fs;
    }

    public eth aHe() {
        return this;
    }

    public OutputStream aHf() {
        return new C35401(this);
    }

    public eth aHg() {
        return this;
    }

    public eti aHh() {
        return this;
    }

    public boolean aHi() {
        return this.Fs == 0;
    }

    public void bb(long j) throws EOFException {
        if (this.Fs < j) {
            throw new EOFException();
        }
    }

    public InputStream aHj() {
        return new C35412(this);
    }

    public eth m11155a(eth com_fossil_eth, long j, long j2) {
        if (com_fossil_eth == null) {
            throw new IllegalArgumentException("out == null");
        }
        etx.m11198b(this.Fs, j, j2);
        if (j2 != 0) {
            com_fossil_eth.Fs += j2;
            ets com_fossil_ets = this.dTh;
            while (j >= ((long) (com_fossil_ets.limit - com_fossil_ets.pos))) {
                j -= (long) (com_fossil_ets.limit - com_fossil_ets.pos);
                com_fossil_ets = com_fossil_ets.dTA;
            }
            while (j2 > 0) {
                ets com_fossil_ets2 = new ets(com_fossil_ets);
                com_fossil_ets2.pos = (int) (((long) com_fossil_ets2.pos) + j);
                com_fossil_ets2.limit = Math.min(com_fossil_ets2.pos + ((int) j2), com_fossil_ets2.limit);
                if (com_fossil_eth.dTh == null) {
                    com_fossil_ets2.dTB = com_fossil_ets2;
                    com_fossil_ets2.dTA = com_fossil_ets2;
                    com_fossil_eth.dTh = com_fossil_ets2;
                } else {
                    com_fossil_eth.dTh.dTB.m11193a(com_fossil_ets2);
                }
                j2 -= (long) (com_fossil_ets2.limit - com_fossil_ets2.pos);
                com_fossil_ets = com_fossil_ets.dTA;
                j = 0;
            }
        }
        return this;
    }

    public long aHk() {
        long j = this.Fs;
        if (j == 0) {
            return 0;
        }
        ets com_fossil_ets = this.dTh.dTB;
        if (com_fossil_ets.limit >= 2048 || !com_fossil_ets.dTz) {
            return j;
        }
        return j - ((long) (com_fossil_ets.limit - com_fossil_ets.pos));
    }

    public byte readByte() {
        if (this.Fs == 0) {
            throw new IllegalStateException("size == 0");
        }
        ets com_fossil_ets = this.dTh;
        int i = com_fossil_ets.pos;
        int i2 = com_fossil_ets.limit;
        int i3 = i + 1;
        byte b = com_fossil_ets.data[i];
        this.Fs--;
        if (i3 == i2) {
            this.dTh = com_fossil_ets.aHG();
            ett.m11195b(com_fossil_ets);
        } else {
            com_fossil_ets.pos = i3;
        }
        return b;
    }

    public byte bc(long j) {
        etx.m11198b(this.Fs, j, 1);
        ets com_fossil_ets = this.dTh;
        while (true) {
            int i = com_fossil_ets.limit - com_fossil_ets.pos;
            if (j < ((long) i)) {
                return com_fossil_ets.data[com_fossil_ets.pos + ((int) j)];
            }
            j -= (long) i;
            com_fossil_ets = com_fossil_ets.dTA;
        }
    }

    public short readShort() {
        if (this.Fs < 2) {
            throw new IllegalStateException("size < 2: " + this.Fs);
        }
        ets com_fossil_ets = this.dTh;
        int i = com_fossil_ets.pos;
        int i2 = com_fossil_ets.limit;
        if (i2 - i < 2) {
            return (short) (((readByte() & 255) << 8) | (readByte() & 255));
        }
        byte[] bArr = com_fossil_ets.data;
        int i3 = i + 1;
        int i4 = i3 + 1;
        i = ((bArr[i] & 255) << 8) | (bArr[i3] & 255);
        this.Fs -= 2;
        if (i4 == i2) {
            this.dTh = com_fossil_ets.aHG();
            ett.m11195b(com_fossil_ets);
        } else {
            com_fossil_ets.pos = i4;
        }
        return (short) i;
    }

    public int readInt() {
        if (this.Fs < 4) {
            throw new IllegalStateException("size < 4: " + this.Fs);
        }
        ets com_fossil_ets = this.dTh;
        int i = com_fossil_ets.pos;
        int i2 = com_fossil_ets.limit;
        if (i2 - i < 4) {
            return ((((readByte() & 255) << 24) | ((readByte() & 255) << 16)) | ((readByte() & 255) << 8)) | (readByte() & 255);
        }
        byte[] bArr = com_fossil_ets.data;
        int i3 = i + 1;
        int i4 = i3 + 1;
        i = ((bArr[i] & 255) << 24) | ((bArr[i3] & 255) << 16);
        i3 = i4 + 1;
        i |= (bArr[i4] & 255) << 8;
        i4 = i3 + 1;
        i |= bArr[i3] & 255;
        this.Fs -= 4;
        if (i4 == i2) {
            this.dTh = com_fossil_ets.aHG();
            ett.m11195b(com_fossil_ets);
            return i;
        }
        com_fossil_ets.pos = i4;
        return i;
    }

    public short aHl() {
        return etx.m11199i(readShort());
    }

    public int aHm() {
        return etx.pz(readInt());
    }

    public long aHn() {
        if (this.Fs == 0) {
            throw new IllegalStateException("size == 0");
        }
        long j = 0;
        int i = 0;
        Object obj = null;
        do {
            ets com_fossil_ets = this.dTh;
            byte[] bArr = com_fossil_ets.data;
            int i2 = com_fossil_ets.pos;
            int i3 = com_fossil_ets.limit;
            int i4 = i2;
            while (i4 < i3) {
                byte b = bArr[i4];
                if (b >= (byte) 48 && b <= (byte) 57) {
                    i2 = b - 48;
                } else if (b >= (byte) 97 && b <= (byte) 102) {
                    i2 = (b - 97) + 10;
                } else if (b < (byte) 65 || b > (byte) 70) {
                    if (i != 0) {
                        obj = 1;
                        if (i4 != i3) {
                            this.dTh = com_fossil_ets.aHG();
                            ett.m11195b(com_fossil_ets);
                        } else {
                            com_fossil_ets.pos = i4;
                        }
                        if (obj == null) {
                            break;
                        }
                    } else {
                        throw new NumberFormatException("Expected leading [0-9a-fA-F] character but was 0x" + Integer.toHexString(b));
                    }
                } else {
                    i2 = (b - 65) + 10;
                }
                if ((-1152921504606846976L & j) != 0) {
                    throw new NumberFormatException("Number too large: " + new eth().bi(j).pr(b).aHo());
                }
                i++;
                i4++;
                j = ((long) i2) | (j << 4);
            }
            if (i4 != i3) {
                com_fossil_ets.pos = i4;
            } else {
                this.dTh = com_fossil_ets.aHG();
                ett.m11195b(com_fossil_ets);
            }
            if (obj == null) {
                break;
            }
        } while (this.dTh != null);
        this.Fs -= (long) i;
        return j;
    }

    public ByteString aAt() {
        return new ByteString(aHq());
    }

    public ByteString bd(long j) throws EOFException {
        return new ByteString(bg(j));
    }

    public String aHo() {
        try {
            return m11156a(this.Fs, etx.UTF_8);
        } catch (EOFException e) {
            throw new AssertionError(e);
        }
    }

    public String be(long j) throws EOFException {
        return m11156a(j, etx.UTF_8);
    }

    public String m11156a(long j, Charset charset) throws EOFException {
        etx.m11198b(this.Fs, 0, j);
        if (charset == null) {
            throw new IllegalArgumentException("charset == null");
        } else if (j > 2147483647L) {
            throw new IllegalArgumentException("byteCount > Integer.MAX_VALUE: " + j);
        } else if (j == 0) {
            return "";
        } else {
            ets com_fossil_ets = this.dTh;
            if (((long) com_fossil_ets.pos) + j > ((long) com_fossil_ets.limit)) {
                return new String(bg(j), charset);
            }
            String str = new String(com_fossil_ets.data, com_fossil_ets.pos, (int) j, charset);
            com_fossil_ets.pos = (int) (((long) com_fossil_ets.pos) + j);
            this.Fs -= j;
            if (com_fossil_ets.pos != com_fossil_ets.limit) {
                return str;
            }
            this.dTh = com_fossil_ets.aHG();
            ett.m11195b(com_fossil_ets);
            return str;
        }
    }

    public String aHp() throws EOFException {
        long g = mo3047g((byte) 10);
        if (g != -1) {
            return bf(g);
        }
        eth com_fossil_eth = new eth();
        m11155a(com_fossil_eth, 0, Math.min(32, this.Fs));
        throw new EOFException("\\n not found: size=" + size() + " content=" + com_fossil_eth.aAt().hex() + "...");
    }

    String bf(long j) throws EOFException {
        if (j <= 0 || bc(j - 1) != (byte) 13) {
            String be = be(j);
            bh(1);
            return be;
        }
        be = be(j - 1);
        bh(2);
        return be;
    }

    public byte[] aHq() {
        try {
            return bg(this.Fs);
        } catch (EOFException e) {
            throw new AssertionError(e);
        }
    }

    public byte[] bg(long j) throws EOFException {
        etx.m11198b(this.Fs, 0, j);
        if (j > 2147483647L) {
            throw new IllegalArgumentException("byteCount > Integer.MAX_VALUE: " + j);
        }
        byte[] bArr = new byte[((int) j)];
        readFully(bArr);
        return bArr;
    }

    public void readFully(byte[] bArr) throws EOFException {
        int i = 0;
        while (i < bArr.length) {
            int read = read(bArr, i, bArr.length - i);
            if (read == -1) {
                throw new EOFException();
            }
            i += read;
        }
    }

    public int read(byte[] bArr, int i, int i2) {
        etx.m11198b((long) bArr.length, (long) i, (long) i2);
        ets com_fossil_ets = this.dTh;
        if (com_fossil_ets == null) {
            return -1;
        }
        int min = Math.min(i2, com_fossil_ets.limit - com_fossil_ets.pos);
        System.arraycopy(com_fossil_ets.data, com_fossil_ets.pos, bArr, i, min);
        com_fossil_ets.pos += min;
        this.Fs -= (long) min;
        if (com_fossil_ets.pos != com_fossil_ets.limit) {
            return min;
        }
        this.dTh = com_fossil_ets.aHG();
        ett.m11195b(com_fossil_ets);
        return min;
    }

    public void clear() {
        try {
            bh(this.Fs);
        } catch (EOFException e) {
            throw new AssertionError(e);
        }
    }

    public void bh(long j) throws EOFException {
        while (j > 0) {
            if (this.dTh == null) {
                throw new EOFException();
            }
            int min = (int) Math.min(j, (long) (this.dTh.limit - this.dTh.pos));
            this.Fs -= (long) min;
            j -= (long) min;
            ets com_fossil_ets = this.dTh;
            com_fossil_ets.pos = min + com_fossil_ets.pos;
            if (this.dTh.pos == this.dTh.limit) {
                ets com_fossil_ets2 = this.dTh;
                this.dTh = com_fossil_ets2.aHG();
                ett.m11195b(com_fossil_ets2);
            }
        }
    }

    public eth m11160e(ByteString byteString) {
        if (byteString == null) {
            throw new IllegalArgumentException("byteString == null");
        }
        byteString.write(this);
        return this;
    }

    public eth mH(String str) {
        return m11153C(str, 0, str.length());
    }

    public eth m11153C(String str, int i, int i2) {
        if (str == null) {
            throw new IllegalArgumentException("string == null");
        } else if (i < 0) {
            throw new IllegalAccessError("beginIndex < 0: " + i);
        } else if (i2 < i) {
            throw new IllegalArgumentException("endIndex < beginIndex: " + i2 + " < " + i);
        } else if (i2 > str.length()) {
            throw new IllegalArgumentException("endIndex > string.length: " + i2 + " > " + str.length());
        } else {
            while (i < i2) {
                int i3;
                char charAt = str.charAt(i);
                if (charAt < '') {
                    int i4;
                    ets pu = pu(1);
                    byte[] bArr = pu.data;
                    int i5 = pu.limit - i;
                    int min = Math.min(i2, 2048 - i5);
                    i3 = i + 1;
                    bArr[i5 + i] = (byte) charAt;
                    while (i3 < min) {
                        char charAt2 = str.charAt(i3);
                        if (charAt2 >= '') {
                            break;
                        }
                        i4 = i3 + 1;
                        bArr[i3 + i5] = (byte) charAt2;
                        i3 = i4;
                    }
                    i4 = (i3 + i5) - pu.limit;
                    pu.limit += i4;
                    this.Fs += (long) i4;
                } else if (charAt < 'ࠀ') {
                    pr((charAt >> 6) | 192);
                    pr((charAt & 63) | Allocation.USAGE_SHARED);
                    i3 = i + 1;
                } else if (charAt < '?' || charAt > '?') {
                    pr((charAt >> 12) | 224);
                    pr(((charAt >> 6) & 63) | Allocation.USAGE_SHARED);
                    pr((charAt & 63) | Allocation.USAGE_SHARED);
                    i3 = i + 1;
                } else {
                    i3 = i + 1 < i2 ? str.charAt(i + 1) : 0;
                    if (charAt > '?' || i3 < 56320 || i3 > 57343) {
                        pr(63);
                        i++;
                    } else {
                        i3 = ((i3 & -56321) | ((charAt & -55297) << 10)) + NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST;
                        pr((i3 >> 18) | 240);
                        pr(((i3 >> 12) & 63) | Allocation.USAGE_SHARED);
                        pr(((i3 >> 6) & 63) | Allocation.USAGE_SHARED);
                        pr((i3 & 63) | Allocation.USAGE_SHARED);
                        i3 = i + 2;
                    }
                }
                i = i3;
            }
            return this;
        }
    }

    public eth pq(int i) {
        if (i < Allocation.USAGE_SHARED) {
            pr(i);
        } else if (i < 2048) {
            pr((i >> 6) | 192);
            pr((i & 63) | Allocation.USAGE_SHARED);
        } else if (i < NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST) {
            if (i < 55296 || i > 57343) {
                pr((i >> 12) | 224);
                pr(((i >> 6) & 63) | Allocation.USAGE_SHARED);
                pr((i & 63) | Allocation.USAGE_SHARED);
            } else {
                throw new IllegalArgumentException("Unexpected code point: " + Integer.toHexString(i));
            }
        } else if (i <= 1114111) {
            pr((i >> 18) | 240);
            pr(((i >> 12) & 63) | Allocation.USAGE_SHARED);
            pr(((i >> 6) & 63) | Allocation.USAGE_SHARED);
            pr((i & 63) | Allocation.USAGE_SHARED);
        } else {
            throw new IllegalArgumentException("Unexpected code point: " + Integer.toHexString(i));
        }
        return this;
    }

    public eth ax(byte[] bArr) {
        if (bArr != null) {
            return m11163m(bArr, 0, bArr.length);
        }
        throw new IllegalArgumentException("source == null");
    }

    public eth m11163m(byte[] bArr, int i, int i2) {
        if (bArr == null) {
            throw new IllegalArgumentException("source == null");
        }
        etx.m11198b((long) bArr.length, (long) i, (long) i2);
        int i3 = i + i2;
        while (i < i3) {
            ets pu = pu(1);
            int min = Math.min(i3 - i, 2048 - pu.limit);
            System.arraycopy(bArr, i, pu.data, pu.limit, min);
            i += min;
            pu.limit = min + pu.limit;
        }
        this.Fs += (long) i2;
        return this;
    }

    public long mo3040b(etv com_fossil_etv) throws IOException {
        if (com_fossil_etv == null) {
            throw new IllegalArgumentException("source == null");
        }
        long j = 0;
        while (true) {
            long b = com_fossil_etv.mo2733b(this, 2048);
            if (b == -1) {
                return j;
            }
            j += b;
        }
    }

    public eth pr(int i) {
        ets pu = pu(1);
        byte[] bArr = pu.data;
        int i2 = pu.limit;
        pu.limit = i2 + 1;
        bArr[i2] = (byte) i;
        this.Fs++;
        return this;
    }

    public eth ps(int i) {
        ets pu = pu(2);
        byte[] bArr = pu.data;
        int i2 = pu.limit;
        int i3 = i2 + 1;
        bArr[i2] = (byte) ((i >>> 8) & 255);
        i2 = i3 + 1;
        bArr[i3] = (byte) (i & 255);
        pu.limit = i2;
        this.Fs += 2;
        return this;
    }

    public eth pt(int i) {
        ets pu = pu(4);
        byte[] bArr = pu.data;
        int i2 = pu.limit;
        int i3 = i2 + 1;
        bArr[i2] = (byte) ((i >>> 24) & 255);
        i2 = i3 + 1;
        bArr[i3] = (byte) ((i >>> 16) & 255);
        i3 = i2 + 1;
        bArr[i2] = (byte) ((i >>> 8) & 255);
        i2 = i3 + 1;
        bArr[i3] = (byte) (i & 255);
        pu.limit = i2;
        this.Fs += 4;
        return this;
    }

    public eth bi(long j) {
        if (j == 0) {
            return pr(48);
        }
        int numberOfTrailingZeros = (Long.numberOfTrailingZeros(Long.highestOneBit(j)) / 4) + 1;
        ets pu = pu(numberOfTrailingZeros);
        byte[] bArr = pu.data;
        int i = pu.limit;
        for (int i2 = (pu.limit + numberOfTrailingZeros) - 1; i2 >= i; i2--) {
            bArr[i2] = dTg[(int) (15 & j)];
            j >>>= 4;
        }
        pu.limit += numberOfTrailingZeros;
        this.Fs = ((long) numberOfTrailingZeros) + this.Fs;
        return this;
    }

    ets pu(int i) {
        if (i < 1 || i > 2048) {
            throw new IllegalArgumentException();
        } else if (this.dTh == null) {
            this.dTh = ett.aHI();
            ets com_fossil_ets = this.dTh;
            ets com_fossil_ets2 = this.dTh;
            r0 = this.dTh;
            com_fossil_ets2.dTB = r0;
            com_fossil_ets.dTA = r0;
            return r0;
        } else {
            r0 = this.dTh.dTB;
            if (r0.limit + i > 2048 || !r0.dTz) {
                return r0.m11193a(ett.aHI());
            }
            return r0;
        }
    }

    public void mo2728a(eth com_fossil_eth, long j) {
        if (com_fossil_eth == null) {
            throw new IllegalArgumentException("source == null");
        } else if (com_fossil_eth == this) {
            throw new IllegalArgumentException("source == this");
        } else {
            etx.m11198b(com_fossil_eth.Fs, 0, j);
            while (j > 0) {
                ets com_fossil_ets;
                if (j < ((long) (com_fossil_eth.dTh.limit - com_fossil_eth.dTh.pos))) {
                    com_fossil_ets = this.dTh != null ? this.dTh.dTB : null;
                    if (com_fossil_ets != null && com_fossil_ets.dTz) {
                        if ((((long) com_fossil_ets.limit) + j) - ((long) (com_fossil_ets.dTy ? 0 : com_fossil_ets.pos)) <= 2048) {
                            com_fossil_eth.dTh.m11194a(com_fossil_ets, (int) j);
                            com_fossil_eth.Fs -= j;
                            this.Fs += j;
                            return;
                        }
                    }
                    com_fossil_eth.dTh = com_fossil_eth.dTh.py((int) j);
                }
                ets com_fossil_ets2 = com_fossil_eth.dTh;
                long j2 = (long) (com_fossil_ets2.limit - com_fossil_ets2.pos);
                com_fossil_eth.dTh = com_fossil_ets2.aHG();
                if (this.dTh == null) {
                    this.dTh = com_fossil_ets2;
                    com_fossil_ets2 = this.dTh;
                    com_fossil_ets = this.dTh;
                    ets com_fossil_ets3 = this.dTh;
                    com_fossil_ets.dTB = com_fossil_ets3;
                    com_fossil_ets2.dTA = com_fossil_ets3;
                } else {
                    this.dTh.dTB.m11193a(com_fossil_ets2).aHH();
                }
                com_fossil_eth.Fs -= j2;
                this.Fs += j2;
                j -= j2;
            }
        }
    }

    public long mo2733b(eth com_fossil_eth, long j) {
        if (com_fossil_eth == null) {
            throw new IllegalArgumentException("sink == null");
        } else if (j < 0) {
            throw new IllegalArgumentException("byteCount < 0: " + j);
        } else if (this.Fs == 0) {
            return -1;
        } else {
            if (j > this.Fs) {
                j = this.Fs;
            }
            com_fossil_eth.mo2728a(this, j);
            return j;
        }
    }

    public long mo3047g(byte b) {
        return m11154a(b, 0);
    }

    public long m11154a(byte b, long j) {
        if (j < 0) {
            throw new IllegalArgumentException("fromIndex < 0");
        }
        ets com_fossil_ets = this.dTh;
        if (com_fossil_ets == null) {
            return -1;
        }
        ets com_fossil_ets2 = com_fossil_ets;
        long j2 = 0;
        do {
            int i = com_fossil_ets2.limit - com_fossil_ets2.pos;
            if (j >= ((long) i)) {
                j -= (long) i;
            } else {
                byte[] bArr = com_fossil_ets2.data;
                int i2 = com_fossil_ets2.limit;
                for (int i3 = (int) (((long) com_fossil_ets2.pos) + j); i3 < i2; i3++) {
                    if (bArr[i3] == b) {
                        return (j2 + ((long) i3)) - ((long) com_fossil_ets2.pos);
                    }
                }
                j = 0;
            }
            j2 += (long) i;
            com_fossil_ets2 = com_fossil_ets2.dTA;
        } while (com_fossil_ets2 != this.dTh);
        return -1;
    }

    public void flush() {
    }

    public void close() {
    }

    public etw aAf() {
        return etw.dTD;
    }

    public boolean equals(Object obj) {
        long j = 0;
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof eth)) {
            return false;
        }
        eth com_fossil_eth = (eth) obj;
        if (this.Fs != com_fossil_eth.Fs) {
            return false;
        }
        if (this.Fs == 0) {
            return true;
        }
        ets com_fossil_ets = this.dTh;
        ets com_fossil_ets2 = com_fossil_eth.dTh;
        int i = com_fossil_ets.pos;
        int i2 = com_fossil_ets2.pos;
        while (j < this.Fs) {
            long min = (long) Math.min(com_fossil_ets.limit - i, com_fossil_ets2.limit - i2);
            int i3 = 0;
            while (((long) i3) < min) {
                int i4 = i + 1;
                byte b = com_fossil_ets.data[i];
                i = i2 + 1;
                if (b != com_fossil_ets2.data[i2]) {
                    return false;
                }
                i3++;
                i2 = i;
                i = i4;
            }
            if (i == com_fossil_ets.limit) {
                com_fossil_ets = com_fossil_ets.dTA;
                i = com_fossil_ets.pos;
            }
            if (i2 == com_fossil_ets2.limit) {
                com_fossil_ets2 = com_fossil_ets2.dTA;
                i2 = com_fossil_ets2.pos;
            }
            j += min;
        }
        return true;
    }

    public int hashCode() {
        ets com_fossil_ets = this.dTh;
        if (com_fossil_ets == null) {
            return 0;
        }
        int i = 1;
        do {
            int i2 = com_fossil_ets.pos;
            while (i2 < com_fossil_ets.limit) {
                int i3 = com_fossil_ets.data[i2] + (i * 31);
                i2++;
                i = i3;
            }
            com_fossil_ets = com_fossil_ets.dTA;
        } while (com_fossil_ets != this.dTh);
        return i;
    }

    public String toString() {
        if (this.Fs == 0) {
            return "Buffer[size=0]";
        }
        if (this.Fs <= 16) {
            ByteString aAt = aHr().aAt();
            return String.format("Buffer[size=%s data=%s]", new Object[]{Long.valueOf(this.Fs), aAt.hex()});
        }
        try {
            MessageDigest instance = MessageDigest.getInstance("MD5");
            instance.update(this.dTh.data, this.dTh.pos, this.dTh.limit - this.dTh.pos);
            for (ets com_fossil_ets = this.dTh.dTA; com_fossil_ets != this.dTh; com_fossil_ets = com_fossil_ets.dTA) {
                instance.update(com_fossil_ets.data, com_fossil_ets.pos, com_fossil_ets.limit - com_fossil_ets.pos);
            }
            return String.format("Buffer[size=%s md5=%s]", new Object[]{Long.valueOf(this.Fs), ByteString.of(instance.digest()).hex()});
        } catch (NoSuchAlgorithmException e) {
            throw new AssertionError();
        }
    }

    public eth aHr() {
        eth com_fossil_eth = new eth();
        if (this.Fs == 0) {
            return com_fossil_eth;
        }
        com_fossil_eth.dTh = new ets(this.dTh);
        ets com_fossil_ets = com_fossil_eth.dTh;
        ets com_fossil_ets2 = com_fossil_eth.dTh;
        ets com_fossil_ets3 = com_fossil_eth.dTh;
        com_fossil_ets2.dTB = com_fossil_ets3;
        com_fossil_ets.dTA = com_fossil_ets3;
        for (com_fossil_ets = this.dTh.dTA; com_fossil_ets != this.dTh; com_fossil_ets = com_fossil_ets.dTA) {
            com_fossil_eth.dTh.dTB.m11193a(new ets(com_fossil_ets));
        }
        com_fossil_eth.Fs = this.Fs;
        return com_fossil_eth;
    }
}
