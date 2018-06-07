package com.fasterxml.jackson.databind.deser.std;

import com.facebook.appevents.AppEventsConstants;
import com.facebook.internal.ServerProtocol;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonParser.NumberType;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.AnnotationIntrospector;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.introspect.AnnotatedMember;
import com.fossil.afr;
import com.fossil.agv;
import com.fossil.agy;
import com.fossil.ahc;
import com.fossil.ajs;
import com.fossil.ami;
import com.fossil.amk;
import java.io.IOException;
import java.io.Serializable;
import java.util.Date;

public abstract class StdDeserializer<T> extends agy<T> implements Serializable {
    protected static final int F_MASK_INT_COERCIONS = (DeserializationFeature.USE_BIG_INTEGER_FOR_INTS.getMask() | DeserializationFeature.USE_LONG_FOR_INTS.getMask());
    private static final long serialVersionUID = 1;
    protected final Class<?> _valueClass;

    protected StdDeserializer(Class<?> cls) {
        this._valueClass = cls;
    }

    protected StdDeserializer(JavaType javaType) {
        this._valueClass = javaType == null ? null : javaType.getRawClass();
    }

    protected StdDeserializer(StdDeserializer<?> stdDeserializer) {
        this._valueClass = stdDeserializer._valueClass;
    }

    public Class<?> handledType() {
        return this._valueClass;
    }

    @Deprecated
    public final Class<?> getValueClass() {
        return this._valueClass;
    }

    public JavaType getValueType() {
        return null;
    }

    protected boolean isDefaultDeserializer(agy<?> com_fossil_agy_) {
        return ami.bG(com_fossil_agy_);
    }

    protected boolean isDefaultKeyDeserializer(ahc com_fossil_ahc) {
        return ami.bG(com_fossil_ahc);
    }

    public Object deserializeWithType(JsonParser jsonParser, DeserializationContext deserializationContext, ajs com_fossil_ajs) throws IOException {
        return com_fossil_ajs.deserializeTypedFromAny(jsonParser, deserializationContext);
    }

    protected final boolean _parseBooleanPrimitive(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
        boolean z = true;
        JsonToken zU = jsonParser.zU();
        if (zU == JsonToken.VALUE_TRUE) {
            return true;
        }
        if (zU == JsonToken.VALUE_FALSE || zU == JsonToken.VALUE_NULL) {
            return false;
        }
        if (zU == JsonToken.VALUE_NUMBER_INT) {
            if (jsonParser.Ai() != NumberType.INT) {
                return _parseBooleanFromNumber(jsonParser, deserializationContext);
            }
            if (jsonParser.getIntValue() == 0) {
                z = false;
            }
            return z;
        } else if (zU == JsonToken.VALUE_STRING) {
            String trim = jsonParser.getText().trim();
            if (ServerProtocol.DIALOG_RETURN_SCOPES_TRUE.equals(trim) || "True".equals(trim)) {
                return true;
            }
            if ("false".equals(trim) || "False".equals(trim) || trim.length() == 0 || _hasTextualNull(trim)) {
                return false;
            }
            throw deserializationContext.weirdStringException(trim, this._valueClass, "only \"true\" or \"false\" recognized");
        } else if (zU == JsonToken.START_ARRAY && deserializationContext.isEnabled(DeserializationFeature.UNWRAP_SINGLE_VALUE_ARRAYS)) {
            jsonParser.zP();
            boolean _parseBooleanPrimitive = _parseBooleanPrimitive(jsonParser, deserializationContext);
            if (jsonParser.zP() == JsonToken.END_ARRAY) {
                return _parseBooleanPrimitive;
            }
            throw deserializationContext.wrongTokenException(jsonParser, JsonToken.END_ARRAY, "Attempted to unwrap single value array for single 'boolean' value but there was more than a single value in the array");
        } else {
            throw deserializationContext.mappingException(this._valueClass, zU);
        }
    }

