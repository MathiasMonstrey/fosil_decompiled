package com.fossil;

public final class ely {
    public static void notNull(Object obj, String str) {
        if (obj == null) {
            throw new NullPointerException("Argument " + str + " cannot be null");
        }
    }
}
