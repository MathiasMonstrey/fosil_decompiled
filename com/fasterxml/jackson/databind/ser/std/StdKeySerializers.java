package com.fasterxml.jackson.databind.ser.std;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializationConfig;
import com.fossil.ahb;
import com.fossil.ahg;
import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
import java.util.UUID;

public class StdKeySerializers {
    protected static final ahb<Object> aVd = new StdKeySerializer();
    protected static final ahb<Object> aVe = new StringKeySerializer();

    public static class Default extends StdSerializer<Object> {
        static final int TYPE_CALENDAR = 2;
        static final int TYPE_CLASS = 3;
        static final int TYPE_DATE = 1;
        static final int TYPE_TO_STRING = 4;
        protected final int _typeId;

        public Default(int i, Class<?> cls) {
            super(cls, false);
            this._typeId = i;
        }

        public void serialize(Object obj, JsonGenerator jsonGenerator, ahg com_fossil_ahg) throws IOException, JsonGenerationException {
            switch (this._typeId) {
                case 1:
                    com_fossil_ahg.defaultSerializeDateKey((Date) obj, jsonGenerator);
                    return;
                case 2:
                    com_fossil_ahg.defaultSerializeDateKey(((Calendar) obj).getTimeInMillis(), jsonGenerator);
                    return;
                case 3:
                    jsonGenerator.aQ(((Class) obj).getName());
                    return;
                default:
                    jsonGenerator.aQ(obj.toString());
                    return;
            }
        }
    }

    public static class StringKeySerializer extends StdSerializer<Object> {
        public StringKeySerializer() {
            super(String.class, false);
        }

        public void serialize(Object obj, JsonGenerator jsonGenerator, ahg com_fossil_ahg) throws IOException, JsonGenerationException {
            jsonGenerator.aQ((String) obj);
        }
    }

    public static ahb<Object> m2759a(SerializationConfig serializationConfig, Class<?> cls, boolean z) {
        if (cls != null) {
            if (cls == String.class) {
                return aVe;
            }
            if (cls == Object.class || cls.isPrimitive() || Number.class.isAssignableFrom(cls)) {
                return aVd;
            }
            if (cls == Class.class) {
                return new Default(3, cls);
            }
            if (Date.class.isAssignableFrom(cls)) {
                return new Default(1, cls);
            }
            if (Calendar.class.isAssignableFrom(cls)) {
                return new Default(2, cls);
            }
            if (cls == UUID.class) {
                return new Default(4, cls);
            }
        }
        return z ? aVd : null;
    }

    public static ahb<Object> GR() {
        return aVd;
    }
}
