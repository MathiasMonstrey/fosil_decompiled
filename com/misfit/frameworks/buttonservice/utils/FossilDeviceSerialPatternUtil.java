package com.misfit.frameworks.buttonservice.utils;

import android.text.TextUtils;

public class FossilDeviceSerialPatternUtil {

    public enum BRAND {
        CHAPS('C'),
        EA('E'),
        DIESEL('D'),
        FOSSIL('F'),
        KARL('L'),
        MICHAEL_KORS('M'),
        KATE_SPADE('K'),
        SKAGEN('S'),
        ARMANI_EXCHANGE('X'),
        TORY_BURCH('T'),
        RELIC('R'),
        MARC_JACOBS('J'),
        DKNY('Y'),
        MICHELE('H'),
        UNKNOWN('U');
        
        private char prefix;

        private BRAND(char c) {
            this.prefix = c;
        }

        public static BRAND fromPrefix(char c) {
            for (BRAND brand : values()) {
                if (brand.getPrefix() == c) {
                    return brand;
                }
            }
            return UNKNOWN;
        }

        public char getPrefix() {
            return this.prefix;
        }
    }

    public static BRAND getBrandBySerial(String str) {
        if (TextUtils.isEmpty(str)) {
            return BRAND.UNKNOWN;
        }
        char charAt;
        if (isQMotion(str)) {
            charAt = str.charAt(1);
        } else {
            charAt = str.charAt(2);
        }
        return BRAND.fromPrefix(charAt);
    }

    public static DEVICE getDeviceBySerial(String str) {
        if (TextUtils.isEmpty(str)) {
            return DEVICE.UNKNOWN;
        }
        return DEVICE.fromPrefix(str.toUpperCase().charAt(0));
    }

    public static String getStyleCode(String str) {
        if (TextUtils.isEmpty(str) || str.length() < 5) {
            return "";
        }
        if (isQMotion(str)) {
            return str.substring(3, 5);
        }
        return str.substring(3, 6);
    }

    public static boolean isRmmDevice(String str) {
        if (!TextUtils.isEmpty(str) && getDeviceBySerial(str) == DEVICE.RMM) {
            return true;
        }
        return false;
    }

    public static boolean isTrackerDevice(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        DEVICE deviceBySerial = getDeviceBySerial(str);
        if (deviceBySerial == DEVICE.RMM || deviceBySerial == DEVICE.Q_MOTION) {
            return true;
        }
        return false;
    }

    public static boolean isHybridSmartWatchDevice(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        DEVICE deviceBySerial = getDeviceBySerial(str);
        if (deviceBySerial == DEVICE.SAM || deviceBySerial == DEVICE.FAKE_SAM || deviceBySerial == DEVICE.SAM_SLIM || deviceBySerial == DEVICE.SAM_MINI || deviceBySerial == DEVICE.SE0) {
            return true;
        }
        return false;
    }

    public static boolean isSamSlimDevice(String str) {
        if (!TextUtils.isEmpty(str) && getDeviceBySerial(str) == DEVICE.SAM_SLIM) {
            return true;
        }
        return false;
    }

    public static boolean isSamMiniDevice(String str) {
        return !TextUtils.isEmpty(str) && getDeviceBySerial(str) == DEVICE.SAM_MINI;
    }

    public static boolean isSamSlimOrMiniDevice(String str) {
        DEVICE deviceBySerial = getDeviceBySerial(str);
        return deviceBySerial == DEVICE.SAM_SLIM || deviceBySerial == DEVICE.SAM_MINI;
    }

    public static boolean isVibeSupportDevice(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        DEVICE deviceBySerial = getDeviceBySerial(str);
        if (deviceBySerial == DEVICE.SAM || deviceBySerial == DEVICE.SE0 || deviceBySerial == DEVICE.FAKE_SAM || deviceBySerial == DEVICE.Q_MOTION || deviceBySerial == DEVICE.SAM_MINI) {
            return true;
        }
        return false;
    }

    public static boolean isQMotion(String str) {
        if (!TextUtils.isEmpty(str) && getDeviceBySerial(str) == DEVICE.Q_MOTION) {
            return true;
        }
        return false;
    }

    public static boolean isGen1Device(String str) {
        if (TextUtils.isEmpty(str) || str.length() <= 10) {
            return false;
        }
        return true;
    }
}
