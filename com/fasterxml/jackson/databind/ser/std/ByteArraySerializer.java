package com.fasterxml.jackson.databind.ser.std;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.jsonFormatVisitors.JsonFormatTypes;
import com.fossil.agz;
import com.fossil.ahg;
import com.fossil.ahh;
import com.fossil.ajc;
import com.fossil.ajg;
import com.fossil.ajv;
import java.io.IOException;
import java.lang.reflect.Type;

@ahh
public class ByteArraySerializer extends StdSerializer<byte[]> {
    private static final long serialVersionUID = 1;

    public ByteArraySerializer() {
        super(byte[].class);
    }

    public boolean isEmpty(ahg com_fossil_ahg, byte[] bArr) {
        return bArr == null || bArr.length == 0;
    }

    public void serialize(byte[] bArr, JsonGenerator jsonGenerator, ahg com_fossil_ahg) throws IOException {
        jsonGenerator.mo936a(com_fossil_ahg.getConfig().getBase64Variant(), bArr, 0, bArr.length);
    }

    public void serializeWithType(byte[] bArr, JsonGenerator jsonGenerator, ahg com_fossil_ahg, ajv com_fossil_ajv) throws IOException {
        com_fossil_ajv.mo1026a(bArr, jsonGenerator);
        jsonGenerator.mo936a(com_fossil_ahg.getConfig().getBase64Variant(), bArr, 0, bArr.length);
        com_fossil_ajv.mo1034d(bArr, jsonGenerator);
    }

    public agz getSchema(ahg com_fossil_ahg, Type type) {
        return createSchemaNode("array", true).m3669a("items", createSchemaNode("string"));
    }

    public void acceptJsonFormatVisitor(ajg com_fossil_ajg, JavaType javaType) throws JsonMappingException {
        if (com_fossil_ajg != null) {
            ajc e = com_fossil_ajg.mo1017e(javaType);
            if (e != null) {
                e.m3533a(JsonFormatTypes.STRING);
            }
        }
    }
}
