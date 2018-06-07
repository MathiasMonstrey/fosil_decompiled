package com.fossil.wearables.fsl.countdown;

public enum CountDownStatus {
    REMOVED(-1),
    INACTIVE(0),
    ACTIVE(1),
    COMPLETED(2);
    
    private int value;

    private CountDownStatus(int i) {
        this.value = i;
    }

    public int getValue() {
        return this.value;
    }

    public static CountDownStatus fromInt(int i) {
        for (CountDownStatus countDownStatus : values()) {
            if (countDownStatus.getValue() == i) {
                return countDownStatus;
            }
        }
        return ACTIVE;
    }
}
