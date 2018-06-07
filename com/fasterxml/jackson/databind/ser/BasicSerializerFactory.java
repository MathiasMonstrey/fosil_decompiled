package com.fasterxml.jackson.databind.ser;

import com.fasterxml.jackson.annotation.JsonFormat.C1501b;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.AnnotationIntrospector;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.SerializationConfig;
import com.fasterxml.jackson.databind.annotation.JsonSerialize.Typing;
import com.fasterxml.jackson.databind.cfg.SerializerFactoryConfig;
import com.fasterxml.jackson.databind.ext.OptionalHandlerFactory;
import com.fasterxml.jackson.databind.introspect.AnnotatedMethod;
import com.fasterxml.jackson.databind.ser.impl.IndexedListSerializer;
import com.fasterxml.jackson.databind.ser.impl.IndexedStringListSerializer;
import com.fasterxml.jackson.databind.ser.impl.IteratorSerializer;
import com.fasterxml.jackson.databind.ser.impl.MapEntrySerializer;
import com.fasterxml.jackson.databind.ser.impl.StringArraySerializer;
import com.fasterxml.jackson.databind.ser.impl.StringCollectionSerializer;
import com.fasterxml.jackson.databind.ser.std.AtomicReferenceSerializer;
import com.fasterxml.jackson.databind.ser.std.BooleanSerializer;
import com.fasterxml.jackson.databind.ser.std.ByteBufferSerializer;
import com.fasterxml.jackson.databind.ser.std.CalendarSerializer;
import com.fasterxml.jackson.databind.ser.std.CollectionSerializer;
import com.fasterxml.jackson.databind.ser.std.DateSerializer;
import com.fasterxml.jackson.databind.ser.std.EnumSerializer;
import com.fasterxml.jackson.databind.ser.std.EnumSetSerializer;
import com.fasterxml.jackson.databind.ser.std.InetAddressSerializer;
import com.fasterxml.jackson.databind.ser.std.InetSocketAddressSerializer;
import com.fasterxml.jackson.databind.ser.std.IterableSerializer;
import com.fasterxml.jackson.databind.ser.std.JsonValueSerializer;
import com.fasterxml.jackson.databind.ser.std.MapSerializer;
import com.fasterxml.jackson.databind.ser.std.NumberSerializer;
import com.fasterxml.jackson.databind.ser.std.NumberSerializers;
import com.fasterxml.jackson.databind.ser.std.ObjectArraySerializer;
import com.fasterxml.jackson.databind.ser.std.SerializableSerializer;
import com.fasterxml.jackson.databind.ser.std.SqlDateSerializer;
import com.fasterxml.jackson.databind.ser.std.SqlTimeSerializer;
import com.fasterxml.jackson.databind.ser.std.StdArraySerializers;
import com.fasterxml.jackson.databind.ser.std.StdDelegatingSerializer;
import com.fasterxml.jackson.databind.ser.std.StdJdkSerializers;
import com.fasterxml.jackson.databind.ser.std.StdKeySerializers;
import com.fasterxml.jackson.databind.ser.std.StringSerializer;
import com.fasterxml.jackson.databind.ser.std.TimeZoneSerializer;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import com.fasterxml.jackson.databind.ser.std.TokenBufferSerializer;
import com.fasterxml.jackson.databind.type.ArrayType;
import com.fasterxml.jackson.databind.type.CollectionLikeType;
import com.fasterxml.jackson.databind.type.CollectionType;
import com.fasterxml.jackson.databind.type.MapLikeType;
import com.fasterxml.jackson.databind.type.MapType;
import com.fasterxml.jackson.databind.type.ReferenceType;
import com.fasterxml.jackson.databind.type.TypeFactory;
import com.fossil.agu;
import com.fossil.aha;
import com.fossil.ahb;
import com.fossil.ahg;
import com.fossil.aiq;
import com.fossil.air;
import com.fossil.aiu;
import com.fossil.aju;
import com.fossil.ajv;
import com.fossil.alf;
import com.fossil.aln;
import com.fossil.alo;
import com.fossil.ami;
import com.fossil.amk;
import com.fossil.amt;
import java.io.Serializable;
import java.lang.reflect.Member;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.RandomAccess;
import java.util.TimeZone;
import java.util.concurrent.atomic.AtomicReference;

public abstract class BasicSerializerFactory extends aln implements Serializable {
    protected static final HashMap<String, ahb<?>> _concrete = new HashMap();
    protected static final HashMap<String, Class<? extends ahb<?>>> _concreteLazy = new HashMap();
    protected final SerializerFactoryConfig _factoryConfig;

