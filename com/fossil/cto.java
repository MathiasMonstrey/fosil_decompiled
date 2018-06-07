package com.fossil;

import com.portfolio.platform.enums.PermissionCodes;

public final /* synthetic */ class cto {
    public static final /* synthetic */ int[] cEQ = new int[PermissionCodes.values().length];

    static {
        cEQ[PermissionCodes.BLUETOOTH_OFF.ordinal()] = 1;
        cEQ[PermissionCodes.LOCATION_PERMISSION_OFF.ordinal()] = 2;
        cEQ[PermissionCodes.LOCATION_PERMISSION_FEATURE_OFF.ordinal()] = 3;
        cEQ[PermissionCodes.LOCATION_SERVICE_OFF.ordinal()] = 4;
        cEQ[PermissionCodes.LOCATION_SERVICE_FEATURE_OFF.ordinal()] = 5;
    }
}