    protected final Boolean _parseBoolean(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
        JsonToken zU = jsonParser.zU();
        if (zU == JsonToken.VALUE_TRUE) {
            return Boolean.TRUE;
        }
        if (zU == JsonToken.VALUE_FALSE) {
            return Boolean.FALSE;
        }
        if (zU == JsonToken.VALUE_NUMBER_INT) {
            if (jsonParser.Ai() == NumberType.INT) {
                return jsonParser.getIntValue() == 0 ? Boolean.FALSE : Boolean.TRUE;
            } else {
                return Boolean.valueOf(_parseBooleanFromNumber(jsonParser, deserializationContext));
            }
        } else if (zU == JsonToken.VALUE_NULL) {
            return (Boolean) getNullValue(deserializationContext);
        } else {
            if (zU == JsonToken.VALUE_STRING) {
                String trim = jsonParser.getText().trim();
                if (ServerProtocol.DIALOG_RETURN_SCOPES_TRUE.equals(trim) || "True".equals(trim)) {
                    return Boolean.TRUE;
                }
                if ("false".equals(trim) || "False".equals(trim)) {
                    return Boolean.FALSE;
                }
                if (trim.length() == 0) {
                    return (Boolean) getEmptyValue(deserializationContext);
                }
                if (_hasTextualNull(trim)) {
                    return (Boolean) getNullValue(deserializationContext);
                }
                throw deserializationContext.weirdStringException(trim, this._valueClass, "only \"true\" or \"false\" recognized");
            } else if (zU == JsonToken.START_ARRAY && deserializationContext.isEnabled(DeserializationFeature.UNWRAP_SINGLE_VALUE_ARRAYS)) {
                jsonParser.zP();
                Boolean _parseBoolean = _parseBoolean(jsonParser, deserializationContext);
                if (jsonParser.zP() == JsonToken.END_ARRAY) {
                    return _parseBoolean;
                }
                throw deserializationContext.wrongTokenException(jsonParser, JsonToken.END_ARRAY, "Attempted to unwrap single value array for single 'Boolean' value but there was more than a single value in the array");
            } else {
                throw deserializationContext.mappingException(this._valueClass, zU);
            }
        }
    }

    protected final boolean _parseBooleanFromNumber(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
        if (jsonParser.Ai() == NumberType.LONG) {
            return (jsonParser.Al() == 0 ? Boolean.FALSE : Boolean.TRUE).booleanValue();
        }
        String text = jsonParser.getText();
        if ("0.0".equals(text) || AppEventsConstants.EVENT_PARAM_VALUE_NO.equals(text)) {
            return Boolean.FALSE.booleanValue();
        }
        return Boolean.TRUE.booleanValue();
    }

    protected Byte _parseByte(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
        JsonToken zU = jsonParser.zU();
        if (zU == JsonToken.VALUE_NUMBER_INT) {
            return Byte.valueOf(jsonParser.Aj());
        }
        if (zU == JsonToken.VALUE_STRING) {
            String trim = jsonParser.getText().trim();
            if (_hasTextualNull(trim)) {
                return (Byte) getNullValue(deserializationContext);
            }
            try {
                if (trim.length() == 0) {
                    return (Byte) getEmptyValue(deserializationContext);
                }
                int parseInt = afr.parseInt(trim);
                if (parseInt >= -128 && parseInt <= 255) {
                    return Byte.valueOf((byte) parseInt);
                }
                throw deserializationContext.weirdStringException(trim, this._valueClass, "overflow, value can not be represented as 8-bit value");
            } catch (IllegalArgumentException e) {
                throw deserializationContext.weirdStringException(trim, this._valueClass, "not a valid Byte value");
            }
        } else if (zU == JsonToken.VALUE_NUMBER_FLOAT) {
            if (!deserializationContext.isEnabled(DeserializationFeature.ACCEPT_FLOAT_AS_INT)) {
                _failDoubleToIntCoercion(jsonParser, deserializationContext, "Byte");
            }
            return Byte.valueOf(jsonParser.Aj());
        } else if (zU == JsonToken.VALUE_NULL) {
            return (Byte) getNullValue(deserializationContext);
        } else {
            if (zU == JsonToken.START_ARRAY && deserializationContext.isEnabled(DeserializationFeature.UNWRAP_SINGLE_VALUE_ARRAYS)) {
                jsonParser.zP();
                Byte _parseByte = _parseByte(jsonParser, deserializationContext);
                if (jsonParser.zP() == JsonToken.END_ARRAY) {
                    return _parseByte;
                }
                throw deserializationContext.wrongTokenException(jsonParser, JsonToken.END_ARRAY, "Attempted to unwrap single value array for single 'Byte' value but there was more than a single value in the array");
            }
            throw deserializationContext.mappingException(this._valueClass, zU);
        }
    }

