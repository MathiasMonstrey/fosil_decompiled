package com.fossil;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;

public final class agr {
    static final char[] aPR = new char[0];
    private char[] aOr;
    private final agm aPS;
    private int aPT;
    private int aPU;
    private ArrayList<char[]> aPV;
    private boolean aPW = false;
    private int aPX;
    private char[] aPY;
    private int aPZ;
    private String aQa;
    private char[] aQb;

    public agr(agm com_fossil_agm) {
        this.aPS = com_fossil_agm;
    }

    public void CW() {
        if (this.aPS == null) {
            CX();
        } else if (this.aPY != null) {
            CX();
            char[] cArr = this.aPY;
            this.aPY = null;
            this.aPS.m3318c(2, cArr);
        }
    }

    public void CX() {
        this.aPT = -1;
        this.aPZ = 0;
        this.aPU = 0;
        this.aOr = null;
        this.aQa = null;
        this.aQb = null;
        if (this.aPW) {
            CY();
        }
    }

    public void m3322q(char[] cArr, int i, int i2) {
        this.aQa = null;
        this.aQb = null;
        this.aOr = cArr;
        this.aPT = i;
        this.aPU = i2;
        if (this.aPW) {
            CY();
        }
    }

    public void m3323r(char[] cArr, int i, int i2) {
        this.aOr = null;
        this.aPT = -1;
        this.aPU = 0;
        this.aQa = null;
        this.aQb = null;
        if (this.aPW) {
            CY();
        } else if (this.aPY == null) {
            this.aPY = gK(i2);
        }
        this.aPX = 0;
        this.aPZ = 0;
        append(cArr, i, i2);
    }

    public void bB(String str) {
        this.aOr = null;
        this.aPT = -1;
        this.aPU = 0;
        this.aQa = str;
        this.aQb = null;
        if (this.aPW) {
            CY();
        }
        this.aPZ = 0;
    }

    private char[] gK(int i) {
        if (this.aPS != null) {
            return this.aPS.bG(2, i);
        }
        return new char[Math.max(i, 1000)];
    }

    private void CY() {
        this.aPW = false;
        this.aPV.clear();
        this.aPX = 0;
        this.aPZ = 0;
    }

    public int size() {
        if (this.aPT >= 0) {
            return this.aPU;
        }
        if (this.aQb != null) {
            return this.aQb.length;
        }
        if (this.aQa != null) {
            return this.aQa.length();
        }
        return this.aPX + this.aPZ;
    }

    public int Af() {
        return this.aPT >= 0 ? this.aPT : 0;
    }

    public char[] CZ() {
        if (this.aPT >= 0) {
            return this.aOr;
        }
        if (this.aQb != null) {
            return this.aQb;
        }
        if (this.aQa != null) {
            char[] toCharArray = this.aQa.toCharArray();
            this.aQb = toCharArray;
            return toCharArray;
        } else if (this.aPW) {
            return Db();
        } else {
            return this.aPY == null ? aPR : this.aPY;
        }
    }

    public String Da() {
        if (this.aQa == null) {
            if (this.aQb != null) {
                this.aQa = new String(this.aQb);
            } else if (this.aPT < 0) {
                int i = this.aPX;
                int i2 = this.aPZ;
                if (i == 0) {
                    this.aQa = i2 == 0 ? "" : new String(this.aPY, 0, i2);
                } else {
                    StringBuilder stringBuilder = new StringBuilder(i + i2);
                    if (this.aPV != null) {
                        int size = this.aPV.size();
                        for (i2 = 0; i2 < size; i2++) {
                            char[] cArr = (char[]) this.aPV.get(i2);
                            stringBuilder.append(cArr, 0, cArr.length);
                        }
                    }
                    stringBuilder.append(this.aPY, 0, this.aPZ);
                    this.aQa = stringBuilder.toString();
                }
            } else if (this.aPU < 1) {
                String str = "";
                this.aQa = str;
                return str;
            } else {
                this.aQa = new String(this.aOr, this.aPT, this.aPU);
            }
        }
        return this.aQa;
    }

    public char[] Db() {
        char[] cArr = this.aQb;
        if (cArr != null) {
            return cArr;
        }
        cArr = Dj();
        this.aQb = cArr;
        return cArr;
    }

    public BigDecimal Dc() throws NumberFormatException {
        if (this.aQb != null) {
            return afr.m3162d(this.aQb);
        }
        if (this.aPT >= 0 && this.aOr != null) {
            return afr.m3163e(this.aOr, this.aPT, this.aPU);
        }
        if (this.aPX != 0 || this.aPY == null) {
            return afr.m3162d(Db());
        }
        return afr.m3163e(this.aPY, 0, this.aPZ);
    }

    public double Dd() throws NumberFormatException {
        return afr.parseDouble(Da());
    }

    public void append(char c) {
        if (this.aPT >= 0) {
            gN(16);
        }
        this.aQa = null;
        this.aQb = null;
        char[] cArr = this.aPY;
        if (this.aPZ >= cArr.length) {
            gO(1);
            cArr = this.aPY;
        }
        int i = this.aPZ;
        this.aPZ = i + 1;
        cArr[i] = c;
    }

