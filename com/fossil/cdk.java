package com.fossil;

import java.util.Collection;

public final class cdk {
    public static <T> T[] m6017d(T[] tArr, int i) {
        return cdm.m6026d(tArr, i);
    }

    static <T> T[] m6015a(Collection<?> collection, T[] tArr) {
        int size = collection.size();
        if (tArr.length < size) {
            tArr = m6017d(tArr, size);
        }
        m6016b(collection, tArr);
        if (tArr.length > size) {
            tArr[size] = null;
        }
        return tArr;
    }

    private static Object[] m6016b(Iterable<?> iterable, Object[] objArr) {
        int i = 0;
        for (Object obj : iterable) {
            int i2 = i + 1;
            objArr[i] = obj;
            i = i2;
        }
        return objArr;
    }

    public static Object[] m6019l(Object... objArr) {
        return m6018e(objArr, objArr.length);
    }

    public static Object[] m6018e(Object[] objArr, int i) {
        for (int i2 = 0; i2 < i; i2++) {
            m6020x(objArr[i2], i2);
        }
        return objArr;
    }

    public static Object m6020x(Object obj, int i) {
        if (obj != null) {
            return obj;
        }
        throw new NullPointerException("at index " + i);
    }
}
