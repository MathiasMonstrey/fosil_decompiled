package com.fasterxml.jackson.databind.ser.impl;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.AnnotationIntrospector;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.ser.ContainerSerializer;
import com.fossil.agv;
import com.fossil.ahb;
import com.fossil.ahg;
import com.fossil.ahh;
import com.fossil.aiq;
import com.fossil.ajv;
import com.fossil.alg;
import com.fossil.alt;
import com.fossil.alt.C1678d;
import java.io.IOException;
import java.util.Map;
import java.util.Map.Entry;

@ahh
public class MapEntrySerializer extends ContainerSerializer<Entry<?, ?>> implements alg {
    protected alt _dynamicValueSerializers;
    protected final JavaType _entryType;
    protected ahb<Object> _keySerializer;
    protected final JavaType _keyType;
    protected final agv _property;
    protected ahb<Object> _valueSerializer;
    protected final JavaType _valueType;
    protected final boolean _valueTypeIsStatic;
    protected final ajv _valueTypeSerializer;

    public MapEntrySerializer(JavaType javaType, JavaType javaType2, JavaType javaType3, boolean z, ajv com_fossil_ajv, agv com_fossil_agv) {
        super(javaType);
        this._entryType = javaType;
        this._keyType = javaType2;
        this._valueType = javaType3;
        this._valueTypeIsStatic = z;
        this._valueTypeSerializer = com_fossil_ajv;
        this._property = com_fossil_agv;
        this._dynamicValueSerializers = alt.GM();
    }

    protected MapEntrySerializer(MapEntrySerializer mapEntrySerializer, agv com_fossil_agv, ajv com_fossil_ajv, ahb<?> com_fossil_ahb_, ahb<?> com_fossil_ahb_2) {
        super(Map.class, false);
        this._entryType = mapEntrySerializer._entryType;
        this._keyType = mapEntrySerializer._keyType;
        this._valueType = mapEntrySerializer._valueType;
        this._valueTypeIsStatic = mapEntrySerializer._valueTypeIsStatic;
        this._valueTypeSerializer = mapEntrySerializer._valueTypeSerializer;
        this._keySerializer = com_fossil_ahb_;
        this._valueSerializer = com_fossil_ahb_2;
        this._dynamicValueSerializers = mapEntrySerializer._dynamicValueSerializers;
        this._property = mapEntrySerializer._property;
    }

    public ContainerSerializer<?> _withValueTypeSerializer(ajv com_fossil_ajv) {
        return new MapEntrySerializer(this, this._property, com_fossil_ajv, this._keySerializer, this._valueSerializer);
    }

    public MapEntrySerializer withResolved(agv com_fossil_agv, ahb<?> com_fossil_ahb_, ahb<?> com_fossil_ahb_2) {
        return new MapEntrySerializer(this, com_fossil_agv, this._valueTypeSerializer, com_fossil_ahb_, com_fossil_ahb_2);
    }

    public ahb<?> createContextual(ahg com_fossil_ahg, agv com_fossil_agv) throws JsonMappingException {
        ahb com_fossil_ahb;
        ahb handleSecondaryContextualization;
        ahb com_fossil_ahb2 = null;
        AnnotationIntrospector annotationIntrospector = com_fossil_ahg.getAnnotationIntrospector();
        aiq member = com_fossil_agv == null ? null : com_fossil_agv.getMember();
        if (member == null || annotationIntrospector == null) {
            com_fossil_ahb = null;
        } else {
            Object findKeySerializer = annotationIntrospector.findKeySerializer(member);
            if (findKeySerializer != null) {
                com_fossil_ahb = com_fossil_ahg.serializerInstance(member, findKeySerializer);
            } else {
                com_fossil_ahb = null;
            }
            Object findContentSerializer = annotationIntrospector.findContentSerializer(member);
            ahb com_fossil_ahb3;
            if (findContentSerializer != null) {
                com_fossil_ahb3 = com_fossil_ahb;
                com_fossil_ahb = com_fossil_ahg.serializerInstance(member, findContentSerializer);
                com_fossil_ahb2 = com_fossil_ahb3;
            } else {
                com_fossil_ahb3 = com_fossil_ahb;
                com_fossil_ahb = null;
                com_fossil_ahb2 = com_fossil_ahb3;
            }
        }
        if (com_fossil_ahb == null) {
            com_fossil_ahb = this._valueSerializer;
        }
        com_fossil_ahb = findConvertingContentSerializer(com_fossil_ahg, com_fossil_agv, com_fossil_ahb);
        if (com_fossil_ahb != null) {
            handleSecondaryContextualization = com_fossil_ahg.handleSecondaryContextualization(com_fossil_ahb, com_fossil_agv);
        } else if ((!this._valueTypeIsStatic || this._valueType.getRawClass() == Object.class) && !hasContentTypeAnnotation(com_fossil_ahg, com_fossil_agv)) {
            handleSecondaryContextualization = com_fossil_ahb;
        } else {
            handleSecondaryContextualization = com_fossil_ahg.findValueSerializer(this._valueType, com_fossil_agv);
        }
        if (com_fossil_ahb2 == null) {
            com_fossil_ahb = this._keySerializer;
        } else {
            com_fossil_ahb = com_fossil_ahb2;
        }
        if (com_fossil_ahb == null) {
            com_fossil_ahb = com_fossil_ahg.findKeySerializer(this._keyType, com_fossil_agv);
        } else {
            com_fossil_ahb = com_fossil_ahg.handleSecondaryContextualization(com_fossil_ahb, com_fossil_agv);
        }
        return withResolved(com_fossil_agv, com_fossil_ahb, handleSecondaryContextualization);
    }

