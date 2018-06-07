package com.fossil;

import android.support.v8.renderscript.Allocation;
import com.facebook.internal.NativeProtocol;
import com.google.android.gms.internal.adi;
import java.io.IOException;
import java.nio.BufferOverflowException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.ReadOnlyBufferException;

public final class bci {
    private final ByteBuffer bqo;

    private bci(ByteBuffer byteBuffer) {
        this.bqo = byteBuffer;
        this.bqo.order(ByteOrder.LITTLE_ENDIAN);
    }

    private bci(byte[] bArr, int i, int i2) {
        this(ByteBuffer.wrap(bArr, i, i2));
    }

    private final void m4836P(long j) throws IOException {
        while ((-128 & j) != 0) {
            hS((((int) j) & 127) | Allocation.USAGE_SHARED);
            j >>>= 7;
        }
        hS((int) j);
    }

    public static int m4837Q(long j) {
        return (-128 & j) == 0 ? 1 : (-16384 & j) == 0 ? 2 : (-2097152 & j) == 0 ? 3 : (-268435456 & j) == 0 ? 4 : (-34359738368L & j) == 0 ? 5 : (-4398046511104L & j) == 0 ? 6 : (-562949953421312L & j) == 0 ? 7 : (-72057594037927936L & j) == 0 ? 8 : (Long.MIN_VALUE & j) == 0 ? 9 : 10;
    }

    private final void m4838R(long j) throws IOException {
        if (this.bqo.remaining() < 8) {
            throw new adi(this.bqo.position(), this.bqo.limit());
        }
        this.bqo.putLong(j);
    }

    private static int m4839a(CharSequence charSequence, byte[] bArr, int i, int i2) {
        int length = charSequence.length();
        int i3 = 0;
        int i4 = i + i2;
        while (i3 < length && i3 + i < i4) {
            char charAt = charSequence.charAt(i3);
            if (charAt >= '') {
                break;
            }
            bArr[i + i3] = (byte) charAt;
            i3++;
        }
        if (i3 == length) {
            return i + length;
        }
        int i5 = i + i3;
        while (i3 < length) {
            int i6;
            char charAt2 = charSequence.charAt(i3);
            if (charAt2 < '' && i5 < i4) {
                i6 = i5 + 1;
                bArr[i5] = (byte) charAt2;
            } else if (charAt2 < 'ࠀ' && i5 <= i4 - 2) {
                r6 = i5 + 1;
                bArr[i5] = (byte) ((charAt2 >>> 6) | 960);
                i6 = r6 + 1;
                bArr[r6] = (byte) ((charAt2 & 63) | Allocation.USAGE_SHARED);
            } else if ((charAt2 < '?' || '?' < charAt2) && i5 <= i4 - 3) {
                i6 = i5 + 1;
                bArr[i5] = (byte) ((charAt2 >>> 12) | 480);
                i5 = i6 + 1;
                bArr[i6] = (byte) (((charAt2 >>> 6) & 63) | Allocation.USAGE_SHARED);
                i6 = i5 + 1;
                bArr[i5] = (byte) ((charAt2 & 63) | Allocation.USAGE_SHARED);
            } else if (i5 <= i4 - 4) {
                if (i3 + 1 != charSequence.length()) {
                    i3++;
                    charAt = charSequence.charAt(i3);
                    if (Character.isSurrogatePair(charAt2, charAt)) {
                        int toCodePoint = Character.toCodePoint(charAt2, charAt);
                        i6 = i5 + 1;
                        bArr[i5] = (byte) ((toCodePoint >>> 18) | 240);
                        i5 = i6 + 1;
                        bArr[i6] = (byte) (((toCodePoint >>> 12) & 63) | Allocation.USAGE_SHARED);
                        r6 = i5 + 1;
                        bArr[i5] = (byte) (((toCodePoint >>> 6) & 63) | Allocation.USAGE_SHARED);
                        i6 = r6 + 1;
                        bArr[r6] = (byte) ((toCodePoint & 63) | Allocation.USAGE_SHARED);
                    }
                }
                throw new IllegalArgumentException("Unpaired surrogate at index " + (i3 - 1));
            } else {
                throw new ArrayIndexOutOfBoundsException("Failed writing " + charAt2 + " at index " + i5);
            }
            i3++;
            i5 = i6;
        }
        return i5;
    }

