package com.fossil;

import com.facebook.internal.NativeProtocol;

class uj {
    protected int aAU;
    protected byte[] aAV;
    protected int aAW;
    protected int aAX;
    protected int[][] aAY;
    protected int[] aAZ = new int[256];
    protected int[] aBa = new int[256];
    protected int[] aBb = new int[256];
    protected int[] aBc = new int[32];

    public uj(byte[] bArr, int i, int i2) {
        this.aAV = bArr;
        this.aAW = i;
        this.aAX = i2;
        this.aAY = new int[256][];
        for (int i3 = 0; i3 < 256; i3++) {
            this.aAY[i3] = new int[4];
            int[] iArr = this.aAY[i3];
            int i4 = (i3 << 12) / 256;
            iArr[2] = i4;
            iArr[1] = i4;
            iArr[0] = i4;
            this.aBb[i3] = 256;
            this.aBa[i3] = 0;
        }
    }

    public byte[] uH() {
        int i;
        byte[] bArr = new byte[768];
        int[] iArr = new int[256];
        for (i = 0; i < 256; i++) {
            iArr[this.aAY[i][3]] = i;
        }
        int i2 = 0;
        for (i = 0; i < 256; i++) {
            int i3 = iArr[i];
            int i4 = i2 + 1;
            bArr[i2] = (byte) this.aAY[i3][0];
            int i5 = i4 + 1;
            bArr[i4] = (byte) this.aAY[i3][1];
            i2 = i5 + 1;
            bArr[i5] = (byte) this.aAY[i3][2];
        }
        return bArr;
    }

    public void uI() {
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        while (i3 < 256) {
            int[] iArr = this.aAY[i3];
            int i4 = iArr[1];
            int i5 = i3;
            for (int i6 = i3 + 1; i6 < 256; i6++) {
                int[] iArr2 = this.aAY[i6];
                if (iArr2[1] < i4) {
                    i4 = iArr2[1];
                    i5 = i6;
                }
            }
            int[] iArr3 = this.aAY[i5];
            if (i3 != i5) {
                i5 = iArr3[0];
                iArr3[0] = iArr[0];
                iArr[0] = i5;
                i5 = iArr3[1];
                iArr3[1] = iArr[1];
                iArr[1] = i5;
                i5 = iArr3[2];
                iArr3[2] = iArr[2];
                iArr[2] = i5;
                i5 = iArr3[3];
                iArr3[3] = iArr[3];
                iArr[3] = i5;
            }
            if (i4 != i2) {
                this.aAZ[i2] = (i + i3) >> 1;
                for (i5 = i2 + 1; i5 < i4; i5++) {
                    this.aAZ[i5] = i3;
                }
                i5 = i4;
                i4 = i3;
            } else {
                i4 = i;
                i5 = i2;
            }
            i3++;
            i = i4;
            i2 = i5;
        }
        this.aAZ[i2] = (i + 255) >> 1;
        for (i4 = i2 + 1; i4 < 256; i4++) {
            this.aAZ[i4] = 255;
        }
    }

