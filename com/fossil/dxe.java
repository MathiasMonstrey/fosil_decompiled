package com.fossil;

import android.support.v8.renderscript.Allocation;
import javax.security.auth.x500.X500Principal;

final class dxe {
    private char[] bRV;
    private final String dAd;
    private int dAe;
    private int dAf;
    private int end;
    private final int length = this.dAd.length();
    private int pos;

    public dxe(X500Principal x500Principal) {
        this.dAd = x500Principal.getName("RFC2253");
    }

    private String aBp() {
        while (this.pos < this.length && this.bRV[this.pos] == ' ') {
            this.pos++;
        }
        if (this.pos == this.length) {
            return null;
        }
        this.dAe = this.pos;
        this.pos++;
        while (this.pos < this.length && this.bRV[this.pos] != '=' && this.bRV[this.pos] != ' ') {
            this.pos++;
        }
        if (this.pos >= this.length) {
            throw new IllegalStateException("Unexpected end of DN: " + this.dAd);
        }
        this.end = this.pos;
        if (this.bRV[this.pos] == ' ') {
            while (this.pos < this.length && this.bRV[this.pos] != '=' && this.bRV[this.pos] == ' ') {
                this.pos++;
            }
            if (this.bRV[this.pos] != '=' || this.pos == this.length) {
                throw new IllegalStateException("Unexpected end of DN: " + this.dAd);
            }
        }
        this.pos++;
        while (this.pos < this.length && this.bRV[this.pos] == ' ') {
            this.pos++;
        }
        if (this.end - this.dAe > 4 && this.bRV[this.dAe + 3] == '.' && ((this.bRV[this.dAe] == 'O' || this.bRV[this.dAe] == 'o') && ((this.bRV[this.dAe + 1] == 'I' || this.bRV[this.dAe + 1] == 'i') && (this.bRV[this.dAe + 2] == 'D' || this.bRV[this.dAe + 2] == 'd')))) {
            this.dAe += 4;
        }
        return new String(this.bRV, this.dAe, this.end - this.dAe);
    }

    private String aBq() {
        this.pos++;
        this.dAe = this.pos;
        this.end = this.dAe;
        while (this.pos != this.length) {
            if (this.bRV[this.pos] == '\"') {
                this.pos++;
                while (this.pos < this.length && this.bRV[this.pos] == ' ') {
                    this.pos++;
                }
                return new String(this.bRV, this.dAe, this.end - this.dAe);
            }
            if (this.bRV[this.pos] == '\\') {
                this.bRV[this.end] = aBt();
            } else {
                this.bRV[this.end] = this.bRV[this.pos];
            }
            this.pos++;
            this.end++;
        }
        throw new IllegalStateException("Unexpected end of DN: " + this.dAd);
    }

    private String aBr() {
        if (this.pos + 4 >= this.length) {
            throw new IllegalStateException("Unexpected end of DN: " + this.dAd);
        }
        int i;
        this.dAe = this.pos;
        this.pos++;
        while (this.pos != this.length && this.bRV[this.pos] != '+' && this.bRV[this.pos] != ',' && this.bRV[this.pos] != ';') {
            int i2;
            if (this.bRV[this.pos] == ' ') {
                this.end = this.pos;
                this.pos++;
                while (this.pos < this.length && this.bRV[this.pos] == ' ') {
                    this.pos++;
                }
                i = this.end - this.dAe;
                if (i >= 5 || (i & 1) == 0) {
                    throw new IllegalStateException("Unexpected end of DN: " + this.dAd);
                }
                byte[] bArr = new byte[(i / 2)];
                int i3 = this.dAe + 1;
                for (i2 = 0; i2 < bArr.length; i2++) {
                    bArr[i2] = (byte) mU(i3);
                    i3 += 2;
                }
                return new String(this.bRV, this.dAe, i);
            }
            if (this.bRV[this.pos] >= 'A' && this.bRV[this.pos] <= 'F') {
                char[] cArr = this.bRV;
                i2 = this.pos;
                cArr[i2] = (char) (cArr[i2] + 32);
            }
            this.pos++;
        }
        this.end = this.pos;
        i = this.end - this.dAe;
        if (i >= 5) {
        }
        throw new IllegalStateException("Unexpected end of DN: " + this.dAd);
    }

