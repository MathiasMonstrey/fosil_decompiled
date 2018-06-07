package com.fasterxml.jackson.databind.ser.std;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser.NumberType;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fossil.agz;
import com.fossil.ahg;
import com.fossil.ajg;
import com.fossil.ajh;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Type;
import java.net.URI;
import java.net.URL;
import java.util.Collection;
import java.util.Currency;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map.Entry;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.regex.Pattern;

public class StdJdkSerializers {

    public static class AtomicBooleanSerializer extends StdScalarSerializer<AtomicBoolean> {
        public AtomicBooleanSerializer() {
            super(AtomicBoolean.class, false);
        }

        public void serialize(AtomicBoolean atomicBoolean, JsonGenerator jsonGenerator, ahg com_fossil_ahg) throws IOException, JsonGenerationException {
            jsonGenerator.writeBoolean(atomicBoolean.get());
        }

        public agz getSchema(ahg com_fossil_ahg, Type type) {
            return createSchemaNode("boolean", true);
        }

        public void acceptJsonFormatVisitor(ajg com_fossil_ajg, JavaType javaType) throws JsonMappingException {
            com_fossil_ajg.mo1021i(javaType);
        }
    }

    public static class AtomicIntegerSerializer extends StdScalarSerializer<AtomicInteger> {
        public AtomicIntegerSerializer() {
            super(AtomicInteger.class, false);
        }

        public void serialize(AtomicInteger atomicInteger, JsonGenerator jsonGenerator, ahg com_fossil_ahg) throws IOException, JsonGenerationException {
            jsonGenerator.fl(atomicInteger.get());
        }

        public agz getSchema(ahg com_fossil_ahg, Type type) {
            return createSchemaNode("integer", true);
        }

        public void acceptJsonFormatVisitor(ajg com_fossil_ajg, JavaType javaType) throws JsonMappingException {
            ajh h = com_fossil_ajg.mo1020h(javaType);
            if (h != null) {
                h.m3556a(NumberType.INT);
            }
        }
    }

    public static class AtomicLongSerializer extends StdScalarSerializer<AtomicLong> {
        public AtomicLongSerializer() {
            super(AtomicLong.class, false);
        }

        public void serialize(AtomicLong atomicLong, JsonGenerator jsonGenerator, ahg com_fossil_ahg) throws IOException, JsonGenerationException {
            jsonGenerator.mo933J(atomicLong.get());
        }

        public agz getSchema(ahg com_fossil_ahg, Type type) {
            return createSchemaNode("integer", true);
        }

        public void acceptJsonFormatVisitor(ajg com_fossil_ajg, JavaType javaType) throws JsonMappingException {
            ajh h = com_fossil_ajg.mo1020h(javaType);
            if (h != null) {
                h.m3556a(NumberType.LONG);
            }
        }
    }

    public static Collection<Entry<Class<?>, Object>> GQ() {
        HashMap hashMap = new HashMap();
        ToStringSerializer toStringSerializer = ToStringSerializer.instance;
        hashMap.put(URL.class, toStringSerializer);
        hashMap.put(URI.class, toStringSerializer);
        hashMap.put(Currency.class, toStringSerializer);
        hashMap.put(UUID.class, new UUIDSerializer());
        hashMap.put(Pattern.class, toStringSerializer);
        hashMap.put(Locale.class, toStringSerializer);
        hashMap.put(Locale.class, toStringSerializer);
        hashMap.put(AtomicBoolean.class, AtomicBooleanSerializer.class);
        hashMap.put(AtomicInteger.class, AtomicIntegerSerializer.class);
        hashMap.put(AtomicLong.class, AtomicLongSerializer.class);
        hashMap.put(File.class, FileSerializer.class);
        hashMap.put(Class.class, ClassSerializer.class);
        hashMap.put(Void.class, NullSerializer.instance);
        hashMap.put(Void.TYPE, NullSerializer.instance);
        return hashMap.entrySet();
    }
}
