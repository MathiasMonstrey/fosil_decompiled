package com.fasterxml.jackson.databind.deser.impl;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.PropertyName;
import com.fasterxml.jackson.databind.deser.SettableBeanProperty;
import com.fasterxml.jackson.databind.introspect.AnnotatedField;
import com.fasterxml.jackson.databind.introspect.AnnotatedMember;
import com.fossil.agy;
import com.fossil.aiv;
import com.fossil.ajs;
import com.fossil.amc;
import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

public final class FieldProperty extends SettableBeanProperty {
    private static final long serialVersionUID = 1;
    protected final AnnotatedField _annotated;
    protected final transient Field _field;

    public FieldProperty(aiv com_fossil_aiv, JavaType javaType, ajs com_fossil_ajs, amc com_fossil_amc, AnnotatedField annotatedField) {
        super(com_fossil_aiv, javaType, com_fossil_ajs, com_fossil_amc);
        this._annotated = annotatedField;
        this._field = annotatedField.getAnnotated();
    }

    protected FieldProperty(FieldProperty fieldProperty, agy<?> com_fossil_agy_) {
        super((SettableBeanProperty) fieldProperty, (agy) com_fossil_agy_);
        this._annotated = fieldProperty._annotated;
        this._field = fieldProperty._field;
    }

    protected FieldProperty(FieldProperty fieldProperty, PropertyName propertyName) {
        super((SettableBeanProperty) fieldProperty, propertyName);
        this._annotated = fieldProperty._annotated;
        this._field = fieldProperty._field;
    }

    protected FieldProperty(FieldProperty fieldProperty) {
        super(fieldProperty);
        this._annotated = fieldProperty._annotated;
        Field annotated = this._annotated.getAnnotated();
        if (annotated == null) {
            throw new IllegalArgumentException("Missing field (broken JDK (de)serialization?)");
        }
        this._field = annotated;
    }

    public FieldProperty withName(PropertyName propertyName) {
        return new FieldProperty(this, propertyName);
    }

    public FieldProperty withValueDeserializer(agy<?> com_fossil_agy_) {
        return new FieldProperty(this, (agy) com_fossil_agy_);
    }

    public <A extends Annotation> A getAnnotation(Class<A> cls) {
        return this._annotated == null ? null : this._annotated.getAnnotation(cls);
    }

    public AnnotatedMember getMember() {
        return this._annotated;
    }

    public void deserializeAndSet(JsonParser jsonParser, DeserializationContext deserializationContext, Object obj) throws IOException {
        Object deserialize = deserialize(jsonParser, deserializationContext);
        try {
            this._field.set(obj, deserialize);
        } catch (Exception e) {
            _throwAsIOE(e, deserialize);
        }
    }

    public Object deserializeSetAndReturn(JsonParser jsonParser, DeserializationContext deserializationContext, Object obj) throws IOException {
        Object deserialize = deserialize(jsonParser, deserializationContext);
        try {
            this._field.set(obj, deserialize);
        } catch (Exception e) {
            _throwAsIOE(e, deserialize);
        }
        return obj;
    }

    public final void set(Object obj, Object obj2) throws IOException {
        try {
            this._field.set(obj, obj2);
        } catch (Exception e) {
            _throwAsIOE(e, obj2);
        }
    }

    public Object setAndReturn(Object obj, Object obj2) throws IOException {
        try {
            this._field.set(obj, obj2);
        } catch (Exception e) {
            _throwAsIOE(e, obj2);
        }
        return obj;
    }

    Object readResolve() {
        return new FieldProperty(this);
    }
}
