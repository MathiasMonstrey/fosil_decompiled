package com.fasterxml.jackson.databind.ser.std;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.AnnotationIntrospector;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.ser.ContainerSerializer;
import com.fasterxml.jackson.databind.type.TypeFactory;
import com.fossil.agv;
import com.fossil.agz;
import com.fossil.ahb;
import com.fossil.ahg;
import com.fossil.ahh;
import com.fossil.aiq;
import com.fossil.aje;
import com.fossil.ajg;
import com.fossil.aji;
import com.fossil.ajv;
import com.fossil.alg;
import com.fossil.alj;
import com.fossil.alk;
import com.fossil.alt;
import com.fossil.alt.C1678d;
import com.fossil.aly;
import com.fossil.amd;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.HashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.SortedMap;
import java.util.TreeMap;

@ahh
public class MapSerializer extends ContainerSerializer<Map<?, ?>> implements alg {
    protected static final JavaType UNSPECIFIED_TYPE = TypeFactory.unknownType();
    private static final long serialVersionUID = 1;
    protected alt _dynamicValueSerializers;
    protected final Object _filterId;
    protected final HashSet<String> _ignoredEntries;
    protected ahb<Object> _keySerializer;
    protected final JavaType _keyType;
    protected final agv _property;
    protected final boolean _sortKeys;
    protected final Object _suppressableValue;
    protected ahb<Object> _valueSerializer;
    protected final JavaType _valueType;
    protected final boolean _valueTypeIsStatic;
    protected final ajv _valueTypeSerializer;

    protected MapSerializer(HashSet<String> hashSet, JavaType javaType, JavaType javaType2, boolean z, ajv com_fossil_ajv, ahb<?> com_fossil_ahb_, ahb<?> com_fossil_ahb_2) {
        super(Map.class, false);
        this._ignoredEntries = hashSet;
        this._keyType = javaType;
        this._valueType = javaType2;
        this._valueTypeIsStatic = z;
        this._valueTypeSerializer = com_fossil_ajv;
        this._keySerializer = com_fossil_ahb_;
        this._valueSerializer = com_fossil_ahb_2;
        this._dynamicValueSerializers = alt.GM();
        this._property = null;
        this._filterId = null;
        this._sortKeys = false;
        this._suppressableValue = null;
    }

    protected void _ensureOverride() {
        if (getClass() != MapSerializer.class) {
            throw new IllegalStateException("Missing override in class " + getClass().getName());
        }
    }

    protected MapSerializer(MapSerializer mapSerializer, agv com_fossil_agv, ahb<?> com_fossil_ahb_, ahb<?> com_fossil_ahb_2, HashSet<String> hashSet) {
        super(Map.class, false);
        this._ignoredEntries = hashSet;
        this._keyType = mapSerializer._keyType;
        this._valueType = mapSerializer._valueType;
        this._valueTypeIsStatic = mapSerializer._valueTypeIsStatic;
        this._valueTypeSerializer = mapSerializer._valueTypeSerializer;
        this._keySerializer = com_fossil_ahb_;
        this._valueSerializer = com_fossil_ahb_2;
        this._dynamicValueSerializers = mapSerializer._dynamicValueSerializers;
        this._property = com_fossil_agv;
        this._filterId = mapSerializer._filterId;
        this._sortKeys = mapSerializer._sortKeys;
        this._suppressableValue = mapSerializer._suppressableValue;
    }

    @Deprecated
    protected MapSerializer(MapSerializer mapSerializer, ajv com_fossil_ajv) {
        this(mapSerializer, com_fossil_ajv, mapSerializer._suppressableValue);
    }

    protected MapSerializer(MapSerializer mapSerializer, ajv com_fossil_ajv, Object obj) {
        super(Map.class, false);
        this._ignoredEntries = mapSerializer._ignoredEntries;
        this._keyType = mapSerializer._keyType;
        this._valueType = mapSerializer._valueType;
        this._valueTypeIsStatic = mapSerializer._valueTypeIsStatic;
        this._valueTypeSerializer = com_fossil_ajv;
        this._keySerializer = mapSerializer._keySerializer;
        this._valueSerializer = mapSerializer._valueSerializer;
        this._dynamicValueSerializers = mapSerializer._dynamicValueSerializers;
        this._property = mapSerializer._property;
        this._filterId = mapSerializer._filterId;
        this._sortKeys = mapSerializer._sortKeys;
        Object obj2 = obj == Include.NON_ABSENT ? this._valueType.isReferenceType() ? Include.NON_EMPTY : Include.NON_NULL : obj;
        this._suppressableValue = obj2;
    }

