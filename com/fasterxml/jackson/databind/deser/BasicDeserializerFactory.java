package com.fasterxml.jackson.databind.deser;

import com.fasterxml.jackson.annotation.JsonCreator.Mode;
import com.fasterxml.jackson.core.JsonLocation;
import com.fasterxml.jackson.databind.AnnotationIntrospector;
import com.fasterxml.jackson.databind.DeserializationConfig;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.PropertyMetadata;
import com.fasterxml.jackson.databind.PropertyName;
import com.fasterxml.jackson.databind.cfg.DeserializerFactoryConfig;
import com.fasterxml.jackson.databind.deser.impl.CreatorCollector;
import com.fasterxml.jackson.databind.deser.std.ArrayBlockingQueueDeserializer;
import com.fasterxml.jackson.databind.deser.std.AtomicReferenceDeserializer;
import com.fasterxml.jackson.databind.deser.std.CollectionDeserializer;
import com.fasterxml.jackson.databind.deser.std.DateDeserializers;
import com.fasterxml.jackson.databind.deser.std.EnumDeserializer;
import com.fasterxml.jackson.databind.deser.std.EnumMapDeserializer;
import com.fasterxml.jackson.databind.deser.std.EnumSetDeserializer;
import com.fasterxml.jackson.databind.deser.std.JsonNodeDeserializer;
import com.fasterxml.jackson.databind.deser.std.MapDeserializer;
import com.fasterxml.jackson.databind.deser.std.MapEntryDeserializer;
import com.fasterxml.jackson.databind.deser.std.NumberDeserializers;
import com.fasterxml.jackson.databind.deser.std.ObjectArrayDeserializer;
import com.fasterxml.jackson.databind.deser.std.PrimitiveArrayDeserializers;
import com.fasterxml.jackson.databind.deser.std.StdKeyDeserializers;
import com.fasterxml.jackson.databind.deser.std.StringArrayDeserializer;
import com.fasterxml.jackson.databind.deser.std.StringCollectionDeserializer;
import com.fasterxml.jackson.databind.deser.std.StringDeserializer;
import com.fasterxml.jackson.databind.deser.std.TokenBufferDeserializer;
import com.fasterxml.jackson.databind.deser.std.UntypedObjectDeserializer;
import com.fasterxml.jackson.databind.ext.OptionalHandlerFactory;
import com.fasterxml.jackson.databind.introspect.AnnotatedConstructor;
import com.fasterxml.jackson.databind.introspect.AnnotatedMember;
import com.fasterxml.jackson.databind.introspect.AnnotatedMethod;
import com.fasterxml.jackson.databind.introspect.AnnotatedParameter;
import com.fasterxml.jackson.databind.introspect.AnnotatedWithParams;
import com.fasterxml.jackson.databind.introspect.VisibilityChecker;
import com.fasterxml.jackson.databind.type.ArrayType;
import com.fasterxml.jackson.databind.type.CollectionLikeType;
import com.fasterxml.jackson.databind.type.CollectionType;
import com.fasterxml.jackson.databind.type.MapLikeType;
import com.fasterxml.jackson.databind.type.MapType;
import com.fasterxml.jackson.databind.type.TypeFactory;
import com.fasterxml.jackson.databind.util.EnumResolver;
import com.fossil.agt;
import com.fossil.agu;
import com.fossil.agv.C1635a;
import com.fossil.agy;
import com.fossil.agz;
import com.fossil.ahc;
import com.fossil.ahr;
import com.fossil.ahu;
import com.fossil.ahz;
import com.fossil.aia;
import com.fossil.aib;
import com.fossil.aie;
import com.fossil.aif;
import com.fossil.aio;
import com.fossil.aip;
import com.fossil.aiq;
import com.fossil.air;
import com.fossil.aiu;
import com.fossil.aiv;
import com.fossil.aja;
import com.fossil.ajs;
import com.fossil.aju;
import com.fossil.ami;
import com.fossil.ams;
import com.fossil.amt;
import java.io.Serializable;
import java.lang.reflect.Member;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.EnumMap;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.NavigableMap;
import java.util.Queue;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ConcurrentNavigableMap;
import java.util.concurrent.ConcurrentSkipListMap;
import java.util.concurrent.atomic.AtomicReference;

public abstract class BasicDeserializerFactory extends ahz implements Serializable {
    protected static final PropertyName UNWRAPPED_CREATOR_PARAM_NAME = new PropertyName("@JsonUnwrapped");
    static final HashMap<String, Class<? extends Collection>> _collectionFallbacks = new HashMap();
    static final HashMap<String, Class<? extends Map>> _mapFallbacks = new HashMap();
    private static final Class<?> aQI = Object.class;
    private static final Class<?> aQJ = String.class;
    private static final Class<?> aQK = CharSequence.class;
    private static final Class<?> aQL = Iterable.class;
    private static final Class<?> aQM = Entry.class;
    protected final DeserializerFactoryConfig _factoryConfig;

    protected abstract ahz withConfig(DeserializerFactoryConfig deserializerFactoryConfig);

    static {
        _mapFallbacks.put(Map.class.getName(), LinkedHashMap.class);
        _mapFallbacks.put(ConcurrentMap.class.getName(), ConcurrentHashMap.class);
        _mapFallbacks.put(SortedMap.class.getName(), TreeMap.class);
        _mapFallbacks.put(NavigableMap.class.getName(), TreeMap.class);
        _mapFallbacks.put(ConcurrentNavigableMap.class.getName(), ConcurrentSkipListMap.class);
        _collectionFallbacks.put(Collection.class.getName(), ArrayList.class);
        _collectionFallbacks.put(List.class.getName(), ArrayList.class);
        _collectionFallbacks.put(Set.class.getName(), HashSet.class);
        _collectionFallbacks.put(SortedSet.class.getName(), TreeSet.class);
        _collectionFallbacks.put(Queue.class.getName(), LinkedList.class);
        _collectionFallbacks.put("java.util.Deque", LinkedList.class);
        _collectionFallbacks.put("java.util.NavigableSet", TreeSet.class);
    }

    protected BasicDeserializerFactory(DeserializerFactoryConfig deserializerFactoryConfig) {
        this._factoryConfig = deserializerFactoryConfig;
    }

    public DeserializerFactoryConfig getFactoryConfig() {
        return this._factoryConfig;
    }

    public final ahz withAdditionalDeserializers(aia com_fossil_aia) {
        return withConfig(this._factoryConfig.withAdditionalDeserializers(com_fossil_aia));
    }

    public final ahz withAdditionalKeyDeserializers(aib com_fossil_aib) {
        return withConfig(this._factoryConfig.withAdditionalKeyDeserializers(com_fossil_aib));
    }

    public final ahz withDeserializerModifier(ahu com_fossil_ahu) {
        return withConfig(this._factoryConfig.withDeserializerModifier(com_fossil_ahu));
    }

    public final ahz withAbstractTypeResolver(agt com_fossil_agt) {
        return withConfig(this._factoryConfig.withAbstractTypeResolver(com_fossil_agt));
    }

    public final ahz withValueInstantiators(aif com_fossil_aif) {
        return withConfig(this._factoryConfig.withValueInstantiators(com_fossil_aif));
    }

    public JavaType mapAbstractType(DeserializationConfig deserializationConfig, JavaType javaType) throws JsonMappingException {
        JavaType c;
        while (true) {
            c = m2697c(deserializationConfig, javaType);
            if (c == null) {
                return javaType;
            }
            Class rawClass = javaType.getRawClass();
            Class rawClass2 = c.getRawClass();
            if (rawClass != rawClass2 && rawClass.isAssignableFrom(rawClass2)) {
                javaType = c;
            }
        }
        throw new IllegalArgumentException("Invalid abstract type resolution from " + javaType + " to " + c + ": latter is not a subtype of former");
    }

    private JavaType m2697c(DeserializationConfig deserializationConfig, JavaType javaType) throws JsonMappingException {
        Class rawClass = javaType.getRawClass();
        if (this._factoryConfig.hasAbstractTypeResolvers()) {
            for (agt a : this._factoryConfig.abstractTypeResolvers()) {
                JavaType a2 = a.m3325a(deserializationConfig, javaType);
                if (a2 != null && a2.getRawClass() != rawClass) {
                    return a2;
                }
            }
        }
        return null;
    }

