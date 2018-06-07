package com.fasterxml.jackson.core;

import com.fasterxml.jackson.core.JsonParser.NumberType;
import com.fasterxml.jackson.core.io.CharacterEscapes;
import com.fossil.aew;
import com.fossil.aex;
import com.fossil.aez;
import com.fossil.afb;
import com.fossil.afc;
import com.fossil.ags;
import java.io.Closeable;
import java.io.Flushable;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

public abstract class JsonGenerator implements Closeable, Flushable {
    protected afb aLw;

    public enum Feature {
        AUTO_CLOSE_TARGET(true),
        AUTO_CLOSE_JSON_CONTENT(true),
        FLUSH_PASSED_TO_STREAM(true),
        QUOTE_FIELD_NAMES(true),
        QUOTE_NON_NUMERIC_NUMBERS(true),
        WRITE_NUMBERS_AS_STRINGS(false),
        WRITE_BIGDECIMAL_AS_PLAIN(false),
        ESCAPE_NON_ASCII(false),
        STRICT_DUPLICATE_DETECTION(false),
        IGNORE_UNKNOWN(false);
        
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
            this._defaultState = z;
            this._mask = 1 << ordinal();
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

    public abstract void mo933J(long j) throws IOException;

    public abstract void mo934T(float f) throws IOException;

    public abstract int mo847a(Base64Variant base64Variant, InputStream inputStream, int i) throws IOException;

    public abstract JsonGenerator mo848a(Feature feature);

    public abstract void mo935a(char c) throws IOException;

    public abstract void mo936a(Base64Variant base64Variant, byte[] bArr, int i, int i2) throws IOException;

    public abstract void mo937a(BigDecimal bigDecimal) throws IOException;

    public abstract void mo938a(BigInteger bigInteger) throws IOException;

    public abstract void mo939a(char[] cArr, int i, int i2) throws IOException;

    public abstract void aQ(String str) throws IOException;

    public abstract void aR(String str) throws IOException;

    public abstract void aS(String str) throws IOException;

    public abstract void aT(String str) throws IOException;

    public abstract void mo850b(afc com_fossil_afc) throws IOException;

    public abstract void mo943b(char[] cArr, int i, int i2) throws IOException;

    public abstract void mo852c(afc com_fossil_afc) throws IOException;

    public abstract void close() throws IOException;

    public abstract void mo945d(double d) throws IOException;

    public abstract JsonGenerator fi(int i);

    public abstract void fl(int i) throws IOException;

    public abstract void flush() throws IOException;

    public abstract void writeBoolean(boolean z) throws IOException;

    public abstract void writeObject(Object obj) throws IOException;

    public abstract void writeString(String str) throws IOException;

    public abstract int zB();

    public abstract void zH() throws IOException;

    public abstract void zI() throws IOException;

    public abstract void zJ() throws IOException;

    public abstract void zK() throws IOException;

    public abstract void zL() throws IOException;

    public abstract aez zM();

    protected JsonGenerator() {
    }

    public void m2669a(aex com_fossil_aex) {
        throw new UnsupportedOperationException("Generator of type " + getClass().getName() + " does not support schema of type '" + com_fossil_aex.zA() + "'");
    }

    public JsonGenerator m2664a(afb com_fossil_afb) {
        this.aLw = com_fossil_afb;
        return this;
    }

    public afb zC() {
        return this.aLw;
    }

    public JsonGenerator fj(int i) {
        return this;
    }

    public JsonGenerator mo921a(CharacterEscapes characterEscapes) {
        return this;
    }

    public JsonGenerator mo922a(afc com_fossil_afc) {
        throw new UnsupportedOperationException();
    }

    public void bm(Object obj) {
        aez zM = zM();
        if (zM != null) {
            zM.bm(obj);
        }
    }

    public boolean zD() {
        return false;
    }

    public boolean zE() {
        return false;
    }

    public boolean zF() {
        return false;
    }

    public boolean zG() {
        return true;
    }

    public void fk(int i) throws IOException {
        zH();
    }

    public void mo946d(afc com_fossil_afc) throws IOException {
        aR(com_fossil_afc.getValue());
    }

    public void mo854e(afc com_fossil_afc) throws IOException {
        aS(com_fossil_afc.getValue());
    }

    public void m2680d(byte[] bArr, int i, int i2) throws IOException {
        mo936a(aew.zz(), bArr, i, i2);
    }

    public void m2659R(byte[] bArr) throws IOException {
        mo936a(aew.zz(), bArr, 0, bArr.length);
    }

    public int m2673b(InputStream inputStream, int i) throws IOException {
        return mo847a(aew.zz(), inputStream, i);
    }

    public void mo947f(short s) throws IOException {
        fl(s);
    }

    public void bn(Object obj) throws IOException {
        throw new JsonGenerationException("No native support for writing Object Ids");
    }

    public void bo(Object obj) throws IOException {
        throw new JsonGenerationException("No native support for writing Object Ids");
    }

