package com.fossil;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.lang.reflect.Field;
import java.util.Collection;
import java.util.Map.Entry;

public final class cdn {

    public static final class C2009a<T> {
        private final Field field;

        private C2009a(Field field) {
            this.field = field;
            field.setAccessible(true);
        }

        public void set(T t, Object obj) {
            try {
                this.field.set(t, obj);
            } catch (IllegalAccessException e) {
                throw new AssertionError(e);
            }
        }

        public void set(T t, int i) {
            try {
                this.field.set(t, Integer.valueOf(i));
            } catch (IllegalAccessException e) {
                throw new AssertionError(e);
            }
        }
    }

    public static <K, V> void m6027a(cdi<K, V> com_fossil_cdi_K__V, ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.writeInt(com_fossil_cdi_K__V.asMap().size());
        for (Entry entry : com_fossil_cdi_K__V.asMap().entrySet()) {
            objectOutputStream.writeObject(entry.getKey());
            objectOutputStream.writeInt(((Collection) entry.getValue()).size());
            for (Object writeObject : (Collection) entry.getValue()) {
                objectOutputStream.writeObject(writeObject);
            }
        }
    }

    public static <T> C2009a<T> m6028f(Class<T> cls, String str) {
        try {
            return new C2009a(cls.getDeclaredField(str));
        } catch (NoSuchFieldException e) {
            throw new AssertionError(e);
        }
    }
}
