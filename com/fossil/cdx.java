package com.fossil;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public final class cdx {
    private static final Map<Class<?>, Class<?>> bOm;
    private static final Map<Class<?>, Class<?>> bOn;

    static {
        Map hashMap = new HashMap(16);
        Map hashMap2 = new HashMap(16);
        m6038a(hashMap, hashMap2, Boolean.TYPE, Boolean.class);
        m6038a(hashMap, hashMap2, Byte.TYPE, Byte.class);
        m6038a(hashMap, hashMap2, Character.TYPE, Character.class);
        m6038a(hashMap, hashMap2, Double.TYPE, Double.class);
        m6038a(hashMap, hashMap2, Float.TYPE, Float.class);
        m6038a(hashMap, hashMap2, Integer.TYPE, Integer.class);
        m6038a(hashMap, hashMap2, Long.TYPE, Long.class);
        m6038a(hashMap, hashMap2, Short.TYPE, Short.class);
        m6038a(hashMap, hashMap2, Void.TYPE, Void.class);
        bOm = Collections.unmodifiableMap(hashMap);
        bOn = Collections.unmodifiableMap(hashMap2);
    }

    private static void m6038a(Map<Class<?>, Class<?>> map, Map<Class<?>, Class<?>> map2, Class<?> cls, Class<?> cls2) {
        map.put(cls, cls2);
        map2.put(cls2, cls);
    }

    public static Set<Class<?>> VE() {
        return bOn.keySet();
    }

    public static <T> Class<T> m6036N(Class<T> cls) {
        cco.ce(cls);
        Class<T> cls2 = (Class) bOm.get(cls);
        return cls2 == null ? cls : cls2;
    }

    public static <T> Class<T> m6037O(Class<T> cls) {
        cco.ce(cls);
        Class<T> cls2 = (Class) bOn.get(cls);
        return cls2 == null ? cls : cls2;
    }
}
