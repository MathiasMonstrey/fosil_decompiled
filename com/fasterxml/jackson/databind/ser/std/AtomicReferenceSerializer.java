package com.fasterxml.jackson.databind.ser.std;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.type.ReferenceType;
import com.fossil.agz;
import com.fossil.ahg;
import com.fossil.ajg;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.concurrent.atomic.AtomicReference;

public class AtomicReferenceSerializer extends StdSerializer<AtomicReference<?>> {
    private static final long serialVersionUID = 1;

    @Deprecated
    public AtomicReferenceSerializer() {
        super(AtomicReference.class, false);
    }

    public AtomicReferenceSerializer(ReferenceType referenceType) {
        super((JavaType) referenceType);
    }

    public boolean isEmpty(ahg com_fossil_ahg, AtomicReference<?> atomicReference) {
        return atomicReference == null || atomicReference.get() == null;
    }

    public void serialize(AtomicReference<?> atomicReference, JsonGenerator jsonGenerator, ahg com_fossil_ahg) throws IOException, JsonGenerationException {
        com_fossil_ahg.defaultSerializeValue(atomicReference.get(), jsonGenerator);
    }

    public agz getSchema(ahg com_fossil_ahg, Type type) {
        return createSchemaNode("any", true);
    }

    public void acceptJsonFormatVisitor(ajg com_fossil_ajg, JavaType javaType) throws JsonMappingException {
        com_fossil_ajg.mo1023k(javaType);
    }
}
