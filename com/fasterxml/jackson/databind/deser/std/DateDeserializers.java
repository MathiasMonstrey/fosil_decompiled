package com.fasterxml.jackson.databind.deser.std;

import com.fasterxml.jackson.annotation.JsonFormat.C1501b;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.util.StdDateFormat;
import com.fossil.agv;
import com.fossil.agy;
import com.fossil.ahh;
import com.fossil.ahv;
import java.io.IOException;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashSet;
import java.util.TimeZone;

public class DateDeserializers {
    private static final HashSet<String> aSd = new HashSet();

    public static abstract class DateBasedDeserializer<T> extends StdScalarDeserializer<T> implements ahv {
        protected final DateFormat _customFormat;
        protected final String _formatString;

        protected abstract DateBasedDeserializer<T> withDateFormat(DateFormat dateFormat, String str);

        protected DateBasedDeserializer(Class<?> cls) {
            super((Class) cls);
            this._customFormat = null;
            this._formatString = null;
        }

        protected DateBasedDeserializer(DateBasedDeserializer<T> dateBasedDeserializer, DateFormat dateFormat, String str) {
            super(dateBasedDeserializer._valueClass);
            this._customFormat = dateFormat;
            this._formatString = str;
        }

        public agy<?> createContextual(DeserializationContext deserializationContext, agv com_fossil_agv) throws JsonMappingException {
            if (com_fossil_agv == null) {
                return this;
            }
            C1501b findFormat = deserializationContext.getAnnotationIntrospector().findFormat(com_fossil_agv.getMember());
            if (findFormat == null) {
                return this;
            }
            TimeZone timeZone = findFormat.getTimeZone();
            if (findFormat.za()) {
                TimeZone timeZone2;
                String pattern = findFormat.getPattern();
                DateFormat simpleDateFormat = new SimpleDateFormat(pattern, findFormat.zb() ? findFormat.getLocale() : deserializationContext.getLocale());
                if (timeZone == null) {
                    timeZone2 = deserializationContext.getTimeZone();
                } else {
                    timeZone2 = timeZone;
                }
                simpleDateFormat.setTimeZone(timeZone2);
                return withDateFormat(simpleDateFormat, pattern);
            } else if (timeZone == null) {
                return this;
            } else {
                DateFormat dateFormat = deserializationContext.getConfig().getDateFormat();
                if (dateFormat.getClass() == StdDateFormat.class) {
                    dateFormat = ((StdDateFormat) dateFormat).withTimeZone(timeZone).withLocale(findFormat.zb() ? findFormat.getLocale() : deserializationContext.getLocale());
                } else {
                    dateFormat = (DateFormat) dateFormat.clone();
                    dateFormat.setTimeZone(timeZone);
                }
                return withDateFormat(dateFormat, this._formatString);
            }
        }

        protected Date _parseDate(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
            if (this._customFormat != null) {
                JsonToken zU = jsonParser.zU();
                Date parse;
                if (zU == JsonToken.VALUE_STRING) {
                    String trim = jsonParser.getText().trim();
                    if (trim.length() == 0) {
                        return (Date) getEmptyValue(deserializationContext);
                    }
                    synchronized (this._customFormat) {
                        try {
                            parse = this._customFormat.parse(trim);
                        } catch (ParseException e) {
                            throw new IllegalArgumentException("Failed to parse Date value '" + trim + "' (format: \"" + this._formatString + "\"): " + e.getMessage());
                        }
                    }
                    return parse;
                } else if (zU == JsonToken.START_ARRAY && deserializationContext.isEnabled(DeserializationFeature.UNWRAP_SINGLE_VALUE_ARRAYS)) {
                    jsonParser.zP();
                    parse = _parseDate(jsonParser, deserializationContext);
                    if (jsonParser.zP() == JsonToken.END_ARRAY) {
                        return parse;
                    }
                    throw deserializationContext.wrongTokenException(jsonParser, JsonToken.END_ARRAY, "Attempted to unwrap single value array for single 'java.util.Date' value but there was more than a single value in the array");
                }
            }
            return super._parseDate(jsonParser, deserializationContext);
        }
    }

    @ahh
    public static class CalendarDeserializer extends DateBasedDeserializer<Calendar> {
        protected final Class<? extends Calendar> _calendarClass;

        public /* bridge */ /* synthetic */ agy createContextual(DeserializationContext deserializationContext, agv com_fossil_agv) throws JsonMappingException {
            return super.createContextual(deserializationContext, com_fossil_agv);
        }

        public CalendarDeserializer() {
            super(Calendar.class);
            this._calendarClass = null;
        }

