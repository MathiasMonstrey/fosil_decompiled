package com.flurry.sdk;

public enum is {
    GET("GET", 0),
    PUT("PUT", 1),
    POST("POST", 2);
    
    String f1299d;
    public int f1300e;

    private is(String str, int i) {
        this.f1299d = str;
        this.f1300e = i;
    }

    public static is m2768a(int i) {
        switch (i) {
            case 0:
                return GET;
            case 1:
                return PUT;
            case 2:
                return POST;
            default:
                return null;
        }
    }
}
