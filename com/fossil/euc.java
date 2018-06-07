package com.fossil;

import java.util.ArrayList;
import java.util.List;

public class euc {
    public static String[] split(String str, String str2) {
        return m11208a(str, str2, -1, false);
    }

    private static String[] m11208a(String str, String str2, int i, boolean z) {
        if (str == null) {
            return null;
        }
        int length = str.length();
        if (length == 0) {
            return eub.bqJ;
        }
        int i2;
        int i3;
        int i4;
        List arrayList = new ArrayList();
        int i5;
        int i6;
        int i7;
        int i8;
        if (str2 == null) {
            i5 = 0;
            i2 = 0;
            i6 = 0;
            i3 = 0;
            i7 = 1;
            while (i3 < length) {
                if (Character.isWhitespace(str.charAt(i3))) {
                    if (i2 != 0 || z) {
                        i2 = i7 + 1;
                        if (i7 == i) {
                            i3 = 0;
                            i5 = length;
                        } else {
                            i5 = i3;
                            i3 = 1;
                        }
                        arrayList.add(str.substring(i6, i5));
                        i7 = i2;
                        i2 = i5;
                        i5 = 0;
                    } else {
                        i8 = i5;
                        i5 = i2;
                        i2 = i3;
                        i3 = i8;
                    }
                    i6 = i2 + 1;
                    i2 = i5;
                    i5 = i3;
                    i3 = i6;
                } else {
                    i3++;
                    i5 = 0;
                    i2 = 1;
                }
            }
            i4 = i3;
            i3 = i6;
        } else if (str2.length() == 1) {
            char charAt = str2.charAt(0);
            i5 = 0;
            i2 = 0;
            i6 = 0;
            i3 = 0;
            i7 = 1;
            while (i3 < length) {
                if (str.charAt(i3) == charAt) {
                    if (i2 != 0 || z) {
                        i2 = i7 + 1;
                        if (i7 == i) {
                            i3 = 0;
                            i5 = length;
                        } else {
                            i5 = i3;
                            i3 = 1;
                        }
                        arrayList.add(str.substring(i6, i5));
                        i7 = i2;
                        i2 = i5;
                        i5 = 0;
                    } else {
                        i8 = i5;
                        i5 = i2;
                        i2 = i3;
                        i3 = i8;
                    }
                    i6 = i2 + 1;
                    i2 = i5;
                    i5 = i3;
                    i3 = i6;
                } else {
                    i3++;
                    i5 = 0;
                    i2 = 1;
                }
            }
            i4 = i3;
            i3 = i6;
        } else {
            i5 = 0;
            i2 = 0;
            i6 = 0;
            i3 = 0;
            i7 = 1;
            while (i3 < length) {
                if (str2.indexOf(str.charAt(i3)) >= 0) {
                    if (i2 != 0 || z) {
                        i2 = i7 + 1;
                        if (i7 == i) {
                            i3 = 0;
                            i5 = length;
                        } else {
                            i5 = i3;
                            i3 = 1;
                        }
                        arrayList.add(str.substring(i6, i5));
                        i7 = i2;
                        i2 = i5;
                        i5 = 0;
                    } else {
                        i8 = i5;
                        i5 = i2;
                        i2 = i3;
                        i3 = i8;
                    }
                    i6 = i2 + 1;
                    i2 = i5;
                    i5 = i3;
                    i3 = i6;
                } else {
                    i3++;
                    i5 = 0;
                    i2 = 1;
                }
            }
            i4 = i3;
            i3 = i6;
        }
        if (i2 != 0 || (z && r3 != 0)) {
            arrayList.add(str.substring(i3, i4));
        }
        return (String[]) arrayList.toArray(new String[arrayList.size()]);
    }
}