        public CalendarDeserializer(Class<? extends Calendar> cls) {
            super(cls);
            this._calendarClass = cls;
        }

        public CalendarDeserializer(CalendarDeserializer calendarDeserializer, DateFormat dateFormat, String str) {
            super(calendarDeserializer, dateFormat, str);
            this._calendarClass = calendarDeserializer._calendarClass;
        }

        protected CalendarDeserializer withDateFormat(DateFormat dateFormat, String str) {
            return new CalendarDeserializer(this, dateFormat, str);
        }

        public Calendar deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
            Date _parseDate = _parseDate(jsonParser, deserializationContext);
            if (_parseDate == null) {
                return null;
            }
            if (this._calendarClass == null) {
                return deserializationContext.constructCalendar(_parseDate);
            }
            try {
                Calendar calendar = (Calendar) this._calendarClass.newInstance();
                calendar.setTimeInMillis(_parseDate.getTime());
                TimeZone timeZone = deserializationContext.getTimeZone();
                if (timeZone == null) {
                    return calendar;
                }
                calendar.setTimeZone(timeZone);
                return calendar;
            } catch (Throwable e) {
                throw deserializationContext.instantiationException(this._calendarClass, e);
            }
        }
    }

    public static class DateDeserializer extends DateBasedDeserializer<Date> {
        public static final DateDeserializer instance = new DateDeserializer();

        public /* bridge */ /* synthetic */ agy createContextual(DeserializationContext deserializationContext, agv com_fossil_agv) throws JsonMappingException {
            return super.createContextual(deserializationContext, com_fossil_agv);
        }

        public DateDeserializer() {
            super(Date.class);
        }

        public DateDeserializer(DateDeserializer dateDeserializer, DateFormat dateFormat, String str) {
            super(dateDeserializer, dateFormat, str);
        }

        protected DateDeserializer withDateFormat(DateFormat dateFormat, String str) {
            return new DateDeserializer(this, dateFormat, str);
        }

        public Date deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
            return _parseDate(jsonParser, deserializationContext);
        }
    }

    public static class SqlDateDeserializer extends DateBasedDeserializer<java.sql.Date> {
        public /* bridge */ /* synthetic */ agy createContextual(DeserializationContext deserializationContext, agv com_fossil_agv) throws JsonMappingException {
            return super.createContextual(deserializationContext, com_fossil_agv);
        }

        public SqlDateDeserializer() {
            super(java.sql.Date.class);
        }

        public SqlDateDeserializer(SqlDateDeserializer sqlDateDeserializer, DateFormat dateFormat, String str) {
            super(sqlDateDeserializer, dateFormat, str);
        }

        protected SqlDateDeserializer withDateFormat(DateFormat dateFormat, String str) {
            return new SqlDateDeserializer(this, dateFormat, str);
        }

        public java.sql.Date deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
            Date _parseDate = _parseDate(jsonParser, deserializationContext);
            return _parseDate == null ? null : new java.sql.Date(_parseDate.getTime());
        }
    }

    public static class TimestampDeserializer extends DateBasedDeserializer<Timestamp> {
        public /* bridge */ /* synthetic */ agy createContextual(DeserializationContext deserializationContext, agv com_fossil_agv) throws JsonMappingException {
            return super.createContextual(deserializationContext, com_fossil_agv);
        }

        public TimestampDeserializer() {
            super(Timestamp.class);
        }

        public TimestampDeserializer(TimestampDeserializer timestampDeserializer, DateFormat dateFormat, String str) {
            super(timestampDeserializer, dateFormat, str);
        }

        protected TimestampDeserializer withDateFormat(DateFormat dateFormat, String str) {
            return new TimestampDeserializer(this, dateFormat, str);
        }

        public Timestamp deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
            return new Timestamp(_parseDate(jsonParser, deserializationContext).getTime());
        }
    }

    static {
        int i = 0;
        Class[] clsArr = new Class[]{Calendar.class, GregorianCalendar.class, java.sql.Date.class, Date.class, Timestamp.class};
        int length = clsArr.length;
        while (i < length) {
            aSd.add(clsArr[i].getName());
            i++;
        }
    }

    public static agy<?> m2721a(Class<?> cls, String str) {
        if (aSd.contains(str)) {
            if (cls == Calendar.class) {
                return new CalendarDeserializer();
            }
            if (cls == Date.class) {
                return DateDeserializer.instance;
            }
            if (cls == java.sql.Date.class) {
                return new SqlDateDeserializer();
            }
            if (cls == Timestamp.class) {
                return new TimestampDeserializer();
            }
            if (cls == GregorianCalendar.class) {
                return new CalendarDeserializer(GregorianCalendar.class);
            }
        }
        return null;
    }
}
