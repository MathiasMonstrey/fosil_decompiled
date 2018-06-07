package com.fasterxml.jackson.databind.ser.impl;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.ser.std.BeanSerializerBase;
import com.fossil.ahb;
import com.fossil.ahg;
import com.fossil.ajv;
import com.fossil.als;
import com.fossil.amo;
import java.io.IOException;

public class UnwrappingBeanSerializer extends BeanSerializerBase {
    private static final long serialVersionUID = 1;
    public final amo _nameTransformer;

    public UnwrappingBeanSerializer(BeanSerializerBase beanSerializerBase, amo com_fossil_amo) {
        super(beanSerializerBase, com_fossil_amo);
        this._nameTransformer = com_fossil_amo;
    }

    public UnwrappingBeanSerializer(UnwrappingBeanSerializer unwrappingBeanSerializer, als com_fossil_als) {
        super((BeanSerializerBase) unwrappingBeanSerializer, com_fossil_als);
        this._nameTransformer = unwrappingBeanSerializer._nameTransformer;
    }

    public UnwrappingBeanSerializer(UnwrappingBeanSerializer unwrappingBeanSerializer, als com_fossil_als, Object obj) {
        super((BeanSerializerBase) unwrappingBeanSerializer, com_fossil_als, obj);
        this._nameTransformer = unwrappingBeanSerializer._nameTransformer;
    }

    protected UnwrappingBeanSerializer(UnwrappingBeanSerializer unwrappingBeanSerializer, String[] strArr) {
        super((BeanSerializerBase) unwrappingBeanSerializer, strArr);
        this._nameTransformer = unwrappingBeanSerializer._nameTransformer;
    }

    public ahb<Object> unwrappingSerializer(amo com_fossil_amo) {
        return new UnwrappingBeanSerializer((BeanSerializerBase) this, com_fossil_amo);
    }

    public boolean isUnwrappingSerializer() {
        return true;
    }

    public BeanSerializerBase withObjectIdWriter(als com_fossil_als) {
        return new UnwrappingBeanSerializer(this, com_fossil_als);
    }

    public BeanSerializerBase withFilterId(Object obj) {
        return new UnwrappingBeanSerializer(this, this._objectIdWriter, obj);
    }

    protected BeanSerializerBase withIgnorals(String[] strArr) {
        return new UnwrappingBeanSerializer(this, strArr);
    }

    protected BeanSerializerBase asArraySerializer() {
        return this;
    }

    public final void serialize(Object obj, JsonGenerator jsonGenerator, ahg com_fossil_ahg) throws IOException {
        jsonGenerator.bm(obj);
        if (this._objectIdWriter != null) {
            _serializeWithObjectId(obj, jsonGenerator, com_fossil_ahg, false);
        } else if (this._propertyFilterId != null) {
            serializeFieldsFiltered(obj, jsonGenerator, com_fossil_ahg);
        } else {
            serializeFields(obj, jsonGenerator, com_fossil_ahg);
        }
    }

    public void serializeWithType(Object obj, JsonGenerator jsonGenerator, ahg com_fossil_ahg, ajv com_fossil_ajv) throws IOException {
        if (com_fossil_ahg.isEnabled(SerializationFeature.FAIL_ON_UNWRAPPED_TYPE_IDENTIFIERS)) {
            throw new JsonMappingException("Unwrapped property requires use of type information: can not serialize without disabling `SerializationFeature.FAIL_ON_UNWRAPPED_TYPE_IDENTIFIERS`");
        }
        jsonGenerator.bm(obj);
        if (this._objectIdWriter != null) {
            _serializeWithObjectId(obj, jsonGenerator, com_fossil_ahg, com_fossil_ajv);
        } else if (this._propertyFilterId != null) {
            serializeFieldsFiltered(obj, jsonGenerator, com_fossil_ahg);
        } else {
            serializeFields(obj, jsonGenerator, com_fossil_ahg);
        }
    }

    public String toString() {
        return "UnwrappingBeanSerializer for " + handledType().getName();
    }
}
