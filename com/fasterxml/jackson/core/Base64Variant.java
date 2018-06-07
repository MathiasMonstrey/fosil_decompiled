package com.fasterxml.jackson.core;

import android.support.v8.renderscript.Allocation;
import com.fossil.aew;
import com.fossil.agn;
import java.io.Serializable;
import java.util.Arrays;

public final class Base64Variant implements Serializable {
    public static final int BASE64_VALUE_INVALID = -1;
    public static final int BASE64_VALUE_PADDING = -2;
    static final char PADDING_CHAR_NONE = '\u0000';
    private static final long serialVersionUID = 1;
    protected final transient int _maxLineLength;
    public final String _name;
    protected final transient char _paddingChar;
    protected final transient boolean _usesPadding;
    private final transient int[] aLm;
    private final transient char[] aLn;
    private final transient byte[] aLo;

    public Base64Variant(String str, String str2, boolean z, char c, int i) {
        int i2 = 0;
        this.aLm = new int[Allocation.USAGE_SHARED];
        this.aLn = new char[64];
        this.aLo = new byte[64];
        this._name = str;
        this._usesPadding = z;
        this._paddingChar = c;
        this._maxLineLength = i;
        int length = str2.length();
        if (length != 64) {
            throw new IllegalArgumentException("Base64Alphabet length must be exactly 64 (was " + length + ")");
        }
        str2.getChars(0, length, this.aLn, 0);
        Arrays.fill(this.aLm, -1);
        while (i2 < length) {
            char c2 = this.aLn[i2];
            this.aLo[i2] = (byte) c2;
            this.aLm[c2] = i2;
            i2++;
        }
        if (z) {
            this.aLm[c] = -2;
        }
    }

    public Base64Variant(Base64Variant base64Variant, String str, int i) {
        this(base64Variant, str, base64Variant._usesPadding, base64Variant._paddingChar, i);
    }

    public Base64Variant(Base64Variant base64Variant, String str, boolean z, char c, int i) {
        this.aLm = new int[Allocation.USAGE_SHARED];
        this.aLn = new char[64];
        this.aLo = new byte[64];
        this._name = str;
        Object obj = base64Variant.aLo;
        System.arraycopy(obj, 0, this.aLo, 0, obj.length);
        obj = base64Variant.aLn;
        System.arraycopy(obj, 0, this.aLn, 0, obj.length);
        obj = base64Variant.aLm;
        System.arraycopy(obj, 0, this.aLm, 0, obj.length);
        this._usesPadding = z;
        this._paddingChar = c;
        this._maxLineLength = i;
    }

    protected Object readResolve() {
        return aew.aP(this._name);
    }

    public String getName() {
        return this._name;
    }

    public boolean usesPadding() {
        return this._usesPadding;
    }

    public boolean usesPaddingChar(char c) {
        return c == this._paddingChar;
    }

    public boolean usesPaddingChar(int i) {
        return i == this._paddingChar;
    }

    public char getPaddingChar() {
        return this._paddingChar;
    }

    public byte getPaddingByte() {
        return (byte) this._paddingChar;
    }

    public int getMaxLineLength() {
        return this._maxLineLength;
    }

    public int decodeBase64Char(char c) {
        return c <= '' ? this.aLm[c] : -1;
    }

    public int decodeBase64Char(int i) {
        return i <= 127 ? this.aLm[i] : -1;
    }

    public int decodeBase64Byte(byte b) {
        return b <= Byte.MAX_VALUE ? this.aLm[b] : -1;
    }

    public char encodeBase64BitsAsChar(int i) {
        return this.aLn[i];
    }

    public int encodeBase64Chunk(int i, char[] cArr, int i2) {
        int i3 = i2 + 1;
        cArr[i2] = this.aLn[(i >> 18) & 63];
        int i4 = i3 + 1;
        cArr[i3] = this.aLn[(i >> 12) & 63];
        i3 = i4 + 1;
        cArr[i4] = this.aLn[(i >> 6) & 63];
        i4 = i3 + 1;
        cArr[i3] = this.aLn[i & 63];
        return i4;
    }