    protected Short _parseShort(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
        JsonToken zU = jsonParser.zU();
        if (zU == JsonToken.VALUE_NUMBER_INT) {
            return Short.valueOf(jsonParser.Ak());
        }
        if (zU == JsonToken.VALUE_STRING) {
            String trim = jsonParser.getText().trim();
            try {
                if (trim.length() == 0) {
                    return (Short) getEmptyValue(deserializationContext);
                }
                if (_hasTextualNull(trim)) {
                    return (Short) getNullValue(deserializationContext);
                }
                int parseInt = afr.parseInt(trim);
                if (parseInt >= -32768 && parseInt <= 32767) {
                    return Short.valueOf((short) parseInt);
                }
                throw deserializationContext.weirdStringException(trim, this._valueClass, "overflow, value can not be represented as 16-bit value");
            } catch (IllegalArgumentException e) {
                throw deserializationContext.weirdStringException(trim, this._valueClass, "not a valid Short value");
            }
        } else if (zU == JsonToken.VALUE_NUMBER_FLOAT) {
            if (!deserializationContext.isEnabled(DeserializationFeature.ACCEPT_FLOAT_AS_INT)) {
                _failDoubleToIntCoercion(jsonParser, deserializationContext, "Short");
            }
            return Short.valueOf(jsonParser.Ak());
        } else if (zU == JsonToken.VALUE_NULL) {
            return (Short) getNullValue(deserializationContext);
        } else {
            if (zU == JsonToken.START_ARRAY && deserializationContext.isEnabled(DeserializationFeature.UNWRAP_SINGLE_VALUE_ARRAYS)) {
                jsonParser.zP();
                Short _parseShort = _parseShort(jsonParser, deserializationContext);
                if (jsonParser.zP() == JsonToken.END_ARRAY) {
                    return _parseShort;
                }
                throw deserializationContext.wrongTokenException(jsonParser, JsonToken.END_ARRAY, "Attempted to unwrap single value array for single 'Short' value but there was more than a single value in the array");
            }
            throw deserializationContext.mappingException(this._valueClass, zU);
        }
    }

    protected final short _parseShortPrimitive(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
        int _parseIntPrimitive = _parseIntPrimitive(jsonParser, deserializationContext);
        if (_parseIntPrimitive >= -32768 && _parseIntPrimitive <= 32767) {
            return (short) _parseIntPrimitive;
        }
        throw deserializationContext.weirdStringException(String.valueOf(_parseIntPrimitive), this._valueClass, "overflow, value can not be represented as 16-bit value");
    }

    protected final int _parseIntPrimitive(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
        if (jsonParser.mo865a(JsonToken.VALUE_NUMBER_INT)) {
            return jsonParser.getIntValue();
        }
        JsonToken zU = jsonParser.zU();
        if (zU == JsonToken.VALUE_STRING) {
            String trim = jsonParser.getText().trim();
            if (_hasTextualNull(trim)) {
                return 0;
            }
            try {
                int length = trim.length();
                if (length > 9) {
                    long parseLong = Long.parseLong(trim);
                    if (parseLong >= -2147483648L && parseLong <= 2147483647L) {
                        return (int) parseLong;
                    }
                    throw deserializationContext.weirdStringException(trim, this._valueClass, "Overflow: numeric value (" + trim + ") out of range of int (" + Integer.MIN_VALUE + " - " + Integer.MAX_VALUE + ")");
                } else if (length != 0) {
                    return afr.parseInt(trim);
                } else {
                    return 0;
                }
            } catch (IllegalArgumentException e) {
                throw deserializationContext.weirdStringException(trim, this._valueClass, "not a valid int value");
            }
        } else if (zU == JsonToken.VALUE_NUMBER_FLOAT) {
            if (!deserializationContext.isEnabled(DeserializationFeature.ACCEPT_FLOAT_AS_INT)) {
                _failDoubleToIntCoercion(jsonParser, deserializationContext, "int");
            }
            return jsonParser.As();
        } else if (zU == JsonToken.VALUE_NULL) {
            return 0;
        } else {
            if (zU == JsonToken.START_ARRAY && deserializationContext.isEnabled(DeserializationFeature.UNWRAP_SINGLE_VALUE_ARRAYS)) {
                jsonParser.zP();
                int _parseIntPrimitive = _parseIntPrimitive(jsonParser, deserializationContext);
                if (jsonParser.zP() == JsonToken.END_ARRAY) {
                    return _parseIntPrimitive;
                }
                throw deserializationContext.wrongTokenException(jsonParser, JsonToken.END_ARRAY, "Attempted to unwrap single value array for single 'int' value but there was more than a single value in the array");
            }
            throw deserializationContext.mappingException(this._valueClass, zU);
        }
    }

