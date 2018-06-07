package com.fasterxml.jackson.databind.deser;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.introspect.AnnotatedMethod;
import com.fossil.agv;
import com.fossil.agy;
import com.fossil.ail.C1512a;
import com.fossil.ajs;
import java.io.IOException;
import java.io.Serializable;

public class SettableAnyProperty implements Serializable {
    private static final long serialVersionUID = 1;
    protected final agv _property;
    protected final AnnotatedMethod _setter;
    protected final JavaType _type;
    protected agy<Object> _valueDeserializer;
    protected final ajs _valueTypeDeserializer;

    static class C1513a extends C1512a {
        private final SettableAnyProperty aRj;
        private final Object aRk;
        private final String aRl;

        public C1513a(SettableAnyProperty settableAnyProperty, UnresolvedForwardReference unresolvedForwardReference, Class<?> cls, Object obj, String str) {
            super(unresolvedForwardReference, cls);
            this.aRj = settableAnyProperty;
            this.aRk = obj;
            this.aRl = str;
        }

        public void mo510i(Object obj, Object obj2) throws IOException {
            if (bv(obj)) {
                this.aRj.set(this.aRk, this.aRl, obj2);
                return;
            }
            throw new IllegalArgumentException("Trying to resolve a forward reference with id [" + obj.toString() + "] that wasn't previously registered.");
        }
    }

    public SettableAnyProperty(agv com_fossil_agv, AnnotatedMethod annotatedMethod, JavaType javaType, agy<Object> com_fossil_agy_java_lang_Object, ajs com_fossil_ajs) {
        this._property = com_fossil_agv;
        this._setter = annotatedMethod;
        this._type = javaType;
        this._valueDeserializer = com_fossil_agy_java_lang_Object;
        this._valueTypeDeserializer = com_fossil_ajs;
    }

    public SettableAnyProperty withValueDeserializer(agy<Object> com_fossil_agy_java_lang_Object) {
        return new SettableAnyProperty(this._property, this._setter, this._type, com_fossil_agy_java_lang_Object, this._valueTypeDeserializer);
    }

    protected SettableAnyProperty(SettableAnyProperty settableAnyProperty) {
        this._property = settableAnyProperty._property;
        this._setter = settableAnyProperty._setter;
        this._type = settableAnyProperty._type;
        this._valueDeserializer = settableAnyProperty._valueDeserializer;
        this._valueTypeDeserializer = settableAnyProperty._valueTypeDeserializer;
    }

    Object readResolve() {
        if (this._setter != null && this._setter.getAnnotated() != null) {
            return this;
        }
        throw new IllegalArgumentException("Missing method (broken JDK (de)serialization?)");
    }

    public agv getProperty() {
        return this._property;
    }

    public boolean hasValueDeserializer() {
        return this._valueDeserializer != null;
    }

    public JavaType getType() {
        return this._type;
    }

    public final void deserializeAndSet(JsonParser jsonParser, DeserializationContext deserializationContext, Object obj, String str) throws IOException {
        try {
            set(obj, str, deserialize(jsonParser, deserializationContext));
        } catch (Throwable e) {
            if (this._valueDeserializer.getObjectIdReader() == null) {
                throw JsonMappingException.from(jsonParser, "Unresolved forward reference but no identity info.", e);
            }
            e.getRoid().m3405a(new C1513a(this, e, this._type.getRawClass(), obj, str));
        }
    }

    public Object deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
        if (jsonParser.zU() == JsonToken.VALUE_NULL) {
            return null;
        }
        if (this._valueTypeDeserializer != null) {
            return this._valueDeserializer.deserializeWithType(jsonParser, deserializationContext, this._valueTypeDeserializer);
        }
        return this._valueDeserializer.deserialize(jsonParser, deserializationContext);
    }

    public void set(Object obj, String str, Object obj2) throws IOException {
        try {
            this._setter.getAnnotated().invoke(obj, new Object[]{str, obj2});
        } catch (Exception e) {
            _throwAsIOE(e, str, obj2);
        }
    }

    protected void _throwAsIOE(Exception exception, String str, Object obj) throws IOException {
        if (exception instanceof IllegalArgumentException) {
            String name = obj == null ? "[NULL]" : obj.getClass().getName();
            StringBuilder append = new StringBuilder("Problem deserializing \"any\" property '").append(str);
            append.append("' of class " + getClassName() + " (expected type: ").append(this._type);
            append.append("; actual type: ").append(name).append(")");
            name = exception.getMessage();
            if (name != null) {
                append.append(", problem: ").append(name);
            } else {
                append.append(" (no error message provided)");
            }
            throw new JsonMappingException(append.toString(), null, exception);
        } else if (exception instanceof IOException) {
            throw ((IOException) exception);
        } else if (exception instanceof RuntimeException) {
            throw ((RuntimeException) exception);
        } else {
            while (exception.getCause() != null) {
                exception = exception.getCause();
            }
            throw new JsonMappingException(exception.getMessage(), null, exception);
        }
    }

    private String getClassName() {
        return this._setter.getDeclaringClass().getName();
    }

    public String toString() {
        return "[any property on class " + getClassName() + "]";
    }
}