    public void encodeBase64Chunk(StringBuilder stringBuilder, int i) {
        stringBuilder.append(this.aLn[(i >> 18) & 63]);
        stringBuilder.append(this.aLn[(i >> 12) & 63]);
        stringBuilder.append(this.aLn[(i >> 6) & 63]);
        stringBuilder.append(this.aLn[i & 63]);
    }

    public int encodeBase64Partial(int i, int i2, char[] cArr, int i3) {
        int i4 = i3 + 1;
        cArr[i3] = this.aLn[(i >> 18) & 63];
        int i5 = i4 + 1;
        cArr[i4] = this.aLn[(i >> 12) & 63];
        if (this._usesPadding) {
            int i6 = i5 + 1;
            cArr[i5] = i2 == 2 ? this.aLn[(i >> 6) & 63] : this._paddingChar;
            i4 = i6 + 1;
            cArr[i6] = this._paddingChar;
            return i4;
        } else if (i2 != 2) {
            return i5;
        } else {
            i4 = i5 + 1;
            cArr[i5] = this.aLn[(i >> 6) & 63];
            return i4;
        }
    }

    public void encodeBase64Partial(StringBuilder stringBuilder, int i, int i2) {
        stringBuilder.append(this.aLn[(i >> 18) & 63]);
        stringBuilder.append(this.aLn[(i >> 12) & 63]);
        if (this._usesPadding) {
            stringBuilder.append(i2 == 2 ? this.aLn[(i >> 6) & 63] : this._paddingChar);
            stringBuilder.append(this._paddingChar);
        } else if (i2 == 2) {
            stringBuilder.append(this.aLn[(i >> 6) & 63]);
        }
    }

    public byte encodeBase64BitsAsByte(int i) {
        return this.aLo[i];
    }

    public int encodeBase64Chunk(int i, byte[] bArr, int i2) {
        int i3 = i2 + 1;
        bArr[i2] = this.aLo[(i >> 18) & 63];
        int i4 = i3 + 1;
        bArr[i3] = this.aLo[(i >> 12) & 63];
        i3 = i4 + 1;
        bArr[i4] = this.aLo[(i >> 6) & 63];
        i4 = i3 + 1;
        bArr[i3] = this.aLo[i & 63];
        return i4;
    }

    public int encodeBase64Partial(int i, int i2, byte[] bArr, int i3) {
        int i4 = i3 + 1;
        bArr[i3] = this.aLo[(i >> 18) & 63];
        int i5 = i4 + 1;
        bArr[i4] = this.aLo[(i >> 12) & 63];
        if (this._usesPadding) {
            byte b = (byte) this._paddingChar;
            int i6 = i5 + 1;
            bArr[i5] = i2 == 2 ? this.aLo[(i >> 6) & 63] : b;
            i4 = i6 + 1;
            bArr[i6] = b;
            return i4;
        } else if (i2 != 2) {
            return i5;
        } else {
            i4 = i5 + 1;
            bArr[i5] = this.aLo[(i >> 6) & 63];
            return i4;
        }
    }

    public String encode(byte[] bArr) {
        return encode(bArr, false);
    }

    public String encode(byte[] bArr, boolean z) {
        int i;
        int length = bArr.length;
        StringBuilder stringBuilder = new StringBuilder(((length >> 2) + length) + (length >> 3));
        if (z) {
            stringBuilder.append('\"');
        }
        int i2 = 0;
        int i3 = length - 3;
        int maxLineLength = getMaxLineLength() >> 2;
        while (i2 <= i3) {
            i = i2 + 1;
            int i4 = i + 1;
            i = i4 + 1;
            encodeBase64Chunk(stringBuilder, (((bArr[i2] << 8) | (bArr[i] & 255)) << 8) | (bArr[i4] & 255));
            i2 = maxLineLength - 1;
            if (i2 <= 0) {
                stringBuilder.append('\\');
                stringBuilder.append('n');
                i2 = getMaxLineLength() >> 2;
            }
            maxLineLength = i2;
            i2 = i;
        }
        i = length - i2;
        if (i > 0) {
            maxLineLength = i2 + 1;
            i2 = bArr[i2] << 16;
            if (i == 2) {
                length = maxLineLength + 1;
                i2 |= (bArr[maxLineLength] & 255) << 8;
            }
            encodeBase64Partial(stringBuilder, i2, i);
        }
        if (z) {
            stringBuilder.append('\"');
        }
        return stringBuilder.toString();
    }

