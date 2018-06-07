package com.fossil;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.node.JsonNodeType;
import java.io.IOException;
import java.util.Arrays;

public class akk extends ala {
    static final akk aTx = new akk(new byte[0]);
    protected final byte[] aTy;

    public akk(byte[] bArr) {
        this.aTy = bArr;
    }

    public akk(byte[] bArr, int i, int i2) {
        if (i == 0 && i2 == bArr.length) {
            this.aTy = bArr;
            return;
        }
        this.aTy = new byte[i2];
        System.arraycopy(bArr, i, this.aTy, 0, i2);
    }

    public static akk m3663W(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        if (bArr.length == 0) {
            return aTx;
        }
        return new akk(bArr);
    }

    public static akk m3664f(byte[] bArr, int i, int i2) {
        if (bArr == null) {
            return null;
        }
        if (i2 == 0) {
            return aTx;
        }
        return new akk(bArr, i, i2);
    }

    public JsonNodeType DG() {
        return JsonNodeType.BINARY;
    }

    public JsonToken AE() {
        return JsonToken.VALUE_EMBEDDED_OBJECT;
    }

    public byte[] DL() {
        return this.aTy;
    }

    public String DP() {
        return aew.zz().encode(this.aTy, false);
    }

    public final void serialize(JsonGenerator jsonGenerator, ahg com_fossil_ahg) throws IOException, JsonProcessingException {
        jsonGenerator.mo936a(com_fossil_ahg.getConfig().getBase64Variant(), this.aTy, 0, this.aTy.length);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || !(obj instanceof akk)) {
            return false;
        }
        return Arrays.equals(((akk) obj).aTy, this.aTy);
    }

    public int hashCode() {
        return this.aTy == null ? -1 : this.aTy.length;
    }

    public String toString() {
        return aew.zz().encode(this.aTy, true);
    }
}
