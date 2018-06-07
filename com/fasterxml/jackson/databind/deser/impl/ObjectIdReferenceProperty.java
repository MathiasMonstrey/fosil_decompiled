package com.fasterxml.jackson.databind.deser.impl;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.PropertyName;
import com.fasterxml.jackson.databind.deser.SettableBeanProperty;
import com.fasterxml.jackson.databind.deser.UnresolvedForwardReference;
import com.fasterxml.jackson.databind.introspect.AnnotatedMember;
import com.fossil.agy;
import com.fossil.ail.C1512a;
import com.fossil.aiy;
import java.io.IOException;
import java.lang.annotation.Annotation;

public class ObjectIdReferenceProperty extends SettableBeanProperty {
    private static final long serialVersionUID = 1;
    private final SettableBeanProperty _forward;

    public static final class C1514a extends C1512a {
        private final ObjectIdReferenceProperty aRC;
        public final Object aRk;

        public C1514a(ObjectIdReferenceProperty objectIdReferenceProperty, UnresolvedForwardReference unresolvedForwardReference, Class<?> cls, Object obj) {
            super(unresolvedForwardReference, cls);
            this.aRC = objectIdReferenceProperty;
            this.aRk = obj;
        }

        public void mo510i(Object obj, Object obj2) throws IOException {
            if (bv(obj)) {
                this.aRC.set(this.aRk, obj2);
                return;
            }
            throw new IllegalArgumentException("Trying to resolve a forward reference with id [" + obj + "] that wasn't previously seen as unresolved.");
        }
    }

    public ObjectIdReferenceProperty(SettableBeanProperty settableBeanProperty, aiy com_fossil_aiy) {
        super(settableBeanProperty);
        this._forward = settableBeanProperty;
        this._objectIdInfo = com_fossil_aiy;
    }

    public ObjectIdReferenceProperty(ObjectIdReferenceProperty objectIdReferenceProperty, agy<?> com_fossil_agy_) {
        super((SettableBeanProperty) objectIdReferenceProperty, (agy) com_fossil_agy_);
        this._forward = objectIdReferenceProperty._forward;
        this._objectIdInfo = objectIdReferenceProperty._objectIdInfo;
    }

    public ObjectIdReferenceProperty(ObjectIdReferenceProperty objectIdReferenceProperty, PropertyName propertyName) {
        super((SettableBeanProperty) objectIdReferenceProperty, propertyName);
        this._forward = objectIdReferenceProperty._forward;
        this._objectIdInfo = objectIdReferenceProperty._objectIdInfo;
    }

    public SettableBeanProperty withValueDeserializer(agy<?> com_fossil_agy_) {
        return new ObjectIdReferenceProperty(this, (agy) com_fossil_agy_);
    }

    public SettableBeanProperty withName(PropertyName propertyName) {
        return new ObjectIdReferenceProperty(this, propertyName);
    }

    public <A extends Annotation> A getAnnotation(Class<A> cls) {
        return this._forward.getAnnotation(cls);
    }

    public AnnotatedMember getMember() {
        return this._forward.getMember();
    }

    public int getCreatorIndex() {
        return this._forward.getCreatorIndex();
    }

    public void deserializeAndSet(JsonParser jsonParser, DeserializationContext deserializationContext, Object obj) throws IOException {
        deserializeSetAndReturn(jsonParser, deserializationContext, obj);
    }

    public Object deserializeSetAndReturn(JsonParser jsonParser, DeserializationContext deserializationContext, Object obj) throws IOException {
        try {
            return setAndReturn(obj, deserialize(jsonParser, deserializationContext));
        } catch (Throwable e) {
            Object obj2 = (this._objectIdInfo == null && this._valueDeserializer.getObjectIdReader() == null) ? null : 1;
            if (obj2 == null) {
                throw JsonMappingException.from(jsonParser, "Unresolved forward reference but no identity info.", e);
            }
            e.getRoid().m3405a(new C1514a(this, e, this._type.getRawClass(), obj));
            return null;
        }
    }

    public void set(Object obj, Object obj2) throws IOException {
        this._forward.set(obj, obj2);
    }

    public Object setAndReturn(Object obj, Object obj2) throws IOException {
        return this._forward.setAndReturn(obj, obj2);
    }
}
