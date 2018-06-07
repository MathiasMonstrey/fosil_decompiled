package com.fossil;

import com.facebook.internal.FacebookRequestErrorClassification;

public class etc extends etb {
    public static final boolean m11134c(String str, String str2, boolean z) {
        if (str == null) {
            return str2 == null;
        } else {
            if (z) {
                return str.equalsIgnoreCase(str2);
            }
            return str.equals(str2);
        }
    }

    public static /* synthetic */ boolean m11133a(String str, String str2, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        return m11135d(str, str2, z);
    }

    public static final boolean m11135d(String str, String str2, boolean z) {
        esl.m11128j(str, "$receiver");
        esl.m11128j(str2, "prefix");
        if (!z) {
            return str.startsWith(str2);
        }
        return m11132a(str, 0, str2, 0, str2.length(), z);
    }

    public static final boolean m11132a(String str, int i, String str2, int i2, int i3, boolean z) {
        esl.m11128j(str, "$receiver");
        esl.m11128j(str2, FacebookRequestErrorClassification.KEY_OTHER);
        if (z) {
            return str.regionMatches(z, i, str2, i2, i3);
        }
        return str.regionMatches(i, str2, i2, i3);
    }
}