    public void bp(Object obj) throws IOException {
        throw new JsonGenerationException("No native support for writing Type Ids");
    }

    public void mo924r(String str, String str2) throws IOException {
        aQ(str);
        writeString(str2);
    }

    public final void aU(String str) throws IOException {
        aQ(str);
        zH();
    }

    public final void aV(String str) throws IOException {
        aQ(str);
        zJ();
    }

    public void aW(String str) throws IOException {
    }

    public void mo1096a(JsonParser jsonParser) throws IOException {
        JsonToken zU = jsonParser.zU();
        if (zU == null) {
            aX("No current event to copy");
        }
        NumberType Ai;
        switch (zU.id()) {
            case -1:
                aX("No current event to copy");
                break;
            case 1:
                break;
            case 2:
                zK();
                return;
            case 3:
                zH();
                return;
            case 4:
                zI();
                return;
            case 5:
                aQ(jsonParser.zW());
                return;
            case 6:
                if (jsonParser.Ag()) {
                    mo939a(jsonParser.Ad(), jsonParser.Af(), jsonParser.Ae());
                    return;
                } else {
                    writeString(jsonParser.getText());
                    return;
                }
            case 7:
                Ai = jsonParser.Ai();
                if (Ai == NumberType.INT) {
                    fl(jsonParser.getIntValue());
                    return;
                } else if (Ai == NumberType.BIG_INTEGER) {
                    mo938a(jsonParser.Am());
                    return;
                } else {
                    mo933J(jsonParser.Al());
                    return;
                }
            case 8:
                Ai = jsonParser.Ai();
                if (Ai == NumberType.BIG_DECIMAL) {
                    mo937a(jsonParser.Ap());
                    return;
                } else if (Ai == NumberType.FLOAT) {
                    mo934T(jsonParser.An());
                    return;
                } else {
                    mo945d(jsonParser.Ao());
                    return;
                }
            case 9:
                writeBoolean(true);
                return;
            case 10:
                writeBoolean(false);
                return;
            case 11:
                zL();
                return;
            case 12:
                writeObject(jsonParser.Aq());
                return;
            default:
                zN();
                return;
        }
        zJ();
    }

    public void mo1097b(JsonParser jsonParser) throws IOException {
        JsonToken zU = jsonParser.zU();
        if (zU == null) {
            aX("No current event to copy");
        }
        int id = zU.id();
        if (id == 5) {
            aQ(jsonParser.zW());
            id = jsonParser.zP().id();
        }
        switch (id) {
            case 1:
                zJ();
                while (jsonParser.zP() != JsonToken.END_OBJECT) {
                    mo1097b(jsonParser);
                }
                zK();
                return;
            case 3:
                zH();
                while (jsonParser.zP() != JsonToken.END_ARRAY) {
                    mo1097b(jsonParser);
                }
                zI();
                return;
            default:
                mo1096a(jsonParser);
                return;
        }
    }

    protected void aX(String str) throws JsonGenerationException {
        throw new JsonGenerationException(str);
    }

    protected final void zN() {
        ags.Dk();
    }

    public void zO() {
        throw new UnsupportedOperationException("Operation not supported by generator of type " + getClass().getName());
    }

    protected void bq(Object obj) throws IOException {
        if (obj == null) {
            zL();
        } else if (obj instanceof String) {
            writeString((String) obj);
        } else {
            if (obj instanceof Number) {
                Number number = (Number) obj;
                if (number instanceof Integer) {
                    fl(number.intValue());
                    return;
                } else if (number instanceof Long) {
                    mo933J(number.longValue());
                    return;
                } else if (number instanceof Double) {
                    mo945d(number.doubleValue());
                    return;
                } else if (number instanceof Float) {
                    mo934T(number.floatValue());
                    return;
                } else if (number instanceof Short) {
                    mo947f(number.shortValue());
                    return;
                } else if (number instanceof Byte) {
                    mo947f((short) number.byteValue());
                    return;
                } else if (number instanceof BigInteger) {
                    mo938a((BigInteger) number);
                    return;
                } else if (number instanceof BigDecimal) {
                    mo937a((BigDecimal) number);
                    return;
                } else if (number instanceof AtomicInteger) {
                    fl(((AtomicInteger) number).get());
                    return;
                } else if (number instanceof AtomicLong) {
                    mo933J(((AtomicLong) number).get());
                    return;
                }
            } else if (obj instanceof byte[]) {
                m2659R((byte[]) obj);
                return;
            } else if (obj instanceof Boolean) {
                writeBoolean(((Boolean) obj).booleanValue());
                return;
            } else if (obj instanceof AtomicBoolean) {
                writeBoolean(((AtomicBoolean) obj).get());
                return;
            }
            throw new IllegalStateException("No ObjectCodec defined for the generator, can only serialize simple wrapper types (type passed " + obj.getClass().getName() + ")");
        }
    }
}
