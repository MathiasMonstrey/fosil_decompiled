package com.fasterxml.jackson.databind.deser;

import com.fasterxml.jackson.annotation.JsonFormat.C1501b;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;
import com.fasterxml.jackson.annotation.JsonTypeInfo.As;
import com.fasterxml.jackson.annotation.ObjectIdGenerator;
import com.fasterxml.jackson.annotation.ObjectIdGenerators.PropertyGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.AnnotationIntrospector;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.PropertyMetadata;
import com.fasterxml.jackson.databind.PropertyName;
import com.fasterxml.jackson.databind.deser.impl.BeanPropertyMap;
import com.fasterxml.jackson.databind.deser.impl.InnerClassProperty;
import com.fasterxml.jackson.databind.deser.impl.ManagedReferenceProperty;
import com.fasterxml.jackson.databind.deser.impl.ObjectIdReader;
import com.fasterxml.jackson.databind.deser.impl.ObjectIdReferenceProperty;
import com.fasterxml.jackson.databind.deser.impl.ObjectIdValueProperty;
import com.fasterxml.jackson.databind.deser.impl.PropertyBasedObjectIdGenerator;
import com.fasterxml.jackson.databind.deser.impl.TypeWrappedDeserializer;
import com.fasterxml.jackson.databind.deser.std.StdDelegatingDeserializer;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import com.fasterxml.jackson.databind.exc.IgnoredPropertyException;
import com.fasterxml.jackson.databind.introspect.AnnotatedMember;
import com.fasterxml.jackson.databind.type.ClassKey;
import com.fossil.aeu;
import com.fossil.agu;
import com.fossil.agv;
import com.fossil.agv.C1635a;
import com.fossil.agy;
import com.fossil.aht;
import com.fossil.ahv;
import com.fossil.aic;
import com.fossil.aie;
import com.fossil.aig;
import com.fossil.aig.C1645a;
import com.fossil.aii;
import com.fossil.ail;
import com.fossil.aim;
import com.fossil.ain;
import com.fossil.aiq;
import com.fossil.aiy;
import com.fossil.ajs;
import com.fossil.amc;
import com.fossil.amd;
import com.fossil.ami;
import com.fossil.amk;
import com.fossil.amo;
import com.fossil.amt;
import java.io.IOException;
import java.io.Serializable;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Member;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public abstract class BeanDeserializerBase extends StdDeserializer<Object> implements ahv, aic, Serializable {
    protected static final PropertyName TEMP_PROPERTY_NAME = new PropertyName("#temporary-name");
    private static final long serialVersionUID = 1;
    protected SettableAnyProperty _anySetter;
    protected final Map<String, SettableBeanProperty> _backRefs;
    protected final BeanPropertyMap _beanProperties;
    protected final JavaType _beanType;
    protected agy<Object> _delegateDeserializer;
    protected aig _externalTypeIdHandler;
    protected final HashSet<String> _ignorableProps;
    protected final boolean _ignoreAllUnknown;
    protected final ain[] _injectables;
    protected final boolean _needViewProcesing;
    protected boolean _nonStandardCreation;
    protected final ObjectIdReader _objectIdReader;
    protected aii _propertyBasedCreator;
    protected final Shape _serializationShape;
    protected transient HashMap<ClassKey, agy<Object>> _subDeserializers;
    protected aim _unwrappedPropertyHandler;
    protected final aie _valueInstantiator;
    protected boolean _vanillaProcessing;
    private final transient amc aQO;

    protected abstract Object _deserializeUsingPropertyBased(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException;

    protected abstract BeanDeserializerBase asArrayDeserializer();

    public abstract Object deserializeFromObject(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException;

    public abstract agy<Object> unwrappingDeserializer(amo com_fossil_amo);

    public abstract BeanDeserializerBase withIgnorableProperties(HashSet<String> hashSet);

    public abstract BeanDeserializerBase withObjectIdReader(ObjectIdReader objectIdReader);

    protected BeanDeserializerBase(aht com_fossil_aht, agu com_fossil_agu, BeanPropertyMap beanPropertyMap, Map<String, SettableBeanProperty> map, HashSet<String> hashSet, boolean z, boolean z2) {
        boolean z3;
        boolean z4 = true;
        Shape shape = null;
        super(com_fossil_agu.getType());
        this.aQO = com_fossil_agu.Dn().ER();
        this._beanType = com_fossil_agu.getType();
        this._valueInstantiator = com_fossil_aht.getValueInstantiator();
        this._beanProperties = beanPropertyMap;
        this._backRefs = map;
        this._ignorableProps = hashSet;
        this._ignoreAllUnknown = z;
        this._anySetter = com_fossil_aht.Ep();
        List Eq = com_fossil_aht.Eq();
        ain[] com_fossil_ainArr = (Eq == null || Eq.isEmpty()) ? null : (ain[]) Eq.toArray(new ain[Eq.size()]);
        this._injectables = com_fossil_ainArr;
        this._objectIdReader = com_fossil_aht.getObjectIdReader();
        if (this._unwrappedPropertyHandler != null || this._valueInstantiator.canCreateUsingDelegate() || this._valueInstantiator.canCreateFromObjectWith() || !this._valueInstantiator.canCreateUsingDefault()) {
            z3 = true;
        } else {
            z3 = false;
        }
        this._nonStandardCreation = z3;
        C1501b a = com_fossil_agu.mo978a(null);
        if (a != null) {
            shape = a.yZ();
        }
        this._serializationShape = shape;
        this._needViewProcesing = z2;
        if (this._nonStandardCreation || this._injectables != null || this._needViewProcesing || this._objectIdReader != null) {
            z4 = false;
        }
        this._vanillaProcessing = z4;
    }

    protected BeanDeserializerBase(BeanDeserializerBase beanDeserializerBase) {
        this(beanDeserializerBase, beanDeserializerBase._ignoreAllUnknown);
    }

    protected BeanDeserializerBase(BeanDeserializerBase beanDeserializerBase, boolean z) {
        super(beanDeserializerBase._beanType);
        this.aQO = beanDeserializerBase.aQO;
        this._beanType = beanDeserializerBase._beanType;
        this._valueInstantiator = beanDeserializerBase._valueInstantiator;
        this._delegateDeserializer = beanDeserializerBase._delegateDeserializer;
        this._propertyBasedCreator = beanDeserializerBase._propertyBasedCreator;
        this._beanProperties = beanDeserializerBase._beanProperties;
        this._backRefs = beanDeserializerBase._backRefs;
        this._ignorableProps = beanDeserializerBase._ignorableProps;
        this._ignoreAllUnknown = z;
        this._anySetter = beanDeserializerBase._anySetter;
        this._injectables = beanDeserializerBase._injectables;
        this._objectIdReader = beanDeserializerBase._objectIdReader;
        this._nonStandardCreation = beanDeserializerBase._nonStandardCreation;
        this._unwrappedPropertyHandler = beanDeserializerBase._unwrappedPropertyHandler;
        this._needViewProcesing = beanDeserializerBase._needViewProcesing;
        this._serializationShape = beanDeserializerBase._serializationShape;
        this._vanillaProcessing = beanDeserializerBase._vanillaProcessing;
    }

    protected BeanDeserializerBase(BeanDeserializerBase beanDeserializerBase, amo com_fossil_amo) {
        super(beanDeserializerBase._beanType);
        this.aQO = beanDeserializerBase.aQO;
        this._beanType = beanDeserializerBase._beanType;
        this._valueInstantiator = beanDeserializerBase._valueInstantiator;
        this._delegateDeserializer = beanDeserializerBase._delegateDeserializer;
        this._propertyBasedCreator = beanDeserializerBase._propertyBasedCreator;
        this._backRefs = beanDeserializerBase._backRefs;
        this._ignorableProps = beanDeserializerBase._ignorableProps;
        boolean z = com_fossil_amo != null || beanDeserializerBase._ignoreAllUnknown;
        this._ignoreAllUnknown = z;
        this._anySetter = beanDeserializerBase._anySetter;
        this._injectables = beanDeserializerBase._injectables;
        this._objectIdReader = beanDeserializerBase._objectIdReader;
        this._nonStandardCreation = beanDeserializerBase._nonStandardCreation;
        aim com_fossil_aim = beanDeserializerBase._unwrappedPropertyHandler;
        if (com_fossil_amo != null) {
            if (com_fossil_aim != null) {
                com_fossil_aim = com_fossil_aim.m3408a(com_fossil_amo);
            }
            this._beanProperties = beanDeserializerBase._beanProperties.renameAll(com_fossil_amo);
        } else {
            this._beanProperties = beanDeserializerBase._beanProperties;
        }
        this._unwrappedPropertyHandler = com_fossil_aim;
        this._needViewProcesing = beanDeserializerBase._needViewProcesing;
        this._serializationShape = beanDeserializerBase._serializationShape;
        this._vanillaProcessing = false;
    }

    public BeanDeserializerBase(BeanDeserializerBase beanDeserializerBase, ObjectIdReader objectIdReader) {
        super(beanDeserializerBase._beanType);
        this.aQO = beanDeserializerBase.aQO;
        this._beanType = beanDeserializerBase._beanType;
        this._valueInstantiator = beanDeserializerBase._valueInstantiator;
        this._delegateDeserializer = beanDeserializerBase._delegateDeserializer;
        this._propertyBasedCreator = beanDeserializerBase._propertyBasedCreator;
        this._backRefs = beanDeserializerBase._backRefs;
        this._ignorableProps = beanDeserializerBase._ignorableProps;
        this._ignoreAllUnknown = beanDeserializerBase._ignoreAllUnknown;
        this._anySetter = beanDeserializerBase._anySetter;
        this._injectables = beanDeserializerBase._injectables;
        this._nonStandardCreation = beanDeserializerBase._nonStandardCreation;
        this._unwrappedPropertyHandler = beanDeserializerBase._unwrappedPropertyHandler;
        this._needViewProcesing = beanDeserializerBase._needViewProcesing;
        this._serializationShape = beanDeserializerBase._serializationShape;
        this._objectIdReader = objectIdReader;
        if (objectIdReader == null) {
            this._beanProperties = beanDeserializerBase._beanProperties;
            this._vanillaProcessing = beanDeserializerBase._vanillaProcessing;
            return;
        }
        this._beanProperties = beanDeserializerBase._beanProperties.withProperty(new ObjectIdValueProperty(objectIdReader, PropertyMetadata.STD_REQUIRED));
        this._vanillaProcessing = false;
    }

    public BeanDeserializerBase(BeanDeserializerBase beanDeserializerBase, HashSet<String> hashSet) {
        super(beanDeserializerBase._beanType);
        this.aQO = beanDeserializerBase.aQO;
        this._beanType = beanDeserializerBase._beanType;
        this._valueInstantiator = beanDeserializerBase._valueInstantiator;
        this._delegateDeserializer = beanDeserializerBase._delegateDeserializer;
        this._propertyBasedCreator = beanDeserializerBase._propertyBasedCreator;
        this._backRefs = beanDeserializerBase._backRefs;
        this._ignorableProps = hashSet;
        this._ignoreAllUnknown = beanDeserializerBase._ignoreAllUnknown;
        this._anySetter = beanDeserializerBase._anySetter;
        this._injectables = beanDeserializerBase._injectables;
        this._nonStandardCreation = beanDeserializerBase._nonStandardCreation;
        this._unwrappedPropertyHandler = beanDeserializerBase._unwrappedPropertyHandler;
        this._needViewProcesing = beanDeserializerBase._needViewProcesing;
        this._serializationShape = beanDeserializerBase._serializationShape;
        this._vanillaProcessing = beanDeserializerBase._vanillaProcessing;
        this._objectIdReader = beanDeserializerBase._objectIdReader;
        this._beanProperties = beanDeserializerBase._beanProperties;
    }

    public void resolve(DeserializationContext deserializationContext) throws JsonMappingException {
        C1645a c1645a;
        SettableBeanProperty[] settableBeanPropertyArr;
        boolean z;
        if (this._valueInstantiator.canCreateFromObjectWith()) {
            SettableBeanProperty[] fromObjectArguments = this._valueInstantiator.getFromObjectArguments(deserializationContext.getConfig());
            c1645a = null;
            for (SettableBeanProperty settableBeanProperty : fromObjectArguments) {
                if (settableBeanProperty.hasValueTypeDeserializer()) {
                    ajs valueTypeDeserializer = settableBeanProperty.getValueTypeDeserializer();
                    if (valueTypeDeserializer.getTypeInclusion() == As.EXTERNAL_PROPERTY) {
                        if (c1645a == null) {
                            c1645a = new C1645a();
                        }
                        c1645a.m3388a(settableBeanProperty, valueTypeDeserializer);
                    }
                }
            }
            settableBeanPropertyArr = fromObjectArguments;
        } else {
            settableBeanPropertyArr = null;
            c1645a = null;
        }
        Iterator it = this._beanProperties.iterator();
        aim com_fossil_aim = null;
        C1645a c1645a2 = c1645a;
        while (it.hasNext()) {
            SettableBeanProperty withValueDeserializer;
            ajs valueTypeDeserializer2;
            SettableBeanProperty settableBeanProperty2 = (SettableBeanProperty) it.next();
            agy valueDeserializer;
            if (settableBeanProperty2.hasValueDeserializer()) {
                valueDeserializer = settableBeanProperty2.getValueDeserializer();
                agy handlePrimaryContextualization = deserializationContext.handlePrimaryContextualization(valueDeserializer, settableBeanProperty2, settableBeanProperty2.getType());
                if (handlePrimaryContextualization != valueDeserializer) {
                    withValueDeserializer = settableBeanProperty2.withValueDeserializer(handlePrimaryContextualization);
                } else {
                    withValueDeserializer = settableBeanProperty2;
                }
            } else {
                valueDeserializer = findConvertingDeserializer(deserializationContext, settableBeanProperty2);
                if (valueDeserializer == null) {
                    valueDeserializer = findDeserializer(deserializationContext, settableBeanProperty2.getType(), settableBeanProperty2);
                }
                withValueDeserializer = settableBeanProperty2.withValueDeserializer(valueDeserializer);
            }
            withValueDeserializer = _resolveManagedReferenceProperty(deserializationContext, withValueDeserializer);
            if (!(withValueDeserializer instanceof ManagedReferenceProperty)) {
                withValueDeserializer = _resolvedObjectIdProperty(deserializationContext, withValueDeserializer);
            }
            SettableBeanProperty _resolveUnwrappedProperty = _resolveUnwrappedProperty(deserializationContext, withValueDeserializer);
            if (_resolveUnwrappedProperty != null) {
                aim com_fossil_aim2;
                if (com_fossil_aim == null) {
                    com_fossil_aim2 = new aim();
                } else {
                    com_fossil_aim2 = com_fossil_aim;
                }
                com_fossil_aim2.m3410a(_resolveUnwrappedProperty);
                this._beanProperties.remove(_resolveUnwrappedProperty);
                com_fossil_aim = com_fossil_aim2;
            } else {
                _resolveUnwrappedProperty = _resolveInnerClassValuedProperty(deserializationContext, withValueDeserializer);
                if (_resolveUnwrappedProperty != settableBeanProperty2) {
                    this._beanProperties.replace(_resolveUnwrappedProperty);
                    if (settableBeanPropertyArr != null) {
                        int length = settableBeanPropertyArr.length;
                        for (int i = 0; i < length; i++) {
                            if (settableBeanPropertyArr[i] == settableBeanProperty2) {
                                settableBeanPropertyArr[i] = _resolveUnwrappedProperty;
                                break;
                            }
                        }
                    }
                }
                if (_resolveUnwrappedProperty.hasValueTypeDeserializer()) {
                    valueTypeDeserializer2 = _resolveUnwrappedProperty.getValueTypeDeserializer();
                    if (valueTypeDeserializer2.getTypeInclusion() == As.EXTERNAL_PROPERTY) {
                        if (c1645a2 == null) {
                            c1645a = new C1645a();
                        } else {
                            c1645a = c1645a2;
                        }
                        c1645a.m3388a(_resolveUnwrappedProperty, valueTypeDeserializer2);
                        this._beanProperties.remove(_resolveUnwrappedProperty);
                        c1645a2 = c1645a;
                    }
                }
            }
        }
        if (!(this._anySetter == null || this._anySetter.hasValueDeserializer())) {
            this._anySetter = this._anySetter.withValueDeserializer(findDeserializer(deserializationContext, this._anySetter.getType(), this._anySetter.getProperty()));
        }
        if (this._valueInstantiator.canCreateUsingDelegate()) {
            JavaType delegateType = this._valueInstantiator.getDelegateType(deserializationContext.getConfig());
            if (delegateType == null) {
                throw new IllegalArgumentException("Invalid delegate-creator definition for " + this._beanType + ": value instantiator (" + this._valueInstantiator.getClass().getName() + ") returned true for 'canCreateUsingDelegate()', but null for 'getDelegateType()'");
            }
            agy typeWrappedDeserializer;
            agv c1635a = new C1635a(TEMP_PROPERTY_NAME, delegateType, null, this.aQO, this._valueInstantiator.getDelegateCreator(), PropertyMetadata.STD_OPTIONAL);
            valueTypeDeserializer2 = (ajs) delegateType.getTypeHandler();
            if (valueTypeDeserializer2 == null) {
                valueTypeDeserializer2 = deserializationContext.getConfig().findTypeDeserializer(delegateType);
            }
            agy findDeserializer = findDeserializer(deserializationContext, delegateType, c1635a);
            if (valueTypeDeserializer2 != null) {
                typeWrappedDeserializer = new TypeWrappedDeserializer(valueTypeDeserializer2.forProperty(c1635a), findDeserializer);
            } else {
                typeWrappedDeserializer = findDeserializer;
            }
            this._delegateDeserializer = typeWrappedDeserializer;
        }
        if (settableBeanPropertyArr != null) {
            this._propertyBasedCreator = aii.m3395a(deserializationContext, this._valueInstantiator, settableBeanPropertyArr);
        }
        if (c1645a2 != null) {
            this._externalTypeIdHandler = c1645a2.ED();
            this._nonStandardCreation = true;
        }
        this._unwrappedPropertyHandler = com_fossil_aim;
        if (com_fossil_aim != null) {
            this._nonStandardCreation = true;
        }
        if (!this._vanillaProcessing || this._nonStandardCreation) {
            z = false;
        } else {
            z = true;
        }
        this._vanillaProcessing = z;
    }

    protected agy<Object> findConvertingDeserializer(DeserializationContext deserializationContext, SettableBeanProperty settableBeanProperty) throws JsonMappingException {
        AnnotationIntrospector annotationIntrospector = deserializationContext.getAnnotationIntrospector();
        if (annotationIntrospector != null) {
            Object findDeserializationConverter = annotationIntrospector.findDeserializationConverter(settableBeanProperty.getMember());
            if (findDeserializationConverter != null) {
                amk converterInstance = deserializationContext.converterInstance(settableBeanProperty.getMember(), findDeserializationConverter);
                JavaType a = converterInstance.m3878a(deserializationContext.getTypeFactory());
                return new StdDelegatingDeserializer(converterInstance, a, deserializationContext.findContextualValueDeserializer(a, settableBeanProperty));
            }
        }
        return null;
    }

    public agy<?> createContextual(DeserializationContext deserializationContext, agv com_fossil_agv) throws JsonMappingException {
        agy com_fossil_agy;
        Shape yZ;
        ObjectIdReader objectIdReader = this._objectIdReader;
        AnnotationIntrospector annotationIntrospector = deserializationContext.getAnnotationIntrospector();
        aiq member = (com_fossil_agv == null || annotationIntrospector == null) ? null : com_fossil_agv.getMember();
        if (!(member == null || annotationIntrospector == null)) {
            aiy findObjectIdInfo = annotationIntrospector.findObjectIdInfo(member);
            if (findObjectIdInfo != null) {
                SettableBeanProperty findProperty;
                JavaType type;
                ObjectIdGenerator propertyBasedObjectIdGenerator;
                findObjectIdInfo = annotationIntrospector.findObjectReferenceInfo(member, findObjectIdInfo);
                Class Fz = findObjectIdInfo.Fz();
                aeu objectIdResolverInstance = deserializationContext.objectIdResolverInstance(member, findObjectIdInfo);
                if (Fz == PropertyGenerator.class) {
                    PropertyName Fy = findObjectIdInfo.Fy();
                    findProperty = findProperty(Fy);
                    if (findProperty == null) {
                        throw new IllegalArgumentException("Invalid Object Id definition for " + handledType().getName() + ": can not find property with name '" + Fy + "'");
                    }
                    type = findProperty.getType();
                    propertyBasedObjectIdGenerator = new PropertyBasedObjectIdGenerator(findObjectIdInfo.getScope());
                } else {
                    type = deserializationContext.getTypeFactory().findTypeParameters(deserializationContext.constructType(Fz), ObjectIdGenerator.class)[0];
                    propertyBasedObjectIdGenerator = deserializationContext.objectIdGeneratorInstance(member, findObjectIdInfo);
                    findProperty = null;
                }
                objectIdReader = ObjectIdReader.construct(type, findObjectIdInfo.Fy(), propertyBasedObjectIdGenerator, deserializationContext.findRootValueDeserializer(type), findProperty, objectIdResolverInstance);
            }
        }
        if (objectIdReader == null || objectIdReader == this._objectIdReader) {
            com_fossil_agy = this;
        } else {
            com_fossil_agy = withObjectIdReader(objectIdReader);
        }
        if (member != null) {
            Object[] findPropertiesToIgnore = annotationIntrospector.findPropertiesToIgnore(member, false);
            if (!(findPropertiesToIgnore == null || findPropertiesToIgnore.length == 0)) {
                com_fossil_agy = com_fossil_agy.withIgnorableProperties(amd.m3836a(com_fossil_agy._ignorableProps, findPropertiesToIgnore));
            }
        }
        if (member != null) {
            C1501b findFormat = annotationIntrospector.findFormat(member);
            if (findFormat != null) {
                yZ = findFormat.yZ();
                if (yZ == null) {
                    yZ = this._serializationShape;
                }
                if (yZ != Shape.ARRAY) {
                    return com_fossil_agy.asArrayDeserializer();
                }
                return com_fossil_agy;
            }
        }
        yZ = null;
        if (yZ == null) {
            yZ = this._serializationShape;
        }
        if (yZ != Shape.ARRAY) {
            return com_fossil_agy;
        }
        return com_fossil_agy.asArrayDeserializer();
    }

    protected SettableBeanProperty _resolveManagedReferenceProperty(DeserializationContext deserializationContext, SettableBeanProperty settableBeanProperty) {
        String managedReferenceName = settableBeanProperty.getManagedReferenceName();
        if (managedReferenceName == null) {
            return settableBeanProperty;
        }
        SettableBeanProperty findBackReference = settableBeanProperty.getValueDeserializer().findBackReference(managedReferenceName);
        if (findBackReference == null) {
            throw new IllegalArgumentException("Can not handle managed/back reference '" + managedReferenceName + "': no back reference property found from type " + settableBeanProperty.getType());
        }
        JavaType javaType = this._beanType;
        JavaType type = findBackReference.getType();
        boolean isContainerType = settableBeanProperty.getType().isContainerType();
        if (type.getRawClass().isAssignableFrom(javaType.getRawClass())) {
            return new ManagedReferenceProperty(settableBeanProperty, managedReferenceName, findBackReference, this.aQO, isContainerType);
        }
        throw new IllegalArgumentException("Can not handle managed/back reference '" + managedReferenceName + "': back reference type (" + type.getRawClass().getName() + ") not compatible with managed type (" + javaType.getRawClass().getName() + ")");
    }

    protected SettableBeanProperty _resolvedObjectIdProperty(DeserializationContext deserializationContext, SettableBeanProperty settableBeanProperty) {
        aiy objectIdInfo = settableBeanProperty.getObjectIdInfo();
        return (objectIdInfo == null && settableBeanProperty.getValueDeserializer().getObjectIdReader() == null) ? settableBeanProperty : new ObjectIdReferenceProperty(settableBeanProperty, objectIdInfo);
    }

    protected SettableBeanProperty _resolveUnwrappedProperty(DeserializationContext deserializationContext, SettableBeanProperty settableBeanProperty) {
        AnnotatedMember member = settableBeanProperty.getMember();
        if (member != null) {
            amo findUnwrappingNameTransformer = deserializationContext.getAnnotationIntrospector().findUnwrappingNameTransformer(member);
            if (findUnwrappingNameTransformer != null) {
                agy valueDeserializer = settableBeanProperty.getValueDeserializer();
                agy unwrappingDeserializer = valueDeserializer.unwrappingDeserializer(findUnwrappingNameTransformer);
                if (!(unwrappingDeserializer == valueDeserializer || unwrappingDeserializer == null)) {
                    return settableBeanProperty.withValueDeserializer(unwrappingDeserializer);
                }
            }
        }
        return null;
    }

    protected SettableBeanProperty _resolveInnerClassValuedProperty(DeserializationContext deserializationContext, SettableBeanProperty settableBeanProperty) {
        agy valueDeserializer = settableBeanProperty.getValueDeserializer();
        if (!(valueDeserializer instanceof BeanDeserializerBase) || ((BeanDeserializerBase) valueDeserializer).getValueInstantiator().canCreateUsingDefault()) {
            return settableBeanProperty;
        }
        Class rawClass = settableBeanProperty.getType().getRawClass();
        Class w = ami.m3872w(rawClass);
        if (w == null || w != this._beanType.getRawClass()) {
            return settableBeanProperty;
        }
        for (Constructor constructor : rawClass.getConstructors()) {
            Class[] parameterTypes = constructor.getParameterTypes();
            if (parameterTypes.length == 1 && parameterTypes[0] == w) {
                if (deserializationContext.getConfig().canOverrideAccessModifiers()) {
                    ami.m3862a((Member) constructor);
                }
                return new InnerClassProperty(settableBeanProperty, constructor);
            }
        }
        return settableBeanProperty;
    }

    public boolean isCachable() {
        return true;
    }

    public Class<?> handledType() {
        return this._beanType.getRawClass();
    }

    public ObjectIdReader getObjectIdReader() {
        return this._objectIdReader;
    }

    public boolean hasProperty(String str) {
        return this._beanProperties.find(str) != null;
    }

    public boolean hasViews() {
        return this._needViewProcesing;
    }

    public int getPropertyCount() {
        return this._beanProperties.size();
    }

    public Collection<Object> getKnownPropertyNames() {
        Collection arrayList = new ArrayList();
        Iterator it = this._beanProperties.iterator();
        while (it.hasNext()) {
            arrayList.add(((SettableBeanProperty) it.next()).getName());
        }
        return arrayList;
    }

    @Deprecated
    public final Class<?> getBeanClass() {
        return this._beanType.getRawClass();
    }

    public JavaType getValueType() {
        return this._beanType;
    }

    public Iterator<SettableBeanProperty> properties() {
        if (this._beanProperties != null) {
            return this._beanProperties.iterator();
        }
        throw new IllegalStateException("Can only call after BeanDeserializer has been resolved");
    }

    public Iterator<SettableBeanProperty> creatorProperties() {
        if (this._propertyBasedCreator == null) {
            return Collections.emptyList().iterator();
        }
        return this._propertyBasedCreator.EI().iterator();
    }

    public SettableBeanProperty findProperty(PropertyName propertyName) {
        return findProperty(propertyName.getSimpleName());
    }

    public SettableBeanProperty findProperty(String str) {
        SettableBeanProperty find = this._beanProperties == null ? null : this._beanProperties.find(str);
        if (find != null || this._propertyBasedCreator == null) {
            return find;
        }
        return this._propertyBasedCreator.bJ(str);
    }

    public SettableBeanProperty findProperty(int i) {
        SettableBeanProperty find = this._beanProperties == null ? null : this._beanProperties.find(i);
        if (find != null || this._propertyBasedCreator == null) {
            return find;
        }
        return this._propertyBasedCreator.gR(i);
    }

    public SettableBeanProperty findBackReference(String str) {
        if (this._backRefs == null) {
            return null;
        }
        return (SettableBeanProperty) this._backRefs.get(str);
    }

    public aie getValueInstantiator() {
        return this._valueInstantiator;
    }

    public void replaceProperty(SettableBeanProperty settableBeanProperty, SettableBeanProperty settableBeanProperty2) {
        this._beanProperties.replace(settableBeanProperty2);
    }

    public Object deserializeWithType(JsonParser jsonParser, DeserializationContext deserializationContext, ajs com_fossil_ajs) throws IOException {
        if (this._objectIdReader != null) {
            if (jsonParser.Av()) {
                Object Ax = jsonParser.Ax();
                if (Ax != null) {
                    return _handleTypedObjectId(jsonParser, deserializationContext, com_fossil_ajs.deserializeTypedFromObject(jsonParser, deserializationContext), Ax);
                }
            }
            JsonToken zU = jsonParser.zU();
            if (zU != null) {
                if (zU.isScalarValue()) {
                    return deserializeFromObjectId(jsonParser, deserializationContext);
                }
                if (zU == JsonToken.START_OBJECT) {
                    zU = jsonParser.zP();
                }
                if (zU == JsonToken.FIELD_NAME && this._objectIdReader.maySerializeAsObject() && this._objectIdReader.isValidReferencePropertyName(jsonParser.zW(), jsonParser)) {
                    return deserializeFromObjectId(jsonParser, deserializationContext);
                }
            }
        }
        return com_fossil_ajs.deserializeTypedFromObject(jsonParser, deserializationContext);
    }

    protected Object _handleTypedObjectId(JsonParser jsonParser, DeserializationContext deserializationContext, Object obj, Object obj2) throws IOException {
        agy deserializer = this._objectIdReader.getDeserializer();
        if (deserializer.handledType() != obj2.getClass()) {
            obj2 = _convertObjectId(jsonParser, deserializationContext, obj2, deserializer);
        }
        deserializationContext.findObjectId(obj2, this._objectIdReader.generator, this._objectIdReader.resolver).bu(obj);
        SettableBeanProperty settableBeanProperty = this._objectIdReader.idProperty;
        if (settableBeanProperty != null) {
            return settableBeanProperty.setAndReturn(obj, obj2);
        }
        return obj;
    }

    protected Object _convertObjectId(JsonParser jsonParser, DeserializationContext deserializationContext, Object obj, agy<Object> com_fossil_agy_java_lang_Object) throws IOException {
        amt com_fossil_amt = new amt(jsonParser);
        if (obj instanceof String) {
            com_fossil_amt.writeString((String) obj);
        } else if (obj instanceof Long) {
            com_fossil_amt.mo933J(((Long) obj).longValue());
        } else if (obj instanceof Integer) {
            com_fossil_amt.fl(((Integer) obj).intValue());
        } else {
            com_fossil_amt.writeObject(obj);
        }
        JsonParser Hu = com_fossil_amt.Hu();
        Hu.zP();
        return com_fossil_agy_java_lang_Object.deserialize(Hu, deserializationContext);
    }

    protected Object deserializeWithObjectId(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
        return deserializeFromObject(jsonParser, deserializationContext);
    }

    protected Object deserializeFromObjectId(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
        Object readObjectReference = this._objectIdReader.readObjectReference(jsonParser, deserializationContext);
        ail findObjectId = deserializationContext.findObjectId(readObjectReference, this._objectIdReader.generator, this._objectIdReader.resolver);
        Object EL = findObjectId.EL();
        if (EL != null) {
            return EL;
        }
        throw new UnresolvedForwardReference("Could not resolve Object Id [" + readObjectReference + "] (for " + this._beanType + ").", jsonParser.zZ(), findObjectId);
    }

    protected Object deserializeFromObjectUsingNonDefault(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
        if (this._delegateDeserializer != null) {
            return this._valueInstantiator.createUsingDelegate(deserializationContext, this._delegateDeserializer.deserialize(jsonParser, deserializationContext));
        }
        if (this._propertyBasedCreator != null) {
            return _deserializeUsingPropertyBased(jsonParser, deserializationContext);
        }
        if (this._beanType.isAbstract()) {
            throw JsonMappingException.from(jsonParser, "Can not instantiate abstract type " + this._beanType + " (need to add/enable type information?)");
        }
        throw JsonMappingException.from(jsonParser, "No suitable constructor found for type " + this._beanType + ": can not instantiate from JSON object (missing default constructor or creator, or perhaps need to add/enable type information?)");
    }

    public Object deserializeFromNumber(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
        if (this._objectIdReader != null) {
            return deserializeFromObjectId(jsonParser, deserializationContext);
        }
        Object createUsingDelegate;
        switch (jsonParser.Ai()) {
            case INT:
                if (this._delegateDeserializer == null || this._valueInstantiator.canCreateFromInt()) {
                    return this._valueInstantiator.createFromInt(deserializationContext, jsonParser.getIntValue());
                }
                createUsingDelegate = this._valueInstantiator.createUsingDelegate(deserializationContext, this._delegateDeserializer.deserialize(jsonParser, deserializationContext));
                if (this._injectables == null) {
                    return createUsingDelegate;
                }
                injectValues(deserializationContext, createUsingDelegate);
                return createUsingDelegate;
            case LONG:
                if (this._delegateDeserializer == null || this._valueInstantiator.canCreateFromInt()) {
                    return this._valueInstantiator.createFromLong(deserializationContext, jsonParser.Al());
                }
                createUsingDelegate = this._valueInstantiator.createUsingDelegate(deserializationContext, this._delegateDeserializer.deserialize(jsonParser, deserializationContext));
                if (this._injectables == null) {
                    return createUsingDelegate;
                }
                injectValues(deserializationContext, createUsingDelegate);
                return createUsingDelegate;
            default:
                if (this._delegateDeserializer != null) {
                    createUsingDelegate = this._valueInstantiator.createUsingDelegate(deserializationContext, this._delegateDeserializer.deserialize(jsonParser, deserializationContext));
                    if (this._injectables == null) {
                        return createUsingDelegate;
                    }
                    injectValues(deserializationContext, createUsingDelegate);
                    return createUsingDelegate;
                }
                throw deserializationContext.instantiationException(handledType(), "no suitable creator method found to deserialize from JSON integer number");
        }
    }

    public Object deserializeFromString(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
        if (this._objectIdReader != null) {
            return deserializeFromObjectId(jsonParser, deserializationContext);
        }
        if (this._delegateDeserializer == null || this._valueInstantiator.canCreateFromString()) {
            return this._valueInstantiator.createFromString(deserializationContext, jsonParser.getText());
        }
        Object createUsingDelegate = this._valueInstantiator.createUsingDelegate(deserializationContext, this._delegateDeserializer.deserialize(jsonParser, deserializationContext));
        if (this._injectables == null) {
            return createUsingDelegate;
        }
        injectValues(deserializationContext, createUsingDelegate);
        return createUsingDelegate;
    }

    public Object deserializeFromDouble(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
        switch (jsonParser.Ai()) {
            case FLOAT:
            case DOUBLE:
                if (this._delegateDeserializer == null || this._valueInstantiator.canCreateFromDouble()) {
                    return this._valueInstantiator.createFromDouble(deserializationContext, jsonParser.Ao());
                }
                Object createUsingDelegate = this._valueInstantiator.createUsingDelegate(deserializationContext, this._delegateDeserializer.deserialize(jsonParser, deserializationContext));
                if (this._injectables == null) {
                    return createUsingDelegate;
                }
                injectValues(deserializationContext, createUsingDelegate);
                return createUsingDelegate;
            default:
                if (this._delegateDeserializer != null) {
                    return this._valueInstantiator.createUsingDelegate(deserializationContext, this._delegateDeserializer.deserialize(jsonParser, deserializationContext));
                }
                throw deserializationContext.instantiationException(handledType(), "no suitable creator method found to deserialize from JSON floating-point number");
        }
    }

    public Object deserializeFromBoolean(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
        if (this._delegateDeserializer == null || this._valueInstantiator.canCreateFromBoolean()) {
            return this._valueInstantiator.createFromBoolean(deserializationContext, jsonParser.zU() == JsonToken.VALUE_TRUE);
        }
        Object createUsingDelegate = this._valueInstantiator.createUsingDelegate(deserializationContext, this._delegateDeserializer.deserialize(jsonParser, deserializationContext));
        if (this._injectables == null) {
            return createUsingDelegate;
        }
        injectValues(deserializationContext, createUsingDelegate);
        return createUsingDelegate;
    }

    public Object deserializeFromArray(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
        Object createUsingDelegate;
        if (this._delegateDeserializer != null) {
            try {
                createUsingDelegate = this._valueInstantiator.createUsingDelegate(deserializationContext, this._delegateDeserializer.deserialize(jsonParser, deserializationContext));
                if (this._injectables == null) {
                    return createUsingDelegate;
                }
                injectValues(deserializationContext, createUsingDelegate);
                return createUsingDelegate;
            } catch (Throwable e) {
                wrapInstantiationProblem(e, deserializationContext);
            }
        }
        if (deserializationContext.isEnabled(DeserializationFeature.UNWRAP_SINGLE_VALUE_ARRAYS)) {
            if (jsonParser.zP() == JsonToken.END_ARRAY && deserializationContext.isEnabled(DeserializationFeature.ACCEPT_EMPTY_ARRAY_AS_NULL_OBJECT)) {
                return null;
            }
            createUsingDelegate = deserialize(jsonParser, deserializationContext);
            if (jsonParser.zP() == JsonToken.END_ARRAY) {
                return createUsingDelegate;
            }
            throw deserializationContext.wrongTokenException(jsonParser, JsonToken.END_ARRAY, "Attempted to unwrap single value array for single '" + this._valueClass.getName() + "' value but there was more than a single value in the array");
        } else if (!deserializationContext.isEnabled(DeserializationFeature.ACCEPT_EMPTY_ARRAY_AS_NULL_OBJECT)) {
            throw deserializationContext.mappingException(handledType());
        } else if (jsonParser.zP() == JsonToken.END_ARRAY) {
            return null;
        } else {
            throw deserializationContext.mappingException(handledType(), JsonToken.START_ARRAY);
        }
    }

    public Object deserializeFromEmbedded(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
        if (this._objectIdReader != null) {
            return deserializeFromObjectId(jsonParser, deserializationContext);
        }
        return jsonParser.Aq();
    }

    protected void injectValues(DeserializationContext deserializationContext, Object obj) throws IOException, JsonProcessingException {
        for (ain inject : this._injectables) {
            inject.inject(deserializationContext, obj);
        }
    }

    protected Object handleUnknownProperties(DeserializationContext deserializationContext, Object obj, amt com_fossil_amt) throws IOException, JsonProcessingException {
        com_fossil_amt.zK();
        JsonParser Hu = com_fossil_amt.Hu();
        while (Hu.zP() != JsonToken.END_OBJECT) {
            String zW = Hu.zW();
            Hu.zP();
            handleUnknownProperty(Hu, deserializationContext, obj, zW);
        }
        return obj;
    }

    protected void handleUnknownVanilla(JsonParser jsonParser, DeserializationContext deserializationContext, Object obj, String str) throws IOException, JsonProcessingException {
        if (this._ignorableProps != null && this._ignorableProps.contains(str)) {
            handleIgnoredProperty(jsonParser, deserializationContext, obj, str);
        } else if (this._anySetter != null) {
            try {
                this._anySetter.deserializeAndSet(jsonParser, deserializationContext, obj, str);
            } catch (Throwable e) {
                wrapAndThrow(e, obj, str, deserializationContext);
            }
        } else {
            handleUnknownProperty(jsonParser, deserializationContext, obj, str);
        }
    }

    protected void handleUnknownProperty(JsonParser jsonParser, DeserializationContext deserializationContext, Object obj, String str) throws IOException, JsonProcessingException {
        if (this._ignoreAllUnknown) {
            jsonParser.zT();
            return;
        }
        if (this._ignorableProps != null && this._ignorableProps.contains(str)) {
            handleIgnoredProperty(jsonParser, deserializationContext, obj, str);
        }
        super.handleUnknownProperty(jsonParser, deserializationContext, obj, str);
    }

    protected void handleIgnoredProperty(JsonParser jsonParser, DeserializationContext deserializationContext, Object obj, String str) throws IOException, JsonProcessingException {
        if (deserializationContext.isEnabled(DeserializationFeature.FAIL_ON_IGNORED_PROPERTIES)) {
            throw IgnoredPropertyException.from(jsonParser, obj, str, getKnownPropertyNames());
        }
        jsonParser.zT();
    }

    protected Object handlePolymorphic(JsonParser jsonParser, DeserializationContext deserializationContext, Object obj, amt com_fossil_amt) throws IOException, JsonProcessingException {
        agy _findSubclassDeserializer = _findSubclassDeserializer(deserializationContext, obj, com_fossil_amt);
        Object deserialize;
        if (_findSubclassDeserializer != null) {
            if (com_fossil_amt != null) {
                com_fossil_amt.zK();
                JsonParser Hu = com_fossil_amt.Hu();
                Hu.zP();
                deserialize = _findSubclassDeserializer.deserialize(Hu, deserializationContext, obj);
            } else {
                deserialize = obj;
            }
            if (jsonParser != null) {
                return _findSubclassDeserializer.deserialize(jsonParser, deserializationContext, deserialize);
            }
            return deserialize;
        }
        if (com_fossil_amt != null) {
            deserialize = handleUnknownProperties(deserializationContext, obj, com_fossil_amt);
        } else {
            deserialize = obj;
        }
        if (jsonParser != null) {
            return deserialize(jsonParser, deserializationContext, deserialize);
        }
        return deserialize;
    }

    protected agy<Object> _findSubclassDeserializer(DeserializationContext deserializationContext, Object obj, amt com_fossil_amt) throws IOException, JsonProcessingException {
        agy<Object> com_fossil_agy_java_lang_Object;
        synchronized (this) {
            com_fossil_agy_java_lang_Object = this._subDeserializers == null ? null : (agy) this._subDeserializers.get(new ClassKey(obj.getClass()));
        }
        if (com_fossil_agy_java_lang_Object == null) {
            com_fossil_agy_java_lang_Object = deserializationContext.findRootValueDeserializer(deserializationContext.constructType(obj.getClass()));
            if (com_fossil_agy_java_lang_Object != null) {
                synchronized (this) {
                    if (this._subDeserializers == null) {
                        this._subDeserializers = new HashMap();
                    }
                    this._subDeserializers.put(new ClassKey(obj.getClass()), com_fossil_agy_java_lang_Object);
                }
            }
        }
        return com_fossil_agy_java_lang_Object;
    }

    public void wrapAndThrow(Throwable th, Object obj, String str, DeserializationContext deserializationContext) throws IOException {
        throw JsonMappingException.wrapWithPath(m2698a(th, deserializationContext), obj, str);
    }

    @Deprecated
    public void wrapAndThrow(Throwable th, Object obj, int i, DeserializationContext deserializationContext) throws IOException {
        throw JsonMappingException.wrapWithPath(m2698a(th, deserializationContext), obj, i);
    }

    private Throwable m2698a(Throwable th, DeserializationContext deserializationContext) throws IOException {
        Throwable th2 = th;
        while ((th2 instanceof InvocationTargetException) && th2.getCause() != null) {
            th2 = th2.getCause();
        }
        if (th2 instanceof Error) {
            throw ((Error) th2);
        }
        Object obj = (deserializationContext == null || deserializationContext.isEnabled(DeserializationFeature.WRAP_EXCEPTIONS)) ? 1 : null;
        if (th2 instanceof IOException) {
            if (obj == null || !(th2 instanceof JsonProcessingException)) {
                throw ((IOException) th2);
            }
        } else if (obj == null && (th2 instanceof RuntimeException)) {
            throw ((RuntimeException) th2);
        }
        return th2;
    }

    protected void wrapInstantiationProblem(Throwable th, DeserializationContext deserializationContext) throws IOException {
        Throwable th2 = th;
        while ((th2 instanceof InvocationTargetException) && th2.getCause() != null) {
            th2 = th2.getCause();
        }
        if (th2 instanceof Error) {
            throw ((Error) th2);
        }
        Object obj = (deserializationContext == null || deserializationContext.isEnabled(DeserializationFeature.WRAP_EXCEPTIONS)) ? 1 : null;
        if (th2 instanceof IOException) {
            throw ((IOException) th2);
        } else if (obj == null && (th2 instanceof RuntimeException)) {
            throw ((RuntimeException) th2);
        } else {
            throw deserializationContext.instantiationException(this._beanType.getRawClass(), th2);
        }
    }
}
