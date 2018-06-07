package com.fasterxml.jackson.databind.cfg;

import com.fasterxml.jackson.core.Base64Variant;
import com.fasterxml.jackson.core.io.SerializedString;
import com.fasterxml.jackson.databind.AnnotationIntrospector;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.PropertyName;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.introspect.VisibilityChecker;
import com.fasterxml.jackson.databind.type.TypeFactory;
import com.fossil.afc;
import com.fossil.agl;
import com.fossil.agu;
import com.fossil.ahq;
import com.fossil.ahr;
import com.fossil.aiq;
import com.fossil.aiw;
import com.fossil.aiw.C1505a;
import com.fossil.ajr;
import com.fossil.ajt;
import com.fossil.aju;
import com.fossil.ama;
import com.fossil.ami;
import java.io.Serializable;
import java.lang.reflect.Type;
import java.text.DateFormat;
import java.util.Locale;
import java.util.TimeZone;

public abstract class MapperConfig<T extends MapperConfig<T>> implements C1505a, Serializable {
    private static final long serialVersionUID = 1;
    protected final BaseSettings _base;
    protected final int _mapperFeatures;

    public abstract PropertyName findRootName(JavaType javaType);

    public abstract PropertyName findRootName(Class<?> cls);

    public abstract Class<?> getActiveView();

    public abstract ContextAttributes getAttributes();

    public abstract ajr getSubtypeResolver();

    public abstract agu introspectClassAnnotations(JavaType javaType);

    public abstract agu introspectDirectClassAnnotations(JavaType javaType);

    public abstract boolean useRootWrapping();

    public abstract T with(MapperFeature mapperFeature, boolean z);

    public abstract T with(MapperFeature... mapperFeatureArr);

    public abstract T without(MapperFeature... mapperFeatureArr);

    protected MapperConfig(BaseSettings baseSettings, int i) {
        this._base = baseSettings;
        this._mapperFeatures = i;
    }

    protected MapperConfig(MapperConfig<T> mapperConfig, int i) {
        this._base = mapperConfig._base;
        this._mapperFeatures = i;
    }

    protected MapperConfig(MapperConfig<T> mapperConfig, BaseSettings baseSettings) {
        this._base = baseSettings;
        this._mapperFeatures = mapperConfig._mapperFeatures;
    }

    protected MapperConfig(MapperConfig<T> mapperConfig) {
        this._base = mapperConfig._base;
        this._mapperFeatures = mapperConfig._mapperFeatures;
    }

    public static <F extends Enum<F> & ahq> int collectFeatureDefaults(Class<F> cls) {
        Enum[] enumArr = (Enum[]) cls.getEnumConstants();
        int length = enumArr.length;
        int i = 0;
        int i2 = 0;
        while (i < length) {
            int mask;
            Enum enumR = enumArr[i];
            if (((ahq) enumR).enabledByDefault()) {
                mask = ((ahq) enumR).getMask() | i2;
            } else {
                mask = i2;
            }
            i++;
            i2 = mask;
        }
        return i2;
    }

    public final boolean isEnabled(MapperFeature mapperFeature) {
        return (this._mapperFeatures & mapperFeature.getMask()) != 0;
    }

    public final boolean hasMapperFeatures(int i) {
        return (this._mapperFeatures & i) == i;
    }

    public final boolean isAnnotationProcessingEnabled() {
        return isEnabled(MapperFeature.USE_ANNOTATIONS);
    }

    public final boolean canOverrideAccessModifiers() {
        return isEnabled(MapperFeature.CAN_OVERRIDE_ACCESS_MODIFIERS);
    }

    public final boolean shouldSortPropertiesAlphabetically() {
        return isEnabled(MapperFeature.SORT_PROPERTIES_ALPHABETICALLY);
    }

    public afc compileString(String str) {
        return new SerializedString(str);
    }

    public aiw getClassIntrospector() {
        return this._base.getClassIntrospector();
    }

    public AnnotationIntrospector getAnnotationIntrospector() {
        return this._base.getAnnotationIntrospector();
    }

    public VisibilityChecker<?> getDefaultVisibilityChecker() {
        return this._base.getVisibilityChecker();
    }

    public final PropertyNamingStrategy getPropertyNamingStrategy() {
        return this._base.getPropertyNamingStrategy();
    }

    public final ahr getHandlerInstantiator() {
        return this._base.getHandlerInstantiator();
    }

    public final aju<?> getDefaultTyper(JavaType javaType) {
        return this._base.getTypeResolverBuilder();
    }

    public final TypeFactory getTypeFactory() {
        return this._base.getTypeFactory();
    }

    public final JavaType constructType(Class<?> cls) {
        return getTypeFactory().constructType((Type) cls, (ama) null);
    }

    public final JavaType constructType(agl<?> com_fossil_agl_) {
        return getTypeFactory().constructType(com_fossil_agl_.getType(), (ama) null);
    }

    public JavaType constructSpecializedType(JavaType javaType, Class<?> cls) {
        return getTypeFactory().constructSpecializedType(javaType, cls);
    }

    public agu introspectClassAnnotations(Class<?> cls) {
        return introspectClassAnnotations(constructType((Class) cls));
    }

    public agu introspectDirectClassAnnotations(Class<?> cls) {
        return introspectDirectClassAnnotations(constructType((Class) cls));
    }

    public final DateFormat getDateFormat() {
        return this._base.getDateFormat();
    }

    public final Locale getLocale() {
        return this._base.getLocale();
    }

    public final TimeZone getTimeZone() {
        return this._base.getTimeZone();
    }

    public Base64Variant getBase64Variant() {
        return this._base.getBase64Variant();
    }

    public aju<?> typeResolverBuilderInstance(aiq com_fossil_aiq, Class<? extends aju<?>> cls) {
        ahr handlerInstantiator = getHandlerInstantiator();
        if (handlerInstantiator != null) {
            aju<?> a = handlerInstantiator.m3342a(this, com_fossil_aiq, (Class) cls);
            if (a != null) {
                return a;
            }
        }
        return (aju) ami.m3863b((Class) cls, canOverrideAccessModifiers());
    }

    public ajt typeIdResolverInstance(aiq com_fossil_aiq, Class<? extends ajt> cls) {
        ahr handlerInstantiator = getHandlerInstantiator();
        if (handlerInstantiator != null) {
            ajt b = handlerInstantiator.m3345b(this, com_fossil_aiq, (Class) cls);
            if (b != null) {
                return b;
            }
        }
        return (ajt) ami.m3863b((Class) cls, canOverrideAccessModifiers());
    }
}