    public aie findValueInstantiator(DeserializationContext deserializationContext, agu com_fossil_agu) throws JsonMappingException {
        aie com_fossil_aie;
        DeserializationConfig config = deserializationContext.getConfig();
        aie com_fossil_aie2 = null;
        aiq Dn = com_fossil_agu.Dn();
        Object findValueInstantiator = deserializationContext.getAnnotationIntrospector().findValueInstantiator(Dn);
        if (findValueInstantiator != null) {
            com_fossil_aie2 = _valueInstantiatorInstance(config, Dn, findValueInstantiator);
        }
        if (com_fossil_aie2 == null) {
            com_fossil_aie2 = m2696a(config, com_fossil_agu);
            if (com_fossil_aie2 == null) {
                com_fossil_aie2 = _constructDefaultValueInstantiator(deserializationContext, com_fossil_agu);
            }
        }
        if (this._factoryConfig.hasValueInstantiators()) {
            com_fossil_aie = com_fossil_aie2;
            for (aif com_fossil_aif : this._factoryConfig.valueInstantiators()) {
                com_fossil_aie = com_fossil_aif.m3387a(config, com_fossil_agu, com_fossil_aie);
                if (com_fossil_aie == null) {
                    throw new JsonMappingException("Broken registered ValueInstantiators (of type " + com_fossil_aif.getClass().getName() + "): returned null ValueInstantiator");
                }
            }
        }
        com_fossil_aie = com_fossil_aie2;
        if (com_fossil_aie.getIncompleteParameter() == null) {
            return com_fossil_aie;
        }
        AnnotatedParameter incompleteParameter = com_fossil_aie.getIncompleteParameter();
        throw new IllegalArgumentException("Argument #" + incompleteParameter.getIndex() + " of constructor " + incompleteParameter.getOwner() + " has no property name annotation; must have name when multiple-parameter constructor annotated as Creator");
    }

    private aie m2696a(DeserializationConfig deserializationConfig, agu com_fossil_agu) throws JsonMappingException {
        if (com_fossil_agu.getBeanClass() == JsonLocation.class) {
            return new aip();
        }
        return null;
    }

    protected aie _constructDefaultValueInstantiator(DeserializationContext deserializationContext, agu com_fossil_agu) throws JsonMappingException {
        CreatorCollector creatorCollector = new CreatorCollector(com_fossil_agu, deserializationContext.canOverrideAccessModifiers());
        AnnotationIntrospector annotationIntrospector = deserializationContext.getAnnotationIntrospector();
        DeserializationConfig config = deserializationContext.getConfig();
        VisibilityChecker findAutoDetectVisibility = annotationIntrospector.findAutoDetectVisibility(com_fossil_agu.Dn(), config.getDefaultVisibilityChecker());
        Map _findCreatorsFromProperties = _findCreatorsFromProperties(deserializationContext, com_fossil_agu);
        _addDeserializerFactoryMethods(deserializationContext, com_fossil_agu, findAutoDetectVisibility, annotationIntrospector, creatorCollector, _findCreatorsFromProperties);
        if (com_fossil_agu.getType().isConcrete()) {
            _addDeserializerConstructors(deserializationContext, com_fossil_agu, findAutoDetectVisibility, annotationIntrospector, creatorCollector, _findCreatorsFromProperties);
        }
        return creatorCollector.m2711b(config);
    }

    protected Map<AnnotatedWithParams, aiv[]> _findCreatorsFromProperties(DeserializationContext deserializationContext, agu com_fossil_agu) throws JsonMappingException {
        Map<AnnotatedWithParams, aiv[]> emptyMap = Collections.emptyMap();
        for (aiv com_fossil_aiv : com_fossil_agu.Dr()) {
            Iterator Fo = com_fossil_aiv.Fo();
            while (Fo.hasNext()) {
                Map<AnnotatedWithParams, aiv[]> linkedHashMap;
                AnnotatedParameter annotatedParameter = (AnnotatedParameter) Fo.next();
                AnnotatedWithParams owner = annotatedParameter.getOwner();
                Object obj = (aiv[]) emptyMap.get(owner);
                int index = annotatedParameter.getIndex();
                if (obj == null) {
                    if (emptyMap.isEmpty()) {
                        linkedHashMap = new LinkedHashMap();
                    } else {
                        linkedHashMap = emptyMap;
                    }
                    obj = new aiv[owner.getParameterCount()];
                    linkedHashMap.put(owner, obj);
                } else if (obj[index] != null) {
                    throw new IllegalStateException("Conflict: parameter #" + index + " of " + owner + " bound to more than one property; " + obj[index] + " vs " + com_fossil_aiv);
                } else {
                    linkedHashMap = emptyMap;
                }
                obj[index] = com_fossil_aiv;
                emptyMap = linkedHashMap;
            }
        }
        return emptyMap;
    }

    public aie _valueInstantiatorInstance(DeserializationConfig deserializationConfig, aiq com_fossil_aiq, Object obj) throws JsonMappingException {
        if (obj == null) {
            return null;
        }
        if (obj instanceof aie) {
            return (aie) obj;
        }
        if (obj instanceof Class) {
            Class cls = (Class) obj;
            if (ami.m3854D(cls)) {
                return null;
            }
            if (aie.class.isAssignableFrom(cls)) {
                ahr handlerInstantiator = deserializationConfig.getHandlerInstantiator();
                if (handlerInstantiator != null) {
                    aie c = handlerInstantiator.m3346c(deserializationConfig, com_fossil_aiq, cls);
                    if (c != null) {
                        return c;
                    }
                }
                return (aie) ami.m3863b(cls, deserializationConfig.canOverrideAccessModifiers());
            }
            throw new IllegalStateException("AnnotationIntrospector returned Class " + cls.getName() + "; expected Class<ValueInstantiator>");
        }
        throw new IllegalStateException("AnnotationIntrospector returned key deserializer definition of type " + obj.getClass().getName() + "; expected type KeyDeserializer or Class<KeyDeserializer> instead");
    }

    protected void _addDeserializerConstructors(DeserializationContext deserializationContext, agu com_fossil_agu, VisibilityChecker<?> visibilityChecker, AnnotationIntrospector annotationIntrospector, CreatorCollector creatorCollector, Map<AnnotatedWithParams, aiv[]> map) throws JsonMappingException {
        AnnotatedWithParams Dw = com_fossil_agu.Dw();
        if (Dw != null && (!creatorCollector.Ez() || annotationIntrospector.hasCreatorAnnotation(Dw))) {
            creatorCollector.m2707a(Dw);
        }
        List list = null;
        for (AnnotatedWithParams annotatedWithParams : com_fossil_agu.Du()) {
            boolean hasCreatorAnnotation = annotationIntrospector.hasCreatorAnnotation(annotatedWithParams);
            aiv[] com_fossil_aivArr = (aiv[]) map.get(annotatedWithParams);
            int parameterCount = annotatedWithParams.getParameterCount();
            PropertyName fullName;
            AnnotatedMember parameter;
            if (parameterCount == 1) {
                aiv com_fossil_aiv = com_fossil_aivArr == null ? null : com_fossil_aivArr[0];
                if (_checkIfCreatorPropertyBased(annotationIntrospector, annotatedWithParams, com_fossil_aiv)) {
                    SettableBeanProperty[] settableBeanPropertyArr = new SettableBeanProperty[1];
                    fullName = com_fossil_aiv == null ? null : com_fossil_aiv.getFullName();
                    parameter = annotatedWithParams.getParameter(0);
                    settableBeanPropertyArr[0] = constructCreatorProperty(deserializationContext, com_fossil_agu, fullName, 0, parameter, annotationIntrospector.findInjectableValueId(parameter));
                    creatorCollector.m2713b(annotatedWithParams, hasCreatorAnnotation, settableBeanPropertyArr);
                } else {
                    _handleSingleArgumentConstructor(deserializationContext, com_fossil_agu, visibilityChecker, annotationIntrospector, creatorCollector, annotatedWithParams, hasCreatorAnnotation, visibilityChecker.isCreatorVisible(annotatedWithParams));
                    if (com_fossil_aiv != null) {
                        ((aja) com_fossil_aiv).FT();
                    }
                }
            } else {
                int i;
                List list2;
                AnnotatedMember annotatedMember = null;
                SettableBeanProperty[] settableBeanPropertyArr2 = new SettableBeanProperty[parameterCount];
                int i2 = 0;
                int i3 = 0;
                int i4 = 0;
                int i5 = 0;
                while (i5 < parameterCount) {
                    int i6;
                    int i7;
                    parameter = annotatedWithParams.getParameter(i5);
                    aiv com_fossil_aiv2 = com_fossil_aivArr == null ? null : com_fossil_aivArr[i5];
                    Object findInjectableValueId = annotationIntrospector.findInjectableValueId(parameter);
                    fullName = com_fossil_aiv2 == null ? null : com_fossil_aiv2.getFullName();
                    if (com_fossil_aiv2 != null && com_fossil_aiv2.Fe()) {
                        i2++;
                        settableBeanPropertyArr2[i5] = constructCreatorProperty(deserializationContext, com_fossil_agu, fullName, i5, parameter, findInjectableValueId);
                        i = i4;
                        i6 = i3;
                        i7 = i2;
                        parameter = annotatedMember;
                    } else if (findInjectableValueId != null) {
                        i4++;
                        settableBeanPropertyArr2[i5] = constructCreatorProperty(deserializationContext, com_fossil_agu, fullName, i5, parameter, findInjectableValueId);
                        i = i4;
                        i6 = i3;
                        i7 = i2;
                        parameter = annotatedMember;
                    } else if (annotationIntrospector.findUnwrappingNameTransformer(parameter) != null) {
                        settableBeanPropertyArr2[i5] = constructCreatorProperty(deserializationContext, com_fossil_agu, UNWRAPPED_CREATOR_PARAM_NAME, i5, parameter, null);
                        i6 = i3;
                        i7 = i2 + 1;
                        parameter = annotatedMember;
                        i = i4;
                    } else if (hasCreatorAnnotation && fullName != null && !fullName.isEmpty()) {
                        i3++;
                        settableBeanPropertyArr2[i5] = constructCreatorProperty(deserializationContext, com_fossil_agu, fullName, i5, parameter, findInjectableValueId);
                        i = i4;
                        i6 = i3;
                        i7 = i2;
                        parameter = annotatedMember;
                    } else if (annotatedMember == null) {
                        i = i4;
                        i6 = i3;
                        i7 = i2;
                    } else {
                        i = i4;
                        i6 = i3;
                        i7 = i2;
                        parameter = annotatedMember;
                    }
                    i5++;
                    i4 = i;
                    i3 = i6;
                    i2 = i7;
                    annotatedMember = parameter;
                }
                i = i2 + i3;
                if (hasCreatorAnnotation || i2 > 0 || i4 > 0) {
                    if (i + i4 == parameterCount) {
                        creatorCollector.m2713b(annotatedWithParams, hasCreatorAnnotation, settableBeanPropertyArr2);
                    } else if (i2 == 0 && i4 + 1 == parameterCount) {
                        creatorCollector.m2710a(annotatedWithParams, hasCreatorAnnotation, settableBeanPropertyArr2);
                    } else {
                        PropertyName _findImplicitParamName = _findImplicitParamName(annotatedMember, annotationIntrospector);
                        if (_findImplicitParamName == null || _findImplicitParamName.isEmpty()) {
                            i = annotatedMember.getIndex();
                            if (i == 0 && ami.m3855E(annotatedWithParams.getDeclaringClass())) {
                                throw new IllegalArgumentException("Non-static inner classes like " + annotatedWithParams.getDeclaringClass().getName() + " can not use @JsonCreator for constructors");
                            }
                            throw new IllegalArgumentException("Argument #" + i + " of constructor " + annotatedWithParams + " has no property name annotation; must have name when multiple-parameter constructor annotated as Creator");
                        }
                    }
                }
                if (creatorCollector.Ez()) {
                    list2 = list;
                } else {
                    if (list == null) {
                        list2 = new LinkedList();
                    } else {
                        list2 = list;
                    }
                    list2.add(annotatedWithParams);
                }
                list = list2;
            }
        }
        if (list != null && !creatorCollector.EA() && !creatorCollector.EB()) {
            _checkImplicitlyNamedConstructors(deserializationContext, com_fossil_agu, visibilityChecker, annotationIntrospector, creatorCollector, list);
        }
    }