    protected final Integer _parseInteger(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
        switch (jsonParser.zV()) {
            case 3:
                if (deserializationContext.isEnabled(DeserializationFeature.UNWRAP_SINGLE_VALUE_ARRAYS)) {
                    jsonParser.zP();
                    Integer _parseInteger = _parseInteger(jsonParser, deserializationContext);
                    if (jsonParser.zP() == JsonToken.END_ARRAY) {
                        return _parseInteger;
                    }
                    throw deserializationContext.wrongTokenException(jsonParser, JsonToken.END_ARRAY, "Attempted to unwrap single value array for single 'Integer' value but there was more than a single value in the array");
                }
                break;
            case 6:
                String trim = jsonParser.getText().trim();
                try {
                    int length = trim.length();
                    if (_hasTextualNull(trim)) {
                        return (Integer) getNullValue(deserializationContext);
                    }
                    if (length > 9) {
                        long parseLong = Long.parseLong(trim);
                        if (parseLong >= -2147483648L && parseLong <= 2147483647L) {
                            return Integer.valueOf((int) parseLong);
                        }
                        throw deserializationContext.weirdStringException(trim, this._valueClass, "Overflow: numeric value (" + trim + ") out of range of Integer (" + Integer.MIN_VALUE + " - " + Integer.MAX_VALUE + ")");
                    } else if (length == 0) {
                        return (Integer) getEmptyValue(deserializationContext);
                    } else {
                        return Integer.valueOf(afr.parseInt(trim));
                    }
                } catch (IllegalArgumentException e) {
                    throw deserializationContext.weirdStringException(trim, this._valueClass, "not a valid Integer value");
                }
            case 7:
                return Integer.valueOf(jsonParser.getIntValue());
            case 8:
                if (!deserializationContext.isEnabled(DeserializationFeature.ACCEPT_FLOAT_AS_INT)) {
                    _failDoubleToIntCoercion(jsonParser, deserializationContext, "Integer");
                }
                return Integer.valueOf(jsonParser.As());
            case 11:
                return (Integer) getNullValue(deserializationContext);
        }
        throw deserializationContext.mappingException(this._valueClass, jsonParser.zU());
    }

    protected final Long _parseLong(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
        switch (jsonParser.zV()) {
            case 3:
                if (deserializationContext.isEnabled(DeserializationFeature.UNWRAP_SINGLE_VALUE_ARRAYS)) {
                    jsonParser.zP();
                    Long _parseLong = _parseLong(jsonParser, deserializationContext);
                    if (jsonParser.zP() == JsonToken.END_ARRAY) {
                        return _parseLong;
                    }
                    throw deserializationContext.wrongTokenException(jsonParser, JsonToken.END_ARRAY, "Attempted to unwrap single value array for single 'Long' value but there was more than a single value in the array");
                }
                break;
            case 6:
                String trim = jsonParser.getText().trim();
                if (trim.length() == 0) {
                    return (Long) getEmptyValue(deserializationContext);
                }
                if (_hasTextualNull(trim)) {
                    return (Long) getNullValue(deserializationContext);
                }
                try {
                    return Long.valueOf(afr.parseLong(trim));
                } catch (IllegalArgumentException e) {
                    throw deserializationContext.weirdStringException(trim, this._valueClass, "not a valid Long value");
                }
            case 7:
                return Long.valueOf(jsonParser.Al());
            case 8:
                if (!deserializationContext.isEnabled(DeserializationFeature.ACCEPT_FLOAT_AS_INT)) {
                    _failDoubleToIntCoercion(jsonParser, deserializationContext, "Long");
                }
                return Long.valueOf(jsonParser.At());
            case 11:
                return (Long) getNullValue(deserializationContext);
        }
        throw deserializationContext.mappingException(this._valueClass, jsonParser.zU());
    }

