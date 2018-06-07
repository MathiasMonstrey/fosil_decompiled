package com.fossil;

import com.facebook.internal.NativeProtocol;
import java.io.CharConversionException;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;

public class afu extends Reader {
    protected final boolean _bigEndian;
    protected InputStream aMQ;
    protected byte[] aMR;
    protected int aMU;
    protected final afo aNK;
    protected int aNL;
    protected char aNM = '\u0000';
    protected int aNN = 0;
    protected int aNO = 0;
    protected final boolean aNP;
    protected char[] aNQ = null;

    public afu(afo com_fossil_afo, InputStream inputStream, byte[] bArr, int i, int i2, boolean z) {
        boolean z2 = false;
        this.aNK = com_fossil_afo;
        this.aMQ = inputStream;
        this.aMR = bArr;
        this.aMU = i;
        this.aNL = i2;
        this._bigEndian = z;
        if (inputStream != null) {
            z2 = true;
        }
        this.aNP = z2;
    }

    public void close() throws IOException {
        InputStream inputStream = this.aMQ;
        if (inputStream != null) {
            this.aMQ = null;
            BK();
            inputStream.close();
        }
    }

    public int read() throws IOException {
        if (this.aNQ == null) {
            this.aNQ = new char[1];
        }
        if (read(this.aNQ, 0, 1) < 1) {
            return -1;
        }
        return this.aNQ[0];
    }

    public int read(char[] cArr, int i, int i2) throws IOException {
        if (this.aMR == null) {
            return -1;
        }
        if (i2 < 1) {
            return i2;
        }
        int i3;
        int i4;
        if (i < 0 || i + i2 > cArr.length) {
            m3175f(cArr, i, i2);
        }
        int i5 = i2 + i;
        if (this.aNM != '\u0000') {
            i3 = i + 1;
            cArr[i] = this.aNM;
            this.aNM = '\u0000';
        } else {
            i4 = this.aNL - this.aMU;
            if (i4 < 4 && !fB(i4)) {
                return -1;
            }
            i3 = i;
        }
        while (i3 < i5) {
            int i6 = this.aMU;
            if (this._bigEndian) {
                i6 = (this.aMR[i6 + 3] & 255) | (((this.aMR[i6] << 24) | ((this.aMR[i6 + 1] & 255) << 16)) | ((this.aMR[i6 + 2] & 255) << 8));
            } else {
                i6 = (this.aMR[i6 + 3] << 24) | (((this.aMR[i6] & 255) | ((this.aMR[i6 + 1] & 255) << 8)) | ((this.aMR[i6 + 2] & 255) << 16));
            }
            this.aMU += 4;
            if (i6 > 65535) {
                if (i6 > 1114111) {
                    m3174c(i6, i3 - i, "(above " + Integer.toHexString(1114111) + ") ");
                }
                i6 -= NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST;
                i4 = i3 + 1;
                cArr[i3] = (char) (55296 + (i6 >> 10));
                i6 = (i6 & 1023) | 56320;
                if (i4 >= i5) {
                    this.aNM = (char) i6;
                    break;
                }
            }
            i4 = i3;
            i3 = i4 + 1;
            cArr[i4] = (char) i6;
            if (this.aMU >= this.aNL) {
                i4 = i3;
                break;
            }
        }
        i4 = i3;
        i2 = i4 - i;
        this.aNN += i2;
        return i2;
    }

    private void br(int i, int i2) throws IOException {
        throw new CharConversionException("Unexpected EOF in the middle of a 4-byte UTF-32 char: got " + i + ", needed " + i2 + ", at char #" + this.aNN + ", byte #" + (this.aNO + i) + ")");
    }

    private void m3174c(int i, int i2, String str) throws IOException {
        throw new CharConversionException("Invalid UTF-32 character 0x" + Integer.toHexString(i) + str + " at char #" + (this.aNN + i2) + ", byte #" + ((this.aNO + this.aMU) - 1) + ")");
    }

    private boolean fB(int i) throws IOException {
        this.aNO += this.aNL - i;
        if (i > 0) {
            if (this.aMU > 0) {
                System.arraycopy(this.aMR, this.aMU, this.aMR, 0, i);
                this.aMU = 0;
            }
            this.aNL = i;
        } else {
            this.aMU = 0;
            int read = this.aMQ == null ? -1 : this.aMQ.read(this.aMR);
            if (read < 1) {
                this.aNL = 0;
                if (read >= 0) {
                    BL();
                } else if (!this.aNP) {
                    return false;
                } else {
                    BK();
                    return false;
                }
            }
            this.aNL = read;
        }
        while (this.aNL < 4) {
            int i2;
            if (this.aMQ == null) {
                i2 = -1;
            } else {
                i2 = this.aMQ.read(this.aMR, this.aNL, this.aMR.length - this.aNL);
            }
            if (i2 < 1) {
                if (i2 < 0) {
                    if (this.aNP) {
                        BK();
                    }
                    br(this.aNL, 4);
                }
                BL();
            }
            this.aNL = i2 + this.aNL;
        }
        return true;
    }

    private void BK() {
        byte[] bArr = this.aMR;
        if (bArr != null) {
            this.aMR = null;
            this.aNK.m3145S(bArr);
        }
    }

    private void m3175f(char[] cArr, int i, int i2) throws IOException {
        throw new ArrayIndexOutOfBoundsException("read(buf," + i + "," + i2 + "), cbuf[" + cArr.length + "]");
    }

    private void BL() throws IOException {
        throw new IOException("Strange I/O stream, returned 0 bytes on read");
    }
}
