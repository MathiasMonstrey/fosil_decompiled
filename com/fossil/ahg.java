package com.fossil;

import com.fasterxml.jackson.annotation.ObjectIdGenerator;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.AnnotationIntrospector;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.SerializationConfig;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.cfg.ContextAttributes;
import com.fasterxml.jackson.databind.ser.impl.FailingSerializer;
import com.fasterxml.jackson.databind.ser.impl.UnknownSerializer;
import com.fasterxml.jackson.databind.ser.std.NullSerializer;
import com.fasterxml.jackson.databind.type.TypeFactory;
import java.io.IOException;
import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

public abstract class ahg extends agw {
    protected static final boolean CACHE_UNKNOWN_MAPPINGS = false;
    public static final ahb<Object> DEFAULT_NULL_KEY_SERIALIZER = new FailingSerializer("Null key for a Map not allowed in JSON (use a converting NullKeySerializer?)");
    protected static final ahb<Object> DEFAULT_UNKNOWN_SERIALIZER = new UnknownSerializer();
    protected transient ContextAttributes _attributes;
    protected final SerializationConfig _config;
    protected DateFormat _dateFormat;
    protected ahb<Object> _keySerializer;
    protected final alu _knownSerializers;
    protected ahb<Object> _nullKeySerializer;
    protected ahb<Object> _nullValueSerializer;
    protected final Class<?> _serializationView;
    protected final alm _serializerCache;
    protected final aln _serializerFactory;
    protected final boolean _stdNullValueSerializer;
    protected ahb<Object> _unknownTypeSerializer;

    public abstract alx findObjectId(Object obj, ObjectIdGenerator<?> objectIdGenerator);

    public abstract ahb<Object> serializerInstance(aiq com_fossil_aiq, Object obj) throws JsonMappingException;

    public ahg() {
        this._unknownTypeSerializer = DEFAULT_UNKNOWN_SERIALIZER;
        this._nullValueSerializer = NullSerializer.instance;
        this._nullKeySerializer = DEFAULT_NULL_KEY_SERIALIZER;
        this._config = null;
        this._serializerFactory = null;
        this._serializerCache = new alm();
        this._knownSerializers = null;
        this._serializationView = null;
        this._attributes = null;
        this._stdNullValueSerializer = true;
    }

    protected ahg(ahg com_fossil_ahg, SerializationConfig serializationConfig, aln com_fossil_aln) {
        this._unknownTypeSerializer = DEFAULT_UNKNOWN_SERIALIZER;
        this._nullValueSerializer = NullSerializer.instance;
        this._nullKeySerializer = DEFAULT_NULL_KEY_SERIALIZER;
        if (serializationConfig == null) {
            throw new NullPointerException();
        }
        this._serializerFactory = com_fossil_aln;
        this._config = serializationConfig;
        this._serializerCache = com_fossil_ahg._serializerCache;
        this._unknownTypeSerializer = com_fossil_ahg._unknownTypeSerializer;
        this._keySerializer = com_fossil_ahg._keySerializer;
        this._nullValueSerializer = com_fossil_ahg._nullValueSerializer;
        this._nullKeySerializer = com_fossil_ahg._nullKeySerializer;
        this._stdNullValueSerializer = this._nullValueSerializer == DEFAULT_NULL_KEY_SERIALIZER;
        this._serializationView = serializationConfig.getActiveView();
        this._attributes = serializationConfig.getAttributes();
        this._knownSerializers = this._serializerCache.GK();
    }

    protected ahg(ahg com_fossil_ahg) {
        this._unknownTypeSerializer = DEFAULT_UNKNOWN_SERIALIZER;
        this._nullValueSerializer = NullSerializer.instance;
        this._nullKeySerializer = DEFAULT_NULL_KEY_SERIALIZER;
        this._config = null;
        this._serializationView = null;
        this._serializerFactory = null;
        this._knownSerializers = null;
        this._serializerCache = new alm();
        this._unknownTypeSerializer = com_fossil_ahg._unknownTypeSerializer;
        this._keySerializer = com_fossil_ahg._keySerializer;
        this._nullValueSerializer = com_fossil_ahg._nullValueSerializer;
        this._nullKeySerializer = com_fossil_ahg._nullKeySerializer;
        this._stdNullValueSerializer = com_fossil_ahg._stdNullValueSerializer;
    }

