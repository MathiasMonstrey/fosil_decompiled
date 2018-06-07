package com.misfit.frameworks.buttonservice.utils;

import android.text.TextUtils;
import com.fossil.euh;
import com.misfit.frameworks.buttonservice.enums.MFDeviceFamily;
import com.misfit.frameworks.common.constants.Constants;

public class DeviceIdentityUtils {
    public static final String FAKE_SAM_SERIAL_NUMBER_PREFIX = "SAM-FSL";
    public static final String FLASH_SERIAL_NUMBER_PREFIX = "F";
    public static final String[] Q_MOTION_PREFIX = new String[]{"BF", "BM", "BK", "BS"};
    public static final String RAY_SERIAL_NUMBER_PREFIX = "B0";
    public static final String RMM_SERIAL_NUMBER_PREFIX = "C0";
    public static final String SAM_MINI_SERIAL_NUMBER_PREFIX = "M0";
    public static final String SAM_SE0_SERIAL_NUMBER_PREFIX = "Z0";
    public static final String SAM_SERIAL_NUMBER_PREFIX = "W0";
    public static final String SAM_SLIM_SERIAL_NUMBER_PREFIX = "L0";
    public static final String SHINE2_SERIAL_NUMBER_PREFIX = "S2";
    public static final String SHINE_SERIAL_NUMBER_PREFIX = "S";
    public static final String SPEEDO_SERIAL_NUMBER_PREFIX = "SV0EZ";
    public static final String SWAROVSKI_SERIAL_NUMBER_PREFIX = "SC";

    public enum QMotionType {
        BLACK("DZ"),
        STAINLESS_SILVER("SZ"),
        GOLD("GZ"),
        ROSE_GOLD("R1"),
        BLUE("BZ"),
        COPPER("PZ");
        
        private String value;

        private QMotionType(String str) {
            this.value = str;
        }

        public String getValue() {
            return this.value;
        }

        public static QMotionType fromColorCode(String str) {
            for (QMotionType qMotionType : values()) {
                if (qMotionType.getValue().equalsIgnoreCase(str)) {
                    return qMotionType;
                }
            }
            return ROSE_GOLD;
        }
    }

    public static boolean isShine(String str) {
        return (str == null || !str.startsWith(SHINE_SERIAL_NUMBER_PREFIX) || str.startsWith("S2")) ? false : true;
    }

    public static boolean isFlash(String str) {
        return str != null && str.startsWith(FLASH_SERIAL_NUMBER_PREFIX);
    }

    public static boolean isFlashButton(String str) {
        return str != null && str.equals(Constants.BUTTON_MODEL);
    }

    public static boolean isSwarovskiShine(String str) {
        return str != null && str.startsWith(SWAROVSKI_SERIAL_NUMBER_PREFIX);
    }

    public static boolean isSpeedoShine(String str) {
        return str != null && str.startsWith(SPEEDO_SERIAL_NUMBER_PREFIX);
    }

    public static boolean isShine2(String str) {
        return str != null && str.startsWith("S2");
    }

    public static boolean isRay(String str) {
        return str != null && str.startsWith(RAY_SERIAL_NUMBER_PREFIX);
    }

    public static boolean isMisfitDevice(String str) {
        return FossilDeviceSerialPatternUtil.isRmmDevice(str) || isFlash(str) || isFlashButton(str) || isRay(str) || isShine(str) || isShine2(str) || isSpeedoShine(str) || isSwarovskiShine(str) || isQMotion(str) || FossilDeviceSerialPatternUtil.isHybridSmartWatchDevice(str);
    }

    public static boolean isQMotion(String str) {
        if (TextUtils.isEmpty(str) || str.length() <= 2) {
            return false;
        }
        String substring = str.substring(0, 2);
        for (String equalsIgnoreCase : Q_MOTION_PREFIX) {
            if (substring.equalsIgnoreCase(equalsIgnoreCase)) {
                return true;
            }
        }
        return false;
    }

    public static String getNameBySerial(String str) {
        switch (FossilDeviceSerialPatternUtil.getDeviceBySerial(str)) {
            case RMM:
                return "RMM";
            case Q_MOTION:
                return "Q Motion";
            case FAKE_SAM:
            case SAM:
                return "Hybrid Smartwatch";
            case SAM_SLIM:
                return "SAM Slim";
            case SAM_MINI:
                return "SAM Mini";
            default:
                return "UNKNOWN";
        }
    }

    public static MFDeviceFamily getDeviceFamily(String str) {
        switch (FossilDeviceSerialPatternUtil.getDeviceBySerial(str)) {
            case RMM:
                return MFDeviceFamily.DEVICE_FAMILY_RMM;
            case Q_MOTION:
                return MFDeviceFamily.DEVICE_FAMILY_Q_MOTION;
            case FAKE_SAM:
            case SAM:
                return MFDeviceFamily.DEVICE_FAMILY_SAM;
            case SAM_SLIM:
                return MFDeviceFamily.DEVICE_FAMILY_SAM_SLIM;
            case SAM_MINI:
                return MFDeviceFamily.DEVICE_FAMILY_SAM_MINI;
            case SE0:
                return MFDeviceFamily.DEVICE_FAMILY_SE0;
            default:
                return MFDeviceFamily.UNKNOWN;
        }
    }

    public static QMotionType getQMotionTypeBySerial(String str) {
        if (TextUtils.isEmpty(str) || str.length() < 4) {
            return QMotionType.ROSE_GOLD;
        }
        return QMotionType.fromColorCode(euh.E(str, 3, 5));
    }
}
