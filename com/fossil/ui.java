package com.fossil;

import com.facebook.internal.NativeProtocol;
import java.io.IOException;
import java.io.OutputStream;

class ui {
    private int aAA;
    private int aAB;
    private int aAC;
    int aAD;
    int aAE = 12;
    int aAF;
    int aAG = 4096;
    int[] aAH = new int[5003];
    int[] aAI = new int[5003];
    int aAJ = 5003;
    int aAK = 0;
    boolean aAL = false;
    int aAM;
    int aAN;
    int aAO;
    int aAP = 0;
    int aAQ = 0;
    int[] aAR = new int[]{0, 1, 3, 7, 15, 31, 63, 127, 255, 511, 1023, 2047, 4095, 8191, 16383, 32767, 65535};
    int aAS;
    byte[] aAT = new byte[256];
    private int aAx;
    private int aAy;
    private byte[] aAz;

    ui(int i, int i2, byte[] bArr, int i3) {
        this.aAx = i;
        this.aAy = i2;
        this.aAz = bArr;
        this.aAA = Math.max(2, i3);
    }

    void m13820a(byte b, OutputStream outputStream) throws IOException {
        byte[] bArr = this.aAT;
        int i = this.aAS;
        this.aAS = i + 1;
        bArr[i] = b;
        if (this.aAS >= 254) {
            m13824c(outputStream);
        }
    }

    void m13823b(OutputStream outputStream) throws IOException {
        eF(this.aAJ);
        this.aAK = this.aAN + 2;
        this.aAL = true;
        m13822b(this.aAN, outputStream);
    }

    void eF(int i) {
        for (int i2 = 0; i2 < i; i2++) {
            this.aAH[i2] = -1;
        }
    }

    void m13821a(int i, OutputStream outputStream) throws IOException {
        int i2;
        int i3 = 0;
        this.aAM = i;
        this.aAL = false;
        this.aAD = this.aAM;
        this.aAF = eG(this.aAD);
        this.aAN = 1 << (i - 1);
        this.aAO = this.aAN + 1;
        this.aAK = this.aAN + 2;
        this.aAS = 0;
        int uG = uG();
        for (i2 = this.aAJ; i2 < NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST; i2 *= 2) {
            i3++;
        }
        int i4 = 8 - i3;
        int i5 = this.aAJ;
        eF(i5);
        m13822b(this.aAN, outputStream);
        while (true) {
            i3 = uG();
            if (i3 != -1) {
                int i6 = (i3 << this.aAE) + uG;
                i2 = (i3 << i4) ^ uG;
                if (this.aAH[i2] == i6) {
                    uG = this.aAI[i2];
                } else if (this.aAH[i2] >= 0) {
                    r3 = i5 - i2;
                    if (i2 == 0) {
                        r3 = 1;
                    }
                    do {
                        i2 -= r3;
                        if (i2 < 0) {
                            i2 += i5;
                        }
                        if (this.aAH[i2] == i6) {
                            uG = this.aAI[i2];
                            break;
                        }
                    } while (this.aAH[i2] >= 0);
                    m13822b(uG, outputStream);
                    if (this.aAK >= this.aAG) {
                        r0 = this.aAI;
                        r3 = this.aAK;
                        this.aAK = r3 + 1;
                        r0[i2] = r3;
                        this.aAH[i2] = i6;
                        uG = i3;
                    } else {
                        m13823b(outputStream);
                        uG = i3;
                    }
                } else {
                    m13822b(uG, outputStream);
                    if (this.aAK >= this.aAG) {
                        m13823b(outputStream);
                        uG = i3;
                    } else {
                        r0 = this.aAI;
                        r3 = this.aAK;
                        this.aAK = r3 + 1;
                        r0[i2] = r3;
                        this.aAH[i2] = i6;
                        uG = i3;
                    }
                }
            } else {
                m13822b(uG, outputStream);
                m13822b(this.aAO, outputStream);
                return;
            }
        }
    }

    void encode(OutputStream outputStream) throws IOException {
        outputStream.write(this.aAA);
        this.aAB = this.aAx * this.aAy;
        this.aAC = 0;
        m13821a(this.aAA + 1, outputStream);
        outputStream.write(0);
    }

    void m13824c(OutputStream outputStream) throws IOException {
        if (this.aAS > 0) {
            outputStream.write(this.aAS);
            outputStream.write(this.aAT, 0, this.aAS);
            this.aAS = 0;
        }
    }

    final int eG(int i) {
        return (1 << i) - 1;
    }

    private int uG() {
        if (this.aAB == 0) {
            return -1;
        }
        this.aAB--;
        byte[] bArr = this.aAz;
        int i = this.aAC;
        this.aAC = i + 1;
        return bArr[i] & 255;
    }

    void m13822b(int i, OutputStream outputStream) throws IOException {
        this.aAP &= this.aAR[this.aAQ];
        if (this.aAQ > 0) {
            this.aAP |= i << this.aAQ;
        } else {
            this.aAP = i;
        }
        this.aAQ += this.aAD;
        while (this.aAQ >= 8) {
            m13820a((byte) (this.aAP & 255), outputStream);
            this.aAP >>= 8;
            this.aAQ -= 8;
        }
        if (this.aAK > this.aAF || this.aAL) {
            if (this.aAL) {
                int i2 = this.aAM;
                this.aAD = i2;
                this.aAF = eG(i2);
                this.aAL = false;
            } else {
                this.aAD++;
                if (this.aAD == this.aAE) {
                    this.aAF = this.aAG;
                } else {
                    this.aAF = eG(this.aAD);
                }
            }
        }
        if (i == this.aAO) {
            while (this.aAQ > 0) {
                m13820a((byte) (this.aAP & 255), outputStream);
                this.aAP >>= 8;
                this.aAQ -= 8;
            }
            m13824c(outputStream);
        }
    }
}
