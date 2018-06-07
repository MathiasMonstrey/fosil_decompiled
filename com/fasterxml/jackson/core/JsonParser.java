package com.fasterxml.jackson.core;

import com.fossil.aew;
import com.fossil.aex;
import com.fossil.aez;
import com.fossil.afa;
import java.io.Closeable;
import java.io.IOException;
import java.io.OutputStream;
import java.math.BigDecimal;
import java.math.BigInteger;

public abstract class JsonParser implements Closeable {
    protected int aLy;

    public enum Feature {
        AUTO_CLOSE_SOURCE(true),
        ALLOW_COMMENTS(false),
        ALLOW_YAML_COMMENTS(false),
        ALLOW_UNQUOTED_FIELD_NAMES(false),
        ALLOW_SINGLE_QUOTES(false),
        ALLOW_UNQUOTED_CONTROL_CHARS(false),
        ALLOW_BACKSLASH_ESCAPING_ANY_CHARACTER(false),
        ALLOW_NUMERIC_LEADING_ZEROS(false),
        ALLOW_NON_NUMERIC_NUMBERS(false),
        STRICT_DUPLICATE_DETECTION(false),
        IGNORE_UNDEFINED(false);
        
        private final boolean _defaultState;
        private final int _mask;

        public static int collectDefaults() {
            int i = 0;
            for (Feature feature : values()) {
                if (feature.enabledByDefault()) {
                    i |= feature.getMask();
                }
            }
            return i;
        }

        private Feature(boolean z) {
            this._mask = 1 << ordinal();
            this._defaultState = z;
        }

        public boolean enabledByDefault() {
            return this._defaultState;
        }

        public boolean enabledIn(int i) {
            return (this._mask & i) != 0;
        }

        public int getMask() {
            return this._mask;
        }
    }

    public enum NumberType {
        INT,
        LONG,
        BIG_INTEGER,
        FLOAT,
        DOUBLE,
        BIG_DECIMAL
    }

    public abstract void Ac();

    public abstract char[] Ad() throws IOException;

    public abstract int Ae() throws IOException;

    public abstract int Af() throws IOException;

    public abstract boolean Ag();

    public abstract Number Ah() throws IOException;

    public abstract NumberType Ai() throws IOException;

    public abstract long Al() throws IOException;

    public abstract BigInteger Am() throws IOException;

    public abstract float An() throws IOException;

    public abstract double Ao() throws IOException;

    public abstract BigDecimal Ap() throws IOException;

    public abstract Object Aq() throws IOException;

    public abstract boolean mo865a(JsonToken jsonToken);

    public abstract byte[] mo906a(Base64Variant base64Variant) throws IOException;

    public abstract String aY(String str) throws IOException;

    public abstract void close() throws IOException;

    public abstract boolean fn(int i);

    public abstract afa getCodec();

    public abstract int getIntValue() throws IOException;

    public abstract String getText() throws IOException;

    public abstract JsonToken zP() throws IOException, JsonParseException;

    public abstract JsonToken zQ() throws IOException, JsonParseException;

    public abstract JsonParser zT() throws IOException, JsonParseException;

    public abstract JsonToken zU();

    public abstract int zV();

    public abstract String zW() throws IOException;

    public abstract aez zX();

    public abstract JsonLocation zY();

    public abstract JsonLocation zZ();

    protected JsonParser() {
    }

    protected JsonParser(int i) {
        this.aLy = i;
    }

    public void bm(Object obj) {
        aez zX = zX();
        if (zX != null) {
            zX.bm(obj);
        }
    }

    public void mo905a(aex com_fossil_aex) {
        throw new UnsupportedOperationException("Parser of type " + getClass().getName() + " does not support schema of type '" + com_fossil_aex.zA() + "'");
    }

    public JsonParser mo887a(Feature feature) {
        this.aLy |= feature.getMask();
        return this;
    }

    public boolean isEnabled(Feature feature) {
        return feature.enabledIn(this.aLy);
    }

    public int zB() {
        return this.aLy;
    }

    public JsonParser fm(int i) {
        this.aLy = i;
        return this;
    }

    public String zR() throws IOException, JsonParseException {
        return zP() == JsonToken.FIELD_NAME ? zW() : null;
    }

    public String zS() throws IOException, JsonParseException {
        return zP() == JsonToken.VALUE_STRING ? getText() : null;
    }

    public boolean Aa() {
        return zU() == JsonToken.START_ARRAY;
    }

    public boolean Ab() {
        return zU() == JsonToken.START_OBJECT;
    }

    public byte Aj() throws IOException {
        int intValue = getIntValue();
        if (intValue >= -128 && intValue <= 255) {
            return (byte) intValue;
        }
        throw aZ("Numeric value (" + getText() + ") out of range of Java byte");
    }

    public short Ak() throws IOException {
        int intValue = getIntValue();
        if (intValue >= -32768 && intValue <= 32767) {
            return (short) intValue;
        }
        throw aZ("Numeric value (" + getText() + ") out of range of Java short");
    }

    public byte[] Ar() throws IOException {
        return mo906a(aew.zz());
    }

    public int mo904a(Base64Variant base64Variant, OutputStream outputStream) throws IOException {
        zO();
        return 0;
    }

    public int As() throws IOException {
        return fo(0);
    }

    public int fo(int i) throws IOException {
        return i;
    }

    public long At() throws IOException {
        return getValueAsLong(0);
    }

    public long getValueAsLong(long j) throws IOException {
        return j;
    }

    public String Au() throws IOException {
        return aY(null);
    }

    public boolean Av() {
        return false;
    }

    public boolean Aw() {
        return false;
    }

    public Object Ax() throws IOException {
        return null;
    }

    public Object Ay() throws IOException {
        return null;
    }

    protected JsonParseException aZ(String str) {
        return new JsonParseException(str, zZ());
    }

    protected void zO() {
        throw new UnsupportedOperationException("Operation not supported by parser of type " + getClass().getName());
    }
}
