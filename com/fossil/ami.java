package com.fossil;

import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Member;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Collection;
import java.util.EnumMap;
import java.util.EnumSet;
import java.util.List;
import java.util.Map;

public final class ami {

    static class C1702a {
        static final C1702a aVF = new C1702a();
        private final Field aVG = C1702a.m3848a(EnumSet.class, "elementType", Class.class);
        private final Field aVH = C1702a.m3848a(EnumMap.class, "elementType", Class.class);

        private C1702a() {
        }

        public Class<? extends Enum<?>> m3850b(EnumSet<?> enumSet) {
            if (this.aVG != null) {
                return (Class) m3847a(enumSet, this.aVG);
            }
            throw new IllegalStateException("Can not figure out type for EnumSet (odd JDK platform?)");
        }

        public Class<? extends Enum<?>> m3849b(EnumMap<?, ?> enumMap) {
            if (this.aVH != null) {
                return (Class) m3847a(enumMap, this.aVH);
            }
            throw new IllegalStateException("Can not figure out type for EnumMap (odd JDK platform?)");
        }

        private Object m3847a(Object obj, Field field) {
            try {
                return field.get(obj);
            } catch (Throwable e) {
                throw new IllegalArgumentException(e);
            }
        }

        private static Field m3848a(Class<?> cls, String str, Class<?> cls2) {
            int i;
            int length;
            Field[] declaredFields = cls.getDeclaredFields();
            for (Field field : declaredFields) {
                if (str.equals(field.getName()) && field.getType() == cls2) {
                    break;
                }
            }
            Field field2 = null;
            if (field2 == null) {
                length = declaredFields.length;
                i = 0;
                Field field3 = field2;
                while (i < length) {
                    field2 = declaredFields[i];
                    if (field2.getType() != cls2) {
                        field2 = field3;
                    } else if (field3 != null) {
                        return null;
                    }
                    i++;
                    field3 = field2;
                }
                field2 = field3;
            }
            if (field2 == null) {
                return field2;
            }
            try {
                field2.setAccessible(true);
                return field2;
            } catch (Throwable th) {
                return field2;
            }
        }
    }

    public static List<Class<?>> m3870j(Class<?> cls, Class<?> cls2) {
        return m3860a(cls, cls2, new ArrayList(8));
    }

    public static List<Class<?>> m3860a(Class<?> cls, Class<?> cls2, List<Class<?>> list) {
        m3861a(cls, cls2, list, false);
        return list;
    }

    private static void m3861a(Class<?> cls, Class<?> cls2, Collection<Class<?>> collection, boolean z) {
        if (cls != cls2 && cls != null && cls != Object.class) {
            if (z) {
                if (!collection.contains(cls)) {
                    collection.add(cls);
                } else {
                    return;
                }
            }
            for (Class a : cls.getInterfaces()) {
                m3861a(a, cls2, collection, true);
            }
            m3861a(cls.getSuperclass(), cls2, collection, true);
        }
    }

    public static String m3871v(Class<?> cls) {
        if (cls.isAnnotation()) {
            return "annotation";
        }
        if (cls.isArray()) {
            return "array";
        }
        if (cls.isEnum()) {
            return "enum";
        }
        if (cls.isPrimitive()) {
            return "primitive";
        }
        return null;
    }

    public static String m3859a(Class<?> cls, boolean z) {
        try {
            if (cls.getEnclosingMethod() != null) {
                return "local/anonymous";
            }
            if (!(z || cls.getEnclosingClass() == null || Modifier.isStatic(cls.getModifiers()))) {
                return "non-static member class";
            }
            return null;
        } catch (SecurityException e) {
        } catch (NullPointerException e2) {
        }
    }

    public static Class<?> m3872w(Class<?> cls) {
        Class<?> cls2 = null;
        try {
            if (cls.getEnclosingMethod() == null && !Modifier.isStatic(cls.getModifiers())) {
                cls2 = cls.getEnclosingClass();
            }
        } catch (SecurityException e) {
        } catch (NullPointerException e2) {
        }
        return cls2;
    }

    public static boolean m3873x(Class<?> cls) {
        String name = cls.getName();
        if (name.startsWith("net.sf.cglib.proxy.") || name.startsWith("org.hibernate.proxy.")) {
            return true;
        }
        return false;
    }

    public static boolean m3874y(Class<?> cls) {
        return (cls.getModifiers() & 1536) == 0;
    }

    public static boolean m3875z(Class<?> cls) {
        if (cls.isArray() || Collection.class.isAssignableFrom(cls) || Map.class.isAssignableFrom(cls)) {
            return true;
        }
        return false;
    }

    public static String bF(Object obj) {
        if (obj == null) {
            return "unknown";
        }
        return (obj instanceof Class ? (Class) obj : obj.getClass()).getName();
    }

