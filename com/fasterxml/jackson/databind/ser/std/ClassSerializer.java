package com.fasterxml.jackson.databind.ser.std;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fossil.agz;
import com.fossil.ahg;
import com.fossil.ajg;
import java.io.IOException;
import java.lang.reflect.Type;

public class ClassSerializer extends StdScalarSerializer<Class<?>> {
    public ClassSerializer() {
        super(Class.class, false);
    }

    public void serialize(Class<?> cls, JsonGenerator jsonGenerator, ahg com_fossil_ahg) throws IOException, JsonGenerationException {
        jsonGenerator.writeString(cls.getName());
    }

    public agz getSchema(ahg com_fossil_ahg, Type type) {
        return createSchemaNode("string", true);
    }

    public void acceptJsonFormatVisitor(ajg com_fossil_ajg, JavaType javaType) throws JsonMappingException {
        com_fossil_ajg.mo1018f(javaType);
    }
}
