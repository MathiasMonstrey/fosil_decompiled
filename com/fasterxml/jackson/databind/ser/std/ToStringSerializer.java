package com.fasterxml.jackson.databind.ser.std;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fossil.agz;
import com.fossil.ahg;
import com.fossil.ahh;
import com.fossil.ajg;
import com.fossil.ajv;
import java.io.IOException;
import java.lang.reflect.Type;

@ahh
public class ToStringSerializer extends StdSerializer<Object> {
    public static final ToStringSerializer instance = new ToStringSerializer();

    public ToStringSerializer() {
        super(Object.class);
    }

    public ToStringSerializer(Class<?> cls) {
        super(cls, false);
    }

    @Deprecated
    public boolean isEmpty(Object obj) {
        return isEmpty(null, obj);
    }

    public boolean isEmpty(ahg com_fossil_ahg, Object obj) {
        if (obj == null) {
            return true;
        }
        return obj.toString().isEmpty();
    }

    public void serialize(Object obj, JsonGenerator jsonGenerator, ahg com_fossil_ahg) throws IOException {
        jsonGenerator.writeString(obj.toString());
    }

    public void serializeWithType(Object obj, JsonGenerator jsonGenerator, ahg com_fossil_ahg, ajv com_fossil_ajv) throws IOException {
        com_fossil_ajv.mo1026a(obj, jsonGenerator);
        serialize(obj, jsonGenerator, com_fossil_ahg);
        com_fossil_ajv.mo1034d(obj, jsonGenerator);
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
