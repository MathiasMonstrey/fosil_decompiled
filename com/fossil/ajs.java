package com.fossil;

import com.fasterxml.jackson.annotation.JsonTypeInfo.As;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JavaType;
import java.io.IOException;

public abstract class ajs {
    public abstract Object deserializeTypedFromAny(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException;

    public abstract Object deserializeTypedFromArray(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException;

    public abstract Object deserializeTypedFromObject(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException;

    public abstract Object deserializeTypedFromScalar(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException;

    public abstract ajs forProperty(agv com_fossil_agv);

    public abstract Class<?> getDefaultImpl();

    public abstract String getPropertyName();

    public abstract ajt getTypeIdResolver();

    public abstract As getTypeInclusion();

    public static Object deserializeIfNatural(JsonParser jsonParser, DeserializationContext deserializationContext, JavaType javaType) throws IOException {
        return deserializeIfNatural(jsonParser, deserializationContext, javaType.getRawClass());
    }

    public static Object deserializeIfNatural(JsonParser jsonParser, DeserializationContext deserializationContext, Class<?> cls) throws IOException {
        JsonToken zU = jsonParser.zU();
        if (zU == null) {
            return null;
        }
        switch (zU) {
            case VALUE_STRING:
                if (cls.isAssignableFrom(String.class)) {
                    return jsonParser.getText();
                }
                return null;
            case VALUE_NUMBER_INT:
                if (cls.isAssignableFrom(Integer.class)) {
                    return Integer.valueOf(jsonParser.getIntValue());
                }
                return null;
            case VALUE_NUMBER_FLOAT:
                if (cls.isAssignableFrom(Double.class)) {
                    return Double.valueOf(jsonParser.Ao());
                }
                return null;
            case VALUE_TRUE:
                if (cls.isAssignableFrom(Boolean.class)) {
                    return Boolean.TRUE;
                }
                return null;
            case VALUE_FALSE:
                if (cls.isAssignableFrom(Boolean.class)) {
                    return Boolean.FALSE;
                }
                return null;
            default:
                return null;
        }
    }
}
