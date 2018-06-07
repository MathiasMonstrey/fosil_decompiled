package com.fasterxml.jackson.databind.deser.impl;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fossil.agy;
import com.fossil.ajs;
import java.io.IOException;
import java.io.Serializable;

public final class TypeWrappedDeserializer extends agy<Object> implements Serializable {
    private static final long serialVersionUID = 1;
    protected final agy<Object> _deserializer;
    protected final ajs _typeDeserializer;

    public TypeWrappedDeserializer(ajs com_fossil_ajs, agy<?> com_fossil_agy_) {
        this._typeDeserializer = com_fossil_ajs;
        this._deserializer = com_fossil_agy_;
    }

    public Class<?> handledType() {
        return this._deserializer.handledType();
    }

    public Object deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
        return this._deserializer.deserializeWithType(jsonParser, deserializationContext, this._typeDeserializer);
    }

    public Object deserializeWithType(JsonParser jsonParser, DeserializationContext deserializationContext, ajs com_fossil_ajs) throws IOException {
        throw new IllegalStateException("Type-wrapped deserializer's deserializeWithType should never get called");
    }

    public Object deserialize(JsonParser jsonParser, DeserializationContext deserializationContext, Object obj) throws IOException {
        return this._deserializer.deserialize(jsonParser, deserializationContext, obj);
    }
}