    protected MapSerializer(MapSerializer mapSerializer, Object obj, boolean z) {
        super(Map.class, false);
        this._ignoredEntries = mapSerializer._ignoredEntries;
        this._keyType = mapSerializer._keyType;
        this._valueType = mapSerializer._valueType;
        this._valueTypeIsStatic = mapSerializer._valueTypeIsStatic;
        this._valueTypeSerializer = mapSerializer._valueTypeSerializer;
        this._keySerializer = mapSerializer._keySerializer;
        this._valueSerializer = mapSerializer._valueSerializer;
        this._dynamicValueSerializers = mapSerializer._dynamicValueSerializers;
        this._property = mapSerializer._property;
        this._filterId = obj;
        this._sortKeys = z;
        this._suppressableValue = mapSerializer._suppressableValue;
    }

    public MapSerializer _withValueTypeSerializer(ajv com_fossil_ajv) {
        if (this._valueTypeSerializer == com_fossil_ajv) {
            return this;
        }
        _ensureOverride();
        return new MapSerializer(this, com_fossil_ajv, null);
    }

    public MapSerializer withResolved(agv com_fossil_agv, ahb<?> com_fossil_ahb_, ahb<?> com_fossil_ahb_2, HashSet<String> hashSet, boolean z) {
        _ensureOverride();
        MapSerializer mapSerializer = new MapSerializer(this, com_fossil_agv, com_fossil_ahb_, com_fossil_ahb_2, hashSet);
        if (z != mapSerializer._sortKeys) {
            return new MapSerializer(mapSerializer, this._filterId, z);
        }
        return mapSerializer;
    }

    public MapSerializer withFilterId(Object obj) {
        if (this._filterId == obj) {
            return this;
        }
        _ensureOverride();
        return new MapSerializer(this, obj, this._sortKeys);
    }

    public MapSerializer withContentInclusion(Object obj) {
        if (obj == this._suppressableValue) {
            return this;
        }
        _ensureOverride();
        return new MapSerializer(this, this._valueTypeSerializer, obj);
    }

    public static MapSerializer construct(String[] strArr, JavaType javaType, boolean z, ajv com_fossil_ajv, ahb<Object> com_fossil_ahb_java_lang_Object, ahb<Object> com_fossil_ahb_java_lang_Object2, Object obj) {
        JavaType javaType2;
        JavaType javaType3;
        boolean z2;
        boolean z3 = false;
        HashSet b = (strArr == null || strArr.length == 0) ? null : amd.m3838b(strArr);
        if (javaType == null) {
            javaType2 = UNSPECIFIED_TYPE;
            javaType3 = javaType2;
        } else {
            javaType3 = javaType.getKeyType();
            javaType2 = javaType.getContentType();
        }
        if (!z) {
            if (javaType2 != null && javaType2.isFinal()) {
                z3 = true;
            }
            z2 = z3;
        } else if (javaType2.getRawClass() == Object.class) {
            z2 = false;
        } else {
            z2 = z;
        }
        MapSerializer mapSerializer = new MapSerializer(b, javaType3, javaType2, z2, com_fossil_ajv, com_fossil_ahb_java_lang_Object, com_fossil_ahb_java_lang_Object2);
        if (obj != null) {
            return mapSerializer.withFilterId(obj);
        }
        return mapSerializer;
    }

