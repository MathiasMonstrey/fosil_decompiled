package com.misfit.ble.shine.sync.result;

public class TapEventSummaryShine {
    public long[] arrGoalTrackingID;
    public long doubleTapCount;
    public String goalTrackingID;
    public long startTime;
    public long tripleTapCount;

    public void parseJsonStringGoalTrackingToArray() {
        if (this.goalTrackingID != null) {
            this.goalTrackingID = this.goalTrackingID.replace("{", "");
            this.goalTrackingID = this.goalTrackingID.replace("}", "");
            if (!this.goalTrackingID.equals("")) {
                String[] split = this.goalTrackingID.split(",");
                int length = split.length;
                this.arrGoalTrackingID = new long[length];
                for (int i = 0; i < length; i++) {
                    this.arrGoalTrackingID[i] = Long.parseLong(split[i]);
                }
            }
        }
    }

    public String toString() {
        return String.format("Start time: %d with %d doubleTapCount and %d tripleTapCount and %d goalTrackingID", new Object[]{Long.valueOf(this.startTime), Long.valueOf(this.doubleTapCount), Long.valueOf(this.tripleTapCount), this.goalTrackingID});
    }
}
