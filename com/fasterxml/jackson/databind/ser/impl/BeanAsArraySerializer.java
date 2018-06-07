package com.fasterxml.jackson.databind.ser.impl;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonMappingException.Reference;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.ser.std.BeanSerializerBase;
import com.fossil.ahb;
import com.fossil.ahg;
import com.fossil.ajv;
import com.fossil.ald;
import com.fossil.als;
import com.fossil.amo;
import java.io.IOException;

public class BeanAsArraySerializer extends BeanSerializerBase {
    private static final long serialVersionUID = 1;
    protected final BeanSerializerBase _defaultSerializer;

    public BeanAsArraySerializer(BeanSerializerBase beanSerializerBase) {
        super(beanSerializerBase, (als) null);
        this._defaultSerializer = beanSerializerBase;
    }

    protected BeanAsArraySerializer(BeanSerializerBase beanSerializerBase, String[] strArr) {
        super(beanSerializerBase, strArr);
        this._defaultSerializer = beanSerializerBase;
    }

    protected BeanAsArraySerializer(BeanSerializerBase beanSerializerBase, als com_fossil_als, Object obj) {
        super(beanSerializerBase, com_fossil_als, obj);
        this._defaultSerializer = beanSerializerBase;
    }

    public ahb<Object> unwrappingSerializer(amo com_fossil_amo) {
        return this._defaultSerializer.unwrappingSerializer(com_fossil_amo);
    }

    public boolean isUnwrappingSerializer() {
        return false;
    }

    public BeanSerializerBase withObjectIdWriter(als com_fossil_als) {
        return this._defaultSerializer.withObjectIdWriter(com_fossil_als);
    }

    public BeanSerializerBase withFilterId(Object obj) {
        return new BeanAsArraySerializer(this, this._objectIdWriter, obj);
    }

    protected BeanAsArraySerializer withIgnorals(String[] strArr) {
        return new BeanAsArraySerializer(this, strArr);
    }

    protected BeanSerializerBase asArraySerializer() {
        return this;
    }

    public void serializeWithType(Object obj, JsonGenerator jsonGenerator, ahg com_fossil_ahg, ajv com_fossil_ajv) throws IOException {
        if (this._objectIdWriter != null) {
            _serializeWithObjectId(obj, jsonGenerator, com_fossil_ahg, com_fossil_ajv);
            return;
        }
        String _customTypeId = this._typeId == null ? null : _customTypeId(obj);
        if (_customTypeId == null) {
            com_fossil_ajv.mo1032c(obj, jsonGenerator);
        } else {
            com_fossil_ajv.mo1030b(obj, jsonGenerator, _customTypeId);
        }
        serializeAsArray(obj, jsonGenerator, com_fossil_ahg);
        if (_customTypeId == null) {
            com_fossil_ajv.mo1037f(obj, jsonGenerator);
        } else {
            com_fossil_ajv.mo1035d(obj, jsonGenerator, _customTypeId);
        }
    }

    public final void serialize(Object obj, JsonGenerator jsonGenerator, ahg com_fossil_ahg) throws IOException {
        if (com_fossil_ahg.isEnabled(SerializationFeature.WRITE_SINGLE_ELEM_ARRAYS_UNWRAPPED) && m2748c(com_fossil_ahg)) {
            serializeAsArray(obj, jsonGenerator, com_fossil_ahg);
            return;
        }
        jsonGenerator.zH();
        jsonGenerator.bm(obj);
        serializeAsArray(obj, jsonGenerator, com_fossil_ahg);
        jsonGenerator.zI();
    }

    private boolean m2748c(ahg com_fossil_ahg) {
        ald[] com_fossil_aldArr;
        if (this._filteredProps == null || com_fossil_ahg.getActiveView() == null) {
            com_fossil_aldArr = this._props;
        } else {
            com_fossil_aldArr = this._filteredProps;
        }
        return com_fossil_aldArr.length == 1;
    }

    protected final void serializeAsArray(Object obj, JsonGenerator jsonGenerator, ahg com_fossil_ahg) throws IOException {
        ald[] com_fossil_aldArr;
        if (this._filteredProps == null || com_fossil_ahg.getActiveView() == null) {
            com_fossil_aldArr = this._props;
        } else {
            com_fossil_aldArr = this._filteredProps;
        }
        int i = 0;
        try {
            int length = com_fossil_aldArr.length;
            while (i < length) {
                ald com_fossil_ald = com_fossil_aldArr[i];
                if (com_fossil_ald == null) {
                    jsonGenerator.zL();
                } else {
                    com_fossil_ald.mo1074d(obj, jsonGenerator, com_fossil_ahg);
                }
                i++;
            }
        } catch (Throwable e) {
            wrapAndThrow(com_fossil_ahg, e, obj, i == com_fossil_aldArr.length ? "[anySetter]" : com_fossil_aldArr[i].getName());
        } catch (Throwable e2) {
            JsonMappingException jsonMappingException = new JsonMappingException("Infinite recursion (StackOverflowError)", e2);
            jsonMappingException.prependPath(new Reference(obj, i == com_fossil_aldArr.length ? "[anySetter]" : com_fossil_aldArr[i].getName()));
            throw jsonMappingException;
        }
    }

    public String toString() {
        return "BeanAsArraySerializer for " + handledType().getName();
    }
}
