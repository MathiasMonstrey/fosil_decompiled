package com.fasterxml.jackson.databind.deser.std;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.DeserializationConfig;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.introspect.AnnotatedMethod;
import com.fasterxml.jackson.databind.util.EnumResolver;
import com.fossil.agv;
import com.fossil.agy;
import com.fossil.ahh;
import com.fossil.ahv;
import com.fossil.ajs;
import com.fossil.ami;
import com.fossil.amj;
import java.io.IOException;
import java.lang.reflect.Method;

@ahh
public class EnumDeserializer extends StdScalarDeserializer<Object> {
    private static final long serialVersionUID = 1;
    protected final amj _enumLookup;
    protected Object[] _enumsByIndex;

    public static class FactoryBasedDeserializer extends StdDeserializer<Object> implements ahv {
        private static final long serialVersionUID = 1;
        protected final agy<?> _deser;
        protected final Method _factory;
        protected final Class<?> _inputType;

        public FactoryBasedDeserializer(Class<?> cls, AnnotatedMethod annotatedMethod, Class<?> cls2) {
            super((Class) cls);
            this._factory = annotatedMethod.getAnnotated();
            this._inputType = cls2;
            this._deser = null;
        }

        protected FactoryBasedDeserializer(FactoryBasedDeserializer factoryBasedDeserializer, agy<?> com_fossil_agy_) {
            super(factoryBasedDeserializer._valueClass);
            this._inputType = factoryBasedDeserializer._inputType;
            this._factory = factoryBasedDeserializer._factory;
            this._deser = com_fossil_agy_;
        }

        public agy<?> createContextual(DeserializationContext deserializationContext, agv com_fossil_agv) throws JsonMappingException {
            if (this._deser != null || this._inputType == String.class) {
                return this;
            }
            return new FactoryBasedDeserializer(this, deserializationContext.findContextualValueDeserializer(deserializationContext.constructType(this._inputType), com_fossil_agv));
        }

        public Object deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
            Object deserialize;
            if (this._deser != null) {
                deserialize = this._deser.deserialize(jsonParser, deserializationContext);
            } else {
                JsonToken zU = jsonParser.zU();
                if (zU == JsonToken.VALUE_STRING || zU == JsonToken.FIELD_NAME) {
                    deserialize = jsonParser.getText();
                } else {
                    deserialize = jsonParser.Au();
                }
            }
            try {
                return this._factory.invoke(this._valueClass, new Object[]{deserialize});
            } catch (Throwable th) {
                Throwable th2 = ami.m3865c(th2);
                if (th2 instanceof IOException) {
                    throw ((IOException) th2);
                }
                throw deserializationContext.instantiationException(this._valueClass, th2);
            }
        }