    public void append(char[] cArr, int i, int i2) {
        if (this.aPT >= 0) {
            gN(i2);
        }
        this.aQa = null;
        this.aQb = null;
        Object obj = this.aPY;
        int length = obj.length - this.aPZ;
        if (length >= i2) {
            System.arraycopy(cArr, i, obj, this.aPZ, i2);
            this.aPZ += i2;
            return;
        }
        if (length > 0) {
            System.arraycopy(cArr, i, obj, this.aPZ, length);
            i += length;
            i2 -= length;
        }
        do {
            gO(i2);
            int min = Math.min(this.aPY.length, i2);
            System.arraycopy(cArr, i, this.aPY, 0, min);
            this.aPZ += min;
            i += min;
            i2 -= min;
        } while (i2 > 0);
    }

    public void m3321i(String str, int i, int i2) {
        if (this.aPT >= 0) {
            gN(i2);
        }
        this.aQa = null;
        this.aQb = null;
        char[] cArr = this.aPY;
        int length = cArr.length - this.aPZ;
        if (length >= i2) {
            str.getChars(i, i + i2, cArr, this.aPZ);
            this.aPZ += i2;
            return;
        }
        if (length > 0) {
            str.getChars(i, i + length, cArr, this.aPZ);
            i2 -= length;
            i += length;
        }
        do {
            gO(i2);
            int min = Math.min(this.aPY.length, i2);
            str.getChars(i, i + min, this.aPY, 0);
            this.aPZ += min;
            i += min;
            i2 -= min;
        } while (i2 > 0);
    }

    public char[] De() {
        if (this.aPT >= 0) {
            gN(1);
        } else {
            char[] cArr = this.aPY;
            if (cArr == null) {
                this.aPY = gK(0);
            } else if (this.aPZ >= cArr.length) {
                gO(1);
            }
        }
        return this.aPY;
    }

    public char[] Df() {
        this.aPT = -1;
        this.aPZ = 0;
        this.aPU = 0;
        this.aOr = null;
        this.aQa = null;
        this.aQb = null;
        if (this.aPW) {
            CY();
        }
        char[] cArr = this.aPY;
        if (cArr != null) {
            return cArr;
        }
        cArr = gK(0);
        this.aPY = cArr;
        return cArr;
    }

    public int Dg() {
        return this.aPZ;
    }

    public void gL(int i) {
        this.aPZ = i;
    }

    public String gM(int i) {
        this.aPZ = i;
        if (this.aPX > 0) {
            return Da();
        }
        int i2 = this.aPZ;
        String str = i2 == 0 ? "" : new String(this.aPY, 0, i2);
        this.aQa = str;
        return str;
    }

    public char[] Dh() {
        int i = 1000;
        if (this.aPV == null) {
            this.aPV = new ArrayList();
        }
        this.aPW = true;
        this.aPV.add(this.aPY);
        int length = this.aPY.length;
        this.aPX += length;
        this.aPZ = 0;
        length += length >> 1;
        if (length >= 1000) {
            if (length > 262144) {
                i = 262144;
            } else {
                i = length;
            }
        }
        char[] gP = gP(i);
        this.aPY = gP;
        return gP;
    }

    public char[] Di() {
        char[] cArr = this.aPY;
        int length = cArr.length;
        int i = (length >> 1) + length;
        if (i > 262144) {
            i = (length >> 2) + length;
        }
        char[] copyOf = Arrays.copyOf(cArr, i);
        this.aPY = copyOf;
        return copyOf;
    }

    public String toString() {
        return Da();
    }

    private void gN(int i) {
        int i2 = this.aPU;
        this.aPU = 0;
        Object obj = this.aOr;
        this.aOr = null;
        int i3 = this.aPT;
        this.aPT = -1;
        int i4 = i2 + i;
        if (this.aPY == null || i4 > this.aPY.length) {
            this.aPY = gK(i4);
        }
        if (i2 > 0) {
            System.arraycopy(obj, i3, this.aPY, 0, i2);
        }
        this.aPX = 0;
        this.aPZ = i2;
    }

    private void gO(int i) {
        int i2 = 1000;
        if (this.aPV == null) {
            this.aPV = new ArrayList();
        }
        Object obj = this.aPY;
        this.aPW = true;
        this.aPV.add(obj);
        this.aPX += obj.length;
        this.aPZ = 0;
        int length = obj.length;
        length += length >> 1;
        if (length >= 1000) {
            if (length > 262144) {
                i2 = 262144;
            } else {
                i2 = length;
            }
        }
        this.aPY = gP(i2);
    }

    private char[] Dj() {
        if (this.aQa != null) {
            return this.aQa.toCharArray();
        }
        int i;
        int i2;
        if (this.aPT >= 0) {
            i = this.aPU;
            if (i < 1) {
                return aPR;
            }
            i2 = this.aPT;
            if (i2 == 0) {
                return Arrays.copyOf(this.aOr, i);
            }
            return Arrays.copyOfRange(this.aOr, i2, i + i2);
        }
        i = size();
        if (i < 1) {
            return aPR;
        }
        Object gP = gP(i);
        if (this.aPV != null) {
            int size = this.aPV.size();
            i2 = 0;
            for (int i3 = 0; i3 < size; i3++) {
                char[] cArr = (char[]) this.aPV.get(i3);
                int length = cArr.length;
                System.arraycopy(cArr, 0, gP, i2, length);
                i2 += length;
            }
            i = i2;
        } else {
            i = 0;
        }
        System.arraycopy(this.aPY, 0, gP, i, this.aPZ);
        return gP;
    }

    private char[] gP(int i) {
        return new char[i];
    }
}
