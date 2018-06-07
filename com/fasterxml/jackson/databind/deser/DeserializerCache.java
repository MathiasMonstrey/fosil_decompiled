package com.fasterxml.jackson.databind.deser;

import com.fasterxml.jackson.annotation.JsonFormat.C1501b;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;
import com.fasterxml.jackson.databind.AnnotationIntrospector;
import com.fasterxml.jackson.databind.DeserializationConfig;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.deser.std.StdDelegatingDeserializer;
import com.fasterxml.jackson.databind.type.ArrayType;
import com.fasterxml.jackson.databind.type.CollectionLikeType;
import com.fasterxml.jackson.databind.type.CollectionType;
import com.fasterxml.jackson.databind.type.MapLikeType;
import com.fasterxml.jackson.databind.type.MapType;
import com.fossil.agu;
import com.fossil.agy;
import com.fossil.agy.C1636a;
import com.fossil.agz;
import com.fossil.ahc;
import com.fossil.ahz;
import com.fossil.aic;
import com.fossil.aiq;
import com.fossil.ami;
import com.fossil.amk;
import java.io.Serializable;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

public final class DeserializerCache implements Serializable {
    private static final long serialVersionUID = 1;
    protected final ConcurrentHashMap<JavaType, agy<Object>> _cachedDeserializers = new ConcurrentHashMap(64, 0.75f, 4);
    protected final HashMap<JavaType, agy<Object>> _incompleteDeserializers = new HashMap(8);

    Object writeReplace() {
        this._incompleteDeserializers.clear();
        return this;
    }

    public int cachedDeserializersCount() {
        return this._cachedDeserializers.size();
    }

    public void flushCachedDeserializers() {
        this._cachedDeserializers.clear();
    }

    public agy<Object> findValueDeserializer(DeserializationContext deserializationContext, ahz com_fossil_ahz, JavaType javaType) throws JsonMappingException {
        agy<Object> _findCachedDeserializer = _findCachedDeserializer(javaType);
        if (_findCachedDeserializer != null) {
            return _findCachedDeserializer;
        }
        _findCachedDeserializer = _createAndCacheValueDeserializer(deserializationContext, com_fossil_ahz, javaType);
        if (_findCachedDeserializer == null) {
            return _handleUnknownValueDeserializer(javaType);
        }
        return _findCachedDeserializer;
    }

    public ahc findKeyDeserializer(DeserializationContext deserializationContext, ahz com_fossil_ahz, JavaType javaType) throws JsonMappingException {
        ahc createKeyDeserializer = com_fossil_ahz.createKeyDeserializer(deserializationContext, javaType);
        if (createKeyDeserializer == null) {
            return _handleUnknownKeyDeserializer(javaType);
        }
        if (!(createKeyDeserializer instanceof aic)) {
            return createKeyDeserializer;
        }
        ((aic) createKeyDeserializer).resolve(deserializationContext);
        return createKeyDeserializer;
    }

    public boolean hasValueDeserializerFor(DeserializationContext deserializationContext, ahz com_fossil_ahz, JavaType javaType) throws JsonMappingException {
        agy _findCachedDeserializer = _findCachedDeserializer(javaType);
        if (_findCachedDeserializer == null) {
            _findCachedDeserializer = _createAndCacheValueDeserializer(deserializationContext, com_fossil_ahz, javaType);
        }
        return _findCachedDeserializer != null;
    }

    protected agy<Object> _findCachedDeserializer(JavaType javaType) {
        if (javaType == null) {
            throw new IllegalArgumentException("Null JavaType passed");
        } else if (m2701c(javaType)) {
            return null;
        } else {
            return (agy) this._cachedDeserializers.get(javaType);
        }
    }

