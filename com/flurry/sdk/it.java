package com.flurry.sdk;

public enum it {
    INSTALL(1),
    SESSION_START(2),
    SESSION_END(3),
    APPLICATION_EVENT(4);
    
    public final int f1305e;

    private it(int i) {
        this.f1305e = i;
    }

    public static it m2769a(int i) {
        switch (i) {
            case 1:
                return INSTALL;
            case 2:
                return SESSION_START;
            case 3:
                return SESSION_END;
            case 4:
                return APPLICATION_EVENT;
            default:
                return null;
        }
    }
}
