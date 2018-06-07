package com.misfit.ble.setting.sam;

public enum SAMEnum$HandID {
    HOUR(1),
    MINUTE(2),
    SUB_EYE(3);
    
    private final byte ax;

    private SAMEnum$HandID(int i) {
        this.ax = (byte) i;
    }

    public byte getId() {
        return this.ax;
    }
}