    public abstract ahb<Object> createSerializer(ahg com_fossil_ahg, JavaType javaType) throws JsonMappingException;

    protected abstract Iterable<alo> customSerializers();

    public abstract aln withConfig(SerializerFactoryConfig serializerFactoryConfig);

    static {
        _concrete.put(String.class.getName(), new StringSerializer());
        ToStringSerializer toStringSerializer = ToStringSerializer.instance;
        _concrete.put(StringBuffer.class.getName(), toStringSerializer);
        _concrete.put(StringBuilder.class.getName(), toStringSerializer);
        _concrete.put(Character.class.getName(), toStringSerializer);
        _concrete.put(Character.TYPE.getName(), toStringSerializer);
        NumberSerializers.m2756m(_concrete);
        _concrete.put(Boolean.TYPE.getName(), new BooleanSerializer(true));
        _concrete.put(Boolean.class.getName(), new BooleanSerializer(false));
        _concrete.put(BigInteger.class.getName(), new NumberSerializer(BigInteger.class));
        _concrete.put(BigDecimal.class.getName(), new NumberSerializer(BigDecimal.class));
        _concrete.put(Calendar.class.getName(), CalendarSerializer.instance);
        DateSerializer dateSerializer = DateSerializer.instance;
        _concrete.put(Date.class.getName(), dateSerializer);
        _concrete.put(Timestamp.class.getName(), dateSerializer);
        _concreteLazy.put(java.sql.Date.class.getName(), SqlDateSerializer.class);
        _concreteLazy.put(Time.class.getName(), SqlTimeSerializer.class);
        for (Entry entry : StdJdkSerializers.GQ()) {
            Object value = entry.getValue();
            if (value instanceof ahb) {
                _concrete.put(((Class) entry.getKey()).getName(), (ahb) value);
            } else if (value instanceof Class) {
                _concreteLazy.put(((Class) entry.getKey()).getName(), (Class) value);
            } else {
                throw new IllegalStateException("Internal error: unrecognized value of type " + entry.getClass().getName());
            }
        }
        _concreteLazy.put(amt.class.getName(), TokenBufferSerializer.class);
    }

    protected BasicSerializerFactory(SerializerFactoryConfig serializerFactoryConfig) {
        if (serializerFactoryConfig == null) {
            serializerFactoryConfig = new SerializerFactoryConfig();
        }
        this._factoryConfig = serializerFactoryConfig;
    }

    public SerializerFactoryConfig getFactoryConfig() {
        return this._factoryConfig;
    }

    public final aln withAdditionalSerializers(alo com_fossil_alo) {
        return withConfig(this._factoryConfig.withAdditionalSerializers(com_fossil_alo));
    }

    public final aln withAdditionalKeySerializers(alo com_fossil_alo) {
        return withConfig(this._factoryConfig.withAdditionalKeySerializers(com_fossil_alo));
    }

    public final aln withSerializerModifier(alf com_fossil_alf) {
        return withConfig(this._factoryConfig.withSerializerModifier(com_fossil_alf));
    }

    public ahb<Object> createKeySerializer(SerializationConfig serializationConfig, JavaType javaType, ahb<Object> com_fossil_ahb_java_lang_Object) {
        agu introspectClassAnnotations = serializationConfig.introspectClassAnnotations(javaType.getRawClass());
        ahb<Object> com_fossil_ahb_java_lang_Object2 = null;
        if (this._factoryConfig.hasKeySerializers()) {
            for (alo findSerializer : this._factoryConfig.keySerializers()) {
                com_fossil_ahb_java_lang_Object2 = findSerializer.findSerializer(serializationConfig, javaType, introspectClassAnnotations);
                if (com_fossil_ahb_java_lang_Object2 != null) {
                    break;
                }
            }
        }
        if (com_fossil_ahb_java_lang_Object2 != null) {
            com_fossil_ahb_java_lang_Object = com_fossil_ahb_java_lang_Object2;
        } else if (com_fossil_ahb_java_lang_Object == null) {
            com_fossil_ahb_java_lang_Object = StdKeySerializers.m2759a(serializationConfig, javaType.getRawClass(), false);
            if (com_fossil_ahb_java_lang_Object == null) {
                agu introspect = serializationConfig.introspect(javaType);
                AnnotatedMethod Dz = introspect.Dz();
                if (Dz != null) {
                    ahb a = StdKeySerializers.m2759a(serializationConfig, Dz.getRawReturnType(), true);
                    Member annotated = Dz.getAnnotated();
                    if (serializationConfig.canOverrideAccessModifiers()) {
                        ami.m3862a(annotated);
                    }
                    com_fossil_ahb_java_lang_Object = new JsonValueSerializer(annotated, a);
                    introspectClassAnnotations = introspect;
                } else {
                    com_fossil_ahb_java_lang_Object = StdKeySerializers.GR();
                    introspectClassAnnotations = introspect;
                }
            }
        }
        if (this._factoryConfig.hasSerializerModifiers()) {
            for (alf b : this._factoryConfig.serializerModifiers()) {
                com_fossil_ahb_java_lang_Object = b.m3720b(serializationConfig, javaType, introspectClassAnnotations, com_fossil_ahb_java_lang_Object);
            }
        }
        return com_fossil_ahb_java_lang_Object;
    }

