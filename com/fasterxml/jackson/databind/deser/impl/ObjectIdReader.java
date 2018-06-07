package com.fasterxml.jackson.databind.deser.impl;

import com.fasterxml.jackson.annotation.ObjectIdGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.PropertyName;
import com.fasterxml.jackson.databind.deser.SettableBeanProperty;
import com.fossil.aeu;
import com.fossil.aev;
import com.fossil.agy;
import java.io.IOException;
import java.io.Serializable;

public class ObjectIdReader implements Serializable {
    private static final long serialVersionUID = 1;
    protected final agy<Object> _deserializer;
    protected final JavaType _idType;
    public final ObjectIdGenerator<?> generator;
    public final SettableBeanProperty idProperty;
    public final PropertyName propertyName;
    public final aeu resolver;

    protected ObjectIdReader(JavaType javaType, PropertyName propertyName, ObjectIdGenerator<?> objectIdGenerator, agy<?> com_fossil_agy_, SettableBeanProperty settableBeanProperty, aeu com_fossil_aeu) {
        this._idType = javaType;
        this.propertyName = propertyName;
        this.generator = objectIdGenerator;
        this.resolver = com_fossil_aeu;
        this._deserializer = com_fossil_agy_;
        this.idProperty = settableBeanProperty;
    }

    @Deprecated
    protected ObjectIdReader(JavaType javaType, PropertyName propertyName, ObjectIdGenerator<?> objectIdGenerator, agy<?> com_fossil_agy_, SettableBeanProperty settableBeanProperty) {
        this(javaType, propertyName, objectIdGenerator, com_fossil_agy_, settableBeanProperty, new aev());
    }

    public static ObjectIdReader construct(JavaType javaType, PropertyName propertyName, ObjectIdGenerator<?> objectIdGenerator, agy<?> com_fossil_agy_, SettableBeanProperty settableBeanProperty, aeu com_fossil_aeu) {
        return new ObjectIdReader(javaType, propertyName, objectIdGenerator, com_fossil_agy_, settableBeanProperty, com_fossil_aeu);
    }

    @Deprecated
    public static ObjectIdReader construct(JavaType javaType, PropertyName propertyName, ObjectIdGenerator<?> objectIdGenerator, agy<?> com_fossil_agy_, SettableBeanProperty settableBeanProperty) {
        return construct(javaType, propertyName, objectIdGenerator, com_fossil_agy_, settableBeanProperty, new aev());
    }

    public agy<Object> getDeserializer() {
        return this._deserializer;
    }

    public JavaType getIdType() {
        return this._idType;
    }

    public boolean maySerializeAsObject() {
        return this.generator.maySerializeAsObject();
    }

    public boolean isValidReferencePropertyName(String str, JsonParser jsonParser) {
        return this.generator.isValidReferencePropertyName(str, jsonParser);
    }

    public Object readObjectReference(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
        return this._deserializer.deserialize(jsonParser, deserializationContext);
    }
}
