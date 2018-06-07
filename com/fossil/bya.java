package com.fossil;

public final class bya {
    public static byte m5793b(Boolean bool) {
        return bool != null ? bool.booleanValue() ? (byte) 1 : (byte) 0 : (byte) -1;
    }

    public static Boolean m5794f(byte b) {
        switch (b) {
            case (byte) 0:
                return Boolean.FALSE;
            case (byte) 1:
                return Boolean.TRUE;
            default:
                return null;
        }
    }
}
