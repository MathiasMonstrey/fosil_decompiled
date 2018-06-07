package com.fasterxml.jackson.databind.ser.std;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fossil.ahg;
import com.fossil.ahh;
import java.io.IOException;
import java.text.DateFormat;
import java.util.Date;

@ahh
public class DateSerializer extends DateTimeSerializerBase<Date> {
    public static final DateSerializer instance = new DateSerializer();

    public DateSerializer() {
        this(null, null);
    }

    public DateSerializer(Boolean bool, DateFormat dateFormat) {
        super(Date.class, bool, dateFormat);
    }

    public DateSerializer withFormat(Boolean bool, DateFormat dateFormat) {
        return new DateSerializer(bool, dateFormat);
    }

    protected long _timestamp(Date date) {
        return date == null ? 0 : date.getTime();
    }

    public void serialize(Date date, JsonGenerator jsonGenerator, ahg com_fossil_ahg) throws IOException {
        if (_asTimestamp(com_fossil_ahg)) {
            jsonGenerator.mo933J(_timestamp(date));
        } else if (this._customFormat != null) {
            synchronized (this._customFormat) {
                jsonGenerator.writeString(this._customFormat.format(date));
            }
        } else {
            com_fossil_ahg.defaultSerializeDateValue(date, jsonGenerator);
        }
    }
}