    public ajv createTypeSerializer(SerializationConfig serializationConfig, JavaType javaType) {
        Collection collection;
        air Dn = serializationConfig.introspectClassAnnotations(javaType.getRawClass()).Dn();
        aju findTypeResolver = serializationConfig.getAnnotationIntrospector().findTypeResolver(serializationConfig, Dn, javaType);
        if (findTypeResolver == null) {
            findTypeResolver = serializationConfig.getDefaultTyper(javaType);
            collection = null;
        } else {
            collection = serializationConfig.getSubtypeResolver().collectAndResolveSubtypesByClass(serializationConfig, Dn);
        }
        if (findTypeResolver == null) {
            return null;
        }
        return findTypeResolver.buildTypeSerializer(serializationConfig, javaType, collection);
    }

    protected final ahb<?> findSerializerByLookup(JavaType javaType, SerializationConfig serializationConfig, agu com_fossil_agu, boolean z) {
        String name = javaType.getRawClass().getName();
        if (javaType.isReferenceType() && javaType.isTypeOrSubTypeOf(AtomicReference.class)) {
            return new AtomicReferenceSerializer((ReferenceType) javaType);
        }
        ahb<?> com_fossil_ahb_ = (ahb) _concrete.get(name);
        if (com_fossil_ahb_ != null) {
            return com_fossil_ahb_;
        }
        Class cls = (Class) _concreteLazy.get(name);
        if (cls == null) {
            return com_fossil_ahb_;
        }
        try {
            return (ahb) cls.newInstance();
        } catch (Throwable e) {
            throw new IllegalStateException("Failed to instantiate standard serializer (of type " + cls.getName() + "): " + e.getMessage(), e);
        }
    }

    protected final ahb<?> findSerializerByAnnotations(ahg com_fossil_ahg, JavaType javaType, agu com_fossil_agu) throws JsonMappingException {
        if (aha.class.isAssignableFrom(javaType.getRawClass())) {
            return SerializableSerializer.instance;
        }
        aiq Dz = com_fossil_agu.Dz();
        if (Dz == null) {
            return null;
        }
        Member annotated = Dz.getAnnotated();
        if (com_fossil_ahg.canOverrideAccessModifiers()) {
            ami.m3862a(annotated);
        }
        return new JsonValueSerializer(annotated, findSerializerFromAnnotation(com_fossil_ahg, Dz));
    }

    protected final ahb<?> findSerializerByPrimaryType(ahg com_fossil_ahg, JavaType javaType, agu com_fossil_agu, boolean z) throws JsonMappingException {
        Class rawClass = javaType.getRawClass();
        ahb<?> findOptionalStdSerializer = findOptionalStdSerializer(com_fossil_ahg, javaType, com_fossil_agu, z);
        if (findOptionalStdSerializer != null) {
            return findOptionalStdSerializer;
        }
        if (Calendar.class.isAssignableFrom(rawClass)) {
            return CalendarSerializer.instance;
        }
        if (Date.class.isAssignableFrom(rawClass)) {
            return DateSerializer.instance;
        }
        if (Entry.class.isAssignableFrom(rawClass)) {
            JavaType containedType = javaType.containedType(0);
            if (containedType == null) {
                containedType = TypeFactory.unknownType();
            }
            JavaType containedType2 = javaType.containedType(1);
            if (containedType2 == null) {
                containedType2 = TypeFactory.unknownType();
            }
            return buildMapEntrySerializer(com_fossil_ahg.getConfig(), javaType, com_fossil_agu, z, containedType, containedType2);
        } else if (ByteBuffer.class.isAssignableFrom(rawClass)) {
            return new ByteBufferSerializer();
        } else {
            if (InetAddress.class.isAssignableFrom(rawClass)) {
                return new InetAddressSerializer();
            }
            if (InetSocketAddress.class.isAssignableFrom(rawClass)) {
                return new InetSocketAddressSerializer();
            }
            if (TimeZone.class.isAssignableFrom(rawClass)) {
                return new TimeZoneSerializer();
            }
            if (Charset.class.isAssignableFrom(rawClass)) {
                return ToStringSerializer.instance;
            }
            if (!Number.class.isAssignableFrom(rawClass)) {
                return Enum.class.isAssignableFrom(rawClass) ? buildEnumSerializer(com_fossil_ahg.getConfig(), javaType, com_fossil_agu) : null;
            } else {
                C1501b a = com_fossil_agu.mo978a(null);
                if (a != null) {
                    switch (a.yZ()) {
                        case STRING:
                            return ToStringSerializer.instance;
                        case OBJECT:
                        case ARRAY:
                            return null;
                    }
                }
                return NumberSerializer.instance;
            }
        }
    }

