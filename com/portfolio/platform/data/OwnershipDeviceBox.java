package com.portfolio.platform.data;

import java.util.HashSet;

public class OwnershipDeviceBox {
    private static OwnershipDeviceBox INSTANCE = null;
    private HashSet<String> anotherOwnerDevices = new HashSet();
    private HashSet<String> ownerDevices = new HashSet();

    public enum OwnerShip {
        None,
        MyOwn,
        OtherOwn
    }

    public static OwnershipDeviceBox getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new OwnershipDeviceBox();
        }
        return INSTANCE;
    }

    private OwnershipDeviceBox() {
    }

    public void pushDeviceSerial(OwnerShip ownerShip, String str) {
        switch (ownerShip) {
            case OtherOwn:
                this.anotherOwnerDevices.add(str);
                return;
            default:
                this.ownerDevices.add(str);
                return;
        }
    }

    public void removeDeviceSerial(String str) {
        this.anotherOwnerDevices.remove(str);
        this.ownerDevices.remove(str);
    }

    public boolean isOwnBy(OwnerShip ownerShip, String str) {
        switch (ownerShip) {
            case OtherOwn:
                return this.anotherOwnerDevices.contains(str);
            default:
                return this.ownerDevices.contains(str);
        }
    }

    public void reset() {
        this.anotherOwnerDevices.clear();
        this.ownerDevices.clear();
    }
}
