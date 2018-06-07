package com.fasterxml.jackson.databind.deser.impl;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.PropertyName;
import com.fasterxml.jackson.databind.deser.SettableBeanProperty;
import com.fasterxml.jackson.databind.introspect.AnnotatedMember;
import com.fasterxml.jackson.databind.introspect.AnnotatedMethod;
import com.fossil.agy;
import com.fossil.aiv;
import com.fossil.ajs;
import com.fossil.amc;
import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

public final class SetterlessProperty extends SettableBeanProperty {
    private static final long serialVersionUID = 1;
    protected final AnnotatedMethod _annotated;
    protected final Method _getter;

    public SetterlessProperty(aiv com_fossil_aiv, JavaType javaType, ajs com_fossil_ajs, amc com_fossil_amc, AnnotatedMethod annotatedMethod) {
        super(com_fossil_aiv, javaType, com_fossil_ajs, com_fossil_amc);
        this._annotated = annotatedMethod;
        this._getter = annotatedMethod.getAnnotated();
    }

    protected SetterlessProperty(SetterlessProperty setterlessProperty, agy<?> com_fossil_agy_) {
        super((SettableBeanProperty) setterlessProperty, (agy) com_fossil_agy_);
        this._annotated = setterlessProperty._annotated;
        this._getter = setterlessProperty._getter;
    }

    protected SetterlessProperty(SetterlessProperty setterlessProperty, PropertyName propertyName) {
        super((SettableBeanProperty) setterlessProperty, propertyName);
        this._annotated = setterlessProperty._annotated;
        this._getter = setterlessProperty._getter;
    }

    public SetterlessProperty withName(PropertyName propertyName) {
        return new SetterlessProperty(this, propertyName);
    }

    public SetterlessProperty withValueDeserializer(agy<?> com_fossil_agy_) {
        return new SetterlessProperty(this, (agy) com_fossil_agy_);
    }

    public <A extends Annotation> A getAnnotation(Class<A> cls) {
        return this._annotated.getAnnotation(cls);
    }

    public AnnotatedMember getMember() {
        return this._annotated;
    }

    public final void deserializeAndSet(JsonParser jsonParser, DeserializationContext deserializationContext, Object obj) throws IOException, JsonProcessingException {
        if (jsonParser.zU() != JsonToken.VALUE_NULL) {
            if (this._valueTypeDeserializer != null) {
                throw new JsonMappingException("Problem deserializing 'setterless' property (\"" + getName() + "\"): no way to handle typed deser with setterless yet");
            }
            try {
                Object invoke = this._getter.invoke(obj, new Object[0]);
                if (invoke == null) {
                    throw new JsonMappingException("Problem deserializing 'setterless' property '" + getName() + "': get method returned null");
                }
                this._valueDeserializer.deserialize(jsonParser, deserializationContext, invoke);
            } catch (Exception e) {
                _throwAsIOE(e);
            }
        }
    }

    public Object deserializeSetAndReturn(JsonParser jsonParser, DeserializationContext deserializationContext, Object obj) throws IOException, JsonProcessingException {
        deserializeAndSet(jsonParser, deserializationContext, obj);
        return obj;
    }

    public final void set(Object obj, Object obj2) throws IOException {
        throw new UnsupportedOperationException("Should never call 'set' on setterless property");
    }

    public Object setAndReturn(Object obj, Object obj2) throws IOException {
        set(obj, obj2);
        return null;
    }
}
