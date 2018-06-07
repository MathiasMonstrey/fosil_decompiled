package com.fossil;

import com.fasterxml.jackson.core.Version;
import java.util.regex.Pattern;

public class ags {
    private static final Pattern aQc = Pattern.compile("[-_./;:]");

    public static Version m3324c(String str, String str2, String str3) {
        String str4 = null;
        int i = 0;
        if (str != null) {
            CharSequence trim = str.trim();
            if (trim.length() > 0) {
                String[] split = aQc.split(trim);
                int bC = bC(split[0]);
                int bC2 = split.length > 1 ? bC(split[1]) : 0;
                if (split.length > 2) {
                    i = bC(split[2]);
                }
                if (split.length > 3) {
                    str4 = split[3];
                }
                return new Version(bC, bC2, i, str4, str2, str3);
            }
        }
        return null;
    }

    protected static int bC(String str) {
        int i = 0;
        int length = str.length();
        int i2 = 0;
        while (i < length) {
            char charAt = str.charAt(i);
            if (charAt > '9' || charAt < '0') {
                break;
            }
            i2 = (i2 * 10) + (charAt - 48);
            i++;
        }
        return i2;
    }

    public static final void Dk() {
        throw new RuntimeException("Internal error: this code path should never get executed");
    }
}
