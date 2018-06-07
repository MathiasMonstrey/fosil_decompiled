package com.fossil;

public class aey {
    protected static final aey aLB = new aey();
    protected final aey aLC;
    protected final String aLD;
    protected final String aLE;
    protected final int aLF;

    protected aey() {
        this.aLC = null;
        this.aLE = "";
        this.aLF = -1;
        this.aLD = "";
    }

    protected aey(String str, String str2, aey com_fossil_aey) {
        this.aLD = str;
        this.aLC = com_fossil_aey;
        this.aLE = str2;
        this.aLF = bc(str2);
    }

    public static aey ba(String str) throws IllegalArgumentException {
        if (str == null || str.length() == 0) {
            return aLB;
        }
        if (str.charAt(0) == '/') {
            return bd(str);
        }
        throw new IllegalArgumentException("Invalid input: JSON Pointer expression must start with '/': \"" + str + "\"");
    }

    public boolean matches() {
        return this.aLC == null;
    }

    public aey bb(String str) {
        if (this.aLC == null || !this.aLE.equals(str)) {
            return null;
        }
        return this.aLC;
    }

    public aey fp(int i) {
        if (i != this.aLF || i < 0) {
            return null;
        }
        return this.aLC;
    }

    public String toString() {
        return this.aLD;
    }

    public int hashCode() {
        return this.aLD.hashCode();
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || !(obj instanceof aey)) {
            return false;
        }
        return this.aLD.equals(((aey) obj).aLD);
    }

    private static final int bc(String str) {
        int i = 0;
        int length = str.length();
        if (length == 0 || length > 10) {
            return -1;
        }
        char charAt = str.charAt(0);
        if (charAt <= '0') {
            if (!(length == 1 && charAt == '0')) {
                i = -1;
            }
            return i;
        } else if (charAt > '9') {
            return -1;
        } else {
            for (i = 1; i < length; i++) {
                char charAt2 = str.charAt(i);
                if (charAt2 > '9' || charAt2 < '0') {
                    return -1;
                }
            }
            if (length != 10 || afr.parseLong(str) <= 2147483647L) {
                return afr.parseInt(str);
            }
            return -1;
        }
    }

    protected static aey bd(String str) {
        int length = str.length();
        int i = 1;
        while (i < length) {
            char charAt = str.charAt(i);
            if (charAt == '/') {
                return new aey(str, str.substring(1, i), bd(str.substring(i)));
            }
            int i2 = i + 1;
            if (charAt == '~' && i2 < length) {
                return m3099h(str, i2);
            }
            i = i2;
        }
        return new aey(str, str.substring(1), aLB);
    }

    protected static aey m3099h(String str, int i) {
        int length = str.length();
        StringBuilder stringBuilder = new StringBuilder(Math.max(16, length));
        if (i > 2) {
            stringBuilder.append(str, 1, i - 1);
        }
        int i2 = i + 1;
        m3098a(stringBuilder, str.charAt(i));
        int i3 = i2;
        while (i3 < length) {
            char charAt = str.charAt(i3);
            if (charAt == '/') {
                return new aey(str, stringBuilder.toString(), bd(str.substring(i3)));
            }
            i3++;
            if (charAt != '~' || i3 >= length) {
                stringBuilder.append(charAt);
            } else {
                i2 = i3 + 1;
                m3098a(stringBuilder, str.charAt(i3));
                i3 = i2;
            }
        }
        return new aey(str, stringBuilder.toString(), aLB);
    }

    private static void m3098a(StringBuilder stringBuilder, char c) {
        if (c == '0') {
            c = '~';
        } else if (c == '1') {
            c = '/';
        } else {
            stringBuilder.append('~');
        }
        stringBuilder.append(c);
    }
}
