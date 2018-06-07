package com.fossil;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser.NumberType;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.JsonToken;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;

public class ako extends aku {
    protected final double aTI;

    public ako(double d) {
        this.aTI = d;
    }

    public static ako m3666e(double d) {
        return new ako(d);
    }

    public JsonToken AE() {
        return JsonToken.VALUE_NUMBER_FLOAT;
    }

    public NumberType AF() {
        return NumberType.DOUBLE;
    }

    public Number DM() {
        return Double.valueOf(this.aTI);
    }

    public int intValue() {
        return (int) this.aTI;
    }

    public long longValue() {
        return (long) this.aTI;
    }

    public double doubleValue() {
        return this.aTI;
    }

    public BigDecimal DN() {
        return BigDecimal.valueOf(this.aTI);
    }

    public BigInteger DO() {
        return DN().toBigInteger();
    }

    public String DP() {
        return afs.toString(this.aTI);
    }

    public final void serialize(JsonGenerator jsonGenerator, ahg com_fossil_ahg) throws IOException, JsonProcessingException {
        jsonGenerator.mo945d(this.aTI);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof ako)) {
            return false;
        }
        if (Double.compare(this.aTI, ((ako) obj).aTI) != 0) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        long doubleToLongBits = Double.doubleToLongBits(this.aTI);
        return ((int) (doubleToLongBits >> 32)) ^ ((int) doubleToLongBits);
    }
}
