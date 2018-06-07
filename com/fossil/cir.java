package com.fossil;

import com.fasterxml.jackson.core.util.MinimalPrettyPrinter;
import org.joda.time.DateTimeConstants;

public class cir {
    private static final char[] cen = new char[]{'K', 'M', 'B', 'T'};

    public static String m6515b(double d, int i) {
        double d2 = ((double) (((long) d) / 100)) / 10.0d;
        Object obj = (d2 * 10.0d) % 10.0d == 0.0d ? 1 : null;
        if (d2 >= 1000.0d) {
            return m6515b(d2, i + 1);
        }
        StringBuilder stringBuilder = new StringBuilder();
        obj = (d2 > 99.9d || obj != null || (obj == null && d2 > 9.99d)) ? Integer.valueOf((((int) d2) * 10) / 10) : d2 + "";
        return stringBuilder.append(obj).append("").append(cen[i]).toString();
    }

    public static String jv(int i) {
        StringBuilder stringBuilder = new StringBuilder();
        int i2 = (i % DateTimeConstants.SECONDS_PER_HOUR) / 60;
        int i3 = i / DateTimeConstants.SECONDS_PER_HOUR;
        if (i3 > 0) {
            stringBuilder.append(i3);
            stringBuilder.append("H");
        }
        if (i2 > 0) {
            stringBuilder.append(MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR);
            stringBuilder.append(i2);
            stringBuilder.append("M");
        }
        return stringBuilder.toString();
    }
}
