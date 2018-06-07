package com.fasterxml.jackson.databind.ser.std;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fossil.agz;
import com.fossil.ahg;
import com.fossil.ajg;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Type;

public class FileSerializer extends StdScalarSerializer<File> {
    public FileSerializer() {
        super(File.class);
    }

    public void serialize(File file, JsonGenerator jsonGenerator, ahg com_fossil_ahg) throws IOException {
        jsonGenerator.writeString(file.getAbsolutePath());
    }

    public agz getSchema(ahg com_fossil_ahg, Type type) {
        return createSchemaNode("string", true);
    }

    public void acceptJsonFormatVisitor(ajg com_fossil_ajg, JavaType javaType) throws JsonMappingException {
        com_fossil_ajg.mo1018f(javaType);
    }
}
