package com.fasterxml.jackson.databind;

import com.fasterxml.jackson.annotation.JsonCreator.Mode;
import com.fasterxml.jackson.annotation.JsonFormat.C1501b;
import com.fasterxml.jackson.annotation.JsonInclude.C1502a;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty.Access;
import com.fasterxml.jackson.core.Version;
import com.fasterxml.jackson.databind.annotation.JsonSerialize.Typing;
import com.fasterxml.jackson.databind.cfg.MapperConfig;
import com.fasterxml.jackson.databind.introspect.AnnotatedMember;
import com.fasterxml.jackson.databind.introspect.AnnotatedMethod;
import com.fasterxml.jackson.databind.introspect.AnnotationIntrospectorPair;
import com.fasterxml.jackson.databind.introspect.NopAnnotationIntrospector;
import com.fasterxml.jackson.databind.introspect.VisibilityChecker;
import com.fasterxml.jackson.databind.jsontype.NamedType;
import com.fossil.ahl.C1642a;
import com.fossil.aiq;
import com.fossil.air;
import com.fossil.aiy;
import com.fossil.aju;
import com.fossil.ald;
import com.fossil.amo;
import java.io.Serializable;
import java.lang.annotation.Annotation;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public abstract class AnnotationIntrospector implements Serializable {

    public static class ReferenceProperty {
        private final String _name;
        private final Type aQd;

        public enum Type {
            MANAGED_REFERENCE,
            BACK_REFERENCE
        }

        public ReferenceProperty(Type type, String str) {
            this.aQd = type;
            this._name = str;
        }

        public static ReferenceProperty bD(String str) {
            return new ReferenceProperty(Type.MANAGED_REFERENCE, str);
        }

        public static ReferenceProperty bE(String str) {
            return new ReferenceProperty(Type.BACK_REFERENCE, str);
        }

        public String getName() {
            return this._name;
        }

        public boolean Dl() {
            return this.aQd == Type.MANAGED_REFERENCE;
        }

        public boolean Dm() {
            return this.aQd == Type.BACK_REFERENCE;
        }
    }

    public abstract Version version();

    public static AnnotationIntrospector nopInstance() {
        return NopAnnotationIntrospector.instance;
    }

    public static AnnotationIntrospector pair(AnnotationIntrospector annotationIntrospector, AnnotationIntrospector annotationIntrospector2) {
        return new AnnotationIntrospectorPair(annotationIntrospector, annotationIntrospector2);
    }

    public Collection<AnnotationIntrospector> allIntrospectors() {
        return Collections.singletonList(this);
    }

    public Collection<AnnotationIntrospector> allIntrospectors(Collection<AnnotationIntrospector> collection) {
        collection.add(this);
        return collection;
    }

    public boolean isAnnotationBundle(Annotation annotation) {
        return false;
    }

    public aiy findObjectIdInfo(aiq com_fossil_aiq) {
        return null;
    }

    public aiy findObjectReferenceInfo(aiq com_fossil_aiq, aiy com_fossil_aiy) {
        return com_fossil_aiy;
    }

    public PropertyName findRootName(air com_fossil_air) {
        return null;
    }

    public String[] findPropertiesToIgnore(aiq com_fossil_aiq, boolean z) {
        return findPropertiesToIgnore(com_fossil_aiq);
    }

    @Deprecated
    public String[] findPropertiesToIgnore(aiq com_fossil_aiq) {
        return null;
    }

    public Boolean findIgnoreUnknownProperties(air com_fossil_air) {
        return null;
    }

    public Boolean isIgnorableType(air com_fossil_air) {
        return null;
    }

    @Deprecated
    public Object findFilterId(air com_fossil_air) {
        return findFilterId((aiq) com_fossil_air);
    }

    public Object findFilterId(aiq com_fossil_aiq) {
        return null;
    }

    public Object findNamingStrategy(air com_fossil_air) {
        return null;
    }

    public VisibilityChecker<?> findAutoDetectVisibility(air com_fossil_air, VisibilityChecker<?> visibilityChecker) {
        return visibilityChecker;
    }

    public aju<?> findTypeResolver(MapperConfig<?> mapperConfig, air com_fossil_air, JavaType javaType) {
        return null;
    }

    public aju<?> findPropertyTypeResolver(MapperConfig<?> mapperConfig, AnnotatedMember annotatedMember, JavaType javaType) {
        return null;
    }

    public aju<?> findPropertyContentTypeResolver(MapperConfig<?> mapperConfig, AnnotatedMember annotatedMember, JavaType javaType) {
        return null;
    }

    public List<NamedType> findSubtypes(aiq com_fossil_aiq) {
        return null;
    }

    public String findTypeName(air com_fossil_air) {
        return null;
    }

    public Boolean isTypeId(AnnotatedMember annotatedMember) {
        return null;
    }

    public ReferenceProperty findReferenceType(AnnotatedMember annotatedMember) {
        return null;
    }

    public amo findUnwrappingNameTransformer(AnnotatedMember annotatedMember) {
        return null;
    }

    public boolean hasIgnoreMarker(AnnotatedMember annotatedMember) {
        return false;
    }

    public Object findInjectableValueId(AnnotatedMember annotatedMember) {
        return null;
    }

    public Boolean hasRequiredMarker(AnnotatedMember annotatedMember) {
        return null;
    }

    public Class<?>[] findViews(aiq com_fossil_aiq) {
        return null;
    }

    public C1501b findFormat(aiq com_fossil_aiq) {
        return null;
    }

    public PropertyName findWrapperName(aiq com_fossil_aiq) {
        return null;
    }

    public String findPropertyDefaultValue(aiq com_fossil_aiq) {
        return null;
    }

    public String findPropertyDescription(aiq com_fossil_aiq) {
        return null;
    }

    public Integer findPropertyIndex(aiq com_fossil_aiq) {
        return null;
    }

    public String findImplicitPropertyName(AnnotatedMember annotatedMember) {
        return null;
    }

    public Access findPropertyAccess(aiq com_fossil_aiq) {
        return null;
    }

    public Object findSerializer(aiq com_fossil_aiq) {
        return null;
    }

    public Object findKeySerializer(aiq com_fossil_aiq) {
        return null;
    }

    public Object findContentSerializer(aiq com_fossil_aiq) {
        return null;
    }

    public Object findNullSerializer(aiq com_fossil_aiq) {
        return null;
    }

    public Class<?> findSerializationType(aiq com_fossil_aiq) {
        return null;
    }

    public Class<?> findSerializationKeyType(aiq com_fossil_aiq, JavaType javaType) {
        return null;
    }

    public Class<?> findSerializationContentType(aiq com_fossil_aiq, JavaType javaType) {
        return null;
    }

    public Typing findSerializationTyping(aiq com_fossil_aiq) {
        return null;
    }

    public Object findSerializationConverter(aiq com_fossil_aiq) {
        return null;
    }

    public Object findSerializationContentConverter(AnnotatedMember annotatedMember) {
        return null;
    }

    public Include findSerializationInclusion(aiq com_fossil_aiq, Include include) {
        return include;
    }

    public Include findSerializationInclusionForContent(aiq com_fossil_aiq, Include include) {
        return include;
    }

    public C1502a findPropertyInclusion(aiq com_fossil_aiq) {
        Include include = Include.USE_DEFAULTS;
        return C1502a.m2654a(findSerializationInclusion(com_fossil_aiq, include), findSerializationInclusionForContent(com_fossil_aiq, include));
    }

    public String[] findSerializationPropertyOrder(air com_fossil_air) {
        return null;
    }

    public Boolean findSerializationSortAlphabetically(aiq com_fossil_aiq) {
        return null;
    }

    public void findAndAddVirtualProperties(MapperConfig<?> mapperConfig, air com_fossil_air, List<ald> list) {
    }

    public PropertyName findNameForSerialization(aiq com_fossil_aiq) {
        return null;
    }

    public boolean hasAsValueAnnotation(AnnotatedMethod annotatedMethod) {
        return false;
    }

    public String findEnumValue(Enum<?> enumR) {
        return enumR.name();
    }

    public Object findDeserializer(aiq com_fossil_aiq) {
        return null;
    }

    public Object findKeyDeserializer(aiq com_fossil_aiq) {
        return null;
    }

    public Object findContentDeserializer(aiq com_fossil_aiq) {
        return null;
    }

    public Class<?> findDeserializationType(aiq com_fossil_aiq, JavaType javaType) {
        return null;
    }

    public Class<?> findDeserializationKeyType(aiq com_fossil_aiq, JavaType javaType) {
        return null;
    }

    public Class<?> findDeserializationContentType(aiq com_fossil_aiq, JavaType javaType) {
        return null;
    }

    public Object findDeserializationConverter(aiq com_fossil_aiq) {
        return null;
    }

    public Object findDeserializationContentConverter(AnnotatedMember annotatedMember) {
        return null;
    }

    public Object findValueInstantiator(air com_fossil_air) {
        return null;
    }

    public Class<?> findPOJOBuilder(air com_fossil_air) {
        return null;
    }

    public C1642a findPOJOBuilderConfig(air com_fossil_air) {
        return null;
    }

    public PropertyName findNameForDeserialization(aiq com_fossil_aiq) {
        return null;
    }

    public boolean hasAnySetterAnnotation(AnnotatedMethod annotatedMethod) {
        return false;
    }

    public boolean hasAnyGetterAnnotation(AnnotatedMethod annotatedMethod) {
        return false;
    }

    public boolean hasCreatorAnnotation(aiq com_fossil_aiq) {
        return false;
    }

    public Mode findCreatorBinding(aiq com_fossil_aiq) {
        return null;
    }

    protected <A extends Annotation> A _findAnnotation(aiq com_fossil_aiq, Class<A> cls) {
        return com_fossil_aiq.getAnnotation(cls);
    }

    protected boolean _hasAnnotation(aiq com_fossil_aiq, Class<? extends Annotation> cls) {
        return com_fossil_aiq.hasAnnotation(cls);
    }
}
