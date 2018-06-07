package com.fossil;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser.NumberType;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.JsonToken;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;

public class akx extends aku {
    protected final short aTZ;

    public akx(short s) {
        this.aTZ = s;
    }

    public static akx m3677h(short s) {
        return new akx(s);
    }

    public JsonToken AE() {
        return JsonToken.VALUE_NUMBER_INT;
    }

    public NumberType AF() {
        return NumberType.INT;
    }

    public Number DM() {
        return Short.valueOf(this.aTZ);
    }

    public int intValue() {
        return this.aTZ;
    }

    public long longValue() {
        return (long) this.aTZ;
    }

    public double doubleValue() {
        return (double) this.aTZ;
    }

    public BigDecimal DN() {
        return BigDecimal.valueOf((long) this.aTZ);
    }

    public BigInteger DO() {
        return BigInteger.valueOf((long) this.aTZ);
    }

    public String DP() {
        return afs.toString(this.aTZ);
    }

    public final void serialize(JsonGenerator jsonGenerator, ahg com_fossil_ahg) throws IOException, JsonProcessingException {
        jsonGenerator.mo947f(this.aTZ);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof akx)) {
            return false;
        }
        if (((akx) obj).aTZ != this.aTZ) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return this.aTZ;
    }
}
