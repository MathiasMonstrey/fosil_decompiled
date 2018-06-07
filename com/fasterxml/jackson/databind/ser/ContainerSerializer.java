package com.fasterxml.jackson.databind.ser;

import com.fasterxml.jackson.databind.AnnotationIntrospector;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import com.fossil.agv;
import com.fossil.ahb;
import com.fossil.ahg;
import com.fossil.aiq;
import com.fossil.ajv;

public abstract class ContainerSerializer<T> extends StdSerializer<T> {
    public abstract ContainerSerializer<?> _withValueTypeSerializer(ajv com_fossil_ajv);

    public abstract ahb<?> getContentSerializer();

    public abstract JavaType getContentType();

    public abstract boolean hasSingleElement(T t);

    protected ContainerSerializer(Class<T> cls) {
        super((Class) cls);
    }

    protected ContainerSerializer(JavaType javaType) {
        super(javaType);
    }

    protected ContainerSerializer(Class<?> cls, boolean z) {
        super(cls, z);
    }

    protected ContainerSerializer(ContainerSerializer<?> containerSerializer) {
        super(containerSerializer._handledType, false);
    }

    public ContainerSerializer<?> withValueTypeSerializer(ajv com_fossil_ajv) {
        return com_fossil_ajv == null ? this : _withValueTypeSerializer(com_fossil_ajv);
    }

    @Deprecated
    public boolean isEmpty(T t) {
        return isEmpty(null, t);
    }

    protected boolean hasContentTypeAnnotation(ahg com_fossil_ahg, agv com_fossil_agv) {
        if (com_fossil_agv != null) {
            AnnotationIntrospector annotationIntrospector = com_fossil_ahg.getAnnotationIntrospector();
            aiq member = com_fossil_agv.getMember();
            if (!(member == null || annotationIntrospector == null || annotationIntrospector.findSerializationContentType(member, com_fossil_agv.getType()) == null)) {
                return true;
            }
        }
        return false;
    }
}