    protected agy<Object> _createAndCacheValueDeserializer(DeserializationContext deserializationContext, ahz com_fossil_ahz, JavaType javaType) throws JsonMappingException {
        agy<Object> _findCachedDeserializer;
        synchronized (this._incompleteDeserializers) {
            _findCachedDeserializer = _findCachedDeserializer(javaType);
            if (_findCachedDeserializer != null) {
            } else {
                int size = this._incompleteDeserializers.size();
                if (size > 0) {
                    _findCachedDeserializer = (agy) this._incompleteDeserializers.get(javaType);
                    if (_findCachedDeserializer != null) {
                    }
                }
                try {
                    _findCachedDeserializer = _createAndCache2(deserializationContext, com_fossil_ahz, javaType);
                    if (size == 0) {
                        if (this._incompleteDeserializers.size() > 0) {
                            this._incompleteDeserializers.clear();
                        }
                    }
                } catch (Throwable th) {
                    if (size == 0 && this._incompleteDeserializers.size() > 0) {
                        this._incompleteDeserializers.clear();
                    }
                }
            }
        }
        return _findCachedDeserializer;
    }

    protected agy<Object> _createAndCache2(DeserializationContext deserializationContext, ahz com_fossil_ahz, JavaType javaType) throws JsonMappingException {
        try {
            agy<Object> _createDeserializer = _createDeserializer(deserializationContext, com_fossil_ahz, javaType);
            if (_createDeserializer == null) {
                return null;
            }
            Object obj;
            boolean z = _createDeserializer instanceof aic;
            if (m2701c(javaType) || !_createDeserializer.isCachable()) {
                obj = null;
            } else {
                obj = 1;
            }
            if (z) {
                this._incompleteDeserializers.put(javaType, _createDeserializer);
                ((aic) _createDeserializer).resolve(deserializationContext);
                this._incompleteDeserializers.remove(javaType);
            }
            if (obj == null) {
                return _createDeserializer;
            }
            this._cachedDeserializers.put(javaType, _createDeserializer);
            return _createDeserializer;
        } catch (Throwable e) {
            throw new JsonMappingException(e.getMessage(), null, e);
        }
    }

    protected agy<Object> _createDeserializer(DeserializationContext deserializationContext, ahz com_fossil_ahz, JavaType javaType) throws JsonMappingException {
        DeserializationConfig config = deserializationContext.getConfig();
        if (javaType.isAbstract() || javaType.isMapLikeType() || javaType.isCollectionLikeType()) {
            javaType = com_fossil_ahz.mapAbstractType(config, javaType);
        }
        agu introspect = config.introspect(javaType);
        agy<Object> findDeserializerFromAnnotation = findDeserializerFromAnnotation(deserializationContext, introspect.Dn());
        if (findDeserializerFromAnnotation != null) {
            return findDeserializerFromAnnotation;
        }
        JavaType modifyTypeByAnnotation = modifyTypeByAnnotation(deserializationContext, introspect.Dn(), javaType);
        if (modifyTypeByAnnotation != javaType) {
            introspect = config.introspect(modifyTypeByAnnotation);
            javaType = modifyTypeByAnnotation;
        }
        Class DD = introspect.DD();
        if (DD != null) {
            return com_fossil_ahz.createBuilderBasedDeserializer(deserializationContext, javaType, introspect, DD);
        }
        amk DB = introspect.DB();
        if (DB == null) {
            return _createDeserializer2(deserializationContext, com_fossil_ahz, javaType, introspect);
        }
        JavaType a = DB.m3878a(deserializationContext.getTypeFactory());
        if (!a.hasRawClass(javaType.getRawClass())) {
            introspect = config.introspect(a);
        }
        return new StdDelegatingDeserializer(DB, a, _createDeserializer2(deserializationContext, com_fossil_ahz, a, introspect));
    }

