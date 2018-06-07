package com.fasterxml.jackson.databind.ser.impl;

import com.fasterxml.jackson.core.JsonGenerationException;
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
import java.util.Collection;

@ahh
public class StringCollectionSerializer extends StaticListSerializerBase<Collection<String>> {
    public static final StringCollectionSerializer instance = new StringCollectionSerializer();

    protected StringCollectionSerializer() {
        super(Collection.class);
    }

    protected StringCollectionSerializer(StringCollectionSerializer stringCollectionSerializer, ahb<?> com_fossil_ahb_, Boolean bool) {
        super(stringCollectionSerializer, com_fossil_ahb_, bool);
    }

    public ahb<?> _withResolved(agv com_fossil_agv, ahb<?> com_fossil_ahb_, Boolean bool) {
        return new StringCollectionSerializer(this, com_fossil_ahb_, bool);
    }

    protected agz contentSchema() {
        return createSchemaNode("string", true);
    }

    protected void acceptContentVisitor(ajc com_fossil_ajc) throws JsonMappingException {
        com_fossil_ajc.m3533a(JsonFormatTypes.STRING);
    }

    public void serialize(Collection<String> collection, JsonGenerator jsonGenerator, ahg com_fossil_ahg) throws IOException {
        int size = collection.size();
        if (size == 1 && ((this._unwrapSingle == null && com_fossil_ahg.isEnabled(SerializationFeature.WRITE_SINGLE_ELEM_ARRAYS_UNWRAPPED)) || this._unwrapSingle == Boolean.TRUE)) {
            m2753a(collection, jsonGenerator, com_fossil_ahg);
            return;
        }
        jsonGenerator.fk(size);
        if (this._serializer == null) {
            serializeContents(collection, jsonGenerator, com_fossil_ahg);
        } else {
            m2754b(collection, jsonGenerator, com_fossil_ahg);
        }
        jsonGenerator.zI();
    }

    private final void m2753a(Collection<String> collection, JsonGenerator jsonGenerator, ahg com_fossil_ahg) throws IOException {
        if (this._serializer == null) {
            serializeContents(collection, jsonGenerator, com_fossil_ahg);
        } else {
            m2754b(collection, jsonGenerator, com_fossil_ahg);
        }
    }

    public void serializeWithType(Collection<String> collection, JsonGenerator jsonGenerator, ahg com_fossil_ahg, ajv com_fossil_ajv) throws IOException, JsonGenerationException {
        com_fossil_ajv.mo1032c(collection, jsonGenerator);
        if (this._serializer == null) {
            serializeContents(collection, jsonGenerator, com_fossil_ahg);
        } else {
            m2754b(collection, jsonGenerator, com_fossil_ahg);
        }
        com_fossil_ajv.mo1037f(collection, jsonGenerator);
    }

    private final void serializeContents(Collection<String> collection, JsonGenerator jsonGenerator, ahg com_fossil_ahg) throws IOException, JsonGenerationException {
        if (this._serializer != null) {
            m2754b(collection, jsonGenerator, com_fossil_ahg);
            return;
        }
        int i = 0;
        for (String str : collection) {
            int i2;
            if (str == null) {
                try {
                    com_fossil_ahg.defaultSerializeNull(jsonGenerator);
                } catch (Throwable e) {
                    wrapAndThrow(com_fossil_ahg, e, (Object) collection, i);
                    i2 = i;
                }
            } else {
                jsonGenerator.writeString(str);
            }
            i2 = i + 1;
            i = i2;
        }
    }

    private void m2754b(Collection<String> collection, JsonGenerator jsonGenerator, ahg com_fossil_ahg) throws IOException, JsonGenerationException {
        ahb com_fossil_ahb = this._serializer;
        for (String str : collection) {
            if (str == null) {
                try {
                    com_fossil_ahg.defaultSerializeNull(jsonGenerator);
                } catch (Throwable e) {
                    wrapAndThrow(com_fossil_ahg, e, (Object) collection, 0);
                }
            } else {
                com_fossil_ahb.serialize(str, jsonGenerator, com_fossil_ahg);
            }
        }
    }
}
