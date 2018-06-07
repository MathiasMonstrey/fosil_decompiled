package com.fasterxml.jackson.databind.introspect;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonCreator.Mode;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.C1501b;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.C1502a;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeInfo.As;
import com.fasterxml.jackson.annotation.JsonTypeInfo.C1503a;
import com.fasterxml.jackson.annotation.JsonTypeInfo.Id;
import com.fasterxml.jackson.annotation.ObjectIdGenerators.None;
import com.fasterxml.jackson.core.Version;
import com.fasterxml.jackson.databind.AnnotationIntrospector;
import com.fasterxml.jackson.databind.AnnotationIntrospector.ReferenceProperty;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.PropertyMetadata;
import com.fasterxml.jackson.databind.PropertyName;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize.Typing;
import com.fasterxml.jackson.databind.cfg.MapperConfig;
import com.fasterxml.jackson.databind.jsontype.NamedType;
import com.fasterxml.jackson.databind.ser.std.RawSerializer;
import com.fossil.adw;
import com.fossil.adx;
import com.fossil.ady;
import com.fossil.adz;
import com.fossil.aea;
import com.fossil.aeb;
import com.fossil.aec;
import com.fossil.aed;
import com.fossil.aee;
import com.fossil.aef;
import com.fossil.aeg;
import com.fossil.aeh;
import com.fossil.aei;
import com.fossil.aej;
import com.fossil.aek;
import com.fossil.ael;
import com.fossil.aem;
import com.fossil.aen;
import com.fossil.aeo;
import com.fossil.aeo.C1617a;
import com.fossil.aep;
import com.fossil.aeq;
import com.fossil.aer;
import com.fossil.aes;
import com.fossil.aet;
import com.fossil.agy.C1636a;
import com.fossil.ahb.C1638a;
import com.fossil.ahc.C1639a;
import com.fossil.ahi;
import com.fossil.ahi.C1640a;
import com.fossil.ahi.C1641b;
import com.fossil.ahj;
import com.fossil.ahk;
import com.fossil.ahl;
import com.fossil.ahl.C1642a;
import com.fossil.ahm;
import com.fossil.ahn;
import com.fossil.aho;
import com.fossil.ahr;
import com.fossil.ahs;
import com.fossil.aiq;
import com.fossil.air;
import com.fossil.aiv;
import com.fossil.aiy;
import com.fossil.ajt;
import com.fossil.aju;
import com.fossil.akd;
import com.fossil.ald;
import com.fossil.alp;
import com.fossil.alq;
import com.fossil.ami;
import com.fossil.amk.C1703a;
import com.fossil.amo;
import com.fossil.ams;
import java.io.Serializable;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class JacksonAnnotationIntrospector extends AnnotationIntrospector implements Serializable {
    private static final long serialVersionUID = 1;

    public Version version() {
        return ahs.aOo;
    }

    public boolean isAnnotationBundle(Annotation annotation) {
        return annotation.annotationType().getAnnotation(adw.class) != null;
    }

    public String findEnumValue(Enum<?> enumR) {
        try {
            Field field = enumR.getClass().getField(enumR.name());
            if (field != null) {
                String value = ((JsonProperty) field.getAnnotation(JsonProperty.class)).value();
                if (!(value == null || value.isEmpty())) {
                    return value;
                }
            }
        } catch (Exception e) {
        }
        return enumR.name();
    }

    public PropertyName findRootName(air com_fossil_air) {
        String str = null;
        aem com_fossil_aem = (aem) _findAnnotation(com_fossil_air, aem.class);
        if (com_fossil_aem == null) {
            return null;
        }
        String zr = com_fossil_aem.zr();
        if (zr == null || zr.length() != 0) {
            str = zr;
        }
        return PropertyName.construct(com_fossil_aem.value(), str);
    }

    @Deprecated
    public String[] findPropertiesToIgnore(aiq com_fossil_aiq) {
        aeg com_fossil_aeg = (aeg) _findAnnotation(com_fossil_aiq, aeg.class);
        return com_fossil_aeg == null ? null : com_fossil_aeg.value();
    }

    public String[] findPropertiesToIgnore(aiq com_fossil_aiq, boolean z) {
        aeg com_fossil_aeg = (aeg) _findAnnotation(com_fossil_aiq, aeg.class);
        if (com_fossil_aeg == null) {
            return null;
        }
        if (z) {
            if (com_fossil_aeg.zj()) {
                return null;
            }
        } else if (com_fossil_aeg.zk()) {
            return null;
        }
        return com_fossil_aeg.value();
    }

    public Boolean findIgnoreUnknownProperties(air com_fossil_air) {
        aeg com_fossil_aeg = (aeg) _findAnnotation(com_fossil_air, aeg.class);
        return com_fossil_aeg == null ? null : Boolean.valueOf(com_fossil_aeg.zi());
    }

    public Boolean isIgnorableType(air com_fossil_air) {
        aeh com_fossil_aeh = (aeh) _findAnnotation(com_fossil_air, aeh.class);
        return com_fossil_aeh == null ? null : Boolean.valueOf(com_fossil_aeh.zh());
    }

    @Deprecated
    public Object findFilterId(air com_fossil_air) {
        return _findFilterId(com_fossil_air);
    }

    public Object findFilterId(aiq com_fossil_aiq) {
        return _findFilterId(com_fossil_aiq);
    }

    protected final Object _findFilterId(aiq com_fossil_aiq) {
        aeb com_fossil_aeb = (aeb) _findAnnotation(com_fossil_aiq, aeb.class);
        if (com_fossil_aeb != null) {
            String value = com_fossil_aeb.value();
            if (value.length() > 0) {
                return value;
            }
        }
        return null;
    }

    public Object findNamingStrategy(air com_fossil_air) {
        ahk com_fossil_ahk = (ahk) _findAnnotation(com_fossil_air, ahk.class);
        return com_fossil_ahk == null ? null : com_fossil_ahk.value();
    }

    public VisibilityChecker<?> findAutoDetectVisibility(air com_fossil_air, VisibilityChecker<?> visibilityChecker) {
        JsonAutoDetect jsonAutoDetect = (JsonAutoDetect) _findAnnotation(com_fossil_air, JsonAutoDetect.class);
        return jsonAutoDetect == null ? visibilityChecker : visibilityChecker.with(jsonAutoDetect);
    }

    public String findImplicitPropertyName(AnnotatedMember annotatedMember) {
        return null;
    }

    public boolean hasIgnoreMarker(AnnotatedMember annotatedMember) {
        return _isIgnorable(annotatedMember);
    }

    public Boolean hasRequiredMarker(AnnotatedMember annotatedMember) {
        JsonProperty jsonProperty = (JsonProperty) _findAnnotation(annotatedMember, JsonProperty.class);
        if (jsonProperty != null) {
            return Boolean.valueOf(jsonProperty.zn());
        }
        return null;
    }

    public Access findPropertyAccess(aiq com_fossil_aiq) {
        JsonProperty jsonProperty = (JsonProperty) _findAnnotation(com_fossil_aiq, JsonProperty.class);
        if (jsonProperty != null) {
            return jsonProperty.zp();
        }
        return null;
    }

    public String findPropertyDescription(aiq com_fossil_aiq) {
        aej com_fossil_aej = (aej) _findAnnotation(com_fossil_aiq, aej.class);
        return com_fossil_aej == null ? null : com_fossil_aej.value();
    }

    public Integer findPropertyIndex(aiq com_fossil_aiq) {
        JsonProperty jsonProperty = (JsonProperty) _findAnnotation(com_fossil_aiq, JsonProperty.class);
        if (jsonProperty != null) {
            int zo = jsonProperty.zo();
            if (zo != -1) {
                return Integer.valueOf(zo);
            }
        }
        return null;
    }

    public String findPropertyDefaultValue(aiq com_fossil_aiq) {
        JsonProperty jsonProperty = (JsonProperty) _findAnnotation(com_fossil_aiq, JsonProperty.class);
        if (jsonProperty == null) {
            return null;
        }
        String defaultValue = jsonProperty.defaultValue();
        if (defaultValue.isEmpty()) {
            defaultValue = null;
        }
        return defaultValue;
    }

    public C1501b findFormat(aiq com_fossil_aiq) {
        JsonFormat jsonFormat = (JsonFormat) _findAnnotation(com_fossil_aiq, JsonFormat.class);
        return jsonFormat == null ? null : new C1501b(jsonFormat);
    }

    public ReferenceProperty findReferenceType(AnnotatedMember annotatedMember) {
        aei com_fossil_aei = (aei) _findAnnotation(annotatedMember, aei.class);
        if (com_fossil_aei != null) {
            return ReferenceProperty.bD(com_fossil_aei.value());
        }
        aea com_fossil_aea = (aea) _findAnnotation(annotatedMember, aea.class);
        if (com_fossil_aea != null) {
            return ReferenceProperty.bE(com_fossil_aea.value());
        }
        return null;
    }

    public amo findUnwrappingNameTransformer(AnnotatedMember annotatedMember) {
        aer com_fossil_aer = (aer) _findAnnotation(annotatedMember, aer.class);
        if (com_fossil_aer == null || !com_fossil_aer.enabled()) {
            return null;
        }
        return amo.m3885u(com_fossil_aer.prefix(), com_fossil_aer.zx());
    }

    public Object findInjectableValueId(AnnotatedMember annotatedMember) {
        adx com_fossil_adx = (adx) _findAnnotation(annotatedMember, adx.class);
        if (com_fossil_adx == null) {
            return null;
        }
        Object value = com_fossil_adx.value();
        if (value.length() != 0) {
            return value;
        }
        if (!(annotatedMember instanceof AnnotatedMethod)) {
            return annotatedMember.getRawType().getName();
        }
        AnnotatedMethod annotatedMethod = (AnnotatedMethod) annotatedMember;
        if (annotatedMethod.getParameterCount() == 0) {
            return annotatedMember.getRawType().getName();
        }
        return annotatedMethod.getRawParameterType(0).getName();
    }

    public Class<?>[] findViews(aiq com_fossil_aiq) {
        aet com_fossil_aet = (aet) _findAnnotation(com_fossil_aiq, aet.class);
        return com_fossil_aet == null ? null : com_fossil_aet.zy();
    }

    public aju<?> findTypeResolver(MapperConfig<?> mapperConfig, air com_fossil_air, JavaType javaType) {
        return _findTypeResolver(mapperConfig, com_fossil_air, javaType);
    }

    public aju<?> findPropertyTypeResolver(MapperConfig<?> mapperConfig, AnnotatedMember annotatedMember, JavaType javaType) {
        if (javaType.isContainerType()) {
            return null;
        }
        return _findTypeResolver(mapperConfig, annotatedMember, javaType);
    }

    public aju<?> findPropertyContentTypeResolver(MapperConfig<?> mapperConfig, AnnotatedMember annotatedMember, JavaType javaType) {
        if (javaType.isContainerType()) {
            return _findTypeResolver(mapperConfig, annotatedMember, javaType);
        }
        throw new IllegalArgumentException("Must call method with a container type (got " + javaType + ")");
    }

    public List<NamedType> findSubtypes(aiq com_fossil_aiq) {
        aeo com_fossil_aeo = (aeo) _findAnnotation(com_fossil_aiq, aeo.class);
        if (com_fossil_aeo == null) {
            return null;
        }
        C1617a[] zs = com_fossil_aeo.zs();
        List<NamedType> arrayList = new ArrayList(zs.length);
        for (C1617a c1617a : zs) {
            arrayList.add(new NamedType(c1617a.value(), c1617a.name()));
        }
        return arrayList;
    }

    public String findTypeName(air com_fossil_air) {
        aeq com_fossil_aeq = (aeq) _findAnnotation(com_fossil_air, aeq.class);
        return com_fossil_aeq == null ? null : com_fossil_aeq.value();
    }

    public Boolean isTypeId(AnnotatedMember annotatedMember) {
        return Boolean.valueOf(_hasAnnotation(annotatedMember, aep.class));
    }

    public aiy findObjectIdInfo(aiq com_fossil_aiq) {
        aed com_fossil_aed = (aed) _findAnnotation(com_fossil_aiq, aed.class);
        if (com_fossil_aed == null || com_fossil_aed.zd() == None.class) {
            return null;
        }
        return new aiy(PropertyName.construct(com_fossil_aed.zc()), com_fossil_aed.zf(), com_fossil_aed.zd(), com_fossil_aed.ze());
    }

    public aiy findObjectReferenceInfo(aiq com_fossil_aiq, aiy com_fossil_aiy) {
        aee com_fossil_aee = (aee) _findAnnotation(com_fossil_aiq, aee.class);
        if (com_fossil_aee != null) {
            return com_fossil_aiy.aL(com_fossil_aee.zg());
        }
        return com_fossil_aiy;
    }

    public Object findSerializer(aiq com_fossil_aiq) {
        JsonSerialize jsonSerialize = (JsonSerialize) _findAnnotation(com_fossil_aiq, JsonSerialize.class);
        if (jsonSerialize != null) {
            Class Ec = jsonSerialize.Ec();
            if (Ec != C1638a.class) {
                return Ec;
            }
        }
        ael com_fossil_ael = (ael) _findAnnotation(com_fossil_aiq, ael.class);
        if (com_fossil_ael == null || !com_fossil_ael.zh()) {
            return null;
        }
        return new RawSerializer(com_fossil_aiq.getRawType());
    }

    public Object findKeySerializer(aiq com_fossil_aiq) {
        JsonSerialize jsonSerialize = (JsonSerialize) _findAnnotation(com_fossil_aiq, JsonSerialize.class);
        if (jsonSerialize != null) {
            Class Ee = jsonSerialize.Ee();
            if (Ee != C1638a.class) {
                return Ee;
            }
        }
        return null;
    }

    public Object findContentSerializer(aiq com_fossil_aiq) {
        JsonSerialize jsonSerialize = (JsonSerialize) _findAnnotation(com_fossil_aiq, JsonSerialize.class);
        if (jsonSerialize != null) {
            Class Ed = jsonSerialize.Ed();
            if (Ed != C1638a.class) {
                return Ed;
            }
        }
        return null;
    }

    public Object findNullSerializer(aiq com_fossil_aiq) {
        JsonSerialize jsonSerialize = (JsonSerialize) _findAnnotation(com_fossil_aiq, JsonSerialize.class);
        if (jsonSerialize != null) {
            Class Em = jsonSerialize.Em();
            if (Em != C1638a.class) {
                return Em;
            }
        }
        return null;
    }

    public Include findSerializationInclusion(aiq com_fossil_aiq, Include include) {
        JsonInclude jsonInclude = (JsonInclude) _findAnnotation(com_fossil_aiq, JsonInclude.class);
        if (jsonInclude != null) {
            Include zl = jsonInclude.zl();
            if (zl != Include.USE_DEFAULTS) {
                return zl;
            }
        }
        JsonSerialize jsonSerialize = (JsonSerialize) _findAnnotation(com_fossil_aiq, JsonSerialize.class);
        if (jsonSerialize == null) {
            return include;
        }
        switch (jsonSerialize.Eo()) {
            case ALWAYS:
                return Include.ALWAYS;
            case NON_NULL:
                return Include.NON_NULL;
            case NON_DEFAULT:
                return Include.NON_DEFAULT;
            case NON_EMPTY:
                return Include.NON_EMPTY;
            default:
                return include;
        }
    }

    public Include findSerializationInclusionForContent(aiq com_fossil_aiq, Include include) {
        JsonInclude jsonInclude = (JsonInclude) _findAnnotation(com_fossil_aiq, JsonInclude.class);
        if (jsonInclude == null) {
            return include;
        }
        Include zm = jsonInclude.zm();
        if (zm != Include.USE_DEFAULTS) {
            return zm;
        }
        return include;
    }

    public C1502a findPropertyInclusion(aiq com_fossil_aiq) {
        JsonInclude jsonInclude = (JsonInclude) _findAnnotation(com_fossil_aiq, JsonInclude.class);
        Include zl = jsonInclude == null ? Include.USE_DEFAULTS : jsonInclude.zl();
        if (zl == Include.USE_DEFAULTS) {
            JsonSerialize jsonSerialize = (JsonSerialize) _findAnnotation(com_fossil_aiq, JsonSerialize.class);
            if (jsonSerialize != null) {
                switch (jsonSerialize.Eo()) {
                    case ALWAYS:
                        zl = Include.ALWAYS;
                        break;
                    case NON_NULL:
                        zl = Include.NON_NULL;
                        break;
                    case NON_DEFAULT:
                        zl = Include.NON_DEFAULT;
                        break;
                    case NON_EMPTY:
                        zl = Include.NON_EMPTY;
                        break;
                }
            }
        }
        return C1502a.m2654a(zl, jsonInclude == null ? Include.USE_DEFAULTS : jsonInclude.zm());
    }

    public Class<?> findSerializationType(aiq com_fossil_aiq) {
        JsonSerialize jsonSerialize = (JsonSerialize) _findAnnotation(com_fossil_aiq, JsonSerialize.class);
        return jsonSerialize == null ? null : _classIfExplicit(jsonSerialize.Eh());
    }

    public Class<?> findSerializationKeyType(aiq com_fossil_aiq, JavaType javaType) {
        JsonSerialize jsonSerialize = (JsonSerialize) _findAnnotation(com_fossil_aiq, JsonSerialize.class);
        return jsonSerialize == null ? null : _classIfExplicit(jsonSerialize.Ei());
    }

    public Class<?> findSerializationContentType(aiq com_fossil_aiq, JavaType javaType) {
        JsonSerialize jsonSerialize = (JsonSerialize) _findAnnotation(com_fossil_aiq, JsonSerialize.class);
        return jsonSerialize == null ? null : _classIfExplicit(jsonSerialize.Ej());
    }

    public Typing findSerializationTyping(aiq com_fossil_aiq) {
        JsonSerialize jsonSerialize = (JsonSerialize) _findAnnotation(com_fossil_aiq, JsonSerialize.class);
        return jsonSerialize == null ? null : jsonSerialize.En();
    }

    public Object findSerializationConverter(aiq com_fossil_aiq) {
        JsonSerialize jsonSerialize = (JsonSerialize) _findAnnotation(com_fossil_aiq, JsonSerialize.class);
        return jsonSerialize == null ? null : _classIfExplicit(jsonSerialize.converter(), C1703a.class);
    }

    public Object findSerializationContentConverter(AnnotatedMember annotatedMember) {
        JsonSerialize jsonSerialize = (JsonSerialize) _findAnnotation(annotatedMember, JsonSerialize.class);
        return jsonSerialize == null ? null : _classIfExplicit(jsonSerialize.Eg(), C1703a.class);
    }

    public String[] findSerializationPropertyOrder(air com_fossil_air) {
        aek com_fossil_aek = (aek) _findAnnotation(com_fossil_air, aek.class);
        return com_fossil_aek == null ? null : com_fossil_aek.value();
    }

    public Boolean findSerializationSortAlphabetically(aiq com_fossil_aiq) {
        return m2746a(com_fossil_aiq);
    }

    private final Boolean m2746a(aiq com_fossil_aiq) {
        aek com_fossil_aek = (aek) _findAnnotation(com_fossil_aiq, aek.class);
        if (com_fossil_aek == null || !com_fossil_aek.zq()) {
            return null;
        }
        return Boolean.TRUE;
    }

    public void findAndAddVirtualProperties(MapperConfig<?> mapperConfig, air com_fossil_air, List<ald> list) {
        ahi com_fossil_ahi = (ahi) _findAnnotation(com_fossil_air, ahi.class);
        if (com_fossil_ahi != null) {
            int i;
            boolean DY = com_fossil_ahi.DY();
            JavaType javaType = null;
            C1640a[] DW = com_fossil_ahi.DW();
            int length = DW.length;
            for (i = 0; i < length; i++) {
                if (javaType == null) {
                    javaType = mapperConfig.constructType(Object.class);
                }
                ald _constructVirtualProperty = _constructVirtualProperty(DW[i], mapperConfig, com_fossil_air, javaType);
                if (DY) {
                    list.add(i, _constructVirtualProperty);
                } else {
                    list.add(_constructVirtualProperty);
                }
            }
            C1641b[] DX = com_fossil_ahi.DX();
            i = DX.length;
            for (int i2 = 0; i2 < i; i2++) {
                ald _constructVirtualProperty2 = _constructVirtualProperty(DX[i2], mapperConfig, com_fossil_air);
                if (DY) {
                    list.add(i2, _constructVirtualProperty2);
                } else {
                    list.add(_constructVirtualProperty2);
                }
            }
        }
    }

    protected ald _constructVirtualProperty(C1640a c1640a, MapperConfig<?> mapperConfig, air com_fossil_air, JavaType javaType) {
        PropertyMetadata propertyMetadata = c1640a.zn() ? PropertyMetadata.STD_REQUIRED : PropertyMetadata.STD_OPTIONAL;
        String value = c1640a.value();
        PropertyName _propertyName = _propertyName(c1640a.DZ(), c1640a.Ea());
        if (!_propertyName.hasSimpleName()) {
            _propertyName = PropertyName.construct(value);
        }
        return alq.m3749a(value, ams.m3897a(mapperConfig, new VirtualAnnotatedMember(com_fossil_air, com_fossil_air.getRawType(), value, javaType.getRawClass()), _propertyName, propertyMetadata, c1640a.Eb()), com_fossil_air.ER(), javaType);
    }

    protected ald _constructVirtualProperty(C1641b c1641b, MapperConfig<?> mapperConfig, air com_fossil_air) {
        PropertyMetadata propertyMetadata = c1641b.zn() ? PropertyMetadata.STD_REQUIRED : PropertyMetadata.STD_OPTIONAL;
        PropertyName _propertyName = _propertyName(c1641b.name(), c1641b.zr());
        JavaType constructType = mapperConfig.constructType(c1641b.type());
        aiv a = ams.m3897a(mapperConfig, new VirtualAnnotatedMember(com_fossil_air, com_fossil_air.getRawType(), _propertyName.getSimpleName(), constructType.getRawClass()), _propertyName, propertyMetadata, c1641b.Eb());
        Class value = c1641b.value();
        ahr handlerInstantiator = mapperConfig.getHandlerInstantiator();
        alp a2 = handlerInstantiator == null ? null : handlerInstantiator.m3343a(mapperConfig, value);
        if (a2 == null) {
            a2 = (alp) ami.m3863b(value, mapperConfig.canOverrideAccessModifiers());
        }
        return a2.mo1079a(mapperConfig, com_fossil_air, a, constructType);
    }

    public PropertyName findNameForSerialization(aiq com_fossil_aiq) {
        String value;
        aec com_fossil_aec = (aec) _findAnnotation(com_fossil_aiq, aec.class);
        if (com_fossil_aec != null) {
            value = com_fossil_aec.value();
        } else {
            JsonProperty jsonProperty = (JsonProperty) _findAnnotation(com_fossil_aiq, JsonProperty.class);
            if (jsonProperty != null) {
                value = jsonProperty.value();
            } else if (!_hasAnnotation(com_fossil_aiq, JsonSerialize.class) && !_hasAnnotation(com_fossil_aiq, aet.class) && !_hasAnnotation(com_fossil_aiq, ael.class)) {
                return null;
            } else {
                value = "";
            }
        }
        return PropertyName.construct(value);
    }

    public boolean hasAsValueAnnotation(AnnotatedMethod annotatedMethod) {
        aes com_fossil_aes = (aes) _findAnnotation(annotatedMethod, aes.class);
        return com_fossil_aes != null && com_fossil_aes.zh();
    }

    public Object findDeserializer(aiq com_fossil_aiq) {
        ahj com_fossil_ahj = (ahj) _findAnnotation(com_fossil_aiq, ahj.class);
        if (com_fossil_ahj != null) {
            Class Ec = com_fossil_ahj.Ec();
            if (Ec != C1636a.class) {
                return Ec;
            }
        }
        return null;
    }

    public Object findKeyDeserializer(aiq com_fossil_aiq) {
        ahj com_fossil_ahj = (ahj) _findAnnotation(com_fossil_aiq, ahj.class);
        if (com_fossil_ahj != null) {
            Class Ee = com_fossil_ahj.Ee();
            if (Ee != C1639a.class) {
                return Ee;
            }
        }
        return null;
    }

    public Object findContentDeserializer(aiq com_fossil_aiq) {
        ahj com_fossil_ahj = (ahj) _findAnnotation(com_fossil_aiq, ahj.class);
        if (com_fossil_ahj != null) {
            Class Ed = com_fossil_ahj.Ed();
            if (Ed != C1636a.class) {
                return Ed;
            }
        }
        return null;
    }

    public Class<?> findDeserializationType(aiq com_fossil_aiq, JavaType javaType) {
        ahj com_fossil_ahj = (ahj) _findAnnotation(com_fossil_aiq, ahj.class);
        return com_fossil_ahj == null ? null : _classIfExplicit(com_fossil_ahj.Eh());
    }

    public Class<?> findDeserializationKeyType(aiq com_fossil_aiq, JavaType javaType) {
        ahj com_fossil_ahj = (ahj) _findAnnotation(com_fossil_aiq, ahj.class);
        return com_fossil_ahj == null ? null : _classIfExplicit(com_fossil_ahj.Ei());
    }

    public Class<?> findDeserializationContentType(aiq com_fossil_aiq, JavaType javaType) {
        ahj com_fossil_ahj = (ahj) _findAnnotation(com_fossil_aiq, ahj.class);
        return com_fossil_ahj == null ? null : _classIfExplicit(com_fossil_ahj.Ej());
    }

    public Object findDeserializationConverter(aiq com_fossil_aiq) {
        ahj com_fossil_ahj = (ahj) _findAnnotation(com_fossil_aiq, ahj.class);
        return com_fossil_ahj == null ? null : _classIfExplicit(com_fossil_ahj.converter(), C1703a.class);
    }

    public Object findDeserializationContentConverter(AnnotatedMember annotatedMember) {
        ahj com_fossil_ahj = (ahj) _findAnnotation(annotatedMember, ahj.class);
        return com_fossil_ahj == null ? null : _classIfExplicit(com_fossil_ahj.Eg(), C1703a.class);
    }

    public Object findValueInstantiator(air com_fossil_air) {
        aho com_fossil_aho = (aho) _findAnnotation(com_fossil_air, aho.class);
        return com_fossil_aho == null ? null : com_fossil_aho.value();
    }

    public Class<?> findPOJOBuilder(air com_fossil_air) {
        ahj com_fossil_ahj = (ahj) _findAnnotation(com_fossil_air, ahj.class);
        return com_fossil_ahj == null ? null : _classIfExplicit(com_fossil_ahj.Ef());
    }

    public C1642a findPOJOBuilderConfig(air com_fossil_air) {
        ahl com_fossil_ahl = (ahl) _findAnnotation(com_fossil_air, ahl.class);
        return com_fossil_ahl == null ? null : new C1642a(com_fossil_ahl);
    }

    public PropertyName findNameForDeserialization(aiq com_fossil_aiq) {
        String value;
        aen com_fossil_aen = (aen) _findAnnotation(com_fossil_aiq, aen.class);
        if (com_fossil_aen != null) {
            value = com_fossil_aen.value();
        } else {
            JsonProperty jsonProperty = (JsonProperty) _findAnnotation(com_fossil_aiq, JsonProperty.class);
            if (jsonProperty != null) {
                value = jsonProperty.value();
            } else if (!_hasAnnotation(com_fossil_aiq, ahj.class) && !_hasAnnotation(com_fossil_aiq, aet.class) && !_hasAnnotation(com_fossil_aiq, aer.class) && !_hasAnnotation(com_fossil_aiq, aea.class) && !_hasAnnotation(com_fossil_aiq, aei.class)) {
                return null;
            } else {
                value = "";
            }
        }
        return PropertyName.construct(value);
    }

    public boolean hasAnySetterAnnotation(AnnotatedMethod annotatedMethod) {
        return _hasAnnotation(annotatedMethod, adz.class);
    }

    public boolean hasAnyGetterAnnotation(AnnotatedMethod annotatedMethod) {
        return _hasAnnotation(annotatedMethod, ady.class);
    }

    public boolean hasCreatorAnnotation(aiq com_fossil_aiq) {
        JsonCreator jsonCreator = (JsonCreator) _findAnnotation(com_fossil_aiq, JsonCreator.class);
        return (jsonCreator == null || jsonCreator.yS() == Mode.DISABLED) ? false : true;
    }

    public Mode findCreatorBinding(aiq com_fossil_aiq) {
        JsonCreator jsonCreator = (JsonCreator) _findAnnotation(com_fossil_aiq, JsonCreator.class);
        return jsonCreator == null ? null : jsonCreator.yS();
    }

    protected boolean _isIgnorable(aiq com_fossil_aiq) {
        aef com_fossil_aef = (aef) _findAnnotation(com_fossil_aiq, aef.class);
        return com_fossil_aef != null && com_fossil_aef.zh();
    }

    protected Class<?> _classIfExplicit(Class<?> cls) {
        if (cls == null || ami.m3854D(cls)) {
            return null;
        }
        return cls;
    }

    protected Class<?> _classIfExplicit(Class<?> cls, Class<?> cls2) {
        Class<?> _classIfExplicit = _classIfExplicit(cls);
        return (_classIfExplicit == null || _classIfExplicit == cls2) ? null : _classIfExplicit;
    }

    protected PropertyName _propertyName(String str, String str2) {
        if (str.isEmpty()) {
            return PropertyName.USE_DEFAULT;
        }
        if (str2 == null || str2.isEmpty()) {
            return PropertyName.construct(str);
        }
        return PropertyName.construct(str, str2);
    }

    protected aju<?> _findTypeResolver(MapperConfig<?> mapperConfig, aiq com_fossil_aiq, JavaType javaType) {
        aju typeResolverBuilderInstance;
        ajt com_fossil_ajt = null;
        JsonTypeInfo jsonTypeInfo = (JsonTypeInfo) _findAnnotation(com_fossil_aiq, JsonTypeInfo.class);
        ahn com_fossil_ahn = (ahn) _findAnnotation(com_fossil_aiq, ahn.class);
        if (com_fossil_ahn != null) {
            if (jsonTypeInfo == null) {
                return null;
            }
            typeResolverBuilderInstance = mapperConfig.typeResolverBuilderInstance(com_fossil_aiq, com_fossil_ahn.value());
        } else if (jsonTypeInfo == null) {
            return null;
        } else {
            if (jsonTypeInfo.zt() == Id.NONE) {
                return _constructNoTypeResolverBuilder();
            }
            Object _constructStdTypeResolverBuilder = _constructStdTypeResolverBuilder();
        }
        ahm com_fossil_ahm = (ahm) _findAnnotation(com_fossil_aiq, ahm.class);
        if (com_fossil_ahm != null) {
            com_fossil_ajt = mapperConfig.typeIdResolverInstance(com_fossil_aiq, com_fossil_ahm.value());
        }
        if (com_fossil_ajt != null) {
            com_fossil_ajt.mo1043m(javaType);
        }
        typeResolverBuilderInstance = typeResolverBuilderInstance.init(jsonTypeInfo.zt(), com_fossil_ajt);
        As zu = jsonTypeInfo.zu();
        if (zu == As.EXTERNAL_PROPERTY && (com_fossil_aiq instanceof air)) {
            zu = As.PROPERTY;
        }
        aju typeProperty = typeResolverBuilderInstance.inclusion(zu).typeProperty(jsonTypeInfo.zc());
        Class zv = jsonTypeInfo.zv();
        if (!(zv == C1503a.class || zv.isAnnotation())) {
            typeProperty = typeProperty.defaultImpl(zv);
        }
        return typeProperty.typeIdVisibility(jsonTypeInfo.zw());
    }

    protected akd _constructStdTypeResolverBuilder() {
        return new akd();
    }

    protected akd _constructNoTypeResolverBuilder() {
        return akd.noTypeInfoBuilder();
    }
}
