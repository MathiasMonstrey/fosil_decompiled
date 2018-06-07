package com.fossil;

import java.io.File;

public class ety {
    public static final String dTH = Character.toString('.');
    private static final char dTI = File.separatorChar;
    private static final char dTJ;

    static {
        if (aHJ()) {
            dTJ = '/';
        } else {
            dTJ = '\\';
        }
    }

    static boolean aHJ() {
        return dTI == '\\';
    }

    public static int mK(String str) {
        if (str == null) {
            return -1;
        }
        return Math.max(str.lastIndexOf(47), str.lastIndexOf(92));
    }

    public static String getName(String str) {
        if (str == null) {
            return null;
        }
        return str.substring(mK(str) + 1);
    }
}
