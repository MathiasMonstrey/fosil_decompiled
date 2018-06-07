package com.fossil;

import com.fasterxml.jackson.databind.AnnotationIntrospector;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.cfg.MapperConfig;
import com.fasterxml.jackson.databind.introspect.AnnotatedMember;
import com.fasterxml.jackson.databind.jsontype.NamedType;
import java.util.Collection;

public abstract class ajr {
    @Deprecated
    public abstract Collection<NamedType> collectAndResolveSubtypes(AnnotatedMember annotatedMember, MapperConfig<?> mapperConfig, AnnotationIntrospector annotationIntrospector, JavaType javaType);

    @Deprecated
    public abstract Collection<NamedType> collectAndResolveSubtypes(air com_fossil_air, MapperConfig<?> mapperConfig, AnnotationIntrospector annotationIntrospector);

    public abstract void registerSubtypes(NamedType... namedTypeArr);

    public abstract void registerSubtypes(Class<?>... clsArr);

    public Collection<NamedType> collectAndResolveSubtypesByClass(MapperConfig<?> mapperConfig, AnnotatedMember annotatedMember, JavaType javaType) {
        return collectAndResolveSubtypes(annotatedMember, mapperConfig, mapperConfig.getAnnotationIntrospector(), javaType);
    }

    public Collection<NamedType> collectAndResolveSubtypesByClass(MapperConfig<?> mapperConfig, air com_fossil_air) {
        return collectAndResolveSubtypes(com_fossil_air, mapperConfig, mapperConfig.getAnnotationIntrospector());
    }

    public Collection<NamedType> collectAndResolveSubtypesByTypeId(MapperConfig<?> mapperConfig, AnnotatedMember annotatedMember, JavaType javaType) {
        return collectAndResolveSubtypes(annotatedMember, mapperConfig, mapperConfig.getAnnotationIntrospector(), javaType);
    }

    public Collection<NamedType> collectAndResolveSubtypesByTypeId(MapperConfig<?> mapperConfig, air com_fossil_air) {
        return collectAndResolveSubtypes(com_fossil_air, mapperConfig, mapperConfig.getAnnotationIntrospector());
    }
}
