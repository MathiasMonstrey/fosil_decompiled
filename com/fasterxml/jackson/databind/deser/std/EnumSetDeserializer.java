package com.fasterxml.jackson.databind.deser.std;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fossil.agv;
import com.fossil.agy;
import com.fossil.ahv;
import com.fossil.ajs;
import java.io.IOException;
import java.util.EnumSet;

public class EnumSetDeserializer extends StdDeserializer<EnumSet<?>> implements ahv {
    private static final long serialVersionUID = 1;
    protected final Class<Enum> _enumClass;
    protected agy<Enum<?>> _enumDeserializer;
    protected final JavaType _enumType;

    public EnumSetDeserializer(JavaType javaType, agy<?> com_fossil_agy_) {
        super(EnumSet.class);
        this._enumType = javaType;
        this._enumClass = javaType.getRawClass();
        if (this._enumClass.isEnum()) {
            this._enumDeserializer = com_fossil_agy_;
            return;
        }
        throw new IllegalArgumentException("Type " + javaType + " not Java Enum type");
    }

    public EnumSetDeserializer withDeserializer(agy<?> com_fossil_agy_) {
        return this._enumDeserializer == com_fossil_agy_ ? this : new EnumSetDeserializer(this._enumType, com_fossil_agy_);
    }

    public boolean isCachable() {
        if (this._enumType.getValueHandler() != null) {
            return false;
        }
        return true;
    }

    public agy<?> createContextual(DeserializationContext deserializationContext, agv com_fossil_agv) throws JsonMappingException {
        agy com_fossil_agy = this._enumDeserializer;
        if (com_fossil_agy == null) {
            com_fossil_agy = deserializationContext.findContextualValueDeserializer(this._enumType, com_fossil_agv);
        } else {
            com_fossil_agy = deserializationContext.handleSecondaryContextualization(com_fossil_agy, com_fossil_agv, this._enumType);
        }
        return withDeserializer(com_fossil_agy);
    }

    public EnumSet<?> deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
        if (jsonParser.Aa()) {
            Object EP = EP();
            while (true) {
                try {
                    JsonToken zP = jsonParser.zP();
                    if (zP == JsonToken.END_ARRAY) {
                        return EP;
                    }
                    if (zP == JsonToken.VALUE_NULL) {
                        throw deserializationContext.mappingException(this._enumClass);
                    }
                    Enum enumR = (Enum) this._enumDeserializer.deserialize(jsonParser, deserializationContext);
                    if (enumR != null) {
                        EP.add(enumR);
                    }
                } catch (Throwable e) {
                    throw JsonMappingException.wrapWithPath(e, EP, EP.size());
                }
            }
        }
        throw deserializationContext.mappingException(EnumSet.class);
    }

    public Object deserializeWithType(JsonParser jsonParser, DeserializationContext deserializationContext, ajs com_fossil_ajs) throws IOException, JsonProcessingException {
        return com_fossil_ajs.deserializeTypedFromArray(jsonParser, deserializationContext);
    }

    private EnumSet EP() {
        return EnumSet.noneOf(this._enumClass);
    }
}
