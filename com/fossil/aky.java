package com.fossil;

import com.fasterxml.jackson.core.Base64Variant;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonLocation;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.node.JsonNodeType;
import java.io.IOException;

public class aky extends ala {
    static final aky aUa = new aky("");
    protected final String _value;

    public aky(String str) {
        this._value = str;
    }

    public static aky bX(String str) {
        if (str == null) {
            return null;
        }
        if (str.length() == 0) {
            return aUa;
        }
        return new aky(str);
    }

    public JsonNodeType DG() {
        return JsonNodeType.STRING;
    }

    public JsonToken AE() {
        return JsonToken.VALUE_STRING;
    }

    public String DK() {
        return this._value;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public byte[] m3680a(com.fasterxml.jackson.core.Base64Variant r12) throws java.io.IOException {
        /*
        r11 = this;
        r10 = 3;
        r2 = 0;
        r9 = -2;
        r3 = new com.fossil.agn;
        r0 = 100;
        r3.<init>(r0);
        r4 = r11._value;
        r5 = r4.length();
        r0 = r2;
    L_0x0011:
        if (r0 >= r5) goto L_0x001b;
    L_0x0013:
        r1 = r0 + 1;
        r0 = r4.charAt(r0);
        if (r1 < r5) goto L_0x0020;
    L_0x001b:
        r0 = r3.toByteArray();
        return r0;
    L_0x0020:
        r6 = 32;
        if (r0 <= r6) goto L_0x00d6;
    L_0x0024:
        r6 = r12.decodeBase64Char(r0);
        if (r6 >= 0) goto L_0x002d;
    L_0x002a:
        r11.m3681b(r12, r0, r2);
    L_0x002d:
        if (r1 < r5) goto L_0x0032;
    L_0x002f:
        r11._reportBase64EOF();
    L_0x0032:
        r0 = r1 + 1;
        r1 = r4.charAt(r1);
        r7 = r12.decodeBase64Char(r1);
        if (r7 >= 0) goto L_0x0042;
    L_0x003e:
        r8 = 1;
        r11.m3681b(r12, r1, r8);
    L_0x0042:
        r1 = r6 << 6;
        r1 = r1 | r7;
        if (r0 < r5) goto L_0x0056;
    L_0x0047:
        r6 = r12.usesPadding();
        if (r6 != 0) goto L_0x0053;
    L_0x004d:
        r0 = r1 >> 4;
        r3.append(r0);
        goto L_0x001b;
    L_0x0053:
        r11._reportBase64EOF();
    L_0x0056:
        r6 = r0 + 1;
        r0 = r4.charAt(r0);
        r7 = r12.decodeBase64Char(r0);
        if (r7 >= 0) goto L_0x00a0;
    L_0x0062:
        if (r7 == r9) goto L_0x0068;
    L_0x0064:
        r7 = 2;
        r11.m3681b(r12, r0, r7);
    L_0x0068:
        if (r6 < r5) goto L_0x006d;
    L_0x006a:
        r11._reportBase64EOF();
    L_0x006d:
        r0 = r6 + 1;
        r6 = r4.charAt(r6);
        r7 = r12.usesPaddingChar(r6);
        if (r7 != 0) goto L_0x0099;
    L_0x0079:
        r7 = new java.lang.StringBuilder;
        r7.<init>();
        r8 = "expected padding character '";
        r7 = r7.append(r8);
        r8 = r12.getPaddingChar();
        r7 = r7.append(r8);
        r8 = "'";
        r7 = r7.append(r8);
        r7 = r7.toString();
        r11.m3679a(r12, r6, r10, r7);
    L_0x0099:
        r1 = r1 >> 4;
        r3.append(r1);
        goto L_0x0011;
    L_0x00a0:
        r0 = r1 << 6;
        r1 = r0 | r7;
        if (r6 < r5) goto L_0x00b6;
    L_0x00a6:
        r0 = r12.usesPadding();
        if (r0 != 0) goto L_0x00b3;
    L_0x00ac:
        r0 = r1 >> 2;
        r3.gG(r0);
        goto L_0x001b;
    L_0x00b3:
        r11._reportBase64EOF();
    L_0x00b6:
        r0 = r6 + 1;
        r6 = r4.charAt(r6);
        r7 = r12.decodeBase64Char(r6);
        if (r7 >= 0) goto L_0x00ce;
    L_0x00c2:
        if (r7 == r9) goto L_0x00c7;
    L_0x00c4:
        r11.m3681b(r12, r6, r10);
    L_0x00c7:
        r1 = r1 >> 2;
        r3.gG(r1);
        goto L_0x0011;
    L_0x00ce:
        r1 = r1 << 6;
        r1 = r1 | r7;
        r3.gH(r1);
        goto L_0x0011;
    L_0x00d6:
        r0 = r1;
        goto L_0x0013;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fossil.aky.a(com.fasterxml.jackson.core.Base64Variant):byte[]");
    }

    public byte[] DL() throws IOException {
        return m3680a(aew.zz());
    }

    public String DP() {
        return this._value;
    }

    public final void serialize(JsonGenerator jsonGenerator, ahg com_fossil_ahg) throws IOException {
        if (this._value == null) {
            jsonGenerator.zL();
        } else {
            jsonGenerator.writeString(this._value);
        }
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || !(obj instanceof aky)) {
            return false;
        }
        return ((aky) obj)._value.equals(this._value);
    }

    public int hashCode() {
        return this._value.hashCode();
    }

    public String toString() {
        int length = this._value.length();
        StringBuilder stringBuilder = new StringBuilder((length >> 4) + (length + 2));
        m3678a(stringBuilder, this._value);
        return stringBuilder.toString();
    }

    protected static void m3678a(StringBuilder stringBuilder, String str) {
        stringBuilder.append('\"');
        afn.m3144a(stringBuilder, str);
        stringBuilder.append('\"');
    }

    protected void m3681b(Base64Variant base64Variant, char c, int i) throws JsonParseException {
        m3679a(base64Variant, c, i, null);
    }

    protected void m3679a(Base64Variant base64Variant, char c, int i, String str) throws JsonParseException {
        String str2;
        if (c <= ' ') {
            str2 = "Illegal white space character (code 0x" + Integer.toHexString(c) + ") as character #" + (i + 1) + " of 4-char base64 unit: can only used between units";
        } else if (base64Variant.usesPaddingChar(c)) {
            str2 = "Unexpected padding character ('" + base64Variant.getPaddingChar() + "') as character #" + (i + 1) + " of 4-char base64 unit: padding only legal as 3rd or 4th character";
        } else if (!Character.isDefined(c) || Character.isISOControl(c)) {
            str2 = "Illegal character (code 0x" + Integer.toHexString(c) + ") in base64 content";
        } else {
            str2 = "Illegal character '" + c + "' (code 0x" + Integer.toHexString(c) + ") in base64 content";
        }
        if (str != null) {
            str2 = str2 + ": " + str;
        }
        throw new JsonParseException(str2, JsonLocation.NA);
    }

    protected void _reportBase64EOF() throws JsonParseException {
        throw new JsonParseException("Unexpected end-of-String when base64 content", JsonLocation.NA);
    }
}
