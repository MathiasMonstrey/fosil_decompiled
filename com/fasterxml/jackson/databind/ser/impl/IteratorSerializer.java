package com.fasterxml.jackson.databind.ser.impl;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.ser.ContainerSerializer;
import com.fasterxml.jackson.databind.ser.std.AsArraySerializerBase;
import com.fossil.agv;
import com.fossil.ahb;
import com.fossil.ahg;
import com.fossil.ahh;
import com.fossil.ajv;
import java.io.IOException;
import java.util.Iterator;

@ahh
public class IteratorSerializer extends AsArraySerializerBase<Iterator<?>> {
    public IteratorSerializer(JavaType javaType, boolean z, ajv com_fossil_ajv) {
        super(Iterator.class, javaType, z, com_fossil_ajv, null);
    }

    public IteratorSerializer(IteratorSerializer iteratorSerializer, agv com_fossil_agv, ajv com_fossil_ajv, ahb<?> com_fossil_ahb_, Boolean bool) {
        super((AsArraySerializerBase) iteratorSerializer, com_fossil_agv, com_fossil_ajv, (ahb) com_fossil_ahb_, bool);
    }

    public boolean isEmpty(ahg com_fossil_ahg, Iterator<?> it) {
        return it == null || !it.hasNext();
    }

    public boolean hasSingleElement(Iterator<?> it) {
        return false;
    }

    public ContainerSerializer<?> _withValueTypeSerializer(ajv com_fossil_ajv) {
        return new IteratorSerializer(this, this._property, com_fossil_ajv, this._elementSerializer, this._unwrapSingle);
    }

    public IteratorSerializer withResolved(agv com_fossil_agv, ajv com_fossil_ajv, ahb<?> com_fossil_ahb_, Boolean bool) {
        return new IteratorSerializer(this, com_fossil_agv, com_fossil_ajv, com_fossil_ahb_, bool);
    }

    public final void serialize(Iterator<?> it, JsonGenerator jsonGenerator, ahg com_fossil_ahg) throws IOException {
        if (((this._unwrapSingle == null && com_fossil_ahg.isEnabled(SerializationFeature.WRITE_SINGLE_ELEM_ARRAYS_UNWRAPPED)) || this._unwrapSingle == Boolean.TRUE) && hasSingleElement((Iterator) it)) {
            serializeContents((Iterator) it, jsonGenerator, com_fossil_ahg);
            return;
        }
        jsonGenerator.zH();
        serializeContents((Iterator) it, jsonGenerator, com_fossil_ahg);
        jsonGenerator.zI();
    }

    public void serializeContents(Iterator<?> it, JsonGenerator jsonGenerator, ahg com_fossil_ahg) throws IOException {
        Class cls = null;
        if (it.hasNext()) {
            ajv com_fossil_ajv = this._valueTypeSerializer;
            ahb com_fossil_ahb = null;
            do {
                Object next = it.next();
                if (next == null) {
                    com_fossil_ahg.defaultSerializeNull(jsonGenerator);
                } else {
                    ahb com_fossil_ahb2 = this._elementSerializer;
                    if (com_fossil_ahb2 == null) {
                        Class cls2 = next.getClass();
                        if (cls2 == cls) {
                            com_fossil_ahb2 = com_fossil_ahb;
                        } else {
                            com_fossil_ahb = com_fossil_ahg.findValueSerializer(cls2, this._property);
                            cls = cls2;
                            com_fossil_ahb2 = com_fossil_ahb;
                        }
                    }
                    if (com_fossil_ajv == null) {
                        com_fossil_ahb2.serialize(next, jsonGenerator, com_fossil_ahg);
                    } else {
                        com_fossil_ahb2.serializeWithType(next, jsonGenerator, com_fossil_ahg, com_fossil_ajv);
                    }
                }
            } while (it.hasNext());
        }
    }
}
