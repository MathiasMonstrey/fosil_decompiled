package com.fossil.wearables.fsl.goaltracking;

public enum GoalStatus {
    ACTIVE(1),
    INACTIVE(0),
    REMOVED(-1);
    
    private int value;

    private GoalStatus(int i) {
        this.value = i;
    }

    public int getValue() {
        return this.value;
    }

    public static GoalStatus fromInt(int i) {
        for (GoalStatus goalStatus : values()) {
            if (goalStatus.getValue() == i) {
                return goalStatus;
            }
        }
        return ACTIVE;
    }
}