    public void uJ() {
        int i;
        int i2;
        if (this.aAW < 1509) {
            this.aAX = 1;
        }
        this.aAU = ((this.aAX - 1) / 3) + 30;
        byte[] bArr = this.aAV;
        int i3 = this.aAW;
        int i4 = this.aAW / (this.aAX * 3);
        int i5 = i4 / 100;
        for (i = 0; i < 32; i++) {
            this.aBc[i] = (((1024 - (i * i)) * 256) / 1024) * 1024;
        }
        if (this.aAW < 1509) {
            i2 = 3;
        } else if (this.aAW % 499 != 0) {
            i2 = 1497;
        } else if (this.aAW % 491 != 0) {
            i2 = 1473;
        } else if (this.aAW % 487 != 0) {
            i2 = 1461;
        } else {
            i2 = 1509;
        }
        int i6 = 0;
        int i7 = 32;
        int i8 = 2048;
        int i9 = 0;
        i = 1024;
        while (i9 < i4) {
            int i10 = (bArr[i6 + 0] & 255) << 4;
            int i11 = (bArr[i6 + 1] & 255) << 4;
            int i12 = (bArr[i6 + 2] & 255) << 4;
            int s = m13828s(i10, i11, i12);
            m13826g(i, s, i10, i11, i12);
            if (i7 != 0) {
                m13825f(i7, s, i10, i11, i12);
            }
            int i13 = i6 + i2;
            if (i13 >= i3) {
                i10 = i13 - this.aAW;
            } else {
                i10 = i13;
            }
            int i14 = i9 + 1;
            if (i5 == 0) {
                i13 = 1;
            } else {
                i13 = i5;
            }
            if (i14 % i13 == 0) {
                i11 = i - (i / this.aAU);
                i12 = i8 - (i8 / 30);
                i = i12 >> 6;
                if (i <= 1) {
                    i = 0;
                }
                for (s = 0; s < i; s++) {
                    this.aBc[s] = ((((i * i) - (s * s)) * 256) / (i * i)) * i11;
                }
                i6 = i10;
                i5 = i13;
                i7 = i;
                i8 = i12;
                i9 = i14;
                i = i11;
            } else {
                i6 = i10;
                i5 = i13;
                i9 = i14;
            }
        }
    }

    public int m13827r(int i, int i2, int i3) {
        int i4 = this.aAZ[i2];
        int i5 = -1;
        int i6 = 1000;
        int i7 = i4 - 1;
        int i8 = i4;
        while (true) {
            if (i8 >= 256 && i7 < 0) {
                return i5;
            }
            int[] iArr;
            int i9;
            if (i8 < 256) {
                iArr = this.aAY[i8];
                i9 = iArr[1] - i2;
                if (i9 >= i6) {
                    i8 = i6;
                    i4 = 256;
                    i6 = i5;
                } else {
                    i4 = i8 + 1;
                    if (i9 < 0) {
                        i9 = -i9;
                    }
                    i8 = iArr[0] - i;
                    if (i8 < 0) {
                        i8 = -i8;
                    }
                    i8 += i9;
                    if (i8 < i6) {
                        i9 = iArr[2] - i3;
                        if (i9 < 0) {
                            i9 = -i9;
                        }
                        i8 += i9;
                        if (i8 < i6) {
                            i6 = iArr[3];
                        }
                    }
                    i8 = i6;
                    i6 = i5;
                }
            } else {
                i4 = i8;
                i8 = i6;
                i6 = i5;
            }
            if (i7 >= 0) {
                iArr = this.aAY[i7];
                i9 = i2 - iArr[1];
                if (i9 >= i8) {
                    i5 = i6;
                    i7 = -1;
                    i6 = i8;
                    i8 = i4;
                } else {
                    i7--;
                    if (i9 < 0) {
                        i9 = -i9;
                    }
                    i5 = iArr[0] - i;
                    if (i5 < 0) {
                        i5 = -i5;
                    }
                    i5 += i9;
                    if (i5 < i8) {
                        i9 = iArr[2] - i3;
                        if (i9 < 0) {
                            i9 = -i9;
                        }
                        i9 += i5;
                        if (i9 < i8) {
                            i5 = iArr[3];
                            i8 = i4;
                            i6 = i9;
                        }
                    }
                }
            }
            i5 = i6;
            i6 = i8;
            i8 = i4;
        }
    }

    public byte[] uK() {
        uJ();
        uL();
        uI();
        return uH();
    }

    public void uL() {
        for (int i = 0; i < 256; i++) {
            int[] iArr = this.aAY[i];
            iArr[0] = iArr[0] >> 4;
            iArr = this.aAY[i];
            iArr[1] = iArr[1] >> 4;
            iArr = this.aAY[i];
            iArr[2] = iArr[2] >> 4;
            this.aAY[i][3] = i;
        }
    }

