package com.fossil;

import android.support.v8.renderscript.Allocation;
import com.facebook.internal.NativeProtocol;
import com.facebook.internal.ServerProtocol;
import com.fasterxml.jackson.core.Base64Variant;
import com.fasterxml.jackson.core.JsonLocation;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser.Feature;
import com.fasterxml.jackson.core.JsonToken;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Arrays;

public class age extends afg {
    private static final int[] aOH = afn.Bq();
    protected static final int[] aOp = afn.Bp();
    protected afa _objectCodec;
    protected byte[] aNW;
    protected boolean aNX;
    protected final agg aOI;
    protected int[] aOJ = new int[16];
    private int aOK;
    protected InputStream aOL;
    protected boolean aOu = false;

    public age(afo com_fossil_afo, int i, InputStream inputStream, afa com_fossil_afa, agg com_fossil_agg, byte[] bArr, int i2, int i3, boolean z) {
        super(com_fossil_afo, i);
        this.aOL = inputStream;
        this._objectCodec = com_fossil_afa;
        this.aOI = com_fossil_agg;
        this.aNW = bArr;
        this.aLT = i2;
        this.aLU = i3;
        this.aLX = i2;
        this.aLV = (long) (-i2);
        this.aNX = z;
    }

    public afa getCodec() {
        return this._objectCodec;
    }

    protected final boolean AN() throws IOException {
        this.aLV += (long) this.aLU;
        this.aLX -= this.aLU;
        if (this.aOL == null) {
            return false;
        }
        int length = this.aNW.length;
        if (length == 0) {
            return false;
        }
        length = this.aOL.read(this.aNW, 0, length);
        if (length > 0) {
            this.aLT = 0;
            this.aLU = length;
            return true;
        }
        AP();
        if (length != 0) {
            return false;
        }
        throw new IOException("InputStream.read() returned 0 characters when trying to read " + this.aNW.length + " bytes");
    }

    protected void AP() throws IOException {
        if (this.aOL != null) {
            if (this.aLS.Bz() || isEnabled(Feature.AUTO_CLOSE_SOURCE)) {
                this.aOL.close();
            }
            this.aOL = null;
        }
    }

    protected void AH() throws IOException {
        super.AH();
        this.aOI.release();
        if (this.aNX) {
            byte[] bArr = this.aNW;
            if (bArr != null) {
                this.aNW = agn.aPJ;
                this.aLS.m3145S(bArr);
            }
        }
    }

    public String getText() throws IOException {
        if (this.aMA != JsonToken.VALUE_STRING) {
            return m3262b(this.aMA);
        }
        if (!this.aOu) {
            return this.aMd.Da();
        }
        this.aOu = false;
        return Cw();
    }

    public String Au() throws IOException {
        if (this.aMA == JsonToken.VALUE_STRING) {
            if (!this.aOu) {
                return this.aMd.Da();
            }
            this.aOu = false;
            return Cw();
        } else if (this.aMA == JsonToken.FIELD_NAME) {
            return zW();
        } else {
            return super.aY(null);
        }
    }

    public String aY(String str) throws IOException {
        if (this.aMA == JsonToken.VALUE_STRING) {
            if (!this.aOu) {
                return this.aMd.Da();
            }
            this.aOu = false;
            return Cw();
        } else if (this.aMA == JsonToken.FIELD_NAME) {
            return zW();
        } else {
            return super.aY(str);
        }
    }

    public int As() throws IOException {
        JsonToken jsonToken = this.aMA;
        if (jsonToken != JsonToken.VALUE_NUMBER_INT && jsonToken != JsonToken.VALUE_NUMBER_FLOAT) {
            return super.fo(0);
        }
        if ((this.aMq & 1) == 0) {
            if (this.aMq == 0) {
                return AT();
            }
            if ((this.aMq & 1) == 0) {
                AU();
            }
        }
        return this.aMr;
    }

    public int fo(int i) throws IOException {
        JsonToken jsonToken = this.aMA;
        if (jsonToken != JsonToken.VALUE_NUMBER_INT && jsonToken != JsonToken.VALUE_NUMBER_FLOAT) {
            return super.fo(i);
        }
        if ((this.aMq & 1) == 0) {
            if (this.aMq == 0) {
                return AT();
            }
            if ((this.aMq & 1) == 0) {
                AU();
            }
        }
        return this.aMr;
    }

