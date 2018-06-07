package com.fasterxml.jackson.databind.jsontype.impl;

import com.fasterxml.jackson.annotation.JsonTypeInfo.As;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JavaType;
import com.fossil.agq;
import com.fossil.agv;
import com.fossil.agy;
import com.fossil.ajs;
import com.fossil.ajt;
import com.fossil.amt;
import java.io.IOException;
import java.io.Serializable;

public class AsArrayTypeDeserializer extends TypeDeserializerBase implements Serializable {
    private static final long serialVersionUID = 1;

    public AsArrayTypeDeserializer(JavaType javaType, ajt com_fossil_ajt, String str, boolean z, Class<?> cls) {
        super(javaType, com_fossil_ajt, str, z, cls);
    }

    public AsArrayTypeDeserializer(AsArrayTypeDeserializer asArrayTypeDeserializer, agv com_fossil_agv) {
        super(asArrayTypeDeserializer, com_fossil_agv);
    }

    public ajs forProperty(agv com_fossil_agv) {
        return com_fossil_agv == this._property ? this : new AsArrayTypeDeserializer(this, com_fossil_agv);
    }

    public As getTypeInclusion() {
        return As.WRAPPER_ARRAY;
    }

    public Object deserializeTypedFromArray(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
        return _deserialize(jsonParser, deserializationContext);
    }

    public Object deserializeTypedFromObject(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
        return _deserialize(jsonParser, deserializationContext);
    }

    public Object deserializeTypedFromScalar(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
        return _deserialize(jsonParser, deserializationContext);
    }

    public Object deserializeTypedFromAny(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
        return _deserialize(jsonParser, deserializationContext);
    }

    protected Object _deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
        Object Ay;
        if (jsonParser.Aw()) {
            Ay = jsonParser.Ay();
            if (Ay != null) {
                return _deserializeWithNativeTypeId(jsonParser, deserializationContext, Ay);
            }
        }
        boolean Aa = jsonParser.Aa();
        String _locateTypeId = _locateTypeId(jsonParser, deserializationContext);
        agy _findDeserializer = _findDeserializer(deserializationContext, _locateTypeId);
        if (this._typeIdVisible && !_usesExternalId() && jsonParser.zU() == JsonToken.START_OBJECT) {
            amt com_fossil_amt = new amt(null, false);
            com_fossil_amt.zJ();
            com_fossil_amt.aQ(this._typePropertyName);
            com_fossil_amt.writeString(_locateTypeId);
            jsonParser = agq.m3319a(com_fossil_amt.m3933e(jsonParser), jsonParser);
            jsonParser.zP();
        }
        Ay = _findDeserializer.deserialize(jsonParser, deserializationContext);
        if (!Aa || jsonParser.zP() == JsonToken.END_ARRAY) {
            return Ay;
        }
        throw deserializationContext.wrongTokenException(jsonParser, JsonToken.END_ARRAY, "expected closing END_ARRAY after type information and deserialized value");
    }

    protected String _locateTypeId(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
        if (jsonParser.Aa()) {
            if (jsonParser.zP() == JsonToken.VALUE_STRING) {
                String text = jsonParser.getText();
                jsonParser.zP();
                return text;
            } else if (this._defaultImpl != null) {
                return this._idResolver.Gi();
            } else {
                throw deserializationContext.wrongTokenException(jsonParser, JsonToken.VALUE_STRING, "need JSON String that contains type id (for subtype of " + baseTypeName() + ")");
            }
        } else if (this._defaultImpl != null) {
            return this._idResolver.Gi();
        } else {
            throw deserializationContext.wrongTokenException(jsonParser, JsonToken.START_ARRAY, "need JSON Array to contain As.WRAPPER_ARRAY type information for class " + baseTypeName());
        }
    }

    protected boolean _usesExternalId() {
        return false;
    }
}
