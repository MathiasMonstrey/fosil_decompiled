package com.fossil;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

final class dxg {
    private static final ConcurrentMap<Class<?>, Map<Class<?>, Method>> dAi = new ConcurrentHashMap();
    private static final ConcurrentMap<Class<?>, Map<Class<?>, Set<Method>>> dAj = new ConcurrentHashMap();

    private static void m10261b(Class<?> cls, Map<Class<?>, Method> map) {
        m10260a(cls, map, new HashMap());
    }

    private static void m10262c(Class<?> cls, Map<Class<?>, Set<Method>> map) {
        m10260a(cls, new HashMap(), map);
    }

    private static void m10260a(Class<?> cls, Map<Class<?>, Method> map, Map<Class<?>, Set<Method>> map2) {
        for (Method method : cls.getDeclaredMethods()) {
            if (!method.isBridge()) {
                Class[] parameterTypes;
                if (method.isAnnotationPresent(dxn.class)) {
                    parameterTypes = method.getParameterTypes();
                    if (parameterTypes.length != 1) {
                        throw new IllegalArgumentException("Method " + method + " has @Subscribe annotation but requires " + parameterTypes.length + " arguments.  Methods must require a single argument.");
                    }
                    Class cls2 = parameterTypes[0];
                    if (cls2.isInterface()) {
                        throw new IllegalArgumentException("Method " + method + " has @Subscribe annotation on " + cls2 + " which is an interface.  Subscription must be on a concrete class type.");
                    } else if ((method.getModifiers() & 1) == 0) {
                        throw new IllegalArgumentException("Method " + method + " has @Subscribe annotation on " + cls2 + " but is not 'public'.");
                    } else {
                        Set set = (Set) map2.get(cls2);
                        if (set == null) {
                            set = new HashSet();
                            map2.put(cls2, set);
                        }
                        set.add(method);
                    }
                } else if (method.isAnnotationPresent(dxm.class)) {
                    parameterTypes = method.getParameterTypes();
                    if (parameterTypes.length != 0) {
                        throw new IllegalArgumentException("Method " + method + "has @Produce annotation but requires " + parameterTypes.length + " arguments.  Methods must require zero arguments.");
                    } else if (method.getReturnType() == Void.class) {
                        throw new IllegalArgumentException("Method " + method + " has a return type of void.  Must declare a non-void type.");
                    } else {
                        Class returnType = method.getReturnType();
                        if (returnType.isInterface()) {
                            throw new IllegalArgumentException("Method " + method + " has @Produce annotation on " + returnType + " which is an interface.  Producers must return a concrete class type.");
                        } else if (returnType.equals(Void.TYPE)) {
                            throw new IllegalArgumentException("Method " + method + " has @Produce annotation but has no return type.");
                        } else if ((method.getModifiers() & 1) == 0) {
                            throw new IllegalArgumentException("Method " + method + " has @Produce annotation on " + returnType + " but is not 'public'.");
                        } else if (map.containsKey(returnType)) {
                            throw new IllegalArgumentException("Producer for type " + returnType + " has already been registered.");
                        } else {
                            map.put(returnType, method);
                        }
                    }
                } else {
                    continue;
                }
            }
        }
        dAi.put(cls, map);
        dAj.put(cls, map2);
    }

    static Map<Class<?>, dxk> cT(Object obj) {
        Class cls = obj.getClass();
        Map<Class<?>, dxk> hashMap = new HashMap();
        Map map = (Map) dAi.get(cls);
        if (map == null) {
            map = new HashMap();
            m10261b(cls, map);
        }
        if (!map.isEmpty()) {
            for (Entry entry : map.entrySet()) {
                hashMap.put(entry.getKey(), new dxk(obj, (Method) entry.getValue()));
            }
        }
        return hashMap;
    }

    static Map<Class<?>, Set<dxj>> cU(Object obj) {
        Class cls = obj.getClass();
        Map<Class<?>, Set<dxj>> hashMap = new HashMap();
        Map map = (Map) dAj.get(cls);
        if (map == null) {
            map = new HashMap();
            m10262c(cls, map);
        }
        if (!map.isEmpty()) {
            for (Entry entry : map.entrySet()) {
                Set hashSet = new HashSet();
                for (Method com_fossil_dxj : (Set) entry.getValue()) {
                    hashSet.add(new dxj(obj, com_fossil_dxj));
                }
                hashMap.put(entry.getKey(), hashSet);
            }
        }
        return hashMap;
    }
}
