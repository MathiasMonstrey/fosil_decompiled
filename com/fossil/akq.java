package com.fossil;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser.NumberType;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.JsonToken;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;

public class akq extends aku {
    private static final akq[] aTK = new akq[12];
    protected final int aTL;

    static {
        for (int i = 0; i < 12; i++) {
            aTK[i] = new akq(i - 1);
        }
    }

    public akq(int i) {
        this.aTL = i;
    }

    public static akq gT(int i) {
        if (i > 10 || i < -1) {
            return new akq(i);
        }
        return aTK[i + 1];
    }

    public JsonToken AE() {
        return JsonToken.VALUE_NUMBER_INT;
    }

    public NumberType AF() {
        return NumberType.INT;
    }

    public Number DM() {
        return Integer.valueOf(this.aTL);
    }

    public int intValue() {
        return this.aTL;
    }

    public long longValue() {
        return (long) this.aTL;
    }

    public double doubleValue() {
        return (double) this.aTL;
    }

    public BigDecimal DN() {
        return BigDecimal.valueOf((long) this.aTL);
    }

    public BigInteger DO() {
        return BigInteger.valueOf((long) this.aTL);
    }

    public String DP() {
        return afs.toString(this.aTL);
    }

    public final void serialize(JsonGenerator jsonGenerator, ahg com_fossil_ahg) throws IOException, JsonProcessingException {
        jsonGenerator.fl(this.aTL);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof akq)) {
            return false;
        }
        if (((akq) obj).aTL != this.aTL) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return this.aTL;
    }
}
