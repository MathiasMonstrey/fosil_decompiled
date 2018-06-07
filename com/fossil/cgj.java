package com.fossil;

import java.io.ObjectInputStream;
import java.io.ObjectStreamClass;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public abstract class cgj {

    static class C20484 extends cgj {
        C20484() {
        }

        public <T> T af(Class<T> cls) {
            throw new UnsupportedOperationException("Cannot allocate " + cls);
        }
    }

    public abstract <T> T af(Class<T> cls) throws Exception;

    public static cgj WS() {
        final Method method;
        try {
            Class cls = Class.forName("sun.misc.Unsafe");
            Field declaredField = cls.getDeclaredField("theUnsafe");
            declaredField.setAccessible(true);
            final Object obj = declaredField.get(null);
            method = cls.getMethod("allocateInstance", new Class[]{Class.class});
            return new cgj() {
                public <T> T af(Class<T> cls) throws Exception {
                    cgj.ag(cls);
                    return method.invoke(obj, new Object[]{cls});
                }
            };
        } catch (Exception e) {
            try {
                Method declaredMethod = ObjectStreamClass.class.getDeclaredMethod("getConstructorId", new Class[]{Class.class});
                declaredMethod.setAccessible(true);
                final int intValue = ((Integer) declaredMethod.invoke(null, new Object[]{Object.class})).intValue();
                method = ObjectStreamClass.class.getDeclaredMethod("newInstance", new Class[]{Class.class, Integer.TYPE});
                method.setAccessible(true);
                return new cgj() {
                    public <T> T af(Class<T> cls) throws Exception {
                        cgj.ag(cls);
                        return method.invoke(null, new Object[]{cls, Integer.valueOf(intValue)});
                    }
                };
            } catch (Exception e2) {
                try {
                    final Method declaredMethod2 = ObjectInputStream.class.getDeclaredMethod("newInstance", new Class[]{Class.class, Class.class});
                    declaredMethod2.setAccessible(true);
                    return new cgj() {
                        public <T> T af(Class<T> cls) throws Exception {
                            cgj.ag(cls);
                            return declaredMethod2.invoke(null, new Object[]{cls, Object.class});
                        }
                    };
                } catch (Exception e3) {
                    return new C20484();
                }
            }
        }
    }

    private static void ag(Class<?> cls) {
        int modifiers = cls.getModifiers();
        if (Modifier.isInterface(modifiers)) {
            throw new UnsupportedOperationException("Interface can't be instantiated! Interface name: " + cls.getName());
        } else if (Modifier.isAbstract(modifiers)) {
            throw new UnsupportedOperationException("Abstract class can't be instantiated! Class name: " + cls.getName());
        }
    }
}