    protected ahb<?> findOptionalStdSerializer(ahg com_fossil_ahg, JavaType javaType, agu com_fossil_agu, boolean z) throws JsonMappingException {
        return OptionalHandlerFactory.instance.findSerializer(com_fossil_ahg.getConfig(), javaType, com_fossil_agu);
    }

    protected final ahb<?> findSerializerByAddonType(SerializationConfig serializationConfig, JavaType javaType, agu com_fossil_agu, boolean z) throws JsonMappingException {
        Class rawClass = javaType.getRawClass();
        JavaType[] findTypeParameters;
        JavaType unknownType;
        if (Iterator.class.isAssignableFrom(rawClass)) {
            findTypeParameters = serializationConfig.getTypeFactory().findTypeParameters(javaType, Iterator.class);
            unknownType = (findTypeParameters == null || findTypeParameters.length != 1) ? TypeFactory.unknownType() : findTypeParameters[0];
            return buildIteratorSerializer(serializationConfig, javaType, com_fossil_agu, z, unknownType);
        } else if (Iterable.class.isAssignableFrom(rawClass)) {
            findTypeParameters = serializationConfig.getTypeFactory().findTypeParameters(javaType, Iterable.class);
            unknownType = (findTypeParameters == null || findTypeParameters.length != 1) ? TypeFactory.unknownType() : findTypeParameters[0];
            return buildIterableSerializer(serializationConfig, javaType, com_fossil_agu, z, unknownType);
        } else if (CharSequence.class.isAssignableFrom(rawClass)) {
            return ToStringSerializer.instance;
        } else {
            return null;
        }
    }

    protected ahb<Object> findSerializerFromAnnotation(ahg com_fossil_ahg, aiq com_fossil_aiq) throws JsonMappingException {
        Object findSerializer = com_fossil_ahg.getAnnotationIntrospector().findSerializer(com_fossil_aiq);
        if (findSerializer == null) {
            return null;
        }
        return findConvertingSerializer(com_fossil_ahg, com_fossil_aiq, com_fossil_ahg.serializerInstance(com_fossil_aiq, findSerializer));
    }

    protected ahb<?> findConvertingSerializer(ahg com_fossil_ahg, aiq com_fossil_aiq, ahb<?> com_fossil_ahb_) throws JsonMappingException {
        amk findConverter = findConverter(com_fossil_ahg, com_fossil_aiq);
        return findConverter == null ? com_fossil_ahb_ : new StdDelegatingSerializer(findConverter, findConverter.m3879b(com_fossil_ahg.getTypeFactory()), com_fossil_ahb_);
    }

    protected amk<Object, Object> findConverter(ahg com_fossil_ahg, aiq com_fossil_aiq) throws JsonMappingException {
        Object findSerializationConverter = com_fossil_ahg.getAnnotationIntrospector().findSerializationConverter(com_fossil_aiq);
        if (findSerializationConverter == null) {
            return null;
        }
        return com_fossil_ahg.converterInstance(com_fossil_aiq, findSerializationConverter);
    }

