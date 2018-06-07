package com.flurry.sdk;

public enum in {
    COMPLETE(1),
    TIMEOUT(2),
    INVALID_RESPONSE(3),
    PENDING_COMPLETION(4);
    
    public int f1295e;

    private in(int i) {
        this.f1295e = i;
    }

    public static in m2767a(int i) {
        switch (i) {
            case 1:
                return COMPLETE;
            case 2:
                return TIMEOUT;
            case 3:
                return INVALID_RESPONSE;
            case 4:
                return PENDING_COMPLETION;
            default:
                return null;
        }
    }
}