    protected void _checkImplicitlyNamedConstructors(DeserializationContext deserializationContext, agu com_fossil_agu, VisibilityChecker<?> visibilityChecker, AnnotationIntrospector annotationIntrospector, CreatorCollector creatorCollector, List<AnnotatedConstructor> list) throws JsonMappingException {
        PropertyName _findParamName;
        SettableBeanProperty[] settableBeanPropertyArr = null;
        AnnotatedWithParams annotatedWithParams = null;
        for (AnnotatedWithParams annotatedWithParams2 : list) {
            if (visibilityChecker.isCreatorVisible(annotatedWithParams2)) {
                int parameterCount = annotatedWithParams2.getParameterCount();
                SettableBeanProperty[] settableBeanPropertyArr2 = new SettableBeanProperty[parameterCount];
                for (int i = 0; i < parameterCount; i++) {
                    AnnotatedParameter parameter = annotatedWithParams2.getParameter(i);
                    _findParamName = _findParamName(parameter, annotationIntrospector);
                    if (_findParamName == null || _findParamName.isEmpty()) {
                        break;
                    }
                    settableBeanPropertyArr2[i] = constructCreatorProperty(deserializationContext, com_fossil_agu, _findParamName, parameter.getIndex(), parameter, null);
                }
                if (annotatedWithParams != null) {
                    annotatedWithParams = null;
                    break;
                } else {
                    settableBeanPropertyArr = settableBeanPropertyArr2;
                    annotatedWithParams = annotatedWithParams2;
                }
            }
        }
        if (annotatedWithParams != null) {
            creatorCollector.m2713b(annotatedWithParams, false, settableBeanPropertyArr);
            aiu com_fossil_aiu = (aiu) com_fossil_agu;
            for (SettableBeanProperty settableBeanProperty : settableBeanPropertyArr) {
                _findParamName = settableBeanProperty.getFullName();
                if (!com_fossil_aiu.m3459a(_findParamName)) {
                    com_fossil_aiu.m3460a(ams.m3896a(deserializationContext.getConfig(), settableBeanProperty.getMember(), _findParamName));
                }
            }
        }
    }

    protected boolean _checkIfCreatorPropertyBased(AnnotationIntrospector annotationIntrospector, AnnotatedWithParams annotatedWithParams, aiv com_fossil_aiv) {
        Mode findCreatorBinding = annotationIntrospector.findCreatorBinding(annotatedWithParams);
        if (findCreatorBinding == Mode.PROPERTIES) {
            return true;
        }
        if (findCreatorBinding == Mode.DELEGATING) {
            return false;
        }
        if ((com_fossil_aiv != null && com_fossil_aiv.Fe()) || annotationIntrospector.findInjectableValueId(annotatedWithParams.getParameter(0)) != null) {
            return true;
        }
        if (com_fossil_aiv != null) {
            String name = com_fossil_aiv.getName();
            if (!(name == null || name.isEmpty() || !com_fossil_aiv.Fg())) {
                return true;
            }
        }
        return false;
    }

    protected boolean _handleSingleArgumentConstructor(DeserializationContext deserializationContext, agu com_fossil_agu, VisibilityChecker<?> visibilityChecker, AnnotationIntrospector annotationIntrospector, CreatorCollector creatorCollector, AnnotatedConstructor annotatedConstructor, boolean z, boolean z2) throws JsonMappingException {
        Class rawParameterType = annotatedConstructor.getRawParameterType(0);
        if (rawParameterType == String.class || rawParameterType == CharSequence.class) {
            if (!z && !z2) {
                return true;
            }
            creatorCollector.m2709a(annotatedConstructor, z);
            return true;
        } else if (rawParameterType == Integer.TYPE || rawParameterType == Integer.class) {
            if (!z && !z2) {
                return true;
            }
            creatorCollector.m2712b(annotatedConstructor, z);
            return true;
        } else if (rawParameterType == Long.TYPE || rawParameterType == Long.class) {
            if (!z && !z2) {
                return true;
            }
            creatorCollector.m2714c(annotatedConstructor, z);
            return true;
        } else if (rawParameterType == Double.TYPE || rawParameterType == Double.class) {
            if (!z && !z2) {
                return true;
            }
            creatorCollector.m2715d(annotatedConstructor, z);
            return true;
        } else if (rawParameterType == Boolean.TYPE || rawParameterType == Boolean.class) {
            if (!z && !z2) {
                return true;
            }
            creatorCollector.m2716e(annotatedConstructor, z);
            return true;
        } else if (!z) {
            return false;
        } else {
            creatorCollector.m2710a((AnnotatedWithParams) annotatedConstructor, z, null);
            return true;
        }
    }

