package com.fasterxml.jackson.databind.jsontype.impl;

import com.fasterxml.jackson.annotation.JsonTypeInfo.As;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.deser.std.NullifyingDeserializer;
import com.fossil.agv;
import com.fossil.agw;
import com.fossil.agy;
import com.fossil.ajs;
import com.fossil.ajt;
import com.fossil.ake;
import com.fossil.ami;
import java.io.IOException;
import java.io.Serializable;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public abstract class TypeDeserializerBase extends ajs implements Serializable {
    private static final long serialVersionUID = 1;
    protected final JavaType _baseType;
    protected final JavaType _defaultImpl;
    protected agy<Object> _defaultImplDeserializer;
    protected final Map<String, agy<Object>> _deserializers;
    protected final ajt _idResolver;
    protected final agv _property;
    protected final boolean _typeIdVisible;
    protected final String _typePropertyName;

    public abstract ajs forProperty(agv com_fossil_agv);

    public abstract As getTypeInclusion();

    protected TypeDeserializerBase(JavaType javaType, ajt com_fossil_ajt, String str, boolean z, Class<?> cls) {
        this._baseType = javaType;
        this._idResolver = com_fossil_ajt;
        this._typePropertyName = str;
        this._typeIdVisible = z;
        this._deserializers = new ConcurrentHashMap(16, 0.75f, 4);
        if (cls == null) {
            this._defaultImpl = null;
        } else {
            this._defaultImpl = javaType.forcedNarrowBy(cls);
        }
        this._property = null;
    }

    protected TypeDeserializerBase(TypeDeserializerBase typeDeserializerBase, agv com_fossil_agv) {
        this._baseType = typeDeserializerBase._baseType;
        this._idResolver = typeDeserializerBase._idResolver;
        this._typePropertyName = typeDeserializerBase._typePropertyName;
        this._typeIdVisible = typeDeserializerBase._typeIdVisible;
        this._deserializers = typeDeserializerBase._deserializers;
        this._defaultImpl = typeDeserializerBase._defaultImpl;
        this._defaultImplDeserializer = typeDeserializerBase._defaultImplDeserializer;
        this._property = com_fossil_agv;
    }

    public String baseTypeName() {
        return this._baseType.getRawClass().getName();
    }

    public final String getPropertyName() {
        return this._typePropertyName;
    }

    public ajt getTypeIdResolver() {
        return this._idResolver;
    }

    public Class<?> getDefaultImpl() {
        return this._defaultImpl == null ? null : this._defaultImpl.getRawClass();
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append('[').append(getClass().getName());
        stringBuilder.append("; base-type:").append(this._baseType);
        stringBuilder.append("; id-resolver: ").append(this._idResolver);
        stringBuilder.append(']');
        return stringBuilder.toString();
    }

    protected final agy<Object> _findDeserializer(DeserializationContext deserializationContext, String str) throws IOException {
        agy<Object> com_fossil_agy_java_lang_Object = (agy) this._deserializers.get(str);
        if (com_fossil_agy_java_lang_Object == null) {
            JavaType a = this._idResolver.mo1042a((agw) deserializationContext, str);
            if (a == null) {
                com_fossil_agy_java_lang_Object = _findDefaultImplDeserializer(deserializationContext);
                if (com_fossil_agy_java_lang_Object == null) {
                    com_fossil_agy_java_lang_Object = _handleUnknownTypeId(deserializationContext, str, this._idResolver, this._baseType);
                }
            } else {
                if (this._baseType != null && this._baseType.getClass() == a.getClass()) {
                    a = deserializationContext.getTypeFactory().constructSpecializedType(this._baseType, a.getRawClass());
                }
                com_fossil_agy_java_lang_Object = deserializationContext.findContextualValueDeserializer(a, this._property);
            }
            this._deserializers.put(str, com_fossil_agy_java_lang_Object);
        }
        return com_fossil_agy_java_lang_Object;
    }

    protected final agy<Object> _findDefaultImplDeserializer(DeserializationContext deserializationContext) throws IOException {
        if (this._defaultImpl == null) {
            if (deserializationContext.isEnabled(DeserializationFeature.FAIL_ON_INVALID_SUBTYPE)) {
                return null;
            }
            return NullifyingDeserializer.instance;
        } else if (ami.m3854D(this._defaultImpl.getRawClass())) {
            return NullifyingDeserializer.instance;
        } else {
            agy<Object> com_fossil_agy_java_lang_Object;
            synchronized (this._defaultImpl) {
                if (this._defaultImplDeserializer == null) {
                    this._defaultImplDeserializer = deserializationContext.findContextualValueDeserializer(this._defaultImpl, this._property);
                }
                com_fossil_agy_java_lang_Object = this._defaultImplDeserializer;
            }
            return com_fossil_agy_java_lang_Object;
        }
    }

    @Deprecated
    protected Object _deserializeWithNativeTypeId(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
        return _deserializeWithNativeTypeId(jsonParser, deserializationContext, jsonParser.Ay());
    }

    protected Object _deserializeWithNativeTypeId(JsonParser jsonParser, DeserializationContext deserializationContext, Object obj) throws IOException {
        agy _findDefaultImplDeserializer;
        if (obj == null) {
            _findDefaultImplDeserializer = _findDefaultImplDeserializer(deserializationContext);
            if (_findDefaultImplDeserializer == null) {
                throw deserializationContext.mappingException("No (native) type id found when one was expected for polymorphic type handling");
            }
        }
        _findDefaultImplDeserializer = _findDeserializer(deserializationContext, obj instanceof String ? (String) obj : String.valueOf(obj));
        return _findDefaultImplDeserializer.deserialize(jsonParser, deserializationContext);
    }

    protected agy<Object> _handleUnknownTypeId(DeserializationContext deserializationContext, String str, ajt com_fossil_ajt, JavaType javaType) throws IOException {
        String Gj;
        if (com_fossil_ajt instanceof ake) {
            Gj = ((ake) com_fossil_ajt).Gj();
            if (Gj == null) {
                Gj = "known type ids are not statically known";
            } else {
                Gj = "known type ids = " + Gj;
            }
        } else {
            Gj = null;
        }
        throw deserializationContext.unknownTypeException(this._baseType, str, Gj);
    }
}
