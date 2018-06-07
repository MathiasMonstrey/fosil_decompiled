package com.fossil;

import com.fasterxml.jackson.annotation.ObjectIdGenerator;
import com.fasterxml.jackson.databind.AnnotationIntrospector;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.cfg.MapperConfig;
import com.fasterxml.jackson.databind.type.TypeFactory;
import com.fossil.amk.C1703a;
import java.lang.reflect.Type;
import java.util.Locale;
import java.util.TimeZone;

public abstract class agw {
    public abstract Class<?> getActiveView();

    public abstract AnnotationIntrospector getAnnotationIntrospector();

    public abstract Object getAttribute(Object obj);

    public abstract MapperConfig<?> getConfig();

    public abstract Locale getLocale();

    public abstract TimeZone getTimeZone();

    public abstract TypeFactory getTypeFactory();

    public abstract agw setAttribute(Object obj, Object obj2);

    public final boolean isEnabled(MapperFeature mapperFeature) {
        return getConfig().isEnabled(mapperFeature);
    }

    public final boolean canOverrideAccessModifiers() {
        return getConfig().canOverrideAccessModifiers();
    }

    public JavaType constructType(Type type) {
        return getTypeFactory().constructType(type);
    }

    public JavaType constructSpecializedType(JavaType javaType, Class<?> cls) {
        return javaType.getRawClass() == cls ? javaType : getConfig().constructSpecializedType(javaType, cls);
    }

    public ObjectIdGenerator<?> objectIdGeneratorInstance(aiq com_fossil_aiq, aiy com_fossil_aiy) throws JsonMappingException {
        Class Fz = com_fossil_aiy.Fz();
        MapperConfig config = getConfig();
        ahr handlerInstantiator = config.getHandlerInstantiator();
        ObjectIdGenerator d = handlerInstantiator == null ? null : handlerInstantiator.m3347d(config, com_fossil_aiq, Fz);
        if (d == null) {
            d = (ObjectIdGenerator) ami.m3863b(Fz, config.canOverrideAccessModifiers());
        }
        return d.forScope(com_fossil_aiy.getScope());
    }

    public aeu objectIdResolverInstance(aiq com_fossil_aiq, aiy com_fossil_aiy) {
        Class FA = com_fossil_aiy.FA();
        MapperConfig config = getConfig();
        ahr handlerInstantiator = config.getHandlerInstantiator();
        aeu e = handlerInstantiator == null ? null : handlerInstantiator.m3348e(config, com_fossil_aiq, FA);
        if (e == null) {
            return (aeu) ami.m3863b(FA, config.canOverrideAccessModifiers());
        }
        return e;
    }

    public amk<Object, Object> converterInstance(aiq com_fossil_aiq, Object obj) throws JsonMappingException {
        amk com_fossil_amk = null;
        if (obj == null) {
            return null;
        }
        if (obj instanceof amk) {
            return (amk) obj;
        }
        if (obj instanceof Class) {
            Class cls = (Class) obj;
            if (cls == C1703a.class || ami.m3854D(cls)) {
                return null;
            }
            if (amk.class.isAssignableFrom(cls)) {
                MapperConfig config = getConfig();
                ahr handlerInstantiator = config.getHandlerInstantiator();
                if (handlerInstantiator != null) {
                    com_fossil_amk = handlerInstantiator.m3350g(config, com_fossil_aiq, cls);
                }
                if (com_fossil_amk == null) {
                    com_fossil_amk = (amk) ami.m3863b(cls, config.canOverrideAccessModifiers());
                }
                return com_fossil_amk;
            }
            throw new IllegalStateException("AnnotationIntrospector returned Class " + cls.getName() + "; expected Class<Converter>");
        }
        throw new IllegalStateException("AnnotationIntrospector returned Converter definition of type " + obj.getClass().getName() + "; expected type Converter or Class<Converter> instead");
    }
}
