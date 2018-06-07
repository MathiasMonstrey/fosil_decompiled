package com.fossil;

public final class ccw {
    public static void m6000w(Object obj, Object obj2) {
        if (obj == null) {
            throw new NullPointerException("null key in entry: null=" + obj2);
        } else if (obj2 == null) {
            throw new NullPointerException("null value in entry: " + obj + "=null");
        }
    }

    public static int m5998n(int i, String str) {
        if (i >= 0) {
            return i;
        }
        throw new IllegalArgumentException(str + " cannot be negative but was: " + i);
    }

    static void m5999o(int i, String str) {
        if (i <= 0) {
            throw new IllegalArgumentException(str + " must be positive but was: " + i);
        }
    }

    public static void bB(boolean z) {
        cco.m5993e(z, "no calls to next() since the last call to remove()");
    }
}
