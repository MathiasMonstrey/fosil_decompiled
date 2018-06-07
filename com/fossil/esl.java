package com.fossil;

import java.util.Arrays;
import java.util.List;
import kotlin.KotlinNullPointerException;
import kotlin.UninitializedPropertyAccessException;

public class esl {
    private esl() {
    }

    public static void aGW() {
        throw ((KotlinNullPointerException) m11129p(new KotlinNullPointerException()));
    }

    public static void mE(String str) {
        throw ((UninitializedPropertyAccessException) m11129p(new UninitializedPropertyAccessException(str)));
    }

    public static void mF(String str) {
        mE("lateinit property " + str + " has not been initialized");
    }

    public static void m11127i(Object obj, String str) {
        if (obj == null) {
            throw ((IllegalStateException) m11129p(new IllegalStateException(str + " must not be null")));
        }
    }

    public static void m11128j(Object obj, String str) {
        if (obj == null) {
            mG(str);
        }
    }

    private static void mG(String str) {
        StackTraceElement stackTraceElement = Thread.currentThread().getStackTrace()[3];
        String className = stackTraceElement.getClassName();
        throw ((IllegalArgumentException) m11129p(new IllegalArgumentException("Parameter specified as non-null is null: method " + className + "." + stackTraceElement.getMethodName() + ", parameter " + str)));
    }

    public static boolean m11125C(Object obj, Object obj2) {
        if (obj == null) {
            return obj2 == null;
        } else {
            return obj.equals(obj2);
        }
    }

    private static <T extends Throwable> T m11129p(T t) {
        return m11126d(t, esl.class.getName());
    }

    static <T extends Throwable> T m11126d(T t, String str) {
        StackTraceElement[] stackTrace = t.getStackTrace();
        int length = stackTrace.length;
        int i = -1;
        for (int i2 = 0; i2 < length; i2++) {
            if (str.equals(stackTrace[i2].getClassName())) {
                i = i2;
            }
        }
        List subList = Arrays.asList(stackTrace).subList(i + 1, length);
        t.setStackTrace((StackTraceElement[]) subList.toArray(new StackTraceElement[subList.size()]));
        return t;
    }
}