    protected void _addDeserializerFactoryMethods(DeserializationContext deserializationContext, agu com_fossil_agu, VisibilityChecker<?> visibilityChecker, AnnotationIntrospector annotationIntrospector, CreatorCollector creatorCollector, Map<AnnotatedWithParams, aiv[]> map) throws JsonMappingException {
        DeserializationConfig config = deserializationContext.getConfig();
        for (AnnotatedWithParams annotatedWithParams : com_fossil_agu.Dv()) {
            boolean hasCreatorAnnotation = annotationIntrospector.hasCreatorAnnotation(annotatedWithParams);
            int parameterCount = annotatedWithParams.getParameterCount();
            if (parameterCount != 0) {
                aiv[] com_fossil_aivArr = (aiv[]) map.get(annotatedWithParams);
                if (parameterCount == 1) {
                    aiv com_fossil_aiv;
                    if (com_fossil_aivArr == null) {
                        com_fossil_aiv = null;
                    } else {
                        com_fossil_aiv = com_fossil_aivArr[0];
                    }
                    if (!_checkIfCreatorPropertyBased(annotationIntrospector, annotatedWithParams, com_fossil_aiv)) {
                        _handleSingleArgumentFactory(config, com_fossil_agu, visibilityChecker, annotationIntrospector, creatorCollector, annotatedWithParams, hasCreatorAnnotation);
                    }
                } else if (!hasCreatorAnnotation) {
                    continue;
                }
                AnnotatedMember annotatedMember = null;
                SettableBeanProperty[] settableBeanPropertyArr = new SettableBeanProperty[parameterCount];
                int i = 0;
                int i2 = 0;
                int i3 = 0;
                int i4 = 0;
                while (i4 < parameterCount) {
                    AnnotatedMember parameter = annotatedWithParams.getParameter(i4);
                    aiv com_fossil_aiv2 = com_fossil_aivArr == null ? null : com_fossil_aivArr[i4];
                    Object findInjectableValueId = annotationIntrospector.findInjectableValueId(parameter);
                    PropertyName fullName = com_fossil_aiv2 == null ? null : com_fossil_aiv2.getFullName();
                    if (com_fossil_aiv2 != null && com_fossil_aiv2.Fe()) {
                        i2++;
                        settableBeanPropertyArr[i4] = constructCreatorProperty(deserializationContext, com_fossil_agu, fullName, i4, parameter, findInjectableValueId);
                        parameter = annotatedMember;
                    } else if (findInjectableValueId != null) {
                        i3++;
                        settableBeanPropertyArr[i4] = constructCreatorProperty(deserializationContext, com_fossil_agu, fullName, i4, parameter, findInjectableValueId);
                        parameter = annotatedMember;
                    } else if (annotationIntrospector.findUnwrappingNameTransformer(parameter) != null) {
                        settableBeanPropertyArr[i4] = constructCreatorProperty(deserializationContext, com_fossil_agu, UNWRAPPED_CREATOR_PARAM_NAME, i4, parameter, null);
                        i++;
                        parameter = annotatedMember;
                    } else if (hasCreatorAnnotation && fullName != null && !fullName.isEmpty()) {
                        i++;
                        settableBeanPropertyArr[i4] = constructCreatorProperty(deserializationContext, com_fossil_agu, fullName, i4, parameter, findInjectableValueId);
                        parameter = annotatedMember;
                    } else if (annotatedMember != null) {
                        parameter = annotatedMember;
                    }
                    i4++;
                    annotatedMember = parameter;
                }
                int i5 = i2 + i;
                if (hasCreatorAnnotation || i2 > 0 || i3 > 0) {
                    if (i5 + i3 == parameterCount) {
                        creatorCollector.m2713b(annotatedWithParams, hasCreatorAnnotation, settableBeanPropertyArr);
                    } else if (i2 == 0 && i3 + 1 == parameterCount) {
                        creatorCollector.m2710a(annotatedWithParams, hasCreatorAnnotation, settableBeanPropertyArr);
                    } else {
                        throw new IllegalArgumentException("Argument #" + annotatedMember.getIndex() + " of factory method " + annotatedWithParams + " has no property name annotation; must have name when multiple-parameter constructor annotated as Creator");
                    }
                }
            } else if (hasCreatorAnnotation) {
                creatorCollector.m2707a(annotatedWithParams);
            }
        }
    }

    protected boolean _handleSingleArgumentFactory(DeserializationConfig deserializationConfig, agu com_fossil_agu, VisibilityChecker<?> visibilityChecker, AnnotationIntrospector annotationIntrospector, CreatorCollector creatorCollector, AnnotatedMethod annotatedMethod, boolean z) throws JsonMappingException {
        Class rawParameterType = annotatedMethod.getRawParameterType(0);
        if (rawParameterType == String.class || rawParameterType == CharSequence.class) {
            if (!z && !visibilityChecker.isCreatorVisible(annotatedMethod)) {
                return true;
            }
            creatorCollector.m2709a(annotatedMethod, z);
            return true;
        } else if (rawParameterType == Integer.TYPE || rawParameterType == Integer.class) {
            if (!z && !visibilityChecker.isCreatorVisible(annotatedMethod)) {
                return true;
            }
            creatorCollector.m2712b(annotatedMethod, z);
            return true;
        } else if (rawParameterType == Long.TYPE || rawParameterType == Long.class) {
            if (!z && !visibilityChecker.isCreatorVisible(annotatedMethod)) {
                return true;
            }
            creatorCollector.m2714c(annotatedMethod, z);
            return true;
        } else if (rawParameterType == Double.TYPE || rawParameterType == Double.class) {
            if (!z && !visibilityChecker.isCreatorVisible(annotatedMethod)) {
                return true;
            }
            creatorCollector.m2715d(annotatedMethod, z);
            return true;
        } else if (rawParameterType == Boolean.TYPE || rawParameterType == Boolean.class) {
            if (!z && !visibilityChecker.isCreatorVisible(annotatedMethod)) {
                return true;
            }
            creatorCollector.m2716e(annotatedMethod, z);
            return true;
        } else if (!z) {
            return false;
        } else {
            creatorCollector.m2710a((AnnotatedWithParams) annotatedMethod, z, null);
            return true;
        }
    }

    protected SettableBeanProperty constructCreatorProperty(DeserializationContext deserializationContext, agu com_fossil_agu, PropertyName propertyName, int i, AnnotatedParameter annotatedParameter, Object obj) throws JsonMappingException {
        PropertyMetadata propertyMetadata;
        C1635a a;
        ajs findTypeDeserializer;
        DeserializationConfig config = deserializationContext.getConfig();
        AnnotationIntrospector annotationIntrospector = deserializationContext.getAnnotationIntrospector();
        if (annotationIntrospector == null) {
            propertyMetadata = PropertyMetadata.STD_REQUIRED_OR_OPTIONAL;
        } else {
            Boolean hasRequiredMarker = annotationIntrospector.hasRequiredMarker(annotatedParameter);
            boolean z = hasRequiredMarker != null && hasRequiredMarker.booleanValue();
            propertyMetadata = PropertyMetadata.construct(z, annotationIntrospector.findPropertyDescription(annotatedParameter), annotationIntrospector.findPropertyIndex(annotatedParameter), annotationIntrospector.findPropertyDefaultValue(annotatedParameter));
        }
        JavaType constructType = config.getTypeFactory().constructType(annotatedParameter.getParameterType(), com_fossil_agu.Dp());
        C1635a c1635a = new C1635a(propertyName, constructType, annotationIntrospector.findWrapperName(annotatedParameter), com_fossil_agu.Dq(), annotatedParameter, propertyMetadata);
        JavaType resolveType = resolveType(deserializationContext, com_fossil_agu, constructType, annotatedParameter);
        if (resolveType != constructType) {
            a = c1635a.m3334a(resolveType);
        } else {
            a = c1635a;
        }
        agy findDeserializerFromAnnotation = findDeserializerFromAnnotation(deserializationContext, annotatedParameter);
        JavaType modifyTypeByAnnotation = modifyTypeByAnnotation(deserializationContext, annotatedParameter, resolveType);
        ajs com_fossil_ajs = (ajs) modifyTypeByAnnotation.getTypeHandler();
        if (com_fossil_ajs == null) {
            findTypeDeserializer = findTypeDeserializer(config, modifyTypeByAnnotation);
        } else {
            findTypeDeserializer = com_fossil_ajs;
        }
        SettableBeanProperty creatorProperty = new CreatorProperty(propertyName, modifyTypeByAnnotation, a.getWrapperName(), findTypeDeserializer, com_fossil_agu.Dq(), annotatedParameter, i, obj, propertyMetadata);
        if (findDeserializerFromAnnotation != null) {
            return creatorProperty.withValueDeserializer(deserializationContext.handlePrimaryContextualization(findDeserializerFromAnnotation, creatorProperty, modifyTypeByAnnotation));
        }
        return creatorProperty;
    }

    protected PropertyName _findParamName(AnnotatedParameter annotatedParameter, AnnotationIntrospector annotationIntrospector) {
        if (!(annotatedParameter == null || annotationIntrospector == null)) {
            PropertyName findNameForDeserialization = annotationIntrospector.findNameForDeserialization(annotatedParameter);
            if (findNameForDeserialization != null) {
                return findNameForDeserialization;
            }
            String findImplicitPropertyName = annotationIntrospector.findImplicitPropertyName(annotatedParameter);
            if (!(findImplicitPropertyName == null || findImplicitPropertyName.isEmpty())) {
                return PropertyName.construct(findImplicitPropertyName);
            }
        }
        return null;
    }

    protected PropertyName _findImplicitParamName(AnnotatedParameter annotatedParameter, AnnotationIntrospector annotationIntrospector) {
        String findImplicitPropertyName = annotationIntrospector.findImplicitPropertyName(annotatedParameter);
        if (findImplicitPropertyName == null || findImplicitPropertyName.isEmpty()) {
            return null;
        }
        return PropertyName.construct(findImplicitPropertyName);
    }

