package com.fossil;

import java.util.TimeZone;

public final class dye {
    private static final TimeZone GMT = TimeZone.getTimeZone("GMT");
    public static final long[] dAK = new long[]{300, 200, 300, 200};
    private static final long[] dAL = new long[]{300, 50, 300, 50};
    private static final char[] dAM = new char[]{'<', '>', '\"', '\'', '&', '\r', '\n', ' ', '\t'};
    private static final String[] dAN = new String[]{"&lt;", "&gt;", "&quot;", "&apos;", "&amp;", "&#x0D;", "&#x0A;", "&#x20;", "&#x09;"};

    public static boolean lc(String str) {
        return str == null || str.length() <= 0;
    }
}
