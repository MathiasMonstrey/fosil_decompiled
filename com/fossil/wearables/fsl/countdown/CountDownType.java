package com.fossil.wearables.fsl.countdown;

public enum CountDownType {
    CUSTOM(0),
    BIRTHDAY(1),
    WEDDING(2),
    VACATION(3),
    FESTIVAL(4);
    
    private int value;

    private CountDownType(int i) {
        this.value = i;
    }

    public int getValue() {
        return this.value;
    }

    public static CountDownType fromInt(int i) {
        for (CountDownType countDownType : values()) {
            if (countDownType.getValue() == i) {
                return countDownType;
            }
        }
        return CUSTOM;
    }
}
