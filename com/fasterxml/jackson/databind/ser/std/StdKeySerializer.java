package com.fasterxml.jackson.databind.ser.std;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fossil.agz;
import com.fossil.ahg;
import com.fossil.ajg;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.Date;

public class StdKeySerializer extends StdSerializer<Object> {
    public StdKeySerializer() {
        super(Object.class);
    }

    public void serialize(Object obj, JsonGenerator jsonGenerator, ahg com_fossil_ahg) throws IOException {
        Class cls = obj.getClass();
        if (cls == String.class) {
            obj = (String) obj;
        } else if (Date.class.isAssignableFrom(cls)) {
            com_fossil_ahg.defaultSerializeDateKey((Date) obj, jsonGenerator);
            return;
        } else if (cls == Class.class) {
            obj = ((Class) obj).getName();
        } else {
            obj = obj.toString();
        }
        jsonGenerator.aQ(obj);
    }

    public agz getSchema(ahg com_fossil_ahg, Type type) throws JsonMappingException {
        return createSchemaNode("string");
    }

    public void acceptJsonFormatVisitor(ajg com_fossil_ajg, JavaType javaType) throws JsonMappingException {
        com_fossil_ajg.mo1018f(javaType);
    }
}