    public void setDefaultKeySerializer(ahb<Object> com_fossil_ahb_java_lang_Object) {
        if (com_fossil_ahb_java_lang_Object == null) {
            throw new IllegalArgumentException("Can not pass null JsonSerializer");
        }
        this._keySerializer = com_fossil_ahb_java_lang_Object;
    }

    public void setNullValueSerializer(ahb<Object> com_fossil_ahb_java_lang_Object) {
        if (com_fossil_ahb_java_lang_Object == null) {
            throw new IllegalArgumentException("Can not pass null JsonSerializer");
        }
        this._nullValueSerializer = com_fossil_ahb_java_lang_Object;
    }

    public void setNullKeySerializer(ahb<Object> com_fossil_ahb_java_lang_Object) {
        if (com_fossil_ahb_java_lang_Object == null) {
            throw new IllegalArgumentException("Can not pass null JsonSerializer");
        }
        this._nullKeySerializer = com_fossil_ahb_java_lang_Object;
    }

    public final SerializationConfig getConfig() {
        return this._config;
    }

    public final AnnotationIntrospector getAnnotationIntrospector() {
        return this._config.getAnnotationIntrospector();
    }

    public final TypeFactory getTypeFactory() {
        return this._config.getTypeFactory();
    }

    public final Class<?> getActiveView() {
        return this._serializationView;
    }

    @Deprecated
    public final Class<?> getSerializationView() {
        return this._serializationView;
    }

    public Locale getLocale() {
        return this._config.getLocale();
    }

    public TimeZone getTimeZone() {
        return this._config.getTimeZone();
    }

    public Object getAttribute(Object obj) {
        return this._attributes.getAttribute(obj);
    }

    public ahg setAttribute(Object obj, Object obj2) {
        this._attributes = this._attributes.withPerCallAttribute(obj, obj2);
        return this;
    }

    public final boolean isEnabled(SerializationFeature serializationFeature) {
        return this._config.isEnabled(serializationFeature);
    }

    public final boolean hasSerializationFeatures(int i) {
        return this._config.hasSerializationFeatures(i);
    }

    public final alh getFilterProvider() {
        return this._config.getFilterProvider();
    }

    public ahb<Object> findValueSerializer(Class<?> cls, agv com_fossil_agv) throws JsonMappingException {
        ahb m = this._knownSerializers.m3787m(cls);
        if (m == null) {
            m = this._serializerCache.m3734m(cls);
            if (m == null) {
                m = this._serializerCache.m3736o(this._config.constructType((Class) cls));
                if (m == null) {
                    m = _createAndCacheUntypedSerializer((Class) cls);
                    if (m == null) {
                        return getUnknownTypeSerializer(cls);
                    }
                }
            }
        }
        return handleSecondaryContextualization(m, com_fossil_agv);
    }

    public ahb<Object> findValueSerializer(JavaType javaType, agv com_fossil_agv) throws JsonMappingException {
        ahb o = this._knownSerializers.m3789o(javaType);
        if (o == null) {
            o = this._serializerCache.m3736o(javaType);
            if (o == null) {
                o = _createAndCacheUntypedSerializer(javaType);
                if (o == null) {
                    return getUnknownTypeSerializer(javaType.getRawClass());
                }
            }
        }
        return handleSecondaryContextualization(o, com_fossil_agv);
    }

    public ahb<Object> findValueSerializer(Class<?> cls) throws JsonMappingException {
        ahb<Object> m = this._knownSerializers.m3787m(cls);
        if (m != null) {
            return m;
        }
        m = this._serializerCache.m3734m(cls);
        if (m != null) {
            return m;
        }
        m = this._serializerCache.m3736o(this._config.constructType((Class) cls));
        if (m != null) {
            return m;
        }
        m = _createAndCacheUntypedSerializer((Class) cls);
        if (m == null) {
            return getUnknownTypeSerializer(cls);
        }
        return m;
    }