    private static void m4840a(CharSequence charSequence, ByteBuffer byteBuffer) {
        if (byteBuffer.isReadOnly()) {
            throw new ReadOnlyBufferException();
        } else if (byteBuffer.hasArray()) {
            try {
                byteBuffer.position(m4839a(charSequence, byteBuffer.array(), byteBuffer.arrayOffset() + byteBuffer.position(), byteBuffer.remaining()) - byteBuffer.arrayOffset());
            } catch (Throwable e) {
                BufferOverflowException bufferOverflowException = new BufferOverflowException();
                bufferOverflowException.initCause(e);
                throw bufferOverflowException;
            }
        } else {
            m4842b(charSequence, byteBuffer);
        }
    }

    public static bci ad(byte[] bArr) {
        return m4843h(bArr, 0, bArr.length);
    }

    public static int ae(byte[] bArr) {
        return hV(bArr.length) + bArr.length;
    }

    public static int m4841b(int i, bco com_fossil_bco) {
        int hT = hT(i);
        int MW = com_fossil_bco.MW();
        return hT + (MW + hV(MW));
    }

    private static void m4842b(CharSequence charSequence, ByteBuffer byteBuffer) {
        int length = charSequence.length();
        int i = 0;
        while (i < length) {
            char charAt = charSequence.charAt(i);
            if (charAt < '') {
                byteBuffer.put((byte) charAt);
            } else if (charAt < 'ࠀ') {
                byteBuffer.put((byte) ((charAt >>> 6) | 960));
                byteBuffer.put((byte) ((charAt & 63) | Allocation.USAGE_SHARED));
            } else if (charAt < '?' || '?' < charAt) {
                byteBuffer.put((byte) ((charAt >>> 12) | 480));
                byteBuffer.put((byte) (((charAt >>> 6) & 63) | Allocation.USAGE_SHARED));
                byteBuffer.put((byte) ((charAt & 63) | Allocation.USAGE_SHARED));
            } else {
                if (i + 1 != charSequence.length()) {
                    i++;
                    char charAt2 = charSequence.charAt(i);
                    if (Character.isSurrogatePair(charAt, charAt2)) {
                        int toCodePoint = Character.toCodePoint(charAt, charAt2);
                        byteBuffer.put((byte) ((toCodePoint >>> 18) | 240));
                        byteBuffer.put((byte) (((toCodePoint >>> 12) & 63) | Allocation.USAGE_SHARED));
                        byteBuffer.put((byte) (((toCodePoint >>> 6) & 63) | Allocation.USAGE_SHARED));
                        byteBuffer.put((byte) ((toCodePoint & 63) | Allocation.USAGE_SHARED));
                    }
                }
                throw new IllegalArgumentException("Unpaired surrogate at index " + (i - 1));
            }
            i++;
        }
    }

    public static int bM(int i, int i2) {
        return hT(i) + hR(i2);
    }

    public static int dF(String str) {
        int t = m4846t(str);
        return t + hV(t);
    }

    public static bci m4843h(byte[] bArr, int i, int i2) {
        return new bci(bArr, 0, i2);
    }

    public static int hR(int i) {
        return i >= 0 ? hV(i) : 10;
    }

    private final void hS(int i) throws IOException {
        byte b = (byte) i;
        if (this.bqo.hasRemaining()) {
            this.bqo.put(b);
            return;
        }
        throw new adi(this.bqo.position(), this.bqo.limit());
    }

    public static int hT(int i) {
        return hV(i << 3);
    }

    public static int hV(int i) {
        return (i & -128) == 0 ? 1 : (i & -16384) == 0 ? 2 : (-2097152 & i) == 0 ? 3 : (-268435456 & i) == 0 ? 4 : 5;
    }

    public static int m4844j(int i, long j) {
        return hT(i) + m4837Q(j);
    }

    public static int m4845k(int i, String str) {
        return hT(i) + dF(str);
    }

