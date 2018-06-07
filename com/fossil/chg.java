package com.fossil;

import com.google.i18n.phonenumbers.repackaged.com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import java.io.IOException;

public final class chg {
    private int bWe;
    private int bWf;
    private int bWg;
    private int bWh;
    private int bWi = Integer.MAX_VALUE;
    private int bWj;
    private int bWk = 64;
    private int bWl = 67108864;
    private final byte[] buffer;
    private int bufferSize;

    public static chg ao(byte[] bArr) {
        return m6415i(bArr, 0, bArr.length);
    }

    public static chg m6415i(byte[] bArr, int i, int i2) {
        return new chg(bArr, i, i2);
    }

    public int XF() throws IOException {
        if (XN()) {
            this.bWh = 0;
            return 0;
        }
        this.bWh = XJ();
        if (this.bWh != 0) {
            return this.bWh;
        }
        throw InvalidProtocolBufferNanoException.invalidTag();
    }

    public void iY(int i) throws InvalidProtocolBufferNanoException {
        if (this.bWh != i) {
            throw InvalidProtocolBufferNanoException.invalidEndTag();
        }
    }

    public boolean iZ(int i) throws IOException {
        switch (chk.jf(i)) {
            case 0:
                XH();
                return true;
            case 1:
                XL();
                return true;
            case 2:
                je(XJ());
                return true;
            case 3:
                XG();
                iY(chk.bo(chk.jg(i), 4));
                return true;
            case 4:
                return false;
            case 5:
                XK();
                return true;
            default:
                throw InvalidProtocolBufferNanoException.invalidWireType();
        }
    }

    public void XG() throws IOException {
        int XF;
        do {
            XF = XF();
            if (XF == 0) {
                return;
            }
        } while (iZ(XF));
    }

    public int XH() throws IOException {
        return XJ();
    }

    public boolean XI() throws IOException {
        return XJ() != 0;
    }

    public String readString() throws IOException {
        int XJ = XJ();
        if (XJ > this.bufferSize - this.bWg || XJ <= 0) {
            return new String(jd(XJ), "UTF-8");
        }
        String str = new String(this.buffer, this.bWg, XJ, "UTF-8");
        this.bWg = XJ + this.bWg;
        return str;
    }

    public void m6416a(chi com_fossil_chi) throws IOException {
        int XJ = XJ();
        if (this.bWj >= this.bWk) {
            throw InvalidProtocolBufferNanoException.recursionLimitExceeded();
        }
        XJ = ja(XJ);
        this.bWj++;
        com_fossil_chi.mo1701b(this);
        iY(0);
        this.bWj--;
        jb(XJ);
    }

    public int XJ() throws IOException {
        byte XO = XO();
        if (XO >= (byte) 0) {
            return XO;
        }
        int i = XO & 127;
        byte XO2 = XO();
        if (XO2 >= (byte) 0) {
            return i | (XO2 << 7);
        }
        i |= (XO2 & 127) << 7;
        XO2 = XO();
        if (XO2 >= (byte) 0) {
            return i | (XO2 << 14);
        }
        i |= (XO2 & 127) << 14;
        XO2 = XO();
        if (XO2 >= (byte) 0) {
            return i | (XO2 << 21);
        }
        i |= (XO2 & 127) << 21;
        XO2 = XO();
        i |= XO2 << 28;
        if (XO2 >= (byte) 0) {
            return i;
        }
        for (int i2 = 0; i2 < 5; i2++) {
            if (XO() >= (byte) 0) {
                return i;
            }
        }
        throw InvalidProtocolBufferNanoException.malformedVarint();
    }

    public int XK() throws IOException {
        return (((XO() & 255) | ((XO() & 255) << 8)) | ((XO() & 255) << 16)) | ((XO() & 255) << 24);
    }

    public long XL() throws IOException {
        byte XO = XO();
        byte XO2 = XO();
        return ((((((((((long) XO2) & 255) << 8) | (((long) XO) & 255)) | ((((long) XO()) & 255) << 16)) | ((((long) XO()) & 255) << 24)) | ((((long) XO()) & 255) << 32)) | ((((long) XO()) & 255) << 40)) | ((((long) XO()) & 255) << 48)) | ((((long) XO()) & 255) << 56);
    }

    private chg(byte[] bArr, int i, int i2) {
        this.buffer = bArr;
        this.bWe = i;
        this.bufferSize = i + i2;
        this.bWg = i;
    }

    public int ja(int i) throws InvalidProtocolBufferNanoException {
        if (i < 0) {
            throw InvalidProtocolBufferNanoException.negativeSize();
        }
        int i2 = this.bWg + i;
        int i3 = this.bWi;
        if (i2 > i3) {
            throw InvalidProtocolBufferNanoException.truncatedMessage();
        }
        this.bWi = i2;
        XM();
        return i3;
    }

    private void XM() {
        this.bufferSize += this.bWf;
        int i = this.bufferSize;
        if (i > this.bWi) {
            this.bWf = i - this.bWi;
            this.bufferSize -= this.bWf;
            return;
        }
        this.bWf = 0;
    }

    public void jb(int i) {
        this.bWi = i;
        XM();
    }

    public boolean XN() {
        return this.bWg == this.bufferSize;
    }

    public int getPosition() {
        return this.bWg - this.bWe;
    }

    public void jc(int i) {
        if (i > this.bWg - this.bWe) {
            throw new IllegalArgumentException("Position " + i + " is beyond current " + (this.bWg - this.bWe));
        } else if (i < 0) {
            throw new IllegalArgumentException("Bad position " + i);
        } else {
            this.bWg = this.bWe + i;
        }
    }

    public byte XO() throws IOException {
        if (this.bWg == this.bufferSize) {
            throw InvalidProtocolBufferNanoException.truncatedMessage();
        }
        byte[] bArr = this.buffer;
        int i = this.bWg;
        this.bWg = i + 1;
        return bArr[i];
    }

    public byte[] jd(int i) throws IOException {
        if (i < 0) {
            throw InvalidProtocolBufferNanoException.negativeSize();
        } else if (this.bWg + i > this.bWi) {
            je(this.bWi - this.bWg);
            throw InvalidProtocolBufferNanoException.truncatedMessage();
        } else if (i <= this.bufferSize - this.bWg) {
            Object obj = new byte[i];
            System.arraycopy(this.buffer, this.bWg, obj, 0, i);
            this.bWg += i;
            return obj;
        } else {
            throw InvalidProtocolBufferNanoException.truncatedMessage();
        }
    }

    public void je(int i) throws IOException {
        if (i < 0) {
            throw InvalidProtocolBufferNanoException.negativeSize();
        } else if (this.bWg + i > this.bWi) {
            je(this.bWi - this.bWg);
            throw InvalidProtocolBufferNanoException.truncatedMessage();
        } else if (i <= this.bufferSize - this.bWg) {
            this.bWg += i;
        } else {
            throw InvalidProtocolBufferNanoException.truncatedMessage();
        }
    }
}
