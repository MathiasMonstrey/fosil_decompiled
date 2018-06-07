package com.misfit.frameworks.common.enums;

public enum StravaPostResultCode {
    NOT_EXIST_ACCESS_TOKEN(-3),
    NETWORK_ERROR(-2),
    WRONG_FORMAT(-1),
    POSTING(0),
    POSTED_SUCCESSFULLY(1);
    
    private int value;

    private StravaPostResultCode(int i) {
        this.value = i;
    }

    public int getValue() {
        return this.value;
    }
}