    public ahb<?> createContextual(ahg com_fossil_ahg, agv com_fossil_agv) throws JsonMappingException {
        Object obj;
        ahb com_fossil_ahb;
        ahb serializerInstance;
        boolean z;
        ahb com_fossil_ahb2 = null;
        AnnotationIntrospector annotationIntrospector = com_fossil_ahg.getAnnotationIntrospector();
        aiq member = com_fossil_agv == null ? null : com_fossil_agv.getMember();
        Object obj2 = this._suppressableValue;
        if (member == null || annotationIntrospector == null) {
            obj = obj2;
            com_fossil_ahb = null;
        } else {
            Object findKeySerializer = annotationIntrospector.findKeySerializer(member);
            if (findKeySerializer != null) {
                com_fossil_ahb = com_fossil_ahg.serializerInstance(member, findKeySerializer);
            } else {
                com_fossil_ahb = null;
            }
            Object findContentSerializer = annotationIntrospector.findContentSerializer(member);
            if (findContentSerializer != null) {
                serializerInstance = com_fossil_ahg.serializerInstance(member, findContentSerializer);
            } else {
                serializerInstance = null;
            }
            Include findSerializationInclusionForContent = annotationIntrospector.findSerializationInclusionForContent(member, null);
            if (findSerializationInclusionForContent != null) {
                obj = findSerializationInclusionForContent;
                com_fossil_ahb2 = serializerInstance;
            } else {
                obj = obj2;
                com_fossil_ahb2 = serializerInstance;
            }
        }
        if (com_fossil_ahb2 == null) {
            com_fossil_ahb2 = this._valueSerializer;
        }
        serializerInstance = findConvertingContentSerializer(com_fossil_ahg, com_fossil_agv, com_fossil_ahb2);
        if (serializerInstance != null) {
            serializerInstance = com_fossil_ahg.handleSecondaryContextualization(serializerInstance, com_fossil_agv);
        } else if ((this._valueTypeIsStatic && this._valueType.getRawClass() != Object.class) || hasContentTypeAnnotation(com_fossil_ahg, com_fossil_agv)) {
            serializerInstance = com_fossil_ahg.findValueSerializer(this._valueType, com_fossil_agv);
        }
        if (com_fossil_ahb == null) {
            com_fossil_ahb2 = this._keySerializer;
        } else {
            com_fossil_ahb2 = com_fossil_ahb;
        }
        if (com_fossil_ahb2 == null) {
            com_fossil_ahb = com_fossil_ahg.findKeySerializer(this._keyType, com_fossil_agv);
        } else {
            com_fossil_ahb = com_fossil_ahg.handleSecondaryContextualization(com_fossil_ahb2, com_fossil_agv);
        }
        HashSet hashSet = this._ignoredEntries;
        if (annotationIntrospector == null || member == null) {
            z = false;
        } else {
            HashSet hashSet2;
            String[] findPropertiesToIgnore = annotationIntrospector.findPropertiesToIgnore(member, true);
            if (findPropertiesToIgnore != null) {
                hashSet2 = hashSet == null ? new HashSet() : new HashSet(hashSet);
                for (Object add : findPropertiesToIgnore) {
                    hashSet2.add(add);
                }
            } else {
                hashSet2 = hashSet;
            }
            Boolean findSerializationSortAlphabetically = annotationIntrospector.findSerializationSortAlphabetically(member);
            boolean z2 = findSerializationSortAlphabetically != null && findSerializationSortAlphabetically.booleanValue();
            z = z2;
            hashSet = hashSet2;
        }
        ahb<?> withResolved = withResolved(com_fossil_agv, com_fossil_ahb, serializerInstance, hashSet, z);
        if (obj != this._suppressableValue) {
            withResolved = withResolved.withContentInclusion(obj);
        }
        if (com_fossil_agv == null) {
            return withResolved;
        }
        aiq member2 = com_fossil_agv.getMember();
        if (member2 == null) {
            return withResolved;
        }
        Object findFilterId = annotationIntrospector.findFilterId(member2);
        if (findFilterId != null) {
            return withResolved.withFilterId(findFilterId);
        }
        return withResolved;
    }

    public JavaType getContentType() {
        return this._valueType;
    }

    public ahb<?> getContentSerializer() {
        return this._valueSerializer;
    }

    public boolean isEmpty(ahg com_fossil_ahg, Map<?, ?> map) {
        return map == null || map.isEmpty();
    }

    public boolean hasSingleElement(Map<?, ?> map) {
        return map.size() == 1;
    }

    public ahb<?> getKeySerializer() {
        return this._keySerializer;
    }

