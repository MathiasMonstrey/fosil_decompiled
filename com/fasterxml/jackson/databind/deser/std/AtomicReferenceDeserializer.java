package com.fasterxml.jackson.databind.deser.std;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fossil.agv;
import com.fossil.agy;
import com.fossil.ahv;
import com.fossil.ajs;
import java.io.IOException;
import java.util.concurrent.atomic.AtomicReference;

public class AtomicReferenceDeserializer extends StdDeserializer<AtomicReference<?>> implements ahv {
    private static final long serialVersionUID = 1;
    protected final JavaType _referencedType;
    protected final agy<?> _valueDeserializer;
    protected final ajs _valueTypeDeserializer;

    public AtomicReferenceDeserializer(JavaType javaType) {
        this(javaType, null, null);
    }

    public AtomicReferenceDeserializer(JavaType javaType, ajs com_fossil_ajs, agy<?> com_fossil_agy_) {
        super(AtomicReference.class);
        this._referencedType = javaType;
        this._valueDeserializer = com_fossil_agy_;
        this._valueTypeDeserializer = com_fossil_ajs;
    }

    public AtomicReferenceDeserializer withResolved(ajs com_fossil_ajs, agy<?> com_fossil_agy_) {
        return new AtomicReferenceDeserializer(this._referencedType, com_fossil_ajs, com_fossil_agy_);
    }

    public AtomicReference<?> getNullValue(DeserializationContext deserializationContext) {
        return new AtomicReference();
    }

    @Deprecated
    public AtomicReference<?> getNullValue() {
        return new AtomicReference();
    }

    public agy<?> createContextual(DeserializationContext deserializationContext, agv com_fossil_agv) throws JsonMappingException {
        agy com_fossil_agy = this._valueDeserializer;
        ajs com_fossil_ajs = this._valueTypeDeserializer;
        if (com_fossil_agy == null) {
            com_fossil_agy = deserializationContext.findContextualValueDeserializer(this._referencedType, com_fossil_agv);
        }
        if (com_fossil_ajs != null) {
            com_fossil_ajs = com_fossil_ajs.forProperty(com_fossil_agv);
        }
        return (com_fossil_agy == this._valueDeserializer && com_fossil_ajs == this._valueTypeDeserializer) ? this : withResolved(com_fossil_ajs, com_fossil_agy);
    }

    public AtomicReference<?> deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
        if (this._valueTypeDeserializer != null) {
            return new AtomicReference(this._valueDeserializer.deserializeWithType(jsonParser, deserializationContext, this._valueTypeDeserializer));
        }
        return new AtomicReference(this._valueDeserializer.deserialize(jsonParser, deserializationContext));
    }

    public Object[] deserializeWithType(JsonParser jsonParser, DeserializationContext deserializationContext, ajs com_fossil_ajs) throws IOException {
        return (Object[]) com_fossil_ajs.deserializeTypedFromAny(jsonParser, deserializationContext);
    }
}
