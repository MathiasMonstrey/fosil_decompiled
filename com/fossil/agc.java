package com.fossil;

import com.facebook.internal.ServerProtocol;
import com.fasterxml.jackson.core.Base64Variant;
import com.fasterxml.jackson.core.JsonParser.Feature;
import com.fasterxml.jackson.core.JsonToken;
import java.io.IOException;
import java.io.OutputStream;
import java.io.Reader;

public class agc extends afg {
    protected static final int[] aOp = afn.Bp();
    protected afa _objectCodec;
    protected boolean aNX;
    protected Reader aOq;
    protected char[] aOr;
    protected final agi aOs;
    protected final int aOt;
    protected boolean aOu = false;

    public agc(afo com_fossil_afo, int i, Reader reader, afa com_fossil_afa, agi com_fossil_agi, char[] cArr, int i2, int i3, boolean z) {
        super(com_fossil_afo, i);
        this.aOq = reader;
        this.aOr = cArr;
        this.aLT = i2;
        this.aLU = i3;
        this._objectCodec = com_fossil_afa;
        this.aOs = com_fossil_agi;
        this.aOt = com_fossil_agi.CO();
        this.aNX = z;
    }

    public agc(afo com_fossil_afo, int i, Reader reader, afa com_fossil_afa, agi com_fossil_agi) {
        super(com_fossil_afo, i);
        this.aOq = reader;
        this.aOr = com_fossil_afo.BE();
        this.aLT = 0;
        this.aLU = 0;
        this._objectCodec = com_fossil_afa;
        this.aOs = com_fossil_agi;
        this.aOt = com_fossil_agi.CO();
        this.aNX = true;
    }

    public afa getCodec() {
        return this._objectCodec;
    }

    protected boolean AN() throws IOException {
        this.aLV += (long) this.aLU;
        this.aLX -= this.aLU;
        if (this.aOq == null) {
            return false;
        }
        int read = this.aOq.read(this.aOr, 0, this.aOr.length);
        if (read > 0) {
            this.aLT = 0;
            this.aLU = read;
            return true;
        }
        AP();
        if (read != 0) {
            return false;
        }
        throw new IOException("Reader returned 0 characters when trying to read " + this.aLU);
    }

    protected char bs(String str) throws IOException {
        if (this.aLT >= this.aLU && !AN()) {
            bg(str);
        }
        char[] cArr = this.aOr;
        int i = this.aLT;
        this.aLT = i + 1;
        return cArr[i];
    }

    protected void AP() throws IOException {
        if (this.aOq != null) {
            if (this.aLS.Bz() || isEnabled(Feature.AUTO_CLOSE_SOURCE)) {
                this.aOq.close();
            }
            this.aOq = null;
        }
    }

    protected void AH() throws IOException {
        super.AH();
        this.aOs.release();
        if (this.aNX) {
            char[] cArr = this.aOr;
            if (cArr != null) {
                this.aOr = null;
                this.aLS.m3149a(cArr);
            }
        }
    }

    public final String getText() throws IOException {
        JsonToken jsonToken = this.aMA;
        if (jsonToken != JsonToken.VALUE_STRING) {
            return m3200b(jsonToken);
        }
        if (this.aOu) {
            this.aOu = false;
            AO();
        }
        return this.aMd.Da();
    }

    public final String Au() throws IOException {
        if (this.aMA == JsonToken.VALUE_STRING) {
            if (this.aOu) {
                this.aOu = false;
                AO();
            }
            return this.aMd.Da();
        } else if (this.aMA == JsonToken.FIELD_NAME) {
            return zW();
        } else {
            return super.aY(null);
        }
    }

    public final String aY(String str) throws IOException {
        if (this.aMA == JsonToken.VALUE_STRING) {
            if (this.aOu) {
                this.aOu = false;
                AO();
            }
            return this.aMd.Da();
        } else if (this.aMA == JsonToken.FIELD_NAME) {
            return zW();
        } else {
            return super.aY(str);
        }
    }

    protected final String m3200b(JsonToken jsonToken) {
        if (jsonToken == null) {
            return null;
        }
        switch (jsonToken.id()) {
            case 5:
                return this.aMb.zW();
            case 6:
            case 7:
            case 8:
                return this.aMd.Da();
            default:
                return jsonToken.asString();
        }
    }

    public final char[] Ad() throws IOException {
        if (this.aMA == null) {
            return null;
        }
        switch (this.aMA.id()) {
            case 5:
                if (!this.aMf) {
                    String zW = this.aMb.zW();
                    int length = zW.length();
                    if (this.aMe == null) {
                        this.aMe = this.aLS.fz(length);
                    } else if (this.aMe.length < length) {
                        this.aMe = new char[length];
                    }
                    zW.getChars(0, length, this.aMe, 0);
                    this.aMf = true;
                }
                return this.aMe;
            case 6:
                if (this.aOu) {
                    this.aOu = false;
                    AO();
                    break;
                }
                break;
            case 7:
            case 8:
                break;
            default:
                return this.aMA.asCharArray();
        }
        return this.aMd.CZ();
    }

    public final int Ae() throws IOException {
        if (this.aMA == null) {
            return 0;
        }
        switch (this.aMA.id()) {
            case 5:
                return this.aMb.zW().length();
            case 6:
                if (this.aOu) {
                    this.aOu = false;
                    AO();
                    break;
                }
                break;
            case 7:
            case 8:
                break;
            default:
                return this.aMA.asCharArray().length;
        }
        return this.aMd.size();
    }

    public final int Af() throws IOException {
        if (this.aMA == null) {
            return 0;
        }
        switch (this.aMA.id()) {
            case 6:
                if (this.aOu) {
                    this.aOu = false;
                    AO();
                    break;
                }
                break;
            case 7:
            case 8:
                break;
            default:
                return 0;
        }
        return this.aMd.Af();
    }

    public byte[] mo906a(Base64Variant base64Variant) throws IOException {
        if (this.aMA != JsonToken.VALUE_STRING && (this.aMA != JsonToken.VALUE_EMBEDDED_OBJECT || this.aMh == null)) {
            aX("Current token (" + this.aMA + ") not VALUE_STRING or VALUE_EMBEDDED_OBJECT, can not access as binary");
        }
        if (this.aOu) {
            try {
                this.aMh = m3201b(base64Variant);
                this.aOu = false;
            } catch (IllegalArgumentException e) {
                throw aZ("Failed to decode VALUE_STRING as base64 (" + base64Variant + "): " + e.getMessage());
            }
        } else if (this.aMh == null) {
            agn AS = AS();
            m3107a(getText(), AS, base64Variant);
            this.aMh = AS.toByteArray();
        }
        return this.aMh;
    }

