package com.fossil;

import com.facebook.internal.Utility;
import com.fasterxml.jackson.core.util.MinimalPrettyPrinter;
import java.util.ArrayList;
import java.util.List;

public class euh {
    public static boolean isEmpty(CharSequence charSequence) {
        return charSequence == null || charSequence.length() == 0;
    }

    public static boolean m11223L(CharSequence charSequence) {
        if (charSequence != null) {
            int length = charSequence.length();
            if (length != 0) {
                for (int i = 0; i < length; i++) {
                    if (!Character.isWhitespace(charSequence.charAt(i))) {
                        return false;
                    }
                }
                return true;
            }
        }
        return true;
    }

    public static String m11222E(String str, int i, int i2) {
        int i3 = 0;
        if (str == null) {
            return null;
        }
        int length;
        if (i2 < 0) {
            length = str.length() + i2;
        } else {
            length = i2;
        }
        if (i < 0) {
            i += str.length();
        }
        if (length > str.length()) {
            length = str.length();
        }
        if (i > length) {
            return "";
        }
        if (i < 0) {
            i = 0;
        }
        if (length >= 0) {
            i3 = length;
        }
        return str.substring(i, i3);
    }

    public static String[] split(String str, String str2) {
        return m11225a(str, str2, -1, false);
    }

    private static String[] m11225a(String str, String str2, int i, boolean z) {
        if (str == null) {
            return null;
        }
        int length = str.length();
        if (length == 0) {
            return eug.bqJ;
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

    public static String m11224R(String str, int i) {
        int i2 = 0;
        if (str == null) {
            return null;
        }
        if (i <= 0) {
            return "";
        }
        int length = str.length();
        if (i == 1 || length == 0) {
            return str;
        }
        if (length == 1 && i <= Utility.DEFAULT_STREAM_BUFFER_SIZE) {
            return m11226c(str.charAt(0), i);
        }
        int i3 = length * i;
        switch (length) {
            case 1:
                return m11226c(str.charAt(0), i);
            case 2:
                char charAt = str.charAt(0);
                char charAt2 = str.charAt(1);
                char[] cArr = new char[i3];
                for (i2 = (i * 2) - 2; i2 >= 0; i2 = (i2 - 1) - 1) {
                    cArr[i2] = charAt;
                    cArr[i2 + 1] = charAt2;
                }
                return new String(cArr);
            default:
                StringBuilder stringBuilder = new StringBuilder(i3);
                while (i2 < i) {
                    stringBuilder.append(str);
                    i2++;
                }
                return stringBuilder.toString();
        }
    }

    public static String m11226c(char c, int i) {
        if (i <= 0) {
            return "";
        }
        char[] cArr = new char[i];
        for (int i2 = i - 1; i2 >= 0; i2--) {
            cArr[i2] = c;
        }
        return new String(cArr);
    }

    public static String m11227c(String str, int i, char c) {
        if (str == null) {
            return null;
        }
        int length = i - str.length();
        if (length <= 0) {
            return str;
        }
        if (length > Utility.DEFAULT_STREAM_BUFFER_SIZE) {
            return m11228d(str, i, String.valueOf(c));
        }
        return m11226c(c, length).concat(str);
    }

    public static String m11228d(String str, int i, String str2) {
        int i2 = 0;
        if (str == null) {
            return null;
        }
        if (isEmpty(str2)) {
            str2 = MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR;
        }
        int length = str2.length();
        int length2 = i - str.length();
        if (length2 <= 0) {
            return str;
        }
        if (length == 1 && length2 <= Utility.DEFAULT_STREAM_BUFFER_SIZE) {
            return m11227c(str, i, str2.charAt(0));
        }
        if (length2 == length) {
            return str2.concat(str);
        }
        if (length2 < length) {
            return str2.substring(0, length2).concat(str);
        }
        char[] cArr = new char[length2];
        char[] toCharArray = str2.toCharArray();
        while (i2 < length2) {
            cArr[i2] = toCharArray[i2 % length];
            i2++;
        }
        return new String(cArr).concat(str);
    }
}
