package com.fasterxml.jackson.databind.ser.impl;

import com.fasterxml.jackson.annotation.JsonFormat.C1501b;
import com.fasterxml.jackson.annotation.JsonFormat.Feature;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.AnnotationIntrospector;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.jsonFormatVisitors.JsonFormatTypes;
import com.fasterxml.jackson.databind.ser.ContainerSerializer;
import com.fasterxml.jackson.databind.ser.std.ArraySerializerBase;
import com.fasterxml.jackson.databind.type.TypeFactory;
import com.fossil.agv;
import com.fossil.agz;
import com.fossil.ahb;
import com.fossil.ahg;
import com.fossil.ahh;
import com.fossil.aiq;
import com.fossil.ajc;
import com.fossil.ajg;
import com.fossil.ajv;
import com.fossil.alg;
import java.io.IOException;
import java.lang.reflect.Type;

@ahh
public class StringArraySerializer extends ArraySerializerBase<String[]> implements alg {
    private static final JavaType aUT = TypeFactory.defaultInstance().uncheckedSimpleType(String.class);
    public static final StringArraySerializer instance = new StringArraySerializer();
    protected final ahb<Object> _elementSerializer;

    protected StringArraySerializer() {
        super(String[].class);
        this._elementSerializer = null;
    }

    public StringArraySerializer(StringArraySerializer stringArraySerializer, agv com_fossil_agv, ahb<?> com_fossil_ahb_, Boolean bool) {
        super(stringArraySerializer, com_fossil_agv, bool);
        this._elementSerializer = com_fossil_ahb_;
    }

    public ahb<?> _withResolved(agv com_fossil_agv, Boolean bool) {
        return new StringArraySerializer(this, com_fossil_agv, this._elementSerializer, bool);
    }

    public ContainerSerializer<?> _withValueTypeSerializer(ajv com_fossil_ajv) {
        return this;
    }

    public ahb<?> createContextual(ahg com_fossil_ahg, agv com_fossil_agv) throws JsonMappingException {
        ahb serializerInstance;
        Boolean b;
        ahb com_fossil_ahb = null;
        if (com_fossil_agv != null) {
            C1501b findFormatOverrides;
            AnnotationIntrospector annotationIntrospector = com_fossil_ahg.getAnnotationIntrospector();
            aiq member = com_fossil_agv.getMember();
            if (member != null) {
                Object findContentSerializer = annotationIntrospector.findContentSerializer(member);
                if (findContentSerializer != null) {
                    serializerInstance = com_fossil_ahg.serializerInstance(member, findContentSerializer);
                    findFormatOverrides = com_fossil_agv.findFormatOverrides(annotationIntrospector);
                    b = findFormatOverrides == null ? findFormatOverrides.m2653b(Feature.WRITE_SINGLE_ELEM_ARRAYS_UNWRAPPED) : null;
                }
            }
            serializerInstance = null;
            findFormatOverrides = com_fossil_agv.findFormatOverrides(annotationIntrospector);
            if (findFormatOverrides == null) {
            }
        } else {
            b = null;
            serializerInstance = null;
        }
        if (serializerInstance == null) {
            serializerInstance = this._elementSerializer;
        }
        serializerInstance = findConvertingContentSerializer(com_fossil_ahg, com_fossil_agv, serializerInstance);
        if (serializerInstance == null) {
            serializerInstance = com_fossil_ahg.findValueSerializer(String.class, com_fossil_agv);
        } else {
            serializerInstance = com_fossil_ahg.handleSecondaryContextualization(serializerInstance, com_fossil_agv);
        }
        if (!isDefaultSerializer(serializerInstance)) {
            com_fossil_ahb = serializerInstance;
        }
        return (com_fossil_ahb == this._elementSerializer && b == this._unwrapSingle) ? this : new StringArraySerializer(this, com_fossil_agv, com_fossil_ahb, b);
    }

    public JavaType getContentType() {
        return aUT;
    }

    public ahb<?> getContentSerializer() {
        return this._elementSerializer;
    }

    public boolean isEmpty(ahg com_fossil_ahg, String[] strArr) {
        return strArr == null || strArr.length == 0;
    }

    public boolean hasSingleElement(String[] strArr) {
        return strArr.length == 1;
    }

    public final void serialize(String[] strArr, JsonGenerator jsonGenerator, ahg com_fossil_ahg) throws IOException {
        int length = strArr.length;
        if (length == 1 && ((this._unwrapSingle == null && com_fossil_ahg.isEnabled(SerializationFeature.WRITE_SINGLE_ELEM_ARRAYS_UNWRAPPED)) || this._unwrapSingle == Boolean.TRUE)) {
            serializeContents(strArr, jsonGenerator, com_fossil_ahg);
            return;
        }
        jsonGenerator.fk(length);
        serializeContents(strArr, jsonGenerator, com_fossil_ahg);
        jsonGenerator.zI();
    }

    public void serializeContents(String[] strArr, JsonGenerator jsonGenerator, ahg com_fossil_ahg) throws IOException {
        int length = strArr.length;
        if (length != 0) {
            if (this._elementSerializer != null) {
                m2752a(strArr, jsonGenerator, com_fossil_ahg, this._elementSerializer);
                return;
            }
            for (int i = 0; i < length; i++) {
                if (strArr[i] == null) {
                    jsonGenerator.zL();
                } else {
                    jsonGenerator.writeString(strArr[i]);
                }
            }
        }
    }

    private void m2752a(String[] strArr, JsonGenerator jsonGenerator, ahg com_fossil_ahg, ahb<Object> com_fossil_ahb_java_lang_Object) throws IOException {
        int length = strArr.length;
        for (int i = 0; i < length; i++) {
            if (strArr[i] == null) {
                com_fossil_ahg.defaultSerializeNull(jsonGenerator);
            } else {
                com_fossil_ahb_java_lang_Object.serialize(strArr[i], jsonGenerator, com_fossil_ahg);
            }
        }
    }

    public agz getSchema(ahg com_fossil_ahg, Type type) {
        return createSchemaNode("array", true).m3669a("items", createSchemaNode("string"));
    }

    public void acceptJsonFormatVisitor(ajg com_fossil_ajg, JavaType javaType) throws JsonMappingException {
        if (com_fossil_ajg != null) {
            ajc e = com_fossil_ajg.mo1017e(javaType);
            if (e != null) {
                e.m3533a(JsonFormatTypes.STRING);
            }
        }
    }
}