    protected ahb<?> buildContainerSerializer(ahg com_fossil_ahg, JavaType javaType, agu com_fossil_agu, boolean z) throws JsonMappingException {
        boolean z2;
        ahb<?> com_fossil_ahb_;
        SerializationConfig config = com_fossil_ahg.getConfig();
        if (!(z || !javaType.useStaticType() || (javaType.isContainerType() && javaType.getContentType().getRawClass() == Object.class))) {
            z = true;
        }
        ajv createTypeSerializer = createTypeSerializer(config, javaType.getContentType());
        if (createTypeSerializer != null) {
            z2 = false;
        } else {
            z2 = z;
        }
        ahb _findContentSerializer = _findContentSerializer(com_fossil_ahg, com_fossil_agu.Dn());
        ahb<?> com_fossil_ahb_2;
        if (javaType.isMapLikeType()) {
            MapLikeType mapLikeType = (MapLikeType) javaType;
            ahb _findKeySerializer = _findKeySerializer(com_fossil_ahg, com_fossil_agu.Dn());
            if (mapLikeType.isTrueMapType()) {
                return buildMapSerializer(com_fossil_ahg, (MapType) mapLikeType, com_fossil_agu, z2, _findKeySerializer, createTypeSerializer, _findContentSerializer);
            }
            com_fossil_ahb_2 = null;
            MapLikeType mapLikeType2 = (MapLikeType) javaType;
            for (alo a : customSerializers()) {
                com_fossil_ahb_2 = a.m3741a(config, mapLikeType2, com_fossil_agu, _findKeySerializer, createTypeSerializer, _findContentSerializer);
                if (com_fossil_ahb_2 != null) {
                    break;
                }
            }
            if (com_fossil_ahb_2 == null) {
                com_fossil_ahb_2 = findSerializerByAnnotations(com_fossil_ahg, javaType, com_fossil_agu);
            }
            if (com_fossil_ahb_2 == null || !this._factoryConfig.hasSerializerModifiers()) {
                return com_fossil_ahb_2;
            }
            com_fossil_ahb_ = com_fossil_ahb_2;
            for (alf a2 : this._factoryConfig.serializerModifiers()) {
                com_fossil_ahb_ = a2.m3715a(config, mapLikeType2, com_fossil_agu, (ahb) com_fossil_ahb_);
            }
        } else if (javaType.isCollectionLikeType()) {
            CollectionLikeType collectionLikeType = (CollectionLikeType) javaType;
            if (collectionLikeType.isTrueCollectionType()) {
                return buildCollectionSerializer(com_fossil_ahg, (CollectionType) collectionLikeType, com_fossil_agu, z2, createTypeSerializer, _findContentSerializer);
            }
            com_fossil_ahb_2 = null;
            CollectionLikeType collectionLikeType2 = (CollectionLikeType) javaType;
            for (alo a3 : customSerializers()) {
                com_fossil_ahb_2 = a3.m3739a(config, collectionLikeType2, com_fossil_agu, createTypeSerializer, _findContentSerializer);
                if (com_fossil_ahb_2 != null) {
                    break;
                }
            }
            if (com_fossil_ahb_2 == null) {
                com_fossil_ahb_2 = findSerializerByAnnotations(com_fossil_ahg, javaType, com_fossil_agu);
            }
            if (com_fossil_ahb_2 == null || !this._factoryConfig.hasSerializerModifiers()) {
                return com_fossil_ahb_2;
            }
            com_fossil_ahb_ = com_fossil_ahb_2;
            for (alf a22 : this._factoryConfig.serializerModifiers()) {
                com_fossil_ahb_ = a22.m3713a(config, collectionLikeType2, com_fossil_agu, (ahb) com_fossil_ahb_);
            }
        } else if (!javaType.isArrayType()) {
            return null;
        } else {
            return buildArraySerializer(com_fossil_ahg, (ArrayType) javaType, com_fossil_agu, z2, createTypeSerializer, _findContentSerializer);
        }
        return com_fossil_ahb_;
    }

    protected ahb<?> buildCollectionSerializer(ahg com_fossil_ahg, CollectionType collectionType, agu com_fossil_agu, boolean z, ajv com_fossil_ajv, ahb<Object> com_fossil_ahb_java_lang_Object) throws JsonMappingException {
        ahb<?> com_fossil_ahb_;
        JavaType javaType = null;
        SerializationConfig config = com_fossil_ahg.getConfig();
        ahb<?> com_fossil_ahb_2 = null;
        for (alo a : customSerializers()) {
            com_fossil_ahb_2 = a.m3740a(config, collectionType, com_fossil_agu, com_fossil_ajv, (ahb) com_fossil_ahb_java_lang_Object);
            if (com_fossil_ahb_2 != null) {
                break;
            }
        }
        if (com_fossil_ahb_2 == null) {
            com_fossil_ahb_2 = findSerializerByAnnotations(com_fossil_ahg, collectionType, com_fossil_agu);
            if (com_fossil_ahb_2 == null) {
                C1501b a2 = com_fossil_agu.mo978a(null);
                if (a2 != null && a2.yZ() == Shape.OBJECT) {
                    return null;
                }
                Class rawClass = collectionType.getRawClass();
                if (EnumSet.class.isAssignableFrom(rawClass)) {
                    JavaType contentType = collectionType.getContentType();
                    if (contentType.isEnumType()) {
                        javaType = contentType;
                    }
                    com_fossil_ahb_2 = buildEnumSetSerializer(javaType);
                } else {
                    Class rawClass2 = collectionType.getContentType().getRawClass();
                    if (isIndexedList(rawClass)) {
                        if (rawClass2 != String.class) {
                            com_fossil_ahb_2 = buildIndexedListSerializer(collectionType.getContentType(), z, com_fossil_ajv, com_fossil_ahb_java_lang_Object);
                        } else if (com_fossil_ahb_java_lang_Object == null || ami.bG(com_fossil_ahb_java_lang_Object)) {
                            com_fossil_ahb_2 = IndexedStringListSerializer.instance;
                        }
                    } else if (rawClass2 == String.class && (com_fossil_ahb_java_lang_Object == null || ami.bG(com_fossil_ahb_java_lang_Object))) {
                        com_fossil_ahb_2 = StringCollectionSerializer.instance;
                    }
                    if (com_fossil_ahb_2 == null) {
                        com_fossil_ahb_2 = buildCollectionSerializer(collectionType.getContentType(), z, com_fossil_ajv, com_fossil_ahb_java_lang_Object);
                    }
                }
            }
        }
        if (this._factoryConfig.hasSerializerModifiers()) {
            com_fossil_ahb_ = com_fossil_ahb_2;
            for (alf a3 : this._factoryConfig.serializerModifiers()) {
                com_fossil_ahb_ = a3.m3714a(config, collectionType, com_fossil_agu, (ahb) com_fossil_ahb_);
            }
        } else {
            com_fossil_ahb_ = com_fossil_ahb_2;
        }
        return com_fossil_ahb_;
    }

