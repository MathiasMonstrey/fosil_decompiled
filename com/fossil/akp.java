package com.fossil;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser.NumberType;
import com.fasterxml.jackson.core.JsonToken;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;

public class akp extends aku {
    protected final float aTJ;

    public akp(float f) {
        this.aTJ = f;
    }

    public static akp m3667U(float f) {
        return new akp(f);
    }

    public JsonToken AE() {
        return JsonToken.VALUE_NUMBER_FLOAT;
    }

    public NumberType AF() {
        return NumberType.FLOAT;
    }

    public Number DM() {
        return Float.valueOf(this.aTJ);
    }

    public int intValue() {
        return (int) this.aTJ;
    }

    public long longValue() {
        return (long) this.aTJ;
    }

    public double doubleValue() {
        return (double) this.aTJ;
    }

    public BigDecimal DN() {
        return BigDecimal.valueOf((double) this.aTJ);
    }

    public BigInteger DO() {
        return DN().toBigInteger();
    }

    public String DP() {
        return Float.toString(this.aTJ);
    }

    public final void serialize(JsonGenerator jsonGenerator, ahg com_fossil_ahg) throws IOException {
        jsonGenerator.mo934T(this.aTJ);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof akp)) {
            return false;
        }
        if (Float.compare(this.aTJ, ((akp) obj).aTJ) != 0) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return Float.floatToIntBits(this.aTJ);
    }
}