    @Deprecated
    protected PropertyName _findExplicitParamName(AnnotatedParameter annotatedParameter, AnnotationIntrospector annotationIntrospector) {
        if (annotatedParameter == null || annotationIntrospector == null) {
            return null;
        }
        return annotationIntrospector.findNameForDeserialization(annotatedParameter);
    }

    @Deprecated
    protected boolean _hasExplicitParamName(AnnotatedParameter annotatedParameter, AnnotationIntrospector annotationIntrospector) {
        if (annotatedParameter == null || annotationIntrospector == null) {
            return false;
        }
        PropertyName findNameForDeserialization = annotationIntrospector.findNameForDeserialization(annotatedParameter);
        if (findNameForDeserialization == null || !findNameForDeserialization.hasSimpleName()) {
            return false;
        }
        return true;
    }

    public agy<?> createArrayDeserializer(DeserializationContext deserializationContext, ArrayType arrayType, agu com_fossil_agu) throws JsonMappingException {
        ajs findTypeDeserializer;
        DeserializationConfig config = deserializationContext.getConfig();
        JavaType contentType = arrayType.getContentType();
        agy com_fossil_agy = (agy) contentType.getValueHandler();
        ajs com_fossil_ajs = (ajs) contentType.getTypeHandler();
        if (com_fossil_ajs == null) {
            findTypeDeserializer = findTypeDeserializer(config, contentType);
        } else {
            findTypeDeserializer = com_fossil_ajs;
        }
        agy<?> _findCustomArrayDeserializer = _findCustomArrayDeserializer(arrayType, config, com_fossil_agu, findTypeDeserializer, com_fossil_agy);
        if (_findCustomArrayDeserializer == null) {
            if (com_fossil_agy == null) {
                Class rawClass = contentType.getRawClass();
                if (contentType.isPrimitive()) {
                    return PrimitiveArrayDeserializers.forType(rawClass);
                }
                if (rawClass == String.class) {
                    return StringArrayDeserializer.instance;
                }
            }
            _findCustomArrayDeserializer = new ObjectArrayDeserializer(arrayType, com_fossil_agy, findTypeDeserializer);
        }
        if (!this._factoryConfig.hasDeserializerModifiers()) {
            return _findCustomArrayDeserializer;
        }
        agy com_fossil_agy2 = _findCustomArrayDeserializer;
        for (ahu a : this._factoryConfig.deserializerModifiers()) {
            agy<?> a2 = a.m3362a(config, arrayType, com_fossil_agu, com_fossil_agy2);
        }
        return com_fossil_agy2;
    }

    public agy<?> createCollectionDeserializer(DeserializationContext deserializationContext, CollectionType collectionType, agu com_fossil_agu) throws JsonMappingException {
        ajs findTypeDeserializer;
        CollectionType _mapAbstractCollectionType;
        agy<?> com_fossil_agy_;
        JavaType contentType = collectionType.getContentType();
        agy com_fossil_agy = (agy) contentType.getValueHandler();
        DeserializationConfig config = deserializationContext.getConfig();
        ajs com_fossil_ajs = (ajs) contentType.getTypeHandler();
        if (com_fossil_ajs == null) {
            findTypeDeserializer = findTypeDeserializer(config, contentType);
        } else {
            findTypeDeserializer = com_fossil_ajs;
        }
        agy<?> _findCustomCollectionDeserializer = _findCustomCollectionDeserializer(collectionType, config, com_fossil_agu, findTypeDeserializer, com_fossil_agy);
        if (_findCustomCollectionDeserializer == null) {
            Class rawClass = collectionType.getRawClass();
            if (com_fossil_agy == null && EnumSet.class.isAssignableFrom(rawClass)) {
                _findCustomCollectionDeserializer = new EnumSetDeserializer(contentType, null);
            }
        }
        if (_findCustomCollectionDeserializer == null) {
            if (collectionType.isInterface() || collectionType.isAbstract()) {
                _mapAbstractCollectionType = _mapAbstractCollectionType(collectionType, config);
                if (_mapAbstractCollectionType != null) {
                    com_fossil_agu = config.introspectForCreation(_mapAbstractCollectionType);
                } else if (collectionType.getTypeHandler() == null) {
                    throw new IllegalArgumentException("Can not find a deserializer for non-concrete Collection type " + collectionType);
                } else {
                    _findCustomCollectionDeserializer = AbstractDeserializer.constructForNonPOJO(com_fossil_agu);
                    _mapAbstractCollectionType = collectionType;
                }
            } else {
                _mapAbstractCollectionType = collectionType;
            }
            if (_findCustomCollectionDeserializer == null) {
                aie findValueInstantiator = findValueInstantiator(deserializationContext, com_fossil_agu);
                if (!findValueInstantiator.canCreateUsingDefault() && _mapAbstractCollectionType.getRawClass() == ArrayBlockingQueue.class) {
                    return new ArrayBlockingQueueDeserializer(_mapAbstractCollectionType, com_fossil_agy, findTypeDeserializer, findValueInstantiator, null);
                }
                if (contentType.getRawClass() == String.class) {
                    _findCustomCollectionDeserializer = new StringCollectionDeserializer(_mapAbstractCollectionType, com_fossil_agy, findValueInstantiator);
                } else {
                    _findCustomCollectionDeserializer = new CollectionDeserializer(_mapAbstractCollectionType, com_fossil_agy, findTypeDeserializer, findValueInstantiator);
                }
            }
        } else {
            _mapAbstractCollectionType = collectionType;
        }
        if (this._factoryConfig.hasDeserializerModifiers()) {
            com_fossil_agy_ = _findCustomCollectionDeserializer;
            for (ahu a : this._factoryConfig.deserializerModifiers()) {
                com_fossil_agy_ = a.m3364a(config, _mapAbstractCollectionType, com_fossil_agu, (agy) com_fossil_agy_);
            }
        } else {
            com_fossil_agy_ = _findCustomCollectionDeserializer;
        }
        return com_fossil_agy_;
    }

    protected CollectionType _mapAbstractCollectionType(JavaType javaType, DeserializationConfig deserializationConfig) {
        Class cls = (Class) _collectionFallbacks.get(javaType.getRawClass().getName());
        if (cls == null) {
            return null;
        }
        return (CollectionType) deserializationConfig.constructSpecializedType(javaType, cls);
    }

    public agy<?> createCollectionLikeDeserializer(DeserializationContext deserializationContext, CollectionLikeType collectionLikeType, agu com_fossil_agu) throws JsonMappingException {
        ajs findTypeDeserializer;
        JavaType contentType = collectionLikeType.getContentType();
        agy com_fossil_agy = (agy) contentType.getValueHandler();
        DeserializationConfig config = deserializationContext.getConfig();
        ajs com_fossil_ajs = (ajs) contentType.getTypeHandler();
        if (com_fossil_ajs == null) {
            findTypeDeserializer = findTypeDeserializer(config, contentType);
        } else {
            findTypeDeserializer = com_fossil_ajs;
        }
        agy<?> _findCustomCollectionLikeDeserializer = _findCustomCollectionLikeDeserializer(collectionLikeType, config, com_fossil_agu, findTypeDeserializer, com_fossil_agy);
        if (_findCustomCollectionLikeDeserializer == null || !this._factoryConfig.hasDeserializerModifiers()) {
            return _findCustomCollectionLikeDeserializer;
        }
        agy<?> com_fossil_agy_ = _findCustomCollectionLikeDeserializer;
        for (ahu a : this._factoryConfig.deserializerModifiers()) {
            com_fossil_agy_ = a.m3363a(config, collectionLikeType, com_fossil_agu, (agy) com_fossil_agy_);
        }
        return com_fossil_agy_;
    }

