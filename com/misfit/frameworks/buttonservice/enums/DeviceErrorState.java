package com.misfit.frameworks.buttonservice.enums;

public enum DeviceErrorState {
    SUCCESSFULLY(0),
    NO_DEVICE_FOUND(1),
    FAIL_TO_CONNECT(2),
    FAIL_TO_PREPARE(3),
    FAIL_TO_SET_CONN_PARAMS(10),
    FAIL_TO_SYNC(11),
    FAIL_TO_SET_CONFIG_BACK(12),
    FIRMWARE_INCOMPATIBLE(20),
    FAIL_TO_ACTIVATE(4),
    FAIL_TO_SETUP_CONFIG(5),
    FAIL_TO_SET_GOAL_TRACKING(6),
    NETWORK_ERROR(50),
    UNKNOWN_ERROR(999);
    
    int value;

    private DeviceErrorState(int i) {
        this.value = i;
    }

    public int getValue() {
        return this.value;
    }
}