    protected agy<?> _createDeserializer2(DeserializationContext deserializationContext, ahz com_fossil_ahz, JavaType javaType, agu com_fossil_agu) throws JsonMappingException {
        DeserializationConfig config = deserializationContext.getConfig();
        if (javaType.isEnumType()) {
            return com_fossil_ahz.createEnumDeserializer(deserializationContext, javaType, com_fossil_agu);
        }
        if (javaType.isContainerType()) {
            if (javaType.isArrayType()) {
                return com_fossil_ahz.createArrayDeserializer(deserializationContext, (ArrayType) javaType, com_fossil_agu);
            }
            if (javaType.isMapLikeType()) {
                MapLikeType mapLikeType = (MapLikeType) javaType;
                if (mapLikeType.isTrueMapType()) {
                    return com_fossil_ahz.createMapDeserializer(deserializationContext, (MapType) mapLikeType, com_fossil_agu);
                }
                return com_fossil_ahz.createMapLikeDeserializer(deserializationContext, mapLikeType, com_fossil_agu);
            } else if (javaType.isCollectionLikeType()) {
                C1501b a = com_fossil_agu.mo978a(null);
                if (a == null || a.yZ() != Shape.OBJECT) {
                    CollectionLikeType collectionLikeType = (CollectionLikeType) javaType;
                    if (collectionLikeType.isTrueCollectionType()) {
                        return com_fossil_ahz.createCollectionDeserializer(deserializationContext, (CollectionType) collectionLikeType, com_fossil_agu);
                    }
                    return com_fossil_ahz.createCollectionLikeDeserializer(deserializationContext, collectionLikeType, com_fossil_agu);
                }
            }
        }
        if (agz.class.isAssignableFrom(javaType.getRawClass())) {
            return com_fossil_ahz.createTreeDeserializer(config, javaType, com_fossil_agu);
        }
        return com_fossil_ahz.createBeanDeserializer(deserializationContext, javaType, com_fossil_agu);
    }

    protected agy<Object> findDeserializerFromAnnotation(DeserializationContext deserializationContext, aiq com_fossil_aiq) throws JsonMappingException {
        Object findDeserializer = deserializationContext.getAnnotationIntrospector().findDeserializer(com_fossil_aiq);
        if (findDeserializer == null) {
            return null;
        }
        return findConvertingDeserializer(deserializationContext, com_fossil_aiq, deserializationContext.deserializerInstance(com_fossil_aiq, findDeserializer));
    }

    protected agy<Object> findConvertingDeserializer(DeserializationContext deserializationContext, aiq com_fossil_aiq, agy<Object> com_fossil_agy_java_lang_Object) throws JsonMappingException {
        amk findConverter = findConverter(deserializationContext, com_fossil_aiq);
        return findConverter == null ? com_fossil_agy_java_lang_Object : new StdDelegatingDeserializer(findConverter, findConverter.m3878a(deserializationContext.getTypeFactory()), com_fossil_agy_java_lang_Object);
    }

    protected amk<Object, Object> findConverter(DeserializationContext deserializationContext, aiq com_fossil_aiq) throws JsonMappingException {
        Object findDeserializationConverter = deserializationContext.getAnnotationIntrospector().findDeserializationConverter(com_fossil_aiq);
        if (findDeserializationConverter == null) {
            return null;
        }
        return deserializationContext.converterInstance(com_fossil_aiq, findDeserializationConverter);
    }

