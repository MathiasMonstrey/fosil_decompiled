package com.fasterxml.jackson.databind.introspect;

import com.fasterxml.jackson.databind.AnnotationIntrospector;
import com.fasterxml.jackson.databind.DeserializationConfig;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.SerializationConfig;
import com.fasterxml.jackson.databind.cfg.MapperConfig;
import com.fasterxml.jackson.databind.type.SimpleType;
import com.fasterxml.jackson.databind.util.LRUMap;
import com.fossil.ahl.C1642a;
import com.fossil.air;
import com.fossil.aiu;
import com.fossil.aiw;
import com.fossil.aiw.C1505a;
import com.fossil.aiz;
import java.io.Serializable;
import java.util.Collection;
import java.util.Map;

public class BasicClassIntrospector extends aiw implements Serializable {
    protected static final aiu BOOLEAN_DESC = aiu.m3452a(null, SimpleType.constructUnsafe(Boolean.TYPE), air.m3419b(Boolean.TYPE, null, null));
    protected static final aiu INT_DESC = aiu.m3452a(null, SimpleType.constructUnsafe(Integer.TYPE), air.m3419b(Integer.TYPE, null, null));
    protected static final aiu LONG_DESC = aiu.m3452a(null, SimpleType.constructUnsafe(Long.TYPE), air.m3419b(Long.TYPE, null, null));
    protected static final aiu STRING_DESC = aiu.m3452a(null, SimpleType.constructUnsafe(String.class), air.m3419b(String.class, null, null));
    @Deprecated
    public static final BasicClassIntrospector instance = new BasicClassIntrospector();
    private static final long serialVersionUID = 1;
    protected final LRUMap<JavaType, aiu> _cachedFCA = new LRUMap(16, 64);

    public aiu forSerialization(SerializationConfig serializationConfig, JavaType javaType, C1505a c1505a) {
        aiu _findStdTypeDesc = _findStdTypeDesc(javaType);
        if (_findStdTypeDesc == null) {
            _findStdTypeDesc = _findStdJdkCollectionDesc(serializationConfig, javaType, c1505a);
            if (_findStdTypeDesc == null) {
                _findStdTypeDesc = aiu.m3454b(collectProperties(serializationConfig, javaType, c1505a, true, "set"));
            }
            this._cachedFCA.putIfAbsent(javaType, _findStdTypeDesc);
        }
        return _findStdTypeDesc;
    }

    public aiu forDeserialization(DeserializationConfig deserializationConfig, JavaType javaType, C1505a c1505a) {
        aiu _findStdTypeDesc = _findStdTypeDesc(javaType);
        if (_findStdTypeDesc == null) {
            _findStdTypeDesc = _findStdJdkCollectionDesc(deserializationConfig, javaType, c1505a);
            if (_findStdTypeDesc == null) {
                _findStdTypeDesc = aiu.m3453a(collectProperties(deserializationConfig, javaType, c1505a, false, "set"));
            }
            this._cachedFCA.putIfAbsent(javaType, _findStdTypeDesc);
        }
        return _findStdTypeDesc;
    }

    public aiu forDeserializationWithBuilder(DeserializationConfig deserializationConfig, JavaType javaType, C1505a c1505a) {
        aiu a = aiu.m3453a(collectPropertiesWithBuilder(deserializationConfig, javaType, c1505a, false));
        this._cachedFCA.putIfAbsent(javaType, a);
        return a;
    }

    public aiu forCreation(DeserializationConfig deserializationConfig, JavaType javaType, C1505a c1505a) {
        aiu _findStdTypeDesc = _findStdTypeDesc(javaType);
        if (_findStdTypeDesc != null) {
            return _findStdTypeDesc;
        }
        _findStdTypeDesc = _findStdJdkCollectionDesc(deserializationConfig, javaType, c1505a);
        if (_findStdTypeDesc != null) {
            return _findStdTypeDesc;
        }
        return aiu.m3453a(collectProperties(deserializationConfig, javaType, c1505a, false, "set"));
    }

