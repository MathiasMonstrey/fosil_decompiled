package com.fasterxml.jackson.databind.ser.std;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.AnnotationIntrospector;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.introspect.AnnotatedMember;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fossil.agv;
import com.fossil.agz;
import com.fossil.ahb;
import com.fossil.ahg;
import com.fossil.aje;
import com.fossil.ajg;
import com.fossil.ajq;
import com.fossil.akv;
import com.fossil.alh;
import com.fossil.alj;
import com.fossil.ami;
import com.fossil.amk;
import java.io.IOException;
import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Type;

public abstract class StdSerializer<T> extends ahb<T> implements aje, ajq, Serializable {
    private static final long serialVersionUID = 1;
    protected final Class<T> _handledType;

    public abstract void serialize(T t, JsonGenerator jsonGenerator, ahg com_fossil_ahg) throws IOException;

    protected StdSerializer(Class<T> cls) {
        this._handledType = cls;
    }

    protected StdSerializer(JavaType javaType) {
        this._handledType = javaType.getRawClass();
    }

    protected StdSerializer(Class<?> cls, boolean z) {
        this._handledType = cls;
    }

    protected StdSerializer(StdSerializer<?> stdSerializer) {
        this._handledType = stdSerializer._handledType;
    }

    public Class<T> handledType() {
        return this._handledType;
    }

    public agz getSchema(ahg com_fossil_ahg, Type type) throws JsonMappingException {
        return createSchemaNode("string");
    }

    public agz getSchema(ahg com_fossil_ahg, Type type, boolean z) throws JsonMappingException {
        akv com_fossil_akv = (akv) getSchema(com_fossil_ahg, type);
        if (!z) {
            com_fossil_akv.m3674f("required", !z);
        }
        return com_fossil_akv;
    }

    protected akv createObjectNode() {
        return JsonNodeFactory.instance.objectNode();
    }

    protected akv createSchemaNode(String str) {
        akv createObjectNode = createObjectNode();
        createObjectNode.m3675t("type", str);
        return createObjectNode;
    }

    protected akv createSchemaNode(String str, boolean z) {
        akv createSchemaNode = createSchemaNode(str);
        if (!z) {
            createSchemaNode.m3674f("required", !z);
        }
        return createSchemaNode;
    }

    public void acceptJsonFormatVisitor(ajg com_fossil_ajg, JavaType javaType) throws JsonMappingException {
        com_fossil_ajg.mo1023k(javaType);
    }

    public void wrapAndThrow(ahg com_fossil_ahg, Throwable th, Object obj, String str) throws IOException {
        Throwable th2 = th;
        while ((th2 instanceof InvocationTargetException) && th2.getCause() != null) {
            th2 = th2.getCause();
        }
        if (th2 instanceof Error) {
            throw ((Error) th2);
        }
        Object obj2 = (com_fossil_ahg == null || com_fossil_ahg.isEnabled(SerializationFeature.WRAP_EXCEPTIONS)) ? 1 : null;
        if (th2 instanceof IOException) {
            if (obj2 == null || !(th2 instanceof JsonMappingException)) {
                throw ((IOException) th2);
            }
        } else if (obj2 == null && (th2 instanceof RuntimeException)) {
            throw ((RuntimeException) th2);
        }
        throw JsonMappingException.wrapWithPath(th2, obj, str);
    }

    public void wrapAndThrow(ahg com_fossil_ahg, Throwable th, Object obj, int i) throws IOException {
        Throwable th2 = th;
        while ((th2 instanceof InvocationTargetException) && th2.getCause() != null) {
            th2 = th2.getCause();
        }
        if (th2 instanceof Error) {
            throw ((Error) th2);
        }
        Object obj2 = (com_fossil_ahg == null || com_fossil_ahg.isEnabled(SerializationFeature.WRAP_EXCEPTIONS)) ? 1 : null;
        if (th2 instanceof IOException) {
            if (obj2 == null || !(th2 instanceof JsonMappingException)) {
                throw ((IOException) th2);
            }
        } else if (obj2 == null && (th2 instanceof RuntimeException)) {
            throw ((RuntimeException) th2);
        }
        throw JsonMappingException.wrapWithPath(th2, obj, i);
    }

    protected boolean isDefaultSerializer(ahb<?> com_fossil_ahb_) {
        return ami.bG(com_fossil_ahb_);
    }

    protected ahb<?> findConvertingContentSerializer(ahg com_fossil_ahg, agv com_fossil_agv, ahb<?> com_fossil_ahb_) throws JsonMappingException {
        AnnotationIntrospector annotationIntrospector = com_fossil_ahg.getAnnotationIntrospector();
        if (annotationIntrospector == null || com_fossil_agv == null) {
            return com_fossil_ahb_;
        }
        AnnotatedMember member = com_fossil_agv.getMember();
        if (member == null) {
            return com_fossil_ahb_;
        }
        Object findSerializationContentConverter = annotationIntrospector.findSerializationContentConverter(member);
        if (findSerializationContentConverter == null) {
            return com_fossil_ahb_;
        }
        amk converterInstance = com_fossil_ahg.converterInstance(com_fossil_agv.getMember(), findSerializationContentConverter);
        JavaType b = converterInstance.m3879b(com_fossil_ahg.getTypeFactory());
        if (com_fossil_ahb_ == null && !b.hasRawClass(Object.class)) {
            com_fossil_ahb_ = com_fossil_ahg.findValueSerializer(b);
        }
        return new StdDelegatingSerializer(converterInstance, b, com_fossil_ahb_);
    }

    protected alj findPropertyFilter(ahg com_fossil_ahg, Object obj, Object obj2) throws JsonMappingException {
        alh filterProvider = com_fossil_ahg.getFilterProvider();
        if (filterProvider != null) {
            return filterProvider.m3722m(obj, obj2);
        }
        throw new JsonMappingException("Can not resolve PropertyFilter with id '" + obj + "'; no FilterProvider configured");
    }
}
