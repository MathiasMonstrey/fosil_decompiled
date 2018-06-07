package com.fasterxml.jackson.databind.ser.std;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.jsonFormatVisitors.JsonValueFormat;
import com.fossil.agz;
import com.fossil.ahg;
import com.fossil.ahh;
import com.fossil.ajg;
import com.fossil.ajm;
import java.io.IOException;
import java.lang.reflect.Type;
import java.sql.Time;

@ahh
public class SqlTimeSerializer extends StdScalarSerializer<Time> {
    public SqlTimeSerializer() {
        super(Time.class);
    }

    public void serialize(Time time, JsonGenerator jsonGenerator, ahg com_fossil_ahg) throws IOException {
        jsonGenerator.writeString(time.toString());
    }

    public agz getSchema(ahg com_fossil_ahg, Type type) {
        return createSchemaNode("string", true);
    }

    public void acceptJsonFormatVisitor(ajg com_fossil_ajg, JavaType javaType) throws JsonMappingException {
        ajm f = com_fossil_ajg == null ? null : com_fossil_ajg.mo1018f(javaType);
        if (f != null) {
            f.m3535a(JsonValueFormat.DATE_TIME);
        }
    }
}
