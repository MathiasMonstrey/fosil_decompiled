package com.fossil;

public class bhk<T> {
    private static final Object bhH = new Object();
    private static bhp bvc = null;
    private static int bvd = 0;
    private static String bve = "com.google.android.providers.gsf.permission.READ_GSERVICES";
    private String bvf;
    private T bvg;
    private T bvh = null;

    protected bhk(String str, T t) {
        this.bvf = str;
        this.bvg = t;
    }

    public static bhk<String> m5178P(String str, String str2) {
        return new bho(str, str2);
    }

    public static bhk<Integer> m5179a(String str, Integer num) {
        return new bhn(str, num);
    }

    public static bhk<Long> m5180a(String str, Long l) {
        return new bhm(str, l);
    }

    public static bhk<Boolean> m5181k(String str, boolean z) {
        return new bhl(str, Boolean.valueOf(z));
    }
}
