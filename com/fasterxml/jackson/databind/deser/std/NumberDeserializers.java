package com.fasterxml.jackson.databind.deser.std;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fossil.agy;
import com.fossil.ahh;
import com.fossil.ajs;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.HashSet;

public class NumberDeserializers {
    private static final HashSet<String> aSd = new HashSet();

    @ahh
    public static class BigDecimalDeserializer extends StdScalarDeserializer<BigDecimal> {
        public static final BigDecimalDeserializer instance = new BigDecimalDeserializer();

        public BigDecimalDeserializer() {
            super(BigDecimal.class);
        }

        public BigDecimal deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
            switch (jsonParser.zV()) {
                case 3:
                    if (deserializationContext.isEnabled(DeserializationFeature.UNWRAP_SINGLE_VALUE_ARRAYS)) {
                        jsonParser.zP();
                        BigDecimal deserialize = deserialize(jsonParser, deserializationContext);
                        if (jsonParser.zP() == JsonToken.END_ARRAY) {
                            return deserialize;
                        }
                        throw deserializationContext.wrongTokenException(jsonParser, JsonToken.END_ARRAY, "Attempted to unwrap single value array for single 'BigDecimal' value but there was more than a single value in the array");
                    }
                    break;
                case 6:
                    String trim = jsonParser.getText().trim();
                    if (trim.length() == 0) {
                        return null;
                    }
                    try {
                        return new BigDecimal(trim);
                    } catch (IllegalArgumentException e) {
                        throw deserializationContext.weirdStringException(trim, this._valueClass, "not a valid representation");
                    }
                case 7:
                case 8:
                    return jsonParser.Ap();
            }
            throw deserializationContext.mappingException(this._valueClass, jsonParser.zU());
        }
    }

    @ahh
    public static class BigIntegerDeserializer extends StdScalarDeserializer<BigInteger> {
        public static final BigIntegerDeserializer instance = new BigIntegerDeserializer();

        public BigIntegerDeserializer() {
            super(BigInteger.class);
        }

        public BigInteger deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
            switch (jsonParser.zV()) {
                case 3:
                    if (deserializationContext.isEnabled(DeserializationFeature.UNWRAP_SINGLE_VALUE_ARRAYS)) {
                        jsonParser.zP();
                        BigInteger deserialize = deserialize(jsonParser, deserializationContext);
                        if (jsonParser.zP() == JsonToken.END_ARRAY) {
                            return deserialize;
                        }
                        throw deserializationContext.wrongTokenException(jsonParser, JsonToken.END_ARRAY, "Attempted to unwrap single value array for single 'BigInteger' value but there was more than a single value in the array");
                    }
                    break;
                case 6:
                    String trim = jsonParser.getText().trim();
                    if (trim.length() == 0) {
                        return null;
                    }
                    try {
                        return new BigInteger(trim);
                    } catch (IllegalArgumentException e) {
                        throw deserializationContext.weirdStringException(trim, this._valueClass, "not a valid representation");
                    }
                case 7:
                    switch (jsonParser.Ai()) {
                        case INT:
                        case LONG:
                        case BIG_INTEGER:
                            return jsonParser.Am();
                        default:
                            break;
                    }
                case 8:
                    if (!deserializationContext.isEnabled(DeserializationFeature.ACCEPT_FLOAT_AS_INT)) {
                        _failDoubleToIntCoercion(jsonParser, deserializationContext, "java.math.BigInteger");
                    }
                    return jsonParser.Ap().toBigInteger();
            }
            throw deserializationContext.mappingException(this._valueClass, jsonParser.zU());
        }
    }

    public static abstract class PrimitiveOrWrapperDeserializer<T> extends StdScalarDeserializer<T> {
        private static final long serialVersionUID = 1;
        protected final T _nullValue;
        protected final boolean _primitive;

        protected PrimitiveOrWrapperDeserializer(Class<T> cls, T t) {
            super((Class) cls);
            this._nullValue = t;
            this._primitive = cls.isPrimitive();
        }

        public final T getNullValue(DeserializationContext deserializationContext) throws JsonMappingException {
            if (!this._primitive || !deserializationContext.isEnabled(DeserializationFeature.FAIL_ON_NULL_FOR_PRIMITIVES)) {
                return this._nullValue;
            }
            throw deserializationContext.mappingException("Can not map JSON null into type %s (set DeserializationConfig.DeserializationFeature.FAIL_ON_NULL_FOR_PRIMITIVES to 'false' to allow)", handledType().toString());
        }

        @Deprecated
        public final T getNullValue() {
            return this._nullValue;
        }
    }

    @ahh
    public static final class BooleanDeserializer extends PrimitiveOrWrapperDeserializer<Boolean> {
        static final BooleanDeserializer primitiveInstance = new BooleanDeserializer(Boolean.TYPE, Boolean.FALSE);
        private static final long serialVersionUID = 1;
        static final BooleanDeserializer wrapperInstance = new BooleanDeserializer(Boolean.class, null);

        public BooleanDeserializer(Class<Boolean> cls, Boolean bool) {
            super(cls, bool);
        }

        public Boolean deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
            return _parseBoolean(jsonParser, deserializationContext);
        }

        public Boolean deserializeWithType(JsonParser jsonParser, DeserializationContext deserializationContext, ajs com_fossil_ajs) throws IOException {
            return _parseBoolean(jsonParser, deserializationContext);
        }
    }

    @ahh
    public static class ByteDeserializer extends PrimitiveOrWrapperDeserializer<Byte> {
        static final ByteDeserializer primitiveInstance = new ByteDeserializer(Byte.TYPE, Byte.valueOf((byte) 0));
        private static final long serialVersionUID = 1;
        static final ByteDeserializer wrapperInstance = new ByteDeserializer(Byte.class, null);

        public ByteDeserializer(Class<Byte> cls, Byte b) {
            super(cls, b);
        }

        public Byte deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
            return _parseByte(jsonParser, deserializationContext);
        }
    }

    @ahh
    public static class CharacterDeserializer extends PrimitiveOrWrapperDeserializer<Character> {
        static final CharacterDeserializer primitiveInstance = new CharacterDeserializer(Character.TYPE, Character.valueOf('\u0000'));
        private static final long serialVersionUID = 1;
        static final CharacterDeserializer wrapperInstance = new CharacterDeserializer(Character.class, null);

        public CharacterDeserializer(Class<Character> cls, Character ch) {
            super(cls, ch);
        }

        public Character deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
            switch (jsonParser.zV()) {
                case 3:
                    if (deserializationContext.isEnabled(DeserializationFeature.UNWRAP_SINGLE_VALUE_ARRAYS)) {
                        jsonParser.zP();
                        Character deserialize = deserialize(jsonParser, deserializationContext);
                        if (jsonParser.zP() == JsonToken.END_ARRAY) {
                            return deserialize;
                        }
                        throw deserializationContext.wrongTokenException(jsonParser, JsonToken.END_ARRAY, "Attempted to unwrap single value array for single '" + this._valueClass.getName() + "' value but there was more than a single value in the array");
                    }
                    break;
                case 6:
                    String text = jsonParser.getText();
                    if (text.length() == 1) {
                        return Character.valueOf(text.charAt(0));
                    }
                    if (text.length() == 0) {
                        return (Character) getEmptyValue(deserializationContext);
                    }
                    break;
                case 7:
                    int intValue = jsonParser.getIntValue();
                    if (intValue >= 0 && intValue <= 65535) {
                        return Character.valueOf((char) intValue);
                    }
            }
            throw deserializationContext.mappingException(this._valueClass, jsonParser.zU());
        }
    }

    @ahh
    public static class DoubleDeserializer extends PrimitiveOrWrapperDeserializer<Double> {
        static final DoubleDeserializer primitiveInstance = new DoubleDeserializer(Double.TYPE, Double.valueOf(0.0d));
        private static final long serialVersionUID = 1;
        static final DoubleDeserializer wrapperInstance = new DoubleDeserializer(Double.class, null);

        public DoubleDeserializer(Class<Double> cls, Double d) {
            super(cls, d);
        }

        public Double deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
            return _parseDouble(jsonParser, deserializationContext);
        }

        public Double deserializeWithType(JsonParser jsonParser, DeserializationContext deserializationContext, ajs com_fossil_ajs) throws IOException {
            return _parseDouble(jsonParser, deserializationContext);
        }
    }

    @ahh
    public static class FloatDeserializer extends PrimitiveOrWrapperDeserializer<Float> {
        static final FloatDeserializer primitiveInstance = new FloatDeserializer(Float.TYPE, Float.valueOf(0.0f));
        private static final long serialVersionUID = 1;
        static final FloatDeserializer wrapperInstance = new FloatDeserializer(Float.class, null);

        public FloatDeserializer(Class<Float> cls, Float f) {
            super(cls, f);
        }

        public Float deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
            return _parseFloat(jsonParser, deserializationContext);
        }
    }

    @ahh
    public static final class IntegerDeserializer extends PrimitiveOrWrapperDeserializer<Integer> {
        static final IntegerDeserializer primitiveInstance = new IntegerDeserializer(Integer.TYPE, Integer.valueOf(0));
        private static final long serialVersionUID = 1;
        static final IntegerDeserializer wrapperInstance = new IntegerDeserializer(Integer.class, null);

        public IntegerDeserializer(Class<Integer> cls, Integer num) {
            super(cls, num);
        }

        public boolean isCachable() {
            return true;
        }

        public Integer deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
            if (jsonParser.mo865a(JsonToken.VALUE_NUMBER_INT)) {
                return Integer.valueOf(jsonParser.getIntValue());
            }
            return _parseInteger(jsonParser, deserializationContext);
        }

        public Integer deserializeWithType(JsonParser jsonParser, DeserializationContext deserializationContext, ajs com_fossil_ajs) throws IOException {
            if (jsonParser.mo865a(JsonToken.VALUE_NUMBER_INT)) {
                return Integer.valueOf(jsonParser.getIntValue());
            }
            return _parseInteger(jsonParser, deserializationContext);
        }
    }

    @ahh
    public static final class LongDeserializer extends PrimitiveOrWrapperDeserializer<Long> {
        static final LongDeserializer primitiveInstance = new LongDeserializer(Long.TYPE, Long.valueOf(0));
        private static final long serialVersionUID = 1;
        static final LongDeserializer wrapperInstance = new LongDeserializer(Long.class, null);

        public LongDeserializer(Class<Long> cls, Long l) {
            super(cls, l);
        }

        public boolean isCachable() {
            return true;
        }

        public Long deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
            if (jsonParser.mo865a(JsonToken.VALUE_NUMBER_INT)) {
                return Long.valueOf(jsonParser.Al());
            }
            return _parseLong(jsonParser, deserializationContext);
        }
    }

    @ahh
    public static class NumberDeserializer extends StdScalarDeserializer<Object> {
        public static final NumberDeserializer instance = new NumberDeserializer();

        public NumberDeserializer() {
            super(Number.class);
        }

        public Object deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
            switch (jsonParser.zV()) {
                case 3:
                    if (deserializationContext.isEnabled(DeserializationFeature.UNWRAP_SINGLE_VALUE_ARRAYS)) {
                        jsonParser.zP();
                        Object deserialize = deserialize(jsonParser, deserializationContext);
                        if (jsonParser.zP() == JsonToken.END_ARRAY) {
                            return deserialize;
                        }
                        throw deserializationContext.wrongTokenException(jsonParser, JsonToken.END_ARRAY, "Attempted to unwrap single value array for single '" + this._valueClass.getName() + "' value but there was more than a single value in the array");
                    }
                    break;
                case 6:
                    String trim = jsonParser.getText().trim();
                    if (trim.length() == 0) {
                        return getEmptyValue(deserializationContext);
                    }
                    if (_hasTextualNull(trim)) {
                        return getNullValue(deserializationContext);
                    }
                    if (_isPosInf(trim)) {
                        return Double.valueOf(Double.POSITIVE_INFINITY);
                    }
                    if (_isNegInf(trim)) {
                        return Double.valueOf(Double.NEGATIVE_INFINITY);
                    }
                    if (_isNaN(trim)) {
                        return Double.valueOf(Double.NaN);
                    }
                    try {
                        if (_isIntNumber(trim)) {
                            if (deserializationContext.isEnabled(DeserializationFeature.USE_BIG_INTEGER_FOR_INTS)) {
                                return new BigInteger(trim);
                            }
                            long parseLong = Long.parseLong(trim);
                            if (deserializationContext.isEnabled(DeserializationFeature.USE_LONG_FOR_INTS) || parseLong > 2147483647L || parseLong < -2147483648L) {
                                return Long.valueOf(parseLong);
                            }
                            return Integer.valueOf((int) parseLong);
                        } else if (deserializationContext.isEnabled(DeserializationFeature.USE_BIG_DECIMAL_FOR_FLOATS)) {
                            return new BigDecimal(trim);
                        } else {
                            return new Double(trim);
                        }
                    } catch (IllegalArgumentException e) {
                        throw deserializationContext.weirdStringException(trim, this._valueClass, "not a valid number");
                    }
                case 7:
                    if (deserializationContext.hasSomeOfFeatures(F_MASK_INT_COERCIONS)) {
                        return _coerceIntegral(jsonParser, deserializationContext);
                    }
                    return jsonParser.Ah();
                case 8:
                    if (deserializationContext.isEnabled(DeserializationFeature.USE_BIG_DECIMAL_FOR_FLOATS)) {
                        return jsonParser.Ap();
                    }
                    return Double.valueOf(jsonParser.Ao());
            }
            throw deserializationContext.mappingException(this._valueClass, jsonParser.zU());
        }

        public Object deserializeWithType(JsonParser jsonParser, DeserializationContext deserializationContext, ajs com_fossil_ajs) throws IOException {
            switch (jsonParser.zV()) {
                case 6:
                case 7:
                case 8:
                    return deserialize(jsonParser, deserializationContext);
                default:
                    return com_fossil_ajs.deserializeTypedFromScalar(jsonParser, deserializationContext);
            }
        }
    }

    @ahh
    public static class ShortDeserializer extends PrimitiveOrWrapperDeserializer<Short> {
        static final ShortDeserializer primitiveInstance = new ShortDeserializer(Short.TYPE, Short.valueOf((short) 0));
        private static final long serialVersionUID = 1;
        static final ShortDeserializer wrapperInstance = new ShortDeserializer(Short.class, null);

        public ShortDeserializer(Class<Short> cls, Short sh) {
            super(cls, sh);
        }

        public Short deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
            return _parseShort(jsonParser, deserializationContext);
        }
    }

    static {
        int i = 0;
        Class[] clsArr = new Class[]{Boolean.class, Byte.class, Short.class, Character.class, Integer.class, Long.class, Float.class, Double.class, Number.class, BigDecimal.class, BigInteger.class};
        int length = clsArr.length;
        while (i < length) {
            aSd.add(clsArr[i].getName());
            i++;
        }
    }

    public static agy<?> m2728a(Class<?> cls, String str) {
        if (cls.isPrimitive()) {
            if (cls == Integer.TYPE) {
                return IntegerDeserializer.primitiveInstance;
            }
            if (cls == Boolean.TYPE) {
                return BooleanDeserializer.primitiveInstance;
            }
            if (cls == Long.TYPE) {
                return LongDeserializer.primitiveInstance;
            }
            if (cls == Double.TYPE) {
                return DoubleDeserializer.primitiveInstance;
            }
            if (cls == Character.TYPE) {
                return CharacterDeserializer.primitiveInstance;
            }
            if (cls == Byte.TYPE) {
                return ByteDeserializer.primitiveInstance;
            }
            if (cls == Short.TYPE) {
                return ShortDeserializer.primitiveInstance;
            }
            if (cls == Float.TYPE) {
                return FloatDeserializer.primitiveInstance;
            }
        } else if (!aSd.contains(str)) {
            return null;
        } else {
            if (cls == Integer.class) {
                return IntegerDeserializer.wrapperInstance;
            }
            if (cls == Boolean.class) {
                return BooleanDeserializer.wrapperInstance;
            }
            if (cls == Long.class) {
                return LongDeserializer.wrapperInstance;
            }
            if (cls == Double.class) {
                return DoubleDeserializer.wrapperInstance;
            }
            if (cls == Character.class) {
                return CharacterDeserializer.wrapperInstance;
            }
            if (cls == Byte.class) {
                return ByteDeserializer.wrapperInstance;
            }
            if (cls == Short.class) {
                return ShortDeserializer.wrapperInstance;
            }
            if (cls == Float.class) {
                return FloatDeserializer.wrapperInstance;
            }
            if (cls == Number.class) {
                return NumberDeserializer.instance;
            }
            if (cls == BigDecimal.class) {
                return BigDecimalDeserializer.instance;
            }
            if (cls == BigInteger.class) {
                return BigIntegerDeserializer.instance;
            }
        }
        throw new IllegalArgumentException("Internal error: can't find deserializer for " + cls.getName());
    }
}
