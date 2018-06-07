package com.fasterxml.jackson.databind.ser.impl;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import com.fossil.agz;
import com.fossil.ahg;
import com.fossil.ajg;
import com.fossil.ajv;
import java.io.IOException;
import java.lang.reflect.Type;

public class UnknownSerializer extends StdSerializer<Object> {
    public UnknownSerializer() {
        super(Object.class);
    }

    public UnknownSerializer(Class<?> cls) {
        super(cls, false);
    }

    public void serialize(Object obj, JsonGenerator jsonGenerator, ahg com_fossil_ahg) throws IOException {
        if (com_fossil_ahg.isEnabled(SerializationFeature.FAIL_ON_EMPTY_BEANS)) {
            failForEmpty(obj);
        }
        jsonGenerator.zJ();
        jsonGenerator.zK();
    }

    public final void serializeWithType(Object obj, JsonGenerator jsonGenerator, ahg com_fossil_ahg, ajv com_fossil_ajv) throws IOException {
        if (com_fossil_ahg.isEnabled(SerializationFeature.FAIL_ON_EMPTY_BEANS)) {
            failForEmpty(obj);
        }
        com_fossil_ajv.mo1029b(obj, jsonGenerator);
        com_fossil_ajv.mo1036e(obj, jsonGenerator);
    }

    public boolean isEmpty(ahg com_fossil_ahg, Object obj) {
        return true;
    }

    public agz getSchema(ahg com_fossil_ahg, Type type) throws JsonMappingException {
        return null;
    }

    public void acceptJsonFormatVisitor(ajg com_fossil_ajg, JavaType javaType) throws JsonMappingException {
        com_fossil_ajg.mo1023k(javaType);
    }

    protected void failForEmpty(Object obj) throws JsonMappingException {
        throw new JsonMappingException("No serializer found for class " + obj.getClass().getName() + " and no properties discovered to create BeanSerializer (to avoid exception, disable SerializationFeature.FAIL_ON_EMPTY_BEANS) )");
    }
}
