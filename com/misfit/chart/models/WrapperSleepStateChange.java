package com.misfit.chart.models;

public class WrapperSleepStateChange {
    private int index;
    private int state;

    public WrapperSleepStateChange(int i, int i2) {
        this.state = i;
        this.index = i2;
    }

    public int getState() {
        return this.state;
    }

    public int getIndex() {
        return this.index;
    }
}