    public int mo904a(Base64Variant base64Variant, OutputStream outputStream) throws IOException {
        if (this.aOu && this.aMA == JsonToken.VALUE_STRING) {
            byte[] BD = this.aLS.BD();
            try {
                int a = m3198a(base64Variant, outputStream, BD);
                return a;
            } finally {
                this.aLS.m3147U(BD);
            }
        } else {
            byte[] a2 = mo906a(base64Variant);
            outputStream.write(a2);
            return a2.length;
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    protected int m3198a(com.fasterxml.jackson.core.Base64Variant r12, java.io.OutputStream r13, byte[] r14) throws java.io.IOException {
        /*
        r11 = this;
        r10 = 3;
        r9 = 34;
        r8 = -2;
        r1 = 0;
        r0 = r14.length;
        r5 = r0 + -3;
        r0 = r1;
        r2 = r1;
    L_0x000a:
        r3 = r11.aLT;
        r4 = r11.aLU;
        if (r3 < r4) goto L_0x0013;
    L_0x0010:
        r11.AM();
    L_0x0013:
        r3 = r11.aOr;
        r4 = r11.aLT;
        r6 = r4 + 1;
        r11.aLT = r6;
        r4 = r3[r4];
        r3 = 32;
        if (r4 <= r3) goto L_0x000a;
    L_0x0021:
        r3 = r12.decodeBase64Char(r4);
        if (r3 >= 0) goto L_0x0038;
    L_0x0027:
        if (r4 != r9) goto L_0x0032;
    L_0x0029:
        r11.aOu = r1;
        if (r2 <= 0) goto L_0x0031;
    L_0x002d:
        r0 = r0 + r2;
        r13.write(r14, r1, r2);
    L_0x0031:
        return r0;
    L_0x0032:
        r3 = r11.m3115a(r12, r4, r1);
        if (r3 < 0) goto L_0x000a;
    L_0x0038:
        r4 = r3;
        if (r2 <= r5) goto L_0x013b;
    L_0x003b:
        r0 = r0 + r2;
        r13.write(r14, r1, r2);
        r3 = r1;
    L_0x0040:
        r2 = r11.aLT;
        r6 = r11.aLU;
        if (r2 < r6) goto L_0x0049;
    L_0x0046:
        r11.AM();
    L_0x0049:
        r2 = r11.aOr;
        r6 = r11.aLT;
        r7 = r6 + 1;
        r11.aLT = r7;
        r6 = r2[r6];
        r2 = r12.decodeBase64Char(r6);
        if (r2 >= 0) goto L_0x005e;
    L_0x0059:
        r2 = 1;
        r2 = r11.m3115a(r12, r6, r2);
    L_0x005e:
        r4 = r4 << 6;
        r4 = r4 | r2;
        r2 = r11.aLT;
        r6 = r11.aLU;
        if (r2 < r6) goto L_0x006a;
    L_0x0067:
        r11.AM();
    L_0x006a:
        r2 = r11.aOr;
        r6 = r11.aLT;
        r7 = r6 + 1;
        r11.aLT = r7;
        r6 = r2[r6];
        r2 = r12.decodeBase64Char(r6);
        if (r2 >= 0) goto L_0x00d7;
    L_0x007a:
        if (r2 == r8) goto L_0x0091;
    L_0x007c:
        if (r6 != r9) goto L_0x008c;
    L_0x007e:
        r2 = r12.usesPadding();
        if (r2 != 0) goto L_0x008c;
    L_0x0084:
        r4 = r4 >> 4;
        r2 = r3 + 1;
        r4 = (byte) r4;
        r14[r3] = r4;
        goto L_0x0029;
    L_0x008c:
        r2 = 2;
        r2 = r11.m3115a(r12, r6, r2);
    L_0x0091:
        if (r2 != r8) goto L_0x00d7;
    L_0x0093:
        r2 = r11.aLT;
        r6 = r11.aLU;
        if (r2 < r6) goto L_0x009c;
    L_0x0099:
        r11.AM();
    L_0x009c:
        r2 = r11.aOr;
        r6 = r11.aLT;
        r7 = r6 + 1;
        r11.aLT = r7;
        r2 = r2[r6];
        r6 = r12.usesPaddingChar(r2);
        if (r6 != 0) goto L_0x00ce;
    L_0x00ac:
        r0 = new java.lang.StringBuilder;
        r0.<init>();
        r1 = "expected padding character '";
        r0 = r0.append(r1);
        r1 = r12.getPaddingChar();
        r0 = r0.append(r1);
        r1 = "'";
        r0 = r0.append(r1);
        r0 = r0.toString();
        r0 = r11.m3120a(r12, r2, r10, r0);
        throw r0;
    L_0x00ce:
        r4 = r4 >> 4;
        r2 = r3 + 1;
        r4 = (byte) r4;
        r14[r3] = r4;
        goto L_0x000a;
    L_0x00d7:
        r4 = r4 << 6;
        r4 = r4 | r2;
        r2 = r11.aLT;
        r6 = r11.aLU;
        if (r2 < r6) goto L_0x00e3;
    L_0x00e0:
        r11.AM();
    L_0x00e3:
        r2 = r11.aOr;
        r6 = r11.aLT;
        r7 = r6 + 1;
        r11.aLT = r7;
        r6 = r2[r6];
        r2 = r12.decodeBase64Char(r6);
        if (r2 >= 0) goto L_0x0123;
    L_0x00f3:
        if (r2 == r8) goto L_0x0111;
    L_0x00f5:
        if (r6 != r9) goto L_0x010d;
    L_0x00f7:
        r2 = r12.usesPadding();
        if (r2 != 0) goto L_0x010d;
    L_0x00fd:
        r4 = r4 >> 2;
        r5 = r3 + 1;
        r2 = r4 >> 8;
        r2 = (byte) r2;
        r14[r3] = r2;
        r2 = r5 + 1;
        r3 = (byte) r4;
        r14[r5] = r3;
        goto L_0x0029;
    L_0x010d:
        r2 = r11.m3115a(r12, r6, r10);
    L_0x0111:
        if (r2 != r8) goto L_0x0123;
    L_0x0113:
        r4 = r4 >> 2;
        r6 = r3 + 1;
        r2 = r4 >> 8;
        r2 = (byte) r2;
        r14[r3] = r2;
        r2 = r6 + 1;
        r3 = (byte) r4;
        r14[r6] = r3;
        goto L_0x000a;
    L_0x0123:
        r4 = r4 << 6;
        r4 = r4 | r2;
        r2 = r3 + 1;
        r6 = r4 >> 16;
        r6 = (byte) r6;
        r14[r3] = r6;
        r3 = r2 + 1;
        r6 = r4 >> 8;
        r6 = (byte) r6;
        r14[r2] = r6;
        r2 = r3 + 1;
        r4 = (byte) r4;
        r14[r3] = r4;
        goto L_0x000a;
    L_0x013b:
        r3 = r2;
        goto L_0x0040;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fossil.agc.a(com.fasterxml.jackson.core.Base64Variant, java.io.OutputStream, byte[]):int");
    }

    public final JsonToken zP() throws IOException {
        this.aMq = 0;
        if (this.aMA == JsonToken.FIELD_NAME) {
            return BX();
        }
        if (this.aOu) {
            Cf();
        }
        int Cj = Cj();
        if (Cj < 0) {
            close();
            this.aMA = null;
            return null;
        }
        this.aLY = (this.aLV + ((long) this.aLT)) - 1;
        this.aLZ = this.aLW;
        this.aMa = (this.aLT - this.aLX) - 1;
        this.aMh = null;
        JsonToken jsonToken;
        if (Cj == 93) {
            if (!this.aMb.AA()) {
                m3121a(Cj, '}');
            }
            this.aMb = this.aMb.BQ();
            jsonToken = JsonToken.END_ARRAY;
            this.aMA = jsonToken;
            return jsonToken;
        } else if (Cj == 125) {
            if (!this.aMb.AC()) {
                m3121a(Cj, ']');
            }
            this.aMb = this.aMb.BQ();
            jsonToken = JsonToken.END_OBJECT;
            this.aMA = jsonToken;
            return jsonToken;
        } else {
            if (this.aMb.BS()) {
                Cj = fP(Cj);
            }
            boolean AC = this.aMb.AC();
            if (AC) {
                this.aMb.bq(Cj == 34 ? Cb() : fN(Cj));
                this.aMA = JsonToken.FIELD_NAME;
                Cj = Ch();
            }
            switch (Cj) {
                case 34:
                    this.aOu = true;
                    jsonToken = JsonToken.VALUE_STRING;
                    break;
                case 45:
                    jsonToken = BY();
                    break;
                case 48:
                case 49:
                case 50:
                case 51:
                case 52:
                case 53:
                case 54:
                case 55:
                case 56:
                case 57:
                    jsonToken = fL(Cj);
                    break;
                case 91:
                    if (!AC) {
                        this.aMb = this.aMb.bs(this.aLZ, this.aMa);
                    }
                    jsonToken = JsonToken.START_ARRAY;
                    break;
                case 93:
                case 125:
                    m3112h(Cj, "expected a value");
                    break;
                case 102:
                    Cq();
                    jsonToken = JsonToken.VALUE_FALSE;
                    break;
                case 110:
                    Cr();
                    jsonToken = JsonToken.VALUE_NULL;
                    break;
                case 116:
                    break;
                case 123:
                    if (!AC) {
                        this.aMb = this.aMb.bt(this.aLZ, this.aMa);
                    }
                    jsonToken = JsonToken.START_OBJECT;
                    break;
                default:
                    jsonToken = fO(Cj);
                    break;
            }
            Cp();
            jsonToken = JsonToken.VALUE_TRUE;
            if (AC) {
                this.aMc = jsonToken;
                return this.aMA;
            }
            this.aMA = jsonToken;
            return jsonToken;
        }
    }

    private final JsonToken BX() {
        this.aMf = false;
        JsonToken jsonToken = this.aMc;
        this.aMc = null;
        if (jsonToken == JsonToken.START_ARRAY) {
            this.aMb = this.aMb.bs(this.aLZ, this.aMa);
        } else if (jsonToken == JsonToken.START_OBJECT) {
            this.aMb = this.aMb.bt(this.aLZ, this.aMa);
        }
        this.aMA = jsonToken;
        return jsonToken;
    }

    public String zR() throws IOException {
        this.aMq = 0;
        if (this.aMA == JsonToken.FIELD_NAME) {
            BX();
            return null;
        }
        if (this.aOu) {
            Cf();
        }
        int Cj = Cj();
        if (Cj < 0) {
            close();
            this.aMA = null;
            return null;
        }
        this.aLY = (this.aLV + ((long) this.aLT)) - 1;
        this.aLZ = this.aLW;
        this.aMa = (this.aLT - this.aLX) - 1;
        this.aMh = null;
        if (Cj == 93) {
            if (!this.aMb.AA()) {
                m3121a(Cj, '}');
            }
            this.aMb = this.aMb.BQ();
            this.aMA = JsonToken.END_ARRAY;
            return null;
        } else if (Cj == 125) {
            if (!this.aMb.AC()) {
                m3121a(Cj, ']');
            }
            this.aMb = this.aMb.BQ();
            this.aMA = JsonToken.END_OBJECT;
            return null;
        } else {
            if (this.aMb.BS()) {
                Cj = fP(Cj);
            }
            if (this.aMb.AC()) {
                String Cb = Cj == 34 ? Cb() : fN(Cj);
                this.aMb.bq(Cb);
                this.aMA = JsonToken.FIELD_NAME;
                int Ch = Ch();
                if (Ch == 34) {
                    this.aOu = true;
                    this.aMc = JsonToken.VALUE_STRING;
                    return Cb;
                }
                JsonToken BY;
                switch (Ch) {
                    case 45:
                        BY = BY();
                        break;
                    case 48:
                    case 49:
                    case 50:
                    case 51:
                    case 52:
                    case 53:
                    case 54:
                    case 55:
                    case 56:
                    case 57:
                        BY = fL(Ch);
                        break;
                    case 91:
                        BY = JsonToken.START_ARRAY;
                        break;
                    case 102:
                        Cq();
                        BY = JsonToken.VALUE_FALSE;
                        break;
                    case 110:
                        Cr();
                        BY = JsonToken.VALUE_NULL;
                        break;
                    case 116:
                        Cp();
                        BY = JsonToken.VALUE_TRUE;
                        break;
                    case 123:
                        BY = JsonToken.START_OBJECT;
                        break;
                    default:
                        BY = fO(Ch);
                        break;
                }
                this.aMc = BY;
                return Cb;
            }
            fK(Cj);
            return null;
        }
    }

    private final JsonToken fK(int i) throws IOException {
        if (i == 34) {
            this.aOu = true;
            JsonToken jsonToken = JsonToken.VALUE_STRING;
            this.aMA = jsonToken;
            return jsonToken;
        }
        switch (i) {
            case 45:
                jsonToken = BY();
                this.aMA = jsonToken;
                return jsonToken;
            case 48:
            case 49:
            case 50:
            case 51:
            case 52:
            case 53:
            case 54:
            case 55:
            case 56:
            case 57:
                jsonToken = fL(i);
                this.aMA = jsonToken;
                return jsonToken;
            case 91:
                this.aMb = this.aMb.bs(this.aLZ, this.aMa);
                jsonToken = JsonToken.START_ARRAY;
                this.aMA = jsonToken;
                return jsonToken;
            case 102:
                m3202j("false", 1);
                jsonToken = JsonToken.VALUE_FALSE;
                this.aMA = jsonToken;
                return jsonToken;
            case 110:
                m3202j("null", 1);
                jsonToken = JsonToken.VALUE_NULL;
                this.aMA = jsonToken;
                return jsonToken;
            case 116:
                m3202j(ServerProtocol.DIALOG_RETURN_SCOPES_TRUE, 1);
                jsonToken = JsonToken.VALUE_TRUE;
                this.aMA = jsonToken;
                return jsonToken;
            case 123:
                this.aMb = this.aMb.bt(this.aLZ, this.aMa);
                jsonToken = JsonToken.START_OBJECT;
                this.aMA = jsonToken;
                return jsonToken;
            default:
                jsonToken = fO(i);
                this.aMA = jsonToken;
                return jsonToken;
        }
    }

    public final String zS() throws IOException {
        if (this.aMA == JsonToken.FIELD_NAME) {
            this.aMf = false;
            JsonToken jsonToken = this.aMc;
            this.aMc = null;
            this.aMA = jsonToken;
            if (jsonToken == JsonToken.VALUE_STRING) {
                if (this.aOu) {
                    this.aOu = false;
                    AO();
                }
                return this.aMd.Da();
            } else if (jsonToken == JsonToken.START_ARRAY) {
                this.aMb = this.aMb.bs(this.aLZ, this.aMa);
                return null;
            } else if (jsonToken != JsonToken.START_OBJECT) {
                return null;
            } else {
                this.aMb = this.aMb.bt(this.aLZ, this.aMa);
                return null;
            }
        } else if (zP() == JsonToken.VALUE_STRING) {
            return getText();
        } else {
            return null;
        }
    }

    protected final JsonToken fL(int i) throws IOException {
        int i2 = this.aLT;
        int i3 = i2 - 1;
        int i4 = this.aLU;
        if (i == 48) {
            return m3195d(false, i3);
        }
        int i5 = 1;
        int i6 = i2;
        while (i6 < i4) {
            i2 = i6 + 1;
            char c = this.aOr[i6];
            if (c >= '0' && c <= '9') {
                i5++;
                i6 = i2;
            } else if (c == '.' || c == 'e' || c == 'E') {
                this.aLT = i2;
                return m3193a(c, i3, i2, false, i5);
            } else {
                i6 = i2 - 1;
                this.aLT = i6;
                if (this.aMb.AB()) {
                    fM(c);
                }
                this.aMd.m3322q(this.aOr, i3, i6 - i3);
                return m3124c(false, i5);
            }
        }
        this.aLT = i3;
        return m3195d(false, i3);
    }

    private final JsonToken m3193a(int i, int i2, int i3, boolean z, int i4) throws IOException {
        int i5;
        int i6;
        int i7 = 0;
        int i8 = this.aLU;
        int i9;
        if (i == 46) {
            i5 = 0;
            i9 = i3;
            while (i9 < i8) {
                i3 = i9 + 1;
                i9 = this.aOr[i9];
                if (i9 < 48 || i9 > 57) {
                    if (i5 == 0) {
                        m3125g(i9, "Decimal point not followed by a digit");
                    }
                    i6 = i5;
                    i5 = i3;
                } else {
                    i5++;
                    i9 = i3;
                }
            }
            return m3195d(z, i2);
        }
        i6 = 0;
        i5 = i3;
        i9 = i;
        if (i9 == 101 || i9 == 69) {
            if (i5 >= i8) {
                this.aLT = i2;
                return m3195d(z, i2);
            }
            int i10;
            char c;
            i9 = i5 + 1;
            char c2 = this.aOr[i5];
            if (c2 != '-' && c2 != '+') {
                i10 = i9;
                c = c2;
                i5 = i10;
            } else if (i9 >= i8) {
                this.aLT = i2;
                return m3195d(z, i2);
            } else {
                i5 = i9 + 1;
                i9 = this.aOr[i9];
            }
            while (i9 <= 57 && i9 >= 48) {
                i7++;
                if (i5 >= i8) {
                    this.aLT = i2;
                    return m3195d(z, i2);
                }
                i10 = i5 + 1;
                c = this.aOr[i5];
                i5 = i10;
            }
            if (i7 == 0) {
                m3125g(i9, "Exponent indicator not followed by a digit");
            }
        }
        i5--;
        this.aLT = i5;
        if (this.aMb.AB()) {
            fM(i9);
        }
        this.aMd.m3322q(this.aOr, i2, i5 - i2);
        return m3122b(z, i4, i6, i7);
    }

    protected final JsonToken BY() throws IOException {
        int i = this.aLT;
        int i2 = i - 1;
        int i3 = this.aLU;
        if (i >= i3) {
            return m3195d(true, i2);
        }
        int i4 = i + 1;
        char c = this.aOr[i];
        if (c > '9' || c < '0') {
            this.aLT = i4;
            return m3203q(c, true);
        } else if (c == '0') {
            return m3195d(true, i2);
        } else {
            int i5 = 1;
            i = i4;
            while (i < i3) {
                i4 = i + 1;
                char c2 = this.aOr[i];
                if (c2 >= '0' && c2 <= '9') {
                    i5++;
                    i = i4;
                } else if (c2 == '.' || c2 == 'e' || c2 == 'E') {
                    this.aLT = i4;
                    return m3193a(c2, i2, i4, true, i5);
                } else {
                    i = i4 - 1;
                    this.aLT = i;
                    if (this.aMb.AB()) {
                        fM(c2);
                    }
                    this.aMd.m3322q(this.aOr, i2, i - i2);
                    return m3124c(true, i5);
                }
            }
            return m3195d(true, i2);
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final com.fasterxml.jackson.core.JsonToken m3195d(boolean r11, int r12) throws java.io.IOException {
        /*
        r10 = this;
        if (r11 == 0) goto L_0x0004;
    L_0x0002:
        r12 = r12 + 1;
    L_0x0004:
        r10.aLT = r12;
        r0 = r10.aMd;
        r2 = r0.Df();
        r1 = 0;
        if (r11 == 0) goto L_0x019e;
    L_0x000f:
        r0 = 1;
        r3 = 45;
        r2[r1] = r3;
    L_0x0014:
        r3 = 0;
        r1 = r10.aLT;
        r4 = r10.aLU;
        if (r1 >= r4) goto L_0x0061;
    L_0x001b:
        r1 = r10.aOr;
        r4 = r10.aLT;
        r5 = r4 + 1;
        r10.aLT = r5;
        r1 = r1[r4];
    L_0x0025:
        r4 = 48;
        if (r1 != r4) goto L_0x002d;
    L_0x0029:
        r1 = r10.BZ();
    L_0x002d:
        r5 = 0;
        r9 = r1;
        r1 = r2;
        r2 = r9;
    L_0x0031:
        r4 = 48;
        if (r2 < r4) goto L_0x0198;
    L_0x0035:
        r4 = 57;
        if (r2 > r4) goto L_0x0198;
    L_0x0039:
        r3 = r3 + 1;
        r4 = r1.length;
        if (r0 < r4) goto L_0x0045;
    L_0x003e:
        r0 = r10.aMd;
        r1 = r0.Dh();
        r0 = 0;
    L_0x0045:
        r4 = r0 + 1;
        r1[r0] = r2;
        r0 = r10.aLT;
        r2 = r10.aLU;
        if (r0 < r2) goto L_0x0068;
    L_0x004f:
        r0 = r10.AN();
        if (r0 != 0) goto L_0x0068;
    L_0x0055:
        r0 = 0;
        r5 = 1;
        r7 = r3;
        r3 = r1;
        r1 = r0;
    L_0x005a:
        if (r7 != 0) goto L_0x0074;
    L_0x005c:
        r0 = r10.m3203q(r1, r11);
    L_0x0060:
        return r0;
    L_0x0061:
        r1 = "No digit following minus sign";
        r1 = r10.bs(r1);
        goto L_0x0025;
    L_0x0068:
        r0 = r10.aOr;
        r2 = r10.aLT;
        r6 = r2 + 1;
        r10.aLT = r6;
        r2 = r0[r2];
        r0 = r4;
        goto L_0x0031;
    L_0x0074:
        r0 = 0;
        r2 = 46;
        if (r1 != r2) goto L_0x0191;
    L_0x0079:
        r2 = r4 + 1;
        r3[r4] = r1;
    L_0x007d:
        r4 = r10.aLT;
        r6 = r10.aLU;
        if (r4 < r6) goto L_0x0133;
    L_0x0083:
        r4 = r10.AN();
        if (r4 != 0) goto L_0x0133;
    L_0x0089:
        r5 = 1;
        r4 = r5;
        r5 = r1;
    L_0x008c:
        if (r0 != 0) goto L_0x0093;
    L_0x008e:
        r1 = "Decimal point not followed by a digit";
        r10.m3125g(r5, r1);
    L_0x0093:
        r6 = r0;
        r1 = r3;
        r0 = r2;
    L_0x0096:
        r3 = 0;
        r2 = 101; // 0x65 float:1.42E-43 double:5.0E-322;
        if (r5 == r2) goto L_0x009f;
    L_0x009b:
        r2 = 69;
        if (r5 != r2) goto L_0x0185;
    L_0x009f:
        r2 = r1.length;
        if (r0 < r2) goto L_0x00a9;
    L_0x00a2:
        r0 = r10.aMd;
        r1 = r0.Dh();
        r0 = 0;
    L_0x00a9:
        r2 = r0 + 1;
        r1[r0] = r5;
        r0 = r10.aLT;
        r5 = r10.aLU;
        if (r0 >= r5) goto L_0x015c;
    L_0x00b3:
        r0 = r10.aOr;
        r5 = r10.aLT;
        r8 = r5 + 1;
        r10.aLT = r8;
        r5 = r0[r5];
    L_0x00bd:
        r0 = 45;
        if (r5 == r0) goto L_0x00c5;
    L_0x00c1:
        r0 = 43;
        if (r5 != r0) goto L_0x0181;
    L_0x00c5:
        r0 = r1.length;
        if (r2 < r0) goto L_0x017e;
    L_0x00c8:
        r0 = r10.aMd;
        r1 = r0.Dh();
        r0 = 0;
    L_0x00cf:
        r2 = r0 + 1;
        r1[r0] = r5;
        r0 = r10.aLT;
        r5 = r10.aLU;
        if (r0 >= r5) goto L_0x0164;
    L_0x00d9:
        r0 = r10.aOr;
        r5 = r10.aLT;
        r8 = r5 + 1;
        r10.aLT = r8;
        r0 = r0[r5];
    L_0x00e3:
        r9 = r0;
        r0 = r2;
        r2 = r9;
    L_0x00e6:
        r5 = 57;
        if (r2 > r5) goto L_0x0179;
    L_0x00ea:
        r5 = 48;
        if (r2 < r5) goto L_0x0179;
    L_0x00ee:
        r3 = r3 + 1;
        r5 = r1.length;
        if (r0 < r5) goto L_0x00fa;
    L_0x00f3:
        r0 = r10.aMd;
        r1 = r0.Dh();
        r0 = 0;
    L_0x00fa:
        r5 = r0 + 1;
        r1[r0] = r2;
        r0 = r10.aLT;
        r8 = r10.aLU;
        if (r0 < r8) goto L_0x016c;
    L_0x0104:
        r0 = r10.AN();
        if (r0 != 0) goto L_0x016c;
    L_0x010a:
        r4 = 1;
        r0 = r3;
        r1 = r4;
        r3 = r5;
    L_0x010e:
        if (r0 != 0) goto L_0x0115;
    L_0x0110:
        r4 = "Exponent indicator not followed by a digit";
        r10.m3125g(r2, r4);
    L_0x0115:
        if (r1 != 0) goto L_0x0128;
    L_0x0117:
        r1 = r10.aLT;
        r1 = r1 + -1;
        r10.aLT = r1;
        r1 = r10.aMb;
        r1 = r1.AB();
        if (r1 == 0) goto L_0x0128;
    L_0x0125:
        r10.fM(r2);
    L_0x0128:
        r1 = r10.aMd;
        r1.gL(r3);
        r0 = r10.m3119a(r11, r7, r6, r0);
        goto L_0x0060;
    L_0x0133:
        r1 = r10.aOr;
        r4 = r10.aLT;
        r6 = r4 + 1;
        r10.aLT = r6;
        r1 = r1[r4];
        r4 = 48;
        if (r1 < r4) goto L_0x018d;
    L_0x0141:
        r4 = 57;
        if (r1 <= r4) goto L_0x0149;
    L_0x0145:
        r4 = r5;
        r5 = r1;
        goto L_0x008c;
    L_0x0149:
        r0 = r0 + 1;
        r4 = r3.length;
        if (r2 < r4) goto L_0x018b;
    L_0x014e:
        r2 = r10.aMd;
        r3 = r2.Dh();
        r2 = 0;
        r4 = r2;
    L_0x0156:
        r2 = r4 + 1;
        r3[r4] = r1;
        goto L_0x007d;
    L_0x015c:
        r0 = "expected a digit for number exponent";
        r5 = r10.bs(r0);
        goto L_0x00bd;
    L_0x0164:
        r0 = "expected a digit for number exponent";
        r0 = r10.bs(r0);
        goto L_0x00e3;
    L_0x016c:
        r0 = r10.aOr;
        r2 = r10.aLT;
        r8 = r2 + 1;
        r10.aLT = r8;
        r2 = r0[r2];
        r0 = r5;
        goto L_0x00e6;
    L_0x0179:
        r1 = r4;
        r9 = r3;
        r3 = r0;
        r0 = r9;
        goto L_0x010e;
    L_0x017e:
        r0 = r2;
        goto L_0x00cf;
    L_0x0181:
        r0 = r2;
        r2 = r5;
        goto L_0x00e6;
    L_0x0185:
        r1 = r4;
        r2 = r5;
        r9 = r3;
        r3 = r0;
        r0 = r9;
        goto L_0x0115;
    L_0x018b:
        r4 = r2;
        goto L_0x0156;
    L_0x018d:
        r4 = r5;
        r5 = r1;
        goto L_0x008c;
    L_0x0191:
        r6 = r0;
        r0 = r4;
        r4 = r5;
        r5 = r1;
        r1 = r3;
        goto L_0x0096;
    L_0x0198:
        r7 = r3;
        r4 = r0;
        r3 = r1;
        r1 = r2;
        goto L_0x005a;
    L_0x019e:
        r0 = r1;
        goto L_0x0014;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fossil.agc.d(boolean, int):com.fasterxml.jackson.core.JsonToken");
    }

    private final char BZ() throws IOException {
        if (this.aLT < this.aLU) {
            char c = this.aOr[this.aLT];
            if (c < '0' || c > '9') {
                return '0';
            }
        }
        return Ca();
    }

    private char Ca() throws IOException {
        if (this.aLT >= this.aLU && !AN()) {
            return '0';
        }
        char c = this.aOr[this.aLT];
        if (c < '0' || c > '9') {
            return '0';
        }
        if (!isEnabled(Feature.ALLOW_NUMERIC_LEADING_ZEROS)) {
            bf("Leading zeroes not allowed");
        }
        this.aLT++;
        if (c != '0') {
            return c;
        }
        do {
            if (this.aLT >= this.aLU && !AN()) {
                return c;
            }
            c = this.aOr[this.aLT];
            if (c < '0' || c > '9') {
                return '0';
            }
            this.aLT++;
        } while (c == '0');
        return c;
    }

    protected JsonToken m3203q(int i, boolean z) throws IOException {
        double d = Double.NEGATIVE_INFINITY;
        if (i == 73) {
            if (this.aLT >= this.aLU && !AN()) {
                Bd();
            }
            char[] cArr = this.aOr;
            int i2 = this.aLT;
            this.aLT = i2 + 1;
            i = cArr[i2];
            String str;
            if (i == 78) {
                str = z ? "-INF" : "+INF";
                m3202j(str, 3);
                if (isEnabled(Feature.ALLOW_NON_NUMERIC_NUMBERS)) {
                    if (!z) {
                        d = Double.POSITIVE_INFINITY;
                    }
                    return m3118a(str, d);
                }
                aX("Non-standard token '" + str + "': enable JsonParser.Feature.ALLOW_NON_NUMERIC_NUMBERS to allow");
            } else if (i == 110) {
                str = z ? "-Infinity" : "+Infinity";
                m3202j(str, 3);
                if (isEnabled(Feature.ALLOW_NON_NUMERIC_NUMBERS)) {
                    if (!z) {
                        d = Double.POSITIVE_INFINITY;
                    }
                    return m3118a(str, d);
                }
                aX("Non-standard token '" + str + "': enable JsonParser.Feature.ALLOW_NON_NUMERIC_NUMBERS to allow");
            }
        }
        m3125g(i, "expected digit (0-9) to follow minus sign, for valid numeric value");
        return null;
    }

    private final void fM(int i) throws IOException {
        this.aLT++;
        switch (i) {
            case 9:
            case 32:
                return;
            case 10:
                this.aLW++;
                this.aLX = this.aLT;
                return;
            case 13:
                Cg();
                return;
            default:
                fs(i);
                return;
        }
    }

    protected final String Cb() throws IOException {
        int i;
        int i2 = this.aLT;
        int i3 = this.aOt;
        int[] iArr = aOp;
        while (i2 < this.aLU) {
            char c = this.aOr[i2];
            if (c >= iArr.length || iArr[c] == 0) {
                i3 = (i3 * 33) + c;
                i2++;
            } else {
                if (c == '\"') {
                    i = this.aLT;
                    this.aLT = i2 + 1;
                    return this.aOs.m3315b(this.aOr, i, i2 - i, i3);
                }
                i = this.aLT;
                this.aLT = i2;
                return m3196u(i, i3, 34);
            }
        }
        i = this.aLT;
        this.aLT = i2;
        return m3196u(i, i3, 34);
    }

    private String m3196u(int i, int i2, int i3) throws IOException {
        this.aMd.m3322q(this.aOr, i, this.aLT - i);
        char[] De = this.aMd.De();
        int Dg = this.aMd.Dg();
        while (true) {
            if (this.aLT >= this.aLU && !AN()) {
                bg(": was expecting closing '" + ((char) i3) + "' for name");
            }
            char[] cArr = this.aOr;
            int i4 = this.aLT;
            this.aLT = i4 + 1;
            char c = cArr[i4];
            if (c <= '\\') {
                if (c == '\\') {
                    c = Bb();
                } else if (c <= i3) {
                    if (c == i3) {
                        this.aMd.gL(Dg);
                        agr com_fossil_agr = this.aMd;
                        return this.aOs.m3315b(com_fossil_agr.CZ(), com_fossil_agr.Af(), com_fossil_agr.size(), i2);
                    } else if (c < ' ') {
                        m3113i(c, "name");
                    }
                }
            }
            i2 = (i2 * 33) + c;
            i4 = Dg + 1;
            De[Dg] = c;
            if (i4 >= De.length) {
                De = this.aMd.Dh();
                Dg = 0;
            } else {
                Dg = i4;
            }
        }
    }

    protected String fN(int i) throws IOException {
        if (i == 39 && isEnabled(Feature.ALLOW_SINGLE_QUOTES)) {
            return Cc();
        }
        if (!isEnabled(Feature.ALLOW_UNQUOTED_FIELD_NAMES)) {
            m3112h(i, "was expecting double-quote to start field name");
        }
        int[] Br = afn.Br();
        char length = Br.length;
        boolean isJavaIdentifierPart = i < length ? Br[i] == 0 : Character.isJavaIdentifierPart((char) i);
        if (!isJavaIdentifierPart) {
            m3112h(i, "was expecting either valid name character (for unquoted name) or double-quote (for quoted) to start field name");
        }
        int i2 = this.aLT;
        int i3 = this.aOt;
        int i4 = this.aLU;
        if (i2 < i4) {
            do {
                char c = this.aOr[i2];
                int i5;
                if (c < length) {
                    if (Br[c] != 0) {
                        i5 = this.aLT - 1;
                        this.aLT = i2;
                        return this.aOs.m3315b(this.aOr, i5, i2 - i5, i3);
                    }
                } else if (!Character.isJavaIdentifierPart((char) c)) {
                    i5 = this.aLT - 1;
                    this.aLT = i2;
                    return this.aOs.m3315b(this.aOr, i5, i2 - i5, i3);
                }
                i3 = (i3 * 33) + c;
                i2++;
            } while (i2 < i4);
        }
        int i6 = this.aLT - 1;
        this.aLT = i2;
        return m3194a(i6, i3, Br);
    }

    protected String Cc() throws IOException {
        int i = this.aLT;
        int i2 = this.aOt;
        int i3 = this.aLU;
        if (i < i3) {
            int[] iArr = aOp;
            char length = iArr.length;
            do {
                char c = this.aOr[i];
                if (c != '\'') {
                    if (c < length && iArr[c] != 0) {
                        break;
                    }
                    i2 = (i2 * 33) + c;
                    i++;
                } else {
                    i3 = this.aLT;
                    this.aLT = i + 1;
                    return this.aOs.m3315b(this.aOr, i3, i - i3, i2);
                }
            } while (i < i3);
        }
        i3 = this.aLT;
        this.aLT = i;
        return m3196u(i3, i2, 39);
    }

    protected JsonToken fO(int i) throws IOException {
        switch (i) {
            case 39:
                if (isEnabled(Feature.ALLOW_SINGLE_QUOTES)) {
                    return Cd();
                }
                break;
            case 43:
                if (this.aLT >= this.aLU && !AN()) {
                    Bd();
                }
                char[] cArr = this.aOr;
                int i2 = this.aLT;
                this.aLT = i2 + 1;
                return m3203q(cArr[i2], false);
            case 73:
                m3202j("Infinity", 1);
                if (!isEnabled(Feature.ALLOW_NON_NUMERIC_NUMBERS)) {
                    aX("Non-standard token 'Infinity': enable JsonParser.Feature.ALLOW_NON_NUMERIC_NUMBERS to allow");
                    break;
                }
                return m3118a("Infinity", Double.POSITIVE_INFINITY);
            case 78:
                m3202j("NaN", 1);
                if (!isEnabled(Feature.ALLOW_NON_NUMERIC_NUMBERS)) {
                    aX("Non-standard token 'NaN': enable JsonParser.Feature.ALLOW_NON_NUMERIC_NUMBERS to allow");
                    break;
                }
                return m3118a("NaN", Double.NaN);
        }
        if (Character.isJavaIdentifierStart(i)) {
            m3204s("" + ((char) i), "('true', 'false' or 'null')");
        }
        m3112h(i, "expected a valid value (number, String, array, object, 'true', 'false' or 'null')");
        return null;
    }

    protected JsonToken Cd() throws IOException {
        char[] Df = this.aMd.Df();
        int Dg = this.aMd.Dg();
        while (true) {
            if (this.aLT >= this.aLU && !AN()) {
                bg(": was expecting closing quote for a string value");
            }
            char[] cArr = this.aOr;
            int i = this.aLT;
            this.aLT = i + 1;
            char c = cArr[i];
            if (c <= '\\') {
                if (c == '\\') {
                    c = Bb();
                } else if (c <= '\'') {
                    if (c == '\'') {
                        this.aMd.gL(Dg);
                        return JsonToken.VALUE_STRING;
                    } else if (c < ' ') {
                        m3113i(c, "string value");
                    }
                }
            }
            if (Dg >= Df.length) {
                Df = this.aMd.Dh();
                i = 0;
            } else {
                i = Dg;
            }
            Dg = i + 1;
            Df[i] = c;
        }
    }

    private String m3194a(int i, int i2, int[] iArr) throws IOException {
        this.aMd.m3322q(this.aOr, i, this.aLT - i);
        char[] De = this.aMd.De();
        int Dg = this.aMd.Dg();
        char length = iArr.length;
        while (true) {
            if (this.aLT >= this.aLU && !AN()) {
                break;
            }
            char c = this.aOr[this.aLT];
            if (c > length) {
                if (!Character.isJavaIdentifierPart(c)) {
                    break;
                }
            } else if (iArr[c] != 0) {
                break;
            }
            this.aLT++;
            i2 = (i2 * 33) + c;
            int i3 = Dg + 1;
            De[Dg] = c;
            if (i3 >= De.length) {
                De = this.aMd.Dh();
                Dg = 0;
            } else {
                Dg = i3;
            }
        }
        this.aMd.gL(Dg);
        agr com_fossil_agr = this.aMd;
        return this.aOs.m3315b(com_fossil_agr.CZ(), com_fossil_agr.Af(), com_fossil_agr.size(), i2);
    }

    protected final void AO() throws IOException {
        int i = this.aLT;
        int i2 = this.aLU;
        if (i < i2) {
            int[] iArr = aOp;
            char length = iArr.length;
            do {
                char c = this.aOr[i];
                if (c >= length || iArr[c] == 0) {
                    i++;
                } else if (c == '\"') {
                    this.aMd.m3322q(this.aOr, this.aLT, i - this.aLT);
                    this.aLT = i + 1;
                    return;
                }
            } while (i < i2);
        }
        this.aMd.m3323r(this.aOr, this.aLT, i - this.aLT);
        this.aLT = i;
        Ce();
    }

    protected void Ce() throws IOException {
        char[] De = this.aMd.De();
        int Dg = this.aMd.Dg();
        int[] iArr = aOp;
        char length = iArr.length;
        while (true) {
            if (this.aLT >= this.aLU && !AN()) {
                bg(": was expecting closing quote for a string value");
            }
            char[] cArr = this.aOr;
            int i = this.aLT;
            this.aLT = i + 1;
            char c = cArr[i];
            if (c < length && iArr[c] != 0) {
                if (c == '\"') {
                    this.aMd.gL(Dg);
                    return;
                } else if (c == '\\') {
                    c = Bb();
                } else if (c < ' ') {
                    m3113i(c, "string value");
                }
            }
            if (Dg >= De.length) {
                De = this.aMd.Dh();
                i = 0;
            } else {
                i = Dg;
            }
            Dg = i + 1;
            De[i] = c;
        }
    }

    protected final void Cf() throws IOException {
        this.aOu = false;
        int i = this.aLT;
        int i2 = this.aLU;
        char[] cArr = this.aOr;
        while (true) {
            if (i >= i2) {
                this.aLT = i;
                if (!AN()) {
                    bg(": was expecting closing quote for a string value");
                }
                i = this.aLT;
                i2 = this.aLU;
            }
            int i3 = i + 1;
            char c = cArr[i];
            if (c <= '\\') {
                if (c == '\\') {
                    this.aLT = i3;
                    Bb();
                    i = this.aLT;
                    i2 = this.aLU;
                } else if (c <= '\"') {
                    if (c == '\"') {
                        this.aLT = i3;
                        return;
                    } else if (c < ' ') {
                        this.aLT = i3;
                        m3113i(c, "string value");
                    }
                }
            }
            i = i3;
        }
    }

    protected final void Cg() throws IOException {
        if ((this.aLT < this.aLU || AN()) && this.aOr[this.aLT] == '\n') {
            this.aLT++;
        }
        this.aLW++;
        this.aLX = this.aLT;
    }

    private final int Ch() throws IOException {
        if (this.aLT + 4 >= this.aLU) {
            return aG(false);
        }
        char c = this.aOr[this.aLT];
        char[] cArr;
        int i;
        int i2;
        if (c == ':') {
            cArr = this.aOr;
            i = this.aLT + 1;
            this.aLT = i;
            i2 = cArr[i];
            if (i2 <= 32) {
                if (i2 == 32 || i2 == 9) {
                    cArr = this.aOr;
                    i = this.aLT + 1;
                    this.aLT = i;
                    i2 = cArr[i];
                    if (i2 > 32) {
                        if (i2 == 47 || i2 == 35) {
                            return aG(true);
                        }
                        this.aLT++;
                        return i2;
                    }
                }
                return aG(true);
            } else if (i2 == 47 || i2 == 35) {
                return aG(true);
            } else {
                this.aLT++;
                return i2;
            }
        }
        if (c == ' ' || c == '\t') {
            cArr = this.aOr;
            i = this.aLT + 1;
            this.aLT = i;
            c = cArr[i];
        }
        if (c != ':') {
            return aG(false);
        }
        cArr = this.aOr;
        i = this.aLT + 1;
        this.aLT = i;
        i2 = cArr[i];
        if (i2 <= 32) {
            if (i2 == 32 || i2 == 9) {
                cArr = this.aOr;
                i = this.aLT + 1;
                this.aLT = i;
                i2 = cArr[i];
                if (i2 > 32) {
                    if (i2 == 47 || i2 == 35) {
                        return aG(true);
                    }
                    this.aLT++;
                    return i2;
                }
            }
            return aG(true);
        } else if (i2 == 47 || i2 == 35) {
            return aG(true);
        } else {
            this.aLT++;
            return i2;
        }
    }

    private final int aG(boolean z) throws IOException {
        while (true) {
            if (this.aLT >= this.aLU) {
                AM();
            }
            char[] cArr = this.aOr;
            int i = this.aLT;
            this.aLT = i + 1;
            char c = cArr[i];
            if (c > ' ') {
                if (c == '/') {
                    Cl();
                } else if (c != '#' || !Cn()) {
                    if (z) {
                        return c;
                    }
                    if (c != ':') {
                        if (c < ' ') {
                            ft(c);
                        }
                        m3112h(c, "was expecting a colon to separate field name and value");
                    }
                    z = true;
                }
            } else if (c < ' ') {
                if (c == '\n') {
                    this.aLW++;
                    this.aLX = this.aLT;
                } else if (c == '\r') {
                    Cg();
                } else if (c != '\t') {
                    ft(c);
                }
            }
        }
    }

    private final int fP(int i) throws IOException {
        if (i != 44) {
            m3112h(i, "was expecting comma to separate " + this.aMb.AD() + " entries");
        }
        while (this.aLT < this.aLU) {
            char[] cArr = this.aOr;
            int i2 = this.aLT;
            this.aLT = i2 + 1;
            int i3 = cArr[i2];
            if (i3 > 32) {
                if (i3 != 47 && i3 != 35) {
                    return i3;
                }
                this.aLT--;
                return Ci();
            } else if (i3 < 32) {
                if (i3 == 10) {
                    this.aLW++;
                    this.aLX = this.aLT;
                } else if (i3 == 13) {
                    Cg();
                } else if (i3 != 9) {
                    ft(i3);
                }
            }
        }
        return Ci();
    }

    private final int Ci() throws IOException {
        char c;
        while (true) {
            if (this.aLT < this.aLU || AN()) {
                char[] cArr = this.aOr;
                int i = this.aLT;
                this.aLT = i + 1;
                c = cArr[i];
                if (c > ' ') {
                    if (c == '/') {
                        Cl();
                    } else if (c != '#' || !Cn()) {
                        return c;
                    }
                } else if (c < ' ') {
                    if (c == '\n') {
                        this.aLW++;
                        this.aLX = this.aLT;
                    } else if (c == '\r') {
                        Cg();
                    } else if (c != '\t') {
                        ft(c);
                    }
                }
            } else {
                throw aZ("Unexpected end-of-input within/between " + this.aMb.AD() + " entries");
            }
        }
        return c;
    }

    private final int Cj() throws IOException {
        if (this.aLT >= this.aLU && !AN()) {
            return AR();
        }
        char[] cArr = this.aOr;
        int i = this.aLT;
        this.aLT = i + 1;
        int i2 = cArr[i];
        if (i2 <= 32) {
            if (i2 != 32) {
                if (i2 == 10) {
                    this.aLW++;
                    this.aLX = this.aLT;
                } else if (i2 == 13) {
                    Cg();
                } else if (i2 != 9) {
                    ft(i2);
                }
            }
            while (this.aLT < this.aLU) {
                cArr = this.aOr;
                i = this.aLT;
                this.aLT = i + 1;
                i2 = cArr[i];
                if (i2 > 32) {
                    if (i2 != 47 && i2 != 35) {
                        return i2;
                    }
                    this.aLT--;
                    return Ck();
                } else if (i2 != 32) {
                    if (i2 == 10) {
                        this.aLW++;
                        this.aLX = this.aLT;
                    } else if (i2 == 13) {
                        Cg();
                    } else if (i2 != 9) {
                        ft(i2);
                    }
                }
            }
            return Ck();
        } else if (i2 != 47 && i2 != 35) {
            return i2;
        } else {
            this.aLT--;
            return Ck();
        }
    }

    private int Ck() throws IOException {
        while (true) {
            if (this.aLT >= this.aLU && !AN()) {
                return AR();
            }
            char[] cArr = this.aOr;
            int i = this.aLT;
            this.aLT = i + 1;
            int i2 = cArr[i];
            if (i2 > 32) {
                if (i2 == 47) {
                    Cl();
                } else if (i2 != 35 || !Cn()) {
                    return i2;
                }
            } else if (i2 != 32) {
                if (i2 == 10) {
                    this.aLW++;
                    this.aLX = this.aLT;
                } else if (i2 == 13) {
                    Cg();
                } else if (i2 != 9) {
                    ft(i2);
                }
            }
        }
    }

    private void Cl() throws IOException {
        if (!isEnabled(Feature.ALLOW_COMMENTS)) {
            m3112h(47, "maybe a (non-standard) comment? (not recognized as one since Feature 'ALLOW_COMMENTS' not enabled for parser)");
        }
        if (this.aLT >= this.aLU && !AN()) {
            bg(" in a comment");
        }
        char[] cArr = this.aOr;
        int i = this.aLT;
        this.aLT = i + 1;
        char c = cArr[i];
        if (c == '/') {
            Co();
        } else if (c == '*') {
            Cm();
        } else {
            m3112h(c, "was expecting either '*' or '/' for a comment");
        }
    }

    private void Cm() throws IOException {
        while (true) {
            if (this.aLT >= this.aLU && !AN()) {
                break;
            }
            char[] cArr = this.aOr;
            int i = this.aLT;
            this.aLT = i + 1;
            char c = cArr[i];
            if (c <= '*') {
                if (c == '*') {
                    if (this.aLT >= this.aLU && !AN()) {
                        break;
                    } else if (this.aOr[this.aLT] == '/') {
                        this.aLT++;
                        return;
                    }
                } else if (c < ' ') {
                    if (c == '\n') {
                        this.aLW++;
                        this.aLX = this.aLT;
                    } else if (c == '\r') {
                        Cg();
                    } else if (c != '\t') {
                        ft(c);
                    }
                }
            }
        }
        bg(" in a comment");
    }

    private boolean Cn() throws IOException {
        if (!isEnabled(Feature.ALLOW_YAML_COMMENTS)) {
            return false;
        }
        Co();
        return true;
    }

    private void Co() throws IOException {
        while (true) {
            if (this.aLT < this.aLU || AN()) {
                char[] cArr = this.aOr;
                int i = this.aLT;
                this.aLT = i + 1;
                char c = cArr[i];
                if (c < ' ') {
                    if (c == '\n') {
                        this.aLW++;
                        this.aLX = this.aLT;
                        return;
                    } else if (c == '\r') {
                        Cg();
                        return;
                    } else if (c != '\t') {
                        ft(c);
                    }
                }
            } else {
                return;
            }
        }
    }

    protected char Bb() throws IOException {
        int i = 0;
        if (this.aLT >= this.aLU && !AN()) {
            bg(" in character escape sequence");
        }
        char[] cArr = this.aOr;
        int i2 = this.aLT;
        this.aLT = i2 + 1;
        char c = cArr[i2];
        switch (c) {
            case '\"':
            case '/':
            case '\\':
                return c;
            case 'b':
                return '\b';
            case 'f':
                return '\f';
            case 'n':
                return '\n';
            case 'r':
                return '\r';
            case 't':
                return '\t';
            case 'u':
                for (int i3 = 0; i3 < 4; i3++) {
                    if (this.aLT >= this.aLU && !AN()) {
                        bg(" in character escape sequence");
                    }
                    char[] cArr2 = this.aOr;
                    int i4 = this.aLT;
                    this.aLT = i4 + 1;
                    char c2 = cArr2[i4];
                    i4 = afn.fx(c2);
                    if (i4 < 0) {
                        m3112h(c2, "expected a hex-digit for character escape sequence");
                    }
                    i = (i << 4) | i4;
                }
                return (char) i;
            default:
                return m3110b(c);
        }
    }

    private final void Cp() throws IOException {
        int i = this.aLT;
        if (i + 3 < this.aLU) {
            char[] cArr = this.aOr;
            if (cArr[i] == 'r') {
                i++;
                if (cArr[i] == 'u') {
                    i++;
                    if (cArr[i] == 'e') {
                        i++;
                        char c = cArr[i];
                        if (c < '0' || c == ']' || c == '}') {
                            this.aLT = i;
                            return;
                        }
                    }
                }
            }
        }
        m3202j(ServerProtocol.DIALOG_RETURN_SCOPES_TRUE, 1);
    }

    private final void Cq() throws IOException {
        int i = this.aLT;
        if (i + 4 < this.aLU) {
            char[] cArr = this.aOr;
            if (cArr[i] == 'a') {
                i++;
                if (cArr[i] == 'l') {
                    i++;
                    if (cArr[i] == 's') {
                        i++;
                        if (cArr[i] == 'e') {
                            i++;
                            char c = cArr[i];
                            if (c < '0' || c == ']' || c == '}') {
                                this.aLT = i;
                                return;
                            }
                        }
                    }
                }
            }
        }
        m3202j("false", 1);
    }

    private final void Cr() throws IOException {
        int i = this.aLT;
        if (i + 3 < this.aLU) {
            char[] cArr = this.aOr;
            if (cArr[i] == 'u') {
                i++;
                if (cArr[i] == 'l') {
                    i++;
                    if (cArr[i] == 'l') {
                        i++;
                        char c = cArr[i];
                        if (c < '0' || c == ']' || c == '}') {
                            this.aLT = i;
                            return;
                        }
                    }
                }
            }
        }
        m3202j("null", 1);
    }

    protected final void m3202j(String str, int i) throws IOException {
        int length = str.length();
        do {
            if (this.aLT >= this.aLU && !AN()) {
                bt(str.substring(0, i));
            }
            if (this.aOr[this.aLT] != str.charAt(i)) {
                bt(str.substring(0, i));
            }
            this.aLT++;
            i++;
        } while (i < length);
        if (this.aLT < this.aLU || AN()) {
            char c = this.aOr[this.aLT];
            if (c >= '0' && c != ']' && c != '}' && Character.isJavaIdentifierPart(c)) {
                bt(str.substring(0, i));
            }
        }
    }

    protected byte[] m3201b(Base64Variant base64Variant) throws IOException {
        agn AS = AS();
        while (true) {
            if (this.aLT >= this.aLU) {
                AM();
            }
            char[] cArr = this.aOr;
            int i = this.aLT;
            this.aLT = i + 1;
            char c = cArr[i];
            if (c > ' ') {
                int decodeBase64Char = base64Variant.decodeBase64Char(c);
                if (decodeBase64Char < 0) {
                    if (c == '\"') {
                        return AS.toByteArray();
                    }
                    decodeBase64Char = m3115a(base64Variant, c, 0);
                    if (decodeBase64Char < 0) {
                        continue;
                    }
                }
                if (this.aLT >= this.aLU) {
                    AM();
                }
                char[] cArr2 = this.aOr;
                int i2 = this.aLT;
                this.aLT = i2 + 1;
                char c2 = cArr2[i2];
                i = base64Variant.decodeBase64Char(c2);
                if (i < 0) {
                    i = m3115a(base64Variant, c2, 1);
                }
                i |= decodeBase64Char << 6;
                if (this.aLT >= this.aLU) {
                    AM();
                }
                cArr = this.aOr;
                i2 = this.aLT;
                this.aLT = i2 + 1;
                c2 = cArr[i2];
                decodeBase64Char = base64Variant.decodeBase64Char(c2);
                if (decodeBase64Char < 0) {
                    if (decodeBase64Char != -2) {
                        if (c2 != '\"' || base64Variant.usesPadding()) {
                            decodeBase64Char = m3115a(base64Variant, c2, 2);
                        } else {
                            AS.append(i >> 4);
                            return AS.toByteArray();
                        }
                    }
                    if (decodeBase64Char == -2) {
                        if (this.aLT >= this.aLU) {
                            AM();
                        }
                        cArr = this.aOr;
                        i2 = this.aLT;
                        this.aLT = i2 + 1;
                        char c3 = cArr[i2];
                        if (base64Variant.usesPaddingChar(c3)) {
                            AS.append(i >> 4);
                        } else {
                            throw m3120a(base64Variant, (int) c3, 3, "expected padding character '" + base64Variant.getPaddingChar() + "'");
                        }
                    }
                }
                i = (i << 6) | decodeBase64Char;
                if (this.aLT >= this.aLU) {
                    AM();
                }
                cArr = this.aOr;
                i2 = this.aLT;
                this.aLT = i2 + 1;
                c2 = cArr[i2];
                decodeBase64Char = base64Variant.decodeBase64Char(c2);
                if (decodeBase64Char < 0) {
                    if (decodeBase64Char != -2) {
                        if (c2 != '\"' || base64Variant.usesPadding()) {
                            decodeBase64Char = m3115a(base64Variant, c2, 3);
                        } else {
                            AS.gG(i >> 2);
                            return AS.toByteArray();
                        }
                    }
                    if (decodeBase64Char == -2) {
                        AS.gG(i >> 2);
                    }
                }
                AS.gH(decodeBase64Char | (i << 6));
            }
        }
    }

    protected void bt(String str) throws IOException {
        m3204s(str, "'null', 'true', 'false' or NaN");
    }

    protected void m3204s(String str, String str2) throws IOException {
        StringBuilder stringBuilder = new StringBuilder(str);
        while (true) {
            if (this.aLT >= this.aLU && !AN()) {
                break;
            }
            char c = this.aOr[this.aLT];
            if (!Character.isJavaIdentifierPart(c)) {
                break;
            }
            this.aLT++;
            stringBuilder.append(c);
        }
        aX("Unrecognized token '" + stringBuilder.toString() + "': was expecting " + str2);
    }
}
