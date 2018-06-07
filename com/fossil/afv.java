package com.fossil;

import android.support.v8.renderscript.Allocation;
import com.facebook.internal.NativeProtocol;
import java.io.IOException;
import java.io.OutputStream;
import java.io.Writer;

public final class afv extends Writer {
    private final afo aNK;
    private OutputStream aNR;
    private byte[] aNS;
    private final int aNT;
    private int aNU;
    private int aNV = 0;

    public afv(afo com_fossil_afo, OutputStream outputStream) {
        this.aNK = com_fossil_afo;
        this.aNR = outputStream;
        this.aNS = com_fossil_afo.BC();
        this.aNT = this.aNS.length - 4;
        this.aNU = 0;
    }

    public Writer append(char c) throws IOException {
        write((int) c);
        return this;
    }

    public void close() throws IOException {
        if (this.aNR != null) {
            if (this.aNU > 0) {
                this.aNR.write(this.aNS, 0, this.aNU);
                this.aNU = 0;
            }
            OutputStream outputStream = this.aNR;
            this.aNR = null;
            byte[] bArr = this.aNS;
            if (bArr != null) {
                this.aNS = null;
                this.aNK.m3146T(bArr);
            }
            outputStream.close();
            int i = this.aNV;
            this.aNV = 0;
            if (i > 0) {
                fD(i);
            }
        }
    }

    public void flush() throws IOException {
        if (this.aNR != null) {
            if (this.aNU > 0) {
                this.aNR.write(this.aNS, 0, this.aNU);
                this.aNU = 0;
            }
            this.aNR.flush();
        }
    }

    public void write(char[] cArr) throws IOException {
        write(cArr, 0, cArr.length);
    }

    public void write(char[] cArr, int i, int i2) throws IOException {
        if (i2 >= 2) {
            int i3;
            if (this.aNV > 0) {
                i3 = i + 1;
                i2--;
                write(fC(cArr[i]));
                i = i3;
            }
            i3 = this.aNU;
            byte[] bArr = this.aNS;
            int i4 = this.aNT;
            int i5 = i2 + i;
            int i6 = i;
            while (i6 < i5) {
                int i7;
                int i8;
                if (i3 >= i4) {
                    this.aNR.write(bArr, 0, i3);
                    i3 = 0;
                }
                int i9 = i6 + 1;
                char c = cArr[i6];
                char c2;
                if (c < '') {
                    i7 = i3 + 1;
                    bArr[i3] = (byte) c;
                    i6 = i5 - i9;
                    i3 = i4 - i7;
                    if (i6 <= i3) {
                        i3 = i6;
                    }
                    i8 = i3 + i9;
                    i6 = i7;
                    i3 = i9;
                    while (i3 < i8) {
                        i9 = i3 + 1;
                        char c3 = cArr[i3];
                        if (c3 >= '') {
                            c2 = c3;
                            i3 = i6;
                            i6 = i9;
                            i9 = c2;
                        } else {
                            i7 = i6 + 1;
                            bArr[i6] = (byte) c3;
                            i6 = i7;
                            i3 = i9;
                        }
                    }
                    int i10 = i6;
                    i6 = i3;
                    i3 = i10;
                } else {
                    c2 = c;
                    i6 = i9;
                    char c4 = c2;
                }
                if (i9 < 2048) {
                    i7 = i3 + 1;
                    bArr[i3] = (byte) ((i9 >> 6) | 192);
                    i3 = i7 + 1;
                    bArr[i7] = (byte) ((i9 & 63) | Allocation.USAGE_SHARED);
                } else if (i9 < 55296 || i9 > 57343) {
                    i7 = i3 + 1;
                    bArr[i3] = (byte) ((i9 >> 12) | 224);
                    i8 = i7 + 1;
                    bArr[i7] = (byte) (((i9 >> 6) & 63) | Allocation.USAGE_SHARED);
                    i3 = i8 + 1;
                    bArr[i8] = (byte) ((i9 & 63) | Allocation.USAGE_SHARED);
                } else {
                    if (i9 > 56319) {
                        this.aNU = i3;
                        fD(i9);
                    }
                    this.aNV = i9;
                    if (i6 >= i5) {
                        break;
                    }
                    i9 = i6 + 1;
                    i6 = fC(cArr[i6]);
                    if (i6 > 1114111) {
                        this.aNU = i3;
                        fD(i6);
                    }
                    i7 = i3 + 1;
                    bArr[i3] = (byte) ((i6 >> 18) | 240);
                    i3 = i7 + 1;
                    bArr[i7] = (byte) (((i6 >> 12) & 63) | Allocation.USAGE_SHARED);
                    i7 = i3 + 1;
                    bArr[i3] = (byte) (((i6 >> 6) & 63) | Allocation.USAGE_SHARED);
                    i3 = i7 + 1;
                    bArr[i7] = (byte) ((i6 & 63) | Allocation.USAGE_SHARED);
                    i6 = i9;
                }
            }
            this.aNU = i3;
        } else if (i2 == 1) {
            write(cArr[i]);
        }
    }