    public void serialize(Map<?, ?> map, JsonGenerator jsonGenerator, ahg com_fossil_ahg) throws IOException {
        jsonGenerator.zJ();
        jsonGenerator.bm(map);
        if (!map.isEmpty()) {
            Map _orderEntries;
            Object obj = this._suppressableValue;
            if (obj == Include.ALWAYS) {
                obj = null;
            } else if (obj == null && !com_fossil_ahg.isEnabled(SerializationFeature.WRITE_NULL_MAP_VALUES)) {
                obj = Include.NON_NULL;
            }
            if (this._sortKeys || com_fossil_ahg.isEnabled(SerializationFeature.ORDER_MAP_ENTRIES_BY_KEYS)) {
                _orderEntries = _orderEntries(map);
            } else {
                Map<?, ?> map2 = map;
            }
            if (this._filterId != null) {
                serializeFilteredFields(_orderEntries, jsonGenerator, com_fossil_ahg, findPropertyFilter(com_fossil_ahg, this._filterId, _orderEntries), obj);
            } else if (obj != null) {
                serializeOptionalFields(_orderEntries, jsonGenerator, com_fossil_ahg, obj);
            } else if (this._valueSerializer != null) {
                serializeFieldsUsing(_orderEntries, jsonGenerator, com_fossil_ahg, this._valueSerializer);
            } else {
                serializeFields(_orderEntries, jsonGenerator, com_fossil_ahg);
            }
        }
        jsonGenerator.zK();
    }

    public void serializeWithType(Map<?, ?> map, JsonGenerator jsonGenerator, ahg com_fossil_ahg, ajv com_fossil_ajv) throws IOException {
        Object _orderEntries;
        com_fossil_ajv.mo1029b(map, jsonGenerator);
        jsonGenerator.bm(map);
        Map<?, ?> map2;
        if (map.isEmpty()) {
            map2 = map;
        } else {
            Object obj = this._suppressableValue;
            if (obj == Include.ALWAYS) {
                obj = null;
            } else if (obj == null && !com_fossil_ahg.isEnabled(SerializationFeature.WRITE_NULL_MAP_VALUES)) {
                obj = Include.NON_NULL;
            }
            if (this._sortKeys || com_fossil_ahg.isEnabled(SerializationFeature.ORDER_MAP_ENTRIES_BY_KEYS)) {
                _orderEntries = _orderEntries(map);
            } else {
                map2 = map;
            }
            if (this._filterId != null) {
                serializeFilteredFields(_orderEntries, jsonGenerator, com_fossil_ahg, findPropertyFilter(com_fossil_ahg, this._filterId, _orderEntries), obj);
            } else if (obj != null) {
                serializeOptionalFields(_orderEntries, jsonGenerator, com_fossil_ahg, obj);
            } else if (this._valueSerializer != null) {
                serializeFieldsUsing(_orderEntries, jsonGenerator, com_fossil_ahg, this._valueSerializer);
            } else {
                serializeFields(_orderEntries, jsonGenerator, com_fossil_ahg);
            }
        }
        com_fossil_ajv.mo1036e(_orderEntries, jsonGenerator);
    }

    public void serializeFields(Map<?, ?> map, JsonGenerator jsonGenerator, ahg com_fossil_ahg) throws IOException {
        if (this._valueTypeSerializer != null) {
            serializeTypedFields(map, jsonGenerator, com_fossil_ahg, null);
            return;
        }
        ahb com_fossil_ahb = this._keySerializer;
        HashSet hashSet = this._ignoredEntries;
        alt com_fossil_alt = this._dynamicValueSerializers;
        alt com_fossil_alt2 = com_fossil_alt;
        for (Entry entry : map.entrySet()) {
            Object value = entry.getValue();
            Object key = entry.getKey();
            if (key == null) {
                com_fossil_ahg.findNullKeySerializer(this._keyType, this._property).serialize(null, jsonGenerator, com_fossil_ahg);
            } else if (hashSet == null || !hashSet.contains(key)) {
                com_fossil_ahb.serialize(key, jsonGenerator, com_fossil_ahg);
            }
            if (value == null) {
                com_fossil_ahg.defaultSerializeNull(jsonGenerator);
                com_fossil_alt = com_fossil_alt2;
            } else {
                ahb com_fossil_ahb2;
                Class cls = value.getClass();
                ahb o = com_fossil_alt2.mo1085o(cls);
                ahb com_fossil_ahb3;
                if (o == null) {
                    if (this._valueType.hasGenericTypes()) {
                        o = _findAndAddDynamic(com_fossil_alt2, com_fossil_ahg.constructSpecializedType(this._valueType, cls), com_fossil_ahg);
                    } else {
                        o = _findAndAddDynamic(com_fossil_alt2, cls, com_fossil_ahg);
                    }
                    com_fossil_ahb3 = o;
                    com_fossil_alt = this._dynamicValueSerializers;
                    com_fossil_ahb2 = com_fossil_ahb3;
                } else {
                    com_fossil_ahb3 = o;
                    com_fossil_alt = com_fossil_alt2;
                    com_fossil_ahb2 = com_fossil_ahb3;
                }
                try {
                    com_fossil_ahb2.serialize(value, jsonGenerator, com_fossil_ahg);
                } catch (Throwable e) {
                    wrapAndThrow(com_fossil_ahg, e, (Object) map, "" + key);
                }
            }
            com_fossil_alt2 = com_fossil_alt;
        }
    }

