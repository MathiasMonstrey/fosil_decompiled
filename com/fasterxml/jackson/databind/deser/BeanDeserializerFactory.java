package com.fasterxml.jackson.databind.deser;

import com.fasterxml.jackson.annotation.ObjectIdGenerator;
import com.fasterxml.jackson.annotation.ObjectIdGenerators.PropertyGenerator;
import com.fasterxml.jackson.databind.AnnotationIntrospector;
import com.fasterxml.jackson.databind.AnnotationIntrospector.ReferenceProperty;
import com.fasterxml.jackson.databind.DeserializationConfig;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.PropertyMetadata;
import com.fasterxml.jackson.databind.PropertyName;
import com.fasterxml.jackson.databind.cfg.DeserializerFactoryConfig;
import com.fasterxml.jackson.databind.deser.impl.FieldProperty;
import com.fasterxml.jackson.databind.deser.impl.MethodProperty;
import com.fasterxml.jackson.databind.deser.impl.ObjectIdReader;
import com.fasterxml.jackson.databind.deser.impl.PropertyBasedObjectIdGenerator;
import com.fasterxml.jackson.databind.deser.impl.SetterlessProperty;
import com.fasterxml.jackson.databind.deser.std.ThrowableDeserializer;
import com.fasterxml.jackson.databind.introspect.AnnotatedField;
import com.fasterxml.jackson.databind.introspect.AnnotatedMember;
import com.fasterxml.jackson.databind.introspect.AnnotatedMethod;
import com.fossil.aeu;
import com.fossil.agt;
import com.fossil.agu;
import com.fossil.agv.C1635a;
import com.fossil.agy;
import com.fossil.ahl.C1642a;
import com.fossil.aht;
import com.fossil.ahu;
import com.fossil.ahz;
import com.fossil.aie;
import com.fossil.aih;
import com.fossil.aiq;
import com.fossil.aiv;
import com.fossil.aiy;
import com.fossil.ajs;
import com.fossil.amd;
import com.fossil.ami;
import com.fossil.ams;
import java.io.Serializable;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class BeanDeserializerFactory extends BasicDeserializerFactory implements Serializable {
    private static final Class<?>[] aQX = new Class[]{Throwable.class};
    private static final Class<?>[] aQY = new Class[0];
    public static final BeanDeserializerFactory instance = new BeanDeserializerFactory(new DeserializerFactoryConfig());
    private static final long serialVersionUID = 1;

    public BeanDeserializerFactory(DeserializerFactoryConfig deserializerFactoryConfig) {
        super(deserializerFactoryConfig);
    }

    public ahz withConfig(DeserializerFactoryConfig deserializerFactoryConfig) {
        if (this._factoryConfig == deserializerFactoryConfig) {
            return this;
        }
        if (getClass() != BeanDeserializerFactory.class) {
            throw new IllegalStateException("Subtype of BeanDeserializerFactory (" + getClass().getName() + ") has not properly overridden method 'withAdditionalDeserializers': can not instantiate subtype with " + "additional deserializer definitions");
        }
        this(deserializerFactoryConfig);
        return this;
    }

    public agy<Object> createBeanDeserializer(DeserializationContext deserializationContext, JavaType javaType, agu com_fossil_agu) throws JsonMappingException {
        DeserializationConfig config = deserializationContext.getConfig();
        agy<Object> _findCustomBeanDeserializer = _findCustomBeanDeserializer(javaType, config, com_fossil_agu);
        if (_findCustomBeanDeserializer != null) {
            return _findCustomBeanDeserializer;
        }
        if (javaType.isThrowable()) {
            return buildThrowableDeserializer(deserializationContext, javaType, com_fossil_agu);
        }
        if (javaType.isAbstract()) {
            JavaType materializeAbstractType = materializeAbstractType(deserializationContext, javaType, com_fossil_agu);
            if (materializeAbstractType != null) {
                return buildBeanDeserializer(deserializationContext, materializeAbstractType, config.introspect(materializeAbstractType));
            }
        }
        _findCustomBeanDeserializer = findStdDeserializer(deserializationContext, javaType, com_fossil_agu);
        if (_findCustomBeanDeserializer != null) {
            return _findCustomBeanDeserializer;
        }
        if (isPotentialBeanType(javaType.getRawClass())) {
            return buildBeanDeserializer(deserializationContext, javaType, com_fossil_agu);
        }
        return null;
    }

    public agy<Object> createBuilderBasedDeserializer(DeserializationContext deserializationContext, JavaType javaType, agu com_fossil_agu, Class<?> cls) throws JsonMappingException {
        return buildBuilderBasedDeserializer(deserializationContext, javaType, deserializationContext.getConfig().introspectForBuilder(deserializationContext.constructType(cls)));
    }

    protected agy<?> findStdDeserializer(DeserializationContext deserializationContext, JavaType javaType, agu com_fossil_agu) throws JsonMappingException {
        agy<?> findDefaultDeserializer = findDefaultDeserializer(deserializationContext, javaType, com_fossil_agu);
        if (findDefaultDeserializer == null || !this._factoryConfig.hasDeserializerModifiers()) {
            return findDefaultDeserializer;
        }
        agy<?> com_fossil_agy_ = findDefaultDeserializer;
        for (ahu a : this._factoryConfig.deserializerModifiers()) {
            com_fossil_agy_ = a.m3367a(deserializationContext.getConfig(), com_fossil_agu, (agy) com_fossil_agy_);
        }
        return com_fossil_agy_;
    }

    protected JavaType materializeAbstractType(DeserializationContext deserializationContext, JavaType javaType, agu com_fossil_agu) throws JsonMappingException {
        JavaType type = com_fossil_agu.getType();
        for (agt b : this._factoryConfig.abstractTypeResolvers()) {
            JavaType b2 = b.m3326b(deserializationContext.getConfig(), type);
            if (b2 != null) {
                return b2;
            }
        }
        return null;
    }

    public agy<Object> buildBeanDeserializer(DeserializationContext deserializationContext, JavaType javaType, agu com_fossil_agu) throws JsonMappingException {
        try {
            aht com_fossil_aht;
            agy<Object> Es;
            aie findValueInstantiator = findValueInstantiator(deserializationContext, com_fossil_agu);
            aht constructBeanDeserializerBuilder = constructBeanDeserializerBuilder(deserializationContext, com_fossil_agu);
            constructBeanDeserializerBuilder.m3358a(findValueInstantiator);
            addBeanProps(deserializationContext, com_fossil_agu, constructBeanDeserializerBuilder);
            addObjectIdReader(deserializationContext, com_fossil_agu, constructBeanDeserializerBuilder);
            addReferenceProperties(deserializationContext, com_fossil_agu, constructBeanDeserializerBuilder);
            addInjectables(deserializationContext, com_fossil_agu, constructBeanDeserializerBuilder);
            DeserializationConfig config = deserializationContext.getConfig();
            if (this._factoryConfig.hasDeserializerModifiers()) {
                com_fossil_aht = constructBeanDeserializerBuilder;
                for (ahu a : this._factoryConfig.deserializerModifiers()) {
                    com_fossil_aht = a.m3369a(config, com_fossil_agu, com_fossil_aht);
                }
            } else {
                com_fossil_aht = constructBeanDeserializerBuilder;
            }
            if (!javaType.isAbstract() || findValueInstantiator.canInstantiate()) {
                Es = com_fossil_aht.Es();
            } else {
                Es = com_fossil_aht.Et();
            }
            if (!this._factoryConfig.hasDeserializerModifiers()) {
                return Es;
            }
            agy com_fossil_agy = Es;
            for (ahu a2 : this._factoryConfig.deserializerModifiers()) {
                agy<Object> a3 = a2.m3367a(config, com_fossil_agu, com_fossil_agy);
            }
            return com_fossil_agy;
        } catch (NoClassDefFoundError e) {
            return new aih(e);
        }
    }

    protected agy<Object> buildBuilderBasedDeserializer(DeserializationContext deserializationContext, JavaType javaType, agu com_fossil_agu) throws JsonMappingException {
        aie findValueInstantiator = findValueInstantiator(deserializationContext, com_fossil_agu);
        DeserializationConfig config = deserializationContext.getConfig();
        aht constructBeanDeserializerBuilder = constructBeanDeserializerBuilder(deserializationContext, com_fossil_agu);
        constructBeanDeserializerBuilder.m3358a(findValueInstantiator);
        addBeanProps(deserializationContext, com_fossil_agu, constructBeanDeserializerBuilder);
        addObjectIdReader(deserializationContext, com_fossil_agu, constructBeanDeserializerBuilder);
        addReferenceProperties(deserializationContext, com_fossil_agu, constructBeanDeserializerBuilder);
        addInjectables(deserializationContext, com_fossil_agu, constructBeanDeserializerBuilder);
        C1642a DE = com_fossil_agu.DE();
        String str = DE == null ? "build" : DE.aQD;
        AnnotatedMethod a = com_fossil_agu.mo980a(str, null);
        if (a != null && config.canOverrideAccessModifiers()) {
            ami.m3862a(a.getMember());
        }
        constructBeanDeserializerBuilder.m3357a(a, DE);
        if (this._factoryConfig.hasDeserializerModifiers()) {
            for (ahu a2 : this._factoryConfig.deserializerModifiers()) {
                constructBeanDeserializerBuilder = a2.m3369a(config, com_fossil_agu, constructBeanDeserializerBuilder);
            }
        }
        agy<Object> a3 = constructBeanDeserializerBuilder.m3351a(javaType, str);
        if (!this._factoryConfig.hasDeserializerModifiers()) {
            return a3;
        }
        agy com_fossil_agy = a3;
        for (ahu a22 : this._factoryConfig.deserializerModifiers()) {
            agy<Object> a4 = a22.m3367a(config, com_fossil_agu, com_fossil_agy);
        }
        return com_fossil_agy;
    }

    protected void addObjectIdReader(DeserializationContext deserializationContext, agu com_fossil_agu, aht com_fossil_aht) throws JsonMappingException {
        aiy objectIdInfo = com_fossil_agu.getObjectIdInfo();
        if (objectIdInfo != null) {
            SettableBeanProperty findProperty;
            JavaType type;
            ObjectIdGenerator propertyBasedObjectIdGenerator;
            Class Fz = objectIdInfo.Fz();
            aeu objectIdResolverInstance = deserializationContext.objectIdResolverInstance(com_fossil_agu.Dn(), objectIdInfo);
            if (Fz == PropertyGenerator.class) {
                PropertyName Fy = objectIdInfo.Fy();
                findProperty = com_fossil_aht.findProperty(Fy);
                if (findProperty == null) {
                    throw new IllegalArgumentException("Invalid Object Id definition for " + com_fossil_agu.getBeanClass().getName() + ": can not find property with name '" + Fy + "'");
                }
                type = findProperty.getType();
                propertyBasedObjectIdGenerator = new PropertyBasedObjectIdGenerator(objectIdInfo.getScope());
            } else {
                type = deserializationContext.getTypeFactory().findTypeParameters(deserializationContext.constructType(Fz), ObjectIdGenerator.class)[0];
                findProperty = null;
                propertyBasedObjectIdGenerator = deserializationContext.objectIdGeneratorInstance(com_fossil_agu.Dn(), objectIdInfo);
            }
            com_fossil_aht.m3356a(ObjectIdReader.construct(type, objectIdInfo.Fy(), propertyBasedObjectIdGenerator, deserializationContext.findRootValueDeserializer(type), findProperty, objectIdResolverInstance));
        }
    }

    public agy<Object> buildThrowableDeserializer(DeserializationContext deserializationContext, JavaType javaType, agu com_fossil_agu) throws JsonMappingException {
        aht com_fossil_aht;
        DeserializationConfig config = deserializationContext.getConfig();
        aht constructBeanDeserializerBuilder = constructBeanDeserializerBuilder(deserializationContext, com_fossil_agu);
        constructBeanDeserializerBuilder.m3358a(findValueInstantiator(deserializationContext, com_fossil_agu));
        addBeanProps(deserializationContext, com_fossil_agu, constructBeanDeserializerBuilder);
        AnnotatedMember a = com_fossil_agu.mo980a("initCause", aQX);
        if (a != null) {
            SettableBeanProperty constructSettableProperty = constructSettableProperty(deserializationContext, com_fossil_agu, ams.m3896a(deserializationContext.getConfig(), a, new PropertyName("cause")), a.getGenericParameterType(0));
            if (constructSettableProperty != null) {
                constructBeanDeserializerBuilder.m3355a(constructSettableProperty, true);
            }
        }
        constructBeanDeserializerBuilder.bG("localizedMessage");
        constructBeanDeserializerBuilder.bG("suppressed");
        constructBeanDeserializerBuilder.bG("message");
        if (this._factoryConfig.hasDeserializerModifiers()) {
            com_fossil_aht = constructBeanDeserializerBuilder;
            for (ahu a2 : this._factoryConfig.deserializerModifiers()) {
                com_fossil_aht = a2.m3369a(config, com_fossil_agu, com_fossil_aht);
            }
        } else {
            com_fossil_aht = constructBeanDeserializerBuilder;
        }
        agy<Object> Es = com_fossil_aht.Es();
        if (Es instanceof BeanDeserializer) {
            Es = new ThrowableDeserializer((BeanDeserializer) Es);
        }
        if (!this._factoryConfig.hasDeserializerModifiers()) {
            return Es;
        }
        agy com_fossil_agy = Es;
        for (ahu a22 : this._factoryConfig.deserializerModifiers()) {
            agy<Object> a3 = a22.m3367a(config, com_fossil_agu, com_fossil_agy);
        }
        return com_fossil_agy;
    }

    protected aht constructBeanDeserializerBuilder(DeserializationContext deserializationContext, agu com_fossil_agu) {
        return new aht(com_fossil_agu, deserializationContext.getConfig());
    }

    protected void addBeanProps(DeserializationContext deserializationContext, agu com_fossil_agu, aht com_fossil_aht) throws JsonMappingException {
        Object obj;
        Object obj2;
        SettableBeanProperty[] fromObjectArguments = com_fossil_aht.getValueInstantiator().getFromObjectArguments(deserializationContext.getConfig());
        if (com_fossil_agu.getType().isAbstract()) {
            obj = null;
        } else {
            obj = 1;
        }
        AnnotationIntrospector annotationIntrospector = deserializationContext.getAnnotationIntrospector();
        Boolean findIgnoreUnknownProperties = annotationIntrospector.findIgnoreUnknownProperties(com_fossil_agu.Dn());
        if (findIgnoreUnknownProperties != null) {
            com_fossil_aht.aK(findIgnoreUnknownProperties.booleanValue());
        }
        Set<String> b = amd.m3838b(annotationIntrospector.findPropertiesToIgnore(com_fossil_agu.Dn(), false));
        for (String bG : b) {
            com_fossil_aht.bG(bG);
        }
        AnnotatedMethod Dy = com_fossil_agu.Dy();
        if (Dy != null) {
            com_fossil_aht.m3353a(constructAnySetter(deserializationContext, com_fossil_agu, Dy));
        }
        if (Dy == null) {
            Collection<String> Dt = com_fossil_agu.Dt();
            if (Dt != null) {
                for (String bG2 : Dt) {
                    com_fossil_aht.bG(bG2);
                }
            }
        }
        if (deserializationContext.isEnabled(MapperFeature.USE_GETTERS_AS_SETTERS) && deserializationContext.isEnabled(MapperFeature.AUTO_DETECT_GETTERS)) {
            obj2 = 1;
        } else {
            obj2 = null;
        }
        List filterBeanProps = filterBeanProps(deserializationContext, com_fossil_agu, com_fossil_aht, com_fossil_agu.Dr(), b);
        List list;
        if (this._factoryConfig.hasDeserializerModifiers()) {
            list = filterBeanProps;
            for (ahu a : this._factoryConfig.deserializerModifiers()) {
                list = a.m3370a(deserializationContext.getConfig(), com_fossil_agu, list);
            }
        } else {
            list = filterBeanProps;
        }
        for (aiv com_fossil_aiv : r1) {
            SettableBeanProperty constructSettableProperty;
            if (com_fossil_aiv.Fi()) {
                constructSettableProperty = constructSettableProperty(deserializationContext, com_fossil_agu, com_fossil_aiv, com_fossil_aiv.Fm().getGenericParameterType(0));
            } else if (com_fossil_aiv.Fj()) {
                constructSettableProperty = constructSettableProperty(deserializationContext, com_fossil_agu, com_fossil_aiv, com_fossil_aiv.Fn().getGenericType());
            } else {
                if (obj2 != null && com_fossil_aiv.Fh()) {
                    Class rawType = com_fossil_aiv.Fl().getRawType();
                    if (Collection.class.isAssignableFrom(rawType) || Map.class.isAssignableFrom(rawType)) {
                        constructSettableProperty = constructSetterlessProperty(deserializationContext, com_fossil_agu, com_fossil_aiv);
                    }
                }
                constructSettableProperty = null;
            }
            if (obj != null && com_fossil_aiv.Fk()) {
                SettableBeanProperty settableBeanProperty;
                String name = com_fossil_aiv.getName();
                if (fromObjectArguments != null) {
                    for (SettableBeanProperty settableBeanProperty2 : fromObjectArguments) {
                        if (name.equals(settableBeanProperty2.getName()) && (settableBeanProperty2 instanceof CreatorProperty)) {
                            settableBeanProperty2 = (CreatorProperty) settableBeanProperty2;
                            break;
                        }
                    }
                }
                settableBeanProperty2 = null;
                if (settableBeanProperty2 == null) {
                    throw deserializationContext.mappingException("Could not find creator property with name '%s' (in class %s)", name, com_fossil_agu.getBeanClass().getName());
                }
                if (constructSettableProperty != null) {
                    settableBeanProperty2.setFallbackSetter(constructSettableProperty);
                }
                com_fossil_aht.m3360b(settableBeanProperty2);
            } else if (constructSettableProperty != null) {
                Class[] Ft = com_fossil_aiv.Ft();
                if (Ft == null && !deserializationContext.isEnabled(MapperFeature.DEFAULT_VIEW_INCLUSION)) {
                    Ft = aQY;
                }
                constructSettableProperty.setViews(Ft);
                com_fossil_aht.m3354a(constructSettableProperty);
            }
        }
    }

    protected List<aiv> filterBeanProps(DeserializationContext deserializationContext, agu com_fossil_agu, aht com_fossil_aht, List<aiv> list, Set<String> set) throws JsonMappingException {
        List arrayList = new ArrayList(Math.max(4, list.size()));
        Map hashMap = new HashMap();
        for (aiv com_fossil_aiv : list) {
            String name = com_fossil_aiv.getName();
            if (!set.contains(name)) {
                if (!com_fossil_aiv.Fk()) {
                    Class cls = null;
                    if (com_fossil_aiv.Fi()) {
                        cls = com_fossil_aiv.Fm().getRawParameterType(0);
                    } else if (com_fossil_aiv.Fj()) {
                        cls = com_fossil_aiv.Fn().getRawType();
                    }
                    if (cls != null && isIgnorableType(deserializationContext.getConfig(), com_fossil_agu, cls, hashMap)) {
                        com_fossil_aht.bG(name);
                    }
                }
                arrayList.add(com_fossil_aiv);
            }
        }
        return arrayList;
    }

    protected void addReferenceProperties(DeserializationContext deserializationContext, agu com_fossil_agu, aht com_fossil_aht) throws JsonMappingException {
        Map Ds = com_fossil_agu.Ds();
        if (Ds != null) {
            for (Entry entry : Ds.entrySet()) {
                Type genericParameterType;
                String str = (String) entry.getKey();
                AnnotatedMember annotatedMember = (AnnotatedMember) entry.getValue();
                if (annotatedMember instanceof AnnotatedMethod) {
                    genericParameterType = ((AnnotatedMethod) annotatedMember).getGenericParameterType(0);
                } else {
                    genericParameterType = annotatedMember.getRawType();
                }
                com_fossil_aht.m3359a(str, constructSettableProperty(deserializationContext, com_fossil_agu, ams.m3895a(deserializationContext.getConfig(), annotatedMember), genericParameterType));
            }
        }
    }

    protected void addInjectables(DeserializationContext deserializationContext, agu com_fossil_agu, aht com_fossil_aht) throws JsonMappingException {
        Map DC = com_fossil_agu.DC();
        if (DC != null) {
            boolean canOverrideAccessModifiers = deserializationContext.canOverrideAccessModifiers();
            for (Entry entry : DC.entrySet()) {
                AnnotatedMember annotatedMember = (AnnotatedMember) entry.getValue();
                if (canOverrideAccessModifiers) {
                    annotatedMember.fixAccess();
                }
                com_fossil_aht.m3352a(PropertyName.construct(annotatedMember.getName()), com_fossil_agu.mo979a(annotatedMember.getGenericType()), com_fossil_agu.Dq(), annotatedMember, entry.getKey());
            }
        }
    }

    protected SettableAnyProperty constructAnySetter(DeserializationContext deserializationContext, agu com_fossil_agu, AnnotatedMethod annotatedMethod) throws JsonMappingException {
        if (deserializationContext.canOverrideAccessModifiers()) {
            annotatedMethod.fixAccess();
        }
        JavaType a = com_fossil_agu.Dp().m3829a(annotatedMethod.getGenericParameterType(1));
        C1635a c1635a = new C1635a(PropertyName.construct(annotatedMethod.getName()), a, null, com_fossil_agu.Dq(), annotatedMethod, PropertyMetadata.STD_OPTIONAL);
        JavaType resolveType = resolveType(deserializationContext, com_fossil_agu, a, annotatedMethod);
        agy findDeserializerFromAnnotation = findDeserializerFromAnnotation(deserializationContext, annotatedMethod);
        JavaType modifyTypeByAnnotation = modifyTypeByAnnotation(deserializationContext, annotatedMethod, resolveType);
        if (findDeserializerFromAnnotation == null) {
            findDeserializerFromAnnotation = (agy) modifyTypeByAnnotation.getValueHandler();
        }
        return new SettableAnyProperty(c1635a, annotatedMethod, modifyTypeByAnnotation, findDeserializerFromAnnotation, (ajs) modifyTypeByAnnotation.getTypeHandler());
    }

    protected SettableBeanProperty constructSettableProperty(DeserializationContext deserializationContext, agu com_fossil_agu, aiv com_fossil_aiv, Type type) throws JsonMappingException {
        SettableBeanProperty methodProperty;
        aiq Fr = com_fossil_aiv.Fr();
        if (deserializationContext.canOverrideAccessModifiers()) {
            Fr.fixAccess();
        }
        JavaType a = com_fossil_agu.mo979a(type);
        C1635a c1635a = new C1635a(com_fossil_aiv.getFullName(), a, com_fossil_aiv.getWrapperName(), com_fossil_agu.Dq(), Fr, com_fossil_aiv.getMetadata());
        JavaType resolveType = resolveType(deserializationContext, com_fossil_agu, a, Fr);
        if (resolveType != a) {
            c1635a.m3334a(resolveType);
        }
        agy findDeserializerFromAnnotation = findDeserializerFromAnnotation(deserializationContext, Fr);
        a = modifyTypeByAnnotation(deserializationContext, Fr, resolveType);
        ajs com_fossil_ajs = (ajs) a.getTypeHandler();
        if (Fr instanceof AnnotatedMethod) {
            methodProperty = new MethodProperty(com_fossil_aiv, a, com_fossil_ajs, com_fossil_agu.Dq(), (AnnotatedMethod) Fr);
        } else {
            methodProperty = new FieldProperty(com_fossil_aiv, a, com_fossil_ajs, com_fossil_agu.Dq(), (AnnotatedField) Fr);
        }
        if (findDeserializerFromAnnotation != null) {
            methodProperty = methodProperty.withValueDeserializer(findDeserializerFromAnnotation);
        }
        ReferenceProperty Fu = com_fossil_aiv.Fu();
        if (Fu != null && Fu.Dl()) {
            methodProperty.setManagedReferenceName(Fu.getName());
        }
        aiy Fw = com_fossil_aiv.Fw();
        if (Fw != null) {
            methodProperty.setObjectIdInfo(Fw);
        }
        return methodProperty;
    }

    protected SettableBeanProperty constructSetterlessProperty(DeserializationContext deserializationContext, agu com_fossil_agu, aiv com_fossil_aiv) throws JsonMappingException {
        aiq Fl = com_fossil_aiv.Fl();
        if (deserializationContext.canOverrideAccessModifiers()) {
            Fl.fixAccess();
        }
        JavaType type = Fl.getType(com_fossil_agu.Dp());
        agy findDeserializerFromAnnotation = findDeserializerFromAnnotation(deserializationContext, Fl);
        JavaType resolveType = resolveType(deserializationContext, com_fossil_agu, modifyTypeByAnnotation(deserializationContext, Fl, type), Fl);
        SettableBeanProperty setterlessProperty = new SetterlessProperty(com_fossil_aiv, resolveType, (ajs) resolveType.getTypeHandler(), com_fossil_agu.Dq(), Fl);
        if (findDeserializerFromAnnotation != null) {
            return setterlessProperty.withValueDeserializer(findDeserializerFromAnnotation);
        }
        return setterlessProperty;
    }

    protected boolean isPotentialBeanType(Class<?> cls) {
        String v = ami.m3871v(cls);
        if (v != null) {
            throw new IllegalArgumentException("Can not deserialize Class " + cls.getName() + " (of type " + v + ") as a Bean");
        } else if (ami.m3873x(cls)) {
            throw new IllegalArgumentException("Can not deserialize Proxy class " + cls.getName() + " as a Bean");
        } else {
            v = ami.m3859a(cls, true);
            if (v == null) {
                return true;
            }
            throw new IllegalArgumentException("Can not deserialize Class " + cls.getName() + " (of type " + v + ") as a Bean");
        }
    }

    protected boolean isIgnorableType(DeserializationConfig deserializationConfig, agu com_fossil_agu, Class<?> cls, Map<Class<?>, Boolean> map) {
        Boolean bool = (Boolean) map.get(cls);
        if (bool != null) {
            return bool.booleanValue();
        }
        bool = deserializationConfig.getAnnotationIntrospector().isIgnorableType(deserializationConfig.introspectClassAnnotations((Class) cls).Dn());
        return bool == null ? false : bool.booleanValue();
    }
}
