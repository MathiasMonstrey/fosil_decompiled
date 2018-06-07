package com.fossil;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser.NumberType;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.JsonToken;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;

public class akr extends aku {
    protected final long aTP;

    public akr(long j) {
        this.aTP = j;
    }

    public static akr m3668M(long j) {
        return new akr(j);
    }

    public JsonToken AE() {
        return JsonToken.VALUE_NUMBER_INT;
    }

    public NumberType AF() {
        return NumberType.LONG;
    }

    public Number DM() {
        return Long.valueOf(this.aTP);
    }

    public int intValue() {
        return (int) this.aTP;
    }

    public long longValue() {
        return this.aTP;
    }

    public double doubleValue() {
        return (double) this.aTP;
    }

    public BigDecimal DN() {
        return BigDecimal.valueOf(this.aTP);
    }

    public BigInteger DO() {
        return BigInteger.valueOf(this.aTP);
    }

    public String DP() {
        return afs.toString(this.aTP);
    }

    public final void serialize(JsonGenerator jsonGenerator, ahg com_fossil_ahg) throws IOException, JsonProcessingException {
        jsonGenerator.mo933J(this.aTP);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof akr)) {
            return false;
        }
        if (((akr) obj).aTP != this.aTP) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return ((int) this.aTP) ^ ((int) (this.aTP >> 32));
    }
}