    public void serializeOptionalFields(Map<?, ?> map, JsonGenerator jsonGenerator, ahg com_fossil_ahg, Object obj) throws IOException {
        if (this._valueTypeSerializer != null) {
            serializeTypedFields(map, jsonGenerator, com_fossil_ahg, obj);
            return;
        }
        HashSet hashSet = this._ignoredEntries;
        alt com_fossil_alt = this._dynamicValueSerializers;
        alt com_fossil_alt2 = com_fossil_alt;
        for (Entry entry : map.entrySet()) {
            ahb findNullKeySerializer;
            ahb com_fossil_ahb;
            Object key = entry.getKey();
            if (key == null) {
                findNullKeySerializer = com_fossil_ahg.findNullKeySerializer(this._keyType, this._property);
            } else if (hashSet == null || !hashSet.contains(key)) {
                findNullKeySerializer = this._keySerializer;
            }
            Object value = entry.getValue();
            if (value != null) {
                ahb com_fossil_ahb2;
                ahb com_fossil_ahb3 = this._valueSerializer;
                if (com_fossil_ahb3 == null) {
                    Class cls = value.getClass();
                    com_fossil_ahb3 = com_fossil_alt2.mo1085o(cls);
                    if (com_fossil_ahb3 == null) {
                        if (this._valueType.hasGenericTypes()) {
                            com_fossil_ahb3 = _findAndAddDynamic(com_fossil_alt2, com_fossil_ahg.constructSpecializedType(this._valueType, cls), com_fossil_ahg);
                        } else {
                            com_fossil_ahb3 = _findAndAddDynamic(com_fossil_alt2, cls, com_fossil_ahg);
                        }
                        com_fossil_ahb2 = com_fossil_ahb3;
                        com_fossil_alt = this._dynamicValueSerializers;
                        com_fossil_ahb = com_fossil_ahb2;
                        if (obj == Include.NON_EMPTY && r1.isEmpty(com_fossil_ahg, value)) {
                            com_fossil_alt2 = com_fossil_alt;
                        }
                    }
                }
                com_fossil_ahb2 = com_fossil_ahb3;
                com_fossil_alt = com_fossil_alt2;
                com_fossil_ahb = com_fossil_ahb2;
                com_fossil_alt2 = com_fossil_alt;
            } else if (obj == null) {
                com_fossil_alt = com_fossil_alt2;
                com_fossil_ahb = com_fossil_ahg.getDefaultNullValueSerializer();
            }
            try {
                findNullKeySerializer.serialize(key, jsonGenerator, com_fossil_ahg);
                com_fossil_ahb.serialize(value, jsonGenerator, com_fossil_ahg);
            } catch (Throwable e) {
                wrapAndThrow(com_fossil_ahg, e, (Object) map, "" + key);
            }
            com_fossil_alt2 = com_fossil_alt;
        }
    }

    protected void serializeFieldsUsing(Map<?, ?> map, JsonGenerator jsonGenerator, ahg com_fossil_ahg, ahb<Object> com_fossil_ahb_java_lang_Object) throws IOException {
        ahb com_fossil_ahb = this._keySerializer;
        HashSet hashSet = this._ignoredEntries;
        ajv com_fossil_ajv = this._valueTypeSerializer;
        for (Entry entry : map.entrySet()) {
            Object key = entry.getKey();
            if (hashSet == null || !hashSet.contains(key)) {
                if (key == null) {
                    com_fossil_ahg.findNullKeySerializer(this._keyType, this._property).serialize(null, jsonGenerator, com_fossil_ahg);
                } else {
                    com_fossil_ahb.serialize(key, jsonGenerator, com_fossil_ahg);
                }
                Object value = entry.getValue();
                if (value == null) {
                    com_fossil_ahg.defaultSerializeNull(jsonGenerator);
                } else if (com_fossil_ajv == null) {
                    try {
                        com_fossil_ahb_java_lang_Object.serialize(value, jsonGenerator, com_fossil_ahg);
                    } catch (Throwable e) {
                        wrapAndThrow(com_fossil_ahg, e, (Object) map, "" + key);
                    }
                } else {
                    com_fossil_ahb_java_lang_Object.serializeWithType(value, jsonGenerator, com_fossil_ahg, com_fossil_ajv);
                }
            }
        }
    }

