package com.fasterxml.jackson.databind.ser.std;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fossil.agz;
import com.fossil.ahg;
import com.fossil.ahh;
import com.fossil.ajg;
import com.fossil.ajv;
import com.fossil.amt;
import java.io.IOException;
import java.lang.reflect.Type;

@ahh
public class TokenBufferSerializer extends StdSerializer<amt> {
    public TokenBufferSerializer() {
        super(amt.class);
    }

    public void serialize(amt com_fossil_amt, JsonGenerator jsonGenerator, ahg com_fossil_ahg) throws IOException, JsonGenerationException {
        com_fossil_amt.m3925b(jsonGenerator);
    }

    public final void serializeWithType(amt com_fossil_amt, JsonGenerator jsonGenerator, ahg com_fossil_ahg, ajv com_fossil_ajv) throws IOException, JsonGenerationException {
        com_fossil_ajv.mo1026a(com_fossil_amt, jsonGenerator);
        serialize(com_fossil_amt, jsonGenerator, com_fossil_ahg);
        com_fossil_ajv.mo1034d(com_fossil_amt, jsonGenerator);
    }

    public agz getSchema(ahg com_fossil_ahg, Type type) {
        return createSchemaNode("any", true);
    }

    public void acceptJsonFormatVisitor(ajg com_fossil_ajg, JavaType javaType) throws JsonMappingException {
        com_fossil_ajg.mo1023k(javaType);
    }
}
