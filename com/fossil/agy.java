package com.fossil;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.deser.SettableBeanProperty;
import com.fasterxml.jackson.databind.deser.impl.ObjectIdReader;
import java.io.IOException;
import java.util.Collection;

public abstract class agy<T> {

    public static abstract class C1636a extends agy<Object> {
        private C1636a() {
        }
    }

    public abstract T deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException;

    public T deserialize(JsonParser jsonParser, DeserializationContext deserializationContext, T t) throws IOException, JsonProcessingException {
        throw new UnsupportedOperationException("Can not update object of type " + t.getClass().getName() + " (by deserializer of type " + getClass().getName() + ")");
    }

    public Object deserializeWithType(JsonParser jsonParser, DeserializationContext deserializationContext, ajs com_fossil_ajs) throws IOException {
        return com_fossil_ajs.deserializeTypedFromAny(jsonParser, deserializationContext);
    }

    public agy<T> unwrappingDeserializer(amo com_fossil_amo) {
        return this;
    }

    public agy<?> replaceDelegatee(agy<?> com_fossil_agy_) {
        throw new UnsupportedOperationException();
    }

    public Class<?> handledType() {
        return null;
    }

    public boolean isCachable() {
        return false;
    }

    public agy<?> getDelegatee() {
        return null;
    }

    public Collection<Object> getKnownPropertyNames() {
        return null;
    }

    public T getNullValue(DeserializationContext deserializationContext) throws JsonMappingException {
        return getNullValue();
    }

    public T getEmptyValue(DeserializationContext deserializationContext) throws JsonMappingException {
        return getEmptyValue();
    }

    public ObjectIdReader getObjectIdReader() {
        return null;
    }

    public SettableBeanProperty findBackReference(String str) {
        throw new IllegalArgumentException("Can not handle managed/back reference '" + str + "': type: value deserializer of type " + getClass().getName() + " does not support them");
    }

    @Deprecated
    public T getNullValue() {
        return null;
    }

    @Deprecated
    public T getEmptyValue() {
        return getNullValue();
    }
}
