package com.fossil;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser.NumberType;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.JsonToken;
import com.misfit.frameworks.buttonservice.ButtonService;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;

public class akn extends aku {
    public static final akn aTC = new akn(BigDecimal.ZERO);
    private static final BigDecimal aTD = BigDecimal.valueOf(-2147483648L);
    private static final BigDecimal aTE = BigDecimal.valueOf(2147483647L);
    private static final BigDecimal aTF = BigDecimal.valueOf(Long.MIN_VALUE);
    private static final BigDecimal aTG = BigDecimal.valueOf(ButtonService.TIME_STAMP_FOR_NON_EXECUTABLE_METHOD);
    protected final BigDecimal aTH;

    public akn(BigDecimal bigDecimal) {
        this.aTH = bigDecimal;
    }

    public static akn m3665b(BigDecimal bigDecimal) {
        return new akn(bigDecimal);
    }

    public JsonToken AE() {
        return JsonToken.VALUE_NUMBER_FLOAT;
    }

    public NumberType AF() {
        return NumberType.BIG_DECIMAL;
    }

    public Number DM() {
        return this.aTH;
    }

    public int intValue() {
        return this.aTH.intValue();
    }

    public long longValue() {
        return this.aTH.longValue();
    }

    public BigInteger DO() {
        return this.aTH.toBigInteger();
    }

    public double doubleValue() {
        return this.aTH.doubleValue();
    }

    public BigDecimal DN() {
        return this.aTH;
    }

    public String DP() {
        return this.aTH.toString();
    }

    public final void serialize(JsonGenerator jsonGenerator, ahg com_fossil_ahg) throws IOException, JsonProcessingException {
        jsonGenerator.mo937a(this.aTH);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof akn)) {
            return false;
        }
        if (((akn) obj).aTH.compareTo(this.aTH) != 0) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return Double.valueOf(doubleValue()).hashCode();
    }
}
