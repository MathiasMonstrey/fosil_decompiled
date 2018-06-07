package com.misfit.ble.setting.sam;

public class HandPositions {
    private int bj;
    private int bk;
    private int bl;

    public HandPositions(int i, int i2, int i3) {
        this.bj = i;
        this.bk = i2;
        this.bl = i3;
    }

    public int getHourDegrees() {
        return this.bj;
    }

    public int getMinuteDegrees() {
        return this.bk;
    }

    public int getSubEyeDegrees() {
        return this.bl;
    }

    public String toString() {
        return "hourDegrees: " + this.bj + " - minDegrees: " + this.bk + " - subEyeDegrees: " + this.bl;
    }
}