    public void serializeFilteredFields(Map<?, ?> map, JsonGenerator jsonGenerator, ahg com_fossil_ahg, alj com_fossil_alj, Object obj) throws IOException {
        HashSet hashSet = this._ignoredEntries;
        alt com_fossil_alt = this._dynamicValueSerializers;
        alk com_fossil_aly = new aly(this._valueTypeSerializer, this._property);
        alt com_fossil_alt2 = com_fossil_alt;
        for (Entry entry : map.entrySet()) {
            Object key = entry.getKey();
            if (hashSet == null || !hashSet.contains(key)) {
                ahb findNullKeySerializer;
                ahb com_fossil_ahb;
                if (key == null) {
                    findNullKeySerializer = com_fossil_ahg.findNullKeySerializer(this._keyType, this._property);
                } else {
                    findNullKeySerializer = this._keySerializer;
                }
                Object value = entry.getValue();
                if (value != null) {
                    ahb com_fossil_ahb2;
                    ahb com_fossil_ahb3 = this._valueSerializer;
                    if (com_fossil_ahb3 == null) {
                        Class cls = value.getClass();
                        com_fossil_ahb3 = com_fossil_alt2.mo1085o(cls);
                        if (com_fossil_ahb3 == null) {
                            if (this._valueType.hasGenericTypes()) {
                                com_fossil_ahb3 = _findAndAddDynamic(com_fossil_alt2, com_fossil_ahg.constructSpecializedType(this._valueType, cls), com_fossil_ahg);
                            } else {
                                com_fossil_ahb3 = _findAndAddDynamic(com_fossil_alt2, cls, com_fossil_ahg);
                            }
                            com_fossil_ahb2 = com_fossil_ahb3;
                            com_fossil_alt = this._dynamicValueSerializers;
                            com_fossil_ahb = com_fossil_ahb2;
                            if (obj == Include.NON_EMPTY && r1.isEmpty(com_fossil_ahg, value)) {
                                com_fossil_alt2 = com_fossil_alt;
                            }
                        }
                    }
                    com_fossil_ahb2 = com_fossil_ahb3;
                    com_fossil_alt = com_fossil_alt2;
                    com_fossil_ahb = com_fossil_ahb2;
                    com_fossil_alt2 = com_fossil_alt;
                } else if (obj == null) {
                    com_fossil_alt = com_fossil_alt2;
                    com_fossil_ahb = com_fossil_ahg.getDefaultNullValueSerializer();
                }
                com_fossil_aly.m3801a(key, findNullKeySerializer, com_fossil_ahb);
                try {
                    com_fossil_alj.serializeAsField(value, jsonGenerator, com_fossil_ahg, com_fossil_aly);
                } catch (Throwable e) {
                    wrapAndThrow(com_fossil_ahg, e, (Object) map, "" + key);
                }
                com_fossil_alt2 = com_fossil_alt;
            }
        }
    }

    @Deprecated
    public void serializeFilteredFields(Map<?, ?> map, JsonGenerator jsonGenerator, ahg com_fossil_ahg, alj com_fossil_alj) throws IOException {
        serializeFilteredFields(map, jsonGenerator, com_fossil_ahg, com_fossil_alj, com_fossil_ahg.isEnabled(SerializationFeature.WRITE_NULL_MAP_VALUES) ? null : Include.NON_NULL);
    }

