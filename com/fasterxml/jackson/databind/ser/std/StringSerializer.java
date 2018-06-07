package com.fasterxml.jackson.databind.ser.std;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fossil.agz;
import com.fossil.ahg;
import com.fossil.ahh;
import com.fossil.ajg;
import java.io.IOException;
import java.lang.reflect.Type;

@ahh
public final class StringSerializer extends NonTypedScalarSerializerBase<Object> {
    private static final long serialVersionUID = 1;

    public StringSerializer() {
        super(String.class, false);
    }

    @Deprecated
    public boolean isEmpty(Object obj) {
        String str = (String) obj;
        return str == null || str.length() == 0;
    }

    public boolean isEmpty(ahg com_fossil_ahg, Object obj) {
        String str = (String) obj;
        return str == null || str.length() == 0;
    }

    public void serialize(Object obj, JsonGenerator jsonGenerator, ahg com_fossil_ahg) throws IOException {
        jsonGenerator.writeString((String) obj);
    }

    public agz getSchema(ahg com_fossil_ahg, Type type) {
        return createSchemaNode("string", true);
    }

    public void acceptJsonFormatVisitor(ajg com_fossil_ajg, JavaType javaType) throws JsonMappingException {
        if (com_fossil_ajg != null) {
            com_fossil_ajg.mo1018f(javaType);
        }
    }
}