    public agy<?> createMapDeserializer(DeserializationContext deserializationContext, MapType mapType, agu com_fossil_agu) throws JsonMappingException {
        ajs findTypeDeserializer;
        MapType mapType2;
        DeserializationConfig config = deserializationContext.getConfig();
        JavaType keyType = mapType.getKeyType();
        JavaType contentType = mapType.getContentType();
        agy com_fossil_agy = (agy) contentType.getValueHandler();
        ahc com_fossil_ahc = (ahc) keyType.getValueHandler();
        ajs com_fossil_ajs = (ajs) contentType.getTypeHandler();
        if (com_fossil_ajs == null) {
            findTypeDeserializer = findTypeDeserializer(config, contentType);
        } else {
            findTypeDeserializer = com_fossil_ajs;
        }
        agy<?> _findCustomMapDeserializer = _findCustomMapDeserializer(mapType, config, com_fossil_agu, com_fossil_ahc, findTypeDeserializer, com_fossil_agy);
        if (_findCustomMapDeserializer == null) {
            Class rawClass = mapType.getRawClass();
            if (EnumMap.class.isAssignableFrom(rawClass)) {
                Class rawClass2 = keyType.getRawClass();
                if (rawClass2 == null || !rawClass2.isEnum()) {
                    throw new IllegalArgumentException("Can not construct EnumMap; generic (key) type not available");
                }
                _findCustomMapDeserializer = new EnumMapDeserializer(mapType, null, com_fossil_agy, findTypeDeserializer);
            }
            if (_findCustomMapDeserializer == null) {
                if (mapType.isInterface() || mapType.isAbstract()) {
                    rawClass = (Class) _mapFallbacks.get(rawClass.getName());
                    if (rawClass != null) {
                        MapType mapType3 = (MapType) config.constructSpecializedType(mapType, rawClass);
                        com_fossil_agu = config.introspectForCreation(mapType3);
                        mapType2 = mapType3;
                    } else if (mapType.getTypeHandler() == null) {
                        throw new IllegalArgumentException("Can not find a deserializer for non-concrete Map type " + mapType);
                    } else {
                        _findCustomMapDeserializer = AbstractDeserializer.constructForNonPOJO(com_fossil_agu);
                        mapType2 = mapType;
                    }
                } else {
                    mapType2 = mapType;
                }
                if (_findCustomMapDeserializer == null) {
                    _findCustomMapDeserializer = new MapDeserializer((JavaType) mapType2, findValueInstantiator(deserializationContext, com_fossil_agu), com_fossil_ahc, com_fossil_agy, findTypeDeserializer);
                    _findCustomMapDeserializer.setIgnorableProperties(config.getAnnotationIntrospector().findPropertiesToIgnore(com_fossil_agu.Dn(), false));
                }
                if (this._factoryConfig.hasDeserializerModifiers()) {
                    for (ahu a : this._factoryConfig.deserializerModifiers()) {
                        _findCustomMapDeserializer = a.m3366a(config, mapType2, com_fossil_agu, (agy) _findCustomMapDeserializer);
                    }
                }
                return _findCustomMapDeserializer;
            }
        }
        mapType2 = mapType;
        if (this._factoryConfig.hasDeserializerModifiers()) {
            while (r2.hasNext()) {
                _findCustomMapDeserializer = a.m3366a(config, mapType2, com_fossil_agu, (agy) _findCustomMapDeserializer);
            }
        }
        return _findCustomMapDeserializer;
    }

    public agy<?> createMapLikeDeserializer(DeserializationContext deserializationContext, MapLikeType mapLikeType, agu com_fossil_agu) throws JsonMappingException {
        ajs findTypeDeserializer;
        JavaType keyType = mapLikeType.getKeyType();
        JavaType contentType = mapLikeType.getContentType();
        DeserializationConfig config = deserializationContext.getConfig();
        agy com_fossil_agy = (agy) contentType.getValueHandler();
        ahc com_fossil_ahc = (ahc) keyType.getValueHandler();
        ajs com_fossil_ajs = (ajs) contentType.getTypeHandler();
        if (com_fossil_ajs == null) {
            findTypeDeserializer = findTypeDeserializer(config, contentType);
        } else {
            findTypeDeserializer = com_fossil_ajs;
        }
        agy<?> _findCustomMapLikeDeserializer = _findCustomMapLikeDeserializer(mapLikeType, config, com_fossil_agu, com_fossil_ahc, findTypeDeserializer, com_fossil_agy);
        if (_findCustomMapLikeDeserializer == null || !this._factoryConfig.hasDeserializerModifiers()) {
            return _findCustomMapLikeDeserializer;
        }
        agy<?> com_fossil_agy_ = _findCustomMapLikeDeserializer;
        for (ahu a : this._factoryConfig.deserializerModifiers()) {
            com_fossil_agy_ = a.m3365a(config, mapLikeType, com_fossil_agu, (agy) com_fossil_agy_);
        }
        return com_fossil_agy_;
    }

    public agy<?> createEnumDeserializer(DeserializationContext deserializationContext, JavaType javaType, agu com_fossil_agu) throws JsonMappingException {
        agy<?> deserializerForCreator;
        DeserializationConfig config = deserializationContext.getConfig();
        Class rawClass = javaType.getRawClass();
        agy<?> _findCustomEnumDeserializer = _findCustomEnumDeserializer(rawClass, config, com_fossil_agu);
        if (_findCustomEnumDeserializer == null) {
            for (AnnotatedMethod annotatedMethod : com_fossil_agu.Dv()) {
                if (deserializationContext.getAnnotationIntrospector().hasCreatorAnnotation(annotatedMethod)) {
                    if (annotatedMethod.getParameterCount() == 1 && annotatedMethod.getRawReturnType().isAssignableFrom(rawClass)) {
                        deserializerForCreator = EnumDeserializer.deserializerForCreator(config, rawClass, annotatedMethod);
                        if (deserializerForCreator == null) {
                            deserializerForCreator = new EnumDeserializer(constructEnumResolver(rawClass, config, com_fossil_agu.Dz()));
                        }
                    } else {
                        throw new IllegalArgumentException("Unsuitable method (" + annotatedMethod + ") decorated with @JsonCreator (for Enum type " + rawClass.getName() + ")");
                    }
                }
            }
            deserializerForCreator = _findCustomEnumDeserializer;
            if (deserializerForCreator == null) {
                deserializerForCreator = new EnumDeserializer(constructEnumResolver(rawClass, config, com_fossil_agu.Dz()));
            }
        } else {
            deserializerForCreator = _findCustomEnumDeserializer;
        }
        if (!this._factoryConfig.hasDeserializerModifiers()) {
            return deserializerForCreator;
        }
        agy com_fossil_agy = deserializerForCreator;
        for (ahu a : this._factoryConfig.deserializerModifiers()) {
            _findCustomEnumDeserializer = a.m3361a(config, javaType, com_fossil_agu, com_fossil_agy);
        }
        return com_fossil_agy;
    }

    public agy<?> createTreeDeserializer(DeserializationConfig deserializationConfig, JavaType javaType, agu com_fossil_agu) throws JsonMappingException {
        Class rawClass = javaType.getRawClass();
        agy<?> _findCustomTreeNodeDeserializer = _findCustomTreeNodeDeserializer(rawClass, deserializationConfig, com_fossil_agu);
        return _findCustomTreeNodeDeserializer != null ? _findCustomTreeNodeDeserializer : JsonNodeDeserializer.getDeserializer(rawClass);
    }

    public ajs findTypeDeserializer(DeserializationConfig deserializationConfig, JavaType javaType) throws JsonMappingException {
        Collection collection = null;
        air Dn = deserializationConfig.introspectClassAnnotations(javaType.getRawClass()).Dn();
        aju findTypeResolver = deserializationConfig.getAnnotationIntrospector().findTypeResolver(deserializationConfig, Dn, javaType);
        if (findTypeResolver == null) {
            findTypeResolver = deserializationConfig.getDefaultTyper(javaType);
            if (findTypeResolver == null) {
                return null;
            }
        }
        collection = deserializationConfig.getSubtypeResolver().collectAndResolveSubtypesByTypeId(deserializationConfig, Dn);
        if (findTypeResolver.getDefaultImpl() == null && javaType.isAbstract()) {
            JavaType mapAbstractType = mapAbstractType(deserializationConfig, javaType);
            if (!(mapAbstractType == null || mapAbstractType.getRawClass() == javaType.getRawClass())) {
                findTypeResolver = findTypeResolver.defaultImpl(mapAbstractType.getRawClass());
            }
        }
        return findTypeResolver.buildTypeDeserializer(deserializationConfig, javaType, collection);
    }

    protected agy<?> findOptionalStdDeserializer(DeserializationContext deserializationContext, JavaType javaType, agu com_fossil_agu) throws JsonMappingException {
        return OptionalHandlerFactory.instance.findDeserializer(javaType, deserializationContext.getConfig(), com_fossil_agu);
    }

    public ahc createKeyDeserializer(DeserializationContext deserializationContext, JavaType javaType) throws JsonMappingException {
        DeserializationConfig config = deserializationContext.getConfig();
        ahc com_fossil_ahc = null;
        if (this._factoryConfig.hasKeyDeserializers()) {
            agu introspectClassAnnotations = config.introspectClassAnnotations(javaType.getRawClass());
            for (aib findKeyDeserializer : this._factoryConfig.keyDeserializers()) {
                com_fossil_ahc = findKeyDeserializer.findKeyDeserializer(javaType, config, introspectClassAnnotations);
                if (com_fossil_ahc != null) {
                    break;
                }
            }
        }
        if (com_fossil_ahc == null) {
            if (javaType.isEnumType()) {
                return m2695a(deserializationContext, javaType);
            }
            com_fossil_ahc = StdKeyDeserializers.findStringBasedKeyDeserializer(config, javaType);
        }
        if (com_fossil_ahc == null || !this._factoryConfig.hasDeserializerModifiers()) {
            return com_fossil_ahc;
        }
        ahc com_fossil_ahc2 = com_fossil_ahc;
        for (ahu a : this._factoryConfig.deserializerModifiers()) {
            com_fossil_ahc2 = a.m3368a(config, javaType, com_fossil_ahc2);
        }
        return com_fossil_ahc2;
    }

