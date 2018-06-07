package com.fossil;

import java.io.File;

class ebf {
    private static int f1509a = -1;

    public static boolean Ja() {
        if (f1509a == 1) {
            return true;
        }
        if (f1509a == 0) {
            return false;
        }
        String[] strArr = new String[]{"/bin", "/system/bin/", "/system/xbin/", "/system/sbin/", "/sbin/", "/vendor/bin/"};
        int i = 0;
        while (i < 6) {
            try {
                if (new File(strArr[i] + "su").exists()) {
                    f1509a = 1;
                    return true;
                }
                i++;
            } catch (Exception e) {
            }
        }
        f1509a = 0;
        return false;
    }
}
