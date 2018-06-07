package com.fasterxml.jackson.databind.ser.std;

import com.fasterxml.jackson.annotation.JsonFormat.C1501b;
import com.fasterxml.jackson.annotation.JsonFormat.Feature;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.ser.ContainerSerializer;
import com.fossil.agv;
import com.fossil.ahb;
import com.fossil.ahg;
import com.fossil.ajv;
import com.fossil.alg;
import java.io.IOException;

public abstract class ArraySerializerBase<T> extends ContainerSerializer<T> implements alg {
    protected final agv _property;
    protected final Boolean _unwrapSingle;

    public abstract ahb<?> _withResolved(agv com_fossil_agv, Boolean bool);

    protected abstract void serializeContents(T t, JsonGenerator jsonGenerator, ahg com_fossil_ahg) throws IOException;

    protected ArraySerializerBase(Class<T> cls) {
        super((Class) cls);
        this._property = null;
        this._unwrapSingle = null;
    }

    @Deprecated
    protected ArraySerializerBase(Class<T> cls, agv com_fossil_agv) {
        super((Class) cls);
        this._property = com_fossil_agv;
        this._unwrapSingle = null;
    }

    protected ArraySerializerBase(ArraySerializerBase<?> arraySerializerBase) {
        super(arraySerializerBase._handledType, false);
        this._property = arraySerializerBase._property;
        this._unwrapSingle = arraySerializerBase._unwrapSingle;
    }

    protected ArraySerializerBase(ArraySerializerBase<?> arraySerializerBase, agv com_fossil_agv, Boolean bool) {
        super(arraySerializerBase._handledType, false);
        this._property = com_fossil_agv;
        this._unwrapSingle = bool;
    }

    @Deprecated
    protected ArraySerializerBase(ArraySerializerBase<?> arraySerializerBase, agv com_fossil_agv) {
        super(arraySerializerBase._handledType, false);
        this._property = com_fossil_agv;
        this._unwrapSingle = arraySerializerBase._unwrapSingle;
    }

    public ahb<?> createContextual(ahg com_fossil_ahg, agv com_fossil_agv) throws JsonMappingException {
        if (com_fossil_agv == null) {
            return this;
        }
        C1501b findFormatOverrides = com_fossil_agv.findFormatOverrides(com_fossil_ahg.getAnnotationIntrospector());
        if (findFormatOverrides == null) {
            return this;
        }
        Boolean b = findFormatOverrides.m2653b(Feature.WRITE_SINGLE_ELEM_ARRAYS_UNWRAPPED);
        if (b != this._unwrapSingle) {
            return _withResolved(com_fossil_agv, b);
        }
        return this;
    }

    public void serialize(T t, JsonGenerator jsonGenerator, ahg com_fossil_ahg) throws IOException {
        if (((this._unwrapSingle == null && com_fossil_ahg.isEnabled(SerializationFeature.WRITE_SINGLE_ELEM_ARRAYS_UNWRAPPED)) || this._unwrapSingle == Boolean.TRUE) && hasSingleElement(t)) {
            serializeContents(t, jsonGenerator, com_fossil_ahg);
            return;
        }
        jsonGenerator.zH();
        jsonGenerator.bm(t);
        serializeContents(t, jsonGenerator, com_fossil_ahg);
        jsonGenerator.zI();
    }

    public final void serializeWithType(T t, JsonGenerator jsonGenerator, ahg com_fossil_ahg, ajv com_fossil_ajv) throws IOException {
        com_fossil_ajv.mo1032c(t, jsonGenerator);
        jsonGenerator.bm(t);
        serializeContents(t, jsonGenerator, com_fossil_ahg);
        com_fossil_ajv.mo1037f(t, jsonGenerator);
    }
}