    private ahc m2695a(DeserializationContext deserializationContext, JavaType javaType) throws JsonMappingException {
        DeserializationConfig config = deserializationContext.getConfig();
        agu introspect = config.introspect(javaType);
        agy findDeserializerFromAnnotation = findDeserializerFromAnnotation(deserializationContext, introspect.Dn());
        if (findDeserializerFromAnnotation != null) {
            return StdKeyDeserializers.constructDelegatingKeyDeserializer(config, javaType, findDeserializerFromAnnotation);
        }
        Class rawClass = javaType.getRawClass();
        agy _findCustomEnumDeserializer = _findCustomEnumDeserializer(rawClass, config, introspect);
        if (_findCustomEnumDeserializer != null) {
            return StdKeyDeserializers.constructDelegatingKeyDeserializer(config, javaType, _findCustomEnumDeserializer);
        }
        EnumResolver constructEnumResolver = constructEnumResolver(rawClass, config, introspect.Dz());
        for (AnnotatedMethod annotatedMethod : introspect.Dv()) {
            if (config.getAnnotationIntrospector().hasCreatorAnnotation(annotatedMethod)) {
                if (annotatedMethod.getParameterCount() != 1 || !annotatedMethod.getRawReturnType().isAssignableFrom(rawClass)) {
                    throw new IllegalArgumentException("Unsuitable method (" + annotatedMethod + ") decorated with @JsonCreator (for Enum type " + rawClass.getName() + ")");
                } else if (annotatedMethod.getGenericParameterType(0) != String.class) {
                    throw new IllegalArgumentException("Parameter #0 type for factory method (" + annotatedMethod + ") not suitable, must be java.lang.String");
                } else {
                    if (config.canOverrideAccessModifiers()) {
                        ami.m3862a(annotatedMethod.getMember());
                    }
                    return StdKeyDeserializers.constructEnumKeyDeserializer(constructEnumResolver, annotatedMethod);
                }
            }
        }
        return StdKeyDeserializers.constructEnumKeyDeserializer(constructEnumResolver);
    }

    public ajs findPropertyTypeDeserializer(DeserializationConfig deserializationConfig, JavaType javaType, AnnotatedMember annotatedMember) throws JsonMappingException {
        aju findPropertyTypeResolver = deserializationConfig.getAnnotationIntrospector().findPropertyTypeResolver(deserializationConfig, annotatedMember, javaType);
        if (findPropertyTypeResolver == null) {
            return findTypeDeserializer(deserializationConfig, javaType);
        }
        return findPropertyTypeResolver.buildTypeDeserializer(deserializationConfig, javaType, deserializationConfig.getSubtypeResolver().collectAndResolveSubtypesByTypeId(deserializationConfig, annotatedMember, javaType));
    }

    public ajs findPropertyContentTypeDeserializer(DeserializationConfig deserializationConfig, JavaType javaType, AnnotatedMember annotatedMember) throws JsonMappingException {
        aju findPropertyContentTypeResolver = deserializationConfig.getAnnotationIntrospector().findPropertyContentTypeResolver(deserializationConfig, annotatedMember, javaType);
        JavaType contentType = javaType.getContentType();
        if (findPropertyContentTypeResolver == null) {
            return findTypeDeserializer(deserializationConfig, contentType);
        }
        return findPropertyContentTypeResolver.buildTypeDeserializer(deserializationConfig, contentType, deserializationConfig.getSubtypeResolver().collectAndResolveSubtypesByTypeId(deserializationConfig, annotatedMember, contentType));
    }

    public agy<?> findDefaultDeserializer(DeserializationContext deserializationContext, JavaType javaType, agu com_fossil_agu) throws JsonMappingException {
        Class rawClass = javaType.getRawClass();
        JavaType _findRemappedType;
        JavaType _findRemappedType2;
        if (rawClass == aQI) {
            DeserializationConfig config = deserializationContext.getConfig();
            if (this._factoryConfig.hasAbstractTypeResolvers()) {
                _findRemappedType = _findRemappedType(config, List.class);
                _findRemappedType2 = _findRemappedType(config, Map.class);
            } else {
                _findRemappedType2 = null;
                _findRemappedType = null;
            }
            return new UntypedObjectDeserializer(_findRemappedType, _findRemappedType2);
        } else if (rawClass == aQJ || rawClass == aQK) {
            return StringDeserializer.instance;
        } else {
            JavaType referencedType;
            if (javaType.isReferenceType()) {
                referencedType = javaType.getReferencedType();
                if (AtomicReference.class.isAssignableFrom(rawClass)) {
                    return new AtomicReferenceDeserializer(referencedType, findTypeDeserializer(deserializationContext.getConfig(), referencedType), findDeserializerFromAnnotation(deserializationContext, deserializationContext.getConfig().introspectClassAnnotations(referencedType).Dn()));
                }
            }
            if (rawClass == aQL) {
                TypeFactory typeFactory = deserializationContext.getTypeFactory();
                JavaType[] findTypeParameters = typeFactory.findTypeParameters(javaType, aQL);
                _findRemappedType2 = (findTypeParameters == null || findTypeParameters.length != 1) ? TypeFactory.unknownType() : findTypeParameters[0];
                return createCollectionDeserializer(deserializationContext, typeFactory.constructCollectionType(Collection.class, _findRemappedType2), com_fossil_agu);
            } else if (rawClass == aQM) {
                ajs findTypeDeserializer;
                _findRemappedType2 = javaType.containedType(0);
                if (_findRemappedType2 == null) {
                    _findRemappedType = TypeFactory.unknownType();
                } else {
                    _findRemappedType = _findRemappedType2;
                }
                _findRemappedType2 = javaType.containedType(1);
                if (_findRemappedType2 == null) {
                    referencedType = TypeFactory.unknownType();
                } else {
                    referencedType = _findRemappedType2;
                }
                ajs com_fossil_ajs = (ajs) referencedType.getTypeHandler();
                if (com_fossil_ajs == null) {
                    findTypeDeserializer = findTypeDeserializer(deserializationContext.getConfig(), referencedType);
                } else {
                    findTypeDeserializer = com_fossil_ajs;
                }
                return new MapEntryDeserializer(javaType, (ahc) _findRemappedType.getValueHandler(), (agy) referencedType.getValueHandler(), findTypeDeserializer);
            } else {
                agy<?> a;
                String name = rawClass.getName();
                if (rawClass.isPrimitive() || name.startsWith("java.")) {
                    a = NumberDeserializers.m2728a(rawClass, name);
                    if (a == null) {
                        a = DateDeserializers.m2721a(rawClass, name);
                    }
                    if (a != null) {
                        return a;
                    }
                }
                if (rawClass == amt.class) {
                    return new TokenBufferDeserializer();
                }
                a = findOptionalStdDeserializer(deserializationContext, javaType, com_fossil_agu);
                return a == null ? aio.m3412a(rawClass, name) : a;
            }
        }
    }

    protected JavaType _findRemappedType(DeserializationConfig deserializationConfig, Class<?> cls) throws JsonMappingException {
        JavaType mapAbstractType = mapAbstractType(deserializationConfig, deserializationConfig.constructType((Class) cls));
        return (mapAbstractType == null || mapAbstractType.hasRawClass(cls)) ? null : mapAbstractType;
    }

    protected agy<?> _findCustomArrayDeserializer(ArrayType arrayType, DeserializationConfig deserializationConfig, agu com_fossil_agu, ajs com_fossil_ajs, agy<?> com_fossil_agy_) throws JsonMappingException {
        for (aia a : this._factoryConfig.deserializers()) {
            agy<?> a2 = a.m3380a(arrayType, deserializationConfig, com_fossil_agu, com_fossil_ajs, (agy) com_fossil_agy_);
            if (a2 != null) {
                return a2;
            }
        }
        return null;
    }

    protected agy<Object> _findCustomBeanDeserializer(JavaType javaType, DeserializationConfig deserializationConfig, agu com_fossil_agu) throws JsonMappingException {
        for (aia a : this._factoryConfig.deserializers()) {
            agy<Object> a2 = a.m3379a(javaType, deserializationConfig, com_fossil_agu);
            if (a2 != null) {
                return a2;
            }
        }
        return null;
    }

    protected agy<?> _findCustomCollectionDeserializer(CollectionType collectionType, DeserializationConfig deserializationConfig, agu com_fossil_agu, ajs com_fossil_ajs, agy<?> com_fossil_agy_) throws JsonMappingException {
        for (aia a : this._factoryConfig.deserializers()) {
            agy<?> a2 = a.m3382a(collectionType, deserializationConfig, com_fossil_agu, com_fossil_ajs, (agy) com_fossil_agy_);
            if (a2 != null) {
                return a2;
            }
        }
        return null;
    }

