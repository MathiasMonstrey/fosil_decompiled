package com.fasterxml.jackson.databind.ser.std;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fossil.ahg;
import com.fossil.ajv;
import java.io.IOException;

public abstract class NonTypedScalarSerializerBase<T> extends StdScalarSerializer<T> {
    protected NonTypedScalarSerializerBase(Class<T> cls) {
        super(cls);
    }

    protected NonTypedScalarSerializerBase(Class<?> cls, boolean z) {
        super(cls, z);
    }

    public final void serializeWithType(T t, JsonGenerator jsonGenerator, ahg com_fossil_ahg, ajv com_fossil_ajv) throws IOException {
        serialize(t, jsonGenerator, com_fossil_ahg);
    }
}
