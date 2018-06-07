package com.misfit.frameworks.common.enums;

public enum DeviceOwnership {
    DeviceOwnershipUnknown(-1),
    DeviceOwnershipDeactivated(-2),
    DeviceOwnershipNeverLinked(1),
    DeviceOwnershipUsedToLinkToCurrentAcc(2),
    DeviceOwnershipUsedToLinkToAnotherAcc(3),
    DeviceOwnershipAlreadyLinkedToCurrentAcc(4),
    DeviceOwnershipAlreadyLinkedToAnotherAcc(0);
    
    private int value;

    public int getValue() {
        return this.value;
    }

    public static DeviceOwnership fromInt(int i) {
        for (DeviceOwnership deviceOwnership : values()) {
            if (deviceOwnership.getValue() == i) {
                return deviceOwnership;
            }
        }
        return null;
    }

    private DeviceOwnership(int i) {
        this.value = i;
    }
}
