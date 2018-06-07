package com.misfit.frameworks.buttonservice.enums;

import com.facebook.internal.AnalyticsEvents;
import com.misfit.frameworks.buttonservice.utils.FossilDeviceSerialPatternUtil;

public enum MFDeviceFamily {
    UNKNOWN(AnalyticsEvents.PARAMETER_DIALOG_OUTCOME_VALUE_UNKNOWN, 0),
    INTEL("Intel", 1),
    DEVICE_FAMILY_Q_MOTION("Q_MOTION", 2),
    DEVICE_FAMILY_RMM("RMM", 3),
    DEVICE_FAMILY_SAM("SAM", 4),
    DEVICE_FAMILY_SAM_SLIM("SAM_SLIM", 5),
    DEVICE_FAMILY_SAM_MINI("MINI", 6),
    DEVICE_FAMILY_SE0("SE0", 7);
    
    private String serverName;
    private int value;

    private MFDeviceFamily(String str, int i) {
        this.value = i;
        this.serverName = str;
    }

    public int getValue() {
        return this.value;
    }

    public String getServerName() {
        return this.serverName;
    }

    public static MFDeviceFamily fromServerName(String str) {
        for (MFDeviceFamily mFDeviceFamily : values()) {
            if (mFDeviceFamily.getServerName().equalsIgnoreCase(str)) {
                return mFDeviceFamily;
            }
        }
        return UNKNOWN;
    }

    public static MFDeviceFamily fromInt(int i) {
        for (MFDeviceFamily mFDeviceFamily : values()) {
            if (mFDeviceFamily.getValue() == i) {
                return mFDeviceFamily;
            }
        }
        return UNKNOWN;
    }

    public static MFDeviceFamily getDeviceFamily(String str) {
        switch (FossilDeviceSerialPatternUtil.getDeviceBySerial(str)) {
            case RMM:
                return DEVICE_FAMILY_RMM;
            case SAM:
            case FAKE_SAM:
                return DEVICE_FAMILY_SAM;
            case SE0:
                return DEVICE_FAMILY_SE0;
            case SAM_SLIM:
                return DEVICE_FAMILY_SAM_SLIM;
            case SAM_MINI:
                return DEVICE_FAMILY_SAM_MINI;
            case Q_MOTION:
                return DEVICE_FAMILY_Q_MOTION;
            default:
                return UNKNOWN;
        }
    }

    public static boolean isHybridSmartWatchFamily(MFDeviceFamily mFDeviceFamily) {
        return mFDeviceFamily == DEVICE_FAMILY_SAM || mFDeviceFamily == DEVICE_FAMILY_SAM_SLIM || mFDeviceFamily == DEVICE_FAMILY_SAM_MINI || mFDeviceFamily == DEVICE_FAMILY_SE0;
    }

    public static boolean isSlimOrMiniFamily(MFDeviceFamily mFDeviceFamily) {
        return mFDeviceFamily == DEVICE_FAMILY_SAM_SLIM || mFDeviceFamily == DEVICE_FAMILY_SAM_MINI;
    }
}
