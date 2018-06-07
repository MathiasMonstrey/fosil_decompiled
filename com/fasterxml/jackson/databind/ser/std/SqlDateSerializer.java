package com.fasterxml.jackson.databind.ser.std;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fossil.agz;
import com.fossil.ahg;
import com.fossil.ahh;
import com.fossil.ajg;
import java.io.IOException;
import java.lang.reflect.Type;
import java.sql.Date;
import java.text.DateFormat;

@ahh
public class SqlDateSerializer extends DateTimeSerializerBase<Date> {
    public SqlDateSerializer() {
        this(Boolean.FALSE);
    }

    protected SqlDateSerializer(Boolean bool) {
        super(Date.class, bool, null);
    }

    public SqlDateSerializer withFormat(Boolean bool, DateFormat dateFormat) {
        return new SqlDateSerializer(bool);
    }

    protected long _timestamp(Date date) {
        return date == null ? 0 : date.getTime();
    }

    public void serialize(Date date, JsonGenerator jsonGenerator, ahg com_fossil_ahg) throws IOException, JsonGenerationException {
        if (_asTimestamp(com_fossil_ahg)) {
            jsonGenerator.mo933J(_timestamp(date));
        } else {
            jsonGenerator.writeString(date.toString());
        }
    }

    public agz getSchema(ahg com_fossil_ahg, Type type) {
        return createSchemaNode("string", true);
    }

    public void acceptJsonFormatVisitor(ajg com_fossil_ajg, JavaType javaType) throws JsonMappingException {
        _acceptJsonFormatVisitor(com_fossil_ajg, javaType, this._useTimestamp.booleanValue());
    }
}
