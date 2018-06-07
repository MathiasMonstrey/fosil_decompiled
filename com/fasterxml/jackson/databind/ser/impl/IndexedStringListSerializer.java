package com.fasterxml.jackson.databind.ser.impl;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.jsonFormatVisitors.JsonFormatTypes;
import com.fasterxml.jackson.databind.ser.std.StaticListSerializerBase;
import com.fossil.agv;
import com.fossil.agz;
import com.fossil.ahb;
import com.fossil.ahg;
import com.fossil.ahh;
import com.fossil.ajc;
import com.fossil.ajv;
import java.io.IOException;
import java.util.List;

@ahh
public final class IndexedStringListSerializer extends StaticListSerializerBase<List<String>> {
    public static final IndexedStringListSerializer instance = new IndexedStringListSerializer();
    private static final long serialVersionUID = 1;

    protected IndexedStringListSerializer() {
        super(List.class);
    }

    public IndexedStringListSerializer(IndexedStringListSerializer indexedStringListSerializer, ahb<?> com_fossil_ahb_, Boolean bool) {
        super(indexedStringListSerializer, com_fossil_ahb_, bool);
    }

    public ahb<?> _withResolved(agv com_fossil_agv, ahb<?> com_fossil_ahb_, Boolean bool) {
        return new IndexedStringListSerializer(this, com_fossil_ahb_, bool);
    }

    protected agz contentSchema() {
        return createSchemaNode("string", true);
    }

    protected void acceptContentVisitor(ajc com_fossil_ajc) throws JsonMappingException {
        com_fossil_ajc.m3533a(JsonFormatTypes.STRING);
    }

    public void serialize(List<String> list, JsonGenerator jsonGenerator, ahg com_fossil_ahg) throws IOException {
        int size = list.size();
        if (size == 1 && ((this._unwrapSingle == null && com_fossil_ahg.isEnabled(SerializationFeature.WRITE_SINGLE_ELEM_ARRAYS_UNWRAPPED)) || this._unwrapSingle == Boolean.TRUE)) {
            m2749a(list, jsonGenerator, com_fossil_ahg);
            return;
        }
        jsonGenerator.fk(size);
        if (this._serializer == null) {
            m2750a(list, jsonGenerator, com_fossil_ahg, size);
        } else {
            m2751b(list, jsonGenerator, com_fossil_ahg, size);
        }
        jsonGenerator.zI();
    }

    private final void m2749a(List<String> list, JsonGenerator jsonGenerator, ahg com_fossil_ahg) throws IOException {
        if (this._serializer == null) {
            m2750a(list, jsonGenerator, com_fossil_ahg, 1);
        } else {
            m2751b(list, jsonGenerator, com_fossil_ahg, 1);
        }
    }

    public void serializeWithType(List<String> list, JsonGenerator jsonGenerator, ahg com_fossil_ahg, ajv com_fossil_ajv) throws IOException {
        int size = list.size();
        com_fossil_ajv.mo1032c(list, jsonGenerator);
        if (this._serializer == null) {
            m2750a(list, jsonGenerator, com_fossil_ahg, size);
        } else {
            m2751b(list, jsonGenerator, com_fossil_ahg, size);
        }
        com_fossil_ajv.mo1037f(list, jsonGenerator);
    }

    private final void m2750a(List<String> list, JsonGenerator jsonGenerator, ahg com_fossil_ahg, int i) throws IOException {
        int i2 = 0;
        while (i2 < i) {
            try {
                String str = (String) list.get(i2);
                if (str == null) {
                    com_fossil_ahg.defaultSerializeNull(jsonGenerator);
                } else {
                    jsonGenerator.writeString(str);
                }
                i2++;
            } catch (Throwable e) {
                wrapAndThrow(com_fossil_ahg, e, (Object) list, i2);
                return;
            }
        }
    }

    private final void m2751b(List<String> list, JsonGenerator jsonGenerator, ahg com_fossil_ahg, int i) throws IOException {
        int i2 = 0;
        try {
            ahb com_fossil_ahb = this._serializer;
            while (i2 < i) {
                String str = (String) list.get(i2);
                if (str == null) {
                    com_fossil_ahg.defaultSerializeNull(jsonGenerator);
                } else {
                    com_fossil_ahb.serialize(str, jsonGenerator, com_fossil_ahg);
                }
                i2++;
            }
        } catch (Throwable e) {
            wrapAndThrow(com_fossil_ahg, e, (Object) list, 0);
        }
    }
}