    protected final long _parseLongPrimitive(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
        switch (jsonParser.zV()) {
            case 3:
                if (deserializationContext.isEnabled(DeserializationFeature.UNWRAP_SINGLE_VALUE_ARRAYS)) {
                    jsonParser.zP();
                    long _parseLongPrimitive = _parseLongPrimitive(jsonParser, deserializationContext);
                    if (jsonParser.zP() == JsonToken.END_ARRAY) {
                        return _parseLongPrimitive;
                    }
                    throw deserializationContext.wrongTokenException(jsonParser, JsonToken.END_ARRAY, "Attempted to unwrap single value array for single 'long' value but there was more than a single value in the array");
                }
                break;
            case 6:
                String trim = jsonParser.getText().trim();
                if (trim.length() == 0 || _hasTextualNull(trim)) {
                    return 0;
                }
                try {
                    return afr.parseLong(trim);
                } catch (IllegalArgumentException e) {
                    throw deserializationContext.weirdStringException(trim, this._valueClass, "not a valid long value");
                }
            case 7:
                return jsonParser.Al();
            case 8:
                if (!deserializationContext.isEnabled(DeserializationFeature.ACCEPT_FLOAT_AS_INT)) {
                    _failDoubleToIntCoercion(jsonParser, deserializationContext, "long");
                }
                return jsonParser.At();
            case 11:
                return 0;
        }
        throw deserializationContext.mappingException(this._valueClass, jsonParser.zU());
    }

    protected final Float _parseFloat(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
        JsonToken zU = jsonParser.zU();
        if (zU == JsonToken.VALUE_NUMBER_INT || zU == JsonToken.VALUE_NUMBER_FLOAT) {
            return Float.valueOf(jsonParser.An());
        }
        if (zU == JsonToken.VALUE_STRING) {
            String trim = jsonParser.getText().trim();
            if (trim.length() == 0) {
                return (Float) getEmptyValue(deserializationContext);
            }
            if (_hasTextualNull(trim)) {
                return (Float) getNullValue(deserializationContext);
            }
            switch (trim.charAt(0)) {
                case '-':
                    if (_isNegInf(trim)) {
                        return Float.valueOf(Float.NEGATIVE_INFINITY);
                    }
                    break;
                case 'I':
                    if (_isPosInf(trim)) {
                        return Float.valueOf(Float.POSITIVE_INFINITY);
                    }
                    break;
                case 'N':
                    if (_isNaN(trim)) {
                        return Float.valueOf(Float.NaN);
                    }
                    break;
            }
            try {
                return Float.valueOf(Float.parseFloat(trim));
            } catch (IllegalArgumentException e) {
                throw deserializationContext.weirdStringException(trim, this._valueClass, "not a valid Float value");
            }
        } else if (zU == JsonToken.VALUE_NULL) {
            return (Float) getNullValue(deserializationContext);
        } else {
            if (zU == JsonToken.START_ARRAY && deserializationContext.isEnabled(DeserializationFeature.UNWRAP_SINGLE_VALUE_ARRAYS)) {
                jsonParser.zP();
                Float _parseFloat = _parseFloat(jsonParser, deserializationContext);
                if (jsonParser.zP() == JsonToken.END_ARRAY) {
                    return _parseFloat;
                }
                throw deserializationContext.wrongTokenException(jsonParser, JsonToken.END_ARRAY, "Attempted to unwrap single value array for single 'Byte' value but there was more than a single value in the array");
            }
            throw deserializationContext.mappingException(this._valueClass, zU);
        }
    }

    protected final float _parseFloatPrimitive(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
        JsonToken zU = jsonParser.zU();
        if (zU == JsonToken.VALUE_NUMBER_INT || zU == JsonToken.VALUE_NUMBER_FLOAT) {
            return jsonParser.An();
        }
        if (zU == JsonToken.VALUE_STRING) {
            String trim = jsonParser.getText().trim();
            if (trim.length() == 0 || _hasTextualNull(trim)) {
                return 0.0f;
            }
            switch (trim.charAt(0)) {
                case '-':
                    if (_isNegInf(trim)) {
                        return Float.NEGATIVE_INFINITY;
                    }
                    break;
                case 'I':
                    if (_isPosInf(trim)) {
                        return Float.POSITIVE_INFINITY;
                    }
                    break;
                case 'N':
                    if (_isNaN(trim)) {
                        return Float.NaN;
                    }
                    break;
            }
            try {
                return Float.parseFloat(trim);
            } catch (IllegalArgumentException e) {
                throw deserializationContext.weirdStringException(trim, this._valueClass, "not a valid float value");
            }
        } else if (zU == JsonToken.VALUE_NULL) {
            return 0.0f;
        } else {
            if (zU == JsonToken.START_ARRAY && deserializationContext.isEnabled(DeserializationFeature.UNWRAP_SINGLE_VALUE_ARRAYS)) {
                jsonParser.zP();
                float _parseFloatPrimitive = _parseFloatPrimitive(jsonParser, deserializationContext);
                if (jsonParser.zP() == JsonToken.END_ARRAY) {
                    return _parseFloatPrimitive;
                }
                throw deserializationContext.wrongTokenException(jsonParser, JsonToken.END_ARRAY, "Attempted to unwrap single value array for single 'float' value but there was more than a single value in the array");
            }
            throw deserializationContext.mappingException(this._valueClass, zU);
        }
    }

