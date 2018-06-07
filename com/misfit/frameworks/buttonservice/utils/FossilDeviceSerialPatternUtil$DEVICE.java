package com.misfit.frameworks.buttonservice.utils;

public enum FossilDeviceSerialPatternUtil$DEVICE {
    RMM('C'),
    SAM('W'),
    Q_MOTION('B'),
    UNKNOWN('U'),
    FAKE_SAM('S'),
    SAM_SLIM('L'),
    SAM_MINI('M'),
    SE0('Z');
    
    private char prefix;

    private FossilDeviceSerialPatternUtil$DEVICE(char c) {
        this.prefix = c;
    }

    public static FossilDeviceSerialPatternUtil$DEVICE fromPrefix(char c) {
        for (FossilDeviceSerialPatternUtil$DEVICE fossilDeviceSerialPatternUtil$DEVICE : values()) {
            if (fossilDeviceSerialPatternUtil$DEVICE.getPrefix() == c) {
                return fossilDeviceSerialPatternUtil$DEVICE;
            }
        }
        return UNKNOWN;
    }

    public char getPrefix() {
        return this.prefix;
    }
}
