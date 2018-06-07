package com.fasterxml.jackson.databind.ser.std;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fossil.agv;
import com.fossil.ahb;
import com.fossil.ahg;
import com.fossil.ajv;
import java.io.IOException;
import java.util.EnumSet;
import java.util.Iterator;

public class EnumSetSerializer extends AsArraySerializerBase<EnumSet<? extends Enum<?>>> {
    public EnumSetSerializer(JavaType javaType) {
        super(EnumSet.class, javaType, true, null, null);
    }

    @Deprecated
    public EnumSetSerializer(JavaType javaType, agv com_fossil_agv) {
        this(javaType);
    }

    public EnumSetSerializer(EnumSetSerializer enumSetSerializer, agv com_fossil_agv, ajv com_fossil_ajv, ahb<?> com_fossil_ahb_, Boolean bool) {
        super((AsArraySerializerBase) enumSetSerializer, com_fossil_agv, com_fossil_ajv, (ahb) com_fossil_ahb_, bool);
    }

    public EnumSetSerializer _withValueTypeSerializer(ajv com_fossil_ajv) {
        return this;
    }

    public EnumSetSerializer withResolved(agv com_fossil_agv, ajv com_fossil_ajv, ahb<?> com_fossil_ahb_, Boolean bool) {
        return new EnumSetSerializer(this, com_fossil_agv, com_fossil_ajv, com_fossil_ahb_, bool);
    }

    public boolean isEmpty(ahg com_fossil_ahg, EnumSet<? extends Enum<?>> enumSet) {
        return enumSet == null || enumSet.isEmpty();
    }

    public boolean hasSingleElement(EnumSet<? extends Enum<?>> enumSet) {
        return enumSet.size() == 1;
    }

    public final void serialize(EnumSet<? extends Enum<?>> enumSet, JsonGenerator jsonGenerator, ahg com_fossil_ahg) throws IOException {
        int size = enumSet.size();
        if (size == 1 && ((this._unwrapSingle == null && com_fossil_ahg.isEnabled(SerializationFeature.WRITE_SINGLE_ELEM_ARRAYS_UNWRAPPED)) || this._unwrapSingle == Boolean.TRUE)) {
            serializeContents((EnumSet) enumSet, jsonGenerator, com_fossil_ahg);
            return;
        }
        jsonGenerator.fk(size);
        serializeContents((EnumSet) enumSet, jsonGenerator, com_fossil_ahg);
        jsonGenerator.zI();
    }

    public void serializeContents(EnumSet<? extends Enum<?>> enumSet, JsonGenerator jsonGenerator, ahg com_fossil_ahg) throws IOException {
        ahb com_fossil_ahb = this._elementSerializer;
        Iterator it = enumSet.iterator();
        ahb com_fossil_ahb2 = com_fossil_ahb;
        while (it.hasNext()) {
            Enum enumR = (Enum) it.next();
            if (com_fossil_ahb2 == null) {
                com_fossil_ahb2 = com_fossil_ahg.findValueSerializer(enumR.getDeclaringClass(), this._property);
            }
            com_fossil_ahb2.serialize(enumR, jsonGenerator, com_fossil_ahg);
        }
    }
}
