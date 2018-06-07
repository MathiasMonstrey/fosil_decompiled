package com.fossil;

import com.fasterxml.jackson.databind.node.JsonNodeType;
import com.fossil.aha.C1637a;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Iterator;
import java.util.Map.Entry;

public abstract class agz extends C1637a implements afe, Iterable<agz> {
    public abstract JsonNodeType DG();

    public abstract String DP();

    public abstract String toString();

    protected agz() {
    }

    public int size() {
        return 0;
    }

    public final boolean isArray() {
        return DG() == JsonNodeType.ARRAY;
    }

    public final boolean DF() {
        return DG() == JsonNodeType.OBJECT;
    }

    public agz bF(String str) {
        return null;
    }

    public final boolean DH() {
        return DG() == JsonNodeType.POJO;
    }

    public final boolean DI() {
        return DG() == JsonNodeType.NUMBER;
    }

    public final boolean DJ() {
        return DG() == JsonNodeType.BINARY;
    }

    public String DK() {
        return null;
    }

    public byte[] DL() throws IOException {
        return null;
    }

    public Number DM() {
        return null;
    }

    public int intValue() {
        return 0;
    }

    public long longValue() {
        return 0;
    }

    public double doubleValue() {
        return 0.0d;
    }

    public BigDecimal DN() {
        return BigDecimal.ZERO;
    }

    public BigInteger DO() {
        return BigInteger.ZERO;
    }

    public final Iterator<agz> iterator() {
        return DQ();
    }

    public Iterator<agz> DQ() {
        return aml.Hk();
    }

    public Iterator<Entry<String, agz>> DR() {
        return aml.Hk();
    }
}