    public aiu forClassAnnotations(MapperConfig<?> mapperConfig, JavaType javaType, C1505a c1505a) {
        aiu _findStdTypeDesc = _findStdTypeDesc(javaType);
        if (_findStdTypeDesc != null) {
            return _findStdTypeDesc;
        }
        _findStdTypeDesc = (aiu) this._cachedFCA.get(javaType);
        if (_findStdTypeDesc != null) {
            return _findStdTypeDesc;
        }
        _findStdTypeDesc = aiu.m3452a(mapperConfig, javaType, air.m3414a(javaType.getRawClass(), mapperConfig.isAnnotationProcessingEnabled() ? mapperConfig.getAnnotationIntrospector() : null, c1505a));
        this._cachedFCA.put(javaType, _findStdTypeDesc);
        return _findStdTypeDesc;
    }

    public aiu forDirectClassAnnotations(MapperConfig<?> mapperConfig, JavaType javaType, C1505a c1505a) {
        aiu _findStdTypeDesc = _findStdTypeDesc(javaType);
        if (_findStdTypeDesc != null) {
            return _findStdTypeDesc;
        }
        boolean isAnnotationProcessingEnabled = mapperConfig.isAnnotationProcessingEnabled();
        AnnotationIntrospector annotationIntrospector = mapperConfig.getAnnotationIntrospector();
        Class rawClass = javaType.getRawClass();
        if (!isAnnotationProcessingEnabled) {
            annotationIntrospector = null;
        }
        return aiu.m3452a(mapperConfig, javaType, air.m3419b(rawClass, annotationIntrospector, c1505a));
    }

    protected aiz collectProperties(MapperConfig<?> mapperConfig, JavaType javaType, C1505a c1505a, boolean z, String str) {
        return constructPropertyCollector(mapperConfig, air.m3414a(javaType.getRawClass(), mapperConfig.isAnnotationProcessingEnabled() ? mapperConfig.getAnnotationIntrospector() : null, c1505a), javaType, z, str);
    }

    protected aiz collectPropertiesWithBuilder(MapperConfig<?> mapperConfig, JavaType javaType, C1505a c1505a, boolean z) {
        AnnotationIntrospector annotationIntrospector;
        C1642a c1642a = null;
        if (mapperConfig.isAnnotationProcessingEnabled()) {
            annotationIntrospector = mapperConfig.getAnnotationIntrospector();
        } else {
            annotationIntrospector = null;
        }
        air a = air.m3414a(javaType.getRawClass(), annotationIntrospector, c1505a);
        if (annotationIntrospector != null) {
            c1642a = annotationIntrospector.findPOJOBuilderConfig(a);
        }
        return constructPropertyCollector(mapperConfig, a, javaType, z, c1642a == null ? "with" : c1642a.aQE);
    }

    protected aiz constructPropertyCollector(MapperConfig<?> mapperConfig, air com_fossil_air, JavaType javaType, boolean z, String str) {
        return new aiz(mapperConfig, z, javaType, com_fossil_air, str);
    }

    protected aiu _findStdTypeDesc(JavaType javaType) {
        Class rawClass = javaType.getRawClass();
        if (rawClass.isPrimitive()) {
            if (rawClass == Boolean.TYPE) {
                return BOOLEAN_DESC;
            }
            if (rawClass == Integer.TYPE) {
                return INT_DESC;
            }
            if (rawClass == Long.TYPE) {
                return LONG_DESC;
            }
        } else if (rawClass == String.class) {
            return STRING_DESC;
        }
        return null;
    }

    protected boolean _isStdJDKCollection(JavaType javaType) {
        if (!javaType.isContainerType() || javaType.isArrayType()) {
            return false;
        }
        Class rawClass = javaType.getRawClass();
        Package packageR = rawClass.getPackage();
        if (packageR == null) {
            return false;
        }
        String name = packageR.getName();
        if (!name.startsWith("java.lang") && !name.startsWith("java.util")) {
            return false;
        }
        if (Collection.class.isAssignableFrom(rawClass) || Map.class.isAssignableFrom(rawClass)) {
            return true;
        }
        return false;
    }

    protected aiu _findStdJdkCollectionDesc(MapperConfig<?> mapperConfig, JavaType javaType, C1505a c1505a) {
        AnnotationIntrospector annotationIntrospector = null;
        if (!_isStdJDKCollection(javaType)) {
            return null;
        }
        Class rawClass = javaType.getRawClass();
        if (mapperConfig.isAnnotationProcessingEnabled()) {
            annotationIntrospector = mapperConfig.getAnnotationIntrospector();
        }
        return aiu.m3452a(mapperConfig, javaType, air.m3414a(rawClass, annotationIntrospector, c1505a));
    }
}
