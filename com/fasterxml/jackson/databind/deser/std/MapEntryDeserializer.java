package com.fasterxml.jackson.databind.deser.std;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fossil.agv;
import com.fossil.agy;
import com.fossil.ahc;
import com.fossil.ahh;
import com.fossil.ahv;
import com.fossil.ahw;
import com.fossil.ajs;
import java.io.IOException;
import java.util.AbstractMap.SimpleEntry;
import java.util.Map.Entry;

@ahh
public class MapEntryDeserializer extends ContainerDeserializerBase<Entry<Object, Object>> implements ahv {
    private static final long serialVersionUID = 1;
    protected final ahc _keyDeserializer;
    protected final JavaType _type;
    protected final agy<Object> _valueDeserializer;
    protected final ajs _valueTypeDeserializer;

    public MapEntryDeserializer(JavaType javaType, ahc com_fossil_ahc, agy<Object> com_fossil_agy_java_lang_Object, ajs com_fossil_ajs) {
        super(javaType);
        if (javaType.containedTypeCount() != 2) {
            throw new IllegalArgumentException("Missing generic type information for " + javaType);
        }
        this._type = javaType;
        this._keyDeserializer = com_fossil_ahc;
        this._valueDeserializer = com_fossil_agy_java_lang_Object;
        this._valueTypeDeserializer = com_fossil_ajs;
    }

    protected MapEntryDeserializer(MapEntryDeserializer mapEntryDeserializer) {
        super(mapEntryDeserializer._type);
        this._type = mapEntryDeserializer._type;
        this._keyDeserializer = mapEntryDeserializer._keyDeserializer;
        this._valueDeserializer = mapEntryDeserializer._valueDeserializer;
        this._valueTypeDeserializer = mapEntryDeserializer._valueTypeDeserializer;
    }

    protected MapEntryDeserializer(MapEntryDeserializer mapEntryDeserializer, ahc com_fossil_ahc, agy<Object> com_fossil_agy_java_lang_Object, ajs com_fossil_ajs) {
        super(mapEntryDeserializer._type);
        this._type = mapEntryDeserializer._type;
        this._keyDeserializer = com_fossil_ahc;
        this._valueDeserializer = com_fossil_agy_java_lang_Object;
        this._valueTypeDeserializer = com_fossil_ajs;
    }

    protected MapEntryDeserializer withResolved(ahc com_fossil_ahc, ajs com_fossil_ajs, agy<?> com_fossil_agy_) {
        return (this._keyDeserializer == com_fossil_ahc && this._valueDeserializer == com_fossil_agy_ && this._valueTypeDeserializer == com_fossil_ajs) ? this : new MapEntryDeserializer(this, com_fossil_ahc, (agy) com_fossil_agy_, com_fossil_ajs);
    }

    public agy<?> createContextual(DeserializationContext deserializationContext, agv com_fossil_agv) throws JsonMappingException {
        ahc com_fossil_ahc = this._keyDeserializer;
        if (com_fossil_ahc == null) {
            com_fossil_ahc = deserializationContext.findKeyDeserializer(this._type.containedType(0), com_fossil_agv);
        } else if (com_fossil_ahc instanceof ahw) {
            com_fossil_ahc = ((ahw) com_fossil_ahc).m3371a(deserializationContext, com_fossil_agv);
        }
        agy findConvertingContentDeserializer = findConvertingContentDeserializer(deserializationContext, com_fossil_agv, this._valueDeserializer);
        JavaType containedType = this._type.containedType(1);
        if (findConvertingContentDeserializer == null) {
            findConvertingContentDeserializer = deserializationContext.findContextualValueDeserializer(containedType, com_fossil_agv);
        } else {
            findConvertingContentDeserializer = deserializationContext.handleSecondaryContextualization(findConvertingContentDeserializer, com_fossil_agv, containedType);
        }
        ajs com_fossil_ajs = this._valueTypeDeserializer;
        if (com_fossil_ajs != null) {
            com_fossil_ajs = com_fossil_ajs.forProperty(com_fossil_agv);
        }
        return withResolved(com_fossil_ahc, com_fossil_ajs, findConvertingContentDeserializer);
    }

    public JavaType getContentType() {
        return this._type.containedType(1);
    }

    public agy<Object> getContentDeserializer() {
        return this._valueDeserializer;
    }

    public Entry<Object, Object> deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
        JsonToken zU = jsonParser.zU();
        if (zU != JsonToken.START_OBJECT && zU != JsonToken.FIELD_NAME && zU != JsonToken.END_OBJECT) {
            return (Entry) _deserializeFromEmpty(jsonParser, deserializationContext);
        }
        if (zU == JsonToken.START_OBJECT) {
            zU = jsonParser.zP();
        }
        if (zU == JsonToken.FIELD_NAME) {
            ahc com_fossil_ahc = this._keyDeserializer;
            agy com_fossil_agy = this._valueDeserializer;
            ajs com_fossil_ajs = this._valueTypeDeserializer;
            String zW = jsonParser.zW();
            Object deserializeKey = com_fossil_ahc.deserializeKey(zW, deserializationContext);
            Object obj = null;
            try {
                if (jsonParser.zP() == JsonToken.VALUE_NULL) {
                    obj = com_fossil_agy.getNullValue(deserializationContext);
                } else if (com_fossil_ajs == null) {
                    obj = com_fossil_agy.deserialize(jsonParser, deserializationContext);
                } else {
                    obj = com_fossil_agy.deserializeWithType(jsonParser, deserializationContext, com_fossil_ajs);
                }
            } catch (Throwable e) {
                wrapAndThrow(e, Entry.class, zW);
            }
            JsonToken zP = jsonParser.zP();
            if (zP == JsonToken.END_OBJECT) {
                return new SimpleEntry(deserializeKey, obj);
            }
            if (zP == JsonToken.FIELD_NAME) {
                throw deserializationContext.mappingException("Problem binding JSON into Map.Entry: more than one entry in JSON (second field: '" + jsonParser.zW() + "')");
            }
            throw deserializationContext.mappingException("Problem binding JSON into Map.Entry: unexpected content after JSON Object entry: " + zP);
        } else if (zU == JsonToken.END_OBJECT) {
            throw deserializationContext.mappingException("Can not deserialize a Map.Entry out of empty JSON Object");
        } else {
            throw deserializationContext.mappingException(handledType(), zU);
        }
    }

    public Entry<Object, Object> deserialize(JsonParser jsonParser, DeserializationContext deserializationContext, Entry<Object, Object> entry) throws IOException {
        throw new IllegalStateException("Can not update Map.Entry values");
    }

    public Object deserializeWithType(JsonParser jsonParser, DeserializationContext deserializationContext, ajs com_fossil_ajs) throws IOException, JsonProcessingException {
        return com_fossil_ajs.deserializeTypedFromObject(jsonParser, deserializationContext);
    }

    public JavaType getValueType() {
        return this._type;
    }
}