    protected final String m3262b(JsonToken jsonToken) {
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

    public char[] Ad() throws IOException {
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

    public int Ae() throws IOException {
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

    public int Af() throws IOException {
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
                this.aMh = m3263b(base64Variant);
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
                int a = m3259a(base64Variant, outputStream, BD);
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
    protected int m3259a(com.fasterxml.jackson.core.Base64Variant r12, java.io.OutputStream r13, byte[] r14) throws java.io.IOException {
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
        r3 = r11.aNW;
        r4 = r11.aLT;
        r6 = r4 + 1;
        r11.aLT = r6;
        r3 = r3[r4];
        r4 = r3 & 255;
        r3 = 32;
        if (r4 <= r3) goto L_0x000a;
    L_0x0023:
        r3 = r12.decodeBase64Char(r4);
        if (r3 >= 0) goto L_0x003a;
    L_0x0029:
        if (r4 != r9) goto L_0x0034;
    L_0x002b:
        r11.aOu = r1;
        if (r2 <= 0) goto L_0x0033;
    L_0x002f:
        r0 = r0 + r2;
        r13.write(r14, r1, r2);
    L_0x0033:
        return r0;
    L_0x0034:
        r3 = r11.m3116a(r12, r4, r1);
        if (r3 < 0) goto L_0x000a;
    L_0x003a:
        r4 = r3;
        if (r2 <= r5) goto L_0x0145;
    L_0x003d:
        r0 = r0 + r2;
        r13.write(r14, r1, r2);
        r3 = r1;
    L_0x0042:
        r2 = r11.aLT;
        r6 = r11.aLU;
        if (r2 < r6) goto L_0x004b;
    L_0x0048:
        r11.AM();
    L_0x004b:
        r2 = r11.aNW;
        r6 = r11.aLT;
        r7 = r6 + 1;
        r11.aLT = r7;
        r2 = r2[r6];
        r6 = r2 & 255;
        r2 = r12.decodeBase64Char(r6);
        if (r2 >= 0) goto L_0x0062;
    L_0x005d:
        r2 = 1;
        r2 = r11.m3116a(r12, r6, r2);
    L_0x0062:
        r4 = r4 << 6;
        r4 = r4 | r2;
        r2 = r11.aLT;
        r6 = r11.aLU;
        if (r2 < r6) goto L_0x006e;
    L_0x006b:
        r11.AM();
    L_0x006e:
        r2 = r11.aNW;
        r6 = r11.aLT;
        r7 = r6 + 1;
        r11.aLT = r7;
        r2 = r2[r6];
        r6 = r2 & 255;
        r2 = r12.decodeBase64Char(r6);
        if (r2 >= 0) goto L_0x00df;
    L_0x0080:
        if (r2 == r8) goto L_0x0097;
    L_0x0082:
        if (r6 != r9) goto L_0x0092;
    L_0x0084:
        r2 = r12.usesPadding();
        if (r2 != 0) goto L_0x0092;
    L_0x008a:
        r4 = r4 >> 4;
        r2 = r3 + 1;
        r4 = (byte) r4;
        r14[r3] = r4;
        goto L_0x002b;
    L_0x0092:
        r2 = 2;
        r2 = r11.m3116a(r12, r6, r2);
    L_0x0097:
        if (r2 != r8) goto L_0x00df;
    L_0x0099:
        r2 = r11.aLT;
        r6 = r11.aLU;
        if (r2 < r6) goto L_0x00a2;
    L_0x009f:
        r11.AM();
    L_0x00a2:
        r2 = r11.aNW;
        r6 = r11.aLT;
        r7 = r6 + 1;
        r11.aLT = r7;
        r2 = r2[r6];
        r2 = r2 & 255;
        r6 = r12.usesPaddingChar(r2);
        if (r6 != 0) goto L_0x00d6;
    L_0x00b4:
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
    L_0x00d6:
        r4 = r4 >> 4;
        r2 = r3 + 1;
        r4 = (byte) r4;
        r14[r3] = r4;
        goto L_0x000a;
    L_0x00df:
        r4 = r4 << 6;
        r4 = r4 | r2;
        r2 = r11.aLT;
        r6 = r11.aLU;
        if (r2 < r6) goto L_0x00eb;
    L_0x00e8:
        r11.AM();
    L_0x00eb:
        r2 = r11.aNW;
        r6 = r11.aLT;
        r7 = r6 + 1;
        r11.aLT = r7;
        r2 = r2[r6];
        r6 = r2 & 255;
        r2 = r12.decodeBase64Char(r6);
        if (r2 >= 0) goto L_0x012d;
    L_0x00fd:
        if (r2 == r8) goto L_0x011b;
    L_0x00ff:
        if (r6 != r9) goto L_0x0117;
    L_0x0101:
        r2 = r12.usesPadding();
        if (r2 != 0) goto L_0x0117;
    L_0x0107:
        r4 = r4 >> 2;
        r5 = r3 + 1;
        r2 = r4 >> 8;
        r2 = (byte) r2;
        r14[r3] = r2;
        r2 = r5 + 1;
        r3 = (byte) r4;
        r14[r5] = r3;
        goto L_0x002b;
    L_0x0117:
        r2 = r11.m3116a(r12, r6, r10);
    L_0x011b:
        if (r2 != r8) goto L_0x012d;
    L_0x011d:
        r4 = r4 >> 2;
        r6 = r3 + 1;
        r2 = r4 >> 8;
        r2 = (byte) r2;
        r14[r3] = r2;
        r2 = r6 + 1;
        r3 = (byte) r4;
        r14[r6] = r3;
        goto L_0x000a;
    L_0x012d:
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
    L_0x0145:
        r3 = r2;
        goto L_0x0042;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fossil.age.a(com.fasterxml.jackson.core.Base64Variant, java.io.OutputStream, byte[]):int");
    }

    public JsonLocation zY() {
        return new JsonLocation(this.aLS.Bx(), AJ(), -1, AK(), AL());
    }

    public JsonLocation zZ() {
        return new JsonLocation(this.aLS.Bx(), this.aLV + ((long) this.aLT), -1, this.aLW, (this.aLT - this.aLX) + 1);
    }

    public JsonToken zP() throws IOException {
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
                if (Cj != 44) {
                    m3112h(Cj, "was expecting comma to separate " + this.aMb.AD() + " entries");
                }
                Cj = Cx();
            }
            if (!this.aMb.AC()) {
                return fK(Cj);
            }
            this.aMb.bq(fR(Cj));
            this.aMA = JsonToken.FIELD_NAME;
            Cj = Ch();
            if (Cj == 34) {
                this.aOu = true;
                this.aMc = JsonToken.VALUE_STRING;
                return this.aMA;
            }
            switch (Cj) {
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
                    jsonToken = JsonToken.START_ARRAY;
                    break;
                case 102:
                    m3264j("false", 1);
                    jsonToken = JsonToken.VALUE_FALSE;
                    break;
                case 110:
                    m3264j("null", 1);
                    jsonToken = JsonToken.VALUE_NULL;
                    break;
                case 116:
                    m3264j(ServerProtocol.DIALOG_RETURN_SCOPES_TRUE, 1);
                    jsonToken = JsonToken.VALUE_TRUE;
                    break;
                case 123:
                    jsonToken = JsonToken.START_OBJECT;
                    break;
                default:
                    jsonToken = fT(Cj);
                    break;
            }
            this.aMc = jsonToken;
            return this.aMA;
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
                m3264j("false", 1);
                jsonToken = JsonToken.VALUE_FALSE;
                this.aMA = jsonToken;
                return jsonToken;
            case 110:
                m3264j("null", 1);
                jsonToken = JsonToken.VALUE_NULL;
                this.aMA = jsonToken;
                return jsonToken;
            case 116:
                m3264j(ServerProtocol.DIALOG_RETURN_SCOPES_TRUE, 1);
                jsonToken = JsonToken.VALUE_TRUE;
                this.aMA = jsonToken;
                return jsonToken;
            case 123:
                this.aMb = this.aMb.bt(this.aLZ, this.aMa);
                jsonToken = JsonToken.START_OBJECT;
                this.aMA = jsonToken;
                return jsonToken;
            default:
                jsonToken = fT(i);
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
                if (Cj != 44) {
                    m3112h(Cj, "was expecting comma to separate " + this.aMb.AD() + " entries");
                }
                Cj = Cx();
            }
            if (this.aMb.AC()) {
                String fR = fR(Cj);
                this.aMb.bq(fR);
                this.aMA = JsonToken.FIELD_NAME;
                Cj = Ch();
                if (Cj == 34) {
                    this.aOu = true;
                    this.aMc = JsonToken.VALUE_STRING;
                    return fR;
                }
                JsonToken BY;
                switch (Cj) {
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
                        BY = fL(Cj);
                        break;
                    case 91:
                        BY = JsonToken.START_ARRAY;
                        break;
                    case 102:
                        m3264j("false", 1);
                        BY = JsonToken.VALUE_FALSE;
                        break;
                    case 110:
                        m3264j("null", 1);
                        BY = JsonToken.VALUE_NULL;
                        break;
                    case 116:
                        m3264j(ServerProtocol.DIALOG_RETURN_SCOPES_TRUE, 1);
                        BY = JsonToken.VALUE_TRUE;
                        break;
                    case 123:
                        BY = JsonToken.START_OBJECT;
                        break;
                    default:
                        BY = fT(Cj);
                        break;
                }
                this.aMc = BY;
                return fR;
            }
            fK(Cj);
            return null;
        }
    }

    public String zS() throws IOException {
        if (this.aMA == JsonToken.FIELD_NAME) {
            this.aMf = false;
            JsonToken jsonToken = this.aMc;
            this.aMc = null;
            this.aMA = jsonToken;
            if (jsonToken == JsonToken.VALUE_STRING) {
                if (!this.aOu) {
                    return this.aMd.Da();
                }
                this.aOu = false;
                return Cw();
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

    protected JsonToken fL(int i) throws IOException {
        int i2;
        int i3 = 1;
        char[] Df = this.aMd.Df();
        if (i == 48) {
            i = Cu();
        }
        Df[0] = (char) i;
        int length = (this.aLT + Df.length) - 1;
        if (length > this.aLU) {
            length = this.aLU;
            i2 = 1;
        } else {
            i2 = 1;
        }
        while (this.aLT < length) {
            byte[] bArr = this.aNW;
            int i4 = this.aLT;
            this.aLT = i4 + 1;
            int i5 = bArr[i4] & 255;
            if (i5 >= 48 && i5 <= 57) {
                i4 = i2 + 1;
                i2 = i3 + 1;
                Df[i3] = (char) i5;
                i3 = i2;
                i2 = i4;
            } else if (i5 == 46 || i5 == 101 || i5 == 69) {
                return m3245a(Df, i3, i5, false, i2);
            } else {
                this.aLT--;
                this.aMd.gL(i3);
                if (this.aMb.AB()) {
                    fM(i5);
                }
                return m3124c(false, i2);
            }
        }
        return m3246a(Df, i3, false, i2);
    }

    protected JsonToken BY() throws IOException {
        char[] Df = this.aMd.Df();
        Df[0] = '-';
        if (this.aLT >= this.aLU) {
            AM();
        }
        byte[] bArr = this.aNW;
        int i = this.aLT;
        this.aLT = i + 1;
        int i2 = bArr[i] & 255;
        if (i2 < 48 || i2 > 57) {
            return m3265q(i2, true);
        }
        int i3;
        if (i2 == 48) {
            i2 = Cu();
        }
        i = 2;
        Df[1] = (char) i2;
        i2 = (this.aLT + Df.length) - 2;
        if (i2 > this.aLU) {
            i2 = this.aLU;
            i3 = 1;
        } else {
            i3 = 1;
        }
        while (this.aLT < i2) {
            byte[] bArr2 = this.aNW;
            int i4 = this.aLT;
            this.aLT = i4 + 1;
            int i5 = bArr2[i4] & 255;
            if (i5 >= 48 && i5 <= 57) {
                i3++;
                i4 = i + 1;
                Df[i] = (char) i5;
                i = i4;
            } else if (i5 == 46 || i5 == 101 || i5 == 69) {
                return m3245a(Df, i, i5, true, i3);
            } else {
                this.aLT--;
                this.aMd.gL(i);
                if (this.aMb.AB()) {
                    fM(i5);
                }
                return m3124c(true, i3);
            }
        }
        return m3246a(Df, i, true, i3);
    }

    private final JsonToken m3246a(char[] cArr, int i, boolean z, int i2) throws IOException {
        int i3 = i2;
        int i4 = i;
        char[] cArr2 = cArr;
        while (true) {
            if (this.aLT < this.aLU || AN()) {
                int i5;
                byte[] bArr = this.aNW;
                i5 = this.aLT;
                this.aLT = i5 + 1;
                i5 = bArr[i5] & 255;
                if (i5 <= 57 && i5 >= 48) {
                    int i6;
                    if (i4 >= cArr2.length) {
                        cArr2 = this.aMd.Dh();
                        i6 = 0;
                    } else {
                        i6 = i4;
                    }
                    i4 = i6 + 1;
                    cArr2[i6] = (char) i5;
                    i3++;
                }
            } else {
                this.aMd.gL(i4);
                return m3124c(z, i3);
            }
        }
        if (i5 == 46 || i5 == 101 || i5 == 69) {
            return m3245a(cArr2, i4, i5, z, i3);
        }
        this.aLT--;
        this.aMd.gL(i4);
        if (this.aMb.AB()) {
            bArr = this.aNW;
            int i7 = this.aLT;
            this.aLT = i7 + 1;
            fM(bArr[i7] & 255);
        }
        return m3124c(z, i3);
    }

    private final int Cu() throws IOException {
        if (this.aLT >= this.aLU && !AN()) {
            return 48;
        }
        int i = this.aNW[this.aLT] & 255;
        if (i < 48 || i > 57) {
            return 48;
        }
        if (!isEnabled(Feature.ALLOW_NUMERIC_LEADING_ZEROS)) {
            bf("Leading zeroes not allowed");
        }
        this.aLT++;
        if (i != 48) {
            return i;
        }
        do {
            if (this.aLT >= this.aLU && !AN()) {
                return i;
            }
            i = this.aNW[this.aLT] & 255;
            if (i < 48 || i > 57) {
                return 48;
            }
            this.aLT++;
        } while (i == 48);
        return i;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final com.fasterxml.jackson.core.JsonToken m3245a(char[] r10, int r11, int r12, boolean r13, int r14) throws java.io.IOException {
        /*
        r9 = this;
        r0 = 0;
        r4 = 0;
        r1 = 46;
        if (r12 != r1) goto L_0x011b;
    L_0x0006:
        r1 = r11 + 1;
        r2 = (char) r12;
        r10[r11] = r2;
    L_0x000b:
        r2 = r9.aLT;
        r3 = r9.aLU;
        if (r2 < r3) goto L_0x00ca;
    L_0x0011:
        r2 = r9.AN();
        if (r2 != 0) goto L_0x00ca;
    L_0x0017:
        r4 = 1;
        r5 = r12;
    L_0x0019:
        if (r0 != 0) goto L_0x0020;
    L_0x001b:
        r2 = "Decimal point not followed by a digit";
        r9.m3125g(r5, r2);
    L_0x0020:
        r7 = r0;
        r0 = r1;
        r1 = r10;
    L_0x0023:
        r3 = 0;
        r2 = 101; // 0x65 float:1.42E-43 double:5.0E-322;
        if (r5 == r2) goto L_0x002c;
    L_0x0028:
        r2 = 69;
        if (r5 != r2) goto L_0x0110;
    L_0x002c:
        r2 = r1.length;
        if (r0 < r2) goto L_0x0036;
    L_0x002f:
        r0 = r9.aMd;
        r1 = r0.Dh();
        r0 = 0;
    L_0x0036:
        r2 = r0 + 1;
        r5 = (char) r5;
        r1[r0] = r5;
        r0 = r9.aLT;
        r5 = r9.aLU;
        if (r0 < r5) goto L_0x0044;
    L_0x0041:
        r9.AM();
    L_0x0044:
        r0 = r9.aNW;
        r5 = r9.aLT;
        r6 = r5 + 1;
        r9.aLT = r6;
        r0 = r0[r5];
        r5 = r0 & 255;
        r0 = 45;
        if (r5 == r0) goto L_0x0058;
    L_0x0054:
        r0 = 43;
        if (r5 != r0) goto L_0x010c;
    L_0x0058:
        r0 = r1.length;
        if (r2 < r0) goto L_0x0109;
    L_0x005b:
        r0 = r9.aMd;
        r1 = r0.Dh();
        r0 = 0;
    L_0x0062:
        r6 = r0 + 1;
        r2 = (char) r5;
        r1[r0] = r2;
        r0 = r9.aLT;
        r2 = r9.aLU;
        if (r0 < r2) goto L_0x0070;
    L_0x006d:
        r9.AM();
    L_0x0070:
        r0 = r9.aNW;
        r2 = r9.aLT;
        r5 = r2 + 1;
        r9.aLT = r5;
        r0 = r0[r2];
        r2 = r0 & 255;
        r0 = r6;
    L_0x007d:
        r5 = 57;
        if (r2 > r5) goto L_0x0104;
    L_0x0081:
        r5 = 48;
        if (r2 < r5) goto L_0x0104;
    L_0x0085:
        r3 = r3 + 1;
        r5 = r1.length;
        if (r0 < r5) goto L_0x0091;
    L_0x008a:
        r0 = r9.aMd;
        r1 = r0.Dh();
        r0 = 0;
    L_0x0091:
        r5 = r0 + 1;
        r6 = (char) r2;
        r1[r0] = r6;
        r0 = r9.aLT;
        r6 = r9.aLU;
        if (r0 < r6) goto L_0x00f5;
    L_0x009c:
        r0 = r9.AN();
        if (r0 != 0) goto L_0x00f5;
    L_0x00a2:
        r4 = 1;
        r0 = r3;
        r1 = r4;
        r3 = r5;
    L_0x00a6:
        if (r0 != 0) goto L_0x00ad;
    L_0x00a8:
        r4 = "Exponent indicator not followed by a digit";
        r9.m3125g(r2, r4);
    L_0x00ad:
        if (r1 != 0) goto L_0x00c0;
    L_0x00af:
        r1 = r9.aLT;
        r1 = r1 + -1;
        r9.aLT = r1;
        r1 = r9.aMb;
        r1 = r1.AB();
        if (r1 == 0) goto L_0x00c0;
    L_0x00bd:
        r9.fM(r2);
    L_0x00c0:
        r1 = r9.aMd;
        r1.gL(r3);
        r0 = r9.m3122b(r13, r14, r7, r0);
        return r0;
    L_0x00ca:
        r2 = r9.aNW;
        r3 = r9.aLT;
        r5 = r3 + 1;
        r9.aLT = r5;
        r2 = r2[r3];
        r12 = r2 & 255;
        r2 = 48;
        if (r12 < r2) goto L_0x0118;
    L_0x00da:
        r2 = 57;
        if (r12 <= r2) goto L_0x00e1;
    L_0x00de:
        r5 = r12;
        goto L_0x0019;
    L_0x00e1:
        r0 = r0 + 1;
        r2 = r10.length;
        if (r1 < r2) goto L_0x0116;
    L_0x00e6:
        r1 = r9.aMd;
        r10 = r1.Dh();
        r1 = 0;
        r2 = r1;
    L_0x00ee:
        r1 = r2 + 1;
        r3 = (char) r12;
        r10[r2] = r3;
        goto L_0x000b;
    L_0x00f5:
        r0 = r9.aNW;
        r2 = r9.aLT;
        r6 = r2 + 1;
        r9.aLT = r6;
        r0 = r0[r2];
        r2 = r0 & 255;
        r0 = r5;
        goto L_0x007d;
    L_0x0104:
        r1 = r4;
        r8 = r3;
        r3 = r0;
        r0 = r8;
        goto L_0x00a6;
    L_0x0109:
        r0 = r2;
        goto L_0x0062;
    L_0x010c:
        r0 = r2;
        r2 = r5;
        goto L_0x007d;
    L_0x0110:
        r1 = r4;
        r2 = r5;
        r8 = r3;
        r3 = r0;
        r0 = r8;
        goto L_0x00ad;
    L_0x0116:
        r2 = r1;
        goto L_0x00ee;
    L_0x0118:
        r5 = r12;
        goto L_0x0019;
    L_0x011b:
        r7 = r0;
        r5 = r12;
        r1 = r10;
        r0 = r11;
        goto L_0x0023;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fossil.age.a(char[], int, int, boolean, int):com.fasterxml.jackson.core.JsonToken");
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

    protected final String fR(int i) throws IOException {
        if (i != 34) {
            return fN(i);
        }
        if (this.aLT + 13 > this.aLU) {
            return Cv();
        }
        byte[] bArr = this.aNW;
        int[] iArr = aOp;
        int i2 = this.aLT;
        this.aLT = i2 + 1;
        i2 = bArr[i2] & 255;
        if (iArr[i2] == 0) {
            int i3 = this.aLT;
            this.aLT = i3 + 1;
            i3 = bArr[i3] & 255;
            if (iArr[i3] == 0) {
                i2 = (i2 << 8) | i3;
                i3 = this.aLT;
                this.aLT = i3 + 1;
                i3 = bArr[i3] & 255;
                if (iArr[i3] == 0) {
                    i2 = (i2 << 8) | i3;
                    i3 = this.aLT;
                    this.aLT = i3 + 1;
                    i3 = bArr[i3] & 255;
                    if (iArr[i3] == 0) {
                        i2 = (i2 << 8) | i3;
                        i3 = this.aLT;
                        this.aLT = i3 + 1;
                        int i4 = bArr[i3] & 255;
                        if (iArr[i4] == 0) {
                            this.aOK = i2;
                            return fS(i4);
                        } else if (i4 == 34) {
                            return by(i2, 4);
                        } else {
                            return m3256w(i2, i4, 4);
                        }
                    } else if (i3 == 34) {
                        return by(i2, 3);
                    } else {
                        return m3256w(i2, i3, 3);
                    }
                } else if (i3 == 34) {
                    return by(i2, 2);
                } else {
                    return m3256w(i2, i3, 2);
                }
            } else if (i3 == 34) {
                return by(i2, 1);
            } else {
                return m3256w(i2, i3, 1);
            }
        } else if (i2 == 34) {
            return "";
        } else {
            return m3256w(0, i2, 0);
        }
    }

    protected final String fS(int i) throws IOException {
        byte[] bArr = this.aNW;
        int[] iArr = aOp;
        int i2 = this.aLT;
        this.aLT = i2 + 1;
        i2 = bArr[i2] & 255;
        if (iArr[i2] == 0) {
            i2 |= i << 8;
            int i3 = this.aLT;
            this.aLT = i3 + 1;
            i3 = bArr[i3] & 255;
            if (iArr[i3] == 0) {
                i2 = (i2 << 8) | i3;
                i3 = this.aLT;
                this.aLT = i3 + 1;
                i3 = bArr[i3] & 255;
                if (iArr[i3] == 0) {
                    i2 = (i2 << 8) | i3;
                    i3 = this.aLT;
                    this.aLT = i3 + 1;
                    int i4 = bArr[i3] & 255;
                    if (iArr[i4] == 0) {
                        return bx(i4, i2);
                    }
                    if (i4 == 34) {
                        return m3257x(this.aOK, i2, 4);
                    }
                    return m3254q(this.aOK, i2, i4, 4);
                } else if (i3 == 34) {
                    return m3257x(this.aOK, i2, 3);
                } else {
                    return m3254q(this.aOK, i2, i3, 3);
                }
            } else if (i3 == 34) {
                return m3257x(this.aOK, i2, 2);
            } else {
                return m3254q(this.aOK, i2, i3, 2);
            }
        } else if (i2 == 34) {
            return m3257x(this.aOK, i, 1);
        } else {
            return m3254q(this.aOK, i, i2, 1);
        }
    }

    protected final String bx(int i, int i2) throws IOException {
        byte[] bArr = this.aNW;
        int[] iArr = aOp;
        int i3 = this.aLT;
        this.aLT = i3 + 1;
        int i4 = bArr[i3] & 255;
        if (iArr[i4] == 0) {
            int i5 = (i << 8) | i4;
            i3 = this.aLT;
            this.aLT = i3 + 1;
            i4 = bArr[i3] & 255;
            if (iArr[i4] == 0) {
                i5 = (i5 << 8) | i4;
                i3 = this.aLT;
                this.aLT = i3 + 1;
                i4 = bArr[i3] & 255;
                if (iArr[i4] == 0) {
                    i5 = (i5 << 8) | i4;
                    i3 = this.aLT;
                    this.aLT = i3 + 1;
                    i4 = bArr[i3] & 255;
                    if (iArr[i4] == 0) {
                        return m3267v(i4, i2, i5);
                    }
                    if (i4 == 34) {
                        return m3255r(this.aOK, i2, i5, 4);
                    }
                    return m3252i(this.aOK, i2, i5, i4, 4);
                } else if (i4 == 34) {
                    return m3255r(this.aOK, i2, i5, 3);
                } else {
                    return m3252i(this.aOK, i2, i5, i4, 3);
                }
            } else if (i4 == 34) {
                return m3255r(this.aOK, i2, i5, 2);
            } else {
                return m3252i(this.aOK, i2, i5, i4, 2);
            }
        } else if (i4 == 34) {
            return m3255r(this.aOK, i2, i, 1);
        } else {
            return m3252i(this.aOK, i2, i, i4, 1);
        }
    }

    protected final String m3267v(int i, int i2, int i3) throws IOException {
        this.aOJ[0] = this.aOK;
        this.aOJ[1] = i2;
        this.aOJ[2] = i3;
        byte[] bArr = this.aNW;
        int[] iArr = aOp;
        int i4 = 3;
        int i5 = i;
        while (this.aLT + 4 <= this.aLU) {
            int i6 = this.aLT;
            this.aLT = i6 + 1;
            int i7 = bArr[i6] & 255;
            if (iArr[i7] == 0) {
                i5 = (i5 << 8) | i7;
                i6 = this.aLT;
                this.aLT = i6 + 1;
                i7 = bArr[i6] & 255;
                if (iArr[i7] == 0) {
                    i5 = (i5 << 8) | i7;
                    i6 = this.aLT;
                    this.aLT = i6 + 1;
                    i7 = bArr[i6] & 255;
                    if (iArr[i7] == 0) {
                        i5 = (i5 << 8) | i7;
                        i6 = this.aLT;
                        this.aLT = i6 + 1;
                        i7 = bArr[i6] & 255;
                        if (iArr[i7] == 0) {
                            if (i4 >= this.aOJ.length) {
                                this.aOJ = m3249b(this.aOJ, i4);
                            }
                            i6 = i4 + 1;
                            this.aOJ[i4] = i5;
                            i4 = i6;
                            i5 = i7;
                        } else if (i7 == 34) {
                            return m3247a(this.aOJ, i4, i5, 4);
                        } else {
                            return m3260a(this.aOJ, i4, i5, i7, 4);
                        }
                    } else if (i7 == 34) {
                        return m3247a(this.aOJ, i4, i5, 3);
                    } else {
                        return m3260a(this.aOJ, i4, i5, i7, 3);
                    }
                } else if (i7 == 34) {
                    return m3247a(this.aOJ, i4, i5, 2);
                } else {
                    return m3260a(this.aOJ, i4, i5, i7, 2);
                }
            } else if (i7 == 34) {
                return m3247a(this.aOJ, i4, i5, 1);
            } else {
                return m3260a(this.aOJ, i4, i5, i7, 1);
            }
        }
        return m3260a(this.aOJ, i4, 0, i5, 0);
    }

    protected String Cv() throws IOException {
        if (this.aLT >= this.aLU && !AN()) {
            bg(": was expecting closing '\"' for name");
        }
        byte[] bArr = this.aNW;
        int i = this.aLT;
        this.aLT = i + 1;
        int i2 = bArr[i] & 255;
        if (i2 == 34) {
            return "";
        }
        return m3260a(this.aOJ, 0, 0, i2, 0);
    }

    private final String m3256w(int i, int i2, int i3) throws IOException {
        return m3260a(this.aOJ, 0, i, i2, i3);
    }

    private final String m3254q(int i, int i2, int i3, int i4) throws IOException {
        this.aOJ[0] = i;
        return m3260a(this.aOJ, 1, i2, i3, i4);
    }

    private final String m3252i(int i, int i2, int i3, int i4, int i5) throws IOException {
        this.aOJ[0] = i;
        this.aOJ[1] = i2;
        return m3260a(this.aOJ, 2, i3, i4, i5);
    }

    protected final String m3260a(int[] iArr, int i, int i2, int i3, int i4) throws IOException {
        int[] iArr2 = aOp;
        while (true) {
            int[] iArr3;
            int i5;
            int i6;
            int i7;
            byte[] bArr;
            if (iArr2[i3] != 0) {
                if (i3 == 34) {
                    break;
                }
                if (i3 != 92) {
                    m3113i(i3, "name");
                } else {
                    i3 = Bb();
                }
                if (i3 > 127) {
                    int i8;
                    int[] iArr4;
                    if (i4 >= 4) {
                        if (i >= iArr.length) {
                            iArr = m3249b(iArr, iArr.length);
                            this.aOJ = iArr;
                        }
                        i8 = i + 1;
                        iArr[i] = i2;
                        i4 = 0;
                        i2 = 0;
                        iArr3 = iArr;
                    } else {
                        i8 = i;
                        iArr3 = iArr;
                    }
                    if (i3 < 2048) {
                        i5 = ((i3 >> 6) | 192) | (i2 << 8);
                        iArr4 = iArr3;
                        i6 = i4 + 1;
                    } else {
                        int[] iArr5;
                        int i9;
                        i7 = ((i3 >> 12) | 224) | (i2 << 8);
                        i5 = i4 + 1;
                        if (i5 >= 4) {
                            if (i8 >= iArr3.length) {
                                iArr3 = m3249b(iArr3, iArr3.length);
                                this.aOJ = iArr3;
                            }
                            i5 = i8 + 1;
                            iArr3[i8] = i7;
                            i7 = i5;
                            iArr5 = iArr3;
                            i6 = 0;
                            i5 = 0;
                        } else {
                            i9 = i5;
                            i5 = i7;
                            i7 = i8;
                            iArr5 = iArr3;
                            i6 = i9;
                        }
                        i5 = (i5 << 8) | (((i3 >> 6) & 63) | Allocation.USAGE_SHARED);
                        i6++;
                        i9 = i7;
                        iArr4 = iArr5;
                        i8 = i9;
                    }
                    i2 = (i3 & 63) | Allocation.USAGE_SHARED;
                    i4 = i6;
                    i = i8;
                    iArr3 = iArr4;
                    i7 = i5;
                    if (i4 >= 4) {
                        i4++;
                        i2 |= i7 << 8;
                        iArr = iArr3;
                    } else {
                        if (i >= iArr3.length) {
                            iArr3 = m3249b(iArr3, iArr3.length);
                            this.aOJ = iArr3;
                        }
                        i5 = i + 1;
                        iArr3[i] = i7;
                        i4 = 1;
                        i = i5;
                        iArr = iArr3;
                    }
                    if (this.aLT >= this.aLU && !AN()) {
                        bg(" in field name");
                    }
                    bArr = this.aNW;
                    i5 = this.aLT;
                    this.aLT = i5 + 1;
                    i3 = bArr[i5] & 255;
                }
            }
            i7 = i2;
            iArr3 = iArr;
            i2 = i3;
            if (i4 >= 4) {
                if (i >= iArr3.length) {
                    iArr3 = m3249b(iArr3, iArr3.length);
                    this.aOJ = iArr3;
                }
                i5 = i + 1;
                iArr3[i] = i7;
                i4 = 1;
                i = i5;
                iArr = iArr3;
            } else {
                i4++;
                i2 |= i7 << 8;
                iArr = iArr3;
            }
            bg(" in field name");
            bArr = this.aNW;
            i5 = this.aLT;
            this.aLT = i5 + 1;
            i3 = bArr[i5] & 255;
        }
        if (i4 > 0) {
            if (i >= iArr.length) {
                iArr = m3249b(iArr, iArr.length);
                this.aOJ = iArr;
            }
            i6 = i + 1;
            iArr[i] = bA(i2, i4);
            i = i6;
        }
        String c = this.aOI.m3306c(iArr, i);
        if (c == null) {
            return m3250d(iArr, i, i4);
        }
        return c;
    }

    protected String fN(int i) throws IOException {
        if (i == 39 && isEnabled(Feature.ALLOW_SINGLE_QUOTES)) {
            return Cc();
        }
        int[] iArr;
        int i2;
        if (!isEnabled(Feature.ALLOW_UNQUOTED_FIELD_NAMES)) {
            m3112h((char) fU(i), "was expecting double-quote to start field name");
        }
        int[] Bs = afn.Bs();
        if (Bs[i] != 0) {
            m3112h(i, "was expecting either valid name character (for unquoted name) or double-quote (for quoted) to start field name");
        }
        int i3 = 0;
        int i4 = 0;
        int i5 = i;
        int i6 = 0;
        int[] iArr2 = this.aOJ;
        while (true) {
            if (i3 < 4) {
                int i7 = i3 + 1;
                i3 = i5 | (i4 << 8);
                i5 = i6;
                iArr = iArr2;
                i2 = i7;
            } else {
                if (i6 >= iArr2.length) {
                    iArr2 = m3249b(iArr2, iArr2.length);
                    this.aOJ = iArr2;
                }
                int i8 = i6 + 1;
                iArr2[i6] = i4;
                iArr = iArr2;
                i2 = 1;
                i3 = i5;
                i5 = i8;
            }
            if (this.aLT >= this.aLU && !AN()) {
                bg(" in field name");
            }
            i = this.aNW[this.aLT] & 255;
            if (Bs[i] != 0) {
                break;
            }
            this.aLT++;
            i4 = i3;
            i3 = i2;
            iArr2 = iArr;
            i6 = i5;
            i5 = i;
        }
        if (i2 > 0) {
            if (i5 >= iArr.length) {
                iArr = m3249b(iArr, iArr.length);
                this.aOJ = iArr;
            }
            i8 = i5 + 1;
            iArr[i5] = i3;
            i5 = i8;
        }
        String c = this.aOI.m3306c(iArr, i5);
        if (c == null) {
            return m3250d(iArr, i5, i2);
        }
        return c;
    }

    protected String Cc() throws IOException {
        if (this.aLT >= this.aLU && !AN()) {
            bg(": was expecting closing ''' for name");
        }
        byte[] bArr = this.aNW;
        int i = this.aLT;
        this.aLT = i + 1;
        int i2 = bArr[i] & 255;
        if (i2 == 39) {
            return "";
        }
        int i3;
        int[] iArr;
        int[] iArr2 = this.aOJ;
        int[] iArr3 = aOp;
        int i4 = 0;
        int i5 = 0;
        i = 0;
        while (i2 != 39) {
            int i6;
            int[] iArr4;
            int i7;
            byte[] bArr2;
            if (!(i2 == 34 || iArr3[i2] == 0)) {
                if (i2 != 92) {
                    m3113i(i2, "name");
                } else {
                    i2 = Bb();
                }
                if (i2 > 127) {
                    int[] iArr5;
                    if (i4 >= 4) {
                        if (i >= iArr2.length) {
                            iArr2 = m3249b(iArr2, iArr2.length);
                            this.aOJ = iArr2;
                        }
                        i4 = i + 1;
                        iArr2[i] = i5;
                        i = 0;
                        i5 = i4;
                        i4 = 0;
                    } else {
                        i6 = i4;
                        i4 = i5;
                        i5 = i;
                        i = i6;
                    }
                    if (i2 < 2048) {
                        i6 = i + 1;
                        i = (i4 << 8) | ((i2 >> 6) | 192);
                        iArr5 = iArr2;
                        i3 = i6;
                    } else {
                        i4 = (i4 << 8) | ((i2 >> 12) | 224);
                        i++;
                        if (i >= 4) {
                            if (i5 >= iArr2.length) {
                                iArr2 = m3249b(iArr2, iArr2.length);
                                this.aOJ = iArr2;
                            }
                            i = i5 + 1;
                            iArr2[i5] = i4;
                            i4 = i;
                            iArr4 = iArr2;
                            i3 = 0;
                            i = 0;
                        } else {
                            i6 = i;
                            i = i4;
                            i4 = i5;
                            iArr4 = iArr2;
                            i3 = i6;
                        }
                        i = (i << 8) | (((i2 >> 6) & 63) | Allocation.USAGE_SHARED);
                        i3++;
                        i6 = i4;
                        iArr5 = iArr4;
                        i5 = i6;
                    }
                    i7 = i;
                    i = i3;
                    iArr2 = iArr5;
                    i4 = (i2 & 63) | Allocation.USAGE_SHARED;
                    if (i >= 4) {
                        i6 = i + 1;
                        i = i4 | (i7 << 8);
                        i4 = i5;
                        iArr4 = iArr2;
                        i3 = i6;
                    } else {
                        if (i5 >= iArr2.length) {
                            iArr2 = m3249b(iArr2, iArr2.length);
                            this.aOJ = iArr2;
                        }
                        i2 = i5 + 1;
                        iArr2[i5] = i7;
                        iArr4 = iArr2;
                        i3 = 1;
                        i = i4;
                        i4 = i2;
                    }
                    if (this.aLT >= this.aLU && !AN()) {
                        bg(" in field name");
                    }
                    bArr2 = this.aNW;
                    i7 = this.aLT;
                    this.aLT = i7 + 1;
                    i2 = bArr2[i7] & 255;
                    i6 = i3;
                    iArr2 = iArr4;
                    i5 = i;
                    i = i4;
                    i4 = i6;
                }
            }
            i7 = i5;
            i5 = i;
            i = i4;
            i4 = i2;
            if (i >= 4) {
                if (i5 >= iArr2.length) {
                    iArr2 = m3249b(iArr2, iArr2.length);
                    this.aOJ = iArr2;
                }
                i2 = i5 + 1;
                iArr2[i5] = i7;
                iArr4 = iArr2;
                i3 = 1;
                i = i4;
                i4 = i2;
            } else {
                i6 = i + 1;
                i = i4 | (i7 << 8);
                i4 = i5;
                iArr4 = iArr2;
                i3 = i6;
            }
            bg(" in field name");
            bArr2 = this.aNW;
            i7 = this.aLT;
            this.aLT = i7 + 1;
            i2 = bArr2[i7] & 255;
            i6 = i3;
            iArr2 = iArr4;
            i5 = i;
            i = i4;
            i4 = i6;
        }
        if (i4 > 0) {
            if (i >= iArr2.length) {
                iArr2 = m3249b(iArr2, iArr2.length);
                this.aOJ = iArr2;
            }
            int i8 = i + 1;
            iArr2[i] = bA(i5, i4);
            i6 = i8;
            iArr = iArr2;
            i3 = i6;
        } else {
            iArr = iArr2;
            i3 = i;
        }
        String c = this.aOI.m3306c(iArr, i3);
        if (c == null) {
            return m3250d(iArr, i3, i4);
        }
        return c;
    }

    private final String by(int i, int i2) throws JsonParseException {
        int bA = bA(i, i2);
        String gl = this.aOI.gl(bA);
        if (gl != null) {
            return gl;
        }
        this.aOJ[0] = bA;
        return m3250d(this.aOJ, 1, i2);
    }

    private final String m3257x(int i, int i2, int i3) throws JsonParseException {
        int bA = bA(i2, i3);
        String by = this.aOI.by(i, bA);
        if (by != null) {
            return by;
        }
        this.aOJ[0] = i;
        this.aOJ[1] = bA;
        return m3250d(this.aOJ, 2, i3);
    }

    private final String m3255r(int i, int i2, int i3, int i4) throws JsonParseException {
        int bA = bA(i3, i4);
        String x = this.aOI.m3308x(i, i2, bA);
        if (x != null) {
            return x;
        }
        int[] iArr = this.aOJ;
        iArr[0] = i;
        iArr[1] = i2;
        iArr[2] = bA(bA, i4);
        return m3250d(iArr, 3, i4);
    }

    private final String m3247a(int[] iArr, int i, int i2, int i3) throws JsonParseException {
        if (i >= iArr.length) {
            iArr = m3249b(iArr, iArr.length);
            this.aOJ = iArr;
        }
        int i4 = i + 1;
        iArr[i] = bA(i2, i3);
        String c = this.aOI.m3306c(iArr, i4);
        if (c == null) {
            return m3250d(iArr, i4, i3);
        }
        return c;
    }

    private final String m3250d(int[] iArr, int i, int i2) throws JsonParseException {
        int i3;
        int i4 = ((i << 2) - 4) + i2;
        if (i2 < 4) {
            i3 = iArr[i - 1];
            iArr[i - 1] = i3 << ((4 - i2) << 3);
        } else {
            i3 = 0;
        }
        char[] Df = this.aMd.Df();
        int i5 = 0;
        int i6 = 0;
        while (i6 < i4) {
            char[] cArr;
            int i7;
            int i8 = (iArr[i6 >> 2] >> ((3 - (i6 & 3)) << 3)) & 255;
            i6++;
            if (i8 > 127) {
                int i9;
                if ((i8 & 224) == 192) {
                    i8 &= 31;
                    i9 = 1;
                } else if ((i8 & 240) == 224) {
                    i8 &= 15;
                    i9 = 2;
                } else if ((i8 & 248) == 240) {
                    i8 &= 7;
                    i9 = 3;
                } else {
                    gd(i8);
                    i8 = 1;
                    i9 = 1;
                }
                if (i6 + i9 > i4) {
                    bg(" in field name");
                }
                int i10 = iArr[i6 >> 2] >> ((3 - (i6 & 3)) << 3);
                i6++;
                if ((i10 & 192) != Allocation.USAGE_SHARED) {
                    ge(i10);
                }
                i8 = (i8 << 6) | (i10 & 63);
                if (i9 > 1) {
                    i10 = iArr[i6 >> 2] >> ((3 - (i6 & 3)) << 3);
                    i6++;
                    if ((i10 & 192) != Allocation.USAGE_SHARED) {
                        ge(i10);
                    }
                    i8 = (i8 << 6) | (i10 & 63);
                    if (i9 > 2) {
                        i10 = iArr[i6 >> 2] >> ((3 - (i6 & 3)) << 3);
                        i6++;
                        if ((i10 & 192) != Allocation.USAGE_SHARED) {
                            ge(i10 & 255);
                        }
                        i8 = (i8 << 6) | (i10 & 63);
                    }
                }
                if (i9 > 2) {
                    i8 -= NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST;
                    if (i5 >= Df.length) {
                        Df = this.aMd.Di();
                    }
                    i9 = i5 + 1;
                    Df[i5] = (char) (55296 + (i8 >> 10));
                    int i11 = (i8 & 1023) | 56320;
                    i8 = i6;
                    i6 = i9;
                    cArr = Df;
                    i7 = i11;
                    if (i6 >= cArr.length) {
                        cArr = this.aMd.Di();
                    }
                    i5 = i6 + 1;
                    cArr[i6] = (char) i7;
                    i6 = i8;
                    Df = cArr;
                }
            }
            cArr = Df;
            i7 = i8;
            i8 = i6;
            i6 = i5;
            if (i6 >= cArr.length) {
                cArr = this.aMd.Di();
            }
            i5 = i6 + 1;
            cArr[i6] = (char) i7;
            i6 = i8;
            Df = cArr;
        }
        String str = new String(Df, 0, i5);
        if (i2 < 4) {
            iArr[i - 1] = i3;
        }
        return this.aOI.m3305a(str, iArr, i);
    }

    protected void AO() throws IOException {
        int i = this.aLT;
        if (i >= this.aLU) {
            AM();
            i = this.aLT;
        }
        char[] Df = this.aMd.Df();
        int[] iArr = aOH;
        int min = Math.min(this.aLU, Df.length + i);
        byte[] bArr = this.aNW;
        int i2 = i;
        i = 0;
        while (i2 < min) {
            int i3 = bArr[i2] & 255;
            if (iArr[i3] != 0) {
                if (i3 == 34) {
                    this.aLT = i2 + 1;
                    this.aMd.gL(i);
                    return;
                }
                this.aLT = i2;
                m3248a(Df, i);
            }
            int i4 = i2 + 1;
            i2 = i + 1;
            Df[i] = (char) i3;
            i = i2;
            i2 = i4;
        }
        this.aLT = i2;
        m3248a(Df, i);
    }

    protected String Cw() throws IOException {
        int i = this.aLT;
        if (i >= this.aLU) {
            AM();
            i = this.aLT;
        }
        char[] Df = this.aMd.Df();
        int[] iArr = aOH;
        int min = Math.min(this.aLU, Df.length + i);
        byte[] bArr = this.aNW;
        int i2 = i;
        i = 0;
        while (i2 < min) {
            int i3 = bArr[i2] & 255;
            if (iArr[i3] != 0) {
                if (i3 == 34) {
                    this.aLT = i2 + 1;
                    return this.aMd.gM(i);
                }
                this.aLT = i2;
                m3248a(Df, i);
                return this.aMd.Da();
            }
            int i4 = i2 + 1;
            i2 = i + 1;
            Df[i] = (char) i3;
            i = i2;
            i2 = i4;
        }
        this.aLT = i2;
        m3248a(Df, i);
        return this.aMd.Da();
    }

    private final void m3248a(char[] cArr, int i) throws IOException {
        int[] iArr = aOH;
        byte[] bArr = this.aNW;
        while (true) {
            int i2 = this.aLT;
            if (i2 >= this.aLU) {
                AM();
                i2 = this.aLT;
            }
            if (i >= cArr.length) {
                cArr = this.aMd.Dh();
                i = 0;
            }
            int min = Math.min(this.aLU, (cArr.length - i) + i2);
            while (i2 < min) {
                int i3 = i2 + 1;
                i2 = bArr[i2] & 255;
                if (iArr[i2] != 0) {
                    this.aLT = i3;
                    if (i2 == 34) {
                        this.aMd.gL(i);
                        return;
                    }
                    switch (iArr[i2]) {
                        case 1:
                            i2 = Bb();
                            break;
                        case 2:
                            i2 = fV(i2);
                            break;
                        case 3:
                            if (this.aLU - this.aLT < 2) {
                                i2 = fW(i2);
                                break;
                            } else {
                                i2 = fX(i2);
                                break;
                            }
                        case 4:
                            i3 = fY(i2);
                            i2 = i + 1;
                            cArr[i] = (char) (55296 | (i3 >> 10));
                            if (i2 >= cArr.length) {
                                cArr = this.aMd.Dh();
                                i2 = 0;
                            }
                            i = i2;
                            i2 = (i3 & 1023) | 56320;
                            break;
                        default:
                            if (i2 >= 32) {
                                gc(i2);
                                break;
                            } else {
                                m3113i(i2, "string value");
                                break;
                            }
                    }
                    if (i >= cArr.length) {
                        cArr = this.aMd.Dh();
                        i3 = 0;
                    } else {
                        i3 = i;
                    }
                    i = i3 + 1;
                    cArr[i3] = (char) i2;
                } else {
                    int i4 = i + 1;
                    cArr[i] = (char) i2;
                    i2 = i3;
                    i = i4;
                }
            }
            this.aLT = i2;
        }
    }

    protected void Cf() throws IOException {
        this.aOu = false;
        int[] iArr = aOH;
        byte[] bArr = this.aNW;
        while (true) {
            int i = this.aLT;
            int i2 = this.aLU;
            if (i >= i2) {
                AM();
                i = this.aLT;
                i2 = this.aLU;
            }
            while (i < i2) {
                int i3 = i + 1;
                i = bArr[i] & 255;
                if (iArr[i] != 0) {
                    this.aLT = i3;
                    if (i != 34) {
                        switch (iArr[i]) {
                            case 1:
                                Bb();
                                break;
                            case 2:
                                fZ(i);
                                break;
                            case 3:
                                ga(i);
                                break;
                            case 4:
                                gb(i);
                                break;
                            default:
                                if (i >= 32) {
                                    gc(i);
                                    break;
                                } else {
                                    m3113i(i, "string value");
                                    break;
                                }
                        }
                    }
                    return;
                }
                i = i3;
            }
            this.aLT = i;
        }
    }

    protected JsonToken fT(int i) throws IOException {
        switch (i) {
            case 39:
                break;
            case 43:
                if (this.aLT >= this.aLU && !AN()) {
                    Bd();
                }
                byte[] bArr = this.aNW;
                int i2 = this.aLT;
                this.aLT = i2 + 1;
                return m3265q(bArr[i2] & 255, false);
            case 73:
                m3264j("Infinity", 1);
                if (!isEnabled(Feature.ALLOW_NON_NUMERIC_NUMBERS)) {
                    aX("Non-standard token 'Infinity': enable JsonParser.Feature.ALLOW_NON_NUMERIC_NUMBERS to allow");
                    break;
                }
                return m3118a("Infinity", Double.POSITIVE_INFINITY);
            case 78:
                m3264j("NaN", 1);
                if (!isEnabled(Feature.ALLOW_NON_NUMERIC_NUMBERS)) {
                    aX("Non-standard token 'NaN': enable JsonParser.Feature.ALLOW_NON_NUMERIC_NUMBERS to allow");
                    break;
                }
                return m3118a("NaN", Double.NaN);
            case 93:
            case 125:
                m3112h(i, "expected a value");
                break;
        }
        if (isEnabled(Feature.ALLOW_SINGLE_QUOTES)) {
            return Cd();
        }
        if (Character.isJavaIdentifierStart(i)) {
            m3266s("" + ((char) i), "('true', 'false' or 'null')");
        }
        m3112h(i, "expected a valid value (number, String, array, object, 'true', 'false' or 'null')");
        return null;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    protected com.fasterxml.jackson.core.JsonToken Cd() throws java.io.IOException {
        /*
        r10 = this;
        r9 = 39;
        r2 = 0;
        r0 = r10.aMd;
        r0 = r0.Df();
        r6 = aOH;
        r7 = r10.aNW;
        r1 = r2;
    L_0x000e:
        r3 = r10.aLT;
        r4 = r10.aLU;
        if (r3 < r4) goto L_0x0017;
    L_0x0014:
        r10.AM();
    L_0x0017:
        r3 = r0.length;
        if (r1 < r3) goto L_0x0021;
    L_0x001a:
        r0 = r10.aMd;
        r0 = r0.Dh();
        r1 = r2;
    L_0x0021:
        r4 = r10.aLU;
        r3 = r10.aLT;
        r5 = r0.length;
        r5 = r5 - r1;
        r3 = r3 + r5;
        if (r3 >= r4) goto L_0x00b3;
    L_0x002a:
        r4 = r10.aLT;
        if (r4 >= r3) goto L_0x000e;
    L_0x002e:
        r4 = r10.aLT;
        r5 = r4 + 1;
        r10.aLT = r5;
        r4 = r7[r4];
        r5 = r4 & 255;
        if (r5 == r9) goto L_0x003e;
    L_0x003a:
        r4 = r6[r5];
        if (r4 == 0) goto L_0x0048;
    L_0x003e:
        if (r5 != r9) goto L_0x004f;
    L_0x0040:
        r0 = r10.aMd;
        r0.gL(r1);
        r0 = com.fasterxml.jackson.core.JsonToken.VALUE_STRING;
        return r0;
    L_0x0048:
        r4 = r1 + 1;
        r5 = (char) r5;
        r0[r1] = r5;
        r1 = r4;
        goto L_0x002a;
    L_0x004f:
        r3 = r6[r5];
        switch(r3) {
            case 1: goto L_0x0071;
            case 2: goto L_0x0078;
            case 3: goto L_0x007d;
            case 4: goto L_0x008f;
            default: goto L_0x0054;
        };
    L_0x0054:
        r3 = 32;
        if (r5 >= r3) goto L_0x005d;
    L_0x0058:
        r3 = "string value";
        r10.m3113i(r5, r3);
    L_0x005d:
        r10.gc(r5);
    L_0x0060:
        r3 = r5;
    L_0x0061:
        r4 = r0.length;
        if (r1 < r4) goto L_0x00af;
    L_0x0064:
        r0 = r10.aMd;
        r0 = r0.Dh();
        r4 = r2;
    L_0x006b:
        r1 = r4 + 1;
        r3 = (char) r3;
        r0[r4] = r3;
        goto L_0x000e;
    L_0x0071:
        if (r5 == r9) goto L_0x0060;
    L_0x0073:
        r3 = r10.Bb();
        goto L_0x0061;
    L_0x0078:
        r3 = r10.fV(r5);
        goto L_0x0061;
    L_0x007d:
        r3 = r10.aLU;
        r4 = r10.aLT;
        r3 = r3 - r4;
        r4 = 2;
        if (r3 < r4) goto L_0x008a;
    L_0x0085:
        r3 = r10.fX(r5);
        goto L_0x0061;
    L_0x008a:
        r3 = r10.fW(r5);
        goto L_0x0061;
    L_0x008f:
        r4 = r10.fY(r5);
        r3 = r1 + 1;
        r5 = 55296; // 0xd800 float:7.7486E-41 double:2.732E-319;
        r8 = r4 >> 10;
        r5 = r5 | r8;
        r5 = (char) r5;
        r0[r1] = r5;
        r1 = r0.length;
        if (r3 < r1) goto L_0x00b1;
    L_0x00a1:
        r0 = r10.aMd;
        r0 = r0.Dh();
        r1 = r2;
    L_0x00a8:
        r3 = 56320; // 0xdc00 float:7.8921E-41 double:2.7826E-319;
        r4 = r4 & 1023;
        r3 = r3 | r4;
        goto L_0x0061;
    L_0x00af:
        r4 = r1;
        goto L_0x006b;
    L_0x00b1:
        r1 = r3;
        goto L_0x00a8;
    L_0x00b3:
        r3 = r4;
        goto L_0x002a;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fossil.age.Cd():com.fasterxml.jackson.core.JsonToken");
    }

    protected JsonToken m3265q(int i, boolean z) throws IOException {
        int i2 = i;
        while (i2 == 73) {
            String str;
            if (this.aLT >= this.aLU && !AN()) {
                Bd();
            }
            byte[] bArr = this.aNW;
            int i3 = this.aLT;
            this.aLT = i3 + 1;
            byte b = bArr[i3];
            if (b != (byte) 78) {
                if (b != (byte) 110) {
                    i2 = b;
                    break;
                }
                str = z ? "-Infinity" : "+Infinity";
            } else {
                str = z ? "-INF" : "+INF";
            }
            m3264j(str, 3);
            if (isEnabled(Feature.ALLOW_NON_NUMERIC_NUMBERS)) {
                return m3118a(str, z ? Double.NEGATIVE_INFINITY : Double.POSITIVE_INFINITY);
            }
            aX("Non-standard token '" + str + "': enable JsonParser.Feature.ALLOW_NON_NUMERIC_NUMBERS to allow");
            byte b2 = b;
        }
        m3125g(i2, "expected digit (0-9) to follow minus sign, for valid numeric value");
        return null;
    }

    protected final void m3264j(String str, int i) throws IOException {
        int length = str.length();
        if (this.aLT + length >= this.aLU) {
            m3253l(str, i);
            return;
        }
        do {
            if (this.aNW[this.aLT] != str.charAt(i)) {
                bt(str.substring(0, i));
            }
            this.aLT++;
            i++;
        } while (i < length);
        length = this.aNW[this.aLT] & 255;
        if (length >= 48 && length != 93 && length != 125) {
            m3251h(str, i, length);
        }
    }

    private final void m3253l(String str, int i) throws IOException {
        int length = str.length();
        do {
            if ((this.aLT >= this.aLU && !AN()) || this.aNW[this.aLT] != str.charAt(i)) {
                bt(str.substring(0, i));
            }
            this.aLT++;
            i++;
        } while (i < length);
        if (this.aLT < this.aLU || AN()) {
            length = this.aNW[this.aLT] & 255;
            if (length >= 48 && length != 93 && length != 125) {
                m3251h(str, i, length);
            }
        }
    }

    private final void m3251h(String str, int i, int i2) throws IOException {
        if (Character.isJavaIdentifierPart((char) fU(i2))) {
            bt(str.substring(0, i));
        }
    }

    private final int Cx() throws IOException {
        while (this.aLT < this.aLU) {
            byte[] bArr = this.aNW;
            int i = this.aLT;
            this.aLT = i + 1;
            int i2 = bArr[i] & 255;
            if (i2 > 32) {
                if (i2 != 47 && i2 != 35) {
                    return i2;
                }
                this.aLT--;
                return Cy();
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
        return Cy();
    }

    private final int Cy() throws IOException {
        int i;
        while (true) {
            if (this.aLT < this.aLU || AN()) {
                byte[] bArr = this.aNW;
                int i2 = this.aLT;
                this.aLT = i2 + 1;
                i = bArr[i2] & 255;
                if (i > 32) {
                    if (i == 47) {
                        Cl();
                    } else if (i != 35 || !Cn()) {
                        return i;
                    }
                } else if (i != 32) {
                    if (i == 10) {
                        this.aLW++;
                        this.aLX = this.aLT;
                    } else if (i == 13) {
                        Cg();
                    } else if (i != 9) {
                        ft(i);
                    }
                }
            } else {
                throw aZ("Unexpected end-of-input within/between " + this.aMb.AD() + " entries");
            }
        }
        return i;
    }

    private final int Cj() throws IOException {
        if (this.aLT >= this.aLU && !AN()) {
            return AR();
        }
        byte[] bArr = this.aNW;
        int i = this.aLT;
        this.aLT = i + 1;
        int i2 = bArr[i] & 255;
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
                bArr = this.aNW;
                i = this.aLT;
                this.aLT = i + 1;
                i2 = bArr[i] & 255;
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

    private final int Ck() throws IOException {
        while (true) {
            if (this.aLT >= this.aLU && !AN()) {
                return AR();
            }
            byte[] bArr = this.aNW;
            int i = this.aLT;
            this.aLT = i + 1;
            int i2 = bArr[i] & 255;
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

    private final int Ch() throws IOException {
        if (this.aLT + 4 >= this.aLU) {
            return aG(false);
        }
        byte b = this.aNW[this.aLT];
        byte[] bArr;
        int i;
        int i2;
        if (b == (byte) 58) {
            bArr = this.aNW;
            i = this.aLT + 1;
            this.aLT = i;
            i2 = bArr[i];
            if (i2 <= 32) {
                if (i2 == 32 || i2 == 9) {
                    bArr = this.aNW;
                    i = this.aLT + 1;
                    this.aLT = i;
                    i2 = bArr[i];
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
        if (b == (byte) 32 || b == (byte) 9) {
            bArr = this.aNW;
            i = this.aLT + 1;
            this.aLT = i;
            b = bArr[i];
        }
        if (b != (byte) 58) {
            return aG(false);
        }
        bArr = this.aNW;
        i = this.aLT + 1;
        this.aLT = i;
        i2 = bArr[i];
        if (i2 <= 32) {
            if (i2 == 32 || i2 == 9) {
                bArr = this.aNW;
                i = this.aLT + 1;
                this.aLT = i;
                i2 = bArr[i];
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
            if (this.aLT < this.aLU || AN()) {
                byte[] bArr = this.aNW;
                int i = this.aLT;
                this.aLT = i + 1;
                int i2 = bArr[i] & 255;
                if (i2 > 32) {
                    if (i2 == 47) {
                        Cl();
                    } else if (i2 != 35 || !Cn()) {
                        if (z) {
                            return i2;
                        }
                        if (i2 != 58) {
                            if (i2 < 32) {
                                ft(i2);
                            }
                            m3112h(i2, "was expecting a colon to separate field name and value");
                        }
                        z = true;
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
            } else {
                throw aZ("Unexpected end-of-input within/between " + this.aMb.AD() + " entries");
            }
        }
    }

    private final void Cl() throws IOException {
        if (!isEnabled(Feature.ALLOW_COMMENTS)) {
            m3112h(47, "maybe a (non-standard) comment? (not recognized as one since Feature 'ALLOW_COMMENTS' not enabled for parser)");
        }
        if (this.aLT >= this.aLU && !AN()) {
            bg(" in a comment");
        }
        byte[] bArr = this.aNW;
        int i = this.aLT;
        this.aLT = i + 1;
        int i2 = bArr[i] & 255;
        if (i2 == 47) {
            Co();
        } else if (i2 == 42) {
            Cm();
        } else {
            m3112h(i2, "was expecting either '*' or '/' for a comment");
        }
    }

    private final void Cm() throws IOException {
        int[] Bt = afn.Bt();
        while (true) {
            if (this.aLT < this.aLU || AN()) {
                byte[] bArr = this.aNW;
                int i = this.aLT;
                this.aLT = i + 1;
                int i2 = bArr[i] & 255;
                i = Bt[i2];
                if (i != 0) {
                    switch (i) {
                        case 2:
                            fZ(i2);
                            continue;
                        case 3:
                            ga(i2);
                            continue;
                        case 4:
                            gb(i2);
                            continue;
                        case 10:
                            this.aLW++;
                            this.aLX = this.aLT;
                            continue;
                        case 13:
                            Cg();
                            continue;
                        case 42:
                            if (this.aLT >= this.aLU && !AN()) {
                                break;
                            } else if (this.aNW[this.aLT] == (byte) 47) {
                                this.aLT++;
                                return;
                            } else {
                                continue;
                            }
                        default:
                            gc(i2);
                            continue;
                    }
                }
            }
            bg(" in a comment");
            return;
        }
    }

    private final boolean Cn() throws IOException {
        if (!isEnabled(Feature.ALLOW_YAML_COMMENTS)) {
            return false;
        }
        Co();
        return true;
    }

    private final void Co() throws IOException {
        int[] Bt = afn.Bt();
        while (true) {
            if (this.aLT < this.aLU || AN()) {
                byte[] bArr = this.aNW;
                int i = this.aLT;
                this.aLT = i + 1;
                int i2 = bArr[i] & 255;
                i = Bt[i2];
                if (i != 0) {
                    switch (i) {
                        case 2:
                            fZ(i2);
                            break;
                        case 3:
                            ga(i2);
                            break;
                        case 4:
                            gb(i2);
                            break;
                        case 10:
                            this.aLW++;
                            this.aLX = this.aLT;
                            return;
                        case 13:
                            Cg();
                            return;
                        case 42:
                            break;
                        default:
                            if (i >= 0) {
                                break;
                            }
                            gc(i2);
                            break;
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
        byte[] bArr = this.aNW;
        int i2 = this.aLT;
        this.aLT = i2 + 1;
        byte b = bArr[i2];
        switch (b) {
            case (byte) 34:
            case (byte) 47:
            case (byte) 92:
                return (char) b;
            case (byte) 98:
                return '\b';
            case (byte) 102:
                return '\f';
            case (byte) 110:
                return '\n';
            case (byte) 114:
                return '\r';
            case (byte) 116:
                return '\t';
            case (byte) 117:
                int i3 = 0;
                while (i < 4) {
                    if (this.aLT >= this.aLU && !AN()) {
                        bg(" in character escape sequence");
                    }
                    byte[] bArr2 = this.aNW;
                    int i4 = this.aLT;
                    this.aLT = i4 + 1;
                    byte b2 = bArr2[i4];
                    i4 = afn.fx(b2);
                    if (i4 < 0) {
                        m3112h(b2, "expected a hex-digit for character escape sequence");
                    }
                    i3 = (i3 << 4) | i4;
                    i++;
                }
                return (char) i3;
            default:
                return m3110b((char) fU(b));
        }
    }

    protected int fU(int i) throws IOException {
        int i2 = i & 255;
        if (i2 <= 127) {
            return i2;
        }
        int i3;
        Object obj;
        if ((i2 & 224) == 192) {
            i3 = i2 & 31;
            obj = 1;
        } else if ((i2 & 240) == 224) {
            i3 = i2 & 15;
            i2 = 2;
        } else if ((i2 & 248) == 240) {
            i3 = i2 & 7;
            obj = 3;
        } else {
            gd(i2 & 255);
            i3 = i2;
            i2 = 1;
        }
        int Cz = Cz();
        if ((Cz & 192) != Allocation.USAGE_SHARED) {
            ge(Cz & 255);
        }
        i3 = (i3 << 6) | (Cz & 63);
        if (obj <= 1) {
            return i3;
        }
        int Cz2 = Cz();
        if ((Cz2 & 192) != Allocation.USAGE_SHARED) {
            ge(Cz2 & 255);
        }
        Cz2 = (Cz2 & 63) | (i3 << 6);
        if (obj <= 2) {
            return Cz2;
        }
        i2 = Cz();
        if ((i2 & 192) != Allocation.USAGE_SHARED) {
            ge(i2 & 255);
        }
        return (i2 & 63) | (Cz2 << 6);
    }

    private final int fV(int i) throws IOException {
        if (this.aLT >= this.aLU) {
            AM();
        }
        byte[] bArr = this.aNW;
        int i2 = this.aLT;
        this.aLT = i2 + 1;
        byte b = bArr[i2];
        if ((b & 192) != Allocation.USAGE_SHARED) {
            bz(b & 255, this.aLT);
        }
        return (b & 63) | ((i & 31) << 6);
    }

    private final int fW(int i) throws IOException {
        if (this.aLT >= this.aLU) {
            AM();
        }
        int i2 = i & 15;
        byte[] bArr = this.aNW;
        int i3 = this.aLT;
        this.aLT = i3 + 1;
        byte b = bArr[i3];
        if ((b & 192) != Allocation.USAGE_SHARED) {
            bz(b & 255, this.aLT);
        }
        i2 = (i2 << 6) | (b & 63);
        if (this.aLT >= this.aLU) {
            AM();
        }
        bArr = this.aNW;
        i3 = this.aLT;
        this.aLT = i3 + 1;
        b = bArr[i3];
        if ((b & 192) != Allocation.USAGE_SHARED) {
            bz(b & 255, this.aLT);
        }
        return (i2 << 6) | (b & 63);
    }

    private final int fX(int i) throws IOException {
        int i2 = i & 15;
        byte[] bArr = this.aNW;
        int i3 = this.aLT;
        this.aLT = i3 + 1;
        byte b = bArr[i3];
        if ((b & 192) != Allocation.USAGE_SHARED) {
            bz(b & 255, this.aLT);
        }
        i2 = (i2 << 6) | (b & 63);
        bArr = this.aNW;
        i3 = this.aLT;
        this.aLT = i3 + 1;
        b = bArr[i3];
        if ((b & 192) != Allocation.USAGE_SHARED) {
            bz(b & 255, this.aLT);
        }
        return (i2 << 6) | (b & 63);
    }

    private final int fY(int i) throws IOException {
        if (this.aLT >= this.aLU) {
            AM();
        }
        byte[] bArr = this.aNW;
        int i2 = this.aLT;
        this.aLT = i2 + 1;
        byte b = bArr[i2];
        if ((b & 192) != Allocation.USAGE_SHARED) {
            bz(b & 255, this.aLT);
        }
        int i3 = (b & 63) | ((i & 7) << 6);
        if (this.aLT >= this.aLU) {
            AM();
        }
        byte[] bArr2 = this.aNW;
        int i4 = this.aLT;
        this.aLT = i4 + 1;
        byte b2 = bArr2[i4];
        if ((b2 & 192) != Allocation.USAGE_SHARED) {
            bz(b2 & 255, this.aLT);
        }
        i3 = (i3 << 6) | (b2 & 63);
        if (this.aLT >= this.aLU) {
            AM();
        }
        bArr2 = this.aNW;
        i4 = this.aLT;
        this.aLT = i4 + 1;
        b2 = bArr2[i4];
        if ((b2 & 192) != Allocation.USAGE_SHARED) {
            bz(b2 & 255, this.aLT);
        }
        return ((i3 << 6) | (b2 & 63)) - NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST;
    }

    private final void fZ(int i) throws IOException {
        if (this.aLT >= this.aLU) {
            AM();
        }
        byte[] bArr = this.aNW;
        int i2 = this.aLT;
        this.aLT = i2 + 1;
        byte b = bArr[i2];
        if ((b & 192) != Allocation.USAGE_SHARED) {
            bz(b & 255, this.aLT);
        }
    }

    private final void ga(int i) throws IOException {
        if (this.aLT >= this.aLU) {
            AM();
        }
        byte[] bArr = this.aNW;
        int i2 = this.aLT;
        this.aLT = i2 + 1;
        byte b = bArr[i2];
        if ((b & 192) != Allocation.USAGE_SHARED) {
            bz(b & 255, this.aLT);
        }
        if (this.aLT >= this.aLU) {
            AM();
        }
        bArr = this.aNW;
        i2 = this.aLT;
        this.aLT = i2 + 1;
        b = bArr[i2];
        if ((b & 192) != Allocation.USAGE_SHARED) {
            bz(b & 255, this.aLT);
        }
    }

    private final void gb(int i) throws IOException {
        if (this.aLT >= this.aLU) {
            AM();
        }
        byte[] bArr = this.aNW;
        int i2 = this.aLT;
        this.aLT = i2 + 1;
        byte b = bArr[i2];
        if ((b & 192) != Allocation.USAGE_SHARED) {
            bz(b & 255, this.aLT);
        }
        if (this.aLT >= this.aLU) {
            AM();
        }
        bArr = this.aNW;
        i2 = this.aLT;
        this.aLT = i2 + 1;
        b = bArr[i2];
        if ((b & 192) != Allocation.USAGE_SHARED) {
            bz(b & 255, this.aLT);
        }
        if (this.aLT >= this.aLU) {
            AM();
        }
        bArr = this.aNW;
        i2 = this.aLT;
        this.aLT = i2 + 1;
        b = bArr[i2];
        if ((b & 192) != Allocation.USAGE_SHARED) {
            bz(b & 255, this.aLT);
        }
    }

    protected final void Cg() throws IOException {
        if ((this.aLT < this.aLU || AN()) && this.aNW[this.aLT] == (byte) 10) {
            this.aLT++;
        }
        this.aLW++;
        this.aLX = this.aLT;
    }

    private int Cz() throws IOException {
        if (this.aLT >= this.aLU) {
            AM();
        }
        byte[] bArr = this.aNW;
        int i = this.aLT;
        this.aLT = i + 1;
        return bArr[i] & 255;
    }

    protected void bt(String str) throws IOException {
        m3266s(str, "'null', 'true', 'false' or NaN");
    }

    protected void m3266s(String str, String str2) throws IOException {
        StringBuilder stringBuilder = new StringBuilder(str);
        while (true) {
            if (this.aLT >= this.aLU && !AN()) {
                break;
            }
            byte[] bArr = this.aNW;
            int i = this.aLT;
            this.aLT = i + 1;
            char fU = (char) fU(bArr[i]);
            if (!Character.isJavaIdentifierPart(fU)) {
                break;
            }
            stringBuilder.append(fU);
        }
        aX("Unrecognized token '" + stringBuilder.toString() + "': was expecting " + str2);
    }

    protected void gc(int i) throws JsonParseException {
        if (i < 32) {
            ft(i);
        }
        gd(i);
    }

    protected void gd(int i) throws JsonParseException {
        aX("Invalid UTF-8 start byte 0x" + Integer.toHexString(i));
    }

    protected void ge(int i) throws JsonParseException {
        aX("Invalid UTF-8 middle byte 0x" + Integer.toHexString(i));
    }

    protected void bz(int i, int i2) throws JsonParseException {
        this.aLT = i2;
        ge(i);
    }

    public static int[] m3249b(int[] iArr, int i) {
        if (iArr == null) {
            return new int[i];
        }
        return Arrays.copyOf(iArr, iArr.length + i);
    }

    protected final byte[] m3263b(Base64Variant base64Variant) throws IOException {
        agn AS = AS();
        while (true) {
            if (this.aLT >= this.aLU) {
                AM();
            }
            byte[] bArr = this.aNW;
            int i = this.aLT;
            this.aLT = i + 1;
            i = bArr[i] & 255;
            if (i > 32) {
                int decodeBase64Char = base64Variant.decodeBase64Char(i);
                if (decodeBase64Char < 0) {
                    if (i == 34) {
                        return AS.toByteArray();
                    }
                    decodeBase64Char = m3116a(base64Variant, i, 0);
                    if (decodeBase64Char < 0) {
                        continue;
                    }
                }
                if (this.aLT >= this.aLU) {
                    AM();
                }
                byte[] bArr2 = this.aNW;
                int i2 = this.aLT;
                this.aLT = i2 + 1;
                i2 = bArr2[i2] & 255;
                i = base64Variant.decodeBase64Char(i2);
                if (i < 0) {
                    i = m3116a(base64Variant, i2, 1);
                }
                i |= decodeBase64Char << 6;
                if (this.aLT >= this.aLU) {
                    AM();
                }
                bArr = this.aNW;
                i2 = this.aLT;
                this.aLT = i2 + 1;
                i2 = bArr[i2] & 255;
                decodeBase64Char = base64Variant.decodeBase64Char(i2);
                if (decodeBase64Char < 0) {
                    if (decodeBase64Char != -2) {
                        if (i2 != 34 || base64Variant.usesPadding()) {
                            decodeBase64Char = m3116a(base64Variant, i2, 2);
                        } else {
                            AS.append(i >> 4);
                            return AS.toByteArray();
                        }
                    }
                    if (decodeBase64Char == -2) {
                        if (this.aLT >= this.aLU) {
                            AM();
                        }
                        bArr = this.aNW;
                        i2 = this.aLT;
                        this.aLT = i2 + 1;
                        decodeBase64Char = bArr[i2] & 255;
                        if (base64Variant.usesPaddingChar(decodeBase64Char)) {
                            AS.append(i >> 4);
                        } else {
                            throw m3120a(base64Variant, decodeBase64Char, 3, "expected padding character '" + base64Variant.getPaddingChar() + "'");
                        }
                    }
                }
                i = (i << 6) | decodeBase64Char;
                if (this.aLT >= this.aLU) {
                    AM();
                }
                bArr = this.aNW;
                i2 = this.aLT;
                this.aLT = i2 + 1;
                i2 = bArr[i2] & 255;
                decodeBase64Char = base64Variant.decodeBase64Char(i2);
                if (decodeBase64Char < 0) {
                    if (decodeBase64Char != -2) {
                        if (i2 != 34 || base64Variant.usesPadding()) {
                            decodeBase64Char = m3116a(base64Variant, i2, 3);
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

    private static final int bA(int i, int i2) {
        return i2 == 4 ? i : i | (-1 << (i2 << 3));
    }
}