    protected boolean isIndexedList(Class<?> cls) {
        return RandomAccess.class.isAssignableFrom(cls);
    }

    public ContainerSerializer<?> buildIndexedListSerializer(JavaType javaType, boolean z, ajv com_fossil_ajv, ahb<Object> com_fossil_ahb_java_lang_Object) {
        return new IndexedListSerializer(javaType, z, com_fossil_ajv, com_fossil_ahb_java_lang_Object);
    }

    public ContainerSerializer<?> buildCollectionSerializer(JavaType javaType, boolean z, ajv com_fossil_ajv, ahb<Object> com_fossil_ahb_java_lang_Object) {
        return new CollectionSerializer(javaType, z, com_fossil_ajv, com_fossil_ahb_java_lang_Object);
    }

    public ahb<?> buildEnumSetSerializer(JavaType javaType) {
        return new EnumSetSerializer(javaType);
    }

    protected ahb<?> buildMapSerializer(ahg com_fossil_ahg, MapType mapType, agu com_fossil_agu, boolean z, ahb<Object> com_fossil_ahb_java_lang_Object, ajv com_fossil_ajv, ahb<Object> com_fossil_ahb_java_lang_Object2) throws JsonMappingException {
        SerializationConfig config = com_fossil_ahg.getConfig();
        ahb<?> com_fossil_ahb_ = null;
        for (alo a : customSerializers()) {
            com_fossil_ahb_ = a.m3742a(config, mapType, com_fossil_agu, (ahb) com_fossil_ahb_java_lang_Object, com_fossil_ajv, (ahb) com_fossil_ahb_java_lang_Object2);
            if (com_fossil_ahb_ != null) {
                break;
            }
        }
        if (com_fossil_ahb_ == null) {
            com_fossil_ahb_ = findSerializerByAnnotations(com_fossil_ahg, mapType, com_fossil_agu);
            if (com_fossil_ahb_ == null) {
                com_fossil_ahb_ = MapSerializer.construct(config.getAnnotationIntrospector().findPropertiesToIgnore(com_fossil_agu.Dn(), true), mapType, z, com_fossil_ajv, com_fossil_ahb_java_lang_Object, com_fossil_ahb_java_lang_Object2, findFilterId(config, com_fossil_agu));
                Object findSuppressableContentValue = findSuppressableContentValue(config, mapType.getContentType(), com_fossil_agu);
                if (findSuppressableContentValue != null) {
                    com_fossil_ahb_ = com_fossil_ahb_.withContentInclusion(findSuppressableContentValue);
                }
            }
        }
        if (!this._factoryConfig.hasSerializerModifiers()) {
            return com_fossil_ahb_;
        }
        ahb com_fossil_ahb = com_fossil_ahb_;
        for (alf a2 : this._factoryConfig.serializerModifiers()) {
            ahb<?> a3 = a2.m3716a(config, mapType, com_fossil_agu, com_fossil_ahb);
        }
        return com_fossil_ahb;
    }

    protected Object findSuppressableContentValue(SerializationConfig serializationConfig, JavaType javaType, agu com_fossil_agu) throws JsonMappingException {
        Include d = com_fossil_agu.mo985d(null);
        if (d == null) {
            return null;
        }
        switch (d) {
            case NON_DEFAULT:
                return Include.NON_EMPTY;
            default:
                return d;
        }
    }

