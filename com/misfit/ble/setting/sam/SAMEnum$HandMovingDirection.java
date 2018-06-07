package com.misfit.ble.setting.sam;

public enum SAMEnum$HandMovingDirection {
    CLOCKWISE(1),
    COUNTER_CLOCKWISE(2),
    SHORTEST_PATH(3);
    
    private final byte ax;

    private SAMEnum$HandMovingDirection(int i) {
        this.ax = (byte) i;
    }

    public byte getId() {
        return this.ax;
    }
}
