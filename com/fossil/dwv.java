package com.fossil;

public final class dwv {
    public static boolean kQ(String str) {
        return str.equals("POST") || str.equals("PATCH") || str.equals("PUT") || str.equals("DELETE");
    }

    public static boolean kR(String str) {
        return str.equals("POST") || str.equals("PUT") || str.equals("PATCH");
    }

    public static boolean kS(String str) {
        return kR(str) || str.equals("DELETE");
    }
}
