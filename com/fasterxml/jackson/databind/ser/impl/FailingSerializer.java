package com.fasterxml.jackson.databind.ser.impl;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import com.fossil.agz;
import com.fossil.ahg;
import com.fossil.ajg;
import java.io.IOException;
import java.lang.reflect.Type;

public class FailingSerializer extends StdSerializer<Object> {
    protected final String _msg;

    public FailingSerializer(String str) {
        super(Object.class);
        this._msg = str;
    }

    public void serialize(Object obj, JsonGenerator jsonGenerator, ahg com_fossil_ahg) throws IOException {
        throw new JsonGenerationException(this._msg);
    }

    public agz getSchema(ahg com_fossil_ahg, Type type) throws JsonMappingException {
        return null;
    }

    public void acceptJsonFormatVisitor(ajg com_fossil_ajg, JavaType javaType) {
    }
}