    public byte[] decode(String str) throws IllegalArgumentException {
        agn com_fossil_agn = new agn();
        decode(str, com_fossil_agn);
        return com_fossil_agn.toByteArray();
    }

    public void decode(String str, agn com_fossil_agn) throws IllegalArgumentException {
        int length = str.length();
        int i = 0;
        while (i < length) {
            int i2;
            char charAt;
            while (true) {
                i2 = i + 1;
                charAt = str.charAt(i);
                if (i2 < length) {
                    if (charAt > ' ') {
                        break;
                    }
                    i = i2;
                } else {
                    return;
                }
            }
            int decodeBase64Char = decodeBase64Char(charAt);
            if (decodeBase64Char < 0) {
                _reportInvalidBase64(charAt, 0, null);
            }
            if (i2 >= length) {
                _reportBase64EOF();
            }
            i = i2 + 1;
            char charAt2 = str.charAt(i2);
            int decodeBase64Char2 = decodeBase64Char(charAt2);
            if (decodeBase64Char2 < 0) {
                _reportInvalidBase64(charAt2, 1, null);
            }
            i2 = (decodeBase64Char << 6) | decodeBase64Char2;
            if (i >= length) {
                if (usesPadding()) {
                    _reportBase64EOF();
                } else {
                    com_fossil_agn.append(i2 >> 4);
                    return;
                }
            }
            decodeBase64Char = i + 1;
            charAt = str.charAt(i);
            decodeBase64Char2 = decodeBase64Char(charAt);
            char charAt3;
            if (decodeBase64Char2 < 0) {
                if (decodeBase64Char2 != -2) {
                    _reportInvalidBase64(charAt, 2, null);
                }
                if (decodeBase64Char >= length) {
                    _reportBase64EOF();
                }
                i = decodeBase64Char + 1;
                charAt3 = str.charAt(decodeBase64Char);
                if (!usesPaddingChar(charAt3)) {
                    _reportInvalidBase64(charAt3, 3, "expected padding character '" + getPaddingChar() + "'");
                }
                com_fossil_agn.append(i2 >> 4);
            } else {
                i2 = (i2 << 6) | decodeBase64Char2;
                if (decodeBase64Char >= length) {
                    if (usesPadding()) {
                        _reportBase64EOF();
                    } else {
                        com_fossil_agn.gG(i2 >> 2);
                        return;
                    }
                }
                i = decodeBase64Char + 1;
                charAt3 = str.charAt(decodeBase64Char);
                decodeBase64Char2 = decodeBase64Char(charAt3);
                if (decodeBase64Char2 < 0) {
                    if (decodeBase64Char2 != -2) {
                        _reportInvalidBase64(charAt3, 3, null);
                    }
                    com_fossil_agn.gG(i2 >> 2);
                } else {
                    com_fossil_agn.gH((i2 << 6) | decodeBase64Char2);
                }
            }
        }
    }

    public String toString() {
        return this._name;
    }

    public boolean equals(Object obj) {
        return obj == this;
    }

    public int hashCode() {
        return this._name.hashCode();
    }

    protected void _reportInvalidBase64(char c, int i, String str) throws IllegalArgumentException {
        String str2;
        if (c <= ' ') {
            str2 = "Illegal white space character (code 0x" + Integer.toHexString(c) + ") as character #" + (i + 1) + " of 4-char base64 unit: can only used between units";
        } else if (usesPaddingChar(c)) {
            str2 = "Unexpected padding character ('" + getPaddingChar() + "') as character #" + (i + 1) + " of 4-char base64 unit: padding only legal as 3rd or 4th character";
        } else if (!Character.isDefined(c) || Character.isISOControl(c)) {
            str2 = "Illegal character (code 0x" + Integer.toHexString(c) + ") in base64 content";
        } else {
            str2 = "Illegal character '" + c + "' (code 0x" + Integer.toHexString(c) + ") in base64 content";
        }
        if (str != null) {
            str2 = str2 + ": " + str;
        }
        throw new IllegalArgumentException(str2);
    }

    protected void _reportBase64EOF() throws IllegalArgumentException {
        throw new IllegalArgumentException("Unexpected end-of-String in base64 content");
    }
}