    public void write(int i) throws IOException {
        if (this.aNV > 0) {
            i = fC(i);
        } else if (i >= 55296 && i <= 57343) {
            if (i > 56319) {
                fD(i);
            }
            this.aNV = i;
            return;
        }
        if (this.aNU >= this.aNT) {
            this.aNR.write(this.aNS, 0, this.aNU);
            this.aNU = 0;
        }
        if (i < Allocation.USAGE_SHARED) {
            byte[] bArr = this.aNS;
            int i2 = this.aNU;
            this.aNU = i2 + 1;
            bArr[i2] = (byte) i;
            return;
        }
        int i3 = this.aNU;
        int i4;
        if (i < 2048) {
            i4 = i3 + 1;
            this.aNS[i3] = (byte) ((i >> 6) | 192);
            i3 = i4 + 1;
            this.aNS[i4] = (byte) ((i & 63) | Allocation.USAGE_SHARED);
        } else if (i <= 65535) {
            i4 = i3 + 1;
            this.aNS[i3] = (byte) ((i >> 12) | 224);
            i2 = i4 + 1;
            this.aNS[i4] = (byte) (((i >> 6) & 63) | Allocation.USAGE_SHARED);
            i3 = i2 + 1;
            this.aNS[i2] = (byte) ((i & 63) | Allocation.USAGE_SHARED);
        } else {
            if (i > 1114111) {
                fD(i);
            }
            i4 = i3 + 1;
            this.aNS[i3] = (byte) ((i >> 18) | 240);
            i2 = i4 + 1;
            this.aNS[i4] = (byte) (((i >> 12) & 63) | Allocation.USAGE_SHARED);
            i4 = i2 + 1;
            this.aNS[i2] = (byte) (((i >> 6) & 63) | Allocation.USAGE_SHARED);
            i3 = i4 + 1;
            this.aNS[i4] = (byte) ((i & 63) | Allocation.USAGE_SHARED);
        }
        this.aNU = i3;
    }

    public void write(String str) throws IOException {
        write(str, 0, str.length());
    }

    public void write(String str, int i, int i2) throws IOException {
        if (i2 >= 2) {
            int i3;
            if (this.aNV > 0) {
                i3 = i + 1;
                i2--;
                write(fC(str.charAt(i)));
                i = i3;
            }
            i3 = this.aNU;
            byte[] bArr = this.aNS;
            int i4 = this.aNT;
            int i5 = i2 + i;
            int i6 = i;
            while (i6 < i5) {
                int i7;
                int i8;
                if (i3 >= i4) {
                    this.aNR.write(bArr, 0, i3);
                    i3 = 0;
                }
                int i9 = i6 + 1;
                char charAt = str.charAt(i6);
                char c;
                if (charAt < '') {
                    i7 = i3 + 1;
                    bArr[i3] = (byte) charAt;
                    i6 = i5 - i9;
                    i3 = i4 - i7;
                    if (i6 <= i3) {
                        i3 = i6;
                    }
                    i8 = i3 + i9;
                    i6 = i7;
                    i3 = i9;
                    while (i3 < i8) {
                        i9 = i3 + 1;
                        char charAt2 = str.charAt(i3);
                        if (charAt2 >= '') {
                            c = charAt2;
                            i3 = i6;
                            i6 = i9;
                            i9 = c;
                        } else {
                            i7 = i6 + 1;
                            bArr[i6] = (byte) charAt2;
                            i6 = i7;
                            i3 = i9;
                        }
                    }
                    int i10 = i6;
                    i6 = i3;
                    i3 = i10;
                } else {
                    c = charAt;
                    i6 = i9;
                    char c2 = c;
                }
                if (i9 < 2048) {
                    i7 = i3 + 1;
                    bArr[i3] = (byte) ((i9 >> 6) | 192);
                    i3 = i7 + 1;
                    bArr[i7] = (byte) ((i9 & 63) | Allocation.USAGE_SHARED);
                } else if (i9 < 55296 || i9 > 57343) {
                    i7 = i3 + 1;
                    bArr[i3] = (byte) ((i9 >> 12) | 224);
                    i8 = i7 + 1;
                    bArr[i7] = (byte) (((i9 >> 6) & 63) | Allocation.USAGE_SHARED);
                    i3 = i8 + 1;
                    bArr[i8] = (byte) ((i9 & 63) | Allocation.USAGE_SHARED);
                } else {
                    if (i9 > 56319) {
                        this.aNU = i3;
                        fD(i9);
                    }
                    this.aNV = i9;
                    if (i6 >= i5) {
                        break;
                    }
                    i9 = i6 + 1;
                    i6 = fC(str.charAt(i6));
                    if (i6 > 1114111) {
                        this.aNU = i3;
                        fD(i6);
                    }
                    i7 = i3 + 1;
                    bArr[i3] = (byte) ((i6 >> 18) | 240);
                    i3 = i7 + 1;
                    bArr[i7] = (byte) (((i6 >> 12) & 63) | Allocation.USAGE_SHARED);
                    i7 = i3 + 1;
                    bArr[i3] = (byte) (((i6 >> 6) & 63) | Allocation.USAGE_SHARED);
                    i3 = i7 + 1;
                    bArr[i7] = (byte) ((i6 & 63) | Allocation.USAGE_SHARED);
                    i6 = i9;
                }
            }
            this.aNU = i3;
        } else if (i2 == 1) {
            write(str.charAt(i));
        }
    }

    protected int fC(int i) throws IOException {
        int i2 = this.aNV;
        this.aNV = 0;
        if (i >= 56320 && i <= 57343) {
            return (((i2 - 55296) << 10) + NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST) + (i - 56320);
        }
        throw new IOException("Broken surrogate pair: first char 0x" + Integer.toHexString(i2) + ", second 0x" + Integer.toHexString(i) + "; illegal combination");
    }

    protected static void fD(int i) throws IOException {
        throw new IOException(fE(i));
    }

    protected static String fE(int i) {
        if (i > 1114111) {
            return "Illegal character point (0x" + Integer.toHexString(i) + ") to output; max is 0x10FFFF as per RFC 4627";
        }
        if (i < 55296) {
            return "Illegal character point (0x" + Integer.toHexString(i) + ") to output";
        }
        if (i <= 56319) {
            return "Unmatched first part of surrogate pair (0x" + Integer.toHexString(i) + ")";
        }
        return "Unmatched second part of surrogate pair (0x" + Integer.toHexString(i) + ")";
    }
}
