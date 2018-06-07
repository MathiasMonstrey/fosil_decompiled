package com.fossil;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonMappingException;
import java.io.IOException;
import java.util.Iterator;

public abstract class ahb<T> implements aje {

    public static abstract class C1638a extends ahb<Object> {
    }

    public abstract void serialize(T t, JsonGenerator jsonGenerator, ahg com_fossil_ahg) throws IOException, JsonProcessingException;

    public ahb<T> unwrappingSerializer(amo com_fossil_amo) {
        return this;
    }

    public ahb<T> replaceDelegatee(ahb<?> com_fossil_ahb_) {
        throw new UnsupportedOperationException();
    }

    public ahb<?> withFilterId(Object obj) {
        return this;
    }

    public void serializeWithType(T t, JsonGenerator jsonGenerator, ahg com_fossil_ahg, ajv com_fossil_ajv) throws IOException {
        Class handledType = handledType();
        if (handledType == null) {
            handledType = t.getClass();
        }
        throw com_fossil_ahg.mappingException("Type id handling not implemented for type %s (by serializer of type %s)", handledType.getName(), getClass().getName());
    }

    public Class<T> handledType() {
        return null;
    }

    @Deprecated
    public boolean isEmpty(T t) {
        return isEmpty(null, t);
    }

    public boolean isEmpty(ahg com_fossil_ahg, T t) {
        return t == null;
    }

    public boolean usesObjectId() {
        return false;
    }

    public boolean isUnwrappingSerializer() {
        return false;
    }

    public ahb<?> getDelegatee() {
        return null;
    }

    public Iterator<alk> properties() {
        return aml.Hk();
    }

    public void acceptJsonFormatVisitor(ajg com_fossil_ajg, JavaType javaType) throws JsonMappingException {
        if (com_fossil_ajg != null) {
            com_fossil_ajg.mo1023k(javaType);
        }
    }
}
