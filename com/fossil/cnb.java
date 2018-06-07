package com.fossil;

import java.text.DecimalFormat;

public class cnb {
    public static String m7184e(float f, int i) {
        String str = "#";
        if (i > 0) {
            str = str + ".";
        }
        StringBuilder stringBuilder = new StringBuilder(str);
        for (int i2 = 0; i2 < i; i2++) {
            stringBuilder.append("#");
        }
        return new DecimalFormat(stringBuilder.toString()).format((double) f);
    }
}
