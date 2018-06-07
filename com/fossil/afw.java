package com.fossil;

import com.fasterxml.jackson.core.JsonEncoding;
import com.fasterxml.jackson.core.JsonFactory.Feature;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.format.MatchStrength;
import java.io.ByteArrayInputStream;
import java.io.CharConversionException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

public final class afw {
    protected boolean _bigEndian = true;
    private int aLT;
    private int aLU;
    protected final InputStream aMQ;
    protected final afo aNK;
    protected final byte[] aNW;
    private final boolean aNX;
    protected int aNY;
    protected int aNZ = 0;

    public afw(afo com_fossil_afo, InputStream inputStream) {
        this.aNK = com_fossil_afo;
        this.aMQ = inputStream;
        this.aNW = com_fossil_afo.BB();
        this.aLT = 0;
        this.aLU = 0;
        this.aNY = 0;
        this.aNX = true;
    }

    public afw(afo com_fossil_afo, byte[] bArr, int i, int i2) {
        this.aNK = com_fossil_afo;
        this.aMQ = null;
        this.aNW = bArr;
        this.aLT = i;
        this.aLU = i + i2;
        this.aNY = -i;
        this.aNX = false;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.fasterxml.jackson.core.JsonEncoding BM() throws java.io.IOException {
        /*
        r5 = this;
        r0 = 1;
        r1 = 0;
        r2 = 4;
        r2 = r5.fI(r2);
        if (r2 == 0) goto L_0x0056;
    L_0x0009:
        r2 = r5.aNW;
        r3 = r5.aLT;
        r2 = r2[r3];
        r2 = r2 << 24;
        r3 = r5.aNW;
        r4 = r5.aLT;
        r4 = r4 + 1;
        r3 = r3[r4];
        r3 = r3 & 255;
        r3 = r3 << 16;
        r2 = r2 | r3;
        r3 = r5.aNW;
        r4 = r5.aLT;
        r4 = r4 + 2;
        r3 = r3[r4];
        r3 = r3 & 255;
        r3 = r3 << 8;
        r2 = r2 | r3;
        r3 = r5.aNW;
        r4 = r5.aLT;
        r4 = r4 + 3;
        r3 = r3[r4];
        r3 = r3 & 255;
        r2 = r2 | r3;
        r3 = r5.fF(r2);
        if (r3 == 0) goto L_0x0046;
    L_0x003c:
        if (r0 != 0) goto L_0x0079;
    L_0x003e:
        r0 = com.fasterxml.jackson.core.JsonEncoding.UTF8;
    L_0x0040:
        r1 = r5.aNK;
        r1.m3148a(r0);
        return r0;
    L_0x0046:
        r3 = r5.fG(r2);
        if (r3 != 0) goto L_0x003c;
    L_0x004c:
        r2 = r2 >>> 16;
        r2 = r5.fH(r2);
        if (r2 != 0) goto L_0x003c;
    L_0x0054:
        r0 = r1;
        goto L_0x003c;
    L_0x0056:
        r2 = 2;
        r2 = r5.fI(r2);
        if (r2 == 0) goto L_0x0054;
    L_0x005d:
        r2 = r5.aNW;
        r3 = r5.aLT;
        r2 = r2[r3];
        r2 = r2 & 255;
        r2 = r2 << 8;
        r3 = r5.aNW;
        r4 = r5.aLT;
        r4 = r4 + 1;
        r3 = r3[r4];
        r3 = r3 & 255;
        r2 = r2 | r3;
        r2 = r5.fH(r2);
        if (r2 == 0) goto L_0x0054;
    L_0x0078:
        goto L_0x003c;
    L_0x0079:
        r0 = r5.aNZ;
        switch(r0) {
            case 1: goto L_0x0086;
            case 2: goto L_0x0089;
            case 3: goto L_0x007e;
            case 4: goto L_0x0093;
            default: goto L_0x007e;
        };
    L_0x007e:
        r0 = new java.lang.RuntimeException;
        r1 = "Internal error";
        r0.<init>(r1);
        throw r0;
    L_0x0086:
        r0 = com.fasterxml.jackson.core.JsonEncoding.UTF8;
        goto L_0x0040;
    L_0x0089:
        r0 = r5._bigEndian;
        if (r0 == 0) goto L_0x0090;
    L_0x008d:
        r0 = com.fasterxml.jackson.core.JsonEncoding.UTF16_BE;
        goto L_0x0040;
    L_0x0090:
        r0 = com.fasterxml.jackson.core.JsonEncoding.UTF16_LE;
        goto L_0x0040;
    L_0x0093:
        r0 = r5._bigEndian;
        if (r0 == 0) goto L_0x009a;
    L_0x0097:
        r0 = com.fasterxml.jackson.core.JsonEncoding.UTF32_BE;
        goto L_0x0040;
    L_0x009a:
        r0 = com.fasterxml.jackson.core.JsonEncoding.UTF32_LE;
        goto L_0x0040;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fossil.afw.BM():com.fasterxml.jackson.core.JsonEncoding");
    }

    public Reader BN() throws IOException {
        JsonEncoding By = this.aNK.By();
        switch (By.bits()) {
            case 8:
            case 16:
                InputStream byteArrayInputStream;
                InputStream inputStream = this.aMQ;
                if (inputStream == null) {
                    byteArrayInputStream = new ByteArrayInputStream(this.aNW, this.aLT, this.aLU);
                } else if (this.aLT < this.aLU) {
                    byteArrayInputStream = new afq(this.aNK, inputStream, this.aNW, this.aLT, this.aLU);
                } else {
                    byteArrayInputStream = inputStream;
                }
                return new InputStreamReader(byteArrayInputStream, By.getJavaName());
            case 32:
                return new afu(this.aNK, this.aMQ, this.aNW, this.aLT, this.aLU, this.aNK.By().isBigEndian());
            default:
                throw new RuntimeException("Internal error");
        }
    }

    public JsonParser m3179a(int i, afa com_fossil_afa, agg com_fossil_agg, agi com_fossil_agi, int i2) throws IOException {
        if (BM() == JsonEncoding.UTF8 && Feature.CANONICALIZE_FIELD_NAMES.enabledIn(i2)) {
            return new age(this.aNK, i, this.aMQ, com_fossil_afa, com_fossil_agg.gk(i2), this.aNW, this.aLT, this.aLU, this.aNX);
        }
        return new agc(this.aNK, i, BN(), com_fossil_afa, com_fossil_agi.gw(i2));
    }

    public static MatchStrength hasJSONFormat(afm com_fossil_afm) throws IOException {
        if (!com_fossil_afm.Bo()) {
            return MatchStrength.INCONCLUSIVE;
        }
        byte nextByte = com_fossil_afm.nextByte();
        if (nextByte == (byte) -17) {
            if (!com_fossil_afm.Bo()) {
                return MatchStrength.INCONCLUSIVE;
            }
            if (com_fossil_afm.nextByte() != (byte) -69) {
                return MatchStrength.NO_MATCH;
            }
            if (!com_fossil_afm.Bo()) {
                return MatchStrength.INCONCLUSIVE;
            }
            if (com_fossil_afm.nextByte() != (byte) -65) {
                return MatchStrength.NO_MATCH;
            }
            if (!com_fossil_afm.Bo()) {
                return MatchStrength.INCONCLUSIVE;
            }
            nextByte = com_fossil_afm.nextByte();
        }
        int a = m3177a(com_fossil_afm, nextByte);
        if (a < 0) {
            return MatchStrength.INCONCLUSIVE;
        }
        int a2;
        if (a == 123) {
            a2 = m3176a(com_fossil_afm);
            if (a2 < 0) {
                return MatchStrength.INCONCLUSIVE;
            }
            if (a2 == 34 || a2 == 125) {
                return MatchStrength.SOLID_MATCH;
            }
            return MatchStrength.NO_MATCH;
        } else if (a == 91) {
            a2 = m3176a(com_fossil_afm);
            if (a2 < 0) {
                return MatchStrength.INCONCLUSIVE;
            }
            if (a2 == 93 || a2 == 91) {
                return MatchStrength.SOLID_MATCH;
            }
            return MatchStrength.SOLID_MATCH;
        } else {
            MatchStrength matchStrength = MatchStrength.WEAK_MATCH;
            if (a == 34) {
                return matchStrength;
            }
            if (a <= 57 && a >= 48) {
                return matchStrength;
            }
            if (a == 45) {
                a = m3176a(com_fossil_afm);
                if (a < 0) {
                    return MatchStrength.INCONCLUSIVE;
                }
                if (a > 57 || a < 48) {
                    return MatchStrength.NO_MATCH;
                }
                return matchStrength;
            } else if (a == 110) {
                return m3178a(com_fossil_afm, "ull", matchStrength);
            } else {
                if (a == 116) {
                    return m3178a(com_fossil_afm, "rue", matchStrength);
                }
                if (a == 102) {
                    return m3178a(com_fossil_afm, "alse", matchStrength);
                }
                return MatchStrength.NO_MATCH;
            }
        }
    }

    private static MatchStrength m3178a(afm com_fossil_afm, String str, MatchStrength matchStrength) throws IOException {
        int length = str.length();
        for (int i = 0; i < length; i++) {
            if (!com_fossil_afm.Bo()) {
                return MatchStrength.INCONCLUSIVE;
            }
            if (com_fossil_afm.nextByte() != str.charAt(i)) {
                return MatchStrength.NO_MATCH;
            }
        }
        return matchStrength;
    }

    private static int m3176a(afm com_fossil_afm) throws IOException {
        if (com_fossil_afm.Bo()) {
            return m3177a(com_fossil_afm, com_fossil_afm.nextByte());
        }
        return -1;
    }

    private static int m3177a(afm com_fossil_afm, byte b) throws IOException {
        while (true) {
            int i = b & 255;
            if (i != 32 && i != 13 && i != 10 && i != 9) {
                return i;
            }
            if (!com_fossil_afm.Bo()) {
                return -1;
            }
            b = com_fossil_afm.nextByte();
            i = b & 255;
        }
    }

    private boolean fF(int i) throws IOException {
        switch (i) {
            case -16842752:
                break;
            case -131072:
                this.aLT += 4;
                this.aNZ = 4;
                this._bigEndian = false;
                return true;
            case 65279:
                this._bigEndian = true;
                this.aLT += 4;
                this.aNZ = 4;
                return true;
            case 65534:
                bo("2143");
                break;
        }
        bo("3412");
        int i2 = i >>> 16;
        if (i2 == 65279) {
            this.aLT += 2;
            this.aNZ = 2;
            this._bigEndian = true;
            return true;
        } else if (i2 == 65534) {
            this.aLT += 2;
            this.aNZ = 2;
            this._bigEndian = false;
            return true;
        } else if ((i >>> 8) != 15711167) {
            return false;
        } else {
            this.aLT += 3;
            this.aNZ = 1;
            this._bigEndian = true;
            return true;
        }
    }

    private boolean fG(int i) throws IOException {
        if ((i >> 8) == 0) {
            this._bigEndian = true;
        } else if ((16777215 & i) == 0) {
            this._bigEndian = false;
        } else if ((-16711681 & i) == 0) {
            bo("3412");
        } else if ((-65281 & i) != 0) {
            return false;
        } else {
            bo("2143");
        }
        this.aNZ = 4;
        return true;
    }

    private boolean fH(int i) {
        if ((65280 & i) == 0) {
            this._bigEndian = true;
        } else if ((i & 255) != 0) {
            return false;
        } else {
            this._bigEndian = false;
        }
        this.aNZ = 2;
        return true;
    }

    private void bo(String str) throws IOException {
        throw new CharConversionException("Unsupported UCS-4 endianness (" + str + ") detected");
    }

    protected boolean fI(int i) throws IOException {
        int i2 = this.aLU - this.aLT;
        while (i2 < i) {
            int i3;
            if (this.aMQ == null) {
                i3 = -1;
            } else {
                i3 = this.aMQ.read(this.aNW, this.aLU, this.aNW.length - this.aLU);
            }
            if (i3 < 1) {
                return false;
            }
            this.aLU += i3;
            i2 = i3 + i2;
        }
        return true;
    }
}
