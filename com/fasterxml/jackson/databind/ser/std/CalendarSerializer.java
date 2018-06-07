package com.fasterxml.jackson.databind.ser.std;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fossil.ahg;
import com.fossil.ahh;
import java.io.IOException;
import java.text.DateFormat;
import java.util.Calendar;

@ahh
public class CalendarSerializer extends DateTimeSerializerBase<Calendar> {
    public static final CalendarSerializer instance = new CalendarSerializer();

    public CalendarSerializer() {
        this(null, null);
    }

    public CalendarSerializer(Boolean bool, DateFormat dateFormat) {
        super(Calendar.class, bool, dateFormat);
    }

    public CalendarSerializer withFormat(Boolean bool, DateFormat dateFormat) {
        return new CalendarSerializer(bool, dateFormat);
    }

    protected long _timestamp(Calendar calendar) {
        return calendar == null ? 0 : calendar.getTimeInMillis();
    }

    public void serialize(Calendar calendar, JsonGenerator jsonGenerator, ahg com_fossil_ahg) throws IOException {
        if (_asTimestamp(com_fossil_ahg)) {
            jsonGenerator.mo933J(_timestamp(calendar));
        } else if (this._customFormat != null) {
            synchronized (this._customFormat) {
                jsonGenerator.writeString(this._customFormat.format(calendar.getTime()));
            }
        } else {
            com_fossil_ahg.defaultSerializeDateValue(calendar.getTime(), jsonGenerator);
        }
    }
}