    protected final Double _parseDouble(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
        JsonToken zU = jsonParser.zU();
        if (zU == JsonToken.VALUE_NUMBER_INT || zU == JsonToken.VALUE_NUMBER_FLOAT) {
            return Double.valueOf(jsonParser.Ao());
        }
        if (zU == JsonToken.VALUE_STRING) {
            String trim = jsonParser.getText().trim();
            if (trim.length() == 0) {
                return (Double) getEmptyValue(deserializationContext);
            }
            if (_hasTextualNull(trim)) {
                return (Double) getNullValue(deserializationContext);
            }
            switch (trim.charAt(0)) {
                case '-':
                    if (_isNegInf(trim)) {
                        return Double.valueOf(Double.NEGATIVE_INFINITY);
                    }
                    break;
                case 'I':
                    if (_isPosInf(trim)) {
                        return Double.valueOf(Double.POSITIVE_INFINITY);
                    }
                    break;
                case 'N':
                    if (_isNaN(trim)) {
                        return Double.valueOf(Double.NaN);
                    }
                    break;
            }
            try {
                return Double.valueOf(parseDouble(trim));
            } catch (IllegalArgumentException e) {
                throw deserializationContext.weirdStringException(trim, this._valueClass, "not a valid Double value");
            }
        } else if (zU == JsonToken.VALUE_NULL) {
            return (Double) getNullValue(deserializationContext);
        } else {
            if (zU == JsonToken.START_ARRAY && deserializationContext.isEnabled(DeserializationFeature.UNWRAP_SINGLE_VALUE_ARRAYS)) {
                jsonParser.zP();
                Double _parseDouble = _parseDouble(jsonParser, deserializationContext);
                if (jsonParser.zP() == JsonToken.END_ARRAY) {
                    return _parseDouble;
                }
                throw deserializationContext.wrongTokenException(jsonParser, JsonToken.END_ARRAY, "Attempted to unwrap single value array for single 'Double' value but there was more than a single value in the array");
            }
            throw deserializationContext.mappingException(this._valueClass, zU);
        }
    }

    protected final double _parseDoublePrimitive(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
        JsonToken zU = jsonParser.zU();
        if (zU == JsonToken.VALUE_NUMBER_INT || zU == JsonToken.VALUE_NUMBER_FLOAT) {
            return jsonParser.Ao();
        }
        if (zU == JsonToken.VALUE_STRING) {
            String trim = jsonParser.getText().trim();
            if (trim.length() == 0 || _hasTextualNull(trim)) {
                return 0.0d;
            }
            switch (trim.charAt(0)) {
                case '-':
                    if (_isNegInf(trim)) {
                        return Double.NEGATIVE_INFINITY;
                    }
                    break;
                case 'I':
                    if (_isPosInf(trim)) {
                        return Double.POSITIVE_INFINITY;
                    }
                    break;
                case 'N':
                    if (_isNaN(trim)) {
                        return Double.NaN;
                    }
                    break;
            }
            try {
                return parseDouble(trim);
            } catch (IllegalArgumentException e) {
                throw deserializationContext.weirdStringException(trim, this._valueClass, "not a valid double value");
            }
        } else if (zU == JsonToken.VALUE_NULL) {
            return 0.0d;
        } else {
            if (zU == JsonToken.START_ARRAY && deserializationContext.isEnabled(DeserializationFeature.UNWRAP_SINGLE_VALUE_ARRAYS)) {
                jsonParser.zP();
                double _parseDoublePrimitive = _parseDoublePrimitive(jsonParser, deserializationContext);
                if (jsonParser.zP() == JsonToken.END_ARRAY) {
                    return _parseDoublePrimitive;
                }
                throw deserializationContext.wrongTokenException(jsonParser, JsonToken.END_ARRAY, "Attempted to unwrap single value array for single 'Byte' value but there was more than a single value in the array");
            }
            throw deserializationContext.mappingException(this._valueClass, zU);
        }
    }

