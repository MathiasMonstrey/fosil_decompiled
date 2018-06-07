package com.fossil.wearables.fsl.goaltracking;

public enum PeriodType {
    UNKNOWN(-1),
    DAY(0),
    WEEK(1),
    MONTH(2);
    
    private int value;

    private PeriodType(int i) {
        this.value = i;
    }

    public int getValue() {
        return this.value;
    }

    public static PeriodType fromInt(int i) {
        for (PeriodType periodType : values()) {
            if (periodType.getValue() == i) {
                return periodType;
            }
        }
        return UNKNOWN;
    }
}
