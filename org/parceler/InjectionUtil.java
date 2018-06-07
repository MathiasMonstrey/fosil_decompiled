package org.parceler;

import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.security.AccessController;
import java.security.PrivilegedExceptionAction;

public final class InjectionUtil {
    public static final String CALL_CONSTRUCTOR_METHOD = "callConstructor";
    public static final String CALL_METHOD_METHOD = "callMethod";
    public static final String GET_FIELD_METHOD = "getField";
    public static final String SET_FIELD_METHOD = "setField";

    static abstract class C5102a<T, E extends AccessibleObject> implements PrivilegedExceptionAction<T> {
        private final E dWj;

        public abstract T mo5495a(E e) throws Exception;

        protected C5102a(E e) {
            this.dWj = e;
        }

        public T run() throws Exception {
            boolean isAccessible = this.dWj.isAccessible();
            this.dWj.setAccessible(true);
            T a = mo5495a(this.dWj);
            this.dWj.setAccessible(isAccessible);
            return a;
        }
    }

    static final class C5103b<T> extends C5102a<T, Field> {
        private final Object target;

        public /* synthetic */ Object mo5495a(AccessibleObject accessibleObject) throws Exception {
            return m16335d((Field) accessibleObject);
        }

        private C5103b(Field field, Object obj) {
            super(field);
            this.target = obj;
        }

        public T m16335d(Field field) throws IllegalAccessException {
            return field.get(this.target);
        }
    }

    static final class C5104c<T> extends C5102a<T, Constructor> {
        private final Object[] dWk;

        private C5104c(Constructor constructor, Object[] objArr) {
            super(constructor);
            this.dWk = objArr;
        }

        public T m16337a(Constructor constructor) throws InvocationTargetException, InstantiationException, IllegalAccessException {
            return constructor.newInstance(this.dWk);
        }
    }

    static final class C5105d extends C5102a<Void, Field> {
        private final Object target;
        private final Object value;

        public /* synthetic */ Object mo5495a(AccessibleObject accessibleObject) throws Exception {
            return m16339e((Field) accessibleObject);
        }

        private C5105d(Field field, Object obj, Object obj2) {
            super(field);
            this.target = obj;
            this.value = obj2;
        }

        public Void m16339e(Field field) throws IllegalAccessException {
            field.set(this.target, this.value);
            return null;
        }
    }

    static final class C5106e<T> extends C5102a<T, Method> {
        private final Object[] dWk;
        private final Object target;

        public /* synthetic */ Object mo5495a(AccessibleObject accessibleObject) throws Exception {
            return m16341f((Method) accessibleObject);
        }

        private C5106e(Method method, Object obj, Object[] objArr) {
            super(method);
            this.target = obj;
            this.dWk = objArr;
        }

        public T m16341f(Method method) throws InvocationTargetException, IllegalAccessException {
            return method.invoke(this.target, this.dWk);
        }
    }

    private InjectionUtil() {
    }

    public static <T> T getField(Class<T> cls, Class<?> cls2, Object obj, String str) {
        try {
            return AccessController.doPrivileged(new C5103b(cls2.getDeclaredField(str), obj));
        } catch (Exception e) {
            throw new ParcelerRuntimeException("NoSuchFieldException Exception during field injection: " + str + " in " + obj.getClass(), e);
        } catch (Exception e2) {
            throw new ParcelerRuntimeException("PrivilegedActionException Exception during field injection", e2);
        } catch (Exception e22) {
            throw new ParcelerRuntimeException("Exception during field injection", e22);
        }
    }

    public static void setField(Class<?> cls, Object obj, String str, Object obj2) {
        try {
            AccessController.doPrivileged(new C5105d(cls.getDeclaredField(str), obj, obj2));
        } catch (Exception e) {
            throw new ParcelerRuntimeException("NoSuchFieldException Exception during field injection: " + str + " in " + obj.getClass(), e);
        } catch (Exception e2) {
            throw new ParcelerRuntimeException("PrivilegedActionException Exception during field injection", e2);
        } catch (Exception e22) {
            throw new ParcelerRuntimeException("Exception during field injection", e22);
        }
    }

    public static <T> T callMethod(Class<T> cls, Class<?> cls2, Object obj, String str, Class[] clsArr, Object[] objArr) {
        try {
            return AccessController.doPrivileged(new C5106e(cls2.getDeclaredMethod(str, clsArr), obj, objArr));
        } catch (Exception e) {
            throw new ParcelerRuntimeException("Exception during method injection: NoSuchFieldException", e);
        } catch (Exception e2) {
            throw new ParcelerRuntimeException("PrivilegedActionException Exception during field injection", e2);
        } catch (Exception e22) {
            throw new ParcelerRuntimeException("Exception during field injection", e22);
        }
    }

    public static <T> T callConstructor(Class<T> cls, Class[] clsArr, Object[] objArr) {
        try {
            return AccessController.doPrivileged(new C5104c(cls.getDeclaredConstructor(clsArr), objArr));
        } catch (Exception e) {
            throw new ParcelerRuntimeException("Exception during method injection: NoSuchMethodException", e);
        } catch (Exception e2) {
            throw new ParcelerRuntimeException("PrivilegedActionException Exception during field injection", e2);
        } catch (Exception e22) {
            throw new ParcelerRuntimeException("Exception during field injection", e22);
        }
    }
}