    private static int m4846t(CharSequence charSequence) {
        int i = 0;
        int length = charSequence.length();
        int i2 = 0;
        while (i2 < length && charSequence.charAt(i2) < '') {
            i2++;
        }
        int i3 = length;
        while (i2 < length) {
            char charAt = charSequence.charAt(i2);
            if (charAt < 'ࠀ') {
                i3 += (127 - charAt) >>> 31;
                i2++;
            } else {
                int length2 = charSequence.length();
                while (i2 < length2) {
                    char charAt2 = charSequence.charAt(i2);
                    if (charAt2 < 'ࠀ') {
                        i += (127 - charAt2) >>> 31;
                    } else {
                        i += 2;
                        if ('?' <= charAt2 && charAt2 <= '?') {
                            if (Character.codePointAt(charSequence, i2) < NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST) {
                                throw new IllegalArgumentException("Unpaired surrogate at index " + i2);
                            }
                            i2++;
                        }
                    }
                    i2++;
                }
                i2 = i3 + i;
                if (i2 < length) {
                    return i2;
                }
                throw new IllegalArgumentException("UTF-8 length does not fit in int: " + (((long) i2) + 4294967296L));
            }
        }
        i2 = i3;
        if (i2 < length) {
            return i2;
        }
        throw new IllegalArgumentException("UTF-8 length does not fit in int: " + (((long) i2) + 4294967296L));
    }

    public final void MQ() {
        if (this.bqo.remaining() != 0) {
            throw new IllegalStateException("Did not write as much data as expected.");
        }
    }

    public final void m4847a(int i, double d) throws IOException {
        bN(i, 1);
        m4838R(Double.doubleToLongBits(d));
    }

    public final void m4848a(int i, bco com_fossil_bco) throws IOException {
        bN(i, 2);
        m4849b(com_fossil_bco);
    }

    public final void af(byte[] bArr) throws IOException {
        int length = bArr.length;
        if (this.bqo.remaining() >= length) {
            this.bqo.put(bArr, 0, length);
            return;
        }
        throw new adi(this.bqo.position(), this.bqo.limit());
    }

    public final void m4849b(bco com_fossil_bco) throws IOException {
        hU(com_fossil_bco.MV());
        com_fossil_bco.mo1264a(this);
    }

    public final void bL(int i, int i2) throws IOException {
        bN(i, 0);
        if (i2 >= 0) {
            hU(i2);
        } else {
            m4836P((long) i2);
        }
    }

    public final void bN(int i, int i2) throws IOException {
        hU((i << 3) | i2);
    }

    public final void m4850c(int i, byte[] bArr) throws IOException {
        bN(i, 2);
        hU(bArr.length);
        af(bArr);
    }

    public final void m4851g(int i, float f) throws IOException {
        bN(i, 5);
        int floatToIntBits = Float.floatToIntBits(f);
        if (this.bqo.remaining() < 4) {
            throw new adi(this.bqo.position(), this.bqo.limit());
        }
        this.bqo.putInt(floatToIntBits);
    }

    public final void m4852h(int i, long j) throws IOException {
        bN(i, 0);
        m4836P(j);
    }

    public final void hU(int i) throws IOException {
        while ((i & -128) != 0) {
            hS((i & 127) | Allocation.USAGE_SHARED);
            i >>>= 7;
        }
        hS(i);
    }

    public final void m4853i(int i, long j) throws IOException {
        bN(i, 0);
        m4836P(j);
    }

    public final void m4854j(int i, String str) throws IOException {
        bN(i, 2);
        try {
            int hV = hV(str.length());
            if (hV == hV(str.length() * 3)) {
                int position = this.bqo.position();
                if (this.bqo.remaining() < hV) {
                    throw new adi(hV + position, this.bqo.limit());
                }
                this.bqo.position(position + hV);
                m4840a((CharSequence) str, this.bqo);
                int position2 = this.bqo.position();
                this.bqo.position(position);
                hU((position2 - position) - hV);
                this.bqo.position(position2);
                return;
            }
            hU(m4846t(str));
            m4840a((CharSequence) str, this.bqo);
        } catch (Throwable e) {
            adi com_google_android_gms_internal_adi = new adi(this.bqo.position(), this.bqo.limit());
            com_google_android_gms_internal_adi.initCause(e);
            throw com_google_android_gms_internal_adi;
        }
    }

    public final void m4855r(int i, boolean z) throws IOException {
        int i2 = 0;
        bN(i, 0);
        if (z) {
            i2 = 1;
        }
        byte b = (byte) i2;
        if (this.bqo.hasRemaining()) {
            this.bqo.put(b);
            return;
        }
        throw new adi(this.bqo.position(), this.bqo.limit());
    }
}
