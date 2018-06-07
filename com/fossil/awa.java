package com.fossil;

import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;

public final class awa {
    public static void m4634a(boolean z, Object obj) {
        if (!z) {
            throw new IllegalStateException(String.valueOf(obj));
        }
    }

    public static void m4635a(boolean z, String str, Object... objArr) {
        if (!z) {
            throw new IllegalStateException(String.format(str, objArr));
        }
    }

    public static void aX(boolean z) {
        if (!z) {
            throw new IllegalStateException();
        }
    }

    public static void aY(boolean z) {
        if (!z) {
            throw new IllegalArgumentException();
        }
    }

    public static void m4636b(Handler handler) {
        if (Looper.myLooper() != handler.getLooper()) {
            throw new IllegalStateException("Must be called on the handler thread");
        }
    }

    public static void m4637b(boolean z, Object obj) {
        if (!z) {
            throw new IllegalArgumentException(String.valueOf(obj));
        }
    }

    public static void m4638b(boolean z, String str, Object... objArr) {
        if (!z) {
            throw new IllegalArgumentException(String.format(str, objArr));
        }
    }

    public static <T> T bO(T t) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException("null reference");
    }

    public static String m4639c(String str, Object obj) {
        if (!TextUtils.isEmpty(str)) {
            return str;
        }
        throw new IllegalArgumentException(String.valueOf(obj));
    }

    public static String df(String str) {
        if (!TextUtils.isEmpty(str)) {
            return str;
        }
        throw new IllegalArgumentException("Given String is empty or null");
    }

    public static void dg(String str) {
        if (!axy.LM()) {
            throw new IllegalStateException(str);
        }
    }

    public static void dh(String str) {
        if (axy.LM()) {
            throw new IllegalStateException(str);
        }
    }

    public static <T> T m4640p(T t, Object obj) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException(String.valueOf(obj));
    }
}