    protected Date _parseDate(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
        JsonToken zU = jsonParser.zU();
        if (zU == JsonToken.VALUE_NUMBER_INT) {
            return new Date(jsonParser.Al());
        }
        if (zU == JsonToken.VALUE_NULL) {
            return (Date) getNullValue(deserializationContext);
        }
        if (zU == JsonToken.VALUE_STRING) {
            try {
                String trim = jsonParser.getText().trim();
                if (trim.length() == 0) {
                    return (Date) getEmptyValue(deserializationContext);
                }
                if (_hasTextualNull(trim)) {
                    return (Date) getNullValue(deserializationContext);
                }
                return deserializationContext.parseDate(trim);
            } catch (IllegalArgumentException e) {
                throw deserializationContext.weirdStringException(null, this._valueClass, "not a valid representation (error: " + e.getMessage() + ")");
            }
        } else if (zU == JsonToken.START_ARRAY && deserializationContext.isEnabled(DeserializationFeature.UNWRAP_SINGLE_VALUE_ARRAYS)) {
            jsonParser.zP();
            Date _parseDate = _parseDate(jsonParser, deserializationContext);
            if (jsonParser.zP() == JsonToken.END_ARRAY) {
                return _parseDate;
            }
            throw deserializationContext.wrongTokenException(jsonParser, JsonToken.END_ARRAY, "Attempted to unwrap single value array for single 'java.util.Date' value but there was more than a single value in the array");
        } else {
            throw deserializationContext.mappingException(this._valueClass, zU);
        }
    }

    protected static final double parseDouble(String str) throws NumberFormatException {
        if ("2.2250738585072012e-308".equals(str)) {
            return Double.MIN_VALUE;
        }
        return Double.parseDouble(str);
    }