    public ahb<Object> findValueSerializer(JavaType javaType) throws JsonMappingException {
        ahb<Object> o = this._knownSerializers.m3789o(javaType);
        if (o != null) {
            return o;
        }
        o = this._serializerCache.m3736o(javaType);
        if (o != null) {
            return o;
        }
        o = _createAndCacheUntypedSerializer(javaType);
        if (o == null) {
            return getUnknownTypeSerializer(javaType.getRawClass());
        }
        return o;
    }

    public ahb<Object> findPrimaryPropertySerializer(JavaType javaType, agv com_fossil_agv) throws JsonMappingException {
        ahb o = this._knownSerializers.m3789o(javaType);
        if (o == null) {
            o = this._serializerCache.m3736o(javaType);
            if (o == null) {
                o = _createAndCacheUntypedSerializer(javaType);
                if (o == null) {
                    return getUnknownTypeSerializer(javaType.getRawClass());
                }
            }
        }
        return handlePrimaryContextualization(o, com_fossil_agv);
    }

    public ahb<Object> findPrimaryPropertySerializer(Class<?> cls, agv com_fossil_agv) throws JsonMappingException {
        ahb m = this._knownSerializers.m3787m(cls);
        if (m == null) {
            m = this._serializerCache.m3734m(cls);
            if (m == null) {
                m = this._serializerCache.m3736o(this._config.constructType((Class) cls));
                if (m == null) {
                    m = _createAndCacheUntypedSerializer((Class) cls);
                    if (m == null) {
                        return getUnknownTypeSerializer(cls);
                    }
                }
            }
        }
        return handlePrimaryContextualization(m, com_fossil_agv);
    }

    public ahb<Object> findTypedValueSerializer(Class<?> cls, boolean z, agv com_fossil_agv) throws JsonMappingException {
        ahb<Object> n = this._knownSerializers.m3788n(cls);
        if (n == null) {
            n = this._serializerCache.m3735n(cls);
            if (n == null) {
                ahb<Object> findValueSerializer = findValueSerializer((Class) cls, com_fossil_agv);
                ajv createTypeSerializer = this._serializerFactory.createTypeSerializer(this._config, this._config.constructType((Class) cls));
                if (createTypeSerializer != null) {
                    n = new alv(createTypeSerializer.mo1031c(com_fossil_agv), findValueSerializer);
                } else {
                    n = findValueSerializer;
                }
                if (z) {
                    this._serializerCache.m3733a((Class) cls, r0);
                }
            }
        }
        return n;
    }

    public ahb<Object> findTypedValueSerializer(JavaType javaType, boolean z, agv com_fossil_agv) throws JsonMappingException {
        ahb<Object> p = this._knownSerializers.m3790p(javaType);
        if (p == null) {
            p = this._serializerCache.m3737p(javaType);
            if (p == null) {
                ahb<Object> findValueSerializer = findValueSerializer(javaType, com_fossil_agv);
                ajv createTypeSerializer = this._serializerFactory.createTypeSerializer(this._config, javaType);
                if (createTypeSerializer != null) {
                    p = new alv(createTypeSerializer.mo1031c(com_fossil_agv), findValueSerializer);
                } else {
                    p = findValueSerializer;
                }
                if (z) {
                    this._serializerCache.m3731a(javaType, r0);
                }
            }
        }
        return p;
    }

    public ajv findTypeSerializer(JavaType javaType) throws JsonMappingException {
        return this._serializerFactory.createTypeSerializer(this._config, javaType);
    }

    public ahb<Object> findKeySerializer(JavaType javaType, agv com_fossil_agv) throws JsonMappingException {
        return _handleContextualResolvable(this._serializerFactory.createKeySerializer(this._config, javaType, this._keySerializer), com_fossil_agv);
    }

