package com.fasterxml.jackson.databind.deser.std;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fossil.aew;
import com.fossil.agy;
import com.fossil.ahh;
import com.fossil.ajs;
import com.fossil.amd.C1695a;
import com.fossil.amd.C1696b;
import com.fossil.amd.C1697c;
import com.fossil.amd.C1698d;
import com.fossil.amd.C1699e;
import com.fossil.amd.C1700f;
import com.fossil.amd.C1701g;
import java.io.IOException;

public abstract class PrimitiveArrayDeserializers<T> extends StdDeserializer<T> {

    @ahh
    static final class BooleanDeser extends PrimitiveArrayDeserializers<boolean[]> {
        private static final long serialVersionUID = 1;

        public BooleanDeser() {
            super(boolean[].class);
        }

        public boolean[] deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
            if (!jsonParser.Aa()) {
                return m2730b(jsonParser, deserializationContext);
            }
            C1695a Hc = deserializationContext.getArrayBuilders().Hc();
            int i = 0;
            Object obj = (boolean[]) Hc.Hs();
            while (jsonParser.zP() != JsonToken.END_ARRAY) {
                try {
                    int i2;
                    boolean _parseBooleanPrimitive = _parseBooleanPrimitive(jsonParser, deserializationContext);
                    if (i >= obj.length) {
                        obj = (boolean[]) Hc.m3834l(obj, i);
                        i2 = 0;
                    } else {
                        i2 = i;
                    }
                    i = i2 + 1;
                    obj[i2] = _parseBooleanPrimitive;
                } catch (Throwable e) {
                    throw JsonMappingException.wrapWithPath(e, obj, i + Hc.Hq());
                }
            }
            return (boolean[]) Hc.m3835m(obj, i);
        }