    public JavaType getContentType() {
        return this._valueType;
    }

    public ahb<?> getContentSerializer() {
        return this._valueSerializer;
    }

    public boolean hasSingleElement(Entry<?, ?> entry) {
        return true;
    }

    public boolean isEmpty(ahg com_fossil_ahg, Entry<?, ?> entry) {
        return entry == null;
    }

    public void serialize(Entry<?, ?> entry, JsonGenerator jsonGenerator, ahg com_fossil_ahg) throws IOException {
        jsonGenerator.zJ();
        jsonGenerator.bm(entry);
        if (this._valueSerializer != null) {
            serializeUsing(entry, jsonGenerator, com_fossil_ahg, this._valueSerializer);
        } else {
            serializeDynamic(entry, jsonGenerator, com_fossil_ahg);
        }
        jsonGenerator.zK();
    }

    public void serializeWithType(Entry<?, ?> entry, JsonGenerator jsonGenerator, ahg com_fossil_ahg, ajv com_fossil_ajv) throws IOException {
        com_fossil_ajv.mo1029b(entry, jsonGenerator);
        jsonGenerator.bm(entry);
        if (this._valueSerializer != null) {
            serializeUsing(entry, jsonGenerator, com_fossil_ahg, this._valueSerializer);
        } else {
            serializeDynamic(entry, jsonGenerator, com_fossil_ahg);
        }
        com_fossil_ajv.mo1036e(entry, jsonGenerator);
    }

    protected void serializeDynamic(Entry<?, ?> entry, JsonGenerator jsonGenerator, ahg com_fossil_ahg) throws IOException {
        ahb com_fossil_ahb = this._keySerializer;
        Object obj = !com_fossil_ahg.isEnabled(SerializationFeature.WRITE_NULL_MAP_VALUES) ? 1 : null;
        ajv com_fossil_ajv = this._valueTypeSerializer;
        alt com_fossil_alt = this._dynamicValueSerializers;
        Object value = entry.getValue();
        Object key = entry.getKey();
        if (key == null) {
            com_fossil_ahg.findNullKeySerializer(this._keyType, this._property).serialize(null, jsonGenerator, com_fossil_ahg);
        } else if (obj == null || value != null) {
            com_fossil_ahb.serialize(key, jsonGenerator, com_fossil_ahg);
        } else {
            return;
        }
        if (value == null) {
            com_fossil_ahg.defaultSerializeNull(jsonGenerator);
            return;
        }
        Class cls = value.getClass();
        ahb o = com_fossil_alt.mo1085o(cls);
        if (o == null) {
            if (this._valueType.hasGenericTypes()) {
                o = _findAndAddDynamic(com_fossil_alt, com_fossil_ahg.constructSpecializedType(this._valueType, cls), com_fossil_ahg);
            } else {
                o = _findAndAddDynamic(com_fossil_alt, cls, com_fossil_ahg);
            }
            alt com_fossil_alt2 = this._dynamicValueSerializers;
        }
        if (com_fossil_ajv == null) {
            try {
                o.serialize(value, jsonGenerator, com_fossil_ahg);
                return;
            } catch (Throwable e) {
                wrapAndThrow(com_fossil_ahg, e, (Object) entry, "" + key);
                return;
            }
        }
        o.serializeWithType(value, jsonGenerator, com_fossil_ahg, com_fossil_ajv);
    }

    protected void serializeUsing(Entry<?, ?> entry, JsonGenerator jsonGenerator, ahg com_fossil_ahg, ahb<Object> com_fossil_ahb_java_lang_Object) throws IOException, JsonGenerationException {
        ahb com_fossil_ahb = this._keySerializer;
        ajv com_fossil_ajv = this._valueTypeSerializer;
        Object obj = !com_fossil_ahg.isEnabled(SerializationFeature.WRITE_NULL_MAP_VALUES) ? 1 : null;
        Object value = entry.getValue();
        Object key = entry.getKey();
        if (key == null) {
            com_fossil_ahg.findNullKeySerializer(this._keyType, this._property).serialize(null, jsonGenerator, com_fossil_ahg);
        } else if (obj == null || value != null) {
            com_fossil_ahb.serialize(key, jsonGenerator, com_fossil_ahg);
        } else {
            return;
        }
        if (value == null) {
            com_fossil_ahg.defaultSerializeNull(jsonGenerator);
        } else if (com_fossil_ajv == null) {
            try {
                com_fossil_ahb_java_lang_Object.serialize(value, jsonGenerator, com_fossil_ahg);
            } catch (Throwable e) {
                wrapAndThrow(com_fossil_ahg, e, (Object) entry, "" + key);
            }
        } else {
            com_fossil_ahb_java_lang_Object.serializeWithType(value, jsonGenerator, com_fossil_ahg, com_fossil_ajv);
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
}
