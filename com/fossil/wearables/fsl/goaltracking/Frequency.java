package com.fossil.wearables.fsl.goaltracking;

public enum Frequency {
    UNKNOWN(-1),
    DAILY(0),
    WEEKLY(1);
    
    private int value;

    private Frequency(int i) {
        this.value = i;
    }

    public int getValue() {
        return this.value;
    }

    public static Frequency fromInt(int i) {
        for (Frequency frequency : values()) {
            if (frequency.getValue() == i) {
                return frequency;
            }
        }
        return UNKNOWN;
    }
}
