package com.fasterxml.jackson.databind.ser.std;

import com.fasterxml.jackson.annotation.JsonFormat.C1501b;
import com.fasterxml.jackson.annotation.JsonFormat.Feature;
import com.fasterxml.jackson.databind.AnnotationIntrospector;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fossil.agv;
import com.fossil.agz;
import com.fossil.ahb;
import com.fossil.ahg;
import com.fossil.aiq;
import com.fossil.ajc;
import com.fossil.ajg;
import com.fossil.alg;
import java.lang.reflect.Type;
import java.util.Collection;

public abstract class StaticListSerializerBase<T extends Collection<?>> extends StdSerializer<T> implements alg {
    protected final ahb<String> _serializer;
    protected final Boolean _unwrapSingle;

    public abstract ahb<?> _withResolved(agv com_fossil_agv, ahb<?> com_fossil_ahb_, Boolean bool);

    protected abstract void acceptContentVisitor(ajc com_fossil_ajc) throws JsonMappingException;

    protected abstract agz contentSchema();

    protected StaticListSerializerBase(Class<?> cls) {
        super(cls, false);
        this._serializer = null;
        this._unwrapSingle = null;
    }

    protected StaticListSerializerBase(StaticListSerializerBase<?> staticListSerializerBase, ahb<?> com_fossil_ahb_, Boolean bool) {
        super((StdSerializer) staticListSerializerBase);
        this._serializer = com_fossil_ahb_;
        this._unwrapSingle = bool;
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
            serializerInstance = this._serializer;
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
        return (com_fossil_ahb == this._serializer && b == this._unwrapSingle) ? this : _withResolved(com_fossil_agv, com_fossil_ahb, b);
    }

    @Deprecated
    public boolean isEmpty(T t) {
        return isEmpty(null, (Collection) t);
    }

    public boolean isEmpty(ahg com_fossil_ahg, T t) {
        return t == null || t.size() == 0;
    }

    public agz getSchema(ahg com_fossil_ahg, Type type) {
        return createSchemaNode("array", true).m3669a("items", contentSchema());
    }

    public void acceptJsonFormatVisitor(ajg com_fossil_ajg, JavaType javaType) throws JsonMappingException {
        acceptContentVisitor(com_fossil_ajg.mo1017e(javaType));
    }
}