    public ahb<Object> getDefaultNullKeySerializer() {
        return this._nullKeySerializer;
    }

    public ahb<Object> getDefaultNullValueSerializer() {
        return this._nullValueSerializer;
    }

    public ahb<Object> findNullKeySerializer(JavaType javaType, agv com_fossil_agv) throws JsonMappingException {
        return this._nullKeySerializer;
    }

    public ahb<Object> findNullValueSerializer(agv com_fossil_agv) throws JsonMappingException {
        return this._nullValueSerializer;
    }

    public ahb<Object> getUnknownTypeSerializer(Class<?> cls) {
        if (cls == Object.class) {
            return this._unknownTypeSerializer;
        }
        return new UnknownSerializer(cls);
    }

    public boolean isUnknownTypeSerializer(ahb<?> com_fossil_ahb_) {
        if (com_fossil_ahb_ == this._unknownTypeSerializer || com_fossil_ahb_ == null) {
            return true;
        }
        if (isEnabled(SerializationFeature.FAIL_ON_EMPTY_BEANS) && com_fossil_ahb_.getClass() == UnknownSerializer.class) {
            return true;
        }
        return false;
    }

    public ahb<?> handlePrimaryContextualization(ahb<?> com_fossil_ahb_, agv com_fossil_agv) throws JsonMappingException {
        if (com_fossil_ahb_ == null || !(com_fossil_ahb_ instanceof alg)) {
            return com_fossil_ahb_;
        }
        return ((alg) com_fossil_ahb_).createContextual(this, com_fossil_agv);
    }

    public ahb<?> handleSecondaryContextualization(ahb<?> com_fossil_ahb_, agv com_fossil_agv) throws JsonMappingException {
        if (com_fossil_ahb_ == null || !(com_fossil_ahb_ instanceof alg)) {
            return com_fossil_ahb_;
        }
        return ((alg) com_fossil_ahb_).createContextual(this, com_fossil_agv);
    }

    public final void defaultSerializeValue(Object obj, JsonGenerator jsonGenerator) throws IOException {
        if (obj != null) {
            findTypedValueSerializer(obj.getClass(), true, null).serialize(obj, jsonGenerator, this);
        } else if (this._stdNullValueSerializer) {
            jsonGenerator.zL();
        } else {
            this._nullValueSerializer.serialize(null, jsonGenerator, this);
        }
    }

    public final void defaultSerializeField(String str, Object obj, JsonGenerator jsonGenerator) throws IOException {
        jsonGenerator.aQ(str);
        if (obj != null) {
            findTypedValueSerializer(obj.getClass(), true, null).serialize(obj, jsonGenerator, this);
        } else if (this._stdNullValueSerializer) {
            jsonGenerator.zL();
        } else {
            this._nullValueSerializer.serialize(null, jsonGenerator, this);
        }
    }

    public final void defaultSerializeDateValue(long j, JsonGenerator jsonGenerator) throws IOException {
        if (isEnabled(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS)) {
            jsonGenerator.mo933J(j);
        } else {
            jsonGenerator.writeString(_dateFormat().format(new Date(j)));
        }
    }

    public final void defaultSerializeDateValue(Date date, JsonGenerator jsonGenerator) throws IOException {
        if (isEnabled(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS)) {
            jsonGenerator.mo933J(date.getTime());
        } else {
            jsonGenerator.writeString(_dateFormat().format(date));
        }
    }

    public void defaultSerializeDateKey(long j, JsonGenerator jsonGenerator) throws IOException {
        if (isEnabled(SerializationFeature.WRITE_DATE_KEYS_AS_TIMESTAMPS)) {
            jsonGenerator.aQ(String.valueOf(j));
        } else {
            jsonGenerator.aQ(_dateFormat().format(new Date(j)));
        }
    }

