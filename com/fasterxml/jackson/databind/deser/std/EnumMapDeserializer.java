package com.fasterxml.jackson.databind.deser.std;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fossil.agv;
import com.fossil.agy;
import com.fossil.ahc;
import com.fossil.ahv;
import com.fossil.ajs;
import java.io.IOException;
import java.util.EnumMap;

public class EnumMapDeserializer extends ContainerDeserializerBase<EnumMap<?, ?>> implements ahv {
    private static final long serialVersionUID = 1;
    protected final Class<?> _enumClass;
    protected ahc _keyDeserializer;
    protected final JavaType _mapType;
    protected agy<Object> _valueDeserializer;
    protected final ajs _valueTypeDeserializer;

    public EnumMapDeserializer(JavaType javaType, ahc com_fossil_ahc, agy<?> com_fossil_agy_, ajs com_fossil_ajs) {
        super(javaType);
        this._mapType = javaType;
        this._enumClass = javaType.getKeyType().getRawClass();
        this._keyDeserializer = com_fossil_ahc;
        this._valueDeserializer = com_fossil_agy_;
        this._valueTypeDeserializer = com_fossil_ajs;
    }

    public EnumMapDeserializer withResolved(ahc com_fossil_ahc, agy<?> com_fossil_agy_, ajs com_fossil_ajs) {
        return (com_fossil_ahc == this._keyDeserializer && com_fossil_agy_ == this._valueDeserializer && com_fossil_ajs == this._valueTypeDeserializer) ? this : new EnumMapDeserializer(this._mapType, com_fossil_ahc, com_fossil_agy_, this._valueTypeDeserializer);
    }

    public agy<?> createContextual(DeserializationContext deserializationContext, agv com_fossil_agv) throws JsonMappingException {
        ahc com_fossil_ahc = this._keyDeserializer;
        if (com_fossil_ahc == null) {
            com_fossil_ahc = deserializationContext.findKeyDeserializer(this._mapType.getKeyType(), com_fossil_agv);
        }
        agy com_fossil_agy = this._valueDeserializer;
        JavaType contentType = this._mapType.getContentType();
        if (com_fossil_agy == null) {
            com_fossil_agy = deserializationContext.findContextualValueDeserializer(contentType, com_fossil_agv);
        } else {
            com_fossil_agy = deserializationContext.handleSecondaryContextualization(com_fossil_agy, com_fossil_agv, contentType);
        }
        ajs com_fossil_ajs = this._valueTypeDeserializer;
        if (com_fossil_ajs != null) {
            com_fossil_ajs = com_fossil_ajs.forProperty(com_fossil_agv);
        }
        return withResolved(com_fossil_ahc, com_fossil_agy, com_fossil_ajs);
    }

    public boolean isCachable() {
        return this._valueDeserializer == null && this._keyDeserializer == null && this._valueTypeDeserializer == null;
    }

    public JavaType getContentType() {
        return this._mapType.getContentType();
    }

    public agy<Object> getContentDeserializer() {
        return this._valueDeserializer;
    }

    public EnumMap<?, ?> deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
        if (jsonParser.zU() != JsonToken.START_OBJECT) {
            return (EnumMap) _deserializeFromEmpty(jsonParser, deserializationContext);
        }
        EnumMap<?, ?> constructMap = constructMap();
        agy com_fossil_agy = this._valueDeserializer;
        ajs com_fossil_ajs = this._valueTypeDeserializer;
        while (jsonParser.zP() == JsonToken.FIELD_NAME) {
            String zW = jsonParser.zW();
            Enum enumR = (Enum) this._keyDeserializer.deserializeKey(zW, deserializationContext);
            if (enumR != null) {
                try {
                    Object nullValue;
                    if (jsonParser.zP() == JsonToken.VALUE_NULL) {
                        nullValue = com_fossil_agy.getNullValue(deserializationContext);
                    } else if (com_fossil_ajs == null) {
                        nullValue = com_fossil_agy.deserialize(jsonParser, deserializationContext);
                    } else {
                        nullValue = com_fossil_agy.deserializeWithType(jsonParser, deserializationContext, com_fossil_ajs);
                    }
                    constructMap.put(enumR, nullValue);
                } catch (Throwable e) {
                    wrapAndThrow(e, constructMap, zW);
                    return null;
                }
            } else if (deserializationContext.isEnabled(DeserializationFeature.READ_UNKNOWN_ENUM_VALUES_AS_NULL)) {
                jsonParser.zP();
                jsonParser.zT();
            } else {
                throw deserializationContext.weirdStringException(zW, this._enumClass, "value not one of declared Enum instance names for " + this._mapType.getKeyType());
            }
        }
        return constructMap;
    }

    public Object deserializeWithType(JsonParser jsonParser, DeserializationContext deserializationContext, ajs com_fossil_ajs) throws IOException, JsonProcessingException {
        return com_fossil_ajs.deserializeTypedFromObject(jsonParser, deserializationContext);
    }

    protected EnumMap<?, ?> constructMap() {
        return new EnumMap(this._enumClass);
    }
}
