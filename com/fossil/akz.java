package com.fossil;

import com.fasterxml.jackson.core.Base64Variant;
import com.fasterxml.jackson.core.JsonLocation;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonParser.NumberType;
import com.fasterxml.jackson.core.JsonToken;
import com.fossil.aks.C1667a;
import com.fossil.aks.C1668b;
import com.fossil.aks.C1669c;
import java.io.IOException;
import java.io.OutputStream;
import java.math.BigDecimal;
import java.math.BigInteger;

public class akz extends afh {
    protected afa _objectCodec;
    protected boolean aLR;
    protected JsonToken aMc;
    protected aks aUb;
    protected boolean aUc;

    public akz(agz com_fossil_agz, afa com_fossil_afa) {
        super(0);
        this._objectCodec = com_fossil_afa;
        if (com_fossil_agz.isArray()) {
            this.aMc = JsonToken.START_ARRAY;
            this.aUb = new C1667a(com_fossil_agz, null);
        } else if (com_fossil_agz.DF()) {
            this.aMc = JsonToken.START_OBJECT;
            this.aUb = new C1668b(com_fossil_agz, null);
        } else {
            this.aUb = new C1669c(com_fossil_agz, null);
        }
    }

    public afa getCodec() {
        return this._objectCodec;
    }

    public void close() throws IOException {
        if (!this.aLR) {
            this.aLR = true;
            this.aUb = null;
            this.aMA = null;
        }
    }

    public JsonToken zP() throws IOException, JsonParseException {
        if (this.aMc != null) {
            this.aMA = this.aMc;
            this.aMc = null;
            return this.aMA;
        } else if (this.aUc) {
            this.aUc = false;
            if (this.aUb.Gq()) {
                this.aUb = this.aUb.Gr();
                this.aMA = this.aUb.zP();
                if (this.aMA == JsonToken.START_OBJECT || this.aMA == JsonToken.START_ARRAY) {
                    this.aUc = true;
                }
                return this.aMA;
            }
            this.aMA = this.aMA == JsonToken.START_OBJECT ? JsonToken.END_OBJECT : JsonToken.END_ARRAY;
            return this.aMA;
        } else if (this.aUb == null) {
            this.aLR = true;
            return null;
        } else {
            this.aMA = this.aUb.zP();
            if (this.aMA != null) {
                if (this.aMA == JsonToken.START_OBJECT || this.aMA == JsonToken.START_ARRAY) {
                    this.aUc = true;
                }
                return this.aMA;
            }
            this.aMA = this.aUb.Go();
            this.aUb = this.aUb.Gn();
            return this.aMA;
        }
    }

    public JsonParser zT() throws IOException, JsonParseException {
        if (this.aMA == JsonToken.START_OBJECT) {
            this.aUc = false;
            this.aMA = JsonToken.END_OBJECT;
        } else if (this.aMA == JsonToken.START_ARRAY) {
            this.aUc = false;
            this.aMA = JsonToken.END_ARRAY;
        }
        return this;
    }

    public String zW() {
        return this.aUb == null ? null : this.aUb.zW();
    }

    public aez zX() {
        return this.aUb;
    }

    public JsonLocation zY() {
        return JsonLocation.NA;
    }

    public JsonLocation zZ() {
        return JsonLocation.NA;
    }

    public String getText() {
        if (this.aLR) {
            return null;
        }
        switch (this.aMA) {
            case FIELD_NAME:
                return this.aUb.zW();
            case VALUE_STRING:
                return Gp().DK();
            case VALUE_NUMBER_INT:
            case VALUE_NUMBER_FLOAT:
                return String.valueOf(Gp().DM());
            case VALUE_EMBEDDED_OBJECT:
                agz Gp = Gp();
                if (Gp != null && Gp.DJ()) {
                    return Gp.DP();
                }
        }
        if (this.aMA != null) {
            return this.aMA.asString();
        }
        return null;
    }

    public char[] Ad() throws IOException, JsonParseException {
        return getText().toCharArray();
    }

    public int Ae() throws IOException, JsonParseException {
        return getText().length();
    }

    public int Af() throws IOException, JsonParseException {
        return 0;
    }

    public boolean Ag() {
        return false;
    }

    public NumberType Ai() throws IOException, JsonParseException {
        agz Gu = Gu();
        return Gu == null ? null : Gu.AF();
    }

    public BigInteger Am() throws IOException, JsonParseException {
        return Gu().DO();
    }

    public BigDecimal Ap() throws IOException, JsonParseException {
        return Gu().DN();
    }

    public double Ao() throws IOException, JsonParseException {
        return Gu().doubleValue();
    }

    public float An() throws IOException, JsonParseException {
        return (float) Gu().doubleValue();
    }

    public long Al() throws IOException, JsonParseException {
        return Gu().longValue();
    }

    public int getIntValue() throws IOException, JsonParseException {
        return Gu().intValue();
    }

    public Number Ah() throws IOException, JsonParseException {
        return Gu().DM();
    }

    public Object Aq() {
        if (!this.aLR) {
            agz Gp = Gp();
            if (Gp != null) {
                if (Gp.DH()) {
                    return ((akw) Gp).Gt();
                }
                if (Gp.DJ()) {
                    return ((akk) Gp).DL();
                }
            }
        }
        return null;
    }

    public byte[] mo906a(Base64Variant base64Variant) throws IOException, JsonParseException {
        agz Gp = Gp();
        if (Gp != null) {
            byte[] DL = Gp.DL();
            if (DL != null) {
                return DL;
            }
            if (Gp.DH()) {
                Object Gt = ((akw) Gp).Gt();
                if (Gt instanceof byte[]) {
                    return (byte[]) Gt;
                }
            }
        }
        return null;
    }

    public int mo904a(Base64Variant base64Variant, OutputStream outputStream) throws IOException, JsonParseException {
        byte[] a = mo906a(base64Variant);
        if (a == null) {
            return 0;
        }
        outputStream.write(a, 0, a.length);
        return a.length;
    }

    protected agz Gp() {
        if (this.aLR || this.aUb == null) {
            return null;
        }
        return this.aUb.Gp();
    }

    protected agz Gu() throws JsonParseException {
        agz Gp = Gp();
        if (Gp != null && Gp.DI()) {
            return Gp;
        }
        throw aZ("Current token (" + (Gp == null ? null : Gp.AE()) + ") not numeric, can not use numeric value accessors");
    }

    protected void AQ() throws JsonParseException {
        zN();
    }
}