    private String aBs() {
        this.dAe = this.pos;
        this.end = this.pos;
        while (this.pos < this.length) {
            char[] cArr;
            int i;
            switch (this.bRV[this.pos]) {
                case ' ':
                    this.dAf = this.end;
                    this.pos++;
                    cArr = this.bRV;
                    i = this.end;
                    this.end = i + 1;
                    cArr[i] = ' ';
                    while (this.pos < this.length && this.bRV[this.pos] == ' ') {
                        cArr = this.bRV;
                        i = this.end;
                        this.end = i + 1;
                        cArr[i] = ' ';
                        this.pos++;
                    }
                    if (this.pos != this.length && this.bRV[this.pos] != ',' && this.bRV[this.pos] != '+' && this.bRV[this.pos] != ';') {
                        break;
                    }
                    return new String(this.bRV, this.dAe, this.dAf - this.dAe);
                    break;
                case '+':
                case ',':
                case ';':
                    return new String(this.bRV, this.dAe, this.end - this.dAe);
                case '\\':
                    cArr = this.bRV;
                    i = this.end;
                    this.end = i + 1;
                    cArr[i] = aBt();
                    this.pos++;
                    break;
                default:
                    cArr = this.bRV;
                    i = this.end;
                    this.end = i + 1;
                    cArr[i] = this.bRV[this.pos];
                    this.pos++;
                    break;
            }
        }
        return new String(this.bRV, this.dAe, this.end - this.dAe);
    }

    private char aBt() {
        this.pos++;
        if (this.pos == this.length) {
            throw new IllegalStateException("Unexpected end of DN: " + this.dAd);
        }
        switch (this.bRV[this.pos]) {
            case ' ':
            case '\"':
            case '#':
            case '%':
            case '*':
            case '+':
            case ',':
            case ';':
            case '<':
            case '=':
            case '>':
            case '\\':
            case '_':
                return this.bRV[this.pos];
            default:
                return aBu();
        }
    }

    private char aBu() {
        int mU = mU(this.pos);
        this.pos++;
        if (mU < Allocation.USAGE_SHARED) {
            return (char) mU;
        }
        if (mU < 192 || mU > 247) {
            return '?';
        }
        int i;
        if (mU <= 223) {
            i = 1;
            mU &= 31;
        } else if (mU <= 239) {
            i = 2;
            mU &= 15;
        } else {
            i = 3;
            mU &= 7;
        }
        int i2 = mU;
        for (mU = 0; mU < i; mU++) {
            this.pos++;
            if (this.pos == this.length || this.bRV[this.pos] != '\\') {
                return '?';
            }
            this.pos++;
            int mU2 = mU(this.pos);
            this.pos++;
            if ((mU2 & 192) != Allocation.USAGE_SHARED) {
                return '?';
            }
            i2 = (i2 << 6) + (mU2 & 63);
        }
        return (char) i2;
    }

    private int mU(int i) {
        if (i + 1 >= this.length) {
            throw new IllegalStateException("Malformed DN: " + this.dAd);
        }
        int i2;
        int i3;
        char c = this.bRV[i];
        if (c >= '0' && c <= '9') {
            i2 = c - 48;
        } else if (c >= 'a' && c <= 'f') {
            i2 = c - 87;
        } else if (c < 'A' || c > 'F') {
            throw new IllegalStateException("Malformed DN: " + this.dAd);
        } else {
            i2 = c - 55;
        }
        char c2 = this.bRV[i + 1];
        if (c2 >= '0' && c2 <= '9') {
            i3 = c2 - 48;
        } else if (c2 >= 'a' && c2 <= 'f') {
            i3 = c2 - 87;
        } else if (c2 < 'A' || c2 > 'F') {
            throw new IllegalStateException("Malformed DN: " + this.dAd);
        } else {
            i3 = c2 - 55;
        }
        return (i2 << 4) + i3;
    }

    public String kW(String str) {
        this.pos = 0;
        this.dAe = 0;
        this.end = 0;
        this.dAf = 0;
        this.bRV = this.dAd.toCharArray();
        String aBp = aBp();
        if (aBp == null) {
            return null;
        }
        do {
            String str2 = "";
            if (this.pos == this.length) {
                return null;
            }
            switch (this.bRV[this.pos]) {
                case '\"':
                    str2 = aBq();
                    break;
                case '#':
                    str2 = aBr();
                    break;
                case '+':
                case ',':
                case ';':
                    break;
                default:
                    str2 = aBs();
                    break;
            }
            if (str.equalsIgnoreCase(aBp)) {
                return str2;
            }
            if (this.pos >= this.length) {
                return null;
            }
            if (this.bRV[this.pos] == ',' || this.bRV[this.pos] == ';' || this.bRV[this.pos] == '+') {
                this.pos++;
                aBp = aBp();
            } else {
                throw new IllegalStateException("Malformed DN: " + this.dAd);
            }
        } while (aBp != null);
        throw new IllegalStateException("Malformed DN: " + this.dAd);
    }
}
