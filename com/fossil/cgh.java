package com.fossil;

import java.lang.reflect.Type;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public final class cgh {
    private static final Map<Class<?>, Class<?>> bOm;
    private static final Map<Class<?>, Class<?>> bOn;

    static {
        Map hashMap = new HashMap(16);
        Map hashMap2 = new HashMap(16);
        m6239a(hashMap, hashMap2, Boolean.TYPE, Boolean.class);
        m6239a(hashMap, hashMap2, Byte.TYPE, Byte.class);
        m6239a(hashMap, hashMap2, Character.TYPE, Character.class);
        m6239a(hashMap, hashMap2, Double.TYPE, Double.class);
        m6239a(hashMap, hashMap2, Float.TYPE, Float.class);
        m6239a(hashMap, hashMap2, Integer.TYPE, Integer.class);
        m6239a(hashMap, hashMap2, Long.TYPE, Long.class);
        m6239a(hashMap, hashMap2, Short.TYPE, Short.class);
        m6239a(hashMap, hashMap2, Void.TYPE, Void.class);
        bOm = Collections.unmodifiableMap(hashMap);
        bOn = Collections.unmodifiableMap(hashMap2);
    }

    private static void m6239a(Map<Class<?>, Class<?>> map, Map<Class<?>, Class<?>> map2, Class<?> cls, Class<?> cls2) {
        map.put(cls, cls2);
        map2.put(cls2, cls);
    }

    public static boolean m6240x(Type type) {
        return bOm.containsKey(type);
    }

    public static <T> Class<T> m6238N(Class<T> cls) {
        Class<T> cls2 = (Class) bOm.get(cgd.ce(cls));
        return cls2 == null ? cls : cls2;
    }
}