    protected ahb<?> buildArraySerializer(ahg com_fossil_ahg, ArrayType arrayType, agu com_fossil_agu, boolean z, ajv com_fossil_ajv, ahb<Object> com_fossil_ahb_java_lang_Object) throws JsonMappingException {
        SerializationConfig config = com_fossil_ahg.getConfig();
        ahb<?> com_fossil_ahb_ = null;
        for (alo a : customSerializers()) {
            com_fossil_ahb_ = a.m3738a(config, arrayType, com_fossil_agu, com_fossil_ajv, (ahb) com_fossil_ahb_java_lang_Object);
            if (com_fossil_ahb_ != null) {
                break;
            }
        }
        if (com_fossil_ahb_ == null) {
            Class rawClass = arrayType.getRawClass();
            if (com_fossil_ahb_java_lang_Object == null || ami.bG(com_fossil_ahb_java_lang_Object)) {
                if (String[].class == rawClass) {
                    com_fossil_ahb_ = StringArraySerializer.instance;
                } else {
                    com_fossil_ahb_ = StdArraySerializers.m2758s(rawClass);
                }
            }
            if (com_fossil_ahb_ == null) {
                com_fossil_ahb_ = new ObjectArraySerializer(arrayType.getContentType(), z, com_fossil_ajv, com_fossil_ahb_java_lang_Object);
            }
        }
        if (!this._factoryConfig.hasSerializerModifiers()) {
            return com_fossil_ahb_;
        }
        ahb com_fossil_ahb = com_fossil_ahb_;
        for (alf a2 : this._factoryConfig.serializerModifiers()) {
            ahb<?> a3 = a2.m3712a(config, arrayType, com_fossil_agu, com_fossil_ahb);
        }
        return com_fossil_ahb;
    }

    protected ahb<?> buildIteratorSerializer(SerializationConfig serializationConfig, JavaType javaType, agu com_fossil_agu, boolean z, JavaType javaType2) throws JsonMappingException {
        return new IteratorSerializer(javaType2, z, createTypeSerializer(serializationConfig, javaType2));
    }

    @Deprecated
    protected ahb<?> buildIteratorSerializer(SerializationConfig serializationConfig, JavaType javaType, agu com_fossil_agu, boolean z) throws JsonMappingException {
        JavaType[] findTypeParameters = serializationConfig.getTypeFactory().findTypeParameters(javaType, Iterator.class);
        JavaType unknownType = (findTypeParameters == null || findTypeParameters.length != 1) ? TypeFactory.unknownType() : findTypeParameters[0];
        return buildIteratorSerializer(serializationConfig, javaType, com_fossil_agu, z, unknownType);
    }

    protected ahb<?> buildIterableSerializer(SerializationConfig serializationConfig, JavaType javaType, agu com_fossil_agu, boolean z, JavaType javaType2) throws JsonMappingException {
        return new IterableSerializer(javaType2, z, createTypeSerializer(serializationConfig, javaType2));
    }

    @Deprecated
    protected ahb<?> buildIterableSerializer(SerializationConfig serializationConfig, JavaType javaType, agu com_fossil_agu, boolean z) throws JsonMappingException {
        JavaType[] findTypeParameters = serializationConfig.getTypeFactory().findTypeParameters(javaType, Iterable.class);
        JavaType unknownType = (findTypeParameters == null || findTypeParameters.length != 1) ? TypeFactory.unknownType() : findTypeParameters[0];
        return buildIterableSerializer(serializationConfig, javaType, com_fossil_agu, z, unknownType);
    }

    protected ahb<?> buildMapEntrySerializer(SerializationConfig serializationConfig, JavaType javaType, agu com_fossil_agu, boolean z, JavaType javaType2, JavaType javaType3) throws JsonMappingException {
        return new MapEntrySerializer(javaType3, javaType2, javaType3, z, createTypeSerializer(serializationConfig, javaType3), null);
    }

    protected ahb<?> buildEnumSerializer(SerializationConfig serializationConfig, JavaType javaType, agu com_fossil_agu) throws JsonMappingException {
        C1501b a = com_fossil_agu.mo978a(null);
        if (a == null || a.yZ() != Shape.OBJECT) {
            ahb<?> construct = EnumSerializer.construct(javaType.getRawClass(), serializationConfig, com_fossil_agu, a);
            if (!this._factoryConfig.hasSerializerModifiers()) {
                return construct;
            }
            ahb com_fossil_ahb = construct;
            for (alf a2 : this._factoryConfig.serializerModifiers()) {
                ahb<?> a3 = a2.m3711a(serializationConfig, javaType, com_fossil_agu, com_fossil_ahb);
            }
            return com_fossil_ahb;
        }
        ((aiu) com_fossil_agu).bN("declaringClass");
        return null;
    }