    private JavaType modifyTypeByAnnotation(DeserializationContext deserializationContext, aiq com_fossil_aiq, JavaType javaType) throws JsonMappingException {
        AnnotationIntrospector annotationIntrospector = deserializationContext.getAnnotationIntrospector();
        Class findDeserializationType = annotationIntrospector.findDeserializationType(com_fossil_aiq, javaType);
        if (findDeserializationType != null) {
            try {
                JavaType constructSpecializedType = deserializationContext.getTypeFactory().constructSpecializedType(javaType, findDeserializationType);
            } catch (Throwable e) {
                throw new JsonMappingException("Failed to narrow type " + javaType + " with concrete-type annotation (value " + findDeserializationType.getName() + "), method '" + com_fossil_aiq.getName() + "': " + e.getMessage(), null, e);
            }
        }
        constructSpecializedType = javaType;
        if (!constructSpecializedType.isContainerType()) {
            return constructSpecializedType;
        }
        JavaType javaType2;
        Class findDeserializationKeyType = annotationIntrospector.findDeserializationKeyType(com_fossil_aiq, constructSpecializedType.getKeyType());
        if (findDeserializationKeyType == null) {
            javaType2 = constructSpecializedType;
        } else if (constructSpecializedType instanceof MapLikeType) {
            try {
                javaType2 = ((MapLikeType) constructSpecializedType).narrowKey(findDeserializationKeyType);
            } catch (Throwable e2) {
                throw new JsonMappingException("Failed to narrow key type " + constructSpecializedType + " with key-type annotation (" + findDeserializationKeyType.getName() + "): " + e2.getMessage(), null, e2);
            }
        } else {
            throw new JsonMappingException("Illegal key-type annotation: type " + constructSpecializedType + " is not a Map(-like) type");
        }
        constructSpecializedType = javaType2.getKeyType();
        if (constructSpecializedType != null && constructSpecializedType.getValueHandler() == null) {
            Object findKeyDeserializer = annotationIntrospector.findKeyDeserializer(com_fossil_aiq);
            if (findKeyDeserializer != null) {
                ahc keyDeserializerInstance = deserializationContext.keyDeserializerInstance(com_fossil_aiq, findKeyDeserializer);
                if (keyDeserializerInstance != null) {
                    javaType2 = ((MapLikeType) javaType2).withKeyValueHandler(keyDeserializerInstance);
                    javaType2.getKeyType();
                }
            }
        }
        findDeserializationType = annotationIntrospector.findDeserializationContentType(com_fossil_aiq, javaType2.getContentType());
        if (findDeserializationType != null) {
            try {
                constructSpecializedType = javaType2.narrowContentsBy(findDeserializationType);
            } catch (Throwable e3) {
                throw new JsonMappingException("Failed to narrow content type " + javaType2 + " with content-type annotation (" + findDeserializationType.getName() + "): " + e3.getMessage(), null, e3);
            }
        }
        constructSpecializedType = javaType2;
        if (constructSpecializedType.getContentType().getValueHandler() != null) {
            return constructSpecializedType;
        }
        Object findContentDeserializer = annotationIntrospector.findContentDeserializer(com_fossil_aiq);
        if (findContentDeserializer == null) {
            return constructSpecializedType;
        }
        if (findContentDeserializer instanceof agy) {
            agy com_fossil_agy = (agy) findContentDeserializer;
            findContentDeserializer = null;
        } else {
            Class _verifyAsClass = _verifyAsClass(findContentDeserializer, "findContentDeserializer", C1636a.class);
            findContentDeserializer = _verifyAsClass != null ? deserializationContext.deserializerInstance(com_fossil_aiq, _verifyAsClass) : null;
        }
        if (findContentDeserializer != null) {
            return constructSpecializedType.withContentValueHandler(findContentDeserializer);
        }
        return constructSpecializedType;
    }

    private boolean m2701c(JavaType javaType) {
        if (!javaType.isContainerType()) {
            return false;
        }
        JavaType contentType = javaType.getContentType();
        if (contentType == null) {
            return false;
        }
        if (contentType.getValueHandler() == null && contentType.getTypeHandler() == null) {
            return false;
        }
        return true;
    }

    private Class<?> _verifyAsClass(Object obj, String str, Class<?> cls) {
        if (obj == null) {
            return null;
        }
        if (obj instanceof Class) {
            Class<?> cls2 = (Class) obj;
            if (cls2 == cls || ami.m3854D(cls2)) {
                return null;
            }
            return cls2;
        }
        throw new IllegalStateException("AnnotationIntrospector." + str + "() returned value of type " + obj.getClass().getName() + ": expected type JsonSerializer or Class<JsonSerializer> instead");
    }

    protected agy<Object> _handleUnknownValueDeserializer(JavaType javaType) throws JsonMappingException {
        if (ami.m3874y(javaType.getRawClass())) {
            throw new JsonMappingException("Can not find a Value deserializer for type " + javaType);
        }
        throw new JsonMappingException("Can not find a Value deserializer for abstract type " + javaType);
    }

    protected ahc _handleUnknownKeyDeserializer(JavaType javaType) throws JsonMappingException {
        throw new JsonMappingException("Can not find a (Map) Key deserializer for type " + javaType);
    }
}