        private final boolean[] m2730b(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
            if (jsonParser.zU() == JsonToken.VALUE_STRING && deserializationContext.isEnabled(DeserializationFeature.ACCEPT_EMPTY_STRING_AS_NULL_OBJECT) && jsonParser.getText().length() == 0) {
                return null;
            }
            if (deserializationContext.isEnabled(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY)) {
                return new boolean[]{_parseBooleanPrimitive(jsonParser, deserializationContext)};
            }
            throw deserializationContext.mappingException(this._valueClass);
        }
    }

    @ahh
    static final class ByteDeser extends PrimitiveArrayDeserializers<byte[]> {
        private static final long serialVersionUID = 1;

        public ByteDeser() {
            super(byte[].class);
        }

        public byte[] deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
            JsonToken zU = jsonParser.zU();
            if (zU == JsonToken.VALUE_STRING) {
                return jsonParser.mo906a(deserializationContext.getBase64Variant());
            }
            if (zU == JsonToken.VALUE_EMBEDDED_OBJECT) {
                Object Aq = jsonParser.Aq();
                if (Aq == null) {
                    return null;
                }
                if (Aq instanceof byte[]) {
                    return (byte[]) Aq;
                }
            }
            if (!jsonParser.Aa()) {
                return m2731c(jsonParser, deserializationContext);
            }
            C1696b Hd = deserializationContext.getArrayBuilders().Hd();
            int i = 0;
            Object obj = (byte[]) Hd.Hs();
            while (true) {
                try {
                    zU = jsonParser.zP();
                    if (zU == JsonToken.END_ARRAY) {
                        return (byte[]) Hd.m3835m(obj, i);
                    }
                    byte Aj;
                    int i2;
                    if (zU == JsonToken.VALUE_NUMBER_INT || zU == JsonToken.VALUE_NUMBER_FLOAT) {
                        Aj = jsonParser.Aj();
                    } else if (zU != JsonToken.VALUE_NULL) {
                        throw deserializationContext.mappingException(this._valueClass.getComponentType());
                    } else {
                        Aj = (byte) 0;
                    }
                    if (i >= obj.length) {
                        obj = (byte[]) Hd.m3834l(obj, i);
                        i2 = 0;
                    } else {
                        i2 = i;
                    }
                    i = i2 + 1;
                    obj[i2] = Aj;
                } catch (Throwable e) {
                    throw JsonMappingException.wrapWithPath(e, obj, i + Hd.Hq());
                }
            }
        }

        private final byte[] m2731c(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
            if (jsonParser.zU() == JsonToken.VALUE_STRING && deserializationContext.isEnabled(DeserializationFeature.ACCEPT_EMPTY_STRING_AS_NULL_OBJECT) && jsonParser.getText().length() == 0) {
                return null;
            }
            if (deserializationContext.isEnabled(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY)) {
                byte Aj;
                JsonToken zU = jsonParser.zU();
                if (zU == JsonToken.VALUE_NUMBER_INT || zU == JsonToken.VALUE_NUMBER_FLOAT) {
                    Aj = jsonParser.Aj();
                } else if (zU != JsonToken.VALUE_NULL) {
                    throw deserializationContext.mappingException(this._valueClass.getComponentType());
                } else {
                    Aj = (byte) 0;
                }
                return new byte[]{Aj};
            }
            throw deserializationContext.mappingException(this._valueClass);
        }
    }

    @ahh
    static final class CharDeser extends PrimitiveArrayDeserializers<char[]> {
        private static final long serialVersionUID = 1;

        public CharDeser() {
            super(char[].class);
        }

        public char[] deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
            JsonToken zU = jsonParser.zU();
            Object obj;
            if (zU == JsonToken.VALUE_STRING) {
                Object Ad = jsonParser.Ad();
                int Af = jsonParser.Af();
                int Ae = jsonParser.Ae();
                obj = new char[Ae];
                System.arraycopy(Ad, Af, obj, 0, Ae);
                return obj;
            } else if (jsonParser.Aa()) {
                StringBuilder stringBuilder = new StringBuilder(64);
                while (true) {
                    JsonToken zP = jsonParser.zP();
                    if (zP == JsonToken.END_ARRAY) {
                        return stringBuilder.toString().toCharArray();
                    }
                    if (zP != JsonToken.VALUE_STRING) {
                        throw deserializationContext.mappingException(Character.TYPE);
                    }
                    String text = jsonParser.getText();
                    if (text.length() != 1) {
                        throw JsonMappingException.from(jsonParser, "Can not convert a JSON String of length " + text.length() + " into a char element of char array");
                    }
                    stringBuilder.append(text.charAt(0));
                }
            } else {
                if (zU == JsonToken.VALUE_EMBEDDED_OBJECT) {
                    obj = jsonParser.Aq();
                    if (obj == null) {
                        return null;
                    }
                    if (obj instanceof char[]) {
                        return (char[]) obj;
                    }
                    if (obj instanceof String) {
                        return ((String) obj).toCharArray();
                    }
                    if (obj instanceof byte[]) {
                        return aew.zz().encode((byte[]) obj, false).toCharArray();
                    }
                }
                throw deserializationContext.mappingException(this._valueClass);
            }
        }
    }

    @ahh
    static final class DoubleDeser extends PrimitiveArrayDeserializers<double[]> {
        private static final long serialVersionUID = 1;

        public DoubleDeser() {
            super(double[].class);
        }

        public double[] deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
            if (!jsonParser.Aa()) {
                return m2732d(jsonParser, deserializationContext);
            }
            C1697c Hi = deserializationContext.getArrayBuilders().Hi();
            int i = 0;
            Object obj = (double[]) Hi.Hs();
            while (jsonParser.zP() != JsonToken.END_ARRAY) {
                try {
                    int i2;
                    double _parseDoublePrimitive = _parseDoublePrimitive(jsonParser, deserializationContext);
                    if (i >= obj.length) {
                        obj = (double[]) Hi.m3834l(obj, i);
                        i2 = 0;
                    } else {
                        i2 = i;
                    }
                    i = i2 + 1;
                    obj[i2] = _parseDoublePrimitive;
                } catch (Throwable e) {
                    throw JsonMappingException.wrapWithPath(e, obj, i + Hi.Hq());
                }
            }
            return (double[]) Hi.m3835m(obj, i);
        }

        private final double[] m2732d(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
            if (jsonParser.zU() == JsonToken.VALUE_STRING && deserializationContext.isEnabled(DeserializationFeature.ACCEPT_EMPTY_STRING_AS_NULL_OBJECT) && jsonParser.getText().length() == 0) {
                return null;
            }
            if (deserializationContext.isEnabled(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY)) {
                return new double[]{_parseDoublePrimitive(jsonParser, deserializationContext)};
            }
            throw deserializationContext.mappingException(this._valueClass);
        }
    }

    @ahh
    static final class FloatDeser extends PrimitiveArrayDeserializers<float[]> {
        private static final long serialVersionUID = 1;

        public FloatDeser() {
            super(float[].class);
        }

        public float[] deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
            if (!jsonParser.Aa()) {
                return m2733e(jsonParser, deserializationContext);
            }
            C1698d Hh = deserializationContext.getArrayBuilders().Hh();
            int i = 0;
            Object obj = (float[]) Hh.Hs();
            while (jsonParser.zP() != JsonToken.END_ARRAY) {
                try {
                    int i2;
                    float _parseFloatPrimitive = _parseFloatPrimitive(jsonParser, deserializationContext);
                    if (i >= obj.length) {
                        obj = (float[]) Hh.m3834l(obj, i);
                        i2 = 0;
                    } else {
                        i2 = i;
                    }
                    i = i2 + 1;
                    obj[i2] = _parseFloatPrimitive;
                } catch (Throwable e) {
                    throw JsonMappingException.wrapWithPath(e, obj, i + Hh.Hq());
                }
            }
            return (float[]) Hh.m3835m(obj, i);
        }

        private final float[] m2733e(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
            if (jsonParser.zU() == JsonToken.VALUE_STRING && deserializationContext.isEnabled(DeserializationFeature.ACCEPT_EMPTY_STRING_AS_NULL_OBJECT) && jsonParser.getText().length() == 0) {
                return null;
            }
            if (deserializationContext.isEnabled(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY)) {
                return new float[]{_parseFloatPrimitive(jsonParser, deserializationContext)};
            }
            throw deserializationContext.mappingException(this._valueClass);
        }
    }

    @ahh
    static final class IntDeser extends PrimitiveArrayDeserializers<int[]> {
        public static final IntDeser instance = new IntDeser();
        private static final long serialVersionUID = 1;

        public IntDeser() {
            super(int[].class);
        }

        public int[] deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
            if (!jsonParser.Aa()) {
                return m2734f(jsonParser, deserializationContext);
            }
            C1699e Hf = deserializationContext.getArrayBuilders().Hf();
            int i = 0;
            Object obj = (int[]) Hf.Hs();
            while (jsonParser.zP() != JsonToken.END_ARRAY) {
                try {
                    int i2;
                    int _parseIntPrimitive = _parseIntPrimitive(jsonParser, deserializationContext);
                    if (i >= obj.length) {
                        obj = (int[]) Hf.m3834l(obj, i);
                        i2 = 0;
                    } else {
                        i2 = i;
                    }
                    i = i2 + 1;
                    obj[i2] = _parseIntPrimitive;
                } catch (Throwable e) {
                    throw JsonMappingException.wrapWithPath(e, obj, i + Hf.Hq());
                }
            }
            return (int[]) Hf.m3835m(obj, i);
        }

        private final int[] m2734f(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
            if (jsonParser.zU() == JsonToken.VALUE_STRING && deserializationContext.isEnabled(DeserializationFeature.ACCEPT_EMPTY_STRING_AS_NULL_OBJECT) && jsonParser.getText().length() == 0) {
                return null;
            }
            if (deserializationContext.isEnabled(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY)) {
                return new int[]{_parseIntPrimitive(jsonParser, deserializationContext)};
            }
            throw deserializationContext.mappingException(this._valueClass);
        }
    }

    @ahh
    static final class LongDeser extends PrimitiveArrayDeserializers<long[]> {
        public static final LongDeser instance = new LongDeser();
        private static final long serialVersionUID = 1;

        public LongDeser() {
            super(long[].class);
        }

        public long[] deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
            if (!jsonParser.Aa()) {
                return m2735g(jsonParser, deserializationContext);
            }
            C1700f Hg = deserializationContext.getArrayBuilders().Hg();
            int i = 0;
            Object obj = (long[]) Hg.Hs();
            while (jsonParser.zP() != JsonToken.END_ARRAY) {
                try {
                    int i2;
                    long _parseLongPrimitive = _parseLongPrimitive(jsonParser, deserializationContext);
                    if (i >= obj.length) {
                        obj = (long[]) Hg.m3834l(obj, i);
                        i2 = 0;
                    } else {
                        i2 = i;
                    }
                    i = i2 + 1;
                    obj[i2] = _parseLongPrimitive;
                } catch (Throwable e) {
                    throw JsonMappingException.wrapWithPath(e, obj, i + Hg.Hq());
                }
            }
            return (long[]) Hg.m3835m(obj, i);
        }

        private final long[] m2735g(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
            if (jsonParser.zU() == JsonToken.VALUE_STRING && deserializationContext.isEnabled(DeserializationFeature.ACCEPT_EMPTY_STRING_AS_NULL_OBJECT) && jsonParser.getText().length() == 0) {
                return null;
            }
            if (deserializationContext.isEnabled(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY)) {
                return new long[]{_parseLongPrimitive(jsonParser, deserializationContext)};
            }
            throw deserializationContext.mappingException(this._valueClass);
        }
    }

    @ahh
    static final class ShortDeser extends PrimitiveArrayDeserializers<short[]> {
        private static final long serialVersionUID = 1;

        public ShortDeser() {
            super(short[].class);
        }

        public short[] deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
            if (!jsonParser.Aa()) {
                return m2736h(jsonParser, deserializationContext);
            }
            C1701g He = deserializationContext.getArrayBuilders().He();
            int i = 0;
            Object obj = (short[]) He.Hs();
            while (jsonParser.zP() != JsonToken.END_ARRAY) {
                try {
                    int i2;
                    short _parseShortPrimitive = _parseShortPrimitive(jsonParser, deserializationContext);
                    if (i >= obj.length) {
                        obj = (short[]) He.m3834l(obj, i);
                        i2 = 0;
                    } else {
                        i2 = i;
                    }
                    i = i2 + 1;
                    obj[i2] = _parseShortPrimitive;
                } catch (Throwable e) {
                    throw JsonMappingException.wrapWithPath(e, obj, i + He.Hq());
                }
            }
            return (short[]) He.m3835m(obj, i);
        }

        private final short[] m2736h(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
            if (jsonParser.zU() == JsonToken.VALUE_STRING && deserializationContext.isEnabled(DeserializationFeature.ACCEPT_EMPTY_STRING_AS_NULL_OBJECT) && jsonParser.getText().length() == 0) {
                return null;
            }
            if (deserializationContext.isEnabled(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY)) {
                return new short[]{_parseShortPrimitive(jsonParser, deserializationContext)};
            }
            throw deserializationContext.mappingException(this._valueClass);
        }
    }

    protected PrimitiveArrayDeserializers(Class<T> cls) {
        super((Class) cls);
    }

    public static agy<?> forType(Class<?> cls) {
        if (cls == Integer.TYPE) {
            return IntDeser.instance;
        }
        if (cls == Long.TYPE) {
            return LongDeser.instance;
        }
        if (cls == Byte.TYPE) {
            return new ByteDeser();
        }
        if (cls == Short.TYPE) {
            return new ShortDeser();
        }
        if (cls == Float.TYPE) {
            return new FloatDeser();
        }
        if (cls == Double.TYPE) {
            return new DoubleDeser();
        }
        if (cls == Boolean.TYPE) {
            return new BooleanDeser();
        }
        if (cls == Character.TYPE) {
            return new CharDeser();
        }
        throw new IllegalStateException();
    }

    public Object deserializeWithType(JsonParser jsonParser, DeserializationContext deserializationContext, ajs com_fossil_ajs) throws IOException {
        return com_fossil_ajs.deserializeTypedFromArray(jsonParser, deserializationContext);
    }
}