    protected final String _parseString(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
        JsonToken zU = jsonParser.zU();
        if (zU == JsonToken.VALUE_STRING) {
            return jsonParser.getText();
        }
        String _parseString;
        if (zU == JsonToken.START_ARRAY && deserializationContext.isEnabled(DeserializationFeature.UNWRAP_SINGLE_VALUE_ARRAYS)) {
            jsonParser.zP();
            _parseString = _parseString(jsonParser, deserializationContext);
            if (jsonParser.zP() == JsonToken.END_ARRAY) {
                return _parseString;
            }
            throw deserializationContext.wrongTokenException(jsonParser, JsonToken.END_ARRAY, "Attempted to unwrap single value array for single 'String' value but there was more than a single value in the array");
        }
        _parseString = jsonParser.Au();
        if (_parseString != null) {
            return _parseString;
        }
        throw deserializationContext.mappingException(String.class, jsonParser.zU());
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    protected T _deserializeFromEmpty(com.fasterxml.jackson.core.JsonParser r4, com.fasterxml.jackson.databind.DeserializationContext r5) throws java.io.IOException {
        /*
        r3 = this;
        r2 = 0;
        r0 = r4.zU();
        r1 = com.fasterxml.jackson.core.JsonToken.START_ARRAY;
        if (r0 != r1) goto L_0x0025;
    L_0x0009:
        r0 = com.fasterxml.jackson.databind.DeserializationFeature.ACCEPT_EMPTY_ARRAY_AS_NULL_OBJECT;
        r0 = r5.isEnabled(r0);
        if (r0 == 0) goto L_0x003f;
    L_0x0011:
        r0 = r4.zP();
        r1 = com.fasterxml.jackson.core.JsonToken.END_ARRAY;
        if (r0 != r1) goto L_0x001a;
    L_0x0019:
        return r2;
    L_0x001a:
        r0 = r3.handledType();
        r1 = com.fasterxml.jackson.core.JsonToken.START_ARRAY;
        r0 = r5.mappingException(r0, r1);
        throw r0;
    L_0x0025:
        r1 = com.fasterxml.jackson.core.JsonToken.VALUE_STRING;
        if (r0 != r1) goto L_0x003f;
    L_0x0029:
        r0 = com.fasterxml.jackson.databind.DeserializationFeature.ACCEPT_EMPTY_STRING_AS_NULL_OBJECT;
        r0 = r5.isEnabled(r0);
        if (r0 == 0) goto L_0x003f;
    L_0x0031:
        r0 = r4.getText();
        r0 = r0.trim();
        r0 = r0.isEmpty();
        if (r0 != 0) goto L_0x0019;
    L_0x003f:
        r0 = r3.handledType();
        r0 = r5.mappingException(r0);
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fasterxml.jackson.databind.deser.std.StdDeserializer._deserializeFromEmpty(com.fasterxml.jackson.core.JsonParser, com.fasterxml.jackson.databind.DeserializationContext):T");
    }

    protected boolean _hasTextualNull(String str) {
        return "null".equals(str);
    }

    protected final boolean _isNegInf(String str) {
        return "-Infinity".equals(str) || "-INF".equals(str);
    }

    protected final boolean _isPosInf(String str) {
        return "Infinity".equals(str) || "INF".equals(str);
    }

    protected final boolean _isNaN(String str) {
        return "NaN".equals(str);
    }

    protected Object _coerceIntegral(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
        int deserializationFeatures = deserializationContext.getDeserializationFeatures();
        if (DeserializationFeature.USE_BIG_INTEGER_FOR_INTS.enabledIn(deserializationFeatures)) {
            return jsonParser.Am();
        }
        if (DeserializationFeature.USE_LONG_FOR_INTS.enabledIn(deserializationFeatures)) {
            return Long.valueOf(jsonParser.Al());
        }
        return jsonParser.Am();
    }

    protected agy<Object> findDeserializer(DeserializationContext deserializationContext, JavaType javaType, agv com_fossil_agv) throws JsonMappingException {
        return deserializationContext.findContextualValueDeserializer(javaType, com_fossil_agv);
    }

    protected final boolean _isIntNumber(String str) {
        int length = str.length();
        if (length <= 0) {
            return false;
        }
        char charAt = str.charAt(0);
        int i = (charAt == '-' || charAt == '+') ? 1 : 0;
        while (i < length) {
            char charAt2 = str.charAt(i);
            if (charAt2 > '9' || charAt2 < '0') {
                return false;
            }
            i++;
        }
        return true;
    }

    protected agy<?> findConvertingContentDeserializer(DeserializationContext deserializationContext, agv com_fossil_agv, agy<?> com_fossil_agy_) throws JsonMappingException {
        AnnotationIntrospector annotationIntrospector = deserializationContext.getAnnotationIntrospector();
        if (annotationIntrospector == null || com_fossil_agv == null) {
            return com_fossil_agy_;
        }
        AnnotatedMember member = com_fossil_agv.getMember();
        if (member == null) {
            return com_fossil_agy_;
        }
        Object findDeserializationContentConverter = annotationIntrospector.findDeserializationContentConverter(member);
        if (findDeserializationContentConverter == null) {
            return com_fossil_agy_;
        }
        amk converterInstance = deserializationContext.converterInstance(com_fossil_agv.getMember(), findDeserializationContentConverter);
        JavaType a = converterInstance.m3878a(deserializationContext.getTypeFactory());
        if (com_fossil_agy_ == null) {
            com_fossil_agy_ = deserializationContext.findContextualValueDeserializer(a, com_fossil_agv);
        }
        return new StdDelegatingDeserializer(converterInstance, a, com_fossil_agy_);
    }

    public void handleUnknownProperty(JsonParser jsonParser, DeserializationContext deserializationContext, Object obj, String str) throws IOException {
        if (obj == null) {
            obj = handledType();
        }
        if (!deserializationContext.handleUnknownProperty(jsonParser, this, obj, str)) {
            deserializationContext.reportUnknownProperty(obj, str, this);
            jsonParser.zT();
        }
    }

    protected void _failDoubleToIntCoercion(JsonParser jsonParser, DeserializationContext deserializationContext, String str) throws IOException {
        throw deserializationContext.mappingException("Can not coerce a floating-point value ('%s') into %s; enable `DeserializationFeature.ACCEPT_FLOAT_AS_INT` to allow", jsonParser.Au(), str);
    }
}
