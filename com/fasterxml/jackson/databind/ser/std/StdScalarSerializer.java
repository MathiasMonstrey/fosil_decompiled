package com.fasterxml.jackson.databind.ser.std;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fossil.agz;
import com.fossil.ahg;
import com.fossil.ajg;
import com.fossil.ajv;
import java.io.IOException;
import java.lang.reflect.Type;

public abstract class StdScalarSerializer<T> extends StdSerializer<T> {
    protected StdScalarSerializer(Class<T> cls) {
        super((Class) cls);
    }

    protected StdScalarSerializer(Class<?> cls, boolean z) {
        super((Class) cls);
    }

    public void serializeWithType(T t, JsonGenerator jsonGenerator, ahg com_fossil_ahg, ajv com_fossil_ajv) throws IOException {
        com_fossil_ajv.mo1026a(t, jsonGenerator);
        serialize(t, jsonGenerator, com_fossil_ahg);
        com_fossil_ajv.mo1034d(t, jsonGenerator);
    }

    public agz getSchema(ahg com_fossil_ahg, Type type) throws JsonMappingException {
        return createSchemaNode("string", true);
    }

    public void acceptJsonFormatVisitor(ajg com_fossil_ajg, JavaType javaType) throws JsonMappingException {
        if (com_fossil_ajg != null) {
            com_fossil_ajg.mo1018f(javaType);
        }
    }
}
