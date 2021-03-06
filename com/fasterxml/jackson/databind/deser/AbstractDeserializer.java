package com.fasterxml.jackson.databind.deser;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.deser.impl.ObjectIdReader;
import com.fossil.agu;
import com.fossil.agy;
import com.fossil.aht;
import com.fossil.ail;
import com.fossil.ajs;
import java.io.IOException;
import java.io.Serializable;
import java.util.Map;

public class AbstractDeserializer extends agy<Object> implements Serializable {
    private static final long serialVersionUID = 1;
    protected final boolean _acceptBoolean;
    protected final boolean _acceptDouble;
    protected final boolean _acceptInt;
    protected final boolean _acceptString;
    protected final Map<String, SettableBeanProperty> _backRefProperties;
    protected final JavaType _baseType;
    protected final ObjectIdReader _objectIdReader;

    public AbstractDeserializer(aht com_fossil_aht, agu com_fossil_agu, Map<String, SettableBeanProperty> map) {
        boolean z;
        boolean z2 = false;
        this._baseType = com_fossil_agu.getType();
        this._objectIdReader = com_fossil_aht.getObjectIdReader();
        this._backRefProperties = map;
        Class rawClass = this._baseType.getRawClass();
        this._acceptString = rawClass.isAssignableFrom(String.class);
        if (rawClass == Boolean.TYPE || rawClass.isAssignableFrom(Boolean.class)) {
            z = true;
        } else {
            z = false;
        }
        this._acceptBoolean = z;
        if (rawClass == Integer.TYPE || rawClass.isAssignableFrom(Integer.class)) {
            z = true;
        } else {
            z = false;
        }
        this._acceptInt = z;
        if (rawClass == Double.TYPE || rawClass.isAssignableFrom(Double.class)) {
            z2 = true;
        }
        this._acceptDouble = z2;
    }

    protected AbstractDeserializer(agu com_fossil_agu) {
        boolean z;
        boolean z2 = false;
        this._baseType = com_fossil_agu.getType();
        this._objectIdReader = null;
        this._backRefProperties = null;
        Class rawClass = this._baseType.getRawClass();
        this._acceptString = rawClass.isAssignableFrom(String.class);
        if (rawClass == Boolean.TYPE || rawClass.isAssignableFrom(Boolean.class)) {
            z = true;
        } else {
            z = false;
        }
        this._acceptBoolean = z;
        if (rawClass == Integer.TYPE || rawClass.isAssignableFrom(Integer.class)) {
            z = true;
        } else {
            z = false;
        }
        this._acceptInt = z;
        if (rawClass == Double.TYPE || rawClass.isAssignableFrom(Double.class)) {
            z2 = true;
        }
        this._acceptDouble = z2;
    }

    public static AbstractDeserializer constructForNonPOJO(agu com_fossil_agu) {
        return new AbstractDeserializer(com_fossil_agu);
    }

    public Class<?> handledType() {
        return this._baseType.getRawClass();
    }

    public boolean isCachable() {
        return true;
    }

    public ObjectIdReader getObjectIdReader() {
        return this._objectIdReader;
    }

    public SettableBeanProperty findBackReference(String str) {
        return this._backRefProperties == null ? null : (SettableBeanProperty) this._backRefProperties.get(str);
    }

    public Object deserializeWithType(JsonParser jsonParser, DeserializationContext deserializationContext, ajs com_fossil_ajs) throws IOException, JsonProcessingException {
        if (this._objectIdReader != null) {
            JsonToken zU = jsonParser.zU();
            if (zU != null && zU.isScalarValue()) {
                return _deserializeFromObjectId(jsonParser, deserializationContext);
            }
        }
        Object _deserializeIfNatural = _deserializeIfNatural(jsonParser, deserializationContext);
        return _deserializeIfNatural == null ? com_fossil_ajs.deserializeTypedFromObject(jsonParser, deserializationContext) : _deserializeIfNatural;
    }

    public Object deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
        throw deserializationContext.instantiationException(this._baseType.getRawClass(), "abstract types either need to be mapped to concrete types, have custom deserializer, or be instantiated with additional type information");
    }

    protected Object _deserializeIfNatural(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
        switch (jsonParser.zV()) {
            case 6:
                if (this._acceptString) {
                    return jsonParser.getText();
                }
                break;
            case 7:
                if (this._acceptInt) {
                    return Integer.valueOf(jsonParser.getIntValue());
                }
                break;
            case 8:
                if (this._acceptDouble) {
                    return Double.valueOf(jsonParser.Ao());
                }
                break;
            case 9:
                if (this._acceptBoolean) {
                    return Boolean.TRUE;
                }
                break;
            case 10:
                if (this._acceptBoolean) {
                    return Boolean.FALSE;
                }
                break;
        }
        return null;
    }

    protected Object _deserializeFromObjectId(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
        Object readObjectReference = this._objectIdReader.readObjectReference(jsonParser, deserializationContext);
        ail findObjectId = deserializationContext.findObjectId(readObjectReference, this._objectIdReader.generator, this._objectIdReader.resolver);
        Object EL = findObjectId.EL();
        if (EL != null) {
            return EL;
        }
        throw new UnresolvedForwardReference("Could not resolve Object Id [" + readObjectReference + "] -- unresolved forward-reference?", jsonParser.zZ(), findObjectId);
    }
}
