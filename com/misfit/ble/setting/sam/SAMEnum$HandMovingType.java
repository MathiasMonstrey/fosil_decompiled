package com.misfit.ble.setting.sam;

public enum SAMEnum$HandMovingType {
    DISTANCE(1),
    POSITION(2);
    
    private final byte ax;

    private SAMEnum$HandMovingType(int i) {
        this.ax = (byte) i;
    }

    public byte getId() {
        return this.ax;
    }
}
