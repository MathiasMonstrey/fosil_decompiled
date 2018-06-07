package com.misfit.ble.setting.rmm;

public class GoalTrackingSettings {
    public short mGoalIdNumber;
    public boolean mGoalTrackingState;

    public GoalTrackingSettings(short s, boolean z) {
        this.mGoalIdNumber = s;
        this.mGoalTrackingState = z;
    }

    public short getGoalIdNumber() {
        return this.mGoalIdNumber;
    }

    public boolean getGoalTrackingState() {
        return this.mGoalTrackingState;
    }

    public String toString() {
        return "goalID: " + this.mGoalIdNumber + ", goalState: " + this.mGoalTrackingState;
    }
}
