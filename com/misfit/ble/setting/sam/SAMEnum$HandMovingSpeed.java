package com.misfit.ble.setting.sam;

public enum SAMEnum$HandMovingSpeed {
    FULL(1),
    HALF(2),
    QUARTER(3),
    EIGHTH(4),
    SIXTEENTH(5);
    
    private final byte ax;

    private SAMEnum$HandMovingSpeed(int i) {
        this.ax = (byte) i;
    }

    public byte getId() {
        return this.ax;
    }
}