        public Object deserializeWithType(JsonParser jsonParser, DeserializationContext deserializationContext, ajs com_fossil_ajs) throws IOException {
            if (this._deser == null) {
                return deserialize(jsonParser, deserializationContext);
            }
            return com_fossil_ajs.deserializeTypedFromAny(jsonParser, deserializationContext);
        }
    }

    public EnumDeserializer(EnumResolver enumResolver) {
        super(enumResolver.getEnumClass());
        this._enumLookup = enumResolver.constructLookup();
        this._enumsByIndex = enumResolver.getRawEnums();
    }

    public static agy<?> deserializerForCreator(DeserializationConfig deserializationConfig, Class<?> cls, AnnotatedMethod annotatedMethod) {
        Class rawParameterType = annotatedMethod.getRawParameterType(0);
        if (deserializationConfig.canOverrideAccessModifiers()) {
            ami.m3862a(annotatedMethod.getMember());
        }
        return new FactoryBasedDeserializer(cls, annotatedMethod, rawParameterType);
    }

    public boolean isCachable() {
        return true;
    }

    public Object deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
        JsonToken zU = jsonParser.zU();
        if (zU == JsonToken.VALUE_STRING || zU == JsonToken.FIELD_NAME) {
            String text = jsonParser.getText();
            Object cb = this._enumLookup.cb(text);
            if (cb == null) {
                return m2722a(jsonParser, deserializationContext, text);
            }
            return cb;
        } else if (zU != JsonToken.VALUE_NUMBER_INT) {
            return _deserializeOther(jsonParser, deserializationContext);
        } else {
            _checkFailOnNumber(deserializationContext);
            int intValue = jsonParser.getIntValue();
            if (intValue >= 0 && intValue <= this._enumsByIndex.length) {
                return this._enumsByIndex[intValue];
            }
            if (deserializationContext.isEnabled(DeserializationFeature.READ_UNKNOWN_ENUM_VALUES_AS_NULL)) {
                return null;
            }
            throw deserializationContext.weirdNumberException(Integer.valueOf(intValue), _enumClass(), "index value outside legal index range [0.." + (this._enumsByIndex.length - 1) + "]");
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final java.lang.Object m2722a(com.fasterxml.jackson.core.JsonParser r5, com.fasterxml.jackson.databind.DeserializationContext r6, java.lang.String r7) throws java.io.IOException {
        /*
        r4 = this;
        r0 = 0;
        r1 = r7.trim();
        r2 = r1.length();
        if (r2 != 0) goto L_0x0014;
    L_0x000b:
        r2 = com.fasterxml.jackson.databind.DeserializationFeature.ACCEPT_EMPTY_STRING_AS_NULL_OBJECT;
        r2 = r6.isEnabled(r2);
        if (r2 == 0) goto L_0x0035;
    L_0x0013:
        return r0;
    L_0x0014:
        r2 = 0;
        r2 = r1.charAt(r2);
        r3 = 48;
        if (r2 < r3) goto L_0x0035;
    L_0x001d:
        r3 = 57;
        if (r2 > r3) goto L_0x0035;
    L_0x0021:
        r2 = java.lang.Integer.parseInt(r1);	 Catch:{ NumberFormatException -> 0x0034 }
        r4._checkFailOnNumber(r6);	 Catch:{ NumberFormatException -> 0x0034 }
        if (r2 < 0) goto L_0x0035;
    L_0x002a:
        r3 = r4._enumsByIndex;	 Catch:{ NumberFormatException -> 0x0034 }
        r3 = r3.length;	 Catch:{ NumberFormatException -> 0x0034 }
        if (r2 > r3) goto L_0x0035;
    L_0x002f:
        r3 = r4._enumsByIndex;	 Catch:{ NumberFormatException -> 0x0034 }
        r0 = r3[r2];	 Catch:{ NumberFormatException -> 0x0034 }
        goto L_0x0013;
    L_0x0034:
        r2 = move-exception;
    L_0x0035:
        r2 = com.fasterxml.jackson.databind.DeserializationFeature.READ_UNKNOWN_ENUM_VALUES_AS_NULL;
        r2 = r6.isEnabled(r2);
        if (r2 != 0) goto L_0x0013;
    L_0x003d:
        r0 = r4._enumClass();
        r2 = new java.lang.StringBuilder;
        r2.<init>();
        r3 = "value not one of declared Enum instance names: ";
        r2 = r2.append(r3);
        r3 = r4._enumLookup;
        r3 = r3.Hj();
        r2 = r2.append(r3);
        r2 = r2.toString();
        r0 = r6.weirdStringException(r1, r0, r2);
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fasterxml.jackson.databind.deser.std.EnumDeserializer.a(com.fasterxml.jackson.core.JsonParser, com.fasterxml.jackson.databind.DeserializationContext, java.lang.String):java.lang.Object");
    }

    protected Object _deserializeOther(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
        jsonParser.zU();
        if (deserializationContext.isEnabled(DeserializationFeature.UNWRAP_SINGLE_VALUE_ARRAYS) && jsonParser.Aa()) {
            jsonParser.zP();
            Object deserialize = deserialize(jsonParser, deserializationContext);
            if (jsonParser.zP() == JsonToken.END_ARRAY) {
                return deserialize;
            }
            throw deserializationContext.wrongTokenException(jsonParser, JsonToken.END_ARRAY, "Attempted to unwrap single value array for single '" + _enumClass().getName() + "' value but there was more than a single value in the array");
        }
        throw deserializationContext.mappingException(_enumClass());
    }

    protected void _checkFailOnNumber(DeserializationContext deserializationContext) throws IOException {
        if (deserializationContext.isEnabled(DeserializationFeature.FAIL_ON_NUMBERS_FOR_ENUMS)) {
            throw deserializationContext.mappingException("Not allowed to deserialize Enum value out of JSON number (disable DeserializationConfig.DeserializationFeature.FAIL_ON_NUMBERS_FOR_ENUMS to allow)");
        }
    }

    protected Class<?> _enumClass() {
        return handledType();
    }
}
