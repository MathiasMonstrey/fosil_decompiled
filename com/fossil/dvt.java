package com.fossil;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

class dvt<T> {
    private final Class<?> dwC;
    private final String dwD;
    private final Class[] dwE;

    public dvt(Class<?> cls, String str, Class... clsArr) {
        this.dwC = cls;
        this.dwD = str;
        this.dwE = clsArr;
    }

    public boolean cS(T t) {
        return ai(t.getClass()) != null;
    }

    public Object m9948b(T t, Object... objArr) throws InvocationTargetException {
        Object obj = null;
        Method ai = ai(t.getClass());
        if (ai != null) {
            try {
                obj = ai.invoke(t, objArr);
            } catch (IllegalAccessException e) {
            }
        }
        return obj;
    }

    public Object m9949c(T t, Object... objArr) {
        try {
            return m9948b(t, objArr);
        } catch (InvocationTargetException e) {
            Throwable targetException = e.getTargetException();
            if (targetException instanceof RuntimeException) {
                throw ((RuntimeException) targetException);
            }
            AssertionError assertionError = new AssertionError("Unexpected exception");
            assertionError.initCause(targetException);
            throw assertionError;
        }
    }

    public Object invoke(T t, Object... objArr) throws InvocationTargetException {
        Object ai = ai(t.getClass());
        if (ai == null) {
            throw new AssertionError("Method " + this.dwD + " not supported for object " + t);
        }
        try {
            return ai.invoke(t, objArr);
        } catch (Throwable e) {
            AssertionError assertionError = new AssertionError("Unexpectedly could not call: " + ai);
            assertionError.initCause(e);
            throw assertionError;
        }
    }

    public Object m9950d(T t, Object... objArr) {
        try {
            return invoke(t, objArr);
        } catch (InvocationTargetException e) {
            Throwable targetException = e.getTargetException();
            if (targetException instanceof RuntimeException) {
                throw ((RuntimeException) targetException);
            }
            AssertionError assertionError = new AssertionError("Unexpected exception");
            assertionError.initCause(targetException);
            throw assertionError;
        }
    }

    private Method ai(Class<?> cls) {
        if (this.dwD == null) {
            return null;
        }
        Method a = m9947a(cls, this.dwD, this.dwE);
        if (a == null || this.dwC == null || this.dwC.isAssignableFrom(a.getReturnType())) {
            return a;
        }
        return null;
    }

    private static Method m9947a(Class<?> cls, String str, Class[] clsArr) {
        try {
            Method method = cls.getMethod(str, clsArr);
            try {
                if ((method.getModifiers() & 1) == 0) {
                    return null;
                }
                return method;
            } catch (NoSuchMethodException e) {
                return method;
            }
        } catch (NoSuchMethodException e2) {
            return null;
        }
    }
}
