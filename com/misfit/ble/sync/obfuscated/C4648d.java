package com.misfit.ble.sync.obfuscated;

public class C4648d {
    public static String m15472a(String str) {
        if (str.length() > 23 - "sa_".length()) {
            return "sa_" + str.substring(0, (23 - "sa_".length()) - 1);
        }
        return "sa_" + str;
    }

    public static String m15471a(Class cls) {
        return C4648d.m15472a(cls.getSimpleName());
    }
}