    protected void serializeTypedFields(Map<?, ?> map, JsonGenerator jsonGenerator, ahg com_fossil_ahg, Object obj) throws IOException {
        HashSet hashSet = this._ignoredEntries;
        alt com_fossil_alt = this._dynamicValueSerializers;
        alt com_fossil_alt2 = com_fossil_alt;
        for (Entry entry : map.entrySet()) {
            ahb findNullKeySerializer;
            ahb com_fossil_ahb;
            Object key = entry.getKey();
            if (key == null) {
                findNullKeySerializer = com_fossil_ahg.findNullKeySerializer(this._keyType, this._property);
            } else if (hashSet == null || !hashSet.contains(key)) {
                findNullKeySerializer = this._keySerializer;
            }
            Object value = entry.getValue();
            if (value != null) {
                ahb com_fossil_ahb2 = this._valueSerializer;
                Class cls = value.getClass();
                com_fossil_ahb2 = com_fossil_alt2.mo1085o(cls);
                ahb com_fossil_ahb3;
                if (com_fossil_ahb2 == null) {
                    if (this._valueType.hasGenericTypes()) {
                        com_fossil_ahb2 = _findAndAddDynamic(com_fossil_alt2, com_fossil_ahg.constructSpecializedType(this._valueType, cls), com_fossil_ahg);
                    } else {
                        com_fossil_ahb2 = _findAndAddDynamic(com_fossil_alt2, cls, com_fossil_ahg);
                    }
                    com_fossil_ahb3 = com_fossil_ahb2;
                    com_fossil_alt = this._dynamicValueSerializers;
                    com_fossil_ahb = com_fossil_ahb3;
                } else {
                    com_fossil_ahb3 = com_fossil_ahb2;
                    com_fossil_alt = com_fossil_alt2;
                    com_fossil_ahb = com_fossil_ahb3;
                }
                if (obj == Include.NON_EMPTY && r1.isEmpty(com_fossil_ahg, value)) {
                    com_fossil_alt2 = com_fossil_alt;
                }
            } else if (obj == null) {
                com_fossil_alt = com_fossil_alt2;
                com_fossil_ahb = com_fossil_ahg.getDefaultNullValueSerializer();
            }
            findNullKeySerializer.serialize(key, jsonGenerator, com_fossil_ahg);
            try {
                com_fossil_ahb.serializeWithType(value, jsonGenerator, com_fossil_ahg, this._valueTypeSerializer);
            } catch (Throwable e) {
                wrapAndThrow(com_fossil_ahg, e, (Object) map, "" + key);
            }
            com_fossil_alt2 = com_fossil_alt;
        }
    }

    @Deprecated
    protected void serializeTypedFields(Map<?, ?> map, JsonGenerator jsonGenerator, ahg com_fossil_ahg) throws IOException {
        serializeTypedFields(map, jsonGenerator, com_fossil_ahg, com_fossil_ahg.isEnabled(SerializationFeature.WRITE_NULL_MAP_VALUES) ? null : Include.NON_NULL);
    }

    public agz getSchema(ahg com_fossil_ahg, Type type) {
        return createSchemaNode("object", true);
    }

    public void acceptJsonFormatVisitor(ajg com_fossil_ajg, JavaType javaType) throws JsonMappingException {
        aji l = com_fossil_ajg == null ? null : com_fossil_ajg.mo1024l(javaType);
        if (l != null) {
            l.m3557b(this._keySerializer, this._keyType);
            aje com_fossil_aje = this._valueSerializer;
            if (com_fossil_aje == null) {
                com_fossil_aje = _findAndAddDynamic(this._dynamicValueSerializers, this._valueType, com_fossil_ajg.Gd());
            }
            l.m3558c(com_fossil_aje, this._valueType);
        }
    }

    protected final ahb<Object> _findAndAddDynamic(alt com_fossil_alt, Class<?> cls, ahg com_fossil_ahg) throws JsonMappingException {
        C1678d b = com_fossil_alt.m3771b((Class) cls, com_fossil_ahg, this._property);
        if (com_fossil_alt != b.aUN) {
            this._dynamicValueSerializers = b.aUN;
        }
        return b.aUD;
    }

    protected final ahb<Object> _findAndAddDynamic(alt com_fossil_alt, JavaType javaType, ahg com_fossil_ahg) throws JsonMappingException {
        C1678d b = com_fossil_alt.m3770b(javaType, com_fossil_ahg, this._property);
        if (com_fossil_alt != b.aUN) {
            this._dynamicValueSerializers = b.aUN;
        }
        return b.aUD;
    }

    protected Map<?, ?> _orderEntries(Map<?, ?> map) {
        return map instanceof SortedMap ? map : new TreeMap(map);
    }
}
