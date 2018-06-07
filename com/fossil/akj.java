package com.fossil;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser.NumberType;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.JsonToken;
import com.misfit.frameworks.buttonservice.ButtonService;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;

public class akj extends aku {
    private static final BigInteger aTs = BigInteger.valueOf(-2147483648L);
    private static final BigInteger aTt = BigInteger.valueOf(2147483647L);
    private static final BigInteger aTu = BigInteger.valueOf(Long.MIN_VALUE);
    private static final BigInteger aTv = BigInteger.valueOf(ButtonService.TIME_STAMP_FOR_NON_EXECUTABLE_METHOD);
    protected final BigInteger aTw;

    public akj(BigInteger bigInteger) {
        this.aTw = bigInteger;
    }

    public static akj m3662b(BigInteger bigInteger) {
        return new akj(bigInteger);
    }

    public JsonToken AE() {
        return JsonToken.VALUE_NUMBER_INT;
    }

    public NumberType AF() {
        return NumberType.BIG_INTEGER;
    }

    public Number DM() {
        return this.aTw;
    }

    public int intValue() {
        return this.aTw.intValue();
    }

    public long longValue() {
        return this.aTw.longValue();
    }

    public BigInteger DO() {
        return this.aTw;
    }

    public double doubleValue() {
        return this.aTw.doubleValue();
    }

    public BigDecimal DN() {
        return new BigDecimal(this.aTw);
    }

    public String DP() {
        return this.aTw.toString();
    }

    public final void serialize(JsonGenerator jsonGenerator, ahg com_fossil_ahg) throws IOException, JsonProcessingException {
        jsonGenerator.mo938a(this.aTw);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || !(obj instanceof akj)) {
            return false;
        }
        return ((akj) obj).aTw.equals(this.aTw);
    }

    public int hashCode() {
        return this.aTw.hashCode();
    }
}
