package com.fasterxml.jackson.databind.introspect;

import com.fasterxml.jackson.annotation.JsonCreator.Mode;
import com.fasterxml.jackson.annotation.JsonFormat.C1501b;
import com.fasterxml.jackson.annotation.JsonInclude.C1502a;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty.Access;
import com.fasterxml.jackson.core.Version;
import com.fasterxml.jackson.databind.AnnotationIntrospector;
import com.fasterxml.jackson.databind.AnnotationIntrospector.ReferenceProperty;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.PropertyName;
import com.fasterxml.jackson.databind.annotation.JsonSerialize.Typing;
import com.fasterxml.jackson.databind.cfg.MapperConfig;
import com.fasterxml.jackson.databind.jsontype.NamedType;
import com.fossil.agy.C1636a;
import com.fossil.ahb.C1638a;
import com.fossil.ahc.C1639a;
import com.fossil.ahl.C1642a;
import com.fossil.aiq;
import com.fossil.air;
import com.fossil.aiy;
import com.fossil.aju;
import com.fossil.ald;
import com.fossil.ami;
import com.fossil.amo;
import java.io.Serializable;
import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class AnnotationIntrospectorPair extends AnnotationIntrospector implements Serializable {
    private static final long serialVersionUID = 1;
    protected final AnnotationIntrospector _primary;
    protected final AnnotationIntrospector _secondary;

    public AnnotationIntrospectorPair(AnnotationIntrospector annotationIntrospector, AnnotationIntrospector annotationIntrospector2) {
        this._primary = annotationIntrospector;
        this._secondary = annotationIntrospector2;
    }

    public Version version() {
        return this._primary.version();
    }

    public static AnnotationIntrospector create(AnnotationIntrospector annotationIntrospector, AnnotationIntrospector annotationIntrospector2) {
        if (annotationIntrospector == null) {
            return annotationIntrospector2;
        }
        if (annotationIntrospector2 == null) {
            return annotationIntrospector;
        }
        return new AnnotationIntrospectorPair(annotationIntrospector, annotationIntrospector2);
    }

    public Collection<AnnotationIntrospector> allIntrospectors() {
        return allIntrospectors(new ArrayList());
    }

    public Collection<AnnotationIntrospector> allIntrospectors(Collection<AnnotationIntrospector> collection) {
        this._primary.allIntrospectors(collection);
        this._secondary.allIntrospectors(collection);
        return collection;
    }

    public boolean isAnnotationBundle(Annotation annotation) {
        return this._primary.isAnnotationBundle(annotation) || this._secondary.isAnnotationBundle(annotation);
    }

    public PropertyName findRootName(air com_fossil_air) {
        PropertyName findRootName = this._primary.findRootName(com_fossil_air);
        if (findRootName == null) {
            return this._secondary.findRootName(com_fossil_air);
        }
        if (findRootName.hasSimpleName()) {
            return findRootName;
        }
        PropertyName findRootName2 = this._secondary.findRootName(com_fossil_air);
        return findRootName2 != null ? findRootName2 : findRootName;
    }

    @Deprecated
    public String[] findPropertiesToIgnore(aiq com_fossil_aiq) {
        String[] findPropertiesToIgnore = this._primary.findPropertiesToIgnore(com_fossil_aiq);
        if (findPropertiesToIgnore == null) {
            return this._secondary.findPropertiesToIgnore(com_fossil_aiq);
        }
        return findPropertiesToIgnore;
    }

    public String[] findPropertiesToIgnore(aiq com_fossil_aiq, boolean z) {
        String[] findPropertiesToIgnore = this._primary.findPropertiesToIgnore(com_fossil_aiq, z);
        if (findPropertiesToIgnore == null) {
            return this._secondary.findPropertiesToIgnore(com_fossil_aiq, z);
        }
        return findPropertiesToIgnore;
    }

    public Boolean findIgnoreUnknownProperties(air com_fossil_air) {
        Boolean findIgnoreUnknownProperties = this._primary.findIgnoreUnknownProperties(com_fossil_air);
        if (findIgnoreUnknownProperties == null) {
            return this._secondary.findIgnoreUnknownProperties(com_fossil_air);
        }
        return findIgnoreUnknownProperties;
    }

    public Boolean isIgnorableType(air com_fossil_air) {
        Boolean isIgnorableType = this._primary.isIgnorableType(com_fossil_air);
        if (isIgnorableType == null) {
            return this._secondary.isIgnorableType(com_fossil_air);
        }
        return isIgnorableType;
    }

    @Deprecated
    public Object findFilterId(air com_fossil_air) {
        Object findFilterId = this._primary.findFilterId(com_fossil_air);
        if (findFilterId == null) {
            return this._secondary.findFilterId(com_fossil_air);
        }
        return findFilterId;
    }

    public Object findFilterId(aiq com_fossil_aiq) {
        Object findFilterId = this._primary.findFilterId(com_fossil_aiq);
        if (findFilterId == null) {
            return this._secondary.findFilterId(com_fossil_aiq);
        }
        return findFilterId;
    }

    public Object findNamingStrategy(air com_fossil_air) {
        Object findNamingStrategy = this._primary.findNamingStrategy(com_fossil_air);
        if (findNamingStrategy == null) {
            return this._secondary.findNamingStrategy(com_fossil_air);
        }
        return findNamingStrategy;
    }

    public VisibilityChecker<?> findAutoDetectVisibility(air com_fossil_air, VisibilityChecker<?> visibilityChecker) {
        return this._primary.findAutoDetectVisibility(com_fossil_air, this._secondary.findAutoDetectVisibility(com_fossil_air, visibilityChecker));
    }

    public aju<?> findTypeResolver(MapperConfig<?> mapperConfig, air com_fossil_air, JavaType javaType) {
        aju<?> findTypeResolver = this._primary.findTypeResolver(mapperConfig, com_fossil_air, javaType);
        if (findTypeResolver == null) {
            return this._secondary.findTypeResolver(mapperConfig, com_fossil_air, javaType);
        }
        return findTypeResolver;
    }

    public aju<?> findPropertyTypeResolver(MapperConfig<?> mapperConfig, AnnotatedMember annotatedMember, JavaType javaType) {
        aju<?> findPropertyTypeResolver = this._primary.findPropertyTypeResolver(mapperConfig, annotatedMember, javaType);
        if (findPropertyTypeResolver == null) {
            return this._secondary.findPropertyTypeResolver(mapperConfig, annotatedMember, javaType);
        }
        return findPropertyTypeResolver;
    }

    public aju<?> findPropertyContentTypeResolver(MapperConfig<?> mapperConfig, AnnotatedMember annotatedMember, JavaType javaType) {
        aju<?> findPropertyContentTypeResolver = this._primary.findPropertyContentTypeResolver(mapperConfig, annotatedMember, javaType);
        if (findPropertyContentTypeResolver == null) {
            return this._secondary.findPropertyContentTypeResolver(mapperConfig, annotatedMember, javaType);
        }
        return findPropertyContentTypeResolver;
    }

    public List<NamedType> findSubtypes(aiq com_fossil_aiq) {
        Collection findSubtypes = this._primary.findSubtypes(com_fossil_aiq);
        Collection findSubtypes2 = this._secondary.findSubtypes(com_fossil_aiq);
        if (findSubtypes == null || findSubtypes.isEmpty()) {
            return findSubtypes2;
        }
        if (findSubtypes2 == null || findSubtypes2.isEmpty()) {
            return findSubtypes;
        }
        List<NamedType> arrayList = new ArrayList(findSubtypes.size() + findSubtypes2.size());
        arrayList.addAll(findSubtypes);
        arrayList.addAll(findSubtypes2);
        return arrayList;
    }

    public String findTypeName(air com_fossil_air) {
        String findTypeName = this._primary.findTypeName(com_fossil_air);
        if (findTypeName == null || findTypeName.length() == 0) {
            return this._secondary.findTypeName(com_fossil_air);
        }
        return findTypeName;
    }

    public ReferenceProperty findReferenceType(AnnotatedMember annotatedMember) {
        ReferenceProperty findReferenceType = this._primary.findReferenceType(annotatedMember);
        return findReferenceType == null ? this._secondary.findReferenceType(annotatedMember) : findReferenceType;
    }

    public amo findUnwrappingNameTransformer(AnnotatedMember annotatedMember) {
        amo findUnwrappingNameTransformer = this._primary.findUnwrappingNameTransformer(annotatedMember);
        return findUnwrappingNameTransformer == null ? this._secondary.findUnwrappingNameTransformer(annotatedMember) : findUnwrappingNameTransformer;
    }

    public Object findInjectableValueId(AnnotatedMember annotatedMember) {
        Object findInjectableValueId = this._primary.findInjectableValueId(annotatedMember);
        return findInjectableValueId == null ? this._secondary.findInjectableValueId(annotatedMember) : findInjectableValueId;
    }

    public boolean hasIgnoreMarker(AnnotatedMember annotatedMember) {
        return this._primary.hasIgnoreMarker(annotatedMember) || this._secondary.hasIgnoreMarker(annotatedMember);
    }

    public Boolean hasRequiredMarker(AnnotatedMember annotatedMember) {
        Boolean hasRequiredMarker = this._primary.hasRequiredMarker(annotatedMember);
        return hasRequiredMarker == null ? this._secondary.hasRequiredMarker(annotatedMember) : hasRequiredMarker;
    }

    public Object findSerializer(aiq com_fossil_aiq) {
        Object findSerializer = this._primary.findSerializer(com_fossil_aiq);
        return _isExplicitClassOrOb(findSerializer, C1638a.class) ? findSerializer : this._secondary.findSerializer(com_fossil_aiq);
    }

    public Object findKeySerializer(aiq com_fossil_aiq) {
        Object findKeySerializer = this._primary.findKeySerializer(com_fossil_aiq);
        return _isExplicitClassOrOb(findKeySerializer, C1638a.class) ? findKeySerializer : this._secondary.findKeySerializer(com_fossil_aiq);
    }

    public Object findContentSerializer(aiq com_fossil_aiq) {
        Object findContentSerializer = this._primary.findContentSerializer(com_fossil_aiq);
        return _isExplicitClassOrOb(findContentSerializer, C1638a.class) ? findContentSerializer : this._secondary.findContentSerializer(com_fossil_aiq);
    }

    public Object findNullSerializer(aiq com_fossil_aiq) {
        Object findNullSerializer = this._primary.findNullSerializer(com_fossil_aiq);
        return _isExplicitClassOrOb(findNullSerializer, C1638a.class) ? findNullSerializer : this._secondary.findNullSerializer(com_fossil_aiq);
    }

    public Include findSerializationInclusion(aiq com_fossil_aiq, Include include) {
        return this._primary.findSerializationInclusion(com_fossil_aiq, this._secondary.findSerializationInclusion(com_fossil_aiq, include));
    }

    public Include findSerializationInclusionForContent(aiq com_fossil_aiq, Include include) {
        return this._primary.findSerializationInclusion(com_fossil_aiq, this._secondary.findSerializationInclusion(com_fossil_aiq, include));
    }

    public C1502a findPropertyInclusion(aiq com_fossil_aiq) {
        C1502a findPropertyInclusion = this._secondary.findPropertyInclusion(com_fossil_aiq);
        C1502a findPropertyInclusion2 = this._secondary.findPropertyInclusion(com_fossil_aiq);
        return findPropertyInclusion == null ? findPropertyInclusion2 : findPropertyInclusion.m2656a(findPropertyInclusion2);
    }

    public Class<?> findSerializationType(aiq com_fossil_aiq) {
        Class<?> findSerializationType = this._primary.findSerializationType(com_fossil_aiq);
        return findSerializationType == null ? this._secondary.findSerializationType(com_fossil_aiq) : findSerializationType;
    }

    public Class<?> findSerializationKeyType(aiq com_fossil_aiq, JavaType javaType) {
        Class<?> findSerializationKeyType = this._primary.findSerializationKeyType(com_fossil_aiq, javaType);
        return findSerializationKeyType == null ? this._secondary.findSerializationKeyType(com_fossil_aiq, javaType) : findSerializationKeyType;
    }

    public Class<?> findSerializationContentType(aiq com_fossil_aiq, JavaType javaType) {
        Class<?> findSerializationContentType = this._primary.findSerializationContentType(com_fossil_aiq, javaType);
        return findSerializationContentType == null ? this._secondary.findSerializationContentType(com_fossil_aiq, javaType) : findSerializationContentType;
    }

    public Typing findSerializationTyping(aiq com_fossil_aiq) {
        Typing findSerializationTyping = this._primary.findSerializationTyping(com_fossil_aiq);
        return findSerializationTyping == null ? this._secondary.findSerializationTyping(com_fossil_aiq) : findSerializationTyping;
    }

    public Object findSerializationConverter(aiq com_fossil_aiq) {
        Object findSerializationConverter = this._primary.findSerializationConverter(com_fossil_aiq);
        return findSerializationConverter == null ? this._secondary.findSerializationConverter(com_fossil_aiq) : findSerializationConverter;
    }

    public Object findSerializationContentConverter(AnnotatedMember annotatedMember) {
        Object findSerializationContentConverter = this._primary.findSerializationContentConverter(annotatedMember);
        return findSerializationContentConverter == null ? this._secondary.findSerializationContentConverter(annotatedMember) : findSerializationContentConverter;
    }

    public Class<?>[] findViews(aiq com_fossil_aiq) {
        Class<?>[] findViews = this._primary.findViews(com_fossil_aiq);
        if (findViews == null) {
            return this._secondary.findViews(com_fossil_aiq);
        }
        return findViews;
    }

    public Boolean isTypeId(AnnotatedMember annotatedMember) {
        Boolean isTypeId = this._primary.isTypeId(annotatedMember);
        return isTypeId == null ? this._secondary.isTypeId(annotatedMember) : isTypeId;
    }

    public aiy findObjectIdInfo(aiq com_fossil_aiq) {
        aiy findObjectIdInfo = this._primary.findObjectIdInfo(com_fossil_aiq);
        return findObjectIdInfo == null ? this._secondary.findObjectIdInfo(com_fossil_aiq) : findObjectIdInfo;
    }

    public aiy findObjectReferenceInfo(aiq com_fossil_aiq, aiy com_fossil_aiy) {
        return this._primary.findObjectReferenceInfo(com_fossil_aiq, this._secondary.findObjectReferenceInfo(com_fossil_aiq, com_fossil_aiy));
    }

    public C1501b findFormat(aiq com_fossil_aiq) {
        C1501b findFormat = this._primary.findFormat(com_fossil_aiq);
        return findFormat == null ? this._secondary.findFormat(com_fossil_aiq) : findFormat;
    }

    public PropertyName findWrapperName(aiq com_fossil_aiq) {
        PropertyName findWrapperName = this._primary.findWrapperName(com_fossil_aiq);
        if (findWrapperName == null) {
            return this._secondary.findWrapperName(com_fossil_aiq);
        }
        if (findWrapperName == PropertyName.USE_DEFAULT) {
            PropertyName findWrapperName2 = this._secondary.findWrapperName(com_fossil_aiq);
            if (findWrapperName2 != null) {
                return findWrapperName2;
            }
        }
        return findWrapperName;
    }

    public String findPropertyDefaultValue(aiq com_fossil_aiq) {
        String findPropertyDefaultValue = this._primary.findPropertyDefaultValue(com_fossil_aiq);
        return (findPropertyDefaultValue == null || findPropertyDefaultValue.isEmpty()) ? this._secondary.findPropertyDefaultValue(com_fossil_aiq) : findPropertyDefaultValue;
    }

    public String findPropertyDescription(aiq com_fossil_aiq) {
        String findPropertyDescription = this._primary.findPropertyDescription(com_fossil_aiq);
        return findPropertyDescription == null ? this._secondary.findPropertyDescription(com_fossil_aiq) : findPropertyDescription;
    }

    public Integer findPropertyIndex(aiq com_fossil_aiq) {
        Integer findPropertyIndex = this._primary.findPropertyIndex(com_fossil_aiq);
        return findPropertyIndex == null ? this._secondary.findPropertyIndex(com_fossil_aiq) : findPropertyIndex;
    }

    public String findImplicitPropertyName(AnnotatedMember annotatedMember) {
        String findImplicitPropertyName = this._primary.findImplicitPropertyName(annotatedMember);
        return findImplicitPropertyName == null ? this._secondary.findImplicitPropertyName(annotatedMember) : findImplicitPropertyName;
    }

    public Access findPropertyAccess(aiq com_fossil_aiq) {
        Access findPropertyAccess = this._primary.findPropertyAccess(com_fossil_aiq);
        if (findPropertyAccess != null && findPropertyAccess != Access.AUTO) {
            return findPropertyAccess;
        }
        findPropertyAccess = this._secondary.findPropertyAccess(com_fossil_aiq);
        return findPropertyAccess == null ? Access.AUTO : findPropertyAccess;
    }

    public String[] findSerializationPropertyOrder(air com_fossil_air) {
        String[] findSerializationPropertyOrder = this._primary.findSerializationPropertyOrder(com_fossil_air);
        return findSerializationPropertyOrder == null ? this._secondary.findSerializationPropertyOrder(com_fossil_air) : findSerializationPropertyOrder;
    }

    public Boolean findSerializationSortAlphabetically(aiq com_fossil_aiq) {
        Boolean findSerializationSortAlphabetically = this._primary.findSerializationSortAlphabetically(com_fossil_aiq);
        return findSerializationSortAlphabetically == null ? this._secondary.findSerializationSortAlphabetically(com_fossil_aiq) : findSerializationSortAlphabetically;
    }

    public void findAndAddVirtualProperties(MapperConfig<?> mapperConfig, air com_fossil_air, List<ald> list) {
        this._primary.findAndAddVirtualProperties(mapperConfig, com_fossil_air, list);
        this._secondary.findAndAddVirtualProperties(mapperConfig, com_fossil_air, list);
    }

    public PropertyName findNameForSerialization(aiq com_fossil_aiq) {
        PropertyName findNameForSerialization = this._primary.findNameForSerialization(com_fossil_aiq);
        if (findNameForSerialization == null) {
            return this._secondary.findNameForSerialization(com_fossil_aiq);
        }
        if (findNameForSerialization == PropertyName.USE_DEFAULT) {
            PropertyName findNameForSerialization2 = this._secondary.findNameForSerialization(com_fossil_aiq);
            if (findNameForSerialization2 != null) {
                return findNameForSerialization2;
            }
        }
        return findNameForSerialization;
    }

    public boolean hasAsValueAnnotation(AnnotatedMethod annotatedMethod) {
        return this._primary.hasAsValueAnnotation(annotatedMethod) || this._secondary.hasAsValueAnnotation(annotatedMethod);
    }

    public String findEnumValue(Enum<?> enumR) {
        String findEnumValue = this._primary.findEnumValue(enumR);
        return findEnumValue == null ? this._secondary.findEnumValue(enumR) : findEnumValue;
    }

    public Object findDeserializer(aiq com_fossil_aiq) {
        Object findDeserializer = this._primary.findDeserializer(com_fossil_aiq);
        return _isExplicitClassOrOb(findDeserializer, C1636a.class) ? findDeserializer : this._secondary.findDeserializer(com_fossil_aiq);
    }

    public Object findKeyDeserializer(aiq com_fossil_aiq) {
        Object findKeyDeserializer = this._primary.findKeyDeserializer(com_fossil_aiq);
        return _isExplicitClassOrOb(findKeyDeserializer, C1639a.class) ? findKeyDeserializer : this._secondary.findKeyDeserializer(com_fossil_aiq);
    }

    public Object findContentDeserializer(aiq com_fossil_aiq) {
        Object findContentDeserializer = this._primary.findContentDeserializer(com_fossil_aiq);
        return _isExplicitClassOrOb(findContentDeserializer, C1636a.class) ? findContentDeserializer : this._secondary.findContentDeserializer(com_fossil_aiq);
    }

    public Class<?> findDeserializationType(aiq com_fossil_aiq, JavaType javaType) {
        Class<?> findDeserializationType = this._primary.findDeserializationType(com_fossil_aiq, javaType);
        return findDeserializationType != null ? findDeserializationType : this._secondary.findDeserializationType(com_fossil_aiq, javaType);
    }

    public Class<?> findDeserializationKeyType(aiq com_fossil_aiq, JavaType javaType) {
        Class<?> findDeserializationKeyType = this._primary.findDeserializationKeyType(com_fossil_aiq, javaType);
        return findDeserializationKeyType == null ? this._secondary.findDeserializationKeyType(com_fossil_aiq, javaType) : findDeserializationKeyType;
    }

    public Class<?> findDeserializationContentType(aiq com_fossil_aiq, JavaType javaType) {
        Class<?> findDeserializationContentType = this._primary.findDeserializationContentType(com_fossil_aiq, javaType);
        return findDeserializationContentType == null ? this._secondary.findDeserializationContentType(com_fossil_aiq, javaType) : findDeserializationContentType;
    }

    public Object findDeserializationConverter(aiq com_fossil_aiq) {
        Object findDeserializationConverter = this._primary.findDeserializationConverter(com_fossil_aiq);
        return findDeserializationConverter == null ? this._secondary.findDeserializationConverter(com_fossil_aiq) : findDeserializationConverter;
    }

    public Object findDeserializationContentConverter(AnnotatedMember annotatedMember) {
        Object findDeserializationContentConverter = this._primary.findDeserializationContentConverter(annotatedMember);
        return findDeserializationContentConverter == null ? this._secondary.findDeserializationContentConverter(annotatedMember) : findDeserializationContentConverter;
    }

    public Object findValueInstantiator(air com_fossil_air) {
        Object findValueInstantiator = this._primary.findValueInstantiator(com_fossil_air);
        return findValueInstantiator == null ? this._secondary.findValueInstantiator(com_fossil_air) : findValueInstantiator;
    }

    public Class<?> findPOJOBuilder(air com_fossil_air) {
        Class<?> findPOJOBuilder = this._primary.findPOJOBuilder(com_fossil_air);
        return findPOJOBuilder == null ? this._secondary.findPOJOBuilder(com_fossil_air) : findPOJOBuilder;
    }

    public C1642a findPOJOBuilderConfig(air com_fossil_air) {
        C1642a findPOJOBuilderConfig = this._primary.findPOJOBuilderConfig(com_fossil_air);
        return findPOJOBuilderConfig == null ? this._secondary.findPOJOBuilderConfig(com_fossil_air) : findPOJOBuilderConfig;
    }

    public PropertyName findNameForDeserialization(aiq com_fossil_aiq) {
        PropertyName findNameForDeserialization = this._primary.findNameForDeserialization(com_fossil_aiq);
        if (findNameForDeserialization == null) {
            return this._secondary.findNameForDeserialization(com_fossil_aiq);
        }
        if (findNameForDeserialization == PropertyName.USE_DEFAULT) {
            PropertyName findNameForDeserialization2 = this._secondary.findNameForDeserialization(com_fossil_aiq);
            if (findNameForDeserialization2 != null) {
                return findNameForDeserialization2;
            }
        }
        return findNameForDeserialization;
    }

    public boolean hasAnySetterAnnotation(AnnotatedMethod annotatedMethod) {
        return this._primary.hasAnySetterAnnotation(annotatedMethod) || this._secondary.hasAnySetterAnnotation(annotatedMethod);
    }

    public boolean hasAnyGetterAnnotation(AnnotatedMethod annotatedMethod) {
        return this._primary.hasAnyGetterAnnotation(annotatedMethod) || this._secondary.hasAnyGetterAnnotation(annotatedMethod);
    }

    public boolean hasCreatorAnnotation(aiq com_fossil_aiq) {
        return this._primary.hasCreatorAnnotation(com_fossil_aiq) || this._secondary.hasCreatorAnnotation(com_fossil_aiq);
    }

    public Mode findCreatorBinding(aiq com_fossil_aiq) {
        Mode findCreatorBinding = this._primary.findCreatorBinding(com_fossil_aiq);
        return findCreatorBinding != null ? findCreatorBinding : this._secondary.findCreatorBinding(com_fossil_aiq);
    }

    protected boolean _isExplicitClassOrOb(Object obj, Class<?> cls) {
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof Class)) {
            return true;
        }
        Class<?> cls2 = (Class) obj;
        if (cls2 == cls || ami.m3854D(cls2)) {
            return false;
        }
        return true;
    }
}
