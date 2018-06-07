package com.fossil;

import android.os.Build.VERSION;

public final class axt {
    public static boolean LF() {
        return VERSION.SDK_INT >= 16;
    }

    public static boolean LG() {
        return VERSION.SDK_INT >= 18;
    }

    public static boolean LH() {
        return VERSION.SDK_INT >= 19;
    }

    public static boolean LI() {
        return VERSION.SDK_INT >= 20;
    }

    public static boolean LJ() {
        return VERSION.SDK_INT >= 21;
    }

    public static boolean LK() {
        return VERSION.SDK_INT > 25 || "O".equals(VERSION.CODENAME) || VERSION.CODENAME.startsWith("OMR");
    }

    public static boolean ji() {
        return VERSION.SDK_INT >= 24;
    }
}