    protected void m13825f(int i, int i2, int i3, int i4, int i5) {
        int i6;
        int i7 = i2 - i;
        if (i7 < -1) {
            i6 = -1;
        } else {
            i6 = i7;
        }
        i7 = i2 + i;
        if (i7 > 256) {
            i7 = 256;
        }
        int i8 = 1;
        int i9 = i2 - 1;
        int i10 = i2 + 1;
        while (true) {
            if (i10 < i7 || i9 > i6) {
                int i11 = i8 + 1;
                int i12 = this.aBc[i8];
                if (i10 < i7) {
                    i8 = i10 + 1;
                    int[] iArr = this.aAY[i10];
                    try {
                        iArr[0] = iArr[0] - (((iArr[0] - i3) * i12) / 262144);
                        iArr[1] = iArr[1] - (((iArr[1] - i4) * i12) / 262144);
                        iArr[2] = iArr[2] - (((iArr[2] - i5) * i12) / 262144);
                    } catch (Exception e) {
                    }
                } else {
                    i8 = i10;
                }
                if (i9 > i6) {
                    i10 = i9 - 1;
                    int[] iArr2 = this.aAY[i9];
                    try {
                        iArr2[0] = iArr2[0] - (((iArr2[0] - i3) * i12) / 262144);
                        iArr2[1] = iArr2[1] - (((iArr2[1] - i4) * i12) / 262144);
                        iArr2[2] = iArr2[2] - ((i12 * (iArr2[2] - i5)) / 262144);
                        i9 = i10;
                        i10 = i8;
                        i8 = i11;
                    } catch (Exception e2) {
                        i9 = i10;
                        i10 = i8;
                        i8 = i11;
                    }
                } else {
                    i10 = i8;
                    i8 = i11;
                }
            } else {
                return;
            }
        }
    }

    protected void m13826g(int i, int i2, int i3, int i4, int i5) {
        int[] iArr = this.aAY[i2];
        iArr[0] = iArr[0] - (((iArr[0] - i3) * i) / 1024);
        iArr[1] = iArr[1] - (((iArr[1] - i4) * i) / 1024);
        iArr[2] = iArr[2] - (((iArr[2] - i5) * i) / 1024);
    }

    protected int m13828s(int i, int i2, int i3) {
        int i4 = Integer.MAX_VALUE;
        int i5 = -1;
        int i6 = Integer.MAX_VALUE;
        int i7 = -1;
        int i8 = 0;
        while (i8 < 256) {
            int[] iArr = this.aAY[i8];
            int i9 = iArr[0] - i;
            if (i9 < 0) {
                i9 = -i9;
            }
            int i10 = iArr[1] - i2;
            if (i10 < 0) {
                i10 = -i10;
            }
            i10 += i9;
            i9 = iArr[2] - i3;
            if (i9 < 0) {
                i9 = -i9;
            }
            i10 += i9;
            if (i10 < i6) {
                i9 = i10;
                i6 = i8;
            } else {
                i9 = i6;
                i6 = i7;
            }
            i10 -= this.aBa[i8] >> 12;
            if (i10 < i4) {
                i7 = i8;
            } else {
                i10 = i4;
                i7 = i5;
            }
            i4 = this.aBb[i8] >> 10;
            int[] iArr2 = this.aBb;
            iArr2[i8] = iArr2[i8] - i4;
            iArr2 = this.aBa;
            iArr2[i8] = (i4 << 10) + iArr2[i8];
            i8++;
            i4 = i10;
            i5 = i7;
            i7 = i6;
            i6 = i9;
        }
        int[] iArr3 = this.aBb;
        iArr3[i7] = iArr3[i7] + 64;
        iArr3 = this.aBa;
        iArr3[i7] = iArr3[i7] - NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST;
        return i5;
    }
}
