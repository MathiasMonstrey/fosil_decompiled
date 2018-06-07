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
public final class BooleanSerializer extends NonTypedScalarSerializerBase<Boolean> {
    private static final long serialVersionUID = 1;
    protected final boolean _forPrimitive;

    public BooleanSerializer(boolean z) {
        super(Boolean.class);
        this._forPrimitive = z;
    }

    public void serialize(Boolean bool, JsonGenerator jsonGenerator, ahg com_fossil_ahg) throws IOException {
        jsonGenerator.writeBoolean(bool.booleanValue());
    }

    public agz getSchema(ahg com_fossil_ahg, Type type) {
        return createSchemaNode("boolean", !this._forPrimitive);
    }

    public void acceptJsonFormatVisitor(ajg com_fossil_ajg, JavaType javaType) throws JsonMappingException {
        if (com_fossil_ajg != null) {
            com_fossil_ajg.mo1021i(javaType);
        }
    }
}
