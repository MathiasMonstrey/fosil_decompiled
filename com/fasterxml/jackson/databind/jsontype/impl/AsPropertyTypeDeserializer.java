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

public class AsPropertyTypeDeserializer extends AsArrayTypeDeserializer {
    private static final long serialVersionUID = 1;
    protected final As _inclusion;

    public AsPropertyTypeDeserializer(JavaType javaType, ajt com_fossil_ajt, String str, boolean z, Class<?> cls) {
        this(javaType, com_fossil_ajt, str, z, cls, As.PROPERTY);
    }

    public AsPropertyTypeDeserializer(JavaType javaType, ajt com_fossil_ajt, String str, boolean z, Class<?> cls, As as) {
        super(javaType, com_fossil_ajt, str, z, cls);
        this._inclusion = as;
    }

    public AsPropertyTypeDeserializer(AsPropertyTypeDeserializer asPropertyTypeDeserializer, agv com_fossil_agv) {
        super(asPropertyTypeDeserializer, com_fossil_agv);
        this._inclusion = asPropertyTypeDeserializer._inclusion;
    }

    public ajs forProperty(agv com_fossil_agv) {
        return com_fossil_agv == this._property ? this : new AsPropertyTypeDeserializer(this, com_fossil_agv);
    }

    public As getTypeInclusion() {
        return this._inclusion;
    }

    public Object deserializeTypedFromObject(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
        if (jsonParser.Aw()) {
            Object Ay = jsonParser.Ay();
            if (Ay != null) {
                return _deserializeWithNativeTypeId(jsonParser, deserializationContext, Ay);
            }
        }
        JsonToken zU = jsonParser.zU();
        if (zU == JsonToken.START_OBJECT) {
            zU = jsonParser.zP();
        } else if (zU == JsonToken.START_ARRAY) {
            return _deserializeTypedUsingDefaultImpl(jsonParser, deserializationContext, null);
        } else {
            if (zU != JsonToken.FIELD_NAME) {
                return _deserializeTypedUsingDefaultImpl(jsonParser, deserializationContext, null);
            }
        }
        JsonToken jsonToken = zU;
        amt com_fossil_amt = null;
        while (jsonToken == JsonToken.FIELD_NAME) {
            String zW = jsonParser.zW();
            jsonParser.zP();
            if (this._typePropertyName.equals(zW)) {
                return _deserializeTypedForId(jsonParser, deserializationContext, com_fossil_amt);
            }
            if (com_fossil_amt == null) {
                com_fossil_amt = new amt(null, false);
            }
            com_fossil_amt.aQ(zW);
            com_fossil_amt.mo1097b(jsonParser);
            jsonToken = jsonParser.zP();
        }
        return _deserializeTypedUsingDefaultImpl(jsonParser, deserializationContext, com_fossil_amt);
    }

    protected Object _deserializeTypedForId(JsonParser jsonParser, DeserializationContext deserializationContext, amt com_fossil_amt) throws IOException {
        String text = jsonParser.getText();
        agy _findDeserializer = _findDeserializer(deserializationContext, text);
        if (this._typeIdVisible) {
            if (com_fossil_amt == null) {
                com_fossil_amt = new amt(null, false);
            }
            com_fossil_amt.aQ(jsonParser.zW());
            com_fossil_amt.writeString(text);
        }
        if (com_fossil_amt != null) {
            jsonParser = agq.m3319a(com_fossil_amt.m3933e(jsonParser), jsonParser);
        }
        jsonParser.zP();
        return _findDeserializer.deserialize(jsonParser, deserializationContext);
    }

    protected Object _deserializeTypedUsingDefaultImpl(JsonParser jsonParser, DeserializationContext deserializationContext, amt com_fossil_amt) throws IOException {
        agy _findDefaultImplDeserializer = _findDefaultImplDeserializer(deserializationContext);
        if (_findDefaultImplDeserializer != null) {
            if (com_fossil_amt != null) {
                com_fossil_amt.zK();
                jsonParser = com_fossil_amt.m3933e(jsonParser);
                jsonParser.zP();
            }
            return _findDefaultImplDeserializer.deserialize(jsonParser, deserializationContext);
        }
        Object deserializeIfNatural = ajs.deserializeIfNatural(jsonParser, deserializationContext, this._baseType);
        if (deserializeIfNatural != null) {
            return deserializeIfNatural;
        }
        if (jsonParser.zU() == JsonToken.START_ARRAY) {
            return super.deserializeTypedFromAny(jsonParser, deserializationContext);
        }
        throw deserializationContext.wrongTokenException(jsonParser, JsonToken.FIELD_NAME, "missing property '" + this._typePropertyName + "' that is to contain type id  (for class " + baseTypeName() + ")");
    }

    public Object deserializeTypedFromAny(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
        if (jsonParser.zU() == JsonToken.START_ARRAY) {
            return super.deserializeTypedFromArray(jsonParser, deserializationContext);
        }
        return deserializeTypedFromObject(jsonParser, deserializationContext);
    }
}