    protected agy<?> _findCustomCollectionLikeDeserializer(CollectionLikeType collectionLikeType, DeserializationConfig deserializationConfig, agu com_fossil_agu, ajs com_fossil_ajs, agy<?> com_fossil_agy_) throws JsonMappingException {
        for (aia a : this._factoryConfig.deserializers()) {
            agy<?> a2 = a.m3381a(collectionLikeType, deserializationConfig, com_fossil_agu, com_fossil_ajs, (agy) com_fossil_agy_);
            if (a2 != null) {
                return a2;
            }
        }
        return null;
    }

    protected agy<?> _findCustomEnumDeserializer(Class<?> cls, DeserializationConfig deserializationConfig, agu com_fossil_agu) throws JsonMappingException {
        for (aia a : this._factoryConfig.deserializers()) {
            agy<?> a2 = a.m3385a((Class) cls, deserializationConfig, com_fossil_agu);
            if (a2 != null) {
                return a2;
            }
        }
        return null;
    }

    protected agy<?> _findCustomMapDeserializer(MapType mapType, DeserializationConfig deserializationConfig, agu com_fossil_agu, ahc com_fossil_ahc, ajs com_fossil_ajs, agy<?> com_fossil_agy_) throws JsonMappingException {
        for (aia a : this._factoryConfig.deserializers()) {
            agy<?> a2 = a.m3384a(mapType, deserializationConfig, com_fossil_agu, com_fossil_ahc, com_fossil_ajs, (agy) com_fossil_agy_);
            if (a2 != null) {
                return a2;
            }
        }
        return null;
    }

    protected agy<?> _findCustomMapLikeDeserializer(MapLikeType mapLikeType, DeserializationConfig deserializationConfig, agu com_fossil_agu, ahc com_fossil_ahc, ajs com_fossil_ajs, agy<?> com_fossil_agy_) throws JsonMappingException {
        for (aia a : this._factoryConfig.deserializers()) {
            agy<?> a2 = a.m3383a(mapLikeType, deserializationConfig, com_fossil_agu, com_fossil_ahc, com_fossil_ajs, (agy) com_fossil_agy_);
            if (a2 != null) {
                return a2;
            }
        }
        return null;
    }

    protected agy<?> _findCustomTreeNodeDeserializer(Class<? extends agz> cls, DeserializationConfig deserializationConfig, agu com_fossil_agu) throws JsonMappingException {
        for (aia b : this._factoryConfig.deserializers()) {
            agy<?> b2 = b.m3386b(cls, deserializationConfig, com_fossil_agu);
            if (b2 != null) {
                return b2;
            }
        }
        return null;
    }

    protected agy<Object> findDeserializerFromAnnotation(DeserializationContext deserializationContext, aiq com_fossil_aiq) throws JsonMappingException {
        Object findDeserializer = deserializationContext.getAnnotationIntrospector().findDeserializer(com_fossil_aiq);
        if (findDeserializer == null) {
            return null;
        }
        return deserializationContext.deserializerInstance(com_fossil_aiq, findDeserializer);
    }

    protected <T extends JavaType> T modifyTypeByAnnotation(DeserializationContext deserializationContext, aiq com_fossil_aiq, T t) throws JsonMappingException {
        AnnotationIntrospector annotationIntrospector = deserializationContext.getAnnotationIntrospector();
        Class findDeserializationType = annotationIntrospector.findDeserializationType(com_fossil_aiq, t);
        if (findDeserializationType != null) {
            try {
                T constructSpecializedType = deserializationContext.getTypeFactory().constructSpecializedType(t, findDeserializationType);
            } catch (Throwable e) {
                throw new JsonMappingException("Failed to narrow type " + t + " with concrete-type annotation (value " + findDeserializationType.getName() + "), method '" + com_fossil_aiq.getName() + "': " + e.getMessage(), null, e);
            }
        }
        constructSpecializedType = t;
        if (!constructSpecializedType.isContainerType()) {
            return constructSpecializedType;
        }
        T t2;
        Class findDeserializationKeyType = annotationIntrospector.findDeserializationKeyType(com_fossil_aiq, constructSpecializedType.getKeyType());
        if (findDeserializationKeyType == null) {
            t2 = constructSpecializedType;
        } else if (constructSpecializedType instanceof MapLikeType) {
            try {
                t2 = ((MapLikeType) constructSpecializedType).narrowKey(findDeserializationKeyType);
            } catch (Throwable e2) {
                throw new JsonMappingException("Failed to narrow key type " + constructSpecializedType + " with key-type annotation (" + findDeserializationKeyType.getName() + "): " + e2.getMessage(), null, e2);
            }
        } else {
            throw new JsonMappingException("Illegal key-type annotation: type " + constructSpecializedType + " is not a Map(-like) type");
        }
        JavaType keyType = t2.getKeyType();
        if (keyType != null && keyType.getValueHandler() == null) {
            ahc keyDeserializerInstance = deserializationContext.keyDeserializerInstance(com_fossil_aiq, annotationIntrospector.findKeyDeserializer(com_fossil_aiq));
            if (keyDeserializerInstance != null) {
                t2 = ((MapLikeType) t2).withKeyValueHandler(keyDeserializerInstance);
                t2.getKeyType();
            }
        }
        findDeserializationType = annotationIntrospector.findDeserializationContentType(com_fossil_aiq, t2.getContentType());
        if (findDeserializationType != null) {
            try {
                t2 = t2.narrowContentsBy(findDeserializationType);
            } catch (Throwable e3) {
                throw new JsonMappingException("Failed to narrow content type " + t2 + " with content-type annotation (" + findDeserializationType.getName() + "): " + e3.getMessage(), null, e3);
            }
        }
        if (t2.getContentType().getValueHandler() != null) {
            return t2;
        }
        agy deserializerInstance = deserializationContext.deserializerInstance(com_fossil_aiq, annotationIntrospector.findContentDeserializer(com_fossil_aiq));
        if (deserializerInstance != null) {
            return t2.withContentValueHandler(deserializerInstance);
        }
        return t2;
    }

    protected JavaType resolveType(DeserializationContext deserializationContext, agu com_fossil_agu, JavaType javaType, AnnotatedMember annotatedMember) throws JsonMappingException {
        Object findPropertyTypeDeserializer;
        if (javaType.isContainerType()) {
            AnnotationIntrospector annotationIntrospector = deserializationContext.getAnnotationIntrospector();
            if (javaType.getKeyType() != null) {
                ahc keyDeserializerInstance = deserializationContext.keyDeserializerInstance(annotatedMember, annotationIntrospector.findKeyDeserializer(annotatedMember));
                if (keyDeserializerInstance != null) {
                    javaType = ((MapLikeType) javaType).withKeyValueHandler(keyDeserializerInstance);
                    javaType.getKeyType();
                }
            }
            agy deserializerInstance = deserializationContext.deserializerInstance(annotatedMember, annotationIntrospector.findContentDeserializer(annotatedMember));
            if (deserializerInstance != null) {
                javaType = javaType.withContentValueHandler(deserializerInstance);
            }
            if (annotatedMember instanceof AnnotatedMember) {
                ajs findPropertyContentTypeDeserializer = findPropertyContentTypeDeserializer(deserializationContext.getConfig(), javaType, annotatedMember);
                if (findPropertyContentTypeDeserializer != null) {
                    javaType = javaType.withContentTypeHandler(findPropertyContentTypeDeserializer);
                }
            }
        }
        if (annotatedMember instanceof AnnotatedMember) {
            findPropertyTypeDeserializer = findPropertyTypeDeserializer(deserializationContext.getConfig(), javaType, annotatedMember);
        } else {
            findPropertyTypeDeserializer = findTypeDeserializer(deserializationContext.getConfig(), javaType);
        }
        if (findPropertyTypeDeserializer != null) {
            return javaType.withTypeHandler(findPropertyTypeDeserializer);
        }
        return javaType;
    }

    protected EnumResolver constructEnumResolver(Class<?> cls, DeserializationConfig deserializationConfig, AnnotatedMethod annotatedMethod) {
        if (annotatedMethod != null) {
            Member annotated = annotatedMethod.getAnnotated();
            if (deserializationConfig.canOverrideAccessModifiers()) {
                ami.m3862a(annotated);
            }
            return EnumResolver.constructUnsafeUsingMethod(cls, annotated);
        } else if (deserializationConfig.isEnabled(DeserializationFeature.READ_ENUMS_USING_TO_STRING)) {
            return EnumResolver.constructUnsafeUsingToString(cls);
        } else {
            return EnumResolver.constructUnsafe(cls, deserializationConfig.getAnnotationIntrospector());
        }
    }

    protected AnnotatedMethod _findJsonValueFor(DeserializationConfig deserializationConfig, JavaType javaType) {
        if (javaType == null) {
            return null;
        }
        return deserializationConfig.introspect(javaType).Dz();
    }
}
