package com.fasterxml.jackson.databind.ser.std;

import com.fasterxml.jackson.annotation.JsonFormat.C1501b;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser.NumberType;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.jsonFormatVisitors.JsonValueFormat;
import com.fasterxml.jackson.databind.util.StdDateFormat;
import com.fossil.agv;
import com.fossil.agz;
import com.fossil.ahb;
import com.fossil.ahg;
import com.fossil.ajg;
import com.fossil.ajh;
import com.fossil.ajm;
import com.fossil.alg;
import java.io.IOException;
import java.lang.reflect.Type;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.TimeZone;

public abstract class DateTimeSerializerBase<T> extends StdScalarSerializer<T> implements alg {
    protected final DateFormat _customFormat;
    protected final Boolean _useTimestamp;

    protected abstract long _timestamp(T t);

    public abstract void serialize(T t, JsonGenerator jsonGenerator, ahg com_fossil_ahg) throws IOException;

    public abstract DateTimeSerializerBase<T> withFormat(Boolean bool, DateFormat dateFormat);

    protected DateTimeSerializerBase(Class<T> cls, Boolean bool, DateFormat dateFormat) {
        super(cls);
        this._useTimestamp = bool;
        this._customFormat = dateFormat;
    }

    public ahb<?> createContextual(ahg com_fossil_ahg, agv com_fossil_agv) throws JsonMappingException {
        if (com_fossil_agv == null) {
            return this;
        }
        C1501b findFormat = com_fossil_ahg.getAnnotationIntrospector().findFormat(com_fossil_agv.getMember());
        if (findFormat == null) {
            return this;
        }
        if (findFormat.yZ().isNumeric()) {
            return withFormat(Boolean.TRUE, null);
        }
        Boolean bool = findFormat.yZ() == Shape.STRING ? Boolean.FALSE : null;
        TimeZone timeZone = findFormat.getTimeZone();
        if (findFormat.za()) {
            TimeZone timeZone2;
            DateFormat simpleDateFormat = new SimpleDateFormat(findFormat.getPattern(), findFormat.zb() ? findFormat.getLocale() : com_fossil_ahg.getLocale());
            if (timeZone == null) {
                timeZone2 = com_fossil_ahg.getTimeZone();
            } else {
                timeZone2 = timeZone;
            }
            simpleDateFormat.setTimeZone(timeZone2);
            return withFormat(bool, simpleDateFormat);
        } else if (timeZone == null) {
            return this;
        } else {
            DateFormat dateFormat = com_fossil_ahg.getConfig().getDateFormat();
            if (dateFormat.getClass() == StdDateFormat.class) {
                dateFormat = StdDateFormat.getISO8601Format(timeZone, findFormat.zb() ? findFormat.getLocale() : com_fossil_ahg.getLocale());
            } else {
                dateFormat = (DateFormat) dateFormat.clone();
                dateFormat.setTimeZone(timeZone);
            }
            return withFormat(bool, dateFormat);
        }
    }

    @Deprecated
    public boolean isEmpty(T t) {
        return t == null || _timestamp(t) == 0;
    }

    public boolean isEmpty(ahg com_fossil_ahg, T t) {
        return t == null || _timestamp(t) == 0;
    }

    public agz getSchema(ahg com_fossil_ahg, Type type) {
        return createSchemaNode(_asTimestamp(com_fossil_ahg) ? "number" : "string", true);
    }

    public void acceptJsonFormatVisitor(ajg com_fossil_ajg, JavaType javaType) throws JsonMappingException {
        _acceptJsonFormatVisitor(com_fossil_ajg, javaType, _asTimestamp(com_fossil_ajg.Gd()));
    }

    protected boolean _asTimestamp(ahg com_fossil_ahg) {
        if (this._useTimestamp != null) {
            return this._useTimestamp.booleanValue();
        }
        if (this._customFormat != null) {
            return false;
        }
        if (com_fossil_ahg != null) {
            return com_fossil_ahg.isEnabled(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
        }
        throw new IllegalArgumentException("Null SerializerProvider passed for " + handledType().getName());
    }

    protected void _acceptJsonFormatVisitor(ajg com_fossil_ajg, JavaType javaType, boolean z) throws JsonMappingException {
        if (z) {
            ajh h = com_fossil_ajg.mo1020h(javaType);
            if (h != null) {
                h.m3556a(NumberType.LONG);
                h.m3535a(JsonValueFormat.UTC_MILLISEC);
                return;
            }
            return;
        }
        ajm f = com_fossil_ajg.mo1018f(javaType);
        if (f != null) {
            f.m3535a(JsonValueFormat.DATE_TIME);
        }
    }
}