    public static Throwable m3865c(Throwable th) {
        while (th.getCause() != null) {
            th = th.getCause();
        }
        return th;
    }

    public static void m3868d(Throwable th) {
        m3864b(th, th.getMessage());
    }

    public static void m3864b(Throwable th, String str) {
        if (th instanceof RuntimeException) {
            throw ((RuntimeException) th);
        } else if (th instanceof Error) {
            throw ((Error) th);
        } else {
            throw new IllegalArgumentException(str, th);
        }
    }

    public static void m3869e(Throwable th) {
        m3868d(m3865c(th));
    }

    public static void m3867c(Throwable th, String str) {
        m3864b(m3865c(th), str);
    }

    public static <T> T m3863b(Class<T> cls, boolean z) throws IllegalArgumentException {
        Constructor c = m3866c((Class) cls, z);
        if (c == null) {
            throw new IllegalArgumentException("Class " + cls.getName() + " has no default (no arg) constructor");
        }
        try {
            return c.newInstance(new Object[0]);
        } catch (Throwable e) {
            m3867c(e, "Failed to instantiate class " + cls.getName() + ", problem: " + e.getMessage());
            return null;
        }
    }

    public static <T> Constructor<T> m3866c(Class<T> cls, boolean z) throws IllegalArgumentException {
        try {
            Member declaredConstructor = cls.getDeclaredConstructor(new Class[0]);
            if (z) {
                m3862a(declaredConstructor);
                return declaredConstructor;
            } else if (Modifier.isPublic(declaredConstructor.getModifiers())) {
                return declaredConstructor;
            } else {
                throw new IllegalArgumentException("Default constructor for " + cls.getName() + " is not accessible (non-public?): not allowed to try modify access via Reflection: can not instantiate type");
            }
        } catch (NoSuchMethodException e) {
            return null;
        } catch (Throwable e2) {
            m3867c(e2, "Failed to find default constructor of class " + cls.getName() + ", problem: " + e2.getMessage());
            return null;
        }
    }

    public static Class<?> m3851A(Class<?> cls) {
        if (cls == Integer.TYPE) {
            return Integer.class;
        }
        if (cls == Long.TYPE) {
            return Long.class;
        }
        if (cls == Boolean.TYPE) {
            return Boolean.class;
        }
        if (cls == Double.TYPE) {
            return Double.class;
        }
        if (cls == Float.TYPE) {
            return Float.class;
        }
        if (cls == Byte.TYPE) {
            return Byte.class;
        }
        if (cls == Short.TYPE) {
            return Short.class;
        }
        if (cls == Character.TYPE) {
            return Character.class;
        }
        throw new IllegalArgumentException("Class " + cls.getName() + " is not a primitive type");
    }

    public static void m3862a(Member member) {
        AccessibleObject accessibleObject = (AccessibleObject) member;
        try {
            accessibleObject.setAccessible(true);
        } catch (SecurityException e) {
            if (!accessibleObject.isAccessible()) {
                throw new IllegalArgumentException("Can not access " + member + " (from class " + member.getDeclaringClass().getName() + "; failed to set access: " + e.getMessage());
            }
        }
    }

    public static Class<? extends Enum<?>> m3858a(EnumSet<?> enumSet) {
        if (enumSet.isEmpty()) {
            return C1702a.aVF.m3850b((EnumSet) enumSet);
        }
        return m3856a((Enum) enumSet.iterator().next());
    }

    public static Class<? extends Enum<?>> m3857a(EnumMap<?, ?> enumMap) {
        if (enumMap.isEmpty()) {
            return C1702a.aVF.m3849b((EnumMap) enumMap);
        }
        return m3856a((Enum) enumMap.keySet().iterator().next());
    }

    public static Class<? extends Enum<?>> m3856a(Enum<?> enumR) {
        Class<? extends Enum<?>> cls = enumR.getClass();
        if (cls.getSuperclass() != Enum.class) {
            return cls.getSuperclass();
        }
        return cls;
    }

    public static Class<? extends Enum<?>> m3852B(Class<?> cls) {
        if (cls.getSuperclass() != Enum.class) {
            return cls.getSuperclass();
        }
        return cls;
    }

    public static boolean bG(Object obj) {
        return obj != null && m3853C(obj.getClass());
    }

    public static boolean m3853C(Class<?> cls) {
        return cls.getAnnotation(ahh.class) != null;
    }

    public static boolean m3854D(Class<?> cls) {
        return cls == Void.class || cls == Void.TYPE || cls == ahp.class;
    }

    public static boolean m3855E(Class<?> cls) {
        return (cls.getEnclosingClass() == null || Modifier.isStatic(cls.getModifiers())) ? false : true;
    }
}
