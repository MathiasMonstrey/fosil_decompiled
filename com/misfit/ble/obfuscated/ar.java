package com.misfit.ble.obfuscated;

import android.os.Build.VERSION;
import com.misfit.ble.shine.ShineFeature;
import com.misfit.ble.shine.ShineProfile;
import com.misfit.ble.shine.firmware.CustomFirmware;
import com.misfit.ble.shine.firmware.Firmware;
import com.misfit.frameworks.common.constants.Constants;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class ar {
    public static int m14769c(String str, String str2) {
        if ((str.equalsIgnoreCase("0.0.28x.boot2_prod") || str.equalsIgnoreCase("0.0.28x.boot2_prod_ota")) && str2.equalsIgnoreCase("0.0.28x.almost_press2.2")) {
            return -1;
        }
        if (str.equalsIgnoreCase("0.0.28x.almost_press2.2") && (str2.equalsIgnoreCase("0.0.28x.boot2_prod") || str2.equalsIgnoreCase("0.0.28x.boot2_prod_ota"))) {
            return 1;
        }
        List arrayList = new ArrayList();
        StringTokenizer stringTokenizer = new StringTokenizer(str, ".");
        while (stringTokenizer.hasMoreElements()) {
            arrayList.add(stringTokenizer.nextElement().toString());
        }
        List arrayList2 = new ArrayList();
        stringTokenizer = new StringTokenizer(str2, ".");
        while (stringTokenizer.hasMoreElements()) {
            arrayList2.add(stringTokenizer.nextElement().toString());
        }
        int compareToIgnoreCase = m14774o((String) arrayList.get(0)).compareToIgnoreCase(m14774o((String) arrayList2.get(0)));
        if (compareToIgnoreCase != 0) {
            return compareToIgnoreCase;
        }
        int size = arrayList.size();
        int size2 = arrayList2.size();
        int min = Math.min(size, size2);
        for (int i = 0; i < min; i++) {
            compareToIgnoreCase = m14775p((String) arrayList.get(i)) - m14775p((String) arrayList2.get(i));
            if (compareToIgnoreCase != 0) {
                return compareToIgnoreCase;
            }
        }
        if (size > min) {
            while (min < size) {
                if (m14775p((String) arrayList.get(min)) > 0) {
                    return 1;
                }
                min++;
            }
        } else if (size2 > min) {
            for (int i2 = min; i2 < size2; i2++) {
                if (m14775p((String) arrayList2.get(i2)) > 0) {
                    return -1;
                }
            }
        }
        return 0;
    }

    private static String m14774o(String str) {
        return str.replaceAll("\\d", "");
    }

    private static int m14775p(String str) {
        try {
            return Integer.parseInt(str.replaceAll("[^\\d]", ""));
        } catch (Throwable e) {
            C4462b.m14831a(e, "");
            return -1;
        }
    }

    public static boolean m14767a(Firmware firmware, ew ewVar) {
        if (ewVar instanceof cv) {
            return true;
        }
        if (firmware == null) {
            return false;
        }
        if (firmware instanceof CustomFirmware) {
            return as.m14776a(firmware.getFirmwareVersion(), firmware.getDeviceModel(), ewVar);
        }
        return at.m14777a(firmware, ewVar);
    }

    public static short m14771e(ShineProfile shineProfile, String str) {
        if (shineProfile.isSupportedFeature(ShineFeature.ASYNCHRONOUS_DATA_STREAMING)) {
            return (short) 4;
        }
        if (3 != shineProfile.getDeviceFamily()) {
            return (short) -29184;
        }
        if (m14769c(str, Constants.DEFAULT_FIRMWARE) >= 0) {
            return (short) -28943;
        }
        return (short) -28944;
    }

    public static boolean m14768a(boolean z, int i, String str) {
        if (3 == i) {
            return z;
        }
        if ((11 == i || 12 == i || 13 == i) && z) {
            return false;
        }
        return true;
    }

    public static boolean m14766a(ew ewVar, ShineProfile shineProfile, String str) {
        if (ewVar instanceof en) {
            int deviceFamily = shineProfile.getDeviceFamily();
            if (5 == deviceFamily || 6 == deviceFamily || 8 == deviceFamily || 9 == deviceFamily || 10 == deviceFamily || 11 == deviceFamily || 12 == deviceFamily || 13 == deviceFamily) {
                return true;
            }
        }
        return false;
    }

    public static boolean m14773f(ShineProfile shineProfile, String str) {
        if ((8 == shineProfile.getDeviceFamily() || 9 == shineProfile.getDeviceFamily()) && m14769c(str, "B00.0.40r.v12") >= 0) {
            return true;
        }
        return false;
    }

    public static boolean m14770d(int i, String str) {
        if (13 == i) {
            if (m14769c(str, "HM0.0.0.16r.v1") >= 0) {
                return true;
            }
            return false;
        } else if (11 == i) {
            if (m14769c(str, "HW0.0.0.16r.v2") < 0) {
                return false;
            }
            return true;
        } else if (12 != i) {
            return false;
        } else {
            if (m14769c(str, "HL0.0.0.17r.v2") < 0) {
                return false;
            }
            return true;
        }
    }

    public static boolean m14772e(int i, String str) {
        if (11 == i) {
            if (m14769c(str, "HW0.0.0.14r.v13") >= 0) {
                return true;
            }
            return false;
        } else if (12 != i) {
            return false;
        } else {
            if (m14769c(str, "HL0.0.0.15r.v1") < 0) {
                return false;
            }
            return true;
        }
    }

    public static boolean aF() {
        return VERSION.SDK_INT >= 21;
    }
}
