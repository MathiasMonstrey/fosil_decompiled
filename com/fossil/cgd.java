package com.fossil;

public final class cgd {
    public static <T> T ce(T t) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException();
    }

    public static void bz(boolean z) {
        if (!z) {
            throw new IllegalArgumentException();
        }
    }
}
