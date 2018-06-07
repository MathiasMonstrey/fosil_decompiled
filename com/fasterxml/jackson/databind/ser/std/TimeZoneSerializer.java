package com.fasterxml.jackson.databind.ser.std;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fossil.ahg;
import com.fossil.ajv;
import java.io.IOException;
import java.util.TimeZone;

public class TimeZoneSerializer extends StdScalarSerializer<TimeZone> {
    public TimeZoneSerializer() {
        super(TimeZone.class);
    }

    public void serialize(TimeZone timeZone, JsonGenerator jsonGenerator, ahg com_fossil_ahg) throws IOException {
        jsonGenerator.writeString(timeZone.getID());
    }

    public void serializeWithType(TimeZone timeZone, JsonGenerator jsonGenerator, ahg com_fossil_ahg, ajv com_fossil_ajv) throws IOException {
        com_fossil_ajv.mo1027a((Object) timeZone, jsonGenerator, TimeZone.class);
        serialize(timeZone, jsonGenerator, com_fossil_ahg);
        com_fossil_ajv.mo1034d(timeZone, jsonGenerator);
    }
}