    public void defaultSerializeDateKey(Date date, JsonGenerator jsonGenerator) throws IOException {
        if (isEnabled(SerializationFeature.WRITE_DATE_KEYS_AS_TIMESTAMPS)) {
            jsonGenerator.aQ(String.valueOf(date.getTime()));
        } else {
            jsonGenerator.aQ(_dateFormat().format(date));
        }
    }

    public final void defaultSerializeNull(JsonGenerator jsonGenerator) throws IOException {
        if (this._stdNullValueSerializer) {
            jsonGenerator.zL();
        } else {
            this._nullValueSerializer.serialize(null, jsonGenerator, this);
        }
    }

    public JsonMappingException mappingException(String str, Object... objArr) {
        if (objArr != null && objArr.length > 0) {
            str = String.format(str, objArr);
        }
        return new JsonMappingException(str);
    }

    protected void _reportIncompatibleRootType(Object obj, JavaType javaType) throws IOException, JsonProcessingException {
        if (!javaType.isPrimitive() || !ami.m3851A(javaType.getRawClass()).isAssignableFrom(obj.getClass())) {
            throw new JsonMappingException("Incompatible types: declared root type (" + javaType + ") vs " + obj.getClass().getName());
        }
    }

    protected ahb<Object> _findExplicitUntypedSerializer(Class<?> cls) throws JsonMappingException {
        ahb<Object> m = this._knownSerializers.m3787m(cls);
        if (m == null) {
            m = this._serializerCache.m3734m(cls);
            if (m == null) {
                m = _createAndCacheUntypedSerializer((Class) cls);
            }
        }
        if (isUnknownTypeSerializer(m)) {
            return null;
        }
        return m;
    }

    protected ahb<Object> _createAndCacheUntypedSerializer(Class<?> cls) throws JsonMappingException {
        JavaType constructType = this._config.constructType((Class) cls);
        try {
            ahb<Object> _createUntypedSerializer = _createUntypedSerializer(constructType);
            if (_createUntypedSerializer != null) {
                this._serializerCache.m3732a(constructType, _createUntypedSerializer, this);
            }
            return _createUntypedSerializer;
        } catch (Throwable e) {
            throw new JsonMappingException(e.getMessage(), null, e);
        }
    }

    protected ahb<Object> _createAndCacheUntypedSerializer(JavaType javaType) throws JsonMappingException {
        try {
            ahb<Object> _createUntypedSerializer = _createUntypedSerializer(javaType);
            if (_createUntypedSerializer != null) {
                this._serializerCache.m3732a(javaType, _createUntypedSerializer, this);
            }
            return _createUntypedSerializer;
        } catch (Throwable e) {
            throw new JsonMappingException(e.getMessage(), null, e);
        }
    }

    protected ahb<Object> _createUntypedSerializer(JavaType javaType) throws JsonMappingException {
        ahb<Object> createSerializer;
        synchronized (this._serializerCache) {
            createSerializer = this._serializerFactory.createSerializer(this, javaType);
        }
        return createSerializer;
    }

    protected ahb<Object> _handleContextualResolvable(ahb<?> com_fossil_ahb_, agv com_fossil_agv) throws JsonMappingException {
        if (com_fossil_ahb_ instanceof all) {
            ((all) com_fossil_ahb_).resolve(this);
        }
        return handleSecondaryContextualization(com_fossil_ahb_, com_fossil_agv);
    }

    protected ahb<Object> _handleResolvable(ahb<?> com_fossil_ahb_) throws JsonMappingException {
        if (com_fossil_ahb_ instanceof all) {
            ((all) com_fossil_ahb_).resolve(this);
        }
        return com_fossil_ahb_;
    }

    protected final DateFormat _dateFormat() {
        if (this._dateFormat != null) {
            return this._dateFormat;
        }
        DateFormat dateFormat = (DateFormat) this._config.getDateFormat().clone();
        this._dateFormat = dateFormat;
        TimeZone timeZone = getTimeZone();
        if (timeZone == dateFormat.getTimeZone()) {
            return dateFormat;
        }
        dateFormat.setTimeZone(timeZone);
        return dateFormat;
    }
}
