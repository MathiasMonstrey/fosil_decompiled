package com.fasterxml.jackson.databind.ser;

import com.fasterxml.jackson.annotation.JsonTypeInfo.As;
import com.fasterxml.jackson.annotation.ObjectIdGenerator;
import com.fasterxml.jackson.annotation.ObjectIdGenerators.PropertyGenerator;
import com.fasterxml.jackson.databind.AnnotationIntrospector;
import com.fasterxml.jackson.databind.AnnotationIntrospector.ReferenceProperty;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.PropertyMetadata;
import com.fasterxml.jackson.databind.PropertyName;
import com.fasterxml.jackson.databind.SerializationConfig;
import com.fasterxml.jackson.databind.cfg.SerializerFactoryConfig;
import com.fasterxml.jackson.databind.introspect.AnnotatedField;
import com.fasterxml.jackson.databind.introspect.AnnotatedMember;
import com.fasterxml.jackson.databind.introspect.AnnotatedMethod;
import com.fasterxml.jackson.databind.ser.impl.PropertyBasedObjectIdGenerator;
import com.fasterxml.jackson.databind.ser.std.MapSerializer;
import com.fasterxml.jackson.databind.ser.std.StdDelegatingSerializer;
import com.fossil.agu;
import com.fossil.agv;
import com.fossil.agv.C1635a;
import com.fossil.ahb;
import com.fossil.ahg;
import com.fossil.aiq;
import com.fossil.aiv;
import com.fossil.aiy;
import com.fossil.aju;
import com.fossil.ajv;
import com.fossil.alb;
import com.fossil.ald;
import com.fossil.ale;
import com.fossil.alf;
import com.fossil.ali;
import com.fossil.all;
import com.fossil.aln;
import com.fossil.alo;
import com.fossil.alr;
import com.fossil.als;
import com.fossil.ama;
import com.fossil.amd;
import com.fossil.ami;
import com.fossil.amk;
import java.io.Serializable;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public class BeanSerializerFactory extends BasicSerializerFactory implements Serializable {
    public static final BeanSerializerFactory instance = new BeanSerializerFactory(null);
    private static final long serialVersionUID = 1;

    protected BeanSerializerFactory(SerializerFactoryConfig serializerFactoryConfig) {
        super(serializerFactoryConfig);
    }

    public aln withConfig(SerializerFactoryConfig serializerFactoryConfig) {
        if (this._factoryConfig == serializerFactoryConfig) {
            return this;
        }
        if (getClass() != BeanSerializerFactory.class) {
            throw new IllegalStateException("Subtype of BeanSerializerFactory (" + getClass().getName() + ") has not properly overridden method 'withAdditionalSerializers': can not instantiate subtype with " + "additional serializer definitions");
        }
        this(serializerFactoryConfig);
        return this;
    }

    protected Iterable<alo> customSerializers() {
        return this._factoryConfig.serializers();
    }

    public ahb<Object> createSerializer(ahg com_fossil_ahg, JavaType javaType) throws JsonMappingException {
        SerializationConfig config = com_fossil_ahg.getConfig();
        agu introspect = config.introspect(javaType);
        ahb<Object> findSerializerFromAnnotation = findSerializerFromAnnotation(com_fossil_ahg, introspect.Dn());
        if (findSerializerFromAnnotation != null) {
            return findSerializerFromAnnotation;
        }
        boolean z;
        JavaType modifyTypeByAnnotation = modifyTypeByAnnotation(config, introspect.Dn(), javaType);
        if (modifyTypeByAnnotation == javaType) {
            z = false;
        } else if (modifyTypeByAnnotation.hasRawClass(javaType.getRawClass())) {
            z = true;
        } else {
            introspect = config.introspect(modifyTypeByAnnotation);
            z = true;
        }
        amk DA = introspect.DA();
        if (DA == null) {
            return _createSerializer2(com_fossil_ahg, modifyTypeByAnnotation, introspect, z);
        }
        ahb findSerializerFromAnnotation2;
        JavaType b = DA.m3879b(com_fossil_ahg.getTypeFactory());
        if (b.hasRawClass(modifyTypeByAnnotation.getRawClass())) {
            ahb<Object> com_fossil_ahb_java_lang_Object = findSerializerFromAnnotation;
        } else {
            introspect = config.introspect(b);
            findSerializerFromAnnotation2 = findSerializerFromAnnotation(com_fossil_ahg, introspect.Dn());
        }
        if (findSerializerFromAnnotation2 == null && !b.isJavaLangObject()) {
            findSerializerFromAnnotation2 = _createSerializer2(com_fossil_ahg, b, introspect, true);
        }
        return new StdDelegatingSerializer(DA, b, findSerializerFromAnnotation2);
    }

    protected ahb<?> _createSerializer2(ahg com_fossil_ahg, JavaType javaType, agu com_fossil_agu, boolean z) throws JsonMappingException {
        ahb<?> com_fossil_ahb_ = null;
        SerializationConfig config = com_fossil_ahg.getConfig();
        if (javaType.isContainerType()) {
            if (!z) {
                z = usesStaticTyping(config, com_fossil_agu, null);
            }
            com_fossil_ahb_ = buildContainerSerializer(com_fossil_ahg, javaType, com_fossil_agu, z);
            if (com_fossil_ahb_ != null) {
                return com_fossil_ahb_;
            }
        }
        for (alo findSerializer : customSerializers()) {
            com_fossil_ahb_ = findSerializer.findSerializer(config, javaType, com_fossil_agu);
            if (com_fossil_ahb_ != null) {
                break;
            }
        }
        if (com_fossil_ahb_ == null) {
            com_fossil_ahb_ = findSerializerByAnnotations(com_fossil_ahg, javaType, com_fossil_agu);
        }
        if (com_fossil_ahb_ == null) {
            com_fossil_ahb_ = findSerializerByLookup(javaType, config, com_fossil_agu, z);
            if (com_fossil_ahb_ == null) {
                com_fossil_ahb_ = findSerializerByPrimaryType(com_fossil_ahg, javaType, com_fossil_agu, z);
                if (com_fossil_ahb_ == null) {
                    com_fossil_ahb_ = findBeanSerializer(com_fossil_ahg, javaType, com_fossil_agu);
                    if (com_fossil_ahb_ == null) {
                        com_fossil_ahb_ = findSerializerByAddonType(config, javaType, com_fossil_agu, z);
                        if (com_fossil_ahb_ == null) {
                            com_fossil_ahb_ = com_fossil_ahg.getUnknownTypeSerializer(com_fossil_agu.getBeanClass());
                        }
                    }
                }
            }
        }
        if (com_fossil_ahb_ == null || !this._factoryConfig.hasSerializerModifiers()) {
            return com_fossil_ahb_;
        }
        ahb<?> com_fossil_ahb_2 = com_fossil_ahb_;
        for (alf a : this._factoryConfig.serializerModifiers()) {
            com_fossil_ahb_2 = a.m3717a(config, com_fossil_agu, (ahb) com_fossil_ahb_2);
        }
        return com_fossil_ahb_2;
    }

    public ahb<Object> findBeanSerializer(ahg com_fossil_ahg, JavaType javaType, agu com_fossil_agu) throws JsonMappingException {
        if (isPotentialBeanType(javaType.getRawClass()) || javaType.isEnumType()) {
            return constructBeanSerializer(com_fossil_ahg, com_fossil_agu);
        }
        return null;
    }

    public ajv findPropertyTypeSerializer(JavaType javaType, SerializationConfig serializationConfig, AnnotatedMember annotatedMember) throws JsonMappingException {
        aju findPropertyTypeResolver = serializationConfig.getAnnotationIntrospector().findPropertyTypeResolver(serializationConfig, annotatedMember, javaType);
        if (findPropertyTypeResolver == null) {
            return createTypeSerializer(serializationConfig, javaType);
        }
        return findPropertyTypeResolver.buildTypeSerializer(serializationConfig, javaType, serializationConfig.getSubtypeResolver().collectAndResolveSubtypesByClass(serializationConfig, annotatedMember, javaType));
    }

    public ajv findPropertyContentTypeSerializer(JavaType javaType, SerializationConfig serializationConfig, AnnotatedMember annotatedMember) throws JsonMappingException {
        JavaType contentType = javaType.getContentType();
        aju findPropertyContentTypeResolver = serializationConfig.getAnnotationIntrospector().findPropertyContentTypeResolver(serializationConfig, annotatedMember, javaType);
        if (findPropertyContentTypeResolver == null) {
            return createTypeSerializer(serializationConfig, contentType);
        }
        return findPropertyContentTypeResolver.buildTypeSerializer(serializationConfig, contentType, serializationConfig.getSubtypeResolver().collectAndResolveSubtypesByClass(serializationConfig, annotatedMember, contentType));
    }

    protected ahb<Object> constructBeanSerializer(ahg com_fossil_ahg, agu com_fossil_agu) throws JsonMappingException {
        if (com_fossil_agu.getBeanClass() == Object.class) {
            return com_fossil_ahg.getUnknownTypeSerializer(Object.class);
        }
        List list;
        ale com_fossil_ale;
        SerializationConfig config = com_fossil_ahg.getConfig();
        ale constructBeanSerializerBuilder = constructBeanSerializerBuilder(com_fossil_agu);
        constructBeanSerializerBuilder.m3705a(config);
        List findBeanProperties = findBeanProperties(com_fossil_ahg, com_fossil_agu, constructBeanSerializerBuilder);
        if (findBeanProperties == null) {
            findBeanProperties = new ArrayList();
        } else {
            findBeanProperties = removeOverlappingTypeIds(com_fossil_ahg, com_fossil_agu, constructBeanSerializerBuilder, findBeanProperties);
        }
        com_fossil_ahg.getAnnotationIntrospector().findAndAddVirtualProperties(config, com_fossil_agu.Dn(), findBeanProperties);
        if (this._factoryConfig.hasSerializerModifiers()) {
            list = findBeanProperties;
            for (alf a : this._factoryConfig.serializerModifiers()) {
                list = a.m3719a(config, com_fossil_agu, list);
            }
        } else {
            list = findBeanProperties;
        }
        findBeanProperties = filterBeanProperties(config, com_fossil_agu, list);
        if (this._factoryConfig.hasSerializerModifiers()) {
            list = findBeanProperties;
            for (alf a2 : this._factoryConfig.serializerModifiers()) {
                list = a2.m3721b(config, com_fossil_agu, list);
            }
        } else {
            list = findBeanProperties;
        }
        constructBeanSerializerBuilder.m3707a(constructObjectIdHandler(com_fossil_ahg, com_fossil_agu, list));
        constructBeanSerializerBuilder.m3710w(list);
        constructBeanSerializerBuilder.bC(findFilterId(config, com_fossil_agu));
        aiq Dx = com_fossil_agu.Dx();
        if (Dx != null) {
            ahb construct;
            if (config.canOverrideAccessModifiers()) {
                Dx.fixAccess();
            }
            JavaType type = Dx.getType(com_fossil_agu.Dp());
            boolean isEnabled = config.isEnabled(MapperFeature.USE_STATIC_TYPING);
            JavaType contentType = type.getContentType();
            ajv createTypeSerializer = createTypeSerializer(config, contentType);
            ahb findSerializerFromAnnotation = findSerializerFromAnnotation(com_fossil_ahg, Dx);
            if (findSerializerFromAnnotation == null) {
                construct = MapSerializer.construct(null, type, isEnabled, createTypeSerializer, null, null, null);
            } else {
                construct = findSerializerFromAnnotation;
            }
            constructBeanSerializerBuilder.m3706a(new alb(new C1635a(PropertyName.construct(Dx.getName()), contentType, null, com_fossil_agu.Dq(), Dx, PropertyMetadata.STD_OPTIONAL), Dx, construct));
        }
        processViews(config, constructBeanSerializerBuilder);
        if (this._factoryConfig.hasSerializerModifiers()) {
            com_fossil_ale = constructBeanSerializerBuilder;
            for (alf a3 : this._factoryConfig.serializerModifiers()) {
                com_fossil_ale = a3.m3718a(config, com_fossil_agu, com_fossil_ale);
            }
        } else {
            com_fossil_ale = constructBeanSerializerBuilder;
        }
        ahb<Object> GH = com_fossil_ale.GH();
        if (GH == null && com_fossil_agu.Do()) {
            return com_fossil_ale.GI();
        }
        return GH;
    }

    protected als constructObjectIdHandler(ahg com_fossil_ahg, agu com_fossil_agu, List<ald> list) throws JsonMappingException {
        aiy objectIdInfo = com_fossil_agu.getObjectIdInfo();
        if (objectIdInfo == null) {
            return null;
        }
        Type Fz = objectIdInfo.Fz();
        if (Fz == PropertyGenerator.class) {
            String simpleName = objectIdInfo.Fy().getSimpleName();
            int size = list.size();
            for (int i = 0; i != size; i++) {
                ald com_fossil_ald = (ald) list.get(i);
                if (simpleName.equals(com_fossil_ald.getName())) {
                    if (i > 0) {
                        list.remove(i);
                        list.add(0, com_fossil_ald);
                    }
                    return als.m3765a(com_fossil_ald.getType(), (PropertyName) null, new PropertyBasedObjectIdGenerator(objectIdInfo, com_fossil_ald), objectIdInfo.FB());
                }
            }
            throw new IllegalArgumentException("Invalid Object Id definition for " + com_fossil_agu.getBeanClass().getName() + ": can not find property with name '" + simpleName + "'");
        }
        return als.m3765a(com_fossil_ahg.getTypeFactory().findTypeParameters(com_fossil_ahg.constructType(Fz), ObjectIdGenerator.class)[0], objectIdInfo.Fy(), com_fossil_ahg.objectIdGeneratorInstance(com_fossil_agu.Dn(), objectIdInfo), objectIdInfo.FB());
    }

    protected ald constructFilteredBeanWriter(ald com_fossil_ald, Class<?>[] clsArr) {
        return alr.m3764a(com_fossil_ald, clsArr);
    }

    protected ali constructPropertyBuilder(SerializationConfig serializationConfig, agu com_fossil_agu) {
        return new ali(serializationConfig, com_fossil_agu);
    }

    protected ale constructBeanSerializerBuilder(agu com_fossil_agu) {
        return new ale(com_fossil_agu);
    }

    protected boolean isPotentialBeanType(Class<?> cls) {
        return ami.m3871v(cls) == null && !ami.m3873x(cls);
    }

    protected List<ald> findBeanProperties(ahg com_fossil_ahg, agu com_fossil_agu, ale com_fossil_ale) throws JsonMappingException {
        List<aiv> Dr = com_fossil_agu.Dr();
        SerializationConfig config = com_fossil_ahg.getConfig();
        removeIgnorableTypes(config, com_fossil_agu, Dr);
        if (config.isEnabled(MapperFeature.REQUIRE_SETTERS_FOR_GETTERS)) {
            removeSetterlessGetters(config, com_fossil_agu, Dr);
        }
        if (Dr.isEmpty()) {
            return null;
        }
        boolean usesStaticTyping = usesStaticTyping(config, com_fossil_agu, null);
        ali constructPropertyBuilder = constructPropertyBuilder(config, com_fossil_agu);
        ArrayList arrayList = new ArrayList(Dr.size());
        ama Dp = com_fossil_agu.Dp();
        for (aiv com_fossil_aiv : Dr) {
            AnnotatedMember Fp = com_fossil_aiv.Fp();
            if (!com_fossil_aiv.Fv()) {
                ReferenceProperty Fu = com_fossil_aiv.Fu();
                if (Fu == null || !Fu.Dm()) {
                    if (Fp instanceof AnnotatedMethod) {
                        arrayList.add(_constructWriter(com_fossil_ahg, com_fossil_aiv, Dp, constructPropertyBuilder, usesStaticTyping, (AnnotatedMethod) Fp));
                    } else {
                        arrayList.add(_constructWriter(com_fossil_ahg, com_fossil_aiv, Dp, constructPropertyBuilder, usesStaticTyping, (AnnotatedField) Fp));
                    }
                }
            } else if (Fp != null) {
                if (config.canOverrideAccessModifiers()) {
                    Fp.fixAccess();
                }
                com_fossil_ale.m3709j(Fp);
            }
        }
        return arrayList;
    }

    protected List<ald> filterBeanProperties(SerializationConfig serializationConfig, agu com_fossil_agu, List<ald> list) {
        String[] findPropertiesToIgnore = serializationConfig.getAnnotationIntrospector().findPropertiesToIgnore(com_fossil_agu.Dn(), true);
        if (findPropertiesToIgnore != null && findPropertiesToIgnore.length > 0) {
            HashSet b = amd.m3838b(findPropertiesToIgnore);
            Iterator it = list.iterator();
            while (it.hasNext()) {
                if (b.contains(((ald) it.next()).getName())) {
                    it.remove();
                }
            }
        }
        return list;
    }

    protected void processViews(SerializationConfig serializationConfig, ale com_fossil_ale) {
        List FD = com_fossil_ale.FD();
        boolean isEnabled = serializationConfig.isEnabled(MapperFeature.DEFAULT_VIEW_INCLUSION);
        int size = FD.size();
        ald[] com_fossil_aldArr = new ald[size];
        int i = 0;
        int i2 = 0;
        while (i < size) {
            int i3;
            ald com_fossil_ald = (ald) FD.get(i);
            Class[] GB = com_fossil_ald.GB();
            if (GB == null) {
                if (isEnabled) {
                    com_fossil_aldArr[i] = com_fossil_ald;
                    i3 = i2;
                }
                i3 = i2;
            } else {
                i2++;
                com_fossil_aldArr[i] = constructFilteredBeanWriter(com_fossil_ald, GB);
                i3 = i2;
            }
            i++;
            i2 = i3;
        }
        if (!isEnabled || i2 != 0) {
            com_fossil_ale.m3708a(com_fossil_aldArr);
        }
    }

    protected void removeIgnorableTypes(SerializationConfig serializationConfig, agu com_fossil_agu, List<aiv> list) {
        AnnotationIntrospector annotationIntrospector = serializationConfig.getAnnotationIntrospector();
        HashMap hashMap = new HashMap();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            AnnotatedMember Fp = ((aiv) it.next()).Fp();
            if (Fp == null) {
                it.remove();
            } else {
                Class rawType = Fp.getRawType();
                Boolean bool = (Boolean) hashMap.get(rawType);
                if (bool == null) {
                    bool = annotationIntrospector.isIgnorableType(serializationConfig.introspectClassAnnotations(rawType).Dn());
                    if (bool == null) {
                        bool = Boolean.FALSE;
                    }
                    hashMap.put(rawType, bool);
                }
                if (bool.booleanValue()) {
                    it.remove();
                }
            }
        }
    }

    protected void removeSetterlessGetters(SerializationConfig serializationConfig, agu com_fossil_agu, List<aiv> list) {
        Iterator it = list.iterator();
        while (it.hasNext()) {
            aiv com_fossil_aiv = (aiv) it.next();
            if (!(com_fossil_aiv.Ff() || com_fossil_aiv.Fd())) {
                it.remove();
            }
        }
    }

    protected List<ald> removeOverlappingTypeIds(ahg com_fossil_ahg, agu com_fossil_agu, ale com_fossil_ale, List<ald> list) {
        int size = list.size();
        for (int i = 0; i < size; i++) {
            ald com_fossil_ald = (ald) list.get(i);
            ajv typeSerializer = com_fossil_ald.getTypeSerializer();
            if (typeSerializer != null && typeSerializer.getTypeInclusion() == As.EXTERNAL_PROPERTY) {
                PropertyName construct = PropertyName.construct(typeSerializer.getPropertyName());
                for (ald com_fossil_ald2 : list) {
                    if (com_fossil_ald2 != com_fossil_ald && com_fossil_ald2.m3703f(construct)) {
                        com_fossil_ald.m3691a(null);
                        break;
                    }
                }
            }
        }
        return list;
    }

    protected ald _constructWriter(ahg com_fossil_ahg, aiv com_fossil_aiv, ama com_fossil_ama, ali com_fossil_ali, boolean z, AnnotatedMember annotatedMember) throws JsonMappingException {
        PropertyName fullName = com_fossil_aiv.getFullName();
        if (com_fossil_ahg.canOverrideAccessModifiers()) {
            annotatedMember.fixAccess();
        }
        JavaType type = annotatedMember.getType(com_fossil_ama);
        agv c1635a = new C1635a(fullName, type, com_fossil_aiv.getWrapperName(), com_fossil_ali.Dq(), annotatedMember, com_fossil_aiv.getMetadata());
        ahb findSerializerFromAnnotation = findSerializerFromAnnotation(com_fossil_ahg, annotatedMember);
        if (findSerializerFromAnnotation instanceof all) {
            ((all) findSerializerFromAnnotation).resolve(com_fossil_ahg);
        }
        ahb handlePrimaryContextualization = com_fossil_ahg.handlePrimaryContextualization(findSerializerFromAnnotation, c1635a);
        ajv com_fossil_ajv = null;
        if (ami.m3875z(type.getRawClass()) || type.isCollectionLikeType() || type.isMapLikeType()) {
            com_fossil_ajv = findPropertyContentTypeSerializer(type, com_fossil_ahg.getConfig(), annotatedMember);
        }
        return com_fossil_ali.m3724a(com_fossil_ahg, com_fossil_aiv, type, handlePrimaryContextualization, findPropertyTypeSerializer(type, com_fossil_ahg.getConfig(), annotatedMember), com_fossil_ajv, annotatedMember, z);
    }
}
