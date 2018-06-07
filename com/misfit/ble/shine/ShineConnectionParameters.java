package com.misfit.ble.shine;

public class ShineConnectionParameters {
    private double eH;
    private int eI;
    private int eJ;

    public ShineConnectionParameters(double d, int i, int i2) {
        this.eH = Math.max(d, 7.5d);
        this.eI = i;
        this.eJ = i2;
    }

    public double getConnectionInterval() {
        return this.eH;
    }

    public int getConnectionLatency() {
        return this.eI;
    }

    public int getSupervisionTimeout() {
        return this.eJ;
    }
}
