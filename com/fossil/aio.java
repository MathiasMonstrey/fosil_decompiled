package com.fossil;

import com.fasterxml.jackson.databind.deser.std.AtomicBooleanDeserializer;
import com.fasterxml.jackson.databind.deser.std.ByteBufferDeserializer;
import com.fasterxml.jackson.databind.deser.std.FromStringDeserializer;
import com.fasterxml.jackson.databind.deser.std.StackTraceElementDeserializer;
import com.fasterxml.jackson.databind.deser.std.UUIDDeserializer;
import java.nio.ByteBuffer;
import java.util.HashSet;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;

public class aio {
    private static final HashSet<String> aSd = new HashSet();

    static {
        int i = 0;
        for (Class name : new Class[]{UUID.class, AtomicBoolean.class, StackTraceElement.class, ByteBuffer.class}) {
            aSd.add(name.getName());
        }
        Class[] types = FromStringDeserializer.types();
        int length = types.length;
        while (i < length) {
            aSd.add(types[i].getName());
            i++;
        }
    }

    public static agy<?> m3412a(Class<?> cls, String str) {
        if (aSd.contains(str)) {
            agy findDeserializer = FromStringDeserializer.findDeserializer(cls);
            if (findDeserializer != null) {
                return findDeserializer;
            }
            if (cls == UUID.class) {
                return new UUIDDeserializer();
            }
            if (cls == StackTraceElement.class) {
                return new StackTraceElementDeserializer();
            }
            if (cls == AtomicBoolean.class) {
                return new AtomicBooleanDeserializer();
            }
            if (cls == ByteBuffer.class) {
                return new ByteBufferDeserializer();
            }
        }
        return null;
    }
}
