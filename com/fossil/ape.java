package com.fossil;

import java.util.HashMap;
import java.util.Map;

public class ape {
    private static final String aWB = ape.class.getSimpleName();
    private static final HashMap<String, Map<String, String>> f1441b = new HashMap();
    private static ape baI;

    public static synchronized ape IP() {
        ape com_fossil_ape;
        synchronized (ape.class) {
            if (baI == null) {
                baI = new ape();
            }
            com_fossil_ape = baI;
        }
        return com_fossil_ape;
    }

    public final synchronized HashMap<String, Map<String, String>> m4161b() {
        HashMap<String, Map<String, String>> hashMap;
        synchronized (f1441b) {
            hashMap = new HashMap(f1441b);
        }
        return hashMap;
    }
}