    protected <T extends JavaType> T modifyTypeByAnnotation(SerializationConfig serializationConfig, aiq com_fossil_aiq, T t) {
        Class findSerializationType = serializationConfig.getAnnotationIntrospector().findSerializationType(com_fossil_aiq);
        if (findSerializationType != null) {
            try {
                t = t.widenBy(findSerializationType);
            } catch (IllegalArgumentException e) {
                throw new IllegalArgumentException("Failed to widen type " + t + " with concrete-type annotation (value " + findSerializationType.getName() + "), method '" + com_fossil_aiq.getName() + "': " + e.getMessage());
            }
        }
        return modifySecondaryTypesByAnnotation(serializationConfig, com_fossil_aiq, t);
    }

    public static <T extends JavaType> T modifySecondaryTypesByAnnotation(SerializationConfig serializationConfig, aiq com_fossil_aiq, T t) {
        AnnotationIntrospector annotationIntrospector = serializationConfig.getAnnotationIntrospector();
        if (t.isContainerType()) {
            Class findSerializationKeyType = annotationIntrospector.findSerializationKeyType(com_fossil_aiq, t.getKeyType());
            if (findSerializationKeyType != null) {
                if (t instanceof MapType) {
                    try {
                        t = ((MapType) t).widenKey(findSerializationKeyType);
                    } catch (IllegalArgumentException e) {
                        throw new IllegalArgumentException("Failed to narrow key type " + t + " with key-type annotation (" + findSerializationKeyType.getName() + "): " + e.getMessage());
                    }
                }
                throw new IllegalArgumentException("Illegal key-type annotation: type " + t + " is not a Map type");
            }
            Class findSerializationContentType = annotationIntrospector.findSerializationContentType(com_fossil_aiq, t.getContentType());
            if (findSerializationContentType != null) {
                try {
                    t = t.widenContentsBy(findSerializationContentType);
                } catch (IllegalArgumentException e2) {
                    throw new IllegalArgumentException("Failed to narrow content type " + t + " with content-type annotation (" + findSerializationContentType.getName() + "): " + e2.getMessage());
                }
            }
        }
        return t;
    }

    protected ahb<Object> _findKeySerializer(ahg com_fossil_ahg, aiq com_fossil_aiq) throws JsonMappingException {
        Object findKeySerializer = com_fossil_ahg.getAnnotationIntrospector().findKeySerializer(com_fossil_aiq);
        if (findKeySerializer != null) {
            return com_fossil_ahg.serializerInstance(com_fossil_aiq, findKeySerializer);
        }
        return null;
    }

    protected ahb<Object> _findContentSerializer(ahg com_fossil_ahg, aiq com_fossil_aiq) throws JsonMappingException {
        Object findContentSerializer = com_fossil_ahg.getAnnotationIntrospector().findContentSerializer(com_fossil_aiq);
        if (findContentSerializer != null) {
            return com_fossil_ahg.serializerInstance(com_fossil_aiq, findContentSerializer);
        }
        return null;
    }

    protected Object findFilterId(SerializationConfig serializationConfig, agu com_fossil_agu) {
        return serializationConfig.getAnnotationIntrospector().findFilterId(com_fossil_agu.Dn());
    }

    protected boolean usesStaticTyping(SerializationConfig serializationConfig, agu com_fossil_agu, ajv com_fossil_ajv) {
        if (com_fossil_ajv != null) {
            return false;
        }
        Typing findSerializationTyping = serializationConfig.getAnnotationIntrospector().findSerializationTyping(com_fossil_agu.Dn());
        if (findSerializationTyping == null || findSerializationTyping == Typing.DEFAULT_TYPING) {
            return serializationConfig.isEnabled(MapperFeature.USE_STATIC_TYPING);
        }
        if (findSerializationTyping == Typing.STATIC) {
            return true;
        }
        return false;
    }

    protected Class<?> _verifyAsClass(Object obj, String str, Class<?> cls) {
        if (obj == null) {
            return null;
        }
        if (obj instanceof Class) {
            Class<?> cls2 = (Class) obj;
            if (cls2 == cls || ami.m3854D(cls2)) {
                return null;
            }
            return cls2;
        }
        throw new IllegalStateException("AnnotationIntrospector." + str + "() returned value of type " + obj.getClass().getName() + ": expected type JsonSerializer or Class<JsonSerializer> instead");
    }
}
