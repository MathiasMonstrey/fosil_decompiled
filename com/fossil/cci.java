package com.fossil;

public final class cci {
    public static String toLowerCase(String str) {
        int length = str.length();
        int i = 0;
        while (i < length) {
            if (isUpperCase(str.charAt(i))) {
                char[] toCharArray = str.toCharArray();
                while (i < length) {
                    char c = toCharArray[i];
                    if (isUpperCase(c)) {
                        toCharArray[i] = (char) (c ^ 32);
                    }
                    i++;
                }
                return String.valueOf(toCharArray);
            }
            i++;
        }
        return str;
    }

    public static boolean isUpperCase(char c) {
        return c >= 'A' && c <= 'Z';
    }
}
