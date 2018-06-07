package com.fasterxml.jackson.databind.ser;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ser.impl.BeanAsArraySerializer;
import com.fasterxml.jackson.databind.ser.impl.UnwrappingBeanSerializer;
import com.fasterxml.jackson.databind.ser.std.BeanSerializerBase;
import com.fossil.ahb;
import com.fossil.ahg;
import com.fossil.ald;
import com.fossil.ale;
import com.fossil.als;
import com.fossil.amo;
import java.io.IOException;

public class BeanSerializer extends BeanSerializerBase {
    private static final long serialVersionUID = -4536893235025590367L;

    public BeanSerializer(JavaType javaType, ale com_fossil_ale, ald[] com_fossil_aldArr, ald[] com_fossil_aldArr2) {
        super(javaType, com_fossil_ale, com_fossil_aldArr, com_fossil_aldArr2);
    }

    protected BeanSerializer(BeanSerializerBase beanSerializerBase) {
        super(beanSerializerBase);
    }

    protected BeanSerializer(BeanSerializerBase beanSerializerBase, als com_fossil_als) {
        super(beanSerializerBase, com_fossil_als);
    }

    protected BeanSerializer(BeanSerializerBase beanSerializerBase, als com_fossil_als, Object obj) {
        super(beanSerializerBase, com_fossil_als, obj);
    }

    protected BeanSerializer(BeanSerializerBase beanSerializerBase, String[] strArr) {
        super(beanSerializerBase, strArr);
    }

    public static BeanSerializer createDummy(JavaType javaType) {
        return new BeanSerializer(javaType, null, NO_PROPS, null);
    }

    public ahb<Object> unwrappingSerializer(amo com_fossil_amo) {
        return new UnwrappingBeanSerializer((BeanSerializerBase) this, com_fossil_amo);
    }

    public BeanSerializerBase withObjectIdWriter(als com_fossil_als) {
        return new BeanSerializer(this, com_fossil_als, this._propertyFilterId);
    }

    public BeanSerializerBase withFilterId(Object obj) {
        return new BeanSerializer(this, this._objectIdWriter, obj);
    }

    protected BeanSerializerBase withIgnorals(String[] strArr) {
        return new BeanSerializer((BeanSerializerBase) this, strArr);
    }

    protected BeanSerializerBase asArraySerializer() {
        if (this._objectIdWriter == null && this._anyGetterWriter == null && this._propertyFilterId == null) {
            return new BeanAsArraySerializer(this);
        }
        return this;
    }

    public final void serialize(Object obj, JsonGenerator jsonGenerator, ahg com_fossil_ahg) throws IOException {
        if (this._objectIdWriter != null) {
            jsonGenerator.bm(obj);
            _serializeWithObjectId(obj, jsonGenerator, com_fossil_ahg, true);
            return;
        }
        jsonGenerator.zJ();
        jsonGenerator.bm(obj);
        if (this._propertyFilterId != null) {
            serializeFieldsFiltered(obj, jsonGenerator, com_fossil_ahg);
        } else {
            serializeFields(obj, jsonGenerator, com_fossil_ahg);
        }
        jsonGenerator.zK();
    }

    public String toString() {
        return "BeanSerializer for " + handledType().getName();
    }
}
